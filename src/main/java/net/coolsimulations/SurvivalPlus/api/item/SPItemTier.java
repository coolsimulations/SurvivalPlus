package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class SPItemTier {
	
	/**
	 * These are the default Tiers referred to in SurvivalPlusTiers
	 */
	public static ForgeTier bronzeToolMaterial = new ForgeTier(2, 350, 5.0F, 1.5F, 7, BlockTags.NEEDS_IRON_TOOL, () -> {
		return Ingredient.of(SPTags.Items.INGOTS_BRONZE);
	});
	public static ForgeTier titaniumToolMaterial = new ForgeTier(2, 432, 7.0F, 2.5F, 17, BlockTags.NEEDS_IRON_TOOL, () -> {
		return Ingredient.of(SPTags.Items.INGOTS_TITANIUM);
	});
	
}