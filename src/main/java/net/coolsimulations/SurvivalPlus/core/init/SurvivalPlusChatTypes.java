package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPChatTypes;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.ChatTypeDecoration;

public class SurvivalPlusChatTypes {
	
	public static void register() {
		Registry.register(BuiltinRegistries.CHAT_TYPE, SPChatTypes.COOLSIM, new ChatType(
				ChatTypeDecoration.withSender("sp.coolsim.creator"), 
				ChatTypeDecoration.withSender("chat.type.text.narrate")));
	}
}
