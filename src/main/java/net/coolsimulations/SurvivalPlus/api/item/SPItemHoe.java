package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class SPItemHoe extends HoeItem{

	public SPItemHoe(ToolMaterial tier) {
		super(tier, tier.getMiningLevel() - 3.5F, (new FabricItemSettings().group(SPTabs.tabTools)));
	}

}
