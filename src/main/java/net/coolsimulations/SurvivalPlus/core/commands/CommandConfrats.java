package net.coolsimulations.SurvivalPlus.core.commands;

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

				throw new CommandRuntimeException(new TranslatableComponent("sp.commands.confrats.sameTarget"));

			}else {
				TranslatableComponent confrats = new TranslatableComponent("sp.commands.confrats.display", new Object[] {entityplayer.getDisplayName(), sender.getDisplayName()});
				confrats.withStyle(ChatFormatting.YELLOW);
				if (sender.getEntity() != null)
					sender.getServer().getPlayerList().broadcastMessage(confrats, ChatType.CHAT, sender.getEntity().getUUID());
				else
					sender.getServer().getPlayerList().broadcastMessage(confrats, ChatType.SYSTEM, Util.NIL_UUID);
			}
		}

		return players.size();
	}
}
