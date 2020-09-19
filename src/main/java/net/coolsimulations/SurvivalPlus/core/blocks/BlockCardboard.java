package net.coolsimulations.SurvivalPlus.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class BlockCardboard extends Block{

	public BlockCardboard() {
		super(Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.5F).sound(SoundType.WOOD).func_235838_a_((p_235464_0_) -> {return 0;}));
	}

	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@Override
	public void spawnAdditionalDrops(BlockState state, ServerWorld worldIn, BlockPos pos, ItemStack stack) {
	      super.spawnAdditionalDrops(state, worldIn, pos, stack);
	}

	@Override
	public int getHarvestLevel(BlockState state) {

		return 1;
	}
	
	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		
		return 30;
	}
	
	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		
		return 60;
	}

}