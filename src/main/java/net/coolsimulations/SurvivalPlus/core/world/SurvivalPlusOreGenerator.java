package net.coolsimulations.SurvivalPlus.core.world;

import com.google.common.base.Predicate;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystal;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.ColdOceanBiome;
import net.minecraft.world.biome.DeepColdOceanBiome;
import net.minecraft.world.biome.DeepFrozenOceanBiome;
import net.minecraft.world.biome.DeepLukewarmOceanBiome;
import net.minecraft.world.biome.DeepOceanBiome;
import net.minecraft.world.biome.DeepWarmOceanBiome;
import net.minecraft.world.biome.EndBarrensBiome;
import net.minecraft.world.biome.EndHighlandsBiome;
import net.minecraft.world.biome.EndMidlandsBiome;
import net.minecraft.world.biome.FrozenOceanBiome;
import net.minecraft.world.biome.LukewarmOceanBiome;
import net.minecraft.world.biome.MushroomFieldShoreBiome;
import net.minecraft.world.biome.MushroomFieldsBiome;
import net.minecraft.world.biome.NetherBiome;
import net.minecraft.world.biome.OceanBiome;
import net.minecraft.world.biome.WarmOceanBiome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusOreGenerator {

	public static void generateOres() {

		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			if (biome instanceof NetherBiome) {
				if(!SPConfig.disableAmethystGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK, SPBlocks.amethyst.getDefaultState(), 3), Placement.COUNT_RANGE, new CountRangeConfig(10, 1, 0, 255)));
				}
				if(!SPConfig.disableRubyGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK, SPBlocks.ruby.getDefaultState(), 3), Placement.COUNT_RANGE, new CountRangeConfig(10, 1, 0, 255)));
				}
				if(!SPConfig.disableTopazGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK, SPBlocks.topaz.getDefaultState(), 3), Placement.COUNT_RANGE, new CountRangeConfig(10, 1, 0, 255)));
				}
				if(!SPConfig.disableSapphireGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK, SPBlocks.sapphire.getDefaultState(), 3), Placement.COUNT_RANGE, new CountRangeConfig(10, 1, 0, 255)));
				}
			} else if(!(biome instanceof EndBarrensBiome || biome instanceof EndHighlandsBiome || biome instanceof EndMidlandsBiome)) {
				if(biome instanceof OceanBiome || biome instanceof DeepOceanBiome || biome instanceof ColdOceanBiome || biome instanceof DeepColdOceanBiome || biome instanceof DeepWarmOceanBiome || biome instanceof WarmOceanBiome || biome instanceof DeepLukewarmOceanBiome || biome instanceof LukewarmOceanBiome || biome instanceof DeepFrozenOceanBiome || biome instanceof FrozenOceanBiome && !SPConfig.disablePearlGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.create("gravel", "gravel", new SPGravelGeneratorPredicate()), SPBlocks.pearl.getDefaultState().with(SPBlockCrystal.WATERLOGGED, true), 3), Placement.COUNT_RANGE, new CountRangeConfig(4, 20, 0, 63)));

				}
				if((biome instanceof MushroomFieldsBiome || biome instanceof MushroomFieldShoreBiome) && !SPConfig.disableSpinelGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, SPBlocks.spinel.getDefaultState(), 3), Placement.COUNT_RANGE, new CountRangeConfig(2, 1, 0, 8)));

				}
				if(!SPConfig.disableCopperOreGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, SPBlocks.copper_ore.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(20, 1, 0, 54)));
				}
				if(!SPConfig.disableTinOreGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, SPBlocks.tin_ore.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(20, 1, 0, 54)));
				}
				if(!SPConfig.disableTitaniumOreGen.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, SPBlocks.titanium_ore.getDefaultState(), 4), Placement.COUNT_RANGE, new CountRangeConfig(10, 1, 0, 25)));
				}
			}
		}
	}

	public static class SPGravelGeneratorPredicate implements Predicate<BlockState> {

		@Override
		public boolean apply(BlockState input) {
			return input != null && input.getBlock() == Blocks.GRAVEL;
		}

	}
}

