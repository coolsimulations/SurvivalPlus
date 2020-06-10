package net.coolsimulations.SurvivalPlus.core.util;

/**import jeresources.api.IJERAPI;
import jeresources.api.JERPlugin;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.drop.LootDrop;
import jeresources.api.drop.PlantDrop;
import jeresources.api.restrictions.BiomeRestriction;
import jeresources.api.restrictions.DimensionRestriction;
import jeresources.api.restrictions.Restriction;**/
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.ItemStack;

public class SurvivalPlusJER {
	
	/**@JERPlugin
	public static IJERAPI jerAPI;**/

	public static void init() {
		registerOres();
		registerSPPlants();
	}
	
	private static void registerOres() {
		/**jerAPI.getWorldGenRegistry().register(new ItemStack(SPBlocks.copper_ore), new DistributionSquare(40, 8, 1, 54), new LootDrop[0]);
		jerAPI.getWorldGenRegistry().register(new ItemStack(SPBlocks.tin_ore), new DistributionSquare(40, 8, 1, 54), new LootDrop[0]);
		jerAPI.getWorldGenRegistry().register(new ItemStack(SPBlocks.titanium_ore), new DistributionSquare(10, 4, 1, 25), new LootDrop[0]);
		
		jerAPI.getWorldGenRegistry().register(new ItemStack(SPBlocks.pearl), new DistributionSquare(10, 3, 20, 63), new Restriction(BiomeRestriction.OCEAN), new LootDrop[0]);
		jerAPI.getWorldGenRegistry().register(new ItemStack(SPBlocks.spinel), new DistributionSquare(5, 3, 1, 8), new Restriction(BiomeRestriction.MUSHROOM), new LootDrop[0]);
		
		jerAPI.getWorldGenRegistry().register(new ItemStack(SPBlocks.amethyst), new DistributionSquare(20, 3, 1, 255), new Restriction(DimensionRestriction.NETHER), new LootDrop[0]);
		jerAPI.getWorldGenRegistry().register(new ItemStack(SPBlocks.ruby), new DistributionSquare(20, 3, 1, 255), new Restriction(DimensionRestriction.NETHER), new LootDrop[0]);
		jerAPI.getWorldGenRegistry().register(new ItemStack(SPBlocks.topaz), new DistributionSquare(20, 3, 1, 255), new Restriction(DimensionRestriction.NETHER), new LootDrop[0]);
		jerAPI.getWorldGenRegistry().register(new ItemStack(SPBlocks.sapphire), new DistributionSquare(20, 3, 1, 255), new Restriction(DimensionRestriction.NETHER), new LootDrop[0]);**/
	}
	
	private static void registerSPPlants() {
		/**BlockNamedItem onionPlant = (BlockNamedItem) SPItems.onion_seeds;
		PlantDrop onion = new PlantDrop(new ItemStack(SPItems.raw_onion), 1, 1);
		PlantDrop onionSeeds = new PlantDrop(new ItemStack(SPItems.onion_seeds), 0, 3);
		jerAPI.getPlantRegistry().register(new ItemStack(onionPlant), new PlantDrop[]{onion, onionSeeds});**/
	}

}
