package net.coolsimulations.SurvivalPlus.api.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class SPItemPickaxe extends PickaxeItem{

	public SPItemPickaxe(Tier tier) {
	      super(tier, 1, -2.8F, (new Item.Properties()));
	   }

}
