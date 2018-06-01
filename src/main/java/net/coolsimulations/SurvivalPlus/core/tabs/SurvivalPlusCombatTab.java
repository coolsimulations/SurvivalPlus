package net.coolsimulations.SurvivalPlus.core.tabs;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SurvivalPlusCombatTab extends CreativeTabs{

	public SurvivalPlusCombatTab() {
		super("tabCombat");
	}

	@Override
	public Item getTabIconItem() {
		return SPItems.titanium_sword;
	}

}
