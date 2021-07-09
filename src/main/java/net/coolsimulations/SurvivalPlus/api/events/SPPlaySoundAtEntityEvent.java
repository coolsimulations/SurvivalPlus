package net.coolsimulations.SurvivalPlus.api.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public interface SPPlaySoundAtEntityEvent {
	Event<SPPlaySoundAtEntityEvent> EVENT = EventFactory.createArrayBacked(SPPlaySoundAtEntityEvent.class, (listeners) -> (world, entity, pos, sound, category, volume, pitch) -> {
		for (SPPlaySoundAtEntityEvent listener : listeners) {
			InteractionResult result = listener.playSound(world, entity, pos, sound, category, volume, pitch);

			if (result != InteractionResult.PASS) {
				return result;
			}
		}

		return InteractionResult.PASS;
	});

	InteractionResult playSound(Level world, Entity entity, BlockPos pos, SoundEvent sound, SoundSource category, float volume, float pitch);
}
