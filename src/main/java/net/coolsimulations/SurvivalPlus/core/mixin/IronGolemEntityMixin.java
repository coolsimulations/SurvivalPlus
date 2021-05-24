package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.item.SPItemIngot;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

@Mixin(IronGolemEntity.class)
public abstract class IronGolemEntityMixin extends GolemEntity {

	protected IronGolemEntityMixin(EntityType<? extends GolemEntity> type, World world) {
		super(type, world);
	}

	@Inject(at = @At("HEAD"), method = "interactMob", cancellable = true)
	public void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir)
	{
		ItemStack itemStack = player.getStackInHand(hand);

		Item item = itemStack.getItem();

		Random rand = new Random();
		
		if (this.getHealth() < this.getMaxHealth()) {
			if(item instanceof SPItemIngot && ((SPItemIngot) item).healsGolem()) {
				this.heal(((SPItemIngot) item).getGolemHealth());
				float f1 = 1.0F + (rand.nextFloat() - rand.nextFloat()) * 0.2F;
				this.playSound(SoundEvents.ENTITY_IRON_GOLEM_REPAIR, 1.0F, f1);
				if (!player.abilities.creativeMode) {
					itemStack.decrement(1);
				}
				
				cir.setReturnValue(ActionResult.PASS);
			}
		}
	}

}
