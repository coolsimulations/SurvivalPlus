package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystal;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockMetal;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockOre;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboard;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCheeseCake;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockOnionCrop;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockSpongeCake;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class SurvivalPlusBlocks {
	
	public static void init()
	{
		SPBlocks.copper_block = new SPBlockMetal(SPBlockMetal.Resource.TIER_0).setRegistryName("copper_block");
		SPBlocks.tin_block = new SPBlockMetal(SPBlockMetal.Resource.TIER_0).setRegistryName("tin_block");
		SPBlocks.onion = new BlockOnionCrop().setRegistryName("onion");
		SPBlocks.cheese_cake = new BlockCheeseCake().setRegistryName("cheese_cake");
		SPBlocks.sponge_cake = new BlockSpongeCake().setRegistryName("sponge_cake");
		SPBlocks.copper_ore = new SPBlockOre(SPBlockOre.Resource.TIER_1, false).setRegistryName("copper_ore");
		SPBlocks.tin_ore = new SPBlockOre(SPBlockOre.Resource.TIER_1, false).setRegistryName("tin_ore");
		SPBlocks.amethyst = new SPBlockCrystal().setRegistryName("amethyst");
		SPBlocks.ruby = new SPBlockCrystal().setRegistryName("ruby");
		SPBlocks.bronze_block = new SPBlockMetal(SPBlockMetal.Resource.TIER_1).setRegistryName("bronze_block");
		SPBlocks.titanium_block = new SPBlockOre(SPBlockOre.Resource.TIER_2, false).setRegistryName("titanium_block");
		SPBlocks.titanium_ore = new SPBlockMetal(SPBlockMetal.Resource.TIER_2).setRegistryName("titanium_ore");
		SPBlocks.pearl = new SPBlockCrystal().setRegistryName("pearl");
		SPBlocks.topaz = new SPBlockCrystal().setRegistryName("topaz");
		SPBlocks.sapphire = new SPBlockCrystal().setRegistryName("sapphire");
		SPBlocks.spinel = new SPBlockCrystal().setRegistryName("spinel");
		SPBlocks.cardboard = new BlockCardboard().setRegistryName("cardboard");
		SPBlocks.cardboard_white = new BlockCardboard().setRegistryName("cardboard_white");
		SPBlocks.cardboard_light_grey = new BlockCardboard().setRegistryName("cardboard_light_grey");
		SPBlocks.cardboard_grey = new BlockCardboard().setRegistryName("cardboard_grey");
		SPBlocks.cardboard_black = new BlockCardboard().setRegistryName("cardboard_black");
		SPBlocks.cardboard_red = new BlockCardboard().setRegistryName("cardboard_red");
		SPBlocks.cardboard_orange = new BlockCardboard().setRegistryName("cardboard_orange");
		SPBlocks.cardboard_yellow = new BlockCardboard().setRegistryName("cardboard_yellow");
		SPBlocks.cardboard_lime = new BlockCardboard().setRegistryName("cardboard_lime");
		SPBlocks.cardboard_green = new BlockCardboard().setRegistryName("cardboard_green");
		SPBlocks.cardboard_light_blue = new BlockCardboard().setRegistryName("cardboard_light_blue");
		SPBlocks.cardboard_cyan = new BlockCardboard().setRegistryName("cardboard_cyan");
		SPBlocks.cardboard_blue = new BlockCardboard().setRegistryName("cardboard_blue");
		SPBlocks.cardboard_purple = new BlockCardboard().setRegistryName("cardboard_purple");
		SPBlocks.cardboard_magenta = new BlockCardboard().setRegistryName("cardboard_magenta");
		SPBlocks.cardboard_pink = new BlockCardboard().setRegistryName("cardboard_pink");
		SPBlocks.cardboard_brown = new BlockCardboard().setRegistryName("cardboard_brown");
		
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
	}
	
	public static void registerBlock(Block block) {
		
		BlockItem BlockItem;
		if(block == SPBlocks.amethyst || block == SPBlocks.ruby || block == SPBlocks.pearl || block == SPBlocks.topaz || block == SPBlocks.sapphire || block == SPBlocks.spinel) {
			BlockItem = new BlockItem(block, new Item.Properties().group(SPTabs.tabGem));	
		} else if(block == SPBlocks.onion) {
			BlockItem = new BlockItem(block, new Item.Properties());
		} else if(block == SPBlocks.cheese_cake || block == SPBlocks.sponge_cake) {
			BlockItem = new BlockItem(block, new Item.Properties().group(SPTabs.tabFood));
		} else {
			BlockItem = new BlockItem(block, new Item.Properties().group(SPTabs.tabBlocks));
		}
		BlockItem.setRegistryName(block.getRegistryName());
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(BlockItem);
	}
}
