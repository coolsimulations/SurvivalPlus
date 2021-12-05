package net.coolsimulations.SurvivalPlus.core.util;

import java.util.Iterator;
import java.util.List;

import mods.railcraft.api.crafting.Crafters;
import mods.railcraft.api.crafting.IBlastFurnaceCrafter;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.compat.ISPRailCraftRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class SurvivalPlusRailCraftRecipes implements ISPRailCraftRecipes {

	@Override
	public void addBlastFurnaceRecipe(ItemStack input, ItemStack output, int slag) {
		
		if(SPCompatibilityManager.isRailcraftLoaded()) {
			Crafters.blastFurnace().newRecipe(input).name(input.getItem().getRegistryName().getResourcePath() + ":smelt_" + input.getItem().getRegistryName().getResourcePath()).time(IBlastFurnaceCrafter.SMELT_TIME * output.getCount()).output(output).slagOutput(slag).register();
		}
	}
	
	@Override
	public void removeBlastFurnaceRecipe(ItemStack output) {
		
		if(SPCompatibilityManager.isRailcraftLoaded()) {
			
			List<IBlastFurnaceCrafter.IRecipe> recipes = Crafters.blastFurnace().getRecipes();
			for (Iterator<IBlastFurnaceCrafter.IRecipe> entries = recipes.iterator(); entries.hasNext(); ){
				IBlastFurnaceCrafter.IRecipe entry = entries.next();
				ItemStack result = entry.getOutput();
				if (ItemStack.areItemStacksEqual(result, output)){ // If the output matches the specified ItemStack,
					entries.remove(); // Remove the recipe
				}
			}
		}
	}

	@Override
	public void addOreDictionaryBlastFurnaceRecipe(String input, ResourceLocation name, ItemStack output, int slag) {
		
		addOreDictionaryBlastFurnaceRecipe(input, name, output, slag, false);
		
	}

	@Override
	public void addOreDictionaryBlastFurnaceRecipe(String input, ResourceLocation name, ItemStack output, int slag, boolean removeCurrent) {
		
		if(SPCompatibilityManager.isRailcraftLoaded()) {
			for(ItemStack stack : OreDictionary.getOres(input)) {
				if(removeCurrent) {
					removeBlastFurnaceRecipe(stack);
				}
			}
			Crafters.blastFurnace().newRecipe(input).name(name.getResourcePath() + ":smelt_" + name.getResourcePath()).time(IBlastFurnaceCrafter.SMELT_TIME * output.getCount()).output(output).slagOutput(slag).register();
		}
	}

}
