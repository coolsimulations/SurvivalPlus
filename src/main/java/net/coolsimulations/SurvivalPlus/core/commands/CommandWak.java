package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
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

public class CommandWak {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("wak")
				.then(Commands.argument("targets", EntityArgument.players())
						.requires(s -> s.hasPermission(getRequiredPermissionLevel()))
						.executes(wak -> wak(wak.getSource(), EntityArgument.getPlayers(wak, "targets")))));
	}

	private static int wak(CommandSourceStack sender, Collection<ServerPlayer> players) {
		Iterator var3 = players.iterator();

		while(var3.hasNext()) {
			ServerPlayer entityplayer = (ServerPlayer)var3.next();

			if(entityplayer == sender.getEntity()) {

				throw new CommandRuntimeException(new TranslatableComponent("sp.commands.wak.sameTarget"));

			}else {
				TranslatableComponent wak = new TranslatableComponent("sp.commands.wak.display", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				wak.withStyle(ChatFormatting.DARK_RED);
				if (sender.getEntity() != null)
					sender.getServer().getPlayerList().broadcastMessage(wak, ChatType.CHAT, sender.getEntity().getUUID());
				else
					sender.getServer().getPlayerList().broadcastMessage(wak, ChatType.SYSTEM, Util.NIL_UUID);
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
