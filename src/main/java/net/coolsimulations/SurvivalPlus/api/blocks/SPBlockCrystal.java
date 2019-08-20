package net.coolsimulations.SurvivalPlus.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class SPBlockCrystal extends Block{
	
    protected static final VoxelShape Crystal_AABB = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 13.0D, 13.0D);

		
		public SPBlockCrystal() {
			super(Properties.create(Material.GLASS).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.GLASS).lightValue(7));
			
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
		
}