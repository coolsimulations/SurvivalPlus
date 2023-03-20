package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ItemStack;

public class AetherRebornArmor {
	
public static void init() {
		
		SPItems.skyroot_helmet = new SPItemArmor(SPArmorMaterial.skyrootArmorMaterial, Type.HELMET);
		SPItems.skyroot_chestplate = new SPItemArmor(SPArmorMaterial.skyrootArmorMaterial, Type.CHESTPLATE);
		SPItems.skyroot_leggings = new SPItemArmor(SPArmorMaterial.skyrootArmorMaterial, Type.LEGGINGS);
		SPItems.skyroot_boots = new SPItemArmor(SPArmorMaterial.skyrootArmorMaterial, Type.BOOTS);
		SPItems.skyroot = NonNullList.create();
		SPItems.skyroot.add(0, new ItemStack(SPItems.skyroot_helmet));
		SPItems.skyroot.add(1, new ItemStack(SPItems.skyroot_chestplate));
		SPItems.skyroot.add(2, new ItemStack(SPItems.skyroot_leggings));
		SPItems.skyroot.add(3, new ItemStack(SPItems.skyroot_boots));
		
		SPItems.golden_oak_helmet = new SPItemArmor(SPArmorMaterial.goldenOakArmorMaterial, Type.HELMET);
		SPItems.golden_oak_chestplate = new SPItemArmor(SPArmorMaterial.goldenOakArmorMaterial, Type.CHESTPLATE);
		SPItems.golden_oak_leggings = new SPItemArmor(SPArmorMaterial.goldenOakArmorMaterial, Type.LEGGINGS);
		SPItems.golden_oak_boots = new SPItemArmor(SPArmorMaterial.goldenOakArmorMaterial, Type.BOOTS);
		SPItems.golden_oak = NonNullList.create();
		SPItems.golden_oak.add(0, new ItemStack(SPItems.golden_oak_helmet));
		SPItems.golden_oak.add(1, new ItemStack(SPItems.golden_oak_chestplate));
		SPItems.golden_oak.add(2, new ItemStack(SPItems.golden_oak_leggings));
		SPItems.golden_oak.add(3, new ItemStack(SPItems.golden_oak_boots));
		
		SPItems.orange_helmet = new SPItemArmor(SPArmorMaterial.orangeArmorMaterial, Type.HELMET);
		SPItems.orange_chestplate = new SPItemArmor(SPArmorMaterial.orangeArmorMaterial, Type.CHESTPLATE);
		SPItems.orange_leggings = new SPItemArmor(SPArmorMaterial.orangeArmorMaterial, Type.LEGGINGS);
		SPItems.orange_boots = new SPItemArmor(SPArmorMaterial.orangeArmorMaterial, Type.BOOTS);
		SPItems.orange = NonNullList.create();
		SPItems.orange.add(0, new ItemStack(SPItems.orange_helmet));
		SPItems.orange.add(1, new ItemStack(SPItems.orange_chestplate));
		SPItems.orange.add(2, new ItemStack(SPItems.orange_leggings));
		SPItems.orange.add(3, new ItemStack(SPItems.orange_boots));
		
		SPItems.crystal_helmet = new SPItemArmor(SPArmorMaterial.crystalArmorMaterial, Type.HELMET);
		SPItems.crystal_chestplate = new SPItemArmor(SPArmorMaterial.crystalArmorMaterial, Type.CHESTPLATE);
		SPItems.crystal_leggings = new SPItemArmor(SPArmorMaterial.crystalArmorMaterial, Type.LEGGINGS);
		SPItems.crystal_boots = new SPItemArmor(SPArmorMaterial.crystalArmorMaterial, Type.BOOTS);
		SPItems.crystal = NonNullList.create();
		SPItems.crystal.add(0, new ItemStack(SPItems.crystal_helmet));
		SPItems.crystal.add(1, new ItemStack(SPItems.crystal_chestplate));
		SPItems.crystal.add(2, new ItemStack(SPItems.crystal_leggings));
		SPItems.crystal.add(3, new ItemStack(SPItems.crystal_boots));
		
		SPItems.wisteria_helmet = new SPItemArmor(SPArmorMaterial.wisteriaArmorMaterial, Type.HELMET);
		SPItems.wisteria_chestplate = new SPItemArmor(SPArmorMaterial.wisteriaArmorMaterial, Type.CHESTPLATE);
		SPItems.wisteria_leggings = new SPItemArmor(SPArmorMaterial.wisteriaArmorMaterial, Type.LEGGINGS);
		SPItems.wisteria_boots = new SPItemArmor(SPArmorMaterial.wisteriaArmorMaterial, Type.BOOTS);
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
