package net.coolsimulations.SurvivalPlus.core.tabs;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SurvivalPlusToolsTab extends CreativeTabs{

	public SurvivalPlusToolsTab() {
		super("tabTools");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(SPItems.bronze_axe);
	}

}
