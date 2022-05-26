package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPItemAxe;
import net.coolsimulations.SurvivalPlus.api.item.SPItemHoe;
import net.coolsimulations.SurvivalPlus.api.item.SPItemPickaxe;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShears;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShovel;
import net.coolsimulations.SurvivalPlus.api.item.SPItemSword;
import net.coolsimulations.SurvivalPlus.api.item.SPItemTier;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public class SurvivalPlusTools {
	
	public static final DeferredRegister<Item> ITEMS_TOOL = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	
	private static final RegistryObject<Item> bronze_pickaxe = ITEMS_TOOL.register("bronze_pickaxe", () -> new SPItemPickaxe(SPItemTier.bronzeToolMaterial));
	private static final RegistryObject<Item> bronze_axe = ITEMS_TOOL.register("bronze_axe", () -> new SPItemAxe(SPItemTier.bronzeToolMaterial, 5.5F, -3.1F));
	private static final RegistryObject<Item> bronze_shovel = ITEMS_TOOL.register("bronze_shovel", () -> new SPItemShovel(SPItemTier.bronzeToolMaterial));
	private static final RegistryObject<Item> bronze_hoe = ITEMS_TOOL.register("bronze_hoe", () -> new SPItemHoe(SPItemTier.bronzeToolMaterial, -1.5F, -1.5F));
	private static final RegistryObject<Item> bronze_sword = ITEMS_TOOL.register("bronze_sword", () -> new SPItemSword(SPItemTier.bronzeToolMaterial));
	private static final RegistryObject<Item> bronze_shears = ITEMS_TOOL.register("bronze_shears", () -> new SPItemShears(179));
	private static final RegistryObject<Item> bronze_shield = ITEMS_TOOL.register("bronze_shield", () -> new SPItemShield(274));
	
	private static final RegistryObject<Item> titanium_pickaxe = ITEMS_TOOL.register("titanium_pickaxe", () -> new SPItemPickaxe(SPItemTier.titaniumToolMaterial));
	private static final RegistryObject<Item> titanium_axe = ITEMS_TOOL.register("titanium_axe", () -> new SPItemAxe(SPItemTier.titaniumToolMaterial, 5.5F, -3.0F));
	private static final RegistryObject<Item> titanium_shovel = ITEMS_TOOL.register("titanium_shovel", () -> new SPItemShovel(SPItemTier.titaniumToolMaterial));
	private static final RegistryObject<Item> titanium_hoe = ITEMS_TOOL.register("titanium_hoe", () -> new SPItemHoe(SPItemTier.titaniumToolMaterial, -2.5F, -0.5F));
	private static final RegistryObject<Item> titanium_sword = ITEMS_TOOL.register("titanium_sword", () -> new SPItemSword(SPItemTier.titaniumToolMaterial));
	private static final RegistryObject<Item> titanium_shears = ITEMS_TOOL.register("titanium_shears", () -> new SPItemShears(298));
	private static final RegistryObject<Item> titanium_shield = ITEMS_TOOL.register("titanium_shield", () -> new SPItemShield(519));
}
