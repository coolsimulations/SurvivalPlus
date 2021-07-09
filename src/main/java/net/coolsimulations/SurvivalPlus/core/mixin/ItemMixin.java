package net.coolsimulations.SurvivalPlus.core.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.enchantment.Enchantment;

@Mixin(Item.class)
public class ItemMixin implements ItemAccessor {

	@Override
	@Unique
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return enchantment.category.canEnchant(stack.getItem());
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
	public boolean onDroppedByPlayer(ItemStack item, Player player) {
		return true;
	}

	@Override
	@Unique
	public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
		return false;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player) {
		return false;
	}

}
