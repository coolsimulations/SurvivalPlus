package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPFoods;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponent.Builder;
import net.minecraft.item.Item;
import net.minecraft.item.MushroomStewItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SurvivalPlusFood {

	public static void init(){

		SPFoods.apple_pie = (new Builder()).hunger(8).saturationModifier(0.75F).build();
		SPFoods.beef_pie = (new Builder()).hunger(10).saturationModifier(0.95F).meat().build();
		SPFoods.pork_pie = (new Builder()).hunger(10).saturationModifier(0.95F).meat().build();
		SPFoods.chicken_pie = (new Builder()).hunger(8).saturationModifier(0.75F).meat().build();
		SPFoods.mutton_pie = (new Builder()).hunger(8).saturationModifier(0.75F).meat().build();
		SPFoods.rabbit_pie = (new Builder()).hunger(8).saturationModifier(0.75F).meat().build();
		SPFoods.vegetable_pie = (new Builder()).hunger(7).saturationModifier(1.0F).build();
		SPFoods.raw_onion = (new Builder()).hunger(2).saturationModifier(1.0F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300), 1.0F).build();
		SPFoods.onion_soup = buildSoup(10);
		SPFoods.fried_egg = (new Builder()).hunger(2).saturationModifier(1.0F).snack().build();
		SPFoods.roast_carrot = (new Builder()).hunger(5).saturationModifier(0.5F).build();
		SPFoods.cheese = (new Builder()).hunger(3).saturationModifier(1.0F).snack().build();
		SPFoods.cheese_bread = (new Builder()).hunger(9).saturationModifier(0.9F).build();
		SPFoods.melted_cheese_bread = (new Builder()).hunger(11).saturationModifier(1.0F).build();
		SPFoods.cupcake = (new Builder()).hunger(2).saturationModifier(0.1F).snack().build();
		SPFoods.cheese_cupcake = (new Builder()).hunger(3).saturationModifier(0.2F).snack().build();
		SPFoods.sponge_cupcake = (new Builder()).hunger(2).saturationModifier(0.1F).snack().build();
		SPFoods.baked_apple = (new Builder()).hunger(6).saturationModifier(0.5F).build();
		SPFoods.fried_onion = (new Builder()).hunger(4).saturationModifier(0.8F).snack().build();

		SPItems.apple_pie = new Item(new FabricItemSettings().food(SPFoods.apple_pie).group(SPTabs.tabFood));
		SPItems.beef_pie = new Item(new FabricItemSettings().food(SPFoods.beef_pie).group(SPTabs.tabFood));
		SPItems.pork_pie = new Item(new FabricItemSettings().food(SPFoods.pork_pie).group(SPTabs.tabFood));
		SPItems.chicken_pie = new Item(new FabricItemSettings().food(SPFoods.chicken_pie).group(SPTabs.tabFood));
		SPItems.mutton_pie = new Item(new FabricItemSettings().food(SPFoods.mutton_pie).group(SPTabs.tabFood));
		SPItems.rabbit_pie = new Item(new FabricItemSettings().food(SPFoods.rabbit_pie).group(SPTabs.tabFood));
		SPItems.vegetable_pie = new Item(new FabricItemSettings().food(SPFoods.vegetable_pie).group(SPTabs.tabFood));
		SPItems.raw_onion = new Item(new FabricItemSettings().food(SPFoods.raw_onion).group(SPTabs.tabFood));
		SPItems.onion_soup = new MushroomStewItem(new FabricItemSettings().food(SPFoods.onion_soup).maxCount(1).group(SPTabs.tabFood));
		SPItems.fried_egg = new Item(new FabricItemSettings().food(SPFoods.fried_egg).group(SPTabs.tabFood));
		SPItems.roast_carrot = new Item(new FabricItemSettings().food(SPFoods.roast_carrot).group(SPTabs.tabFood));
		SPItems.cheese = new Item(new FabricItemSettings().food(SPFoods.cheese).group(SPTabs.tabFood));
		SPItems.cheese_bread = new Item(new FabricItemSettings().food(SPFoods.cheese_bread).group(SPTabs.tabFood));
		SPItems.melted_cheese_bread = new Item(new FabricItemSettings().food(SPFoods.melted_cheese_bread).group(SPTabs.tabFood));
		SPItems.cupcake = new Item(new FabricItemSettings().food(SPFoods.cupcake).group(SPTabs.tabFood));
		SPItems.cheese_cupcake = new Item(new FabricItemSettings().food(SPFoods.cheese_cupcake).group(SPTabs.tabFood));
		SPItems.sponge_cupcake = new Item(new FabricItemSettings().food(SPFoods.sponge_cupcake).group(SPTabs.tabFood));
		SPItems.baked_apple = new Item(new FabricItemSettings().food(SPFoods.baked_apple).group(SPTabs.tabFood));
		SPItems.fried_onion = new Item(new FabricItemSettings().food(SPFoods.fried_onion).group(SPTabs.tabFood));

		//(hunger) x * 0.5 = a hearts (Max 20)
	}

	public static void register()
	{
		registerItem(SPItems.apple_pie, "apple_pie");
		registerItem(SPItems.beef_pie, "beef_pie");
		registerItem(SPItems.pork_pie, "pork_pie");
		registerItem(SPItems.chicken_pie, "chicken_pie");
		registerItem(SPItems.mutton_pie, "mutton_pie");
		registerItem(SPItems.rabbit_pie, "rabbit_pie");
		registerItem(SPItems.vegetable_pie, "vegetable_pie");
		registerItem(SPItems.raw_onion, "raw_onion");
		registerItem(SPItems.onion_soup, "onion_soup");
		registerItem(SPItems.fried_egg, "fried_egg");
		registerItem(SPItems.roast_carrot, "roast_carrot");
		registerItem(SPItems.cheese, "cheese");
		registerItem(SPItems.cheese_bread, "cheese_bread");
		registerItem(SPItems.melted_cheese_bread, "melted_cheese_bread");
		registerItem(SPItems.cupcake, "cupcake");
		registerItem(SPItems.cheese_cupcake, "cheese_cupcake");
		registerItem(SPItems.sponge_cupcake, "sponge_cupcake");
		registerItem(SPItems.baked_apple, "baked_apple");
		registerItem(SPItems.fried_onion, "fried_onion");
	}

	public static void registerItem(Item item, String registryName) {

		Registry.register(Registry.ITEM, new Identifier(SPReference.MOD_ID, registryName), item);
	}

	private static FoodComponent buildSoup(int hunger) {
		return (new Builder()).hunger(hunger).saturationModifier(0.6F).build();
	}

}
