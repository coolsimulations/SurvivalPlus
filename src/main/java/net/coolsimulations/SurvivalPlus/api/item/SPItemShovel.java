package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraftforge.common.ToolType;

public class SPItemShovel extends ShovelItem {

	public SPItemShovel(Tier tier) {
	      super(tier, 1.5F, -3.0F, (new Item.Properties().addToolType(ToolType.SHOVEL, tier.getLevel()).tab(SPTabs.tabTools)));
	   }

}
