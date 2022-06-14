package net.coolsimulations.SurvivalPlus.core.init;

import java.util.Optional;

import net.coolsimulations.SurvivalPlus.api.SPChatTypes;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.network.chat.ChatDecoration;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.ChatType.Narration;
import net.minecraft.network.chat.ChatType.TextDisplay;

public class SurvivalPlusChatTypes {
	
	public static void register() {
		Registry.register(BuiltinRegistries.CHAT_TYPE, SPChatTypes.COOLSIM, new ChatType(
		          Optional.of(TextDisplay.decorated(ChatDecoration.withSender("sp.coolsim.creator"))), 
		          Optional.empty(), 
		          Optional.of(Narration.decorated(ChatDecoration.withSender("chat.type.text.narrate"), Narration.Priority.CHAT))));
	}
}
