package net.coolsimulations.SurvivalPlus.core.commands;

import java.util.Collection;
import java.util.Iterator;

import com.mojang.brigadier.CommandDispatcher;

import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandRuntimeException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;

public class CommandWak {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("wak")
				.then(Commands.argument("targets", EntityArgument.players())
						.requires(s -> s.hasPermission(getRequiredPermissionLevel()))
						.executes(wak -> wak(wak.getSource(), EntityArgument.getPlayers(wak, "targets")))));
	}

	private static int wak(CommandSourceStack sender, Collection<ServerPlayer> players) {
		Iterator<ServerPlayer> var3 = players.iterator();

		while(var3.hasNext()) {
			ServerPlayer entityplayer = (ServerPlayer)var3.next();

			if(entityplayer == sender.getEntity()) {

				throw new CommandRuntimeException(Component.translatable("sp.commands.wak.sameTarget"));

			}else {
				MutableComponent wak = Component.translatable("sp.commands.wak.display", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				wak.withStyle(ChatFormatting.DARK_RED);
				sender.getServer().getPlayerList().broadcastSystemMessage(wak, false);
			}
		}

		return players.size();
	}

	public static int getRequiredPermissionLevel() {

		if(SPConfig.opWak.get() > 4) {
			return 4;
		} else {
			return SPConfig.opWak.get();
		}
	}
}
