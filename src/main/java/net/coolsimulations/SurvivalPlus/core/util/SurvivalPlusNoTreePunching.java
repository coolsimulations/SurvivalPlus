package net.coolsimulations.SurvivalPlus.core.util;

import com.alcatrazescapee.notreepunching.common.ModItemGroup;
import com.alcatrazescapee.notreepunching.common.items.CraftingAxeItem;
import com.alcatrazescapee.notreepunching.common.items.KnifeItem;
import com.alcatrazescapee.notreepunching.common.items.MattockItem;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPItemTier;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;
import net.minecraft.item.Item.Properties;

public class SurvivalPlusNoTreePunching {
	
	public static void init() {
		SPItems.titanium_knife = new KnifeItem(SPItemTier.titaniumToolMaterial, 1, -2.2F, new Properties().group(ModItemGroup.ITEMS)).setRegistryName("titanium_knife");
		SPItems.titanium_mattock = new MattockItem(SPItemTier.titaniumToolMaterial, 0.5F, -2.2F, new Properties().group(ModItemGroup.ITEMS)).setRegistryName("titanium_mattock");
		SPItems.titanium_saw = new CraftingAxeItem(SPItemTier.titaniumToolMaterial, 3.0F, -3.2F, new Properties().group(ModItemGroup.ITEMS)).setRegistryName("titanium_saw");
		
		/**if(SPCompatibilityManager.isGCLoaded() && SPCompatibilityManager.isGCPLoaded()) {
			SPItems.desh_knife = new ItemKnife(MarsItems.TOOLDESH).setUnlocalizedName("desh_knife").setRegistryName("desh_knife").setCreativeTab(ModTabs.TAB_TOOLS);
			SPItems.desh_mattock = new ItemMattock(MarsItems.TOOLDESH).setUnlocalizedName("desh_mattock").setRegistryName("desh_mattock").setCreativeTab(ModTabs.TAB_TOOLS);
			SPItems.desh_saw = new ItemSaw(MarsItems.TOOLDESH).setUnlocalizedName("desh_saw").setRegistryName("desh_saw").setCreativeTab(ModTabs.TAB_TOOLS);
		}**/
	}
	
	public static void register()
	{
		SurvivalPlusTools.registerItem(SPItems.titanium_knife);
		SurvivalPlusTools.registerItem(SPItems.titanium_mattock);
		SurvivalPlusTools.registerItem(SPItems.titanium_saw);
		
		/**if(SPCompatibilityManager.isGCLoaded() && SPCompatibilityManager.isGCPLoaded()) {
			SurvivalPlusTools.registerItem(SPItems.desh_knife);
			SurvivalPlusTools.registerItem(SPItems.desh_mattock);
			SurvivalPlusTools.registerItem(SPItems.desh_saw);
		}**/
	}

}
