package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;

public class SPItemPickaxe extends PickaxeItem{

	public SPItemPickaxe(Tier tier) {
	      super(tier, 1, -2.8F, (new Item.Properties().tab(SPTabs.tabTools)));
	   }

}
