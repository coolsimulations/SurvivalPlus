package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.item.SPItemAxe;
import net.coolsimulations.SurvivalPlus.api.item.SPItemHoe;
import net.coolsimulations.SurvivalPlus.api.item.SPItemPickaxe;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShears;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShovel;
import net.coolsimulations.SurvivalPlus.api.item.SPItemSword;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusNoTreePunching;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;

public class SurvivalPlusTools {
	
	// During the EnumHelper the number are for (harvest level, max uses, efficiency, damage, enchantability)
	// Wood = (0, 59, 2.0F, 0.0F, 15) Sword adds 4.0F damage
	//Stone = (1, 131, 4.0F, 1.0F, 5) Sword adds 5.0F damage
	// Iron = (2, 251, 6.0F, 2.0F, 14) Sword adds 6.0F damage
	//Diamond = (3, 1561, 8.0F, 3.0F, 10) Sword adds 7.0F damage
	// Gold = (0, 32, 12.0F, 0.0F, 22) Sword adds 4.0F damage
	//Tool Materials
	//WOOD(0, 59, 2.0F, 0.0F, 15),
    //STONE(1, 131, 4.0F, 1.0F, 5),
    //IRON(2, 250, 6.0F, 2.0F, 14),
    //EMERALD(3, 1561, 8.0F, 3.0F, 10),
    //GOLD(0, 32, 12.0F, 0.0F, 22);
	
	public static void init() 
	{

		SPItems.bronzeToolMaterial = EnumHelper.addToolMaterial("bronzeToolMaterial", 2, 350, 5.0F, 1.5F, 7).setRepairItem(new ItemStack(SPItems.bronze_ingot));
		SPItems.bronze_pickaxe = new SPItemPickaxe(SPItems.bronzeToolMaterial, "ingotBronze").setUnlocalizedName("bronze_pickaxe").setRegistryName("bronze_pickaxe").setCreativeTab(SPTabs.tabTools);
		SPItems.bronze_axe = new SPItemAxe(SPItems.bronzeToolMaterial, 7, -3.1F, "ingotBronze").setUnlocalizedName("bronze_axe").setRegistryName("bronze_axe").setCreativeTab(SPTabs.tabTools);
		SPItems.bronze_shovel = new SPItemShovel(SPItems.bronzeToolMaterial, "ingotBronze").setUnlocalizedName("bronze_shovel").setRegistryName("bronze_shovel").setCreativeTab(SPTabs.tabTools);
		SPItems.bronze_hoe = new SPItemHoe(SPItems.bronzeToolMaterial, "ingotBronze").setUnlocalizedName("bronze_hoe").setRegistryName("bronze_hoe").setCreativeTab(SPTabs.tabTools);
		SPItems.bronze_sword = new SPItemSword(SPItems.bronzeToolMaterial, "ingotBronze").setUnlocalizedName("bronze_sword").setRegistryName("bronze_sword").setCreativeTab(SPTabs.tabCombat);
		SPItems.bronze_shears = new SPItemShears(179, "ingotBronze").setUnlocalizedName("bronze_shears").setRegistryName("bronze_shears").setCreativeTab(SPTabs.tabTools);
		SPItems.bronze_shield = new SPItemShield(274, "plankWood").setUnlocalizedName("bronze_shield").setRegistryName("bronze_shield").setCreativeTab(SPTabs.tabCombat);
		
		SPItems.titaniumToolMaterial = EnumHelper.addToolMaterial("titaniumToolMaterial", 2, 432, 7.0F, 2.5F, 17).setRepairItem(new ItemStack(SPItems.titanium_ingot));
		SPItems.titanium_pickaxe = new SPItemPickaxe(SPItems.titaniumToolMaterial, "ingotTitanium").setUnlocalizedName("titanium_pickaxe").setRegistryName("titanium_pickaxe").setCreativeTab(SPTabs.tabTools);
		SPItems.titanium_axe = new SPItemAxe(SPItems.titaniumToolMaterial, 8.0F, -3.0F, "ingotTitanium").setUnlocalizedName("titanium_axe").setRegistryName("titanium_axe").setCreativeTab(SPTabs.tabTools);
		SPItems.titanium_shovel = new SPItemShovel(SPItems.titaniumToolMaterial, "ingotTitanium").setUnlocalizedName("titanium_shovel").setRegistryName("titanium_shovel").setCreativeTab(SPTabs.tabTools);
		SPItems.titanium_hoe = new SPItemHoe(SPItems.titaniumToolMaterial, "ingotTitanium").setUnlocalizedName("titanium_hoe").setRegistryName("titanium_hoe").setCreativeTab(SPTabs.tabTools);
		SPItems.titanium_sword = new SPItemSword(SPItems.titaniumToolMaterial, "ingotTitanium").setUnlocalizedName("titanium_sword").setRegistryName("titanium_sword").setCreativeTab(SPTabs.tabCombat);
		SPItems.titanium_shears = new SPItemShears(298, "ingotTitanium").setUnlocalizedName("titanium_shears").setRegistryName("titanium_shears").setCreativeTab(SPTabs.tabTools);
		SPItems.titanium_shield = new SPItemShield(519, "plankWood").setUnlocalizedName("titanium_shield").setRegistryName("titanium_shield").setCreativeTab(SPTabs.tabCombat);
		
		if(!SPCompatibilityManager.isEmeraldMaterialModsLoaded() && SPConfig.enableEmeraldMaterial)
			SPItems.emeraldToolMaterial = EnumHelper.addToolMaterial("emeraldToolMaterial", 3, 1776, 9.0F, 3.5F, 22).setRepairItem(new ItemStack(Items.EMERALD));
		if(!SPCompatibilityManager.isObsidianMaterialModsLoaded() && SPConfig.enableObsidianMaterial)
			SPItems.obsidianToolMaterial = EnumHelper.addToolMaterial("obsidianToolMaterial", 3, 1820, 7.0F, 4.5F, 11).setRepairItem(new ItemStack(Blocks.OBSIDIAN));
		
		if(SPCompatibilityManager.isNoTreePunchingLoaded()){
			SurvivalPlusNoTreePunching.init();
		}

	}
	
	public static void register()
	{
		registerItem(SPItems.bronze_pickaxe);
		registerItem(SPItems.bronze_axe);
		registerItem(SPItems.bronze_shovel);
		registerItem(SPItems.bronze_hoe);
		registerItem(SPItems.bronze_sword);
		registerItem(SPItems.bronze_shears);
		registerItem(SPItems.bronze_shield);
		
		registerItem(SPItems.titanium_pickaxe);
		registerItem(SPItems.titanium_axe);
		registerItem(SPItems.titanium_shovel);
		registerItem(SPItems.titanium_hoe);
		registerItem(SPItems.titanium_sword);
		registerItem(SPItems.titanium_shears);
		registerItem(SPItems.titanium_shield);

		if(SPCompatibilityManager.isNoTreePunchingLoaded()){
			SurvivalPlusNoTreePunching.register();
		}
		
	}
	
	public static void registerRenders()
	{
		registerRender(SPItems.bronze_pickaxe);
		registerRender(SPItems.bronze_axe);
		registerRender(SPItems.bronze_shovel);
		registerRender(SPItems.bronze_hoe);
		registerRender(SPItems.bronze_sword);
		registerRender(SPItems.bronze_shears);
		registerRender(SPItems.bronze_shield);
		
		registerRender(SPItems.titanium_pickaxe);
		registerRender(SPItems.titanium_axe);
		registerRender(SPItems.titanium_shovel);
		registerRender(SPItems.titanium_hoe);
		registerRender(SPItems.titanium_sword);
		registerRender(SPItems.titanium_shears);
		registerRender(SPItems.titanium_shield);

		if(SPCompatibilityManager.isNoTreePunchingLoaded()){
			SurvivalPlusNoTreePunching.registerRenders();
		}
		
	}
	
	public static void registerItem(Item item) {
		
		SurvivalPlus.ITEMS_TOOLS.add(item);
	}
	
	public static void registerItems(IForgeRegistry<Item> registry) {
		
	for (Item item : SurvivalPlus.ITEMS_TOOLS)
    {
        registry.register(item);
    	}
	}
	
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
