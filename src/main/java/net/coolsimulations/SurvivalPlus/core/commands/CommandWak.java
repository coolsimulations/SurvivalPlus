package net.coolsimulations.SurvivalPlus.core.commands;

import java.util.Collection;
import java.util.Iterator;

import com.mojang.brigadier.CommandDispatcher;

import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.minecraft.command.CommandException;
import net.minecraft.command.arguments.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class CommandWak {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("wak")
				.then(CommandManager.argument("targets", EntityArgumentType.players())
						.requires(s -> s.hasPermissionLevel(getRequiredPermissionLevel()))
						.executes(wak -> wak(wak.getSource(), EntityArgumentType.getPlayers(wak, "targets")))));
	}

	private static int wak(ServerCommandSource sender, Collection<ServerPlayerEntity> players) {
		Iterator var3 = players.iterator();

		while(var3.hasNext()) {
			ServerPlayerEntity entityplayer = (ServerPlayerEntity)var3.next();

			if(entityplayer == sender.getEntity()) {

				throw new CommandException(new TranslatableText("sp.commands.wak.sameTarget"));

			}else {
				TranslatableText wak = new TranslatableText("sp.commands.wak.display", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				wak.getStyle().setColor(Formatting.DARK_RED);
				sender.getMinecraftServer().getPlayerManager().sendToAll(wak);
			}
		}

		return players.size();
	}

	public static int getRequiredPermissionLevel() {

		if(SPConfig.opWak > 4) {
			return 4;
		} else {
			return SPConfig.opWak;
		}
	}
}
