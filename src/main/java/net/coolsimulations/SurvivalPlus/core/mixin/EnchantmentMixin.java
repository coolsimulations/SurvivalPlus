package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

@Mixin(Enchantment.class)
public abstract class EnchantmentMixin {

	@Inject(at = @At("HEAD"), method = "isAcceptableItem", cancellable = true)
	public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		if(((ItemAccessor) stack.getItem()).canApplyAtEnchantingTable(stack, (((Enchantment) (Object)this)))) {
			cir.setReturnValue(true);
		}
	}

}
