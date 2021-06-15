package net.coolsimulations.SurvivalPlus.core.blocks;

import java.util.Iterator;
import java.util.Random;

import javax.annotation.Nullable;

import com.blackgear.cavesandcliffs.common.blocks.AbstractCauldronBlock;
import com.blackgear.cavesandcliffs.core.registries.CCBBlocks;
import com.blackgear.cavesandcliffs.core.registries.CCBParticleTypes;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.HopperBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public class BlockCardboardLantern extends BlockCardboard implements IWaterLoggable {

	protected static final VoxelShape CARDBOARD_LANTERN_AABB = VoxelShapes.or(Block.box(6.0D, 1.0D, 6.D, 10.0D, 5D, 10.0D), Block.box(5.75D, 0.0D, 5.75D, 10.25D, 1.0D, 10.25D), Block.box(5.75D, 5.0D, 5.75D, 10.25D, 6.0D, 10.25D), Block.box(7.0, 6.0D, 7.0D, 9.0D, 7.0D, 9.0D), Block.box(6.75, 6.0D, 6.75D, 9.25D, 6.25D, 9.25D));
	protected static final VoxelShape CARDBOARD_LANTERN_HANGING_AABB = VoxelShapes.or(Block.box(6.0D, 2.0D, 6.D, 10.0D, 6D, 10.0D), Block.box(5.75D, 1.0D, 5.75D, 10.25D, 2.0D, 10.25D), Block.box(5.75D, 6.0D, 5.75D, 10.25D, 7.0D, 10.25D), Block.box(7.0, 7.0D, 7.0D, 9.0D, 8.0D, 9.0D), Block.box(6.75, 7.0D, 6.75D, 9.25D, 7.25D, 9.25D), Block.box(7.75, 8.0D, 7.75D, 8.25D, 16.0D, 8.25D));
	protected static final VoxelShape CARDBOARD_PAD_AABB = VoxelShapes.or(Block.box(6.0D, -1.5D, 6.D, 10.0D, 3.5D, 10.0D), Block.box(5.75D, -1.5D, 5.75D, 10.25D, -0.5D, 10.25D), Block.box(5.75D, 3.5D, 5.75D, 10.25D, 4.5D, 10.25D), Block.box(7.0, 4.5D, 7.0D, 9.0D, 5.5D, 9.0D), Block.box(6.75, 4.5D, 6.75D, 9.25D, 4.75D, 9.25D), Block.box(5.0D, -1.5D, 5.0D, 11.0D, -2.5D, 11.0D), Block.box(4.0D, -1.0D, 11.0D, 5.0D, -2.0D, 5.0D), Block.box(12.0D, -1.0D, 4.0D, 4.0D, -2.0D, 5.0D), Block.box(12.0D, -1.0D, 11.0D, 4.0D, -2.0D, 12.0D), Block.box(12.0D, -1.0D, 5.0D, 11.0D, -2.0D, 11.0D));
	protected static final VoxelShape CARDBOARD_LANTERN_NORTH_AABB = VoxelShapes.or(Block.box(6.0D, 2.0D, 8.D, 10.0D, 6D, 12.0D), Block.box(5.75D, 1.0D, 7.75D, 10.25D, 2.0D, 12.25D), Block.box(5.75D, 6.0D, 7.75D, 10.25D, 7.0D, 12.25D), Block.box(7.0, 7.0D, 9.0D, 9.0D, 8.0D, 11.0D), Block.box(6.75, 7.0D, 8.75D, 9.25D, 7.25D, 11.25D), Block.box(7.75, 6.25D, 7.75D, 8.25D, 6.75D, 15.75D), Block.box(7.5, 6.D, 15.75D, 8.5D, 7.0D, 16.0D), Block.box(7.75, 1.25D, 7.75D, 8.25D, 1.75D, 15.75D), Block.box(7.5, 1.D, 15.75D, 8.5D, 2.0D, 16.0D), Block.box(7.75, 1.75D, 14.25D, 8.25D, 6.25D, 14.75D));
	protected static final VoxelShape CARDBOARD_LANTERN_SOUTH_AABB = VoxelShapes.or(Block.box(6.0D, 2.0D, 4.D, 10.0D, 6D, 8.0D), Block.box(5.75D, 1.0D, 3.75D, 10.25D, 2.0D, 8.25D), Block.box(5.75D, 6.0D, 3.75D, 10.25D, 7.0D, 8.25D), Block.box(7.0, 7.0D, 5.0D, 9.0D, 8.0D, 7.0D), Block.box(6.75, 7.0D, 4.75D, 9.25D, 7.25D, 7.25D), Block.box(7.75, 6.25D, 0.25D, 8.25D, 6.75D, 3.75D), Block.box(7.5, 6.0D, 0.0D, 8.5D, 7.0D, 0.25D), Block.box(7.75, 1.25D, 0.25D, 8.25D, 1.75D, 3.75D), Block.box(7.5, 1.0D, 0.0D, 8.5D, 2.0D, 0.25D), Block.box(7.75, 1.75D, 1.25D, 8.25D, 6.25D, 1.75D));
	protected static final VoxelShape CARDBOARD_LANTERN_EAST_AABB = VoxelShapes.or(Block.box(4.0D, 2.0D, 6.D, 8.0D, 6D, 10.0D), Block.box(3.75D, 1.0D, 5.75D, 8.25D, 2.0D, 10.25D), Block.box(3.75D, 6.0D, 5.75D, 8.25D, 7.0D, 10.25D), Block.box(5.0, 7.0D, 7.0D, 7.0D, 8.0D, 9.0D), Block.box(4.75, 7.0D, 6.75D, 7.25D, 7.25D, 9.25D), Block.box(0.25, 6.25D, 7.75D, 3.75D, 6.75D, 8.25D), Block.box(0.0, 6.0D, 7.5D, 0.25D, 7.0D, 8.5D), Block.box(0.0, 1.25D, 7.75D, 0.25D, 1.75D, 8.25D), Block.box(0.0, 1.0D, 7.5D, 0.25D, 2.0D, 8.5D), Block.box(1.25, 1.75D, 7.75D, 1.75D, 6.25D, 8.25D));
	protected static final VoxelShape CARDBOARD_LANTERN_WEST_AABB = VoxelShapes.or(Block.box(8.0D, 2.0D, 6.D, 12.0D, 6D, 10.0D), Block.box(7.75D, 1.0D, 5.75D, 12.25D, 2.0D, 10.25D), Block.box(7.75D, 6.0D, 5.75D, 12.25D, 7.0D, 10.25D), Block.box(9.0, 7.0D, 7.0D, 11.0D, 8.0D, 9.0D), Block.box(8.75, 7.0D, 6.75D, 11.25D, 7.25D, 9.25D), Block.box(15.75, 6.25D, 7.75D, 9.25D, 6.75D, 8.25D), Block.box(16.0, 6.0D, 7.5D, 15.75D, 7.0D, 8.5D), Block.box(15.75, 1.25D, 7.75D, 9.25D, 1.75D, 8.25D), Block.box(16.0, 1.0D, 7.5D, 15.75D, 2.0D, 8.5D), Block.box(14.75, 1.75D, 7.75D, 14.25D, 6.25D, 8.25D));
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	public static final BooleanProperty FLOATING = BooleanProperty.create("floating");
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	protected boolean isDyed;

	public BlockCardboardLantern(MaterialColor colour, boolean isDyed) {
		super(colour);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP).setValue(FLOATING, Boolean.valueOf(false)).setValue(WATERLOGGED, false));
		this.isDyed = isDyed;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}

	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		if(!state.getValue(WATERLOGGED))
			return 14;
		else
			return state.getLightEmission();
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		Direction enumfacing = (Direction)state.getValue(FACING);
		boolean isFloating = state.getValue(FLOATING);

		if(isFloating) {
			if(enumfacing == Direction.DOWN) {
				return CARDBOARD_LANTERN_HANGING_AABB;
			} else {
				return CARDBOARD_PAD_AABB;
			}
		} else {
			switch (enumfacing) {
			case UP:
				return CARDBOARD_LANTERN_AABB;
			case EAST:
				return CARDBOARD_LANTERN_EAST_AABB;
			case SOUTH:
				return CARDBOARD_LANTERN_SOUTH_AABB;
			case WEST:
				return CARDBOARD_LANTERN_WEST_AABB;
			case NORTH:
				return CARDBOARD_LANTERN_NORTH_AABB;
			case DOWN:
				return CARDBOARD_LANTERN_HANGING_AABB;
			}
		}

		return CARDBOARD_PAD_AABB;
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		Direction enumfacing = (Direction)stateIn.getValue(FACING);
		boolean isFloating = stateIn.getValue(FLOATING);
		boolean isWaterLogged = stateIn.getValue(WATERLOGGED);
		double d0 = (double)pos.getX() + 0.5D;
		double d1;
		double d2 = (double)pos.getZ() + 0.5D;
		
		BasicParticleType flame;
		
		if(SPCompatibilityManager.isCavesAndCliffsBackportLoaded()) {
			d1 = (double)pos.getY() + 0.25;
			flame = CCBParticleTypes.SMALL_FLAME.get();
		} else {
			d1 = (double)pos.getY() + 0.21875D;
			flame = ParticleTypes.FLAME;
		}

		if(!isWaterLogged) {
			if(isFloating) {
				if(enumfacing == Direction.DOWN) {
					worldIn.addParticle(flame, d0, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
				} else {
					worldIn.addParticle(flame, d0, d1 - 0.03125D, d2, 0.0D, 0.0D, 0.0D);
				}
			} else {
				switch (enumfacing) {
				case UP:
					worldIn.addParticle(flame, d0, d1, d2, 0.0D, 0.0D, 0.0D);
					break;
				case EAST:
					worldIn.addParticle(flame, d0 - 0.125, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
					break;
				case SOUTH:
					worldIn.addParticle(flame, d0, d1 + 0.0625D, d2 - 0.125, 0.0D, 0.0D, 0.0D);
					break;
				case WEST:
					worldIn.addParticle(flame, d0 + 0.125, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
					break;
				case NORTH:
					worldIn.addParticle(flame, d0, d1 + 0.0625D, d2 + 0.125, 0.0D, 0.0D, 0.0D);
					break;
				case DOWN:
					worldIn.addParticle(flame, d0, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
					break;
				}
			}
		}
	}

	/**
	 * Called when the block is right clicked by a player.
	 */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit)
	{
		ItemStack itemStackIn = playerIn.getItemInHand(hand);

		if(!isDyed) {

			ActionResultType success = ActionResultType.FAIL;

			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_WHITE, SPBlocks.cardboard_lantern_white);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_LIGHT_GRAY, SPBlocks.cardboard_lantern_light_grey);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_GRAY, SPBlocks.cardboard_lantern_grey);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_BLACK, SPBlocks.cardboard_lantern_black);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_RED, SPBlocks.cardboard_lantern_red);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_ORANGE, SPBlocks.cardboard_lantern_orange);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_YELLOW, SPBlocks.cardboard_lantern_yellow);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_LIME, SPBlocks.cardboard_lantern_lime);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_GREEN, SPBlocks.cardboard_lantern_green);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_LIGHT_BLUE, SPBlocks.cardboard_lantern_light_blue);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_CYAN, SPBlocks.cardboard_lantern_cyan);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_BLUE, SPBlocks.cardboard_lantern_blue);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_PURPLE, SPBlocks.cardboard_lantern_purple);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_MAGENTA, SPBlocks.cardboard_lantern_magenta);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_PINK, SPBlocks.cardboard_lantern_pink);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.DYES_BROWN, SPBlocks.cardboard_lantern_brown);

			state.updateShape(hit.getDirection(), state, worldIn, pos, pos);
			return success;
		} else {
			state.updateShape(hit.getDirection(), state, worldIn, pos, pos);
		}

		return ActionResultType.FAIL;
	}

	protected ActionResultType checkDye(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn, ItemStack stack, IOptionalNamedTag<Item> tag, Block dyeBlock) {

		for(Iterator<Item> acceptableItems = tag.getValues().iterator(); acceptableItems.hasNext(); ){
			Item dye = acceptableItems.next();
			if(dye == stack.getItem() && tag != null) {
				if(!playerIn.isCreative())
					stack.shrink(1);
				worldIn.setBlock(pos, dyeBlock.defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(FLOATING, state.getValue(FLOATING)).setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
				return ActionResultType.SUCCESS;
			}

		}

		return ActionResultType.FAIL;
	}

	/**
	 * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
	 * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
	 * returns its solidified counterpart.
	 * Note that this method should ideally consider only the specific face passed in.
	 */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos fromPos)
	{
		if (state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		if (!canPlaceBlock((World)worldIn, pos, (Direction)state.getValue(FACING)) && !state.getValue(FLOATING))
		{
			return Blocks.AIR.defaultBlockState();
		} else {
			if(state.getValue(FACING) == Direction.DOWN && !isValidPos((World)worldIn, fromPos, Direction.DOWN)) {
				return Blocks.AIR.defaultBlockState();
			}
		}

		if(state.getValue(FLOATING) && !canBlockStay((World)worldIn, pos, state)) {
			return Blocks.AIR.defaultBlockState();
		}
		return state;
	}

	public boolean canBlockStay(World worldIn, BlockPos pos, BlockState state)
	{
		BlockState iblockstate = worldIn.getBlockState(pos.below());
		FluidState ifluidstate = worldIn.getFluidState(pos.below());
		Material material = iblockstate.getMaterial();
		return ifluidstate.getType() == Fluids.WATER || (material == Material.ICE || material == Material.ICE_SOLID) || (iblockstate.getBlock() instanceof CauldronBlock && iblockstate.getValue(CauldronBlock.LEVEL) == 3) || (SPCompatibilityManager.isCavesAndCliffsBackportLoaded() && iblockstate.getBlock() instanceof AbstractCauldronBlock && iblockstate.getBlock() != CCBBlocks.LAVA_CAULDRON.get() && ((AbstractCauldronBlock) iblockstate.getBlock()).isFull(iblockstate));
	}

	/**
	 * Check whether this block can be placed on the block in the given direction.
	 */
	protected static boolean canPlaceBlock(World worldIn, BlockPos pos, Direction direction)
	{
		BlockPos blockpos = pos.relative(direction.getOpposite());
		BlockState iblockstate = worldIn.getBlockState(blockpos);
		Block block = iblockstate.getBlock();

		if (direction == Direction.UP)
		{
			if(block instanceof TrapDoorBlock && !isTrapdoorValid(iblockstate, direction)) {
				return false;
			} else if(block instanceof BlockCardboardLantern) {
				return false;
			} else {
				return true;
			}
		} else if (direction != Direction.DOWN) {
			return iblockstate.isFaceSturdy(worldIn, blockpos, direction.getOpposite());// && !blockstate.is(BlockTags.LEAVES);
		} else {
			return isValidPos(worldIn, pos, Direction.DOWN);
		}
	}

	protected boolean canFloat(World worldIn, BlockPos pos, Direction direction)
	{
		BlockPos blockpos = pos.relative(direction.getOpposite());
		BlockState iblockstate = worldIn.getBlockState(blockpos);

		return direction == Direction.UP && (iblockstate.getBlock() == Blocks.WATER || ((iblockstate.getMaterial() == Material.ICE || iblockstate.getMaterial() == Material.ICE_SOLID) && direction != Direction.DOWN) || (iblockstate.getBlock() instanceof CauldronBlock && iblockstate.getValue(CauldronBlock.LEVEL) == 3)  || (SPCompatibilityManager.isCavesAndCliffsBackportLoaded() && iblockstate.getBlock() instanceof AbstractCauldronBlock && iblockstate.getBlock() != CCBBlocks.LAVA_CAULDRON.get() && ((AbstractCauldronBlock) iblockstate.getBlock()).isFull(iblockstate)));
	}

	protected boolean isWaterLogged(IWorld worldIn, BlockPos pos) {
		FluidState ifluidstate = worldIn.getFluidState(pos);
		return Boolean.valueOf(ifluidstate.getType() == Fluids.WATER);

	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {

		if(canPlaceBlock(context.getLevel(), context.getClickedPos(), context.getClickedFace()))
			return this.defaultBlockState().setValue(FACING, context.getClickedFace()).setValue(FLOATING, Boolean.valueOf(canFloat(context.getLevel(), context.getClickedPos(), context.getClickedFace()))).setValue(WATERLOGGED, isWaterLogged(context.getLevel(), context.getClickedPos()));
		else
			return null;
	}

	protected static boolean isValidPos(World worldIn, BlockPos pos, Direction direction)
	{
		BlockPos blockpos = pos.relative(direction.getOpposite());
		BlockState state = worldIn.getBlockState(blockpos);
		Block block = state.getBlock();

		if(block instanceof TrapDoorBlock) {
			return isTrapdoorValid(state, direction);
		}

		if(block instanceof HopperBlock) {
			return false;
		}

		if(block.isAir(state, worldIn, blockpos)) {
			return false;
		} else {
			return true;
		}
	}

	protected static boolean isTrapdoorValid(BlockState state, Direction facing) {
		return state.getProperties().contains(TrapDoorBlock.HALF) && (facing == Direction.UP && state.getValue(TrapDoorBlock.HALF) == Half.TOP || facing == Direction.DOWN && state.getValue(TrapDoorBlock.HALF) == Half.BOTTOM) && !state.getValue(TrapDoorBlock.OPEN);
	}

	/**
	 * Called after the block is set in the Chunk data, but before the Tile Entity is set
	 */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving)
	{
		Random rand = new Random();
		worldIn.getBlockTicks().scheduleTick(pos, this, 20 + rand.nextInt(10));
	}

	/**
	 * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
	 * blockstate.
	 */
	@Override
	public BlockState rotate(BlockState state, Rotation rot)
	{
		return state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
	}

	/**
	 * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
	 * blockstate.
	 */
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn)
	{
		return state.rotate(mirrorIn.getRotation((Direction)state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, FLOATING, WATERLOGGED);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return (Boolean) state.getValue(WATERLOGGED)
				? Fluids.WATER.getSource(false)
						: super.getFluidState(state);
	}
}