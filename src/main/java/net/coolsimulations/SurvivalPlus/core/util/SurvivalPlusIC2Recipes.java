package net.coolsimulations.SurvivalPlus.core.util;

import ic2.api.item.IC2Items;
import ic2.api.recipe.Recipes;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;
import biomesoplenty.api.block.BOPBlocks;

public class SurvivalPlusIC2Recipes {
	
	private static NBTTagCompound orewash;
	private static NBTTagCompound centerf;
	private static NBTTagCompound cutterhard;

	public static void init()
    {
        
       	SurvivalPlusAPIRecipes.removeFurnaceRecipe(IC2Items.getItem("ingot", "copper"));
       	SurvivalPlusAPIRecipes.removeFurnaceRecipe(IC2Items.getItem("ingot", "tin"));
       	SurvivalPlusAPIRecipes.removeFurnaceRecipe(IC2Items.getItem("ingot", "bronze"));
       	//removeCraftingRecipe(IC2Items.getItem("dust", "bronze"));
        
       	GameRegistry.addSmelting(IC2Items.getItem("resource", "copper_ore"), new ItemStack(SPItems.copper_ingot), 0.7F);
    	GameRegistry.addSmelting(IC2Items.getItem("crushed", "copper"), new ItemStack(SPItems.copper_ingot), 0.7F);
   		GameRegistry.addSmelting(IC2Items.getItem("purified", "copper"), new ItemStack(SPItems.copper_ingot), 0.7F);
   		GameRegistry.addSmelting(IC2Items.getItem("dust", "copper"), new ItemStack(SPItems.copper_ingot), 0.7F);
    	
    	GameRegistry.addSmelting(IC2Items.getItem("resource", "tin_ore"), new ItemStack(SPItems.tin_ingot), 0.7F);
   		GameRegistry.addSmelting(IC2Items.getItem("crushed", "tin"), new ItemStack(SPItems.tin_ingot), 0.7F);
   		GameRegistry.addSmelting(IC2Items.getItem("purified", "tin"), new ItemStack(SPItems.tin_ingot), 0.7F);
   		GameRegistry.addSmelting(IC2Items.getItem("dust", "tin"), new ItemStack(SPItems.tin_ingot), 0.7F);
    	
    	GameRegistry.addSmelting(SPItems.crushed_titanium_ore, new ItemStack(SPItems.titanium_ingot), 0.7F);
   		GameRegistry.addSmelting(SPItems.purified_titanium_ore, new ItemStack(SPItems.titanium_ingot), 0.7F);
    	
    	GameRegistry.addSmelting(IC2Items.getItem("dust", "bronze"), new ItemStack(SPItems.bronze_ingot), 0.7F);
    	
    	orewash = new NBTTagCompound();
		orewash.setInteger("amount", 1000);
		
		centerf = new NBTTagCompound();
		centerf.setInteger("minHeat", 1500);
		cutterhard = new NBTTagCompound();
		cutterhard.setInteger("hardness", 3);
		
		ItemStack hvCable = IC2Items.getItem("cable", "type:iron,insulation:0");
		hvCable.stackSize = 16;
   		
   		//Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.titanium_ore)), null, false, new ItemStack(SPItems.crushed_titanium_ore, 2));

   		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("oreTitanium"), null, false, new ItemStack(SPItems.crushed_titanium_ore, 2));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("ingotTitanium"), null, false, new ItemStack(SPItems.titanium_dust));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("plateDenseTitanium", 9), null, false, new ItemStack(SPItems.titanium_dust, 8));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("plateTitanium", 9), null, false, new ItemStack(SPItems.tiny_titanium_pile, 8));
		
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("cropOnion", 8), null, false, IC2Items.getItem("crafting", "bio_chaff"));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("seedOnion", 16), null, false, IC2Items.getItem("crafting", "bio_chaff"));
		
		Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(Blocks.RED_SANDSTONE)), null, false, new ItemStack(Blocks.SAND, 1, 1));
		
		Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("dustTinyTitanium", 9), null, false, new ItemStack(SPItems.titanium_dust));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotTitanium", 9), null, false, new ItemStack(SPBlocks.titanium_block));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("plateTitanium", 9), null, false, new ItemStack(SPItems.titanium_dense_plate));
		
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(Blocks.SAND, 4, 1)), null, false, new ItemStack(Blocks.RED_SANDSTONE));
		
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardBlack"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardBlue"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardBrown"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardCyan"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardGreen"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardGrey"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardGray"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardLightBlue"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardLightGrey"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardLightGray"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardLime"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardMagenta"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardOrange"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardPink"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardPurple"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardRed"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardWhite"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardYellow"), null, false, new ItemStack(SPBlocks.cardboard));
		
		Recipes.blockcutter.addRecipe(Recipes.inputFactory.forOreDict("blockTitanium"), cutterhard, false, new ItemStack(SPItems.titanium_plate, 9));
		
		Recipes.oreWashing.addRecipe(Recipes.inputFactory.forOreDict("crushedTitanium"), orewash, false, new ItemStack(SPItems.purified_titanium_ore), new ItemStack(SPItems.tiny_titanium_pile, 2), IC2Items.getItem("dust", "stone"));
		
		Recipes.centrifuge.addRecipe(Recipes.inputFactory.forOreDict("crushedPurifiedTitanium"), centerf, false, new ItemStack(SPItems.tiny_titanium_pile), new ItemStack(SPItems.titanium_dust));
		Recipes.centrifuge.addRecipe(Recipes.inputFactory.forOreDict("crushedTitanium"), centerf, false, new ItemStack(SPItems.tiny_titanium_pile), new ItemStack(SPItems.titanium_dust), IC2Items.getItem("dust", "stone"));
		
		Recipes.metalformerExtruding.addRecipe(Recipes.inputFactory.forOreDict("ingotTitanium"), null, false, hvCable);
		Recipes.metalformerExtruding.addRecipe(Recipes.inputFactory.forOreDict("plateTitanium"), null, false, IC2Items.getItem("crafting", "fuel_rod"));
		Recipes.metalformerCutting.addRecipe(Recipes.inputFactory.forOreDict("plateTitanium"), null, false, hvCable);
		Recipes.metalformerRolling.addRecipe(Recipes.inputFactory.forOreDict("plateTitanium"), null, false, new ItemStack(SPItems.titanium_casing, 2));
		Recipes.metalformerRolling.addRecipe(Recipes.inputFactory.forOreDict("ingotTitanium"), null, false, new ItemStack(SPItems.titanium_plate));
		
    }
}
