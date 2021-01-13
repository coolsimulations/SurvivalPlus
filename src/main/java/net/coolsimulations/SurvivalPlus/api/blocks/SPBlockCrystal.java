package net.coolsimulations.SurvivalPlus.api.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.EntityContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;

public class SPBlockCrystal extends Block implements Waterloggable{
	
	protected static final VoxelShape Crystal_Base_AABB = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 3.0D, 13.0D);
	protected static final VoxelShape Crystal_South_West_Pillar_AABB = Block.createCuboidShape(7.0D, 3.0D, 13.0D, 5.0D, 9.0D, 11.0D);
	protected static final VoxelShape Crystal_South_East_Pillar_AABB = Block.createCuboidShape(12.0D, 3.0D, 12.0D, 10.0D, 9.0D, 10.0D);
	protected static final VoxelShape Crystal_North_East_Pillar_AABB = Block.createCuboidShape(12.0D, 3.0D, 8.0D, 9.0D, 9.0D, 5.0D);
	protected static final VoxelShape Crystal_North_East_Top_Pillar_AABB = Block.createCuboidShape(11.3D, 9.0D, 8.3D, 9.8D, 10.0D, 6.8D);
	protected static final VoxelShape Crystal_North_West_Pillar_AABB = Block.createCuboidShape(9.0D, 3.0D, 8.0D, 6.0D, 12.0D, 5.0D);
	protected static final VoxelShape Crystal_North_West_Top_Pillar_AABB = Block.createCuboidShape(8.3D, 12.0D, 7.3D, 6.8D, 13.0D, 5.8D);
	protected static final VoxelShape Crystal_Middle_Pillar_AABB = Block.createCuboidShape(10.0D, 3.0D, 11.0D, 7.0D, 11.0D, 8.0D);
	protected static final VoxelShape Crystal_Middle_Top_Pillar_AABB = Block.createCuboidShape(9.3D, 11.0D, 10.3D, 7.8D, 12.0D, 8.8D);
	protected static final VoxelShape Crystal_West_Pillar_AABB = Block.createCuboidShape(6.0D, 3.0D, 9.0D, 3.0D, 9.0D, 6.0D);
	protected static final VoxelShape Crystal_West_Top_Pillar_AABB = Block.createCuboidShape(5.3D, 9.0D, 8.3D, 3.8D, 10.0D, 6.8D);
	protected static final VoxelShape Crystal_North_Rotated_1_Pillar_AABB = Block.createCuboidShape(5.0D, 3.0D, 6.0D, 4.0D, 8.0D, 5.0D);
	protected static final VoxelShape Crystal_North_Rotated_2_Pillar_AABB = Block.createCuboidShape(6.0D, 3.0D, 6.0D, 5.0D, 8.0D, 4.0D);
	protected static final VoxelShape Crystal_South_Rotated_1_Pillar_AABB = Block.createCuboidShape(6.0D, 3.0D, 10.0D, 4.0D, 8.0D, 9.0D);
	protected static final VoxelShape Crystal_South_Rotated_2_Pillar_AABB = Block.createCuboidShape(7.0D, 3.0D, 11.0D, 6.0D, 8.0D, 8.0D);
    protected static final VoxelShape Crystal_AABB = VoxelShapes.union(Crystal_Base_AABB, VoxelShapes.union(Crystal_South_West_Pillar_AABB, VoxelShapes.union(Crystal_South_East_Pillar_AABB, VoxelShapes.union(Crystal_North_East_Pillar_AABB, VoxelShapes.union(Crystal_North_East_Top_Pillar_AABB, VoxelShapes.union(Crystal_North_West_Pillar_AABB, VoxelShapes.union(Crystal_North_West_Top_Pillar_AABB, VoxelShapes.union(Crystal_Middle_Pillar_AABB, VoxelShapes.union(Crystal_Middle_Top_Pillar_AABB, VoxelShapes.union(Crystal_West_Pillar_AABB, VoxelShapes.union(Crystal_West_Top_Pillar_AABB, VoxelShapes.union(Crystal_North_Rotated_1_Pillar_AABB, VoxelShapes.union(Crystal_North_Rotated_2_Pillar_AABB, VoxelShapes.union(Crystal_South_Rotated_1_Pillar_AABB, Crystal_South_Rotated_2_Pillar_AABB))))))))))))));
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;;

		
		public SPBlockCrystal(MaterialColor colour) {
			super(FabricBlockSettings.of(Material.GLASS, colour).hardness(1.0F).resistance(1.0F).sounds(BlockSoundGroup.GLASS).breakByTool(FabricToolTags.PICKAXES).lightLevel(7));
			this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false));
			
		}
		
		@Override
	    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, EntityContext context)
		{
	        return Crystal_AABB;
	    }
		
		@Override
		public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
			if (stateIn.get(WATERLOGGED)) {
				worldIn.getFluidTickScheduler().schedule(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
			}

			return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		}

		@Override
		public BlockState getPlacementState(ItemPlacementContext context) {
			FluidState ifluidstate = context.getWorld().getFluidState(context.getBlockPos());
			return this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
		}
		
		@Override
		protected void appendProperties(Builder<Block, BlockState> state) {
			state.add(WATERLOGGED);
		}

		/**@Override
		public boolean canContainFluid(IBlockReader reader, BlockPos pos, BlockState state, Fluid fluid) {
			return !(Boolean) state.get(WATERLOGGED) && fluid == Fluids.WATER;
		}

		@Override
		public boolean receiveFluid(IWorld world, BlockPos pos, BlockState state, FluidState fluid) {
			if (!(Boolean) state.get(WATERLOGGED) && fluid.getFluid() == Fluids.WATER) {
				if (!world.isRemote()) {
					world.setBlockState(pos, (BlockState) state.with(WATERLOGGED, true), 3);
					world.getPendingFluidTicks().scheduleTick(pos, fluid.getFluid(),
							fluid.getFluid().getTickRate(world));
				}

				return true;
			} else {
				return false;
			}
		}

		@Override
		public Fluid pickupFluid(IWorld world, BlockPos pos, BlockState state) {
			if ((Boolean) state.get(WATERLOGGED)) {
				world.setBlockState(pos, (BlockState) state.with(WATERLOGGED, false), 3);
				return Fluids.WATER;
			} else {
				return Fluids.EMPTY;
			}
		}**/
		
		@Override
		public FluidState getFluidState(BlockState state) {
			return (Boolean) state.get(WATERLOGGED)
					? Fluids.WATER.getStill(false)
					: super.getFluidState(state);
		}
		
}