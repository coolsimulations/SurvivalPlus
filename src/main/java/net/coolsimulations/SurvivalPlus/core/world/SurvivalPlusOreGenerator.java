package net.coolsimulations.SurvivalPlus.core.world;

import java.util.List;

import com.google.common.base.Predicate;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class SurvivalPlusOreGenerator {
	
	public static final List<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), SPBlocks.tin_ore.defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), SPBlocks.deepslate_tin_ore.defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_TITANIUM_TARGET_LIST = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), SPBlocks.titanium_ore.defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), SPBlocks.deepslate_titanium_ore.defaultBlockState()));
	
	public static void generateOres() {

		if(!SPConfig.disableTinOreGen) {
			registerOre(BiomeSelectors.includeByKey(Biomes.DRIPSTONE_CAVES), "tin_ore_large", new OreConfiguration(ORE_TIN_TARGET_LIST, 20), commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
			registerOre(BiomeSelectors.foundInOverworld().and(BiomeSelectors.excludeByKey(Biomes.DRIPSTONE_CAVES)), "tin_ore", new OreConfiguration(ORE_TIN_TARGET_LIST, 10), commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
		}
		if(!SPConfig.disableTitaniumOreGen) {
			registerOre(BiomeSelectors.foundInOverworld(), "titanium_ore", new OreConfiguration(ORE_TITANIUM_TARGET_LIST, 4), commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(25))));
			registerOre(BiomeSelectors.foundInOverworld(), "titanium_ore_large", new OreConfiguration(ORE_TITANIUM_TARGET_LIST, 8), rareOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-62), VerticalAnchor.aboveBottom(62))));

		}
	}

	protected static void registerOre(java.util.function.Predicate<BiomeSelectionContext> selector, String id, OreConfiguration config, List<PlacementModifier> list) {
		ResourceLocation location = new ResourceLocation(SPReference.MOD_ID, id);
		BiomeModifications.addFeature(selector, GenerationStep.Decoration.UNDERGROUND_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, location));
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

	public static class SPGravelGeneratorPredicate implements Predicate<BlockState> {

		@Override
		public boolean apply(BlockState input) {
			return input != null && input.getBlock() == Blocks.GRAVEL;
		}

	}
}

