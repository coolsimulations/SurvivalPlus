package net.coolsimulations.SurvivalPlus.core.util;

import me.shedaniel.rei.api.EntryRegistry;
import me.shedaniel.rei.api.plugins.REIPluginV0;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.fabricmc.loader.api.SemanticVersion;
import net.fabricmc.loader.api.VersionParsingException;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class SurvivalPlusREI implements REIPluginV0 {

	@Override
	public ResourceLocation getPluginIdentifier() {
		return new ResourceLocation(SPReference.MOD_ID, "rer_plugin");
	}
	
	@Override
    public SemanticVersion getMinimumVersion() throws VersionParsingException {
        return SemanticVersion.parse("0.1.5");
    }
	
	@Override
    public void postRegister() {
		
		EntryRegistry.getInstance().getEntryStacks().filter(stack->Block.byItem(stack.getItem()) == SPBlocks.onion && stack.getItem() != SPItems.onion_seeds).forEach(stack->EntryRegistry.getInstance().removeEntry(stack));
    }

}
