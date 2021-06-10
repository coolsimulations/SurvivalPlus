package net.coolsimulations.SurvivalPlus.core.items;

import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.minecraft.advancement.criterion.Criterions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RayTraceContext;
import net.minecraft.world.World;

public class ItemCardboardLantern extends BlockItem {

	public ItemCardboardLantern(Block block, Item.Settings builder) {
		super(block, builder);
	}

	/**
	 * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
	 * {@link #onItemUse}.
	 */
	public TypedActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemStack = playerIn.getStackInHand(handIn);
		HitResult hitResult = rayTrace(worldIn, playerIn, RayTraceContext.FluidHandling.SOURCE_ONLY);
		if (hitResult.getType() == HitResult.Type.MISS) {
			return new TypedActionResult(ActionResult.PASS, itemStack);
		} else {
			if (hitResult.getType() == HitResult.Type.BLOCK) {
				BlockHitResult blockHitResult = (BlockHitResult)hitResult;
				BlockPos blockPos = blockHitResult.getBlockPos();
				Direction direction = blockHitResult.getSide();
				if (!worldIn.canPlayerModifyAt(playerIn, blockPos) || !playerIn.canPlaceOn(blockPos.offset(direction), direction, itemStack)) {
					return new TypedActionResult(ActionResult.FAIL, itemStack);
				}

				BlockPos blockpos1 = blockPos.up();
				BlockState blockState = worldIn.getBlockState(blockPos);
				Material material = blockState.getMaterial();
				FluidState fluidState = worldIn.getFluidState(blockPos);
				if (fluidState.getFluid() == Fluids.WATER && worldIn.isAir(blockpos1)) {
					worldIn.setBlockState(blockpos1, getBlock().getDefaultState().with(BlockCardboardLantern.FACING, playerIn.getHorizontalFacing().getOpposite()).with(BlockCardboardLantern.FLOATING, true).with(BlockCardboardLantern.WATERLOGGED, false), 11);
					if (playerIn instanceof ServerPlayerEntity) {
						Criterions.PLACED_BLOCK.trigger((ServerPlayerEntity)playerIn, blockpos1, itemStack);
					}

					if (!playerIn.abilities.creativeMode) {
						itemStack.decrement(1);
					}

					playerIn.incrementStat(Stats.USED.getOrCreateStat(this));
					worldIn.playSound(playerIn, blockPos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					return new TypedActionResult(ActionResult.SUCCESS, itemStack);
				}
			}

			return new TypedActionResult(ActionResult.FAIL, itemStack);
		}
	}
}
