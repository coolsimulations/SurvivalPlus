package net.coolsimulations.SurvivalPlus.core.compat;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class SurvivalPlusGobber {
	
	public static void init() {

		registerCrafting();
		registerOreDict();
	}
	
	private static final Block glob_plank = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_plank"));
	private static final Block glob_log = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_log"));
	private static final Block glob2_plank = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob2_plank"));
	private static final Block glob2_log = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob2_log"));
	private static final Block glob3_plank = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob3_plank"));
	private static final Block glob3_log = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob3_log"));
	
	public static void registerCrafting() {
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_planks_from_log"), null, new ItemStack(glob_plank), Ingredient.fromStacks(new ItemStack(glob_log)));
		GameRegistry.addShapelessRecipe(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob2_planks_from_log"), null, new ItemStack(glob2_plank), Ingredient.fromStacks(new ItemStack(glob2_log)));
		GameRegistry.addShapelessRecipe(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob3_planks_from_log"), null, new ItemStack(glob3_plank), Ingredient.fromStacks(new ItemStack(glob3_log)));
	}
	
	public static void registerOreDict() {
		
		Item glob_seed = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob_seed"));
		Item glob2_seed = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob2_seed"));
		Item glob3_seed = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "glob3_seed"));
		
		Item glob_crop = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globette"));
		Item glob2_crop = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globette2"));
		Item glob3_crop = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globette3"));
		
		Item ingot_gobber = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot"));
		Item ingot_nether_gobber = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot2"));
		Item ingot_end_gobber = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot3"));
		
		Block block_gobber = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot_block"));
		Block block_nether_gobber = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot2_block"));
		Block block_end_gobber = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "globot3_block"));
		
		Item plate_gobber = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GOBBER_MODID, "garmor_repair"));
		
		OreDictionary.registerOre("logWood", new ItemStack(glob_log));
		OreDictionary.registerOre("logWood", new ItemStack(glob2_log));
		OreDictionary.registerOre("logWood", new ItemStack(glob3_log));
		
		OreDictionary.registerOre("plankWood", new ItemStack(glob_plank));
		OreDictionary.registerOre("plankWood", new ItemStack(glob2_plank));
		OreDictionary.registerOre("plankWood", new ItemStack(glob3_plank));
		
		OreDictionary.registerOre("seedGlob", new ItemStack(glob_seed));
		OreDictionary.registerOre("seedNetherGlob", new ItemStack(glob2_seed));
		OreDictionary.registerOre("seedEndGlob", new ItemStack(glob3_seed));
		
		OreDictionary.registerOre("cropGlob", new ItemStack(glob_crop));
		OreDictionary.registerOre("cropNetherGlob", new ItemStack(glob2_crop));
		OreDictionary.registerOre("cropEndGlob", new ItemStack(glob3_crop));
		
		OreDictionary.registerOre("ingotGobber", new ItemStack(ingot_gobber));
		OreDictionary.registerOre("ingotNetherGobber", new ItemStack(ingot_nether_gobber));
		OreDictionary.registerOre("ingotEndGobber", new ItemStack(ingot_end_gobber));
		
		OreDictionary.registerOre("blockGobber", new ItemStack(block_gobber));
		OreDictionary.registerOre("blockNetherGobber", new ItemStack(block_nether_gobber));
		OreDictionary.registerOre("blockEndGobber", new ItemStack(block_end_gobber));
		
		OreDictionary.registerOre("plateGobber", new ItemStack(plate_gobber));
		
	}

}
