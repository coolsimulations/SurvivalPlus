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

public class SmithVillagerTradeHandler implements ITradeList {

    @Override
	public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) {
    	
		recipeList.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 6), new ItemStack(SPItems.bronze_chestplate)));
		recipeList.add(new MerchantRecipe(new ItemStack(SPItems.bronze_ingot, 12), new ItemStack(Items.EMERALD)));
		recipeList.add(new MerchantRecipe(new ItemStack(SPItems.titanium_ingot, 18), new ItemStack(Items.EMERALD, 2)));
		
	}
    
    public static void init(){
    	
    	VillagerRegistry.VillagerProfession smith = VillagerRegistry.getById(3);
		smith.getCareer(3).addTrade(2, new SmithVillagerTradeHandler());
    }

}
