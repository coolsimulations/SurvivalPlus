package net.coolsimulations.SurvivalPlus.primer;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.primer.init.SurvivalPlusPrimerBlocks;
import net.coolsimulations.SurvivalPlus.primer.init.SurvivalPlusPrimerItems;
import net.minecraftforge.fml.common.Mod;

@Mod(value = PrimerReference.MOD_ID)
public class SurvivalPlusPrimer {
	
	private static SurvivalPlusPrimer instance;
	public static SurvivalPlusPrimer getInstance()
	{
		return instance;
	}

	public SurvivalPlusPrimer() {
		
		SPReference.MOD_ADDON_NAMES.add("sp_primer.name");
		
		SurvivalPlusPrimerItems.init();
		SurvivalPlusPrimerItems.register();
		SurvivalPlusPrimerBlocks.init();
		SurvivalPlusPrimerBlocks.register();
		
	}

}
