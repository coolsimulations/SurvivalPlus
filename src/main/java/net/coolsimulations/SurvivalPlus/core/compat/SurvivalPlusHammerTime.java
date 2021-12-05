package net.coolsimulations.SurvivalPlus.core.compat;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;

import com.ewyboy.bibliotheca.common.loaders.ItemLoader;
import com.ewyboy.hammertime.common.items.ItemHammer;
import com.ewyboy.hammertime.common.items.ItemShovel;
import com.ewyboy.hammertime.common.items.ItemAxe;
import com.ewyboy.hammertime.common.items.ItemSickle;

public class SurvivalPlusHammerTime {
	
	public static void init() {
		ItemLoader.init(SPCompatibilityManager.HAMMER_TIME_MODID, Items.class);
	}
	
	public static void registerEventHandler() {
		
		MinecraftForge.EVENT_BUS.register(new SurvivalPlusHammerTime());
	}
	
	@SubscribeEvent
	public void removeRecipes(RegistryEvent.Register<IRecipe> event) {
		
		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
		
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxediamond"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxegold"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxeiron"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxestone"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxewood"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammerdiamond"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammergold"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammeriron"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammerstone"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammerwood"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshoveldiamond"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshovelgold"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshoveliron"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshovelstone"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshovelwood"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsicklediamond"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsicklegold"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsickleiron"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsicklestone"));
		modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsicklewood"));
	}
	
	public static class Items {
	
		public static ItemHammer hammerBronze = new ItemHammer(SPItems.bronzeToolMaterial);
		public static ItemHammer hammerTitanium = new ItemHammer(SPItems.titaniumToolMaterial);
		
		public static ItemShovel shovelBronze = new ItemShovel(SPItems.bronzeToolMaterial);
		public static ItemShovel shovelTitanium = new ItemShovel(SPItems.titaniumToolMaterial);
		
		public static ItemAxe axeBronze = new ItemAxe(SPItems.bronzeToolMaterial);
		public static ItemAxe axeTitanium = new ItemAxe(SPItems.titaniumToolMaterial);
		
		public static ItemSickle sickleBronze = new ItemSickle(SPItems.bronzeToolMaterial);
		public static ItemSickle sickleTitanium = new ItemSickle(SPItems.titaniumToolMaterial);
	}

}
