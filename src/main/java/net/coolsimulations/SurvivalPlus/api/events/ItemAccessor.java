package net.coolsimulations.SurvivalPlus.api.events;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

public interface ItemAccessor {
	
	boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment);

}
