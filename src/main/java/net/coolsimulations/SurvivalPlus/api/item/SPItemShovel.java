package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class SPItemShovel extends ShovelItem {

	public SPItemShovel(ToolMaterial tier) {
	      super(tier, 1.5F, -3.0F, (new FabricItemSettings()).group(SPTabs.tabTools));
	   }

}
