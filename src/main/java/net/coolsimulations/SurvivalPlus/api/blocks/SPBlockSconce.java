package net.coolsimulations.SurvivalPlus.api.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SPBlockSconce extends Block {

	protected static final VoxelShape SCONCE_NORTH_AABB = Block.box(6.0D, 1.810752D, 9.590768D, 10.0D, 11.6564D, 16.0D);
	protected static final VoxelShape SCONCE_SOUTH_AABB = Block.box(6.0D, 1.810752D, 0.0D, 10.0D, 11.6564D, 6.409232D);
	protected static final VoxelShape SCONCE_WEST_AABB = Block.box(9.590768D, 1.810752D, 6.0D, 16.0D, 11.6564D, 10.0D);
	protected static final VoxelShape SCONCE_EAST_AABB = Block.box(0.0D, 1.810752D, 6.0D, 6.409232D, 11.6564D, 10.0D);

	public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;

	public SPBlockSconce() {
		super(FabricBlockSettings.of(Material.METAL, MaterialColor.COLOR_BROWN).strength(3.5F, 3.7F).requiresTool().sounds(SoundType.LANTERN));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
	{
		switch ((Direction)state.getValue(FACING))
		{
		case EAST:
			return SCONCE_EAST_AABB;
		case WEST:
			return SCONCE_WEST_AABB;
		case SOUTH:
			return SCONCE_SOUTH_AABB;
		case NORTH:
			return SCONCE_NORTH_AABB;
		default:
			return SCONCE_WEST_AABB;
		}
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
	{
		return Shapes.empty();
	}

	@Override
	public PushReaction getPistonPushReaction(BlockState state)
	{
		return PushReaction.DESTROY;
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		Direction direction = state.getValue(FACING);
		BlockPos blockpos = pos.relative(direction.getOpposite());
		BlockState blockstate = world.getBlockState(blockpos);
		return blockstate.isFaceSturdy(world, blockpos, direction);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState blockstate = this.defaultBlockState();
		LevelReader levelreader = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		Direction[] adirection = context.getNearestLookingDirections();

		for(Direction direction : adirection) {
			if (direction.getAxis().isHorizontal()) {
				Direction direction1 = direction.getOpposite();
				blockstate = blockstate.setValue(FACING, direction1);
				if (blockstate.canSurvive(levelreader, blockpos)) {
					return blockstate;
				}
			}
		}

		return null;
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos fromPos) {
		return facing.getOpposite() == state.getValue(FACING) && !state.canSurvive(worldIn, pos) ? Blocks.AIR.defaultBlockState() : state;
	}

	@Override
	public RenderShape getRenderShape(BlockState state)
	{
		return RenderShape.MODEL;
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
		state.add(FACING);
	}

}
