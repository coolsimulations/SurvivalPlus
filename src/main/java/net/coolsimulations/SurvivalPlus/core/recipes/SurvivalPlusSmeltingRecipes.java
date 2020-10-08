package net.coolsimulations.SurvivalPlus.core.recipes;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusAPIRecipes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class SurvivalPlusSmeltingRecipes {

	public static void register() {

		addOreDictionaryRecipe("oreCopper", new ItemStack(SPItems.copper_ingot), 0.7F, true);
		addOreDictionaryRecipe("oreTin", new ItemStack(SPItems.tin_ingot), 0.7F, true);
		GameRegistry.addSmelting(SPBlocks.titanium_ore, new ItemStack(SPItems.titanium_ingot), 1.0F);
		addOreDictionaryRecipe("egg", new ItemStack(SPItems.fried_egg), 0.35F);
		addOreDictionaryRecipe("cropCarrot", new ItemStack(SPItems.roast_carrot), 0.35F);
		addOreDictionaryRecipe("foodCheesebread", new ItemStack(SPItems.melted_cheese_bread), 0.4F);
		GameRegistry.addSmelting(Items.APPLE, new ItemStack(SPItems.baked_apple), 0.35F);
		addOreDictionaryRecipe("cropApple", new ItemStack(SPItems.baked_apple), 0.35F);
		addOreDictionaryRecipe("cropOnion", new ItemStack(SPItems.fried_onion), 0.35F);
		GameRegistry.addSmelting(SPItems.bronze_axe, new ItemStack(SPItems.bronze_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.bronze_hoe, new ItemStack(SPItems.bronze_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.bronze_pickaxe, new ItemStack(SPItems.bronze_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.bronze_shears, new ItemStack(SPItems.bronze_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.bronze_shovel, new ItemStack(SPItems.bronze_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.bronze_sword, new ItemStack(SPItems.bronze_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.bronze_helmet, new ItemStack(SPItems.bronze_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.bronze_chestplate, new ItemStack(SPItems.bronze_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.bronze_leggings, new ItemStack(SPItems.bronze_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.bronze_boots, new ItemStack(SPItems.bronze_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.titanium_axe, new ItemStack(SPItems.titanium_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.titanium_hoe, new ItemStack(SPItems.titanium_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.titanium_pickaxe, new ItemStack(SPItems.titanium_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.titanium_shears, new ItemStack(SPItems.titanium_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.titanium_shovel, new ItemStack(SPItems.titanium_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.titanium_sword, new ItemStack(SPItems.titanium_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.titanium_helmet, new ItemStack(SPItems.titanium_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.titanium_chestplate, new ItemStack(SPItems.titanium_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.titanium_leggings, new ItemStack(SPItems.titanium_nugget), 0.1F);
		GameRegistry.addSmelting(SPItems.titanium_boots, new ItemStack(SPItems.titanium_nugget), 0.1F);

	}
	
	public static void addOreDictionaryRecipe(String input, ItemStack output, float xp) {
		
		addOreDictionaryRecipe(input, output, xp, false);
	}
	
	public static void addOreDictionaryRecipe(String input, ItemStack output, float xp, boolean removeCurrent) {
		
		for(ItemStack stack : OreDictionary.getOres(input)) {
			if(FurnaceRecipes.instance().getSmeltingResult(stack) != null && removeCurrent) {
				SurvivalPlusAPIRecipes.removeFurnaceRecipe(FurnaceRecipes.instance().getSmeltingResult(stack));
			}
			GameRegistry.addSmelting(stack, output, xp);
		}
		
	}

}