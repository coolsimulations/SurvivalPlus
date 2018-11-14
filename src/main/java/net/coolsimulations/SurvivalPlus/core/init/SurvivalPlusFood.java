package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPItemFoodEffect;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSoup;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SurvivalPlusFood {
	
	public static void init(){
		SPItems.apple_pie = new ItemFood(8, 0.75F, false).setUnlocalizedName("apple_pie").setRegistryName("apple_pie").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.beef_pie = new ItemFood(10, 0.95F, true).setUnlocalizedName("beef_pie").setRegistryName("beef_pie").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.pork_pie = new ItemFood(10, 0.95F, true).setUnlocalizedName("pork_pie").setRegistryName("pork_pie").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.chicken_pie = new ItemFood(8, 0.75F, true).setUnlocalizedName("chicken_pie").setRegistryName("chicken_pie").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.mutton_pie = new ItemFood(8, 0.75F, true).setUnlocalizedName("mutton_pie").setRegistryName("mutton_pie").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.rabbit_pie = new ItemFood(8, 0.75F, true).setUnlocalizedName("rabbit_pie").setRegistryName("rabbit_pie").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.vegetable_pie = new ItemFood(7, 1.0F, false).setUnlocalizedName("vegetable_pie").setRegistryName("vegetable_pie").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.raw_onion = new SPItemFoodEffect(2, 1.0F, false, MobEffects.NAUSEA, 300).setUnlocalizedName("raw_onion").setRegistryName("raw_onion").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.onion_soup = new ItemSoup(10).setUnlocalizedName("onion_soup").setRegistryName("onion_soup").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.fried_egg = new ItemFood(2, 1.0F, false).setUnlocalizedName("fried_egg").setRegistryName("fried_egg").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.roast_carrot = new ItemFood(5, 0.5F, false).setUnlocalizedName("roast_carrot").setRegistryName("roast_carrot").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.cheese = new ItemFood(3, 1.0F, false).setUnlocalizedName("cheese").setRegistryName("cheese").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.cheese_bread = new ItemFood(9, 0.9F, false).setUnlocalizedName("cheese_bread").setRegistryName("cheese_bread").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.melted_cheese_bread = new ItemFood(11, 1.0F, false).setUnlocalizedName("melted_cheese_bread").setRegistryName("melted_cheese_bread").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.cupcake = new ItemFood(2, 0.1F, false).setUnlocalizedName("cupcake").setRegistryName("cupcake").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.cheese_cupcake = new ItemFood(3, 0.2F, false).setUnlocalizedName("cheese_cupcake").setRegistryName("cheese_cupcake").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.sponge_cupcake = new ItemFood(2, 0.1F, false).setUnlocalizedName("sponge_cupcake").setRegistryName("sponge_cupcake").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.baked_apple = new ItemFood(6, 0.5F, false).setUnlocalizedName("baked_apple").setRegistryName("baked_apple").setCreativeTab(SurvivalPlus.tabFood);
		SPItems.fried_onion = new ItemFood(4, 0.8F, false).setUnlocalizedName("fried_onion").setRegistryName("fried_onion").setCreativeTab(SurvivalPlus.tabFood);
		
		//(hunger) x * 0.5 = a hearts (Max 20)
	}
	public static void register()
	{
		GameRegistry.register(SPItems.apple_pie);
		GameRegistry.register(SPItems.beef_pie);
		GameRegistry.register(SPItems.pork_pie);
		GameRegistry.register(SPItems.chicken_pie);
		GameRegistry.register(SPItems.mutton_pie);
		GameRegistry.register(SPItems.rabbit_pie);
		GameRegistry.register(SPItems.vegetable_pie);
		GameRegistry.register(SPItems.raw_onion);
		GameRegistry.register(SPItems.onion_soup);
		GameRegistry.register(SPItems.fried_egg);
		GameRegistry.register(SPItems.roast_carrot);
		GameRegistry.register(SPItems.cheese);
		GameRegistry.register(SPItems.cheese_bread);
		GameRegistry.register(SPItems.melted_cheese_bread);
		GameRegistry.register(SPItems.cupcake);
		GameRegistry.register(SPItems.cheese_cupcake);
		GameRegistry.register(SPItems.sponge_cupcake);
		GameRegistry.register(SPItems.baked_apple);
		GameRegistry.register(SPItems.fried_onion);
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
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
