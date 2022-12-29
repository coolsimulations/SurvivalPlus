package net.coolsimulations.SurvivalPlus.api.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.ShearsItem;

public class SPItemShears extends ShearsItem{
	
	public SPItemShears(int maxDamage) {
	    super((new FabricItemSettings()).maxCount(1).maxDamage(maxDamage));
    }

}
