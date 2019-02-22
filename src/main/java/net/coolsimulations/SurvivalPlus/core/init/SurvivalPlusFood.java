package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.item.SPItemFoodEffect;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSoup;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class SurvivalPlusFood {
	
	public static void init(){
		SPItems.apple_pie = new ItemFood(8, 0.75F, false).setUnlocalizedName("apple_pie").setRegistryName("apple_pie").setCreativeTab(SPTabs.tabFood);
		SPItems.beef_pie = new ItemFood(10, 0.95F, true).setUnlocalizedName("beef_pie").setRegistryName("beef_pie").setCreativeTab(SPTabs.tabFood);
		SPItems.pork_pie = new ItemFood(10, 0.95F, true).setUnlocalizedName("pork_pie").setRegistryName("pork_pie").setCreativeTab(SPTabs.tabFood);
		SPItems.chicken_pie = new ItemFood(8, 0.75F, true).setUnlocalizedName("chicken_pie").setRegistryName("chicken_pie").setCreativeTab(SPTabs.tabFood);
		SPItems.mutton_pie = new ItemFood(8, 0.75F, true).setUnlocalizedName("mutton_pie").setRegistryName("mutton_pie").setCreativeTab(SPTabs.tabFood);
		SPItems.rabbit_pie = new ItemFood(8, 0.75F, true).setUnlocalizedName("rabbit_pie").setRegistryName("rabbit_pie").setCreativeTab(SPTabs.tabFood);
		SPItems.vegetable_pie = new ItemFood(7, 1.0F, false).setUnlocalizedName("vegetable_pie").setRegistryName("vegetable_pie").setCreativeTab(SPTabs.tabFood);
		SPItems.raw_onion = new SPItemFoodEffect(2, 1.0F, false, MobEffects.NAUSEA, 300).setUnlocalizedName("raw_onion").setRegistryName("raw_onion").setCreativeTab(SPTabs.tabFood);
		SPItems.onion_soup = new ItemSoup(10).setUnlocalizedName("onion_soup").setRegistryName("onion_soup").setCreativeTab(SPTabs.tabFood);
		SPItems.fried_egg = new ItemFood(2, 1.0F, false).setUnlocalizedName("fried_egg").setRegistryName("fried_egg").setCreativeTab(SPTabs.tabFood);
		SPItems.roast_carrot = new ItemFood(5, 0.5F, false).setUnlocalizedName("roast_carrot").setRegistryName("roast_carrot").setCreativeTab(SPTabs.tabFood);
		SPItems.cheese = new ItemFood(3, 1.0F, false).setUnlocalizedName("cheese").setRegistryName("cheese").setCreativeTab(SPTabs.tabFood);
		SPItems.cheese_bread = new ItemFood(9, 0.9F, false).setUnlocalizedName("cheese_bread").setRegistryName("cheese_bread").setCreativeTab(SPTabs.tabFood);
		SPItems.melted_cheese_bread = new ItemFood(11, 1.0F, false).setUnlocalizedName("melted_cheese_bread").setRegistryName("melted_cheese_bread").setCreativeTab(SPTabs.tabFood);
		SPItems.cupcake = new ItemFood(2, 0.1F, false).setUnlocalizedName("cupcake").setRegistryName("cupcake").setCreativeTab(SPTabs.tabFood);
		SPItems.cheese_cupcake = new ItemFood(3, 0.2F, false).setUnlocalizedName("cheese_cupcake").setRegistryName("cheese_cupcake").setCreativeTab(SPTabs.tabFood);
		SPItems.sponge_cupcake = new ItemFood(2, 0.1F, false).setUnlocalizedName("sponge_cupcake").setRegistryName("sponge_cupcake").setCreativeTab(SPTabs.tabFood);
		SPItems.baked_apple = new ItemFood(6, 0.5F, false).setUnlocalizedName("baked_apple").setRegistryName("baked_apple").setCreativeTab(SPTabs.tabFood);
		SPItems.fried_onion = new ItemFood(4, 0.8F, false).setUnlocalizedName("fried_onion").setRegistryName("fried_onion").setCreativeTab(SPTabs.tabFood);
		
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
		
		SurvivalPlus.ITEMS_FOOD.add(item);
	}

	public static void registerItems(IForgeRegistry<Item> registry) {
	
	for (Item item : SurvivalPlus.ITEMS_FOOD)
    {
        registry.register(item);
    	}
	}
	
	public static void registerRenders()
	{
		registerRender(SPItems.apple_pie);
		registerRender(SPItems.beef_pie);
		registerRender(SPItems.pork_pie);
		registerRender(SPItems.chicken_pie);
		registerRender(SPItems.mutton_pie);
		registerRender(SPItems.rabbit_pie);
		registerRender(SPItems.vegetable_pie);
		registerRender(SPItems.raw_onion);
		registerRender(SPItems.onion_soup);
		registerRender(SPItems.fried_egg);
		registerRender(SPItems.roast_carrot);
		registerRender(SPItems.cheese);
		registerRender(SPItems.cheese_bread);
		registerRender(SPItems.melted_cheese_bread);
		registerRender(SPItems.cupcake);
		registerRender(SPItems.cheese_cupcake);
		registerRender(SPItems.sponge_cupcake);
		registerRender(SPItems.baked_apple);
		registerRender(SPItems.fried_onion);

	}
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
