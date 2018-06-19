package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.registries.IForgeRegistry;

public class SurvivalPlusItems {
	
	public static void init() {
		
		SPItems.tin_ingot = new Item().setUnlocalizedName("tin_ingot").setRegistryName("tin_ingot").setCreativeTab(SurvivalPlus.tabMaterials);
		SPItems.copper_ingot = new Item().setUnlocalizedName("copper_ingot").setRegistryName("copper_ingot").setCreativeTab(SurvivalPlus.tabMaterials);
		SPItems.onion_seeds = new ItemSeeds(SPBlocks.onion, Blocks.FARMLAND).setUnlocalizedName("onion_seeds").setRegistryName("onion_seeds").setCreativeTab(SurvivalPlus.tabMaterials);
		SPItems.bronze_ingot = new Item().setUnlocalizedName("bronze_ingot").setRegistryName("bronze_ingot").setCreativeTab(SurvivalPlus.tabMaterials);
		SPItems.bronze_nugget = new Item().setUnlocalizedName("bronze_nugget").setRegistryName("bronze_nugget").setCreativeTab(SurvivalPlus.tabMaterials);
		SPItems.titanium_ingot = new Item().setUnlocalizedName("titanium_ingot").setRegistryName("titanium_ingot").setCreativeTab(SurvivalPlus.tabMaterials);
		SPItems.titanium_nugget = new Item().setUnlocalizedName("titanium_nugget").setRegistryName("titanium_nugget").setCreativeTab(SurvivalPlus.tabMaterials);
		SPItems.charcoal_bucket = new Item().setUnlocalizedName("charcoal_bucket").setRegistryName("charcoal_bucket").setMaxStackSize(1).setContainerItem(Items.BUCKET).setCreativeTab(SurvivalPlus.tabMaterials);
		SPItems.paper_cup = new Item().setUnlocalizedName("paper_cup").setRegistryName("paper_cup").setCreativeTab(SurvivalPlus.tabMaterials);
		SPItems.white_dye = new Item().setUnlocalizedName("white_dye").setRegistryName("white_dye").setCreativeTab(SurvivalPlus.tabMaterials);
		
		if(SPCompatibilityManager.isSimpleGrinderLoaded() || SPCompatibilityManager.isIc2Loaded())
		{
			SPItems.titanium_dust = new Item().setUnlocalizedName("titanium_dust").setRegistryName("titanium_dust").setCreativeTab(SurvivalPlus.tabMaterials);
		}
		
		if(SPCompatibilityManager.isSimpleGrinderLoaded() && !SPCompatibilityManager.isIc2Loaded())
		{
			SPItems.copper_dust = new Item().setUnlocalizedName("copper_dust").setRegistryName("copper_dust").setCreativeTab(SurvivalPlus.tabMaterials);
			SPItems.tin_dust = new Item().setUnlocalizedName("tin_dust").setRegistryName("tin_dust").setCreativeTab(SurvivalPlus.tabMaterials);
		}
		
        if (SPCompatibilityManager.isIc2Loaded())
        {
        	SPItems.crushed_titanium_ore = new Item().setUnlocalizedName("crushed_titanium_ore").setRegistryName("crushed_titanium_ore").setCreativeTab(SurvivalPlus.tabMaterials);
        	SPItems.purified_titanium_ore = new Item().setUnlocalizedName("purified_titanium_ore").setRegistryName("purified_titanium_ore").setCreativeTab(SurvivalPlus.tabMaterials);
        	SPItems.tiny_titanium_pile = new Item().setUnlocalizedName("tiny_titanium_pile").setRegistryName("tiny_titanium_pile").setCreativeTab(SurvivalPlus.tabMaterials);
        	SPItems.titanium_plate = new Item().setUnlocalizedName("titanium_plate").setRegistryName("titanium_plate").setCreativeTab(SurvivalPlus.tabMaterials);
        	SPItems.titanium_dense_plate = new Item().setUnlocalizedName("titanium_dense_plate").setRegistryName("titanium_dense_plate").setCreativeTab(SurvivalPlus.tabMaterials);
        	SPItems.titanium_casing = new Item().setUnlocalizedName("titanium_casing").setRegistryName("titanium_casing").setCreativeTab(SurvivalPlus.tabMaterials);

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
		registerItem(SPItems.white_dye);
		
		if(SPCompatibilityManager.isSimpleGrinderLoaded() || SPCompatibilityManager.isIc2Loaded())
		{
			registerItem(SPItems.titanium_dust);
		}
		
		if(SPCompatibilityManager.isSimpleGrinderLoaded() && !SPCompatibilityManager.isIc2Loaded())
		{
			registerItem(SPItems.copper_dust);
			registerItem(SPItems.tin_dust);
		}

		if (SPCompatibilityManager.isIc2Loaded())
        {
			registerItem(SPItems.crushed_titanium_ore);
			registerItem(SPItems.purified_titanium_ore);
			registerItem(SPItems.tiny_titanium_pile);
			registerItem(SPItems.titanium_plate);
			registerItem(SPItems.titanium_dense_plate);
			registerItem(SPItems.titanium_casing);

        }
	}


	public static void registerRenders()
	{
		registerRender(SPItems.tin_ingot);
		registerRender(SPItems.copper_ingot);
		registerRender(SPItems.onion_seeds);
		registerRender(SPItems.bronze_ingot);
		registerRender(SPItems.bronze_nugget);
		registerRender(SPItems.titanium_ingot);
		registerRender(SPItems.titanium_nugget);
		registerRender(SPItems.charcoal_bucket);
		registerRender(SPItems.paper_cup);
		registerRender(SPItems.white_dye);
		
		if(SPCompatibilityManager.isSimpleGrinderLoaded() || SPCompatibilityManager.isIc2Loaded())
		{
			registerRender(SPItems.titanium_dust);
		}
		
		if(SPCompatibilityManager.isSimpleGrinderLoaded() && !SPCompatibilityManager.isIc2Loaded())
		{
			registerRender(SPItems.copper_dust);
			registerRender(SPItems.tin_dust);
		}
		
		if (SPCompatibilityManager.isIc2Loaded())
        {
			registerRender(SPItems.crushed_titanium_ore);
			registerRender(SPItems.purified_titanium_ore);
			registerRender(SPItems.tiny_titanium_pile);
			registerRender(SPItems.titanium_plate);
			registerRender(SPItems.titanium_dense_plate);
			registerRender(SPItems.titanium_casing);
        }
		
	}
	
	public static void registerItem(Item item) {
		
		SurvivalPlus.ITEMS.add(item);
	}
	
	public static void registerItems(IForgeRegistry<Item> registry) {
		
	for (Item item : SurvivalPlus.ITEMS)
    {
        registry.register(item);
    	}
	}
	
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
