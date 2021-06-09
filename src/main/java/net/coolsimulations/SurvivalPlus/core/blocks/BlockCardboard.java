package net.coolsimulations.SurvivalPlus.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockCardboard extends Block {

	public BlockCardboard(MaterialColor colour) {
		super(Properties.create(Material.WOOD, colour).hardnessAndResistance(0.5F, 2.5F).sound(SoundType.WOOD));
		FireBlock fireblock = (FireBlock) Blocks.FIRE;
		fireblock.setFireInfo(this, 30, 60);
	}

	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@Override
	public void spawnAdditionalDrops(BlockState state, World world, BlockPos pos, ItemStack stack) {
		super.spawnAdditionalDrops(state, world, pos, stack);
	}

	@Override
	public int getHarvestLevel(BlockState state) {

		return 1;
	}


	@Override
	public int getLightValue(BlockState p_getLightValue_1_) {

		return 0;
	}

}