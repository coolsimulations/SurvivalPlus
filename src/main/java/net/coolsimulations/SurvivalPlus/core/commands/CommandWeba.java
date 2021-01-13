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

public class CommandWeba {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("weba")
				.then(CommandManager.argument("targets", EntityArgumentType.players())
				.requires(s -> s.hasPermissionLevel(0))
				.executes(weba -> weba(weba.getSource(), EntityArgumentType.getPlayers(weba, "targets")))));
	}

	private static int weba(ServerCommandSource sender, Collection<ServerPlayerEntity> players) {
		Iterator var3 = players.iterator();

		while(var3.hasNext()) {
			ServerPlayerEntity entityplayer = (ServerPlayerEntity)var3.next();

			if(entityplayer == sender.getEntity()) {

				throw new CommandException(new TranslatableText("sp.commands.weba.sameTarget"));

			}else {
				TranslatableText weba = new TranslatableText("sp.commands.weba.display", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				weba.getStyle().setColor(Formatting.GOLD);
				sender.getMinecraftServer().getPlayerManager().sendToAll(weba);
			}
		}

		return players.size();
	}
}
