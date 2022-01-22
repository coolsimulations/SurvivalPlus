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

public class GobberArmor {
	
	public static void init(){
		
		SPItems.globArmorMaterial = EnumHelper.addArmorMaterial("glob", SPReference.MOD_ID + ":" +  "glob", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.glob_helmet = new SPItemArmor(SPItems.globArmorMaterial, 0, EntityEquipmentSlot.HEAD, "glob_helmet", "stickWood").setUnlocalizedName("glob_helmet").setRegistryName("glob_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.glob_chestplate = new SPItemArmor(SPItems.globArmorMaterial, 0, EntityEquipmentSlot.CHEST, "glob_chestplate", "stickWood").setUnlocalizedName("glob_chestplate").setRegistryName("glob_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.glob_leggings = new SPItemArmor(SPItems.globArmorMaterial, 0, EntityEquipmentSlot.LEGS, "glob_leggings", "stickWood").setUnlocalizedName("glob_leggings").setRegistryName("glob_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.glob_boots = new SPItemArmor(SPItems.globArmorMaterial, 0, EntityEquipmentSlot.FEET, "glob_boots", "stickWood").setUnlocalizedName("glob_boots").setRegistryName("glob_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.glob = NonNullList.create();
		SPItems.glob.add(0, new ItemStack(SPItems.glob_helmet));
		SPItems.glob.add(1, new ItemStack(SPItems.glob_chestplate));
		SPItems.glob.add(2, new ItemStack(SPItems.glob_leggings));
		SPItems.glob.add(3, new ItemStack(SPItems.glob_boots));
		
		SPItems.netherGlobArmorMaterial = EnumHelper.addArmorMaterial("nether_glob", SPReference.MOD_ID + ":" +  "nether_glob", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.nether_glob_helmet = new SPItemArmor(SPItems.netherGlobArmorMaterial, 0, EntityEquipmentSlot.HEAD, "nether_glob_helmet", "stickWood").setUnlocalizedName("nether_glob_helmet").setRegistryName("nether_glob_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.nether_glob_chestplate = new SPItemArmor(SPItems.netherGlobArmorMaterial, 0, EntityEquipmentSlot.CHEST, "nether_glob_chestplate", "stickWood").setUnlocalizedName("nether_glob_chestplate").setRegistryName("nether_glob_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.nether_glob_leggings = new SPItemArmor(SPItems.netherGlobArmorMaterial, 0, EntityEquipmentSlot.LEGS, "nether_glob_leggings", "stickWood").setUnlocalizedName("nether_glob_leggings").setRegistryName("nether_glob_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.nether_glob_boots = new SPItemArmor(SPItems.netherGlobArmorMaterial, 0, EntityEquipmentSlot.FEET, "nether_glob_boots", "stickWood").setUnlocalizedName("nether_glob_boots").setRegistryName("nether_glob_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.nether_glob = NonNullList.create();
		SPItems.nether_glob.add(0, new ItemStack(SPItems.nether_glob_helmet));
		SPItems.nether_glob.add(1, new ItemStack(SPItems.nether_glob_chestplate));
		SPItems.nether_glob.add(2, new ItemStack(SPItems.nether_glob_leggings));
		SPItems.nether_glob.add(3, new ItemStack(SPItems.nether_glob_boots));
		
		SPItems.endGlobArmorMaterial = EnumHelper.addArmorMaterial("end_glob", SPReference.MOD_ID + ":" +  "end_glob", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.end_glob_helmet = new SPItemArmor(SPItems.endGlobArmorMaterial, 0, EntityEquipmentSlot.HEAD, "end_glob_helmet", "stickWood").setUnlocalizedName("end_glob_helmet").setRegistryName("end_glob_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.end_glob_chestplate = new SPItemArmor(SPItems.endGlobArmorMaterial, 0, EntityEquipmentSlot.CHEST, "end_glob_chestplate", "stickWood").setUnlocalizedName("end_glob_chestplate").setRegistryName("end_glob_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.end_glob_leggings = new SPItemArmor(SPItems.endGlobArmorMaterial, 0, EntityEquipmentSlot.LEGS, "end_glob_leggings", "stickWood").setUnlocalizedName("end_glob_leggings").setRegistryName("end_glob_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.end_glob_boots = new SPItemArmor(SPItems.endGlobArmorMaterial, 0, EntityEquipmentSlot.FEET, "end_glob_boots", "stickWood").setUnlocalizedName("end_glob_boots").setRegistryName("end_glob_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.end_glob = NonNullList.create();
		SPItems.end_glob.add(0, new ItemStack(SPItems.end_glob_helmet));
		SPItems.end_glob.add(1, new ItemStack(SPItems.end_glob_chestplate));
		SPItems.end_glob.add(2, new ItemStack(SPItems.end_glob_leggings));
		SPItems.end_glob.add(3, new ItemStack(SPItems.end_glob_boots));
	}
	
	public static void register()
	{
		SurvivalPlusArmor.registerItem(SPItems.glob);
		SurvivalPlusArmor.registerItem(SPItems.nether_glob);
		SurvivalPlusArmor.registerItem(SPItems.end_glob);
	}
	
	public static void registerRenders()
	{
		SurvivalPlusArmor.registerRender(SPItems.glob);
		SurvivalPlusArmor.registerRender(SPItems.nether_glob);
		SurvivalPlusArmor.registerRender(SPItems.end_glob);
	}

}
