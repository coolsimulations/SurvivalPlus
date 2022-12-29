package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPItemAxe;
import net.coolsimulations.SurvivalPlus.api.item.SPItemHoe;
import net.coolsimulations.SurvivalPlus.api.item.SPItemPickaxe;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShears;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShovel;
import net.coolsimulations.SurvivalPlus.api.item.SPItemSword;
import net.coolsimulations.SurvivalPlus.api.item.SPItemTier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class SurvivalPlusTools {
	
	public static void init() 
	{
		SPItems.bronze_pickaxe = new SPItemPickaxe(SPItemTier.bronzeToolMaterial);
		SPItems.bronze_axe = new SPItemAxe(SPItemTier.bronzeToolMaterial, 5.5F, -3.1F);
		SPItems.bronze_shovel = new SPItemShovel(SPItemTier.bronzeToolMaterial);
		SPItems.bronze_hoe = new SPItemHoe(SPItemTier.bronzeToolMaterial, -1.5F, -1.5F);
		SPItems.bronze_sword = new SPItemSword(SPItemTier.bronzeToolMaterial);
		SPItems.bronze_shears = new SPItemShears(179);
		SPItems.bronze_shield = new SPItemShield(274);
		
		SPItems.titanium_pickaxe = new SPItemPickaxe(SPItemTier.titaniumToolMaterial);
		SPItems.titanium_axe = new SPItemAxe(SPItemTier.titaniumToolMaterial, 5.5F, -3.0F);
		SPItems.titanium_shovel = new SPItemShovel(SPItemTier.titaniumToolMaterial);
		SPItems.titanium_hoe = new SPItemHoe(SPItemTier.titaniumToolMaterial, -2.5F, -0.5F);
		SPItems.titanium_sword = new SPItemSword(SPItemTier.titaniumToolMaterial);
		SPItems.titanium_shears = new SPItemShears(298);
		SPItems.titanium_shield = new SPItemShield(519);

	}
	
	public static void register()
	{
		registerItem(SPItems.bronze_pickaxe, "bronze_pickaxe");
		registerItem(SPItems.bronze_axe, "bronze_axe");
		registerItem(SPItems.bronze_shovel, "bronze_shovel");
		registerItem(SPItems.bronze_hoe, "bronze_hoe");
		registerItem(SPItems.bronze_sword, "bronze_sword");
		registerItem(SPItems.bronze_shears, "bronze_shears");
		registerItem(SPItems.bronze_shield, "bronze_shield");
		
		registerItem(SPItems.titanium_pickaxe, "titanium_pickaxe");
		registerItem(SPItems.titanium_axe, "titanium_axe");
		registerItem(SPItems.titanium_shovel, "titanium_shovel");
		registerItem(SPItems.titanium_hoe, "titanium_hoe");
		registerItem(SPItems.titanium_sword, "titanium_sword");
		registerItem(SPItems.titanium_shears, "titanium_shears");
		registerItem(SPItems.titanium_shield, "titanium_shield");

		
	}
	
	public static void registerItem(Item item, String registryName) {

		Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(SPReference.MOD_ID, registryName), item);
	}

}
