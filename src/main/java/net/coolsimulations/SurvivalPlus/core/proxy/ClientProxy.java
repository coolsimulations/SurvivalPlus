package net.coolsimulations.SurvivalPlus.core.proxy;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.client.renderer.TileEntityShieldRenderer;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce;
import net.coolsimulations.SurvivalPlus.core.client.renderer.SPTileEntitySconceRenderer;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusNoTreePunching;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusBlocks;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusFood;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;
import net.coolsimulations.SurvivalPlus.core.world.SurvivalPlusOreGenerator;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy implements CommonProxy{
	
	@Override
	public void init(){
		SurvivalPlusBlocks.registerRenders();
		SurvivalPlusItems.registerRenders();
		SurvivalPlusFood.registerRenders();
		SurvivalPlusArmor.registerRenders();
		SurvivalPlusTools.registerRenders();
		SPItems.bronze_shield.setTileEntityItemStackRenderer(TileEntityShieldRenderer.instance);
		SPItems.titanium_shield.setTileEntityItemStackRenderer(TileEntityShieldRenderer.instance);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySconce.class, new SPTileEntitySconceRenderer());
	}
	
}
