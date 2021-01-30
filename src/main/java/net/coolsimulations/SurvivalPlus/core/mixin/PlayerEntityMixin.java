package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

	@Shadow
	private PlayerInventory inventory;

	protected PlayerEntityMixin(EntityType<? extends LivingEntity> type, World world) {
		super(type, world);
	}

	@SuppressWarnings("unchecked")
	@Inject(at = @At("HEAD"), method = "damageShield", cancellable = true)
	protected void damageShield(float amount, CallbackInfo info) {
		if (amount >= 3.0F && ((ItemAccessor) this.activeItemStack.getItem()).isShield(this.activeItemStack, this)) {
			int i = 1 + MathHelper.floor(amount);
			Hand hand = this.getActiveHand();
			this.activeItemStack.damage(i, (LivingEntity)this, (Consumer)((playerEntity) -> {
				((LivingEntity) playerEntity).sendToolBreakStatus(hand);
			}));
			if (this.activeItemStack.isEmpty()) {
				if (hand == Hand.MAIN_HAND) {
					this.equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
				} else {
					this.equipStack(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
				}

				this.activeItemStack = ItemStack.EMPTY;
				this.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8F, 0.8F + this.world.random.nextFloat() * 0.4F);
			}
		}
	}

	@Inject(at = @At("HEAD"), method = "disableShield", cancellable = true)
	public void disableShield(boolean sprinting, CallbackInfo info) {
		float f = 0.25F + (float)EnchantmentHelper.getEfficiency(this) * 0.05F;
		if (sprinting) {
			f += 0.75F;
		}

		this.getItemCooldownManager().set(this.getActiveItem().getItem(), 100);
		this.clearActiveItem();
		this.world.sendEntityStatus(this, (byte)30);
		info.cancel();
	}

	@Inject(at = @At("HEAD"), method = "takeShieldHit", cancellable = true)
	public void takeShieldHit(LivingEntity attacker, CallbackInfo info) {
		super.takeShieldHit(attacker);
		if (((ItemAccessor) attacker.getMainHandStack().getItem()).canDisableShield(attacker.getMainHandStack(), this.getActiveItem(), this, attacker)) {
			(((PlayerEntity) (Object)this)).disableShield(true);
		}
	}

	@Inject(at = @At("HEAD"), method = "dropSelectedItem", cancellable = true)
	public void dropSelectedItem(boolean dropEntireStack, CallbackInfoReturnable<ItemEntity> cir) {
		ItemStack stack = this.inventory.getMainHandStack();
		if (stack.isEmpty() || !((ItemAccessor) stack.getItem()).onDroppedByPlayer(stack, (((PlayerEntity) (Object)this)))) cir.setReturnValue(null);
	}
	
	@Shadow
	public abstract ItemEntity dropItem(ItemStack stack, boolean bl, boolean bl2);

	@Shadow
	public abstract ItemCooldownManager getItemCooldownManager();

}
