package net.coolsimulations.SurvivalPlus.core.compat;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;

public class SurvivalPlusCompatManager {
	
	public static void init() {
		
		if(SPCompatibilityManager.isBlockusLoaded()) {
			SurvivalPlusBlockus.init();
			SurvivalPlusBlockus.register();
		}
		if(SPCompatibilityManager.isJerLoaded())
			SurvivalPlusJER.setup();
		if (SPCompatibilityManager.isTorcherinoLoaded())
			SurvivalPlusTorcherino.init();
		if (SPCompatibilityManager.isNoTreePunchingLoaded()) {
			SurvivalPlusNoTreePunching.init();
			SurvivalPlusNoTreePunching.register();
		}
	}

}
