package net.coolsimulations.SurvivalPlus.core.tabs;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SurvivalPlusToolsTab extends CreativeTabs{

	public SurvivalPlusToolsTab() {
		super("tabTools");
	}

	@Override
	public Item getTabIconItem() {
		return SPItems.bronze_axe;
	}

}
