package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.advancement.criterion.Criterions;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShearsItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(BeehiveBlock.class)
public abstract class BeehiveBlockMixin {

	@Inject(at = @At("HEAD"), method = "onUse", cancellable = true)
	public void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
		
		ItemStack itemStack = player.getStackInHand(hand);
		ItemStack itemStack2 = itemStack.copy();
		int i = (Integer)state.get(BeehiveBlock.HONEY_LEVEL);
		boolean bl = false;

		if (i >= 5) {
			if (itemStack.getItem() instanceof ShearsItem && itemStack.getItem() != Items.SHEARS) {
				world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_BEEHIVE_SHEAR, SoundCategory.NEUTRAL, 1.0F, 1.0F);
				BeehiveBlock.dropHoneycomb(world, pos);
				itemStack.damage(1, (LivingEntity)player, (Consumer)((playerx) -> {
					((LivingEntity) playerx).sendToolBreakStatus(hand);
				}));
				bl = true;
			}
		}
		
		if (bl) {
	         if (!CampfireBlock.isLitCampfireInRange(world, pos, 5)) {
	            if (this.hasBees(world, pos)) {
	               this.angerNearbyBees(world, pos);
	            }

	            this.takeHoney(world, state, pos, player, BeehiveBlockEntity.BeeState.EMERGENCY);
	         } else {
	            this.takeHoney(world, state, pos);
	            if (player instanceof ServerPlayerEntity) {
	               Criterions.SAFELY_HARVEST_HONEY.test((ServerPlayerEntity)player, pos, itemStack2);
	            }
	         }
	      }
	}
	
	@Shadow
	public abstract boolean hasBees(World world, BlockPos pos);
	
	@Shadow
	public abstract void angerNearbyBees(World world, BlockPos pos);
	
	@Shadow
	public abstract void takeHoney(World world, BlockState state, BlockPos pos, @Nullable PlayerEntity player, BeehiveBlockEntity.BeeState beeState);
	
	@Shadow
	public abstract void takeHoney(World world, BlockState state, BlockPos pos);

}
