package net.coolsimulations.SurvivalPlus.core.compat;

import java.util.Random;

import com.coliwogg.gemsmod.init.BlockInit;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

import ic2.api.item.IC2Items;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.AsteroidBlocks;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import micdoodle8.mods.galacticraft.planets.venus.VenusBlocks;
import micdoodle8.mods.galacticraft.planets.venus.VenusItems;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.compat.SPCompatRecipeManager;
import net.coolsimulations.SurvivalPlus.api.item.SPItemIngot;
import net.insane96mcp.carbonado.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import scala.reflect.internal.Trees.If;
import techreborn.api.TechRebornAPI;
import thedarkcolour.futuremc.block.villagepillage.CampfireBlock;
import thedarkcolour.futuremc.config.FConfig;
import thedarkcolour.futuremc.recipe.SimpleRecipe;
import thedarkcolour.futuremc.recipe.furnace.BlastFurnaceRecipes;
import thedarkcolour.futuremc.registry.FSounds;

public class SurvivalPlusFutureMC {

	public static void init() {

		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryCampfireRecipe("egg", new ItemStack(SPItems.fried_egg), 600);
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryCampfireRecipe("cropCarrot", new ItemStack(SPItems.roast_carrot), 600);
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryCampfireRecipe("foodCheesebread", new ItemStack(SPItems.melted_cheese_bread), 600);
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryCampfireRecipe("cropApple", new ItemStack(SPItems.baked_apple), 600);
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryCampfireRecipe("cropOnion", new ItemStack(SPItems.fried_onion), 600);

		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_axe), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_hoe), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_pickaxe), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_shears), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_shovel), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_sword), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_helmet), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_chestplate), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_leggings), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_boots), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_axe), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_hoe), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_pickaxe), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_shears), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_shovel), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_sword), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_helmet), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_chestplate), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_leggings), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_boots), new ItemStack(SPItems.titanium_nugget));

		if(SPConfig.enableReplaceSmelting) {

			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("oreCopper", new ItemStack(SPItems.copper_ingot), true);
			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("oreTin", new ItemStack(SPItems.tin_ingot), true);

			if(SPCompatibilityManager.isSimpleGrinderLoaded() || SPCompatibilityManager.isIc2Loaded()) {

				SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("dustCopper", new ItemStack(SPItems.copper_ingot), true);
				SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("dustTin", new ItemStack(SPItems.tin_ingot), true);
			}
		} else {

			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPBlocks.copper_ore), new ItemStack(SPItems.copper_ingot));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPBlocks.tin_ore), new ItemStack(SPItems.tin_ingot));

			if(SPCompatibilityManager.isSimpleGrinderLoaded() && !SPCompatibilityManager.isIc2Loaded()) {

				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.copper_dust), new ItemStack(SPItems.copper_ingot));
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.tin_dust), new ItemStack(SPItems.tin_ingot));
			}
		}

		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPBlocks.titanium_ore), new ItemStack(SPItems.titanium_ingot));

		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("cropOnion", SPCompatRecipeManager.futureRecipeManager.getComposterRarityRare());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("seedOnion", SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodApplebaked", SPCompatRecipeManager.futureRecipeManager.getComposterRarityEpic());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodCheese", SPCompatRecipeManager.futureRecipeManager.getComposterRarityUnCommon());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodFriedonions", SPCompatRecipeManager.futureRecipeManager.getComposterRarityRare());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodRoastcarrot", SPCompatRecipeManager.futureRecipeManager.getComposterRarityEpic());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodApplepie", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodBeefpie", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodChickenpie", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodMuttonpie", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodPorkpie", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodRabbitpie", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodVegetablepie", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodCheesebread", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodMeltedCheesebread", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodCupcake", SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodCheesecupcake", SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodSpongecupcake", SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodCheesecake", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodSpongecake", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());

		if((SPCompatibilityManager.isSimpleGrinderLoaded() || SPCompatibilityManager.isIc2Loaded()) && !SPCompatibilityManager.isTechRebornLoaded()) {

			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_dust), new ItemStack(SPItems.titanium_ingot));
		}

		if(SPCompatibilityManager.isIc2Loaded()) {

			if(SPConfig.enableReplaceSmelting) {

				SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedCopper", new ItemStack(SPItems.copper_ingot), true);
				SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedCopper", new ItemStack(SPItems.copper_ingot), true);
				SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("dustCopper", new ItemStack(SPItems.copper_ingot), true);

				SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedTin", new ItemStack(SPItems.tin_ingot), true);
				SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedTin", new ItemStack(SPItems.tin_ingot), true);
				SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("dustTin", new ItemStack(SPItems.tin_ingot), true);

				SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("dustBronze", new ItemStack(SPItems.bronze_ingot), true);

			}

			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedTitanium", new ItemStack(SPItems.titanium_ingot));
			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedTitanium", new ItemStack(SPItems.titanium_ingot));

			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedGold", new ItemStack(Items.GOLD_INGOT));
			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedGold", new ItemStack(Items.GOLD_INGOT));

			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedIron", new ItemStack(Items.IRON_INGOT));
			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedIron", new ItemStack(Items.IRON_INGOT));

			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedLead", IC2Items.getItem("ingot", "lead"));
			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedLead", IC2Items.getItem("ingot", "lead"));

			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedSilver", IC2Items.getItem("ingot", "silver"));
			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedSilver", IC2Items.getItem("ingot", "silver"));

			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(IC2Items.getItem("dust", "coal_fuel"), IC2Items.getItem("dust", "coal"));

			SPCompatRecipeManager.futureRecipeManager.addCampfireRecipe(IC2Items.getItem("mug", "cold_coffee"), IC2Items.getItem("mug", "dark_coffee"), 600);
			SPCompatRecipeManager.futureRecipeManager.addSmokerRecipe(IC2Items.getItem("mug", "cold_coffee"), IC2Items.getItem("mug", "dark_coffee"));

			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(IC2Items.getItem("sapling"), SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());

			if(SPCompatibilityManager.isGCLoaded()) {
				SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedAluminum", new ItemStack(GCItems.basicItem, 1, 5));
				SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedAluminum", new ItemStack(GCItems.basicItem, 1, 5));
			}
		}

		if(SPCompatibilityManager.isGCLoaded()) {

			SPCompatRecipeManager.futureRecipeManager.addCampfireRecipe(new ItemStack(GCItems.foodItem, 1, 6), new ItemStack(GCItems.foodItem, 1, 7), 600);

			if(SPConfig.enableReplaceSmelting) {

				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.canister, 1, 1), new ItemStack(SPItems.copper_ingot, 3));
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.canister), new ItemStack(SPItems.tin_ingot, 3));
			} else {
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.canister, 1, 1), new ItemStack(GCItems.basicItem, 3, 3));
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.canister), new ItemStack(GCItems.basicItem, 3, 4));
			}

			if(SPCompatibilityManager.isGCPLoaded()) {
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(MarsItems.marsItemBasic), new ItemStack(MarsItems.marsItemBasic, 1, 2));
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(AsteroidsItems.basicItem, 1, 3), new ItemStack(Items.IRON_INGOT));
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(AsteroidsItems.basicItem, 1, 4), new ItemStack(AsteroidsItems.basicItem));
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(MarsBlocks.marsBlock, 1, 2), new ItemStack(MarsItems.marsItemBasic, 1, 2));
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(MarsBlocks.marsBlock, 1, 3), new ItemStack(Items.IRON_INGOT));
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(AsteroidBlocks.blockBasic, 1, 3), new ItemStack(GCItems.basicItem, 1, 5));
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(VenusBlocks.venusBlock, 1, 6), new ItemStack(GCItems.basicItem, 1, 5));
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(VenusBlocks.venusBlock, 1, 9), new ItemStack(Items.QUARTZ));

				if(SPConfig.enableReplaceSmelting && SPCompatibilityManager.isIc2Loaded()) {

					SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(VenusBlocks.venusBlock, 1, 8), IC2Items.getItem("ingot", "lead"));
				} else {

					SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(VenusBlocks.venusBlock, 1, 8), new ItemStack(VenusItems.basicItem, 1, 1));
				}

				if(SPCompatibilityManager.isExtraPlanetsLoaded()) {

					SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ExtraPlanets_Blocks.VOLCANIC_ROCK), new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 12));

					SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 1, 0), SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
					SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 1, 1), SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
					SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 1, 2), SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
					SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 1, 3), SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
					SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 1, 4), SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
					SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 1, 5), SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
				}
			}
		}

		if(SPCompatibilityManager.isCarbonadoLoaded()) {
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ModItems.carbonadoShardItem), new ItemStack(ModItems.carbonadoShardMoltenItem));
		}

		if(SPCompatibilityManager.isForestryLoaded()) {
			Item peat = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "peat"));
			Item ash = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "ash"));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(peat), new ItemStack(ash));
		}

		if(SPCompatibilityManager.isGACLoaded()) {
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(BlockInit.AMETHYST_ORE), new ItemStack(SPBlocks.amethyst));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(BlockInit.RUBY_ORE), new ItemStack(SPBlocks.ruby));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(BlockInit.SAPPHIRE_ORE), new ItemStack(SPBlocks.sapphire));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(BlockInit.TOPAZ_ORE), new ItemStack(SPBlocks.topaz));
		}

		if(SPCompatibilityManager.isTriGemsLoaded()) {
			Item ruby = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "ruby_ore"));
			Item sapphire = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "sapphire_ore"));
			Item topaz = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "topaz_ore"));

			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ruby), new ItemStack(SPBlocks.ruby));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(sapphire), new ItemStack(SPBlocks.sapphire));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(topaz), new ItemStack(SPBlocks.topaz));
		}

		if(SPCompatibilityManager.isBamboozledLoaded()) {
			Item dried_bamboo = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.BAMBOOZLED_MODID, "bamboo_dried"));

			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryCampfireRecipe("cropBamboo", new ItemStack(dried_bamboo), 600);
		}

		if(SPCompatibilityManager.isWeepingAngelsLoaded()) {
			Item ingot = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.WEEPING_ANGELS_MODID, "kontron_ingot"));

			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("oreKontron", new ItemStack(ingot));
		}

		if(SPCompatibilityManager.isRailcraftLoaded()) {

			Item nugget = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "nugget"));
			Item ore_metal_poor = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "ore_metal_poor"));
			Item ore_metal = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "ore_metal"));
			Item ingot = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "ingot"));

			if(!SPConfig.enableReplaceSmelting) {

				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal), new ItemStack(ingot, 1, 1));
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal, 1, 1), new ItemStack(ingot, 1, 2));
			}

			if(SPConfig.enableReplaceSmelting && SPCompatibilityManager.isIc2Loaded()) {

				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal, 1, 2), IC2Items.getItem("ingot", "lead"));
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal, 1, 3), IC2Items.getItem("ingot", "silver"));
			} else {

				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal, 1, 2), new ItemStack(ingot, 1, 3));
				SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal, 1, 3), new ItemStack(ingot, 1, 4));
			}

			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal_poor, 1, 2), new ItemStack(nugget, 3, 1));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal_poor, 1, 3), new ItemStack(nugget, 3, 2));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal_poor, 1, 4), new ItemStack(nugget, 3, 3));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal_poor, 1, 5), new ItemStack(nugget, 3, 4));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal_poor, 1, 6), new ItemStack(nugget, 3, 6));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal_poor, 1, 7), new ItemStack(nugget, 3, 8));

			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal_poor), new ItemStack(Items.IRON_NUGGET, 3));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal_poor, 1, 1), new ItemStack(Items.GOLD_NUGGET, 3));

			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal, 1, 4), new ItemStack(ingot, 1, 6));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ore_metal, 1, 5), new ItemStack(ingot, 1, 8));
		}

		if(SPCompatibilityManager.isGobberLoaded()) {

			Item raw_gobber = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot_raw"));
			Item raw_nether_gobber = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot2_raw"));
			Item raw_end_gobber = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot3_raw"));

			Item ingot_gobber = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot"));
			Item ingot_nether_gobber = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot2"));
			Item ingot_end_gobber = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot3"));

			Item fresh_skull = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "fresh_wither_skull"));

			Item glob_seed = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_seed"));
			Item glob2_seed = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob2_seed"));
			Item glob3_seed = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob3_seed"));

			Item goo = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "goo"));
			Item glob_bread = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_bread"));
			Item glob_apple = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "gapple"));
			Item glob_pie = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_pie"));
			Item glob_cookie = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_cookie"));
			Item glob_chicken = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_chicken"));
			Item glob_beef = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_beef"));
			Item glob_mutton = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_mutton"));
			Item glob_fish = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_fish"));
			Item glob_pork = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_pork"));
			Item glob_rabbit = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_rabbit"));

			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(raw_gobber), new ItemStack(ingot_gobber));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(raw_nether_gobber), new ItemStack(ingot_nether_gobber));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(raw_end_gobber), new ItemStack(ingot_end_gobber));

			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(fresh_skull), new ItemStack(Items.SKULL, 1, 1));

			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(glob_seed), SPCompatRecipeManager.futureRecipeManager.getComposterRarityRare());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(glob2_seed), SPCompatRecipeManager.futureRecipeManager.getComposterRarityEpic());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(glob3_seed), SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());

			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(goo), SPCompatRecipeManager.futureRecipeManager.getComposterRarityRare());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(glob_bread), SPCompatRecipeManager.futureRecipeManager.getComposterRarityRare());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(glob_apple), SPCompatRecipeManager.futureRecipeManager.getComposterRarityRare());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(glob_pie), SPCompatRecipeManager.futureRecipeManager.getComposterRarityEpic());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(glob_cookie), SPCompatRecipeManager.futureRecipeManager.getComposterRarityEpic());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(glob_chicken), SPCompatRecipeManager.futureRecipeManager.getComposterRarityEpic());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(glob_beef), SPCompatRecipeManager.futureRecipeManager.getComposterRarityEpic());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(glob_mutton), SPCompatRecipeManager.futureRecipeManager.getComposterRarityEpic());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(glob_fish), SPCompatRecipeManager.futureRecipeManager.getComposterRarityEpic());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(glob_pork), SPCompatRecipeManager.futureRecipeManager.getComposterRarityEpic());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(glob_rabbit), SPCompatRecipeManager.futureRecipeManager.getComposterRarityEpic());
		}

		if (SPCompatibilityManager.isTechRebornLoaded()) {

			if(SPConfig.enableReplaceSmelting) {

				if (SPCompatibilityManager.isIc2Loaded()) {
					SPCompatRecipeManager.futureRecipeManager.removeBlastFurnaceRecipe(new ItemStack(TechRebornAPI.getItem("INGOTS"), 1, 8));
					SPCompatRecipeManager.futureRecipeManager.removeBlastFurnaceRecipe(new ItemStack(TechRebornAPI.getItem("INGOTS"), 1, 11));
					SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(TechRebornAPI.getBlock("ORE"), 1, 12), IC2Items.getItem("ingot", "lead"));
					SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(TechRebornAPI.getItem("DUSTS"), 1, 29), IC2Items.getItem("ingot", "lead"));
					SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(TechRebornAPI.getBlock("ORE"), 1, 13), IC2Items.getItem("ingot", "silver"));
					SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(TechRebornAPI.getItem("DUSTS"), 1, 47), IC2Items.getItem("ingot", "silver"));
				} else {
					
					SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("dustCopper", new ItemStack(SPItems.copper_ingot), true);
					SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("dustTin", new ItemStack(SPItems.tin_ingot), true);
					SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("dustBronze", new ItemStack(SPItems.bronze_ingot), true);
					SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("dustTitanium", new ItemStack(SPItems.titanium_ingot), true);
				}
			}
			
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(TechRebornAPI.getBlock("RUBBER_SAPLING")), SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(TechRebornAPI.getItem("PARTS"), 1, 31), SPCompatRecipeManager.futureRecipeManager.getComposterRarityUnCommon());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(TechRebornAPI.getItem("PARTS"), 1, 44), SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
			SPCompatRecipeManager.futureRecipeManager.addComposterRecipe(new ItemStack(TechRebornAPI.getItem("PARTS"), 1, 45), SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());

		}
	}

	public static void registerEventHandler() {

		MinecraftForge.EVENT_BUS.register(new SurvivalPlusFutureMC());
	}

	@SubscribeEvent
	public void removeRecipes(RegistryEvent.Register<IRecipe> event) {

		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();

		modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire"));

		if(SPCompatibilityManager.isIc2Loaded()) {
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt1"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt2"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt3"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt4"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt5"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt6"));
		}
	}

	@SubscribeEvent
	public void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
		IBlockState state = event.getWorld().getBlockState(event.getPos());

		EntityPlayer entityplayer = event.getEntityPlayer();
		ItemStack itemStackIn = entityplayer.getHeldItem(event.getHand());
		Item item = itemStackIn.getItem();

		if(SPCompatibilityManager.isFutureMCLoaded() && block instanceof CampfireBlock) {
			PropertyBool LIT = ObfuscationReflectionHelper.getPrivateValue(CampfireBlock.class, (CampfireBlock) block, "LIT");
			PropertyBool SIGNAL = ObfuscationReflectionHelper.getPrivateValue(CampfireBlock.class, (CampfireBlock) block, "SIGNAL");
			if(state.getValue(LIT) && item == Items.BUCKET  && !entityplayer.isCreative()) {
				event.getWorld().setBlockState(event.getPos(), state.withProperty(LIT, false));
				if (event.getWorld().isRemote) {
					for (int i = 0; i < 20; ++i) {
						CampfireBlock.Companion.spawnSmokeParticles(event.getWorld(), event.getPos(), (Boolean) state.getValue(SIGNAL), true);
					}
				} else {
					event.getWorld().playSound((EntityPlayer) null, event.getPos(), SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
				}
				if(itemStackIn.getCount() == 1) {
					if (ItemStack.areItemStacksEqual(entityplayer.getHeldItemOffhand(), itemStackIn))
					{
						entityplayer.setHeldItem(EnumHand.OFF_HAND, new ItemStack(SPItems.charcoal_bucket));
					}
					else
					{
						entityplayer.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(SPItems.charcoal_bucket));
					}
				} else  if(itemStackIn.getCount() >= 2){
					itemStackIn.shrink(1);
					boolean flag = entityplayer.inventory.addItemStackToInventory(new ItemStack(SPItems.charcoal_bucket));
					if(!flag) {
						entityplayer.dropItem(new ItemStack(SPItems.charcoal_bucket), false);
					}		
				}
			}
		}
	}

	@SubscribeEvent
	public void golemHealth(EntityInteract event) {
		ItemStack itemstack = event.getItemStack();
		Item item = itemstack.getItem();
		if(SPCompatibilityManager.isFutureMCLoaded() && FConfig.INSTANCE.getBuzzyBees().ironGolem.ironBarHealing && event.getTarget() instanceof EntityIronGolem) {
			if (((EntityLiving) event.getTarget()).getHealth() < ((EntityLiving) event.getTarget()).getMaxHealth()) {
				if(item instanceof SPItemIngot && ((SPItemIngot) item).healsGolem()) {
					Random rand = ((EntityLivingBase) event.getTarget()).getRNG();
					((EntityLiving) event.getTarget()).heal(((SPItemIngot) item).getGolemHealth());
					float f1 = 1.0F + (rand.nextFloat() - rand.nextFloat()) * 0.2F;
					((EntityLiving) event.getTarget()).playSound(FSounds.INSTANCE.getIRON_GOLEM_REPAIR(), 1.0F, f1);
					if (!event.getEntityPlayer().isCreative()) {
						itemstack.shrink(1);
					}
				}
			}
		}
	}

}
