package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.enchantment.EfficiencyEnchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;

public class SPItemShears extends ShearsItem{
	
	public SPItemShears(int maxDamage) {
	    super((new Item.Properties()).maxStackSize(1).defaultMaxDamage(maxDamage).group(SPTabs.tabTools));
    }
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.enchantment.Enchantment enchantment)
    {
		if(enchantment instanceof EfficiencyEnchantment)
			return true;
		else
			return enchantment.type.canEnchantItem(stack.getItem());
    }

}
