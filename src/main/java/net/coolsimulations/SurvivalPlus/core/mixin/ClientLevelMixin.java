package net.coolsimulations.SurvivalPlus.core.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.events.SPPlaySoundAtEntityEvent;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

@Mixin(ClientLevel.class)
public abstract class ClientLevelMixin {

	@Inject(at = @At(value = "HEAD"), method = "playSeededSound", cancellable = true)
    private void playSound(@Nullable Player player, double x, double y, double z, Holder<SoundEvent> sound, SoundSource category, float volume, float pitch, long seed, CallbackInfo info) {
		InteractionResult result = SPPlaySoundAtEntityEvent.EVENT.invoker().playSound((((Level) (Object)this)), player, new BlockPos(x, y, z), sound, category, volume, pitch, seed);

        if (result == InteractionResult.FAIL) {
            info.cancel();
        }
    }
	
	@Inject(at = @At(value = "HEAD"), method = "playSeededSound(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/core/Holder;Lnet/minecraft/sounds/SoundSource;FFJ)V", cancellable = true)
    private void playSound(@Nullable Player player, Entity entity, Holder<SoundEvent> sound, SoundSource category, float volume, float pitch, long seed, CallbackInfo info) {
		InteractionResult result = SPPlaySoundAtEntityEvent.EVENT.invoker().playSound((((Level) (Object)this)), player, entity.blockPosition(), sound, category, volume, pitch, seed);

        if (result == InteractionResult.FAIL) {
            info.cancel();
        }
    }
}