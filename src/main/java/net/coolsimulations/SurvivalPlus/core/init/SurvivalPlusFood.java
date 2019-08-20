package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.item.SPItemFoodEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSoup;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusFood {
	
	public static void init(){
		SPItems.apple_pie = new ItemFood(8, 0.75F, false, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("apple_pie");
		SPItems.beef_pie = new ItemFood(10, 0.95F, true, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("beef_pie");
		SPItems.pork_pie = new ItemFood(10, 0.95F, true, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("pork_pie");
		SPItems.chicken_pie = new ItemFood(8, 0.75F, true, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("chicken_pie");
		SPItems.mutton_pie = new ItemFood(8, 0.75F, true, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("mutton_pie");
		SPItems.rabbit_pie = new ItemFood(8, 0.75F, true, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("rabbit_pie");
		SPItems.vegetable_pie = new ItemFood(7, 1.0F, false, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("vegetable_pie");
		SPItems.raw_onion = new SPItemFoodEffect(2, 1.0F, false, MobEffects.NAUSEA, 300, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("raw_onion");
		SPItems.onion_soup = new ItemSoup(10, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("onion_soup");
		SPItems.fried_egg = new ItemFood(2, 1.0F, false, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("fried_egg");
		SPItems.roast_carrot = new ItemFood(5, 0.5F, false, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("roast_carrot");
		SPItems.cheese = new ItemFood(3, 1.0F, false, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("cheese");
		SPItems.cheese_bread = new ItemFood(9, 0.9F, false, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("cheese_bread");
		SPItems.melted_cheese_bread = new ItemFood(11, 1.0F, false, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("melted_cheese_bread");
		SPItems.cupcake = new ItemFood(2, 0.1F, false, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("cupcake");
		SPItems.cheese_cupcake = new ItemFood(3, 0.2F, false, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("cheese_cupcake");
		SPItems.sponge_cupcake = new ItemFood(2, 0.1F, false, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("sponge_cupcake");
		SPItems.baked_apple = new ItemFood(6, 0.5F, false, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("baked_apple");
		SPItems.fried_onion = new ItemFood(4, 0.8F, false, new Item.Properties().group(SPTabs.tabFood)).setRegistryName("fried_onion");
		
		//(hunger) x * 0.5 = a hearts (Max 20)
	}
	public static void register()
	{
		registerItem(SPItems.apple_pie);
		registerItem(SPItems.beef_pie);
		registerItem(SPItems.pork_pie);
		registerItem(SPItems.chicken_pie);
		registerItem(SPItems.mutton_pie);
		registerItem(SPItems.rabbit_pie);
		registerItem(SPItems.vegetable_pie);
		registerItem(SPItems.raw_onion);
		registerItem(SPItems.onion_soup);
		registerItem(SPItems.fried_egg);
		registerItem(SPItems.roast_carrot);
		registerItem(SPItems.cheese);
		registerItem(SPItems.cheese_bread);
		registerItem(SPItems.melted_cheese_bread);
		registerItem(SPItems.cupcake);
		registerItem(SPItems.cheese_cupcake);
		registerItem(SPItems.sponge_cupcake);
		registerItem(SPItems.baked_apple);
		registerItem(SPItems.fried_onion);
	}
	
	public static void registerItem(Item item) {
		
		 ForgeRegistries.ITEMS.register(item);
	}
}
