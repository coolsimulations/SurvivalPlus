package net.coolsimulations.SurvivalPlus.api;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties.Builder;

public class SPFoods {
	
	/**
	 * These are the food Items referred to in SurvivalPlusFood
	 */
	public static FoodProperties apple_pie = (new Builder()).nutrition(8).saturationMod(0.75F).build();
	public static FoodProperties beef_pie = (new Builder()).nutrition(10).saturationMod(0.95F).meat().build();
	public static FoodProperties pork_pie = (new Builder()).nutrition(10).saturationMod(0.95F).meat().build();
	public static FoodProperties chicken_pie = (new Builder()).nutrition(8).saturationMod(0.75F).meat().build();
	public static FoodProperties mutton_pie = (new Builder()).nutrition(8).saturationMod(0.75F).meat().build();
	public static FoodProperties rabbit_pie = (new Builder()).nutrition(8).saturationMod(0.75F).meat().build();
	public static FoodProperties vegetable_pie = (new Builder()).nutrition(7).saturationMod(1.0F).build();
	public static FoodProperties raw_onion = (new Builder()).nutrition(2).saturationMod(1.0F).effect(new MobEffectInstance(MobEffects.CONFUSION, 300), 1.0F).build();
	public static FoodProperties onion_soup = (new Builder()).nutrition(10).saturationMod(0.6F).build();
	public static FoodProperties fried_egg = (new Builder()).nutrition(2).saturationMod(1.0F).fast().build();
	public static FoodProperties roast_carrot = (new Builder()).nutrition(5).saturationMod(0.5F).build();
	public static FoodProperties cheese = (new Builder()).nutrition(3).saturationMod(1.0F).fast().build();
	public static FoodProperties cheese_bread = (new Builder()).nutrition(9).saturationMod(0.9F).build();
	public static FoodProperties melted_cheese_bread = (new Builder()).nutrition(11).saturationMod(1.0F).build();
	public static FoodProperties cupcake = (new Builder()).nutrition(2).saturationMod(0.1F).fast().build();
	public static FoodProperties cheese_cupcake = (new Builder()).nutrition(3).saturationMod(0.2F).fast().build();
	public static FoodProperties sponge_cupcake = (new Builder()).nutrition(2).saturationMod(0.1F).fast().build();
	public static FoodProperties baked_apple = (new Builder()).nutrition(6).saturationMod(0.5F).build();
	public static FoodProperties fried_onion = (new Builder()).nutrition(4).saturationMod(0.8F).fast().build();

}
