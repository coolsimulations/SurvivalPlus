package net.coolsimulations.SurvivalPlus.core.util;

import com.brand.blockus.content.BlocksRegistration;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class SurvivalPlusBlockus {
	
	public static void init() {
		
		SPBlocks.onion_crate = BlocksRegistration.registerCrates("onion");
		
		SPItems.white_oak_helmet = new SPItemArmor(SPArmorMaterial.whiteOakArmorMaterial, EquipmentSlot.HEAD);
		SPItems.white_oak_chestplate = new SPItemArmor(SPArmorMaterial.whiteOakArmorMaterial, EquipmentSlot.CHEST);
		SPItems.white_oak_leggings = new SPItemArmor(SPArmorMaterial.whiteOakArmorMaterial, EquipmentSlot.LEGS);
		SPItems.white_oak_boots = new SPItemArmor(SPArmorMaterial.whiteOakArmorMaterial, EquipmentSlot.FEET);
		SPItems.white_oak = DefaultedList.of();
		SPItems.white_oak.add(0, new ItemStack(SPItems.white_oak_helmet));
		SPItems.white_oak.add(1, new ItemStack(SPItems.white_oak_chestplate));
		SPItems.white_oak.add(2, new ItemStack(SPItems.white_oak_leggings));
		SPItems.white_oak.add(3, new ItemStack(SPItems.white_oak_boots));
	}
	
	public static void register() {
		
		SurvivalPlusArmor.registerItem(SPItems.white_oak, "white_oak");
	}

}
