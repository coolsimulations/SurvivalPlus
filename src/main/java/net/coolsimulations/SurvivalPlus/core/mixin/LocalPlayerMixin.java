package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.authlib.GameProfile;

import net.coolsimulations.SurvivalPlus.api.events.SPPlaySoundAtEntityEvent;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;

@Mixin(LocalPlayer.class)
public abstract class LocalPlayerMixin extends AbstractClientPlayer {

	public LocalPlayerMixin(ClientLevel world, GameProfile profile) {
		super(world, profile);
	}

	@Inject(at = @At(value = "HEAD"), method = "playSound", cancellable = true)
    private void playSound(SoundEvent sound, float volume, float pitch, CallbackInfo info) {
		InteractionResult result = SPPlaySoundAtEntityEvent.EVENT.invoker().playSound(this.level, (((LocalPlayer) (Object)this)), (((LocalPlayer) (Object)this)).blockPosition(), sound, this.getSoundSource(), volume, pitch);

        if (result == InteractionResult.FAIL) {
            info.cancel();
        }
    }
}