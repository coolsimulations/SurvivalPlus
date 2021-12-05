package net.coolsimulations.SurvivalPlus.core.compat;

import com.coliwogg.gemsmod.init.BlockInit;
import com.coliwogg.gemsmod.init.ItemInit;

import ic2.api.item.IC2Items;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusSmeltingRecipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class SurvivalPlusGAC {

	public static void init() {

		if(SPConfig.enableReplaceSmelting) {
			
			SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(ItemInit.AMETHYST));
			SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(ItemInit.RUBY));
			SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(ItemInit.SAPPHIRE));;
			SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(ItemInit.TOPAZ));
			GameRegistry.addSmelting(BlockInit.AMETHYST_ORE, new ItemStack(SPBlocks.amethyst), 1.5F);
			GameRegistry.addSmelting(BlockInit.RUBY_ORE, new ItemStack(SPBlocks.ruby), 1.5F);
			GameRegistry.addSmelting(BlockInit.SAPPHIRE_ORE, new ItemStack(SPBlocks.sapphire), 1.5F);
			GameRegistry.addSmelting(BlockInit.TOPAZ_ORE, new ItemStack(SPBlocks.topaz), 1.5F);
		}
	}

}
