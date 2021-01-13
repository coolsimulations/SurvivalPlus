package net.coolsimulations.SurvivalPlus.core.util;

import com.brand.blockus.blocks.FoodBlocks.Crate;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;

public class SurvivalPlusBlockus {
	
	public static void init() {
		
		SPBlocks.onion_crate = new Crate("onion_crate", 2.5f, 2.5f);
	}

}
