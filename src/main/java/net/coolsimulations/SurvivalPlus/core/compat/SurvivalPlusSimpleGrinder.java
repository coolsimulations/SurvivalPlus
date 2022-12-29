package net.coolsimulations.SurvivalPlus.core.compat;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusSmeltingRecipes;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class SurvivalPlusSimpleGrinder {

	public static void init() {

		if(!SPCompatibilityManager.isIc2Loaded()) {

			OreDictionary.registerOre("dustCopper", new ItemStack(SPItems.copper_dust));
			OreDictionary.registerOre("dustTin", new ItemStack(SPItems.tin_dust));

			if (!SPCompatibilityManager.isTechRebornLoaded() && !SPCompatibilityManager.isIc2Loaded())
				GameRegistry.addSmelting(SPItems.titanium_dust, new ItemStack(SPItems.titanium_ingot), 3.0F);

			if(SPConfig.enableReplaceSmelting) {
				SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("dustCopper", new ItemStack(SPItems.copper_ingot), 3.0F, true);
				SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("dustTin", new ItemStack(SPItems.tin_ingot), 3.0F, true);
			} else {
				GameRegistry.addSmelting(SPItems.copper_dust, new ItemStack(SPItems.copper_ingot), 3.0F);
				GameRegistry.addSmelting(SPItems.tin_dust, new ItemStack(SPItems.tin_ingot), 3.0F);
			}
		}
	}

}
