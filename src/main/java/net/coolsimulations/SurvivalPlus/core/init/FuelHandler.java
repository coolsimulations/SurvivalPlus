package net.coolsimulations.SurvivalPlus.core.init;

import java.util.HashMap;
import java.util.Map;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboard;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SPReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FuelHandler{
	
	private static Map<Item, Integer> armor_fuel = new HashMap<Item, Integer>();

	public static void registerArmorFuels() {

		addArmorFuels(SPItems.oak);
		addArmorFuels(SPItems.spruce);
		addArmorFuels(SPItems.birch);
		addArmorFuels(SPItems.jungle);
		addArmorFuels(SPItems.acacia);
		addArmorFuels(SPItems.dark_oak);

		if(SPCompatibilityManager.isBopLoaded()) {

			addArmorFuels(SPItems.cherry);
			addArmorFuels(SPItems.dead);
			addArmorFuels(SPItems.ethereal);
			addArmorFuels(SPItems.fir);
			addArmorFuels(SPItems.hellbark);
			addArmorFuels(SPItems.jacaranda);
			addArmorFuels(SPItems.magic);
			addArmorFuels(SPItems.mahogany);
			addArmorFuels(SPItems.palm);
			addArmorFuels(SPItems.redwood);
			addArmorFuels(SPItems.umbran);
			addArmorFuels(SPItems.willow);
		}

		if(SPCompatibilityManager.isBopExtrasLoaded()) {

			addArmorFuels(SPItems.ebony);
			addArmorFuels(SPItems.eucalyptus);
			addArmorFuels(SPItems.mangrove);
			addArmorFuels(SPItems.pine);
			addArmorFuels(SPItems.sacred_oak);
		}

		if(SPCompatibilityManager.isForestryLoaded()) {

			addArmorFuels(SPItems.desert_acacia);
			addArmorFuels(SPItems.balsa);
			addArmorFuels(SPItems.baobab);
			addArmorFuels(SPItems.cherry_forestry);
			addArmorFuels(SPItems.chestnut);
			addArmorFuels(SPItems.citrus);
			addArmorFuels(SPItems.cocobolo);
			addArmorFuels(SPItems.ebony_forestry);
			addArmorFuels(SPItems.giant_sequoia);
			addArmorFuels(SPItems.greenheart);
			addArmorFuels(SPItems.ipe);
			addArmorFuels(SPItems.kapok);
			addArmorFuels(SPItems.larch);
			addArmorFuels(SPItems.lime);
			addArmorFuels(SPItems.mahoe);
			addArmorFuels(SPItems.mahogany_forestry);
			addArmorFuels(SPItems.maple);
			addArmorFuels(SPItems.padauk);
			addArmorFuels(SPItems.palm_forestry);
			addArmorFuels(SPItems.papaya);
			addArmorFuels(SPItems.pine_forestry);
			addArmorFuels(SPItems.plum);
			addArmorFuels(SPItems.poplar);
			addArmorFuels(SPItems.sequoia);
			addArmorFuels(SPItems.teak);
			addArmorFuels(SPItems.walnut);
			addArmorFuels(SPItems.wenge);
			addArmorFuels(SPItems.willow_forestry);
			addArmorFuels(SPItems.zebrawood);
		}

		if (SPCompatibilityManager.isIc2Loaded()) {
			addArmorFuels(SPItems.rubber);
		}

		if(SPCompatibilityManager.isTraverseLoaded()) {

			addArmorFuels(SPItems.fir_traverse);
		}

		if(SPCompatibilityManager.isExtendedNetherBackportLoaded()) {
			addArmorFuels(SPItems.crimson);
			addArmorFuels(SPItems.warped);
		}
	}

	@SubscribeEvent
	public static void onFurnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event)
	{
		ItemStack fuel = event.getItemStack();

		for(Map.Entry<Item, Integer> entry : armor_fuel.entrySet()) {
			if(fuel.getItem() == entry.getKey()) {
				event.setBurnTime(entry.getValue());
				return;
			}
		}

		if (SPCompatibilityManager.isBambooModsLoaded()) {
			if(fuel.getItem() == SPItems.bamboo_helmet)
				event.setBurnTime(250);
			if(fuel.getItem() == SPItems.bamboo_chestplate)
				event.setBurnTime(400);
			if(fuel.getItem() == SPItems.bamboo_leggings)
				event.setBurnTime(350);
			if(fuel.getItem() == SPItems.bamboo_boots)
				event.setBurnTime(200);
		}

		if(fuel.getItem() == SPItems.paper_cup)
			event.setBurnTime(200);

		if(fuel.getItem() == SPItems.charcoal_bucket)
			event.setBurnTime(4800);

		Item item = fuel.getItem();

		if (item instanceof BlockItem && Block.getBlockFromItem(item) != Blocks.AIR)
		{
			Block block = Block.getBlockFromItem(item);

			if (block instanceof BlockCardboard)
			{
				event.setBurnTime(800);
				if(block instanceof BlockCardboardLantern) {
					event.setBurnTime(1600);
				}
			}
		}
	}

	private static void addArmorFuels(NonNullList<ItemStack> item) {

		for(int i = 0; i < item.size(); i++) {
			if(item.get(i).getItem() instanceof ArmorItem) {

				int value;

				EquipmentSlotType slotType = ((ArmorItem) item.get(i).getItem()).getEquipmentSlot();

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

				armor_fuel.put(item.get(i).getItem(), value);
			}
		}
	}

}
