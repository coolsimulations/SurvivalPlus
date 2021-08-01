package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.Util;
import net.minecraft.network.chat.ChatType;
import net.minecraft.ChatFormatting;

public class CommandWail {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("wail")
				.requires(s -> s.hasPermission(0))
				.executes(wail -> wail(wail.getSource())));
	}

	private static int wail(CommandSourceStack sender) {

		TranslatableComponent wail = new TranslatableComponent("sp.commands.wail.display", new Object[] {sender.getDisplayName()});
		wail.withStyle(ChatFormatting.AQUA);
		if (sender.getEntity() != null)
			sender.getServer().getPlayerList().broadcastMessage(wail, ChatType.CHAT, sender.getEntity().getUUID());
		else
			sender.getServer().getPlayerList().broadcastMessage(wail, ChatType.SYSTEM, Util.NIL_UUID);

		return Command.SINGLE_SUCCESS;
	}
}
