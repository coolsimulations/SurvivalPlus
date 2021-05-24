package net.coolsimulations.SurvivalPlus.core.world;

import com.google.common.base.Predicate;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystal;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockStateMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.Rules;

public class SurvivalPlusOreGenerator {

	public static void generateOres() {

		if(!SPConfig.disableAmethystGen) {
			registerOre(BiomeSelectors.foundInTheNether(), "amethyst", Feature.ORE.configure(new OreFeatureConfig(Rules.NETHERRACK, SPBlocks.amethyst.getDefaultState(), 3)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 255)).spreadHorizontally().repeat(3)));
		}
		if(!SPConfig.disableRubyGen) {
			registerOre(BiomeSelectors.foundInTheNether(), "ruby", Feature.ORE.configure(new OreFeatureConfig(Rules.NETHERRACK, SPBlocks.ruby.getDefaultState(), 3)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 255)).spreadHorizontally().repeat(3)));
		}
		if(!SPConfig.disableTopazGen) {
			registerOre(BiomeSelectors.foundInTheNether(), "topaz", Feature.ORE.configure(new OreFeatureConfig(Rules.NETHERRACK, SPBlocks.topaz.getDefaultState(), 3)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 255)).spreadHorizontally().repeat(3)));
		}
		if(!SPConfig.disableSapphireGen) {
			registerOre(BiomeSelectors.foundInTheNether(), "sapphire", Feature.ORE.configure(new OreFeatureConfig(Rules.NETHERRACK, SPBlocks.sapphire.getDefaultState(), 3)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 255)).spreadHorizontally().repeat(3)));
		}
		if(!SPConfig.disablePearlGen) {
			registerOre(BiomeSelectors.categories(Biome.Category.OCEAN), "pearl", Feature.ORE.configure(new OreFeatureConfig(new BlockStateMatchRuleTest(Blocks.GRAVEL.getDefaultState()), SPBlocks.pearl.getDefaultState().with(SPBlockCrystal.WATERLOGGED, true), 3)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 63)).spreadHorizontally().repeat(3)));

		}
		if(!SPConfig.disableSpinelGen) {
			registerOre(BiomeSelectors.categories(Category.MUSHROOM), "spinel", Feature.ORE.configure(new OreFeatureConfig(Rules.BASE_STONE_OVERWORLD, SPBlocks.spinel.getDefaultState(), 3)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 8)).spreadHorizontally().repeat(3)));

		}
		if(!SPConfig.disableCopperOreGen) {
			registerOre(BiomeSelectors.foundInOverworld(), "copper_ore", Feature.ORE.configure(new OreFeatureConfig(Rules.BASE_STONE_OVERWORLD, SPBlocks.copper_ore.getDefaultState(), 8)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 54)).spreadHorizontally().repeat(8)));
		}
		if(!SPConfig.disableTinOreGen) {
			registerOre(BiomeSelectors.foundInOverworld(), "tin_ore", Feature.ORE.configure(new OreFeatureConfig(Rules.BASE_STONE_OVERWORLD, SPBlocks.tin_ore.getDefaultState(), 8)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 54)).spreadHorizontally().repeat(8)));
		}
		if(!SPConfig.disableTitaniumOreGen) {
			registerOre(BiomeSelectors.foundInOverworld(), "titanium_ore", Feature.ORE.configure(new OreFeatureConfig(Rules.BASE_STONE_OVERWORLD, SPBlocks.titanium_ore.getDefaultState(), 4)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 25)).spreadHorizontally().repeat(4)));
		}
	}

	protected static void registerOre(java.util.function.Predicate<BiomeSelectionContext> selector, String id, ConfiguredFeature<?, ?> config) {

		RegistryKey<ConfiguredFeature<?, ?>> registry = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier(SPReference.MOD_ID, id));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, registry.getValue(), config);
		BiomeModifications.addFeature(selector, GenerationStep.Feature.UNDERGROUND_DECORATION, registry);
	}

	public static class SPGravelGeneratorPredicate implements Predicate<BlockState> {

		@Override
		public boolean apply(BlockState input) {
			return input != null && input.getBlock() == Blocks.GRAVEL;
		}

	}
}

