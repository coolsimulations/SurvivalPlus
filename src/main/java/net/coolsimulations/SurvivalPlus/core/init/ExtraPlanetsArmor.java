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

public class ExtraPlanetsArmor {
	
	public static void init(){
		
		SPItems.kepler22bBlueMapleArmorMaterial = EnumHelper.addArmorMaterial("kepler22b_blue_maple", SPReference.MOD_ID + ":" +  "kepler22b_blue_maple", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.kepler22b_blue_maple_helmet = new SPItemArmor(SPItems.kepler22bBlueMapleArmorMaterial, 0, EntityEquipmentSlot.HEAD, "kepler22b_blue_maple_helmet", "stickWood").setUnlocalizedName("kepler22b_blue_maple_helmet").setRegistryName("kepler22b_blue_maple_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_blue_maple_chestplate = new SPItemArmor(SPItems.kepler22bBlueMapleArmorMaterial, 0, EntityEquipmentSlot.CHEST, "kepler22b_blue_maple_chestplate", "stickWood").setUnlocalizedName("kepler22b_blue_maple_chestplate").setRegistryName("kepler22b_blue_maple_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_blue_maple_leggings = new SPItemArmor(SPItems.kepler22bBlueMapleArmorMaterial, 0, EntityEquipmentSlot.LEGS, "kepler22b_blue_maple_leggings", "stickWood").setUnlocalizedName("kepler22b_blue_maple_leggings").setRegistryName("kepler22b_blue_maple_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_blue_maple_boots = new SPItemArmor(SPItems.kepler22bBlueMapleArmorMaterial, 0, EntityEquipmentSlot.FEET, "kepler22b_blue_maple_boots", "stickWood").setUnlocalizedName("kepler22b_blue_maple_boots").setRegistryName("kepler22b_blue_maple_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_blue_maple = NonNullList.create();
		SPItems.kepler22b_blue_maple.add(0, new ItemStack(SPItems.kepler22b_blue_maple_helmet));
		SPItems.kepler22b_blue_maple.add(1, new ItemStack(SPItems.kepler22b_blue_maple_chestplate));
		SPItems.kepler22b_blue_maple.add(2, new ItemStack(SPItems.kepler22b_blue_maple_leggings));
		SPItems.kepler22b_blue_maple.add(3, new ItemStack(SPItems.kepler22b_blue_maple_boots));
		
		SPItems.kepler22bRedMapleArmorMaterial = EnumHelper.addArmorMaterial("kepler22b_red_maple", SPReference.MOD_ID + ":" +  "kepler22b_red_maple", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.kepler22b_red_maple_helmet = new SPItemArmor(SPItems.kepler22bRedMapleArmorMaterial, 0, EntityEquipmentSlot.HEAD, "kepler22b_red_maple_helmet", "stickWood").setUnlocalizedName("kepler22b_red_maple_helmet").setRegistryName("kepler22b_red_maple_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_red_maple_chestplate = new SPItemArmor(SPItems.kepler22bRedMapleArmorMaterial, 0, EntityEquipmentSlot.CHEST, "kepler22b_red_maple_chestplate", "stickWood").setUnlocalizedName("kepler22b_red_maple_chestplate").setRegistryName("kepler22b_red_maple_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_red_maple_leggings = new SPItemArmor(SPItems.kepler22bRedMapleArmorMaterial, 0, EntityEquipmentSlot.LEGS, "kepler22b_red_maple_leggings", "stickWood").setUnlocalizedName("kepler22b_red_maple_leggings").setRegistryName("kepler22b_red_maple_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_red_maple_boots = new SPItemArmor(SPItems.kepler22bRedMapleArmorMaterial, 0, EntityEquipmentSlot.FEET, "kepler22b_red_maple_boots", "stickWood").setUnlocalizedName("kepler22b_red_maple_boots").setRegistryName("kepler22b_red_maple_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_red_maple = NonNullList.create();
		SPItems.kepler22b_red_maple.add(0, new ItemStack(SPItems.kepler22b_red_maple_helmet));
		SPItems.kepler22b_red_maple.add(1, new ItemStack(SPItems.kepler22b_red_maple_chestplate));
		SPItems.kepler22b_red_maple.add(2, new ItemStack(SPItems.kepler22b_red_maple_leggings));
		SPItems.kepler22b_red_maple.add(3, new ItemStack(SPItems.kepler22b_red_maple_boots));
		
		SPItems.kepler22bPurpleMapleArmorMaterial = EnumHelper.addArmorMaterial("kepler22b_purple_maple", SPReference.MOD_ID + ":" +  "kepler22b_purple_maple", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.kepler22b_purple_maple_helmet = new SPItemArmor(SPItems.kepler22bPurpleMapleArmorMaterial, 0, EntityEquipmentSlot.HEAD, "kepler22b_purple_maple_helmet", "stickWood").setUnlocalizedName("kepler22b_purple_maple_helmet").setRegistryName("kepler22b_purple_maple_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_purple_maple_chestplate = new SPItemArmor(SPItems.kepler22bPurpleMapleArmorMaterial, 0, EntityEquipmentSlot.CHEST, "kepler22b_purple_maple_chestplate", "stickWood").setUnlocalizedName("kepler22b_purple_maple_chestplate").setRegistryName("kepler22b_purple_maple_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_purple_maple_leggings = new SPItemArmor(SPItems.kepler22bPurpleMapleArmorMaterial, 0, EntityEquipmentSlot.LEGS, "kepler22b_purple_maple_leggings", "stickWood").setUnlocalizedName("kepler22b_purple_maple_leggings").setRegistryName("kepler22b_purple_maple_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_purple_maple_boots = new SPItemArmor(SPItems.kepler22bPurpleMapleArmorMaterial, 0, EntityEquipmentSlot.FEET, "kepler22b_purple_maple_boots", "stickWood").setUnlocalizedName("kepler22b_purple_maple_boots").setRegistryName("kepler22b_purple_maple_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_purple_maple = NonNullList.create();
		SPItems.kepler22b_purple_maple.add(0, new ItemStack(SPItems.kepler22b_purple_maple_helmet));
		SPItems.kepler22b_purple_maple.add(1, new ItemStack(SPItems.kepler22b_purple_maple_chestplate));
		SPItems.kepler22b_purple_maple.add(2, new ItemStack(SPItems.kepler22b_purple_maple_leggings));
		SPItems.kepler22b_purple_maple.add(3, new ItemStack(SPItems.kepler22b_purple_maple_boots));
		
		SPItems.kepler22bYellowMapleArmorMaterial = EnumHelper.addArmorMaterial("kepler22b_yellow_maple", SPReference.MOD_ID + ":" +  "kepler22b_yellow_maple", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.kepler22b_yellow_maple_helmet = new SPItemArmor(SPItems.kepler22bYellowMapleArmorMaterial, 0, EntityEquipmentSlot.HEAD, "kepler22b_yellow_maple_helmet", "stickWood").setUnlocalizedName("kepler22b_yellow_maple_helmet").setRegistryName("kepler22b_yellow_maple_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_yellow_maple_chestplate = new SPItemArmor(SPItems.kepler22bYellowMapleArmorMaterial, 0, EntityEquipmentSlot.CHEST, "kepler22b_yellow_maple_chestplate", "stickWood").setUnlocalizedName("kepler22b_yellow_maple_chestplate").setRegistryName("kepler22b_yellow_maple_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_yellow_maple_leggings = new SPItemArmor(SPItems.kepler22bYellowMapleArmorMaterial, 0, EntityEquipmentSlot.LEGS, "kepler22b_yellow_maple_leggings", "stickWood").setUnlocalizedName("kepler22b_yellow_maple_leggings").setRegistryName("kepler22b_yellow_maple_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_yellow_maple_boots = new SPItemArmor(SPItems.kepler22bYellowMapleArmorMaterial, 0, EntityEquipmentSlot.FEET, "kepler22b_yellow_maple_boots", "stickWood").setUnlocalizedName("kepler22b_yellow_maple_boots").setRegistryName("kepler22b_yellow_maple_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_yellow_maple = NonNullList.create();
		SPItems.kepler22b_yellow_maple.add(0, new ItemStack(SPItems.kepler22b_yellow_maple_helmet));
		SPItems.kepler22b_yellow_maple.add(1, new ItemStack(SPItems.kepler22b_yellow_maple_chestplate));
		SPItems.kepler22b_yellow_maple.add(2, new ItemStack(SPItems.kepler22b_yellow_maple_leggings));
		SPItems.kepler22b_yellow_maple.add(3, new ItemStack(SPItems.kepler22b_yellow_maple_boots));
		
		SPItems.kepler22bGreenMapleArmorMaterial = EnumHelper.addArmorMaterial("kepler22b_green_maple", SPReference.MOD_ID + ":" +  "kepler22b_green_maple", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.kepler22b_green_maple_helmet = new SPItemArmor(SPItems.kepler22bGreenMapleArmorMaterial, 0, EntityEquipmentSlot.HEAD, "kepler22b_green_maple_helmet", "stickWood").setUnlocalizedName("kepler22b_green_maple_helmet").setRegistryName("kepler22b_green_maple_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_green_maple_chestplate = new SPItemArmor(SPItems.kepler22bGreenMapleArmorMaterial, 0, EntityEquipmentSlot.CHEST, "kepler22b_green_maple_chestplate", "stickWood").setUnlocalizedName("kepler22b_green_maple_chestplate").setRegistryName("kepler22b_green_maple_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_green_maple_leggings = new SPItemArmor(SPItems.kepler22bGreenMapleArmorMaterial, 0, EntityEquipmentSlot.LEGS, "kepler22b_green_maple_leggings", "stickWood").setUnlocalizedName("kepler22b_green_maple_leggings").setRegistryName("kepler22b_green_maple_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_green_maple_boots = new SPItemArmor(SPItems.kepler22bGreenMapleArmorMaterial, 0, EntityEquipmentSlot.FEET, "kepler22b_green_maple_boots", "stickWood").setUnlocalizedName("kepler22b_green_maple_boots").setRegistryName("kepler22b_green_maple_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_green_maple = NonNullList.create();
		SPItems.kepler22b_green_maple.add(0, new ItemStack(SPItems.kepler22b_green_maple_helmet));
		SPItems.kepler22b_green_maple.add(1, new ItemStack(SPItems.kepler22b_green_maple_chestplate));
		SPItems.kepler22b_green_maple.add(2, new ItemStack(SPItems.kepler22b_green_maple_leggings));
		SPItems.kepler22b_green_maple.add(3, new ItemStack(SPItems.kepler22b_green_maple_boots));
		
		SPItems.kepler22bBrownMapleArmorMaterial = EnumHelper.addArmorMaterial("kepler22b_brown_maple", SPReference.MOD_ID + ":" +  "kepler22b_brown_maple", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.kepler22b_brown_maple_helmet = new SPItemArmor(SPItems.kepler22bBrownMapleArmorMaterial, 0, EntityEquipmentSlot.HEAD, "kepler22b_brown_maple_helmet", "stickWood").setUnlocalizedName("kepler22b_brown_maple_helmet").setRegistryName("kepler22b_brown_maple_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_brown_maple_chestplate = new SPItemArmor(SPItems.kepler22bBrownMapleArmorMaterial, 0, EntityEquipmentSlot.CHEST, "kepler22b_brown_maple_chestplate", "stickWood").setUnlocalizedName("kepler22b_brown_maple_chestplate").setRegistryName("kepler22b_brown_maple_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_brown_maple_leggings = new SPItemArmor(SPItems.kepler22bBrownMapleArmorMaterial, 0, EntityEquipmentSlot.LEGS, "kepler22b_brown_maple_leggings", "stickWood").setUnlocalizedName("kepler22b_brown_maple_leggings").setRegistryName("kepler22b_brown_maple_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_brown_maple_boots = new SPItemArmor(SPItems.kepler22bBrownMapleArmorMaterial, 0, EntityEquipmentSlot.FEET, "kepler22b_brown_maple_boots", "stickWood").setUnlocalizedName("kepler22b_brown_maple_boots").setRegistryName("kepler22b_brown_maple_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.kepler22b_brown_maple = NonNullList.create();
		SPItems.kepler22b_brown_maple.add(0, new ItemStack(SPItems.kepler22b_brown_maple_helmet));
		SPItems.kepler22b_brown_maple.add(1, new ItemStack(SPItems.kepler22b_brown_maple_chestplate));
		SPItems.kepler22b_brown_maple.add(2, new ItemStack(SPItems.kepler22b_brown_maple_leggings));
		SPItems.kepler22b_brown_maple.add(3, new ItemStack(SPItems.kepler22b_brown_maple_boots));
	}
	
	public static void register()
	{
		SurvivalPlusArmor.registerItem(SPItems.kepler22b_blue_maple);
		SurvivalPlusArmor.registerItem(SPItems.kepler22b_red_maple);
		SurvivalPlusArmor.registerItem(SPItems.kepler22b_purple_maple);
		SurvivalPlusArmor.registerItem(SPItems.kepler22b_yellow_maple);
		SurvivalPlusArmor.registerItem(SPItems.kepler22b_green_maple);
		SurvivalPlusArmor.registerItem(SPItems.kepler22b_brown_maple);
		
	}
	
	public static void registerRenders()
	{
		SurvivalPlusArmor.registerRender(SPItems.kepler22b_blue_maple);
		SurvivalPlusArmor.registerRender(SPItems.kepler22b_red_maple);
		SurvivalPlusArmor.registerRender(SPItems.kepler22b_purple_maple);
		SurvivalPlusArmor.registerRender(SPItems.kepler22b_yellow_maple);
		SurvivalPlusArmor.registerRender(SPItems.kepler22b_green_maple);
		SurvivalPlusArmor.registerRender(SPItems.kepler22b_brown_maple);
	}

}
