package net.coolsimulations.SurvivalPlus.core.proxy;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.client.renderer.TileEntityShieldRenderer;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusBlocks;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusFood;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusNoTreePunching;
import net.coolsimulations.SurvivalPlus.core.world.SurvivalPlusOreGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy implements CommonProxy{
	
	@Override
	public void init(){
		GameRegistry.registerWorldGenerator(new SurvivalPlusOreGenerator(), 1);
		SurvivalPlusBlocks.registerRenders();
		SurvivalPlusItems.registerRenders();
		SurvivalPlusFood.registerRenders();
		SurvivalPlusArmor.registerRenders();
		SurvivalPlusTools.registerRenders();
		SPItems.bronze_shield.setTileEntityItemStackRenderer(TileEntityShieldRenderer.instance);
		SPItems.titanium_shield.setTileEntityItemStackRenderer(TileEntityShieldRenderer.instance);
	}
	
}
