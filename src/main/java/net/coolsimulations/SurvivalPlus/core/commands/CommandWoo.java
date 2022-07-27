package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class CommandWoo {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("woo")
		.requires(s -> s.hasPermission(0))
		.executes(woo -> woo(woo.getSource())));
	}

	private static int woo(CommandSourceStack sender) {

		MutableComponent woo = Component.translatable("sp.commands.woo.display", new Object[] {sender.getDisplayName()});
		woo.withStyle(ChatFormatting.BLUE);
		sender.getServer().getPlayerList().broadcastSystemMessage(woo, false);

		return Command.SINGLE_SUCCESS;
	}
}
