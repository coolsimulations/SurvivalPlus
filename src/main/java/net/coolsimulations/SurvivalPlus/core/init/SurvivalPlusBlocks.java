package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystal;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockMetal;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockOre;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;

public class SurvivalPlusBlocks {

	public static void init()
	{
		SPBlocks.copper_block = new SPBlockMetal(MaterialColor.COLOR_BROWN, SPBlockMetal.Resource.TIER_0);
		SPBlocks.tin_block = new SPBlockMetal(MaterialColor.METAL, SPBlockMetal.Resource.TIER_0);
		SPBlocks.onion = new BlockOnionCrop();
		SPBlocks.cheese_cake = new BlockCheeseCake();
		SPBlocks.sponge_cake = new BlockSpongeCake();
		SPBlocks.copper_ore = new SPBlockOre(SPBlockOre.Resource.TIER_1, false);
		SPBlocks.tin_ore = new SPBlockOre(SPBlockOre.Resource.TIER_1, false);
		SPBlocks.amethyst = new SPBlockCrystal(MaterialColor.COLOR_PURPLE);
		SPBlocks.ruby = new SPBlockCrystal(MaterialColor.COLOR_RED);
		SPBlocks.bronze_block = new SPBlockMetal(MaterialColor.COLOR_BROWN, SPBlockMetal.Resource.TIER_1);
		SPBlocks.titanium_block = new SPBlockMetal(MaterialColor.DIAMOND, SPBlockMetal.Resource.TIER_2);
		SPBlocks.titanium_ore = new SPBlockOre(SPBlockOre.Resource.TIER_2, false);
		SPBlocks.pearl = new SPBlockCrystal(MaterialColor.SNOW);
		SPBlocks.topaz = new SPBlockCrystal(MaterialColor.COLOR_YELLOW);
		SPBlocks.sapphire = new SPBlockCrystal(MaterialColor.COLOR_BLUE);
		SPBlocks.spinel = new SPBlockCrystal(MaterialColor.COLOR_BLACK);
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
		registerBlock(SPBlocks.copper_block, "copper_block");
		registerBlock(SPBlocks.tin_block, "tin_block");
		registerBlock(SPBlocks.onion, "onion");
		registerBlock(SPBlocks.copper_ore, "copper_ore");
		registerBlock(SPBlocks.tin_ore, "tin_ore");
		registerBlock(SPBlocks.amethyst, "amethyst");
		registerBlock(SPBlocks.bronze_block, "bronze_block");
		registerBlock(SPBlocks.titanium_block, "titanium_block");
		registerBlock(SPBlocks.titanium_ore, "titanium_ore");
		registerBlock(SPBlocks.ruby, "ruby");
		registerBlock(SPBlocks.cheese_cake, "cheese_cake");
		registerBlock(SPBlocks.sponge_cake, "sponge_cake");
		registerBlock(SPBlocks.pearl, "pearl");
		registerBlock(SPBlocks.topaz, "topaz");
		registerBlock(SPBlocks.sapphire, "sapphire");
		registerBlock(SPBlocks.spinel, "spinel");
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

		BlockItem BlockItem;
		if(block instanceof SPBlockCrystal) {
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
		Registry.register(Registry.BLOCK, new ResourceLocation(SPReference.MOD_ID, registryName), block);
		Registry.register(Registry.ITEM, new ResourceLocation(SPReference.MOD_ID, registryName), BlockItem);
	}

}
