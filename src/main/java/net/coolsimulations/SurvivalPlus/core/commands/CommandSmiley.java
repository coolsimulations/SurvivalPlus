package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class CommandSmiley {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal(":)")
				.requires(s -> s.hasPermission(0))
				.executes(smiley -> smiley(smiley.getSource())));
	}

	private static int smiley(CommandSourceStack sender) {

		MutableComponent smiley = Component.translatable("sp.commands.smiley.display", new Object[] {sender.getDisplayName()});
		smiley.withStyle(ChatFormatting.GREEN);
		sender.getServer().getPlayerList().broadcastSystemMessage(smiley, false);

		return Command.SINGLE_SUCCESS;
	}
}
