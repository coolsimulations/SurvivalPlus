package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.util.EnumHelper;

public class TraverseArmor {

	public static void init() {

		SPItems.firTraverseArmorMaterial = EnumHelper.addArmorMaterial("fir_traverse", SPReference.MOD_ID + ":" +  "fir_traverse", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.fir_helmet_traverse = new SPItemArmor(SPItems.firTraverseArmorMaterial, 0, EntityEquipmentSlot.HEAD, "fir_helmet_traverse", "stickWood").setUnlocalizedName("fir_helmet_traverse").setRegistryName("fir_helmet_traverse").setCreativeTab(SPTabs.tabCombat);
		SPItems.fir_chestplate_traverse = new SPItemArmor(SPItems.firTraverseArmorMaterial, 0, EntityEquipmentSlot.CHEST, "fir_chestplate_traverse", "stickWood").setUnlocalizedName("fir_chestplate_traverse").setRegistryName("fir_chestplate_traverse").setCreativeTab(SPTabs.tabCombat);
		SPItems.fir_leggings_traverse = new SPItemArmor(SPItems.firTraverseArmorMaterial, 0, EntityEquipmentSlot.LEGS, "fir_leggings_traverse", "stickWood").setUnlocalizedName("fir_leggings_traverse").setRegistryName("fir_leggings_traverse").setCreativeTab(SPTabs.tabCombat);
		SPItems.fir_boots_traverse = new SPItemArmor(SPItems.firTraverseArmorMaterial, 0, EntityEquipmentSlot.FEET, "fir_boots_traverse", "stickWood").setUnlocalizedName("fir_boots_traverse").setRegistryName("fir_boots_traverse").setCreativeTab(SPTabs.tabCombat);
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
	
	public static void registerRenders()
	{
		SurvivalPlusArmor.registerRender(SPItems.fir_traverse);
	}

}
