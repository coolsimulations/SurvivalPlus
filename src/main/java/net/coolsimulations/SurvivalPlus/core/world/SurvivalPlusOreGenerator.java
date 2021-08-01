package net.coolsimulations.SurvivalPlus.core.world;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;

public class SurvivalPlusOreGenerator {

	public static final RuleTest gravel = new TagMatchTest(Tags.Blocks.GRAVEL);

	public static void generateOres(ResourceLocation name, Biome.ClimateSettings climate, Biome.BiomeCategory category, float depth, float scale, BiomeSpecialEffects effects, BiomeGenerationSettingsBuilder gen, MobSpawnInfoBuilder spawns) {

		if (category != BiomeCategory.NETHER && category != BiomeCategory.THEEND) {
			if(!SPConfig.disableTinOreGen.get()) {
				gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, SPBlocks.tin_ore.defaultBlockState(), 8)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(96))))).squared().count(6));
				gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, SPBlocks.deepslate_tin_ore.defaultBlockState(), 8)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(96))))).squared().count(6));
			}
			if(!SPConfig.disableTitaniumOreGen.get()) {
				gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, SPBlocks.titanium_ore.defaultBlockState(), 4)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(25))))).squared().count(4));
				gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, SPBlocks.deepslate_titanium_ore.defaultBlockState(), 4)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(25))))).squared().count(4));
			}
		}
	}
}

