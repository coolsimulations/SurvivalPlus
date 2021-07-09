package net.coolsimulations.SurvivalPlus.api.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.Connection;
import net.minecraft.world.InteractionResult;

public interface SPClientPlayerJoinEvent {
	Event<SPClientPlayerJoinEvent> EVENT = EventFactory.createArrayBacked(SPClientPlayerJoinEvent.class, (listeners) -> (manager, player, networkManager) -> {
		for (SPClientPlayerJoinEvent listener : listeners) {
			InteractionResult result = listener.playerLogin(manager, player, networkManager);

			if (result != InteractionResult.PASS) {
				return result;
			}
		}

		return InteractionResult.PASS;
	});

	InteractionResult playerLogin(MultiPlayerGameMode manager, LocalPlayer player, Connection networkManager);
}
