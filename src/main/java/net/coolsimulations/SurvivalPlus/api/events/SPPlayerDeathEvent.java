package net.coolsimulations.SurvivalPlus.api.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;

public interface SPPlayerDeathEvent {
	
	Event<SPPlayerDeathEvent> EVENT = EventFactory.createArrayBacked(SPPlayerDeathEvent.class, (listeners) -> (player, source) -> {
        for (SPPlayerDeathEvent listener : listeners) {
            ActionResult result = listener.killPlayer(player, source);

            if (result != ActionResult.PASS) {
                return result;
            }
        }

        return ActionResult.PASS;
    });

    ActionResult killPlayer(ServerPlayerEntity player, DamageSource source);

}
