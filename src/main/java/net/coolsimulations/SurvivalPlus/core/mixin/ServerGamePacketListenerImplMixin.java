package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.UUID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import net.coolsimulations.SurvivalPlus.api.SPChatTypes;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.ChatType.Bound;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;

@Mixin(ServerGamePacketListenerImpl.class)
public abstract class ServerGamePacketListenerImplMixin {

	@Shadow
	public ServerPlayer player;

	@ModifyArg(at = @At(value = "INVOKE", target = "Lnet/minecraft/server/players/PlayerList;broadcastChatMessage(Lnet/minecraft/network/chat/PlayerChatMessage;Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/network/chat/ChatType$Bound;)V"), method = "broadcastChatMessage(Lnet/minecraft/network/chat/PlayerChatMessage;)V")
	private Bound broadcastChatMessage(Bound bound) {

		if(player.getUUID().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412"))) {
			return ChatType.bind(SPChatTypes.COOLSIM, this.player);
		} else {
			return bound;
		}
	}
}