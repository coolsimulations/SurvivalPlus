package net.coolsimulations.SurvivalPlus.core.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.dimension.DimensionType;

import java.util.Collection;
import java.util.Iterator;

public class CommandSleep {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("sleep")
				.then(Commands.argument("targets", EntityArgument.multiplePlayers())
						.requires(s -> s.hasPermissionLevel(0))
						.executes(sleep -> sleep(sleep.getSource(), EntityArgument.getPlayers(sleep, "targets")))));

		dispatcher.register(Commands.literal("sleep")
				.requires(s -> s.hasPermissionLevel(0))
				.executes(sleep -> sleepSingle(sleep.getSource())));
	}

	private static int sleep(CommandSource sender, Collection<EntityPlayerMP> players) {
		Iterator var3 = players.iterator();

		while (var3.hasNext()) {
			EntityPlayerMP entityplayer = (EntityPlayerMP) var3.next();

			TextComponentTranslation dimension = null;
			if (!SPCompatibilityManager.isGCLoaded() && sender.getWorld().dimension.getType() == DimensionType.OVERWORLD) {
				dimension = new TextComponentTranslation("createWorld.customize.preset.overworld", new Object[]{});
			}

			if (sender.getWorld().dimension.getType() == DimensionType.THE_END) {
				throw new CommandException(new TextComponentTranslation("sp.commands.sleep.invalid"));
			} else {
				if (!sender.getWorld().isDaytime()) {
					if (entityplayer == sender.getEntity()) {
						if (sender.getEntity() instanceof EntityPlayer && ((EntityPlayer) sender.getEntity()).isPlayerSleeping()) {

							if (dimension == null) {
								TextComponentTranslation sleep = new TextComponentTranslation("sp.commands.sleep.display3", new Object[]{sender.getDisplayName(), sender.getDisplayName(), sender.getWorld().getDimension().getType().getId()});
								sleep.getStyle().setColor(TextFormatting.LIGHT_PURPLE);
								sender.getServer().getPlayerList().sendMessage(sleep);
							} else {
								TextComponentTranslation sleep = new TextComponentTranslation("sp.commands.sleep.display3", new Object[]{sender.getDisplayName(), dimension});
								sleep.getStyle().setColor(TextFormatting.LIGHT_PURPLE);
								sender.getServer().getPlayerList().sendMessage(sleep);
							}
						} else {
							throw new CommandException(new TextComponentTranslation("sp.commands.sleep.display4", new Object[]{sender.getDisplayName(), dimension}));
						}
					} else {
						if (entityplayer.world.getDimension() == sender.getWorld().getDimension()) {

							if (sender.getWorld().dimension.isNether() || sender.getWorld().dimension.getType() == DimensionType.THE_END) {
								throw new CommandException(new TextComponentTranslation("sp.commands.sleep.invalid"));
							} else {
								if (dimension == null) {
									TextComponentTranslation sleep = new TextComponentTranslation("sp.commands.sleep.display1", new Object[]{entityplayer.getDisplayName(), sender.getDisplayName(), sender.getWorld().getDimension().getType().getId()});
									sleep.getStyle().setColor(TextFormatting.LIGHT_PURPLE);
									sender.getServer().getPlayerList().sendMessage(sleep);
								} else {
									TextComponentTranslation sleep = new TextComponentTranslation("sp.commands.sleep.display1", new Object[]{entityplayer.getDisplayName(), sender.getDisplayName(), dimension});
									sleep.getStyle().setColor(TextFormatting.LIGHT_PURPLE);
									sender.getServer().getPlayerList().sendMessage(sleep);
								}
							}
						} else {
							throw new CommandException(new TextComponentTranslation("sp.commands.sleep.dimension"));
						}
					}
				} else {
					throw new CommandException(new TextComponentTranslation("sp.commands.sleep.night"));
				}
			}
		}

		return players.size();
	}

	private static int sleepSingle(CommandSource sender) {

		TextComponentTranslation dimension = null;
		if(!SPCompatibilityManager.isGCLoaded() && sender.getWorld().dimension.getType() == DimensionType.OVERWORLD) {
			dimension = new TextComponentTranslation("createWorld.customize.preset.overworld", new Object[] {});
		}

		if(sender.getWorld().dimension.getType() == DimensionType.THE_END) {
			throw new CommandException(new TextComponentTranslation("sp.commands.sleep.invalid"));
		} else {
			if (!sender.getWorld().isDaytime()) {

				if (sender.getWorld().dimension.isNether()) {
					throw new CommandException(new TextComponentTranslation("sp.commands.sleep.invalid"));
				} else {
					if (dimension == null) {
						TextComponentTranslation sleep = new TextComponentTranslation("sp.commands.sleep.display2", new Object[]{sender.getDisplayName(), sender.getWorld().getDimension().getType().getId()});
						sleep.getStyle().setColor(TextFormatting.LIGHT_PURPLE);
						sender.getServer().getPlayerList().sendMessage(sleep);
					} else {
						TextComponentTranslation sleep = new TextComponentTranslation("sp.commands.sleep.display2", new Object[]{sender.getDisplayName(), dimension});
						sleep.getStyle().setColor(TextFormatting.LIGHT_PURPLE);
						sender.getServer().getPlayerList().sendMessage(sleep);
					}
				}
			} else {
				throw new CommandException(new TextComponentTranslation("sp.commands.sleep.night"));
			}
		}

		return Command.SINGLE_SUCCESS;
	}
}
