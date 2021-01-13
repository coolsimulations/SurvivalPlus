package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class SPItemPickaxe extends PickaxeItem{

	public SPItemPickaxe(ToolMaterial tier) {
	      super(tier, 1, -2.8F, (new FabricItemSettings()).group(SPTabs.tabTools));
	   }

}
