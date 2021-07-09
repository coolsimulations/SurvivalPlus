package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.coolsimulations.SurvivalPlus.api.events.SPLivingAttackEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	
	public LivingEntityMixin(EntityType<?> type, Level world) {
		super(type, world);
	}

	@Inject(at = @At("HEAD"), method = "swing", cancellable = false)
	public void swing(InteractionHand hand, CallbackInfo info) {
		ItemStack stack = this.getItemInHand(hand);
		if (!stack.isEmpty() && ((ItemAccessor) stack.getItem()).onEntitySwing(stack, (((LivingEntity) (Object)this)))) info.cancel();
	}
	
	@Inject(at = @At("HEAD"), method = "hurt", cancellable = true)
	public void hurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
		InteractionResult result = SPLivingAttackEvent.EVENT.invoker().attackEntity((((LivingEntity) (Object)this)), source, amount);

        if (result == InteractionResult.FAIL) {
            cir.cancel();
        }
	}
	
	@Shadow
	public abstract ItemStack getItemInHand(InteractionHand hand);

}
