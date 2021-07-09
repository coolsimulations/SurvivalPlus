package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.item.SPItemIngot;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;

public class SurvivalPlusItems {
	
	public static void init() {

		SPItems.tin_ingot = new SPItemIngot(true, 20.0F);
		SPItems.copper_ingot = new SPItemIngot();
		SPItems.onion_seeds = new ItemNameBlockItem(SPBlocks.onion, new FabricItemSettings().group(SPTabs.tabMaterials));
		SPItems.bronze_ingot = new SPItemIngot();
		SPItems.bronze_nugget = new Item(new FabricItemSettings().group(SPTabs.tabMaterials));
		SPItems.titanium_ingot = new SPItemIngot(true, 50.0F);
		SPItems.titanium_nugget = new Item(new FabricItemSettings().group(SPTabs.tabMaterials));
		SPItems.charcoal_bucket = new Item(new FabricItemSettings().group(SPTabs.tabMaterials).maxCount(1).recipeRemainder(Items.BUCKET));
		SPItems.paper_cup = new Item(new FabricItemSettings().group(SPTabs.tabMaterials));
		
		if(SPCompatibilityManager.isRefinedMachineryLoaded() || SPCompatibilityManager.isMechanixLoaded() || SPCompatibilityManager.isIndustrialRevolutionLoaded())
			SPItems.titanium_dust = new Item(new FabricItemSettings().group(SPTabs.tabMaterials));
		
		if(SPCompatibilityManager.isModernIndustrializationLoaded()) {
			SPItems.titanium_crushed_dust = new Item(new FabricItemSettings().group(SPTabs.tabMaterials));
			SPItems.titanium_tiny_dust = new Item(new FabricItemSettings().group(SPTabs.tabMaterials));
		}
		
		if(SPCompatibilityManager.isMechanixLoaded()) {
			SPItems.copper_dust = new Item(new FabricItemSettings().group(SPTabs.tabMaterials));
			SPItems.tin_dust = new Item(new FabricItemSettings().group(SPTabs.tabMaterials));
		}

	}
	
	public static void register()
	{
		registerItem(SPItems.tin_ingot, "tin_ingot");
		registerItem(SPItems.copper_ingot, "copper_ingot");
		registerItem(SPItems.onion_seeds, "onion_seeds");
		registerItem(SPItems.bronze_ingot, "bronze_ingot");
		registerItem(SPItems.bronze_nugget, "bronze_nugget");
		registerItem(SPItems.titanium_ingot, "titanium_ingot");
		registerItem(SPItems.titanium_nugget, "titanium_nugget");
		registerItem(SPItems.charcoal_bucket, "charcoal_bucket");
		registerItem(SPItems.paper_cup, "paper_cup");
		
		if(SPCompatibilityManager.isRefinedMachineryLoaded() || SPCompatibilityManager.isMechanixLoaded() || SPCompatibilityManager.isIndustrialRevolutionLoaded())
			registerItem(SPItems.titanium_dust, "titanium_dust");
		
		if(SPCompatibilityManager.isModernIndustrializationLoaded()) {
			registerItem(SPItems.titanium_crushed_dust, "titanium_crushed_dust");
			registerItem(SPItems.titanium_tiny_dust, "titanium_tiny_dust");
		}
		
		if(SPCompatibilityManager.isMechanixLoaded()) {
			registerItem(SPItems.copper_dust, "copper_dust");
			registerItem(SPItems.tin_dust, "tin_dust");
		}
	}
	
	public static void registerItem(Item item, String registryName) {

		Registry.register(Registry.ITEM, new ResourceLocation(SPReference.MOD_ID, registryName), item);
	}

}
