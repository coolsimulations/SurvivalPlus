package net.coolsimulations.SurvivalPlus.primer.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SPBlockCrystal extends AmethystBlock implements SimpleWaterloggedBlock {

	protected static final VoxelShape Crystal_Base_AABB = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 3.0D, 13.0D);
	protected static final VoxelShape Crystal_South_West_Pillar_AABB = Block.box(5.0D, 3.0D, 11.0D, 7.0D, 9.0D, 13.0D);
	protected static final VoxelShape Crystal_South_East_Pillar_AABB = Block.box(10.0D, 3.0D, 10.0D, 12.0D, 9.0D, 12.0D);
	protected static final VoxelShape Crystal_North_East_Pillar_AABB = Block.box(9.0D, 3.0D, 5.0D, 12.0D, 9.0D, 8.0D);
	protected static final VoxelShape Crystal_North_East_Top_Pillar_AABB = Block.box(9.8D, 9.0D, 6.8D, 11.3D, 10.0D, 8.3D);
	protected static final VoxelShape Crystal_North_West_Pillar_AABB = Block.box(6.0D, 3.0D, 5.0D, 9.0D, 12.0D, 8.0D);
	protected static final VoxelShape Crystal_North_West_Top_Pillar_AABB = Block.box(6.8D, 12.0D, 5.8D, 8.3D, 13.0D, 7.3D);
	protected static final VoxelShape Crystal_Middle_Pillar_AABB = Block.box(7.0D, 3.0D, 8.0D, 10.0D, 11.0D, 11.0D);
	protected static final VoxelShape Crystal_Middle_Top_Pillar_AABB = Block.box(7.8D, 11.0D, 8.8D, 9.3D, 12.0D, 10.3D);
	protected static final VoxelShape Crystal_West_Pillar_AABB = Block.box(3.0D, 3.0D, 6.0D, 6.0D, 9.0D, 9.0D);
	protected static final VoxelShape Crystal_West_Top_Pillar_AABB = Block.box(3.8D, 9.0D, 6.8D, 5.3D, 10.0D, 8.3D);
	protected static final VoxelShape Crystal_North_Rotated_1_Pillar_AABB = Block.box(4.0D, 3.0D, 5.0D, 5.0D, 8.0D, 6.0D);
	protected static final VoxelShape Crystal_North_Rotated_2_Pillar_AABB = Block.box(5.0D, 3.0D, 4.0D, 6.0D, 8.0D, 6.0D);
	protected static final VoxelShape Crystal_South_Rotated_1_Pillar_AABB = Block.box(4.0D, 3.0D, 9.0D, 6.0D, 8.0D, 10.0D);
	protected static final VoxelShape Crystal_South_Rotated_2_Pillar_AABB = Block.box(6.0D, 3.0D, 8.0D, 7.0D, 8.0D, 11.0D);
	protected static final VoxelShape Crystal_AABB = Shapes.or(Crystal_Base_AABB, Shapes.or(Crystal_South_West_Pillar_AABB, Shapes.or(Crystal_South_East_Pillar_AABB, Shapes.or(Crystal_North_East_Pillar_AABB, Shapes.or(Crystal_North_East_Top_Pillar_AABB, Shapes.or(Crystal_North_West_Pillar_AABB, Shapes.or(Crystal_North_West_Top_Pillar_AABB, Shapes.or(Crystal_Middle_Pillar_AABB, Shapes.or(Crystal_Middle_Top_Pillar_AABB, Shapes.or(Crystal_West_Pillar_AABB, Shapes.or(Crystal_West_Top_Pillar_AABB, Shapes.or(Crystal_North_Rotated_1_Pillar_AABB, Shapes.or(Crystal_North_Rotated_2_Pillar_AABB, Shapes.or(Crystal_South_Rotated_1_Pillar_AABB, Crystal_South_Rotated_2_Pillar_AABB))))))))))))));
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;


	public SPBlockCrystal(MaterialColor colour) {
		super(FabricBlockSettings.of(Material.AMETHYST, colour).hardness(1.5F).resistance(1.5F).sounds(SoundType.AMETHYST_CLUSTER).breakByTool(FabricToolTags.PICKAXES).luminance(5));
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));

	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
	{
		return Crystal_AABB;
	}

	@Override
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> state) {
		state.add(WATERLOGGED);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return (Boolean) state.getValue(WATERLOGGED)
				? Fluids.WATER.getSource(false)
						: super.getFluidState(state);
	}

}