package net.coolsimulations.SurvivalPlus.core.util;

import java.util.Iterator;
import java.util.List;

import mods.railcraft.api.crafting.Crafters;
import mods.railcraft.api.crafting.IBlastFurnaceCrafter;
import mods.railcraft.api.crafting.ISimpleRecipe;
import mods.railcraft.common.util.crafting.Ingredients;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.compat.ISPRailCraftRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
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
	public void addBlastFurnaceFuel(ItemStack input, int burnTime) {
		
		if(SPCompatibilityManager.isRailcraftLoaded()) {
			Crafters.blastFurnace().newFuel(Ingredients.from(input))
            .name(input.getItem().getRegistryName().getResourcePath() + ":" + "fuel_" + input.getItem().getRegistryName().getResourceDomain())
            .time(burnTime)
            .register();
		}
	}
	
	@Override
	public void removeBlastFurnaceFuel(ItemStack fuel) {
		
		if(SPCompatibilityManager.isRailcraftLoaded()) {
			
			List<ISimpleRecipe> fuels = Crafters.blastFurnace().getFuels();
			for (Iterator<ISimpleRecipe> entries = fuels.iterator(); entries.hasNext(); ){
				ISimpleRecipe entry = entries.next();
				Ingredient result = entry.getInput();
				if (result.test(fuel)){ // If the fuel matches the specified ItemStack,
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
	
	@Override
	public void addOreDictionaryBlastFurnaceFuel(String input, ResourceLocation name, int burnTime) {
		
		addOreDictionaryBlastFurnaceFuel(input, name, burnTime, false);
		
	}
	
	@Override
	public void addOreDictionaryBlastFurnaceFuel(String input, ResourceLocation name, int burnTime, boolean removeCurrent) {
		
		if(SPCompatibilityManager.isRailcraftLoaded()) {
			for(ItemStack stack : OreDictionary.getOres(input)) {
				if(removeCurrent) {
					removeBlastFurnaceFuel(stack);
				}
			}
			Crafters.blastFurnace().newFuel(input)
            .name(name.getResourcePath() + ":" + "fuel_" + name.getResourceDomain())
            .time(burnTime)
            .register();
		}
	}

}
