package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

@Environment(EnvType.CLIENT)
@Mixin(ChatComponent.class)
public abstract class ChatComponentMixin {

	@ModifyVariable(method = "addMessage(Lnet/minecraft/network/chat/Component;Lnet/minecraft/network/chat/MessageSignature;ILnet/minecraft/client/GuiMessageTag;Z)V", at = @At("HEAD"), ordinal = 0)
	private Component addMessage(Component message) { 
		MutableComponent playerJoined = Component.translatable("multiplayer.player.joined", new Object[] {"coolsim"});

		MutableComponent playerLeft = Component.translatable("multiplayer.player.left", new Object[] {"coolsim"});

		MutableComponent coolsimJoined = Component.translatable("sp.coolsim.joined", new Object[] {"coolsim"});
		coolsimJoined.withStyle(ChatFormatting.YELLOW);

		MutableComponent coolsimLeft = Component.translatable("sp.coolsim.left", new Object[] {"coolsim"});
		coolsimLeft.withStyle(ChatFormatting.YELLOW);

		if(message.getString().equals(playerJoined.getString())) {
			return coolsimJoined;
		}

		if(message.getString().equals(playerLeft.getString())) {
			return coolsimLeft;
		}

		if(message.getString().startsWith("[coolsim]")) {
			MutableComponent coolsim = Component.translatable("sp.coolsim.creator", new Object[] {"", message});
			coolsim = Component.literal(coolsim.getString().replaceFirst("<", "").replaceFirst("> ", ""));
			return coolsim;
		}
		
		return message;
	}
}