package net.coolsimulations.SurvivalPlus.api.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class SPItemSword extends SwordItem{

	public SPItemSword(Tier tier) {
	      super(tier, 3, -2.4F, (new Item.Properties()));
	   }

}
