package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandRuntimeException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.Util;
import net.minecraft.network.chat.ChatType;
import net.minecraft.ChatFormatting;

import java.util.Collection;
import java.util.Iterator;

public class CommandIndeed {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("indeed")
				.then(Commands.argument("targets", EntityArgument.players())
						.requires(s -> s.hasPermission(0))
						.executes(indeed -> indeed(indeed.getSource(), EntityArgument.getPlayers(indeed, "targets")))));

		dispatcher.register(Commands.literal("indeed")
				.requires(s -> s.hasPermission(0))
				.executes(indeed -> indeedSingle(indeed.getSource())));
	}

	private static int indeed(CommandSourceStack sender, Collection<ServerPlayer> players) {
		Iterator<ServerPlayer> var3 = players.iterator();

		while (var3.hasNext()) {
			ServerPlayer entityplayer = (ServerPlayer) var3.next();

			if (entityplayer == sender.getEntity()) {

				throw new CommandRuntimeException(new TranslatableComponent("sp.commands.indeed.sameTarget"));

			} else {
				TranslatableComponent indeed = new TranslatableComponent("sp.commands.indeed.display1", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				indeed.withStyle(ChatFormatting.DARK_GREEN);
				if (sender.getEntity() != null)
					sender.getServer().getPlayerList().broadcastMessage(indeed, ChatType.CHAT, sender.getEntity().getUUID());
				else
					sender.getServer().getPlayerList().broadcastMessage(indeed, ChatType.SYSTEM, Util.NIL_UUID);
			}
		}

		return players.size();
	}

	private static int indeedSingle(CommandSourceStack sender) {

		TranslatableComponent indeed = new TranslatableComponent("sp.commands.indeed.display2", new Object[]{sender.getDisplayName()});
		indeed.withStyle(ChatFormatting.DARK_GREEN);
		if (sender.getEntity() != null)
			sender.getServer().getPlayerList().broadcastMessage(indeed, ChatType.CHAT, sender.getEntity().getUUID());
		else
			sender.getServer().getPlayerList().broadcastMessage(indeed, ChatType.SYSTEM, Util.NIL_UUID);

		return Command.SINGLE_SUCCESS;
	}
}
