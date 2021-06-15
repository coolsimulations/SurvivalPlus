package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.enchantment.EfficiencyEnchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;

public class SPItemShears extends ShearsItem{

	public SPItemShears(int maxDamage) {
		super((new Item.Properties()).stacksTo(1).defaultDurability(maxDamage).tab(SPTabs.tabTools));
	}

}
