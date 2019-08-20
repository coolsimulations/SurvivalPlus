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

public class FarmerVillagerTradeHandler implements ITradeList {

    @Override
	public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) {
    	
		recipeList.add(new MerchantRecipe(new ItemStack(SPItems.raw_onion, 13), new ItemStack(Items.EMERALD)));
		
	}
    
    public static void init() {
    	
    	VillagerRegistry.VillagerProfession farmer = VillagerRegistry.getById(0);
		farmer.getCareer(0).addTrade(2, new FarmerVillagerTradeHandler());
    }

}
