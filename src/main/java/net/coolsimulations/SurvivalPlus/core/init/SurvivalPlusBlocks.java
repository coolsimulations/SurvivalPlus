package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
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
import net.minecraft.block.Block;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusBlocks {

	public static void init()
	{
		SPBlocks.copper_block = new SPBlockMetal(MaterialColor.BROWN, SPBlockMetal.Resource.TIER_0, true).setRegistryName("copper_block");
		SPBlocks.tin_block = new SPBlockMetal(MaterialColor.IRON, SPBlockMetal.Resource.TIER_0, true).setRegistryName("tin_block");
		SPBlocks.onion = new BlockOnionCrop().setRegistryName("onion");
		SPBlocks.cheese_cake = new BlockCheeseCake().setRegistryName("cheese_cake");
		SPBlocks.sponge_cake = new BlockSpongeCake().setRegistryName("sponge_cake");
		SPBlocks.copper_ore = new SPBlockOre(SPBlockOre.Resource.TIER_1, false).setRegistryName("copper_ore");
		SPBlocks.tin_ore = new SPBlockOre(SPBlockOre.Resource.TIER_1, false).setRegistryName("tin_ore");
		SPBlocks.amethyst = new SPBlockCrystal(MaterialColor.PURPLE).setRegistryName("amethyst");
		SPBlocks.ruby = new SPBlockCrystal(MaterialColor.BROWN).setRegistryName("ruby");
		SPBlocks.bronze_block = new SPBlockMetal(MaterialColor.RED, SPBlockMetal.Resource.TIER_1, true).setRegistryName("bronze_block");
		SPBlocks.titanium_block = new SPBlockMetal(MaterialColor.DIAMOND, SPBlockMetal.Resource.TIER_2, true).setRegistryName("titanium_block");
		SPBlocks.titanium_ore = new SPBlockOre(SPBlockOre.Resource.TIER_2, false).setRegistryName("titanium_ore");
		SPBlocks.pearl = new SPBlockCrystal(MaterialColor.SNOW).setRegistryName("pearl");
		SPBlocks.topaz = new SPBlockCrystal(MaterialColor.YELLOW).setRegistryName("topaz");
		SPBlocks.sapphire = new SPBlockCrystal(MaterialColor.BLUE).setRegistryName("sapphire");
		SPBlocks.spinel = new SPBlockCrystal(MaterialColor.BLACK).setRegistryName("spinel");
		SPBlocks.cardboard = new BlockCardboard(MaterialColor.WOOD).setRegistryName("cardboard");
		SPBlocks.cardboard_white = new BlockCardboard(MaterialColor.SNOW).setRegistryName("cardboard_white");
		SPBlocks.cardboard_light_grey = new BlockCardboard(MaterialColor.LIGHT_GRAY).setRegistryName("cardboard_light_grey");
		SPBlocks.cardboard_grey = new BlockCardboard(MaterialColor.GRAY).setRegistryName("cardboard_grey");
		SPBlocks.cardboard_black = new BlockCardboard(MaterialColor.BLACK).setRegistryName("cardboard_black");
		SPBlocks.cardboard_red = new BlockCardboard(MaterialColor.RED).setRegistryName("cardboard_red");
		SPBlocks.cardboard_orange = new BlockCardboard(MaterialColor.ADOBE).setRegistryName("cardboard_orange");
		SPBlocks.cardboard_yellow = new BlockCardboard(MaterialColor.YELLOW).setRegistryName("cardboard_yellow");
		SPBlocks.cardboard_lime = new BlockCardboard(MaterialColor.LIME).setRegistryName("cardboard_lime");
		SPBlocks.cardboard_green = new BlockCardboard(MaterialColor.GREEN).setRegistryName("cardboard_green");
		SPBlocks.cardboard_light_blue = new BlockCardboard(MaterialColor.LIGHT_BLUE).setRegistryName("cardboard_light_blue");
		SPBlocks.cardboard_cyan = new BlockCardboard(MaterialColor.CYAN).setRegistryName("cardboard_cyan");
		SPBlocks.cardboard_blue = new BlockCardboard(MaterialColor.BLUE).setRegistryName("cardboard_blue");
		SPBlocks.cardboard_purple = new BlockCardboard(MaterialColor.PURPLE).setRegistryName("cardboard_purple");
		SPBlocks.cardboard_magenta = new BlockCardboard(MaterialColor.MAGENTA).setRegistryName("cardboard_magenta");
		SPBlocks.cardboard_pink = new BlockCardboard(MaterialColor.PINK).setRegistryName("cardboard_pink");
		SPBlocks.cardboard_brown = new BlockCardboard(MaterialColor.BROWN).setRegistryName("cardboard_brown");
		SPBlocks.cardboard_lantern = new BlockCardboardLantern(MaterialColor.WOOD, false).setRegistryName("cardboard_lantern");
		SPBlocks.cardboard_lantern_white = new BlockCardboardLantern(MaterialColor.SNOW, true).setRegistryName("cardboard_lantern_white");
		SPBlocks.cardboard_lantern_light_grey = new BlockCardboardLantern(MaterialColor.LIGHT_GRAY, true).setRegistryName("cardboard_lantern_light_grey");
		SPBlocks.cardboard_lantern_grey = new BlockCardboardLantern(MaterialColor.GRAY, true).setRegistryName("cardboard_lantern_grey");
		SPBlocks.cardboard_lantern_black = new BlockCardboardLantern(MaterialColor.BLACK, true).setRegistryName("cardboard_lantern_black");
		SPBlocks.cardboard_lantern_red = new BlockCardboardLantern(MaterialColor.RED, true).setRegistryName("cardboard_lantern_red");
		SPBlocks.cardboard_lantern_orange = new BlockCardboardLantern(MaterialColor.ADOBE, true).setRegistryName("cardboard_lantern_orange");
		SPBlocks.cardboard_lantern_yellow = new BlockCardboardLantern(MaterialColor.YELLOW, true).setRegistryName("cardboard_lantern_yellow");
		SPBlocks.cardboard_lantern_lime = new BlockCardboardLantern(MaterialColor.LIME, true).setRegistryName("cardboard_lantern_lime");
		SPBlocks.cardboard_lantern_green = new BlockCardboardLantern(MaterialColor.GREEN, true).setRegistryName("cardboard_lantern_green");
		SPBlocks.cardboard_lantern_light_blue = new BlockCardboardLantern(MaterialColor.LIGHT_BLUE, true).setRegistryName("cardboard_lantern_light_blue");
		SPBlocks.cardboard_lantern_cyan = new BlockCardboardLantern(MaterialColor.CYAN, true).setRegistryName("cardboard_lantern_cyan");
		SPBlocks.cardboard_lantern_blue = new BlockCardboardLantern(MaterialColor.BLUE, true).setRegistryName("cardboard_lantern_blue");
		SPBlocks.cardboard_lantern_purple = new BlockCardboardLantern(MaterialColor.PURPLE, true).setRegistryName("cardboard_lantern_purple");
		SPBlocks.cardboard_lantern_magenta = new BlockCardboardLantern(MaterialColor.MAGENTA, true).setRegistryName("cardboard_lantern_magenta");
		SPBlocks.cardboard_lantern_pink = new BlockCardboardLantern(MaterialColor.PINK, true).setRegistryName("cardboard_lantern_pink");
		SPBlocks.cardboard_lantern_brown = new BlockCardboardLantern(MaterialColor.BROWN, true).setRegistryName("cardboard_lantern_brown");

	}

	public static void register()
	{
		registerBlock(SPBlocks.copper_block);
		registerBlock(SPBlocks.tin_block);
		registerBlock(SPBlocks.onion);
		registerBlock(SPBlocks.copper_ore);
		registerBlock(SPBlocks.tin_ore);
		registerBlock(SPBlocks.amethyst);
		registerBlock(SPBlocks.bronze_block);
		registerBlock(SPBlocks.titanium_block);
		registerBlock(SPBlocks.titanium_ore);
		registerBlock(SPBlocks.ruby);
		registerBlock(SPBlocks.cheese_cake);
		registerBlock(SPBlocks.sponge_cake);
		registerBlock(SPBlocks.pearl);
		registerBlock(SPBlocks.topaz);
		registerBlock(SPBlocks.sapphire);
		registerBlock(SPBlocks.spinel);
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

		BlockItem BlockItem;
		if(block instanceof SPBlockCrystal) {
			BlockItem = new BlockItem(block, new Item.Properties().group(SPTabs.tabGem));	
		} else if(block == SPBlocks.onion) {
			BlockItem = new BlockItem(block, new Item.Properties());
		} else if(block == SPBlocks.cheese_cake || block == SPBlocks.sponge_cake) {
			BlockItem = new BlockItem(block, new Item.Properties().group(SPTabs.tabFood).maxStackSize(1));
		} else if (block instanceof BlockCardboardLantern) {
			BlockItem = new ItemCardboardLantern(block, new Item.Properties().group(SPTabs.tabBlocks));
		} else {
			BlockItem = new BlockItem(block, new Item.Properties().group(SPTabs.tabBlocks));
		}
		BlockItem.setRegistryName(block.getRegistryName());
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(BlockItem);
	}
}
