package net.coolsimulations.SurvivalPlus.api.events;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

public interface ItemAccessor {
	
	boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment);
	
	boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker);
	
	boolean isShield(ItemStack stack, @Nullable LivingEntity entity);
	
	boolean onDroppedByPlayer(ItemStack item, Player player);
	
	boolean onEntitySwing(ItemStack stack, LivingEntity entity);
	
	boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player);

}
