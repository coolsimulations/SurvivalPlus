package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.Util;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextFormatting;

public class CommandEmportant {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("emportant")
				.then(Commands.argument("message", StringArgumentType.greedyString())
					.requires(s -> s.hasPermissionLevel(0))
					.executes(emportant -> emportant(emportant.getSource(), StringArgumentType.getString(emportant, "message")))));
	}

	private static int emportant(CommandSource sender, String announcement) {

		TranslationTextComponent emportant = new TranslationTextComponent("sp.commands.emportant.display", new Object[] {sender.getDisplayName(), announcement});
		emportant.func_240699_a_(TextFormatting.BLUE);
		emportant.func_240699_a_(TextFormatting.BOLD);
		sender.getServer().getPlayerList().func_232641_a_(emportant, ChatType.SYSTEM, Util.field_240973_b_);

		return Command.SINGLE_SUCCESS;
	}
}
