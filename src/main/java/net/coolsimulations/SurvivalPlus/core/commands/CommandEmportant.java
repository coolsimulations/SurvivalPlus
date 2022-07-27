package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class CommandEmportant {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("emportant")
				.then(Commands.argument("message", StringArgumentType.greedyString())
						.requires(s -> s.hasPermission(0))
						.executes(emportant -> emportant(emportant.getSource(), StringArgumentType.getString(emportant, "message")))));
	}

	private static int emportant(CommandSourceStack sender, String announcement) {

		MutableComponent emportant = Component.translatable("sp.commands.emportant.display", new Object[] {sender.getDisplayName(), announcement});
		emportant.withStyle(ChatFormatting.BLUE, ChatFormatting.BOLD);
		sender.getServer().getPlayerList().broadcastSystemMessage(emportant, false);

		return Command.SINGLE_SUCCESS;
	}
}
