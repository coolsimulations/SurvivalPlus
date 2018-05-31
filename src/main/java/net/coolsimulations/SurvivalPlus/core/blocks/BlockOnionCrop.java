package net.coolsimulations.SurvivalPlus.core.blocks;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockOnionCrop extends BlockCrops{
	
	@Override
	protected Item getSeed()
    {
        return SPItems.onion_seeds;
    }
	@Override
    protected Item getCrop()
    {
        return SPItems.raw_onion;
    }
    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        Block soil = worldIn.getBlockState(pos.down()).getBlock();
        return soil.equals(Blocks.FARMLAND);
    }

}
