package net.coolsimulations.SurvivalPlus.api.compat;

import net.minecraft.item.ItemStack;

public interface ISPFutureRecipes {
	
	void addCampfireRecipe(ItemStack input, ItemStack output, int duration);
	
	void removeCampfireRecipe(ItemStack output);
	
	void addBlastFurnaceRecipe(ItemStack input, ItemStack output);
	
	void removeBlastFurnaceRecipe(ItemStack output);
	
	void addSmokerRecipe(ItemStack input, ItemStack output);
	
	void removeSmokerRecipe(ItemStack output);
	
	void addSmithingRecipe(ItemStack input, ItemStack material, ItemStack output);
	
	void removeSmithingRecipe(ItemStack output, ItemStack material);
	
	void addStonecutterRecipe(ItemStack input, ItemStack output);
	
	void removeStonecutterRecipe(ItemStack output);
	
	void addComposterRecipe(ItemStack input, int rarity);
	
	void removeComposterRecipe(ItemStack output);
	
	void addFirePitRecipe(ItemStack input, ItemStack output);
	
	void removeFirePitRecipe(ItemStack input, ItemStack output);
	
	void addOreDictionaryCampfireRecipe(String input, ItemStack output, int duration);
	
	void addOreDictionaryCampfireRecipe(String input, ItemStack output, int duration, boolean removeCurrent);
	
	void addOreDictionaryBlastFurnaceRecipe(String input, ItemStack output);
	
	void addOreDictionaryBlastFurnaceRecipe(String input, ItemStack output, boolean removeCurrent);
	
	void addOreDictionarySmokerRecipe(String input, ItemStack output);
	
	void addOreDictionarySmokerRecipe(String input, ItemStack output, boolean removeCurrent);
	
	void addOreDictionarySmithingRecipe(String input, ItemStack material, ItemStack output);
	
	void addOreDictionarySmithingRecipe(String input, ItemStack material, ItemStack output, boolean removeCurrent);
	
	void addOreDictionarySmithingRecipe(String input, String material, ItemStack output);
	
	void addOreDictionarySmithingRecipe(String input, String material, ItemStack output, boolean removeCurrent);
	
	void addOreDictionarySmithingRecipe(ItemStack input, String material, ItemStack output);
	
	void addOreDictionarySmithingRecipe(ItemStack input, String material, ItemStack output, boolean removeCurrent);
	
	void addOreDictionaryStonecutterRecipe(String input, ItemStack output);
	
	void addOreDictionaryStonecutterRecipe(String input, ItemStack output, boolean removeCurrent);
	
	void addOreDictionaryComposterRecipe(String input, int rarity);
	
	void addOreDictionaryComposterRecipe(String input, int rarity, boolean removeCurrent);
	
	void addOreDictionaryFirePitRecipe(String input, ItemStack output);
	
	void addOreDictionaryFirePitRecipe(String input, ItemStack output, boolean removeCurrent);
	
	int getComposterRarityCommon();
	
	int getComposterRarityUnCommon();
	
	int getComposterRarityRare();
	
	int getComposterRarityEpic();
	
	int getComposterRarityLegendary();
	
	boolean getNetheriteEnabled();

}
