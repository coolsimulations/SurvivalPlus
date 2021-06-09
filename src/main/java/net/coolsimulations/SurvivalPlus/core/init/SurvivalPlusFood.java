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
		
		SPFoods.apple_pie = (new Builder()).hunger(8).saturation(0.75F).build();
		SPFoods.beef_pie = (new Builder()).hunger(10).saturation(0.95F).meat().build();
		SPFoods.pork_pie = (new Builder()).hunger(10).saturation(0.95F).meat().build();
		SPFoods.chicken_pie = (new Builder()).hunger(8).saturation(0.75F).meat().build();
		SPFoods.mutton_pie = (new Builder()).hunger(8).saturation(0.75F).meat().build();
		SPFoods.rabbit_pie = (new Builder()).hunger(8).saturation(0.75F).meat().build();
		SPFoods.vegetable_pie = (new Builder()).hunger(7).saturation(1.0F).build();
		SPFoods.raw_onion = (new Builder()).hunger(2).saturation(1.0F).effect(new EffectInstance(Effects.NAUSEA, 300), 1.0F).build();
		SPFoods.onion_soup = buildSoup(10);
		SPFoods.fried_egg = (new Builder()).hunger(2).saturation(1.0F).fastToEat().build();
		SPFoods.roast_carrot = (new Builder()).hunger(5).saturation(0.5F).build();
		SPFoods.cheese = (new Builder()).hunger(3).saturation(1.0F).fastToEat().build();
		SPFoods.cheese_bread = (new Builder()).hunger(9).saturation(0.9F).build();
		SPFoods.melted_cheese_bread = (new Builder()).hunger(11).saturation(1.0F).build();
		SPFoods.cupcake = (new Builder()).hunger(2).saturation(0.1F).fastToEat().build();
		SPFoods.cheese_cupcake = (new Builder()).hunger(3).saturation(0.2F).fastToEat().build();
		SPFoods.sponge_cupcake = (new Builder()).hunger(2).saturation(0.1F).fastToEat().build();
		SPFoods.baked_apple = (new Builder()).hunger(6).saturation(0.5F).build();
		SPFoods.fried_onion = (new Builder()).hunger(4).saturation(0.8F).fastToEat().build();
		
		SPItems.apple_pie = new Item(new Item.Properties().food(SPFoods.apple_pie).group(SPTabs.tabFood)).setRegistryName("apple_pie");
		SPItems.beef_pie = new Item(new Item.Properties().food(SPFoods.beef_pie).group(SPTabs.tabFood)).setRegistryName("beef_pie");
		SPItems.pork_pie = new Item(new Item.Properties().food(SPFoods.pork_pie).group(SPTabs.tabFood)).setRegistryName("pork_pie");
		SPItems.chicken_pie = new Item(new Item.Properties().food(SPFoods.chicken_pie).group(SPTabs.tabFood)).setRegistryName("chicken_pie");
		SPItems.mutton_pie = new Item(new Item.Properties().food(SPFoods.mutton_pie).group(SPTabs.tabFood)).setRegistryName("mutton_pie");
		SPItems.rabbit_pie = new Item(new Item.Properties().food(SPFoods.rabbit_pie).group(SPTabs.tabFood)).setRegistryName("rabbit_pie");
		SPItems.vegetable_pie = new Item(new Item.Properties().food(SPFoods.vegetable_pie).group(SPTabs.tabFood)).setRegistryName("vegetable_pie");
		SPItems.raw_onion = new Item(new Item.Properties().food(SPFoods.raw_onion).group(SPTabs.tabFood)).setRegistryName("raw_onion");
		SPItems.onion_soup = new SoupItem(new Item.Properties().food(SPFoods.onion_soup).maxStackSize(1).group(SPTabs.tabFood)).setRegistryName("onion_soup");
		SPItems.fried_egg = new Item(new Item.Properties().food(SPFoods.fried_egg).group(SPTabs.tabFood)).setRegistryName("fried_egg");
		SPItems.roast_carrot = new Item(new Item.Properties().food(SPFoods.roast_carrot).group(SPTabs.tabFood)).setRegistryName("roast_carrot");
		SPItems.cheese = new Item(new Item.Properties().food(SPFoods.cheese).group(SPTabs.tabFood)).setRegistryName("cheese");
		SPItems.cheese_bread = new Item(new Item.Properties().food(SPFoods.cheese_bread).group(SPTabs.tabFood)).setRegistryName("cheese_bread");
		SPItems.melted_cheese_bread = new Item(new Item.Properties().food(SPFoods.melted_cheese_bread).group(SPTabs.tabFood)).setRegistryName("melted_cheese_bread");
		SPItems.cupcake = new SPItemCupcake(new Item.Properties().food(SPFoods.cupcake).group(SPTabs.tabFood)).setRegistryName("cupcake");
		SPItems.cheese_cupcake = new SPItemCupcake(new Item.Properties().food(SPFoods.cheese_cupcake).group(SPTabs.tabFood)).setRegistryName("cheese_cupcake");
		SPItems.sponge_cupcake = new SPItemCupcake(new Item.Properties().food(SPFoods.sponge_cupcake).group(SPTabs.tabFood)).setRegistryName("sponge_cupcake");
		SPItems.baked_apple = new Item(new Item.Properties().food(SPFoods.baked_apple).group(SPTabs.tabFood)).setRegistryName("baked_apple");
		SPItems.fried_onion = new Item(new Item.Properties().food(SPFoods.fried_onion).group(SPTabs.tabFood)).setRegistryName("fried_onion");
		
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
		return (new Builder()).hunger(hunger).saturation(0.6F).build();
	}
}
