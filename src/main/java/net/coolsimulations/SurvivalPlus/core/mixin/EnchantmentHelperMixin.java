package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.google.common.collect.Lists;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.InfoEnchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin {

	@Inject(at = @At("HEAD"), method = "getHighestApplicableEnchantmentsAtPower", cancellable = true)
	private static void getHighestApplicableEnchantmentsAtPower(int power, ItemStack stack, boolean bl, CallbackInfoReturnable<List<InfoEnchantment>> cir) {
		List<InfoEnchantment> list = Lists.newArrayList();
		Item item = stack.getItem();
		boolean bl2 = item == Items.BOOK;

		for(Enchantment enchantment : Registry.ENCHANTMENT) {
			if ((!enchantment.isTreasure() || bl) && (((ItemAccessor) stack.getItem()).canApplyAtEnchantingTable(stack, enchantment) || bl2)) {
				for(int i = enchantment.getMaximumLevel(); i > enchantment.getMinimumLevel() - 1; --i) {
					if (power >= enchantment.getMinimumPower(i) && power <= enchantment.getMaximumPower(i)) {
						list.add(new InfoEnchantment(enchantment, i));
						break;
					}
				}
			}
		}

		cir.setReturnValue(list);
	}

}