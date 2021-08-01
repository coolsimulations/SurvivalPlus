package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class SPItemSword extends SwordItem{

	public SPItemSword(Tier tier) {
	      super(tier, 3, -2.4F, (new Item.Properties()).tab(SPTabs.tabCombat));
	   }

}
