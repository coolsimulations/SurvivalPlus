package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.Util;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextFormatting;

import java.util.Collection;
import java.util.Iterator;

public class CommandMourn {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("mourn")
				.then(Commands.argument("targets", EntityArgument.players())
						.requires(s -> s.hasPermission(0))
						.executes(mourn -> mourn(mourn.getSource(), EntityArgument.getPlayers(mourn, "targets")))));
	}

	private static int mourn(CommandSource sender, Collection<ServerPlayerEntity> players) {
		Iterator var3 = players.iterator();

		while(var3.hasNext()) {
			ServerPlayerEntity entityplayer = (ServerPlayerEntity)var3.next();

			if(entityplayer == sender.getEntity()) {

				throw new CommandException(new TranslationTextComponent("sp.commands.mourn.sameTarget"));

			}else {
				TranslationTextComponent mourns = new TranslationTextComponent("sp.commands.mourn.display", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				mourns.withStyle(TextFormatting.DARK_AQUA);
				if (sender.getEntity() != null)
					sender.getServer().getPlayerList().broadcastMessage(mourns, ChatType.CHAT, sender.getEntity().getUUID());
				else
					sender.getServer().getPlayerList().broadcastMessage(mourns, ChatType.SYSTEM, Util.NIL_UUID);
			}
		}

		return players.size();
	}
}
