package net.coolsimulations.SurvivalPlus.api.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShearsItem;

public class SPItemShears extends ShearsItem{

	public SPItemShears(int maxDamage) {
		super((new Item.Properties()).stacksTo(1).defaultDurability(maxDamage));
	}

}
