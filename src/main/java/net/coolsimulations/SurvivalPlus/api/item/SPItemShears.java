package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ShearsItem;

public class SPItemShears extends ShearsItem{
	
	public SPItemShears(int maxDamage) {
	    super((new Item.Properties()).maxStackSize(1).defaultMaxDamage(maxDamage).group(SPTabs.tabTools));
    }

}
