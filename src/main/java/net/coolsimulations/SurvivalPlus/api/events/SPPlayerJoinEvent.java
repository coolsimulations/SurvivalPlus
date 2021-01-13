package net.coolsimulations.SurvivalPlus.api.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;

public interface SPPlayerJoinEvent {
	Event<SPPlayerJoinEvent> EVENT = EventFactory.createArrayBacked(SPPlayerJoinEvent.class, (listeners) -> (player, server) -> {
		for (SPPlayerJoinEvent listener : listeners) {
			ActionResult result = listener.playerLogin(player, server);

			if (result != ActionResult.PASS) {
				return result;
			}
		}

		return ActionResult.PASS;
	});

	ActionResult playerLogin(ServerPlayerEntity player, MinecraftServer server);
}
