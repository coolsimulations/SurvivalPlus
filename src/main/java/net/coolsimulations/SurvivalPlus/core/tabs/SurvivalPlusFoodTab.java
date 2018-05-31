package net.coolsimulations.SurvivalPlus.core.tabs;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SurvivalPlusFoodTab extends CreativeTabs{

	public SurvivalPlusFoodTab() {
		super("tabFood");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(SPItems.apple_pie);
	}

}
