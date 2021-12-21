package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.events.SPLastLoadEvent;
import net.minecraft.server.Main;

@Mixin(Main.class)
public class ServerMainMixin {
	
	private static boolean hasLoaded = false;
	
	@Inject(method = "main", at = @At(target = "Ljava/nio/file/Paths;get(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", value = "INVOKE_ASSIGN"), remap = false)
    private static void inject(String[] args, CallbackInfo ci) {
		if(!hasLoaded) {
			SPLastLoadEvent.EVENT.invoker().load();
			hasLoaded = true;
		}
    }

}
