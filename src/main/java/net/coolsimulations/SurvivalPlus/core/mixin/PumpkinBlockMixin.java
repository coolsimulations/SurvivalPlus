package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.PumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

@Mixin(PumpkinBlock.class)
public class PumpkinBlockMixin {

	@SuppressWarnings("unchecked")
	@Inject(at = @At("HEAD"), method = "use", cancellable = true)
	public void use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit, CallbackInfoReturnable<InteractionResult> cir) {
		ItemStack itemStack = player.getItemInHand(hand);
		
		if (itemStack.getItem() instanceof ShearsItem && itemStack.getItem() != Items.SHEARS) {
	         if (!world.isClientSide) {
	            Direction direction = hit.getDirection();
	            Direction direction2 = direction.getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : direction;
	            world.playSound((Player)null, pos, SoundEvents.PUMPKIN_CARVE, SoundSource.BLOCKS, 1.0F, 1.0F);
	            world.setBlock(pos, (BlockState)Blocks.CARVED_PUMPKIN.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, direction2), 11);
	            ItemEntity itemEntity = new ItemEntity(world, (double)pos.getX() + 0.5D + (double)direction2.getStepX() * 0.65D, (double)pos.getY() + 0.1D, (double)pos.getZ() + 0.5D + (double)direction2.getStepZ() * 0.65D, new ItemStack(Items.PUMPKIN_SEEDS, 4));
	            itemEntity.setDeltaMovement(0.05D * (double)direction2.getStepX() + world.random.nextDouble() * 0.02D, 0.05D, 0.05D * (double)direction2.getStepZ() + world.random.nextDouble() * 0.02D);
	            world.addFreshEntity(itemEntity);
	            itemStack.hurtAndBreak(1, (LivingEntity)player, (Consumer)((playerEntity) -> {
	               ((LivingEntity) playerEntity).broadcastBreakEvent(hand);;
	            }));
	            world.gameEvent(player, GameEvent.SHEAR, pos);
				player.awardStat(Stats.ITEM_USED.get(Items.SHEARS));
				cir.setReturnValue(InteractionResult.sidedSuccess(world.isClientSide));
	         }
	      }
	}

}
