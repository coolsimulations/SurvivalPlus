package net.coolsimulations.SurvivalPlus.core.init;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockCrystalBudding;
import net.coolsimulations.SurvivalPlus.core.world.SurvivalPlusOreGenerator;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraftforge.common.world.BiomeModifier.Phase;

@SuppressWarnings({"unused"})
public class SurvivalPlusGeodes {
	
	public static final DeferredRegister<Block> BLOCKS_GEODE = DeferredRegister.create(ForgeRegistries.BLOCKS, SPReference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS_GEODE = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	
	public static final DeferredRegister<Codec<? extends BiomeModifier>> GEODE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SPReference.MOD_ID);
	
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
	
	private static final RegistryObject<Codec<RubyGeodeModifier>> RUBY_GEODE_MODIFIER = GEODE_SERIALIZERS.register("ruby_geode_modifier", RubyGeodeModifier::makeCodec);
	private static final RegistryObject<Codec<TopazGeodeModifier>> TOPAZ_GEODE_MODIFIER = GEODE_SERIALIZERS.register("topaz_geode_modifier", TopazGeodeModifier::makeCodec);
	private static final RegistryObject<Codec<SapphireGeodeModifier>> SAPPHIRE_GEODE_MODIFIER = GEODE_SERIALIZERS.register("sapphire_geode_modifier", SapphireGeodeModifier::makeCodec);
	private static final RegistryObject<Codec<PearlGeodeModifier>> PEARL_GEODE_MODIFIER = GEODE_SERIALIZERS.register("pearl_geode_modifier", PearlGeodeModifier::makeCodec);
	private static final RegistryObject<Codec<SpinelGeodeModifier>> SPINEL_GEODE_MODIFIER = GEODE_SERIALIZERS.register("spinel_geode_modifier", SpinelGeodeModifier::makeCodec);
	
	public record RubyGeodeModifier(HolderSet<Biome> biomes, Decoration generationStage, HolderSet<PlacedFeature> features)
	implements BiomeModifier
	{
		private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ruby_geode_modifier"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SPReference.MOD_ID);

		@Override
		public void modify(Holder<Biome> biome, Phase phase, Builder builder)
		{
			if(!SPConfig.disableRubyGen.get())
				if (phase == Phase.ADD && this.biomes.contains(biome))
				{
					BiomeGenerationSettingsBuilder generation = builder.getGenerationSettings();
					this.features.forEach(holder -> generation.addFeature(this.generationStage, holder));
				}
		}

		@Override
		public Codec<? extends BiomeModifier> codec()
		{
			return SERIALIZER.get();
		}

		private static Codec<RubyGeodeModifier> makeCodec()
		{
			return RecordCodecBuilder.create(builder -> builder.group(
					Biome.LIST_CODEC.fieldOf("biomes").forGetter(RubyGeodeModifier::biomes),
					Codec.STRING.comapFlatMap(SurvivalPlusOreGenerator::generationStageFromString, Decoration::toString).fieldOf("generation_stage").forGetter(RubyGeodeModifier::generationStage),
					PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(RubyGeodeModifier::features)
					).apply(builder, RubyGeodeModifier::new));
		}
	}
	
	public record TopazGeodeModifier(HolderSet<Biome> biomes, Decoration generationStage, HolderSet<PlacedFeature> features)
	implements BiomeModifier
	{
		private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "topaz_geode_modifier"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SPReference.MOD_ID);

		@Override
		public void modify(Holder<Biome> biome, Phase phase, Builder builder)
		{
			if(!SPConfig.disableTopazGen.get())
				if (phase == Phase.ADD && this.biomes.contains(biome))
				{
					BiomeGenerationSettingsBuilder generation = builder.getGenerationSettings();
					this.features.forEach(holder -> generation.addFeature(this.generationStage, holder));
				}
		}

		@Override
		public Codec<? extends BiomeModifier> codec()
		{
			return SERIALIZER.get();
		}

		private static Codec<TopazGeodeModifier> makeCodec()
		{
			return RecordCodecBuilder.create(builder -> builder.group(
					Biome.LIST_CODEC.fieldOf("biomes").forGetter(TopazGeodeModifier::biomes),
					Codec.STRING.comapFlatMap(SurvivalPlusOreGenerator::generationStageFromString, Decoration::toString).fieldOf("generation_stage").forGetter(TopazGeodeModifier::generationStage),
					PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(TopazGeodeModifier::features)
					).apply(builder, TopazGeodeModifier::new));
		}
	}
	
	public record SapphireGeodeModifier(HolderSet<Biome> biomes, Decoration generationStage, HolderSet<PlacedFeature> features)
	implements BiomeModifier
	{
		private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "sapphire_geode_modifier"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SPReference.MOD_ID);

		@Override
		public void modify(Holder<Biome> biome, Phase phase, Builder builder)
		{
			if(!SPConfig.disableSapphireGen.get())
				if (phase == Phase.ADD && this.biomes.contains(biome))
				{
					BiomeGenerationSettingsBuilder generation = builder.getGenerationSettings();
					this.features.forEach(holder -> generation.addFeature(this.generationStage, holder));
				}
		}

		@Override
		public Codec<? extends BiomeModifier> codec()
		{
			return SERIALIZER.get();
		}

		private static Codec<SapphireGeodeModifier> makeCodec()
		{
			return RecordCodecBuilder.create(builder -> builder.group(
					Biome.LIST_CODEC.fieldOf("biomes").forGetter(SapphireGeodeModifier::biomes),
					Codec.STRING.comapFlatMap(SurvivalPlusOreGenerator::generationStageFromString, Decoration::toString).fieldOf("generation_stage").forGetter(SapphireGeodeModifier::generationStage),
					PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(SapphireGeodeModifier::features)
					).apply(builder, SapphireGeodeModifier::new));
		}
	}
	
	public record PearlGeodeModifier(HolderSet<Biome> biomes, Decoration generationStage, HolderSet<PlacedFeature> features)
	implements BiomeModifier
	{
		private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "pearl_geode_modifier"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SPReference.MOD_ID);

		@Override
		public void modify(Holder<Biome> biome, Phase phase, Builder builder)
		{
			if(!SPConfig.disablePearlGen.get())
				if (phase == Phase.ADD && this.biomes.contains(biome))
				{
					BiomeGenerationSettingsBuilder generation = builder.getGenerationSettings();
					this.features.forEach(holder -> generation.addFeature(this.generationStage, holder));
				}
		}

		@Override
		public Codec<? extends BiomeModifier> codec()
		{
			return SERIALIZER.get();
		}

		private static Codec<PearlGeodeModifier> makeCodec()
		{
			return RecordCodecBuilder.create(builder -> builder.group(
					Biome.LIST_CODEC.fieldOf("biomes").forGetter(PearlGeodeModifier::biomes),
					Codec.STRING.comapFlatMap(SurvivalPlusOreGenerator::generationStageFromString, Decoration::toString).fieldOf("generation_stage").forGetter(PearlGeodeModifier::generationStage),
					PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(PearlGeodeModifier::features)
					).apply(builder, PearlGeodeModifier::new));
		}
	}
	
	public record SpinelGeodeModifier(HolderSet<Biome> biomes, Decoration generationStage, HolderSet<PlacedFeature> features)
	implements BiomeModifier
	{
		private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "spinel_geode_modifier"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SPReference.MOD_ID);

		@Override
		public void modify(Holder<Biome> biome, Phase phase, Builder builder)
		{
			if(!SPConfig.disableSpinelGen.get())
				if (phase == Phase.ADD && this.biomes.contains(biome))
				{
					BiomeGenerationSettingsBuilder generation = builder.getGenerationSettings();
					this.features.forEach(holder -> generation.addFeature(this.generationStage, holder));
				}
		}

		@Override
		public Codec<? extends BiomeModifier> codec()
		{
			return SERIALIZER.get();
		}

		private static Codec<SpinelGeodeModifier> makeCodec()
		{
			return RecordCodecBuilder.create(builder -> builder.group(
					Biome.LIST_CODEC.fieldOf("biomes").forGetter(SpinelGeodeModifier::biomes),
					Codec.STRING.comapFlatMap(SurvivalPlusOreGenerator::generationStageFromString, Decoration::toString).fieldOf("generation_stage").forGetter(SpinelGeodeModifier::generationStage),
					PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(SpinelGeodeModifier::features)
					).apply(builder, SpinelGeodeModifier::new));
		}
	}

}
