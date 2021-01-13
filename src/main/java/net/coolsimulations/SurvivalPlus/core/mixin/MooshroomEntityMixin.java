package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

@Mixin(MooshroomEntity.class)
public abstract class MooshroomEntityMixin extends AnimalEntity {
	
	protected MooshroomEntityMixin(EntityType<? extends AnimalEntity> type, World world) {
		super(type, world);
	}
	
	@Shadow
	public abstract MooshroomEntity.Type getMooshroomType();

	@SuppressWarnings("unchecked")
	@Inject(at = @At("TAIL"), method = "interactMob", cancellable = true)
	public void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<Boolean> cir)
	{
		ItemStack itemStack = player.getStackInHand(hand);
		int k;
		
		if (itemStack.getItem() instanceof ShearsItem && this.getBreedingAge() >= 0) {
            this.world.addParticle(ParticleTypes.EXPLOSION, this.x, this.y + (double)(this.getHeight() / 2.0F), this.z, 0.0D, 0.0D, 0.0D);
            if (!this.world.isClient) {
               this.remove();
               CowEntity cowEntity = (CowEntity)EntityType.COW.create(this.world);
               cowEntity.refreshPositionAndAngles(this.x, this.y, this.z, this.yaw, this.pitch);
               cowEntity.setHealth(this.getHealth());
               cowEntity.field_6283 = this.field_6283;
               if (this.hasCustomName()) {
                  cowEntity.setCustomName(this.getCustomName());
               }

               this.world.spawnEntity(cowEntity);

               for(k = 0; k < 5; ++k) {
                  this.world.spawnEntity(new ItemEntity(this.world, this.x, this.y + (double)this.getHeight(), this.z, new ItemStack(this.getMooshroomType().getMushroomState().getBlock())));
               }

               itemStack.damage(1, (LivingEntity)player, (Consumer)((playerEntity) -> {
                  ((LivingEntity) playerEntity).sendToolBreakStatus(hand);
               }));
               this.playSound(SoundEvents.ENTITY_MOOSHROOM_SHEAR, 1.0F, 1.0F);
            }
            
            cir.setReturnValue(true);
         }
	}

}
