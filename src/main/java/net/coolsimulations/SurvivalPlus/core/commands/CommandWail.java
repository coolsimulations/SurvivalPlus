package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class CommandWail {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("wail")
				.requires(s -> s.hasPermissionLevel(0))
				.executes(wail -> wail(wail.getSource())));
	}

	private static int wail(ServerCommandSource sender) {

		TranslatableText wail = new TranslatableText("sp.commands.wail.display", new Object[] {sender.getDisplayName()});
		wail.getStyle().setColor(Formatting.AQUA);
		sender.getMinecraftServer().getPlayerManager().sendToAll(wail);

		return Command.SINGLE_SUCCESS;
	}
}
