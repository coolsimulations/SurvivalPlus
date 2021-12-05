package net.coolsimulations.SurvivalPlus.core.compat;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusSmeltingRecipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SurvivalPlusTriGems {

	public static void init() {

		Item ruby = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "ruby"));
		Item sapphire = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "sapphire"));
		Item topaz = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "topaz"));

		Block ruby_ore = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "ruby_ore"));
		Block sapphire_ore = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "sapphire_ore"));
		Block topaz_ore = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "topaz_ore"));

		if(SPConfig.enableReplaceSmelting) {

			SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(ruby));
			SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(sapphire));
			SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(topaz));
			GameRegistry.addSmelting(ruby_ore, new ItemStack(SPBlocks.ruby), 0.5F);
			GameRegistry.addSmelting(sapphire_ore, new ItemStack(SPBlocks.sapphire), 0.5F);
			GameRegistry.addSmelting(topaz_ore, new ItemStack(SPBlocks.topaz), 0.5F);
		}
	}

}
