package net.coolsimulations.SurvivalPlus.core;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
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
import net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfig;
import net.coolsimulations.SurvivalPlus.core.init.FuelHandler;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusBlocks;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusFood;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;
import net.coolsimulations.SurvivalPlus.core.proxy.ClientProxy;
import net.coolsimulations.SurvivalPlus.core.proxy.CommonProxy;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusAPIRecipes;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusEMCValues;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusEventHandler;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusIC2Recipes;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusUpdateHandler;
import net.coolsimulations.SurvivalPlus.core.world.SurvivalPlusOreGenerator;
import net.coolsimulations.SurvivalPlus.core.world.village.StructureVillageOnionCrop;
import net.coolsimulations.SurvivalPlus.core.world.village.VillageOnionCropHandler;
import net.minecraft.item.ItemGroup;
//import net.minecraft.world.gen.feature.structure.StructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = SPReference.MOD_ID)
@Mod.EventBusSubscriber(modid = SPReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SurvivalPlus {
	
	 public static CommonProxy proxy = (CommonProxy) DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	
	private static SurvivalPlus instance;
	public static SurvivalPlus getInstance()
    {
        return instance;
    }
	
	@SubscribeEvent
	public static void serverLoad(FMLServerStartingEvent event) {

		CommandConfrats.register(event.getCommandDispatcher());
		CommandEmportant.register(event.getCommandDispatcher());
		CommandWoo.register(event.getCommandDispatcher());
		CommandWak.register(event.getCommandDispatcher());
		CommandSmiley.register(event.getCommandDispatcher());
		CommandWail.register(event.getCommandDispatcher());
		CommandIndeed.register(event.getCommandDispatcher());
		CommandMourn.register(event.getCommandDispatcher());
		CommandSleep.register(event.getCommandDispatcher());
		CommandWeba.register(event.getCommandDispatcher());
		
	}
	
	public SurvivalPlus() {
		
		SPCompatibilityManager.checkForCompatibleMods();
		SurvivalPlusConfig.register(ModLoadingContext.get());
		SurvivalPlusUpdateHandler.init();
    		MinecraftForge.EVENT_BUS.register(new SurvivalPlusEventHandler());
		FMLJavaModLoadingContext.get().getModEventBus().addListener(SurvivalPlus::setupEvent);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(SurvivalPlus::serverLoad);
		MinecraftForge.EVENT_BUS.register(new FuelHandler());
		
		SurvivalPlusBlocks.init();
		SurvivalPlusBlocks.register();
		SurvivalPlusItems.init();
		SurvivalPlusItems.register();
		SurvivalPlusFood.init();
		SurvivalPlusFood.register();
		
		//VillagerRegistry.instance().registerVillageCreationHandler(new VillageOnionCropHandler());  //temp till forge pull request #6142 is resolved
		//StructureIO.registerStructureComponent(StructureVillageOnionCrop.class, SPReference.MOD_ID + ":onionCropFieldStructure");  //temp till forge pull request #6142 is resolved
		
		SurvivalPlusArmor.init();
		SurvivalPlusArmor.register();
		SurvivalPlusTools.init();
		SurvivalPlusTools.register();
		
		if (SPCompatibilityManager.isProjectELoaded())
        {
    			SurvivalPlusEMCValues.init();
        }
		
		SurvivalPlusAPIRecipes.loadRecipes();
		
        if (SPCompatibilityManager.isIc2Loaded())
        {
        		SurvivalPlusIC2Recipes.init();
        }
		
	}
	
	@SubscribeEvent
	public static void setupEvent(FMLCommonSetupEvent event) {

		SurvivalPlusOreGenerator.generateOres();
	}
}
