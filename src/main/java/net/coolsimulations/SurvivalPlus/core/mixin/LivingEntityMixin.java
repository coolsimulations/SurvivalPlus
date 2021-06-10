package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.coolsimulations.SurvivalPlus.api.events.SPLivingAttackEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
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
	
	@Inject(at = @At("HEAD"), method = "damage", cancellable = true)
	public void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
		ActionResult result = SPLivingAttackEvent.EVENT.invoker().attackEntity((((LivingEntity) (Object)this)), source, amount);

        if (result == ActionResult.FAIL) {
            cir.cancel();
        }
	}
	
	@Shadow
	public abstract ItemStack getStackInHand(Hand hand);

}
