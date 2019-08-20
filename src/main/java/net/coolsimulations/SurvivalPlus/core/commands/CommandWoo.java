package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class CommandWoo {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("woo")
		.requires(s -> s.hasPermissionLevel(0))
		.executes(woo -> woo(woo.getSource())));
	}

	private static int woo(CommandSource sender) {

		TextComponentTranslation woo = new TextComponentTranslation("sp.commands.woo.display", new Object[] {sender.getDisplayName()});
		woo.getStyle().setColor(TextFormatting.BLUE);
		sender.getServer().getPlayerList().sendMessage(woo);

		return Command.SINGLE_SUCCESS;
	}
}
