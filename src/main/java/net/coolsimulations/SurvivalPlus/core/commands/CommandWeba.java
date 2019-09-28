package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.TextFormatting;

import java.util.Collection;
import java.util.Iterator;

public class CommandWeba {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("weba")
				.then(Commands.argument("targets", EntityArgument.players())
				.requires(s -> s.hasPermissionLevel(0))
				.executes(weba -> weba(weba.getSource(), EntityArgument.getPlayers(weba, "targets")))));
	}

	private static int weba(CommandSource sender, Collection<ServerPlayerEntity> players) {
		Iterator var3 = players.iterator();

		while(var3.hasNext()) {
			ServerPlayerEntity entityplayer = (ServerPlayerEntity)var3.next();

			if(entityplayer == sender.getEntity()) {

				throw new CommandException(new TranslationTextComponent("sp.commands.weba.sameTarget"));

			}else {
				TranslationTextComponent weba = new TranslationTextComponent("sp.commands.weba.display", new Object[]{sender.getDisplayName(), entityplayer.getDisplayName()});
				weba.getStyle().setColor(TextFormatting.GOLD);
				sender.getServer().getPlayerList().sendMessage(weba);
			}
		}

		return players.size();
	}
}
