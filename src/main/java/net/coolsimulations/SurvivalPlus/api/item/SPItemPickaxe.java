package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;

public class SPItemPickaxe extends PickaxeItem{

	public SPItemPickaxe(IItemTier tier) {
	      super(tier, 1, -2.8F, (new Item.Properties().addToolType(ToolType.PICKAXE, tier.getHarvestLevel()).group(SPTabs.tabTools)));
	   }

}
