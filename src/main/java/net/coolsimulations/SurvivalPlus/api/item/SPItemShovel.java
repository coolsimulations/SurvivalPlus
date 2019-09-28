package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.common.ToolType;

public class SPItemShovel extends ShovelItem {

	public SPItemShovel(IItemTier tier) {
	      super(tier, 1.5F, -3.0F, (new Item.Properties().addToolType(ToolType.SHOVEL, tier.getHarvestLevel()).group(SPTabs.tabTools)));
	   }

}
