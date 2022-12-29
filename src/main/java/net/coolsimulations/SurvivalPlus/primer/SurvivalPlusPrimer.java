package net.coolsimulations.SurvivalPlus.primer;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.primer.init.SurvivalPlusPrimerBlocks;
import net.coolsimulations.SurvivalPlus.primer.init.SurvivalPlusPrimerItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.resources.ResourceLocation;

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
		
		addToTabs();
	}
	
	private void addToTabs() {
		ItemGroupEvents.modifyEntriesEvent(new ResourceLocation(SPReference.MOD_ID, "tab_materials")).register(content -> {
			content.accept(SurvivalPlusPrimerItems.copper_ingot);
		});
		ItemGroupEvents.modifyEntriesEvent(new ResourceLocation(SPReference.MOD_ID, "tab_blocks")).register(content -> {
			content.accept(SurvivalPlusPrimerBlocks.copper_block);
			content.accept(SurvivalPlusPrimerBlocks.copper_ore);
		});
		ItemGroupEvents.modifyEntriesEvent(new ResourceLocation(SPReference.MOD_ID, "tab_gem")).register(content -> {
			content.accept(SurvivalPlusPrimerBlocks.amethyst);
			content.accept(SurvivalPlusPrimerBlocks.ruby);
			content.accept(SurvivalPlusPrimerBlocks.topaz);
			content.accept(SurvivalPlusPrimerBlocks.sapphire);
			content.accept(SurvivalPlusPrimerBlocks.spinel);
		});
	}
}
