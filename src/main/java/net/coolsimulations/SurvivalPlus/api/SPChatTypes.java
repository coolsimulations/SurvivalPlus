package net.coolsimulations.SurvivalPlus.api;

import net.minecraft.core.Registry;
import net.minecraft.network.chat.ChatType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class SPChatTypes {

	public static final ResourceKey<ChatType> COOLSIM = create("coolsim");

	private static ResourceKey<ChatType> create(String string) {
		return ResourceKey.create(Registry.CHAT_TYPE_REGISTRY, new ResourceLocation(string));
	}
}
