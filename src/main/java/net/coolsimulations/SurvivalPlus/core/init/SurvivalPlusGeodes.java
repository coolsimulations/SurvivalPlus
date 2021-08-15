package net.coolsimulations.SurvivalPlus.core.init;

import com.google.common.collect.ImmutableList;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystalBudding;
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
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusGeodes {
	
	public static void init() {

		SPBlocks.ruby_block = new AmethystBlock(Properties.of(Material.AMETHYST, MaterialColor.COLOR_RED).strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).requiresCorrectToolForDrops()).setRegistryName("ruby_block");
		SPBlocks.ruby_cluster = new AmethystClusterBlock(7, 3, Properties.of(Material.AMETHYST, MaterialColor.COLOR_RED).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel((blockState) -> 5)).setRegistryName("ruby_cluster");
		SPBlocks.large_ruby_bud = new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(SPBlocks.ruby_cluster).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((blockState) -> 4)).setRegistryName("large_ruby_bud");
		SPBlocks.medium_ruby_bud = new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(SPBlocks.ruby_cluster).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((blockState) -> 2)).setRegistryName("medium_ruby_bud");
		SPBlocks.small_ruby_bud = new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(SPBlocks.ruby_cluster).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((blockState) -> 1)).setRegistryName("small_ruby_bud");
		SPBlocks.budding_ruby = new SPBlockCrystalBudding(Properties.of(Material.AMETHYST, MaterialColor.COLOR_RED).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
				ImmutableList.of(((AmethystClusterBlock) SPBlocks.small_ruby_bud), ((AmethystClusterBlock) SPBlocks.medium_ruby_bud), ((AmethystClusterBlock) SPBlocks.large_ruby_bud), ((AmethystClusterBlock) SPBlocks.ruby_cluster))
				).setRegistryName("budding_ruby");
		SPBlocks.pearl_block = new AmethystBlock(Properties.of(Material.AMETHYST, MaterialColor.SNOW).strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).requiresCorrectToolForDrops()).setRegistryName("pearl_block");
		SPBlocks.pearl_cluster = new AmethystClusterBlock(7, 3, Properties.of(Material.AMETHYST, MaterialColor.SNOW).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel((blockState) -> 5)).setRegistryName("pearl_cluster");
		SPBlocks.large_pearl_bud = new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(SPBlocks.pearl_cluster).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((blockState) -> 4)).setRegistryName("large_pearl_bud");
		SPBlocks.medium_pearl_bud = new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(SPBlocks.pearl_cluster).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((blockState) -> 2)).setRegistryName("medium_pearl_bud");
		SPBlocks.small_pearl_bud = new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(SPBlocks.pearl_cluster).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((blockState) -> 1)).setRegistryName("small_pearl_bud");
		SPBlocks.budding_pearl = new SPBlockCrystalBudding(Properties.of(Material.AMETHYST, MaterialColor.SNOW).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
				ImmutableList.of(((AmethystClusterBlock) SPBlocks.small_pearl_bud), ((AmethystClusterBlock) SPBlocks.medium_pearl_bud), ((AmethystClusterBlock) SPBlocks.large_pearl_bud), ((AmethystClusterBlock) SPBlocks.pearl_cluster))
				).setRegistryName("budding_pearl");
		SPBlocks.topaz_block = new AmethystBlock(Properties.of(Material.AMETHYST, MaterialColor.COLOR_YELLOW).strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).requiresCorrectToolForDrops()).setRegistryName("topaz_block");
		SPBlocks.topaz_cluster = new AmethystClusterBlock(7, 3, Properties.of(Material.AMETHYST, MaterialColor.COLOR_YELLOW).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel((blockState) -> 5)).setRegistryName("topaz_cluster");
		SPBlocks.large_topaz_bud = new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(SPBlocks.topaz_cluster).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((blockState) -> 4)).setRegistryName("large_topaz_bud");
		SPBlocks.medium_topaz_bud = new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(SPBlocks.topaz_cluster).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((blockState) -> 2)).setRegistryName("medium_topaz_bud");
		SPBlocks.small_topaz_bud = new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(SPBlocks.topaz_cluster).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((blockState) -> 1)).setRegistryName("small_topaz_bud");
		SPBlocks.budding_topaz = new SPBlockCrystalBudding(Properties.of(Material.AMETHYST, MaterialColor.COLOR_YELLOW).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
				ImmutableList.of(((AmethystClusterBlock) SPBlocks.small_topaz_bud), ((AmethystClusterBlock) SPBlocks.medium_topaz_bud), ((AmethystClusterBlock) SPBlocks.large_topaz_bud), ((AmethystClusterBlock) SPBlocks.topaz_cluster))
				).setRegistryName("budding_topaz");
		SPBlocks.sapphire_block = new AmethystBlock(Properties.of(Material.AMETHYST, MaterialColor.COLOR_BLUE).strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).requiresCorrectToolForDrops()).setRegistryName("sapphire_block");
		SPBlocks.sapphire_cluster = new AmethystClusterBlock(7, 3, Properties.of(Material.AMETHYST, MaterialColor.COLOR_BLUE).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel((blockState) -> 5)).setRegistryName("sapphire_cluster");
		SPBlocks.large_sapphire_bud = new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(SPBlocks.sapphire_cluster).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((blockState) -> 4)).setRegistryName("large_sapphire_bud");
		SPBlocks.medium_sapphire_bud = new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(SPBlocks.sapphire_cluster).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((blockState) -> 2)).setRegistryName("medium_sapphire_bud");
		SPBlocks.small_sapphire_bud = new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(SPBlocks.sapphire_cluster).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((blockState) -> 1)).setRegistryName("small_sapphire_bud");
		SPBlocks.budding_sapphire = new SPBlockCrystalBudding(Properties.of(Material.AMETHYST, MaterialColor.COLOR_BLUE).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
				ImmutableList.of(((AmethystClusterBlock) SPBlocks.small_sapphire_bud), ((AmethystClusterBlock) SPBlocks.medium_sapphire_bud), ((AmethystClusterBlock) SPBlocks.large_sapphire_bud), ((AmethystClusterBlock) SPBlocks.sapphire_cluster))
				).setRegistryName("budding_sapphire");
		SPBlocks.spinel_block = new AmethystBlock(Properties.of(Material.AMETHYST, MaterialColor.COLOR_BLACK).strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).requiresCorrectToolForDrops()).setRegistryName("spinel_block");
		SPBlocks.spinel_cluster = new AmethystClusterBlock(7, 3, Properties.of(Material.AMETHYST, MaterialColor.COLOR_BLACK).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel((blockState) -> 5)).setRegistryName("spinel_cluster");
		SPBlocks.large_spinel_bud = new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(SPBlocks.spinel_cluster).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((blockState) -> 4)).setRegistryName("large_spinel_bud");
		SPBlocks.medium_spinel_bud = new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(SPBlocks.spinel_cluster).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((blockState) -> 2)).setRegistryName("medium_spinel_bud");
		SPBlocks.small_spinel_bud = new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(SPBlocks.spinel_cluster).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((blockState) -> 1)).setRegistryName("small_spinel_bud");
		SPBlocks.budding_spinel = new SPBlockCrystalBudding(Properties.of(Material.AMETHYST, MaterialColor.COLOR_BLACK).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops(),
				ImmutableList.of(((AmethystClusterBlock) SPBlocks.small_spinel_bud), ((AmethystClusterBlock) SPBlocks.medium_spinel_bud), ((AmethystClusterBlock) SPBlocks.large_spinel_bud), ((AmethystClusterBlock) SPBlocks.spinel_cluster))
				).setRegistryName("budding_spinel");

		SPItems.ruby_shard = new Item(new Item.Properties().tab(SPTabs.tabMaterials)).setRegistryName("ruby_shard");
		SPItems.pearl = new Item(new Item.Properties().tab(SPTabs.tabMaterials)).setRegistryName("pearl");
		SPItems.topaz_shard = new Item(new Item.Properties().tab(SPTabs.tabMaterials)).setRegistryName("topaz_shard");
		SPItems.sapphire_shard = new Item(new Item.Properties().tab(SPTabs.tabMaterials)).setRegistryName("sapphire_shard");
		SPItems.spinel_shard = new Item(new Item.Properties().tab(SPTabs.tabMaterials)).setRegistryName("spinel_shard");
	}

	public static void register() {

		registerBlock(SPBlocks.ruby_block);
		registerBlock(SPBlocks.ruby_cluster);
		registerBlock(SPBlocks.large_ruby_bud);
		registerBlock(SPBlocks.medium_ruby_bud);
		registerBlock(SPBlocks.small_ruby_bud);
		registerBlock(SPBlocks.budding_ruby);
		registerBlock(SPBlocks.pearl_block);
		registerBlock(SPBlocks.pearl_cluster);
		registerBlock(SPBlocks.large_pearl_bud);
		registerBlock(SPBlocks.medium_pearl_bud);
		registerBlock(SPBlocks.small_pearl_bud);
		registerBlock(SPBlocks.budding_pearl);
		registerBlock(SPBlocks.topaz_block);
		registerBlock(SPBlocks.topaz_cluster);
		registerBlock(SPBlocks.large_topaz_bud);
		registerBlock(SPBlocks.medium_topaz_bud);
		registerBlock(SPBlocks.small_topaz_bud);
		registerBlock(SPBlocks.budding_topaz);
		registerBlock(SPBlocks.sapphire_block);
		registerBlock(SPBlocks.sapphire_cluster);
		registerBlock(SPBlocks.large_sapphire_bud);
		registerBlock(SPBlocks.medium_sapphire_bud);
		registerBlock(SPBlocks.small_sapphire_bud);
		registerBlock(SPBlocks.budding_sapphire);
		registerBlock(SPBlocks.spinel_block);
		registerBlock(SPBlocks.spinel_cluster);
		registerBlock(SPBlocks.large_spinel_bud);
		registerBlock(SPBlocks.medium_spinel_bud);
		registerBlock(SPBlocks.small_spinel_bud);
		registerBlock(SPBlocks.budding_spinel);

		registerItem(SPItems.ruby_shard);
		registerItem(SPItems.pearl);
		registerItem(SPItems.topaz_shard);
		registerItem(SPItems.sapphire_shard);
		registerItem(SPItems.spinel_shard);
	}

	public static void registerFeature(BiomeGenerationSettingsBuilder gen, Biome.BiomeCategory category) {

		if (category == BiomeCategory.NETHER) {
			if(!SPConfig.disableRubyGen.get()) {
				gen.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, Feature.GEODE.configured(new GeodeConfiguration(new GeodeBlockSettings(new SimpleStateProvider(Blocks.AIR.defaultBlockState()), new SimpleStateProvider(SPBlocks.ruby_block.defaultBlockState()), new SimpleStateProvider(SPBlocks.budding_ruby.defaultBlockState()), new SimpleStateProvider(Blocks.CALCITE.defaultBlockState()), new SimpleStateProvider(Blocks.MAGMA_BLOCK.defaultBlockState()), ((SPBlockCrystalBudding) SPBlocks.budding_ruby).getStates(), BlockTags.FEATURES_CANNOT_REPLACE.getName(), BlockTags.GEODE_INVALID_BLOCKS.getName()), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.top()).squared().rarity(53));
			}
			if(!SPConfig.disableTopazGen.get()) {
				gen.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, Feature.GEODE.configured(new GeodeConfiguration(new GeodeBlockSettings(new SimpleStateProvider(Blocks.AIR.defaultBlockState()), new SimpleStateProvider(SPBlocks.topaz_block.defaultBlockState()), new SimpleStateProvider(SPBlocks.budding_topaz.defaultBlockState()), new SimpleStateProvider(Blocks.CALCITE.defaultBlockState()), new SimpleStateProvider(Blocks.MAGMA_BLOCK.defaultBlockState()), ((SPBlockCrystalBudding) SPBlocks.budding_topaz).getStates(), BlockTags.FEATURES_CANNOT_REPLACE.getName(), BlockTags.GEODE_INVALID_BLOCKS.getName()), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.top()).squared().rarity(53));
			}
			if(!SPConfig.disableSapphireGen.get()) {
				gen.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, Feature.GEODE.configured(new GeodeConfiguration(new GeodeBlockSettings(new SimpleStateProvider(Blocks.AIR.defaultBlockState()), new SimpleStateProvider(SPBlocks.sapphire_block.defaultBlockState()), new SimpleStateProvider(SPBlocks.budding_sapphire.defaultBlockState()), new SimpleStateProvider(Blocks.CALCITE.defaultBlockState()), new SimpleStateProvider(Blocks.MAGMA_BLOCK.defaultBlockState()), ((SPBlockCrystalBudding) SPBlocks.budding_sapphire).getStates(), BlockTags.FEATURES_CANNOT_REPLACE.getName(), BlockTags.GEODE_INVALID_BLOCKS.getName()), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.top()).squared().rarity(53));
			}
		} else if (category != BiomeCategory.THEEND) {

			if(category == BiomeCategory.OCEAN && !SPConfig.disablePearlGen.get()) {
				gen.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, Feature.GEODE.configured(new GeodeConfiguration(new GeodeBlockSettings(new SimpleStateProvider(Blocks.WATER.defaultBlockState()), new SimpleStateProvider(SPBlocks.pearl_block.defaultBlockState()), new SimpleStateProvider(SPBlocks.budding_pearl.defaultBlockState()), new SimpleStateProvider(Blocks.CALCITE.defaultBlockState()), new SimpleStateProvider(Blocks.SMOOTH_BASALT.defaultBlockState()), ImmutableList.of(((SPBlockCrystalBudding) SPBlocks.budding_pearl).getStates().get(0).setValue(BlockStateProperties.WATERLOGGED, true), ((SPBlockCrystalBudding) SPBlocks.budding_pearl).getStates().get(1).setValue(BlockStateProperties.WATERLOGGED, true), ((SPBlockCrystalBudding) SPBlocks.budding_pearl).getStates().get(2).setValue(BlockStateProperties.WATERLOGGED, true), ((SPBlockCrystalBudding) SPBlocks.budding_pearl).getStates().get(3).setValue(BlockStateProperties.WATERLOGGED, true)), BlockTags.FEATURES_CANNOT_REPLACE.getName(), BlockTags.GEODE_INVALID_BLOCKS.getName()), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(63)).squared().rarity(53));
			}

			if(category == BiomeCategory.MUSHROOM && !SPConfig.disableSpinelGen.get()) {
				gen.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, Feature.GEODE.configured(new GeodeConfiguration(new GeodeBlockSettings(new SimpleStateProvider(Blocks.AIR.defaultBlockState()), new SimpleStateProvider(SPBlocks.spinel_block.defaultBlockState()), new SimpleStateProvider(SPBlocks.budding_spinel.defaultBlockState()), new SimpleStateProvider(Blocks.CALCITE.defaultBlockState()), new SimpleStateProvider(Blocks.SMOOTH_BASALT.defaultBlockState()), ((SPBlockCrystalBudding) SPBlocks.budding_spinel).getStates(), BlockTags.FEATURES_CANNOT_REPLACE.getName(), BlockTags.GEODE_INVALID_BLOCKS.getName()), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(16)).squared().rarity(53));
			}
		}
	}

	private static void registerBlock(Block block) {

		BlockItem baseBlockItem = new BlockItem(block, new Item.Properties().tab(SPTabs.tabGem));
		baseBlockItem.setRegistryName(block.getRegistryName());

		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(baseBlockItem);
	}

	private static void registerItem(Item item) {
		ForgeRegistries.ITEMS.register(item);
	}

}
