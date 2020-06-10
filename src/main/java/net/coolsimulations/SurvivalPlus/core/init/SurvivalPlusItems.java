package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.item.SPItemIngot;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusItems {
	
	public static void init() {
		
		SPItems.tin_ingot = new SPItemIngot(true).setRegistryName("tin_ingot");
		SPItems.copper_ingot = new SPItemIngot(true).setRegistryName("copper_ingot");
		SPItems.onion_seeds = new BlockNamedItem(SPBlocks.onion, new Item.Properties().group(SPTabs.tabMaterials)).setRegistryName("onion_seeds");
		SPItems.bronze_ingot = new SPItemIngot(true).setRegistryName("bronze_ingot");
		SPItems.bronze_nugget = new Item(new Item.Properties().group(SPTabs.tabMaterials)).setRegistryName("bronze_nugget");
		SPItems.titanium_ingot = new SPItemIngot(true).setRegistryName("titanium_ingot");
		SPItems.titanium_nugget = new Item(new Item.Properties().group(SPTabs.tabMaterials)).setRegistryName("titanium_nugget");
		SPItems.charcoal_bucket = new Item(new Item.Properties().group(SPTabs.tabMaterials).maxStackSize(1).containerItem(Items.BUCKET)).setRegistryName("charcoal_bucket");
		SPItems.paper_cup = new Item(new Item.Properties().group(SPTabs.tabMaterials)).setRegistryName("paper_cup");
		
		if(SPCompatibilityManager.isSimpleGrinderLoaded() || SPCompatibilityManager.isIc2Loaded() || SPCompatibilityManager.isSilentMechanismsLoaded())
		{
			SPItems.titanium_dust = new Item(new Item.Properties().group(SPTabs.tabMaterials)).setRegistryName("titanium_dust");
		}
		
		if(SPCompatibilityManager.isSimpleGrinderLoaded() && !SPCompatibilityManager.isIc2Loaded())
		{
			SPItems.copper_dust = new Item(new Item.Properties().group(SPTabs.tabMaterials)).setRegistryName("copper_dust");
			SPItems.tin_dust = new Item(new Item.Properties().group(SPTabs.tabMaterials)).setRegistryName("tin_dust");
		}
		
		if(SPCompatibilityManager.isIc2Loaded() || SPCompatibilityManager.isSilentMechanismsLoaded())
		{
			SPItems.crushed_titanium_ore = new Item(new Item.Properties().group(SPTabs.tabMaterials)).setRegistryName("crushed_titanium_ore");
		}
		
        if (SPCompatibilityManager.isIc2Loaded())
        {
        	SPItems.purified_titanium_ore = new Item(new Item.Properties().group(SPTabs.tabMaterials)).setRegistryName("purified_titanium_ore");
        	SPItems.tiny_titanium_pile = new Item(new Item.Properties().group(SPTabs.tabMaterials)).setRegistryName("tiny_titanium_pile");
        	SPItems.titanium_plate = new Item(new Item.Properties().group(SPTabs.tabMaterials)).setRegistryName("titanium_plate");
        	SPItems.titanium_dense_plate = new Item(new Item.Properties().group(SPTabs.tabMaterials)).setRegistryName("titanium_dense_plate");
        	SPItems.titanium_casing = new Item(new Item.Properties().group(SPTabs.tabMaterials)).setRegistryName("titanium_casing");

        }

	}
	public static void register()
	{
		registerItem(SPItems.tin_ingot);
		registerItem(SPItems.copper_ingot);
		registerItem(SPItems.onion_seeds);
		registerItem(SPItems.bronze_ingot);
		registerItem(SPItems.bronze_nugget);
		registerItem(SPItems.titanium_ingot);
		registerItem(SPItems.titanium_nugget);
		registerItem(SPItems.charcoal_bucket);
		registerItem(SPItems.paper_cup);
		
		if(SPCompatibilityManager.isSimpleGrinderLoaded() || SPCompatibilityManager.isIc2Loaded() || SPCompatibilityManager.isSilentMechanismsLoaded())
		{
			registerItem(SPItems.titanium_dust);
		}
		
		if(SPCompatibilityManager.isSimpleGrinderLoaded() && !SPCompatibilityManager.isIc2Loaded())
		{
			registerItem(SPItems.copper_dust);
			registerItem(SPItems.tin_dust);
		}
		
		if(SPCompatibilityManager.isIc2Loaded() || SPCompatibilityManager.isSilentMechanismsLoaded())
		{
			registerItem(SPItems.crushed_titanium_ore);
		}

		if (SPCompatibilityManager.isIc2Loaded())
        {
			registerItem(SPItems.purified_titanium_ore);
			registerItem(SPItems.tiny_titanium_pile);
			registerItem(SPItems.titanium_plate);
			registerItem(SPItems.titanium_dense_plate);
			registerItem(SPItems.titanium_casing);

        }
	}
	public static void registerItem(Item item) {
		
		 ForgeRegistries.ITEMS.register(item);
	}
}
