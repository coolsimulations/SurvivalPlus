package net.coolsimulations.SurvivalPlus.core.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BlockCardboard extends Block {

	public BlockCardboard(MaterialColor colour) {
		super(Properties.of(Material.WOOD, colour).strength(0.5F, 2.5F).sound(SoundType.WOOD).lightLevel((p_235464_0_) -> {return 0;}));
	}

	@Override
	public void spawnAfterBreak(BlockState state, ServerLevel worldIn, BlockPos pos, ItemStack stack) {
		super.spawnAfterBreak(state, worldIn, pos, stack);
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {

		return 30;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {

		return 60;
	}

}