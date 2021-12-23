package net.coolsimulations.SurvivalPlus.api.world;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystalBudding;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.GeodeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class SPGeodeFeature extends GeodeFeature {

	private SPBlockCrystalBudding buddingBlock;
	private Block baseBlock;
	private Block outerBlock;
	private Block calciteBlock;

	private final GeodeBlockSettings blockSettings;
	private final GeodeConfiguration geodeConfiguration;

	public SPGeodeFeature(@NotNull SPBlockCrystalBudding buddingBlock, @NotNull Block baseBlock, boolean waterLogged) {
		this(buddingBlock, baseBlock, Blocks.CALCITE, Blocks.SMOOTH_BASALT, waterLogged);
	}
	
	public SPGeodeFeature(@NotNull SPBlockCrystalBudding buddingBlock, @NotNull Block baseBlock) {
		this(buddingBlock, baseBlock, false);
	}

	public SPGeodeFeature(@NotNull SPBlockCrystalBudding buddingBlock, @NotNull Block baseBlock, @NotNull Block calciteBlock, @NotNull Block outerBlock, boolean waterLogged) {
		super(GeodeConfiguration.CODEC);
		this.buddingBlock = buddingBlock;
		this.baseBlock = baseBlock;
		this.calciteBlock = calciteBlock;
		this.outerBlock = outerBlock;
		
		BlockState fillingState = Blocks.AIR.defaultBlockState();
		List<BlockState> buds = this.buddingBlock.getStates();
		
		if(waterLogged) {
			fillingState = Blocks.WATER.defaultBlockState();
			List<BlockState> replacements = new ArrayList<BlockState>();
			for(int i = 0; i < buds.size(); i++) {
				replacements.add(buds.get(i).setValue(BlockStateProperties.WATERLOGGED, true));
			}
			buds = replacements;
		}

		this.blockSettings = new GeodeBlockSettings(
				BlockStateProvider.simple(fillingState),
				BlockStateProvider.simple(this.baseBlock.defaultBlockState()),
				BlockStateProvider.simple(this.buddingBlock.defaultBlockState()),
				BlockStateProvider.simple(this.calciteBlock.defaultBlockState()),
				BlockStateProvider.simple(this.outerBlock.defaultBlockState()),
				buds,
				BlockTags.FEATURES_CANNOT_REPLACE.getName(),
				BlockTags.GEODE_INVALID_BLOCKS.getName()
				);

		this.geodeConfiguration = new GeodeConfiguration(
				blockSettings,
				new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
				new GeodeCrackSettings(0.95D, 2.0D, 2),
				0.35D, 0.083D, true,
				UniformInt.of(4, 6),
				UniformInt.of(3, 4),
				UniformInt.of(1, 2),
				-16, 16, 0.05D, 1
				);
	}

	public GeodeConfiguration getGeodeConfiguration() {
		return this.geodeConfiguration;
	}

	public GeodeBlockSettings getBlockSettings() {
		return blockSettings;
	}
}
