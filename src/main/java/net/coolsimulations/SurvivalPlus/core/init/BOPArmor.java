package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BOPArmor {
	
	public static void init(){
		
		SPItems.cherryArmorMaterial = EnumHelper.addArmorMaterial("cherry", SPReference.MOD_ID + ":" +  "cherry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.cherry_helmet = new SPItemArmor(SPItems.cherryArmorMaterial, 0, EntityEquipmentSlot.HEAD, "cherry_helmet", "stickWood").setUnlocalizedName("cherry_helmet").setRegistryName("cherry_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.cherry_chestplate = new SPItemArmor(SPItems.cherryArmorMaterial, 0, EntityEquipmentSlot.CHEST, "cherry_chestplate", "stickWood").setUnlocalizedName("cherry_chestplate").setRegistryName("cherry_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.cherry_leggings = new SPItemArmor(SPItems.cherryArmorMaterial, 0, EntityEquipmentSlot.LEGS, "cherry_leggings", "stickWood").setUnlocalizedName("cherry_leggings").setRegistryName("cherry_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.cherry_boots = new SPItemArmor(SPItems.cherryArmorMaterial, 0, EntityEquipmentSlot.FEET, "cherry_boots", "stickWood").setUnlocalizedName("cherry_boots").setRegistryName("cherry_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.deadArmorMaterial = EnumHelper.addArmorMaterial("dead", SPReference.MOD_ID + ":" +  "dead", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.dead_helmet = new SPItemArmor(SPItems.deadArmorMaterial, 0, EntityEquipmentSlot.HEAD, "dead_helmet", "stickWood").setUnlocalizedName("dead_helmet").setRegistryName("dead_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.dead_chestplate = new SPItemArmor(SPItems.deadArmorMaterial, 0, EntityEquipmentSlot.CHEST, "dead_chestplate", "stickWood").setUnlocalizedName("dead_chestplate").setRegistryName("dead_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.dead_leggings = new SPItemArmor(SPItems.deadArmorMaterial, 0, EntityEquipmentSlot.LEGS, "dead_leggings", "stickWood").setUnlocalizedName("dead_leggings").setRegistryName("dead_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.dead_boots = new SPItemArmor(SPItems.deadArmorMaterial, 0, EntityEquipmentSlot.FEET, "dead_boots", "stickWood").setUnlocalizedName("dead_boots").setRegistryName("dead_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.ebonyArmorMaterial = EnumHelper.addArmorMaterial("ebony", SPReference.MOD_ID + ":" +  "ebony", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.ebony_helmet = new SPItemArmor(SPItems.ebonyArmorMaterial, 0, EntityEquipmentSlot.HEAD, "ebony_helmet", "stickWood").setUnlocalizedName("ebony_helmet").setRegistryName("ebony_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.ebony_chestplate = new SPItemArmor(SPItems.ebonyArmorMaterial, 0, EntityEquipmentSlot.CHEST, "ebony_chestplate", "stickWood").setUnlocalizedName("ebony_chestplate").setRegistryName("ebony_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.ebony_leggings = new SPItemArmor(SPItems.ebonyArmorMaterial, 0, EntityEquipmentSlot.LEGS, "ebony_leggings", "stickWood").setUnlocalizedName("ebony_leggings").setRegistryName("ebony_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.ebony_boots = new SPItemArmor(SPItems.ebonyArmorMaterial, 0, EntityEquipmentSlot.FEET, "ebony_boots", "stickWood").setUnlocalizedName("ebony_boots").setRegistryName("ebony_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.etherealArmorMaterial = EnumHelper.addArmorMaterial("ethereal", SPReference.MOD_ID + ":" +  "ethereal", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.ethereal_helmet = new SPItemArmor(SPItems.etherealArmorMaterial, 0, EntityEquipmentSlot.HEAD, "ethereal_helmet", "stickWood").setUnlocalizedName("ethereal_helmet").setRegistryName("ethereal_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.ethereal_chestplate = new SPItemArmor(SPItems.etherealArmorMaterial, 0, EntityEquipmentSlot.CHEST, "ethereal_chestplate", "stickWood").setUnlocalizedName("ethereal_chestplate").setRegistryName("ethereal_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.ethereal_leggings = new SPItemArmor(SPItems.etherealArmorMaterial, 0, EntityEquipmentSlot.LEGS, "ethereal_leggings", "stickWood").setUnlocalizedName("ethereal_leggings").setRegistryName("ethereal_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.ethereal_boots = new SPItemArmor(SPItems.etherealArmorMaterial, 0, EntityEquipmentSlot.FEET, "ethereal_boots", "stickWood").setUnlocalizedName("ethereal_boots").setRegistryName("ethereal_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.eucalyptusArmorMaterial = EnumHelper.addArmorMaterial("eucalyptus", SPReference.MOD_ID + ":" +  "eucalyptus", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.eucalyptus_helmet = new SPItemArmor(SPItems.eucalyptusArmorMaterial, 0, EntityEquipmentSlot.HEAD, "eucalyptus_helmet", "stickWood").setUnlocalizedName("eucalyptus_helmet").setRegistryName("eucalyptus_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.eucalyptus_chestplate = new SPItemArmor(SPItems.eucalyptusArmorMaterial, 0, EntityEquipmentSlot.CHEST, "eucalyptus_chestplate", "stickWood").setUnlocalizedName("eucalyptus_chestplate").setRegistryName("eucalyptus_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.eucalyptus_leggings = new SPItemArmor(SPItems.eucalyptusArmorMaterial, 0, EntityEquipmentSlot.LEGS, "eucalyptus_leggings", "stickWood").setUnlocalizedName("eucalyptus_leggings").setRegistryName("eucalyptus_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.eucalyptus_boots = new SPItemArmor(SPItems.eucalyptusArmorMaterial, 0, EntityEquipmentSlot.FEET, "eucalyptus_boots", "stickWood").setUnlocalizedName("eucalyptus_boots").setRegistryName("eucalyptus_boots").setCreativeTab(SurvivalPlus.tabCombat);

		SPItems.firArmorMaterial = EnumHelper.addArmorMaterial("fir", SPReference.MOD_ID + ":" +  "fir", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.fir_helmet = new SPItemArmor(SPItems.firArmorMaterial, 0, EntityEquipmentSlot.HEAD, "fir_helmet", "stickWood").setUnlocalizedName("fir_helmet").setRegistryName("fir_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.fir_chestplate = new SPItemArmor(SPItems.firArmorMaterial, 0, EntityEquipmentSlot.CHEST, "fir_chestplate", "stickWood").setUnlocalizedName("fir_chestplate").setRegistryName("fir_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.fir_leggings = new SPItemArmor(SPItems.firArmorMaterial, 0, EntityEquipmentSlot.LEGS, "fir_leggings", "stickWood").setUnlocalizedName("fir_leggings").setRegistryName("fir_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.fir_boots = new SPItemArmor(SPItems.firArmorMaterial, 0, EntityEquipmentSlot.FEET, "fir_boots", "stickWood").setUnlocalizedName("fir_boots").setRegistryName("fir_boots").setCreativeTab(SurvivalPlus.tabCombat);

		SPItems.hellbarkArmorMaterial = EnumHelper.addArmorMaterial("hellbark", SPReference.MOD_ID + ":" +  "hellbark", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.hellbark_helmet = new SPItemArmor(SPItems.hellbarkArmorMaterial, 0, EntityEquipmentSlot.HEAD, "hellbark_helmet", "stickWood").setUnlocalizedName("hellbark_helmet").setRegistryName("hellbark_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.hellbark_chestplate = new SPItemArmor(SPItems.hellbarkArmorMaterial, 0, EntityEquipmentSlot.CHEST, "hellbark_chestplate", "stickWood").setUnlocalizedName("hellbark_chestplate").setRegistryName("hellbark_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.hellbark_leggings = new SPItemArmor(SPItems.hellbarkArmorMaterial, 0, EntityEquipmentSlot.LEGS, "hellbark_leggings", "stickWood").setUnlocalizedName("hellbark_leggings").setRegistryName("hellbark_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.hellbark_boots = new SPItemArmor(SPItems.hellbarkArmorMaterial, 0, EntityEquipmentSlot.FEET, "hellbark_boots", "stickWood").setUnlocalizedName("hellbark_boots").setRegistryName("hellbark_boots").setCreativeTab(SurvivalPlus.tabCombat);

		SPItems.jacarandaArmorMaterial = EnumHelper.addArmorMaterial("jacaranda", SPReference.MOD_ID + ":" +  "jacaranda", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.jacaranda_helmet = new SPItemArmor(SPItems.jacarandaArmorMaterial, 0, EntityEquipmentSlot.HEAD, "jacaranda_helmet", "stickWood").setUnlocalizedName("jacaranda_helmet").setRegistryName("jacaranda_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.jacaranda_chestplate = new SPItemArmor(SPItems.jacarandaArmorMaterial, 0, EntityEquipmentSlot.CHEST, "jacaranda_chestplate", "stickWood").setUnlocalizedName("jacaranda_chestplate").setRegistryName("jacaranda_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.jacaranda_leggings = new SPItemArmor(SPItems.jacarandaArmorMaterial, 0, EntityEquipmentSlot.LEGS, "jacaranda_leggings", "stickWood").setUnlocalizedName("jacaranda_leggings").setRegistryName("jacaranda_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.jacaranda_boots = new SPItemArmor(SPItems.jacarandaArmorMaterial, 0, EntityEquipmentSlot.FEET, "jacaranda_boots", "stickWood").setUnlocalizedName("jacaranda_boots").setRegistryName("jacaranda_boots").setCreativeTab(SurvivalPlus.tabCombat);

		SPItems.magicArmorMaterial = EnumHelper.addArmorMaterial("magic", SPReference.MOD_ID + ":" +  "magic", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.magic_helmet = new SPItemArmor(SPItems.magicArmorMaterial, 0, EntityEquipmentSlot.HEAD, "magic_helmet", "stickWood").setUnlocalizedName("magic_helmet").setRegistryName("magic_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.magic_chestplate = new SPItemArmor(SPItems.magicArmorMaterial, 0, EntityEquipmentSlot.CHEST, "magic_chestplate", "stickWood").setUnlocalizedName("magic_chestplate").setRegistryName("magic_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.magic_leggings = new SPItemArmor(SPItems.magicArmorMaterial, 0, EntityEquipmentSlot.LEGS, "magic_leggings", "stickWood").setUnlocalizedName("magic_leggings").setRegistryName("magic_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.magic_boots = new SPItemArmor(SPItems.magicArmorMaterial, 0, EntityEquipmentSlot.FEET, "magic_boots", "stickWood").setUnlocalizedName("magic_boots").setRegistryName("magic_boots").setCreativeTab(SurvivalPlus.tabCombat);

		SPItems.mahoganyArmorMaterial = EnumHelper.addArmorMaterial("mahogany", SPReference.MOD_ID + ":" +  "mahogany", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.mahogany_helmet = new SPItemArmor(SPItems.mahoganyArmorMaterial, 0, EntityEquipmentSlot.HEAD, "mahogany_helmet", "stickWood").setUnlocalizedName("mahogany_helmet").setRegistryName("mahogany_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.mahogany_chestplate = new SPItemArmor(SPItems.mahoganyArmorMaterial, 0, EntityEquipmentSlot.CHEST, "mahogany_chestplate", "stickWood").setUnlocalizedName("mahogany_chestplate").setRegistryName("mahogany_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.mahogany_leggings = new SPItemArmor(SPItems.mahoganyArmorMaterial, 0, EntityEquipmentSlot.LEGS, "mahogany_leggings", "stickWood").setUnlocalizedName("mahogany_leggings").setRegistryName("mahogany_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.mahogany_boots = new SPItemArmor(SPItems.mahoganyArmorMaterial, 0, EntityEquipmentSlot.FEET, "mahogany_boots", "stickWood").setUnlocalizedName("mahogany_boots").setRegistryName("mahogany_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.mangroveArmorMaterial = EnumHelper.addArmorMaterial("mangrove", SPReference.MOD_ID + ":" +  "mangrove", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.mangrove_helmet = new SPItemArmor(SPItems.mangroveArmorMaterial, 0, EntityEquipmentSlot.HEAD, "mangrove_helmet", "stickWood").setUnlocalizedName("mangrove_helmet").setRegistryName("mangrove_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.mangrove_chestplate = new SPItemArmor(SPItems.mangroveArmorMaterial, 0, EntityEquipmentSlot.CHEST, "mangrove_chestplate", "stickWood").setUnlocalizedName("mangrove_chestplate").setRegistryName("mangrove_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.mangrove_leggings = new SPItemArmor(SPItems.mangroveArmorMaterial, 0, EntityEquipmentSlot.LEGS, "mangrove_leggings", "stickWood").setUnlocalizedName("mangrove_leggings").setRegistryName("mangrove_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.mangrove_boots = new SPItemArmor(SPItems.mangroveArmorMaterial, 0, EntityEquipmentSlot.FEET, "mangrove_boots", "stickWood").setUnlocalizedName("mangrove_boots").setRegistryName("mangrove_boots").setCreativeTab(SurvivalPlus.tabCombat);

		SPItems.palmArmorMaterial = EnumHelper.addArmorMaterial("palm", SPReference.MOD_ID + ":" +  "palm", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.palm_helmet = new SPItemArmor(SPItems.palmArmorMaterial, 0, EntityEquipmentSlot.HEAD, "palm_helmet", "stickWood").setUnlocalizedName("palm_helmet").setRegistryName("palm_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.palm_chestplate = new SPItemArmor(SPItems.palmArmorMaterial, 0, EntityEquipmentSlot.CHEST, "palm_chestplate", "stickWood").setUnlocalizedName("palm_chestplate").setRegistryName("palm_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.palm_leggings = new SPItemArmor(SPItems.palmArmorMaterial, 0, EntityEquipmentSlot.LEGS, "palm_leggings", "stickWood").setUnlocalizedName("palm_leggings").setRegistryName("palm_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.palm_boots = new SPItemArmor(SPItems.palmArmorMaterial, 0, EntityEquipmentSlot.FEET, "palm_boots", "stickWood").setUnlocalizedName("palm_boots").setRegistryName("palm_boots").setCreativeTab(SurvivalPlus.tabCombat);

		SPItems.pineArmorMaterial = EnumHelper.addArmorMaterial("pine", SPReference.MOD_ID + ":" +  "pine", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.pine_helmet = new SPItemArmor(SPItems.pineArmorMaterial, 0, EntityEquipmentSlot.HEAD, "pine_helmet", "stickWood").setUnlocalizedName("pine_helmet").setRegistryName("pine_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.pine_chestplate = new SPItemArmor(SPItems.pineArmorMaterial, 0, EntityEquipmentSlot.CHEST, "pine_chestplate", "stickWood").setUnlocalizedName("pine_chestplate").setRegistryName("pine_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.pine_leggings = new SPItemArmor(SPItems.pineArmorMaterial, 0, EntityEquipmentSlot.LEGS, "pine_leggings", "stickWood").setUnlocalizedName("pine_leggings").setRegistryName("pine_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.pine_boots = new SPItemArmor(SPItems.pineArmorMaterial, 0, EntityEquipmentSlot.FEET, "pine_boots", "stickWood").setUnlocalizedName("pine_boots").setRegistryName("pine_boots").setCreativeTab(SurvivalPlus.tabCombat);

		SPItems.redwoodArmorMaterial = EnumHelper.addArmorMaterial("redwood", SPReference.MOD_ID + ":" +  "redwood", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.redwood_helmet = new SPItemArmor(SPItems.redwoodArmorMaterial, 0, EntityEquipmentSlot.HEAD, "redwood_helmet", "stickWood").setUnlocalizedName("redwood_helmet").setRegistryName("redwood_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.redwood_chestplate = new SPItemArmor(SPItems.redwoodArmorMaterial, 0, EntityEquipmentSlot.CHEST, "redwood_chestplate", "stickWood").setUnlocalizedName("redwood_chestplate").setRegistryName("redwood_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.redwood_leggings = new SPItemArmor(SPItems.redwoodArmorMaterial, 0, EntityEquipmentSlot.LEGS, "redwood_leggings", "stickWood").setUnlocalizedName("redwood_leggings").setRegistryName("redwood_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.redwood_boots = new SPItemArmor(SPItems.redwoodArmorMaterial, 0, EntityEquipmentSlot.FEET, "redwood_boots", "stickWood").setUnlocalizedName("redwood_boots").setRegistryName("redwood_boots").setCreativeTab(SurvivalPlus.tabCombat);

		SPItems.sacredOakArmorMaterial = EnumHelper.addArmorMaterial("sacred_oak", SPReference.MOD_ID + ":" +  "sacred_oak", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.sacred_oak_helmet = new SPItemArmor(SPItems.sacredOakArmorMaterial, 0, EntityEquipmentSlot.HEAD, "sacred_oak_helmet", "stickWood").setUnlocalizedName("sacred_oak_helmet").setRegistryName("sacred_oak_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.sacred_oak_chestplate = new SPItemArmor(SPItems.sacredOakArmorMaterial, 0, EntityEquipmentSlot.CHEST, "sacred_oak_chestplate", "stickWood").setUnlocalizedName("sacred_oak_chestplate").setRegistryName("sacred_oak_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.sacred_oak_leggings = new SPItemArmor(SPItems.sacredOakArmorMaterial, 0, EntityEquipmentSlot.LEGS, "sacred_oak_leggings", "stickWood").setUnlocalizedName("sacred_oak_leggings").setRegistryName("sacred_oak_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.sacred_oak_boots = new SPItemArmor(SPItems.sacredOakArmorMaterial, 0, EntityEquipmentSlot.FEET, "sacred_oak_boots", "stickWood").setUnlocalizedName("sacred_oak_boots").setRegistryName("sacred_oak_boots").setCreativeTab(SurvivalPlus.tabCombat);

		SPItems.umbranArmorMaterial = EnumHelper.addArmorMaterial("umbran", SPReference.MOD_ID + ":" +  "umbran", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.umbran_helmet = new SPItemArmor(SPItems.umbranArmorMaterial, 0, EntityEquipmentSlot.HEAD, "umbran_helmet", "stickWood").setUnlocalizedName("umbran_helmet").setRegistryName("umbran_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.umbran_chestplate = new SPItemArmor(SPItems.umbranArmorMaterial, 0, EntityEquipmentSlot.CHEST, "umbran_chestplate", "stickWood").setUnlocalizedName("umbran_chestplate").setRegistryName("umbran_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.umbran_leggings = new SPItemArmor(SPItems.umbranArmorMaterial, 0, EntityEquipmentSlot.LEGS, "umbran_leggings", "stickWood").setUnlocalizedName("umbran_leggings").setRegistryName("umbran_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.umbran_boots = new SPItemArmor(SPItems.umbranArmorMaterial, 0, EntityEquipmentSlot.FEET, "umbran_boots", "stickWood").setUnlocalizedName("umbran_boots").setRegistryName("umbran_boots").setCreativeTab(SurvivalPlus.tabCombat);

		SPItems.willowArmorMaterial = EnumHelper.addArmorMaterial("willow", SPReference.MOD_ID + ":" +  "willow", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.willow_helmet = new SPItemArmor(SPItems.umbranArmorMaterial, 0, EntityEquipmentSlot.HEAD, "willow_helmet", "stickWood").setUnlocalizedName("willow_helmet").setRegistryName("willow_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.willow_chestplate = new SPItemArmor(SPItems.umbranArmorMaterial, 0, EntityEquipmentSlot.CHEST, "willow_chestplate", "stickWood").setUnlocalizedName("willow_chestplate").setRegistryName("willow_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.willow_leggings = new SPItemArmor(SPItems.umbranArmorMaterial, 0, EntityEquipmentSlot.LEGS, "willow_leggings", "stickWood").setUnlocalizedName("willow_leggings").setRegistryName("willow_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.willow_boots = new SPItemArmor(SPItems.umbranArmorMaterial, 0, EntityEquipmentSlot.FEET, "willow_boots", "stickWood").setUnlocalizedName("willow_boots").setRegistryName("willow_boots").setCreativeTab(SurvivalPlus.tabCombat);
	}
	
	public static void register()
	{
		SurvivalPlusArmor.registerItem(SPItems.cherry_helmet);
		SurvivalPlusArmor.registerItem(SPItems.cherry_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.cherry_leggings);
		SurvivalPlusArmor.registerItem(SPItems.cherry_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.dead_helmet);
		SurvivalPlusArmor.registerItem(SPItems.dead_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.dead_leggings);
		SurvivalPlusArmor.registerItem(SPItems.dead_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.ebony_helmet);
		SurvivalPlusArmor.registerItem(SPItems.ebony_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.ebony_leggings);
		SurvivalPlusArmor.registerItem(SPItems.ebony_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.ethereal_helmet);
		SurvivalPlusArmor.registerItem(SPItems.ethereal_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.ethereal_leggings);
		SurvivalPlusArmor.registerItem(SPItems.ethereal_boots);

		SurvivalPlusArmor.registerItem(SPItems.eucalyptus_helmet);
		SurvivalPlusArmor.registerItem(SPItems.eucalyptus_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.eucalyptus_leggings);
		SurvivalPlusArmor.registerItem(SPItems.eucalyptus_boots);

		SurvivalPlusArmor.registerItem(SPItems.fir_helmet);
		SurvivalPlusArmor.registerItem(SPItems.fir_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.fir_leggings);
		SurvivalPlusArmor.registerItem(SPItems.fir_boots);

		SurvivalPlusArmor.registerItem(SPItems.hellbark_helmet);
		SurvivalPlusArmor.registerItem(SPItems.hellbark_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.hellbark_leggings);
		SurvivalPlusArmor.registerItem(SPItems.hellbark_boots);

		SurvivalPlusArmor.registerItem(SPItems.jacaranda_helmet);
		SurvivalPlusArmor.registerItem(SPItems.jacaranda_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.jacaranda_leggings);
		SurvivalPlusArmor.registerItem(SPItems.jacaranda_boots);

		SurvivalPlusArmor.registerItem(SPItems.magic_helmet);
		SurvivalPlusArmor.registerItem(SPItems.magic_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.magic_leggings);
		SurvivalPlusArmor.registerItem(SPItems.magic_boots);

		SurvivalPlusArmor.registerItem(SPItems.mahogany_helmet);
		SurvivalPlusArmor.registerItem(SPItems.mahogany_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.mahogany_leggings);
		SurvivalPlusArmor.registerItem(SPItems.mahogany_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.mangrove_helmet);
		SurvivalPlusArmor.registerItem(SPItems.mangrove_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.mangrove_leggings);
		SurvivalPlusArmor.registerItem(SPItems.mangrove_boots);

		SurvivalPlusArmor.registerItem(SPItems.palm_helmet);
		SurvivalPlusArmor.registerItem(SPItems.palm_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.palm_leggings);
		SurvivalPlusArmor.registerItem(SPItems.palm_boots);

		SurvivalPlusArmor.registerItem(SPItems.pine_helmet);
		SurvivalPlusArmor.registerItem(SPItems.pine_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.pine_leggings);
		SurvivalPlusArmor.registerItem(SPItems.pine_boots);

		SurvivalPlusArmor.registerItem(SPItems.redwood_helmet);
		SurvivalPlusArmor.registerItem(SPItems.redwood_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.redwood_leggings);
		SurvivalPlusArmor.registerItem(SPItems.redwood_boots);

		SurvivalPlusArmor.registerItem(SPItems.sacred_oak_helmet);
		SurvivalPlusArmor.registerItem(SPItems.sacred_oak_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.sacred_oak_leggings);
		SurvivalPlusArmor.registerItem(SPItems.sacred_oak_boots);

		SurvivalPlusArmor.registerItem(SPItems.umbran_helmet);
		SurvivalPlusArmor.registerItem(SPItems.umbran_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.umbran_leggings);
		SurvivalPlusArmor.registerItem(SPItems.umbran_boots);

		SurvivalPlusArmor.registerItem(SPItems.willow_helmet);
		SurvivalPlusArmor.registerItem(SPItems.willow_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.willow_leggings);
		SurvivalPlusArmor.registerItem(SPItems.willow_boots);
	}
	
	public static void registerRenders()
	{
		SurvivalPlusArmor.registerRender(SPItems.cherry_helmet);
		SurvivalPlusArmor.registerRender(SPItems.cherry_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.cherry_leggings);
		SurvivalPlusArmor.registerRender(SPItems.cherry_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.dead_helmet);
		SurvivalPlusArmor.registerRender(SPItems.dead_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.dead_leggings);
		SurvivalPlusArmor.registerRender(SPItems.dead_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.ebony_helmet);
		SurvivalPlusArmor.registerRender(SPItems.ebony_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.ebony_leggings);
		SurvivalPlusArmor.registerRender(SPItems.ebony_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.ethereal_helmet);
		SurvivalPlusArmor.registerRender(SPItems.ethereal_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.ethereal_leggings);
		SurvivalPlusArmor.registerRender(SPItems.ethereal_boots);

		SurvivalPlusArmor.registerRender(SPItems.eucalyptus_helmet);
		SurvivalPlusArmor.registerRender(SPItems.eucalyptus_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.eucalyptus_leggings);
		SurvivalPlusArmor.registerRender(SPItems.eucalyptus_boots);

		SurvivalPlusArmor.registerRender(SPItems.fir_helmet);
		SurvivalPlusArmor.registerRender(SPItems.fir_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.fir_leggings);
		SurvivalPlusArmor.registerRender(SPItems.fir_boots);

		SurvivalPlusArmor.registerRender(SPItems.hellbark_helmet);
		SurvivalPlusArmor.registerRender(SPItems.hellbark_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.hellbark_leggings);
		SurvivalPlusArmor.registerRender(SPItems.hellbark_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.jacaranda_helmet);
		SurvivalPlusArmor.registerRender(SPItems.jacaranda_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.jacaranda_leggings);
		SurvivalPlusArmor.registerRender(SPItems.jacaranda_boots);

		SurvivalPlusArmor.registerRender(SPItems.magic_helmet);
		SurvivalPlusArmor.registerRender(SPItems.magic_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.magic_leggings);
		SurvivalPlusArmor.registerRender(SPItems.magic_boots);

		SurvivalPlusArmor.registerRender(SPItems.mahogany_helmet);
		SurvivalPlusArmor.registerRender(SPItems.mahogany_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.mahogany_leggings);
		SurvivalPlusArmor.registerRender(SPItems.mahogany_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.mangrove_helmet);
		SurvivalPlusArmor.registerRender(SPItems.mangrove_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.mangrove_leggings);
		SurvivalPlusArmor.registerRender(SPItems.mangrove_boots);

		SurvivalPlusArmor.registerRender(SPItems.palm_helmet);
		SurvivalPlusArmor.registerRender(SPItems.palm_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.palm_leggings);
		SurvivalPlusArmor.registerRender(SPItems.palm_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.pine_helmet);
		SurvivalPlusArmor.registerRender(SPItems.pine_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.pine_leggings);
		SurvivalPlusArmor.registerRender(SPItems.pine_boots);

		SurvivalPlusArmor.registerRender(SPItems.redwood_helmet);
		SurvivalPlusArmor.registerRender(SPItems.redwood_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.redwood_leggings);
		SurvivalPlusArmor.registerRender(SPItems.redwood_boots);

		SurvivalPlusArmor.registerRender(SPItems.sacred_oak_helmet);
		SurvivalPlusArmor.registerRender(SPItems.sacred_oak_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.sacred_oak_leggings);
		SurvivalPlusArmor.registerRender(SPItems.sacred_oak_boots);

		SurvivalPlusArmor.registerRender(SPItems.umbran_helmet);
		SurvivalPlusArmor.registerRender(SPItems.umbran_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.umbran_leggings);
		SurvivalPlusArmor.registerRender(SPItems.umbran_boots);

		SurvivalPlusArmor.registerRender(SPItems.willow_helmet);
		SurvivalPlusArmor.registerRender(SPItems.willow_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.willow_leggings);
		SurvivalPlusArmor.registerRender(SPItems.willow_boots);
	}

}
