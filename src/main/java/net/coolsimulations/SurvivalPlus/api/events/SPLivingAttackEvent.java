package net.coolsimulations.SurvivalPlus.api.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;

public interface SPLivingAttackEvent {
	
	Event<SPLivingAttackEvent> EVENT = EventFactory.createArrayBacked(SPLivingAttackEvent.class, (listeners) -> (entity, source, amount) -> {
        for (SPLivingAttackEvent listener : listeners) {
            ActionResult result = listener.attackEntity(entity, source, amount);

            if (result != ActionResult.PASS) {
                return result;
            }
        }

        return ActionResult.PASS;
    });

    ActionResult attackEntity(LivingEntity entity, DamageSource source, float amount);

}
