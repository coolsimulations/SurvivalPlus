package net.coolsimulations.SurvivalPlus.core.commands;

import java.util.Collection;
import java.util.Iterator;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.command.CommandException;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.network.MessageType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;

public class CommandIndeed {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("indeed")
				.then(CommandManager.argument("targets", EntityArgumentType.players())
						.requires(s -> s.hasPermissionLevel(0))
						.executes(indeed -> indeed(indeed.getSource(), EntityArgumentType.getPlayers(indeed, "targets")))));

		dispatcher.register(CommandManager.literal("indeed")
				.requires(s -> s.hasPermissionLevel(0))
				.executes(indeed -> indeedSingle(indeed.getSource())));
	}

	private static int indeed(ServerCommandSource sender, Collection<ServerPlayerEntity> players) {
		Iterator var3 = players.iterator();

		while (var3.hasNext()) {
			ServerPlayerEntity entityplayer = (ServerPlayerEntity) var3.next();

			if (entityplayer == sender.getEntity()) {

				throw new CommandException(new TranslatableText("sp.commands.indeed.sameTarget"));

			} else {
				TranslatableText indeed = new TranslatableText("sp.commands.indeed.display1", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				indeed.formatted(Formatting.DARK_GREEN);
				sender.getMinecraftServer().getPlayerManager().broadcastChatMessage(indeed, MessageType.SYSTEM, Util.NIL_UUID);
			}
		}

		return players.size();
	}

	private static int indeedSingle(ServerCommandSource sender) {

		TranslatableText indeed = new TranslatableText("sp.commands.indeed.display2", new Object[]{sender.getDisplayName()});
		indeed.formatted(Formatting.DARK_GREEN);
		sender.getMinecraftServer().getPlayerManager().broadcastChatMessage(indeed, MessageType.SYSTEM, Util.NIL_UUID);

		return Command.SINGLE_SUCCESS;
	}
}
