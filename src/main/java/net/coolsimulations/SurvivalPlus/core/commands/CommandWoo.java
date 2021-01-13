package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class CommandWoo {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("woo")
		.requires(s -> s.hasPermissionLevel(0))
		.executes(woo -> woo(woo.getSource())));
	}

	private static int woo(ServerCommandSource sender) {

		TranslatableText woo = new TranslatableText("sp.commands.woo.display", new Object[] {sender.getDisplayName()});
		woo.getStyle().setColor(Formatting.BLUE);
		sender.getMinecraftServer().getPlayerManager().sendToAll(woo);

		return Command.SINGLE_SUCCESS;
	}
}
