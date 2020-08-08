package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraft.item.HoeItem;

public class SPItemHoe extends HoeItem{

	public SPItemHoe(IItemTier tier, float attackDamageIn, float attackSpeedIn) {
		super(tier, (int) attackDamageIn, attackSpeedIn, (new Item.Properties().addToolType(ToolType.HOE, tier.getHarvestLevel()).group(SPTabs.tabTools)));
	}

}
