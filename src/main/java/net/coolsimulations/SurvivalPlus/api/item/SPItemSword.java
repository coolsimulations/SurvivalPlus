package net.coolsimulations.SurvivalPlus.api.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class SPItemSword extends SwordItem{

	public SPItemSword(Tier tier) {
	      super(tier, 3, -2.4F, (new FabricItemSettings()));
	   }

}
