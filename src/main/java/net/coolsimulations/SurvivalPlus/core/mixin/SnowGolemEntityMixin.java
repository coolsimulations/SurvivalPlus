package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

@Mixin(SnowGolemEntity.class)
public abstract class SnowGolemEntityMixin extends GolemEntity {
	
	protected SnowGolemEntityMixin(EntityType<? extends GolemEntity> type, World world) {
		super(type, world);
	}

	@Shadow
	public abstract void setHasPumpkin(boolean hasPumpkin);
	
	@Shadow
	public abstract boolean hasPumpkin();
	
	@SuppressWarnings("unchecked")
	@Inject(at = @At("TAIL"), method = "interactMob", cancellable = true)
	public void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir)
	{
		ItemStack itemStack = player.getStackInHand(hand);
	      if (itemStack.getItem() instanceof ShearsItem && this.hasPumpkin() && !this.world.isClient) {
	         this.setHasPumpkin(false);
	         itemStack.damage(1, (LivingEntity)player, (Consumer)((playerEntity) -> {
	            ((LivingEntity) playerEntity).sendToolBreakStatus(hand);
	         }));
	      }
	}

}
