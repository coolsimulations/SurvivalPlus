package net.coolsimulations.SurvivalPlus.core.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.events.SPPlaySoundAtEntityEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {

	@Inject(at = @At(value = "HEAD"), method = "playSound", cancellable = true)
    private void playSound(@Nullable PlayerEntity player, double x, double y, double z, SoundEvent sound, SoundCategory category, float volume, float pitch, CallbackInfo info) {
		ActionResult result = SPPlaySoundAtEntityEvent.EVENT.invoker().playSound((((World) (Object)this)), player, new BlockPos(x, y, z), sound, category, volume, pitch);

        if (result == ActionResult.FAIL) {
            info.cancel();
        }
    }
	
	@Inject(at = @At(value = "HEAD"), method = "playSoundFromEntity", cancellable = true)
    private void playSoundFromEntity(@Nullable PlayerEntity player, Entity entity, SoundEvent sound, SoundCategory category, float volume, float pitch, CallbackInfo info) {
		ActionResult result = SPPlaySoundAtEntityEvent.EVENT.invoker().playSound((((World) (Object)this)), player, entity.getBlockPos(), sound, category, volume, pitch);

        if (result == ActionResult.FAIL) {
            info.cancel();
        }
    }
}