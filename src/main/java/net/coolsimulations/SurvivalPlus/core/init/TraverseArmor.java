package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class TraverseArmor {

	public static void init(){

		SPItems.fir_helmet_traverse = new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, EquipmentSlotType.HEAD).setRegistryName("fir_helmet_traverse");
		SPItems.fir_chestplate_traverse = new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, EquipmentSlotType.CHEST).setRegistryName("fir_chestplate_traverse");
		SPItems.fir_leggings_traverse = new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, EquipmentSlotType.LEGS).setRegistryName("fir_leggings_traverse");
		SPItems.fir_boots_traverse = new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, EquipmentSlotType.FEET).setRegistryName("fir_boots_traverse");
		SPItems.fir_traverse = NonNullList.create();
		SPItems.fir_traverse.add(0, new ItemStack(SPItems.fir_helmet_traverse));
		SPItems.fir_traverse.add(1, new ItemStack(SPItems.fir_chestplate_traverse));
		SPItems.fir_traverse.add(2, new ItemStack(SPItems.fir_leggings_traverse));
		SPItems.fir_traverse.add(3, new ItemStack(SPItems.fir_boots_traverse));
	}

	public static void register()
	{
		SurvivalPlusArmor.registerItem(SPItems.fir_traverse);
	}

}