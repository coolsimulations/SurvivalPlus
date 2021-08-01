package net.coolsimulations.SurvivalPlus.primer.init;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockMetal;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockOre;
import net.coolsimulations.SurvivalPlus.primer.blocks.SPBlockCrystal;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusPrimerBlocks {

	public static Block copper_block;
	public static Block copper_ore;
	public static Block amethyst;
	public static Block ruby;
	public static Block pearl;
	public static Block topaz;
	public static Block sapphire;
	public static Block spinel;

	public static void init() {

		copper_block = new SPBlockMetal(MaterialColor.COLOR_BROWN, SPBlockMetal.Resource.TIER_0).setRegistryName(SPReference.MOD_ID, "copper_block");
		copper_ore = new SPBlockOre(SPBlockOre.Resource.TIER_1, false).setRegistryName(SPReference.MOD_ID, "copper_ore");
		amethyst = new SPBlockCrystal(MaterialColor.COLOR_PURPLE).setRegistryName(SPReference.MOD_ID, "amethyst");
		ruby = new SPBlockCrystal(MaterialColor.COLOR_RED).setRegistryName(SPReference.MOD_ID, "ruby");
		pearl = new SPBlockCrystal(MaterialColor.SNOW).setRegistryName(SPReference.MOD_ID, "pearl");
		topaz = new SPBlockCrystal(MaterialColor.COLOR_YELLOW).setRegistryName(SPReference.MOD_ID, "topaz");
		sapphire = new SPBlockCrystal(MaterialColor.COLOR_BLUE).setRegistryName(SPReference.MOD_ID, "sapphire");
		spinel = new SPBlockCrystal(MaterialColor.COLOR_BLACK).setRegistryName(SPReference.MOD_ID, "spinel");

	}

	public static void register() {

		registerBlock(copper_block);
		registerBlock(copper_ore);
		registerBlock(amethyst);
		registerBlock(ruby);
		registerBlock(pearl, false);
		registerBlock(topaz);
		registerBlock(sapphire);
		registerBlock(spinel);

	}
	
	public static void registerBlock(Block block) {
		registerBlock(block, true);
	}

	public static void registerBlock(Block block, boolean registerItem) {

		BlockItem blockItem;

		if(block instanceof SPBlockCrystal) {
			blockItem = new BlockItem(block, new Item.Properties().tab(SPTabs.tabGem));	
		} else {
			blockItem = new BlockItem(block, new Item.Properties().tab(SPTabs.tabBlocks));
		}

		blockItem.setRegistryName(block.getRegistryName());
		ForgeRegistries.BLOCKS.register(block);
		if(registerItem)
			ForgeRegistries.ITEMS.register(blockItem);
	}

}
