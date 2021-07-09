package net.coolsimulations.SurvivalPlus.api.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;

public interface SPPlayerDeathEvent {
	
	Event<SPPlayerDeathEvent> EVENT = EventFactory.createArrayBacked(SPPlayerDeathEvent.class, (listeners) -> (player, source) -> {
        for (SPPlayerDeathEvent listener : listeners) {
            InteractionResult result = listener.killPlayer(player, source);

            if (result != InteractionResult.PASS) {
                return result;
            }
        }

        return InteractionResult.PASS;
    });

    InteractionResult killPlayer(ServerPlayer player, DamageSource source);

}
