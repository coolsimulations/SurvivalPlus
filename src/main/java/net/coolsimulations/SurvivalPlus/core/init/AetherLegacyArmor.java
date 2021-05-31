package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.util.EnumHelper;

public class AetherLegacyArmor {
	
	public static void init(){
		
		SPItems.skyrootArmorMaterial = EnumHelper.addArmorMaterial("skyroot", SPReference.MOD_ID + ":" +  "skyroot", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.skyroot_helmet = new SPItemArmor(SPItems.skyrootArmorMaterial, 0, EntityEquipmentSlot.HEAD, "skyroot_helmet", "stickWood").setUnlocalizedName("skyroot_helmet").setRegistryName("skyroot_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.skyroot_chestplate = new SPItemArmor(SPItems.skyrootArmorMaterial, 0, EntityEquipmentSlot.CHEST, "skyroot_chestplate", "stickWood").setUnlocalizedName("skyroot_chestplate").setRegistryName("skyroot_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.skyroot_leggings = new SPItemArmor(SPItems.skyrootArmorMaterial, 0, EntityEquipmentSlot.LEGS, "skyroot_leggings", "stickWood").setUnlocalizedName("skyroot_leggings").setRegistryName("skyroot_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.skyroot_boots = new SPItemArmor(SPItems.skyrootArmorMaterial, 0, EntityEquipmentSlot.FEET, "skyroot_boots", "stickWood").setUnlocalizedName("skyroot_boots").setRegistryName("skyroot_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.skyroot = NonNullList.create();
		SPItems.skyroot.add(0, new ItemStack(SPItems.skyroot_helmet));
		SPItems.skyroot.add(1, new ItemStack(SPItems.skyroot_chestplate));
		SPItems.skyroot.add(2, new ItemStack(SPItems.skyroot_leggings));
		SPItems.skyroot.add(3, new ItemStack(SPItems.skyroot_boots));
		
		SPItems.goldenOakArmorMaterial = EnumHelper.addArmorMaterial("golden_oak", SPReference.MOD_ID + ":" +  "golden_oak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.golden_oak_helmet = new SPItemArmor(SPItems.goldenOakArmorMaterial, 0, EntityEquipmentSlot.HEAD, "golden_oak_helmet", "stickWood").setUnlocalizedName("golden_oak_helmet").setRegistryName("golden_oak_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.golden_oak_chestplate = new SPItemArmor(SPItems.goldenOakArmorMaterial, 0, EntityEquipmentSlot.CHEST, "golden_oak_chestplate", "stickWood").setUnlocalizedName("golden_oak_chestplate").setRegistryName("golden_oak_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.golden_oak_leggings = new SPItemArmor(SPItems.goldenOakArmorMaterial, 0, EntityEquipmentSlot.LEGS, "golden_oak_leggings", "stickWood").setUnlocalizedName("golden_oak_leggings").setRegistryName("golden_oak_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.golden_oak_boots = new SPItemArmor(SPItems.goldenOakArmorMaterial, 0, EntityEquipmentSlot.FEET, "golden_oak_boots", "stickWood").setUnlocalizedName("golden_oak_boots").setRegistryName("golden_oak_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.golden_oak = NonNullList.create();
		SPItems.golden_oak.add(0, new ItemStack(SPItems.golden_oak_helmet));
		SPItems.golden_oak.add(1, new ItemStack(SPItems.golden_oak_chestplate));
		SPItems.golden_oak.add(2, new ItemStack(SPItems.golden_oak_leggings));
		SPItems.golden_oak.add(3, new ItemStack(SPItems.golden_oak_boots));
	}
	
	public static void register()
	{
		SurvivalPlusArmor.registerItem(SPItems.skyroot);
		SurvivalPlusArmor.registerItem(SPItems.golden_oak);
	}
	
	public static void registerRenders()
	{
		SurvivalPlusArmor.registerRender(SPItems.skyroot);
		SurvivalPlusArmor.registerRender(SPItems.golden_oak);
	}

}
