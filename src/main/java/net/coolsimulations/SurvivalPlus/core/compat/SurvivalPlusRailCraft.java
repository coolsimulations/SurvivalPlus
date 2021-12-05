package net.coolsimulations.SurvivalPlus.core.compat;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

import ic2.api.item.IC2Items;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.AsteroidBlocks;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import mods.railcraft.api.crafting.Crafters;
import mods.railcraft.common.blocks.RailcraftBlocks;
import mods.railcraft.common.core.RailcraftConfig;
import mods.railcraft.common.items.RailcraftItems;
import mods.railcraft.common.util.crafting.Ingredients;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.compat.SPCompatRecipeManager;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusSmeltingRecipes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SurvivalPlusRailCraft {

	public static void init() {

		registerMetalRolling();
		registerRockCrushing();
		registerBlastFurnace();
		registerSmelting();
		registerCrafting();

	}

	public static void registerMetalRolling() {

		Item plate = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "plate"));

		Crafters.rollingMachine().newRecipe(new ItemStack(plate, 6)).shaped("II", "II", 'I', "ingotTitanium");
	}

	public static void registerRockCrushing() {

		if(SPCompatibilityManager.isIc2Loaded() && RailcraftConfig.canCrushOres()) {
			Crafters.rockCrusher().makeRecipe(Ingredients.from("oreTitanium")).name(SPReference.MOD_ID + ":crush_" + SPBlocks.titanium_ore.getRegistryName().getResourcePath()).addOutput(new ItemStack(SPItems.crushed_titanium_ore, 2)).register();

			if(SPCompatibilityManager.isGCLoaded()) {
				Crafters.rockCrusher().makeRecipe(Ingredients.from("oreAluminum")).name(SPReference.MOD_ID + ":crush_aluminum_ore").addOutput(new ItemStack(GCItems.ic2compat, 2, 2)).register();

				if(SPCompatibilityManager.isGCPLoaded()) {

					ItemStack crushed_iron = IC2Items.getItem("crushed", "iron");
					crushed_iron.setCount(2);

					Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(MarsBlocks.marsBlock, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_mars").addOutput(crushed_iron).register();
					Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(AsteroidBlocks.blockBasic, 1, 5))).name(SPReference.MOD_ID + ":crush_iron_ore_asteroid").addOutput(crushed_iron).register();

					if(SPCompatibilityManager.isExtraPlanetsLoaded()) {

						Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_mercury").addOutput(crushed_iron).register();
						if(Config.CERES)
							Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_ceres").addOutput(crushed_iron).register();
						Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_jupiter").addOutput(crushed_iron).register();
						Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_saturn").addOutput(crushed_iron).register();
						Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_neptune").addOutput(crushed_iron).register();
						Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_pluto").addOutput(crushed_iron).register();
						Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_eris").addOutput(crushed_iron).register();
						if(Config.KEPLER22B)
							Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 2))).name(SPReference.MOD_ID + ":crush_iron_ore_kepler22b").addOutput(crushed_iron).register();
						if(Config.EUROPA)
							Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.EUROPA_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_europa").addOutput(crushed_iron).register();
						if(Config.IO)
							Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.IO_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_io").addOutput(crushed_iron).register();
						if(Config.DEIMOS)
							Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.DEIMOS_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_deimos").addOutput(crushed_iron).register();
						if(Config.PHOBOS)
							Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.PHOBOS_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_phobos").addOutput(crushed_iron).register();
						if(Config.TRITON)
							Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.TRITON_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_triton").addOutput(crushed_iron).register();
						if(Config.CALLISTO)
							Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.CALLISTO_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_callisto").addOutput(crushed_iron).register();
						if(Config.GANYMEDE)
							Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_ganymede").addOutput(crushed_iron).register();
						if(Config.RHEA)
							Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.RHEA_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_rhea").addOutput(crushed_iron).register();
						if(Config.TITAN)
							Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.TITAN_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_titan").addOutput(crushed_iron).register();
						if(Config.OBERON)
							Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.OBERON_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_oberon").addOutput(crushed_iron).register();
						if(Config.TITANIA)
							Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.TITANIA_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_titania").addOutput(crushed_iron).register();
						if(Config.IAPETUS)
							Crafters.rockCrusher().makeRecipe(Ingredients.from(new ItemStack(ExtraPlanets_Blocks.IAPETUS_BLOCKS, 1, 3))).name(SPReference.MOD_ID + ":crush_iron_ore_iapetus").addOutput(crushed_iron).register();
					}
				}
			}
		}
	}

	public static void registerBlastFurnace() {

		if(SPConfig.enableReplaceSmelting && SPCompatibilityManager.isIc2Loaded()) {

			ItemStack steel = IC2Items.getItem("ingot", "steel");

			SPCompatRecipeManager.railcraftRecipeManager.removeBlastFurnaceRecipe(new ItemStack(RailcraftItems.INGOT.item()));
			SPCompatRecipeManager.railcraftRecipeManager.removeBlastFurnaceRecipe(new ItemStack(RailcraftItems.INGOT.item(), 2));
			SPCompatRecipeManager.railcraftRecipeManager.removeBlastFurnaceRecipe(new ItemStack(RailcraftItems.INGOT.item(), 3));
			SPCompatRecipeManager.railcraftRecipeManager.removeBlastFurnaceRecipe(new ItemStack(RailcraftItems.INGOT.item(), 4));
			SPCompatRecipeManager.railcraftRecipeManager.removeBlastFurnaceRecipe(new ItemStack(RailcraftItems.INGOT.item(), 5));
			SPCompatRecipeManager.railcraftRecipeManager.removeBlastFurnaceRecipe(new ItemStack(RailcraftItems.INGOT.item(), 6));
			SPCompatRecipeManager.railcraftRecipeManager.removeBlastFurnaceRecipe(new ItemStack(RailcraftItems.INGOT.item(), 7));
			SPCompatRecipeManager.railcraftRecipeManager.removeBlastFurnaceRecipe(new ItemStack(RailcraftItems.INGOT.item(), 8));

			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(Items.IRON_INGOT), steel, 1);

			steel.setCount(5);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(Items.IRON_HELMET), steel, 1);

			steel.setCount(8);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(Items.IRON_CHESTPLATE), steel, 1);

			steel.setCount(7);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(Items.IRON_LEGGINGS), steel, 1);

			steel.setCount(4);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(Items.IRON_BOOTS), steel, 1);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(Items.IRON_HORSE_ARMOR), steel, 1);

			steel.setCount(2);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(Items.IRON_SWORD), steel, 1);

			steel.setCount(1);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(Items.IRON_SHOVEL), steel, 1);

			steel.setCount(3);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(Items.IRON_PICKAXE), steel, 1);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(Items.IRON_AXE), steel, 1);

			steel.setCount(2);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(Items.IRON_HOE), steel, 1);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(Items.SHEARS), steel, 1);

			steel.setCount(3);
			SPCompatRecipeManager.railcraftRecipeManager.addOreDictionaryBlastFurnaceRecipe("toolCrowbar", new ResourceLocation(SPReference.MOD_ID + ":smelt_tool_crowbar"), steel, 1);

			steel.setCount(6);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(Items.IRON_DOOR), steel, 1);

			steel.setCount(4);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(Blocks.IRON_TRAPDOOR), steel, 1);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(RailcraftItems.ARMOR_HELMET_STEEL.item()), steel, 1);

			steel.setCount(6);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(RailcraftItems.ARMOR_CHESTPLATE_STEEL.item()), steel, 1);

			steel.setCount(5);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(RailcraftItems.ARMOR_LEGGINGS_STEEL.item()), steel, 1);

			steel.setCount(3);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(RailcraftItems.ARMOR_BOOTS_STEEL.item()), steel, 1);

			steel.setCount(1);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(RailcraftItems.SWORD_STEEL.item()), steel, 1);

			steel.setCount(2);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(RailcraftItems.PICKAXE_STEEL.item()), steel, 1);

			steel.setCount(1);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(RailcraftItems.HOE_STEEL.item()), steel, 1);

			steel.setCount(2);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(RailcraftItems.AXE_STEEL.item()), steel, 1);

			steel.setCount(1);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(RailcraftItems.SHEARS_STEEL.item()), steel, 1);
			SPCompatRecipeManager.railcraftRecipeManager.addOreDictionaryBlastFurnaceRecipe("plateIron", new ResourceLocation(SPReference.MOD_ID + ":smelt_iron_plate"), steel, 1);
			SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(RailcraftBlocks.BOILER_TANK_PRESSURE_LOW.item()), steel, 1);

			if(SPCompatibilityManager.isGCLoaded()) {

				steel.setCount(3);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelPickaxe), steel, 1);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelAxe), steel, 1);

				steel.setCount(2);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelHoe), steel, 1);

				steel.setCount(1);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelSpade), steel, 1);

				steel.setCount(2);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelSword), steel, 1);

				steel.setCount(5);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelHelmet), steel, 1);

				steel.setCount(8);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelChestplate), steel, 1);

				steel.setCount(7);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelLeggings), steel, 1);

				steel.setCount(4);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelBoots), steel, 1);
			}
		} else {

			if(SPCompatibilityManager.isGCLoaded()) {
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelPickaxe), new ItemStack(RailcraftItems.INGOT.item(), 3), 1);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelAxe), new ItemStack(RailcraftItems.INGOT.item(), 3), 1);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelHoe), new ItemStack(RailcraftItems.INGOT.item(), 2), 1);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelSpade), new ItemStack(RailcraftItems.INGOT.item()), 1);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelSword), new ItemStack(RailcraftItems.INGOT.item(), 2), 1);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelHelmet), new ItemStack(RailcraftItems.INGOT.item(), 5), 1);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelChestplate), new ItemStack(RailcraftItems.INGOT.item(), 8), 1);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelLeggings), new ItemStack(RailcraftItems.INGOT.item(), 7), 1);
				SPCompatRecipeManager.railcraftRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.steelBoots), new ItemStack(RailcraftItems.INGOT.item(), 4), 1);
			}
		}
	}

	public static void registerSmelting() {

		Item ingot = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "ingot"));
		Block oreMetal = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "ore_metal"));

		if(SPConfig.enableReplaceSmelting) {

			SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(ingot, 1, 1));
			SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(ingot, 1, 2));

			if(SPCompatibilityManager.isIc2Loaded()) {

				SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(ingot, 1, 3));
				GameRegistry.addSmelting(new ItemStack(oreMetal, 1, 2), IC2Items.getItem("ingot", "lead"), 1.0F);
				SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(ingot, 1, 4));
				GameRegistry.addSmelting(new ItemStack(oreMetal, 1, 3), IC2Items.getItem("ingot", "silver"), 1.0F);
			}
		}
	}

	public static void registerCrafting() {

		if(SPConfig.enableReplaceSmelting && SPCompatibilityManager.isIc2Loaded()) {

			ItemStack steel = IC2Items.getItem("ingot", "steel");
			GameRegistry.addShapedRecipe(steel.getItem().getRegistryName(), null, steel, new Object []{"NNN", "NNN", "NNN", 'N', "nuggetSteel"});

			ItemStack lead = IC2Items.getItem("ingot", "lead");
			GameRegistry.addShapedRecipe(steel.getItem().getRegistryName(), null, lead, new Object []{"NNN", "NNN", "NNN", 'N', "nuggetLead"});
		}
	}

}
