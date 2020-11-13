package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
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

public class CommandIndeed {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("indeed")
				.then(Commands.argument("targets", EntityArgument.players())
						.requires(s -> s.hasPermissionLevel(0))
						.executes(indeed -> indeed(indeed.getSource(), EntityArgument.getPlayers(indeed, "targets")))));

		dispatcher.register(Commands.literal("indeed")
				.requires(s -> s.hasPermissionLevel(0))
				.executes(indeed -> indeedSingle(indeed.getSource())));
	}

	private static int indeed(CommandSource sender, Collection<ServerPlayerEntity> players) {
		Iterator var3 = players.iterator();

		while (var3.hasNext()) {
			ServerPlayerEntity entityplayer = (ServerPlayerEntity) var3.next();

			if (entityplayer == sender.getEntity()) {

				throw new CommandException(new TranslationTextComponent("sp.commands.indeed.sameTarget"));

			} else {
				TranslationTextComponent indeed = new TranslationTextComponent("sp.commands.indeed.display1", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				indeed.mergeStyle(TextFormatting.DARK_GREEN);
				sender.getServer().getPlayerList().func_232641_a_(indeed, ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		}

		return players.size();
	}

	private static int indeedSingle(CommandSource sender) {

		TranslationTextComponent indeed = new TranslationTextComponent("sp.commands.indeed.display2", new Object[]{sender.getDisplayName()});
		indeed.mergeStyle(TextFormatting.DARK_GREEN);
		sender.getServer().getPlayerList().func_232641_a_(indeed, ChatType.SYSTEM, Util.DUMMY_UUID);

		return Command.SINGLE_SUCCESS;
	}
}
