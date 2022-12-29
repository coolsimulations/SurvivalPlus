package net.coolsimulations.SurvivalPlus.core.compat;

import java.util.Iterator;
import java.util.function.Supplier;

import ic2.api.recipes.RecipeRegistry;
import ic2.api.recipes.ingridients.inputs.IInput;
import ic2.api.recipes.ingridients.inputs.ItemTagInput;
import ic2.api.recipes.ingridients.recipes.IRecipeOutput;
import ic2.api.recipes.misc.RecipeMods;
import ic2.api.recipes.registries.IAdvancedCraftingManager;
import ic2.api.recipes.registries.IAdvancedCraftingManager.SmeltingType;
import ic2.api.recipes.registries.IMachineRecipeList;
import ic2.api.recipes.registries.IMachineRecipeList.RecipeEntry;
import ic2.api.recipes.registries.IRefiningRecipeList;
import ic2.api.recipes.registries.IRefiningRecipeList.FluidRecipe;
import ic2.core.IC2;
import ic2.core.platform.recipes.crafting.RecipeIC2Base;
import ic2.core.platform.recipes.crafting.helpers.DamagedInput;
import ic2.core.platform.recipes.misc.AdvRecipeRegistry;
import ic2.core.platform.registries.IC2Blocks;
import ic2.core.platform.registries.IC2Fluids;
import ic2.core.platform.registries.IC2Items;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTags;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class SurvivalPlusIC2 {

	public static void init() {

		SurvivalPlusArmor.ITEMS_RUBBER_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusItems.ITEMS_IC2.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	public static void setup() {

		RecipeRegistry.MACERATOR.get(true).registerListener(SurvivalPlusIC2::registerMacerator);
		RecipeRegistry.COMPRESSOR.get(true).registerListener(SurvivalPlusIC2::registerCompressor);
		RecipeRegistry.EXTRACTOR.get(true).registerListener(SurvivalPlusIC2::registerExtractor);
		RecipeRegistry.RECYCLER.get(true).registerListener(SurvivalPlusIC2::registerRecycler);
		RecipeRegistry.MIXING_FURNACE.get(true).registerListener(SurvivalPlusIC2::registerAlloySmelter);
		RecipeRegistry.CRAFTING.registerListener(SurvivalPlusIC2::registerCrafting);
		IC2.RECIPES.get(true).refining.registerListener(SurvivalPlusIC2::registerRefinery);

		IC2.CONFIG.disableBronzeArmor.set(true);
		IC2.CONFIG.disableBronzeTools.set(true);
		IC2.CONFIG.save();
	}

	public static void registerMacerator(IMachineRecipeList registry) {
		
		removeMaceratorRecipe(new ItemStack(IC2Blocks.TIN_BLOCK));
		
		registry.addIC2XPRecipe("raw_tin_block_to_dust", new ItemStack(IC2Items.DUST_TIN, 18), 3.6f, RecipeMods.RECIPE_TIME.create(4.0), new Object[]{SPTags.Blocks.STORAGE_BLOCKS_RAW_TIN});
		registry.addIC2XPRecipe("tin_block_to_dust", new ItemStack(IC2Items.DUST_TIN, 9), 0.9f, RecipeMods.RECIPE_TIME.create(4.0), new Object[]{SPTags.Blocks.STORAGE_BLOCKS_TIN});

		registry.addXPRecipe(new ResourceLocation(SPReference.MOD_ID, "titanium_ore_to_dust"), new ItemStack(SPItems.titanium_dust.get(), 2), 0.8F, new Object[] {SPTags.Blocks.ORES_TITANIUM});
		registry.addXPRecipe(new ResourceLocation(SPReference.MOD_ID, "raw_titanium_to_dust"), new ItemStack(SPItems.titanium_dust.get(), 2), 0.8F, new Object[] {SPTags.Items.RAW_ORES_TITANIUM});
		registry.addXPRecipe(new ResourceLocation(SPReference.MOD_ID, "raw_titanium_block_to_dust"), new ItemStack(SPItems.titanium_dust.get(), 18), 7.2F, RecipeMods.RECIPE_TIME.create(4.0), new Object[] {SPTags.Blocks.STORAGE_BLOCKS_RAW_TITANIUM});
		registry.addXPRecipe(new ResourceLocation(SPReference.MOD_ID, "titanium_block_to_dust"), new ItemStack(SPItems.titanium_dust.get(), 9), 0.8F, RecipeMods.RECIPE_TIME.create(4.0), new Object[] {SPTags.Blocks.STORAGE_BLOCKS_TITANIUM});
		registry.addXPRecipe(new ResourceLocation(SPReference.MOD_ID, "titanium_inot_to_dust"), new ItemStack(SPItems.titanium_dust.get()), 0.8F, new Object[] {SPTags.Items.INGOTS_TITANIUM});
	}

	public static void registerCompressor(IMachineRecipeList registry) {

		registry.addSimpleRecipe(new ResourceLocation(SPReference.MOD_ID, "titanium_dense_plate"), new ItemStack(SPItems.titanium_dense_plate.get()), new Object[] {new ItemTagInput(SPTags.Items.INGOTS_TITANIUM, 8)});
	}

	public static void registerExtractor(IMachineRecipeList registry) {

		registry.addSimpleRecipe(new ResourceLocation(SPReference.MOD_ID, "onion_extraction"), new ItemStack(Items.WHITE_DYE, 2), new Object[] {SPTags.Items.CROPS_ONION});
	}

	public static void registerRecycler(IMachineRecipeList registry) {

		removeRecyclerRecipe(new ItemStack(IC2Items.AXE_BRONZE));
		removeRecyclerRecipe(new ItemStack(IC2Items.PICKAXE_BRONZE));
		removeRecyclerRecipe(new ItemStack(IC2Items.SHOVEL_BRONZE));
		removeRecyclerRecipe(new ItemStack(IC2Items.HOE_BRONZE));
		removeRecyclerRecipe(new ItemStack(IC2Items.SWORD_BRONZE));
		removeRecyclerRecipe(new ItemStack(IC2Items.BRONZE_HELMET));
		removeRecyclerRecipe(new ItemStack(IC2Items.BRONZE_CHEST));
		removeRecyclerRecipe(new ItemStack(IC2Items.BRONZE_LEGGINGS));
		removeRecyclerRecipe(new ItemStack(IC2Items.BRONZE_BOOTS));

		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_shears_iron"), new ItemStack(Items.IRON_INGOT), 0, 2, new DamagedInput(Items.SHEARS).setUndamaged());
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_damaged_shears_iron"), new ItemStack(IC2Items.SCRAP_METAL), 0, 2, new DamagedInput(Items.SHEARS));

		registry.addIC2RangeRecipe("recycling_axe_bronze", new ItemStack(SPItems.bronze_ingot.get()), 0, 3, new DamagedInput(SPItems.bronze_axe.get()).setUndamaged());
		registry.addIC2RangeRecipe("recycling_pickaxe_bronze", new ItemStack(SPItems.bronze_ingot.get()), 0, 3, new DamagedInput(SPItems.bronze_pickaxe.get()).setUndamaged());
		registry.addIC2RangeRecipe("recycling_shovel_bronze", new ItemStack(SPItems.bronze_ingot.get()), 0, 1, new DamagedInput(SPItems.bronze_shovel.get()).setUndamaged());
		registry.addIC2RangeRecipe("recycling_hoe_bronze", new ItemStack(SPItems.bronze_ingot.get()), 0, 2, new DamagedInput(SPItems.bronze_hoe.get()).setUndamaged());
		registry.addIC2RangeRecipe("recycling_sword_bronze", new ItemStack(SPItems.bronze_ingot.get()), 0, 2, new DamagedInput(SPItems.bronze_sword.get()).setUndamaged());
		registry.addIC2RangeRecipe("recycling_helmet_bronze", new ItemStack(SPItems.bronze_ingot.get()), 0, 2, new DamagedInput(SPItems.bronze_helmet.get()).setUndamaged());
		registry.addIC2RangeRecipe("recycling_chestplate_bronze", new ItemStack(SPItems.bronze_ingot.get()), 0, 8, new DamagedInput(SPItems.bronze_chestplate.get()).setUndamaged());
		registry.addIC2RangeRecipe("recycling_leggings_bronze", new ItemStack(SPItems.bronze_ingot.get()), 0, 7, new DamagedInput(SPItems.bronze_leggings.get()).setUndamaged());
		registry.addIC2RangeRecipe("recycling_boots_bronze", new ItemStack(SPItems.bronze_ingot.get()), 0, 4, new DamagedInput(SPItems.bronze_boots.get()).setUndamaged());

		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_shears_bronze"), new ItemStack(SPItems.bronze_ingot.get()), 0, 2, new DamagedInput(SPItems.bronze_shears.get()).setUndamaged());

		registry.addIC2RangeRecipe("recycling_damaged_axe_bronze", new ItemStack(IC2Items.SCRAP_METAL), 0, 3, new DamagedInput(SPItems.bronze_axe.get()));
		registry.addIC2RangeRecipe("recycling_damaged_pickaxe_bronze", new ItemStack(IC2Items.SCRAP_METAL), 0, 3, new DamagedInput(SPItems.bronze_pickaxe.get()));
		registry.addIC2RangeRecipe("recycling_damaged_shovel_bronze", new ItemStack(IC2Items.SCRAP_METAL), 0, 1, new DamagedInput(SPItems.bronze_shovel.get()));
		registry.addIC2RangeRecipe("recycling_damaged_hoe_bronze", new ItemStack(IC2Items.SCRAP_METAL), 0, 2, new DamagedInput(SPItems.bronze_hoe.get()));
		registry.addIC2RangeRecipe("recycling_damaged_sword_bronze", new ItemStack(IC2Items.SCRAP_METAL), 0, 2, new DamagedInput(SPItems.bronze_sword.get()));
		registry.addIC2RangeRecipe("recycling_damaged_helmet_bronze", new ItemStack(IC2Items.SCRAP_METAL), 0, 2, new DamagedInput(SPItems.bronze_helmet.get()));
		registry.addIC2RangeRecipe("recycling_damaged_chestplate_bronze", new ItemStack(IC2Items.SCRAP_METAL), 0, 8, new DamagedInput(SPItems.bronze_chestplate.get()));
		registry.addIC2RangeRecipe("recycling_damaged_leggings_bronze", new ItemStack(IC2Items.SCRAP_METAL), 0, 7, new DamagedInput(SPItems.bronze_leggings.get()));
		registry.addIC2RangeRecipe("recycling_damaged_boots_bronze", new ItemStack(IC2Items.SCRAP_METAL), 0, 4, new DamagedInput(SPItems.bronze_boots.get()));

		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_damaged_shears_bronze"), new ItemStack(IC2Items.SCRAP_METAL), 0, 2, new DamagedInput(SPItems.bronze_shears.get()));

		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_axe_titanium"), new ItemStack(SPItems.titanium_ingot.get()), 0, 3, new DamagedInput(SPItems.titanium_axe.get()).setUndamaged());
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_pickaxe_titanium"), new ItemStack(SPItems.titanium_ingot.get()), 0, 3, new DamagedInput(SPItems.titanium_pickaxe.get()).setUndamaged());
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_shovel_titanium"), new ItemStack(SPItems.titanium_ingot.get()), 0, 1, new DamagedInput(SPItems.titanium_shovel.get()).setUndamaged());
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_hoe_titanium"), new ItemStack(SPItems.titanium_ingot.get()), 0, 2, new DamagedInput(SPItems.titanium_hoe.get()).setUndamaged());
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_sword_titanium"), new ItemStack(SPItems.titanium_ingot.get()), 0, 2, new DamagedInput(SPItems.titanium_sword.get()).setUndamaged());
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_helmet_titanium"), new ItemStack(SPItems.titanium_ingot.get()), 0, 2, new DamagedInput(SPItems.titanium_helmet.get()).setUndamaged());
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_chestplate_titanium"), new ItemStack(SPItems.titanium_ingot.get()), 0, 8, new DamagedInput(SPItems.titanium_chestplate.get()).setUndamaged());
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_leggings_titanium"), new ItemStack(SPItems.titanium_ingot.get()), 0, 7, new DamagedInput(SPItems.titanium_leggings.get()).setUndamaged());
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_boots_titanium"), new ItemStack(SPItems.titanium_ingot.get()), 0, 4, new DamagedInput(SPItems.titanium_boots.get()).setUndamaged());
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_shears_titanium"), new ItemStack(SPItems.titanium_ingot.get()), 0, 2, new DamagedInput(SPItems.titanium_shears.get()).setUndamaged());
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_dense_plate_titanium"), new ItemStack(SPItems.titanium_ingot.get()), 0, 8, new DamagedInput(SPItems.titanium_dense_plate.get()).setUndamaged());

		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_damaged_axe_titanium"), new ItemStack(IC2Items.SCRAP_METAL), 0, 3, new DamagedInput(SPItems.titanium_axe.get()));
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_damaged_pickaxe_titanium"), new ItemStack(IC2Items.SCRAP_METAL), 0, 3, new DamagedInput(SPItems.titanium_pickaxe.get()));
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_damaged_shovel_titanium"), new ItemStack(IC2Items.SCRAP_METAL), 0, 1, new DamagedInput(SPItems.titanium_shovel.get()));
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_damaged_hoe_titanium"), new ItemStack(IC2Items.SCRAP_METAL), 0, 2, new DamagedInput(SPItems.titanium_hoe.get()));
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_damaged_sword_titanium"), new ItemStack(IC2Items.SCRAP_METAL), 0, 2, new DamagedInput(SPItems.titanium_sword.get()));
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_damaged_helmet_titanium"), new ItemStack(IC2Items.SCRAP_METAL), 0, 2, new DamagedInput(SPItems.titanium_helmet.get()));
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_damaged_chestplate_titanium"), new ItemStack(IC2Items.SCRAP_METAL), 0, 8, new DamagedInput(SPItems.titanium_chestplate.get()));
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_damaged_leggings_titanium"), new ItemStack(IC2Items.SCRAP_METAL), 0, 7, new DamagedInput(SPItems.titanium_leggings.get()));
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_damaged_boots_titanium"), new ItemStack(IC2Items.SCRAP_METAL), 0, 4, new DamagedInput(SPItems.titanium_boots.get()));
		registry.addRangeRecipe(new ResourceLocation(SPReference.MOD_ID, "recycling_damaged_shears_titanium"), new ItemStack(IC2Items.SCRAP_METAL), 0, 2, new DamagedInput(SPItems.titanium_shears.get()));
	}

	public static void registerAlloySmelter(IMachineRecipeList registry) {
		
		removeAlloySmelterRecipe(new ItemStack(IC2Items.INGOT_BRONZE));
		removeAlloySmelterRecipe(new ItemStack(IC2Blocks.BRONZE_BLOCK));

		registry.addIC2SimpleRecipe("bronze_ore", new ItemStack(SPItems.bronze_ingot.get(), 8), new Object[]{new ItemTagInput(Tags.Items.ORES_COPPER, 3), SPTags.Blocks.ORES_TIN});
		registry.addIC2SimpleRecipe("bronze_ore_raw_copper", new ItemStack(SPItems.bronze_ingot.get(), 8), new Object[]{new ItemTagInput(Tags.Items.RAW_MATERIALS_COPPER, 3), SPTags.Blocks.ORES_TIN});
		registry.addIC2SimpleRecipe("bronze_ore_raw_tin", new ItemStack(SPItems.bronze_ingot.get(), 8), new Object[]{new ItemTagInput(Tags.Items.ORES_COPPER, 3), SPTags.Items.RAW_ORES_TIN});
		registry.addIC2SimpleRecipe("bronze_raw", new ItemStack(SPItems.bronze_ingot.get(), 8), new Object[]{new ItemTagInput(Tags.Items.RAW_MATERIALS_COPPER, 3), SPTags.Items.RAW_ORES_TIN});
		registry.addSimpleRecipe(new ResourceLocation(SPReference.MOD_ID, "bronze_ore_raw_copper_block"), new ItemStack(SPItems.bronze_ingot.get(), 24), new Object[]{new ItemTagInput(Tags.Items.STORAGE_BLOCKS_RAW_COPPER), new ItemTagInput(SPTags.Items.ORES_TIN, 3)});
		registry.addSimpleRecipe(new ResourceLocation(SPReference.MOD_ID, "bronze_ore_raw_tin_block"), new ItemStack(SPItems.bronze_ingot.get(), 24), new Object[]{new ItemTagInput(Tags.Items.ORES_COPPER, 27), SPTags.Blocks.STORAGE_BLOCKS_RAW_TIN});
		registry.addSimpleRecipe(new ResourceLocation(SPReference.MOD_ID, "bronze_raw_block_raw_copper"), new ItemStack(SPItems.bronze_ingot.get(), 24), new Object[]{new ItemTagInput(Tags.Items.STORAGE_BLOCKS_RAW_COPPER), new ItemTagInput(SPTags.Items.RAW_ORES_TIN, 3)});
		registry.addSimpleRecipe(new ResourceLocation(SPReference.MOD_ID, "bronze_raw_block_raw_tin"), new ItemStack(SPItems.bronze_ingot.get(), 24), new Object[]{new ItemTagInput(Tags.Items.RAW_MATERIALS_COPPER, 27), SPTags.Blocks.STORAGE_BLOCKS_RAW_TIN});
		registry.addIC2SimpleRecipe("bronze_dust", new ItemStack(SPItems.bronze_ingot.get(), 4), new Object[]{new ItemTagInput(SPTags.Items.DUSTS_COPPER, 3), SPTags.Items.DUSTS_TIN});
		registry.addIC2SimpleRecipe("bronze_ingot", new ItemStack(SPItems.bronze_ingot.get(), 4), new Object[]{new ItemTagInput(Tags.Items.INGOTS_COPPER, 3), SPTags.Items.INGOTS_TIN});

		registry.addIC2SimpleRecipe("bronze_block", new ItemStack(SPBlocks.bronze_block.get(), 4), new Object[]{new ItemTagInput(Tags.Items.STORAGE_BLOCKS_COPPER, 3), SPTags.Blocks.STORAGE_BLOCKS_TIN});
		registry.addIC2SimpleRecipe("bronze_block", new ItemStack(SPBlocks.bronze_block.get(), 4), new Object[]{new ItemStack(IC2Blocks.DUST_COPPER_BLOCK, 3), new ItemStack(IC2Blocks.DUST_TIN_BLOCK)});
		registry.addIC2SimpleRecipe("bronze_mixed", new ItemStack(SPItems.bronze_ingot.get(), 12), new Object[]{Tags.Blocks.STORAGE_BLOCKS_COPPER, new ItemTagInput(SPTags.Items.INGOTS_TIN, 3)});
		registry.addIC2SimpleRecipe("bronze_mixed_2", new ItemStack(SPItems.bronze_ingot.get(), 36), new Object[]{new ItemTagInput(Tags.Items.INGOTS_COPPER, 27), SPTags.Blocks.STORAGE_BLOCKS_TIN});
	}
	
	public static void registerRefinery(IRefiningRecipeList registry) {
		
		removeRefineryRecipe(new ItemStack(IC2Items.RAW_TIN));
		
		registry.addIC2Recipe("tin_to_raw").addMod(RecipeMods.RECIPE_TIME, 0.5).catalyst(SPTags.Items.ORES_TIN).mainInput(Fluids.LAVA, 25 * 3).buildRange(new ItemStack(SPItems.raw_tin.get()), 3, 3 * 3);
		registry.addIC2Recipe("tin_to_raw" + "_advanced").addMod(RecipeMods.RECIPE_TIME, 0.5).catalyst(SPTags.Items.ORES_TIN).mainInput(IC2Fluids.BIO_FUEL, 50 * 3).buildRange(new ItemStack(SPItems.raw_tin.get()), 3 * 3, 3 * 5);
		registry.addIC2Recipe("tin_to_raw" + "_alk").addMod(RecipeMods.RECIPE_TIME, 0.5).catalyst(SPTags.Items.ORES_TIN).mainInput(IC2Fluids.ALCOHOL, 25 * 3).buildRange(new ItemStack(SPItems.raw_tin.get()), 3 * 5, 3 * 7);
		
		registry.addRecipe(new ResourceLocation(SPReference.MOD_ID, "titanium_to_raw")).addMod(RecipeMods.RECIPE_TIME, 0.5).catalyst(SPTags.Items.ORES_TITANIUM).mainInput(Fluids.LAVA, 25 * 1).buildRange(new ItemStack(SPItems.raw_titanium.get()), 1, 1 * 3);
		registry.addRecipe(new ResourceLocation(SPReference.MOD_ID, "titanium_to_raw" + "_advanced")).addMod(RecipeMods.RECIPE_TIME, 0.5).catalyst(SPTags.Items.ORES_TITANIUM).mainInput(IC2Fluids.BIO_FUEL, 50 * 1).buildRange(new ItemStack(SPItems.raw_titanium.get()), 1 * 3, 1 * 5);
		registry.addRecipe(new ResourceLocation(SPReference.MOD_ID, "titanium_to_raw" + "_alk")).addMod(RecipeMods.RECIPE_TIME, 0.5).catalyst(SPTags.Items.ORES_TITANIUM).mainInput(IC2Fluids.ALCOHOL, 25 * 1).buildRange(new ItemStack(SPItems.raw_titanium.get()), 1 * 5, 1 * 7);
	}

	public static void registerCrafting(IAdvancedCraftingManager registry) {

		removeCraftingRecipe(new ItemStack(IC2Items.BRONZE_SIGN_ITEM));
		removeCraftingRecipe(new ItemStack(IC2Items.TIN_SIGN_ITEM));
		removeCraftingRecipe(new ItemStack(IC2Items.INGOT_BRONZE));
		removeSmeltingRecipe(new ItemStack(IC2Items.INGOT_BRONZE));
		removeCraftingRecipe(new ItemStack(IC2Blocks.BRONZE_BLOCK));
		removeSmeltingRecipe(new ItemStack(IC2Blocks.BRONZE_BLOCK));
		removeCraftingRecipe(new ItemStack(IC2Items.INGOT_TIN));
		removeSmeltingRecipe(new ItemStack(IC2Items.INGOT_TIN));
		removeCraftingRecipe(new ItemStack(IC2Blocks.TIN_BLOCK));
		removeSmeltingRecipe(new ItemStack(IC2Blocks.TIN_BLOCK));
		removeCraftingRecipe(new ItemStack(IC2Blocks.RAW_TIN_BLOCK));

		registry.addShapedRecipe(new ResourceLocation(SPReference.MOD_ID, "glass_fiber_2"), new ItemStack(IC2Items.GLASSFIBER_CABLE, 2), new Object[]{"GGG", "ETE", "GGG", Character.valueOf('G'), Tags.Items.GLASS, Character.valueOf('E'), Tags.Items.DUSTS_REDSTONE, Character.valueOf('T'), SPTags.Items.DUSTS_TITANIUM});
		registry.addShapedIC2Recipe("bronze_sign", new ItemStack(IC2Items.BRONZE_SIGN_ITEM), new Object[]{"XXX", "XXX", " # ", Character.valueOf('#'), Tags.Items.RODS_WOODEN, Character.valueOf('X'), SPTags.Items.INGOTS_BRONZE});	
		registry.addShapedIC2Recipe("tin_sign", new ItemStack(IC2Items.TIN_SIGN_ITEM), new Object[]{"XXX", "XXX", " # ", Character.valueOf('#'), Tags.Items.RODS_WOODEN, Character.valueOf('X'), SPTags.Items.INGOTS_TIN});

		registry.addIC2SmeltingRecipe("bronze_dust_block_furnace", new ItemStack(SPBlocks.bronze_block.get()), new ItemStack(IC2Blocks.DUST_BRONZE_BLOCK), SmeltingType.FURNACE);
		registry.addIC2SmeltingRecipe("bronze_dust_block_blast", new ItemStack(SPBlocks.bronze_block.get()), new ItemStack(IC2Blocks.DUST_BRONZE_BLOCK), SmeltingType.BLASTFURNACE);

		registry.addIC2SmeltingRecipe("tin_dust_block_furnace", new ItemStack(SPBlocks.tin_block.get()), new ItemStack(IC2Blocks.DUST_TIN_BLOCK), SmeltingType.FURNACE);
		registry.addIC2SmeltingRecipe("tin_dust_block_blast", new ItemStack(SPBlocks.tin_block.get()), new ItemStack(IC2Blocks.DUST_TIN_BLOCK), SmeltingType.BLASTFURNACE);
	}

	public static void removeCraftingRecipe(ItemStack resultItem) {

		Iterable<RecipeIC2Base> recipes = AdvRecipeRegistry.INSTANCE.getRecipes();
		for(Iterator<RecipeIC2Base> entries = recipes.iterator(); entries.hasNext(); ) {
			RecipeIC2Base entry = entries.next();
			ItemStack stackResult = entry.getResultItem();
			if (ItemStack.isSame(stackResult, resultItem)){ // If the output matches the specified ItemStack,
				entries.remove(); // Remove the recipe
			}
		}
	}

	public static void removeSmeltingRecipe(ItemStack resultItem) {

		Iterable<Supplier<AbstractCookingRecipe>> recipes = AdvRecipeRegistry.INSTANCE.getCooking();
		for(Iterator<Supplier<AbstractCookingRecipe>> entries = recipes.iterator(); entries.hasNext(); ) {
			Supplier<AbstractCookingRecipe> entry = entries.next();
			ItemStack stackResult = entry.get().getResultItem();
			if (ItemStack.isSame(stackResult, resultItem)){ // If the output matches the specified ItemStack,
				entries.remove(); // Remove the recipe
			}
		}
	}

	public static void removeRecyclerRecipe(ItemStack resultItem) {

		Iterable<RecipeEntry> recipes = IC2.RECIPES.get().recycler.getAllEntries();
		for(Iterator<RecipeEntry> entries = recipes.iterator(); entries.hasNext(); ) {
			RecipeEntry entry = entries.next();
			for (IInput inputs : entry.getInputs()) {
				for (ItemStack stackResult : inputs.getComponents()) {
					if (ItemStack.isSame(stackResult, resultItem)){ // If the input matches the specified ItemStack,
						entries.remove(); // Remove the recipe
					}
				}
			}
		}
	}

	public static void removeAlloySmelterRecipe(ItemStack resultItem) {

		Iterable<RecipeEntry> recipes = IC2.RECIPES.get().mixingFurnace.getAllEntries();
		for(Iterator<RecipeEntry> entries = recipes.iterator(); entries.hasNext(); ) {
			RecipeEntry entry = entries.next();
			IRecipeOutput outputs = entry.getOutput();
			for (ItemStack stackResult : outputs.getAllOutputs()) { 
				if (ItemStack.isSame(stackResult, resultItem)){ // If the output matches the specified ItemStack,
					entries.remove(); // Remove the recipe
				}
			}
		}
	}
	
	public static void removeMaceratorRecipe(ItemStack resultItem) {

		Iterable<RecipeEntry> recipes = IC2.RECIPES.get().macerator.getAllEntries();
		for(Iterator<RecipeEntry> entries = recipes.iterator(); entries.hasNext(); ) {
			RecipeEntry entry = entries.next();
			for (IInput inputs : entry.getInputs()) {
				for (ItemStack stackResult : inputs.getComponents()) {
					if (ItemStack.isSame(stackResult, resultItem)){ // If the input matches the specified ItemStack,
						entries.remove(); // Remove the recipe
					}
				}
			}
		}
	}	
	
	public static void removeRefineryRecipe(ItemStack resultItem) {

		Iterable<FluidRecipe> recipes = IC2.RECIPES.get().refining.getAllRecipes();
		for(Iterator<FluidRecipe> entries = recipes.iterator(); entries.hasNext(); ) {
			FluidRecipe entry = entries.next();
			IRecipeOutput outputs = entry.getOutput();
			for (ItemStack stackResult : outputs.getAllOutputs()) { 
				if (ItemStack.isSame(stackResult, resultItem)){ // If the output matches the specified ItemStack,
					entries.remove(); // Remove the recipe
				}
			}
		}
	}

}
