package net.coolsimulations.SurvivalPlus.core.world;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystal;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusOreGenerator {

	public static void generateOres() {

		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			if (biome instanceof NetherBiome) {
				if(!SPConfig.disableAmethystGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(BlockMatcher.forBlock(Blocks.NETHERRACK), SPBlocks.amethyst.getDefaultState(), 3), biome.COUNT_RANGE, new CountRangeConfig(10, 1, 0, 255)));
				}
				if(!SPConfig.disableRubyGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(BlockMatcher.forBlock(Blocks.NETHERRACK), SPBlocks.ruby.getDefaultState(), 3), biome.COUNT_RANGE, new CountRangeConfig(10, 1, 0, 255)));
				}
				if(!SPConfig.disableTopazGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(BlockMatcher.forBlock(Blocks.NETHERRACK), SPBlocks.topaz.getDefaultState(), 3), biome.COUNT_RANGE, new CountRangeConfig(10, 1, 0, 255)));
				}
				if(!SPConfig.disableSapphireGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(BlockMatcher.forBlock(Blocks.NETHERRACK), SPBlocks.sapphire.getDefaultState(), 3), biome.COUNT_RANGE, new CountRangeConfig(10, 1, 0, 255)));
				}
			} else if(!(biome instanceof EndBarrensBiome || biome instanceof EndHighlandsBiome || biome instanceof EndMidlandsBiome)) {

				if(biome instanceof OceanBiome || biome instanceof DeepOceanBiome || biome instanceof ColdOceanBiome || biome instanceof DeepColdOceanBiome || biome instanceof DeepWarmOceanBiome || biome instanceof WarmOceanBiome || biome instanceof DeepLukewarmOceanBiome || biome instanceof LukewarmOceanBiome || biome instanceof DeepFrozenOceanBiome || biome instanceof FrozenOceanBiome && !SPConfig.disablePearlGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(BlockMatcher.forBlock(Blocks.GRAVEL), SPBlocks.pearl.getDefaultState().with(SPBlockCrystal.WATERLOGGED, true), 3), biome.COUNT_RANGE, new CountRangeConfig(4, 20, 0, 63)));

				}
				if((biome instanceof MushroomFieldsBiome || biome instanceof MushroomFieldShoreBiome) && !SPConfig.disableSpinelGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, SPBlocks.spinel.getDefaultState(), 3), biome.COUNT_RANGE, new CountRangeConfig(2, 1, 0, 8)));

				}
				if(!SPConfig.disableCopperOreGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, SPBlocks.copper_ore.getDefaultState(), 8), biome.COUNT_RANGE, new CountRangeConfig(20, 1, 0, 54)));
				}
				if(!SPConfig.disableTinOreGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, SPBlocks.tin_ore.getDefaultState(), 8), biome.COUNT_RANGE, new CountRangeConfig(20, 1, 0, 54)));
				}
				if(!SPConfig.disableTitaniumOreGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, SPBlocks.titanium_ore.getDefaultState(), 4), biome.COUNT_RANGE, new CountRangeConfig(5, 1, 0, 25)));
				}
			}
		}
	}
}
