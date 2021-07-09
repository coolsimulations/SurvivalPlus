package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class SPItemHoe extends HoeItem {

	public SPItemHoe(Tier tier, float attackDamageIn, float attackSpeedIn) {
		super(tier, (int) attackDamageIn, attackSpeedIn, (new FabricItemSettings().tab(SPTabs.tabTools)));
	}

}
