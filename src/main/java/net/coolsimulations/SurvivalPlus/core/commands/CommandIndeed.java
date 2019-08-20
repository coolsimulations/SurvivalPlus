package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
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

public class CommandIndeed {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("indeed")
				.then(Commands.argument("targets", EntityArgument.multiplePlayers())
						.requires(s -> s.hasPermissionLevel(0))
						.executes(indeed -> indeed(indeed.getSource(), EntityArgument.getPlayers(indeed, "targets")))));

		dispatcher.register(Commands.literal("indeed")
				.requires(s -> s.hasPermissionLevel(0))
				.executes(indeed -> indeedSingle(indeed.getSource())));
	}

	private static int indeed(CommandSource sender, Collection<EntityPlayerMP> players) {
		Iterator var3 = players.iterator();

		while (var3.hasNext()) {
			EntityPlayerMP entityplayer = (EntityPlayerMP) var3.next();

			if (entityplayer == sender.getEntity()) {

				throw new CommandException(new TextComponentTranslation("sp.commands.indeed.sameTarget"));

			} else {
				TextComponentTranslation indeed = new TextComponentTranslation("sp.commands.indeed.display1", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				indeed.getStyle().setColor(TextFormatting.DARK_GREEN);
				sender.getServer().getPlayerList().sendMessage(indeed);
			}
		}

		return players.size();
	}

	private static int indeedSingle(CommandSource sender) {

		TextComponentTranslation indeed = new TextComponentTranslation("sp.commands.indeed.display2", new Object[]{sender.getDisplayName()});
		indeed.getStyle().setColor(TextFormatting.DARK_GREEN);
		sender.getServer().getPlayerList().sendMessage(indeed);

		return Command.SINGLE_SUCCESS;
	}
}
