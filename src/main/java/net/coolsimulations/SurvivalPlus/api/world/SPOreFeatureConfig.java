package net.coolsimulations.SurvivalPlus.api.world;

import java.util.function.Predicate;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class SPOreFeatureConfig extends OreFeatureConfig {

	Predicate<BlockState> blockPredicate;

	public SPOreFeatureConfig(Predicate<BlockState> blockPredicate, BlockState blockState, int size) {
		super(null, blockState, size);
		this.blockPredicate = blockPredicate;
	}
}
