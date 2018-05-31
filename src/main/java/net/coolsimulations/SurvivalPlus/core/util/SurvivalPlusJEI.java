package net.coolsimulations.SurvivalPlus.core.util;

import javax.annotation.Nonnull;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class SurvivalPlusJEI extends BlankModPlugin{
	
	public static void loadBlacklist(IIngredientBlacklist jeiHidden){
		
		if (SPCompatibilityManager.isJeiLoaded()){
			
			jeiHidden.addIngredientToBlacklist(new ItemStack(SPBlocks.onion, 1, 0));
		}
	}
	
	@Override
    public void register(@Nonnull IModRegistry registry)
    {
        SurvivalPlusJEI.loadBlacklist(registry.getJeiHelpers().getIngredientBlacklist());
    }


}
