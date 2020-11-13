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
				gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, SPBlocks.amethyst.getDefaultState(), 3)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 255))).square().func_242731_b(3));
			}
			if(!SPConfig.disableRubyGen.get()) {
				gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, SPBlocks.ruby.getDefaultState(), 3)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 255))).square().func_242731_b(3));
			}
			if(!SPConfig.disableTopazGen.get()) {
				gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, SPBlocks.topaz.getDefaultState(), 3)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 255))).square().func_242731_b(3));
			}
			if(!SPConfig.disableSapphireGen.get()) {
				gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, SPBlocks.sapphire.getDefaultState(), 3)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 255))).square().func_242731_b(3));
			}
		} else if(category == Category.OCEAN && !SPConfig.disablePearlGen.get()) {
			gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(gravel, SPBlocks.pearl.getDefaultState().with(SPBlockCrystal.WATERLOGGED, true), 3)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 63))).square().func_242731_b(3));

		} else if(category == Category.MUSHROOM && !SPConfig.disableSpinelGen.get()) {
			gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, SPBlocks.spinel.getDefaultState(), 3)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 8))).square().func_242731_b(3));

		} else {
			if(!SPConfig.disableCopperOreGen.get()) {
				gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, SPBlocks.copper_ore.getDefaultState(), 8)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 54))).square().func_242731_b(8));
			}
			if(!SPConfig.disableTinOreGen.get()) {
				gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, SPBlocks.tin_ore.getDefaultState(), 8)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 54))).square().func_242731_b(8));
			}
			if(!SPConfig.disableTitaniumOreGen.get()) {
				gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, SPBlocks.titanium_ore.getDefaultState(), 4)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 25))).square().func_242731_b(4));
			}
		}
	}
}

