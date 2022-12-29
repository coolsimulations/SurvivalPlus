package net.coolsimulations.SurvivalPlus.core.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.jetbrains.annotations.NotNull;

import com.google.common.collect.ImmutableList;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystalBudding;
import net.coolsimulations.SurvivalPlus.api.world.SPGeodeFeature;
import net.coolsimulations.SurvivalPlus.core.mixin.AllayAccessor;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class SurvivalPlusGeodes {

	public static void init() {

		SPBlocks.ruby_block = new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST, MaterialColor.COLOR_RED).strength(1.5F).sounds(SoundType.AMETHYST_CLUSTER).requiresTool());
		SPBlocks.ruby_cluster = new AmethystClusterBlock(7, 3, FabricBlockSettings.of(Material.AMETHYST, MaterialColor.COLOR_RED).nonOpaque().ticksRandomly().sounds(SoundType.AMETHYST_CLUSTER).strength(1.5f).luminance((blockState) -> 5));
		SPBlocks.large_ruby_bud = new AmethystClusterBlock(5, 3, FabricBlockSettings.copyOf(SPBlocks.ruby_cluster).sounds(SoundType.LARGE_AMETHYST_BUD).luminance((blockState) -> 4));
		SPBlocks.medium_ruby_bud = new AmethystClusterBlock(4, 3, FabricBlockSettings.copyOf(SPBlocks.ruby_cluster).sounds(SoundType.MEDIUM_AMETHYST_BUD).luminance((blockState) -> 2));
		SPBlocks.small_ruby_bud = new AmethystClusterBlock(3, 4, FabricBlockSettings.copyOf(SPBlocks.ruby_cluster).sounds(SoundType.SMALL_AMETHYST_BUD).luminance((blockState) -> 1));
		SPBlocks.budding_ruby = new SPBlockCrystalBudding(FabricBlockSettings.of(Material.AMETHYST, MaterialColor.COLOR_RED).ticksRandomly().strength(1.5F).sounds(SoundType.AMETHYST).requiresTool(),
				ImmutableList.of(((AmethystClusterBlock) SPBlocks.small_ruby_bud), ((AmethystClusterBlock) SPBlocks.medium_ruby_bud), ((AmethystClusterBlock) SPBlocks.large_ruby_bud), ((AmethystClusterBlock) SPBlocks.ruby_cluster))
				);
		SPBlocks.pearl_block = new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST, MaterialColor.SNOW).strength(1.5F).sounds(SoundType.AMETHYST_CLUSTER).requiresTool());
		SPBlocks.pearl_cluster = new AmethystClusterBlock(7, 3, FabricBlockSettings.of(Material.AMETHYST, MaterialColor.SNOW).nonOpaque().ticksRandomly().sounds(SoundType.AMETHYST_CLUSTER).strength(1.5f).luminance((blockState) -> 5));
		SPBlocks.large_pearl_bud = new AmethystClusterBlock(5, 3, FabricBlockSettings.copyOf(SPBlocks.pearl_cluster).sounds(SoundType.LARGE_AMETHYST_BUD).luminance((blockState) -> 4));
		SPBlocks.medium_pearl_bud = new AmethystClusterBlock(4, 3, FabricBlockSettings.copyOf(SPBlocks.pearl_cluster).sounds(SoundType.MEDIUM_AMETHYST_BUD).luminance((blockState) -> 2));
		SPBlocks.small_pearl_bud = new AmethystClusterBlock(3, 4, FabricBlockSettings.copyOf(SPBlocks.pearl_cluster).sounds(SoundType.SMALL_AMETHYST_BUD).luminance((blockState) -> 1));
		SPBlocks.budding_pearl = new SPBlockCrystalBudding(FabricBlockSettings.of(Material.AMETHYST, MaterialColor.SNOW).ticksRandomly().strength(1.5F).sounds(SoundType.AMETHYST).requiresTool(),
				ImmutableList.of(((AmethystClusterBlock) SPBlocks.small_pearl_bud), ((AmethystClusterBlock) SPBlocks.medium_pearl_bud), ((AmethystClusterBlock) SPBlocks.large_pearl_bud), ((AmethystClusterBlock) SPBlocks.pearl_cluster))
				);
		SPBlocks.topaz_block = new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST, MaterialColor.COLOR_YELLOW).strength(1.5F).sounds(SoundType.AMETHYST_CLUSTER).requiresTool());
		SPBlocks.topaz_cluster = new AmethystClusterBlock(7, 3, FabricBlockSettings.of(Material.AMETHYST, MaterialColor.COLOR_YELLOW).nonOpaque().ticksRandomly().sounds(SoundType.AMETHYST_CLUSTER).strength(1.5f).luminance((blockState) -> 5));
		SPBlocks.large_topaz_bud = new AmethystClusterBlock(5, 3, FabricBlockSettings.copyOf(SPBlocks.topaz_cluster).sounds(SoundType.LARGE_AMETHYST_BUD).luminance((blockState) -> 4));
		SPBlocks.medium_topaz_bud = new AmethystClusterBlock(4, 3, FabricBlockSettings.copyOf(SPBlocks.topaz_cluster).sounds(SoundType.MEDIUM_AMETHYST_BUD).luminance((blockState) -> 2));
		SPBlocks.small_topaz_bud = new AmethystClusterBlock(3, 4, FabricBlockSettings.copyOf(SPBlocks.topaz_cluster).sounds(SoundType.SMALL_AMETHYST_BUD).luminance((blockState) -> 1));
		SPBlocks.budding_topaz = new SPBlockCrystalBudding(FabricBlockSettings.of(Material.AMETHYST, MaterialColor.COLOR_YELLOW).ticksRandomly().strength(1.5F).sounds(SoundType.AMETHYST).requiresTool(),
				ImmutableList.of(((AmethystClusterBlock) SPBlocks.small_topaz_bud), ((AmethystClusterBlock) SPBlocks.medium_topaz_bud), ((AmethystClusterBlock) SPBlocks.large_topaz_bud), ((AmethystClusterBlock) SPBlocks.topaz_cluster))
				);
		SPBlocks.sapphire_block = new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST, MaterialColor.COLOR_BLUE).strength(1.5F).sounds(SoundType.AMETHYST_CLUSTER).requiresTool());
		SPBlocks.sapphire_cluster = new AmethystClusterBlock(7, 3, FabricBlockSettings.of(Material.AMETHYST, MaterialColor.COLOR_BLUE).nonOpaque().ticksRandomly().sounds(SoundType.AMETHYST_CLUSTER).strength(1.5f).luminance((blockState) -> 5));
		SPBlocks.large_sapphire_bud = new AmethystClusterBlock(5, 3, FabricBlockSettings.copyOf(SPBlocks.sapphire_cluster).sounds(SoundType.LARGE_AMETHYST_BUD).luminance((blockState) -> 4));
		SPBlocks.medium_sapphire_bud = new AmethystClusterBlock(4, 3, FabricBlockSettings.copyOf(SPBlocks.sapphire_cluster).sounds(SoundType.MEDIUM_AMETHYST_BUD).luminance((blockState) -> 2));
		SPBlocks.small_sapphire_bud = new AmethystClusterBlock(3, 4, FabricBlockSettings.copyOf(SPBlocks.sapphire_cluster).sounds(SoundType.SMALL_AMETHYST_BUD).luminance((blockState) -> 1));
		SPBlocks.budding_sapphire = new SPBlockCrystalBudding(FabricBlockSettings.of(Material.AMETHYST, MaterialColor.COLOR_BLUE).ticksRandomly().strength(1.5F).sounds(SoundType.AMETHYST).requiresTool(),
				ImmutableList.of(((AmethystClusterBlock) SPBlocks.small_sapphire_bud), ((AmethystClusterBlock) SPBlocks.medium_sapphire_bud), ((AmethystClusterBlock) SPBlocks.large_sapphire_bud), ((AmethystClusterBlock) SPBlocks.sapphire_cluster))
				);
		SPBlocks.spinel_block = new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST, MaterialColor.COLOR_BLACK).strength(1.5F).sounds(SoundType.AMETHYST_CLUSTER).requiresTool());
		SPBlocks.spinel_cluster = new AmethystClusterBlock(7, 3, FabricBlockSettings.of(Material.AMETHYST, MaterialColor.COLOR_BLACK).nonOpaque().ticksRandomly().sounds(SoundType.AMETHYST_CLUSTER).strength(1.5f).luminance((blockState) -> 5));
		SPBlocks.large_spinel_bud = new AmethystClusterBlock(5, 3, FabricBlockSettings.copyOf(SPBlocks.spinel_cluster).sounds(SoundType.LARGE_AMETHYST_BUD).luminance((blockState) -> 4));
		SPBlocks.medium_spinel_bud = new AmethystClusterBlock(4, 3, FabricBlockSettings.copyOf(SPBlocks.spinel_cluster).sounds(SoundType.MEDIUM_AMETHYST_BUD).luminance((blockState) -> 2));
		SPBlocks.small_spinel_bud = new AmethystClusterBlock(3, 4, FabricBlockSettings.copyOf(SPBlocks.spinel_cluster).sounds(SoundType.SMALL_AMETHYST_BUD).luminance((blockState) -> 1));
		SPBlocks.budding_spinel = new SPBlockCrystalBudding(FabricBlockSettings.of(Material.AMETHYST, MaterialColor.COLOR_BLACK).ticksRandomly().strength(1.5F).sounds(SoundType.AMETHYST).requiresTool(),
				ImmutableList.of(((AmethystClusterBlock) SPBlocks.small_spinel_bud), ((AmethystClusterBlock) SPBlocks.medium_spinel_bud), ((AmethystClusterBlock) SPBlocks.large_spinel_bud), ((AmethystClusterBlock) SPBlocks.spinel_cluster))
				);

		SPItems.ruby_shard = new Item(new FabricItemSettings());
		SPItems.pearl = new Item(new FabricItemSettings());
		SPItems.topaz_shard = new Item(new FabricItemSettings());
		SPItems.sapphire_shard = new Item(new FabricItemSettings());
		SPItems.spinel_shard = new Item(new FabricItemSettings());
		
		List<ItemStack> shards = new ArrayList<ItemStack>(Arrays.asList(AllayAccessor.getDupeItem().getItems()));
		shards.add(new ItemStack(SPItems.ruby_shard));
		shards.add(new ItemStack(SPItems.pearl));
		shards.add(new ItemStack(SPItems.topaz_shard));
		shards.add(new ItemStack(SPItems.sapphire_shard));
		shards.add(new ItemStack(SPItems.spinel_shard));
		AllayAccessor.setDupeItem(Ingredient.of(shards.toArray(new ItemStack[] {})));
	}

	public static void register() {

		registerBlock(SPBlocks.ruby_block, "ruby_block");
		registerBlock(SPBlocks.ruby_cluster, "ruby_cluster");
		registerBlock(SPBlocks.large_ruby_bud, "large_ruby_bud");
		registerBlock(SPBlocks.medium_ruby_bud, "medium_ruby_bud");
		registerBlock(SPBlocks.small_ruby_bud, "small_ruby_bud");
		registerBlock(SPBlocks.budding_ruby, "budding_ruby");
		registerBlock(SPBlocks.pearl_block, "pearl_block");
		registerBlock(SPBlocks.pearl_cluster, "pearl_cluster");
		registerBlock(SPBlocks.large_pearl_bud, "large_pearl_bud");
		registerBlock(SPBlocks.medium_pearl_bud, "medium_pearl_bud");
		registerBlock(SPBlocks.small_pearl_bud, "small_pearl_bud");
		registerBlock(SPBlocks.budding_pearl, "budding_pearl");
		registerBlock(SPBlocks.topaz_block, "topaz_block");
		registerBlock(SPBlocks.topaz_cluster, "topaz_cluster");
		registerBlock(SPBlocks.large_topaz_bud, "large_topaz_bud");
		registerBlock(SPBlocks.medium_topaz_bud, "medium_topaz_bud");
		registerBlock(SPBlocks.small_topaz_bud, "small_topaz_bud");
		registerBlock(SPBlocks.budding_topaz, "budding_topaz");
		registerBlock(SPBlocks.sapphire_block, "sapphire_block");
		registerBlock(SPBlocks.sapphire_cluster, "sapphire_cluster");
		registerBlock(SPBlocks.large_sapphire_bud, "large_sapphire_bud");
		registerBlock(SPBlocks.medium_sapphire_bud, "medium_sapphire_bud");
		registerBlock(SPBlocks.small_sapphire_bud, "small_sapphire_bud");
		registerBlock(SPBlocks.budding_sapphire, "budding_sapphire");
		registerBlock(SPBlocks.spinel_block, "spinel_block");
		registerBlock(SPBlocks.spinel_cluster, "spinel_cluster");
		registerBlock(SPBlocks.large_spinel_bud, "large_spinel_bud");
		registerBlock(SPBlocks.medium_spinel_bud, "medium_spinel_bud");
		registerBlock(SPBlocks.small_spinel_bud, "small_spinel_bud");
		registerBlock(SPBlocks.budding_spinel, "budding_spinel");

		registerItem(SPItems.ruby_shard, "ruby_shard");
		registerItem(SPItems.pearl, "pearl");
		registerItem(SPItems.topaz_shard, "topaz_shard");
		registerItem(SPItems.sapphire_shard, "sapphire_shard");
		registerItem(SPItems.spinel_shard, "spinel_shard");

		if(!SPConfig.disableRubyGen) {
			registerFeatures(SPBlocks.ruby_block, SPBlocks.budding_ruby, Blocks.CALCITE, Blocks.MAGMA_BLOCK, "ruby_geode", BiomeSelectors.foundInTheNether(), VerticalAnchor.bottom(), VerticalAnchor.top(), 24);
		}
		if(!SPConfig.disablePearlGen) {
			registerFeatures(SPBlocks.pearl_block, SPBlocks.budding_pearl, Blocks.CALCITE, Blocks.SMOOTH_BASALT, true, "pearl_geode", BiomeSelectors.tag(BiomeTags.IS_OCEAN), VerticalAnchor.aboveBottom(64), VerticalAnchor.absolute(63), 24);
		}
		if(!SPConfig.disableTopazGen) {
			registerFeatures(SPBlocks.topaz_block, SPBlocks.budding_topaz, Blocks.CALCITE, Blocks.MAGMA_BLOCK, "topaz_geode", BiomeSelectors.foundInTheNether(), VerticalAnchor.bottom(), VerticalAnchor.top(), 24);
		}
		if(!SPConfig.disableSapphireGen) {
			registerFeatures(SPBlocks.sapphire_block, SPBlocks.budding_sapphire, Blocks.CALCITE, Blocks.MAGMA_BLOCK, "sapphire_geode", BiomeSelectors.foundInTheNether(), VerticalAnchor.bottom(), VerticalAnchor.top(), 24);
		}
		
		if(!SPConfig.disableSpinelGen) {
			registerFeatures(SPBlocks.spinel_block, SPBlocks.budding_spinel, Blocks.CALCITE, Blocks.SMOOTH_BASALT, "spinel_geode", BiomeSelectors.includeByKey(Biomes.MUSHROOM_FIELDS), VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64), 24);
		}
	}
	
	public static void registerFeatures(Block baseBlock, Block buddingBlock, Block calciteBlock, Block outerBlock, String geodeFeatureRegistryName, Predicate<BiomeSelectionContext> category, VerticalAnchor bottom, VerticalAnchor top, int rarity) {
		registerFeatures(baseBlock, buddingBlock, calciteBlock, outerBlock, false, geodeFeatureRegistryName, category, bottom, top, rarity);
	}

	public static void registerFeatures(Block baseBlock, Block buddingBlock, Block calciteBlock, Block outerBlock, boolean waterLogged, String geodeFeatureRegistryName, Predicate<BiomeSelectionContext> category, VerticalAnchor bottom, VerticalAnchor top, int rarity) {
		ResourceLocation location = new ResourceLocation(SPReference.MOD_ID, geodeFeatureRegistryName);
		
		SPGeodeFeature geodeFeature = new SPGeodeFeature((@NotNull SPBlockCrystalBudding) buddingBlock, baseBlock, calciteBlock, outerBlock, waterLogged);
		Registry.register(BuiltInRegistries.FEATURE, location, geodeFeature);

		BiomeModifications.addFeature(category, GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, location));
	}

	private static void registerBlock(Block block, String registryName) {

		BlockItem baseBlockItem = new BlockItem(block, new FabricItemSettings());

		Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(SPReference.MOD_ID, registryName), block);
		Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(SPReference.MOD_ID, registryName), baseBlockItem);
	}

	private static void registerItem(Item item, String registryName) {
		Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(SPReference.MOD_ID, registryName), item);
	}

}
