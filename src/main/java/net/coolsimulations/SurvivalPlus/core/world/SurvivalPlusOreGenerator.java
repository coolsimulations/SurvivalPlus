package net.coolsimulations.SurvivalPlus.core.world;

import java.util.List;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnSettingsBuilder;

public class SurvivalPlusOreGenerator {

	public static final RuleTest gravel = new TagMatchTest(Tags.Blocks.GRAVEL);

	public static final List<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, SPBlocks.tin_ore.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, SPBlocks.deepslate_tin_ore.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_TITANIUM_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, SPBlocks.titanium_ore.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, SPBlocks.deepslate_titanium_ore.get().defaultBlockState()));

	public static void generateOres(ResourceLocation name, Biome.ClimateSettings climate, Biome.BiomeCategory category, BiomeSpecialEffects effects, BiomeGenerationSettingsBuilder gen, MobSpawnSettingsBuilder spawns) {

		if (category != BiomeCategory.NETHER && category != BiomeCategory.THEEND) {
			if(!SPConfig.disableTinOreGen.get()) {
				if(name.toString().equals("minecraft:dripstone_caves")) {
					gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, PlacementUtils.register("tin_ore_large", FeatureUtils.register("tin_ore_large", Feature.ORE, new OreConfiguration(ORE_TIN_TARGET_LIST, 20)), commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
				} else {
					gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, PlacementUtils.register("tin_ore", FeatureUtils.register("tin_ore", Feature.ORE, new OreConfiguration(ORE_TIN_TARGET_LIST, 10)), commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
				}
			}
			if(!SPConfig.disableTitaniumOreGen.get()) {
				gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, PlacementUtils.register("titanium_ore", FeatureUtils.register("titanium_ore", Feature.ORE, new OreConfiguration(ORE_TITANIUM_TARGET_LIST, 4)), commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(25)))));
				gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, PlacementUtils.register("titanium_ore_large", FeatureUtils.register("titanium_ore_large", Feature.ORE, new OreConfiguration(ORE_TITANIUM_TARGET_LIST, 8)), rareOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-62), VerticalAnchor.aboveBottom(62)))));
			}
		}
	}

	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}

	private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
		return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
	}
}

