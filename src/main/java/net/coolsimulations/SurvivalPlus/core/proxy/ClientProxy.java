package net.coolsimulations.SurvivalPlus.core.proxy;

import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusBlocks;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusFood;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;
import net.coolsimulations.SurvivalPlus.core.world.SurvivalPlusOreGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy implements CommonProxy{
	
	@Override
	public void init(){
		SurvivalPlusBlocks.registerRenders();
		SurvivalPlusItems.registerRenders();
		SurvivalPlusFood.registerRenders();
		SurvivalPlusArmor.registerRenders();
		SurvivalPlusTools.registerRenders();
	}
	
}
