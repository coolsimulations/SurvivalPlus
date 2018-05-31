package net.coolsimulations.SurvivalPlus.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCardboard extends Block{
		
		public BlockCardboard() {
			super(Material.WOOD);
			this.setHardness(0.5F);
			this.setResistance(2.5F);
			this.setLightOpacity(16);
			this.setHarvestLevel("axe", 1);
			this.blockSoundType = SoundType.WOOD;
		}
		
		public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		    return 30;
		  }
		  
		  public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		    return 20;
		  }
		
}