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

public class CommandMourn {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("mourn")
				.then(Commands.argument("targets", EntityArgument.players())
						.requires(s -> s.hasPermission(0))
						.executes(mourn -> mourn(mourn.getSource(), EntityArgument.getPlayers(mourn, "targets")))));
	}

	private static int mourn(CommandSourceStack sender, Collection<ServerPlayer> players) {
		Iterator<ServerPlayer> var3 = players.iterator();

		while(var3.hasNext()) {
			ServerPlayer entityplayer = (ServerPlayer)var3.next();

			if(entityplayer == sender.getEntity()) {

				throw new CommandRuntimeException(Component.translatable("sp.commands.mourn.sameTarget"));

			}else {
				MutableComponent mourns = Component.translatable("sp.commands.mourn.display", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				mourns.withStyle(ChatFormatting.DARK_AQUA);
				sender.getServer().getPlayerList().broadcastSystemMessage(mourns, false);
			}
		}

		return players.size();
	}
}
