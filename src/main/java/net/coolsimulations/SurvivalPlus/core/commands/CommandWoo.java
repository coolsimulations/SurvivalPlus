package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.Util;
import net.minecraft.network.chat.ChatType;
import net.minecraft.ChatFormatting;

public class CommandWoo {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("woo")
		.requires(s -> s.hasPermission(0))
		.executes(woo -> woo(woo.getSource())));
	}

	private static int woo(CommandSourceStack sender) {

		TranslatableComponent woo = new TranslatableComponent("sp.commands.woo.display", new Object[] {sender.getDisplayName()});
		woo.withStyle(ChatFormatting.BLUE);
		if (sender.getEntity() != null)
			sender.getServer().getPlayerList().broadcastMessage(woo, ChatType.CHAT, sender.getEntity().getUUID());
		else
			sender.getServer().getPlayerList().broadcastMessage(woo, ChatType.SYSTEM, Util.NIL_UUID);

		return Command.SINGLE_SUCCESS;
	}
}
