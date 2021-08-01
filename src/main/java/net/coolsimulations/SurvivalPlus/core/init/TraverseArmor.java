package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;

public class TraverseArmor {

	public static void init(){

		SPItems.fir_helmet_traverse = new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, EquipmentSlot.HEAD).setRegistryName("fir_helmet_traverse");
		SPItems.fir_chestplate_traverse = new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, EquipmentSlot.CHEST).setRegistryName("fir_chestplate_traverse");
		SPItems.fir_leggings_traverse = new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, EquipmentSlot.LEGS).setRegistryName("fir_leggings_traverse");
		SPItems.fir_boots_traverse = new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, EquipmentSlot.FEET).setRegistryName("fir_boots_traverse");
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
