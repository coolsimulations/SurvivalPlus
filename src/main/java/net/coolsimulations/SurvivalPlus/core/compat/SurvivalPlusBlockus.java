package net.coolsimulations.SurvivalPlus.core.compat;

import com.brand.blockus.content.BlocksRegistration;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ItemStack;

public class SurvivalPlusBlockus extends BlocksRegistration {
	
	public static void init() {
		
		SPBlocks.onion_crate = register("onion_crate", createCrates());
		
		SPItems.white_oak_helmet = new SPItemArmor(SPArmorMaterial.whiteOakArmorMaterial, Type.HELMET);
		SPItems.white_oak_chestplate = new SPItemArmor(SPArmorMaterial.whiteOakArmorMaterial, Type.CHESTPLATE);
		SPItems.white_oak_leggings = new SPItemArmor(SPArmorMaterial.whiteOakArmorMaterial, Type.LEGGINGS);
		SPItems.white_oak_boots = new SPItemArmor(SPArmorMaterial.whiteOakArmorMaterial, Type.BOOTS);
		SPItems.white_oak = NonNullList.create();
		SPItems.white_oak.add(0, new ItemStack(SPItems.white_oak_helmet));
		SPItems.white_oak.add(1, new ItemStack(SPItems.white_oak_chestplate));
		SPItems.white_oak.add(2, new ItemStack(SPItems.white_oak_leggings));
		SPItems.white_oak.add(3, new ItemStack(SPItems.white_oak_boots));
	}
	
	public static void register() {
		
		SurvivalPlusArmor.registerItem(SPItems.white_oak, "white_oak");
	}

}
