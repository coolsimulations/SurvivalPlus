package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

import java.util.Collection;
import java.util.Iterator;

public class CommandMourn {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("mourn")
				.then(Commands.argument("targets", EntityArgument.multiplePlayers())
						.requires(s -> s.hasPermissionLevel(0))
						.executes(mourn -> mourn(mourn.getSource(), EntityArgument.getPlayers(mourn, "targets")))));
	}

	private static int mourn(CommandSource sender, Collection<EntityPlayerMP> players) {
		Iterator var3 = players.iterator();

		while(var3.hasNext()) {
			EntityPlayerMP entityplayer = (EntityPlayerMP)var3.next();

			if(entityplayer == sender.getEntity()) {

				throw new CommandException(new TextComponentTranslation("sp.commands.mourn.sameTarget"));

			}else {
				TextComponentTranslation mourns = new TextComponentTranslation("sp.commands.mourn.display", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				mourns.getStyle().setColor(TextFormatting.DARK_AQUA);
				sender.getServer().getPlayerList().sendMessage(mourns);
			}
		}

		return players.size();
	}
}
