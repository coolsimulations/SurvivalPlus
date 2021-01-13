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

public class CommandMourn {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("mourn")
				.then(CommandManager.argument("targets", EntityArgumentType.players())
						.requires(s -> s.hasPermissionLevel(0))
						.executes(mourn -> mourn(mourn.getSource(), EntityArgumentType.getPlayers(mourn, "targets")))));
	}

	private static int mourn(ServerCommandSource sender, Collection<ServerPlayerEntity> players) {
		Iterator var3 = players.iterator();

		while(var3.hasNext()) {
			ServerPlayerEntity entityplayer = (ServerPlayerEntity)var3.next();

			if(entityplayer == sender.getEntity()) {

				throw new CommandException(new TranslatableText("sp.commands.mourn.sameTarget"));

			}else {
				TranslatableText mourns = new TranslatableText("sp.commands.mourn.display", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				mourns.getStyle().setColor(Formatting.DARK_AQUA);
				sender.getMinecraftServer().getPlayerManager().sendToAll(mourns);
			}
		}

		return players.size();
	}
}
