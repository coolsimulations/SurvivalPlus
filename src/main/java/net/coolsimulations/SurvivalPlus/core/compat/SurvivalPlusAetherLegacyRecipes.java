package net.coolsimulations.SurvivalPlus.core.compat;

import com.gildedgames.the_aether.api.enchantments.AetherEnchantment;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class SurvivalPlusAetherLegacyRecipes {
	
	public static void registerEventHandler() {

		MinecraftForge.EVENT_BUS.register(new SurvivalPlusAetherLegacyRecipes());
	}
	
	@SubscribeEvent
	public void init(Register<AetherEnchantment> event) {
		
		IForgeRegistry<AetherEnchantment> registry = event.getRegistry();

		registerArmourLists(registry, SPItems.oak, 225);
		registerArmourLists(registry, SPItems.spruce, 225);
		registerArmourLists(registry, SPItems.birch, 225);
		registerArmourLists(registry, SPItems.jungle, 225);
		registerArmourLists(registry, SPItems.acacia, 225);
		registerArmourLists(registry, SPItems.dark_oak, 225);
		registerArmourLists(registry, SPItems.skyroot, 225);
		registerArmourLists(registry, SPItems.golden_oak, 225);
		
		if (OreDictionary.getOres("woodRubber").size() > 0) {
			registerArmourLists(registry, SPItems.rubber, 225);
		}
		
        registerArmourLists(registry, SPItems.stone, 550);
		
		registry.register(new AetherEnchantment(SPItems.bronze_axe, 1750));
		registry.register(new AetherEnchantment(SPItems.bronze_hoe, 1750));
		registry.register(new AetherEnchantment(SPItems.bronze_pickaxe, 1750));
		registry.register(new AetherEnchantment(SPItems.bronze_shears, 1750));
		registry.register(new AetherEnchantment(SPItems.bronze_shovel, 1750));
		
		registerArmourLists(registry, SPItems.bronze, 5500);
		
		registry.register(new AetherEnchantment(SPItems.titanium_axe, 2750));
		registry.register(new AetherEnchantment(SPItems.titanium_hoe, 2750));
		registry.register(new AetherEnchantment(SPItems.titanium_pickaxe, 2750));
		registry.register(new AetherEnchantment(SPItems.titanium_shears, 2750));
		registry.register(new AetherEnchantment(SPItems.titanium_shovel, 1750));
		
		registerArmourLists(registry, SPItems.titanium, 6500);
		
		if(SPCompatibilityManager.isNoTreePunchingLoaded()) {
			registry.register(new AetherEnchantment(SPItems.titanium_saw, 2750));
			registry.register(new AetherEnchantment(SPItems.titanium_knife, 2750));
			registry.register(new AetherEnchantment(SPItems.titanium_mattock, 2750));
			
			if(SPCompatibilityManager.isGCLoaded() && SPCompatibilityManager.isGCPLoaded()) {
				registry.register(new AetherEnchantment(SPItems.desh_saw, 3250));
				registry.register(new AetherEnchantment(SPItems.desh_knife, 3250));
				registry.register(new AetherEnchantment(SPItems.desh_mattock, 3250));
			}
		}
		
		if(SPCompatibilityManager.isBopLoaded()) {
			registerArmourLists(registry, SPItems.cherry, 225);
			registerArmourLists(registry, SPItems.dead, 225);
			registerArmourLists(registry, SPItems.ebony, 225);
			registerArmourLists(registry, SPItems.ethereal, 225);
			registerArmourLists(registry, SPItems.eucalyptus, 225);
			registerArmourLists(registry, SPItems.fir, 225);
			registerArmourLists(registry, SPItems.hellbark, 225);
			registerArmourLists(registry, SPItems.jacaranda, 225);
			registerArmourLists(registry, SPItems.magic, 225);
			registerArmourLists(registry, SPItems.mahogany, 225);
			registerArmourLists(registry, SPItems.mangrove, 225);
			registerArmourLists(registry, SPItems.palm, 225);
			registerArmourLists(registry, SPItems.pine, 225);
			registerArmourLists(registry, SPItems.redwood, 225);
			registerArmourLists(registry, SPItems.sacred_oak, 225);
			registerArmourLists(registry, SPItems.umbran, 225);
			registerArmourLists(registry, SPItems.willow, 225);
		}
		
		if(SPCompatibilityManager.isForestryLoaded()) {
			registerArmourLists(registry, SPItems.desert_acacia, 225);
			registerArmourLists(registry, SPItems.balsa, 225);
			registerArmourLists(registry, SPItems.baobab, 225);
			registerArmourLists(registry, SPItems.cherry_forestry, 225);
			registerArmourLists(registry, SPItems.chestnut, 225);
			registerArmourLists(registry, SPItems.citrus, 225);
			registerArmourLists(registry, SPItems.cocobolo, 225);
			registerArmourLists(registry, SPItems.ebony_forestry, 225);
			registerArmourLists(registry, SPItems.giant_sequoia, 225);
			registerArmourLists(registry, SPItems.greenheart, 225);
			registerArmourLists(registry, SPItems.ipe, 225);
			registerArmourLists(registry, SPItems.kapok, 225);
			registerArmourLists(registry, SPItems.larch, 225);
			registerArmourLists(registry, SPItems.lime, 225);
			registerArmourLists(registry, SPItems.mahogany, 225);
			registerArmourLists(registry, SPItems.maple, 225);
			registerArmourLists(registry, SPItems.padauk, 225);
			registerArmourLists(registry, SPItems.palm_forestry, 225);
			registerArmourLists(registry, SPItems.papaya, 225);
			registerArmourLists(registry, SPItems.pine_forestry, 225);
			registerArmourLists(registry, SPItems.plum, 225);
			registerArmourLists(registry, SPItems.poplar, 225);
			registerArmourLists(registry, SPItems.sequoia, 225);
			registerArmourLists(registry, SPItems.teak, 225);
			registerArmourLists(registry, SPItems.walnut, 225);
			registerArmourLists(registry, SPItems.wenge, 225);
			registerArmourLists(registry, SPItems.willow_forestry, 225);
			registerArmourLists(registry, SPItems.zebrawood, 225);
		}
		
		if(SPCompatibilityManager.isTraverseLoaded()) {
			registerArmourLists(registry, SPItems.fir_traverse, 225);
		}
		
		if(SPCompatibilityManager.isBambooModsLoaded()) {
			registerArmourLists(registry, SPItems.bamboo, 225);
		}
		
		if(SPCompatibilityManager.isExtraPlanetsLoaded()) {
			registerArmourLists(registry, SPItems.kepler22b_blue_maple, 225);
			registerArmourLists(registry, SPItems.kepler22b_red_maple, 225);
			registerArmourLists(registry, SPItems.kepler22b_purple_maple, 225);
			registerArmourLists(registry, SPItems.kepler22b_yellow_maple, 225);
			registerArmourLists(registry, SPItems.kepler22b_green_maple, 225);
			registerArmourLists(registry, SPItems.kepler22b_brown_maple, 225);
		}
		
		if(SPCompatibilityManager.isGobberLoaded()) {
			registerArmourLists(registry, SPItems.glob, 225);
			registerArmourLists(registry, SPItems.nether_glob, 225);
			registerArmourLists(registry, SPItems.end_glob, 225);
		}
	}
	
	protected void registerArmourLists(IForgeRegistry<AetherEnchantment> registry, NonNullList<ItemStack> itemList, int duration) {
		
		for(ItemStack item : itemList) {
			registry.register(new AetherEnchantment(item.getItem(), duration));
		}
	}

}
