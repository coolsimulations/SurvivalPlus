package net.coolsimulations.SurvivalPlus.primer;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.primer.init.SurvivalPlusPrimerBlocks;
import net.coolsimulations.SurvivalPlus.primer.init.SurvivalPlusPrimerItems;
import net.fabricmc.api.ModInitializer;

public class SurvivalPlusPrimer implements ModInitializer {
	
	private static SurvivalPlusPrimer instance;
	public static SurvivalPlusPrimer getInstance()
	{
		return instance;
	}

	@Override
	public void onInitialize() {
		
		SPReference.MOD_ADDON_NAMES.add("sp_primer.name");
		
		SurvivalPlusPrimerItems.init();
		SurvivalPlusPrimerItems.register();
		SurvivalPlusPrimerBlocks.init();
		SurvivalPlusPrimerBlocks.register();
		
	}

}
