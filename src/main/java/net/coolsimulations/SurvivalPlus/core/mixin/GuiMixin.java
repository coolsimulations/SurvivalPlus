package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Gui;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

@Environment(EnvType.CLIENT)
@Mixin(Gui.class)
public abstract class GuiMixin {

	@ModifyVariable(at = @At(value = "INVOKE", ordinal = 0), method = "handleSystemChat", ordinal = 0)
	private Component handleSystemChat(Component message) {
		
		MutableComponent coolsim = Component.translatable("sp.coolsim.creator");
		coolsim.withStyle(ChatFormatting.GOLD);

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
			if(message instanceof MutableComponent) {
				return coolsim.append(((MutableComponent) message).withStyle(ChatFormatting.WHITE));
			} else {
				return coolsim.append(Component.literal("").withStyle(ChatFormatting.WHITE).append(message));
			}
		}
		
		return message;
	}
}