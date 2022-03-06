package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPFoods;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.item.SPItemCupcake;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public class SurvivalPlusFood {
	
	public static final DeferredRegister<Item> ITEMS_FOOD = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	
	private static final RegistryObject<Item> apple_pie = ITEMS_FOOD.register("apple_pie", () -> new Item(new Item.Properties().food(SPFoods.apple_pie).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> beef_pie = ITEMS_FOOD.register("beef_pie", () -> new Item(new Item.Properties().food(SPFoods.beef_pie).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> pork_pie = ITEMS_FOOD.register("pork_pie", () -> new Item(new Item.Properties().food(SPFoods.pork_pie).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> chicken_pie = ITEMS_FOOD.register("chicken_pie", () -> new Item(new Item.Properties().food(SPFoods.chicken_pie).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> mutton_pie = ITEMS_FOOD.register("mutton_pie", () -> new Item(new Item.Properties().food(SPFoods.mutton_pie).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> rabbit_pie = ITEMS_FOOD.register("rabbit_pie", () -> new Item(new Item.Properties().food(SPFoods.rabbit_pie).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> vegetable_pie = ITEMS_FOOD.register("vegetable_pie", () -> new Item(new Item.Properties().food(SPFoods.vegetable_pie).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> raw_onion = ITEMS_FOOD.register("raw_onion", () -> new Item(new Item.Properties().food(SPFoods.raw_onion).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> onion_soup = ITEMS_FOOD.register("onion_soup", () -> new BowlFoodItem(new Item.Properties().food(SPFoods.onion_soup).stacksTo(1).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> fried_egg = ITEMS_FOOD.register("fried_egg", () -> new Item(new Item.Properties().food(SPFoods.fried_egg).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> roast_carrot = ITEMS_FOOD.register("roast_carrot", () -> new Item(new Item.Properties().food(SPFoods.roast_carrot).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> cheese = ITEMS_FOOD.register("cheese", () -> new Item(new Item.Properties().food(SPFoods.cheese).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> cheese_bread = ITEMS_FOOD.register("cheese_bread", () -> new Item(new Item.Properties().food(SPFoods.cheese_bread).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> melted_cheese_bread = ITEMS_FOOD.register("melted_cheese_bread", () -> new Item(new Item.Properties().food(SPFoods.melted_cheese_bread).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> cupcake = ITEMS_FOOD.register("cupcake", () -> new SPItemCupcake(new Item.Properties().food(SPFoods.cupcake).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> cheese_cupcake = ITEMS_FOOD.register("cheese_cupcake", () -> new SPItemCupcake(new Item.Properties().food(SPFoods.cheese_cupcake).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> sponge_cupcake = ITEMS_FOOD.register("sponge_cupcake", () -> new SPItemCupcake(new Item.Properties().food(SPFoods.sponge_cupcake).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> baked_apple = ITEMS_FOOD.register("baked_apple", () -> new Item(new Item.Properties().food(SPFoods.baked_apple).tab(SPTabs.tabFood)));
	private static final RegistryObject<Item> fried_onion = ITEMS_FOOD.register("fried_onion", () -> new Item(new Item.Properties().food(SPFoods.fried_onion).tab(SPTabs.tabFood)));
}
