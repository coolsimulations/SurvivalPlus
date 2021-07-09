package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

@Mixin(BeehiveBlock.class)
public abstract class BeehiveBlockMixin {

	@Inject(at = @At("HEAD"), method = "use", cancellable = true)
	public void use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit, CallbackInfoReturnable<InteractionResult> cir) {
		
		ItemStack itemStack = player.getItemInHand(hand);
		ItemStack itemStack2 = itemStack.copy();
		int i = (Integer)state.getValue(BeehiveBlock.HONEY_LEVEL);
		boolean bl = false;

		if (i >= 5) {
			if (itemStack.getItem() instanceof ShearsItem && itemStack.getItem() != Items.SHEARS) {
				world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BEEHIVE_SHEAR, SoundSource.NEUTRAL, 1.0F, 1.0F);
				BeehiveBlock.dropHoneycomb(world, pos);
				itemStack.hurtAndBreak(1, (LivingEntity)player, (Consumer)((playerx) -> {
					((LivingEntity) playerx).broadcastBreakEvent(hand);
				}));
				bl = true;
			}
		}
		
		if (bl) {
	         if (!CampfireBlock.isSmokeyPos(world, pos)) {
	            if (this.hiveContainsBees(world, pos)) {
	               this.angerNearbyBees(world, pos);
	            }

	            this.releaseBeesAndResetHoneyLevel(world, state, pos, player, BeehiveBlockEntity.BeeReleaseStatus.EMERGENCY);
	         } else {
	            this.resetHoneyLevel(world, state, pos);
	         }
	      }
	}
	
	@Shadow
	public abstract boolean hiveContainsBees(Level world, BlockPos pos);
	
	@Shadow
	public abstract void angerNearbyBees(Level world, BlockPos pos);
	
	@Shadow
	public abstract void releaseBeesAndResetHoneyLevel(Level world, BlockState state, BlockPos pos, @Nullable Player player, BeehiveBlockEntity.BeeReleaseStatus beeState);
	
	@Shadow
	public abstract void resetHoneyLevel(Level world, BlockState state, BlockPos pos);

}
