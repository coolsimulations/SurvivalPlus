package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.Util;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextFormatting;

public class CommandSmiley {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal(":)")
				.requires(s -> s.hasPermission(0))
				.executes(smiley -> smiley(smiley.getSource())));
	}

	private static int smiley(CommandSource sender) {

		TranslationTextComponent smiley = new TranslationTextComponent("sp.commands.smiley.display", new Object[] {sender.getDisplayName()});
		smiley.withStyle(TextFormatting.GREEN);
		if (sender.getEntity() != null)
			sender.getServer().getPlayerList().broadcastMessage(smiley, ChatType.CHAT, sender.getEntity().getUUID());
		else
			sender.getServer().getPlayerList().broadcastMessage(smiley, ChatType.SYSTEM, Util.NIL_UUID);

		return Command.SINGLE_SUCCESS;
	}
}
