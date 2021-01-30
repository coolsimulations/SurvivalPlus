package net.coolsimulations.SurvivalPlus.api.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface SPPlaySoundAtEntityEvent {
	Event<SPPlaySoundAtEntityEvent> EVENT = EventFactory.createArrayBacked(SPPlaySoundAtEntityEvent.class, (listeners) -> (world, entity, pos, sound, category, volume, pitch) -> {
		for (SPPlaySoundAtEntityEvent listener : listeners) {
			ActionResult result = listener.playSound(world, entity, pos, sound, category, volume, pitch);

			if (result != ActionResult.PASS) {
				return result;
			}
		}

		return ActionResult.PASS;
	});

	ActionResult playSound(World world, Entity entity, BlockPos pos, SoundEvent sound, SoundCategory category, float volume, float pitch);
}
