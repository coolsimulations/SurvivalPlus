package net.coolsimulations.SurvivalPlus.core.compat;

import com.alcatrazescapee.notreepunching.common.items.KnifeItem;
import com.alcatrazescapee.notreepunching.common.items.MattockItem;
import com.alcatrazescapee.notreepunching.common.items.ModItems;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPItemTier;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;

public class SurvivalPlusNoTreePunching {
	
	public static void init() {
		
		SPItems.titanium_knife = new KnifeItem(SPItemTier.titaniumToolMaterial, 1, -2.2F, new FabricItemSettings().tab(ModItems.Tab.ITEMS));
		SPItems.titanium_mattock = new MattockItem(SPItemTier.titaniumToolMaterial, 0.5F, -2.2F, new FabricItemSettings().tab(ModItems.Tab.ITEMS));
		SPItems.titanium_saw = new AxeItem(SPItemTier.titaniumToolMaterial, 3.0F, -3.2F, new FabricItemSettings().tab(ModItems.Tab.ITEMS));
	}
	
	public static void register() {
		
		registerItem(SPItems.titanium_knife, "titanium_knife");
		registerItem(SPItems.titanium_saw, "titanium_saw");
		registerItem(SPItems.titanium_mattock, "titanium_mattock");
	}
	
	public static void registerItem(Item item, String registryName) {

		Registry.register(Registry.ITEM, new ResourceLocation(SPReference.MOD_ID, registryName), item);
	}
}
