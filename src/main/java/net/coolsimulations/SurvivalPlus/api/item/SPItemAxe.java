package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.AxeItem;
import net.minecraftforge.common.ToolType;

public class SPItemAxe extends AxeItem {
    
    public SPItemAxe(IItemTier tier, float damage, float speed) {
	      //super(tier, 6.0F, -3.2F, (new Item.Properties().addToolType(ToolType.AXE, tier.getHarvestLevel()).group(SPTabs.tabTools)));
    		  super(tier, damage, speed, (new Item.Properties().addToolType(ToolType.AXE, tier.getHarvestLevel()).group(SPTabs.tabTools)));
	   }
 
}