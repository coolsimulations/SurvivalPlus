package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.TranslatableComponent;

public class CommandSmiley {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal(":)")
				.requires(s -> s.hasPermission(0))
				.executes(smiley -> smiley(smiley.getSource())));
	}

	private static int smiley(CommandSourceStack sender) {

		TranslatableComponent smiley = new TranslatableComponent("sp.commands.smiley.display", new Object[] {sender.getDisplayName()});
		smiley.withStyle(ChatFormatting.GREEN);
		if(sender.getEntity() != null)
			sender.getServer().getPlayerList().broadcastMessage(smiley, ChatType.CHAT, sender.getEntity().getUUID());
		else
			sender.getServer().getPlayerList().broadcastMessage(smiley, ChatType.SYSTEM, Util.NIL_UUID);

		return Command.SINGLE_SUCCESS;
	}
}
