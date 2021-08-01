package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.Util;
import net.minecraft.network.chat.ChatType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;

public class CommandEmportant {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("emportant")
				.then(Commands.argument("message", StringArgumentType.greedyString())
					.requires(s -> s.hasPermission(0))
					.executes(emportant -> emportant(emportant.getSource(), StringArgumentType.getString(emportant, "message")))));
	}

	private static int emportant(CommandSourceStack sender, String announcement) {

		TranslatableComponent emportant = new TranslatableComponent("sp.commands.emportant.display", new Object[] {sender.getDisplayName(), announcement});
		emportant.withStyle(ChatFormatting.BLUE);
		emportant.withStyle(ChatFormatting.BOLD);
		if (sender.getEntity() != null)
			sender.getServer().getPlayerList().broadcastMessage(emportant, ChatType.CHAT, sender.getEntity().getUUID());
		else
			sender.getServer().getPlayerList().broadcastMessage(emportant, ChatType.SYSTEM, Util.NIL_UUID);

		return Command.SINGLE_SUCCESS;
	}
}
