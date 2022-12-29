package net.coolsimulations.SurvivalPlus.api.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class SPItemShovel extends ShovelItem {

	public SPItemShovel(Tier tier) {
	      super(tier, 1.5F, -3.0F, (new FabricItemSettings()));
	   }

}
