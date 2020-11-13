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

public class CommandConfrats {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("confrats")
				.then(Commands.argument("targets", EntityArgument.players())
						.requires(s -> s.hasPermissionLevel(0))
						.executes(confrats -> confrats(confrats.getSource(), EntityArgument.getPlayers(confrats, "targets")))));
	}

	private static int confrats(CommandSource sender, Collection<ServerPlayerEntity> players) {
		Iterator var3 = players.iterator();

		while(var3.hasNext()) {
			ServerPlayerEntity entityplayer = (ServerPlayerEntity)var3.next();

			if(entityplayer == sender.getEntity()) {

				throw new CommandException(new TranslationTextComponent("sp.commands.confrats.sameTarget"));

			}else {
				TranslationTextComponent confrats = new TranslationTextComponent("sp.commands.confrats.display", new Object[] {entityplayer.getDisplayName(), sender.getDisplayName()});
				confrats.mergeStyle(TextFormatting.YELLOW);
				sender.getServer().getPlayerList().func_232641_a_(confrats, ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		}

		return players.size();
	}
}
