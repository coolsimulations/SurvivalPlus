package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler{
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		
		if(fuel.getItem() == SPItems.oak_helmet)
			return 1500;
		if(fuel.getItem() == SPItems.oak_chestplate)
			return 2400;
		if(fuel.getItem() == SPItems.oak_leggings)
			return 2100;
		if(fuel.getItem() == SPItems.oak_boots)
			return 1200;
		
		if(fuel.getItem() == SPItems.spruce_helmet)
			return 1500;
		if(fuel.getItem() == SPItems.spruce_chestplate)
			return 2400;
		if(fuel.getItem() == SPItems.spruce_leggings)
			return 2100;
		if(fuel.getItem() == SPItems.spruce_boots)
			return 1200;
		
		if(fuel.getItem() == SPItems.birch_helmet)
			return 1500;
		if(fuel.getItem() == SPItems.birch_chestplate)
			return 2400;
		if(fuel.getItem() == SPItems.birch_leggings)
			return 2100;
		if(fuel.getItem() == SPItems.birch_boots)
			return 1200;

		if(fuel.getItem() == SPItems.jungle_helmet)
			return 1500;
		if(fuel.getItem() == SPItems.jungle_chestplate)
			return 2400;
		if(fuel.getItem() == SPItems.jungle_leggings)
			return 2100;
		if(fuel.getItem() == SPItems.jungle_boots)
			return 1200;
		
		if(fuel.getItem() == SPItems.acacia_helmet)
			return 1500;
		if(fuel.getItem() == SPItems.acacia_chestplate)
			return 2400;
		if(fuel.getItem() == SPItems.acacia_leggings)
			return 2100;
		if(fuel.getItem() == SPItems.acacia_boots)
			return 1200;

		if(fuel.getItem() == SPItems.dark_oak_helmet)
			return 1500;
		if(fuel.getItem() == SPItems.dark_oak_chestplate)
			return 2400;
		if(fuel.getItem() == SPItems.dark_oak_leggings)
			return 2100;
		if(fuel.getItem() == SPItems.dark_oak_boots)
			return 1200;
		
		if(SPCompatibilityManager.isBopLoaded()) {
			
			if(fuel.getItem() == SPItems.cherry_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.cherry_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.cherry_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.cherry_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.dead_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.dead_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.dead_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.dead_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.ebony_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.ebony_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.ebony_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.ebony_boots)
				return 1200;
			if(fuel.getItem() == SPItems.ebony_helmet)
				return 1500;
			
			if(fuel.getItem() == SPItems.ethereal_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.ethereal_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.ethereal_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.eucalyptus_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.eucalyptus_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.eucalyptus_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.eucalyptus_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.fir_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.fir_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.fir_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.fir_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.hellbark_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.hellbark_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.hellbark_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.hellbark_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.jacaranda_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.jacaranda_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.jacaranda_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.jacaranda_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.magic_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.magic_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.magic_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.magic_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.mahogany_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.mahogany_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.mahogany_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.mahogany_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.mangrove_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.mangrove_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.mangrove_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.mangrove_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.palm_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.palm_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.palm_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.palm_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.pine_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.pine_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.pine_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.pine_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.redwood_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.redwood_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.redwood_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.redwood_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.sacred_oak_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.sacred_oak_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.sacred_oak_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.sacred_oak_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.umbran_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.umbran_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.umbran_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.umbran_boots)
				return 1200;
			
			if(fuel.getItem() == SPItems.willow_helmet)
				return 1500;
			if(fuel.getItem() == SPItems.willow_chestplate)
				return 2400;
			if(fuel.getItem() == SPItems.willow_leggings)
				return 2100;
			if(fuel.getItem() == SPItems.willow_boots)
				return 1200;
		}
		
		if(fuel.getItem() == SPItems.paper_cup)

		if(fuel.getItem() == SPItems.charcoal_bucket)
			return 4800;
		
		Item item = fuel.getItem();
		
		if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
        {
            Block block = Block.getBlockFromItem(item);

            if (block == SPBlocks.cardboard)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_white)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_light_grey)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_grey)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_black)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_red)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_orange)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_yellow)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_lime)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_green)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_light_blue)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_cyan)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_blue)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_purple)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_magenta)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_pink)
            {
                return 800;
            }
            if (block == SPBlocks.cardboard_brown)
            {
                return 800;
            }
        }

		
		return 0;
	}

}
