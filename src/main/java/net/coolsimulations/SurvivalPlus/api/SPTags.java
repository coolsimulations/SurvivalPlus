package net.coolsimulations.SurvivalPlus.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagRegistry;
import net.minecraft.tags.TagRegistry.NamedTag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeMod;

public class SPTags
{
	public static class Blocks
	{
		private static final TagRegistry<Block> collection = new TagRegistry<>();
		public static final ITag.INamedTag<Block> STORAGE_BLOCKS_COPPER = tag("storage_blocks/copper");
		public static final ITag.INamedTag<Block> STORAGE_BLOCKS_TIN = tag("storage_blocks/tin");
		public static final ITag.INamedTag<Block> STORAGE_BLOCKS_BRONZE = tag("storage_blocks/bronze");
		public static final ITag.INamedTag<Block> STORAGE_BLOCKS_TITANIUM = tag("storage_blocks/titanium");

		public static final ITag.INamedTag<Block> ORES_COPPER = tag("ores/copper");
		public static final ITag.INamedTag<Block> ORES_TIN = tag("ores/tin");
		public static final ITag.INamedTag<Block> ORES_TITANIUM = tag("ores/titanium");

		public static final ITag.INamedTag<Block> CARDBOARD = tag("cardboard");
		public static final ITag.INamedTag<Block> CARDBOARD_PLAIN = tag("cardboard/plain");
		public static final ITag.INamedTag<Block> CARDBOARD_BLACK = tag("cardboard/blue");
		public static final ITag.INamedTag<Block> CARDBOARD_BROWN = tag("cardboard/brown");
		public static final ITag.INamedTag<Block> CARDBOARD_CYAN = tag("cardboard/cyan");
		public static final ITag.INamedTag<Block> CARDBOARD_GREEN = tag("cardboard/green");
		public static final ITag.INamedTag<Block> CARDBOARD_GREY = tag("cardboard/grey");
		public static final ITag.INamedTag<Block> CARDBOARD_LIGHT_BLUE = tag("cardboard/light_blue");
		public static final ITag.INamedTag<Block> CARDBOARD_LIGHT_GREY = tag("cardboard/light_grey");
		public static final ITag.INamedTag<Block> CARDBOARD_LIME = tag("cardboard/lime");
		public static final ITag.INamedTag<Block> CARDBOARD_MAGENTA = tag("cardboard/magenta");
		public static final ITag.INamedTag<Block> CARDBOARD_ORANGE = tag("cardboard/orange");
		public static final ITag.INamedTag<Block> CARDBOARD_PINK = tag("cardboard/pink");
		public static final ITag.INamedTag<Block> CARDBOARD_PURPLE = tag("cardboard/purple");
		public static final ITag.INamedTag<Block> CARDBOARD_RED = tag("cardboard/red");
		public static final ITag.INamedTag<Block> CARDBOARD_WHITE = tag("cardboard/white");
		public static final ITag.INamedTag<Block> CARDBOARD_YELLOW = tag("cardboard/yellow");

		public static final ITag.INamedTag<Block> CAMPFIRE = tag("campfire");

		private static ITag.INamedTag<Block> tag(String name)
        {
            return BlockTags.makeWrapperTag("forge:" + name);
        }
	}

	public static class Items
	{
		private static final TagRegistry<Item> collection = new TagRegistry<>();
		public static final ITag.INamedTag<Item> INGOTS_COPPER = tag("ingots/copper");
		public static final ITag.INamedTag<Item> INGOTS_TIN = tag("ingots/tin");
		public static final ITag.INamedTag<Item> INGOTS_BRONZE = tag("ingots/bronze");
		public static final ITag.INamedTag<Item> INGOTS_TITANIUM = tag("ingots/titanium");

		public static final ITag.INamedTag<Item> NUGGETS_BRONZE = tag("nuggets/bronze");
		public static final ITag.INamedTag<Item> NUGGETS_TITANIUM = tag("nuggets/titanium");

		public static final ITag.INamedTag<Item> GEMS_AMETHYST = tag("gems/amethyst");
		public static final ITag.INamedTag<Item> GEMS_RUBY = tag("gems/ruby");
		public static final ITag.INamedTag<Item> GEMS_SAPPHIRE = tag("gems/sapphire");
		public static final ITag.INamedTag<Item> GEMS_TOPAZ = tag("gems/topaz");
		public static final ITag.INamedTag<Item> GEMS_SPINEL = tag("gems/spinel");
		public static final ITag.INamedTag<Item> GEMS_PEARL = tag("gems/pearl");

		public static final ITag.INamedTag<Item> DYES_WHITE = tag("dyes/white");

		public static final ITag.INamedTag<Item> DUSTS_COPPER = tag("dusts/copper");
		public static final ITag.INamedTag<Item> DUSTS_TIN = tag("dusts/tin");
		public static final ITag.INamedTag<Item> DUSTS_TITANIUM = tag("dusts/titanium");

		/**public static final ITag.INamedTag<Item> CRUSHED_TITANIUM = tag("crushed/titanium");
    	public static final ITag.INamedTag<Item> CRUSHED_PURIFIED_TITANIUM = tag("crushed/purified/titanium");
    	public static final ITag.INamedTag<Item> DUSTS_TINY_TITANIUM = tag("dusts/tiny/titanium");
    	public static final ITag.INamedTag<Item> PLATES_TITANIUM = tag("plates/titanium");
    	public static final ITag.INamedTag<Item> PLATES_DENSE_TITANIUM = tag("plates/dense/titanium");
    	public static final ITag.INamedTag<Item> CASINGS_TITANIUM = tag("casings/titanium");**/

		public static final ITag.INamedTag<Item> CROPS_ONION = tag("crops/onion");

		public static final ITag.INamedTag<Item> CUPS_PAPER = tag("cups/paper");

		public static final ITag.INamedTag<Item> FOOD_BAKED_APPLE = tag("food/baked/apple");
		public static final ITag.INamedTag<Item> FOOD_CHEESE = tag("food/cheese");
		public static final ITag.INamedTag<Item> FOOD_SOUP_ONION = tag("food/soup/onion");
		public static final ITag.INamedTag<Item> FOOD_FRIED_ONION = tag("food/fried/onion");
		public static final ITag.INamedTag<Item> FOOD_FRIED_EGG = tag("food/fried/egg");
		public static final ITag.INamedTag<Item> FOOD_ROAST_CARROT = tag("food/roast/carrot");
		public static final ITag.INamedTag<Item> FOOD_PIE_APPLE = tag("food/pie/apple");
		public static final ITag.INamedTag<Item> FOOD_PIE_BEEF = tag("food/pie/beef");
		public static final ITag.INamedTag<Item> FOOD_PIE_CHICKEN = tag("food/pie/chicken");
		public static final ITag.INamedTag<Item> FOOD_PIE_MUTTON = tag("food/pie/mutton");
		public static final ITag.INamedTag<Item> FOOD_PIE_PORK = tag("food/pie/pork");
		public static final ITag.INamedTag<Item> FOOD_PIE_RABBIT = tag("food/pie/rabbit");
		public static final ITag.INamedTag<Item> FOOD_PIE_VEGETABLE = tag("food/pie/vegetable");
		public static final ITag.INamedTag<Item> FOOD_BREAD_CHEESE = tag("food/bread/cheese");
		public static final ITag.INamedTag<Item> FOOD_BREAD_MELTED_CHEESE = tag("food/bread/melted/cheese");
		public static final ITag.INamedTag<Item> FOOD_CUPCAKE = tag("food/cupcake");
		public static final ITag.INamedTag<Item> FOOD_CUPCAKE_CHEESE = tag("food/cupcake/cheese");
		public static final ITag.INamedTag<Item> FOOD_CUPCAKE_SPONGE = tag("food/cupcake/sponge");
		public static final ITag.INamedTag<Item> SEEDS_ONION = tag("seeds/onion");
		public static final ITag.INamedTag<Item> FOOD_CAKE_CHEESE = tag("food/cake/cheese");
		public static final ITag.INamedTag<Item> FOOD_CAKE_SPONGE = tag("food/cake/sponge");

		public static final ITag.INamedTag<Item> BUCKETS = tag("buckets/charcoal");

		private static INamedTag<Item> tag(String name)
        {
			return ItemTags.makeWrapperTag("forge:" + name);
        }
	}
}