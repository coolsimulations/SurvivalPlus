package net.coolsimulations.SurvivalPlus.core.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraftforge.common.world.BiomeModifier.Phase;

@SuppressWarnings({"unused"})
public class SurvivalPlusOreGenerator {

	public static final DeferredRegister<Codec<? extends BiomeModifier>> ORE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SPReference.MOD_ID);

	private static final RegistryObject<Codec<SPTinOreModifier>> TIN_ORE_MODIFIER = ORE_SERIALIZERS.register("tin_ore_modifier", SPTinOreModifier::makeCodec);
	private static final RegistryObject<Codec<SPTinOreLargeModifier>> TIN_ORE_LARGE_MODIFIER = ORE_SERIALIZERS.register("tin_ore_large_modifier", SPTinOreLargeModifier::makeCodec);
	private static final RegistryObject<Codec<SPTitaniumOreModifier>> TITANIUM_ORE_MODIFIER = ORE_SERIALIZERS.register("titanium_ore_modifier", SPTitaniumOreModifier::makeCodec);

	public record SPTinOreModifier(HolderSet<Biome> biomes, HolderSet<Biome> biomesExcluded, Decoration generationStage, HolderSet<PlacedFeature> features)
	implements BiomeModifier
	{
		private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "tin_ore_modifier"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SPReference.MOD_ID);

		@Override
		public void modify(Holder<Biome> biome, Phase phase, Builder builder)
		{
			if(!SPConfig.disableTinOreGen.get())
				if (phase == Phase.ADD && this.biomes.contains(biome) && biome != biomesExcluded)
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

		private static Codec<SPTinOreModifier> makeCodec()
		{
			return RecordCodecBuilder.create(builder -> builder.group(
					Biome.LIST_CODEC.fieldOf("biomes").forGetter(SPTinOreModifier::biomes),
					Biome.LIST_CODEC.fieldOf("biomes_excluded").forGetter(SPTinOreModifier::biomesExcluded),
					Codec.STRING.comapFlatMap(SurvivalPlusOreGenerator::generationStageFromString, Decoration::toString).fieldOf("generation_stage").forGetter(SPTinOreModifier::generationStage),
					PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(SPTinOreModifier::features)
					).apply(builder, SPTinOreModifier::new));
		}
	}
	
	public record SPTinOreLargeModifier(HolderSet<Biome> biomes, Decoration generationStage, HolderSet<PlacedFeature> features)
	implements BiomeModifier
	{
		private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "tin_ore_large_modifier"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SPReference.MOD_ID);

		@Override
		public void modify(Holder<Biome> biome, Phase phase, Builder builder)
		{
			if(!SPConfig.disableTinOreGen.get())
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

		private static Codec<SPTinOreLargeModifier> makeCodec()
		{
			return RecordCodecBuilder.create(builder -> builder.group(
					Biome.LIST_CODEC.fieldOf("biomes").forGetter(SPTinOreLargeModifier::biomes),
					Codec.STRING.comapFlatMap(SurvivalPlusOreGenerator::generationStageFromString, Decoration::toString).fieldOf("generation_stage").forGetter(SPTinOreLargeModifier::generationStage),
					PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(SPTinOreLargeModifier::features)
					).apply(builder, SPTinOreLargeModifier::new));
		}
	}
	
	public record SPTitaniumOreModifier(HolderSet<Biome> biomes, Decoration generationStage, HolderSet<PlacedFeature> features)
	implements BiomeModifier
	{
		private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_ore_modifier"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SPReference.MOD_ID);

		@Override
		public void modify(Holder<Biome> biome, Phase phase, Builder builder)
		{
			if(!SPConfig.disableTitaniumOreGen.get())
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

		private static Codec<SPTitaniumOreModifier> makeCodec()
		{
			return RecordCodecBuilder.create(builder -> builder.group(
					Biome.LIST_CODEC.fieldOf("biomes").forGetter(SPTitaniumOreModifier::biomes),
					Codec.STRING.comapFlatMap(SurvivalPlusOreGenerator::generationStageFromString, Decoration::toString).fieldOf("generation_stage").forGetter(SPTitaniumOreModifier::generationStage),
					PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(SPTitaniumOreModifier::features)
					).apply(builder, SPTitaniumOreModifier::new));
		}
	}
	
	public static DataResult<Decoration> generationStageFromString(String name)
	{
		try
		{
			return DataResult.success(Decoration.valueOf(name));
		}
		catch (Exception e)
		{
			return DataResult.error("Not a decoration stage: " + name);
		}
	}
}

