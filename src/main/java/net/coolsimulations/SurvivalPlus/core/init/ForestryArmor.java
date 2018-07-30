package net.coolsimulations.SurvivalPlus.core.init;

import forestry.arboriculture.blocks.BlockForestryLog;
import forestry.arboriculture.blocks.BlockRegistryArboriculture;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ForestryArmor {
	
	public static void init(){
		
		SPItems.desertAcaciaArmorMaterial = EnumHelper.addArmorMaterial("desert_acacia", SPReference.MOD_ID + ":" +  "desert_acacia", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.desert_acacia_helmet = new SPItemArmor(SPItems.desertAcaciaArmorMaterial, 0, EntityEquipmentSlot.HEAD, "desert_acacia_helmet", "stickWood").setUnlocalizedName("desert_acacia_helmet").setRegistryName("desert_acacia_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.desert_acacia_chestplate = new SPItemArmor(SPItems.desertAcaciaArmorMaterial, 0, EntityEquipmentSlot.CHEST, "desert_acacia_chestplate", "stickWood").setUnlocalizedName("desert_acacia_chestplate").setRegistryName("desert_acacia_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.desert_acacia_leggings = new SPItemArmor(SPItems.desertAcaciaArmorMaterial, 0, EntityEquipmentSlot.LEGS, "desert_acacia_leggings", "stickWood").setUnlocalizedName("desert_acacia_leggings").setRegistryName("desert_acacia_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.desert_acacia_boots = new SPItemArmor(SPItems.desertAcaciaArmorMaterial, 0, EntityEquipmentSlot.FEET, "desert_acacia_boots", "stickWood").setUnlocalizedName("desert_acacia_boots").setRegistryName("desert_acacia_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.balsaArmorMaterial = EnumHelper.addArmorMaterial("balsa", SPReference.MOD_ID + ":" +  "balsa", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.balsa_helmet = new SPItemArmor(SPItems.balsaArmorMaterial, 0, EntityEquipmentSlot.HEAD, "balsa_helmet", "stickWood").setUnlocalizedName("balsa_helmet").setRegistryName("balsa_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.balsa_chestplate = new SPItemArmor(SPItems.balsaArmorMaterial, 0, EntityEquipmentSlot.CHEST, "balsa_chestplate", "stickWood").setUnlocalizedName("balsa_chestplate").setRegistryName("balsa_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.balsa_leggings = new SPItemArmor(SPItems.balsaArmorMaterial, 0, EntityEquipmentSlot.LEGS, "balsa_leggings", "stickWood").setUnlocalizedName("balsa_leggings").setRegistryName("balsa_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.balsa_boots = new SPItemArmor(SPItems.balsaArmorMaterial, 0, EntityEquipmentSlot.FEET, "balsa_boots", "stickWood").setUnlocalizedName("balsa_boots").setRegistryName("balsa_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.baobabArmorMaterial = EnumHelper.addArmorMaterial("baobab", SPReference.MOD_ID + ":" +  "baobab", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.baobab_helmet = new SPItemArmor(SPItems.baobabArmorMaterial, 0, EntityEquipmentSlot.HEAD, "baobab_helmet", "stickWood").setUnlocalizedName("baobab_helmet").setRegistryName("baobab_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.baobab_chestplate = new SPItemArmor(SPItems.baobabArmorMaterial, 0, EntityEquipmentSlot.CHEST, "baobab_chestplate", "stickWood").setUnlocalizedName("baobab_chestplate").setRegistryName("baobab_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.baobab_leggings = new SPItemArmor(SPItems.baobabArmorMaterial, 0, EntityEquipmentSlot.LEGS, "baobab_leggings", "stickWood").setUnlocalizedName("baobab_leggings").setRegistryName("baobab_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.baobab_boots = new SPItemArmor(SPItems.baobabArmorMaterial, 0, EntityEquipmentSlot.FEET, "baobab_boots", "stickWood").setUnlocalizedName("baobab_boots").setRegistryName("baobab_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.cherryForestryArmorMaterial = EnumHelper.addArmorMaterial("cherry_forestry", SPReference.MOD_ID + ":" +  "cherry_forestry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.cherry_helmet_forestry = new SPItemArmor(SPItems.cherryForestryArmorMaterial, 0, EntityEquipmentSlot.HEAD, "cherry_helmet_forestry", "stickWood").setUnlocalizedName("cherry_helmet_forestry").setRegistryName("cherry_helmet_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.cherry_chestplate_forestry  = new SPItemArmor(SPItems.cherryForestryArmorMaterial, 0, EntityEquipmentSlot.CHEST, "cherry_chestplate_forestry", "stickWood").setUnlocalizedName("cherry_chestplate_forestry").setRegistryName("cherry_chestplate_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.cherry_leggings_forestry  = new SPItemArmor(SPItems.cherryForestryArmorMaterial, 0, EntityEquipmentSlot.LEGS, "cherry_leggings_forestry", "stickWood").setUnlocalizedName("cherry_leggings_forestry").setRegistryName("cherry_leggings_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.cherry_boots_forestry  = new SPItemArmor(SPItems.cherryForestryArmorMaterial, 0, EntityEquipmentSlot.FEET, "cherry_boots_forestry", "stickWood").setUnlocalizedName("cherry_boots_forestry").setRegistryName("cherry_boots_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.chestnutArmorMaterial = EnumHelper.addArmorMaterial("chestnut", SPReference.MOD_ID + ":" +  "chestnut", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.chestnut_helmet = new SPItemArmor(SPItems.chestnutArmorMaterial, 0, EntityEquipmentSlot.HEAD, "chestnut_helmet", "stickWood").setUnlocalizedName("chestnut_helmet").setRegistryName("chestnut_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.chestnut_chestplate = new SPItemArmor(SPItems.chestnutArmorMaterial, 0, EntityEquipmentSlot.CHEST, "chestnut_chestplate", "stickWood").setUnlocalizedName("chestnut_chestplate").setRegistryName("chestnut_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.chestnut_leggings = new SPItemArmor(SPItems.chestnutArmorMaterial, 0, EntityEquipmentSlot.LEGS, "chestnut_leggings", "stickWood").setUnlocalizedName("chestnut_leggings").setRegistryName("chestnut_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.chestnut_boots = new SPItemArmor(SPItems.chestnutArmorMaterial, 0, EntityEquipmentSlot.FEET, "chestnut_boots", "stickWood").setUnlocalizedName("chestnut_boots").setRegistryName("chestnut_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.citrusArmorMaterial = EnumHelper.addArmorMaterial("citrus", SPReference.MOD_ID + ":" +  "citrus", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.citrus_helmet = new SPItemArmor(SPItems.citrusArmorMaterial, 0, EntityEquipmentSlot.HEAD, "citrus_helmet", "stickWood").setUnlocalizedName("citrus_helmet").setRegistryName("citrus_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.citrus_chestplate = new SPItemArmor(SPItems.citrusArmorMaterial, 0, EntityEquipmentSlot.CHEST, "citrus_chestplate", "stickWood").setUnlocalizedName("citrus_chestplate").setRegistryName("citrus_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.citrus_leggings = new SPItemArmor(SPItems.citrusArmorMaterial, 0, EntityEquipmentSlot.LEGS, "citrus_leggings", "stickWood").setUnlocalizedName("citrus_leggings").setRegistryName("citrus_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.citrus_boots = new SPItemArmor(SPItems.citrusArmorMaterial, 0, EntityEquipmentSlot.FEET, "citrus_boots", "stickWood").setUnlocalizedName("citrus_boots").setRegistryName("citrus_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.cocoboloArmorMaterial = EnumHelper.addArmorMaterial("cocobolo", SPReference.MOD_ID + ":" +  "cocobolo", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.cocobolo_helmet = new SPItemArmor(SPItems.cocoboloArmorMaterial, 0, EntityEquipmentSlot.HEAD, "cocobolo_helmet", "stickWood").setUnlocalizedName("cocobolo_helmet").setRegistryName("cocobolo_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.cocobolo_chestplate = new SPItemArmor(SPItems.cocoboloArmorMaterial, 0, EntityEquipmentSlot.CHEST, "cocobolo_chestplate", "stickWood").setUnlocalizedName("cocobolo_chestplate").setRegistryName("cocobolo_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.cocobolo_leggings = new SPItemArmor(SPItems.cocoboloArmorMaterial, 0, EntityEquipmentSlot.LEGS, "cocobolo_leggings", "stickWood").setUnlocalizedName("cocobolo_leggings").setRegistryName("cocobolo_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.cocobolo_boots = new SPItemArmor(SPItems.cocoboloArmorMaterial, 0, EntityEquipmentSlot.FEET, "cocobolo_boots", "stickWood").setUnlocalizedName("cocobolo_boots").setRegistryName("cocobolo_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.ebonyForestryArmorMaterial = EnumHelper.addArmorMaterial("ebony_forestry", SPReference.MOD_ID + ":" +  "ebony_forestry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.ebony_helmet_forestry = new SPItemArmor(SPItems.ebonyForestryArmorMaterial, 0, EntityEquipmentSlot.HEAD, "ebony_helmet_forestry", "stickWood").setUnlocalizedName("ebony_helmet_forestry").setRegistryName("ebony_helmet_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.ebony_chestplate_forestry  = new SPItemArmor(SPItems.ebonyForestryArmorMaterial, 0, EntityEquipmentSlot.CHEST, "ebony_chestplate_forestry", "stickWood").setUnlocalizedName("ebony_chestplate_forestry").setRegistryName("ebony_chestplate_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.ebony_leggings_forestry  = new SPItemArmor(SPItems.ebonyForestryArmorMaterial, 0, EntityEquipmentSlot.LEGS, "ebony_leggings_forestry", "stickWood").setUnlocalizedName("ebony_leggings_forestry").setRegistryName("ebony_leggings_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.ebony_boots_forestry  = new SPItemArmor(SPItems.ebonyForestryArmorMaterial, 0, EntityEquipmentSlot.FEET, "ebony_boots_forestry", "stickWood").setUnlocalizedName("ebony_boots_forestry").setRegistryName("ebony_boots_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.giantSequoiaArmorMaterial = EnumHelper.addArmorMaterial("giant_sequoia", SPReference.MOD_ID + ":" +  "giant_sequoia", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.giant_sequoia_helmet = new SPItemArmor(SPItems.giantSequoiaArmorMaterial, 0, EntityEquipmentSlot.HEAD, "giant_sequoia_helmet", "stickWood").setUnlocalizedName("giant_sequoia_helmet").setRegistryName("giant_sequoia_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.giant_sequoia_chestplate = new SPItemArmor(SPItems.giantSequoiaArmorMaterial, 0, EntityEquipmentSlot.CHEST, "giant_sequoia_chestplate", "stickWood").setUnlocalizedName("giant_sequoia_chestplate").setRegistryName("giant_sequoia_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.giant_sequoia_leggings = new SPItemArmor(SPItems.giantSequoiaArmorMaterial, 0, EntityEquipmentSlot.LEGS, "giant_sequoia_leggings", "stickWood").setUnlocalizedName("giant_sequoia_leggings").setRegistryName("giant_sequoia_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.giant_sequoia_boots = new SPItemArmor(SPItems.giantSequoiaArmorMaterial, 0, EntityEquipmentSlot.FEET, "giant_sequoia_boots", "stickWood").setUnlocalizedName("giant_sequoia_boots").setRegistryName("giant_sequoia_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.greenheartArmorMaterial = EnumHelper.addArmorMaterial("greenheart", SPReference.MOD_ID + ":" +  "greenheart", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.greenheart_helmet = new SPItemArmor(SPItems.greenheartArmorMaterial, 0, EntityEquipmentSlot.HEAD, "greenheart_helmet", "stickWood").setUnlocalizedName("greenheart_helmet").setRegistryName("greenheart_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.greenheart_chestplate = new SPItemArmor(SPItems.greenheartArmorMaterial, 0, EntityEquipmentSlot.CHEST, "greenheart_chestplate", "stickWood").setUnlocalizedName("greenheart_chestplate").setRegistryName("greenheart_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.greenheart_leggings = new SPItemArmor(SPItems.greenheartArmorMaterial, 0, EntityEquipmentSlot.LEGS, "greenheart_leggings", "stickWood").setUnlocalizedName("greenheart_leggings").setRegistryName("greenheart_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.greenheart_boots = new SPItemArmor(SPItems.greenheartArmorMaterial, 0, EntityEquipmentSlot.FEET, "greenheart_boots", "stickWood").setUnlocalizedName("greenheart_boots").setRegistryName("greenheart_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.ipeArmorMaterial = EnumHelper.addArmorMaterial("ipe", SPReference.MOD_ID + ":" +  "ipe", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.ipe_helmet = new SPItemArmor(SPItems.ipeArmorMaterial, 0, EntityEquipmentSlot.HEAD, "ipe_helmet", "stickWood").setUnlocalizedName("ipe_helmet").setRegistryName("ipe_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.ipe_chestplate = new SPItemArmor(SPItems.ipeArmorMaterial, 0, EntityEquipmentSlot.CHEST, "ipe_chestplate", "stickWood").setUnlocalizedName("ipe_chestplate").setRegistryName("ipe_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.ipe_leggings = new SPItemArmor(SPItems.ipeArmorMaterial, 0, EntityEquipmentSlot.LEGS, "ipe_leggings", "stickWood").setUnlocalizedName("ipe_leggings").setRegistryName("ipe_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.ipe_boots = new SPItemArmor(SPItems.ipeArmorMaterial, 0, EntityEquipmentSlot.FEET, "ipe_boots", "stickWood").setUnlocalizedName("ipe_boots").setRegistryName("ipe_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.kapokArmorMaterial = EnumHelper.addArmorMaterial("kapok", SPReference.MOD_ID + ":" +  "kapok", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.kapok_helmet = new SPItemArmor(SPItems.kapokArmorMaterial, 0, EntityEquipmentSlot.HEAD, "kapok_helmet", "stickWood").setUnlocalizedName("kapok_helmet").setRegistryName("kapok_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.kapok_chestplate = new SPItemArmor(SPItems.kapokArmorMaterial, 0, EntityEquipmentSlot.CHEST, "kapok_chestplate", "stickWood").setUnlocalizedName("kapok_chestplate").setRegistryName("kapok_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.kapok_leggings = new SPItemArmor(SPItems.kapokArmorMaterial, 0, EntityEquipmentSlot.LEGS, "kapok_leggings", "stickWood").setUnlocalizedName("kapok_leggings").setRegistryName("kapok_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.kapok_boots = new SPItemArmor(SPItems.kapokArmorMaterial, 0, EntityEquipmentSlot.FEET, "kapok_boots", "stickWood").setUnlocalizedName("kapok_boots").setRegistryName("kapok_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.larchArmorMaterial = EnumHelper.addArmorMaterial("larch", SPReference.MOD_ID + ":" +  "larch", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.larch_helmet = new SPItemArmor(SPItems.larchArmorMaterial, 0, EntityEquipmentSlot.HEAD, "larch_helmet", "stickWood").setUnlocalizedName("larch_helmet").setRegistryName("larch_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.larch_chestplate = new SPItemArmor(SPItems.larchArmorMaterial, 0, EntityEquipmentSlot.CHEST, "larch_chestplate", "stickWood").setUnlocalizedName("larch_chestplate").setRegistryName("larch_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.larch_leggings = new SPItemArmor(SPItems.larchArmorMaterial, 0, EntityEquipmentSlot.LEGS, "larch_leggings", "stickWood").setUnlocalizedName("larch_leggings").setRegistryName("larch_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.larch_boots = new SPItemArmor(SPItems.larchArmorMaterial, 0, EntityEquipmentSlot.FEET, "larch_boots", "stickWood").setUnlocalizedName("larch_boots").setRegistryName("larch_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.limeArmorMaterial = EnumHelper.addArmorMaterial("lime", SPReference.MOD_ID + ":" +  "lime", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.lime_helmet = new SPItemArmor(SPItems.limeArmorMaterial, 0, EntityEquipmentSlot.HEAD, "lime_helmet", "stickWood").setUnlocalizedName("lime_helmet").setRegistryName("lime_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.lime_chestplate = new SPItemArmor(SPItems.limeArmorMaterial, 0, EntityEquipmentSlot.CHEST, "lime_chestplate", "stickWood").setUnlocalizedName("lime_chestplate").setRegistryName("lime_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.lime_leggings = new SPItemArmor(SPItems.limeArmorMaterial, 0, EntityEquipmentSlot.LEGS, "lime_leggings", "stickWood").setUnlocalizedName("lime_leggings").setRegistryName("lime_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.lime_boots = new SPItemArmor(SPItems.limeArmorMaterial, 0, EntityEquipmentSlot.FEET, "lime_boots", "stickWood").setUnlocalizedName("lime_boots").setRegistryName("lime_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.mahoeArmorMaterial = EnumHelper.addArmorMaterial("mahoe", SPReference.MOD_ID + ":" +  "mahoe", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.mahoe_helmet = new SPItemArmor(SPItems.mahoeArmorMaterial, 0, EntityEquipmentSlot.HEAD, "mahoe_helmet", "stickWood").setUnlocalizedName("mahoe_helmet").setRegistryName("mahoe_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.mahoe_chestplate = new SPItemArmor(SPItems.mahoeArmorMaterial, 0, EntityEquipmentSlot.CHEST, "mahoe_chestplate", "stickWood").setUnlocalizedName("mahoe_chestplate").setRegistryName("mahoe_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.mahoe_leggings = new SPItemArmor(SPItems.mahoeArmorMaterial, 0, EntityEquipmentSlot.LEGS, "mahoe_leggings", "stickWood").setUnlocalizedName("mahoe_leggings").setRegistryName("mahoe_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.mahoe_boots = new SPItemArmor(SPItems.mahoeArmorMaterial, 0, EntityEquipmentSlot.FEET, "mahoe_boots", "stickWood").setUnlocalizedName("mahoe_boots").setRegistryName("mahoe_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.mahoganyForestryArmorMaterial = EnumHelper.addArmorMaterial("mahogany_forestry", SPReference.MOD_ID + ":" +  "mahogany_forestry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.mahogany_helmet_forestry = new SPItemArmor(SPItems.mahoganyForestryArmorMaterial, 0, EntityEquipmentSlot.HEAD, "mahogany_helmet_forestry", "stickWood").setUnlocalizedName("mahogany_helmet_forestry").setRegistryName("mahogany_helmet_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.mahogany_chestplate_forestry  = new SPItemArmor(SPItems.mahoganyForestryArmorMaterial, 0, EntityEquipmentSlot.CHEST, "mahogany_chestplate_forestry", "stickWood").setUnlocalizedName("mahogany_chestplate_forestry").setRegistryName("mahogany_chestplate_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.mahogany_leggings_forestry  = new SPItemArmor(SPItems.mahoganyForestryArmorMaterial, 0, EntityEquipmentSlot.LEGS, "mahogany_leggings_forestry", "stickWood").setUnlocalizedName("mahogany_leggings_forestry").setRegistryName("mahogany_leggings_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.mahogany_boots_forestry  = new SPItemArmor(SPItems.mahoganyForestryArmorMaterial, 0, EntityEquipmentSlot.FEET, "mahogany_boots_forestry", "stickWood").setUnlocalizedName("mahogany_boots_forestry").setRegistryName("mahogany_boots_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.mapleArmorMaterial = EnumHelper.addArmorMaterial("maple", SPReference.MOD_ID + ":" +  "maple", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.maple_helmet = new SPItemArmor(SPItems.mapleArmorMaterial, 0, EntityEquipmentSlot.HEAD, "maple_helmet", "stickWood").setUnlocalizedName("maple_helmet").setRegistryName("maple_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.maple_chestplate = new SPItemArmor(SPItems.mapleArmorMaterial, 0, EntityEquipmentSlot.CHEST, "maple_chestplate", "stickWood").setUnlocalizedName("maple_chestplate").setRegistryName("maple_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.maple_leggings = new SPItemArmor(SPItems.mapleArmorMaterial, 0, EntityEquipmentSlot.LEGS, "maple_leggings", "stickWood").setUnlocalizedName("maple_leggings").setRegistryName("maple_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.maple_boots = new SPItemArmor(SPItems.mapleArmorMaterial, 0, EntityEquipmentSlot.FEET, "maple_boots", "stickWood").setUnlocalizedName("maple_boots").setRegistryName("maple_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.padaukArmorMaterial = EnumHelper.addArmorMaterial("padauk", SPReference.MOD_ID + ":" +  "padauk", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.padauk_helmet = new SPItemArmor(SPItems.padaukArmorMaterial, 0, EntityEquipmentSlot.HEAD, "padauk_helmet", "stickWood").setUnlocalizedName("padauk_helmet").setRegistryName("padauk_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.padauk_chestplate = new SPItemArmor(SPItems.padaukArmorMaterial, 0, EntityEquipmentSlot.CHEST, "padauk_chestplate", "stickWood").setUnlocalizedName("padauk_chestplate").setRegistryName("padauk_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.padauk_leggings = new SPItemArmor(SPItems.padaukArmorMaterial, 0, EntityEquipmentSlot.LEGS, "padauk_leggings", "stickWood").setUnlocalizedName("padauk_leggings").setRegistryName("padauk_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.padauk_boots = new SPItemArmor(SPItems.padaukArmorMaterial, 0, EntityEquipmentSlot.FEET, "padauk_boots", "stickWood").setUnlocalizedName("padauk_boots").setRegistryName("padauk_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.palmForestryArmorMaterial = EnumHelper.addArmorMaterial("palm_forestry", SPReference.MOD_ID + ":" +  "palm_forestry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.palm_helmet_forestry = new SPItemArmor(SPItems.palmForestryArmorMaterial, 0, EntityEquipmentSlot.HEAD, "palm_helmet_forestry", "stickWood").setUnlocalizedName("palm_helmet_forestry").setRegistryName("palm_helmet_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.palm_chestplate_forestry  = new SPItemArmor(SPItems.palmForestryArmorMaterial, 0, EntityEquipmentSlot.CHEST, "palm_chestplate_forestry", "stickWood").setUnlocalizedName("palm_chestplate_forestry").setRegistryName("palm_chestplate_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.palm_leggings_forestry  = new SPItemArmor(SPItems.palmForestryArmorMaterial, 0, EntityEquipmentSlot.LEGS, "palm_leggings_forestry", "stickWood").setUnlocalizedName("palm_leggings_forestry").setRegistryName("palm_leggings_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.palm_boots_forestry  = new SPItemArmor(SPItems.palmForestryArmorMaterial, 0, EntityEquipmentSlot.FEET, "palm_boots_forestry", "stickWood").setUnlocalizedName("palm_boots_forestry").setRegistryName("palm_boots_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.papayaArmorMaterial = EnumHelper.addArmorMaterial("papaya", SPReference.MOD_ID + ":" +  "papaya", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.papaya_helmet = new SPItemArmor(SPItems.papayaArmorMaterial, 0, EntityEquipmentSlot.HEAD, "papaya_helmet", "stickWood").setUnlocalizedName("papaya_helmet").setRegistryName("papaya_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.papaya_chestplate = new SPItemArmor(SPItems.papayaArmorMaterial, 0, EntityEquipmentSlot.CHEST, "papaya_chestplate", "stickWood").setUnlocalizedName("papaya_chestplate").setRegistryName("papaya_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.papaya_leggings = new SPItemArmor(SPItems.papayaArmorMaterial, 0, EntityEquipmentSlot.LEGS, "papaya_leggings", "stickWood").setUnlocalizedName("papaya_leggings").setRegistryName("papaya_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.papaya_boots = new SPItemArmor(SPItems.papayaArmorMaterial, 0, EntityEquipmentSlot.FEET, "papaya_boots", "stickWood").setUnlocalizedName("papaya_boots").setRegistryName("papaya_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.pineForestryArmorMaterial = EnumHelper.addArmorMaterial("pine_forestry", SPReference.MOD_ID + ":" +  "pine_forestry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.pine_helmet_forestry = new SPItemArmor(SPItems.pineForestryArmorMaterial, 0, EntityEquipmentSlot.HEAD, "pine_helmet_forestry", "stickWood").setUnlocalizedName("pine_helmet_forestry").setRegistryName("pine_helmet_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.pine_chestplate_forestry  = new SPItemArmor(SPItems.pineForestryArmorMaterial, 0, EntityEquipmentSlot.CHEST, "pine_chestplate_forestry", "stickWood").setUnlocalizedName("pine_chestplate_forestry").setRegistryName("pine_chestplate_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.pine_leggings_forestry  = new SPItemArmor(SPItems.pineForestryArmorMaterial, 0, EntityEquipmentSlot.LEGS, "pine_leggings_forestry", "stickWood").setUnlocalizedName("pine_leggings_forestry").setRegistryName("pine_leggings_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.pine_boots_forestry  = new SPItemArmor(SPItems.pineForestryArmorMaterial, 0, EntityEquipmentSlot.FEET, "pine_boots_forestry", "stickWood").setUnlocalizedName("pine_boots_forestry").setRegistryName("pine_boots_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.plumArmorMaterial = EnumHelper.addArmorMaterial("plum", SPReference.MOD_ID + ":" +  "plum", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.plum_helmet = new SPItemArmor(SPItems.plumArmorMaterial, 0, EntityEquipmentSlot.HEAD, "plum_helmet", "stickWood").setUnlocalizedName("plum_helmet").setRegistryName("plum_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.plum_chestplate = new SPItemArmor(SPItems.plumArmorMaterial, 0, EntityEquipmentSlot.CHEST, "plum_chestplate", "stickWood").setUnlocalizedName("plum_chestplate").setRegistryName("plum_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.plum_leggings = new SPItemArmor(SPItems.plumArmorMaterial, 0, EntityEquipmentSlot.LEGS, "plum_leggings", "stickWood").setUnlocalizedName("plum_leggings").setRegistryName("plum_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.plum_boots = new SPItemArmor(SPItems.plumArmorMaterial, 0, EntityEquipmentSlot.FEET, "plum_boots", "stickWood").setUnlocalizedName("plum_boots").setRegistryName("plum_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.poplarArmorMaterial = EnumHelper.addArmorMaterial("poplar", SPReference.MOD_ID + ":" +  "poplar", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.poplar_helmet = new SPItemArmor(SPItems.poplarArmorMaterial, 0, EntityEquipmentSlot.HEAD, "poplar_helmet", "stickWood").setUnlocalizedName("poplar_helmet").setRegistryName("poplar_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.poplar_chestplate = new SPItemArmor(SPItems.poplarArmorMaterial, 0, EntityEquipmentSlot.CHEST, "poplar_chestplate", "stickWood").setUnlocalizedName("poplar_chestplate").setRegistryName("poplar_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.poplar_leggings = new SPItemArmor(SPItems.poplarArmorMaterial, 0, EntityEquipmentSlot.LEGS, "poplar_leggings", "stickWood").setUnlocalizedName("poplar_leggings").setRegistryName("poplar_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.poplar_boots = new SPItemArmor(SPItems.poplarArmorMaterial, 0, EntityEquipmentSlot.FEET, "poplar_boots", "stickWood").setUnlocalizedName("poplar_boots").setRegistryName("poplar_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.sequoiaArmorMaterial = EnumHelper.addArmorMaterial("sequoia", SPReference.MOD_ID + ":" +  "sequoia", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.sequoia_helmet = new SPItemArmor(SPItems.sequoiaArmorMaterial, 0, EntityEquipmentSlot.HEAD, "sequoia_helmet", "stickWood").setUnlocalizedName("sequoia_helmet").setRegistryName("sequoia_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.sequoia_chestplate = new SPItemArmor(SPItems.sequoiaArmorMaterial, 0, EntityEquipmentSlot.CHEST, "sequoia_chestplate", "stickWood").setUnlocalizedName("sequoia_chestplate").setRegistryName("sequoia_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.sequoia_leggings = new SPItemArmor(SPItems.sequoiaArmorMaterial, 0, EntityEquipmentSlot.LEGS, "sequoia_leggings", "stickWood").setUnlocalizedName("sequoia_leggings").setRegistryName("sequoia_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.sequoia_boots = new SPItemArmor(SPItems.sequoiaArmorMaterial, 0, EntityEquipmentSlot.FEET, "sequoia_boots", "stickWood").setUnlocalizedName("sequoia_boots").setRegistryName("sequoia_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.teakArmorMaterial = EnumHelper.addArmorMaterial("teak", SPReference.MOD_ID + ":" +  "teak", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.teak_helmet = new SPItemArmor(SPItems.teakArmorMaterial, 0, EntityEquipmentSlot.HEAD, "teak_helmet", "stickWood").setUnlocalizedName("teak_helmet").setRegistryName("teak_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.teak_chestplate = new SPItemArmor(SPItems.teakArmorMaterial, 0, EntityEquipmentSlot.CHEST, "teak_chestplate", "stickWood").setUnlocalizedName("teak_chestplate").setRegistryName("teak_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.teak_leggings = new SPItemArmor(SPItems.teakArmorMaterial, 0, EntityEquipmentSlot.LEGS, "teak_leggings", "stickWood").setUnlocalizedName("teak_leggings").setRegistryName("teak_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.teak_boots = new SPItemArmor(SPItems.teakArmorMaterial, 0, EntityEquipmentSlot.FEET, "teak_boots", "stickWood").setUnlocalizedName("teak_boots").setRegistryName("teak_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.walnutArmorMaterial = EnumHelper.addArmorMaterial("walnut", SPReference.MOD_ID + ":" +  "walnut", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.walnut_helmet = new SPItemArmor(SPItems.walnutArmorMaterial, 0, EntityEquipmentSlot.HEAD, "walnut_helmet", "stickWood").setUnlocalizedName("walnut_helmet").setRegistryName("walnut_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.walnut_chestplate = new SPItemArmor(SPItems.walnutArmorMaterial, 0, EntityEquipmentSlot.CHEST, "walnut_chestplate", "stickWood").setUnlocalizedName("walnut_chestplate").setRegistryName("walnut_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.walnut_leggings = new SPItemArmor(SPItems.walnutArmorMaterial, 0, EntityEquipmentSlot.LEGS, "walnut_leggings", "stickWood").setUnlocalizedName("walnut_leggings").setRegistryName("walnut_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.walnut_boots = new SPItemArmor(SPItems.walnutArmorMaterial, 0, EntityEquipmentSlot.FEET, "walnut_boots", "stickWood").setUnlocalizedName("walnut_boots").setRegistryName("walnut_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.wengeArmorMaterial = EnumHelper.addArmorMaterial("wenge", SPReference.MOD_ID + ":" +  "wenge", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.wenge_helmet = new SPItemArmor(SPItems.wengeArmorMaterial, 0, EntityEquipmentSlot.HEAD, "wenge_helmet", "stickWood").setUnlocalizedName("wenge_helmet").setRegistryName("wenge_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.wenge_chestplate = new SPItemArmor(SPItems.wengeArmorMaterial, 0, EntityEquipmentSlot.CHEST, "wenge_chestplate", "stickWood").setUnlocalizedName("wenge_chestplate").setRegistryName("wenge_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.wenge_leggings = new SPItemArmor(SPItems.wengeArmorMaterial, 0, EntityEquipmentSlot.LEGS, "wenge_leggings", "stickWood").setUnlocalizedName("wenge_leggings").setRegistryName("wenge_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.wenge_boots = new SPItemArmor(SPItems.wengeArmorMaterial, 0, EntityEquipmentSlot.FEET, "wenge_boots", "stickWood").setUnlocalizedName("wenge_boots").setRegistryName("wenge_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.willowForestryArmorMaterial = EnumHelper.addArmorMaterial("willow_forestry", SPReference.MOD_ID + ":" +  "willow_forestry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.willow_helmet_forestry = new SPItemArmor(SPItems.willowForestryArmorMaterial, 0, EntityEquipmentSlot.HEAD, "willow_helmet_forestry", "stickWood").setUnlocalizedName("willow_helmet_forestry").setRegistryName("willow_helmet_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.willow_chestplate_forestry  = new SPItemArmor(SPItems.willowForestryArmorMaterial, 0, EntityEquipmentSlot.CHEST, "willow_chestplate_forestry", "stickWood").setUnlocalizedName("willow_chestplate_forestry").setRegistryName("willow_chestplate_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.willow_leggings_forestry  = new SPItemArmor(SPItems.willowForestryArmorMaterial, 0, EntityEquipmentSlot.LEGS, "willow_leggings_forestry", "stickWood").setUnlocalizedName("willow_leggings_forestry").setRegistryName("willow_leggings_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.willow_boots_forestry  = new SPItemArmor(SPItems.willowForestryArmorMaterial, 0, EntityEquipmentSlot.FEET, "willow_boots_forestry", "stickWood").setUnlocalizedName("willow_boots_forestry").setRegistryName("willow_boots_forestry").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.zebrawoodArmorMaterial = EnumHelper.addArmorMaterial("zebrawood", SPReference.MOD_ID + ":" +  "zebrawood", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.zebrawood_helmet = new SPItemArmor(SPItems.zebrawoodArmorMaterial, 0, EntityEquipmentSlot.HEAD, "zebrawood_helmet", "stickWood").setUnlocalizedName("zebrawood_helmet").setRegistryName("zebrawood_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.zebrawood_chestplate = new SPItemArmor(SPItems.zebrawoodArmorMaterial, 0, EntityEquipmentSlot.CHEST, "zebrawood_chestplate", "stickWood").setUnlocalizedName("zebrawood_chestplate").setRegistryName("zebrawood_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.zebrawood_leggings = new SPItemArmor(SPItems.zebrawoodArmorMaterial, 0, EntityEquipmentSlot.LEGS, "zebrawood_leggings", "stickWood").setUnlocalizedName("zebrawood_leggings").setRegistryName("zebrawood_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.zebrawood_boots = new SPItemArmor(SPItems.zebrawoodArmorMaterial, 0, EntityEquipmentSlot.FEET, "zebrawood_boots", "stickWood").setUnlocalizedName("zebrawood_boots").setRegistryName("zebrawood_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
	}
	
	public static void register()
	{
		SurvivalPlusArmor.registerItem(SPItems.desert_acacia_helmet);
		SurvivalPlusArmor.registerItem(SPItems.desert_acacia_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.desert_acacia_leggings);
		SurvivalPlusArmor.registerItem(SPItems.desert_acacia_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.balsa_helmet);
		SurvivalPlusArmor.registerItem(SPItems.balsa_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.balsa_leggings);
		SurvivalPlusArmor.registerItem(SPItems.balsa_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.baobab_helmet);
		SurvivalPlusArmor.registerItem(SPItems.baobab_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.baobab_leggings);
		SurvivalPlusArmor.registerItem(SPItems.baobab_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.cherry_helmet_forestry);
		SurvivalPlusArmor.registerItem(SPItems.cherry_chestplate_forestry);
		SurvivalPlusArmor.registerItem(SPItems.cherry_leggings_forestry);
		SurvivalPlusArmor.registerItem(SPItems.cherry_boots_forestry);
		
		SurvivalPlusArmor.registerItem(SPItems.chestnut_helmet);
		SurvivalPlusArmor.registerItem(SPItems.chestnut_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.chestnut_leggings);
		SurvivalPlusArmor.registerItem(SPItems.chestnut_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.citrus_helmet);
		SurvivalPlusArmor.registerItem(SPItems.citrus_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.citrus_leggings);
		SurvivalPlusArmor.registerItem(SPItems.citrus_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.cocobolo_helmet);
		SurvivalPlusArmor.registerItem(SPItems.cocobolo_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.cocobolo_leggings);
		SurvivalPlusArmor.registerItem(SPItems.cocobolo_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.ebony_helmet_forestry);
		SurvivalPlusArmor.registerItem(SPItems.ebony_chestplate_forestry);
		SurvivalPlusArmor.registerItem(SPItems.ebony_leggings_forestry);
		SurvivalPlusArmor.registerItem(SPItems.ebony_boots_forestry);
		
		SurvivalPlusArmor.registerItem(SPItems.giant_sequoia_helmet);
		SurvivalPlusArmor.registerItem(SPItems.giant_sequoia_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.giant_sequoia_leggings);
		SurvivalPlusArmor.registerItem(SPItems.giant_sequoia_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.greenheart_helmet);
		SurvivalPlusArmor.registerItem(SPItems.greenheart_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.greenheart_leggings);
		SurvivalPlusArmor.registerItem(SPItems.greenheart_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.ipe_helmet);
		SurvivalPlusArmor.registerItem(SPItems.ipe_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.ipe_leggings);
		SurvivalPlusArmor.registerItem(SPItems.ipe_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.kapok_helmet);
		SurvivalPlusArmor.registerItem(SPItems.kapok_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.kapok_leggings);
		SurvivalPlusArmor.registerItem(SPItems.kapok_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.larch_helmet);
		SurvivalPlusArmor.registerItem(SPItems.larch_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.larch_leggings);
		SurvivalPlusArmor.registerItem(SPItems.larch_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.lime_helmet);
		SurvivalPlusArmor.registerItem(SPItems.lime_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.lime_leggings);
		SurvivalPlusArmor.registerItem(SPItems.lime_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.mahoe_helmet);
		SurvivalPlusArmor.registerItem(SPItems.mahoe_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.mahoe_leggings);
		SurvivalPlusArmor.registerItem(SPItems.mahoe_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.mahogany_helmet_forestry);
		SurvivalPlusArmor.registerItem(SPItems.mahogany_chestplate_forestry);
		SurvivalPlusArmor.registerItem(SPItems.mahogany_leggings_forestry);
		SurvivalPlusArmor.registerItem(SPItems.mahogany_boots_forestry);
		
		SurvivalPlusArmor.registerItem(SPItems.maple_helmet);
		SurvivalPlusArmor.registerItem(SPItems.maple_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.maple_leggings);
		SurvivalPlusArmor.registerItem(SPItems.maple_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.padauk_helmet);
		SurvivalPlusArmor.registerItem(SPItems.padauk_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.padauk_leggings);
		SurvivalPlusArmor.registerItem(SPItems.padauk_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.palm_helmet_forestry);
		SurvivalPlusArmor.registerItem(SPItems.palm_chestplate_forestry);
		SurvivalPlusArmor.registerItem(SPItems.palm_leggings_forestry);
		SurvivalPlusArmor.registerItem(SPItems.palm_boots_forestry);
		
		SurvivalPlusArmor.registerItem(SPItems.papaya_helmet);
		SurvivalPlusArmor.registerItem(SPItems.papaya_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.papaya_leggings);
		SurvivalPlusArmor.registerItem(SPItems.papaya_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.pine_helmet_forestry);
		SurvivalPlusArmor.registerItem(SPItems.pine_chestplate_forestry);
		SurvivalPlusArmor.registerItem(SPItems.pine_leggings_forestry);
		SurvivalPlusArmor.registerItem(SPItems.pine_boots_forestry);
		
		SurvivalPlusArmor.registerItem(SPItems.plum_helmet);
		SurvivalPlusArmor.registerItem(SPItems.plum_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.plum_leggings);
		SurvivalPlusArmor.registerItem(SPItems.plum_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.poplar_helmet);
		SurvivalPlusArmor.registerItem(SPItems.poplar_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.poplar_leggings);
		SurvivalPlusArmor.registerItem(SPItems.poplar_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.sequoia_helmet);
		SurvivalPlusArmor.registerItem(SPItems.sequoia_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.sequoia_leggings);
		SurvivalPlusArmor.registerItem(SPItems.sequoia_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.teak_helmet);
		SurvivalPlusArmor.registerItem(SPItems.teak_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.teak_leggings);
		SurvivalPlusArmor.registerItem(SPItems.teak_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.walnut_helmet);
		SurvivalPlusArmor.registerItem(SPItems.walnut_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.walnut_leggings);
		SurvivalPlusArmor.registerItem(SPItems.walnut_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.wenge_helmet);
		SurvivalPlusArmor.registerItem(SPItems.wenge_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.wenge_leggings);
		SurvivalPlusArmor.registerItem(SPItems.wenge_boots);
		
		SurvivalPlusArmor.registerItem(SPItems.willow_helmet_forestry);
		SurvivalPlusArmor.registerItem(SPItems.willow_chestplate_forestry);
		SurvivalPlusArmor.registerItem(SPItems.willow_leggings_forestry);
		SurvivalPlusArmor.registerItem(SPItems.willow_boots_forestry);
		
		SurvivalPlusArmor.registerItem(SPItems.zebrawood_helmet);
		SurvivalPlusArmor.registerItem(SPItems.zebrawood_chestplate);
		SurvivalPlusArmor.registerItem(SPItems.zebrawood_leggings);
		SurvivalPlusArmor.registerItem(SPItems.zebrawood_boots);
		
	}
	
	public static void registerRenders()
	{
		SurvivalPlusArmor.registerRender(SPItems.desert_acacia_helmet);
		SurvivalPlusArmor.registerRender(SPItems.desert_acacia_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.desert_acacia_leggings);
		SurvivalPlusArmor.registerRender(SPItems.desert_acacia_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.balsa_helmet);
		SurvivalPlusArmor.registerRender(SPItems.balsa_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.balsa_leggings);
		SurvivalPlusArmor.registerRender(SPItems.balsa_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.baobab_helmet);
		SurvivalPlusArmor.registerRender(SPItems.baobab_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.baobab_leggings);
		SurvivalPlusArmor.registerRender(SPItems.baobab_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.cherry_helmet_forestry);
		SurvivalPlusArmor.registerRender(SPItems.cherry_chestplate_forestry);
		SurvivalPlusArmor.registerRender(SPItems.cherry_leggings_forestry);
		SurvivalPlusArmor.registerRender(SPItems.cherry_boots_forestry);
		
		SurvivalPlusArmor.registerRender(SPItems.chestnut_helmet);
		SurvivalPlusArmor.registerRender(SPItems.chestnut_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.chestnut_leggings);
		SurvivalPlusArmor.registerRender(SPItems.chestnut_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.citrus_helmet);
		SurvivalPlusArmor.registerRender(SPItems.citrus_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.citrus_leggings);
		SurvivalPlusArmor.registerRender(SPItems.citrus_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.cocobolo_helmet);
		SurvivalPlusArmor.registerRender(SPItems.cocobolo_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.cocobolo_leggings);
		SurvivalPlusArmor.registerRender(SPItems.cocobolo_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.ebony_helmet_forestry);
		SurvivalPlusArmor.registerRender(SPItems.ebony_chestplate_forestry);
		SurvivalPlusArmor.registerRender(SPItems.ebony_leggings_forestry);
		SurvivalPlusArmor.registerRender(SPItems.ebony_boots_forestry);
		
		SurvivalPlusArmor.registerRender(SPItems.giant_sequoia_helmet);
		SurvivalPlusArmor.registerRender(SPItems.giant_sequoia_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.giant_sequoia_leggings);
		SurvivalPlusArmor.registerRender(SPItems.giant_sequoia_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.greenheart_helmet);
		SurvivalPlusArmor.registerRender(SPItems.greenheart_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.greenheart_leggings);
		SurvivalPlusArmor.registerRender(SPItems.greenheart_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.ipe_helmet);
		SurvivalPlusArmor.registerRender(SPItems.ipe_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.ipe_leggings);
		SurvivalPlusArmor.registerRender(SPItems.ipe_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.kapok_helmet);
		SurvivalPlusArmor.registerRender(SPItems.kapok_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.kapok_leggings);
		SurvivalPlusArmor.registerRender(SPItems.kapok_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.larch_helmet);
		SurvivalPlusArmor.registerRender(SPItems.larch_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.larch_leggings);
		SurvivalPlusArmor.registerRender(SPItems.larch_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.lime_helmet);
		SurvivalPlusArmor.registerRender(SPItems.lime_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.lime_leggings);
		SurvivalPlusArmor.registerRender(SPItems.lime_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.mahoe_helmet);
		SurvivalPlusArmor.registerRender(SPItems.mahoe_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.mahoe_leggings);
		SurvivalPlusArmor.registerRender(SPItems.mahoe_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.mahogany_helmet_forestry);
		SurvivalPlusArmor.registerRender(SPItems.mahogany_chestplate_forestry);
		SurvivalPlusArmor.registerRender(SPItems.mahogany_leggings_forestry);
		SurvivalPlusArmor.registerRender(SPItems.mahogany_boots_forestry);
		
		SurvivalPlusArmor.registerRender(SPItems.maple_helmet);
		SurvivalPlusArmor.registerRender(SPItems.maple_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.maple_leggings);
		SurvivalPlusArmor.registerRender(SPItems.maple_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.padauk_helmet);
		SurvivalPlusArmor.registerRender(SPItems.padauk_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.padauk_leggings);
		SurvivalPlusArmor.registerRender(SPItems.padauk_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.palm_helmet_forestry);
		SurvivalPlusArmor.registerRender(SPItems.palm_chestplate_forestry);
		SurvivalPlusArmor.registerRender(SPItems.palm_leggings_forestry);
		SurvivalPlusArmor.registerRender(SPItems.palm_boots_forestry);
		
		SurvivalPlusArmor.registerRender(SPItems.papaya_helmet);
		SurvivalPlusArmor.registerRender(SPItems.papaya_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.papaya_leggings);
		SurvivalPlusArmor.registerRender(SPItems.papaya_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.pine_helmet_forestry);
		SurvivalPlusArmor.registerRender(SPItems.pine_chestplate_forestry);
		SurvivalPlusArmor.registerRender(SPItems.pine_leggings_forestry);
		SurvivalPlusArmor.registerRender(SPItems.pine_boots_forestry);
		
		SurvivalPlusArmor.registerRender(SPItems.plum_helmet);
		SurvivalPlusArmor.registerRender(SPItems.plum_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.plum_leggings);
		SurvivalPlusArmor.registerRender(SPItems.plum_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.poplar_helmet);
		SurvivalPlusArmor.registerRender(SPItems.poplar_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.poplar_leggings);
		SurvivalPlusArmor.registerRender(SPItems.poplar_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.sequoia_helmet);
		SurvivalPlusArmor.registerRender(SPItems.sequoia_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.sequoia_leggings);
		SurvivalPlusArmor.registerRender(SPItems.sequoia_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.teak_helmet);
		SurvivalPlusArmor.registerRender(SPItems.teak_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.teak_leggings);
		SurvivalPlusArmor.registerRender(SPItems.teak_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.walnut_helmet);
		SurvivalPlusArmor.registerRender(SPItems.walnut_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.walnut_leggings);
		SurvivalPlusArmor.registerRender(SPItems.walnut_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.wenge_helmet);
		SurvivalPlusArmor.registerRender(SPItems.wenge_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.wenge_leggings);
		SurvivalPlusArmor.registerRender(SPItems.wenge_boots);
		
		SurvivalPlusArmor.registerRender(SPItems.willow_helmet_forestry);
		SurvivalPlusArmor.registerRender(SPItems.willow_chestplate_forestry);
		SurvivalPlusArmor.registerRender(SPItems.willow_leggings_forestry);
		SurvivalPlusArmor.registerRender(SPItems.willow_boots_forestry);
		
		SurvivalPlusArmor.registerRender(SPItems.zebrawood_helmet);
		SurvivalPlusArmor.registerRender(SPItems.zebrawood_chestplate);
		SurvivalPlusArmor.registerRender(SPItems.zebrawood_leggings);
		SurvivalPlusArmor.registerRender(SPItems.zebrawood_boots);
		
	}

}
