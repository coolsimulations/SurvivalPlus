package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class SPItemIngot extends Item {
	
public final boolean beacon;
	
	public SPItemIngot(boolean isBeaconIngot) {
		super(new FabricItemSettings().group(SPTabs.tabMaterials));
		this.beacon = isBeaconIngot;
	}

}
