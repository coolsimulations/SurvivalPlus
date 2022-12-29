package net.coolsimulations.SurvivalPlus.core;

import java.io.File;
import java.util.Optional;

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
import net.coolsimulations.SurvivalPlus.core.init.FuelHandler;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusBlocks;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusFood;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusGeodes;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTileEntities;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;
import net.coolsimulations.SurvivalPlus.core.recipes.SPShieldRecipes;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusComposterRecipes;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusDispenserBehavior;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusEventHandler;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusUpdateHandler;
import net.coolsimulations.SurvivalPlus.core.world.SurvivalPlusOreGenerator;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.players.UserWhiteList;
import net.minecraft.server.players.UserWhiteListEntry;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class SurvivalPlus implements ModInitializer {

	private static SurvivalPlus instance;
	public static SurvivalPlus getInstance()
	{
		return instance;
	}

	public static void onServerLoad() {
		ServerLifecycleEvents.SERVER_STARTED.register((server) -> {
			if(server.isDedicatedServer()) {

				Optional<GameProfile> gameprofile = server.getProfileCache().get("coolsim");
				UserWhiteList whitelist = server.getPlayerList().getWhiteList();

				if (!gameprofile.isEmpty()) {
					if(server.getPlayerList().isUsingWhitelist() && !whitelist.isWhiteListed(gameprofile.get()) && !server.getPlayerList().getBans().isBanned(gameprofile.get())) {
						UserWhiteListEntry entry = new UserWhiteListEntry(gameprofile.get());
						whitelist.add(entry);
					}
				}
			}
		});
	}

	@Override
	public void onInitialize() {

		SPCompatibilityManager.checkForCompatibleMods();
		SurvivalPlusConfig.init(new File(FabricLoader.getInstance().getConfigDir().toFile(), SPReference.MOD_ID + ".json"));
		SurvivalPlusUpdateHandler.init();

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			CommandConfrats.register(dispatcher);
			CommandEmportant.register(dispatcher);
			CommandWoo.register(dispatcher);
			CommandWak.register(dispatcher);
			CommandSmiley.register(dispatcher);
			CommandWail.register(dispatcher);
			CommandIndeed.register(dispatcher);
			CommandMourn.register(dispatcher);
			CommandSleep.register(dispatcher);
			CommandWeba.register(dispatcher);
		});

		onServerLoad();

		SurvivalPlusBlocks.init();
		SurvivalPlusBlocks.register();
		SurvivalPlusTileEntities.init();
		SurvivalPlusItems.init();
		SurvivalPlusItems.register();
		SurvivalPlusFood.init();
		SurvivalPlusFood.register();

		SurvivalPlusGeodes.init();
		SurvivalPlusGeodes.register();

		SurvivalPlusArmor.init();
		SurvivalPlusArmor.register();
		SurvivalPlusTools.init();
		SurvivalPlusTools.register();

		SurvivalPlusCompatManager.init();

		FuelHandler.init();

		SurvivalPlusDispenserBehavior.init();
		registerRecipes();
		setupEvent();

		SurvivalPlusEventHandler.init();

		SurvivalPlusComposterRecipes.init();

		registerTabs();
		addToTabs();
	}

	public void setupEvent() {
		SurvivalPlusOreGenerator.generateOres();
	}

	public void registerRecipes() {
		RecipeSerializer.register(SPReference.MOD_ID + ":crafting_special_spshielddecoration", SPShieldRecipes.CRAFTING_SPECIAL_SPSHIELD);
	}

	private void registerTabs() {
		SPTabs.tabMaterials = FabricItemGroup.builder(new ResourceLocation(SPReference.MOD_ID, "tab_materials"))
				.title(Component.translatable("item_group." + SPReference.MOD_ID + ".tab_materials"))
				.icon(() -> new ItemStack(SPItems.tin_ingot))
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(SPItems.tin_ingot);
					populator.accept(SPItems.raw_tin);
					populator.accept(SPItems.onion_seeds);
					populator.accept(SPItems.bronze_ingot);
					populator.accept(SPItems.bronze_nugget);
					populator.accept(SPItems.titanium_ingot);
					populator.accept(SPItems.raw_titanium);
					populator.accept(SPItems.titanium_nugget);
					populator.accept(SPItems.charcoal_bucket);
					populator.accept(SPItems.paper_cup);
					if(SPCompatibilityManager.isIndustrialRevolutionLoaded())
						populator.accept(SPItems.titanium_dust);
					populator.accept(SPItems.ruby_shard);
					populator.accept(SPItems.pearl);
					populator.accept(SPItems.topaz_shard);
					populator.accept(SPItems.sapphire_shard);
					populator.accept(SPItems.spinel_shard);
				}).build();

		SPTabs.tabBlocks = FabricItemGroup.builder(new ResourceLocation(SPReference.MOD_ID, "tab_blocks"))
				.title(Component.translatable("item_group." + SPReference.MOD_ID + ".tab_blocks"))
				.icon(() -> new ItemStack(SPBlocks.tin_block))
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(SPBlocks.raw_tin_block);
					populator.accept(SPBlocks.tin_block);
					populator.accept(SPBlocks.tin_ore);
					populator.accept(SPBlocks.deepslate_tin_ore);
					populator.accept(SPBlocks.bronze_block);
					populator.accept(SPBlocks.raw_titanium_block);
					populator.accept(SPBlocks.titanium_block);
					populator.accept(SPBlocks.titanium_ore);
					populator.accept(SPBlocks.deepslate_titanium_ore);
					populator.accept(SPBlocks.cardboard);
					populator.accept(SPBlocks.cardboard_white);
					populator.accept(SPBlocks.cardboard_light_grey);
					populator.accept(SPBlocks.cardboard_grey);
					populator.accept(SPBlocks.cardboard_black);
					populator.accept(SPBlocks.cardboard_red);
					populator.accept(SPBlocks.cardboard_orange);
					populator.accept(SPBlocks.cardboard_yellow);
					populator.accept(SPBlocks.cardboard_lime);
					populator.accept(SPBlocks.cardboard_green);
					populator.accept(SPBlocks.cardboard_light_blue);
					populator.accept(SPBlocks.cardboard_cyan);
					populator.accept(SPBlocks.cardboard_blue);
					populator.accept(SPBlocks.cardboard_purple);
					populator.accept(SPBlocks.cardboard_magenta);
					populator.accept(SPBlocks.cardboard_pink);
					populator.accept(SPBlocks.cardboard_brown);
					populator.accept(SPBlocks.cardboard_lantern);
					populator.accept(SPBlocks.cardboard_lantern_white);
					populator.accept(SPBlocks.cardboard_lantern_light_grey);
					populator.accept(SPBlocks.cardboard_lantern_grey);
					populator.accept(SPBlocks.cardboard_lantern_black);
					populator.accept(SPBlocks.cardboard_lantern_red);
					populator.accept(SPBlocks.cardboard_lantern_orange);
					populator.accept(SPBlocks.cardboard_lantern_yellow);
					populator.accept(SPBlocks.cardboard_lantern_lime);
					populator.accept(SPBlocks.cardboard_lantern_green);
					populator.accept(SPBlocks.cardboard_lantern_light_blue);
					populator.accept(SPBlocks.cardboard_lantern_cyan);
					populator.accept(SPBlocks.cardboard_lantern_blue);
					populator.accept(SPBlocks.cardboard_lantern_purple);
					populator.accept(SPBlocks.cardboard_lantern_magenta);
					populator.accept(SPBlocks.cardboard_lantern_pink);
					populator.accept(SPBlocks.cardboard_lantern_brown);
					populator.accept(SPBlocks.sconce);
					populator.accept(SPBlocks.gem_staff);
				}).build();

		SPTabs.tabFood = FabricItemGroup.builder(new ResourceLocation(SPReference.MOD_ID, "tab_food"))
				.title(Component.translatable("item_group." + SPReference.MOD_ID + ".tab_food"))
				.icon(() -> new ItemStack(SPItems.apple_pie))
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(SPBlocks.cheese_cake);
					populator.accept(SPBlocks.sponge_cake);
					populator.accept(SPItems.apple_pie);
					populator.accept(SPItems.beef_pie);
					populator.accept(SPItems.pork_pie);
					populator.accept(SPItems.chicken_pie);
					populator.accept(SPItems.mutton_pie);
					populator.accept(SPItems.rabbit_pie);
					populator.accept(SPItems.vegetable_pie);
					populator.accept(SPItems.raw_onion);
					populator.accept(SPItems.onion_soup);
					populator.accept(SPItems.fried_egg);
					populator.accept(SPItems.roast_carrot);
					populator.accept(SPItems.cheese);
					populator.accept(SPItems.cheese_bread);
					populator.accept(SPItems.melted_cheese_bread);
					populator.accept(SPItems.cupcake);
					populator.accept(SPItems.cheese_cupcake);
					populator.accept(SPItems.sponge_cupcake);
					populator.accept(SPItems.baked_apple);
					populator.accept(SPItems.fried_onion);
				}).build();

		SPTabs.tabGem = FabricItemGroup.builder(new ResourceLocation(SPReference.MOD_ID, "tab_gem"))
				.title(Component.translatable("item_group." + SPReference.MOD_ID + ".tab_gem"))
				.icon(() -> new ItemStack(SPBlocks.sapphire_cluster))
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(SPBlocks.ruby_block);
					populator.accept(SPBlocks.ruby_cluster);
					populator.accept(SPBlocks.large_ruby_bud);
					populator.accept(SPBlocks.medium_ruby_bud);
					populator.accept(SPBlocks.small_ruby_bud);
					populator.accept(SPBlocks.budding_ruby);
					populator.accept(SPBlocks.pearl_block);
					populator.accept(SPBlocks.pearl_cluster);
					populator.accept(SPBlocks.large_pearl_bud);
					populator.accept(SPBlocks.medium_pearl_bud);
					populator.accept(SPBlocks.small_pearl_bud);
					populator.accept(SPBlocks.budding_pearl);
					populator.accept(SPBlocks.topaz_block);
					populator.accept(SPBlocks.topaz_cluster);
					populator.accept(SPBlocks.large_topaz_bud);
					populator.accept(SPBlocks.medium_topaz_bud);
					populator.accept(SPBlocks.small_topaz_bud);
					populator.accept(SPBlocks.budding_topaz);
					populator.accept(SPBlocks.sapphire_block);
					populator.accept(SPBlocks.sapphire_cluster);
					populator.accept(SPBlocks.large_sapphire_bud);
					populator.accept(SPBlocks.medium_sapphire_bud);
					populator.accept(SPBlocks.small_sapphire_bud);
					populator.accept(SPBlocks.budding_sapphire);
					populator.accept(SPBlocks.spinel_block);
					populator.accept(SPBlocks.spinel_cluster);
					populator.accept(SPBlocks.large_spinel_bud);
					populator.accept(SPBlocks.medium_spinel_bud);
					populator.accept(SPBlocks.small_spinel_bud);
					populator.accept(SPBlocks.budding_spinel);
				}).build();

		SPTabs.tabCombat = FabricItemGroup.builder(new ResourceLocation(SPReference.MOD_ID, "tab_combat"))
				.title(Component.translatable("item_group." + SPReference.MOD_ID + ".tab_combat"))
				.icon(() -> new ItemStack(SPItems.titanium_sword))
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
					if(SPCompatibilityManager.isEnrichedLoaded())
						for (ItemStack item : SPItems.redwood_vanilla_enhanced)
							populator.accept(item.getItem());
					if(SPCompatibilityManager.isTraverseLoaded())
						for (ItemStack item : SPItems.fir_traverse)
							populator.accept(item.getItem());
					if(SPCompatibilityManager.isTerrestriaLoaded()) {
						for (ItemStack item : SPItems.redwood_terrestria)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.hemlock)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.rubber_terrestria)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.cypress)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.willow_terrestria)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.japanese_maple)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.rainbow_eucalyptus)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.sakura)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.yucca_palm)
							populator.accept(item.getItem());
					}
					if(SPCompatibilityManager.isAetherRebornLoaded()) {
						for (ItemStack item : SPItems.skyroot)
							populator.accept(item.getItem());
						for (ItemStack item : SPItems.golden_oak)
							populator.accept(item.getItem());
					}
					populator.accept(SPItems.bronze_sword);
					populator.accept(SPItems.bronze_shield);
					populator.accept(SPItems.titanium_sword);
					populator.accept(SPItems.titanium_shield);
				}).build();

		SPTabs.tabTools = FabricItemGroup.builder(new ResourceLocation(SPReference.MOD_ID, "tab_tools"))
				.title(Component.translatable("item_group." + SPReference.MOD_ID + ".tab_tools"))
				.icon(() -> new ItemStack(SPItems.bronze_axe))
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(SPItems.bronze_pickaxe);
					populator.accept(SPItems.bronze_axe);
					populator.accept(SPItems.bronze_shovel);
					populator.accept(SPItems.bronze_hoe);
					populator.accept(SPItems.bronze_shears);
					populator.accept(SPItems.titanium_pickaxe);
					populator.accept(SPItems.titanium_axe);
					populator.accept(SPItems.titanium_shovel);
					populator.accept(SPItems.titanium_hoe);
					populator.accept(SPItems.titanium_shears);
				}).build();
	}
	
	private void addToTabs() {
	    ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(content -> {
			//TEMP UNTIL NO TREE UPDATES
			if(SPCompatibilityManager.isNoTreePunchingLoaded()) {
				content.accept(SPItems.titanium_knife);
				content.accept(SPItems.titanium_mattock);
				content.accept(SPItems.titanium_saw);
			}
	    });
	}
}
