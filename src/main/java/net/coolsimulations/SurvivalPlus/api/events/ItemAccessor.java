package net.coolsimulations.SurvivalPlus.api.events;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public interface ItemAccessor {
	
	boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment);
	
	boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker);

}
