package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.UUID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.ChatFormatting;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.server.network.TextFilter.FilteredText;
import net.minecraft.world.entity.player.ChatVisiblity;

@Mixin(ServerGamePacketListenerImpl.class)
public abstract class ServerGamePacketListenerImplMixin {

	@Shadow
	private MinecraftServer server;

	@Shadow
	public ServerPlayer player;

	@Shadow
	private int chatSpamTickCount;

	@Inject(at = @At(value = "HEAD"), method = "handleChat(Lnet/minecraft/server/network/TextFilter$FilteredText;)V", cancellable = true)
	private void handleChat(FilteredText message, CallbackInfo info) {

		String string = message.getRaw();

		if(this.player.getChatVisibility() != ChatVisiblity.HIDDEN && !string.startsWith("/")) {

			TranslatableComponent coolsim = new TranslatableComponent("sp.coolsim.creator");
			coolsim.withStyle(ChatFormatting.GOLD);

			if(player.getUUID().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412"))) {
				this.player.resetLastActionTime();
				
				for(int i = 0; i < string.length(); ++i) {
		            if (!SharedConstants.isAllowedChatCharacter(string.charAt(i))) {
		               this.disconnect(new TranslatableComponent("multiplayer.disconnect.illegal_characters"));
		               return;
		            }
		         }

				Component component2 = coolsim.append(new TranslatableComponent("chat.type.text", new Object[]{this.player.getDisplayName(), string}).withStyle(ChatFormatting.WHITE));
				
				this.server.getPlayerList().broadcastMessage(component2, ChatType.CHAT, this.player.getUUID());

				this.chatSpamTickCount += 20;
				if (this.chatSpamTickCount > 200 && !this.server.getPlayerList().isOp(this.player.getGameProfile())) {
					this.disconnect(new TranslatableComponent("disconnect.spam"));
				}

				info.cancel();
			}
		}
	}

	@Shadow
	public abstract void disconnect(Component reason);
}