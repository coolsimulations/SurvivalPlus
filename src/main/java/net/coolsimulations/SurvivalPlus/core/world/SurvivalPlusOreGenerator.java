package net.coolsimulations.SurvivalPlus.core.world;

import com.google.common.base.Predicate;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystal;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.Predicates;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockStateMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class SurvivalPlusOreGenerator {
	
	public static void generateOres() {

		if(!SPConfig.disableAmethystGen) {
			registerOre(BiomeSelectors.foundInTheNether(), "amethyst", Feature.ORE.configured(new OreConfiguration(Predicates.NETHERRACK, SPBlocks.amethyst.defaultBlockState(), 3)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(0, 0, 255)).squared().count(3)));
		}
		if(!SPConfig.disableRubyGen) {
			registerOre(BiomeSelectors.foundInTheNether(), "ruby", Feature.ORE.configured(new OreConfiguration(Predicates.NETHERRACK, SPBlocks.ruby.defaultBlockState(), 3)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(0, 0, 255)).squared().count(3)));
		}
		if(!SPConfig.disableTopazGen) {
			registerOre(BiomeSelectors.foundInTheNether(), "topaz", Feature.ORE.configured(new OreConfiguration(Predicates.NETHERRACK, SPBlocks.topaz.defaultBlockState(), 3)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(0, 0, 255)).squared().count(3)));
		}
		if(!SPConfig.disableSapphireGen) {
			registerOre(BiomeSelectors.foundInTheNether(), "sapphire", Feature.ORE.configured(new OreConfiguration(Predicates.NETHERRACK, SPBlocks.sapphire.defaultBlockState(), 3)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(0, 0, 255)).squared().count(3)));
		}
		if(!SPConfig.disablePearlGen) {
			registerOre(BiomeSelectors.categories(BiomeCategory.OCEAN), "pearl", Feature.ORE.configured(new OreConfiguration(new BlockStateMatchTest(Blocks.GRAVEL.defaultBlockState()), SPBlocks.pearl.defaultBlockState().setValue(SPBlockCrystal.WATERLOGGED, true), 3)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(0, 0, 63)).squared().count(3)));

		}
		if(!SPConfig.disableSpinelGen) {
			registerOre(BiomeSelectors.categories(BiomeCategory.MUSHROOM), "spinel", Feature.ORE.configured(new OreConfiguration(Predicates.NATURAL_STONE, SPBlocks.spinel.defaultBlockState(), 3)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(0, 0, 8)).squared().count(3)));

		}
		if(!SPConfig.disableCopperOreGen) {
			registerOre(BiomeSelectors.foundInOverworld(), "copper_ore", Feature.ORE.configured(new OreConfiguration(Predicates.NATURAL_STONE, SPBlocks.copper_ore.defaultBlockState(), 8)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(0, 0, 54)).squared().count(8)));
		}
		if(!SPConfig.disableTinOreGen) {
			registerOre(BiomeSelectors.foundInOverworld(), "tin_ore", Feature.ORE.configured(new OreConfiguration(Predicates.NATURAL_STONE, SPBlocks.tin_ore.defaultBlockState(), 8)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(0, 0, 54)).squared().count(8)));
		}
		if(!SPConfig.disableTitaniumOreGen) {
			registerOre(BiomeSelectors.foundInOverworld(), "titanium_ore", Feature.ORE.configured(new OreConfiguration(Predicates.NATURAL_STONE, SPBlocks.titanium_ore.defaultBlockState(), 4)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(0, 0, 25)).squared().count(4)));
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

