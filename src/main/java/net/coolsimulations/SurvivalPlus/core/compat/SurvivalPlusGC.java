package net.coolsimulations.SurvivalPlus.core.compat;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

import ic2.api.item.IC2Items;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.venus.VenusBlocks;
import micdoodle8.mods.galacticraft.planets.venus.VenusItems;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusSmeltingRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class SurvivalPlusGC {
	
	public static void init() {

		registerSmelting();
		registerCrafting();
	}
	
	public static void registerEventHandler() {

		MinecraftForge.EVENT_BUS.register(new SurvivalPlusGC());
	}

	public static void registerSmelting() {

		if(SPConfig.enableReplaceSmelting) {

			SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(GCItems.basicItem, 1, 3));
			SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(GCItems.basicItem, 3, 3));
			GameRegistry.addSmelting(new ItemStack(GCItems.canister, 1, 1), new ItemStack(SPItems.copper_ingot, 3), 1.0F);
			SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(GCItems.basicItem, 1, 4));
			SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(GCItems.basicItem, 3, 4));
			GameRegistry.addSmelting(new ItemStack(GCItems.canister), new ItemStack(SPItems.tin_ingot, 3), 0.5F);

			if(SPCompatibilityManager.isGCPLoaded() && SPCompatibilityManager.isIc2Loaded()) {
				SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(VenusItems.basicItem, 1, 1));
				GameRegistry.addSmelting(new ItemStack(VenusBlocks.venusBlock, 1, 8), IC2Items.getItem("ingot", "lead"), 1.0F);

				if(SPCompatibilityManager.isExtraPlanetsLoaded()) {
					SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(ExtraPlanets_Items.INGOT_LEAD));
					GameRegistry.addSmelting(new ItemStack(ExtraPlanets_Blocks.ORE_LEAD), IC2Items.getItem("ingot", "lead"), 0.0F);
				}
			}
		}
	}

	public static void registerCrafting() {

		if(SPCompatibilityManager.isExtraPlanetsLoaded() && SPCompatibilityManager.isIc2Loaded()) {
			GameRegistry.addShapedRecipe(new ResourceLocation(SPCompatibilityManager.IC2_MODID, "plant_ball_blue"), null, IC2Items.getItem("crafting", "plant_ball"), new Object []{"SSS", "S S", "SSS", 'S', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 1, 0)});
			GameRegistry.addShapedRecipe(new ResourceLocation(SPCompatibilityManager.IC2_MODID, "plant_ball_red"), null, IC2Items.getItem("crafting", "plant_ball"), new Object []{"SSS", "S S", "SSS", 'S', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 1, 1)});
			GameRegistry.addShapedRecipe(new ResourceLocation(SPCompatibilityManager.IC2_MODID, "plant_ball_purple"), null, IC2Items.getItem("crafting", "plant_ball"), new Object []{"SSS", "S S", "SSS", 'S', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 1, 2)});
			GameRegistry.addShapedRecipe(new ResourceLocation(SPCompatibilityManager.IC2_MODID, "plant_ball_yellow"), null, IC2Items.getItem("crafting", "plant_ball"), new Object []{"SSS", "S S", "SSS", 'S', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 1, 3)});
			GameRegistry.addShapedRecipe(new ResourceLocation(SPCompatibilityManager.IC2_MODID, "plant_ball_green"), null, IC2Items.getItem("crafting", "plant_ball"), new Object []{"SSS", "S S", "SSS", 'S', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 1, 4)});
			GameRegistry.addShapedRecipe(new ResourceLocation(SPCompatibilityManager.IC2_MODID, "plant_ball_brown"), null, IC2Items.getItem("crafting", "plant_ball"), new Object []{"SSS", "S S", "SSS", 'S', new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 1, 5)});
		}
	}
	
	@SubscribeEvent
	public void removeRecipes(RegistryEvent.Register<IRecipe> event) {

		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();

		if(SPConfig.enableReplaceSmelting) {
			
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.GCCORE_MODID + ":" + "basic_block_core_9"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.GCCORE_MODID + ":" + "basic_block_core_10"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.GCCORE_MODID + ":" + "basic_item_3"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.GCCORE_MODID + ":" + "basic_item_4"));
			
			if(SPCompatibilityManager.isGCPLoaded() && SPCompatibilityManager.isIc2Loaded()) {

				modRegistry.remove(new ResourceLocation(SPCompatibilityManager.GCPLANETS_MODID + ":" + "venus_12"));
				modRegistry.remove(new ResourceLocation(SPCompatibilityManager.GCPLANETS_MODID + ":" + "basic_item_venus_1"));
			}
		}
		
	}

}
