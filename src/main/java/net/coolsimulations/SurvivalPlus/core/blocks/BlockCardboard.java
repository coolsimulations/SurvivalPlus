package net.coolsimulations.SurvivalPlus.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockCardboard extends Block{
		
		public BlockCardboard() {
			super(Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.5F).sound(SoundType.WOOD));
		}
		
		@Override
		public ToolType getHarvestTool(IBlockState state) {
			return ToolType.AXE;
		}
		
		@Override
	    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune)
	    {
	        return this;
	    }
		
		@Override
		public int getHarvestLevel(IBlockState state) {
			
			return 1;
		}
			
		
		@Override
		public int getLightValue(IBlockState p_getLightValue_1_) {
			
			return 16;
		}
		
		@Override
		public int getFireSpreadSpeed(IBlockState state, IBlockReader world, BlockPos pos, EnumFacing face) {
			
		    return 30;
		}
		
		@Override
		public int getFlammability(IBlockState state, IBlockReader world, BlockPos pos, EnumFacing face) {
			
		    return 20;
		}
		
}