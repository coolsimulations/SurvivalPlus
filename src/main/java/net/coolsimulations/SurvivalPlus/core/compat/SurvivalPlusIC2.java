package net.coolsimulations.SurvivalPlus.core.compat;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

import biomesoplenty.api.block.BOPBlocks;
import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.MachineRecipe;
import ic2.api.recipe.Recipes;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.AsteroidBlocks;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import mods.railcraft.common.blocks.RailcraftBlocks;
import mods.railcraft.common.items.RailcraftItems;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusSmeltingRecipes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class SurvivalPlusIC2 {

	private static NBTTagCompound orewash;
	private static NBTTagCompound centerf;
	private static NBTTagCompound cutterhard;
	private static NBTTagCompound blastf;

	public static void init() {

		registerMacerator();
		registerCompressor();
		registerExtractor();
		registerMetalFormer();
		registerCentrifuge();
		registerBlockCutting();
		registerOreWashing();
		registerBlastFurnace();
		registerSmelting();
		registerCrafting();
		registerOreDict();

		if(SPCompatibilityManager.isBopLoaded())
			registerBOP();

		if(SPCompatibilityManager.isGCPLoaded())
			registerGCP();

		if(SPCompatibilityManager.isExtraPlanetsLoaded())
			registerEX();
		
		if(SPCompatibilityManager.isRailcraftLoaded())
			registerRailCraft();
		
		if(SPCompatibilityManager.isGobberLoaded())
			registerGobber();
	}

	public static void registerEventHandler() {

		MinecraftForge.EVENT_BUS.register(new SurvivalPlusIC2());
	}

	public static void registerMacerator() {

		//Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.titanium_ore)), null, false, new ItemStack(SPItems.crushed_titanium_ore, 2));

		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("oreTitanium"), null, false, new ItemStack(SPItems.crushed_titanium_ore, 2));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("ingotTitanium"), null, false, new ItemStack(SPItems.titanium_dust));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("plateDenseTitanium"), null, false, new ItemStack(SPItems.titanium_dust, 8));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("plateTitanium"), null, false, new ItemStack(SPItems.tiny_titanium_pile, 8));

		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("cropOnion", 8), null, false, IC2Items.getItem("crafting", "bio_chaff"));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("seedOnion", 16), null, false, IC2Items.getItem("crafting", "bio_chaff"));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("cropBeetroot", 8), null, false, IC2Items.getItem("crafting", "bio_chaff"));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("seedBeetroot", 16), null, false, IC2Items.getItem("crafting", "bio_chaff"));

		Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(Blocks.RED_SANDSTONE)), null, false, new ItemStack(Blocks.SAND, 1, 1));
	}

	public static void registerCompressor() {

		Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("dustTinyTitanium", 9), null, false, new ItemStack(SPItems.titanium_dust));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("plateTitanium", 9), null, false, new ItemStack(SPItems.titanium_dense_plate));

		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(Blocks.SAND, 4, 1)), null, false, new ItemStack(Blocks.RED_SANDSTONE));

		if(SPConfig.enableReplaceSmelting) {

			Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotCopper", 9), null, true, new ItemStack(SPBlocks.copper_block));
			Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotTin", 9), null, true, new ItemStack(SPBlocks.tin_block));
			Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotBronze", 9), null, true, new ItemStack(SPBlocks.bronze_block));
			
			removeCompressorRecipe(IC2Items.getItem("resource", "copper_block"));
			removeCompressorRecipe(IC2Items.getItem("resource", "tin_block"));
			removeCompressorRecipe(IC2Items.getItem("resource", "bronze_block"));
		}
		
		if(SPCompatibilityManager.isGCLoaded()) {
			
			Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotAluminum", 9), null, false, new ItemStack(GCBlocks.basicBlock, 1, 11));
			Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict(ConfigManagerCore.otherModsSilicon, 9), null, false, new ItemStack(GCBlocks.basicBlock, 1, 13));
		}
		
		if(SPCompatibilityManager.isGCPLoaded()) {
			
			Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPItems.titanium_ingot, 9)), null, false, new ItemStack(SPBlocks.titanium_block));
			Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(AsteroidsItems.basicItem, 9)), null, false, new ItemStack(AsteroidBlocks.blockBasic, 1, 7));
		} else {
			
			Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotTitanium", 9), null, false, new ItemStack(SPBlocks.titanium_block));
		}
	}

	public static void registerExtractor() {

		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardBlack"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardBlue"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardBrown"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardCyan"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardGreen"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardGrey"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardGray"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardLightBlue"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardLightGrey"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardLightGray"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardLime"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardMagenta"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardOrange"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardPink"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardPurple"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardRed"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardWhite"), null, false, new ItemStack(SPBlocks.cardboard));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forOreDict("blockCardboardYellow"), null, false, new ItemStack(SPBlocks.cardboard));

		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_black)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_blue)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_brown)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_cyan)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_green)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_grey)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_light_blue)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_light_grey)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_lime)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_magenta)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_orange)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_pink)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_purple)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_red)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_white)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(SPBlocks.cardboard_lantern_yellow)), null, false, new ItemStack(SPBlocks.cardboard_lantern));
	}

	public static void registerMetalFormer() {

		ItemStack hvCable = IC2Items.getItem("cable", "type:iron,insulation:0");
		hvCable.setCount(16);

		ItemStack fuelRod = IC2Items.getItem("crafting", "fuel_rod");
		fuelRod.setCount(4);

		Recipes.metalformerExtruding.addRecipe(Recipes.inputFactory.forOreDict("ingotTitanium"), null, false, hvCable);
		Recipes.metalformerExtruding.addRecipe(Recipes.inputFactory.forOreDict("plateTitanium"), null, false, fuelRod);
		Recipes.metalformerCutting.addRecipe(Recipes.inputFactory.forOreDict("plateTitanium"), null, false, hvCable);
		Recipes.metalformerRolling.addRecipe(Recipes.inputFactory.forOreDict("plateTitanium"), null, false, new ItemStack(SPItems.titanium_casing, 2));
		Recipes.metalformerRolling.addRecipe(Recipes.inputFactory.forOreDict("ingotTitanium"), null, false, new ItemStack(SPItems.titanium_plate));
	}

	public static void registerCentrifuge() {

		centerf = new NBTTagCompound();
		centerf.setInteger("minHeat", 1500);

		Recipes.centrifuge.addRecipe(Recipes.inputFactory.forOreDict("crushedPurifiedTitanium"), centerf, false, new ItemStack(SPItems.tiny_titanium_pile), new ItemStack(SPItems.titanium_dust));
		Recipes.centrifuge.addRecipe(Recipes.inputFactory.forOreDict("crushedTitanium"), centerf, false, new ItemStack(SPItems.tiny_titanium_pile), new ItemStack(SPItems.titanium_dust), IC2Items.getItem("dust", "stone"));
	}

	public static void registerBlockCutting() {

		cutterhard = new NBTTagCompound();
		cutterhard.setInteger("hardness", 3);

		Recipes.blockcutter.addRecipe(Recipes.inputFactory.forOreDict("blockTitanium"), cutterhard, false, new ItemStack(SPItems.titanium_plate, 9));
	}

	public static void registerOreWashing() {

		orewash = new NBTTagCompound();
		orewash.setInteger("amount", 1000);

		Recipes.oreWashing.addRecipe(Recipes.inputFactory.forOreDict("crushedTitanium"), orewash, false, new ItemStack(SPItems.purified_titanium_ore), new ItemStack(SPItems.tiny_titanium_pile, 2), IC2Items.getItem("dust", "stone"));
	}

	public static void registerBlastFurnace() {

		blastf = new NBTTagCompound();
		blastf.setInteger("fluid", 1);
		blastf.setInteger("duration", 6000);
	}

	public static void registerSmelting() {

		if(SPConfig.enableReplaceSmelting) {
			SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("crushedCopper", new ItemStack(SPItems.copper_ingot), 0.7F, true);
			SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("crushedPurifiedCopper", new ItemStack(SPItems.copper_ingot), 0.7F, true);
			SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("dustCopper", new ItemStack(SPItems.copper_ingot), 0.7F, true);

			SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("crushedTin", new ItemStack(SPItems.tin_ingot), 0.7F, true);
			SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("crushedPurifiedTin", new ItemStack(SPItems.tin_ingot), 0.7F, true);
			SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("dustTin", new ItemStack(SPItems.tin_ingot), 0.7F, true);

			SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("dustBronze", new ItemStack(SPItems.bronze_ingot), 0.7F, true);

		}

		GameRegistry.addSmelting(SPItems.titanium_dust, new ItemStack(SPItems.titanium_ingot), 3.0F);

		SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("crushedTitanium", new ItemStack(SPItems.titanium_ingot), 0.7F);
		SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("crushedPurifiedTitanium", new ItemStack(SPItems.titanium_ingot), 0.7F);
	}

	public static void registerCrafting() {

		ItemStack cable = IC2Items.getItem("cable", "type:glass,insulation:0");
		cable.setCount(9);

		GameRegistry.addShapedRecipe(cable.getItem().getRegistryName(), null, cable, new Object []{"GGG", "ETE", "GGG", 'G', Blocks.GLASS, 'T', "dustTitanium", 'E', IC2Items.getItem("dust", "energium")});
	}

	public static void registerOreDict() {

		OreDictionary.registerOre("crushedTitanium", new ItemStack(SPItems.crushed_titanium_ore));	
		OreDictionary.registerOre("crushedPurifiedTitanium", new ItemStack(SPItems.purified_titanium_ore));
		OreDictionary.registerOre("dustTinyTitanium", new ItemStack(SPItems.tiny_titanium_pile));
		OreDictionary.registerOre("plateTitanium", new ItemStack(SPItems.titanium_plate));
		OreDictionary.registerOre("plateDenseTitanium", new ItemStack(SPItems.titanium_dense_plate));
		OreDictionary.registerOre("casingTitanium", new ItemStack(SPItems.titanium_casing));
	}

	@SubscribeEvent
	public void removeRecipes(RegistryEvent.Register<IRecipe> event) {

		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();

		modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "bronze_ingot_alt2"));

		if(SPConfig.enableReplaceSmelting) {

			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "90"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "91"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "92"));

			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "113"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "114"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "115"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "116"));

			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "180"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "181"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "182"));

			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "248"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "249"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "250"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "251"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.IC2_MODID + ":" + "252"));
		}
	}

	public static void removeCompressorRecipe (ItemStack resultItem)
	{
		Iterable<? extends MachineRecipe<IRecipeInput, Collection<ItemStack>>> recipes = Recipes.compressor.getRecipes();
		for (Iterator<? extends MachineRecipe<IRecipeInput, Collection<ItemStack>>> entries = recipes.iterator(); entries.hasNext(); ){
			MachineRecipe<IRecipeInput, Collection<ItemStack>> entry = entries.next();
			Collection<ItemStack> result = entry.getOutput();
			for (Iterator<ItemStack> stacks = result.iterator(); stacks.hasNext(); ){
				ItemStack stackResult = stacks.next();
				if (ItemStack.areItemStacksEqual(stackResult, resultItem)){ // If the output matches the specified ItemStack,
					entries.remove(); // Remove the recipe
				}
			}
		}
	}

	public static void registerBOP() {

		Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(BOPBlocks.white_sandstone)), null, false, new ItemStack(BOPBlocks.white_sand));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(BOPBlocks.white_sand, 4)), null, false, new ItemStack(BOPBlocks.white_sandstone));
	}

	public static void registerGCP() {

		Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(MarsBlocks.marsBlock, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(AsteroidBlocks.blockBasic, 1, 5)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(MarsItems.marsItemBasic, 9, 2)), null, false, new ItemStack(MarsBlocks.marsBlock, 1, 8));
	}

	public static void registerEX() {

		Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		if(Config.CERES) {
			
			Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
			
			Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.INGOT_URANIUM, 9)), null, false, new ItemStack(ExtraPlanets_Blocks.CERES_BLOCKS, 1, 7));
		}
		Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));

		if(Config.KEPLER22B) {

			Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 2)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
			Recipes.cannerEnrich.addRecipe(new FluidStack(FluidRegistry.WATER, 6000), Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 7)), new FluidStack(FluidRegistry.getFluid("ic2hot_water"), 1000));
			Recipes.cannerEnrich.addRecipe(new FluidStack(FluidRegistry.WATER, 6000), Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 8)), new FluidStack(FluidRegistry.getFluid("ic2hot_water"), 1000));
			Recipes.cannerEnrich.addRecipe(new FluidStack(FluidRegistry.WATER, 6000), Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 9)), new FluidStack(FluidRegistry.getFluid("ic2hot_water"), 1000));
			Recipes.cannerEnrich.addRecipe(new FluidStack(FluidRegistry.WATER, 6000), Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 10)), new FluidStack(FluidRegistry.getFluid("ic2hot_water"), 1000));
			Recipes.cannerEnrich.addRecipe(new FluidStack(FluidRegistry.WATER, 6000), Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 11)), new FluidStack(FluidRegistry.getFluid("ic2hot_water"), 1000));
			Recipes.cannerEnrich.addRecipe(new FluidStack(FluidRegistry.WATER, 6000), Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 12)), new FluidStack(FluidRegistry.getFluid("ic2hot_water"), 1000));

			Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 4, 0)), null, false, IC2Items.getItem("crafting", "bio_chaff"));
			Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 4, 1)), null, false, IC2Items.getItem("crafting", "bio_chaff"));
			Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 4, 2)), null, false, IC2Items.getItem("crafting", "bio_chaff"));
			Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 4, 3)), null, false, IC2Items.getItem("crafting", "bio_chaff"));
			Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 4, 4)), null, false, IC2Items.getItem("crafting", "bio_chaff"));
			Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 4, 5)), null, false, IC2Items.getItem("crafting", "bio_chaff"));
			
			Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 9, 5)), null, false, new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 14));
		}

		if(Config.EUROPA)
			Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.EUROPA_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		if(Config.IO)
			Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.IO_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		if(Config.DEIMOS)
			Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.DEIMOS_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		if(Config.PHOBOS)
			Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.PHOBOS_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		if(Config.TRITON)
			Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.TRITON_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		if(Config.CALLISTO)
			Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.CALLISTO_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		if(Config.GANYMEDE)
			Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.GANYMEDE_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		if(Config.RHEA)
			Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.RHEA_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		if(Config.TITAN)
			Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.TITAN_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		if(Config.OBERON)
			Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.OBERON_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		if(Config.TITANIA)
			Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.TITANIA_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));
		if(Config.IAPETUS)
			Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.IAPETUS_BLOCKS, 1, 3)), blastf, false, IC2Items.getItem("ingot", "steel"),  IC2Items.getItem("misc_resource", "slag"));

		Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.RED_SANDSTONE)), null, false, new ItemStack(ExtraPlanets_Blocks.RED_SAND));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.RED_SAND, 4)), null, false, new ItemStack(ExtraPlanets_Blocks.RED_SANDSTONE));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.ORANGE_SANDSTONE)), null, false, new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND, 4)), null, false, new ItemStack(ExtraPlanets_Blocks.ORANGE_SANDSTONE));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 9, 6)), null, false, new ItemStack(Items.DIAMOND));
		
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 9, 5)), null, false, new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 7));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 9, 5)), null, false, new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 7));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 9, 6)), null, false, new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 11));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 9, 5)), null, false, new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 7));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 9, 7)), null, false, new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 8));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 9, 5)), null, false, new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 4));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 9, 5)), null, false, new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 7));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 9, 8)), null, false, new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 12));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 9, 7)), null, false, new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 13));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 9, 5)), null, false, new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 8));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 9, 5)), null, false, new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 11));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(ExtraPlanets_Items.INGOT_MERCURY, 9)), null, false, new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 7));
	}
	
	public static void registerRailCraft() {

		Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotInvar", 9), null, false, new ItemStack(RailcraftBlocks.METAL.item(), 1, 7));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotBrass", 9), null, false, new ItemStack(RailcraftBlocks.METAL.item(), 1, 9));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(RailcraftItems.COKE.item(), 9)), null, false, new ItemStack(RailcraftBlocks.GENERIC.item(), 1, 6));
		
		if(SPCompatibilityManager.isExtraPlanetsLoaded()) {

			Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(RailcraftItems.INGOT.item(), 9, 6)), null, false, new ItemStack(RailcraftBlocks.METAL.item(), 1, 6));
			Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(RailcraftItems.INGOT.item(), 9, 8)), null, false, new ItemStack(RailcraftBlocks.METAL.item(), 1, 8));
		} else {
			
			Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotNickel", 9), null, false, new ItemStack(RailcraftBlocks.METAL.item(), 1, 6));
			Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotZinc", 9), null, false, new ItemStack(RailcraftBlocks.METAL.item(), 1, 8));
		}
	}
	
	public static void registerGobber() {
		
		Block block_gobber = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot_block"));
		Block block_nether_gobber = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot2_block"));
		Block block_end_gobber = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot3_block"));
		
		Block glob_plank = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_plank"));
		Block glob_log = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_log"));
		Block glob2_plank = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob2_plank"));
		Block glob2_log = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob2_log"));
		Block glob3_plank = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob3_plank"));
		Block glob3_log = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob3_log"));
		
		Item glob = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob"));
		Item nether_glob = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob2"));
		Item end_glob = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob3"));
		
		Item ingot_gobber = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot"));
		Item ingot_nether_gobber = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot2"));
		Item ingot_end_gobber = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot3"));
		
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("cropGlob", 8), null, false, IC2Items.getItem("crafting", "bio_chaff"));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("cropNetherGlob", 4), null, false, IC2Items.getItem("crafting", "bio_chaff"));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("cropEndGlob", 2), null, false, IC2Items.getItem("crafting", "bio_chaff"));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("seedGlob", 16), null, false, IC2Items.getItem("crafting", "bio_chaff"));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("seedNetherGlob", 8), null, false, IC2Items.getItem("crafting", "bio_chaff"));
		Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("seedEndGlob", 4), null, false, IC2Items.getItem("crafting", "bio_chaff"));
		
		Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotGobber", 9), null, true, new ItemStack(block_gobber));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotNetherGobber", 9), null, true, new ItemStack(block_nether_gobber));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotEndGobber", 9), null, true, new ItemStack(block_end_gobber));
		
		Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("cropGlob", 9), null, true, new ItemStack(glob));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("cropNetherGlob", 9), null, true, new ItemStack(nether_glob));
		Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("cropEndGlob", 9), null, true, new ItemStack(end_glob));
		
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(glob_log, 8)), null, false, new ItemStack(glob));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(glob_plank, 8)), null, false, new ItemStack(glob));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(glob2_log, 8)), null, false, new ItemStack(nether_glob));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(glob2_plank, 8)), null, false, new ItemStack(nether_glob));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(glob3_log, 8)), null, false, new ItemStack(end_glob));
		Recipes.extractor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(glob3_plank, 8)), null, false, new ItemStack(end_glob));
		
		Recipes.blockcutter.addRecipe(Recipes.inputFactory.forOreDict("blockGobber"), cutterhard, false, new ItemStack(ingot_gobber, 9));
		Recipes.blockcutter.addRecipe(Recipes.inputFactory.forOreDict("blockNetherGobber"), cutterhard, false, new ItemStack(ingot_nether_gobber, 9));
		Recipes.blockcutter.addRecipe(Recipes.inputFactory.forOreDict("blockEndGobber"), cutterhard, false, new ItemStack(ingot_end_gobber, 9));
		
	}
}
