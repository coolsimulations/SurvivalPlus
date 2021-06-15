package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.Util;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class CommandEmportant {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("emportant")
				.then(Commands.argument("message", StringArgumentType.greedyString())
					.requires(s -> s.hasPermission(0))
					.executes(emportant -> emportant(emportant.getSource(), StringArgumentType.getString(emportant, "message")))));
	}

	private static int emportant(CommandSource sender, String announcement) {

		TranslationTextComponent emportant = new TranslationTextComponent("sp.commands.emportant.display", new Object[] {sender.getDisplayName(), announcement});
		emportant.withStyle(TextFormatting.BLUE);
		emportant.withStyle(TextFormatting.BOLD);
		if (sender.getEntity() != null)
			sender.getServer().getPlayerList().broadcastMessage(emportant, ChatType.CHAT, sender.getEntity().getUUID());
		else
			sender.getServer().getPlayerList().broadcastMessage(emportant, ChatType.SYSTEM, Util.NIL_UUID);

		return Command.SINGLE_SUCCESS;
	}
}
