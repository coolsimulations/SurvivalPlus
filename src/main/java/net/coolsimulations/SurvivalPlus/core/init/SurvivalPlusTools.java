package net.coolsimulations.SurvivalPlus.core.init;


import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPItemAxe;
import net.coolsimulations.SurvivalPlus.api.item.SPItemHoe;
import net.coolsimulations.SurvivalPlus.api.item.SPItemPickaxe;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShears;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShovel;
import net.coolsimulations.SurvivalPlus.api.item.SPItemSword;
import net.coolsimulations.SurvivalPlus.api.item.SPItemTier;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusNoTreePunching;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusTools {
	
	public static void init() 
	{
		SPItems.bronze_pickaxe = new SPItemPickaxe(SPItemTier.bronzeToolMaterial).setRegistryName("bronze_pickaxe");
		SPItems.bronze_axe = new SPItemAxe(SPItemTier.bronzeToolMaterial, 7, -3.1F).setRegistryName("bronze_axe");
		SPItems.bronze_shovel = new SPItemShovel(SPItemTier.bronzeToolMaterial).setRegistryName("bronze_shovel");
		//if(!SPCompatibilityManager.isExtendedNetherBackportLoaded())
			SPItems.bronze_hoe = new SPItemHoe(SPItemTier.bronzeToolMaterial).setRegistryName("bronze_hoe");
		SPItems.bronze_sword = new SPItemSword(SPItemTier.bronzeToolMaterial).setRegistryName("bronze_sword");
		SPItems.bronze_shears = new SPItemShears(179).setRegistryName("bronze_shears");
		SPItems.bronze_shield = new SPItemShield(274).setRegistryName("bronze_shield");
		
		SPItems.titanium_pickaxe = new SPItemPickaxe(SPItemTier.titaniumToolMaterial).setRegistryName("titanium_pickaxe");
		SPItems.titanium_axe = new SPItemAxe(SPItemTier.titaniumToolMaterial, 8.0F, -3.0F).setRegistryName("titanium_axe");
		SPItems.titanium_shovel = new SPItemShovel(SPItemTier.titaniumToolMaterial).setRegistryName("titanium_shovel");
		//if(!SPCompatibilityManager.isExtendedNetherBackportLoaded())
			SPItems.titanium_hoe = new SPItemHoe(SPItemTier.titaniumToolMaterial).setRegistryName("titanium_hoe");
		SPItems.titanium_sword = new SPItemSword(SPItemTier.titaniumToolMaterial).setRegistryName("titanium_sword");
		SPItems.titanium_shears = new SPItemShears(298).setRegistryName("titanium_shears");
		SPItems.titanium_shield = new SPItemShield(519).setRegistryName("titanium_shield");
		
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
	
	public static void registerItem(Item item) {
		
		 ForgeRegistries.ITEMS.register(item);
	}
}
