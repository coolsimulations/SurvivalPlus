package net.coolsimulations.SurvivalPlus.core.tabs;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SurvivalPlusGemTab extends CreativeTabs{

	public SurvivalPlusGemTab() {
		super("tabGem");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(SPBlocks.amethyst);
	}

}
