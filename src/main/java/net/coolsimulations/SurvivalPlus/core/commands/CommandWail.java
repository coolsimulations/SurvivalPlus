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
				.requires(s -> s.hasPermission(0))
				.executes(wail -> wail(wail.getSource())));
	}

	private static int wail(CommandSource sender) {

		TranslationTextComponent wail = new TranslationTextComponent("sp.commands.wail.display", new Object[] {sender.getDisplayName()});
		wail.withStyle(TextFormatting.AQUA);
		if (sender.getEntity() != null)
			sender.getServer().getPlayerList().broadcastMessage(wail, ChatType.CHAT, sender.getEntity().getUUID());
		else
			sender.getServer().getPlayerList().broadcastMessage(wail, ChatType.SYSTEM, Util.NIL_UUID);

		return Command.SINGLE_SUCCESS;
	}
}
