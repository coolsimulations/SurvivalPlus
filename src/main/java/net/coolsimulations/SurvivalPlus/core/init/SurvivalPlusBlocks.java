package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystal;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockMetal;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockOre;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCampfire;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboard;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCheeseCake;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockOnionCrop;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockSpongeCake;
import net.coolsimulations.SurvivalPlus.core.items.ItemCardboardLantern;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class SurvivalPlusBlocks {

	public static void init()
	{
		SPBlocks.copper_block = new SPBlockMetal(0, true).setUnlocalizedName("copper_block").setRegistryName("copper_block").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.tin_block = new SPBlockMetal(0, true).setUnlocalizedName("tin_block").setRegistryName("tin_block").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.onion = new BlockOnionCrop().setUnlocalizedName("onion").setRegistryName("onion");
		SPBlocks.cheese_cake = new BlockCheeseCake().setUnlocalizedName("cheese_cake").setRegistryName("cheese_cake").setCreativeTab(SPTabs.tabFood);
		SPBlocks.sponge_cake = new BlockSpongeCake().setUnlocalizedName("sponge_cake").setRegistryName("sponge_cake").setCreativeTab(SPTabs.tabFood); 
		SPBlocks.copper_ore = new SPBlockOre(1, false).setUnlocalizedName("copper_ore").setRegistryName("copper_ore").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.tin_ore = new SPBlockOre(1, false).setUnlocalizedName("tin_ore").setRegistryName("tin_ore").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.amethyst = new SPBlockCrystal().setUnlocalizedName("amethyst").setRegistryName("amethyst").setCreativeTab(SPTabs.tabGem);
		SPBlocks.ruby = new SPBlockCrystal().setUnlocalizedName("ruby").setRegistryName("ruby").setCreativeTab(SPTabs.tabGem);
		SPBlocks.bronze_block = new SPBlockMetal(1, true).setUnlocalizedName("bronze_block").setRegistryName("bronze_block").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.titanium_block = new SPBlockMetal(2, true).setUnlocalizedName("titanium_block").setRegistryName("titanium_block").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.titanium_ore = new SPBlockOre(2, false).setUnlocalizedName("titanium_ore").setRegistryName("titanium_ore").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.pearl = new SPBlockCrystal().setUnlocalizedName("pearl").setRegistryName("pearl").setCreativeTab(SPTabs.tabGem);
		SPBlocks.topaz = new SPBlockCrystal().setUnlocalizedName("topaz").setRegistryName("topaz").setCreativeTab(SPTabs.tabGem);
		SPBlocks.sapphire = new SPBlockCrystal().setUnlocalizedName("sapphire").setRegistryName("sapphire").setCreativeTab(SPTabs.tabGem);
		SPBlocks.spinel = new SPBlockCrystal().setUnlocalizedName("spinel").setRegistryName("spinel").setCreativeTab(SPTabs.tabGem);
		SPBlocks.cardboard = new BlockCardboard().setUnlocalizedName("cardboard").setRegistryName("cardboard").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_white = new BlockCardboard().setUnlocalizedName("cardboard_white").setRegistryName("cardboard_white").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_light_grey = new BlockCardboard().setUnlocalizedName("cardboard_light_grey").setRegistryName("cardboard_light_grey").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_grey = new BlockCardboard().setUnlocalizedName("cardboard_grey").setRegistryName("cardboard_grey").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_black = new BlockCardboard().setUnlocalizedName("cardboard_black").setRegistryName("cardboard_black").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_red = new BlockCardboard().setUnlocalizedName("cardboard_red").setRegistryName("cardboard_red").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_orange = new BlockCardboard().setUnlocalizedName("cardboard_orange").setRegistryName("cardboard_orange").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_yellow = new BlockCardboard().setUnlocalizedName("cardboard_yellow").setRegistryName("cardboard_yellow").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lime = new BlockCardboard().setUnlocalizedName("cardboard_lime").setRegistryName("cardboard_lime").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_green = new BlockCardboard().setUnlocalizedName("cardboard_green").setRegistryName("cardboard_green").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_light_blue = new BlockCardboard().setUnlocalizedName("cardboard_light_blue").setRegistryName("cardboard_light_blue").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_cyan = new BlockCardboard().setUnlocalizedName("cardboard_cyan").setRegistryName("cardboard_cyan").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_blue = new BlockCardboard().setUnlocalizedName("cardboard_blue").setRegistryName("cardboard_blue").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_purple = new BlockCardboard().setUnlocalizedName("cardboard_purple").setRegistryName("cardboard_purple").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_magenta = new BlockCardboard().setUnlocalizedName("cardboard_magenta").setRegistryName("cardboard_magenta").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_pink = new BlockCardboard().setUnlocalizedName("cardboard_pink").setRegistryName("cardboard_pink").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_brown = new BlockCardboard().setUnlocalizedName("cardboard_brown").setRegistryName("cardboard_brown").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern = new BlockCardboardLantern(false).setUnlocalizedName("cardboard_lantern").setRegistryName("cardboard_lantern").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_white = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_white").setRegistryName("cardboard_lantern_white").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_light_grey = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_light_grey").setRegistryName("cardboard_lantern_light_grey").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_grey = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_grey").setRegistryName("cardboard_lantern_grey").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_black = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_black").setRegistryName("cardboard_lantern_black").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_red = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_red").setRegistryName("cardboard_lantern_red").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_orange = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_orange").setRegistryName("cardboard_lantern_orange").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_yellow = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_yellow").setRegistryName("cardboard_lantern_yellow").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_lime = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_lime").setRegistryName("cardboard_lantern_lime").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_green = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_green").setRegistryName("cardboard_lantern_green").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_light_blue = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_light_blue").setRegistryName("cardboard_lantern_light_blue").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_cyan = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_cyan").setRegistryName("cardboard_lantern_cyan").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_blue = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_blue").setRegistryName("cardboard_lantern_blue").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_purple = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_purple").setRegistryName("cardboard_lantern_purple").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_magenta = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_magenta").setRegistryName("cardboard_lantern_magenta").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_pink = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_pink").setRegistryName("cardboard_lantern_pink").setCreativeTab(SPTabs.tabBlocks);
		SPBlocks.cardboard_lantern_brown = new BlockCardboardLantern(true).setUnlocalizedName("cardboard_lantern_brown").setRegistryName("cardboard_lantern_brown").setCreativeTab(SPTabs.tabBlocks);

		SPBlocks.campfire = new BlockCampfire(false).setUnlocalizedName("campfire").setRegistryName("campfire").setCreativeTab(SPTabs.tabBlocks);
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

		registerBlock(SPBlocks.campfire);
	}

	public static void registerRenders()
	{
		registerRender(SPBlocks.copper_block);
		registerRender(SPBlocks.tin_block);
		registerRender(SPBlocks.onion);
		registerRender(SPBlocks.copper_ore);
		registerRender(SPBlocks.tin_ore);
		registerRender(SPBlocks.amethyst);
		registerRender(SPBlocks.bronze_block);
		registerRender(SPBlocks.titanium_block);
		registerRender(SPBlocks.titanium_ore);
		registerRender(SPBlocks.ruby);
		registerRender(SPBlocks.cheese_cake);
		registerRender(SPBlocks.sponge_cake);
		registerRender(SPBlocks.pearl);
		registerRender(SPBlocks.topaz);
		registerRender(SPBlocks.sapphire);
		registerRender(SPBlocks.spinel);
		registerRender(SPBlocks.cardboard);
		registerRender(SPBlocks.cardboard_white);
		registerRender(SPBlocks.cardboard_light_grey);
		registerRender(SPBlocks.cardboard_grey);
		registerRender(SPBlocks.cardboard_black);
		registerRender(SPBlocks.cardboard_red);
		registerRender(SPBlocks.cardboard_orange);
		registerRender(SPBlocks.cardboard_yellow);
		registerRender(SPBlocks.cardboard_lime);
		registerRender(SPBlocks.cardboard_green);
		registerRender(SPBlocks.cardboard_light_blue);
		registerRender(SPBlocks.cardboard_cyan);
		registerRender(SPBlocks.cardboard_blue);
		registerRender(SPBlocks.cardboard_purple);
		registerRender(SPBlocks.cardboard_magenta);
		registerRender(SPBlocks.cardboard_pink);
		registerRender(SPBlocks.cardboard_brown);
		registerRender(SPBlocks.cardboard_lantern);
		registerRender(SPBlocks.cardboard_lantern_white);
		registerRender(SPBlocks.cardboard_lantern_light_grey);
		registerRender(SPBlocks.cardboard_lantern_grey);
		registerRender(SPBlocks.cardboard_lantern_black);
		registerRender(SPBlocks.cardboard_lantern_red);
		registerRender(SPBlocks.cardboard_lantern_orange);
		registerRender(SPBlocks.cardboard_lantern_yellow);
		registerRender(SPBlocks.cardboard_lantern_lime);
		registerRender(SPBlocks.cardboard_lantern_green);
		registerRender(SPBlocks.cardboard_lantern_light_blue);
		registerRender(SPBlocks.cardboard_lantern_cyan);
		registerRender(SPBlocks.cardboard_lantern_blue);
		registerRender(SPBlocks.cardboard_lantern_purple);
		registerRender(SPBlocks.cardboard_lantern_magenta);
		registerRender(SPBlocks.cardboard_lantern_pink);
		registerRender(SPBlocks.cardboard_lantern_brown);

		registerRender(SPBlocks.campfire);
	}

	public static void registerBlock(Block block) {

		if(block == SPBlocks.cheese_cake || block == SPBlocks.sponge_cake) {
			SurvivalPlus.ITEMS.add(new ItemBlock(block).setRegistryName(block.getRegistryName()).setMaxStackSize(1));
		} else if (block instanceof BlockCardboardLantern) {
			SurvivalPlus.ITEMS.add(new ItemCardboardLantern(block).setRegistryName(block.getRegistryName()));
		} else {
			SurvivalPlus.ITEMS.add(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		}
		SurvivalPlus.BLOCKS.add(block);
	}

	public static void registerBlocks(IForgeRegistry<Block> registry) {

		for (Block block: SurvivalPlus.BLOCKS)
		{
			registry.register(block);
		}
	}

	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

}
