package net.coolsimulations.SurvivalPlus.core.items;

import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class ItemCardboardLantern extends BlockItem {

	public ItemCardboardLantern(Block block, Item.Properties builder) {
		super(block, builder);
	}

	/**
	 * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
	 * {@link #onItemUse}.
	 */
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack itemStack = playerIn.getItemInHand(handIn);
		HitResult hitResult = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.SOURCE_ONLY);
		if (hitResult.getType() == HitResult.Type.MISS) {
			return new InteractionResultHolder(InteractionResult.PASS, itemStack);
		} else {
			if (hitResult.getType() == HitResult.Type.BLOCK) {
				BlockHitResult blockHitResult = (BlockHitResult)hitResult;
				BlockPos blockPos = blockHitResult.getBlockPos();
				Direction direction = blockHitResult.getDirection();
				if (!worldIn.mayInteract(playerIn, blockPos) || !playerIn.mayUseItemAt(blockPos.relative(direction), direction, itemStack)) {
					return new InteractionResultHolder(InteractionResult.FAIL, itemStack);
				}

				BlockPos blockpos1 = blockPos.above();
				BlockState blockState = worldIn.getBlockState(blockPos);
				Material material = blockState.getMaterial();
				FluidState fluidState = worldIn.getFluidState(blockPos);
				if (fluidState.getType() == Fluids.WATER && worldIn.isEmptyBlock(blockpos1)) {
					worldIn.setBlock(blockpos1, getBlock().defaultBlockState().setValue(BlockCardboardLantern.FACING, playerIn.getDirection().getOpposite()).setValue(BlockCardboardLantern.FLOATING, true).setValue(BlockCardboardLantern.WATERLOGGED, false), 11);
					if (playerIn instanceof ServerPlayer) {
						CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)playerIn, blockpos1, itemStack);
					}

					if (!playerIn.getAbilities().instabuild) {
						itemStack.shrink(1);
					}

					playerIn.awardStat(Stats.ITEM_USED.get(this));
					worldIn.playSound(playerIn, blockPos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
					return new InteractionResultHolder(InteractionResult.SUCCESS, itemStack);
				}
			}

			return new InteractionResultHolder(InteractionResult.FAIL, itemStack);
		}
	}
}
