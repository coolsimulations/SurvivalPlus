package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.events.SPClientPlayerJoinEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import net.minecraft.world.InteractionResult;

@Mixin(ClientPacketListener.class)
public class ClientPacketListenerMixin {
	
	@Shadow
	private Minecraft minecraft;
	
	@Inject(at = @At("TAIL"), method = "handleLogin", cancellable = true)
	public void handleLogin(ClientboundLoginPacket packet, CallbackInfo info) {
		InteractionResult result = SPClientPlayerJoinEvent.EVENT.invoker().playerLogin(this.minecraft.gameMode, this.minecraft.player, this.minecraft.getConnection().getConnection());

        if (result == InteractionResult.FAIL) {
            info.cancel();
        }
	}

}
