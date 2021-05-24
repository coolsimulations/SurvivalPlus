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
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin {

	@Inject(at = @At("HEAD"), method = "getPossibleEntries", cancellable = true)
	private static void getPossibleEntries(int power, ItemStack stack, boolean bl, CallbackInfoReturnable<List<EnchantmentLevelEntry>> cir) {
		List<EnchantmentLevelEntry> list = Lists.newArrayList();
		Item item = stack.getItem();
		boolean bl2 = item == Items.BOOK;

		for(Enchantment enchantment : Registry.ENCHANTMENT) {
			if ((!enchantment.isTreasure() || bl) && (((ItemAccessor) stack.getItem()).canApplyAtEnchantingTable(stack, enchantment) || bl2)) {
				for(int i = enchantment.getMaxLevel(); i > enchantment.getMinLevel() - 1; --i) {
					if (power >= enchantment.getMinPower(i) && power <= enchantment.getMaxPower(i)) {
						list.add(new EnchantmentLevelEntry(enchantment, i));
						break;
					}
				}
			}
		}

		cir.setReturnValue(list);
	}

}
