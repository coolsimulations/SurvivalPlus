package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystal;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockMetal;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockOre;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCampfire;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboard;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCheeseCake;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockOnionCrop;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockSpongeCake;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SurvivalPlusBlocks {
	
	public static void init()
	{
		SPBlocks.copper_block = new SPBlockMetal(0).setUnlocalizedName("copper_block").setRegistryName("copper_block").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.tin_block = new SPBlockMetal(0).setUnlocalizedName("tin_block").setRegistryName("tin_block").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.onion = new BlockOnionCrop().setUnlocalizedName("onion").setRegistryName("onion");
		SPBlocks.cheese_cake = new BlockCheeseCake().setUnlocalizedName("cheese_cake").setRegistryName("cheese_cake").setCreativeTab(SurvivalPlus.tabFood);
		SPBlocks.sponge_cake = new BlockSpongeCake().setUnlocalizedName("sponge_cake").setRegistryName("sponge_cake").setCreativeTab(SurvivalPlus.tabFood); 
		SPBlocks.copper_ore = new SPBlockOre(1).setUnlocalizedName("copper_ore").setRegistryName("copper_ore").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.tin_ore = new SPBlockOre(1).setUnlocalizedName("tin_ore").setRegistryName("tin_ore").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.amethyst = new SPBlockCrystal().setUnlocalizedName("amethyst").setRegistryName("amethyst").setCreativeTab(SurvivalPlus.tabGem);
		SPBlocks.ruby = new SPBlockCrystal().setUnlocalizedName("ruby").setRegistryName("ruby").setCreativeTab(SurvivalPlus.tabGem);
		SPBlocks.bronze_block = new SPBlockMetal(1).setUnlocalizedName("bronze_block").setRegistryName("bronze_block").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.titanium_block = new SPBlockMetal(2).setUnlocalizedName("titanium_block").setRegistryName("titanium_block").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.titanium_ore = new SPBlockOre(2).setUnlocalizedName("titanium_ore").setRegistryName("titanium_ore").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.pearl = new SPBlockCrystal().setUnlocalizedName("pearl").setRegistryName("pearl").setCreativeTab(SurvivalPlus.tabGem);
		SPBlocks.topaz = new SPBlockCrystal().setUnlocalizedName("topaz").setRegistryName("topaz").setCreativeTab(SurvivalPlus.tabGem);
		SPBlocks.sapphire = new SPBlockCrystal().setUnlocalizedName("sapphire").setRegistryName("sapphire").setCreativeTab(SurvivalPlus.tabGem);
		SPBlocks.spinel = new SPBlockCrystal().setUnlocalizedName("spinel").setRegistryName("spinel").setCreativeTab(SurvivalPlus.tabGem);
		SPBlocks.cardboard = new BlockCardboard().setUnlocalizedName("cardboard").setRegistryName("cardboard").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_white = new BlockCardboard().setUnlocalizedName("cardboard_white").setRegistryName("cardboard_white").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_light_grey = new BlockCardboard().setUnlocalizedName("cardboard_light_grey").setRegistryName("cardboard_light_grey").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_grey = new BlockCardboard().setUnlocalizedName("cardboard_grey").setRegistryName("cardboard_grey").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_black = new BlockCardboard().setUnlocalizedName("cardboard_black").setRegistryName("cardboard_black").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_red = new BlockCardboard().setUnlocalizedName("cardboard_red").setRegistryName("cardboard_red").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_orange = new BlockCardboard().setUnlocalizedName("cardboard_orange").setRegistryName("cardboard_orange").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_yellow = new BlockCardboard().setUnlocalizedName("cardboard_yellow").setRegistryName("cardboard_yellow").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_lime = new BlockCardboard().setUnlocalizedName("cardboard_lime").setRegistryName("cardboard_lime").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_green = new BlockCardboard().setUnlocalizedName("cardboard_green").setRegistryName("cardboard_green").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_light_blue = new BlockCardboard().setUnlocalizedName("cardboard_light_blue").setRegistryName("cardboard_light_blue").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_cyan = new BlockCardboard().setUnlocalizedName("cardboard_cyan").setRegistryName("cardboard_cyan").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_blue = new BlockCardboard().setUnlocalizedName("cardboard_blue").setRegistryName("cardboard_blue").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_purple = new BlockCardboard().setUnlocalizedName("cardboard_purple").setRegistryName("cardboard_purple").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_magenta = new BlockCardboard().setUnlocalizedName("cardboard_magenta").setRegistryName("cardboard_magenta").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_pink = new BlockCardboard().setUnlocalizedName("cardboard_pink").setRegistryName("cardboard_pink").setCreativeTab(SurvivalPlus.tabBlocks);
		SPBlocks.cardboard_brown = new BlockCardboard().setUnlocalizedName("cardboard_brown").setRegistryName("cardboard_brown").setCreativeTab(SurvivalPlus.tabBlocks);
				
		SPBlocks.campfire = new BlockCampfire(false).setUnlocalizedName("campfire").setRegistryName("campfire").setCreativeTab(SurvivalPlus.tabBlocks);
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
		
		registerBlock(SPBlocks.campfire);
		//registerBlock(SPBlocks.lit_campfire);
	}
	
	private static void registerBlock(Block block){
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
		
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
		
		registerRender(SPBlocks.campfire);
		//registerRender(SPBlocks.lit_campfire);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
}
