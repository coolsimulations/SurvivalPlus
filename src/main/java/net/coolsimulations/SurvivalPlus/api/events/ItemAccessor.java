package net.coolsimulations.SurvivalPlus.api.events;

import org.jetbrains.annotations.Nullable;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public interface ItemAccessor {
	
	boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment);
	
	boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker);
	
	boolean isShield(ItemStack stack, @Nullable LivingEntity entity);
	
	boolean onDroppedByPlayer(ItemStack item, PlayerEntity player);
	
	boolean onEntitySwing(ItemStack stack, LivingEntity entity);
	
	boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, PlayerEntity player);

}
