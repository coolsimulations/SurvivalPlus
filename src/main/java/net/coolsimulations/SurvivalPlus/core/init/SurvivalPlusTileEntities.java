package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntityGemStaff;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SurvivalPlusTileEntities {
	
	public static void register() {
		GameRegistry.registerTileEntity(TileEntitySconce.class, new ResourceLocation(SPReference.MOD_ID, "sconce"));
		GameRegistry.registerTileEntity(TileEntityGemStaff.class, new ResourceLocation(SPReference.MOD_ID, "gem_staff"));
	}
}
