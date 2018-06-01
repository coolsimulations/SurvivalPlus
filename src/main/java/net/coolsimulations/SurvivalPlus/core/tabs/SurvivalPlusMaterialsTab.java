package net.coolsimulations.SurvivalPlus.core.tabs;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SurvivalPlusMaterialsTab extends CreativeTabs{

	public SurvivalPlusMaterialsTab() {
		super("tabMaterials");
	}

	@Override
	public Item getTabIconItem() {
		return SPItems.tin_ingot;
	}

}
