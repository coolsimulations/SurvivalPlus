package net.coolsimulations.SurvivalPlus.api;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.ChatType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class SPChatTypes {

	public static final ResourceKey<ChatType> COOLSIM = create("coolsim");

	private static ResourceKey<ChatType> create(String string) {
		return ResourceKey.create(Registries.CHAT_TYPE, new ResourceLocation(SPReference.MOD_ID, string));
	}
}
