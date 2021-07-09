package net.coolsimulations.SurvivalPlus.api.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

public interface SPLivingAttackEvent {
	
	Event<SPLivingAttackEvent> EVENT = EventFactory.createArrayBacked(SPLivingAttackEvent.class, (listeners) -> (entity, source, amount) -> {
        for (SPLivingAttackEvent listener : listeners) {
            InteractionResult result = listener.attackEntity(entity, source, amount);

            if (result != InteractionResult.PASS) {
                return result;
            }
        }

        return InteractionResult.PASS;
    });

	InteractionResult attackEntity(LivingEntity entity, DamageSource source, float amount);

}
