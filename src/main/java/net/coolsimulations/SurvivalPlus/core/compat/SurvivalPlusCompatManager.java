package net.coolsimulations.SurvivalPlus.core.compat;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.core.init.AetherArmor;
import net.coolsimulations.SurvivalPlus.core.init.BOPArmor;
import net.coolsimulations.SurvivalPlus.core.init.ForestryArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.coolsimulations.SurvivalPlus.core.init.TraverseArmor;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class SurvivalPlusCompatManager {

	public static void initEventHandler() {

		if(SPCompatibilityManager.isLumberjackLoaded())
			SurvivalPlusLumberjack.registerEventHandler();
	}

	public static void init() {

		if(SPCompatibilityManager.isBambooModsLoaded())
			SurvivalPlusArmor.ITEMS_BAMBOO_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isBopLoaded())
			BOPArmor.ITEMS_BOP_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isBopExtrasLoaded())
			BOPArmor.ITEMS_BOP_EXTRAS_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isForestryLoaded())
			ForestryArmor.ITEMS_FORESTRY_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isTraverseLoaded())
			TraverseArmor.ITEMS_TRAVERSE_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
		if(SPCompatibilityManager.isAetherLoaded())
			AetherArmor.ITEMS_AETHER_ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
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
			SurvivalPlusIC2.init();
	}

	public static void setup() {
		if(SPCompatibilityManager.isBopLoaded())
			BOPArmor.init();
		if(SPCompatibilityManager.isForestryLoaded())
			ForestryArmor.init();
		if(SPCompatibilityManager.isTraverseLoaded())
			TraverseArmor.init();
		if(SPCompatibilityManager.isAetherLoaded())
			AetherArmor.init();
		if(SPCompatibilityManager.isIc2Loaded())
			SurvivalPlusIC2.setup();
		if(SPCompatibilityManager.isProjectELoaded())
			SurvivalPlusEMCValues.setup();
		if(SPCompatibilityManager.isJerLoaded())
			SurvivalPlusJER.setup();
	}
	
	public static void postSetup(ServerLevel world) {
		if(SPCompatibilityManager.isIc2Loaded())
			SurvivalPlusIC2.postSetup(world);
	}

}
