package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.text.LiteralText;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

	@ModifyVariable(at = @At(value = "INVOKE", ordinal = 0), method = "addChatMessage", ordinal = 0)
	private Text addChatMessage(Text message) {
		TranslatableText coolsim = new TranslatableText("sp.coolsim.creator");
		coolsim.formatted(Formatting.GOLD);

		TranslatableText playerJoined = new TranslatableText("multiplayer.player.joined", new Object[] {"coolsim"});
		playerJoined.formatted(Formatting.YELLOW);

		TranslatableText playerLeft = new TranslatableText("multiplayer.player.left", new Object[] {"coolsim"});
		playerLeft.formatted(Formatting.YELLOW);

		TranslatableText coolsimJoined = new TranslatableText("sp.coolsim.joined");
		coolsimJoined.formatted(Formatting.YELLOW);

		TranslatableText coolsimLeft = new TranslatableText("sp.coolsim.left");
		coolsimLeft.formatted(Formatting.YELLOW);

		if(message.equals(playerJoined)) {
			return coolsimJoined;
		}

		if(message.equals(playerLeft)) {
			return coolsimLeft;
		}

		if(message.getString().startsWith("[coolsim]")) {
			if(message instanceof MutableText) {
				return coolsim.append(((MutableText) message).formatted(Formatting.WHITE));
			} else {
				return coolsim.append(new LiteralText("").formatted(Formatting.WHITE).append(message));
			}
		}
		
		return message;
	}
}