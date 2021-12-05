package net.coolsimulations.SurvivalPlus.core.compat;

import biomesoplenty.api.block.BOPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class SurvivalPlusBOP {
	
	public static void init() {
		
		if(SPCompatibilityManager.isBopLoaded()) {
        	OreDictionary.registerOre("cropBamboo", new ItemStack(BOPBlocks.bamboo));
        }
		
	}
	
	public static void registerEventHandler() {
		
		MinecraftForge.EVENT_BUS.register(new SurvivalPlusBOP());
	}
	
	@SubscribeEvent
	public void removeRecipes(RegistryEvent.Register<IRecipe> event) {
		
		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
		
		if(SPCompatibilityManager.isBopLoaded()) {
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.BOP_MODID + ":" + "white_dye_from_lily_of_the_valley"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.BOP_MODID + ":" + "white_dye_from_white_anemone"));
			if(!SPConfig.enableReplaceBOPRecipe) {
				modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "terrestrial_artifact"));
				modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "terrestrial_artifact_ore_gc"));
			} else {
				modRegistry.remove(new ResourceLocation(SPCompatibilityManager.BOP_MODID + ":" + "terrestrial_artifact"));
				modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "terrestrial_artifact_gc"));
			}
		}
	}

}
