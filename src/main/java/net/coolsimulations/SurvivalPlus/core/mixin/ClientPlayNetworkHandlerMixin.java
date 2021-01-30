package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.events.SPClientPlayerJoinEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import net.minecraft.util.ActionResult;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
	
	@Shadow
	private MinecraftClient client;
	
	@Inject(at = @At("TAIL"), method = "onGameJoin", cancellable = true)
	public void onGameJoin(GameJoinS2CPacket packet, CallbackInfo info) {
		ActionResult result = SPClientPlayerJoinEvent.EVENT.invoker().playerLogin(this.client.interactionManager, this.client.player, this.client.getNetworkHandler().getConnection());

        if (result == ActionResult.FAIL) {
            info.cancel();
        }
	}

}
