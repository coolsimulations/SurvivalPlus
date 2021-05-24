package net.coolsimulations.SurvivalPlus.core.commands;

import java.util.Collection;
import java.util.Iterator;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.minecraft.command.CommandException;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.MessageType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class CommandSleep {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("sleep")
				.then(CommandManager.argument("targets", EntityArgumentType.players())
						.requires(s -> s.hasPermissionLevel(0))
						.executes(sleep -> sleep(sleep.getSource(), EntityArgumentType.getPlayers(sleep, "targets")))));

		dispatcher.register(CommandManager.literal("sleep")
				.requires(s -> s.hasPermissionLevel(0))
				.executes(sleep -> sleepSingle(sleep.getSource())));
		
		dispatcher.register(CommandManager.literal("sloop")
				.then(CommandManager.argument("targets", EntityArgumentType.players())
						.requires(s -> s.hasPermissionLevel(0))
						.executes(sleep -> sleep(sleep.getSource(), EntityArgumentType.getPlayers(sleep, "targets")))));

		dispatcher.register(CommandManager.literal("sloop")
				.requires(s -> s.hasPermissionLevel(0))
				.executes(sleep -> sleepSingle(sleep.getSource())));
	}

	private static int sleep(ServerCommandSource sender, Collection<ServerPlayerEntity> players) {
		Iterator var3 = players.iterator();

		while (var3.hasNext()) {
			ServerPlayerEntity entityplayer = (ServerPlayerEntity) var3.next();

			TranslatableText dimension = null;
			if (!SPCompatibilityManager.isGCLoaded() && sender.getWorld().getRegistryKey() == World.OVERWORLD) {
				dimension = new TranslatableText("createWorld.customize.preset.overworld", new Object[]{});
			}

			if (sender.getWorld().getRegistryKey() == World.END) {
				throw new CommandException(new TranslatableText("sp.commands.sleep.invalid"));
			} else {
				if (!sender.getWorld().isDay()) {
					if (entityplayer == sender.getEntity()) {
						if (sender.getEntity() instanceof PlayerEntity && ((PlayerEntity) sender.getEntity()).isSleeping()) {

							if (dimension == null) {
								TranslatableText sleep = new TranslatableText("sp.commands.sleep.display3", new Object[]{sender.getDisplayName(), sender.getDisplayName(), sender.getWorld().getRegistryKey().getValue()});
								sleep.formatted(Formatting.LIGHT_PURPLE);
								sender.getMinecraftServer().getPlayerManager().broadcastChatMessage(sleep, MessageType.SYSTEM, Util.NIL_UUID);
							} else {
								TranslatableText sleep = new TranslatableText("sp.commands.sleep.display3", new Object[]{sender.getDisplayName(), dimension});
								sleep.formatted(Formatting.LIGHT_PURPLE);
								sender.getMinecraftServer().getPlayerManager().broadcastChatMessage(sleep, MessageType.SYSTEM, Util.NIL_UUID);
							}
						} else {
							throw new CommandException(new TranslatableText("sp.commands.sleep.display4", new Object[]{sender.getDisplayName(), dimension}));
						}
					} else {
						if (entityplayer.world.getDimension() == sender.getWorld().getDimension()) {

							if (sender.getWorld().getRegistryKey() == World.NETHER || sender.getWorld().getRegistryKey() == World.END) {
								throw new CommandException(new TranslatableText("sp.commands.sleep.invalid"));
							} else {
								if (dimension == null) {
									TranslatableText sleep = new TranslatableText("sp.commands.sleep.display1", new Object[]{entityplayer.getDisplayName(), sender.getDisplayName(), sender.getWorld().getRegistryKey().getValue()});
									sleep.formatted(Formatting.LIGHT_PURPLE);
									sender.getMinecraftServer().getPlayerManager().broadcastChatMessage(sleep, MessageType.SYSTEM, Util.NIL_UUID);
								} else {
									TranslatableText sleep = new TranslatableText("sp.commands.sleep.display1", new Object[]{entityplayer.getDisplayName(), sender.getDisplayName(), dimension});
									sleep.formatted(Formatting.LIGHT_PURPLE);
									sender.getMinecraftServer().getPlayerManager().broadcastChatMessage(sleep, MessageType.SYSTEM, Util.NIL_UUID);
								}
							}
						} else {
							throw new CommandException(new TranslatableText("sp.commands.sleep.dimension"));
						}
					}
				} else {
					throw new CommandException(new TranslatableText("sp.commands.sleep.night"));
				}
			}
		}

		return players.size();
	}

	private static int sleepSingle(ServerCommandSource sender) {

		TranslatableText dimension = null;
		if(!SPCompatibilityManager.isGCLoaded() && sender.getWorld().getRegistryKey() == World.OVERWORLD) {
			dimension = new TranslatableText("createWorld.customize.preset.overworld", new Object[] {});
		}

		if(sender.getWorld().getRegistryKey() == World.END) {
			throw new CommandException(new TranslatableText("sp.commands.sleep.invalid"));
		} else {
			if (!sender.getWorld().isDay()) {

				if (sender.getWorld().getRegistryKey() == World.NETHER) {
					throw new CommandException(new TranslatableText("sp.commands.sleep.invalid"));
				} else {
					if (dimension == null) {
						TranslatableText sleep = new TranslatableText("sp.commands.sleep.display2", new Object[]{sender.getDisplayName(), sender.getWorld().getRegistryKey().getValue()});
						sleep.formatted(Formatting.LIGHT_PURPLE);
						sender.getMinecraftServer().getPlayerManager().broadcastChatMessage(sleep, MessageType.SYSTEM, Util.NIL_UUID);
					} else {
						TranslatableText sleep = new TranslatableText("sp.commands.sleep.display2", new Object[]{sender.getDisplayName(), dimension});
						sleep.formatted(Formatting.LIGHT_PURPLE);
						sender.getMinecraftServer().getPlayerManager().broadcastChatMessage(sleep, MessageType.SYSTEM, Util.NIL_UUID);
					}
				}
			} else {
				throw new CommandException(new TranslatableText("sp.commands.sleep.night"));
			}
		}

		return Command.SINGLE_SUCCESS;
	}
}
