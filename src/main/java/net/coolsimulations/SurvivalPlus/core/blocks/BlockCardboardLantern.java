package net.coolsimulations.SurvivalPlus.core.blocks;

import java.util.Iterator;
import java.util.Random;

import org.jetbrains.annotations.Nullable;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockCardboardLantern extends BlockCardboard implements SimpleWaterloggedBlock {

	protected static final VoxelShape CARDBOARD_LANTERN_AABB = Shapes.or(Block.box(6.0D, 1.0D, 6.D, 10.0D, 5D, 10.0D), Block.box(5.75D, 0.0D, 5.75D, 10.25D, 1.0D, 10.25D), Block.box(5.75D, 5.0D, 5.75D, 10.25D, 6.0D, 10.25D), Block.box(7.0, 6.0D, 7.0D, 9.0D, 7.0D, 9.0D), Block.box(6.75, 6.0D, 6.75D, 9.25D, 6.25D, 9.25D));
	protected static final VoxelShape CARDBOARD_LANTERN_HANGING_AABB = Shapes.or(Block.box(6.0D, 2.0D, 6.D, 10.0D, 6D, 10.0D), Block.box(5.75D, 1.0D, 5.75D, 10.25D, 2.0D, 10.25D), Block.box(5.75D, 6.0D, 5.75D, 10.25D, 7.0D, 10.25D), Block.box(7.0, 7.0D, 7.0D, 9.0D, 8.0D, 9.0D), Block.box(6.75, 7.0D, 6.75D, 9.25D, 7.25D, 9.25D), Block.box(7.75, 8.0D, 7.75D, 8.25D, 16.0D, 8.25D));
	protected static final VoxelShape CARDBOARD_PAD_AABB = Shapes.or(Block.box(6.0D, -1.5D, 6.D, 10.0D, 3.5D, 10.0D), Block.box(5.75D, -1.5D, 5.75D, 10.25D, -0.5D, 10.25D), Block.box(5.75D, 3.5D, 5.75D, 10.25D, 4.5D, 10.25D), Block.box(7.0, 4.5D, 7.0D, 9.0D, 5.5D, 9.0D), Block.box(6.75, 4.5D, 6.75D, 9.25D, 4.75D, 9.25D), Block.box(5.0D, -2.5D, 5.0D, 11.0D, -1.5D, 11.0D), Block.box(4.0D, -2.0D, 5.0D, 5.0D, -1.0D, 11.0D), Block.box(4.0D, -2.0D, 4.0D, 12.0D, -1.0D, 5.0D), Block.box(4.0D, -2.0D, 11.0D, 12.0D, -1.0D, 12.0D), Block.box(11.0D, -2.0D, 5.0D, 12.0D, -1.0D, 11.0D));
	protected static final VoxelShape CARDBOARD_LANTERN_NORTH_AABB = Shapes.or(Block.box(6.0D, 2.0D, 8.D, 10.0D, 6D, 12.0D), Block.box(5.75D, 1.0D, 7.75D, 10.25D, 2.0D, 12.25D), Block.box(5.75D, 6.0D, 7.75D, 10.25D, 7.0D, 12.25D), Block.box(7.0, 7.0D, 9.0D, 9.0D, 8.0D, 11.0D), Block.box(6.75, 7.0D, 8.75D, 9.25D, 7.25D, 11.25D), Block.box(7.75, 6.25D, 7.75D, 8.25D, 6.75D, 15.75D), Block.box(7.5, 6.D, 15.75D, 8.5D, 7.0D, 16.0D), Block.box(7.75, 1.25D, 7.75D, 8.25D, 1.75D, 15.75D), Block.box(7.5, 1.D, 15.75D, 8.5D, 2.0D, 16.0D), Block.box(7.75, 1.75D, 14.25D, 8.25D, 6.25D, 14.75D));
	protected static final VoxelShape CARDBOARD_LANTERN_SOUTH_AABB = Shapes.or(Block.box(6.0D, 2.0D, 4.D, 10.0D, 6D, 8.0D), Block.box(5.75D, 1.0D, 3.75D, 10.25D, 2.0D, 8.25D), Block.box(5.75D, 6.0D, 3.75D, 10.25D, 7.0D, 8.25D), Block.box(7.0, 7.0D, 5.0D, 9.0D, 8.0D, 7.0D), Block.box(6.75, 7.0D, 4.75D, 9.25D, 7.25D, 7.25D), Block.box(7.75, 6.25D, 0.25D, 8.25D, 6.75D, 3.75D), Block.box(7.5, 6.0D, 0.0D, 8.5D, 7.0D, 0.25D), Block.box(7.75, 1.25D, 0.25D, 8.25D, 1.75D, 3.75D), Block.box(7.5, 1.0D, 0.0D, 8.5D, 2.0D, 0.25D), Block.box(7.75, 1.75D, 1.25D, 8.25D, 6.25D, 1.75D));
	protected static final VoxelShape CARDBOARD_LANTERN_EAST_AABB = Shapes.or(Block.box(4.0D, 2.0D, 6.D, 8.0D, 6D, 10.0D), Block.box(3.75D, 1.0D, 5.75D, 8.25D, 2.0D, 10.25D), Block.box(3.75D, 6.0D, 5.75D, 8.25D, 7.0D, 10.25D), Block.box(5.0, 7.0D, 7.0D, 7.0D, 8.0D, 9.0D), Block.box(4.75, 7.0D, 6.75D, 7.25D, 7.25D, 9.25D), Block.box(0.25, 6.25D, 7.75D, 3.75D, 6.75D, 8.25D), Block.box(0.0, 6.0D, 7.5D, 0.25D, 7.0D, 8.5D), Block.box(0.0, 1.25D, 7.75D, 0.25D, 1.75D, 8.25D), Block.box(0.0, 1.0D, 7.5D, 0.25D, 2.0D, 8.5D), Block.box(1.25, 1.75D, 7.75D, 1.75D, 6.25D, 8.25D));
	protected static final VoxelShape CARDBOARD_LANTERN_WEST_AABB = Shapes.or(Block.box(8.0D, 2.0D, 6.D, 12.0D, 6D, 10.0D), Block.box(7.75D, 1.0D, 5.75D, 12.25D, 2.0D, 10.25D), Block.box(7.75D, 6.0D, 5.75D, 12.25D, 7.0D, 10.25D), Block.box(9.0, 7.0D, 7.0D, 11.0D, 8.0D, 9.0D), Block.box(8.75, 7.0D, 6.75D, 11.25D, 7.25D, 9.25D), Block.box(9.25D, 6.25D, 7.75D, 15.75D, 6.75D, 8.25D), Block.box(15.75D, 6.0D, 7.5D, 16.0D, 7.0D, 8.5D), Block.box(9.25D, 1.25D, 7.75D, 15.75D, 1.75D, 8.25D), Block.box(15.75D, 1.0D, 7.5D, 16.0D, 2.0D, 8.5D), Block.box(14.25, 1.75D, 7.75D, 14.75D, 6.25D, 8.25D));
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	public static final BooleanProperty FLOATING = BooleanProperty.create("floating");
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	protected boolean isDyed;

	public BlockCardboardLantern(MaterialColor colour, boolean isDyed) {
		super(FabricBlockSettings.of(Material.WOOD, colour).hardness(0.5F).resistance(2.5F).sounds(SoundType.WOOD).luminance((blockStatex) -> {
			if(!blockStatex.getValue(WATERLOGGED))
				return 14;
			else
				return 0;
		}));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP).setValue(FLOATING, Boolean.valueOf(false)).setValue(WATERLOGGED, false));
		this.isDyed = isDyed;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
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

	@Environment(EnvType.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand)
	{
		Direction enumfacing = (Direction)stateIn.getValue(FACING);
		boolean isFloating = stateIn.getValue(FLOATING);
		boolean isWaterLogged = stateIn.getValue(WATERLOGGED);
		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.25D;
		double d2 = (double)pos.getZ() + 0.5D;

		if(!isWaterLogged) {
			if(isFloating) {
				if(enumfacing == Direction.DOWN) {
					worldIn.addParticle(ParticleTypes.SMALL_FLAME, d0, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
				} else {
					worldIn.addParticle(ParticleTypes.SMALL_FLAME, d0, d1 - 0.03125D, d2, 0.0D, 0.0D, 0.0D);
				}
			} else {
				switch (enumfacing) {
				case UP:
					worldIn.addParticle(ParticleTypes.SMALL_FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
					break;
				case EAST:
					worldIn.addParticle(ParticleTypes.SMALL_FLAME, d0 - 0.125, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
					break;
				case SOUTH:
					worldIn.addParticle(ParticleTypes.SMALL_FLAME, d0, d1 + 0.0625D, d2 - 0.125, 0.0D, 0.0D, 0.0D);
					break;
				case WEST:
					worldIn.addParticle(ParticleTypes.SMALL_FLAME, d0 + 0.125, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
					break;
				case NORTH:
					worldIn.addParticle(ParticleTypes.SMALL_FLAME, d0, d1 + 0.0625D, d2 + 0.125, 0.0D, 0.0D, 0.0D);
					break;
				case DOWN:
					worldIn.addParticle(ParticleTypes.SMALL_FLAME, d0, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
					break;
				}
			}
		}
	}

	/**
	 * Called when the block is right clicked by a player.
	 */
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit)
	{
		ItemStack itemStackIn = playerIn.getItemInHand(hand);

		if(!isDyed) {

			InteractionResult success = InteractionResult.FAIL;

			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "white_dyes", SPBlocks.cardboard_lantern_white);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "light_gray_dyes", SPBlocks.cardboard_lantern_light_grey);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "gray_dyes", SPBlocks.cardboard_lantern_grey);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "black_dyes", SPBlocks.cardboard_lantern_black);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "red_dyes", SPBlocks.cardboard_lantern_red);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "orange_dyes", SPBlocks.cardboard_lantern_orange);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "yellow_dyes", SPBlocks.cardboard_lantern_yellow);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "lime_dyes", SPBlocks.cardboard_lantern_lime);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "green_dyes", SPBlocks.cardboard_lantern_green);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "light_blue_dyes", SPBlocks.cardboard_lantern_light_blue);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "cyan_dyes", SPBlocks.cardboard_lantern_cyan);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "blue_dyes", SPBlocks.cardboard_lantern_blue);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "purple_dyes", SPBlocks.cardboard_lantern_purple);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "magenta_dyes", SPBlocks.cardboard_lantern_magenta);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "pink_dyes", SPBlocks.cardboard_lantern_pink);
			if(!success.consumesAction())
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "brown_dyes", SPBlocks.cardboard_lantern_brown);

			state.updateShape(hit.getDirection(), state, worldIn, pos, pos);
			return success;
		} else {
			state.updateShape(hit.getDirection(), state, worldIn, pos, pos);
		}

		return InteractionResult.FAIL;
	}

	protected InteractionResult checkDye(Level worldIn, BlockPos pos, BlockState state, Player playerIn, ItemStack stack, String dye_tag, Block dyeBlock) {

		TagKey<Item> tag = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", dye_tag));

		if(stack.is(tag)) {
			if(!playerIn.isCreative())
				stack.shrink(1);
			worldIn.setBlock(pos, dyeBlock.defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(FLOATING, state.getValue(FLOATING)).setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
			return InteractionResult.SUCCESS;
		}

		return InteractionResult.FAIL;
	}

	/**
	 * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
	 * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
	 * returns its solidified counterpart.
	 * Note that this method should ideally consider only the specific face passed in.
	 */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos fromPos)
	{
		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		if (!canPlaceBlock(((Level) worldIn), pos, (Direction)state.getValue(FACING)) && !state.getValue(FLOATING))
		{
			return Blocks.AIR.defaultBlockState();
		} else {
			if(state.getValue(FACING) == Direction.DOWN && !isValidPos(((Level) worldIn), fromPos, Direction.DOWN)) {
				return Blocks.AIR.defaultBlockState();
			}
		}

		if(state.getValue(FLOATING) && !canBlockStay(((Level) worldIn), pos, state)) {
			return Blocks.AIR.defaultBlockState();
		}
		return state;
	}

	public boolean canBlockStay(Level worldIn, BlockPos pos, BlockState state)
	{
		BlockState iblockstate = worldIn.getBlockState(pos.below());
		FluidState ifluidstate = worldIn.getFluidState(pos.below());
		Material material = iblockstate.getMaterial();
		return ifluidstate.getType() == Fluids.WATER || (material == Material.ICE || material == Material.ICE_SOLID) || (iblockstate.getBlock() instanceof AbstractCauldronBlock && iblockstate.getBlock() != Blocks.LAVA_CAULDRON && ((AbstractCauldronBlock) iblockstate.getBlock()).isFull(iblockstate));
	}

	/**
	 * Check whether this block can be placed on the block in the given direction.
	 */
	protected static boolean canPlaceBlock(Level worldIn, BlockPos pos, Direction direction)
	{
		BlockPos blockpos = pos.relative(direction.getOpposite());
		BlockState iblockstate = worldIn.getBlockState(blockpos);
		Block block = iblockstate.getBlock();

		if (direction == Direction.UP)
		{
			if(block instanceof TrapDoorBlock && !isTrapdoorValid(iblockstate, direction)) {
				return false;
			} else if(block instanceof SlabBlock && !isSlabValid(iblockstate, direction)) {
				return false;
			} else if(block instanceof BlockCardboardLantern && iblockstate.getValue(FACING).getAxis() == Direction.Axis.Y) {
				return false;
			} else {
				return true;
			}
		} else if (direction != Direction.DOWN) {
			if(block instanceof TrapDoorBlock && !isTrapdoorValid(iblockstate, direction)) {
				return false;
			}
			return iblockstate.isFaceSturdy(worldIn, blockpos, direction.getOpposite());
		} else {
			return isValidPos(worldIn, pos, Direction.DOWN);
		}
	}

	protected boolean canFloat(Level worldIn, BlockPos pos, Direction direction)
	{
		BlockPos blockpos = pos.relative(direction.getOpposite());
		BlockState iblockstate = worldIn.getBlockState(blockpos);

		return direction == Direction.UP && (iblockstate.getBlock() == Blocks.WATER || ((iblockstate.getMaterial() == Material.ICE || iblockstate.getMaterial() == Material.ICE_SOLID) && direction != Direction.DOWN) || (iblockstate.getBlock() instanceof AbstractCauldronBlock && iblockstate.getBlock() != Blocks.LAVA_CAULDRON && ((AbstractCauldronBlock) iblockstate.getBlock()).isFull(iblockstate)));
	}

	protected boolean isWaterLogged(Level worldIn, BlockPos pos) {
		FluidState ifluidstate = worldIn.getFluidState(pos);
		return Boolean.valueOf(ifluidstate.getType() == Fluids.WATER);

	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {

		if(canPlaceBlock(context.getLevel(), context.getClickedPos(), context.getClickedFace()))
			return this.defaultBlockState().setValue(FACING, context.getClickedFace()).setValue(FLOATING, Boolean.valueOf(canFloat(context.getLevel(), context.getClickedPos(), context.getClickedFace()))).setValue(WATERLOGGED, isWaterLogged(context.getLevel(), context.getClickedPos()));
		else
			return null;
	}

	protected static boolean isValidPos(Level worldIn, BlockPos pos, Direction direction)
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

		if(block instanceof SlabBlock) {
			return isSlabValid(state, direction);
		}

		if(state.isAir()) {
			return false;
		} else {
			return true;
		}
	}

	protected static boolean isTrapdoorValid(BlockState state, Direction facing) {
		return state.getProperties().contains(TrapDoorBlock.HALF) && (facing == Direction.UP && state.getValue(TrapDoorBlock.HALF) == Half.TOP || facing == Direction.DOWN && state.getValue(TrapDoorBlock.HALF) == Half.BOTTOM) && !state.getValue(TrapDoorBlock.OPEN);
	}

	protected static boolean isSlabValid(BlockState state, Direction facing) {
		return (state.getProperties().contains(SlabBlock.TYPE) && (facing == Direction.UP && state.getValue(SlabBlock.TYPE) == SlabType.TOP || facing == Direction.DOWN && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM)) || state.getValue(SlabBlock.TYPE) == SlabType.DOUBLE;
	}

	/**
	 * Called after the block is set in the Chunk data, but before the Tile Entity is set
	 */
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving)
	{
		Random rand = new Random();
		worldIn.scheduleTick(pos, this, 20 + rand.nextInt(10));
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
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, FLOATING, WATERLOGGED);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return (Boolean) state.getValue(WATERLOGGED)
				? Fluids.WATER.getSource(false)
						: super.getFluidState(state);
	}
}