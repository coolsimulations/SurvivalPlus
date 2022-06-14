package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.PlayerChatMessage;

public class CommandWoo {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("woo")
		.requires(s -> s.hasPermission(0))
		.executes(woo -> woo(woo.getSource())));
	}

	private static int woo(CommandSourceStack sender) {

		MutableComponent woo = Component.translatable("sp.commands.woo.display", new Object[] {sender.getDisplayName()});
		woo.withStyle(ChatFormatting.BLUE);
		if (sender.getEntity() != null)
			sender.getServer().getPlayerList().broadcastChatMessage(PlayerChatMessage.signed(woo, sender.getSigningContext().getArgumentSignature("action")), sender.getEntity().asChatSender(), ChatType.SYSTEM);
		else
			sender.getServer().getPlayerList().broadcastSystemMessage(woo, ChatType.SYSTEM);

		return Command.SINGLE_SUCCESS;
	}
}
