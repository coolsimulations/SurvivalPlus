package net.coolsimulations.SurvivalPlus.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class SPBlockCrystal extends Block{
	
    protected static final AxisAlignedBB Crystal_AABB = new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.8125D, 0.8125D);

		
		public SPBlockCrystal() {
			super(Material.GLASS);
			this.setHardness(1.0F);
			this.setResistance(1.0F);
			this.setLightOpacity(0);
			this.setLightLevel(0.4375F);
			this.setHarvestLevel("pickaxe", 0);
			this.blockSoundType = SoundType.GLASS;
			
		}
		
		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}
		
		@Override
		public boolean isFullCube(IBlockState state)
		{
			return false;
		}
		
		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        return Crystal_AABB;
	    }
		
}