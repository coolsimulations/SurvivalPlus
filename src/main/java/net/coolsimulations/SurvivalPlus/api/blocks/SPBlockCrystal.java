package net.coolsimulations.SurvivalPlus.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class SPBlockCrystal extends Block{
	
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

		
		public SPBlockCrystal() {
			super(Properties.create(Material.GLASS).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.GLASS).lightValue(7));
			
		}
		
		@Override
		public ToolType getHarvestTool(BlockState state) {
			return ToolType.PICKAXE;
		}
		
		@Override
		public void spawnAdditionalDrops(BlockState state, World world, BlockPos pos, ItemStack stack) {
			super.spawnAdditionalDrops(state, world, pos, stack);
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
		
}