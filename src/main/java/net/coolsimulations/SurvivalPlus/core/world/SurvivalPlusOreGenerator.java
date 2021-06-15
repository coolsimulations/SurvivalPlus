package net.coolsimulations.SurvivalPlus.core.world;

import com.google.common.base.Predicate;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystal;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;

public class SurvivalPlusOreGenerator {

	public static final RuleTest gravel = new TagMatchRuleTest(Tags.Blocks.GRAVEL);

	public static void generateOres(ResourceLocation name, Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettingsBuilder gen, MobSpawnInfoBuilder spawns) {

		if (category == Category.NETHER) {
			if(!SPConfig.disableAmethystGen.get()) {
				gen.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, SPBlocks.amethyst.defaultBlockState(), 3)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(0, 0, 255))).squared().count(3));
			}
			if(!SPConfig.disableRubyGen.get()) {
				gen.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, SPBlocks.ruby.defaultBlockState(), 3)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(0, 0, 255))).squared().count(3));
			}
			if(!SPConfig.disableTopazGen.get()) {
				gen.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, SPBlocks.topaz.defaultBlockState(), 3)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(0, 0, 255))).squared().count(3));
			}
			if(!SPConfig.disableSapphireGen.get()) {
				gen.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, SPBlocks.sapphire.defaultBlockState(), 3)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(0, 0, 255))).squared().count(3));
			}
		} else if (category != Category.THEEND) {
			if(category == Category.OCEAN && !SPConfig.disablePearlGen.get()) {
				gen.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreFeatureConfig(gravel, SPBlocks.pearl.defaultBlockState().setValue(SPBlockCrystal.WATERLOGGED, true), 3)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(0, 0, 63))).squared().count(3));

			}
			if(category == Category.MUSHROOM && !SPConfig.disableSpinelGen.get()) {
				gen.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, SPBlocks.spinel.defaultBlockState(), 3)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(0, 0, 8))).squared().count(3));

			}
			if(!SPConfig.disableCopperOreGen.get()) {
				gen.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, SPBlocks.copper_ore.defaultBlockState(), 8)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(0, 0, 54))).squared().count(8));
			}
			if(!SPConfig.disableTinOreGen.get()) {
				gen.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, SPBlocks.tin_ore.defaultBlockState(), 8)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(0, 0, 54))).squared().count(8));
			}
			if(!SPConfig.disableTitaniumOreGen.get()) {
				gen.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, SPBlocks.titanium_ore.defaultBlockState(), 4)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(0, 0, 25))).squared().count(4));
			}
		}
	}
}

