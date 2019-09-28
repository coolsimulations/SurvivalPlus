package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class SPItemSword extends SwordItem{

	public SPItemSword(IItemTier tier) {
	      super(tier, 3, -2.4F, (new Item.Properties()).group(SPTabs.tabCombat));
	   }

}
