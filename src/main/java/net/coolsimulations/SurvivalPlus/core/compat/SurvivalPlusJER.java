package net.coolsimulations.SurvivalPlus.core.compat;

import org.jetbrains.annotations.NotNull;

import jeresources.api.IJERAPI;
import jeresources.api.conditionals.Conditional;
import jeresources.api.distributions.DistributionTriangular;
import jeresources.api.drop.LootDrop;
import jeresources.api.drop.PlantDrop;
import jeresources.api.restrictions.BiomeRestriction;
import jeresources.api.restrictions.DimensionRestriction;
import jeresources.api.restrictions.Restriction;
import jeresources.compatibility.api.JERAPI;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;

public class SurvivalPlusJER {
	
	public static void setup() {
		IJERAPI jerAPI = JERAPI.getInstance();
		try {
			registerOres(jerAPI);
		} catch (Exception e) {}
		try {
			registerSPPlants(jerAPI);
		} catch (Exception e) {}
	}
	
	private static void registerOres(@NotNull IJERAPI jerApi) throws IllegalStateException, NoSuchFieldException, NoSuchMethodException, NoClassDefFoundError {
		jerApi.getWorldGenRegistry().register(new ItemStack(SPBlocks.tin_ore.get()), new ItemStack(SPBlocks.deepslate_tin_ore.get()), new DistributionTriangular(16, 8, 46, 66), new Restriction(DimensionRestriction.OVERWORLD), true, new LootDrop(new ItemStack(SPItems.raw_tin.get()), 2, 20, Conditional.affectedByFortune));
		jerApi.getWorldGenRegistry().register(new ItemStack(SPBlocks.tin_ore.get()), new ItemStack(SPBlocks.deepslate_tin_ore.get()), new DistributionTriangular(16, 16, 46, 66), new Restriction(BiomeRestriction.DRIPSTONE_CAVES, DimensionRestriction.OVERWORLD), true, new LootDrop(new ItemStack(SPItems.raw_tin.get()), 2, 20, Conditional.affectedByFortune));
		
		jerApi.getWorldGenRegistry().register(new ItemStack(SPBlocks.titanium_ore.get()), new ItemStack(SPBlocks.deepslate_titanium_ore.get()), new DistributionTriangular(10, 5, -64, 62), new Restriction(DimensionRestriction.OVERWORLD), true, new LootDrop(new ItemStack(SPItems.raw_titanium.get()), 1, 3, Conditional.affectedByFortune));
	}
	
	private static void registerSPPlants(@NotNull IJERAPI jerApi) throws IllegalStateException, NoSuchFieldException, NoSuchMethodException, NoClassDefFoundError {
		ItemNameBlockItem onionPlant = (ItemNameBlockItem) SPItems.onion_seeds.get();
		PlantDrop onion = new PlantDrop(new ItemStack(SPItems.raw_onion.get()), 1, 1);
		PlantDrop onionSeeds = new PlantDrop(new ItemStack(SPItems.onion_seeds.get()), 0, 3);
		jerApi.getPlantRegistry().register(new ItemStack(onionPlant), new PlantDrop[]{onion, onionSeeds});
	}

}