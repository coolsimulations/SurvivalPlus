package net.coolsimulations.SurvivalPlus.core.tabs;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SurvivalPlusBlocksTab extends CreativeTabs{

	public SurvivalPlusBlocksTab() {
		super("tabBlocks");
	}

	@Override
	public Item getTabIconItem() {
		 return Item.getItemFromBlock(SPBlocks.tin_block);
	}

}
