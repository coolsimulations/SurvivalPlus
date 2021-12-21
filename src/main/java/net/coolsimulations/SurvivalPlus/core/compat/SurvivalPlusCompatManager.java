package net.coolsimulations.SurvivalPlus.core.compat;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;

public class SurvivalPlusCompatManager {
	
	public static void init() {
		
		if(SPCompatibilityManager.isBlockusLoaded()) {
			SurvivalPlusBlockus.init();
			SurvivalPlusBlockus.register();
		}
	}

}
