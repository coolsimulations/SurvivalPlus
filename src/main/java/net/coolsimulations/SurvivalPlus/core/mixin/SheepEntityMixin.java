package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

@Mixin(SheepEntity.class)
public abstract class SheepEntityMixin extends AnimalEntity {

	protected SheepEntityMixin(EntityType<? extends AnimalEntity> type, World world) {
		super(type, world);
	}

	@Shadow
	public abstract void dropItems();

	@Shadow
	public abstract boolean isSheared();

	@SuppressWarnings("unchecked")
	@Inject(at = @At("TAIL"), method = "interactMob", cancellable = true)
	public void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<Boolean> cir)
	{
		ItemStack itemStack = player.getStackInHand(hand);
		if (itemStack.getItem() instanceof ShearsItem && !this.isSheared() && !this.isBaby()) {
			this.dropItems();
			if (!this.world.isClient) {
				itemStack.damage(1, (LivingEntity)player, (Consumer)((playerEntity) -> {
					((LivingEntity) playerEntity).sendToolBreakStatus(hand);
				}));
			}
		}
	}

}
