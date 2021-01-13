package net.coolsimulations.SurvivalPlus.core.util;

import me.crimsondawn45.fabricshieldlib.util.FabricShieldLibRegistry;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class SurvivalPlusShieldLib {
	
	public static void init() {
		for(Item item : Registry.ITEM) {
			if(item instanceof SPItemShield)
				FabricShieldLibRegistry.registerShield(item);
		}
	}

}
