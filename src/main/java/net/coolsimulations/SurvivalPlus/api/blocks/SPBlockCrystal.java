package net.coolsimulations.SurvivalPlus.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.init.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class SPBlockCrystal extends Block implements IBucketPickupHandler, ILiquidContainer{
	
	protected static final VoxelShape Crystal_Base_AABB = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 3.0D, 13.0D);
	protected static final VoxelShape Crystal_South_West_Pillar_AABB = Block.makeCuboidShape(7.0D, 3.0D, 13.0D, 5.0D, 9.0D, 11.0D);
	protected static final VoxelShape Crystal_South_East_Pillar_AABB = Block.makeCuboidShape(12.0D, 3.0D, 12.0D, 10.0D, 9.0D, 10.0D);
	protected static final VoxelShape Crystal_North_East_Pillar_AABB = Block.makeCuboidShape(12.0D, 3.0D, 8.0D, 9.0D, 9.0D, 5.0D);
	protected static final VoxelShape Crystal_North_East_Top_Pillar_AABB = Block.makeCuboidShape(11.3D, 9.0D, 8.3D, 9.8D, 10.0D, 6.8D);
	protected static final VoxelShape Crystal_North_West_Pillar_AABB = Block.makeCuboidShape(9.0D, 3.0D, 8.0D, 6.0D, 12.0D, 5.0D);
	protected static final VoxelShape Crystal_North_West_Top_Pillar_AABB = Block.makeCuboidShape(8.3D, 12.0D, 7.3D, 6.8D, 13.0D, 5.8D);
	protected static final VoxelShape Crystal_Middle_Pillar_AABB = Block.makeCuboidShape(10.0D, 3.0D, 11.0D, 7.0D, 11.0D, 8.0D);
	protected static final VoxelShape Crystal_Middle_Top_Pillar_AABB = Block.makeCuboidShape(9.3D, 11.0D, 10.3D, 7.8D, 12.0D, 8.8D);
	protected static final VoxelShape Crystal_West_Pillar_AABB = Block.makeCuboidShape(6.0D, 3.0D, 9.0D, 3.0D, 9.0D, 6.0D);
	protected static final VoxelShape Crystal_West_Top_Pillar_AABB = Block.makeCuboidShape(5.3D, 9.0D, 8.3D, 3.8D, 10.0D, 6.8D);
	protected static final VoxelShape Crystal_North_Rotated_1_Pillar_AABB = Block.makeCuboidShape(5.0D, 3.0D, 6.0D, 4.0D, 8.0D, 5.0D);
	protected static final VoxelShape Crystal_North_Rotated_2_Pillar_AABB = Block.makeCuboidShape(6.0D, 3.0D, 6.0D, 5.0D, 8.0D, 4.0D);
	protected static final VoxelShape Crystal_South_Rotated_1_Pillar_AABB = Block.makeCuboidShape(6.0D, 3.0D, 10.0D, 4.0D, 8.0D, 9.0D);
	protected static final VoxelShape Crystal_South_Rotated_2_Pillar_AABB = Block.makeCuboidShape(7.0D, 3.0D, 11.0D, 6.0D, 8.0D, 8.0D);
    protected static final VoxelShape Crystal_AABB = VoxelShapes.or(Crystal_Base_AABB, VoxelShapes.or(Crystal_South_West_Pillar_AABB, VoxelShapes.or(Crystal_South_East_Pillar_AABB, VoxelShapes.or(Crystal_North_East_Pillar_AABB, VoxelShapes.or(Crystal_North_East_Top_Pillar_AABB, VoxelShapes.or(Crystal_North_West_Pillar_AABB, VoxelShapes.or(Crystal_North_West_Top_Pillar_AABB, VoxelShapes.or(Crystal_Middle_Pillar_AABB, VoxelShapes.or(Crystal_Middle_Top_Pillar_AABB, VoxelShapes.or(Crystal_West_Pillar_AABB, VoxelShapes.or(Crystal_West_Top_Pillar_AABB, VoxelShapes.or(Crystal_North_Rotated_1_Pillar_AABB, VoxelShapes.or(Crystal_North_Rotated_2_Pillar_AABB, VoxelShapes.or(Crystal_South_Rotated_1_Pillar_AABB, Crystal_South_Rotated_2_Pillar_AABB))))))))))))));
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;;

		
		public SPBlockCrystal() {
			super(Properties.create(Material.GLASS).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.GLASS).lightValue(7));
			this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, false));
			
		}
		
		@Override
		public ToolType getHarvestTool(IBlockState state) {
			return ToolType.PICKAXE;
		}
		
		@Override
	    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune)
	    {
	        return this;
	    }
		
		@Override
		public int getHarvestLevel(IBlockState state) {
			return 0;
		}
		
		@Override
		public boolean isFullCube(IBlockState state)
		{
			return false;
		}
		
		@Override
	    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos)
		{
	        return Crystal_AABB;
	    }
		
		@Override
		public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
			if (stateIn.get(WATERLOGGED)) {
				worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
			}

			return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		}

		@Override
		public IBlockState getStateForPlacement(BlockItemUseContext context) {
			IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
			return this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
		}
		
		@Override
		protected void fillStateContainer(Builder<Block, IBlockState> state) {
			state.add(new IProperty[]{WATERLOGGED});
		}

		@Override
		public boolean canContainFluid(IBlockReader reader, BlockPos pos, IBlockState state, Fluid fluid) {
			return !(Boolean) state.get(WATERLOGGED) && fluid == Fluids.WATER;
		}

		@Override
		public boolean receiveFluid(IWorld world, BlockPos pos, IBlockState state, IFluidState fluid) {
			if (!(Boolean) state.get(WATERLOGGED) && fluid.getFluid() == Fluids.WATER) {
				if (!world.isRemote()) {
					world.setBlockState(pos, (IBlockState) state.with(WATERLOGGED, true), 3);
					world.getPendingFluidTicks().scheduleTick(pos, fluid.getFluid(),
							fluid.getFluid().getTickRate(world));
				}

				return true;
			} else {
				return false;
			}
		}

		@Override
		public Fluid pickupFluid(IWorld world, BlockPos pos, IBlockState state) {
			if ((Boolean) state.get(WATERLOGGED)) {
				world.setBlockState(pos, (IBlockState) state.with(WATERLOGGED, false), 3);
				return Fluids.WATER;
			} else {
				return Fluids.EMPTY;
			}
		}
		
		@Override
		public IFluidState getFluidState(IBlockState state) {
			return (Boolean) state.get(WATERLOGGED)
					? Fluids.WATER.getStillFluidState(false)
					: super.getFluidState(state);
		}
		
}