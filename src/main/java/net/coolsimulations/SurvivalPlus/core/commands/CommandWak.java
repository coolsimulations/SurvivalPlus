package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

import java.util.Collection;
import java.util.Iterator;

public class CommandWak {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("wak")
				.then(Commands.argument("targets", EntityArgument.multiplePlayers())
						.requires(s -> s.hasPermissionLevel(getRequiredPermissionLevel()))
						.executes(wak -> wak(wak.getSource(), EntityArgument.getPlayers(wak, "targets")))));
	}

	private static int wak(CommandSource sender, Collection<EntityPlayerMP> players) {
		Iterator var3 = players.iterator();

		while(var3.hasNext()) {
			EntityPlayerMP entityplayer = (EntityPlayerMP)var3.next();

			if(entityplayer == sender.getEntity()) {

				throw new CommandException(new TextComponentTranslation("sp.commands.wak.sameTarget"));

			}else {
				TextComponentTranslation wak = new TextComponentTranslation("sp.commands.wak.display", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				wak.getStyle().setColor(TextFormatting.DARK_RED);
				sender.getServer().getPlayerList().sendMessage(wak);
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
