package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.kwpugh.gobber2.enchantments.QuickUseEnchantment;

import net.coolsimulations.SurvivalPlus.api.compat.SPGobberEnchantments;
import net.minecraft.world.item.ItemStack;

@Mixin(QuickUseEnchantment.class)
public class QuickUseEnchantmentMixin {
	
	@Inject(at = @At("HEAD"), method = "method_8192", cancellable = true, remap = false, require = 0)
	public void canEnchant(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
		
		if(SPGobberEnchantments.quick_use.contains(stack.getItem()))
			info.setReturnValue(true);
	}

}
