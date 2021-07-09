package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.ShieldItem;

public class SPItemShield extends ShieldItem {

	public SPItemShield(int maxDamage) {
		super((new FabricItemSettings()).maxCount(1).maxDamage(maxDamage).tab(SPTabs.tabCombat));
	}
}
