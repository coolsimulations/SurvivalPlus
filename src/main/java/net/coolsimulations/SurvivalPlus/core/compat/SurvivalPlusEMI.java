package net.coolsimulations.SurvivalPlus.core.compat;

import dev.emi.emi.api.EmiApi;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.world.level.block.Block;

public class SurvivalPlusEMI implements EmiPlugin {

	@Override
	public void register(EmiRegistry registry) {
		try {
			EmiApi.getIndexStacks().stream()
			.filter(entry->Block.byItem(entry.getItemStack().getItem()) == SPBlocks.onion && entry.getItemStack().getItem().asItem() != SPItems.onion_seeds)
			.forEach(entry->
			registry.removeEmiStacks(entry)
					);
		} catch(Exception e) {
		}
	}
}