package net.coolsimulations.SurvivalPlus.api.world;

import com.google.common.base.Predicate;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class SPNetherGeneratorPredicate implements Predicate<BlockState> {
	
	@Override
	public boolean apply(BlockState input) {
		return input != null && input.getBlock() == Blocks.NETHERRACK;
	}

}
