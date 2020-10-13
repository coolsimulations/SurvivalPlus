package net.coolsimulations.SurvivalPlus.core.recipes;

import java.util.Iterator;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.util.IItemProvider;

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
		
		registerCompostable(SPItems.raw_onion, RARE);
		registerCompostable(SPItems.onion_seeds, COMMON);
		registerCompostable(SPItems.baked_apple, EPIC);
		registerCompostable(SPItems.cheese, UNCOMMON);
		registerCompostable(SPItems.fried_onion, RARE);
		registerCompostable(SPItems.roast_carrot, EPIC);
		registerCompostable(SPItems.apple_pie, LEGENDARY);
		registerCompostable(SPItems.beef_pie, LEGENDARY);
		registerCompostable(SPItems.chicken_pie, LEGENDARY);
		registerCompostable(SPItems.mutton_pie, LEGENDARY);
		registerCompostable(SPItems.pork_pie, LEGENDARY);
		registerCompostable(SPItems.rabbit_pie, LEGENDARY);
		registerCompostable(SPItems.vegetable_pie, LEGENDARY);
		registerCompostable(SPItems.cheese_bread, LEGENDARY);
		registerCompostable(SPItems.melted_cheese_bread, LEGENDARY);
		registerCompostable(SPItems.cupcake, COMMON);
		registerCompostable(SPItems.cheese_cupcake, COMMON);
		registerCompostable(SPItems.sponge_cupcake, COMMON);
		registerCompostable(SPBlocks.cheese_cake, LEGENDARY);
		registerCompostable(SPBlocks.sponge_cake, LEGENDARY);
	}
	
	protected static void registerCompostableTag(INamedTag<Item> tag, float rarity) {
		
		for(Iterator<Item> item = tag.func_230236_b_().iterator(); item.hasNext();)
			registerCompostable(item.next(), rarity);
	}
	
	protected static void registerCompostable(IItemProvider item, float rarity) {
		ComposterBlock.CHANCES.put(item.asItem(), rarity);
	}

}
