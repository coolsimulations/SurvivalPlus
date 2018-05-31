package net.coolsimulations.SurvivalPlus.core.recipes;

import java.util.Random;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager.ITradeList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class FarmerVillagerTradeHandler implements ITradeList {

    @Override
	public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) {
    	
		recipeList.add(new MerchantRecipe(new ItemStack(SPItems.raw_onion, 13), new ItemStack(Items.EMERALD)));
		
	}
    
    public static void init() {
    	
    	VillagerRegistry.VillagerProfession farmer = ForgeRegistries.VILLAGER_PROFESSIONS.getValue(new ResourceLocation("minecraft:farmer"));
		farmer.getCareer(0).addTrade(2, new FarmerVillagerTradeHandler());
    }

}
