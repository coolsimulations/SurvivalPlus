package net.coolsimulations.SurvivalPlus.core.recipes;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager.ITradeList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import java.util.Random;

public class ButcherVillagerTradeHandler implements ITradeList {

    @Override
	public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) {
    	
		recipeList.add(new MerchantRecipe(new ItemStack(Items.EMERALD), new ItemStack(SPItems.beef_pie, 4)));
		
	}
    
    public static void init() {
    	
    	VillagerRegistry.VillagerProfession butcher = VillagerRegistry.getById(4);
		butcher.getCareer(4).addTrade(3, new ButcherVillagerTradeHandler());
    }

}
