package net.coolsimulations.SurvivalPlus.core.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.math.BlockPos;

@Mixin(Item.class)
public class ItemMixin implements ItemAccessor {

	@Override
	@Unique
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return enchantment.type.isAcceptableItem(stack.getItem());
	}

	@Override
	@Unique
	public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
		return shield.getItem() instanceof AxeItem;
	}

	@Override
	@Unique
	public boolean isShield(ItemStack stack, @Nullable LivingEntity entity) {
		return stack.getItem() instanceof ShieldItem;
	}

	@Override
	@Unique
	public boolean onDroppedByPlayer(ItemStack item, PlayerEntity player) {
		return true;
	}

	@Override
	@Unique
	public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
		return false;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, PlayerEntity player) {
		return false;
	}

}
