package net.coolsimulations.SurvivalPlus.core.compat;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusSmeltingRecipes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class SurvivalPlusWeepingAngles {
	
	public static void init() {
		
		Item ore = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.WEEPING_ANGELS_MODID, "kontron_ore"));
    	Item ingot = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.WEEPING_ANGELS_MODID, "kontron_ingot"));
    	
    	OreDictionary.registerOre("oreKontron", new ItemStack(ore));
    	OreDictionary.registerOre("ingotKontron", new ItemStack(ingot));
    	SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("oreKontron", new ItemStack(ingot), 0.7F, true);
	}

}
