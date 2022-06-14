package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.PlayerChatMessage;

public class CommandSmiley {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal(":)")
				.requires(s -> s.hasPermission(0))
				.executes(smiley -> smiley(smiley.getSource())));
	}

	private static int smiley(CommandSourceStack sender) {

		MutableComponent smiley = Component.translatable("sp.commands.smiley.display", new Object[] {sender.getDisplayName()});
		smiley.withStyle(ChatFormatting.GREEN);
		if (sender.getEntity() != null)
			sender.getServer().getPlayerList().broadcastChatMessage(PlayerChatMessage.signed(smiley, sender.getSigningContext().getArgumentSignature("action")), sender.getEntity().asChatSender(), ChatType.SYSTEM);
		else
			sender.getServer().getPlayerList().broadcastSystemMessage(smiley, ChatType.SYSTEM);

		return Command.SINGLE_SUCCESS;
	}
}
