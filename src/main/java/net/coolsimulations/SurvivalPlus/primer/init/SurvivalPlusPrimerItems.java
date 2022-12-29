package net.coolsimulations.SurvivalPlus.primer.init;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPItemIngot;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class SurvivalPlusPrimerItems {

	public static Item copper_ingot;

	public static void init() {

		copper_ingot = new SPItemIngot();

	}

	public static void register() {

		registerItem(copper_ingot, "copper_ingot");

	}

	public static void registerItem(Item item, String registryName) {

		Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(SPReference.MOD_ID, registryName), item);
	}

}
