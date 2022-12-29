package net.coolsimulations.SurvivalPlus.core.util;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class SurvivalPlusOreDict {
	
	public static void PreInit(){
		
		OreDictionary.registerOre("ingotCopper", new ItemStack(SPItems.copper_ingot));
		OreDictionary.registerOre("ingotTin", new ItemStack(SPItems.tin_ingot));
		OreDictionary.registerOre("ingotBronze", new ItemStack(SPItems.bronze_ingot));
		OreDictionary.registerOre("ingotTitanium", new ItemStack(SPItems.titanium_ingot));
		
		OreDictionary.registerOre("blockCopper", new ItemStack(SPBlocks.copper_block));
		OreDictionary.registerOre("blockTin", new ItemStack(SPBlocks.tin_block));
		OreDictionary.registerOre("blockBronze", new ItemStack(SPBlocks.bronze_block));
		OreDictionary.registerOre("blockTitanium", new ItemStack(SPBlocks.titanium_block));
		
		OreDictionary.registerOre("oreCopper", new ItemStack(SPBlocks.copper_ore));
		OreDictionary.registerOre("oreTin", new ItemStack(SPBlocks.tin_ore));
		OreDictionary.registerOre("oreTitanium", new ItemStack(SPBlocks.titanium_ore));
		
		OreDictionary.registerOre("nuggetBronze", new ItemStack(SPItems.bronze_nugget));
		OreDictionary.registerOre("nuggetTitanium", new ItemStack(SPItems.titanium_nugget));
		
		OreDictionary.registerOre("barsIron", new ItemStack(Blocks.IRON_BARS));
		
		OreDictionary.registerOre("dyeWhite", new ItemStack(SPItems.white_dye));
		
		if(SPCompatibilityManager.isSimpleGrinderLoaded() || (SPCompatibilityManager.isIc2Loaded() && !SPCompatibilityManager.isTechRebornLoaded())) {
			OreDictionary.registerOre("dustTitanium", new ItemStack(SPItems.titanium_dust));
		}
		
		OreDictionary.registerOre("cropApple", new ItemStack(Items.APPLE));
		
		OreDictionary.registerOre("cropBeetroot", new ItemStack(Items.BEETROOT));
		OreDictionary.registerOre("seedBeetroot", new ItemStack(Items.BEETROOT_SEEDS));
		
		OreDictionary.registerOre("cropOnion", new ItemStack(SPItems.raw_onion));
		OreDictionary.registerOre("listAllveggie", new ItemStack(SPItems.raw_onion));
		
		OreDictionary.registerOre("cupPaper", new ItemStack(SPItems.paper_cup));
		
		OreDictionary.registerOre("foodApplebaked", new ItemStack(SPItems.baked_apple));
		OreDictionary.registerOre("foodCheese", new ItemStack(SPItems.cheese));
		OreDictionary.registerOre("foodOnionsoup", new ItemStack(SPItems.onion_soup));
		OreDictionary.registerOre("foodFriedonions", new ItemStack(SPItems.fried_onion));
		OreDictionary.registerOre("foodFriedegg", new ItemStack(SPItems.fried_egg));
		OreDictionary.registerOre("foodRoastcarrot", new ItemStack(SPItems.roast_carrot));
		OreDictionary.registerOre("foodApplepie", new ItemStack(SPItems.apple_pie));
		OreDictionary.registerOre("foodBeefpie", new ItemStack(SPItems.beef_pie));
		OreDictionary.registerOre("foodChickenpie", new ItemStack(SPItems.chicken_pie));
		OreDictionary.registerOre("foodMuttonpie", new ItemStack(SPItems.mutton_pie));
		OreDictionary.registerOre("foodPorkpie", new ItemStack(SPItems.pork_pie));
		OreDictionary.registerOre("foodRabbitpie", new ItemStack(SPItems.rabbit_pie));
		OreDictionary.registerOre("foodVegetablepie", new ItemStack(SPItems.vegetable_pie));
		OreDictionary.registerOre("foodCheesebread", new ItemStack(SPItems.cheese_bread));
		OreDictionary.registerOre("foodMeltedCheesebread", new ItemStack(SPItems.melted_cheese_bread));
		OreDictionary.registerOre("foodCupcake", new ItemStack(SPItems.cupcake));
		OreDictionary.registerOre("foodCheesecupcake", new ItemStack(SPItems.cheese_cupcake));
		OreDictionary.registerOre("foodSpongecupcake", new ItemStack(SPItems.sponge_cupcake));
		OreDictionary.registerOre("listAllseed", new ItemStack(SPItems.onion_seeds));
		OreDictionary.registerOre("seedOnion", new ItemStack(SPItems.onion_seeds));
		OreDictionary.registerOre("foodCheesecake", new ItemStack(SPBlocks.cheese_cake));
		OreDictionary.registerOre("foodSpongecake", new ItemStack(SPBlocks.sponge_cake));
		
		OreDictionary.registerOre("bucketCharcoal", new ItemStack(SPItems.charcoal_bucket));
		
		OreDictionary.registerOre("gemAmethyst", new ItemStack(SPBlocks.amethyst));
		OreDictionary.registerOre("gemRuby", new ItemStack(SPBlocks.ruby));
		OreDictionary.registerOre("gemSapphire", new ItemStack(SPBlocks.sapphire));
		OreDictionary.registerOre("gemTopaz", new ItemStack(SPBlocks.topaz));
		OreDictionary.registerOre("gemSpinel", new ItemStack(SPBlocks.spinel));
		OreDictionary.registerOre("gemPearl", new ItemStack(SPBlocks.pearl));

		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_black));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_blue));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_brown));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_cyan));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_green));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_grey));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_light_blue));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_light_grey));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_lime));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_magenta));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_orange));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_pink));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_purple));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_red));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_white));
		OreDictionary.registerOre("blockCardboard", new ItemStack(SPBlocks.cardboard_yellow));
		
		OreDictionary.registerOre("blockCardboardBlack", new ItemStack(SPBlocks.cardboard_black));
		OreDictionary.registerOre("blockCardboardBlue", new ItemStack(SPBlocks.cardboard_blue));
		OreDictionary.registerOre("blockCardboardBrown", new ItemStack(SPBlocks.cardboard_brown));
		OreDictionary.registerOre("blockCardboardCyan", new ItemStack(SPBlocks.cardboard_cyan));
		OreDictionary.registerOre("blockCardboardGreen", new ItemStack(SPBlocks.cardboard_green));
		OreDictionary.registerOre("blockCardboardGrey", new ItemStack(SPBlocks.cardboard_grey));
		OreDictionary.registerOre("blockCardboardGray", new ItemStack(SPBlocks.cardboard_grey));
		OreDictionary.registerOre("blockCardboardLightBlue", new ItemStack(SPBlocks.cardboard_light_blue));
		OreDictionary.registerOre("blockCardboardLightGrey", new ItemStack(SPBlocks.cardboard_light_grey));
		OreDictionary.registerOre("blockCardboardLightGray", new ItemStack(SPBlocks.cardboard_light_grey));
		OreDictionary.registerOre("blockCardboardLime", new ItemStack(SPBlocks.cardboard_lime));
		OreDictionary.registerOre("blockCardboardMagenta", new ItemStack(SPBlocks.cardboard_magenta));
		OreDictionary.registerOre("blockCardboardOrange", new ItemStack(SPBlocks.cardboard_orange));
		OreDictionary.registerOre("blockCardboardPink", new ItemStack(SPBlocks.cardboard_pink));
		OreDictionary.registerOre("blockCardboardPurple", new ItemStack(SPBlocks.cardboard_purple));
		OreDictionary.registerOre("blockCardboardRed", new ItemStack(SPBlocks.cardboard_red));
		OreDictionary.registerOre("blockCardboardWhite", new ItemStack(SPBlocks.cardboard_white));
		OreDictionary.registerOre("blockCardboardYellow", new ItemStack(SPBlocks.cardboard_yellow));
		
		OreDictionary.registerOre("blockCampfire", new ItemStack(SPBlocks.campfire));

	}

}
