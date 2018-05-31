package net.coolsimulations.SurvivalPlus.core.tabs;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SurvivalPlusCombatTab extends CreativeTabs{

	public SurvivalPlusCombatTab() {
		super("tabCombat");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(SPItems.titanium_sword);
	}

}
