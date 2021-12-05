package net.coolsimulations.SurvivalPlus.core.commands;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

import com.gildedgames.the_aether.AetherConfig;
import com.mjr.extraplanets.Config;

import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.planets.asteroids.ConfigManagerAsteroids;
import micdoodle8.mods.galacticraft.planets.mars.ConfigManagerMars;
import micdoodle8.mods.galacticraft.planets.venus.ConfigManagerVenus;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class CommandSleep extends CommandBase{
	
	@Override
	public String getName() {
		
		return "sleep";
	}
	
	@Override
	public List<String> getAliases()
    {
        return Collections.singletonList("sloop");
    }

	@Override
	public String getUsage(ICommandSender sender) {
		
		return "sp.commands.sleep.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
    	
		TextComponentTranslation dimension = null;
		if(!SPCompatibilityManager.isGCLoaded() && sender.getCommandSenderEntity().world.provider.getDimension() == 0) {
    		dimension = new TextComponentTranslation("createWorld.customize.preset.overworld", new Object[] {});
    	}
    	if(SPCompatibilityManager.isGCLoaded() && sender.getCommandSenderEntity().world.provider.getDimension() == ConfigManagerCore.idDimensionOverworld) {
    		dimension = new TextComponentTranslation("dimension.overworld.name", new Object[] {});
    	}
    	
    	if(SPCompatibilityManager.isGCLoaded()) {
    		if(sender.getCommandSenderEntity().world.provider.getDimension() == ConfigManagerCore.idDimensionMoon) {
    			dimension = new TextComponentTranslation("dimension.moon.name", new Object[] {});
    		}
    	}
    	
    	if(SPCompatibilityManager.isGCPLoaded()) {
    		if(sender.getCommandSenderEntity().world.provider.getDimension() == ConfigManagerMars.dimensionIDMars) {
    			dimension = new TextComponentTranslation("planet.mars", new Object[] {});
    		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == ConfigManagerAsteroids.dimensionIDAsteroids) {
    			dimension = new TextComponentTranslation("planet.asteroids", new Object[] {});
    		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == ConfigManagerVenus.dimensionIDVenus) {
    			dimension = new TextComponentTranslation("Venus", new Object[] {});
    		}
    		
    		if(SPCompatibilityManager.isExtraPlanetsLoaded()) {
    			if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.CALLISTO_ID) {
        			dimension = new TextComponentTranslation("moon.callisto", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.CERES_ID) {
        			dimension = new TextComponentTranslation("planet.Ceres", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.DEIMOS_ID) {
        			dimension = new TextComponentTranslation("moon.deimos", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.ERIS_ID) {
        			dimension = new TextComponentTranslation("planet.Eris", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.EUROPA_ID) {
        			dimension = new TextComponentTranslation("moon.europa", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.GANYMEDE_ID) {
        			dimension = new TextComponentTranslation("moon.ganymede", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.IAPETUS_ID) {
        			dimension = new TextComponentTranslation("moon.iapetus", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.IO_ID) {
        			dimension = new TextComponentTranslation("moon.io", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.JUPITER_ID) {
        			dimension = new TextComponentTranslation("planet.Juptier", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.KEPLER22B_ID) {
        			dimension = new TextComponentTranslation("planet.kepler22b", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.MERCURY_ID) {
        			dimension = new TextComponentTranslation("planet.Mercury", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.NEPTUNE_ID) {
        			dimension = new TextComponentTranslation("planet.Neptune", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.OBERON_ID) {
        			dimension = new TextComponentTranslation("moon.oberon", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.PHOBOS_ID) {
        			dimension = new TextComponentTranslation("moon.phobos", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.PLUTO_ID) {
        			dimension = new TextComponentTranslation("planet.Pluto", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.RHEA_ID) {
        			dimension = new TextComponentTranslation("moon.rhea", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.SATURN_ID) {
        			dimension = new TextComponentTranslation("planet.Saturn", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.TITAN_ID) {
        			dimension = new TextComponentTranslation("moon.titan", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.TITANIA_ID) {
        			dimension = new TextComponentTranslation("moon.titania", new Object[] {});
        		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.TRITON_ID) {
         			dimension = new TextComponentTranslation("moon.triton", new Object[] {});
         		} else if(sender.getCommandSenderEntity().world.provider.getDimension() == Config.URANUS_ID) {
         			dimension = new TextComponentTranslation("planet.Uranus", new Object[] {});
         		}
    		}
    	}
    	
    	if(SPCompatibilityManager.isAetherLegacyLoaded()) {
    		if(sender.getCommandSenderEntity().world.provider.getDimension() == AetherConfig.dimension.aether_dimension_id) {
    			dimension = new TextComponentTranslation("The Aether", new Object[] {});
    		}
    	}
		
		if (args.length >= 2)
        {
            throw new WrongUsageException("sp.commands.sleep.usage", new Object[0]);
        }
        else if(args.length == 1)
        {
        	if(sender.getCommandSenderEntity().world.provider.getDimension() == 1){
        		TextComponentTranslation invalid = new TextComponentTranslation("sp.commands.sleep.invalid", new Object[] {});
    			invalid.getStyle().setColor(TextFormatting.RED);
    			sender.sendMessage(invalid);
        		
        	} else {
        		if(!sender.getCommandSenderEntity().world.provider.isDaytime()) {
        			Entity entityplayer = getEntity(server, sender, args[0]);
        			EntityPlayer player = this.getPlayer(server, sender, args[0]);
        			if (entityplayer == sender)
        			{
        				if(sender instanceof EntityPlayer && player.isPlayerSleeping()) {
        				
        					if(dimension == null) {
        						TextComponentTranslation sleep = new TextComponentTranslation("sp.commands.sleep.display3", new Object[] {sender.getDisplayName(), sender.getCommandSenderEntity().world.provider.getDimension()});
								sleep.getStyle().setColor(TextFormatting.LIGHT_PURPLE);
								server.getPlayerList().sendMessage(sleep);
        					}
        					else {
        						TextComponentTranslation sleep = new TextComponentTranslation("sp.commands.sleep.display3", new Object[] {sender.getDisplayName(), dimension});
								sleep.getStyle().setColor(TextFormatting.LIGHT_PURPLE);
								server.getPlayerList().sendMessage(sleep);
        					}
        				} else {
        					TextComponentTranslation sleep = new TextComponentTranslation("sp.commands.sleep.display4", new Object[] {sender.getDisplayName(), dimension});
							sleep.getStyle().setColor(TextFormatting.RED);
							sender.sendMessage(sleep);
        				}
        			}else {
        				if(entityplayer.world.provider.getDimension() == sender.getCommandSenderEntity().world.provider.getDimension()) {
        				
        					if(sender.getCommandSenderEntity().world.provider.getDimension() == -1 || sender.getCommandSenderEntity().world.provider.getDimension() == 1) {
        						TextComponentTranslation invalid = new TextComponentTranslation("sp.commands.sleep.invalid", new Object[] {});
        						invalid.getStyle().setColor(TextFormatting.RED);
        						sender.sendMessage(invalid);
        					} else {
        						if(dimension == null) {
        							TextComponentTranslation sleep = new TextComponentTranslation("sp.commands.sleep.display1", new Object[] {entityplayer.getDisplayName(), sender.getDisplayName(), sender.getCommandSenderEntity().world.provider.getDimension()});
        							sleep.getStyle().setColor(TextFormatting.LIGHT_PURPLE);
        							server.getPlayerList().sendMessage(sleep);
        						} else {
        							TextComponentTranslation sleep = new TextComponentTranslation("sp.commands.sleep.display1", new Object[] {entityplayer.getDisplayName(), sender.getDisplayName(), dimension});
        							sleep.getStyle().setColor(TextFormatting.LIGHT_PURPLE);
        							server.getPlayerList().sendMessage(sleep);
        						}
        					}
        				} else{
        					TextComponentTranslation invalid = new TextComponentTranslation("sp.commands.sleep.dimension", new Object[] {});
    						invalid.getStyle().setColor(TextFormatting.RED);
    						sender.sendMessage(invalid);
        				}
        			}
        		} else {
        			TextComponentTranslation invalid = new TextComponentTranslation("sp.commands.sleep.night", new Object[] {});
        			invalid.getStyle().setColor(TextFormatting.RED);
        			sender.sendMessage(invalid);
        		}
        	}
        }
        else
        {
        	if(sender.getCommandSenderEntity().world.provider.getDimension() == 1){
        		TextComponentTranslation invalid = new TextComponentTranslation("sp.commands.sleep.invalid", new Object[] {});
    			invalid.getStyle().setColor(TextFormatting.RED);
    			sender.sendMessage(invalid);
        		
        	} else {
        		if(!sender.getCommandSenderEntity().world.provider.isDaytime()) {
        		
        			if(sender.getCommandSenderEntity().world.provider.getDimension() == -1 || sender.getCommandSenderEntity().world.provider.getDimension() == 1) {
        				TextComponentTranslation invalid = new TextComponentTranslation("sp.commands.sleep.invalid", new Object[] {});
        				invalid.getStyle().setColor(TextFormatting.RED);
        				sender.sendMessage(invalid);
        			} else
        			{
        				if(dimension == null) {
        					TextComponentTranslation sleep = new TextComponentTranslation("sp.commands.sleep.display2", new Object[] {sender.getDisplayName(), sender.getCommandSenderEntity().world.provider.getDimension()});
    						sleep.getStyle().setColor(TextFormatting.LIGHT_PURPLE);
    						server.getPlayerList().sendMessage(sleep);
        				} else {
        					TextComponentTranslation sleep = new TextComponentTranslation("sp.commands.sleep.display2", new Object[] {sender.getDisplayName(), dimension});
    						sleep.getStyle().setColor(TextFormatting.LIGHT_PURPLE);
    						server.getPlayerList().sendMessage(sleep);
        				}
        			}
        		}
        	 	else {
         			TextComponentTranslation invalid = new TextComponentTranslation("sp.commands.sleep.night", new Object[] {});
         			invalid.getStyle().setColor(TextFormatting.RED);
         			sender.sendMessage(invalid);
         		}
        	}
        }
	}

	@Override
	public int getRequiredPermissionLevel() {
		
		return 0;
	}
	
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }
    
    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos)
    {
        return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
    }

}
