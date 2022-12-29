package net.coolsimulations.SurvivalPlus.api.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class SPItemShovel extends ShovelItem {

	public SPItemShovel(Tier tier) {
	      super(tier, 1.5F, -3.0F, (new Item.Properties()));
	   }

}
