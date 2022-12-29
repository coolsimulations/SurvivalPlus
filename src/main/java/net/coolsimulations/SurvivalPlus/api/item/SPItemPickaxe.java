package net.coolsimulations.SurvivalPlus.api.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class SPItemPickaxe extends PickaxeItem {

	public SPItemPickaxe(Tier tier) {
	      super(tier, 1, -2.8F, (new FabricItemSettings()));
	   }

}
