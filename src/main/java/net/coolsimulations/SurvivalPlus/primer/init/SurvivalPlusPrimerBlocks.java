package net.coolsimulations.SurvivalPlus.primer.init;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockMetal;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockOre;
import net.coolsimulations.SurvivalPlus.primer.blocks.SPBlockCrystal;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;

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

		copper_block = new SPBlockMetal(MaterialColor.COLOR_BROWN, SPBlockMetal.Resource.TIER_0);
		copper_ore = new SPBlockOre(SPBlockOre.Resource.TIER_1, false);
		amethyst = new SPBlockCrystal(MaterialColor.COLOR_PURPLE);
		ruby = new SPBlockCrystal(MaterialColor.COLOR_RED);
		pearl = new SPBlockCrystal(MaterialColor.SNOW);
		topaz = new SPBlockCrystal(MaterialColor.COLOR_YELLOW);
		sapphire = new SPBlockCrystal(MaterialColor.COLOR_BLUE);
		spinel = new SPBlockCrystal(MaterialColor.COLOR_BLACK);

	}

	public static void register() {

		registerBlock(copper_block, "copper_block");
		registerBlock(copper_ore, "copper_ore");
		registerBlock(amethyst, "amethyst");
		registerBlock(ruby, "ruby");
		registerBlock(pearl, "pearl", false);
		registerBlock(topaz, "topaz");
		registerBlock(sapphire, "sapphire");
		registerBlock(spinel, "spinel");

	}
	
	public static void registerBlock(Block block, String registryName) {
		registerBlock(block, registryName, true);
	}

	public static void registerBlock(Block block, String registryName, boolean registerItem) {

		Registry.register(Registry.BLOCK, new ResourceLocation(SPReference.MOD_ID, registryName), block);
		
		if(registerItem) {
			BlockItem blockItem;

			if(block instanceof SPBlockCrystal) {
				blockItem = new BlockItem(block, new FabricItemSettings().group(SPTabs.tabGem));	
			} else {
				blockItem = new BlockItem(block, new FabricItemSettings().group(SPTabs.tabBlocks));
			}
			Registry.register(Registry.ITEM, new ResourceLocation(SPReference.MOD_ID, registryName), blockItem);
		}
	}

}
