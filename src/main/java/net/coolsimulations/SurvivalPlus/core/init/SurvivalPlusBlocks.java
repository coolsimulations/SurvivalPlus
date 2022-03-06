package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockMetal;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockOre;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCandleCheeseCake;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCandleSpongeCake;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboard;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCheeseCake;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockOnionCrop;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockSpongeCake;
import net.coolsimulations.SurvivalPlus.core.items.ItemCardboardLantern;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public class SurvivalPlusBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SPReference.MOD_ID);
	public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	
	private static final RegistryObject<Block> raw_tin_block = BLOCKS.register("raw_tin_block", () -> new SPBlockMetal(MaterialColor.METAL, SPBlockMetal.Resource.TIER_0));
	private static final RegistryObject<Block> tin_block = BLOCKS.register("tin_block", () -> new SPBlockMetal(MaterialColor.METAL, SPBlockMetal.Resource.TIER_0));
	private static final RegistryObject<Block> onion = BLOCKS.register("onion", () -> new BlockOnionCrop());
	private static final RegistryObject<Block> tin_ore = BLOCKS.register("tin_ore", () -> new SPBlockOre(SPBlockOre.Resource.TIER_1, false));
	private static final RegistryObject<Block> deepslate_tin_ore = BLOCKS.register("deepslate_tin_ore", () -> new SPBlockOre(SPBlockOre.Resource.TIER_1_DEEPSLATE, false));
	private static final RegistryObject<Block> bronze_block = BLOCKS.register("bronze_block", () -> new SPBlockMetal(MaterialColor.COLOR_BROWN, SPBlockMetal.Resource.TIER_1));
	private static final RegistryObject<Block> raw_titanium_block = BLOCKS.register("raw_titanium_block", () -> new SPBlockMetal(MaterialColor.DIAMOND, SPBlockMetal.Resource.TIER_2));
	private static final RegistryObject<Block> titanium_block = BLOCKS.register("titanium_block", () -> new SPBlockMetal(MaterialColor.DIAMOND, SPBlockMetal.Resource.TIER_2));
	private static final RegistryObject<Block> titanium_ore = BLOCKS.register("titanium_ore", () -> new SPBlockOre(SPBlockOre.Resource.TIER_2, false));
	private static final RegistryObject<Block> deepslate_titanium_ore = BLOCKS.register("deepslate_titanium_ore", () -> new SPBlockOre(SPBlockOre.Resource.TIER_2_DEEPSLATE, false));
	private static final RegistryObject<Block> cheese_cake = BLOCKS.register("cheese_cake", () -> new BlockCheeseCake());
	private static final RegistryObject<Block> candle_cheese_cake = BLOCKS.register("candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.CANDLE));
	private static final RegistryObject<Block> white_candle_cheese_cake = BLOCKS.register("white_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.WHITE_CANDLE));
	private static final RegistryObject<Block> light_grey_candle_cheese_cake = BLOCKS.register("light_grey_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.LIGHT_GRAY_CANDLE));
	private static final RegistryObject<Block> grey_candle_cheese_cake = BLOCKS.register("grey_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.GRAY_CANDLE));
	private static final RegistryObject<Block> black_candle_cheese_cake = BLOCKS.register("black_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.BLACK_CANDLE));
	private static final RegistryObject<Block> red_candle_cheese_cake = BLOCKS.register("red_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.RED_CANDLE));
	private static final RegistryObject<Block> orange_candle_cheese_cake = BLOCKS.register("orange_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.ORANGE_CANDLE));
	private static final RegistryObject<Block> yellow_candle_cheese_cake = BLOCKS.register("yellow_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.YELLOW_CANDLE));
	private static final RegistryObject<Block> lime_candle_cheese_cake = BLOCKS.register("lime_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.LIME_CANDLE));
	private static final RegistryObject<Block> green_candle_cheese_cake = BLOCKS.register("green_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.GREEN_CANDLE));
	private static final RegistryObject<Block> light_blue_candle_cheese_cake = BLOCKS.register("light_blue_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.LIGHT_BLUE_CANDLE));
	private static final RegistryObject<Block> cyan_candle_cheese_cake = BLOCKS.register("cyan_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.CYAN_CANDLE));
	private static final RegistryObject<Block> blue_candle_cheese_cake = BLOCKS.register("blue_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.BLUE_CANDLE));
	private static final RegistryObject<Block> purple_candle_cheese_cake = BLOCKS.register("purple_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.PURPLE_CANDLE));
	private static final RegistryObject<Block> magenta_candle_cheese_cake = BLOCKS.register("magenta_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.MAGENTA_CANDLE));
	private static final RegistryObject<Block> pink_candle_cheese_cake = BLOCKS.register("pink_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.PINK_CANDLE));
	private static final RegistryObject<Block> brown_candle_cheese_cake = BLOCKS.register("brown_candle_cheese_cake", () -> new BlockCandleCheeseCake(Blocks.BROWN_CANDLE));
	private static final RegistryObject<Block> sponge_cake = BLOCKS.register("sponge_cake", () -> new BlockSpongeCake());
	private static final RegistryObject<Block> candle_sponge_cake = BLOCKS.register("candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.CANDLE));
	private static final RegistryObject<Block> white_candle_sponge_cake = BLOCKS.register("white_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.WHITE_CANDLE));
	private static final RegistryObject<Block> light_grey_candle_sponge_cake = BLOCKS.register("light_grey_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.LIGHT_GRAY_CANDLE));
	private static final RegistryObject<Block> grey_candle_sponge_cake = BLOCKS.register("grey_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.GRAY_CANDLE));
	private static final RegistryObject<Block> black_candle_sponge_cake = BLOCKS.register("black_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.BLACK_CANDLE));
	private static final RegistryObject<Block> red_candle_sponge_cake = BLOCKS.register("red_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.RED_CANDLE));
	private static final RegistryObject<Block> orange_candle_sponge_cake = BLOCKS.register("orange_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.ORANGE_CANDLE));
	private static final RegistryObject<Block> yellow_candle_sponge_cake = BLOCKS.register("yellow_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.YELLOW_CANDLE));
	private static final RegistryObject<Block> lime_candle_sponge_cake = BLOCKS.register("lime_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.LIME_CANDLE));
	private static final RegistryObject<Block> green_candle_sponge_cake = BLOCKS.register("green_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.GREEN_CANDLE));
	private static final RegistryObject<Block> light_blue_candle_sponge_cake = BLOCKS.register("light_blue_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.LIGHT_BLUE_CANDLE));
	private static final RegistryObject<Block> cyan_candle_sponge_cake = BLOCKS.register("cyan_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.CYAN_CANDLE));
	private static final RegistryObject<Block> blue_candle_sponge_cake = BLOCKS.register("blue_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.BLUE_CANDLE));
	private static final RegistryObject<Block> purple_candle_sponge_cake = BLOCKS.register("purple_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.PURPLE_CANDLE));
	private static final RegistryObject<Block> magenta_candle_sponge_cake = BLOCKS.register("magenta_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.MAGENTA_CANDLE));
	private static final RegistryObject<Block> pink_candle_sponge_cake = BLOCKS.register("pink_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.PINK_CANDLE));
	private static final RegistryObject<Block> brown_candle_sponge_cake = BLOCKS.register("brown_candle_sponge_cake", () -> new BlockCandleSpongeCake(Blocks.BROWN_CANDLE));
	private static final RegistryObject<Block> cardboard = BLOCKS.register("cardboard", () -> new BlockCardboard(MaterialColor.WOOD));
	private static final RegistryObject<Block> cardboard_white = BLOCKS.register("cardboard_white", () -> new BlockCardboard(MaterialColor.SNOW));
	private static final RegistryObject<Block> cardboard_light_grey = BLOCKS.register("cardboard_light_grey", () -> new BlockCardboard(MaterialColor.COLOR_LIGHT_GRAY));
	private static final RegistryObject<Block> cardboard_grey = BLOCKS.register("cardboard_grey", () -> new BlockCardboard(MaterialColor.COLOR_GRAY));
	private static final RegistryObject<Block> cardboard_black = BLOCKS.register("cardboard_black", () -> new BlockCardboard(MaterialColor.COLOR_BLACK));
	private static final RegistryObject<Block> cardboard_red = BLOCKS.register("cardboard_red", () -> new BlockCardboard(MaterialColor.COLOR_RED));
	private static final RegistryObject<Block> cardboard_orange = BLOCKS.register("cardboard_orange", () -> new BlockCardboard(MaterialColor.COLOR_ORANGE));
	private static final RegistryObject<Block> cardboard_yellow = BLOCKS.register("cardboard_yellow", () -> new BlockCardboard(MaterialColor.COLOR_YELLOW));
	private static final RegistryObject<Block> cardboard_lime = BLOCKS.register("cardboard_lime", () -> new BlockCardboard(MaterialColor.COLOR_LIGHT_GREEN));
	private static final RegistryObject<Block> cardboard_green = BLOCKS.register("cardboard_green", () -> new BlockCardboard(MaterialColor.COLOR_GREEN));
	private static final RegistryObject<Block> cardboard_light_blue = BLOCKS.register("cardboard_light_blue", () -> new BlockCardboard(MaterialColor.COLOR_LIGHT_BLUE));
	private static final RegistryObject<Block> cardboard_cyan = BLOCKS.register("cardboard_cyan", () -> new BlockCardboard(MaterialColor.COLOR_CYAN));
	private static final RegistryObject<Block> cardboard_blue = BLOCKS.register("cardboard_blue", () -> new BlockCardboard(MaterialColor.COLOR_BLUE));
	private static final RegistryObject<Block> cardboard_purple = BLOCKS.register("cardboard_purple", () -> new BlockCardboard(MaterialColor.COLOR_PURPLE));
	private static final RegistryObject<Block> cardboard_magenta = BLOCKS.register("cardboard_magenta", () -> new BlockCardboard(MaterialColor.COLOR_MAGENTA));
	private static final RegistryObject<Block> cardboard_pink = BLOCKS.register("cardboard_pink", () -> new BlockCardboard(MaterialColor.COLOR_PINK));
	private static final RegistryObject<Block> cardboard_brown = BLOCKS.register("cardboard_brown", () -> new BlockCardboard(MaterialColor.COLOR_BROWN));
	private static final RegistryObject<Block> cardboard_lantern = BLOCKS.register("cardboard_lantern", () -> new BlockCardboardLantern(MaterialColor.WOOD, false));
	private static final RegistryObject<Block> cardboard_lantern_white = BLOCKS.register("cardboard_lantern_white", () -> new BlockCardboardLantern(MaterialColor.SNOW, true));
	private static final RegistryObject<Block> cardboard_lantern_light_grey = BLOCKS.register("cardboard_lantern_light_grey", () -> new BlockCardboardLantern(MaterialColor.COLOR_LIGHT_GRAY, true));
	private static final RegistryObject<Block> cardboard_lantern_grey = BLOCKS.register("cardboard_lantern_grey", () -> new BlockCardboardLantern(MaterialColor.COLOR_GRAY, true));
	private static final RegistryObject<Block> cardboard_lantern_black = BLOCKS.register("cardboard_lantern_black", () -> new BlockCardboardLantern(MaterialColor.COLOR_BLACK, true));
	private static final RegistryObject<Block> cardboard_lantern_red = BLOCKS.register("cardboard_lantern_red", () -> new BlockCardboardLantern(MaterialColor.COLOR_RED, true));
	private static final RegistryObject<Block> cardboard_lantern_orange = BLOCKS.register("cardboard_lantern_orange", () -> new BlockCardboardLantern(MaterialColor.COLOR_ORANGE, true));
	private static final RegistryObject<Block> cardboard_lantern_yellow = BLOCKS.register("cardboard_lantern_yellow", () -> new BlockCardboardLantern(MaterialColor.COLOR_YELLOW, true));
	private static final RegistryObject<Block> cardboard_lantern_lime = BLOCKS.register("cardboard_lantern_lime", () -> new BlockCardboardLantern(MaterialColor.COLOR_LIGHT_GREEN, true));
	private static final RegistryObject<Block> cardboard_lantern_green = BLOCKS.register("cardboard_lantern_green", () -> new BlockCardboardLantern(MaterialColor.COLOR_GREEN, true));
	private static final RegistryObject<Block> cardboard_lantern_light_blue = BLOCKS.register("cardboard_lantern_light_blue", () -> new BlockCardboardLantern(MaterialColor.COLOR_LIGHT_BLUE, true));
	private static final RegistryObject<Block> cardboard_lantern_cyan = BLOCKS.register("cardboard_lantern_cyan", () -> new BlockCardboardLantern(MaterialColor.COLOR_CYAN, true));
	private static final RegistryObject<Block> cardboard_lantern_blue = BLOCKS.register("cardboard_lantern_blue", () -> new BlockCardboardLantern(MaterialColor.COLOR_BLUE, true));
	private static final RegistryObject<Block> cardboard_lantern_purple = BLOCKS.register("cardboard_lantern_purple", () -> new BlockCardboardLantern(MaterialColor.COLOR_PURPLE, true));
	private static final RegistryObject<Block> cardboard_lantern_magenta = BLOCKS.register("cardboard_lantern_magenta", () -> new BlockCardboardLantern(MaterialColor.COLOR_MAGENTA, true));
	private static final RegistryObject<Block> cardboard_lantern_pink = BLOCKS.register("cardboard_lantern_pink", () -> new BlockCardboardLantern(MaterialColor.COLOR_PINK, true));
	private static final RegistryObject<Block> cardboard_lantern_brown = BLOCKS.register("cardboard_lantern_brown", () -> new BlockCardboardLantern(MaterialColor.COLOR_BROWN, true));
	
	private static final RegistryObject<Item> raw_tin_block_item = BLOCK_ITEMS.register("raw_tin_block", () -> new BlockItem(raw_tin_block.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> tin_block_item = BLOCK_ITEMS.register("tin_block", () -> new BlockItem(tin_block.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> onion_item = BLOCK_ITEMS.register("onion", () -> new BlockItem(onion.get(), new Item.Properties()));
	private static final RegistryObject<Item> tin_ore_item = BLOCK_ITEMS.register("tin_ore", () -> new BlockItem(tin_ore.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> deepslate_tin_ore_item = BLOCK_ITEMS.register("deepslate_tin_ore", () -> new BlockItem(deepslate_tin_ore.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> bronze_block_item = BLOCK_ITEMS.register("bronze_block", () -> new BlockItem(bronze_block.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> raw_titanium_block_item = BLOCK_ITEMS.register("raw_titanium_block", () -> new BlockItem(raw_titanium_block.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> titanium_block_item = BLOCK_ITEMS.register("titanium_block", () -> new BlockItem(titanium_block.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> titanium_ore_item = BLOCK_ITEMS.register("titanium_ore", () -> new BlockItem(titanium_ore.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> deepslate_titanium_ore_item = BLOCK_ITEMS.register("deepslate_titanium_ore", () -> new BlockItem(deepslate_titanium_ore.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cheese_cake_item = BLOCK_ITEMS.register("cheese_cake", () -> new BlockItem(cheese_cake.get(), new Item.Properties().tab(SPTabs.tabFood).stacksTo(1)));
	private static final RegistryObject<Item> sponge_cake_item = BLOCK_ITEMS.register("sponge_cake", () -> new BlockItem(sponge_cake.get(), new Item.Properties().tab(SPTabs.tabFood).stacksTo(1)));
	private static final RegistryObject<Item> cardboard_item = BLOCK_ITEMS.register("cardboard", () -> new BlockItem(cardboard.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_white_item = BLOCK_ITEMS.register("cardboard_white", () -> new BlockItem(cardboard_white.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_light_grey_item = BLOCK_ITEMS.register("cardboard_light_grey", () -> new BlockItem(cardboard_light_grey.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_grey_item = BLOCK_ITEMS.register("cardboard_grey", () -> new BlockItem(cardboard_grey.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_black_item = BLOCK_ITEMS.register("cardboard_black", () -> new BlockItem(cardboard_black.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_red_item = BLOCK_ITEMS.register("cardboard_red", () -> new BlockItem(cardboard_red.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_orange_item = BLOCK_ITEMS.register("cardboard_orange", () -> new BlockItem(cardboard_orange.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_yellow_item = BLOCK_ITEMS.register("cardboard_yellow", () -> new BlockItem(cardboard_yellow.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lime_item = BLOCK_ITEMS.register("cardboard_lime", () -> new BlockItem(cardboard_lime.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_green_item = BLOCK_ITEMS.register("cardboard_green", () -> new BlockItem(cardboard_green.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_light_blue_item = BLOCK_ITEMS.register("cardboard_light_blue", () -> new BlockItem(cardboard_light_blue.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_cyan_item = BLOCK_ITEMS.register("cardboard_cyan", () -> new BlockItem(cardboard_cyan.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_blue_item = BLOCK_ITEMS.register("cardboard_blue", () -> new BlockItem(cardboard_blue.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_purple_item = BLOCK_ITEMS.register("cardboard_purple", () -> new BlockItem(cardboard_purple.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_magenta_item = BLOCK_ITEMS.register("cardboard_magenta", () -> new BlockItem(cardboard_magenta.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_pink_item = BLOCK_ITEMS.register("cardboard_pink", () -> new BlockItem(cardboard_pink.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_brown_item = BLOCK_ITEMS.register("cardboard_brown", () -> new BlockItem(cardboard_brown.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_item = BLOCK_ITEMS.register("cardboard_lantern", () -> new ItemCardboardLantern(cardboard_lantern.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_white_item = BLOCK_ITEMS.register("cardboard_lantern_white", () -> new ItemCardboardLantern(cardboard_lantern_white.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_light_grey_item = BLOCK_ITEMS.register("cardboard_lantern_light_grey", () -> new ItemCardboardLantern(cardboard_lantern_light_grey.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_grey_item = BLOCK_ITEMS.register("cardboard_lantern_grey", () -> new ItemCardboardLantern(cardboard_lantern_grey.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_black_item = BLOCK_ITEMS.register("cardboard_lantern_black", () -> new ItemCardboardLantern(cardboard_lantern_black.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_red_item = BLOCK_ITEMS.register("cardboard_lantern_red", () -> new ItemCardboardLantern(cardboard_lantern_red.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_orange_item = BLOCK_ITEMS.register("cardboard_lantern_orange", () -> new ItemCardboardLantern(cardboard_lantern_orange.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_yellow_item = BLOCK_ITEMS.register("cardboard_lantern_yellow", () -> new ItemCardboardLantern(cardboard_lantern_yellow.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_lime_item = BLOCK_ITEMS.register("cardboard_lantern_lime", () -> new ItemCardboardLantern(cardboard_lantern_lime.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_green_item = BLOCK_ITEMS.register("cardboard_lantern_green", () -> new ItemCardboardLantern(cardboard_lantern_green.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_light_blue_item = BLOCK_ITEMS.register("cardboard_lantern_light_blue", () -> new ItemCardboardLantern(cardboard_lantern_light_blue.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_cyan_item = BLOCK_ITEMS.register("cardboard_lantern_cyan", () -> new ItemCardboardLantern(cardboard_lantern_cyan.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_blue_item = BLOCK_ITEMS.register("cardboard_lantern_blue", () -> new ItemCardboardLantern(cardboard_lantern_blue.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_purple_item = BLOCK_ITEMS.register("cardboard_lantern_purple", () -> new ItemCardboardLantern(cardboard_lantern_purple.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_magenta_item = BLOCK_ITEMS.register("cardboard_lantern_magenta", () -> new ItemCardboardLantern(cardboard_lantern_magenta.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_pink_item = BLOCK_ITEMS.register("cardboard_lantern_pink", () -> new ItemCardboardLantern(cardboard_lantern_pink.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> cardboard_lantern_brown_item = BLOCK_ITEMS.register("cardboard_lantern_brown", () -> new ItemCardboardLantern(cardboard_lantern_brown.get(), new Item.Properties().tab(SPTabs.tabBlocks)));

}
