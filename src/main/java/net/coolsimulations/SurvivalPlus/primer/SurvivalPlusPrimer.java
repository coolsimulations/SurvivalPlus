package net.coolsimulations.SurvivalPlus.primer;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.primer.init.SurvivalPlusPrimerBlocks;
import net.coolsimulations.SurvivalPlus.primer.init.SurvivalPlusPrimerItems;
import net.minecraftforge.event.CreativeModeTabEvent;
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
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::addToTabs);
	}
	
	private void addToTabs(CreativeModeTabEvent.BuildContents event) {
		if (event.getTab().getIconItem().getItem() == SPItems.tin_ingot.get()) {
			event.accept(SurvivalPlusPrimerItems.copper_ingot.get());
		}
		if (event.getTab().getIconItem().getItem() == SPBlocks.tin_block.get().asItem()) {
			event.accept(SurvivalPlusPrimerBlocks.copper_block.get());
			event.accept(SurvivalPlusPrimerBlocks.copper_ore.get());
		}
		if (event.getTab().getIconItem().getItem() == SPBlocks.sapphire_cluster.get().asItem()) {
			event.accept(SurvivalPlusPrimerBlocks.amethyst.get());
			event.accept(SurvivalPlusPrimerBlocks.ruby.get());
			event.accept(SurvivalPlusPrimerBlocks.topaz.get());
			event.accept(SurvivalPlusPrimerBlocks.sapphire.get());
			event.accept(SurvivalPlusPrimerBlocks.spinel.get());
		}
	}
}
