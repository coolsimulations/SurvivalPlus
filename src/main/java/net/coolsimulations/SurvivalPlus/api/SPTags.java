package net.coolsimulations.SurvivalPlus.api;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class SPTags
{
	public static class Blocks
	{
		//private static final TagRegistry<Block> collection = new TagRegistry<>();
		public static final TagKey<Block> STORAGE_BLOCKS_TIN = tag("storage_blocks/tin");
		public static final TagKey<Block> STORAGE_BLOCKS_BRONZE = tag("storage_blocks/bronze");
		public static final TagKey<Block> STORAGE_BLOCKS_TITANIUM = tag("storage_blocks/titanium");
		public static final TagKey<Block> STORAGE_BLOCKS_RAW_TIN = tag("storage_blocks/raw_tin");
		public static final TagKey<Block> STORAGE_BLOCKS_RAW_TITANIUM = tag("storage_blocks/raw_titanium");
		
		public static final TagKey<Block> ORES_TIN = tag("ores/tin");
		public static final TagKey<Block> ORES_TITANIUM = tag("ores/titanium");

		public static final TagKey<Block> CARDBOARD = tag("cardboard");
		public static final TagKey<Block> CARDBOARD_PLAIN = tag("cardboard/plain");
		public static final TagKey<Block> CARDBOARD_BLACK = tag("cardboard/blue");
		public static final TagKey<Block> CARDBOARD_BROWN = tag("cardboard/brown");
		public static final TagKey<Block> CARDBOARD_CYAN = tag("cardboard/cyan");
		public static final TagKey<Block> CARDBOARD_GREEN = tag("cardboard/green");
		public static final TagKey<Block> CARDBOARD_GREY = tag("cardboard/grey");
		public static final TagKey<Block> CARDBOARD_LIGHT_BLUE = tag("cardboard/light_blue");
		public static final TagKey<Block> CARDBOARD_LIGHT_GREY = tag("cardboard/light_grey");
		public static final TagKey<Block> CARDBOARD_LIME = tag("cardboard/lime");
		public static final TagKey<Block> CARDBOARD_MAGENTA = tag("cardboard/magenta");
		public static final TagKey<Block> CARDBOARD_ORANGE = tag("cardboard/orange");
		public static final TagKey<Block> CARDBOARD_PINK = tag("cardboard/pink");
		public static final TagKey<Block> CARDBOARD_PURPLE = tag("cardboard/purple");
		public static final TagKey<Block> CARDBOARD_RED = tag("cardboard/red");
		public static final TagKey<Block> CARDBOARD_WHITE = tag("cardboard/white");
		public static final TagKey<Block> CARDBOARD_YELLOW = tag("cardboard/yellow");

		private static TagKey<Block> tag(String name)
        {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
	}

	public static class Items
	{
		//private static final TagRegistry<Item> collection = new TagRegistry<>();
		public static final TagKey<Item> STORAGE_BLOCKS_TIN = tag("storage_blocks/tin");
		public static final TagKey<Item> STORAGE_BLOCKS_BRONZE = tag("storage_blocks/bronze");
		public static final TagKey<Item> STORAGE_BLOCKS_TITANIUM = tag("storage_blocks/titanium");
		public static final TagKey<Item> STORAGE_BLOCKS_RAW_TIN = tag("storage_blocks/raw_tin");
		public static final TagKey<Item> STORAGE_BLOCKS_RAW_TITANIUM = tag("storage_blocks/raw_titanium");
		
		public static final TagKey<Item> ORES_TIN = tag("ores/tin");
		public static final TagKey<Item> ORES_TITANIUM = tag("ores/titanium");

		public static final TagKey<Item> CARDBOARD = tag("cardboard");
		public static final TagKey<Item> CARDBOARD_PLAIN = tag("cardboard/plain");
		public static final TagKey<Item> CARDBOARD_BLACK = tag("cardboard/blue");
		public static final TagKey<Item> CARDBOARD_BROWN = tag("cardboard/brown");
		public static final TagKey<Item> CARDBOARD_CYAN = tag("cardboard/cyan");
		public static final TagKey<Item> CARDBOARD_GREEN = tag("cardboard/green");
		public static final TagKey<Item> CARDBOARD_GREY = tag("cardboard/grey");
		public static final TagKey<Item> CARDBOARD_LIGHT_BLUE = tag("cardboard/light_blue");
		public static final TagKey<Item> CARDBOARD_LIGHT_GREY = tag("cardboard/light_grey");
		public static final TagKey<Item> CARDBOARD_LIME = tag("cardboard/lime");
		public static final TagKey<Item> CARDBOARD_MAGENTA = tag("cardboard/magenta");
		public static final TagKey<Item> CARDBOARD_ORANGE = tag("cardboard/orange");
		public static final TagKey<Item> CARDBOARD_PINK = tag("cardboard/pink");
		public static final TagKey<Item> CARDBOARD_PURPLE = tag("cardboard/purple");
		public static final TagKey<Item> CARDBOARD_RED = tag("cardboard/red");
		public static final TagKey<Item> CARDBOARD_WHITE = tag("cardboard/white");
		public static final TagKey<Item> CARDBOARD_YELLOW = tag("cardboard/yellow");
		
		public static final TagKey<Item> INGOTS_TIN = tag("ingots/tin");
		public static final TagKey<Item> INGOTS_BRONZE = tag("ingots/bronze");
		public static final TagKey<Item> INGOTS_TITANIUM = tag("ingots/titanium");

		public static final TagKey<Item> NUGGETS_BRONZE = tag("nuggets/bronze");
		public static final TagKey<Item> NUGGETS_TITANIUM = tag("nuggets/titanium");
		
    	public static final TagKey<Item> SHARDS_RUBY = tag("gems/ruby");
    	public static final TagKey<Item> SHARDS_SAPPHIRE = tag("gems/sapphire");
    	public static final TagKey<Item> SHARDS_TOPAZ = tag("gems/topaz");
    	public static final TagKey<Item> SHARDS_SPINEL = tag("gems/spinel");
    	public static final TagKey<Item> PEARLS = tag("gems/pearl");
    	
    	public static final TagKey<Item> RAW_ORES_TIN = tag("raw_materials/tin");
    	public static final TagKey<Item> RAW_ORES_TITANIUM = tag("raw_materials/titanium");

		public static final TagKey<Item> DYES_WHITE = tag("dyes/white");

		public static final TagKey<Item> DUSTS_COPPER = tag("dusts/copper");
		public static final TagKey<Item> DUSTS_TIN = tag("dusts/tin");
		public static final TagKey<Item> DUSTS_TITANIUM = tag("dusts/titanium");

		public static final TagKey<Item> PLATES_DENSE_TITANIUM = tag("plates/dense/titanium");

		public static final TagKey<Item> CROPS_ONION = tag("crops/onion");

		public static final TagKey<Item> CUPS_PAPER = tag("cups/paper");

		public static final TagKey<Item> FOOD_BAKED_APPLE = tag("food/baked/apple");
		public static final TagKey<Item> FOOD_CHEESE = tag("food/cheese");
		public static final TagKey<Item> FOOD_SOUP_ONION = tag("food/soup/onion");
		public static final TagKey<Item> FOOD_FRIED_ONION = tag("food/fried/onion");
		public static final TagKey<Item> FOOD_FRIED_EGG = tag("food/fried/egg");
		public static final TagKey<Item> FOOD_ROAST_CARROT = tag("food/roast/carrot");
		public static final TagKey<Item> FOOD_PIE_APPLE = tag("food/pie/apple");
		public static final TagKey<Item> FOOD_PIE_BEEF = tag("food/pie/beef");
		public static final TagKey<Item> FOOD_PIE_CHICKEN = tag("food/pie/chicken");
		public static final TagKey<Item> FOOD_PIE_MUTTON = tag("food/pie/mutton");
		public static final TagKey<Item> FOOD_PIE_PORK = tag("food/pie/pork");
		public static final TagKey<Item> FOOD_PIE_RABBIT = tag("food/pie/rabbit");
		public static final TagKey<Item> FOOD_PIE_VEGETABLE = tag("food/pie/vegetable");
		public static final TagKey<Item> FOOD_BREAD_CHEESE = tag("food/bread/cheese");
		public static final TagKey<Item> FOOD_BREAD_MELTED_CHEESE = tag("food/bread/melted/cheese");
		public static final TagKey<Item> FOOD_CUPCAKE = tag("food/cupcake");
		public static final TagKey<Item> FOOD_CUPCAKE_CHEESE = tag("food/cupcake/cheese");
		public static final TagKey<Item> FOOD_CUPCAKE_SPONGE = tag("food/cupcake/sponge");
		public static final TagKey<Item> SEEDS_ONION = tag("seeds/onion");
		public static final TagKey<Item> FOOD_CAKE_CHEESE = tag("food/cake/cheese");
		public static final TagKey<Item> FOOD_CAKE_SPONGE = tag("food/cake/sponge");

		public static final TagKey<Item> BUCKETS = tag("buckets/charcoal");
		
    	public static final TagKey<Item> SHEARS = tag("shears");
    	
    	public static final TagKey<Item> SAWS = tag(SPCompatibilityManager.NO_TREE_PUNCHING_MODID, "saws");
    	
    	public static final TagKey<Item> KNIVES = tag(SPCompatibilityManager.NO_TREE_PUNCHING_MODID, "knives");

		private static TagKey<Item> tag(String name)
        {
			return ItemTags.create(new ResourceLocation("forge", name));
        }
		
        private static TagKey<Item> tag(String modid, String name)
        {
            return ItemTags.create(new ResourceLocation(modid, name));
        }
	}
}