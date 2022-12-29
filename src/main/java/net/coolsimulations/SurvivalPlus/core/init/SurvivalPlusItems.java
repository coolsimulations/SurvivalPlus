package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.item.SPItemIngot;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public class SurvivalPlusItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS_IC2 = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS_TITANIUM_DUST = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS_TIN_DUST = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS_TITANIUM_CHUNKS = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	
	private static final RegistryObject<Item> tin_ingot = ITEMS.register("tin_ingot", () -> new SPItemIngot(true, 20.0F));
	private static final RegistryObject<Item> raw_tin = ITEMS.register("raw_tin", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials)));
	private static final RegistryObject<Item> onion_seeds = ITEMS.register("onion_seeds", () -> new ItemNameBlockItem(SPBlocks.onion.get(), new Item.Properties().tab(SPTabs.tabMaterials)));
	private static final RegistryObject<Item> bronze_ingot = ITEMS.register("bronze_ingot", () -> new SPItemIngot());
	private static final RegistryObject<Item> bronze_nugget = ITEMS.register("bronze_nugget", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials)));
	private static final RegistryObject<Item> titanium_ingot = ITEMS.register("titanium_ingot", () -> new SPItemIngot(true, 50.0F));
	private static final RegistryObject<Item> raw_titanium = ITEMS.register("raw_titanium", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials)));
	private static final RegistryObject<Item> titanium_nugget = ITEMS.register("titanium_nugget", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials)));
	private static final RegistryObject<Item> charcoal_bucket = ITEMS.register("charcoal_bucket", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials).stacksTo(1).craftRemainder(Items.BUCKET)));
	private static final RegistryObject<Item> paper_cup = ITEMS.register("paper_cup", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials)));
	
	private static final RegistryObject<Item> titanium_dust = ITEMS_TITANIUM_DUST.register("titanium_dust", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials)));
	
	private static final RegistryObject<Item> tin_dust = ITEMS_TIN_DUST.register("tin_dust", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials)));
	
	private static final RegistryObject<Item> titanium_chunks = ITEMS_TITANIUM_CHUNKS.register("titanium_chunks", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials)));
	
	private static final RegistryObject<Item> titanium_dense_plate = ITEMS_IC2.register("titanium_dense_plate", () -> new Item(new Item.Properties().tab(SPTabs.tabMaterials)));
}
