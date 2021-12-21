package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class AetherRebornArmor {
	
public static void init() {
		
		SPItems.skyroot_helmet = new SPItemArmor(SPArmorMaterial.skyrootArmorMaterial, EquipmentSlot.HEAD);
		SPItems.skyroot_chestplate = new SPItemArmor(SPArmorMaterial.skyrootArmorMaterial, EquipmentSlot.CHEST);
		SPItems.skyroot_leggings = new SPItemArmor(SPArmorMaterial.skyrootArmorMaterial, EquipmentSlot.LEGS);
		SPItems.skyroot_boots = new SPItemArmor(SPArmorMaterial.skyrootArmorMaterial, EquipmentSlot.FEET);
		SPItems.skyroot = NonNullList.create();
		SPItems.skyroot.add(0, new ItemStack(SPItems.skyroot_helmet));
		SPItems.skyroot.add(1, new ItemStack(SPItems.skyroot_chestplate));
		SPItems.skyroot.add(2, new ItemStack(SPItems.skyroot_leggings));
		SPItems.skyroot.add(3, new ItemStack(SPItems.skyroot_boots));
		
		SPItems.golden_oak_helmet = new SPItemArmor(SPArmorMaterial.goldenOakArmorMaterial, EquipmentSlot.HEAD);
		SPItems.golden_oak_chestplate = new SPItemArmor(SPArmorMaterial.goldenOakArmorMaterial, EquipmentSlot.CHEST);
		SPItems.golden_oak_leggings = new SPItemArmor(SPArmorMaterial.goldenOakArmorMaterial, EquipmentSlot.LEGS);
		SPItems.golden_oak_boots = new SPItemArmor(SPArmorMaterial.goldenOakArmorMaterial, EquipmentSlot.FEET);
		SPItems.golden_oak = NonNullList.create();
		SPItems.golden_oak.add(0, new ItemStack(SPItems.golden_oak_helmet));
		SPItems.golden_oak.add(1, new ItemStack(SPItems.golden_oak_chestplate));
		SPItems.golden_oak.add(2, new ItemStack(SPItems.golden_oak_leggings));
		SPItems.golden_oak.add(3, new ItemStack(SPItems.golden_oak_boots));
		
		SPItems.orange_helmet = new SPItemArmor(SPArmorMaterial.orangeArmorMaterial, EquipmentSlot.HEAD);
		SPItems.orange_chestplate = new SPItemArmor(SPArmorMaterial.orangeArmorMaterial, EquipmentSlot.CHEST);
		SPItems.orange_leggings = new SPItemArmor(SPArmorMaterial.orangeArmorMaterial, EquipmentSlot.LEGS);
		SPItems.orange_boots = new SPItemArmor(SPArmorMaterial.orangeArmorMaterial, EquipmentSlot.FEET);
		SPItems.orange = NonNullList.create();
		SPItems.orange.add(0, new ItemStack(SPItems.orange_helmet));
		SPItems.orange.add(1, new ItemStack(SPItems.orange_chestplate));
		SPItems.orange.add(2, new ItemStack(SPItems.orange_leggings));
		SPItems.orange.add(3, new ItemStack(SPItems.orange_boots));
		
		SPItems.crystal_helmet = new SPItemArmor(SPArmorMaterial.crystalArmorMaterial, EquipmentSlot.HEAD);
		SPItems.crystal_chestplate = new SPItemArmor(SPArmorMaterial.crystalArmorMaterial, EquipmentSlot.CHEST);
		SPItems.crystal_leggings = new SPItemArmor(SPArmorMaterial.crystalArmorMaterial, EquipmentSlot.LEGS);
		SPItems.crystal_boots = new SPItemArmor(SPArmorMaterial.crystalArmorMaterial, EquipmentSlot.FEET);
		SPItems.crystal = NonNullList.create();
		SPItems.crystal.add(0, new ItemStack(SPItems.crystal_helmet));
		SPItems.crystal.add(1, new ItemStack(SPItems.crystal_chestplate));
		SPItems.crystal.add(2, new ItemStack(SPItems.crystal_leggings));
		SPItems.crystal.add(3, new ItemStack(SPItems.crystal_boots));
		
		SPItems.wisteria_helmet = new SPItemArmor(SPArmorMaterial.wisteriaArmorMaterial, EquipmentSlot.HEAD);
		SPItems.wisteria_chestplate = new SPItemArmor(SPArmorMaterial.wisteriaArmorMaterial, EquipmentSlot.CHEST);
		SPItems.wisteria_leggings = new SPItemArmor(SPArmorMaterial.wisteriaArmorMaterial, EquipmentSlot.LEGS);
		SPItems.wisteria_boots = new SPItemArmor(SPArmorMaterial.wisteriaArmorMaterial, EquipmentSlot.FEET);
		SPItems.wisteria = NonNullList.create();
		SPItems.wisteria.add(0, new ItemStack(SPItems.wisteria_helmet));
		SPItems.wisteria.add(1, new ItemStack(SPItems.wisteria_chestplate));
		SPItems.wisteria.add(2, new ItemStack(SPItems.wisteria_leggings));
		SPItems.wisteria.add(3, new ItemStack(SPItems.wisteria_boots));
	}
	
	public static void register() {
		
		SurvivalPlusArmor.registerItem(SPItems.skyroot, "skyroot");
		SurvivalPlusArmor.registerItem(SPItems.golden_oak, "golden_oak");
		SurvivalPlusArmor.registerItem(SPItems.orange, "orange");
		SurvivalPlusArmor.registerItem(SPItems.crystal, "crystal");
		SurvivalPlusArmor.registerItem(SPItems.wisteria, "wisteria");
	}

}
