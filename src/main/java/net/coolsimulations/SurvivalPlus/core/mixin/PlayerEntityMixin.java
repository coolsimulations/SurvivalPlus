package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

	protected PlayerEntityMixin(EntityType<? extends LivingEntity> type, World world) {
		super(type, world);
	}

	@SuppressWarnings("unchecked")
	@Inject(at = @At("HEAD"), method = "damageShield", cancellable = true)
	protected void damageShield(float amount, CallbackInfo info) {
		if (amount >= 3.0F && this.activeItemStack.getItem() instanceof SPItemShield) {
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

		if (this.random.nextFloat() < f) {
			for(int i = 0; i < Registry.ITEM.getIds().size(); i++) {
				if(Registry.ITEM.get(i) instanceof SPItemShield) {
					Item item = Registry.ITEM.get(i);
					this.getItemCooldownManager().set(item, 100);
				}
			}
			this.clearActiveItem();
			this.world.sendEntityStatus(this, (byte)30);
		}

	}
	
	@Inject(at = @At("HEAD"), method = "takeShieldHit", cancellable = true)
	public void takeShieldHit(LivingEntity attacker, CallbackInfo info) {
		super.takeShieldHit(attacker);
	      if (((ItemAccessor) attacker.getMainHandStack().getItem()).canDisableShield(attacker.getMainHandStack(), this.getActiveItem(), this, attacker)) {
	    	  (((PlayerEntity) (Object)this)).disableShield(true);
	      }
	}

	@Shadow
	public abstract ItemCooldownManager getItemCooldownManager();

}
