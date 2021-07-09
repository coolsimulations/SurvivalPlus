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
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;

@Environment(EnvType.CLIENT)
@Mixin(Gui.class)
public abstract class GuiMixin {

	@ModifyVariable(at = @At(value = "INVOKE", ordinal = 0), method = "handleChat", ordinal = 0)
	private Component handleChat(Component message) {
		TranslatableComponent coolsim = new TranslatableComponent("sp.coolsim.creator");
		coolsim.withStyle(ChatFormatting.GOLD);

		TranslatableComponent playerJoined = new TranslatableComponent("multiplayer.player.joined", new Object[] {"coolsim"});

		TranslatableComponent playerLeft = new TranslatableComponent("multiplayer.player.left", new Object[] {"coolsim"});

		TranslatableComponent coolsimJoined = new TranslatableComponent("sp.coolsim.joined", new Object[] {"coolsim"});
		coolsimJoined.withStyle(ChatFormatting.YELLOW);

		TranslatableComponent coolsimLeft = new TranslatableComponent("sp.coolsim.left", new Object[] {"coolsim"});
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
				return coolsim.append(new TextComponent("").withStyle(ChatFormatting.WHITE).append(message));
			}
		}
		
		return message;
	}
}