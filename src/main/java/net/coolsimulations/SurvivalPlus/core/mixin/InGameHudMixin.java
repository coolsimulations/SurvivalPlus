package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusEventHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

	@ModifyVariable(at = @At(value = "INVOKE", ordinal = 0), method = "addChatMessage", ordinal = 0)
	private Text onChatMessage(Text message) {
		TranslatableText coolsim = new TranslatableText("sp.coolsim.creator");
		coolsim.getStyle().setColor(Formatting.GOLD);

		TranslatableText playerJoined = new TranslatableText("multiplayer.player.joined", new Object[] {"coolsim"});
		playerJoined.getStyle().setColor(Formatting.YELLOW);

		TranslatableText playerLeft = new TranslatableText("multiplayer.player.left", new Object[] {"coolsim"});
		playerLeft.getStyle().setColor(Formatting.YELLOW);

		TranslatableText coolsimJoined = new TranslatableText("sp.coolsim.joined");
		coolsimJoined.getStyle().setColor(Formatting.YELLOW);

		TranslatableText coolsimLeft = new TranslatableText("sp.coolsim.left");
		coolsimLeft.getStyle().setColor(Formatting.YELLOW);

		if(message.asFormattedString().equals(playerJoined.asFormattedString())) {
			return coolsimJoined;
		}

		if(message.asFormattedString().equals(playerLeft.asFormattedString())) {
			return coolsimLeft;
		}

		if(SurvivalPlusEventHandler.replaceFormattingCodes(message).startsWith("[coolsim]")) {
			return new LiteralText(message.asFormattedString().replaceFirst("\\[", coolsim.asFormattedString() + " ["));
		}
		
		return message;
	}
}