package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.events.SPLastLoadEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;

@Mixin(Minecraft.class)
public class MinecraftMixin {
	
	private static boolean hasLoaded = false;
	
	@Inject(method = "<init>", at = @At(target = "Ljava/lang/Thread;currentThread()Ljava/lang/Thread;", value = "INVOKE_ASSIGN"))
    public void inject(GameConfig gameConfig, CallbackInfo ci) {
		if(!hasLoaded) {
			SPLastLoadEvent.EVENT.invoker().load();
			hasLoaded = true;
		}
    }

}
