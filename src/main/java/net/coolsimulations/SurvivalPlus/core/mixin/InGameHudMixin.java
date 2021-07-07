package net.coolsimulations.SurvivalPlus.core.mixin;

import org.apache.commons.lang3.StringUtils;
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
		
		String coolsimFormatted = "coolsim";

		if(message.asFormattedString().contains("coolsim")) {
			int index = message.asFormattedString().indexOf("coolsim");
			try {
				coolsimFormatted = message.asFormattedString().substring(index - 2, index + 9);
				if(StringUtils.countMatches(coolsimFormatted, "§") != 2) {
					coolsimFormatted = "coolsim";
				}
			} catch(Exception e) {
				
			}
		}

		TranslatableText playerJoined = new TranslatableText("multiplayer.player.joined", new Object[] {coolsimFormatted});
		playerJoined.getStyle().setColor(Formatting.YELLOW);

		TranslatableText playerLeft = new TranslatableText("multiplayer.player.left", new Object[] {coolsimFormatted});
		playerLeft.getStyle().setColor(Formatting.YELLOW);

		TranslatableText coolsimJoined = new TranslatableText("sp.coolsim.joined", new Object[] {coolsimFormatted});
		coolsimJoined.getStyle().setColor(Formatting.YELLOW);

		TranslatableText coolsimLeft = new TranslatableText("sp.coolsim.left", new Object[] {coolsimFormatted});
		coolsimLeft.getStyle().setColor(Formatting.YELLOW);

		if(SurvivalPlusEventHandler.replaceFormattingCodes(message).equals(SurvivalPlusEventHandler.replaceFormattingCodes(playerJoined))) {
			return coolsimJoined;
		}

		if(SurvivalPlusEventHandler.replaceFormattingCodes(message).equals(SurvivalPlusEventHandler.replaceFormattingCodes(playerLeft))) {
			return coolsimLeft;
		}

		if(SurvivalPlusEventHandler.replaceFormattingCodes(message).startsWith("[coolsim]")) {
			return new LiteralText(message.asFormattedString().replaceFirst("\\[", coolsim.asFormattedString() + " ["));
		}
		
		return message;
	}
}