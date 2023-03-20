package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ItemStack;

public class TraverseArmor {
	
	public static void init() {
		
		SPItems.fir_helmet_traverse = new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, Type.HELMET);
		SPItems.fir_chestplate_traverse = new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, Type.CHESTPLATE);
		SPItems.fir_leggings_traverse = new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, Type.LEGGINGS);
		SPItems.fir_boots_traverse = new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, Type.BOOTS);
		SPItems.fir_traverse = NonNullList.create();
		SPItems.fir_traverse.add(0, new ItemStack(SPItems.fir_helmet_traverse));
		SPItems.fir_traverse.add(1, new ItemStack(SPItems.fir_chestplate_traverse));
		SPItems.fir_traverse.add(2, new ItemStack(SPItems.fir_leggings_traverse));
		SPItems.fir_traverse.add(3, new ItemStack(SPItems.fir_boots_traverse));
	}
	
	public static void register() {
		
		SurvivalPlusArmor.registerItem(SPItems.fir_traverse, "fir", SPCompatibilityManager.TRAVERSE_MODID);
	}

}
