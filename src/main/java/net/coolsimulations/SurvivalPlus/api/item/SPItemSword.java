package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SPItemSword extends SwordItem{

	public SPItemSword(ToolMaterial tier) {
	      super(tier, 3, -2.4F, (new FabricItemSettings()).group(SPTabs.tabCombat));
	   }

}
