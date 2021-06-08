package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboard;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.registry.Registry;

public class FuelHandler{

	public static void init()
	{
		addArmorFuels(SPItems.oak);
		addArmorFuels(SPItems.spruce);
		addArmorFuels(SPItems.birch);
		addArmorFuels(SPItems.jungle);
		addArmorFuels(SPItems.acacia);
		addArmorFuels(SPItems.dark_oak);
		
		if (SPCompatibilityManager.isBambooModsLoaded()) {
			FuelRegistry.INSTANCE.add(SPItems.bamboo_helmet, 250);
			FuelRegistry.INSTANCE.add(SPItems.bamboo_chestplate, 400);
			FuelRegistry.INSTANCE.add(SPItems.bamboo_leggings, 350);
			FuelRegistry.INSTANCE.add(SPItems.bamboo_boots, 200);
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
		
		FuelRegistry.INSTANCE.add(SPItems.paper_cup, 200);

		FuelRegistry.INSTANCE.add(SPItems.charcoal_bucket, 4800);

		for(int i = 0; i < Registry.BLOCK.getIds().size(); i++) {
			Block block = Registry.BLOCK.get(i);
			
			if(block instanceof BlockCardboard) {
				FuelRegistry.INSTANCE.add(block, 800);
				if(block instanceof BlockCardboardLantern) {
					FuelRegistry.INSTANCE.add(block, 1600);
				}
			}
		}
	}

	private static void addArmorFuels(DefaultedList<ItemStack> item) {

		for(int i = 0; i < item.size(); i++) {
			if(item.get(i).getItem() instanceof ArmorItem) {

				int value;

				EquipmentSlot slotType = ((ArmorItem) item.get(i).getItem()).getSlotType();

				switch (slotType) {
				case HEAD:
					value = 1500;
					break;
				case CHEST:
					value = 2400;
					break;
				case LEGS:
					value = 2100;
					break;
				case FEET:
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
