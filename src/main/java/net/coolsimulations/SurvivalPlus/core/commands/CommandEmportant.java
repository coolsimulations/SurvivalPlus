package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;

import net.minecraft.network.MessageType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;

public class CommandEmportant {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("emportant")
				.then(CommandManager.argument("message", StringArgumentType.greedyString())
					.requires(s -> s.hasPermissionLevel(0))
					.executes(emportant -> emportant(emportant.getSource(), StringArgumentType.getString(emportant, "message")))));
	}

	private static int emportant(ServerCommandSource sender, String announcement) {

		TranslatableText emportant = new TranslatableText("sp.commands.emportant.display", new Object[] {sender.getDisplayName(), announcement});
		emportant.formatted(Formatting.BLUE, Formatting.BOLD);
		sender.getMinecraftServer().getPlayerManager().broadcastChatMessage(emportant, MessageType.SYSTEM, Util.NIL_UUID);

		return Command.SINGLE_SUCCESS;
	}
}
