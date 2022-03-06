package net.coolsimulations.SurvivalPlus.primer;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.primer.init.SurvivalPlusPrimerBlocks;
import net.coolsimulations.SurvivalPlus.primer.init.SurvivalPlusPrimerItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = PrimerReference.MOD_ID)
public class SurvivalPlusPrimer {
	
	private static SurvivalPlusPrimer instance;
	public static SurvivalPlusPrimer getInstance()
	{
		return instance;
	}

	public SurvivalPlusPrimer() {
		
		SPReference.MOD_ADDON_NAMES.add("sp_primer.name");
		
		SurvivalPlusPrimerItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusPrimerBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		SurvivalPlusPrimerBlocks.BLOCK_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		
	}

}
