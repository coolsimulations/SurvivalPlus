package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraft.world.item.HoeItem;

public class SPItemHoe extends HoeItem{

	public SPItemHoe(Tier tier, float attackDamageIn, float attackSpeedIn) {
		super(tier, (int) attackDamageIn, attackSpeedIn, (new Item.Properties().addToolType(ToolType.HOE, tier.getLevel()).tab(SPTabs.tabTools)));
	}

}
