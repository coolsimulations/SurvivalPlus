package net.coolsimulations.SurvivalPlus.core.world;

import com.google.common.base.Predicate;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystal;
import net.coolsimulations.SurvivalPlus.api.world.SPOreFeature;
import net.coolsimulations.SurvivalPlus.api.world.SPOreFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.ColdOceanBiome;
import net.minecraft.world.biome.DeepColdOceanBiome;
import net.minecraft.world.biome.DeepFrozenOceanBiome;
import net.minecraft.world.biome.DeepLukewarmOceanBiome;
import net.minecraft.world.biome.DeepOceanBiome;
import net.minecraft.world.biome.DeepWarmOceanBiome;
import net.minecraft.world.biome.EndBiome;
import net.minecraft.world.biome.FrozenOceanBiome;
import net.minecraft.world.biome.LukewarmOceanBiome;
import net.minecraft.world.biome.MushroomFieldShoreBiome;
import net.minecraft.world.biome.MushroomFieldsBiome;
import net.minecraft.world.biome.NetherBiome;
import net.minecraft.world.biome.OceanBiome;
import net.minecraft.world.biome.WarmOceanBiome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.Target;;

public class SurvivalPlusOreGenerator {

	public static void generateOres() {

		for (Biome biome : Registry.BIOME) {
			if (biome instanceof NetherBiome || biome.getCategory() == Category.NETHER) {
				if(!SPConfig.disableAmethystGen) {
					biome.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Biome.configureFeature(Feature.ORE, new OreFeatureConfig(Target.NETHERRACK, SPBlocks.amethyst.getDefaultState(), 3), Decorator.COUNT_RANGE, new RangeDecoratorConfig(10, 1, 0, 255)));
				}
				if(!SPConfig.disableRubyGen) {
					biome.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Biome.configureFeature(Feature.ORE, new OreFeatureConfig(Target.NETHERRACK, SPBlocks.ruby.getDefaultState(), 3), Decorator.COUNT_RANGE, new RangeDecoratorConfig(10, 1, 0, 255)));
				}
				if(!SPConfig.disableTopazGen) {
					biome.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Biome.configureFeature(Feature.ORE, new OreFeatureConfig(Target.NETHERRACK, SPBlocks.topaz.getDefaultState(), 3), Decorator.COUNT_RANGE, new RangeDecoratorConfig(10, 1, 0, 255)));
				}
				if(!SPConfig.disableSapphireGen) {
					biome.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Biome.configureFeature(Feature.ORE, new OreFeatureConfig(Target.NETHERRACK, SPBlocks.sapphire.getDefaultState(), 3), Decorator.COUNT_RANGE, new RangeDecoratorConfig(10, 1, 0, 255)));
				}
			} else if(!(biome instanceof EndBiome || biome.getCategory() == Category.THEEND)) {
				if((biome instanceof OceanBiome || biome instanceof DeepOceanBiome || biome instanceof ColdOceanBiome || biome instanceof DeepColdOceanBiome || biome instanceof DeepWarmOceanBiome || biome instanceof WarmOceanBiome || biome instanceof DeepLukewarmOceanBiome || biome instanceof LukewarmOceanBiome || biome instanceof DeepFrozenOceanBiome || biome instanceof FrozenOceanBiome || biome.getCategory() == Category.OCEAN) && !SPConfig.disablePearlGen) {
					biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Biome.configureFeature(SPOreFeature.SURVIVALPLUS_ORE_FEATURE, new SPOreFeatureConfig(new SPGravelGeneratorPredicate(), SPBlocks.pearl.getDefaultState().with(SPBlockCrystal.WATERLOGGED, true), 3), Decorator.COUNT_RANGE, new RangeDecoratorConfig(4, 20, 0, 63)));

				}
				if((biome instanceof MushroomFieldsBiome || biome instanceof MushroomFieldShoreBiome || biome.getCategory() == Category.MUSHROOM) && !SPConfig.disableSpinelGen) {
					biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Biome.configureFeature(Feature.ORE, new OreFeatureConfig(Target.NATURAL_STONE, SPBlocks.spinel.getDefaultState(), 3), Decorator.COUNT_RANGE, new RangeDecoratorConfig(2, 1, 0, 8)));

				}
				if(!SPConfig.disableCopperOreGen) {
					biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Biome.configureFeature(Feature.ORE, new OreFeatureConfig(Target.NATURAL_STONE, SPBlocks.copper_ore.getDefaultState(), 8), Decorator.COUNT_RANGE, new RangeDecoratorConfig(20, 1, 0, 54)));
				}
				if(!SPConfig.disableTinOreGen) {
					biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Biome.configureFeature(Feature.ORE, new OreFeatureConfig(Target.NATURAL_STONE, SPBlocks.tin_ore.getDefaultState(), 8), Decorator.COUNT_RANGE, new RangeDecoratorConfig(20, 1, 0, 54)));
				}
				if(!SPConfig.disableTitaniumOreGen) {
					biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Biome.configureFeature(Feature.ORE, new OreFeatureConfig(Target.NATURAL_STONE, SPBlocks.titanium_ore.getDefaultState(), 4), Decorator.COUNT_RANGE, new RangeDecoratorConfig(10, 1, 0, 25)));
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

