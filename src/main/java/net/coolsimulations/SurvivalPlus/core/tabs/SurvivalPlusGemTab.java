package net.coolsimulations.SurvivalPlus.core.tabs;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SurvivalPlusGemTab extends CreativeTabs{

	public SurvivalPlusGemTab() {
		super("tabGem");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(SPBlocks.amethyst);
	}

}
