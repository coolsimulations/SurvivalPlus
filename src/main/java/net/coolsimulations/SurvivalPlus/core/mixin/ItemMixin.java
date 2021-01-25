package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mixin(Item.class)
public class ItemMixin implements ItemAccessor {

	@Override
	@Unique
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return enchantment.type.isAcceptableItem(stack.getItem());
	}

}
