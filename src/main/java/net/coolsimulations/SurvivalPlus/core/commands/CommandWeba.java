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

public class CommandWeba {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("weba")
				.then(Commands.argument("targets", EntityArgument.players())
				.requires(s -> s.hasPermission(0))
				.executes(weba -> weba(weba.getSource(), EntityArgument.getPlayers(weba, "targets")))));
	}

	private static int weba(CommandSourceStack sender, Collection<ServerPlayer> players) {
		Iterator var3 = players.iterator();

		while(var3.hasNext()) {
			ServerPlayer entityplayer = (ServerPlayer)var3.next();

			if(entityplayer == sender.getEntity()) {

				throw new CommandRuntimeException(new TranslatableComponent("sp.commands.weba.sameTarget"));

			}else {
				TranslatableComponent weba = new TranslatableComponent("sp.commands.weba.display", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				weba.withStyle(ChatFormatting.GOLD);
				if (sender.getEntity() != null)
					sender.getServer().getPlayerList().broadcastMessage(weba, ChatType.CHAT, sender.getEntity().getUUID());
				else
					sender.getServer().getPlayerList().broadcastMessage(weba, ChatType.SYSTEM, Util.NIL_UUID);
			}
		}

		return players.size();
	}
}
