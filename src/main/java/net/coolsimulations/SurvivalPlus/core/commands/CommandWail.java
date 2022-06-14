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

public class CommandWail {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("wail")
				.requires(s -> s.hasPermission(0))
				.executes(wail -> wail(wail.getSource())));
	}

	private static int wail(CommandSourceStack sender) {

		MutableComponent wail = Component.translatable("sp.commands.wail.display", new Object[] {sender.getDisplayName()});
		wail.withStyle(ChatFormatting.AQUA);
		if (sender.getEntity() != null)
			sender.getServer().getPlayerList().broadcastChatMessage(PlayerChatMessage.signed(wail, sender.getSigningContext().getArgumentSignature("action")), sender.getEntity().asChatSender(), ChatType.SYSTEM);
		else
			sender.getServer().getPlayerList().broadcastSystemMessage(wail, ChatType.SYSTEM);

		return Command.SINGLE_SUCCESS;
	}
}
