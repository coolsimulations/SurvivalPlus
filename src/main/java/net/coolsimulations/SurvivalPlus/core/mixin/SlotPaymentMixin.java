package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.item.SPItemIngot;
import net.minecraft.item.ItemStack;

@Mixin(targets = { "net.minecraft.container.BeaconContainer$SlotPayment" })
public class SlotPaymentMixin {

	@Inject(at = @At("HEAD"), method = "Lnet/minecraft/container/BeaconContainer$SlotPayment;canInsert(Lnet/minecraft/item/ItemStack;)Z", cancellable = true)
	public void canInsert(ItemStack stack, CallbackInfoReturnable<Boolean> cir)
	{
		if(stack.getItem() instanceof SPItemIngot) {
			if(((SPItemIngot) stack.getItem()).beacon) {
				cir.setReturnValue(true);
			}
				
		}
	}
}
