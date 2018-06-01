package net.coolsimulations.SurvivalPlus.core.tabs;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SurvivalPlusFoodTab extends CreativeTabs{

	public SurvivalPlusFoodTab() {
		super("tabFood");
	}

	@Override
	public Item getTabIconItem() {
		return SPItems.apple_pie;
	}

}
