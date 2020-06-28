package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.Util;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextFormatting;

public class CommandWail {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("wail")
				.requires(s -> s.hasPermissionLevel(0))
				.executes(wail -> wail(wail.getSource())));
	}

	private static int wail(CommandSource sender) {

		TranslationTextComponent wail = new TranslationTextComponent("sp.commands.wail.display", new Object[] {sender.getDisplayName()});
		wail.func_240699_a_(TextFormatting.AQUA);
		sender.getServer().getPlayerList().func_232641_a_(wail, ChatType.SYSTEM, Util.field_240973_b_);

		return Command.SINGLE_SUCCESS;
	}
}
