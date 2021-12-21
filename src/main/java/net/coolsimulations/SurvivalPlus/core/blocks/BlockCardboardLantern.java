package net.coolsimulations.SurvivalPlus.core.blocks;

import java.util.Iterator;
import java.util.Random;

import org.jetbrains.annotations.Nullable;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.HopperBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.SlabType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class BlockCardboardLantern extends BlockCardboard implements Waterloggable {

	protected static final VoxelShape CARDBOARD_LANTERN_AABB = VoxelShapes.union(Block.createCuboidShape(6.0D, 1.0D, 6.D, 10.0D, 5D, 10.0D), Block.createCuboidShape(5.75D, 0.0D, 5.75D, 10.25D, 1.0D, 10.25D), Block.createCuboidShape(5.75D, 5.0D, 5.75D, 10.25D, 6.0D, 10.25D), Block.createCuboidShape(7.0, 6.0D, 7.0D, 9.0D, 7.0D, 9.0D), Block.createCuboidShape(6.75, 6.0D, 6.75D, 9.25D, 6.25D, 9.25D));
	protected static final VoxelShape CARDBOARD_LANTERN_HANGING_AABB = VoxelShapes.union(Block.createCuboidShape(6.0D, 2.0D, 6.D, 10.0D, 6D, 10.0D), Block.createCuboidShape(5.75D, 1.0D, 5.75D, 10.25D, 2.0D, 10.25D), Block.createCuboidShape(5.75D, 6.0D, 5.75D, 10.25D, 7.0D, 10.25D), Block.createCuboidShape(7.0, 7.0D, 7.0D, 9.0D, 8.0D, 9.0D), Block.createCuboidShape(6.75, 7.0D, 6.75D, 9.25D, 7.25D, 9.25D), Block.createCuboidShape(7.75, 8.0D, 7.75D, 8.25D, 16.0D, 8.25D));
	protected static final VoxelShape CARDBOARD_PAD_AABB = VoxelShapes.union(Block.createCuboidShape(6.0D, -1.5D, 6.D, 10.0D, 3.5D, 10.0D), Block.createCuboidShape(5.75D, -1.5D, 5.75D, 10.25D, -0.5D, 10.25D), Block.createCuboidShape(5.75D, 3.5D, 5.75D, 10.25D, 4.5D, 10.25D), Block.createCuboidShape(7.0, 4.5D, 7.0D, 9.0D, 5.5D, 9.0D), Block.createCuboidShape(6.75, 4.5D, 6.75D, 9.25D, 4.75D, 9.25D), Block.createCuboidShape(5.0D, -1.5D, 5.0D, 11.0D, -2.5D, 11.0D), Block.createCuboidShape(4.0D, -1.0D, 11.0D, 5.0D, -2.0D, 5.0D), Block.createCuboidShape(12.0D, -1.0D, 4.0D, 4.0D, -2.0D, 5.0D), Block.createCuboidShape(12.0D, -1.0D, 11.0D, 4.0D, -2.0D, 12.0D), Block.createCuboidShape(12.0D, -1.0D, 5.0D, 11.0D, -2.0D, 11.0D));
	protected static final VoxelShape CARDBOARD_LANTERN_NORTH_AABB = VoxelShapes.union(Block.createCuboidShape(6.0D, 2.0D, 8.D, 10.0D, 6D, 12.0D), Block.createCuboidShape(5.75D, 1.0D, 7.75D, 10.25D, 2.0D, 12.25D), Block.createCuboidShape(5.75D, 6.0D, 7.75D, 10.25D, 7.0D, 12.25D), Block.createCuboidShape(7.0, 7.0D, 9.0D, 9.0D, 8.0D, 11.0D), Block.createCuboidShape(6.75, 7.0D, 8.75D, 9.25D, 7.25D, 11.25D), Block.createCuboidShape(7.75, 6.25D, 7.75D, 8.25D, 6.75D, 15.75D), Block.createCuboidShape(7.5, 6.D, 15.75D, 8.5D, 7.0D, 16.0D), Block.createCuboidShape(7.75, 1.25D, 7.75D, 8.25D, 1.75D, 15.75D), Block.createCuboidShape(7.5, 1.D, 15.75D, 8.5D, 2.0D, 16.0D), Block.createCuboidShape(7.75, 1.75D, 14.25D, 8.25D, 6.25D, 14.75D));
	protected static final VoxelShape CARDBOARD_LANTERN_SOUTH_AABB = VoxelShapes.union(Block.createCuboidShape(6.0D, 2.0D, 4.D, 10.0D, 6D, 8.0D), Block.createCuboidShape(5.75D, 1.0D, 3.75D, 10.25D, 2.0D, 8.25D), Block.createCuboidShape(5.75D, 6.0D, 3.75D, 10.25D, 7.0D, 8.25D), Block.createCuboidShape(7.0, 7.0D, 5.0D, 9.0D, 8.0D, 7.0D), Block.createCuboidShape(6.75, 7.0D, 4.75D, 9.25D, 7.25D, 7.25D), Block.createCuboidShape(7.75, 6.25D, 0.25D, 8.25D, 6.75D, 3.75D), Block.createCuboidShape(7.5, 6.0D, 0.0D, 8.5D, 7.0D, 0.25D), Block.createCuboidShape(7.75, 1.25D, 0.25D, 8.25D, 1.75D, 3.75D), Block.createCuboidShape(7.5, 1.0D, 0.0D, 8.5D, 2.0D, 0.25D), Block.createCuboidShape(7.75, 1.75D, 1.25D, 8.25D, 6.25D, 1.75D));
	protected static final VoxelShape CARDBOARD_LANTERN_EAST_AABB = VoxelShapes.union(Block.createCuboidShape(4.0D, 2.0D, 6.D, 8.0D, 6D, 10.0D), Block.createCuboidShape(3.75D, 1.0D, 5.75D, 8.25D, 2.0D, 10.25D), Block.createCuboidShape(3.75D, 6.0D, 5.75D, 8.25D, 7.0D, 10.25D), Block.createCuboidShape(5.0, 7.0D, 7.0D, 7.0D, 8.0D, 9.0D), Block.createCuboidShape(4.75, 7.0D, 6.75D, 7.25D, 7.25D, 9.25D), Block.createCuboidShape(0.25, 6.25D, 7.75D, 3.75D, 6.75D, 8.25D), Block.createCuboidShape(0.0, 6.0D, 7.5D, 0.25D, 7.0D, 8.5D), Block.createCuboidShape(0.0, 1.25D, 7.75D, 0.25D, 1.75D, 8.25D), Block.createCuboidShape(0.0, 1.0D, 7.5D, 0.25D, 2.0D, 8.5D), Block.createCuboidShape(1.25, 1.75D, 7.75D, 1.75D, 6.25D, 8.25D));
	protected static final VoxelShape CARDBOARD_LANTERN_WEST_AABB = VoxelShapes.union(Block.createCuboidShape(8.0D, 2.0D, 6.D, 12.0D, 6D, 10.0D), Block.createCuboidShape(7.75D, 1.0D, 5.75D, 12.25D, 2.0D, 10.25D), Block.createCuboidShape(7.75D, 6.0D, 5.75D, 12.25D, 7.0D, 10.25D), Block.createCuboidShape(9.0, 7.0D, 7.0D, 11.0D, 8.0D, 9.0D), Block.createCuboidShape(8.75, 7.0D, 6.75D, 11.25D, 7.25D, 9.25D), Block.createCuboidShape(15.75, 6.25D, 7.75D, 9.25D, 6.75D, 8.25D), Block.createCuboidShape(16.0, 6.0D, 7.5D, 15.75D, 7.0D, 8.5D), Block.createCuboidShape(15.75, 1.25D, 7.75D, 9.25D, 1.75D, 8.25D), Block.createCuboidShape(16.0, 1.0D, 7.5D, 15.75D, 2.0D, 8.5D), Block.createCuboidShape(14.75, 1.75D, 7.75D, 14.25D, 6.25D, 8.25D));
	public static final DirectionProperty FACING = Properties.FACING;
	public static final BooleanProperty FLOATING = BooleanProperty.of("floating");
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

	protected boolean isDyed;

	public BlockCardboardLantern(MaterialColor colour, boolean isDyed) {
		super(colour);
		this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.UP).with(FLOATING, Boolean.valueOf(false)).with(WATERLOGGED, false));
		this.isDyed = isDyed;
	}

	@Override
	public boolean hasRandomTicks(BlockState state) {
		return true;
	}

	@Override
	public int getLuminance(BlockState state) {
		if(!state.get(WATERLOGGED))
			return 14;
		else
			return super.lightLevel;
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, EntityContext context)
	{
		Direction enumfacing = (Direction)state.get(FACING);
		boolean isFloating = state.get(FLOATING);

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

	@Environment(EnvType.CLIENT)
	public void randomDisplayTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		Direction enumfacing = (Direction)stateIn.get(FACING);
		boolean isFloating = stateIn.get(FLOATING);
		boolean isWaterLogged = stateIn.get(WATERLOGGED);
		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.21875D;
		double d2 = (double)pos.getZ() + 0.5D;

		if(!isWaterLogged) {
			if(isFloating) {
				if(enumfacing == Direction.DOWN) {
					worldIn.addParticle(ParticleTypes.FLAME, d0, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
				} else {
					worldIn.addParticle(ParticleTypes.FLAME, d0, d1 - 0.03125D, d2, 0.0D, 0.0D, 0.0D);
				}
			} else {
				switch (enumfacing) {
				case UP:
					worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
					break;
				case EAST:
					worldIn.addParticle(ParticleTypes.FLAME, d0 - 0.125, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
					break;
				case SOUTH:
					worldIn.addParticle(ParticleTypes.FLAME, d0, d1 + 0.0625D, d2 - 0.125, 0.0D, 0.0D, 0.0D);
					break;
				case WEST:
					worldIn.addParticle(ParticleTypes.FLAME, d0 + 0.125, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
					break;
				case NORTH:
					worldIn.addParticle(ParticleTypes.FLAME, d0, d1 + 0.0625D, d2 + 0.125, 0.0D, 0.0D, 0.0D);
					break;
				case DOWN:
					worldIn.addParticle(ParticleTypes.FLAME, d0, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
					break;
				}
			}
		}
	}

	/**
	 * Called when the block is right clicked by a player.
	 */
	@Override
	public boolean activate(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockHitResult hit)
	{
		ItemStack itemStackIn = playerIn.getStackInHand(hand);

		if(!isDyed) {

			boolean success = false;

			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "white_dyes", SPBlocks.cardboard_lantern_white);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "light_gray_dyes", SPBlocks.cardboard_lantern_light_grey);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "gray_dyes", SPBlocks.cardboard_lantern_grey);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "black_dyes", SPBlocks.cardboard_lantern_black);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "red_dyes", SPBlocks.cardboard_lantern_red);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "orange_dyes", SPBlocks.cardboard_lantern_orange);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "yellow_dyes", SPBlocks.cardboard_lantern_yellow);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "lime_dyes", SPBlocks.cardboard_lantern_lime);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "green_dyes", SPBlocks.cardboard_lantern_green);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "light_blue_dyes", SPBlocks.cardboard_lantern_light_blue);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "cyan_dyes", SPBlocks.cardboard_lantern_cyan);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "blue_dyes", SPBlocks.cardboard_lantern_blue);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "purple_dyes", SPBlocks.cardboard_lantern_purple);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "magenta_dyes", SPBlocks.cardboard_lantern_magenta);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "pink_dyes", SPBlocks.cardboard_lantern_pink);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "brown_dyes", SPBlocks.cardboard_lantern_brown);

			state.getStateForNeighborUpdate(hit.getSide(), state, worldIn, pos, pos);
			return success;
		} else {
			state.getStateForNeighborUpdate(hit.getSide(), state, worldIn, pos, pos);
		}

		return false;
	}

	protected boolean checkDye(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn, ItemStack stack, String dye_tag, Block dyeBlock) {

		Tag<Item> tag = new ItemTags.CachingTag(new Identifier("c", dye_tag));
		
		for(Iterator<Item> acceptableItems = tag.values().iterator(); acceptableItems.hasNext(); ){
			Item dye = acceptableItems.next();
			if(dye == stack.getItem() && tag != null) {
				if(!playerIn.isCreative())
					stack.decrement(1);
				worldIn.setBlockState(pos, dyeBlock.getDefaultState().with(FACING, state.get(FACING)).with(FLOATING, state.get(FLOATING)).with(WATERLOGGED, state.get(WATERLOGGED)), 3);
				return true;
			}

		}

		return false;
	}

	/**
	 * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
	 * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
	 * returns its solidified counterpart.
	 * Note that this method should ideally consider only the specific face passed in.
	 */
	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos fromPos)
	{
		if (state.get(WATERLOGGED)) {
			worldIn.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}

		if (!canPlaceBlock(worldIn.getWorld(), pos, (Direction)state.get(FACING)) && !state.get(FLOATING))
		{
			return Blocks.AIR.getDefaultState();
		} else {
			if(state.get(FACING) == Direction.DOWN && !isValidPos(worldIn.getWorld(), fromPos, Direction.DOWN)) {
				return Blocks.AIR.getDefaultState();
			}
		}

		if(state.get(FLOATING) && !canBlockStay(worldIn.getWorld(), pos, state)) {
			return Blocks.AIR.getDefaultState();
		}
		return state;
	}

	public boolean canBlockStay(World worldIn, BlockPos pos, BlockState state)
	{
		BlockState iblockstate = worldIn.getBlockState(pos.down());
		FluidState ifluidstate = worldIn.getFluidState(pos.down());
		Material material = iblockstate.getMaterial();
		return ifluidstate.getFluid() == Fluids.WATER || (material == Material.ICE || material == Material.PACKED_ICE) || (iblockstate.getBlock() instanceof CauldronBlock && iblockstate.get(CauldronBlock.LEVEL) == 3);
	}

	/**
	 * Check whether this block can be placed on the block in the given direction.
	 */
	protected static boolean canPlaceBlock(World worldIn, BlockPos pos, Direction direction)
	{
		BlockPos blockpos = pos.offset(direction.getOpposite());
		BlockState iblockstate = worldIn.getBlockState(blockpos);
		Block block = iblockstate.getBlock();

		if (direction == Direction.UP)
		{
			if(block instanceof TrapdoorBlock && !isTrapdoorValid(iblockstate, direction)) {
				return false;
			} else if(block instanceof SlabBlock && !isSlabValid(iblockstate, direction)) {
				return false;
			} else if(block instanceof BlockCardboardLantern && iblockstate.get(FACING).getAxis() == Direction.Axis.Y) {
				return false;
			} else {
				return true;
			}
		} else if (direction != Direction.DOWN) {
			return iblockstate.isSideSolidFullSquare(worldIn, blockpos, direction.getOpposite()) && isSideSolidFullSquare(iblockstate, worldIn, blockpos, direction);
		} else {
			return isValidPos(worldIn, pos, Direction.DOWN);
		}
	}

	protected boolean canFloat(World worldIn, BlockPos pos, Direction direction)
	{
		BlockPos blockpos = pos.offset(direction.getOpposite());
		BlockState iblockstate = worldIn.getBlockState(blockpos);

		return direction == Direction.UP && (iblockstate.getBlock() == Blocks.WATER || ((iblockstate.getMaterial() == Material.ICE || iblockstate.getMaterial() == Material.PACKED_ICE) && direction != Direction.DOWN) || (iblockstate.getBlock() instanceof CauldronBlock && iblockstate.get(CauldronBlock.LEVEL) == 3));
	}

	protected boolean isWaterLogged(IWorld worldIn, BlockPos pos) {
		FluidState ifluidstate = worldIn.getFluidState(pos);
		return Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER);

	}

	@Override
	@Nullable
	public BlockState getPlacementState(ItemPlacementContext context) {

		if(canPlaceBlock(context.getWorld(), context.getBlockPos(), context.getSide()))
			return this.getDefaultState().with(FACING, context.getSide()).with(FLOATING, Boolean.valueOf(canFloat(context.getWorld(), context.getBlockPos(), context.getSide()))).with(WATERLOGGED, isWaterLogged(context.getWorld(), context.getBlockPos()));
		else
			return null;
	}

	protected static boolean isValidPos(World worldIn, BlockPos pos, Direction direction)
	{
		BlockPos blockpos = pos.offset(direction.getOpposite());
		BlockState state = worldIn.getBlockState(blockpos);
		Block block = state.getBlock();

		if(block instanceof TrapdoorBlock) {
			return isTrapdoorValid(state, direction);
		}

		if(block instanceof HopperBlock) {
			return false;
		}
		
		if(block instanceof SlabBlock) {
			return isSlabValid(state, direction);
		}

		if(block.isAir(state)) {
			return false;
		} else {
			return true;
		}
	}

	protected static boolean isTrapdoorValid(BlockState state, Direction facing) {
		return state.getProperties().contains(TrapdoorBlock.HALF) && (facing == Direction.UP && state.get(TrapdoorBlock.HALF) == BlockHalf.TOP || facing == Direction.DOWN && state.get(TrapdoorBlock.HALF) == BlockHalf.BOTTOM) && !state.get(TrapdoorBlock.OPEN);
	}
	
	protected static boolean isSlabValid(BlockState state, Direction facing) {
		return (state.getProperties().contains(SlabBlock.TYPE) && (facing == Direction.UP && state.get(SlabBlock.TYPE) == SlabType.TOP || facing == Direction.DOWN && state.get(SlabBlock.TYPE) == SlabType.BOTTOM)) || state.get(SlabBlock.TYPE) == SlabType.DOUBLE;
	}

	/**
	 * Called after the block is set in the Chunk data, but before the Tile Entity is set
	 */
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving)
	{
		Random rand = new Random();
		worldIn.getBlockTickScheduler().schedule(pos, this, this.getTickRate(worldIn) + rand.nextInt(10));
	}

	/**
	 * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
	 * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
	 */
	@Override
	public BlockRenderType getRenderType(BlockState state)
	{
		return BlockRenderType.MODEL;
	}

	@Environment(EnvType.CLIENT)
	public RenderLayer getRenderLayer()
	{
		return RenderLayer.CUTOUT;
	}

	/**
	 * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
	 * blockstate.
	 */
	@Override
	public BlockState rotate(BlockState state, BlockRotation rot)
	{
		return state.with(FACING, rot.rotate((Direction)state.get(FACING)));
	}

	/**
	 * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
	 * blockstate.
	 */
	@Override
	public BlockState mirror(BlockState state, BlockMirror mirrorIn)
	{
		return state.rotate(mirrorIn.getRotation((Direction)state.get(FACING)));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING, FLOATING, WATERLOGGED);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return (Boolean) state.get(WATERLOGGED)
				? Fluids.WATER.getStill(false)
						: super.getFluidState(state);
	}
}