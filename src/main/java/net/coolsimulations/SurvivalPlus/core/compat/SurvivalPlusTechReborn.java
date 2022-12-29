package net.coolsimulations.SurvivalPlus.core.compat;

import java.util.ArrayList;
import java.util.List;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

import biomesoplenty.api.block.BOPBlocks;
import forestry.core.fluids.Fluids;
import ic2.api.item.IC2Items;
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
import net.minecraftforge.registries.IForgeRegistryModifiable;
import reborncore.api.praescriptum.recipes.Recipe;
import reborncore.api.recipe.IBaseRecipeType;
import reborncore.api.recipe.RecipeHandler;
import techreborn.api.Reference;
import techreborn.api.TechRebornAPI;
import techreborn.api.recipe.Recipes;
import techreborn.api.recipe.machines.BlastFurnaceRecipe;
import techreborn.api.recipe.machines.IndustrialGrinderRecipe;
import techreborn.api.recipe.machines.IndustrialSawmillRecipe;

public class SurvivalPlusTechReborn {

	public static void init() {

		registerGrinder();
		registerCompressor();
		registerExtractor();
		registerWireMill();
		registerCentrifuge();
		registerAlloySmelter();
		registerBlastFurnace();
		registerSmelting();
		registerCrafting();

		if(SPCompatibilityManager.isBopLoaded())
			registerBOP();

		if(SPCompatibilityManager.isExtraPlanetsLoaded())
			registerEX();
		
		if(SPCompatibilityManager.isGobberLoaded())
			registerGobber();
	}

	public static void registerEventHandler() {

		MinecraftForge.EVENT_BUS.register(new SurvivalPlusTechReborn());
	}

	public static void registerGrinder() {

		Recipes.grinder.createRecipe().withInput("oreTitanium").withOutput(new ItemStack(TechRebornAPI.getItem("DUSTS"), 2, 54)).withEnergyCostPerTick(2).withOperationDuration(300).register();

		Recipes.grinder.createRecipe().withInput(new ItemStack(Blocks.SANDSTONE)).withOutput(new ItemStack(Blocks.SAND)).withEnergyCostPerTick(2).withOperationDuration(300).register();
		Recipes.grinder.createRecipe().withInput(new ItemStack(Blocks.RED_SANDSTONE)).withOutput(new ItemStack(Blocks.SAND, 1, 1)).withEnergyCostPerTick(2).withOperationDuration(300).register();
		
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe("oreTitanium", new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(TechRebornAPI.getItem("DUSTS"), 2, 54), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 1, 24), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 1, 7), null, 100, 128));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe("oreTitanium", new FluidStack(FluidRegistry.getFluid("fluidmercury"), Fluid.BUCKET_VOLUME), new ItemStack(TechRebornAPI.getItem("DUSTS"), 3, 54), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 1, 24), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 1, 7), null, 100, 128));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe("oreTitanium", new FluidStack(FluidRegistry.getFluid("fluidsodiumpersulfate"), Fluid.BUCKET_VOLUME), new ItemStack(TechRebornAPI.getItem("DUSTS"), 2, 54), new ItemStack(TechRebornAPI.getItem("DUSTS"), 1, 24), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 1, 7), null, 100, 128));
	}

	public static void registerCompressor() {

		Recipes.compressor.createRecipe().withInput("cropOnion", 8).withOutput(new ItemStack(TechRebornAPI.getItem("PARTS"), 1, 45)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.compressor.createRecipe().withInput("cropBeetroot", 8).withOutput(new ItemStack(TechRebornAPI.getItem("PARTS"), 1, 45)).withEnergyCostPerTick(2).withOperationDuration(400).register();

		Recipes.compressor.createRecipe().withInput(new ItemStack(Blocks.SAND, 4)).withOutput(new ItemStack(Blocks.SANDSTONE)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.compressor.createRecipe().withInput(new ItemStack(Blocks.SAND, 4, 1)).withOutput(new ItemStack(Blocks.RED_SANDSTONE)).withEnergyCostPerTick(2).withOperationDuration(400).register();
	}	

	public static void registerExtractor() {

		Recipes.extractor.createRecipe().withInput("blockCardboardBlack").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardBlue").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardBrown").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardCyan").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardGreen").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardGrey").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardGray").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardLightBlue").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardLightGrey").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardLightGray").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardLime").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardMagenta").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardOrange").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardPink").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardPurple").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardRed").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardWhite").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput("blockCardboardYellow").withOutput(new ItemStack(SPBlocks.cardboard)).withEnergyCostPerTick(2).withOperationDuration(400).register();

		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_black)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_blue)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_brown)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_cyan)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_green)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_grey)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_light_blue)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_light_grey)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_lime)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_magenta)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_orange)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_pink)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_purple)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_red)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_white)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(SPBlocks.cardboard_lantern_yellow)).withOutput(new ItemStack(SPBlocks.cardboard_lantern)).withEnergyCostPerTick(2).withOperationDuration(400).register();
	}

	public static void registerWireMill() {

		Recipes.wireMill.createRecipe().withInput("ingotTitanium").withOutput(new ItemStack(TechRebornAPI.getBlock("CABLE"), 6, 3)).withEnergyCostPerTick(2).withOperationDuration(200).register();
	}

	public static void registerCentrifuge() {

		ItemStack methane = new ItemStack(TechRebornAPI.getItem("CELL"));
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("FluidName", "fluidmethane");
		tag.setInteger("Amount", 1000);
		methane.setTagInfo("Fluid", tag);

		Recipes.centrifuge.createRecipe().withInput("cropOnion", 16).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodApplebaked", 16).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodCheese", 8).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodFriedonions", 8).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodRoastcarrot", 8).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodApplepie", 4).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodBeefpie", 4).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodChickenpie", 4).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodMuttonpie", 4).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodPorkpie", 4).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodRabbitpie", 4).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodVegetablepie", 4).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodCheesebread", 4).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodMeltedCheesebread", 2).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodCupcake", 4).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodCheesecupcake", 4).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodSpongecupcake", 4).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodCheesecake", 8).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();
		Recipes.centrifuge.createRecipe().withInput("foodSpongecake", 8).withInput(new ItemStack(TechRebornAPI.getItem("CELL"))).withOutput(methane).withEnergyCostPerTick(5).withOperationDuration(5000).register();

		if (SPConfig.enableReplaceSmelting) {
			ItemStack lava = new ItemStack(TechRebornAPI.getItem("CELL"), 16);
			NBTTagCompound lava_tag = new NBTTagCompound();
			lava_tag.setString("FluidName", "lava");
			lava_tag.setInteger("Amount", 1000);
			lava.setTagInfo("Fluid", lava_tag);
			removeCentrifugeRecipe(new ItemStack(TechRebornAPI.getItem("INGOTS"), 4, 4));
			Recipes.centrifuge.createRecipe().withInput(lava).withOutput(new ItemStack(SPItems.tin_ingot, 18)).withOutput(new ItemStack(SPItems.copper_ingot, 4)).withOutput(new ItemStack(TechRebornAPI.getItem("INGOTS"), 1, 5)).withOutput(new ItemStack(TechRebornAPI.getItem("INGOTS"), 1, 17)).withEnergyCostPerTick(5).withOperationDuration(15000).withNBT(true).register();
		}
	}

	public static void registerAlloySmelter() {

		if (SPConfig.enableReplaceSmelting) {
			removeAlloySmelterRecipe(new ItemStack(TechRebornAPI.getItem("INGOTS"), 4, 2));
			Recipes.alloySmelter.createRecipe().withInput("ingotCopper", 3).withInput("ingotTin").withOutput(new ItemStack(SPItems.bronze_ingot, 4)).withEnergyCostPerTick(16).withOperationDuration(100).register();
			Recipes.alloySmelter.createRecipe().withInput("dustCopper", 3).withInput("dustTin").withOutput(new ItemStack(SPItems.bronze_ingot, 4)).withEnergyCostPerTick(16).withOperationDuration(100).register();
			Recipes.alloySmelter.createRecipe().withInput("ingotCopper", 3).withInput("dustTin").withOutput(new ItemStack(SPItems.bronze_ingot, 4)).withEnergyCostPerTick(16).withOperationDuration(100).register();
			Recipes.alloySmelter.createRecipe().withInput("dustCopper", 3).withInput("ingotTin").withOutput(new ItemStack(SPItems.bronze_ingot, 4)).withEnergyCostPerTick(16).withOperationDuration(100).register();
		}
	}

	public static void registerBlastFurnace() {

		if (SPConfig.enableReplaceSmelting) {
			removeBlastFurnaceRecipe(new ItemStack(TechRebornAPI.getItem("INGOTS"), 1, 14));
			RecipeHandler.addRecipe(new BlastFurnaceRecipe("dustTitanium", null, new ItemStack(SPItems.titanium_ingot), null, 3600, 128, 1500));
			RecipeHandler.addRecipe(new BlastFurnaceRecipe(new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 4, 54), null, new ItemStack(SPItems.titanium_ingot), null, 3600, 128, 1500));
		}
	}

	public static void registerSmelting() {

		if(SPConfig.enableReplaceSmelting) {	
			if (!SPCompatibilityManager.isIc2Loaded()) {
				SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("dustCopper", new ItemStack(SPItems.copper_ingot), 0.7F, true);
				SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("dustTin", new ItemStack(SPItems.tin_ingot), 0.7F, true);
				SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("dustBronze", new ItemStack(SPItems.bronze_ingot), 0.7F, true);
			} else {
				SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(TechRebornAPI.getItem("INGOTS"), 1, 8));
				GameRegistry.addSmelting(new ItemStack(TechRebornAPI.getBlock("ORE"), 1, 12), IC2Items.getItem("ingot", "lead"), 1.0F);
				GameRegistry.addSmelting(new ItemStack(TechRebornAPI.getItem("DUSTS"), 1, 29), IC2Items.getItem("ingot", "lead"), 1.0F);
				SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(TechRebornAPI.getItem("INGOTS"), 1, 11));
				GameRegistry.addSmelting(new ItemStack(TechRebornAPI.getBlock("ORE"), 1, 13), IC2Items.getItem("ingot", "silver"), 1.0F);
				GameRegistry.addSmelting(new ItemStack(TechRebornAPI.getItem("DUSTS"), 1, 47), IC2Items.getItem("ingot", "silver"), 1.0F);
			}
		}
	}

	public static void registerCrafting() {

		ItemStack cable = new ItemStack(TechRebornAPI.getBlock("CABLE"), 4, 4);

		GameRegistry.addShapedRecipe(new ResourceLocation(SPCompatibilityManager.TECH_REBORN_MODID, "cable_titanium_1"), null, cable, new Object []{"GGG", "ETE", "GGG", 'G',"blockGlass", 'T', "dustTitanium", 'E', "dustRedstone"});

		ItemStack cable1 = new ItemStack(TechRebornAPI.getBlock("CABLE"), 6, 4);
		GameRegistry.addShapedRecipe(new ResourceLocation(SPCompatibilityManager.TECH_REBORN_MODID, "cable_titanium_2"), null, cable1, new Object []{"GGG", "ETE", "GGG", 'G',"blockGlass", 'T', "dustTitanium", 'E', "ingotSilver"});

		ItemStack cable2 = new ItemStack(TechRebornAPI.getBlock("CABLE"), 8, 4);
		GameRegistry.addShapedRecipe(new ResourceLocation(SPCompatibilityManager.TECH_REBORN_MODID, "cable_titanium_3"), null, cable2, new Object []{"GGG", "ETE", "GGG", 'G',"blockGlass", 'T', "dustTitanium", 'E', "ingotElectrum"});

		GameRegistry.addShapedRecipe(new ResourceLocation(SPCompatibilityManager.TECH_REBORN_MODID, "cable_titanium_4"), null, new ItemStack(TechRebornAPI.getBlock("CABLE"), 12, 3), new Object []{"TTT", 'T', "ingotTitanium"});
	}

	@SubscribeEvent
	public void removeRecipes(RegistryEvent.Register<IRecipe> event) {

		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();

		if (!SPCompatibilityManager.isIc2Loaded())
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "bronze_ingot_alt2"));

		if(SPConfig.enableReplaceSmelting) {
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.TECH_REBORN_MODID + ":" + "storage_14"));
		}
	}

	public static void removeCentrifugeRecipe (ItemStack resultItem)
	{
		for(Recipe recipe : Recipes.centrifuge.getRecipes()) {
			for (ItemStack output : recipe.getItemOutputs()) {
				if (ItemStack.areItemsEqual(output, resultItem))
					Recipes.centrifuge.getRecipes().remove(recipe);
			}
		}
	}

	public static void removeAlloySmelterRecipe (ItemStack resultItem)
	{
		for(Recipe recipe : Recipes.alloySmelter.getRecipes()) {
			for (ItemStack output : recipe.getItemOutputs()) {
				if (ItemStack.areItemsEqual(output, resultItem))
					Recipes.alloySmelter.getRecipes().remove(recipe);
			}
		}
	}

	public static void removeBlastFurnaceRecipe (ItemStack resultItem)
	{
		List<IBaseRecipeType> removalList = new ArrayList<IBaseRecipeType>(); 
		for(IBaseRecipeType recipe : RecipeHandler.recipeList) {
			for (ItemStack output : recipe.getOutputs()) {
				if (ItemStack.areItemsEqual(output, resultItem) && recipe.getRecipeName() == Reference.BLAST_FURNACE_RECIPE)
					removalList.add(recipe);
			}
		}
		for (IBaseRecipeType recipe : removalList)
			RecipeHandler.recipeList.remove(recipe);
	}

	public static void registerBOP() {

		Recipes.grinder.createRecipe().withInput(new ItemStack(BOPBlocks.white_sandstone)).withOutput(new ItemStack(BOPBlocks.white_sand)).withEnergyCostPerTick(2).withOperationDuration(300).register();
		Recipes.compressor.createRecipe().withInput(new ItemStack(BOPBlocks.white_sand, 4)).withOutput(new ItemStack(BOPBlocks.white_sandstone)).withEnergyCostPerTick(2).withOperationDuration(400).register();
	}

	public static void registerEX() {

		if(Config.KEPLER22B) {
			
			Recipes.compressor.createRecipe().withInput(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 8, 0)).withOutput(new ItemStack(TechRebornAPI.getItem("PARTS"), 1, 45)).withEnergyCostPerTick(2).withOperationDuration(400).register();  
			Recipes.compressor.createRecipe().withInput(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 8, 1)).withOutput(new ItemStack(TechRebornAPI.getItem("PARTS"), 1, 45)).withEnergyCostPerTick(2).withOperationDuration(400).register();  
			Recipes.compressor.createRecipe().withInput(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 8, 2)).withOutput(new ItemStack(TechRebornAPI.getItem("PARTS"), 1, 45)).withEnergyCostPerTick(2).withOperationDuration(400).register();  
			Recipes.compressor.createRecipe().withInput(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 8, 3)).withOutput(new ItemStack(TechRebornAPI.getItem("PARTS"), 1, 45)).withEnergyCostPerTick(2).withOperationDuration(400).register();  
			Recipes.compressor.createRecipe().withInput(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 8, 4)).withOutput(new ItemStack(TechRebornAPI.getItem("PARTS"), 1, 45)).withEnergyCostPerTick(2).withOperationDuration(400).register();  
			Recipes.compressor.createRecipe().withInput(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING, 8, 5)).withOutput(new ItemStack(TechRebornAPI.getItem("PARTS"), 1, 45)).withEnergyCostPerTick(2).withOperationDuration(400).register();
			
			RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 6), new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 6, 16), new ItemStack(TechRebornAPI.getItem("DUSTS"), 1, 13), null, 100, 64));
			RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 7), new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 6, 16), new ItemStack(TechRebornAPI.getItem("DUSTS"), 1, 13), null, 100, 64));
			RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 8), new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 6, 16), new ItemStack(TechRebornAPI.getItem("DUSTS"), 1, 13), null, 100, 64));
			RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 9), new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 6, 16), new ItemStack(TechRebornAPI.getItem("DUSTS"), 1, 13), null, 100, 64));
			RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 10), new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 6, 16), new ItemStack(TechRebornAPI.getItem("DUSTS"), 1, 13), null, 100, 64));
			
			RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 6), new FluidStack(FluidRegistry.getFluid("fluidmercury"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 2), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 3, 16), null, null, 100, 64));
			RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 7), new FluidStack(FluidRegistry.getFluid("fluidmercury"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 2, 1), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 3, 16), null, null, 100, 64));
			RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 8), new FluidStack(FluidRegistry.getFluid("fluidmercury"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 2, 2), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 3, 16), null, null, 100, 64));
			RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 9), new FluidStack(FluidRegistry.getFluid("fluidmercury"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 2, 3), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 3, 16), null, null, 100, 64));
			RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_BLOCKS, 1, 10), new FluidStack(FluidRegistry.getFluid("fluidmercury"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 2, 4), new ItemStack(TechRebornAPI.getItem("SMALL_DUSTS"), 3, 16), null, null, 100, 64));
			
			RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG), new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 1), new ItemStack(TechRebornAPI.getItem("DUSTS"), 3, 46), new ItemStack(Items.PAPER), 100, 128, false));
			RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 1), new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 1), new ItemStack(TechRebornAPI.getItem("DUSTS"), 3, 46), new ItemStack(Items.PAPER), 100, 128, false));
			RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 2), new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 2), new ItemStack(TechRebornAPI.getItem("DUSTS"), 3, 46), new ItemStack(Items.PAPER), 100, 128, false));
			RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG, 1, 3), new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 3), new ItemStack(TechRebornAPI.getItem("DUSTS"), 3, 46), new ItemStack(Items.PAPER), 100, 128, false));
			RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2), new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4 ,4), new ItemStack(TechRebornAPI.getItem("DUSTS"), 3, 46), new ItemStack(Items.PAPER), 100, 128, false));
			RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2, 1, 1), new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(ExtraPlanets_Blocks.KEPLER22B_MAPLE_PLANKS, 4, 5), new ItemStack(TechRebornAPI.getItem("DUSTS"), 3, 46), new ItemStack(Items.PAPER), 100, 128, false));
		}
		
		Recipes.grinder.createRecipe().withInput(new ItemStack(ExtraPlanets_Blocks.RED_SANDSTONE)).withOutput(new ItemStack(ExtraPlanets_Blocks.RED_SAND)).withEnergyCostPerTick(2).withOperationDuration(300).register();
		Recipes.compressor.createRecipe().withInput(new ItemStack(ExtraPlanets_Blocks.RED_SAND, 4)).withOutput(new ItemStack(ExtraPlanets_Blocks.RED_SANDSTONE)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.grinder.createRecipe().withInput(new ItemStack(ExtraPlanets_Blocks.ORANGE_SANDSTONE)).withOutput(new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND)).withEnergyCostPerTick(2).withOperationDuration(300).register();
		Recipes.compressor.createRecipe().withInput(new ItemStack(ExtraPlanets_Blocks.ORANGE_SAND, 4)).withOutput(new ItemStack(ExtraPlanets_Blocks.ORANGE_SANDSTONE)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.compressor.createRecipe().withInput(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 9, 6)).withOutput(new ItemStack(Items.DIAMOND)).withEnergyCostPerTick(2).withOperationDuration(400).register();
	}
	
	public static void registerGobber() {
		
		Block glob_plank = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_plank"));
		Block glob_log = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_log"));
		Block glob2_plank = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob2_plank"));
		Block glob2_log = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob2_log"));
		Block glob3_plank = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob3_plank"));
		Block glob3_log = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob3_log"));
		
		Item glob = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob"));
		Item nether_glob = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob2"));
		Item end_glob = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob3"));
		
		Item glob_crop = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globette"));
		Item nether_glob_crop = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globette2"));
		Item end_glob_crop = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globette3"));
		
		Recipes.compressor.createRecipe().withInput("cropGlob", 9).withOutput(new ItemStack(glob)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.compressor.createRecipe().withInput("cropNetherGlob", 9).withOutput(new ItemStack(nether_glob)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.compressor.createRecipe().withInput("cropEndGlob", 9).withOutput(new ItemStack(end_glob)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		
		Recipes.compressor.createRecipe().withInput("cropGlob", 4).withOutput(new ItemStack(TechRebornAPI.getItem("PARTS"), 1, 45)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.compressor.createRecipe().withInput("cropNetherGlob", 4).withOutput(new ItemStack(TechRebornAPI.getItem("PARTS"), 1, 45)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.compressor.createRecipe().withInput("cropEndGlob", 4).withOutput(new ItemStack(TechRebornAPI.getItem("PARTS"), 1, 45)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		
		Recipes.extractor.createRecipe().withInput(new ItemStack(glob_log, 8)).withOutput(new ItemStack(glob)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(glob2_log, 8)).withOutput(new ItemStack(nether_glob)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		Recipes.extractor.createRecipe().withInput(new ItemStack(glob3_log, 8)).withOutput(new ItemStack(end_glob)).withEnergyCostPerTick(2).withOperationDuration(400).register();
		
		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(glob_log, new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(glob_plank, 4), new ItemStack(TechRebornAPI.getItem("DUSTS"), 3, 46), new ItemStack(glob_crop, 2), 100, 128, false));
		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(glob2_log, new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(glob2_plank, 4), new ItemStack(TechRebornAPI.getItem("DUSTS"), 3, 46), new ItemStack(nether_glob_crop, 2), 100, 128, false));
		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(glob3_log, new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME), new ItemStack(glob3_plank, 4), new ItemStack(TechRebornAPI.getItem("DUSTS"), 3, 46), new ItemStack(end_glob_crop, 2), 100, 128, false));
	}
}
