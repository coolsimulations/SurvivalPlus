package net.coolsimulations.SurvivalPlus.core.init;

import java.util.List;

import com.google.common.collect.ImmutableList;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystalBudding;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public class SurvivalPlusGeodes {
	
	public static final DeferredRegister<Block> BLOCKS_GEODE = DeferredRegister.create(ForgeRegistries.BLOCKS, SPReference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS_GEODE = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	
	private static final RegistryObject<Block> ruby_block = BLOCKS_GEODE.register("ruby_block", () -> new AmethystBlock(Properties.of(Material.AMETHYST, MaterialColor.COLOR_RED).strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).requiresCorrectToolForDrops()));
	private static final RegistryObject<Block> ruby_cluster = BLOCKS_GEODE.register("ruby_cluster", () -> new AmethystClusterBlock(7, 3, Properties.of(Material.AMETHYST, MaterialColor.COLOR_RED).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel((blockState) -> 5)));
	private static final RegistryObject<Block> large_ruby_bud = BLOCKS_GEODE.register("large_ruby_bud", () -> new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(ruby_cluster.get()).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((blockState) -> 4)));
	private static final RegistryObject<Block> medium_ruby_bud = BLOCKS_GEODE.register("medium_ruby_bud", () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(ruby_cluster.get()).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((blockState) -> 2)));
	private static final RegistryObject<Block> small_ruby_bud = BLOCKS_GEODE.register("small_ruby_bud", () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(ruby_cluster.get()).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((blockState) -> 1)));
	private static final RegistryObject<Block> budding_ruby = BLOCKS_GEODE.register("budding_ruby", () -> new SPBlockCrystalBudding(Properties.of(Material.AMETHYST, MaterialColor.COLOR_RED).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
			ImmutableList.of(((AmethystClusterBlock) small_ruby_bud.get()), ((AmethystClusterBlock) medium_ruby_bud.get()), ((AmethystClusterBlock) large_ruby_bud.get()), ((AmethystClusterBlock) ruby_cluster.get()))));
	private static final RegistryObject<Block> pearl_block = BLOCKS_GEODE.register("pearl_block", () -> new AmethystBlock(Properties.of(Material.AMETHYST, MaterialColor.SNOW).strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).requiresCorrectToolForDrops()));
	private static final RegistryObject<Block> pearl_cluster = BLOCKS_GEODE.register("pearl_cluster", () -> new AmethystClusterBlock(7, 3, Properties.of(Material.AMETHYST, MaterialColor.SNOW).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel((blockState) -> 5)));
	private static final RegistryObject<Block> large_pearl_bud = BLOCKS_GEODE.register("large_pearl_bud", () -> new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(pearl_cluster.get()).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((blockState) -> 4)));
	private static final RegistryObject<Block> medium_pearl_bud = BLOCKS_GEODE.register("medium_pearl_bud", () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(pearl_cluster.get()).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((blockState) -> 2)));
	private static final RegistryObject<Block> small_pearl_bud = BLOCKS_GEODE.register("small_pearl_bud", () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(pearl_cluster.get()).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((blockState) -> 1)));
	private static final RegistryObject<Block> budding_pearl = BLOCKS_GEODE.register("budding_pearl", () -> new SPBlockCrystalBudding(Properties.of(Material.AMETHYST, MaterialColor.SNOW).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
			ImmutableList.of(((AmethystClusterBlock) small_pearl_bud.get()), ((AmethystClusterBlock) medium_pearl_bud.get()), ((AmethystClusterBlock) large_pearl_bud.get()), ((AmethystClusterBlock) pearl_cluster.get()))));
	private static final RegistryObject<Block> topaz_block = BLOCKS_GEODE.register("topaz_block", () -> new AmethystBlock(Properties.of(Material.AMETHYST, MaterialColor.SNOW).strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).requiresCorrectToolForDrops()));
	private static final RegistryObject<Block> topaz_cluster = BLOCKS_GEODE.register("topaz_cluster", () -> new AmethystClusterBlock(7, 3, Properties.of(Material.AMETHYST, MaterialColor.SNOW).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel((blockState) -> 5)));
	private static final RegistryObject<Block> large_topaz_bud = BLOCKS_GEODE.register("large_topaz_bud", () -> new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(topaz_cluster.get()).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((blockState) -> 4)));
	private static final RegistryObject<Block> medium_topaz_bud = BLOCKS_GEODE.register("medium_topaz_bud", () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(topaz_cluster.get()).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((blockState) -> 2)));
	private static final RegistryObject<Block> small_topaz_bud = BLOCKS_GEODE.register("small_topaz_bud", () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(topaz_cluster.get()).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((blockState) -> 1)));
	private static final RegistryObject<Block> budding_topaz = BLOCKS_GEODE.register("budding_topaz", () -> new SPBlockCrystalBudding(Properties.of(Material.AMETHYST, MaterialColor.SNOW).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
			ImmutableList.of(((AmethystClusterBlock) small_topaz_bud.get()), ((AmethystClusterBlock) medium_topaz_bud.get()), ((AmethystClusterBlock) large_topaz_bud.get()), ((AmethystClusterBlock) topaz_cluster.get()))));
	private static final RegistryObject<Block> sapphire_block = BLOCKS_GEODE.register("sapphire_block", () -> new AmethystBlock(Properties.of(Material.AMETHYST, MaterialColor.SNOW).strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).requiresCorrectToolForDrops()));
	private static final RegistryObject<Block> sapphire_cluster = BLOCKS_GEODE.register("sapphire_cluster", () -> new AmethystClusterBlock(7, 3, Properties.of(Material.AMETHYST, MaterialColor.SNOW).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel((blockState) -> 5)));
	private static final RegistryObject<Block> large_sapphire_bud = BLOCKS_GEODE.register("large_sapphire_bud", () -> new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(sapphire_cluster.get()).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((blockState) -> 4)));
	private static final RegistryObject<Block> medium_sapphire_bud = BLOCKS_GEODE.register("medium_sapphire_bud", () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(sapphire_cluster.get()).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((blockState) -> 2)));
	private static final RegistryObject<Block> small_sapphire_bud = BLOCKS_GEODE.register("small_sapphire_bud", () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(sapphire_cluster.get()).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((blockState) -> 1)));
	private static final RegistryObject<Block> budding_sapphire = BLOCKS_GEODE.register("budding_sapphire", () -> new SPBlockCrystalBudding(Properties.of(Material.AMETHYST, MaterialColor.SNOW).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
			ImmutableList.of(((AmethystClusterBlock) small_sapphire_bud.get()), ((AmethystClusterBlock) medium_sapphire_bud.get()), ((AmethystClusterBlock) large_sapphire_bud.get()), ((AmethystClusterBlock) sapphire_cluster.get()))));
	private static final RegistryObject<Block> spinel_block = BLOCKS_GEODE.register("spinel_block", () -> new AmethystBlock(Properties.of(Material.AMETHYST, MaterialColor.SNOW).strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).requiresCorrectToolForDrops()));
	private static final RegistryObject<Block> spinel_cluster = BLOCKS_GEODE.register("spinel_cluster", () -> new AmethystClusterBlock(7, 3, Properties.of(Material.AMETHYST, MaterialColor.SNOW).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel((blockState) -> 5)));
	private static final RegistryObject<Block> large_spinel_bud = BLOCKS_GEODE.register("large_spinel_bud", () -> new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(spinel_cluster.get()).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((blockState) -> 4)));
	private static final RegistryObject<Block> medium_spinel_bud = BLOCKS_GEODE.register("medium_spinel_bud", () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(spinel_cluster.get()).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((blockState) -> 2)));
	private static final RegistryObject<Block> small_spinel_bud = BLOCKS_GEODE.register("small_spinel_bud", () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(spinel_cluster.get()).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((blockState) -> 1)));
	private static final RegistryObject<Block> budding_spinel = BLOCKS_GEODE.register("budding_spinel", () -> new SPBlockCrystalBudding(Properties.of(Material.AMETHYST, MaterialColor.SNOW).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
			ImmutableList.of(((AmethystClusterBlock) small_spinel_bud.get()), ((AmethystClusterBlock) medium_spinel_bud.get()), ((AmethystClusterBlock) large_spinel_bud.get()), ((AmethystClusterBlock) spinel_cluster.get()))));
	
	private static final RegistryObject<Item> ruby_block_item = ITEMS_GEODE.register("ruby_block", () -> new BlockItem(ruby_block.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> ruby_cluster_item = ITEMS_GEODE.register("ruby_cluster", () -> new BlockItem(ruby_cluster.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> large_ruby_bud_item = ITEMS_GEODE.register("large_ruby_bud", () -> new BlockItem(large_ruby_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> medium_ruby_bud_item = ITEMS_GEODE.register("medium_ruby_bud", () -> new BlockItem(medium_ruby_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> small_ruby_bud_item = ITEMS_GEODE.register("small_ruby_bud", () -> new BlockItem(small_ruby_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> budding_ruby_item = ITEMS_GEODE.register("budding_ruby", () -> new BlockItem(budding_ruby.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> pearl_block_item = ITEMS_GEODE.register("pearl_block", () -> new BlockItem(pearl_block.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> pearl_cluster_item = ITEMS_GEODE.register("pearl_cluster", () -> new BlockItem(pearl_cluster.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> large_pearl_bud_item = ITEMS_GEODE.register("large_pearl_bud", () -> new BlockItem(large_pearl_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> medium_pearl_bud_item = ITEMS_GEODE.register("medium_pearl_bud", () -> new BlockItem(medium_pearl_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> small_pearl_bud_item = ITEMS_GEODE.register("small_pearl_bud", () -> new BlockItem(small_pearl_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> budding_pearl_item = ITEMS_GEODE.register("budding_pearl", () -> new BlockItem(budding_pearl.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> topaz_block_item = ITEMS_GEODE.register("topaz_block", () -> new BlockItem(topaz_block.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> topaz_cluster_item = ITEMS_GEODE.register("topaz_cluster", () -> new BlockItem(topaz_cluster.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> large_topaz_bud_item = ITEMS_GEODE.register("large_topaz_bud", () -> new BlockItem(large_topaz_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> medium_topaz_bud_item = ITEMS_GEODE.register("medium_topaz_bud", () -> new BlockItem(medium_topaz_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> small_topaz_bud_item = ITEMS_GEODE.register("small_topaz_bud", () -> new BlockItem(small_topaz_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> budding_topaz_item = ITEMS_GEODE.register("budding_topaz", () -> new BlockItem(budding_topaz.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> sapphire_block_item = ITEMS_GEODE.register("sapphire_block", () -> new BlockItem(sapphire_block.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> sapphire_cluster_item = ITEMS_GEODE.register("sapphire_cluster", () -> new BlockItem(sapphire_cluster.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> large_sapphire_bud_item = ITEMS_GEODE.register("large_sapphire_bud", () -> new BlockItem(large_sapphire_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> medium_sapphire_bud_item = ITEMS_GEODE.register("medium_sapphire_bud", () -> new BlockItem(medium_sapphire_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> small_sapphire_bud_item = ITEMS_GEODE.register("small_sapphire_bud", () -> new BlockItem(small_sapphire_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> budding_sapphire_item = ITEMS_GEODE.register("budding_sapphire", () -> new BlockItem(budding_sapphire.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> spinel_block_item = ITEMS_GEODE.register("spinel_block", () -> new BlockItem(spinel_block.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> spinel_cluster_item = ITEMS_GEODE.register("spinel_cluster", () -> new BlockItem(spinel_cluster.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> large_spinel_bud_item = ITEMS_GEODE.register("large_spinel_bud", () -> new BlockItem(large_spinel_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> medium_spinel_bud_item = ITEMS_GEODE.register("medium_spinel_bud", () -> new BlockItem(medium_spinel_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> small_spinel_bud_item = ITEMS_GEODE.register("small_spinel_bud", () -> new BlockItem(small_spinel_bud.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> budding_spinel_item = ITEMS_GEODE.register("budding_spinel", () -> new BlockItem(budding_spinel.get(), new Item.Properties().tab(SPTabs.tabGem)));
	
	private static final RegistryObject<Item> ruby_shard = ITEMS_GEODE.register("ruby_shard", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials)));
	private static final RegistryObject<Item> pearl = ITEMS_GEODE.register("pearl", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials)));
	private static final RegistryObject<Item> topaz_shard = ITEMS_GEODE.register("topaz_shard", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials)));
	private static final RegistryObject<Item> sapphire_shard = ITEMS_GEODE.register("sapphire_shard", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials)));
	private static final RegistryObject<Item> spinel_shard = ITEMS_GEODE.register("spinel_shard", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials)));

	public static void registerFeature(BiomeGenerationSettingsBuilder gen, Biome.BiomeCategory category) {

		if (category == BiomeCategory.NETHER) {
			if(!SPConfig.disableRubyGen.get()) {
				gen.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, PlacementUtils.register("ruby_geode", FeatureUtils.register("ruby_geode", Feature.GEODE, new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR.defaultBlockState()), BlockStateProvider.simple(ruby_block.get().defaultBlockState()), BlockStateProvider.simple(budding_ruby.get().defaultBlockState()), BlockStateProvider.simple(Blocks.CALCITE.defaultBlockState()), BlockStateProvider.simple(Blocks.MAGMA_BLOCK.defaultBlockState()), ((SPBlockCrystalBudding) budding_ruby.get()).getStates(), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)), List.of(RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()), BiomeFilter.biome())));
			}
			if(!SPConfig.disableTopazGen.get()) {
				gen.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, PlacementUtils.register("topaz_geode", FeatureUtils.register("topaz_geode", Feature.GEODE, new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR.defaultBlockState()), BlockStateProvider.simple(topaz_block.get().defaultBlockState()), BlockStateProvider.simple(budding_topaz.get().defaultBlockState()), BlockStateProvider.simple(Blocks.CALCITE.defaultBlockState()), BlockStateProvider.simple(Blocks.MAGMA_BLOCK.defaultBlockState()), ((SPBlockCrystalBudding) budding_topaz.get()).getStates(), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)), List.of(RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()), BiomeFilter.biome())));
			}
			if(!SPConfig.disableSapphireGen.get()) {
				gen.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, PlacementUtils.register("sapphire_geode", FeatureUtils.register("sapphire_geode", Feature.GEODE, new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR.defaultBlockState()), BlockStateProvider.simple(sapphire_block.get().defaultBlockState()), BlockStateProvider.simple(budding_sapphire.get().defaultBlockState()), BlockStateProvider.simple(Blocks.CALCITE.defaultBlockState()), BlockStateProvider.simple(Blocks.MAGMA_BLOCK.defaultBlockState()), ((SPBlockCrystalBudding) budding_sapphire.get()).getStates(), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)), List.of(RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()), BiomeFilter.biome())));
			}
		} else if (category != BiomeCategory.THEEND) {

			if(category == BiomeCategory.OCEAN && !SPConfig.disablePearlGen.get()) {
				gen.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, PlacementUtils.register("pearl_geode", FeatureUtils.register("pearl_geode", Feature.GEODE, new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.WATER.defaultBlockState()), BlockStateProvider.simple(pearl_block.get().defaultBlockState()), BlockStateProvider.simple(budding_pearl.get().defaultBlockState()), BlockStateProvider.simple(Blocks.CALCITE.defaultBlockState()), BlockStateProvider.simple(Blocks.SMOOTH_BASALT.defaultBlockState()), ImmutableList.of(((SPBlockCrystalBudding) budding_pearl.get()).getStates().get(0).setValue(BlockStateProperties.WATERLOGGED, true), ((SPBlockCrystalBudding) budding_pearl.get()).getStates().get(1).setValue(BlockStateProperties.WATERLOGGED, true), ((SPBlockCrystalBudding) budding_pearl.get()).getStates().get(2).setValue(BlockStateProperties.WATERLOGGED, true), ((SPBlockCrystalBudding) budding_pearl.get()).getStates().get(3).setValue(BlockStateProperties.WATERLOGGED, true)), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)), List.of(RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(64), VerticalAnchor.absolute(63)), BiomeFilter.biome())));
			}

			if(category == BiomeCategory.MUSHROOM && !SPConfig.disableSpinelGen.get()) {
				gen.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, PlacementUtils.register("spinel_geode", FeatureUtils.register("spinel_geode", Feature.GEODE, new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR.defaultBlockState()), BlockStateProvider.simple(spinel_block.get().defaultBlockState()), BlockStateProvider.simple(budding_spinel.get().defaultBlockState()), BlockStateProvider.simple(Blocks.CALCITE.defaultBlockState()), BlockStateProvider.simple(Blocks.SMOOTH_BASALT.defaultBlockState()), ((SPBlockCrystalBudding) budding_spinel.get()).getStates(), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)), List.of(RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64)), BiomeFilter.biome())));
			}
		}
	}

}
