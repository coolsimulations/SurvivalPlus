package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.google.common.collect.Lists;

public class BOPArmor {
	
	public static void init(){
		
		SPItems.cherryArmorMaterial = EnumHelper.addArmorMaterial("cherry", SPReference.MOD_ID + ":" +  "cherry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.cherry_helmet = new SPItemArmor(SPItems.cherryArmorMaterial, 0, EntityEquipmentSlot.HEAD, "cherry_helmet", "stickWood").setUnlocalizedName("cherry_helmet").setRegistryName("cherry_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.cherry_chestplate = new SPItemArmor(SPItems.cherryArmorMaterial, 0, EntityEquipmentSlot.CHEST, "cherry_chestplate", "stickWood").setUnlocalizedName("cherry_chestplate").setRegistryName("cherry_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.cherry_leggings = new SPItemArmor(SPItems.cherryArmorMaterial, 0, EntityEquipmentSlot.LEGS, "cherry_leggings", "stickWood").setUnlocalizedName("cherry_leggings").setRegistryName("cherry_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.cherry_boots = new SPItemArmor(SPItems.cherryArmorMaterial, 0, EntityEquipmentSlot.FEET, "cherry_boots", "stickWood").setUnlocalizedName("cherry_boots").setRegistryName("cherry_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.cherry = Lists.newArrayList();
		SPItems.cherry.add(0, new ItemStack(SPItems.cherry_helmet));
		SPItems.cherry.add(1, new ItemStack(SPItems.cherry_chestplate));
		SPItems.cherry.add(2, new ItemStack(SPItems.cherry_leggings));
		SPItems.cherry.add(3, new ItemStack(SPItems.cherry_boots));
		
		SPItems.deadArmorMaterial = EnumHelper.addArmorMaterial("dead", SPReference.MOD_ID + ":" +  "dead", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.dead_helmet = new SPItemArmor(SPItems.deadArmorMaterial, 0, EntityEquipmentSlot.HEAD, "dead_helmet", "stickWood").setUnlocalizedName("dead_helmet").setRegistryName("dead_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.dead_chestplate = new SPItemArmor(SPItems.deadArmorMaterial, 0, EntityEquipmentSlot.CHEST, "dead_chestplate", "stickWood").setUnlocalizedName("dead_chestplate").setRegistryName("dead_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.dead_leggings = new SPItemArmor(SPItems.deadArmorMaterial, 0, EntityEquipmentSlot.LEGS, "dead_leggings", "stickWood").setUnlocalizedName("dead_leggings").setRegistryName("dead_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.dead_boots = new SPItemArmor(SPItems.deadArmorMaterial, 0, EntityEquipmentSlot.FEET, "dead_boots", "stickWood").setUnlocalizedName("dead_boots").setRegistryName("dead_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.dead = Lists.newArrayList();
		SPItems.dead.add(0, new ItemStack(SPItems.dead_helmet));
		SPItems.dead.add(1, new ItemStack(SPItems.dead_chestplate));
		SPItems.dead.add(2, new ItemStack(SPItems.dead_leggings));
		SPItems.dead.add(3, new ItemStack(SPItems.dead_boots));
		
		SPItems.ebonyArmorMaterial = EnumHelper.addArmorMaterial("ebony", SPReference.MOD_ID + ":" +  "ebony", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.ebony_helmet = new SPItemArmor(SPItems.ebonyArmorMaterial, 0, EntityEquipmentSlot.HEAD, "ebony_helmet", "stickWood").setUnlocalizedName("ebony_helmet").setRegistryName("ebony_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.ebony_chestplate = new SPItemArmor(SPItems.ebonyArmorMaterial, 0, EntityEquipmentSlot.CHEST, "ebony_chestplate", "stickWood").setUnlocalizedName("ebony_chestplate").setRegistryName("ebony_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.ebony_leggings = new SPItemArmor(SPItems.ebonyArmorMaterial, 0, EntityEquipmentSlot.LEGS, "ebony_leggings", "stickWood").setUnlocalizedName("ebony_leggings").setRegistryName("ebony_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.ebony_boots = new SPItemArmor(SPItems.ebonyArmorMaterial, 0, EntityEquipmentSlot.FEET, "ebony_boots", "stickWood").setUnlocalizedName("ebony_boots").setRegistryName("ebony_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.ebony = Lists.newArrayList();
		SPItems.ebony.add(0, new ItemStack(SPItems.ebony_helmet));
		SPItems.ebony.add(1, new ItemStack(SPItems.ebony_chestplate));
		SPItems.ebony.add(2, new ItemStack(SPItems.ebony_leggings));
		SPItems.ebony.add(3, new ItemStack(SPItems.ebony_boots));
		
		SPItems.etherealArmorMaterial = EnumHelper.addArmorMaterial("ethereal", SPReference.MOD_ID + ":" +  "ethereal", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.ethereal_helmet = new SPItemArmor(SPItems.etherealArmorMaterial, 0, EntityEquipmentSlot.HEAD, "ethereal_helmet", "stickWood").setUnlocalizedName("ethereal_helmet").setRegistryName("ethereal_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.ethereal_chestplate = new SPItemArmor(SPItems.etherealArmorMaterial, 0, EntityEquipmentSlot.CHEST, "ethereal_chestplate", "stickWood").setUnlocalizedName("ethereal_chestplate").setRegistryName("ethereal_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.ethereal_leggings = new SPItemArmor(SPItems.etherealArmorMaterial, 0, EntityEquipmentSlot.LEGS, "ethereal_leggings", "stickWood").setUnlocalizedName("ethereal_leggings").setRegistryName("ethereal_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.ethereal_boots = new SPItemArmor(SPItems.etherealArmorMaterial, 0, EntityEquipmentSlot.FEET, "ethereal_boots", "stickWood").setUnlocalizedName("ethereal_boots").setRegistryName("ethereal_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.ethereal = Lists.newArrayList();
		SPItems.ethereal.add(0, new ItemStack(SPItems.ethereal_helmet));
		SPItems.ethereal.add(1, new ItemStack(SPItems.ethereal_chestplate));
		SPItems.ethereal.add(2, new ItemStack(SPItems.ethereal_leggings));
		SPItems.ethereal.add(3, new ItemStack(SPItems.ethereal_boots));
		
		SPItems.eucalyptusArmorMaterial = EnumHelper.addArmorMaterial("eucalyptus", SPReference.MOD_ID + ":" +  "eucalyptus", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.eucalyptus_helmet = new SPItemArmor(SPItems.eucalyptusArmorMaterial, 0, EntityEquipmentSlot.HEAD, "eucalyptus_helmet", "stickWood").setUnlocalizedName("eucalyptus_helmet").setRegistryName("eucalyptus_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.eucalyptus_chestplate = new SPItemArmor(SPItems.eucalyptusArmorMaterial, 0, EntityEquipmentSlot.CHEST, "eucalyptus_chestplate", "stickWood").setUnlocalizedName("eucalyptus_chestplate").setRegistryName("eucalyptus_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.eucalyptus_leggings = new SPItemArmor(SPItems.eucalyptusArmorMaterial, 0, EntityEquipmentSlot.LEGS, "eucalyptus_leggings", "stickWood").setUnlocalizedName("eucalyptus_leggings").setRegistryName("eucalyptus_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.eucalyptus_boots = new SPItemArmor(SPItems.eucalyptusArmorMaterial, 0, EntityEquipmentSlot.FEET, "eucalyptus_boots", "stickWood").setUnlocalizedName("eucalyptus_boots").setRegistryName("eucalyptus_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.eucalyptus = Lists.newArrayList();
		SPItems.eucalyptus.add(0, new ItemStack(SPItems.eucalyptus_helmet));
		SPItems.eucalyptus.add(1, new ItemStack(SPItems.eucalyptus_chestplate));
		SPItems.eucalyptus.add(2, new ItemStack(SPItems.eucalyptus_leggings));
		SPItems.eucalyptus.add(3, new ItemStack(SPItems.eucalyptus_boots));

		SPItems.firArmorMaterial = EnumHelper.addArmorMaterial("fir", SPReference.MOD_ID + ":" +  "fir", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.fir_helmet = new SPItemArmor(SPItems.firArmorMaterial, 0, EntityEquipmentSlot.HEAD, "fir_helmet", "stickWood").setUnlocalizedName("fir_helmet").setRegistryName("fir_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.fir_chestplate = new SPItemArmor(SPItems.firArmorMaterial, 0, EntityEquipmentSlot.CHEST, "fir_chestplate", "stickWood").setUnlocalizedName("fir_chestplate").setRegistryName("fir_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.fir_leggings = new SPItemArmor(SPItems.firArmorMaterial, 0, EntityEquipmentSlot.LEGS, "fir_leggings", "stickWood").setUnlocalizedName("fir_leggings").setRegistryName("fir_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.fir_boots = new SPItemArmor(SPItems.firArmorMaterial, 0, EntityEquipmentSlot.FEET, "fir_boots", "stickWood").setUnlocalizedName("fir_boots").setRegistryName("fir_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.fir = Lists.newArrayList();
		SPItems.fir.add(0, new ItemStack(SPItems.fir_helmet));
		SPItems.fir.add(1, new ItemStack(SPItems.fir_chestplate));
		SPItems.fir.add(2, new ItemStack(SPItems.fir_leggings));
		SPItems.fir.add(3, new ItemStack(SPItems.fir_boots));

		SPItems.hellbarkArmorMaterial = EnumHelper.addArmorMaterial("hellbark", SPReference.MOD_ID + ":" +  "hellbark", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.hellbark_helmet = new SPItemArmor(SPItems.hellbarkArmorMaterial, 0, EntityEquipmentSlot.HEAD, "hellbark_helmet", "stickWood").setUnlocalizedName("hellbark_helmet").setRegistryName("hellbark_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.hellbark_chestplate = new SPItemArmor(SPItems.hellbarkArmorMaterial, 0, EntityEquipmentSlot.CHEST, "hellbark_chestplate", "stickWood").setUnlocalizedName("hellbark_chestplate").setRegistryName("hellbark_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.hellbark_leggings = new SPItemArmor(SPItems.hellbarkArmorMaterial, 0, EntityEquipmentSlot.LEGS, "hellbark_leggings", "stickWood").setUnlocalizedName("hellbark_leggings").setRegistryName("hellbark_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.hellbark_boots = new SPItemArmor(SPItems.hellbarkArmorMaterial, 0, EntityEquipmentSlot.FEET, "hellbark_boots", "stickWood").setUnlocalizedName("hellbark_boots").setRegistryName("hellbark_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.hellbark = Lists.newArrayList();
		SPItems.hellbark.add(0, new ItemStack(SPItems.hellbark_helmet));
		SPItems.hellbark.add(1, new ItemStack(SPItems.hellbark_chestplate));
		SPItems.hellbark.add(2, new ItemStack(SPItems.hellbark_leggings));
		SPItems.hellbark.add(3, new ItemStack(SPItems.hellbark_boots));

		SPItems.jacarandaArmorMaterial = EnumHelper.addArmorMaterial("jacaranda", SPReference.MOD_ID + ":" +  "jacaranda", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.jacaranda_helmet = new SPItemArmor(SPItems.jacarandaArmorMaterial, 0, EntityEquipmentSlot.HEAD, "jacaranda_helmet", "stickWood").setUnlocalizedName("jacaranda_helmet").setRegistryName("jacaranda_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.jacaranda_chestplate = new SPItemArmor(SPItems.jacarandaArmorMaterial, 0, EntityEquipmentSlot.CHEST, "jacaranda_chestplate", "stickWood").setUnlocalizedName("jacaranda_chestplate").setRegistryName("jacaranda_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.jacaranda_leggings = new SPItemArmor(SPItems.jacarandaArmorMaterial, 0, EntityEquipmentSlot.LEGS, "jacaranda_leggings", "stickWood").setUnlocalizedName("jacaranda_leggings").setRegistryName("jacaranda_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.jacaranda_boots = new SPItemArmor(SPItems.jacarandaArmorMaterial, 0, EntityEquipmentSlot.FEET, "jacaranda_boots", "stickWood").setUnlocalizedName("jacaranda_boots").setRegistryName("jacaranda_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.jacaranda = Lists.newArrayList();
		SPItems.jacaranda.add(0, new ItemStack(SPItems.jacaranda_helmet));
		SPItems.jacaranda.add(1, new ItemStack(SPItems.jacaranda_chestplate));
		SPItems.jacaranda.add(2, new ItemStack(SPItems.jacaranda_leggings));
		SPItems.jacaranda.add(3, new ItemStack(SPItems.jacaranda_boots));

		SPItems.magicArmorMaterial = EnumHelper.addArmorMaterial("magic", SPReference.MOD_ID + ":" +  "magic", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.magic_helmet = new SPItemArmor(SPItems.magicArmorMaterial, 0, EntityEquipmentSlot.HEAD, "magic_helmet", "stickWood").setUnlocalizedName("magic_helmet").setRegistryName("magic_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.magic_chestplate = new SPItemArmor(SPItems.magicArmorMaterial, 0, EntityEquipmentSlot.CHEST, "magic_chestplate", "stickWood").setUnlocalizedName("magic_chestplate").setRegistryName("magic_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.magic_leggings = new SPItemArmor(SPItems.magicArmorMaterial, 0, EntityEquipmentSlot.LEGS, "magic_leggings", "stickWood").setUnlocalizedName("magic_leggings").setRegistryName("magic_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.magic_boots = new SPItemArmor(SPItems.magicArmorMaterial, 0, EntityEquipmentSlot.FEET, "magic_boots", "stickWood").setUnlocalizedName("magic_boots").setRegistryName("magic_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.magic = Lists.newArrayList();
		SPItems.magic.add(0, new ItemStack(SPItems.magic_helmet));
		SPItems.magic.add(1, new ItemStack(SPItems.magic_chestplate));
		SPItems.magic.add(2, new ItemStack(SPItems.magic_leggings));
		SPItems.magic.add(3, new ItemStack(SPItems.magic_boots));

		SPItems.mahoganyArmorMaterial = EnumHelper.addArmorMaterial("mahogany", SPReference.MOD_ID + ":" +  "mahogany", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.mahogany_helmet = new SPItemArmor(SPItems.mahoganyArmorMaterial, 0, EntityEquipmentSlot.HEAD, "mahogany_helmet", "stickWood").setUnlocalizedName("mahogany_helmet").setRegistryName("mahogany_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.mahogany_chestplate = new SPItemArmor(SPItems.mahoganyArmorMaterial, 0, EntityEquipmentSlot.CHEST, "mahogany_chestplate", "stickWood").setUnlocalizedName("mahogany_chestplate").setRegistryName("mahogany_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.mahogany_leggings = new SPItemArmor(SPItems.mahoganyArmorMaterial, 0, EntityEquipmentSlot.LEGS, "mahogany_leggings", "stickWood").setUnlocalizedName("mahogany_leggings").setRegistryName("mahogany_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.mahogany_boots = new SPItemArmor(SPItems.mahoganyArmorMaterial, 0, EntityEquipmentSlot.FEET, "mahogany_boots", "stickWood").setUnlocalizedName("mahogany_boots").setRegistryName("mahogany_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.mahogany = Lists.newArrayList();
		SPItems.mahogany.add(0, new ItemStack(SPItems.mahogany_helmet));
		SPItems.mahogany.add(1, new ItemStack(SPItems.mahogany_chestplate));
		SPItems.mahogany.add(2, new ItemStack(SPItems.mahogany_leggings));
		SPItems.mahogany.add(3, new ItemStack(SPItems.mahogany_boots));
		
		SPItems.mangroveArmorMaterial = EnumHelper.addArmorMaterial("mangrove", SPReference.MOD_ID + ":" +  "mangrove", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.mangrove_helmet = new SPItemArmor(SPItems.mangroveArmorMaterial, 0, EntityEquipmentSlot.HEAD, "mangrove_helmet", "stickWood").setUnlocalizedName("mangrove_helmet").setRegistryName("mangrove_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.mangrove_chestplate = new SPItemArmor(SPItems.mangroveArmorMaterial, 0, EntityEquipmentSlot.CHEST, "mangrove_chestplate", "stickWood").setUnlocalizedName("mangrove_chestplate").setRegistryName("mangrove_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.mangrove_leggings = new SPItemArmor(SPItems.mangroveArmorMaterial, 0, EntityEquipmentSlot.LEGS, "mangrove_leggings", "stickWood").setUnlocalizedName("mangrove_leggings").setRegistryName("mangrove_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.mangrove_boots = new SPItemArmor(SPItems.mangroveArmorMaterial, 0, EntityEquipmentSlot.FEET, "mangrove_boots", "stickWood").setUnlocalizedName("mangrove_boots").setRegistryName("mangrove_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.mangrove = Lists.newArrayList();
		SPItems.mangrove.add(0, new ItemStack(SPItems.mangrove_helmet));
		SPItems.mangrove.add(1, new ItemStack(SPItems.mangrove_chestplate));
		SPItems.mangrove.add(2, new ItemStack(SPItems.mangrove_leggings));
		SPItems.mangrove.add(3, new ItemStack(SPItems.mangrove_boots));

		SPItems.palmArmorMaterial = EnumHelper.addArmorMaterial("palm", SPReference.MOD_ID + ":" +  "palm", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.palm_helmet = new SPItemArmor(SPItems.palmArmorMaterial, 0, EntityEquipmentSlot.HEAD, "palm_helmet", "stickWood").setUnlocalizedName("palm_helmet").setRegistryName("palm_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.palm_chestplate = new SPItemArmor(SPItems.palmArmorMaterial, 0, EntityEquipmentSlot.CHEST, "palm_chestplate", "stickWood").setUnlocalizedName("palm_chestplate").setRegistryName("palm_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.palm_leggings = new SPItemArmor(SPItems.palmArmorMaterial, 0, EntityEquipmentSlot.LEGS, "palm_leggings", "stickWood").setUnlocalizedName("palm_leggings").setRegistryName("palm_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.palm_boots = new SPItemArmor(SPItems.palmArmorMaterial, 0, EntityEquipmentSlot.FEET, "palm_boots", "stickWood").setUnlocalizedName("palm_boots").setRegistryName("palm_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.palm = Lists.newArrayList();
		SPItems.palm.add(0, new ItemStack(SPItems.palm_helmet));
		SPItems.palm.add(1, new ItemStack(SPItems.palm_chestplate));
		SPItems.palm.add(2, new ItemStack(SPItems.palm_leggings));
		SPItems.palm.add(3, new ItemStack(SPItems.palm_boots));

		SPItems.pineArmorMaterial = EnumHelper.addArmorMaterial("pine", SPReference.MOD_ID + ":" +  "pine", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.pine_helmet = new SPItemArmor(SPItems.pineArmorMaterial, 0, EntityEquipmentSlot.HEAD, "pine_helmet", "stickWood").setUnlocalizedName("pine_helmet").setRegistryName("pine_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.pine_chestplate = new SPItemArmor(SPItems.pineArmorMaterial, 0, EntityEquipmentSlot.CHEST, "pine_chestplate", "stickWood").setUnlocalizedName("pine_chestplate").setRegistryName("pine_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.pine_leggings = new SPItemArmor(SPItems.pineArmorMaterial, 0, EntityEquipmentSlot.LEGS, "pine_leggings", "stickWood").setUnlocalizedName("pine_leggings").setRegistryName("pine_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.pine_boots = new SPItemArmor(SPItems.pineArmorMaterial, 0, EntityEquipmentSlot.FEET, "pine_boots", "stickWood").setUnlocalizedName("pine_boots").setRegistryName("pine_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.pine = Lists.newArrayList();
		SPItems.pine.add(0, new ItemStack(SPItems.pine_helmet));
		SPItems.pine.add(1, new ItemStack(SPItems.pine_chestplate));
		SPItems.pine.add(2, new ItemStack(SPItems.pine_leggings));
		SPItems.pine.add(3, new ItemStack(SPItems.pine_boots));

		SPItems.redwoodArmorMaterial = EnumHelper.addArmorMaterial("redwood", SPReference.MOD_ID + ":" +  "redwood", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.redwood_helmet = new SPItemArmor(SPItems.redwoodArmorMaterial, 0, EntityEquipmentSlot.HEAD, "redwood_helmet", "stickWood").setUnlocalizedName("redwood_helmet").setRegistryName("redwood_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.redwood_chestplate = new SPItemArmor(SPItems.redwoodArmorMaterial, 0, EntityEquipmentSlot.CHEST, "redwood_chestplate", "stickWood").setUnlocalizedName("redwood_chestplate").setRegistryName("redwood_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.redwood_leggings = new SPItemArmor(SPItems.redwoodArmorMaterial, 0, EntityEquipmentSlot.LEGS, "redwood_leggings", "stickWood").setUnlocalizedName("redwood_leggings").setRegistryName("redwood_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.redwood_boots = new SPItemArmor(SPItems.redwoodArmorMaterial, 0, EntityEquipmentSlot.FEET, "redwood_boots", "stickWood").setUnlocalizedName("redwood_boots").setRegistryName("redwood_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.redwood = Lists.newArrayList();
		SPItems.redwood.add(0, new ItemStack(SPItems.redwood_helmet));
		SPItems.redwood.add(1, new ItemStack(SPItems.redwood_chestplate));
		SPItems.redwood.add(2, new ItemStack(SPItems.redwood_leggings));
		SPItems.redwood.add(3, new ItemStack(SPItems.redwood_boots));

		SPItems.sacredOakArmorMaterial = EnumHelper.addArmorMaterial("sacred_oak", SPReference.MOD_ID + ":" +  "sacred_oak", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.sacred_oak_helmet = new SPItemArmor(SPItems.sacredOakArmorMaterial, 0, EntityEquipmentSlot.HEAD, "sacred_oak_helmet", "stickWood").setUnlocalizedName("sacred_oak_helmet").setRegistryName("sacred_oak_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.sacred_oak_chestplate = new SPItemArmor(SPItems.sacredOakArmorMaterial, 0, EntityEquipmentSlot.CHEST, "sacred_oak_chestplate", "stickWood").setUnlocalizedName("sacred_oak_chestplate").setRegistryName("sacred_oak_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.sacred_oak_leggings = new SPItemArmor(SPItems.sacredOakArmorMaterial, 0, EntityEquipmentSlot.LEGS, "sacred_oak_leggings", "stickWood").setUnlocalizedName("sacred_oak_leggings").setRegistryName("sacred_oak_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.sacred_oak_boots = new SPItemArmor(SPItems.sacredOakArmorMaterial, 0, EntityEquipmentSlot.FEET, "sacred_oak_boots", "stickWood").setUnlocalizedName("sacred_oak_boots").setRegistryName("sacred_oak_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.sacred_oak = Lists.newArrayList();
		SPItems.sacred_oak.add(0, new ItemStack(SPItems.sacred_oak_helmet));
		SPItems.sacred_oak.add(1, new ItemStack(SPItems.sacred_oak_chestplate));
		SPItems.sacred_oak.add(2, new ItemStack(SPItems.sacred_oak_leggings));
		SPItems.sacred_oak.add(3, new ItemStack(SPItems.sacred_oak_boots));

		SPItems.umbranArmorMaterial = EnumHelper.addArmorMaterial("umbran", SPReference.MOD_ID + ":" +  "umbran", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.umbran_helmet = new SPItemArmor(SPItems.umbranArmorMaterial, 0, EntityEquipmentSlot.HEAD, "umbran_helmet", "stickWood").setUnlocalizedName("umbran_helmet").setRegistryName("umbran_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.umbran_chestplate = new SPItemArmor(SPItems.umbranArmorMaterial, 0, EntityEquipmentSlot.CHEST, "umbran_chestplate", "stickWood").setUnlocalizedName("umbran_chestplate").setRegistryName("umbran_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.umbran_leggings = new SPItemArmor(SPItems.umbranArmorMaterial, 0, EntityEquipmentSlot.LEGS, "umbran_leggings", "stickWood").setUnlocalizedName("umbran_leggings").setRegistryName("umbran_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.umbran_boots = new SPItemArmor(SPItems.umbranArmorMaterial, 0, EntityEquipmentSlot.FEET, "umbran_boots", "stickWood").setUnlocalizedName("umbran_boots").setRegistryName("umbran_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.umbran = Lists.newArrayList();
		SPItems.umbran.add(0, new ItemStack(SPItems.umbran_helmet));
		SPItems.umbran.add(1, new ItemStack(SPItems.umbran_chestplate));
		SPItems.umbran.add(2, new ItemStack(SPItems.umbran_leggings));
		SPItems.umbran.add(3, new ItemStack(SPItems.umbran_boots));

		SPItems.willowArmorMaterial = EnumHelper.addArmorMaterial("willow", SPReference.MOD_ID + ":" +  "willow", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.willow_helmet = new SPItemArmor(SPItems.willowArmorMaterial, 0, EntityEquipmentSlot.HEAD, "willow_helmet", "stickWood").setUnlocalizedName("willow_helmet").setRegistryName("willow_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.willow_chestplate = new SPItemArmor(SPItems.willowArmorMaterial, 0, EntityEquipmentSlot.CHEST, "willow_chestplate", "stickWood").setUnlocalizedName("willow_chestplate").setRegistryName("willow_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.willow_leggings = new SPItemArmor(SPItems.willowArmorMaterial, 0, EntityEquipmentSlot.LEGS, "willow_leggings", "stickWood").setUnlocalizedName("willow_leggings").setRegistryName("willow_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.willow_boots = new SPItemArmor(SPItems.willowArmorMaterial, 0, EntityEquipmentSlot.FEET, "willow_boots", "stickWood").setUnlocalizedName("willow_boots").setRegistryName("willow_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.willow = Lists.newArrayList();
		SPItems.willow.add(0, new ItemStack(SPItems.willow_helmet));
		SPItems.willow.add(1, new ItemStack(SPItems.willow_chestplate));
		SPItems.willow.add(2, new ItemStack(SPItems.willow_leggings));
		SPItems.willow.add(3, new ItemStack(SPItems.willow_boots));
	}
	
	public static void register()
	{
		SurvivalPlusArmor.register(SPItems.cherry);
		SurvivalPlusArmor.register(SPItems.dead);
		SurvivalPlusArmor.register(SPItems.ebony);
		SurvivalPlusArmor.register(SPItems.ethereal);
		SurvivalPlusArmor.register(SPItems.eucalyptus);
		SurvivalPlusArmor.register(SPItems.fir);
		SurvivalPlusArmor.register(SPItems.hellbark);
		SurvivalPlusArmor.register(SPItems.jacaranda);
		SurvivalPlusArmor.register(SPItems.magic);
		SurvivalPlusArmor.register(SPItems.mahogany);
		SurvivalPlusArmor.register(SPItems.mangrove);
		SurvivalPlusArmor.register(SPItems.palm);
		SurvivalPlusArmor.register(SPItems.pine);
		SurvivalPlusArmor.register(SPItems.redwood);
		SurvivalPlusArmor.register(SPItems.sacred_oak);
		SurvivalPlusArmor.register(SPItems.umbran);
		SurvivalPlusArmor.register(SPItems.willow);
	}
	
	public static void registerRenders()
	{
		SurvivalPlusArmor.registerRender(SPItems.cherry);
		SurvivalPlusArmor.registerRender(SPItems.dead);
		SurvivalPlusArmor.registerRender(SPItems.ebony);
		SurvivalPlusArmor.registerRender(SPItems.ethereal);
		SurvivalPlusArmor.registerRender(SPItems.eucalyptus);
		SurvivalPlusArmor.registerRender(SPItems.fir);
		SurvivalPlusArmor.registerRender(SPItems.hellbark);
		SurvivalPlusArmor.registerRender(SPItems.jacaranda);
		SurvivalPlusArmor.registerRender(SPItems.magic);
		SurvivalPlusArmor.registerRender(SPItems.mahogany);
		SurvivalPlusArmor.registerRender(SPItems.mangrove);
		SurvivalPlusArmor.registerRender(SPItems.palm);
		SurvivalPlusArmor.registerRender(SPItems.pine);
		SurvivalPlusArmor.registerRender(SPItems.redwood);
		SurvivalPlusArmor.registerRender(SPItems.sacred_oak);
		SurvivalPlusArmor.registerRender(SPItems.umbran);
		SurvivalPlusArmor.registerRender(SPItems.willow);
	}

}
