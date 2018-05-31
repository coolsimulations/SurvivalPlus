package net.coolsimulations.SurvivalPlus.core.util;

import moze_intel.projecte.api.ProjectEAPI;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class SurvivalPlusEMCValues {
	
	
	public static void init(){
		
			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(SPItems.titanium_ingot), 2048);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("ingotTitanium", 2048);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("foodOnion", 64);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("seedOnion", 32);
    		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(SPItems.raw_onion), 64);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("gemAmethyst", 512);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("gemRuby", 512);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("gemTopaz", 512);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("gemSapphire", 512);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("gemPearl", 2048);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("gemSpinel", 2048);
    		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(Items.WATER_BUCKET), 769);
    		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(Items.LAVA_BUCKET), 833);
    		
    		ProjectEAPI.getEMCProxy().registerCustomEMC("crushedTitanium", 1024);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("crushedPurifiedTitanium", 1024);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("dustTitanium", 1024);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("dustTinyTitanium", (int) 113.7);
    		
    		ProjectEAPI.getEMCProxy().registerCustomEMC("crushedAluminum", 128);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("crushedPurifiedAluminum", 128);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("dustAluminum", 128);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("dustTinyAluminum", (int) 14.2);
    		
    		if(SPConfig.enableSponge) {
    			
    			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(Blocks.SPONGE), 2496);
    		}
    		
    		//EMC Values for OreDicts
    		ProjectEAPI.getEMCProxy().registerCustomEMC("grass", 1);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("dirt", 1);
    		ProjectEAPI.getEMCProxy().registerCustomEMC("sand", 1);
	}

}
