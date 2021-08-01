package net.coolsimulations.SurvivalPlus.primer.init;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPItemIngot;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusPrimerItems {

	public static Item copper_ingot;

	public static void init() {

		copper_ingot = new SPItemIngot().setRegistryName(SPReference.MOD_ID, "copper_ingot");

	}

	public static void register() {

		registerItem(copper_ingot);

	}

	public static void registerItem(Item item) {

		ForgeRegistries.ITEMS.register(item);
	}

}
