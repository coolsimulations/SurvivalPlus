package net.coolsimulations.SurvivalPlus.core.world;

import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldRegister {

	public static void MainRegistery(){
		RegisterWorldGen(new WorldOreGen(), 1);
		
	}
	
	public static void RegisterWorldGen(IWorldGenerator iGenerator, int WeightedProbability){
		GameRegistry.registerWorldGenerator(iGenerator, WeightedProbability);
	}
}
