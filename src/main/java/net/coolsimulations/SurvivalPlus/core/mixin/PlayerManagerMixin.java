package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.events.SPPlayerJoinEvent;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {
	
    @Inject(at = @At("TAIL"), method = "onPlayerConnect", cancellable = true)
	public void onPlayerConnect(ClientConnection connection, ServerPlayerEntity player, CallbackInfo info) {
    	ActionResult result = SPPlayerJoinEvent.EVENT.invoker().playerLogin(player, player.getServer());

        if (result == ActionResult.FAIL) {
            info.cancel();
        }
	}

}
