package net.coolsimulations.SurvivalPlus.api.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.network.ClientConnection;
import net.minecraft.util.ActionResult;

public interface SPClientPlayerJoinEvent {
	Event<SPClientPlayerJoinEvent> EVENT = EventFactory.createArrayBacked(SPClientPlayerJoinEvent.class, (listeners) -> (manager, player, networkManager) -> {
		for (SPClientPlayerJoinEvent listener : listeners) {
			ActionResult result = listener.playerLogin(manager, player, networkManager);

			if (result != ActionResult.PASS) {
				return result;
			}
		}

		return ActionResult.PASS;
	});

	ActionResult playerLogin(ClientPlayerInteractionManager manager, ClientPlayerEntity player, ClientConnection networkManager);
}
