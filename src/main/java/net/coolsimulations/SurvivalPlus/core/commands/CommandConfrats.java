package net.coolsimulations.SurvivalPlus.core.commands;

import java.util.Collection;
import java.util.Iterator;

import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandRuntimeException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;

public class CommandConfrats {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("confrats")
				.then(Commands.argument("targets", EntityArgument.players())
						.requires(s -> s.hasPermission(0))
						.executes(confrats -> confrats(confrats.getSource(), EntityArgument.getPlayers(confrats, "targets")))));
	}

	private static int confrats(CommandSourceStack sender, Collection<ServerPlayer> players) {
		Iterator<ServerPlayer> var3 = players.iterator();

		while(var3.hasNext()) {
			ServerPlayer entityplayer = (ServerPlayer)var3.next();

			if(entityplayer == sender.getEntity()) {

				throw new CommandRuntimeException(Component.translatable("sp.commands.confrats.sameTarget"));

			} else {
				MutableComponent confrats = Component.translatable("sp.commands.confrats.display", new Object[] {entityplayer.getDisplayName(), sender.getDisplayName()});
				confrats.withStyle(ChatFormatting.YELLOW);
				sender.getServer().getPlayerList().broadcastSystemMessage(confrats, false);
			}
		}

		return players.size();
	}
}
