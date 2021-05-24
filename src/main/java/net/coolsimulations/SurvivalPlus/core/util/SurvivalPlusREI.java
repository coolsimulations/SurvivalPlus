package net.coolsimulations.SurvivalPlus.core.util;

import me.shedaniel.rei.api.EntryRegistry;
import me.shedaniel.rei.api.plugins.REIPluginV0;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.fabricmc.loader.api.SemanticVersion;
import net.fabricmc.loader.api.VersionParsingException;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

public class SurvivalPlusREI implements REIPluginV0 {

	@Override
	public Identifier getPluginIdentifier() {
		return new Identifier(SPReference.MOD_ID, "rer_plugin");
	}
	
	@Override
    public SemanticVersion getMinimumVersion() throws VersionParsingException {
        return SemanticVersion.parse("0.1.4");
    }
	
	@Override
    public void postRegister() {
		
		EntryRegistry.getInstance().getEntryStacks().filter(stack->Block.getBlockFromItem(stack.getItem()) == SPBlocks.onion && stack.getItem() != SPItems.onion_seeds).forEach(stack->EntryRegistry.getInstance().removeEntry(stack));
    }

}
