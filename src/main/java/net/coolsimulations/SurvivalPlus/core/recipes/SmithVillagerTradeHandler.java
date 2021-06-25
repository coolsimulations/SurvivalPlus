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

public class SmithVillagerTradeHandler implements ITradeList {

    @Override
	public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) {
    	
		recipeList.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 3), new ItemStack(SPItems.bronze_chestplate)));
		recipeList.add(new MerchantRecipe(new ItemStack(SPItems.bronze_ingot, 3), new ItemStack(Items.EMERALD)));
		recipeList.add(new MerchantRecipe(new ItemStack(SPItems.titanium_ingot, 3), new ItemStack(Items.EMERALD, 2)));
		
	}
    
    public static void init(){
    	
    	VillagerRegistry.VillagerProfession smith = ForgeRegistries.VILLAGER_PROFESSIONS.getValue(new ResourceLocation("minecraft:smith"));
		smith.getCareer(3).addTrade(2, new SmithVillagerTradeHandler());
    }

}
