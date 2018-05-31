package net.coolsimulations.SurvivalPlus.core.tabs;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SurvivalPlusMaterialsTab extends CreativeTabs{

	public SurvivalPlusMaterialsTab() {
		super("tabMaterials");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(SPItems.tin_ingot);
	}

}
