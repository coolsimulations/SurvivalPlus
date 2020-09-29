package net.coolsimulations.SurvivalPlus.core.util;

import com.alcatrazescapee.notreepunching.client.ModTabs;
import com.alcatrazescapee.notreepunching.common.items.ItemKnife;
import com.alcatrazescapee.notreepunching.common.items.ItemMattock;
import com.alcatrazescapee.notreepunching.common.items.ItemSaw;

import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;

public class SurvivalPlusNoTreePunching {
	
	public static void init() {
		SPItems.titanium_knife = new ItemKnife(SPItems.titaniumToolMaterial).setUnlocalizedName("titanium_knife").setRegistryName("titanium_knife").setCreativeTab(ModTabs.TAB_TOOLS);
		SPItems.titanium_mattock = new ItemMattock(SPItems.titaniumToolMaterial).setUnlocalizedName("titanium_mattock").setRegistryName("titanium_mattock").setCreativeTab(ModTabs.TAB_TOOLS);
		SPItems.titanium_saw = new ItemSaw(SPItems.titaniumToolMaterial).setUnlocalizedName("titanium_saw").setRegistryName("titanium_saw").setCreativeTab(ModTabs.TAB_TOOLS);
		
		if(SPCompatibilityManager.isGCLoaded() && SPCompatibilityManager.isGCPLoaded()) {
			SPItems.desh_knife = new ItemKnife(MarsItems.TOOLDESH).setUnlocalizedName("desh_knife").setRegistryName("desh_knife").setCreativeTab(ModTabs.TAB_TOOLS);
			SPItems.desh_mattock = new ItemMattock(MarsItems.TOOLDESH).setUnlocalizedName("desh_mattock").setRegistryName("desh_mattock").setCreativeTab(ModTabs.TAB_TOOLS);
			SPItems.desh_saw = new ItemSaw(MarsItems.TOOLDESH).setUnlocalizedName("desh_saw").setRegistryName("desh_saw").setCreativeTab(ModTabs.TAB_TOOLS);
		}
	}
	
	public static void register()
	{
		SurvivalPlusTools.registerItem(SPItems.titanium_knife);
		SurvivalPlusTools.registerItem(SPItems.titanium_mattock);
		SurvivalPlusTools.registerItem(SPItems.titanium_saw);
		
		if(SPCompatibilityManager.isGCLoaded() && SPCompatibilityManager.isGCPLoaded()) {
			SurvivalPlusTools.registerItem(SPItems.desh_knife);
			SurvivalPlusTools.registerItem(SPItems.desh_mattock);
			SurvivalPlusTools.registerItem(SPItems.desh_saw);
		}
	}
	
	public static void registerRenders()
	{
		SurvivalPlusTools.registerRender(SPItems.titanium_knife);
		SurvivalPlusTools.registerRender(SPItems.titanium_mattock);
		SurvivalPlusTools.registerRender(SPItems.titanium_saw);
		
		if(SPCompatibilityManager.isGCLoaded() && SPCompatibilityManager.isGCPLoaded()) {
			SurvivalPlusTools.registerRender(SPItems.desh_knife);
			SurvivalPlusTools.registerRender(SPItems.desh_mattock);
			SurvivalPlusTools.registerRender(SPItems.desh_saw);
		}
	}

}
