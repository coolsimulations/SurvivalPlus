package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class SPItemAxe extends AxeItem {

	public SPItemAxe(ToolMaterial tier, float damage, float speed) {
		//super(tier, 6.0F, -3.2F, (new Item.Properties().addToolType(ToolType.AXE, tier.getHarvestLevel()).group(SPTabs.tabTools)));
		super(tier, damage, speed, (new FabricItemSettings()).group(SPTabs.tabTools));
	}

}