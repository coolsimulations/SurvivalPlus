package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	
	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(at = @At("HEAD"), method = "swingHand", cancellable = false)
	public void swingHand(Hand hand, CallbackInfo info) {
		ItemStack stack = this.getStackInHand(hand);
		if (!stack.isEmpty() && ((ItemAccessor) stack.getItem()).onEntitySwing(stack, (((LivingEntity) (Object)this)))) info.cancel();
	}
	
	@Shadow
	public abstract ItemStack getStackInHand(Hand hand);

}
