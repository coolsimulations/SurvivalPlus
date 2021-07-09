package net.coolsimulations.SurvivalPlus.api.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;

public interface SPPlayerJoinEvent {
	Event<SPPlayerJoinEvent> EVENT = EventFactory.createArrayBacked(SPPlayerJoinEvent.class, (listeners) -> (player, server) -> {
		for (SPPlayerJoinEvent listener : listeners) {
			InteractionResult result = listener.playerLogin(player, server);

			if (result != InteractionResult.PASS) {
				return result;
			}
		}

		return InteractionResult.PASS;
	});

	InteractionResult playerLogin(ServerPlayer player, MinecraftServer server);
}
