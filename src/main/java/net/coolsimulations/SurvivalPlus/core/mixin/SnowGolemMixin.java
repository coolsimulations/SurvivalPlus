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
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

@Mixin(SnowGolem.class)
public abstract class SnowGolemMixin extends AbstractGolem {

	protected SnowGolemMixin(EntityType<? extends AbstractGolem> type, Level world) {
		super(type, world);
	}

	@Shadow
	public abstract void shear(SoundSource soundSource);
	
	@Shadow
	public abstract boolean readyForShearing();

	@SuppressWarnings("unchecked")
	@Inject(at = @At("TAIL"), method = "mobInteract", cancellable = true)
	public void mobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir)
	{
		ItemStack itemStack = player.getItemInHand(hand);
		if (itemStack.getItem() instanceof ShearsItem && this.readyForShearing()) {
			this.shear(SoundSource.PLAYERS);
			this.gameEvent(GameEvent.SHEAR, player);
			if (!this.level.isClientSide) {
				itemStack.hurtAndBreak(1, (LivingEntity)player, (Consumer)((playerx) -> {
					((LivingEntity) playerx).broadcastBreakEvent(hand);
				}));
			}

			cir.setReturnValue(InteractionResult.sidedSuccess(this.level.isClientSide));
		}
	}

}
