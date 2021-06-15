package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPFoods;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.item.SPItemCupcake;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.item.Food.Builder;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.item.SoupItem;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusFood {
	
	public static void init(){
		
		SPFoods.apple_pie = (new Builder()).nutrition(8).saturationMod(0.75F).build();
		SPFoods.beef_pie = (new Builder()).nutrition(10).saturationMod(0.95F).meat().build();
		SPFoods.pork_pie = (new Builder()).nutrition(10).saturationMod(0.95F).meat().build();
		SPFoods.chicken_pie = (new Builder()).nutrition(8).saturationMod(0.75F).meat().build();
		SPFoods.mutton_pie = (new Builder()).nutrition(8).saturationMod(0.75F).meat().build();
		SPFoods.rabbit_pie = (new Builder()).nutrition(8).saturationMod(0.75F).meat().build();
		SPFoods.vegetable_pie = (new Builder()).nutrition(7).saturationMod(1.0F).build();
		SPFoods.raw_onion = (new Builder()).nutrition(2).saturationMod(1.0F).effect(new EffectInstance(Effects.CONFUSION, 300), 1.0F).build();
		SPFoods.onion_soup = buildSoup(10);
		SPFoods.fried_egg = (new Builder()).nutrition(2).saturationMod(1.0F).fast().build();
		SPFoods.roast_carrot = (new Builder()).nutrition(5).saturationMod(0.5F).build();
		SPFoods.cheese = (new Builder()).nutrition(3).saturationMod(1.0F).fast().build();
		SPFoods.cheese_bread = (new Builder()).nutrition(9).saturationMod(0.9F).build();
		SPFoods.melted_cheese_bread = (new Builder()).nutrition(11).saturationMod(1.0F).build();
		SPFoods.cupcake = (new Builder()).nutrition(2).saturationMod(0.1F).fast().build();
		SPFoods.cheese_cupcake = (new Builder()).nutrition(3).saturationMod(0.2F).fast().build();
		SPFoods.sponge_cupcake = (new Builder()).nutrition(2).saturationMod(0.1F).fast().build();
		SPFoods.baked_apple = (new Builder()).nutrition(6).saturationMod(0.5F).build();
		SPFoods.fried_onion = (new Builder()).nutrition(4).saturationMod(0.8F).fast().build();
		
		SPItems.apple_pie = new Item(new Item.Properties().food(SPFoods.apple_pie).tab(SPTabs.tabFood)).setRegistryName("apple_pie");
		SPItems.beef_pie = new Item(new Item.Properties().food(SPFoods.beef_pie).tab(SPTabs.tabFood)).setRegistryName("beef_pie");
		SPItems.pork_pie = new Item(new Item.Properties().food(SPFoods.pork_pie).tab(SPTabs.tabFood)).setRegistryName("pork_pie");
		SPItems.chicken_pie = new Item(new Item.Properties().food(SPFoods.chicken_pie).tab(SPTabs.tabFood)).setRegistryName("chicken_pie");
		SPItems.mutton_pie = new Item(new Item.Properties().food(SPFoods.mutton_pie).tab(SPTabs.tabFood)).setRegistryName("mutton_pie");
		SPItems.rabbit_pie = new Item(new Item.Properties().food(SPFoods.rabbit_pie).tab(SPTabs.tabFood)).setRegistryName("rabbit_pie");
		SPItems.vegetable_pie = new Item(new Item.Properties().food(SPFoods.vegetable_pie).tab(SPTabs.tabFood)).setRegistryName("vegetable_pie");
		SPItems.raw_onion = new Item(new Item.Properties().food(SPFoods.raw_onion).tab(SPTabs.tabFood)).setRegistryName("raw_onion");
		SPItems.onion_soup = new SoupItem(new Item.Properties().food(SPFoods.onion_soup).stacksTo(1).tab(SPTabs.tabFood)).setRegistryName("onion_soup");
		SPItems.fried_egg = new Item(new Item.Properties().food(SPFoods.fried_egg).tab(SPTabs.tabFood)).setRegistryName("fried_egg");
		SPItems.roast_carrot = new Item(new Item.Properties().food(SPFoods.roast_carrot).tab(SPTabs.tabFood)).setRegistryName("roast_carrot");
		SPItems.cheese = new Item(new Item.Properties().food(SPFoods.cheese).tab(SPTabs.tabFood)).setRegistryName("cheese");
		SPItems.cheese_bread = new Item(new Item.Properties().food(SPFoods.cheese_bread).tab(SPTabs.tabFood)).setRegistryName("cheese_bread");
		SPItems.melted_cheese_bread = new Item(new Item.Properties().food(SPFoods.melted_cheese_bread).tab(SPTabs.tabFood)).setRegistryName("melted_cheese_bread");
		SPItems.cupcake = new SPItemCupcake(new Item.Properties().food(SPFoods.cupcake).tab(SPTabs.tabFood)).setRegistryName("cupcake");
		SPItems.cheese_cupcake = new SPItemCupcake(new Item.Properties().food(SPFoods.cheese_cupcake).tab(SPTabs.tabFood)).setRegistryName("cheese_cupcake");
		SPItems.sponge_cupcake = new SPItemCupcake(new Item.Properties().food(SPFoods.sponge_cupcake).tab(SPTabs.tabFood)).setRegistryName("sponge_cupcake");
		SPItems.baked_apple = new Item(new Item.Properties().food(SPFoods.baked_apple).tab(SPTabs.tabFood)).setRegistryName("baked_apple");
		SPItems.fried_onion = new Item(new Item.Properties().food(SPFoods.fried_onion).tab(SPTabs.tabFood)).setRegistryName("fried_onion");
		
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
	
	private static Food buildSoup(int hunger) {
		return (new Builder()).nutrition(hunger).saturationMod(0.6F).build();
	}
}
