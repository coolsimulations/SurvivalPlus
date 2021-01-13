package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class CommandSmiley {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal(":)")
				.requires(s -> s.hasPermissionLevel(0))
				.executes(smiley -> smiley(smiley.getSource())));
	}

	private static int smiley(ServerCommandSource sender) {

		TranslatableText smiley = new TranslatableText("sp.commands.smiley.display", new Object[] {sender.getDisplayName()});
		smiley.getStyle().setColor(Formatting.GREEN);
		sender.getMinecraftServer().getPlayerManager().sendToAll(smiley);

		return Command.SINGLE_SUCCESS;
	}
}
