package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.UUID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.SharedConstants;
import net.minecraft.client.options.ChatVisibility;
import net.minecraft.network.MessageType;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

@Mixin(ServerPlayNetworkHandler.class)
public abstract class ServerPlayNetworkHandlerMixin {

	@Shadow
	private MinecraftServer server;

	@Shadow
	public ServerPlayerEntity player;
	
	@Shadow
	private int messageCooldown;

	@Inject(at = @At("HEAD"), method = "method_31286", cancellable = true)
	private void method_31286(String message, CallbackInfo info) {

		if(this.player.getClientChatVisibility() != ChatVisibility.HIDDEN && !message.startsWith("/")) {

			TranslatableText coolsim = new TranslatableText("sp.coolsim.creator");
			coolsim.formatted(Formatting.GOLD);

			if(player.getUuid().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412"))) {
				this.player.updateLastActionTime();

		         for(int i = 0; i < message.length(); ++i) {
		            if (!SharedConstants.isValidChar(message.charAt(i))) {
		               this.disconnect(new TranslatableText("multiplayer.disconnect.illegal_characters"));
		               return;
		            }
		         }
		         
				Text text = coolsim.append(new TranslatableText("chat.type.text", new Object[]{this.player.getDisplayName(), message}).formatted(Formatting.WHITE));
	            this.server.getPlayerManager().broadcastChatMessage(text, MessageType.CHAT, this.player.getUuid());
	            
	            this.messageCooldown += 20;
	            if (this.messageCooldown > 200 && !this.server.getPlayerManager().isOperator(this.player.getGameProfile())) {
	               this.disconnect(new TranslatableText("disconnect.spam"));
	            }
	            
	            info.cancel();
			}
		}
	}
	
	@Shadow
	public abstract void disconnect(Text reason);
}