package net.coolsimulations.SurvivalPlus.core.world;

import com.google.common.base.Predicate;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.Predicates;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;

public class SurvivalPlusOreGenerator {
	
	public static void generateOres() {

		if(!SPConfig.disableTinOreGen) {
			registerOre(BiomeSelectors.foundInOverworld(), "tin_ore", Feature.ORE.configured(new OreConfiguration(Predicates.NATURAL_STONE, SPBlocks.tin_ore.defaultBlockState(), 8)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(96)))).squared().count(6)));
			registerOre(BiomeSelectors.foundInOverworld(), "deepslate_tin_ore", Feature.ORE.configured(new OreConfiguration(Predicates.DEEPSLATE_ORE_REPLACEABLES, SPBlocks.deepslate_tin_ore.defaultBlockState(), 8)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(96)))).squared().count(6)));
		}
		if(!SPConfig.disableTitaniumOreGen) {
			registerOre(BiomeSelectors.foundInOverworld(), "titanium_ore", Feature.ORE.configured(new OreConfiguration(Predicates.NATURAL_STONE, SPBlocks.titanium_ore.defaultBlockState(), 4)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(25)))).squared().count(4)));
			registerOre(BiomeSelectors.foundInOverworld(), "deepslate_titanium_ore", Feature.ORE.configured(new OreConfiguration(Predicates.DEEPSLATE_ORE_REPLACEABLES, SPBlocks.deepslate_titanium_ore.defaultBlockState(), 4)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(25)))).squared().count(4)));
		}
	}

	protected static void registerOre(java.util.function.Predicate<BiomeSelectionContext> selector, String id, ConfiguredFeature<?, ?> config) {

		ResourceKey<ConfiguredFeature<?, ?>> registry = ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation(SPReference.MOD_ID, id));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, registry.location(), config);
		BiomeModifications.addFeature(selector, GenerationStep.Decoration.UNDERGROUND_DECORATION, registry);
	}

	public static class SPGravelGeneratorPredicate implements Predicate<BlockState> {

		@Override
		public boolean apply(BlockState input) {
			return input != null && input.getBlock() == Blocks.GRAVEL;
		}

	}
}

