package net.coolsimulations.SurvivalPlus.core.compat;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusSmeltingRecipes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class SurvivalPlusBamboozled {
	
	public static void init() {
		
		Item bamboo = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.BAMBOOZLED_MODID, "bamboo"));
    	Item dried_bamboo = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.BAMBOOZLED_MODID, "bamboo_dried"));
    	
    	OreDictionary.registerOre("cropBamboo", new ItemStack(bamboo));
    	SurvivalPlusSmeltingRecipes.removeFurnaceRecipe(new ItemStack(dried_bamboo));
    	SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("cropBamboo", new ItemStack(dried_bamboo), 1.0F, true);
	}
	
	public static void registerEventHandler() {

		MinecraftForge.EVENT_BUS.register(new SurvivalPlusBamboozled());
	}
	
	@SubscribeEvent
	public void removeRecipes(RegistryEvent.Register<IRecipe> event) {

		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();

		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.BAMBOOZLED_MODID + ":" + "bamboo_bundle"));
	}

}
