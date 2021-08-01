package net.coolsimulations.SurvivalPlus.core.util;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class SurvivalPlusREI implements REIClientPlugin {
	
	@Override
    public void postRegister() {
		
		EntryRegistry.getInstance().getEntryStacks().filter(stack->Block.byItem(((ItemStack) stack.getValue()).getItem()) == SPBlocks.onion && ((ItemStack) stack.getValue()).getItem().asItem() != SPItems.onion_seeds).forEach(stack->EntryRegistry.getInstance().removeEntry(stack));
    }

}
