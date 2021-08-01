package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboard;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SPReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FuelHandler{
	
	@SubscribeEvent
    public static void onFurnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event)
    {
        ItemStack fuel = event.getItemStack();

        addArmorFuels(event, SPItems.oak);
		addArmorFuels(event, SPItems.spruce);
		addArmorFuels(event, SPItems.birch);
		addArmorFuels(event, SPItems.jungle);
		addArmorFuels(event, SPItems.acacia);
		addArmorFuels(event, SPItems.dark_oak);
		addArmorFuels(event, SPItems.crimson);
		addArmorFuels(event, SPItems.warped);
		
		if(SPCompatibilityManager.isBopLoaded()) {
			
			addArmorFuels(event, SPItems.cherry);
			addArmorFuels(event, SPItems.dead);
			addArmorFuels(event, SPItems.ethereal);
			addArmorFuels(event, SPItems.fir);
			addArmorFuels(event, SPItems.hellbark);
			addArmorFuels(event, SPItems.jacaranda);
			addArmorFuels(event, SPItems.magic);
			addArmorFuels(event, SPItems.mahogany);
			addArmorFuels(event, SPItems.palm);
			addArmorFuels(event, SPItems.redwood);
			addArmorFuels(event, SPItems.umbran);
			addArmorFuels(event, SPItems.willow);
		}
		
		if(SPCompatibilityManager.isBopExtrasLoaded()) {
			
			addArmorFuels(event, SPItems.ebony);
			addArmorFuels(event, SPItems.eucalyptus);
			addArmorFuels(event, SPItems.mangrove);
			addArmorFuels(event, SPItems.pine);
			addArmorFuels(event, SPItems.sacred_oak);
		}
		
		if(SPCompatibilityManager.isForestryLoaded()) {
			
			addArmorFuels(event, SPItems.desert_acacia);
			addArmorFuels(event, SPItems.balsa);
			addArmorFuels(event, SPItems.baobab);
			addArmorFuels(event, SPItems.cherry_forestry);
			addArmorFuels(event, SPItems.chestnut);
			addArmorFuels(event, SPItems.citrus);
			addArmorFuels(event, SPItems.cocobolo);
			addArmorFuels(event, SPItems.ebony_forestry);
			addArmorFuels(event, SPItems.giant_sequoia);
			addArmorFuels(event, SPItems.greenheart);
			addArmorFuels(event, SPItems.ipe);
			addArmorFuels(event, SPItems.kapok);
			addArmorFuels(event, SPItems.larch);
			addArmorFuels(event, SPItems.lime);
			addArmorFuels(event, SPItems.mahoe);
			addArmorFuels(event, SPItems.mahogany_forestry);
			addArmorFuels(event, SPItems.maple);
			addArmorFuels(event, SPItems.padauk);
			addArmorFuels(event, SPItems.palm_forestry);
			addArmorFuels(event, SPItems.papaya);
			addArmorFuels(event, SPItems.pine_forestry);
			addArmorFuels(event, SPItems.plum);
			addArmorFuels(event, SPItems.poplar);
			addArmorFuels(event, SPItems.sequoia);
			addArmorFuels(event, SPItems.teak);
			addArmorFuels(event, SPItems.walnut);
			addArmorFuels(event, SPItems.wenge);
			addArmorFuels(event, SPItems.willow_forestry);
			addArmorFuels(event, SPItems.zebrawood);
		}
		
		if (SPCompatibilityManager.isIc2Loaded()) {
			addArmorFuels(event, SPItems.rubber);
		}

		if(SPCompatibilityManager.isTraverseLoaded()) {

			addArmorFuels(event, SPItems.fir_traverse);
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
		
		if (item instanceof BlockItem && Block.byItem(item) != Blocks.AIR)
		{
			Block block = Block.byItem(item);

			if (block instanceof BlockCardboard)
			{
				event.setBurnTime(800);
				if(block instanceof BlockCardboardLantern) {
					event.setBurnTime(1600);
				}
			}
		}
	}
	
	private static void addArmorFuels(FurnaceFuelBurnTimeEvent event, NonNullList<ItemStack> item) {

		for(int i = 0; i < item.size(); i++) {
			if(item.get(i).getItem() instanceof ArmorItem) {

				int value;

				EquipmentSlot slotType = ((ArmorItem) item.get(i).getItem()).getSlot();

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

				event.setBurnTime(value);
			}
		}
	}

}
