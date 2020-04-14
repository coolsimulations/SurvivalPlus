package net.coolsimulations.SurvivalPlus.core.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.FMLRelaunchLog;

import org.apache.logging.log4j.Level;


public class SurvivalPlusConfig {
	
	static Configuration config;
	
	public static void init(File file)
    {
        config = new Configuration(file);
        syncConfig(true);
    }
	
    public static void forceSave()
    {
    	config.save();
    }
	
	 public static void syncConfig(boolean load)
	    {
	        List<String> propOrder = new ArrayList<String>();

	        try
	        {
	            Property prop;

	            if (!config.isChild)
	            {
	                if (load)
	                {
	                    config.load();
	                }
	            }
	            
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_RECIPES, "Enable Sponge Recipe", false);
	            prop.setComment("If this is enabled, sponge can be crafted with a combination of gold ingots, yellow wool and cheese. By default this is set to false as to make sponge cake rarer.");
	            prop.setLanguageKey("sp.configgui.enable_sponge");
	            SPConfig.enableSponge = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_COMPATIBILITY, "Enable Replace BOP Terrestrial Artifact Recipe", false);
	            prop.setComment("If this is enable and Biomes O' Plenty are played with, the crafting recipe for the Terrestrial Artifact can use SurvivalPlus's ruby, topaz, and sapphire. By default this is set to false as the idea of the Terrestrial Artifact is that you need to go to all BOP biomes to find the needed gems, whereas SurvivalPlus gems generate everywhere.");
	            prop.setLanguageKey("sp.configgui.enable_Replace_BOP_Recipe");
	            SPConfig.enableReplaceBOPRecipe = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_GENERATION, "Disable SurvivalPlus Copper Ore Gen", false);
	            prop.setLanguageKey("sp.configgui.disable_copper_ore_gen");
	            SPConfig.disableCopperOreGen = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_GENERATION, "Disable SurvivalPlus Tin Ore Gen", false);
	            prop.setLanguageKey("sp.configgui.disable_tin_ore_gen");
	            SPConfig.disableTinOreGen = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_GENERATION, "Disable SurvivalPlus Titanium Ore Gen", false);
	            prop.setLanguageKey("sp.configgui.disable_titanium_ore_gen");
	            SPConfig. disableTitaniumOreGen = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_GENERATION, "Disable SurvivalPlus Amethyst Gen", false);
	            prop.setLanguageKey("sp.configgui.disable_amethyst_gen");
	            SPConfig.disableAmethystGen = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_GENERATION, "Disable SurvivalPlus Ruby Gen", false);
	            prop.setLanguageKey("sp.configgui.disable_ruby_gen");
	            SPConfig.disableRubyGen = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_GENERATION, "Disable SurvivalPlus Topaz Gen", false);
	            prop.setLanguageKey("sp.configgui.disable_topaz_gen");
	            SPConfig.disableTopazGen = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_GENERATION, "Disable SurvivalPlus Sapphire Gen", false);
	            prop.setLanguageKey("sp.configgui.disable_sapphire_gen");
	            SPConfig.disableSapphireGen = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_GENERATION, "Disable SurvivalPlus Pearl Gen", false);
	            prop.setLanguageKey("sp.configgui.disable_pearl_gen");
	            SPConfig.disablePearlGen = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_GENERATION, "Disable SurvivalPlus Spinel Gen", false);
	            prop.setLanguageKey("sp.configgui.disable_spinel_gen");
	            SPConfig.disableSpinelGen = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_COMMAND, "Define Wak Command Permission Level", 0);
	            prop.setComment("If this is set to 0 anyone can use the Wak Command. If set above 4 then it will return 4.");
	            prop.setLanguageKey("sp.configgui.op_wak_command");
	            SPConfig.opWak = prop.getInt(0);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_COMMAND, "Disable SurvivalPlus Update Checker Message", false);
	            prop.setLanguageKey("sp.configgui.update_check");
	            SPConfig.disableUpdateCheck = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_COMPATIBILITY, "Disable Sounds Played Through sun.audio", false);
	            prop.setLanguageKey("sp.configgui.sun_audio");
	            SPConfig.disableSunAudio = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(SPReference.CONFIG_CATEGORY_COMMAND, "Disable SurvivalPlus Thank You Message", false);
	            prop.setLanguageKey("sp.configgui.disable_thanks");
	            SPConfig.disableThanks = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            if (config.hasChanged())
	            {
	                config.save();
	            }
	            
	        }
	        catch (final Exception e)
	        {
	        	FMLRelaunchLog.log(SPReference.MOD_NAME, Level.ERROR, ("Problem loading SurvivalPlus config (\"SurvivalPlus.conf\")"));
	            e.printStackTrace();
	        }
	    }
	 
	 public static List<IConfigElement> getConfigElements()
	    {
	        List<IConfigElement> list = new ArrayList<IConfigElement>();
	        list.addAll(new ConfigElement(config.getCategory(SPReference.CONFIG_CATEGORY_RECIPES)).getChildElements());
	        list.addAll(new ConfigElement(config.getCategory(SPReference.CONFIG_CATEGORY_COMPATIBILITY)).getChildElements());
	        list.addAll(new ConfigElement(config.getCategory(SPReference.CONFIG_CATEGORY_GENERATION)).getChildElements());
	        list.addAll(new ConfigElement(config.getCategory(SPReference.CONFIG_CATEGORY_COMMAND)).getChildElements());
	        return list;
	    }

}
