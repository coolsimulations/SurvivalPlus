package net.coolsimulations.SurvivalPlus.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class SPBlockCrystal extends Block implements IWaterLoggable {

	protected static final VoxelShape Crystal_Base_AABB = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 3.0D, 13.0D);
	protected static final VoxelShape Crystal_South_West_Pillar_AABB = Block.box(7.0D, 3.0D, 13.0D, 5.0D, 9.0D, 11.0D);
	protected static final VoxelShape Crystal_South_East_Pillar_AABB = Block.box(12.0D, 3.0D, 12.0D, 10.0D, 9.0D, 10.0D);
	protected static final VoxelShape Crystal_North_East_Pillar_AABB = Block.box(12.0D, 3.0D, 8.0D, 9.0D, 9.0D, 5.0D);
	protected static final VoxelShape Crystal_North_East_Top_Pillar_AABB = Block.box(11.3D, 9.0D, 8.3D, 9.8D, 10.0D, 6.8D);
	protected static final VoxelShape Crystal_North_West_Pillar_AABB = Block.box(9.0D, 3.0D, 8.0D, 6.0D, 12.0D, 5.0D);
	protected static final VoxelShape Crystal_North_West_Top_Pillar_AABB = Block.box(8.3D, 12.0D, 7.3D, 6.8D, 13.0D, 5.8D);
	protected static final VoxelShape Crystal_Middle_Pillar_AABB = Block.box(10.0D, 3.0D, 11.0D, 7.0D, 11.0D, 8.0D);
	protected static final VoxelShape Crystal_Middle_Top_Pillar_AABB = Block.box(9.3D, 11.0D, 10.3D, 7.8D, 12.0D, 8.8D);
	protected static final VoxelShape Crystal_West_Pillar_AABB = Block.box(6.0D, 3.0D, 9.0D, 3.0D, 9.0D, 6.0D);
	protected static final VoxelShape Crystal_West_Top_Pillar_AABB = Block.box(5.3D, 9.0D, 8.3D, 3.8D, 10.0D, 6.8D);
	protected static final VoxelShape Crystal_North_Rotated_1_Pillar_AABB = Block.box(5.0D, 3.0D, 6.0D, 4.0D, 8.0D, 5.0D);
	protected static final VoxelShape Crystal_North_Rotated_2_Pillar_AABB = Block.box(6.0D, 3.0D, 6.0D, 5.0D, 8.0D, 4.0D);
	protected static final VoxelShape Crystal_South_Rotated_1_Pillar_AABB = Block.box(6.0D, 3.0D, 10.0D, 4.0D, 8.0D, 9.0D);
	protected static final VoxelShape Crystal_South_Rotated_2_Pillar_AABB = Block.box(7.0D, 3.0D, 11.0D, 6.0D, 8.0D, 8.0D);
	protected static final VoxelShape Crystal_AABB = VoxelShapes.or(Crystal_Base_AABB, VoxelShapes.or(Crystal_South_West_Pillar_AABB, VoxelShapes.or(Crystal_South_East_Pillar_AABB, VoxelShapes.or(Crystal_North_East_Pillar_AABB, VoxelShapes.or(Crystal_North_East_Top_Pillar_AABB, VoxelShapes.or(Crystal_North_West_Pillar_AABB, VoxelShapes.or(Crystal_North_West_Top_Pillar_AABB, VoxelShapes.or(Crystal_Middle_Pillar_AABB, VoxelShapes.or(Crystal_Middle_Top_Pillar_AABB, VoxelShapes.or(Crystal_West_Pillar_AABB, VoxelShapes.or(Crystal_West_Top_Pillar_AABB, VoxelShapes.or(Crystal_North_Rotated_1_Pillar_AABB, VoxelShapes.or(Crystal_North_Rotated_2_Pillar_AABB, VoxelShapes.or(Crystal_South_Rotated_1_Pillar_AABB, Crystal_South_Rotated_2_Pillar_AABB))))))))))))));
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;;


	public SPBlockCrystal(MaterialColor colour) {
		super(Properties.of(Material.GLASS, colour).strength(1.0F, 1.0F).sound(SoundType.GLASS).lightLevel((p_235464_0_) -> {return 7;}));
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));

	}

	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public void spawnAfterBreak(BlockState state, ServerWorld worldIn, BlockPos pos, ItemStack stack) {
		super.spawnAfterBreak(state, worldIn, pos, stack);
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return Crystal_AABB;
	}

	@Override
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
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