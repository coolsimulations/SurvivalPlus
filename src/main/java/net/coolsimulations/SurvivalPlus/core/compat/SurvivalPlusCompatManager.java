package net.coolsimulations.SurvivalPlus.core.compat;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;

public class SurvivalPlusCompatManager {
	
	public static void initEventHandler() {
		
		if(SPCompatibilityManager.isFutureMCLoaded())
			SurvivalPlusFutureMC.registerEventHandler();
		if(SPCompatibilityManager.isIc2Loaded())
			SurvivalPlusIC2.registerEventHandler();
		if(SPCompatibilityManager.isTechRebornLoaded())
			SurvivalPlusTechReborn.registerEventHandler();
		if(SPCompatibilityManager.isGCLoaded())
			SurvivalPlusGC.registerEventHandler();
		if(SPCompatibilityManager.isRailcraftLoaded())
			SurvivalPlusRailCraft.registerEventHandler();
		if(SPCompatibilityManager.isBopLoaded())
			SurvivalPlusBOP.registerEventHandler();
		if(SPCompatibilityManager.isLumberjackLoaded())
			SurvivalPlusLumberjack.registerEventHandler();
		if(SPCompatibilityManager.isHammerTimeLoaded())
			SurvivalPlusHammerTime.registerEventHandler();
		if(SPCompatibilityManager.isAetherLegacyLoaded())
			SurvivalPlusAetherLegacyRecipes.registerEventHandler();
		if(SPCompatibilityManager.isBamboozledLoaded())
			SurvivalPlusBamboozled.registerEventHandler();
	}
	
	public static void initRecipies() {
		
		SurvivalPlusFutureMC.init();
		
		if(SPCompatibilityManager.isGobberLoaded())
			SurvivalPlusGobber.init();
		
		if(SPCompatibilityManager.isIc2Loaded())
			SurvivalPlusIC2.init();
		if(SPCompatibilityManager.isTechRebornLoaded())
			SurvivalPlusTechReborn.init();
		if(SPCompatibilityManager.isBopLoaded())
			SurvivalPlusBOP.init();
		if(SPCompatibilityManager.isSimpleGrinderLoaded())
			SurvivalPlusSimpleGrinder.init();
		if(SPCompatibilityManager.isGCLoaded())
			SurvivalPlusGC.init();
		if(SPCompatibilityManager.isRailcraftLoaded())
			SurvivalPlusRailCraft.init();
		if(SPCompatibilityManager.isWeepingAngelsLoaded())
			SurvivalPlusWeepingAngles.init();
		if(SPCompatibilityManager.isBamboozledLoaded())
			SurvivalPlusBamboozled.init();
		if(SPCompatibilityManager.isTriGemsLoaded())
			SurvivalPlusTriGems.init();
		if(SPCompatibilityManager.isGACLoaded())
			SurvivalPlusGAC.init();
		
	}

}
