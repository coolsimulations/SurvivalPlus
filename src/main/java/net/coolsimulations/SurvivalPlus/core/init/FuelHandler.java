package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SPReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FuelHandler{
	
	@SubscribeEvent
    public static void onFurnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event)
    {
        ItemStack fuel = event.getItemStack();

		if(fuel.getItem() == SPItems.oak_helmet)
			event.setBurnTime(1500);
		if(fuel.getItem() == SPItems.oak_chestplate)
			event.setBurnTime(2400);
		if(fuel.getItem() == SPItems.oak_leggings)
			event.setBurnTime(2100);
		if(fuel.getItem() == SPItems.oak_boots)
			event.setBurnTime(1200);
		
		if(fuel.getItem() == SPItems.spruce_helmet)
			event.setBurnTime(1500);
		if(fuel.getItem() == SPItems.spruce_chestplate)
			event.setBurnTime(2400);
		if(fuel.getItem() == SPItems.spruce_leggings)
			event.setBurnTime(2100);
		if(fuel.getItem() == SPItems.spruce_boots)
			event.setBurnTime(1200);
		
		if(fuel.getItem() == SPItems.birch_helmet)
			event.setBurnTime(1500);
		if(fuel.getItem() == SPItems.birch_chestplate)
			event.setBurnTime(2400);
		if(fuel.getItem() == SPItems.birch_leggings)
			event.setBurnTime(2100);
		if(fuel.getItem() == SPItems.birch_boots)
			event.setBurnTime(1200);

		if(fuel.getItem() == SPItems.jungle_helmet)
			event.setBurnTime(1500);
		if(fuel.getItem() == SPItems.jungle_chestplate)
			event.setBurnTime(2400);
		if(fuel.getItem() == SPItems.jungle_leggings)
			event.setBurnTime(2100);
		if(fuel.getItem() == SPItems.jungle_boots)
			event.setBurnTime(1200);
		
		if(fuel.getItem() == SPItems.acacia_helmet)
			event.setBurnTime(1500);
		if(fuel.getItem() == SPItems.acacia_chestplate)
			event.setBurnTime(2400);
		if(fuel.getItem() == SPItems.acacia_leggings)
			event.setBurnTime(2100);
		if(fuel.getItem() == SPItems.acacia_boots)
			event.setBurnTime(1200);

		if(fuel.getItem() == SPItems.dark_oak_helmet)
			event.setBurnTime(1500);
		if(fuel.getItem() == SPItems.dark_oak_chestplate)
			event.setBurnTime(2400);
		if(fuel.getItem() == SPItems.dark_oak_leggings)
			event.setBurnTime(2100);
		if(fuel.getItem() == SPItems.dark_oak_boots)
			event.setBurnTime(1200);
		
		if(SPCompatibilityManager.isBopLoaded()) {
			
			if(fuel.getItem() == SPItems.cherry_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.cherry_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.cherry_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.cherry_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.dead_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.dead_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.dead_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.dead_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.ethereal_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.ethereal_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.ethereal_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.fir_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.fir_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.fir_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.fir_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.hellbark_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.hellbark_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.hellbark_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.hellbark_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.jacaranda_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.jacaranda_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.jacaranda_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.jacaranda_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.magic_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.magic_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.magic_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.magic_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.mahogany_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.mahogany_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.mahogany_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.mahogany_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.palm_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.palm_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.palm_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.palm_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.redwood_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.redwood_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.redwood_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.redwood_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.umbran_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.umbran_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.umbran_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.umbran_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.willow_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.willow_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.willow_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.willow_boots)
				event.setBurnTime(1200);
		}
		
		if(SPCompatibilityManager.isBopExtrasLoaded()) {
			
			if(fuel.getItem() == SPItems.ebony_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.ebony_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.ebony_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.ebony_boots)
				event.setBurnTime(1200);
			if(fuel.getItem() == SPItems.ebony_helmet)
				event.setBurnTime(1500);
			
			if(fuel.getItem() == SPItems.eucalyptus_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.eucalyptus_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.eucalyptus_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.eucalyptus_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.mangrove_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.mangrove_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.mangrove_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.mangrove_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.pine_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.pine_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.pine_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.pine_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.sacred_oak_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.sacred_oak_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.sacred_oak_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.sacred_oak_boots)
				event.setBurnTime(1200);
		}
		
		if(SPCompatibilityManager.isForestryLoaded()) {
			
			if(fuel.getItem() == SPItems.desert_acacia_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.desert_acacia_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.desert_acacia_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.desert_acacia_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.balsa_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.balsa_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.balsa_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.balsa_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.baobab_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.baobab_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.baobab_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.baobab_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.cherry_helmet_forestry)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.cherry_chestplate_forestry)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.cherry_leggings_forestry)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.cherry_boots_forestry)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.chestnut_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.chestnut_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.chestnut_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.chestnut_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.citrus_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.citrus_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.citrus_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.citrus_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.cocobolo_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.cocobolo_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.cocobolo_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.cocobolo_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.ebony_helmet_forestry)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.ebony_chestplate_forestry)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.ebony_leggings_forestry)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.ebony_boots_forestry)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.giant_sequoia_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.giant_sequoia_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.giant_sequoia_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.giant_sequoia_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.greenheart_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.greenheart_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.greenheart_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.greenheart_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.ipe_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.ipe_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.ipe_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.ipe_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.kapok_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.kapok_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.kapok_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.kapok_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.larch_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.larch_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.larch_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.larch_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.lime_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.lime_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.lime_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.lime_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.mahoe_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.mahoe_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.mahoe_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.mahoe_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.mahogany_helmet_forestry)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.mahogany_chestplate_forestry)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.mahogany_leggings_forestry)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.mahogany_boots_forestry)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.maple_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.maple_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.maple_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.maple_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.padauk_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.padauk_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.padauk_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.padauk_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.palm_helmet_forestry)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.palm_chestplate_forestry)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.palm_leggings_forestry)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.palm_boots_forestry)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.papaya_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.papaya_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.papaya_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.papaya_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.pine_helmet_forestry)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.pine_chestplate_forestry)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.pine_leggings_forestry)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.pine_boots_forestry)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.plum_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.plum_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.plum_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.plum_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.poplar_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.poplar_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.poplar_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.poplar_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.sequoia_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.sequoia_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.sequoia_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.sequoia_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.teak_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.teak_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.teak_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.teak_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.walnut_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.walnut_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.walnut_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.walnut_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.wenge_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.wenge_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.wenge_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.wenge_boots)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.willow_helmet_forestry)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.willow_chestplate_forestry)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.willow_leggings_forestry)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.willow_boots_forestry)
				event.setBurnTime(1200);
			
			if(fuel.getItem() == SPItems.zebrawood_helmet)
				event.setBurnTime(1500);
			if(fuel.getItem() == SPItems.zebrawood_chestplate)
				event.setBurnTime(2400);
			if(fuel.getItem() == SPItems.zebrawood_leggings)
				event.setBurnTime(2100);
			if(fuel.getItem() == SPItems.zebrawood_boots)
				event.setBurnTime(1200);
			
		}
		
		if(fuel.getItem() == SPItems.paper_cup)

		if(fuel.getItem() == SPItems.charcoal_bucket)
			event.setBurnTime(4800);
		
		Item item = fuel.getItem();
		
		if (item instanceof BlockItem && Block.getBlockFromItem(item) != Blocks.AIR)
        {
            Block block = Block.getBlockFromItem(item);

            if (block == SPBlocks.cardboard)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_white)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_light_grey)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_grey)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_black)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_red)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_orange)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_yellow)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_lime)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_green)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_light_blue)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_cyan)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_blue)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_purple)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_magenta)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_pink)
            {
                event.setBurnTime(800);
            }
            if (block == SPBlocks.cardboard_brown)
            {
                event.setBurnTime(800);
            }
        }
	}

}
