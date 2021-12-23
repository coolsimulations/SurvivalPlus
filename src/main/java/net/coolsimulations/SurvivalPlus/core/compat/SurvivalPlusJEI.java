package net.coolsimulations.SurvivalPlus.core.compat;

import java.util.Collections;

import javax.annotation.Nonnull;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.insane96mcp.carbonado.init.ModItems;
import net.insane96mcp.carbonado.lib.Properties;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@JEIPlugin
public class SurvivalPlusJEI implements IModPlugin{
	
	public static void loadBlacklist(IIngredientBlacklist jeiHidden){
		
		jeiHidden.addIngredientToBlacklist(new ItemStack(SPBlocks.onion, 1, 0));
		
		if(SPCompatibilityManager.isNoTreePunchingLoaded())
			jeiHidden.addIngredientToBlacklist(new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.LUMBERJACK_MODID, "wood_lumberaxe"))));
		if(SPCompatibilityManager.isFutureMCLoaded())
			jeiHidden.addIngredientToBlacklist(new ItemStack(SPBlocks.campfire));
	}
	
	@Override
    public void register(@Nonnull IModRegistry registry)
    {
        SurvivalPlusJEI.loadBlacklist(registry.getJeiHelpers().getIngredientBlacklist());
        if(SPCompatibilityManager.isCarbonadoLoaded())
        		SurvivalPlusCardbonado.initJEI(registry);
    }


}
