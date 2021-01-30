package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.authlib.GameProfile;

import net.coolsimulations.SurvivalPlus.api.events.SPPlaySoundAtEntityEvent;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {

	public ClientPlayerEntityMixin(ClientWorld world, GameProfile profile) {
		super(world, profile);
	}

	@Inject(at = @At(value = "HEAD"), method = "playSound", cancellable = true)
    private void playSound(SoundEvent sound, float volume, float pitch, CallbackInfo info) {
		ActionResult result = SPPlaySoundAtEntityEvent.EVENT.invoker().playSound(this.world, (((ClientPlayerEntity) (Object)this)), (((ClientPlayerEntity) (Object)this)).getBlockPos(), sound, this.getSoundCategory(), volume, pitch);

        if (result == ActionResult.FAIL) {
            info.cancel();
        }
    }
}