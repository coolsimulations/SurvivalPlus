package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class CommandEmportant {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("emportant")
				.then(Commands.argument("message", StringArgumentType.greedyString())
					.requires(s -> s.hasPermissionLevel(0))
					.executes(emportant -> emportant(emportant.getSource(), StringArgumentType.getString(emportant, "message")))));
	}

	private static int emportant(CommandSource sender, String announcement) {

		TextComponentTranslation emportant = new TextComponentTranslation("sp.commands.emportant.display", new Object[] {sender.getDisplayName(), announcement});
		emportant.getStyle().setColor(TextFormatting.BLUE);
		emportant.getStyle().setBold(true);
		sender.getServer().getPlayerList().sendMessage(emportant);

		return Command.SINGLE_SUCCESS;
	}
}
