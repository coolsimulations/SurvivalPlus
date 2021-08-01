package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
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
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusBlocks {

	public static void init()
	{
		SPBlocks.raw_tin_block = new SPBlockMetal(MaterialColor.METAL, SPBlockMetal.Resource.TIER_0).setRegistryName("raw_tin_block");
		SPBlocks.tin_block = new SPBlockMetal(MaterialColor.METAL, SPBlockMetal.Resource.TIER_0).setRegistryName("tin_block");
		SPBlocks.onion = new BlockOnionCrop().setRegistryName("onion");
		SPBlocks.cheese_cake = new BlockCheeseCake().setRegistryName("cheese_cake");
		SPBlocks.candle_cheese_cake = new BlockCandleCheeseCake(Blocks.CANDLE).setRegistryName("candle_cheese_cake");
		SPBlocks.white_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.WHITE_CANDLE).setRegistryName("white_candle_cheese_cake");
		SPBlocks.light_grey_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.LIGHT_GRAY_CANDLE).setRegistryName("light_grey_candle_cheese_cake");
		SPBlocks.grey_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.GRAY_CANDLE).setRegistryName("grey_candle_cheese_cake");
		SPBlocks.black_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.BLACK_CANDLE).setRegistryName("black_candle_cheese_cake");
		SPBlocks.red_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.RED_CANDLE).setRegistryName("red_candle_cheese_cake");
		SPBlocks.orange_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.ORANGE_CANDLE).setRegistryName("orange_candle_cheese_cake");
		SPBlocks.yellow_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.YELLOW_CANDLE).setRegistryName("yellow_candle_cheese_cake");
		SPBlocks.lime_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.LIME_CANDLE).setRegistryName("lime_candle_cheese_cake");
		SPBlocks.green_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.GREEN_CANDLE).setRegistryName("green_candle_cheese_cake");
		SPBlocks.light_blue_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.LIGHT_BLUE_CANDLE).setRegistryName("light_blue_candle_cheese_cake");
		SPBlocks.cyan_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.CYAN_CANDLE).setRegistryName("cyan_candle_cheese_cake");
		SPBlocks.blue_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.BLUE_CANDLE).setRegistryName("blue_candle_cheese_cake");
		SPBlocks.purple_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.PURPLE_CANDLE).setRegistryName("purple_candle_cheese_cake");
		SPBlocks.magenta_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.MAGENTA_CANDLE).setRegistryName("magenta_candle_cheese_cake");
		SPBlocks.pink_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.PINK_CANDLE).setRegistryName("pink_candle_cheese_cake");
		SPBlocks.brown_candle_cheese_cake = new BlockCandleCheeseCake(Blocks.BROWN_CANDLE).setRegistryName("brown_candle_cheese_cake");
		SPBlocks.sponge_cake = new BlockSpongeCake().setRegistryName("sponge_cake");
		SPBlocks.candle_sponge_cake = new BlockCandleSpongeCake(Blocks.CANDLE).setRegistryName("candle_sponge_cake");
		SPBlocks.white_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.WHITE_CANDLE).setRegistryName("white_candle_sponge_cake");
		SPBlocks.light_grey_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.LIGHT_GRAY_CANDLE).setRegistryName("light_grey_candle_sponge_cake");
		SPBlocks.grey_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.GRAY_CANDLE).setRegistryName("grey_candle_sponge_cake");
		SPBlocks.black_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.BLACK_CANDLE).setRegistryName("black_candle_sponge_cake");
		SPBlocks.red_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.RED_CANDLE).setRegistryName("red_candle_sponge_cake");
		SPBlocks.orange_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.ORANGE_CANDLE).setRegistryName("orange_candle_sponge_cake");
		SPBlocks.yellow_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.YELLOW_CANDLE).setRegistryName("yellow_candle_sponge_cake");
		SPBlocks.lime_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.LIME_CANDLE).setRegistryName("lime_candle_sponge_cake");
		SPBlocks.green_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.GREEN_CANDLE).setRegistryName("green_candle_sponge_cake");
		SPBlocks.light_blue_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.LIGHT_BLUE_CANDLE).setRegistryName("light_blue_candle_sponge_cake");
		SPBlocks.cyan_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.CYAN_CANDLE).setRegistryName("cyan_candle_sponge_cake");
		SPBlocks.blue_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.BLUE_CANDLE).setRegistryName("blue_candle_sponge_cake");
		SPBlocks.purple_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.PURPLE_CANDLE).setRegistryName("purple_candle_sponge_cake");
		SPBlocks.magenta_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.MAGENTA_CANDLE).setRegistryName("magenta_candle_sponge_cake");
		SPBlocks.pink_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.PINK_CANDLE).setRegistryName("pink_candle_sponge_cake");
		SPBlocks.brown_candle_sponge_cake = new BlockCandleSpongeCake(Blocks.BROWN_CANDLE).setRegistryName("brown_candle_sponge_cake");
		SPBlocks.tin_ore = new SPBlockOre(SPBlockOre.Resource.TIER_1, false).setRegistryName("tin_ore");
		SPBlocks.deepslate_tin_ore = new SPBlockOre(SPBlockOre.Resource.TIER_1_DEEPSLATE, false).setRegistryName("deepslate_tin_ore");
		SPBlocks.bronze_block = new SPBlockMetal(MaterialColor.COLOR_BROWN, SPBlockMetal.Resource.TIER_1).setRegistryName("bronze_block");
		SPBlocks.raw_titanium_block = new SPBlockMetal(MaterialColor.DIAMOND, SPBlockMetal.Resource.TIER_2).setRegistryName("raw_titanium_block");
		SPBlocks.titanium_block = new SPBlockMetal(MaterialColor.DIAMOND, SPBlockMetal.Resource.TIER_2).setRegistryName("titanium_block");
		SPBlocks.titanium_ore = new SPBlockOre(SPBlockOre.Resource.TIER_2, false).setRegistryName("titanium_ore");
		SPBlocks.deepslate_titanium_ore = new SPBlockOre(SPBlockOre.Resource.TIER_2_DEEPSLATE, false).setRegistryName("deepslate_titanium_ore");
		SPBlocks.cardboard = new BlockCardboard(MaterialColor.WOOD).setRegistryName("cardboard");
		SPBlocks.cardboard_white = new BlockCardboard(MaterialColor.SNOW).setRegistryName("cardboard_white");
		SPBlocks.cardboard_light_grey = new BlockCardboard(MaterialColor.COLOR_LIGHT_GRAY).setRegistryName("cardboard_light_grey");
		SPBlocks.cardboard_grey = new BlockCardboard(MaterialColor.COLOR_GRAY).setRegistryName("cardboard_grey");
		SPBlocks.cardboard_black = new BlockCardboard(MaterialColor.COLOR_BLACK).setRegistryName("cardboard_black");
		SPBlocks.cardboard_red = new BlockCardboard(MaterialColor.COLOR_RED).setRegistryName("cardboard_red");
		SPBlocks.cardboard_orange = new BlockCardboard(MaterialColor.COLOR_ORANGE).setRegistryName("cardboard_orange");
		SPBlocks.cardboard_yellow = new BlockCardboard(MaterialColor.COLOR_YELLOW).setRegistryName("cardboard_yellow");
		SPBlocks.cardboard_lime = new BlockCardboard(MaterialColor.COLOR_LIGHT_GREEN).setRegistryName("cardboard_lime");
		SPBlocks.cardboard_green = new BlockCardboard(MaterialColor.COLOR_GREEN).setRegistryName("cardboard_green");
		SPBlocks.cardboard_light_blue = new BlockCardboard(MaterialColor.COLOR_LIGHT_BLUE).setRegistryName("cardboard_light_blue");
		SPBlocks.cardboard_cyan = new BlockCardboard(MaterialColor.COLOR_CYAN).setRegistryName("cardboard_cyan");
		SPBlocks.cardboard_blue = new BlockCardboard(MaterialColor.COLOR_BLUE).setRegistryName("cardboard_blue");
		SPBlocks.cardboard_purple = new BlockCardboard(MaterialColor.COLOR_PURPLE).setRegistryName("cardboard_purple");
		SPBlocks.cardboard_magenta = new BlockCardboard(MaterialColor.COLOR_MAGENTA).setRegistryName("cardboard_magenta");
		SPBlocks.cardboard_pink = new BlockCardboard(MaterialColor.COLOR_PINK).setRegistryName("cardboard_pink");
		SPBlocks.cardboard_brown = new BlockCardboard(MaterialColor.COLOR_BROWN).setRegistryName("cardboard_brown");
		SPBlocks.cardboard_lantern = new BlockCardboardLantern(MaterialColor.WOOD, false).setRegistryName("cardboard_lantern");
		SPBlocks.cardboard_lantern_white = new BlockCardboardLantern(MaterialColor.SNOW, true).setRegistryName("cardboard_lantern_white");
		SPBlocks.cardboard_lantern_light_grey = new BlockCardboardLantern(MaterialColor.COLOR_LIGHT_GRAY, true).setRegistryName("cardboard_lantern_light_grey");
		SPBlocks.cardboard_lantern_grey = new BlockCardboardLantern(MaterialColor.COLOR_GRAY, true).setRegistryName("cardboard_lantern_grey");
		SPBlocks.cardboard_lantern_black = new BlockCardboardLantern(MaterialColor.COLOR_BLACK, true).setRegistryName("cardboard_lantern_black");
		SPBlocks.cardboard_lantern_red = new BlockCardboardLantern(MaterialColor.COLOR_RED, true).setRegistryName("cardboard_lantern_red");
		SPBlocks.cardboard_lantern_orange = new BlockCardboardLantern(MaterialColor.COLOR_ORANGE, true).setRegistryName("cardboard_lantern_orange");
		SPBlocks.cardboard_lantern_yellow = new BlockCardboardLantern(MaterialColor.COLOR_YELLOW, true).setRegistryName("cardboard_lantern_yellow");
		SPBlocks.cardboard_lantern_lime = new BlockCardboardLantern(MaterialColor.COLOR_LIGHT_GREEN, true).setRegistryName("cardboard_lantern_lime");
		SPBlocks.cardboard_lantern_green = new BlockCardboardLantern(MaterialColor.COLOR_GREEN, true).setRegistryName("cardboard_lantern_green");
		SPBlocks.cardboard_lantern_light_blue = new BlockCardboardLantern(MaterialColor.COLOR_LIGHT_BLUE, true).setRegistryName("cardboard_lantern_light_blue");
		SPBlocks.cardboard_lantern_cyan = new BlockCardboardLantern(MaterialColor.COLOR_CYAN, true).setRegistryName("cardboard_lantern_cyan");
		SPBlocks.cardboard_lantern_blue = new BlockCardboardLantern(MaterialColor.COLOR_BLUE, true).setRegistryName("cardboard_lantern_blue");
		SPBlocks.cardboard_lantern_purple = new BlockCardboardLantern(MaterialColor.COLOR_PURPLE, true).setRegistryName("cardboard_lantern_purple");
		SPBlocks.cardboard_lantern_magenta = new BlockCardboardLantern(MaterialColor.COLOR_MAGENTA, true).setRegistryName("cardboard_lantern_magenta");
		SPBlocks.cardboard_lantern_pink = new BlockCardboardLantern(MaterialColor.COLOR_PINK, true).setRegistryName("cardboard_lantern_pink");
		SPBlocks.cardboard_lantern_brown = new BlockCardboardLantern(MaterialColor.COLOR_BROWN, true).setRegistryName("cardboard_lantern_brown");

	}

	public static void register()
	{
		registerBlock(SPBlocks.raw_tin_block);
		registerBlock(SPBlocks.tin_block);
		registerBlock(SPBlocks.onion);
		registerBlock(SPBlocks.tin_ore);
		registerBlock(SPBlocks.deepslate_tin_ore);
		registerBlock(SPBlocks.bronze_block);
		registerBlock(SPBlocks.raw_titanium_block);
		registerBlock(SPBlocks.titanium_block);
		registerBlock(SPBlocks.titanium_ore);
		registerBlock(SPBlocks.deepslate_titanium_ore);
		registerBlock(SPBlocks.cheese_cake);
		registerBlock(SPBlocks.candle_cheese_cake, false);
		registerBlock(SPBlocks.white_candle_cheese_cake, false);
		registerBlock(SPBlocks.light_grey_candle_cheese_cake, false);
		registerBlock(SPBlocks.grey_candle_cheese_cake, false);
		registerBlock(SPBlocks.black_candle_cheese_cake, false);
		registerBlock(SPBlocks.red_candle_cheese_cake, false);
		registerBlock(SPBlocks.orange_candle_cheese_cake, false);
		registerBlock(SPBlocks.yellow_candle_cheese_cake, false);
		registerBlock(SPBlocks.lime_candle_cheese_cake, false);
		registerBlock(SPBlocks.green_candle_cheese_cake, false);
		registerBlock(SPBlocks.light_blue_candle_cheese_cake, false);
		registerBlock(SPBlocks.cyan_candle_cheese_cake, false);
		registerBlock(SPBlocks.blue_candle_cheese_cake, false);
		registerBlock(SPBlocks.purple_candle_cheese_cake, false);
		registerBlock(SPBlocks.magenta_candle_cheese_cake, false);
		registerBlock(SPBlocks.pink_candle_cheese_cake, false);
		registerBlock(SPBlocks.brown_candle_cheese_cake, false);
		registerBlock(SPBlocks.sponge_cake);
		registerBlock(SPBlocks.candle_sponge_cake, false);
		registerBlock(SPBlocks.white_candle_sponge_cake, false);
		registerBlock(SPBlocks.light_grey_candle_sponge_cake, false);
		registerBlock(SPBlocks.grey_candle_sponge_cake, false);
		registerBlock(SPBlocks.black_candle_sponge_cake, false);
		registerBlock(SPBlocks.red_candle_sponge_cake, false);
		registerBlock(SPBlocks.orange_candle_sponge_cake, false);
		registerBlock(SPBlocks.yellow_candle_sponge_cake, false);
		registerBlock(SPBlocks.lime_candle_sponge_cake, false);
		registerBlock(SPBlocks.green_candle_sponge_cake, false);
		registerBlock(SPBlocks.light_blue_candle_sponge_cake, false);
		registerBlock(SPBlocks.cyan_candle_sponge_cake, false);
		registerBlock(SPBlocks.blue_candle_sponge_cake, false);
		registerBlock(SPBlocks.purple_candle_sponge_cake, false);
		registerBlock(SPBlocks.magenta_candle_sponge_cake, false);
		registerBlock(SPBlocks.pink_candle_sponge_cake, false);
		registerBlock(SPBlocks.brown_candle_sponge_cake, false);
		registerBlock(SPBlocks.cardboard);
		registerBlock(SPBlocks.cardboard_white);
		registerBlock(SPBlocks.cardboard_light_grey);
		registerBlock(SPBlocks.cardboard_grey);
		registerBlock(SPBlocks.cardboard_black);
		registerBlock(SPBlocks.cardboard_red);
		registerBlock(SPBlocks.cardboard_orange);
		registerBlock(SPBlocks.cardboard_yellow);
		registerBlock(SPBlocks.cardboard_lime);
		registerBlock(SPBlocks.cardboard_green);
		registerBlock(SPBlocks.cardboard_light_blue);
		registerBlock(SPBlocks.cardboard_cyan);
		registerBlock(SPBlocks.cardboard_blue);
		registerBlock(SPBlocks.cardboard_purple);
		registerBlock(SPBlocks.cardboard_magenta);
		registerBlock(SPBlocks.cardboard_pink);
		registerBlock(SPBlocks.cardboard_brown);
		registerBlock(SPBlocks.cardboard_lantern);
		registerBlock(SPBlocks.cardboard_lantern_white);
		registerBlock(SPBlocks.cardboard_lantern_light_grey);
		registerBlock(SPBlocks.cardboard_lantern_grey);
		registerBlock(SPBlocks.cardboard_lantern_black);
		registerBlock(SPBlocks.cardboard_lantern_red);
		registerBlock(SPBlocks.cardboard_lantern_orange);
		registerBlock(SPBlocks.cardboard_lantern_yellow);
		registerBlock(SPBlocks.cardboard_lantern_lime);
		registerBlock(SPBlocks.cardboard_lantern_green);
		registerBlock(SPBlocks.cardboard_lantern_light_blue);
		registerBlock(SPBlocks.cardboard_lantern_cyan);
		registerBlock(SPBlocks.cardboard_lantern_blue);
		registerBlock(SPBlocks.cardboard_lantern_purple);
		registerBlock(SPBlocks.cardboard_lantern_magenta);
		registerBlock(SPBlocks.cardboard_lantern_pink);
		registerBlock(SPBlocks.cardboard_lantern_brown);
	}

	public static void registerBlock(Block block) {

		registerBlock(block, true);
	}

	public static void registerBlock(Block block, boolean regsiterItem) {

		ForgeRegistries.BLOCKS.register(block);
		if(regsiterItem)
			registerBlockItem(block);
	}

	public static void registerBlockItem(Block block) {

		BlockItem BlockItem;
		if(block instanceof AmethystBlock) {
			BlockItem = new BlockItem(block, new Item.Properties().tab(SPTabs.tabGem));	
		} else if(block == SPBlocks.onion) {
			BlockItem = new BlockItem(block, new Item.Properties());
		} else if(block == SPBlocks.cheese_cake || block == SPBlocks.sponge_cake) {
			BlockItem = new BlockItem(block, new Item.Properties().tab(SPTabs.tabFood).stacksTo(1));
		} else if (block instanceof BlockCardboardLantern) {
			BlockItem = new ItemCardboardLantern(block, new Item.Properties().tab(SPTabs.tabBlocks));
		} else {
			BlockItem = new BlockItem(block, new Item.Properties().tab(SPTabs.tabBlocks));
		}

		BlockItem.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(BlockItem);
	}
}
