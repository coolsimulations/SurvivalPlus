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

public class ButcherVillagerTradeHandler implements ITradeList {

    @Override
	public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) {
    	
		recipeList.add(new MerchantRecipe(new ItemStack(Items.EMERALD), new ItemStack(SPItems.beef_pie, 4)));
		
	}
    
    public static void init() {
    	
    	VillagerRegistry.VillagerProfession butcher = ForgeRegistries.VILLAGER_PROFESSIONS.getValue(new ResourceLocation("minecraft:butcher"));
		butcher.getCareer(4).addTrade(3, new ButcherVillagerTradeHandler());
    }

}
