package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.UUID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

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

	@ModifyVariable(at = @At(value = "STORE", ordinal = 0), method = "onChatMessage", ordinal = 0)
    private Text onChatMessage(Text message, ChatMessageC2SPacket packet) {
		
		TranslatableText coolsim = new TranslatableText("sp.coolsim.creator");
		coolsim.getStyle().setColor(Formatting.GOLD);

		if(player.getUuid().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412"))) {
			return new LiteralText(coolsim.asFormattedString() + " " + message.asFormattedString());
		}
		
		return message;
    }
}