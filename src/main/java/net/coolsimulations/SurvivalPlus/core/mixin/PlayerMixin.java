package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {

	@Shadow
	private Inventory inventory;

	protected PlayerMixin(EntityType<? extends LivingEntity> type, Level world) {
		super(type, world);
	}

	@SuppressWarnings("unchecked")
	@Inject(at = @At("HEAD"), method = "hurtCurrentlyUsedShield", cancellable = true)
	protected void hurtCurrentlyUsedShield(float amount, CallbackInfo info) {
		if (amount >= 3.0F && ((ItemAccessor) this.useItem.getItem()).isShield(this.useItem, this)) {
			int i = 1 + Mth.floor(amount);
			InteractionHand hand = this.getUsedItemHand();
			this.useItem.hurtAndBreak(i, (LivingEntity)this, (Consumer)((playerEntity) -> {
				((LivingEntity) playerEntity).broadcastBreakEvent(hand);;
			}));
			if (this.useItem.isEmpty()) {
				if (hand == InteractionHand.MAIN_HAND) {
					this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
				} else {
					this.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
				}

				this.useItem = ItemStack.EMPTY;
				this.playSound(SoundEvents.SHIELD_BREAK, 0.8F, 0.8F + this.level.random.nextFloat() * 0.4F);
			}
		}
	}

	@Inject(at = @At("HEAD"), method = "disableShield", cancellable = true)
	public void disableShield(boolean sprinting, CallbackInfo info) {
		float f = 0.25F + (float)EnchantmentHelper.getBlockEfficiency(this) * 0.05F;
		if (sprinting) {
			f += 0.75F;
		}

		this.getCooldowns().addCooldown(this.getUseItem().getItem(), 100);
		this.stopUsingItem();
		this.level.broadcastEntityEvent(this, (byte)30);
		info.cancel();
	}

	@Inject(at = @At("HEAD"), method = "blockUsingShield", cancellable = true)
	public void blockUsingShield(LivingEntity attacker, CallbackInfo info) {
		super.blockUsingShield(attacker);
		if (((ItemAccessor) attacker.getMainHandItem().getItem()).canDisableShield(attacker.getMainHandItem(), this.getUseItem(), this, attacker)) {
			(((Player) (Object)this)).disableShield(true);
		}
	}

	@Shadow
	public abstract ItemCooldowns getCooldowns();

}
