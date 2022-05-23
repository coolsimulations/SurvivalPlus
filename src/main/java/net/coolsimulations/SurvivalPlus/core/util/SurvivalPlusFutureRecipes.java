package net.coolsimulations.SurvivalPlus.core.util;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.compat.ISPFutureRecipes;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusNoTreePunching;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.oredict.OreDictionary;
import thedarkcolour.futuremc.block.villagepillage.ComposterBlock;
import thedarkcolour.futuremc.block.villagepillage.ComposterRarity;
import thedarkcolour.futuremc.config.FConfig;
import thedarkcolour.futuremc.recipe.campfire.CampfireRecipes;
import thedarkcolour.futuremc.recipe.furnace.BlastFurnaceRecipes;
import thedarkcolour.futuremc.recipe.furnace.SmokerRecipes;
import thedarkcolour.futuremc.recipe.smithing.SmithingRecipe;
import thedarkcolour.futuremc.recipe.smithing.SmithingRecipes;
import thedarkcolour.futuremc.recipe.stonecutter.StonecutterRecipes;
import thedarkcolour.futuremc.registry.FItems;

public class SurvivalPlusFutureRecipes implements ISPFutureRecipes {

	@Override
	public void addCampfireRecipe(ItemStack input, ItemStack output, int duration) {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			CampfireRecipes.INSTANCE.addRecipe(Ingredient.fromStacks(input), output, duration);
		}
		
		if(SPCompatibilityManager.isNoTreePunchingLoaded()) {
			SurvivalPlusNoTreePunching.addCampfireRecipe(input, output);
		}
	}

	@Override
	public void removeCampfireRecipe(ItemStack output) {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			if(CampfireRecipes.INSTANCE.getRecipe(output) != null) {
				CampfireRecipes.INSTANCE.removeRecipeForOutput(output);
			}
		}
	}

	@Override
	public void addBlastFurnaceRecipe(ItemStack input, ItemStack output) {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			BlastFurnaceRecipes.INSTANCE.addRecipe(Ingredient.fromStacks(input), output);
		}
	}

	@Override
	public void removeBlastFurnaceRecipe(ItemStack output) {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			if(BlastFurnaceRecipes.INSTANCE.getRecipe(output) != null) {
				BlastFurnaceRecipes.INSTANCE.removeRecipeForOutput(output);
			}
		}
	}

	@Override
	public void addSmokerRecipe(ItemStack input, ItemStack output) {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			SmokerRecipes.INSTANCE.addRecipe(Ingredient.fromStacks(input), output);
		}
	}

	@Override
	public void removeSmokerRecipe(ItemStack output) {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			if(SmokerRecipes.INSTANCE.getRecipe(output) != null) {
				SmokerRecipes.INSTANCE.removeRecipeForOutput(output);
			}
		}
	}

	@Override
	public void addSmithingRecipe(ItemStack input, ItemStack material, ItemStack output) {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			if(material.getItem() == FItems.INSTANCE.getNETHERITE_INGOT() && !getNetheriteEnabled()) {
				System.out.println("Cannot Register FutureMC Smithing Recipe for " + input.getItem().getRegistryName().toString() + " due to Netherite being Disabled");
			} else {
				SmithingRecipes.INSTANCE.getRecipes().add(new SmithingRecipe(Ingredient.fromStacks(input), Ingredient.fromStacks(material), output));
			}
		}
	}

	@Override
	public void removeSmithingRecipe(ItemStack output, ItemStack material) {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			if(SmithingRecipes.INSTANCE.getRecipe(output, material) != null) {
				SmithingRecipes.INSTANCE.removeRecipe(output, material);
			}
		}
	}

	@Override
	public void addStonecutterRecipe(ItemStack input, ItemStack output) {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			StonecutterRecipes.INSTANCE.addRecipe(Ingredient.fromStacks(input), output);
		}
	}

	@Override
	public void removeStonecutterRecipe(ItemStack output) {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			if(StonecutterRecipes.INSTANCE.getRecipe(output) != null) {
				StonecutterRecipes.INSTANCE.removeRecipeForOutput(output);
			}
		}
	}

	@Override
	public void addComposterRecipe(ItemStack input, int rarity) {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			ComposterBlock.ItemsForComposter.add(input, rarity);
		}
	}

	@Override
	public void removeComposterRecipe(ItemStack output) {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			if(ComposterBlock.ItemsForComposter.getChance(output) != 0) {
				ComposterBlock.ItemsForComposter.remove(output);
			}
		}
	}
	
	@Override
	public void addFirePitRecipe(ItemStack input, ItemStack output) {
		
		if(SPCompatibilityManager.isNoTreePunchingLoaded()) {
			SurvivalPlusNoTreePunching.addFirePitRecipe(input, output);
		}
	}
	
	@Override
	public void removeFirePitRecipe(ItemStack input, ItemStack output) {
		
		if(SPCompatibilityManager.isNoTreePunchingLoaded()) {
			SurvivalPlusNoTreePunching.removeFirePitRecipe(input, output);
		}
	}

	@Override
	public void addOreDictionaryCampfireRecipe(String input, ItemStack output, int duration) {

		addOreDictionaryCampfireRecipe(input, output, duration, false);
	}

	@Override
	public void addOreDictionaryCampfireRecipe(String input, ItemStack output, int duration, boolean removeCurrent) {

		for(ItemStack stack : OreDictionary.getOres(input)) {
			if(removeCurrent) {
				removeCampfireRecipe(stack);
			}
			addCampfireRecipe(stack, output, duration);
		}
	}

	@Override
	public void addOreDictionaryBlastFurnaceRecipe(String input, ItemStack output) {

		addOreDictionaryBlastFurnaceRecipe(input, output, false);
	}

	@Override
	public void addOreDictionaryBlastFurnaceRecipe(String input, ItemStack output, boolean removeCurrent) {

		for(ItemStack stack : OreDictionary.getOres(input)) {
			if(removeCurrent) {
				removeBlastFurnaceRecipe(stack);
			}
			addBlastFurnaceRecipe(stack, output);
		}
	}

	@Override
	public void addOreDictionarySmokerRecipe(String input, ItemStack output) {

		addOreDictionarySmokerRecipe(input, output, false);
	}

	@Override
	public void addOreDictionarySmokerRecipe(String input, ItemStack output, boolean removeCurrent) {

		for(ItemStack stack : OreDictionary.getOres(input)) {
			if(removeCurrent) {
				removeSmokerRecipe(stack);
			}
			addSmokerRecipe(stack, output);
		}
	}

	@Override
	public void addOreDictionarySmithingRecipe(String input, ItemStack material, ItemStack output) {

		addOreDictionarySmithingRecipe(input, material, output, false);
	}

	@Override
	public void addOreDictionarySmithingRecipe(String input, ItemStack material, ItemStack output, boolean removeCurrent) {

		for(ItemStack stack : OreDictionary.getOres(input)) {
			if(removeCurrent) {
				removeSmithingRecipe(stack, material);
			}
			addSmithingRecipe(stack, material, output);
		}
	}

	@Override
	public void addOreDictionarySmithingRecipe(String input, String material, ItemStack output) {

		addOreDictionarySmithingRecipe(input, material, output, false);
	}

	@Override
	public void addOreDictionarySmithingRecipe(String input, String material, ItemStack output, boolean removeCurrent) {

		for(ItemStack stack : OreDictionary.getOres(input)) {
			for(ItemStack materialStack : OreDictionary.getOres(material)) {
				if(removeCurrent) {
					removeSmithingRecipe(stack, materialStack);
				}
				addSmithingRecipe(stack, materialStack, output);
			}
		}
	}
	
	@Override
	public void addOreDictionarySmithingRecipe(ItemStack input, String material, ItemStack output) {

		addOreDictionarySmithingRecipe(input, material, output, false);
	}

	@Override
	public void addOreDictionarySmithingRecipe(ItemStack input, String material, ItemStack output, boolean removeCurrent) {

		for(ItemStack materialStack : OreDictionary.getOres(material)) {
			if(removeCurrent) {
				removeSmithingRecipe(input, materialStack);
			}
			addSmithingRecipe(input, materialStack, output);
		}
	}

	@Override
	public void addOreDictionaryStonecutterRecipe(String input, ItemStack output) {

		addOreDictionaryStonecutterRecipe(input, output, false);
	}

	@Override
	public void addOreDictionaryStonecutterRecipe(String input, ItemStack output, boolean removeCurrent) {

		for(ItemStack stack : OreDictionary.getOres(input)) {
			if(removeCurrent) {
				removeStonecutterRecipe(stack);
			}
			addStonecutterRecipe(stack, output);
		}
	}

	@Override
	public void addOreDictionaryComposterRecipe(String input, int rarity) {

		addOreDictionaryComposterRecipe(input, rarity, false);
	}

	@Override
	public void addOreDictionaryComposterRecipe(String input, int rarity, boolean removeCurrent) {

		for(ItemStack stack : OreDictionary.getOres(input)) {
			if(removeCurrent) {
				removeComposterRecipe(stack);
			}
			addComposterRecipe(stack, rarity);
		}
	}
	
	@Override
	public void addOreDictionaryFirePitRecipe(String input, ItemStack output) {

		addOreDictionaryFirePitRecipe(input, output, false);
	}

	@Override
	public void addOreDictionaryFirePitRecipe(String input, ItemStack output, boolean removeCurrent) {

		for(ItemStack stack : OreDictionary.getOres(input)) {
			if(removeCurrent) {
				removeFirePitRecipe(stack, output);
			}
			addFirePitRecipe(stack, output);
		}
	}

	@Override
	public int getComposterRarityCommon() {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			return ComposterRarity.INSTANCE.getCOMMON();
		}

		return 0;
	}

	@Override
	public int getComposterRarityUnCommon() {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			return ComposterRarity.INSTANCE.getUNCOMMON();
		}

		return 0;
	}

	@Override
	public int getComposterRarityRare() {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			return ComposterRarity.INSTANCE.getRARE();
		}

		return 0;
	}

	@Override
	public int getComposterRarityEpic() {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			return ComposterRarity.INSTANCE.getEPIC();
		}

		return 0;
	}

	@Override
	public int getComposterRarityLegendary() {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			return ComposterRarity.INSTANCE.getLEGENDARY();
		}

		return 0;
	}
	
	@Override
	public boolean getNetheriteEnabled() {

		if(SPCompatibilityManager.isFutureMCLoaded()) {
			return FConfig.INSTANCE.getNetherUpdate().netherite;
		}

		return true;
	}
}
