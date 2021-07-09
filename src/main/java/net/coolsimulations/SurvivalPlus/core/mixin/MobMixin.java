package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

@Mixin(Mob.class)
public abstract class MobMixin extends LivingEntity {

	protected MobMixin(EntityType<? extends LivingEntity> type, Level world) {
		super(type, world);
	}

	@Inject(at = @At("HEAD"), method = "getEquipmentSlotForItem", cancellable = true)
	private static void getEquipmentSlotForItem(ItemStack stack, CallbackInfoReturnable<EquipmentSlot> cir) {
		Item item = stack.getItem();
		if(((ItemAccessor) item).isShield(stack, null)) {
			cir.setReturnValue(EquipmentSlot.OFFHAND);
		}
	}

	@Inject(at = @At("HEAD"), method = "doHurtTarget", cancellable = true)
	public void doHurtTarget(Entity target, CallbackInfoReturnable<Boolean> cir) {
		float f = (float)this.getAttribute(Attributes.ATTACK_DAMAGE).getValue();
		if (target instanceof LivingEntity) {
			f += EnchantmentHelper.getDamageBonus(this.getMainHandItem(), ((LivingEntity)target).getMobType());
		}

		boolean bl = target.hurt(DamageSource.mobAttack(this), f);
		
		if (bl) {
			if (target instanceof Player) {
	            Player playerEntity = (Player)target;
	            ItemStack itemStack = this.getMainHandItem();
	            ItemStack itemStack2 = playerEntity.isUsingItem() ? playerEntity.getUseItem() : ItemStack.EMPTY;
	            if (!itemStack.isEmpty() && !itemStack2.isEmpty() && ((ItemAccessor) itemStack.getItem()).canDisableShield(itemStack, itemStack2, playerEntity, this) && ((ItemAccessor) itemStack2.getItem()).isShield(itemStack2, this)) {
	               float h = 0.25F + (float)EnchantmentHelper.getBlockEfficiency(this) * 0.05F;
	               if (this.random.nextFloat() < h) {
	                  playerEntity.getCooldowns().addCooldown(itemStack2.getItem(), 100);
	                  this.level.broadcastEntityEvent(playerEntity, (byte)30);
	               }
	            }
	         }
		}

	}

}
