package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

@Mixin(Mob.class)
public abstract class MobMixin extends LivingEntity {

	protected MobMixin(EntityType<? extends LivingEntity> type, Level world) {
		super(type, world);
	}
	
	@Inject(at = @At("HEAD"), method = "maybeDisableShield", cancellable = true)
	public void maybeDisableShield(Player player, ItemStack itemStack, ItemStack itemStack2, CallbackInfo info) {
		if (!itemStack.isEmpty() && !itemStack2.isEmpty() && ((ItemAccessor) itemStack.getItem()).canDisableShield(itemStack, itemStack2, player, this) && ((ItemAccessor) itemStack2.getItem()).isShield(itemStack2, this)) {
			float f = 0.25F + (float) EnchantmentHelper.getBlockEfficiency(this) * 0.05F;
			if (this.random.nextFloat() < f) {
				player.getCooldowns().addCooldown(itemStack2.getItem(), 100);
				this.level.broadcastEntityEvent(player, (byte) 30);
			}
		}
	}

}
