package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.Util;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextFormatting;

public class CommandWoo {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("woo")
		.requires(s -> s.hasPermission(0))
		.executes(woo -> woo(woo.getSource())));
	}

	private static int woo(CommandSource sender) {

		TranslationTextComponent woo = new TranslationTextComponent("sp.commands.woo.display", new Object[] {sender.getDisplayName()});
		woo.withStyle(TextFormatting.BLUE);
		if (sender.getEntity() != null)
			sender.getServer().getPlayerList().broadcastMessage(woo, ChatType.CHAT, sender.getEntity().getUUID());
		else
			sender.getServer().getPlayerList().broadcastMessage(woo, ChatType.SYSTEM, Util.NIL_UUID);

		return Command.SINGLE_SUCCESS;
	}
}
