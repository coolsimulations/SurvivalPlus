package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboard;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class FuelHandler{

	public static void init()
	{
		addArmorFuels(SPItems.oak);
		addArmorFuels(SPItems.spruce);
		addArmorFuels(SPItems.birch);
		addArmorFuels(SPItems.jungle);
		addArmorFuels(SPItems.acacia);
		addArmorFuels(SPItems.dark_oak);
		addArmorFuels(SPItems.crimson);
		addArmorFuels(SPItems.warped);
		addArmorFuels(SPItems.mangrove);
		
		if (SPCompatibilityManager.isBambooModsLoaded()) {
			FuelRegistry.INSTANCE.add(SPItems.bamboo_helmet, 250);
			FuelRegistry.INSTANCE.add(SPItems.bamboo_chestplate, 400);
			FuelRegistry.INSTANCE.add(SPItems.bamboo_leggings, 350);
			FuelRegistry.INSTANCE.add(SPItems.bamboo_boots, 200);
		}
		
		if(SPCompatibilityManager.isEnrichedLoaded()) {
			addArmorFuels(SPItems.redwood_vanilla_enhanced);
		}

		if(SPCompatibilityManager.isTerrestriaLoaded()) {
			addArmorFuels(SPItems.redwood_terrestria);
			addArmorFuels(SPItems.hemlock);
			addArmorFuels(SPItems.rubber_terrestria);
			addArmorFuels(SPItems.cypress);
			addArmorFuels(SPItems.willow_terrestria);
			addArmorFuels(SPItems.japanese_maple);
			addArmorFuels(SPItems.rainbow_eucalyptus);
			addArmorFuels(SPItems.sakura);
		}

		if(SPCompatibilityManager.isTraverseLoaded()) {
			addArmorFuels(SPItems.fir_traverse);
		}
		
		if(SPCompatibilityManager.isBlockusLoaded()) {
			addArmorFuels(SPItems.white_oak);
		}
		
		if(SPCompatibilityManager.isAetherRebornLoaded()) {
			addArmorFuels(SPItems.skyroot);
			addArmorFuels(SPItems.golden_oak);
			addArmorFuels(SPItems.orange);
			addArmorFuels(SPItems.crystal);
			addArmorFuels(SPItems.wisteria);
		}
		
		FuelRegistry.INSTANCE.add(SPItems.paper_cup, 200);

		FuelRegistry.INSTANCE.add(SPItems.charcoal_bucket, 4800);

		for(int i = 0; i < BuiltInRegistries.BLOCK.keySet().size(); i++) {
			Block block = BuiltInRegistries.BLOCK.byId(i);
			if(block instanceof BlockCardboard) {
				FuelRegistry.INSTANCE.add(block, 800);
				if(block instanceof BlockCardboardLantern) {
					FuelRegistry.INSTANCE.add(block, 1600);
				}
			}
		}
	}

	private static void addArmorFuels(NonNullList<ItemStack> item) {

		for(int i = 0; i < item.size(); i++) {
			if(item.get(i).getItem() instanceof ArmorItem) {

				int value;

				Type slotType = ((ArmorItem) item.get(i).getItem()).getType();

				switch (slotType) {
				case HELMET:
					value = 1500;
					break;
				case CHESTPLATE:
					value = 2400;
					break;
				case LEGGINGS:
					value = 2100;
					break;
				case BOOTS:
					value = 1200;
					break;
				default:
					value = 0;
				}

				FuelRegistry.INSTANCE.add(item.get(i).getItem(), value);
			}
		}
	}

}
