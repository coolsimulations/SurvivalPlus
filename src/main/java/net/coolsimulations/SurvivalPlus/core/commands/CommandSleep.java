package net.coolsimulations.SurvivalPlus.core.commands;

import java.util.Collection;
import java.util.Iterator;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.minecraft.command.CommandException;
import net.minecraft.command.arguments.EntityArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
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
			if (!SPCompatibilityManager.isGCLoaded() && sender.getWorld().dimension.getType() == DimensionType.OVERWORLD) {
				dimension = new TranslatableText("createWorld.customize.preset.overworld", new Object[]{});
			}

			if (sender.getWorld().dimension.getType() == DimensionType.THE_END) {
				throw new CommandException(new TranslatableText("sp.commands.sleep.invalid"));
			} else {
				if (!sender.getWorld().isDay()) {
					if (entityplayer == sender.getEntity()) {
						if (sender.getEntity() instanceof PlayerEntity && ((PlayerEntity) sender.getEntity()).isSleeping()) {

							if (dimension == null) {
								TranslatableText sleep = new TranslatableText("sp.commands.sleep.display3", new Object[]{sender.getDisplayName(), sender.getDisplayName(), sender.getWorld().getDimension().getType().getRawId()});
								sleep.getStyle().setColor(Formatting.LIGHT_PURPLE);
								sender.getMinecraftServer().getPlayerManager().sendToAll(sleep);
							} else {
								TranslatableText sleep = new TranslatableText("sp.commands.sleep.display3", new Object[]{sender.getDisplayName(), dimension});
								sleep.getStyle().setColor(Formatting.LIGHT_PURPLE);
								sender.getMinecraftServer().getPlayerManager().sendToAll(sleep);
							}
						} else {
							throw new CommandException(new TranslatableText("sp.commands.sleep.display4", new Object[]{sender.getDisplayName(), dimension}));
						}
					} else {
						if (entityplayer.world.getDimension() == sender.getWorld().getDimension()) {

							if (sender.getWorld().dimension.isNether() || sender.getWorld().dimension.getType() == DimensionType.THE_END) {
								throw new CommandException(new TranslatableText("sp.commands.sleep.invalid"));
							} else {
								if (dimension == null) {
									TranslatableText sleep = new TranslatableText("sp.commands.sleep.display1", new Object[]{entityplayer.getDisplayName(), sender.getDisplayName(), sender.getWorld().getDimension().getType().getRawId()});
									sleep.getStyle().setColor(Formatting.LIGHT_PURPLE);
									sender.getMinecraftServer().getPlayerManager().sendToAll(sleep);
								} else {
									TranslatableText sleep = new TranslatableText("sp.commands.sleep.display1", new Object[]{entityplayer.getDisplayName(), sender.getDisplayName(), dimension});
									sleep.getStyle().setColor(Formatting.LIGHT_PURPLE);
									sender.getMinecraftServer().getPlayerManager().sendToAll(sleep);
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
		if(!SPCompatibilityManager.isGCLoaded() && sender.getWorld().dimension.getType() == DimensionType.OVERWORLD) {
			dimension = new TranslatableText("createWorld.customize.preset.overworld", new Object[] {});
		}

		if(sender.getWorld().dimension.getType() == DimensionType.THE_END) {
			throw new CommandException(new TranslatableText("sp.commands.sleep.invalid"));
		} else {
			if (!sender.getWorld().isDay()) {

				if (sender.getWorld().dimension.isNether()) {
					throw new CommandException(new TranslatableText("sp.commands.sleep.invalid"));
				} else {
					if (dimension == null) {
						TranslatableText sleep = new TranslatableText("sp.commands.sleep.display2", new Object[]{sender.getDisplayName(), sender.getWorld().getDimension().getType().getRawId()});
						sleep.getStyle().setColor(Formatting.LIGHT_PURPLE);
						sender.getMinecraftServer().getPlayerManager().sendToAll(sleep);
					} else {
						TranslatableText sleep = new TranslatableText("sp.commands.sleep.display2", new Object[]{sender.getDisplayName(), dimension});
						sleep.getStyle().setColor(Formatting.LIGHT_PURPLE);
						sender.getMinecraftServer().getPlayerManager().sendToAll(sleep);
					}
				}
			} else {
				throw new CommandException(new TranslatableText("sp.commands.sleep.night"));
			}
		}

		return Command.SINGLE_SUCCESS;
	}
}
