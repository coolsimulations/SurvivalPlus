package net.coolsimulations.SurvivalPlus.core.items;

import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemCardboardLantern extends BlockItem {

	public ItemCardboardLantern(Block block, Item.Properties builder) {
		super(block, builder);
	}

	/**
	 * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
	 * {@link #use}.
	 */
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		RayTraceResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
		if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
			return new ActionResult<>(ActionResultType.PASS, itemstack);
		} else {
			if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
				BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)raytraceresult;
				BlockPos blockpos = blockraytraceresult.getBlockPos();
				Direction direction = blockraytraceresult.getDirection();
				if (!worldIn.mayInteract(playerIn, blockpos) || !playerIn.mayUseItemAt(blockpos.relative(direction), direction, itemstack)) {
					return new ActionResult<>(ActionResultType.FAIL, itemstack);
				}

				BlockPos blockpos1 = blockpos.above();
				BlockState blockstate = worldIn.getBlockState(blockpos);
				Material material = blockstate.getMaterial();
				FluidState ifluidstate = worldIn.getFluidState(blockpos);
				if (ifluidstate.getType() == Fluids.WATER && worldIn.isEmptyBlock(blockpos1)) {

					// special case for handling block placement with water lilies
					net.minecraftforge.common.util.BlockSnapshot blocksnapshot = net.minecraftforge.common.util.BlockSnapshot.create(worldIn.dimension(), worldIn, blockpos1);
					worldIn.setBlock(blockpos1, getBlock().defaultBlockState().setValue(BlockCardboardLantern.FACING, playerIn.getDirection().getOpposite()).setValue(BlockCardboardLantern.FLOATING, true).setValue(BlockCardboardLantern.WATERLOGGED, false), 11);
					if (net.minecraftforge.event.ForgeEventFactory.onBlockPlace(playerIn, blocksnapshot, net.minecraft.util.Direction.UP)) {
						blocksnapshot.restore(true, false);
						return new ActionResult<ItemStack>(ActionResultType.FAIL, itemstack);
					}

					if (playerIn instanceof ServerPlayerEntity) {
						CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerIn, blockpos1, itemstack);
					}

					if (!playerIn.abilities.instabuild) {
						itemstack.shrink(1);
					}

					playerIn.awardStat(Stats.ITEM_USED.get(this));
					worldIn.playSound(playerIn, blockpos, SoundEvents.WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
				}
			}

			return new ActionResult<>(ActionResultType.FAIL, itemstack);
		}
	}

	/**public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
		BlockRayTraceResult blockraytraceresult = getPlayerPOVHitResult(p_77659_1_, p_77659_2_, RayTraceContext.FluidMode.SOURCE_ONLY);
		BlockRayTraceResult blockraytraceresult1 = blockraytraceresult.withPosition(blockraytraceresult.getBlockPos().above());
		ActionResultType actionresulttype = super.useOn(new ItemUseContext(p_77659_2_, p_77659_3_, blockraytraceresult1));
		return new ActionResult<>(actionresulttype, p_77659_2_.getItemInHand(p_77659_3_));
	}**/
}