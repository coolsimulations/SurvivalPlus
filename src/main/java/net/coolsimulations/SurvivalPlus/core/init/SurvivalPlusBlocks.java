package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockMetal;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockOre;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCandleCheeseCake;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCandleSpongeCake;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboard;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCheeseCake;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockOnionCrop;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockSpongeCake;
import net.coolsimulations.SurvivalPlus.core.items.ItemCardboardLantern;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;

public class SurvivalPlusBlocks {

	public static void init()
	{
		SPBlocks.raw_tin_block = new SPBlockMetal(MaterialColor.METAL, SPBlockMetal.Resource.TIER_0);
		SPBlocks.tin_block = new SPBlockMetal(MaterialColor.METAL, SPBlockMetal.Resource.TIER_0);
		SPBlocks.onion = new BlockOnionCrop();
		SPBlocks.cheese_cake = new BlockCheeseCake();
		SPBlocks.candle_cheese_cake = new BlockCandleCheeseCake(Blocks.CANDLE);
		SPBlocks.white_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.WHITE_CANDLE);
		SPBlocks.light_grey_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.LIGHT_GRAY_CANDLE);
		SPBlocks.grey_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.GRAY_CANDLE);
		SPBlocks.black_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.BLACK_CANDLE);
		SPBlocks.red_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.RED_CANDLE);
		SPBlocks.orange_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.ORANGE_CANDLE);
		SPBlocks.yellow_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.YELLOW_CANDLE);
		SPBlocks.lime_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.LIME_CANDLE);
		SPBlocks.green_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.GREEN_CANDLE);
		SPBlocks.light_blue_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.LIGHT_BLUE_CANDLE);
		SPBlocks.cyan_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.CYAN_CANDLE);
		SPBlocks.blue_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.BLUE_CANDLE);
		SPBlocks.purple_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.PURPLE_CANDLE);
		SPBlocks.magenta_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.MAGENTA_CANDLE);
		SPBlocks.pink_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.PINK_CANDLE);
		SPBlocks.brown_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.BROWN_CANDLE);
		SPBlocks.sponge_cake = new BlockSpongeCake();
		SPBlocks.candle_sponge_cake = new BlockCandleSpongeCake(Blocks.CANDLE);
		SPBlocks.white_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.WHITE_CANDLE);
		SPBlocks.light_grey_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.LIGHT_GRAY_CANDLE);
		SPBlocks.grey_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.GRAY_CANDLE);
		SPBlocks.black_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.BLACK_CANDLE);
		SPBlocks.red_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.RED_CANDLE);
		SPBlocks.orange_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.ORANGE_CANDLE);
		SPBlocks.yellow_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.YELLOW_CANDLE);
		SPBlocks.lime_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.LIME_CANDLE);
		SPBlocks.green_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.GREEN_CANDLE);
		SPBlocks.light_blue_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.LIGHT_BLUE_CANDLE);
		SPBlocks.cyan_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.CYAN_CANDLE);
		SPBlocks.blue_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.BLUE_CANDLE);
		SPBlocks.purple_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.PURPLE_CANDLE);
		SPBlocks.magenta_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.MAGENTA_CANDLE);
		SPBlocks.pink_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.PINK_CANDLE);
		SPBlocks.brown_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.BROWN_CANDLE);
		SPBlocks.tin_ore = new SPBlockOre(SPBlockOre.Resource.TIER_1, false);
		SPBlocks.deepslate_tin_ore = new SPBlockOre(SPBlockOre.Resource.TIER_1_DEEPSLATE, false);
		SPBlocks.bronze_block = new SPBlockMetal(MaterialColor.COLOR_BROWN, SPBlockMetal.Resource.TIER_1);
		SPBlocks.raw_titanium_block = new SPBlockMetal(MaterialColor.DIAMOND, SPBlockMetal.Resource.TIER_2);
		SPBlocks.titanium_block = new SPBlockMetal(MaterialColor.DIAMOND, SPBlockMetal.Resource.TIER_2);
		SPBlocks.titanium_ore = new SPBlockOre(SPBlockOre.Resource.TIER_2, false);
		SPBlocks.deepslate_titanium_ore = new SPBlockOre(SPBlockOre.Resource.TIER_2_DEEPSLATE, false);
		SPBlocks.cardboard = new BlockCardboard(MaterialColor.WOOD);
		SPBlocks.cardboard_white = new BlockCardboard(MaterialColor.SNOW);
		SPBlocks.cardboard_light_grey = new BlockCardboard(MaterialColor.COLOR_LIGHT_GRAY);
		SPBlocks.cardboard_grey = new BlockCardboard(MaterialColor.COLOR_GRAY);
		SPBlocks.cardboard_black = new BlockCardboard(MaterialColor.COLOR_BLACK);
		SPBlocks.cardboard_red = new BlockCardboard(MaterialColor.COLOR_RED);
		SPBlocks.cardboard_orange = new BlockCardboard(MaterialColor.COLOR_ORANGE);
		SPBlocks.cardboard_yellow = new BlockCardboard(MaterialColor.COLOR_YELLOW);
		SPBlocks.cardboard_lime = new BlockCardboard(MaterialColor.COLOR_LIGHT_GREEN);
		SPBlocks.cardboard_green = new BlockCardboard(MaterialColor.COLOR_GREEN);
		SPBlocks.cardboard_light_blue = new BlockCardboard(MaterialColor.COLOR_LIGHT_BLUE);
		SPBlocks.cardboard_cyan = new BlockCardboard(MaterialColor.COLOR_CYAN);
		SPBlocks.cardboard_blue = new BlockCardboard(MaterialColor.COLOR_BLUE);
		SPBlocks.cardboard_purple = new BlockCardboard(MaterialColor.COLOR_PURPLE);
		SPBlocks.cardboard_magenta = new BlockCardboard(MaterialColor.COLOR_MAGENTA);
		SPBlocks.cardboard_pink = new BlockCardboard(MaterialColor.COLOR_PINK);
		SPBlocks.cardboard_brown = new BlockCardboard(MaterialColor.COLOR_BROWN);
		SPBlocks.cardboard_lantern = new BlockCardboardLantern(MaterialColor.WOOD, false);
		SPBlocks.cardboard_lantern_white = new BlockCardboardLantern(MaterialColor.SNOW, true);
		SPBlocks.cardboard_lantern_light_grey = new BlockCardboardLantern(MaterialColor.COLOR_LIGHT_GRAY, true);
		SPBlocks.cardboard_lantern_grey = new BlockCardboardLantern(MaterialColor.COLOR_GRAY, true);
		SPBlocks.cardboard_lantern_black = new BlockCardboardLantern(MaterialColor.COLOR_BLACK, true);
		SPBlocks.cardboard_lantern_red = new BlockCardboardLantern(MaterialColor.COLOR_RED, true);
		SPBlocks.cardboard_lantern_orange = new BlockCardboardLantern(MaterialColor.COLOR_ORANGE, true);
		SPBlocks.cardboard_lantern_yellow = new BlockCardboardLantern(MaterialColor.COLOR_YELLOW, true);
		SPBlocks.cardboard_lantern_lime = new BlockCardboardLantern(MaterialColor.COLOR_LIGHT_GREEN, true);
		SPBlocks.cardboard_lantern_green = new BlockCardboardLantern(MaterialColor.COLOR_GREEN, true);
		SPBlocks.cardboard_lantern_light_blue = new BlockCardboardLantern(MaterialColor.COLOR_LIGHT_BLUE, true);
		SPBlocks.cardboard_lantern_cyan = new BlockCardboardLantern(MaterialColor.COLOR_CYAN, true);
		SPBlocks.cardboard_lantern_blue = new BlockCardboardLantern(MaterialColor.COLOR_BLUE, true);
		SPBlocks.cardboard_lantern_purple = new BlockCardboardLantern(MaterialColor.COLOR_PURPLE, true);
		SPBlocks.cardboard_lantern_magenta = new BlockCardboardLantern(MaterialColor.COLOR_MAGENTA, true);
		SPBlocks.cardboard_lantern_pink = new BlockCardboardLantern(MaterialColor.COLOR_PINK, true);
		SPBlocks.cardboard_lantern_brown = new BlockCardboardLantern(MaterialColor.COLOR_BROWN, true);

	}

	public static void register()
	{
		registerBlock(SPBlocks.raw_tin_block, "raw_tin_block");
		registerBlock(SPBlocks.tin_block, "tin_block");
		registerBlock(SPBlocks.onion, "onion");
		registerBlock(SPBlocks.tin_ore, "tin_ore");
		registerBlock(SPBlocks.deepslate_tin_ore, "deepslate_tin_ore");
		registerBlock(SPBlocks.bronze_block, "bronze_block");
		registerBlock(SPBlocks.raw_titanium_block, "raw_titanium_block");
		registerBlock(SPBlocks.titanium_block, "titanium_block");
		registerBlock(SPBlocks.titanium_ore, "titanium_ore");
		registerBlock(SPBlocks.deepslate_titanium_ore, "deepslate_titanium_ore");
		registerBlock(SPBlocks.cheese_cake, "cheese_cake");
		registerBlock(SPBlocks.candle_cheese_cake, "candle_cheese_cake", false);
		registerBlock(SPBlocks.white_candle_cheese_cake, "white_candle_cheese_cake", false);
		registerBlock(SPBlocks.light_grey_candle_cheese_cake, "light_grey_candle_cheese_cake", false);
		registerBlock(SPBlocks.grey_candle_cheese_cake, "grey_candle_cheese_cake", false);
		registerBlock(SPBlocks.black_candle_cheese_cake, "black_candle_cheese_cake", false);
		registerBlock(SPBlocks.red_candle_cheese_cake, "red_candle_cheese_cake", false);
		registerBlock(SPBlocks.orange_candle_cheese_cake, "orange_candle_cheese_cake", false);
		registerBlock(SPBlocks.yellow_candle_cheese_cake, "yellow_candle_cheese_cake", false);
		registerBlock(SPBlocks.lime_candle_cheese_cake, "lime_candle_cheese_cake", false);
		registerBlock(SPBlocks.green_candle_cheese_cake, "green_candle_cheese_cake", false);
		registerBlock(SPBlocks.light_blue_candle_cheese_cake, "light_blue_candle_cheese_cake", false);
		registerBlock(SPBlocks.cyan_candle_cheese_cake, "cyan_candle_cheese_cake", false);
		registerBlock(SPBlocks.blue_candle_cheese_cake, "blue_candle_cheese_cake", false);
		registerBlock(SPBlocks.purple_candle_cheese_cake, "purple_candle_cheese_cake", false);
		registerBlock(SPBlocks.magenta_candle_cheese_cake, "magenta_candle_cheese_cake", false);
		registerBlock(SPBlocks.pink_candle_cheese_cake, "pink_candle_cheese_cake", false);
		registerBlock(SPBlocks.brown_candle_cheese_cake, "brown_candle_cheese_cake", false);
		registerBlock(SPBlocks.sponge_cake, "sponge_cake");
		registerBlock(SPBlocks.candle_sponge_cake, "candle_sponge_cake", false);
		registerBlock(SPBlocks.white_candle_sponge_cake, "white_candle_sponge_cake", false);
		registerBlock(SPBlocks.light_grey_candle_sponge_cake, "light_grey_candle_sponge_cake", false);
		registerBlock(SPBlocks.grey_candle_sponge_cake, "grey_candle_sponge_cake", false);
		registerBlock(SPBlocks.black_candle_sponge_cake, "black_candle_sponge_cake", false);
		registerBlock(SPBlocks.red_candle_sponge_cake, "red_candle_sponge_cake", false);
		registerBlock(SPBlocks.orange_candle_sponge_cake, "orange_candle_sponge_cake", false);
		registerBlock(SPBlocks.yellow_candle_sponge_cake, "yellow_candle_sponge_cake", false);
		registerBlock(SPBlocks.lime_candle_sponge_cake, "lime_candle_sponge_cake", false);
		registerBlock(SPBlocks.green_candle_sponge_cake, "green_candle_sponge_cake", false);
		registerBlock(SPBlocks.light_blue_candle_sponge_cake, "light_blue_candle_sponge_cake", false);
		registerBlock(SPBlocks.cyan_candle_sponge_cake, "cyan_candle_sponge_cake", false);
		registerBlock(SPBlocks.blue_candle_sponge_cake, "blue_candle_sponge_cake", false);
		registerBlock(SPBlocks.purple_candle_sponge_cake, "purple_candle_sponge_cake", false);
		registerBlock(SPBlocks.magenta_candle_sponge_cake, "magenta_candle_sponge_cake", false);
		registerBlock(SPBlocks.pink_candle_sponge_cake, "pink_candle_sponge_cake", false);
		registerBlock(SPBlocks.brown_candle_sponge_cake, "brown_candle_sponge_cake", false);
		registerBlock(SPBlocks.cardboard, "cardboard");
		registerBlock(SPBlocks.cardboard_white, "cardboard_white");
		registerBlock(SPBlocks.cardboard_light_grey, "cardboard_light_grey");
		registerBlock(SPBlocks.cardboard_grey, "cardboard_grey");
		registerBlock(SPBlocks.cardboard_black, "cardboard_black");
		registerBlock(SPBlocks.cardboard_red, "cardboard_red");
		registerBlock(SPBlocks.cardboard_orange, "cardboard_orange");
		registerBlock(SPBlocks.cardboard_yellow, "cardboard_yellow");
		registerBlock(SPBlocks.cardboard_lime, "cardboard_lime");
		registerBlock(SPBlocks.cardboard_green, "cardboard_green");
		registerBlock(SPBlocks.cardboard_light_blue, "cardboard_light_blue");
		registerBlock(SPBlocks.cardboard_cyan, "cardboard_cyan");
		registerBlock(SPBlocks.cardboard_blue, "cardboard_blue");
		registerBlock(SPBlocks.cardboard_purple, "cardboard_purple");
		registerBlock(SPBlocks.cardboard_magenta, "cardboard_magenta");
		registerBlock(SPBlocks.cardboard_pink, "cardboard_pink");
		registerBlock(SPBlocks.cardboard_brown, "cardboard_brown");
		registerBlock(SPBlocks.cardboard_lantern, "cardboard_lantern");
		registerBlock(SPBlocks.cardboard_lantern_white, "cardboard_lantern_white");
		registerBlock(SPBlocks.cardboard_lantern_light_grey, "cardboard_lantern_light_grey");
		registerBlock(SPBlocks.cardboard_lantern_grey, "cardboard_lantern_grey");
		registerBlock(SPBlocks.cardboard_lantern_black, "cardboard_lantern_black");
		registerBlock(SPBlocks.cardboard_lantern_red, "cardboard_lantern_red");
		registerBlock(SPBlocks.cardboard_lantern_orange, "cardboard_lantern_orange");
		registerBlock(SPBlocks.cardboard_lantern_yellow, "cardboard_lantern_yellow");
		registerBlock(SPBlocks.cardboard_lantern_lime, "cardboard_lantern_lime");
		registerBlock(SPBlocks.cardboard_lantern_green, "cardboard_lantern_green");
		registerBlock(SPBlocks.cardboard_lantern_light_blue, "cardboard_lantern_light_blue");
		registerBlock(SPBlocks.cardboard_lantern_cyan, "cardboard_lantern_cyan");
		registerBlock(SPBlocks.cardboard_lantern_blue, "cardboard_lantern_blue");
		registerBlock(SPBlocks.cardboard_lantern_purple, "cardboard_lantern_purple");
		registerBlock(SPBlocks.cardboard_lantern_magenta, "cardboard_lantern_magenta");
		registerBlock(SPBlocks.cardboard_lantern_pink, "cardboard_lantern_pink");
		registerBlock(SPBlocks.cardboard_lantern_brown, "cardboard_lantern_brown");
	}

	public static void registerBlock(Block block, String registryName) {

		registerBlock(block, registryName, true);
	}

	public static void registerBlock(Block block, String registryName, boolean regsiterItem) {

		Registry.register(Registry.BLOCK, new ResourceLocation(SPReference.MOD_ID, registryName), block);
		if(regsiterItem)
			registerBlockItem(block, registryName);
	}

	public static void registerBlockItem(Block block, String registryName) {

		BlockItem BlockItem;
		if(block instanceof AmethystBlock) {
			BlockItem = new BlockItem(block, new FabricItemSettings().group(SPTabs.tabGem));	
		} else if(block == SPBlocks.onion) {
			BlockItem = new BlockItem(block, new FabricItemSettings());
		} else if(block == SPBlocks.cheese_cake || block == SPBlocks.sponge_cake) {
			BlockItem = new BlockItem(block, new FabricItemSettings().group(SPTabs.tabFood).stacksTo(1));
		} else if (block instanceof BlockCardboardLantern) {
			BlockItem = new ItemCardboardLantern(block, new FabricItemSettings().group(SPTabs.tabBlocks));
		} else {
			BlockItem = new BlockItem(block, new FabricItemSettings().group(SPTabs.tabBlocks));
		}

		Registry.register(Registry.ITEM, new ResourceLocation(SPReference.MOD_ID, registryName), BlockItem);
	}

}
