package net.coolsimulations.SurvivalPlus.api;

import net.coolsimulations.SurvivalPlus.core.mixin.BlockTagsMixin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.StaticTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class SPTags
{
    public static class Blocks
    {
    	public static final Tag<Block> STORAGE_BLOCKS_COPPER = tag("copper_blocks");
    	public static final Tag<Block> STORAGE_BLOCKS_TIN = tag("tin_blocks");
    	public static final Tag<Block> STORAGE_BLOCKS_BRONZE = tag("bronze_blocks");
    	public static final Tag<Block> STORAGE_BLOCKS_TITANIUM = tag("titanium_blocks");
    	
    	public static final Tag<Block> ORES_COPPER = tag("copper_ores");
    	public static final Tag<Block> ORES_TIN = tag("tin_ores");
    	public static final Tag<Block> ORES_TITANIUM = tag("titanium_ores");
    	
    	public static final Tag<Block> CARDBOARD = tag("cardboards");
    	
    	public static final Tag<Block> CAMPFIRE = tag("campfires");

        private static Tag<Block> tag(String name)
        {
            return BlockTagsMixin.register("c:" + name);
        }
    }

    public static class Items
    {
    	public static final Tag<Item> INGOTS_COPPER = tag("copper_ingots");
    	public static final Tag<Item> INGOTS_TIN = tag("tin_ingots");
    	public static final Tag<Item> INGOTS_BRONZE = tag("bronze_ingots");
    	public static final Tag<Item> INGOTS_TITANIUM = tag("titanium_ingots");
    	
    	public static final Tag<Item> NUGGETS_BRONZE = tag("bronze_nuggets");
    	public static final Tag<Item> NUGGETS_TITANIUM = tag("titanium_nuggets");
    	
    	public static final Tag<Item> GEMS_AMETHYST = tag("amethysts");
    	public static final Tag<Item> GEMS_RUBY = tag("rubies");
    	public static final Tag<Item> GEMS_SAPPHIRE = tag("sapphires");
    	public static final Tag<Item> GEMS_TOPAZ = tag("topazes");
    	public static final Tag<Item> GEMS_SPINEL = tag("spinels");
    	public static final Tag<Item> GEMS_PEARL = tag("pearls");
    	
    	//public static final Tag<Item> DYES_WHITE = tag("white_dyes");
    	
    	/**public static final Tag<Item> DUSTS_COPPER = tag("copper_dusts");
    	public static final Tag<Item> DUSTS_TIN = tag("tin_dusts");
    	public static final Tag<Item> DUSTS_TITANIUM = tag("titanium_dusts");**/
    	
    	/**public static final Tag<Item> CRUSHED_TITANIUM = tag("crushed/titanium");
    	public static final Tag<Item> CRUSHED_PURIFIED_TITANIUM = tag("crushed/purified/titanium");
    	public static final Tag<Item> DUSTS_TINY_TITANIUM = tag("dusts/tiny/titanium");
    	public static final Tag<Item> PLATES_TITANIUM = tag("plates/titanium");
    	public static final Tag<Item> PLATES_DENSE_TITANIUM = tag("plates/dense/titanium");
    	public static final Tag<Item> CASINGS_TITANIUM = tag("casings/titanium");**/
    	
    	public static final Tag<Item> CROPS_ONION = tag("onions");
    	
    	public static final Tag<Item> CUPS_PAPER = tag("paper_cups");
    	
    	public static final Tag<Item> FOOD_BAKED_APPLE = tag("baked_apples");
    	public static final Tag<Item> FOOD_CHEESE = tag("cheeses");
    	public static final Tag<Item> FOOD_SOUP_ONION = tag("onion_soups");
    	public static final Tag<Item> FOOD_FRIED_ONION = tag("fried_onions");
    	public static final Tag<Item> FOOD_FRIED_EGG = tag("fried_eggs");
    	public static final Tag<Item> FOOD_ROAST_CARROT = tag("roast_carrots");
    	public static final Tag<Item> FOOD_PIE = tag("pies");
    	public static final Tag<Item> FOOD_BREAD_CHEESE = tag("cheese_breads");
    	public static final Tag<Item> FOOD_BREAD_MELTED_CHEESE = tag("melted_cheese_breads");
    	public static final Tag<Item> FOOD_CUPCAKE = tag("cupcakes");
    	public static final Tag<Item> SEEDS_ONION = tag("onion_seeds");
    	public static final Tag<Item> FOOD_CAKE = tag("cakes");

        private static Tag.Named<Item> tag(String name)
        {
        	return StaticTags.create(new ResourceLocation("item"), TagContainer::getItems).bind("c:" + name);
        }
    }
}