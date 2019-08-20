package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

public class SPItemHoe extends ItemHoe{

	public SPItemHoe(IItemTier tier) {
		super(tier, tier.getHarvestLevel() - 3.5F, (new Item.Properties().group(SPTabs.tabTools)));
	}

}
