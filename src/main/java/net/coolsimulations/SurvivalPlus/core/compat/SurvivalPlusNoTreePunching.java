package net.coolsimulations.SurvivalPlus.core.compat;

import com.alcatrazescapee.notreepunching.common.items.KnifeItem;
import com.alcatrazescapee.notreepunching.common.items.MattockItem;
import com.alcatrazescapee.notreepunching.common.items.ModItems;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPItemTier;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public class SurvivalPlusNoTreePunching {
	
	public static final DeferredRegister<Item> ITEMS_NO_TREE_PUNCHING = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	
	private static final RegistryObject<Item> titanium_knife = ITEMS_NO_TREE_PUNCHING.register("titanium_knife", () -> new KnifeItem(SPItemTier.titaniumToolMaterial, 1, -2.2F, new Properties().tab(ModItems.Tab.ITEMS)));
	private static final RegistryObject<Item> titanium_mattock = ITEMS_NO_TREE_PUNCHING.register("titanium_mattock", () -> new MattockItem(SPItemTier.titaniumToolMaterial, 0.5F, -2.2F, new Properties().tab(ModItems.Tab.ITEMS)));
	private static final RegistryObject<Item> titanium_saw = ITEMS_NO_TREE_PUNCHING.register("titanium_saw", () -> new AxeItem(SPItemTier.titaniumToolMaterial, 3.0F, -3.2F, new Properties().tab(ModItems.Tab.ITEMS)));
}
