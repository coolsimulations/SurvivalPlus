package net.coolsimulations.SurvivalPlus.core.compat;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;

public class SurvivalPlusCompatManager {
	
	public static void initEventHandler() {
		
		if(SPCompatibilityManager.isLumberjackLoaded())
			SurvivalPlusLumberjack.registerEventHandler();
	}
	
	public static void init() {
		
		if(SPCompatibilityManager.isHammerTimeLoaded())
			SurvivalPlusHammerTime.init();
		if(SPCompatibilityManager.isLumberjackLoaded()) {
			SurvivalPlusLumberjack.init();
			SurvivalPlusLumberjack.register();
		}
		if(SPCompatibilityManager.isNoTreePunchingLoaded()){
			SurvivalPlusNoTreePunching.init();
			SurvivalPlusNoTreePunching.register();
		}
	}

}
