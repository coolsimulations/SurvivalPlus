package net.coolsimulations.SurvivalPlus.core.recipes;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusComposterRecipes {
	
	protected static float COMMON = 0.3F;
	protected static float UNCOMMON = 0.5F;
	protected static float RARE = 0.65F;
	protected static float EPIC = 0.85F;
	protected static float LEGENDARY = 1.0F;
	
	public static void init() {
		
		//SurvivalPlus Tags haven't been working in 1.13 or 1.14, however they do work in SurvivalPlus Lightsabers so I'm assuming that it order of loading related
		//So these lines below do not work, but leaving them there in case other mods tags work 
		/**registerCompostableTag(SPTags.Items.CROPS_ONION, RARE);
		registerCompostableTag(SPTags.Items.SEEDS_ONION, COMMON);
		registerCompostableTag(SPTags.Items.FOOD_BAKED_APPLE, EPIC);
		registerCompostableTag(SPTags.Items.FOOD_CHEESE, UNCOMMON);
		registerCompostableTag(SPTags.Items.FOOD_FRIED_ONION, RARE);
		registerCompostableTag(SPTags.Items.FOOD_ROAST_CARROT, EPIC);
		registerCompostableTag(SPTags.Items.FOOD_PIE_APPLE, LEGENDARY);
		registerCompostableTag(SPTags.Items.FOOD_PIE_BEEF, LEGENDARY);
		registerCompostableTag(SPTags.Items.FOOD_PIE_CHICKEN, LEGENDARY);
		registerCompostableTag(SPTags.Items.FOOD_PIE_MUTTON, LEGENDARY);
		registerCompostableTag(SPTags.Items.FOOD_PIE_PORK, LEGENDARY);
		registerCompostableTag(SPTags.Items.FOOD_PIE_RABBIT, LEGENDARY);
		registerCompostableTag(SPTags.Items.FOOD_PIE_VEGETABLE, LEGENDARY);
		registerCompostableTag(SPTags.Items.FOOD_BREAD_CHEESE, LEGENDARY);
		registerCompostableTag(SPTags.Items.FOOD_BREAD_MELTED_CHEESE, LEGENDARY);
		registerCompostableTag(SPTags.Items.FOOD_CUPCAKE, COMMON);
		registerCompostableTag(SPTags.Items.FOOD_CUPCAKE_CHEESE, COMMON);
		registerCompostableTag(SPTags.Items.FOOD_CUPCAKE_SPONGE, COMMON);
		registerCompostableTag(SPTags.Items.FOOD_CAKE_CHEESE, LEGENDARY);
		registerCompostableTag(SPTags.Items.FOOD_CAKE_SPONGE, LEGENDARY);**/
		
		registerCompostable(SPItems.raw_onion.get(), RARE);
		registerCompostable(SPItems.onion_seeds.get(), COMMON);
		registerCompostable(SPItems.baked_apple.get(), EPIC);
		registerCompostable(SPItems.cheese.get(), UNCOMMON);
		registerCompostable(SPItems.fried_onion.get(), RARE);
		registerCompostable(SPItems.roast_carrot.get(), EPIC);
		registerCompostable(SPItems.apple_pie.get(), LEGENDARY);
		registerCompostable(SPItems.beef_pie.get(), LEGENDARY);
		registerCompostable(SPItems.chicken_pie.get(), LEGENDARY);
		registerCompostable(SPItems.mutton_pie.get(), LEGENDARY);
		registerCompostable(SPItems.pork_pie.get(), LEGENDARY);
		registerCompostable(SPItems.rabbit_pie.get(), LEGENDARY);
		registerCompostable(SPItems.vegetable_pie.get(), LEGENDARY);
		registerCompostable(SPItems.cheese_bread.get(), LEGENDARY);
		registerCompostable(SPItems.melted_cheese_bread.get(), LEGENDARY);
		registerCompostable(SPItems.cupcake.get(), COMMON);
		registerCompostable(SPItems.cheese_cupcake.get(), COMMON);
		registerCompostable(SPItems.sponge_cupcake.get(), COMMON);
		registerCompostable(SPBlocks.cheese_cake.get(), LEGENDARY);
		registerCompostable(SPBlocks.sponge_cake.get(), LEGENDARY);
	}
	
	protected static void registerCompostableTag(TagKey<Item> tag, float rarity) {
		
		for(Item item : ForgeRegistries.ITEMS)
			if(new ItemStack(item).is(tag))
				registerCompostable(item, rarity);
	}
	
	protected static void registerCompostable(ItemLike item, float rarity) {
		ComposterBlock.COMPOSTABLES.put(item.asItem(), rarity);
	}

}
