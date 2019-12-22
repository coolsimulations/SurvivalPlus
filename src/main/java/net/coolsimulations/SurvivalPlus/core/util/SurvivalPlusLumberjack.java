package net.coolsimulations.SurvivalPlus.core.util;

import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.doubledoordev.lumberjack.items.ItemLumberAxe;
import net.minecraft.item.ItemStack;

public class SurvivalPlusLumberjack {
	
	public static void init() {
		
		if(SPCompatibilityManager.isLumberjackLoaded()) {
			SPItems.bronze_lumberaxe = new ItemLumberAxe(SPItems.bronzeToolMaterial);
			SPItems.titanium_lumberaxe = new ItemLumberAxe(SPItems.titaniumToolMaterial);

			if(SPCompatibilityManager.isGCLoaded()) {
				
				GCItems.TOOL_STEEL.setRepairItem(new ItemStack(GCItems.basicItem, 1, 9));
				SPItems.steel_lumberaxe = new ItemLumberAxe(GCItems.TOOL_STEEL);

				if(SPCompatibilityManager.isGCPLoaded()) {
					MarsItems.TOOLDESH.setRepairItem(new ItemStack(MarsItems.marsItemBasic, 1, 2));
					SPItems.desh_lumberaxe = new ItemLumberAxe(MarsItems.TOOLDESH);
				}
			}
		}
	}

}
