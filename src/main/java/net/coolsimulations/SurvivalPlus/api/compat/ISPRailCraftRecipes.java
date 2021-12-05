package net.coolsimulations.SurvivalPlus.api.compat;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public interface ISPRailCraftRecipes {
	
	void addBlastFurnaceRecipe(ItemStack input, ItemStack output, int slag);
	
	void removeBlastFurnaceRecipe(ItemStack output);
	
	/**
	 * Registers an OreDict recipe to the Blast Furnace
	 * @param input Registered OreDict string
	 * @param name Name of the recipe, typically the input item, such as new ResourceLocation("survivalplus", "bronze_pickaxe")
	 * @param output The output ItemStack
	 * @param slag The amount of Slag this recipe produces  
	 */
	void addOreDictionaryBlastFurnaceRecipe(String input, ResourceLocation name, ItemStack output, int slag);
	
	void addOreDictionaryBlastFurnaceRecipe(String input, ResourceLocation name, ItemStack output, int slag, boolean removeCurrent);

}
