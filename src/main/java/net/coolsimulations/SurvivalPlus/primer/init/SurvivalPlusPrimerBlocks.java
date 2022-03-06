package net.coolsimulations.SurvivalPlus.primer.init;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockMetal;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockOre;
import net.coolsimulations.SurvivalPlus.primer.blocks.SPBlockCrystal;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public class SurvivalPlusPrimerBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SPReference.MOD_ID);
	public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	
	public static final RegistryObject<Block> copper_block = BLOCKS.register("copper_block", () -> new SPBlockMetal(MaterialColor.COLOR_BROWN, SPBlockMetal.Resource.TIER_0));
	public static final RegistryObject<Block> copper_ore = BLOCKS.register("copper_ore", () -> new SPBlockOre(SPBlockOre.Resource.TIER_1, false));
	public static final RegistryObject<Block> amethyst = BLOCKS.register("amethyst", () -> new SPBlockCrystal(MaterialColor.COLOR_PURPLE));
	public static final RegistryObject<Block> ruby = BLOCKS.register("ruby", () -> new SPBlockCrystal(MaterialColor.COLOR_RED));
	public static final RegistryObject<Block> pearl = BLOCKS.register("pearl", () -> new SPBlockCrystal(MaterialColor.SNOW));
	public static final RegistryObject<Block> topaz = BLOCKS.register("topaz", () -> new SPBlockCrystal(MaterialColor.COLOR_YELLOW));
	public static final RegistryObject<Block> sapphire = BLOCKS.register("sapphire", () -> new SPBlockCrystal(MaterialColor.COLOR_BLUE));
	public static final RegistryObject<Block> spinel = BLOCKS.register("spinel", () -> new SPBlockCrystal(MaterialColor.COLOR_BLACK));
	
	private static final RegistryObject<Item> copper_block_item = BLOCK_ITEMS.register("copper_block", () -> new BlockItem(copper_block.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> copper_ore_item = BLOCK_ITEMS.register("copper_ore", () -> new BlockItem(copper_ore.get(), new Item.Properties().tab(SPTabs.tabBlocks)));
	private static final RegistryObject<Item> amethyst_item = BLOCK_ITEMS.register("amethyst", () -> new BlockItem(amethyst.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> ruby_item = BLOCK_ITEMS.register("ruby", () -> new BlockItem(ruby.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> topaz_item = BLOCK_ITEMS.register("topaz", () -> new BlockItem(topaz.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> sapphire_item = BLOCK_ITEMS.register("sapphire", () -> new BlockItem(sapphire.get(), new Item.Properties().tab(SPTabs.tabGem)));
	private static final RegistryObject<Item> spinel_item = BLOCK_ITEMS.register("spinel", () -> new BlockItem(spinel.get(), new Item.Properties().tab(SPTabs.tabGem)));

}
