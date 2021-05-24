package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {

	protected MobEntityMixin(EntityType<? extends LivingEntity> type, World world) {
		super(type, world);
	}

	@Inject(at = @At("HEAD"), method = "getPreferredEquipmentSlot", cancellable = true)
	private static void getPreferredEquipmentSlot(ItemStack stack, CallbackInfoReturnable<EquipmentSlot> cir) {
		Item item = stack.getItem();
		if(((ItemAccessor) item).isShield(stack, null)) {
			cir.setReturnValue(EquipmentSlot.OFFHAND);
		}
	}

	@Inject(at = @At("HEAD"), method = "tryAttack", cancellable = true)
	public void tryAttack(Entity target, CallbackInfoReturnable<Boolean> cir) {
		float f = (float)this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).getValue();
		if (target instanceof LivingEntity) {
			f += EnchantmentHelper.getAttackDamage(this.getMainHandStack(), ((LivingEntity)target).getGroup());
		}

		boolean bl = target.damage(DamageSource.mob(this), f);
		
		if (bl) {
			if (target instanceof PlayerEntity) {
	            PlayerEntity playerEntity = (PlayerEntity)target;
	            ItemStack itemStack = this.getMainHandStack();
	            ItemStack itemStack2 = playerEntity.isUsingItem() ? playerEntity.getActiveItem() : ItemStack.EMPTY;
	            if (!itemStack.isEmpty() && !itemStack2.isEmpty() && ((ItemAccessor) itemStack.getItem()).canDisableShield(itemStack, itemStack2, playerEntity, this) && ((ItemAccessor) itemStack2.getItem()).isShield(itemStack2, this)) {
	               float h = 0.25F + (float)EnchantmentHelper.getEfficiency(this) * 0.05F;
	               if (this.random.nextFloat() < h) {
	                  playerEntity.getItemCooldownManager().set(itemStack2.getItem(), 100);
	                  this.world.sendEntityStatus(playerEntity, (byte)30);
	               }
	            }
	         }
		}

	}

}
