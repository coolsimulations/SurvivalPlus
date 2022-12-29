package net.coolsimulations.SurvivalPlus.api;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class SPTags
{
    public static class Blocks
    {
    	public static final TagKey<Block> STORAGE_BLOCKS_COPPER = tag("copper_blocks");
    	public static final TagKey<Block> STORAGE_BLOCKS_TIN = tag("tin_blocks");
    	public static final TagKey<Block> STORAGE_BLOCKS_BRONZE = tag("bronze_blocks");
    	public static final TagKey<Block> STORAGE_BLOCKS_TITANIUM = tag("titanium_blocks");
    	
    	public static final TagKey<Block> RAW_STORAGE_BLOCKS_TIN = tag("raw_tin_blocks");
    	public static final TagKey<Block> RAW_STORAGE_BLOCKS_BRONZE = tag("raw_bronze_blocks");
    	public static final TagKey<Block> RAW_STORAGE_BLOCKS_TITANIUM = tag("raw_titanium_blocks");
    	
    	public static final TagKey<Block> ORES_COPPER = tag("copper_ores");
    	public static final TagKey<Block> ORES_TIN = tag("tin_ores");
    	public static final TagKey<Block> ORES_TITANIUM = tag("titanium_ores");
    	
    	public static final TagKey<Block> CARDBOARD = tag("cardboards");

    	private static TagKey<Block> tag(String name)
        {
        	return TagKey.create(Registries.BLOCK, new ResourceLocation("c", name));
        }
    }

    public static class Items
    {
    	public static final TagKey<Item> RAW_STORAGE_BLOCKS_TIN = tag("raw_tin_blocks");
    	public static final TagKey<Item> RAW_STORAGE_BLOCKS_BRONZE = tag("raw_bronze_blocks");
    	public static final TagKey<Item> RAW_STORAGE_BLOCKS_TITANIUM = tag("raw_titanium_blocks");
    	
    	public static final TagKey<Item> ORES_COPPER = tag("copper_ores");
    	public static final TagKey<Item> ORES_TIN = tag("tin_ores");
    	public static final TagKey<Item> ORES_TITANIUM = tag("titanium_ores");
    	
    	public static final TagKey<Item> CARDBOARD = tag("cardboards");
    	
    	public static final TagKey<Item> INGOTS_COPPER = tag("copper_ingots");
    	public static final TagKey<Item> INGOTS_TIN = tag("tin_ingots");
    	public static final TagKey<Item> INGOTS_BRONZE = tag("bronze_ingots");
    	public static final TagKey<Item> INGOTS_TITANIUM = tag("titanium_ingots");
    	
    	public static final TagKey<Item> NUGGETS_BRONZE = tag("bronze_nuggets");
    	public static final TagKey<Item> NUGGETS_TITANIUM = tag("titanium_nuggets");
    	
    	public static final TagKey<Item> SHARDS_AMETHYST = tag("amethyst_shards");
    	public static final TagKey<Item> SHARDS_RUBY = tag("ruby_shards");
    	public static final TagKey<Item> SHARDS_SAPPHIRE = tag("sapphire_shards");
    	public static final TagKey<Item> SHARDS_TOPAZ = tag("topaz_shards");
    	public static final TagKey<Item> SHARDS_SPINEL = tag("spinel_shards");
    	public static final TagKey<Item> PEARLS = tag("pearls");
    	
    	public static final TagKey<Item> RAW_ORES_TIN = tag("raw_tins_ores");
    	public static final TagKey<Item> RAW_ORES_TITANIUM = tag("raw_titanium_ores");
    	
    	//public static final Tag<Item> DYES_WHITE = tag("white_dyes");
    	
    	/**public static final TagKey<Item> DUSTS_TIN = tag("tin_dusts");
    	public static final TagKey<Item> DUSTS_TITANIUM = tag("titanium_dusts");**/
    	
    	/**public static final TagKey<Item> CRUSHED_TITANIUM = tag("crushed/titanium");
    	public static final TagKey<Item> CRUSHED_PURIFIED_TITANIUM = tag("crushed/purified/titanium");
    	public static final TagKey<Item> DUSTS_TINY_TITANIUM = tag("dusts/tiny/titanium");
    	public static final TagKey<Item> PLATES_TITANIUM = tag("plates/titanium");
    	public static final TagKey<Item> PLATES_DENSE_TITANIUM = tag("plates/dense/titanium");
    	public static final TagKey<Item> CASINGS_TITANIUM = tag("casings/titanium");**/
    	
    	public static final TagKey<Item> CROPS_ONION = tag("onions");
    	
    	public static final TagKey<Item> CUPS_PAPER = tag("paper_cups");
    	
    	public static final TagKey<Item> FOOD_BAKED_APPLE = tag("baked_apples");
    	public static final TagKey<Item> FOOD_CHEESE = tag("cheeses");
    	public static final TagKey<Item> FOOD_SOUP_ONION = tag("onion_soups");
    	public static final TagKey<Item> FOOD_FRIED_ONION = tag("fried_onions");
    	public static final TagKey<Item> FOOD_FRIED_EGG = tag("fried_eggs");
    	public static final TagKey<Item> FOOD_ROAST_CARROT = tag("roast_carrots");
    	public static final TagKey<Item> FOOD_PIE = tag("pies");
    	public static final TagKey<Item> FOOD_BREAD_CHEESE = tag("cheese_breads");
    	public static final TagKey<Item> FOOD_BREAD_MELTED_CHEESE = tag("melted_cheese_breads");
    	public static final TagKey<Item> FOOD_CUPCAKE = tag("cupcakes");
    	public static final TagKey<Item> SEEDS_ONION = tag("onion_seeds");
    	public static final TagKey<Item> FOOD_CAKE = tag("cakes");

        private static TagKey<Item> tag(String name)
        {
        	return TagKey.create(Registries.ITEM, new ResourceLocation("c", name));
        }
    }
}