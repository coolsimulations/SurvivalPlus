package net.coolsimulations.SurvivalPlus.core.commands;

import java.util.Collection;
import java.util.Iterator;

import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.command.CommandException;
import net.minecraft.command.arguments.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class CommandConfrats {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("confrats")
				.then(CommandManager.argument("targets", EntityArgumentType.players())
						.requires(s -> s.hasPermissionLevel(0))
						.executes(confrats -> confrats(confrats.getSource(), EntityArgumentType.getPlayers(confrats, "targets")))));
	}

	private static int confrats(ServerCommandSource sender, Collection<ServerPlayerEntity> players) {
		Iterator var3 = players.iterator();

		while(var3.hasNext()) {
			ServerPlayerEntity entityplayer = (ServerPlayerEntity)var3.next();

			if(entityplayer == sender.getEntity()) {

				throw new CommandException(new TranslatableText("sp.commands.confrats.sameTarget"));

			}else {
				TranslatableText confrats = new TranslatableText("sp.commands.confrats.display", new Object[] {entityplayer.getDisplayName(), sender.getDisplayName()});
				confrats.getStyle().setColor(Formatting.YELLOW);
				sender.getMinecraftServer().getPlayerManager().sendToAll(confrats);
			}
		}

		return players.size();
	}
}
