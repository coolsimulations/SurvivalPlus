package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.animal.MushroomCow.MushroomType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;

@Mixin(MushroomCow.class)
public abstract class MushroomCowMixin extends Animal {
	
	protected MushroomCowMixin(EntityType<? extends Animal> type, Level world) {
		super(type, world);
	}
	
	@Shadow
	public abstract MushroomCow.MushroomType getMushroomType();
	
	@Shadow
	public abstract boolean readyForShearing();

	@SuppressWarnings("unchecked")
	@Inject(at = @At("TAIL"), method = "mobInteract", cancellable = true)
	public void mobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir)
	{
		ItemStack itemStack = player.getItemInHand(hand);
		int k;
		
		if (itemStack.getItem() instanceof ShearsItem && this.readyForShearing()) {
			((ServerLevel) this.level).sendParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(0.5D), this.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
            if (!this.level.isClientSide) {
               this.remove();
               Cow cowEntity = (Cow)EntityType.COW.create(this.level);
               cowEntity.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, this.xRot);
               cowEntity.setHealth(this.getHealth());
               cowEntity.yBodyRot = this.yBodyRot;
               if (this.hasCustomName()) {
                  cowEntity.setCustomName(this.getCustomName());
               }

               this.level.addFreshEntity(cowEntity);

               for(k = 0; k < 5; ++k) {
                  this.level.addFreshEntity(new ItemEntity(this.level, this.getX(), this.getY(1.0D), this.getZ(), new ItemStack(this.getMushroomType().getBlockState().getBlock())));
               }

               itemStack.hurtAndBreak(1, (LivingEntity)player, (Consumer)((playerEntity) -> {
                  ((LivingEntity) playerEntity).broadcastBreakEvent(hand);;
               }));
               this.playSound(SoundEvents.MOOSHROOM_SHEAR, 1.0F, 1.0F);
            }
            
            cir.setReturnValue(InteractionResult.PASS);
         }
	}

}
