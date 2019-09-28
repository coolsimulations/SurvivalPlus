package net.coolsimulations.SurvivalPlus.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
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