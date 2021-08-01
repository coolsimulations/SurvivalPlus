package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

@Mixin(Sheep.class)
public abstract class SheepMixin extends Animal {

	protected SheepMixin(EntityType<? extends Animal> type, Level world) {
		super(type, world);
	}

	@Shadow
	public abstract boolean readyForShearing();
	
	@Shadow
	public abstract void shear(SoundSource shearedSoundCategory);

	@SuppressWarnings("unchecked")
	@Inject(at = @At("TAIL"), method = "mobInteract", cancellable = true)
	public void mobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir)
	{
		ItemStack itemStack = player.getItemInHand(hand);
		if (itemStack.getItem() instanceof ShearsItem) {
			if (!this.level.isClientSide && this.readyForShearing()) {
	            this.shear(SoundSource.PLAYERS);
	            this.gameEvent(GameEvent.SHEAR, player);
	            itemStack.hurtAndBreak(1, (LivingEntity)player, (Consumer)((playerEntity) -> {
	               ((LivingEntity) playerEntity).broadcastBreakEvent(hand);;
	            }));
	            cir.setReturnValue(InteractionResult.SUCCESS);
	         }
		}
	}

}
