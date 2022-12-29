package net.coolsimulations.SurvivalPlus.api.item;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

public class SPItemHoe extends HoeItem{

	public SPItemHoe(Tier tier, float attackDamageIn, float attackSpeedIn) {
		super(tier, (int) attackDamageIn, attackSpeedIn, (new Item.Properties()));
	}

}
