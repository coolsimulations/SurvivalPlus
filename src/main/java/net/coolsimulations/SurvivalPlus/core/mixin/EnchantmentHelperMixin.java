package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;

@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin {

	@Inject(at = @At("TAIL"), method = "getAvailableEnchantmentResults", cancellable = true)
	private static void getAvailableEnchantmentResults(int power, ItemStack stack, boolean bl, CallbackInfoReturnable<List<EnchantmentInstance>> cir) {
		Item item = stack.getItem();
		boolean bl2 = item == Items.BOOK;

		for(Enchantment enchantment : Registry.ENCHANTMENT) {
			if ((!enchantment.isTreasureOnly() || bl) && (((ItemAccessor) stack.getItem()).canApplyAtEnchantingTable(stack, enchantment) || bl2)) {
				for(int i = enchantment.getMaxLevel(); i > enchantment.getMinLevel() - 1; --i) {
					if (power >= enchantment.getMinCost(i) && power <= enchantment.getMaxCost(i)) {
						cir.getReturnValue().add(new EnchantmentInstance(enchantment, i));
						break;
					}
				}
			}
		}
	}
}
