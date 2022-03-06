package net.coolsimulations.SurvivalPlus.core.compat;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class SurvivalPlusCompatManager {
	
	public static void initEventHandler() {
		
		if(SPCompatibilityManager.isLumberjackLoaded())
			SurvivalPlusLumberjack.registerEventHandler();
	}
	
	public static void init() {
		
		if(SPCompatibilityManager.isHammerTimeLoaded())
			SurvivalPlusHammerTime.init();
		if(SPCompatibilityManager.isLumberjackLoaded())
			SurvivalPlusLumberjack.ITEMS_LUMBERJACK.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isNoTreePunchingLoaded())
			SurvivalPlusNoTreePunching.ITEMS_NO_TREE_PUNCHING.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isSimpleGrinderLoaded() || SPCompatibilityManager.isIc2Loaded() || SPCompatibilityManager.isSilentMechanismsLoaded() || SPCompatibilityManager.isPlainGrinderLoaded())
			SurvivalPlusItems.ITEMS_TITANIUM_DUST.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isSimpleGrinderLoaded() && !SPCompatibilityManager.isIc2Loaded() || SPCompatibilityManager.isPlainGrinderLoaded())
			SurvivalPlusItems.ITEMS_TIN_DUST.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isSilentMechanismsLoaded())
			SurvivalPlusItems.ITEMS_TITANIUM_CHUNKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isIc2Loaded())
			SurvivalPlusItems.ITEMS_IC2.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

}
