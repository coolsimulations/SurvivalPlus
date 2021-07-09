package net.coolsimulations.SurvivalPlus.core.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.events.SPPlaySoundAtEntityEvent;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

@Mixin(ClientLevel.class)
public abstract class ClientLevelMixin {

	@Inject(at = @At(value = "HEAD"), method = "playSound", cancellable = true)
    private void playSound(@Nullable Player player, double x, double y, double z, SoundEvent sound, SoundSource category, float volume, float pitch, CallbackInfo info) {
		InteractionResult result = SPPlaySoundAtEntityEvent.EVENT.invoker().playSound((((Level) (Object)this)), player, new BlockPos(x, y, z), sound, category, volume, pitch);

        if (result == InteractionResult.FAIL) {
            info.cancel();
        }
    }
	
	@Inject(at = @At(value = "HEAD"), method = "playSound(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V", cancellable = true)
    private void playSound(@Nullable Player player, Entity entity, SoundEvent sound, SoundSource category, float volume, float pitch, CallbackInfo info) {
		InteractionResult result = SPPlaySoundAtEntityEvent.EVENT.invoker().playSound((((Level) (Object)this)), player, entity.blockPosition(), sound, category, volume, pitch);

        if (result == InteractionResult.FAIL) {
            info.cancel();
        }
    }
}