package net.coolsimulations.SurvivalPlus.core;

import java.io.File;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.commands.CommandConfrats;
import net.coolsimulations.SurvivalPlus.core.commands.CommandIndeed;
import net.coolsimulations.SurvivalPlus.core.commands.CommandMourn;
import net.coolsimulations.SurvivalPlus.core.commands.CommandSleep;
import net.coolsimulations.SurvivalPlus.core.commands.CommandSmiley;
import net.coolsimulations.SurvivalPlus.core.commands.CommandWail;
import net.coolsimulations.SurvivalPlus.core.commands.CommandWak;
import net.coolsimulations.SurvivalPlus.core.commands.CommandWeba;
import net.coolsimulations.SurvivalPlus.core.commands.CommandWoo;
import net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfig;
import net.coolsimulations.SurvivalPlus.core.init.FuelHandler;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusBlocks;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusFood;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;
import net.coolsimulations.SurvivalPlus.core.proxy.CommonProxy;
import net.coolsimulations.SurvivalPlus.core.recipes.ButcherVillagerTradeHandler;
import net.coolsimulations.SurvivalPlus.core.recipes.FarmerVillagerTradeHandler;
import net.coolsimulations.SurvivalPlus.core.recipes.SmithVillagerTradeHandler;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusShapedRecipes;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusShapelessRecipes;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusSmeltingRecipes;
import net.coolsimulations.SurvivalPlus.core.tabs.SurvivalPlusBlocksTab;
import net.coolsimulations.SurvivalPlus.core.tabs.SurvivalPlusCombatTab;
import net.coolsimulations.SurvivalPlus.core.tabs.SurvivalPlusFoodTab;
import net.coolsimulations.SurvivalPlus.core.tabs.SurvivalPlusGemTab;
import net.coolsimulations.SurvivalPlus.core.tabs.SurvivalPlusMaterialsTab;
import net.coolsimulations.SurvivalPlus.core.tabs.SurvivalPlusToolsTab;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusAPIRecipes;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusEMCValues;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusEventHandler;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusIC2Recipes;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusOreDict;
import net.coolsimulations.SurvivalPlus.core.world.village.StructureVillageOnionCrop;
import net.coolsimulations.SurvivalPlus.core.world.village.VillageOnionCropHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

@Mod(modid = SPReference.MOD_ID, name = SPReference.MOD_NAME, version = SPReference.VERSION, acceptedMinecraftVersions = SPReference.ACCEPTED_VERSIONS, dependencies = SPReference.DEPENDENCIES, guiFactory = "net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfigGUI")
public class SurvivalPlus {
	
	@SidedProxy(clientSide = SPReference.CLIENT_PROXY_CLASS, serverSide = SPReference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.Instance(SPReference.MOD_ID)
	private static SurvivalPlus instance;
	public static SurvivalPlus getInstance()
    {
        return instance;
    }
	
	public static final CreativeTabs tabMaterials = new SurvivalPlusMaterialsTab();
	public static final CreativeTabs tabBlocks = new SurvivalPlusBlocksTab();
	public static final CreativeTabs tabFood = new SurvivalPlusFoodTab();
	public static final CreativeTabs tabGem = new SurvivalPlusGemTab();
	public static final CreativeTabs tabCombat = new SurvivalPlusCombatTab();
	public static final CreativeTabs tabTools = new SurvivalPlusToolsTab();
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		System.out.println("Pre Init");
		SPCompatibilityManager.checkForCompatibleMods();
		SurvivalPlusConfig.init(new File(event.getModConfigurationDirectory(), SPReference.SURVIVALPLUS_CONFIG_FILE));
    	MinecraftForge.EVENT_BUS.register(new SurvivalPlusEventHandler());
		
		SurvivalPlusBlocks.init();
		SurvivalPlusBlocks.register();
		SurvivalPlusItems.init();
		SurvivalPlusItems.register();
		SurvivalPlusFood.init();
		SurvivalPlusFood.register();
		
		VillagerRegistry.instance().registerVillageCreationHandler(new VillageOnionCropHandler());
		MapGenStructureIO.registerStructureComponent(StructureVillageOnionCrop.class, SPReference.MOD_ID + ":onionCropFieldStructure");
		
		SmithVillagerTradeHandler.init();
		FarmerVillagerTradeHandler.init();
		ButcherVillagerTradeHandler.init();
		
		SurvivalPlusArmor.init();
		SurvivalPlusArmor.register();
		SurvivalPlusTools.init();
		SurvivalPlusTools.register();
		SurvivalPlusOreDict.PreInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		System.out.println("Init");
		
		proxy.init();
		SurvivalPlusShapedRecipes.register();
		SurvivalPlusShapelessRecipes.register();
		SurvivalPlusSmeltingRecipes.register();
		GameRegistry.registerFuelHandler(new FuelHandler());
		
		if (SPCompatibilityManager.isProjectELoaded())
        {
    		SurvivalPlusEMCValues.init();
        }

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		System.out.println("Post Init");
		 
        SurvivalPlusAPIRecipes.loadRecipes();
        if (SPCompatibilityManager.isIc2Loaded())
        {
        SurvivalPlusIC2Recipes.init();
        }else{
        		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(SPItems.bronze_ingot), "ingotCopper", "ingotCopper", "ingotCopper", "ingotTin");
        }
			
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		
		event.registerServerCommand(new CommandConfrats());
		event.registerServerCommand(new CommandWoo());
		event.registerServerCommand(new CommandWak());
		event.registerServerCommand(new CommandSmiley());
		event.registerServerCommand(new CommandWail());
		event.registerServerCommand(new CommandIndeed());
		event.registerServerCommand(new CommandMourn());
		event.registerServerCommand(new CommandSleep());
		event.registerServerCommand(new CommandWeba());
		
	}
}
