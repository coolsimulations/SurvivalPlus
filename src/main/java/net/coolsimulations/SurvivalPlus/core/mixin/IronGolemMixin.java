package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.item.SPItemIngot;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@Mixin(IronGolem.class)
public abstract class IronGolemMixin extends AbstractGolem {

	protected IronGolemMixin(EntityType<? extends AbstractGolem> type, Level world) {
		super(type, world);
	}

	@Inject(at = @At("HEAD"), method = "mobInteract", cancellable = true)
	public void mobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir)
	{
		ItemStack itemStack = player.getItemInHand(hand);

		Item item = itemStack.getItem();

		Random rand = new Random();
		
		if (this.getHealth() < this.getMaxHealth()) {
			if(item instanceof SPItemIngot && ((SPItemIngot) item).healsGolem()) {
				this.heal(((SPItemIngot) item).getGolemHealth());
				float f1 = 1.0F + (rand.nextFloat() - rand.nextFloat()) * 0.2F;
				this.playSound(SoundEvents.IRON_GOLEM_REPAIR, 1.0F, f1);
				if (!player.getAbilities().instabuild) {
					itemStack.shrink(1);
				}
				
				cir.setReturnValue(InteractionResult.sidedSuccess(this.level.isClientSide));
			}
		}
	}

}
