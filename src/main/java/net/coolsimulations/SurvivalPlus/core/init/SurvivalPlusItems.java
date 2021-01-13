package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.item.SPItemIngot;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SurvivalPlusItems {
	
	public static void init() {

		SPItems.tin_ingot = new SPItemIngot(true);
		SPItems.copper_ingot = new SPItemIngot(true);
		SPItems.onion_seeds = new AliasedBlockItem(SPBlocks.onion, new FabricItemSettings().group(SPTabs.tabMaterials));
		SPItems.bronze_ingot = new SPItemIngot(true);
		SPItems.bronze_nugget = new Item(new FabricItemSettings().group(SPTabs.tabMaterials));
		SPItems.titanium_ingot = new SPItemIngot(true);
		SPItems.titanium_nugget = new Item(new FabricItemSettings().group(SPTabs.tabMaterials));
		SPItems.charcoal_bucket = new Item(new FabricItemSettings().group(SPTabs.tabMaterials).maxCount(1).recipeRemainder(Items.BUCKET));
		SPItems.paper_cup = new Item(new FabricItemSettings().group(SPTabs.tabMaterials));
		
		if(SPCompatibilityManager.isRefinedMachineryLoaded())
			SPItems.titanium_dust = new Item(new FabricItemSettings().group(SPTabs.tabMaterials));

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
		
		if(SPCompatibilityManager.isRefinedMachineryLoaded())
			registerItem(SPItems.titanium_dust, "titanium_dust");
	}
	
	public static void registerItem(Item item, String registryName) {

		Registry.register(Registry.ITEM, new Identifier(SPReference.MOD_ID, registryName), item);
	}

}
