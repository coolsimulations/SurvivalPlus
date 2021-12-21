package net.coolsimulations.SurvivalPlus.core.compat;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class SurvivalPlusREI implements REIClientPlugin {

	@Override
	public void registerEntries(EntryRegistry registry) {

		try {
			registry.getEntryStacks().
			filter(entry->entry.getType().equals(VanillaEntryTypes.ITEM))
			.filter(entry->Block.byItem(((ItemStack) entry.getValue()).getItem()) == SPBlocks.onion && ((ItemStack) entry.getValue()).getItem().asItem() != SPItems.onion_seeds)
			.forEach(entry->
			registry.removeEntry(entry)
					);
		} catch(Exception e) {
		}
	}

}
