package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ForestryArmor {
	
	public static void init(){
		
		SPItems.desert_acacia_helmet = new SPItemArmor(SPArmorMaterial.desertAcaciaArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("desert_acacia_helmet");
		SPItems.desert_acacia_chestplate = new SPItemArmor(SPArmorMaterial.desertAcaciaArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("desert_acacia_chestplate");
		SPItems.desert_acacia_leggings = new SPItemArmor(SPArmorMaterial.desertAcaciaArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("desert_acacia_leggings");
		SPItems.desert_acacia_boots = new SPItemArmor(SPArmorMaterial.desertAcaciaArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("desert_acacia_boots");
		SPItems.desert_acacia = NonNullList.create();
		SPItems.desert_acacia.add(0, new ItemStack(SPItems.desert_acacia_helmet));
		SPItems.desert_acacia.add(1, new ItemStack(SPItems.desert_acacia_chestplate));
		SPItems.desert_acacia.add(2, new ItemStack(SPItems.desert_acacia_leggings));
		SPItems.desert_acacia.add(3, new ItemStack(SPItems.desert_acacia_boots));
		
		SPItems.balsa_helmet = new SPItemArmor(SPArmorMaterial.balsaArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("balsa_helmet");
		SPItems.balsa_chestplate = new SPItemArmor(SPArmorMaterial.balsaArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("balsa_chestplate");
		SPItems.balsa_leggings = new SPItemArmor(SPArmorMaterial.balsaArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("balsa_leggings");
		SPItems.balsa_boots = new SPItemArmor(SPArmorMaterial.balsaArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("balsa_boots");
		SPItems.balsa = NonNullList.create();
		SPItems.balsa.add(0, new ItemStack(SPItems.balsa_helmet));
		SPItems.balsa.add(1, new ItemStack(SPItems.balsa_chestplate));
		SPItems.balsa.add(2, new ItemStack(SPItems.balsa_leggings));
		SPItems.balsa.add(3, new ItemStack(SPItems.balsa_boots));
		
		SPItems.baobab_helmet = new SPItemArmor(SPArmorMaterial.baobabArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("baobab_helmet");
		SPItems.baobab_chestplate = new SPItemArmor(SPArmorMaterial.baobabArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("baobab_chestplate");
		SPItems.baobab_leggings = new SPItemArmor(SPArmorMaterial.baobabArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("baobab_leggings");
		SPItems.baobab_boots = new SPItemArmor(SPArmorMaterial.baobabArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("baobab_boots");
		SPItems.baobab = NonNullList.create();
		SPItems.baobab.add(0, new ItemStack(SPItems.baobab_helmet));
		SPItems.baobab.add(1, new ItemStack(SPItems.baobab_chestplate));
		SPItems.baobab.add(2, new ItemStack(SPItems.baobab_leggings));
		SPItems.baobab.add(3, new ItemStack(SPItems.baobab_boots));
		
		SPItems.cherry_helmet_forestry = new SPItemArmor(SPArmorMaterial.cherryForestryArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("cherry_helmet_forestry");
		SPItems.cherry_chestplate_forestry = new SPItemArmor(SPArmorMaterial.cherryForestryArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("cherry_chestplate_forestry");
		SPItems.cherry_leggings_forestry = new SPItemArmor(SPArmorMaterial.cherryForestryArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("cherry_leggings_forestry");
		SPItems.cherry_boots_forestry = new SPItemArmor(SPArmorMaterial.cherryForestryArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("cherry_boots_forestry");
		SPItems.cherry_forestry = NonNullList.create();
		SPItems.cherry_forestry.add(0, new ItemStack(SPItems.cherry_helmet_forestry));
		SPItems.cherry_forestry.add(1, new ItemStack(SPItems.cherry_chestplate_forestry));
		SPItems.cherry_forestry.add(2, new ItemStack(SPItems.cherry_leggings_forestry));
		SPItems.cherry_forestry.add(3, new ItemStack(SPItems.cherry_boots_forestry));
		
		SPItems.chestnut_helmet = new SPItemArmor(SPArmorMaterial.chestnutArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("chestnut_helmet");
		SPItems.chestnut_chestplate = new SPItemArmor(SPArmorMaterial.chestnutArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("chestnut_chestplate");
		SPItems.chestnut_leggings = new SPItemArmor(SPArmorMaterial.chestnutArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("chestnut_leggings");
		SPItems.chestnut_boots = new SPItemArmor(SPArmorMaterial.chestnutArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("chestnut_boots");
		SPItems.chestnut = NonNullList.create();
		SPItems.chestnut.add(0, new ItemStack(SPItems.chestnut_helmet));
		SPItems.chestnut.add(1, new ItemStack(SPItems.chestnut_chestplate));
		SPItems.chestnut.add(2, new ItemStack(SPItems.chestnut_leggings));
		SPItems.chestnut.add(3, new ItemStack(SPItems.chestnut_boots));
		
		SPItems.citrus_helmet = new SPItemArmor(SPArmorMaterial.citrusArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("citrus_helmet");
		SPItems.citrus_chestplate = new SPItemArmor(SPArmorMaterial.citrusArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("citrus_chestplate");
		SPItems.citrus_leggings = new SPItemArmor(SPArmorMaterial.citrusArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("citrus_leggings");
		SPItems.citrus_boots = new SPItemArmor(SPArmorMaterial.citrusArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("citrus_boots");
		SPItems.citrus = NonNullList.create();
		SPItems.citrus.add(0, new ItemStack(SPItems.citrus_helmet));
		SPItems.citrus.add(1, new ItemStack(SPItems.citrus_chestplate));
		SPItems.citrus.add(2, new ItemStack(SPItems.citrus_leggings));
		SPItems.citrus.add(3, new ItemStack(SPItems.citrus_boots));
		
		SPItems.cocobolo_helmet = new SPItemArmor(SPArmorMaterial.cocoboloArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("cocobolo_helmet");
		SPItems.cocobolo_chestplate = new SPItemArmor(SPArmorMaterial.cocoboloArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("cocobolo_chestplate");
		SPItems.cocobolo_leggings = new SPItemArmor(SPArmorMaterial.cocoboloArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("cocobolo_leggings");
		SPItems.cocobolo_boots = new SPItemArmor(SPArmorMaterial.cocoboloArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("cocobolo_boots");
		SPItems.cocobolo = NonNullList.create();
		SPItems.cocobolo.add(0, new ItemStack(SPItems.cocobolo_helmet));
		SPItems.cocobolo.add(1, new ItemStack(SPItems.cocobolo_chestplate));
		SPItems.cocobolo.add(2, new ItemStack(SPItems.cocobolo_leggings));
		SPItems.cocobolo.add(3, new ItemStack(SPItems.cocobolo_boots));
		
		SPItems.ebony_helmet_forestry = new SPItemArmor(SPArmorMaterial.ebonyForestryArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("ebony_helmet_forestry");
		SPItems.ebony_chestplate_forestry = new SPItemArmor(SPArmorMaterial.ebonyForestryArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("ebony_chestplate_forestry");
		SPItems.ebony_leggings_forestry = new SPItemArmor(SPArmorMaterial.ebonyForestryArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("ebony_leggings_forestry");
		SPItems.ebony_boots_forestry = new SPItemArmor(SPArmorMaterial.ebonyForestryArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("ebony_boots_forestry");
		SPItems.ebony_forestry = NonNullList.create();
		SPItems.ebony_forestry.add(0, new ItemStack(SPItems.ebony_helmet_forestry));
		SPItems.ebony_forestry.add(1, new ItemStack(SPItems.ebony_chestplate_forestry));
		SPItems.ebony_forestry.add(2, new ItemStack(SPItems.ebony_leggings_forestry));
		SPItems.ebony_forestry.add(3, new ItemStack(SPItems.ebony_boots_forestry));
		
		SPItems.giant_sequoia_helmet = new SPItemArmor(SPArmorMaterial.giantSequoiaArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("giant_sequoia_helmet");
		SPItems.giant_sequoia_chestplate = new SPItemArmor(SPArmorMaterial.giantSequoiaArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("giant_sequoia_chestplate");
		SPItems.giant_sequoia_leggings = new SPItemArmor(SPArmorMaterial.giantSequoiaArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("giant_sequoia_leggings");
		SPItems.giant_sequoia_boots = new SPItemArmor(SPArmorMaterial.giantSequoiaArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("giant_sequoia_boots");
		SPItems.giant_sequoia = NonNullList.create();
		SPItems.giant_sequoia.add(0, new ItemStack(SPItems.giant_sequoia_helmet));
		SPItems.giant_sequoia.add(1, new ItemStack(SPItems.giant_sequoia_chestplate));
		SPItems.giant_sequoia.add(2, new ItemStack(SPItems.giant_sequoia_leggings));
		SPItems.giant_sequoia.add(3, new ItemStack(SPItems.giant_sequoia_boots));
		
		SPItems.greenheart_helmet = new SPItemArmor(SPArmorMaterial.greenheartArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("greenheart_helmet");
		SPItems.greenheart_chestplate = new SPItemArmor(SPArmorMaterial.greenheartArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("greenheart_chestplate");
		SPItems.greenheart_leggings = new SPItemArmor(SPArmorMaterial.greenheartArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("greenheart_leggings");
		SPItems.greenheart_boots = new SPItemArmor(SPArmorMaterial.greenheartArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("greenheart_boots");
		SPItems.greenheart = NonNullList.create();
		SPItems.greenheart.add(0, new ItemStack(SPItems.greenheart_helmet));
		SPItems.greenheart.add(1, new ItemStack(SPItems.greenheart_chestplate));
		SPItems.greenheart.add(2, new ItemStack(SPItems.greenheart_leggings));
		SPItems.greenheart.add(3, new ItemStack(SPItems.greenheart_boots));
		
		SPItems.ipe_helmet = new SPItemArmor(SPArmorMaterial.ipeArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("ipe_helmet");
		SPItems.ipe_chestplate = new SPItemArmor(SPArmorMaterial.ipeArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("ipe_chestplate");
		SPItems.ipe_leggings = new SPItemArmor(SPArmorMaterial.ipeArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("ipe_leggings");
		SPItems.ipe_boots = new SPItemArmor(SPArmorMaterial.ipeArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("ipe_boots");
		SPItems.ipe = NonNullList.create();
		SPItems.ipe.add(0, new ItemStack(SPItems.ipe_helmet));
		SPItems.ipe.add(1, new ItemStack(SPItems.ipe_chestplate));
		SPItems.ipe.add(2, new ItemStack(SPItems.ipe_leggings));
		SPItems.ipe.add(3, new ItemStack(SPItems.ipe_boots));
		
		SPItems.kapok_helmet = new SPItemArmor(SPArmorMaterial.kapokArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("kapok_helmet");
		SPItems.kapok_chestplate = new SPItemArmor(SPArmorMaterial.kapokArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("kapok_chestplate");
		SPItems.kapok_leggings = new SPItemArmor(SPArmorMaterial.kapokArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("kapok_leggings");
		SPItems.kapok_boots = new SPItemArmor(SPArmorMaterial.kapokArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("kapok_boots");
		SPItems.kapok = NonNullList.create();
		SPItems.kapok.add(0, new ItemStack(SPItems.kapok_helmet));
		SPItems.kapok.add(1, new ItemStack(SPItems.kapok_chestplate));
		SPItems.kapok.add(2, new ItemStack(SPItems.kapok_leggings));
		SPItems.kapok.add(3, new ItemStack(SPItems.kapok_boots));
		
		SPItems.larch_helmet = new SPItemArmor(SPArmorMaterial.larchArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("larch_helmet");
		SPItems.larch_chestplate = new SPItemArmor(SPArmorMaterial.larchArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("larch_chestplate");
		SPItems.larch_leggings = new SPItemArmor(SPArmorMaterial.larchArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("larch_leggings");
		SPItems.larch_boots = new SPItemArmor(SPArmorMaterial.larchArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("larch_boots");
		SPItems.larch = NonNullList.create();
		SPItems.larch.add(0, new ItemStack(SPItems.larch_helmet));
		SPItems.larch.add(1, new ItemStack(SPItems.larch_chestplate));
		SPItems.larch.add(2, new ItemStack(SPItems.larch_leggings));
		SPItems.larch.add(3, new ItemStack(SPItems.larch_boots));
		
		SPItems.lime_helmet = new SPItemArmor(SPArmorMaterial.limeArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("lime_helmet");
		SPItems.lime_chestplate = new SPItemArmor(SPArmorMaterial.limeArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("lime_chestplate");
		SPItems.lime_leggings = new SPItemArmor(SPArmorMaterial.limeArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("lime_leggings");
		SPItems.lime_boots = new SPItemArmor(SPArmorMaterial.limeArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("lime_boots");
		SPItems.lime = NonNullList.create();
		SPItems.lime.add(0, new ItemStack(SPItems.lime_helmet));
		SPItems.lime.add(1, new ItemStack(SPItems.lime_chestplate));
		SPItems.lime.add(2, new ItemStack(SPItems.lime_leggings));
		SPItems.lime.add(3, new ItemStack(SPItems.lime_boots));
		
		SPItems.mahoe_helmet = new SPItemArmor(SPArmorMaterial.mahoeArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("mahoe_helmet");
		SPItems.mahoe_chestplate = new SPItemArmor(SPArmorMaterial.mahoeArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("mahoe_chestplate");
		SPItems.mahoe_leggings = new SPItemArmor(SPArmorMaterial.mahoeArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("mahoe_leggings");
		SPItems.mahoe_boots = new SPItemArmor(SPArmorMaterial.mahoeArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("mahoe_boots");
		SPItems.mahoe = NonNullList.create();
		SPItems.mahoe.add(0, new ItemStack(SPItems.mahoe_helmet));
		SPItems.mahoe.add(1, new ItemStack(SPItems.mahoe_chestplate));
		SPItems.mahoe.add(2, new ItemStack(SPItems.mahoe_leggings));
		SPItems.mahoe.add(3, new ItemStack(SPItems.mahoe_boots));
		
		SPItems.mahogany_helmet_forestry = new SPItemArmor(SPArmorMaterial.mahoganyForestryArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("mahogany_helmet_forestry");
		SPItems.mahogany_chestplate_forestry = new SPItemArmor(SPArmorMaterial.mahoganyForestryArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("mahogany_chestplate_forestry");
		SPItems.mahogany_leggings_forestry = new SPItemArmor(SPArmorMaterial.mahoganyForestryArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("mahogany_leggings_forestry");
		SPItems.mahogany_boots_forestry = new SPItemArmor(SPArmorMaterial.mahoganyForestryArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("mahogany_boots_forestry");
		SPItems.mahogany_forestry = NonNullList.create();
		SPItems.mahogany_forestry.add(0, new ItemStack(SPItems.mahogany_helmet_forestry));
		SPItems.mahogany_forestry.add(1, new ItemStack(SPItems.mahogany_chestplate_forestry));
		SPItems.mahogany_forestry.add(2, new ItemStack(SPItems.mahogany_leggings_forestry));
		SPItems.mahogany_forestry.add(3, new ItemStack(SPItems.mahogany_boots_forestry));
		
		SPItems.maple_helmet = new SPItemArmor(SPArmorMaterial.mapleArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("maple_helmet");
		SPItems.maple_chestplate = new SPItemArmor(SPArmorMaterial.mapleArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("maple_chestplate");
		SPItems.maple_leggings = new SPItemArmor(SPArmorMaterial.mapleArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("maple_leggings");
		SPItems.maple_boots = new SPItemArmor(SPArmorMaterial.mapleArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("maple_boots");
		SPItems.maple = NonNullList.create();
		SPItems.maple.add(0, new ItemStack(SPItems.maple_helmet));
		SPItems.maple.add(1, new ItemStack(SPItems.maple_chestplate));
		SPItems.maple.add(2, new ItemStack(SPItems.maple_leggings));
		SPItems.maple.add(3, new ItemStack(SPItems.maple_boots));
		
		SPItems.padauk_helmet = new SPItemArmor(SPArmorMaterial.padaukArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("padauk_helmet");
		SPItems.padauk_chestplate = new SPItemArmor(SPArmorMaterial.padaukArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("padauk_chestplate");
		SPItems.padauk_leggings = new SPItemArmor(SPArmorMaterial.padaukArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("padauk_leggings");
		SPItems.padauk_boots = new SPItemArmor(SPArmorMaterial.padaukArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("padauk_boots");
		SPItems.padauk = NonNullList.create();
		SPItems.padauk.add(0, new ItemStack(SPItems.padauk_helmet));
		SPItems.padauk.add(1, new ItemStack(SPItems.padauk_chestplate));
		SPItems.padauk.add(2, new ItemStack(SPItems.padauk_leggings));
		SPItems.padauk.add(3, new ItemStack(SPItems.padauk_boots));
		
		SPItems.palm_helmet_forestry = new SPItemArmor(SPArmorMaterial.palmForestryArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("palm_helmet_forestry");
		SPItems.palm_chestplate_forestry = new SPItemArmor(SPArmorMaterial.palmForestryArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("palm_chestplate_forestry");
		SPItems.palm_leggings_forestry = new SPItemArmor(SPArmorMaterial.palmForestryArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("palm_leggings_forestry");
		SPItems.palm_boots_forestry = new SPItemArmor(SPArmorMaterial.palmForestryArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("palm_boots_forestry");
		SPItems.palm_forestry = NonNullList.create();
		SPItems.palm_forestry.add(0, new ItemStack(SPItems.palm_helmet_forestry));
		SPItems.palm_forestry.add(1, new ItemStack(SPItems.palm_chestplate_forestry));
		SPItems.palm_forestry.add(2, new ItemStack(SPItems.palm_leggings_forestry));
		SPItems.palm_forestry.add(3, new ItemStack(SPItems.palm_boots_forestry));
		
		SPItems.papaya_helmet = new SPItemArmor(SPArmorMaterial.papayaArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("papaya_helmet");
		SPItems.papaya_chestplate = new SPItemArmor(SPArmorMaterial.papayaArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("papaya_chestplate");
		SPItems.papaya_leggings = new SPItemArmor(SPArmorMaterial.papayaArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("papaya_leggings");
		SPItems.papaya_boots = new SPItemArmor(SPArmorMaterial.papayaArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("papaya_boots");
		SPItems.papaya = NonNullList.create();
		SPItems.papaya.add(0, new ItemStack(SPItems.papaya_helmet));
		SPItems.papaya.add(1, new ItemStack(SPItems.papaya_chestplate));
		SPItems.papaya.add(2, new ItemStack(SPItems.papaya_leggings));
		SPItems.papaya.add(3, new ItemStack(SPItems.papaya_boots));
		
		SPItems.pine_helmet_forestry = new SPItemArmor(SPArmorMaterial.papayaArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("pine_helmet_forestry");
		SPItems.pine_chestplate_forestry = new SPItemArmor(SPArmorMaterial.papayaArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("pine_chestplate_forestry");
		SPItems.pine_leggings_forestry = new SPItemArmor(SPArmorMaterial.papayaArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("pine_leggings_forestry");
		SPItems.pine_boots_forestry = new SPItemArmor(SPArmorMaterial.papayaArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("pine_boots_forestry");
		SPItems.pine_forestry = NonNullList.create();
		SPItems.pine_forestry.add(0, new ItemStack(SPItems.pine_helmet_forestry));
		SPItems.pine_forestry.add(1, new ItemStack(SPItems.pine_chestplate_forestry));
		SPItems.pine_forestry.add(2, new ItemStack(SPItems.pine_leggings_forestry));
		SPItems.pine_forestry.add(3, new ItemStack(SPItems.pine_boots_forestry));
		
		SPItems.plum_helmet = new SPItemArmor(SPArmorMaterial.plumArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("plum_helmet");
		SPItems.plum_chestplate = new SPItemArmor(SPArmorMaterial.plumArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("plum_chestplate");
		SPItems.plum_leggings = new SPItemArmor(SPArmorMaterial.plumArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("plum_leggings");
		SPItems.plum_boots = new SPItemArmor(SPArmorMaterial.plumArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("plum_boots");
		SPItems.plum = NonNullList.create();
		SPItems.plum.add(0, new ItemStack(SPItems.plum_helmet));
		SPItems.plum.add(1, new ItemStack(SPItems.plum_chestplate));
		SPItems.plum.add(2, new ItemStack(SPItems.plum_leggings));
		SPItems.plum.add(3, new ItemStack(SPItems.plum_boots));
		
		SPItems.poplar_helmet = new SPItemArmor(SPArmorMaterial.poplarArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("poplar_helmet");
		SPItems.poplar_chestplate = new SPItemArmor(SPArmorMaterial.poplarArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("poplar_chestplate");
		SPItems.poplar_leggings = new SPItemArmor(SPArmorMaterial.poplarArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("poplar_leggings");
		SPItems.poplar_boots = new SPItemArmor(SPArmorMaterial.poplarArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("poplar_boots");
		SPItems.poplar = NonNullList.create();
		SPItems.poplar.add(0, new ItemStack(SPItems.poplar_helmet));
		SPItems.poplar.add(1, new ItemStack(SPItems.poplar_chestplate));
		SPItems.poplar.add(2, new ItemStack(SPItems.poplar_leggings));
		SPItems.poplar.add(3, new ItemStack(SPItems.poplar_boots));
		
		SPItems.sequoia_helmet = new SPItemArmor(SPArmorMaterial.sequoiaArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("sequoia_helmet");
		SPItems.sequoia_chestplate = new SPItemArmor(SPArmorMaterial.sequoiaArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("sequoia_chestplate");
		SPItems.sequoia_leggings = new SPItemArmor(SPArmorMaterial.sequoiaArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("sequoia_leggings");
		SPItems.sequoia_boots = new SPItemArmor(SPArmorMaterial.sequoiaArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("sequoia_boots");
		SPItems.sequoia = NonNullList.create();
		SPItems.sequoia.add(0, new ItemStack(SPItems.sequoia_helmet));
		SPItems.sequoia.add(1, new ItemStack(SPItems.sequoia_chestplate));
		SPItems.sequoia.add(2, new ItemStack(SPItems.sequoia_leggings));
		SPItems.sequoia.add(3, new ItemStack(SPItems.sequoia_boots));
		
		SPItems.teak_helmet = new SPItemArmor(SPArmorMaterial.teakArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("teak_helmet");
		SPItems.teak_chestplate = new SPItemArmor(SPArmorMaterial.teakArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("teak_chestplate");
		SPItems.teak_leggings = new SPItemArmor(SPArmorMaterial.teakArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("teak_leggings");
		SPItems.teak_boots = new SPItemArmor(SPArmorMaterial.teakArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("teak_boots");
		SPItems.teak = NonNullList.create();
		SPItems.teak.add(0, new ItemStack(SPItems.teak_helmet));
		SPItems.teak.add(1, new ItemStack(SPItems.teak_chestplate));
		SPItems.teak.add(2, new ItemStack(SPItems.teak_leggings));
		SPItems.teak.add(3, new ItemStack(SPItems.teak_boots));
		
		SPItems.walnut_helmet = new SPItemArmor(SPArmorMaterial.walnutArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("walnut_helmet");
		SPItems.walnut_chestplate = new SPItemArmor(SPArmorMaterial.walnutArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("walnut_chestplate");
		SPItems.walnut_leggings = new SPItemArmor(SPArmorMaterial.walnutArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("walnut_leggings");
		SPItems.walnut_boots = new SPItemArmor(SPArmorMaterial.walnutArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("walnut_boots");
		SPItems.walnut = NonNullList.create();
		SPItems.walnut.add(0, new ItemStack(SPItems.walnut_helmet));
		SPItems.walnut.add(1, new ItemStack(SPItems.walnut_chestplate));
		SPItems.walnut.add(2, new ItemStack(SPItems.walnut_leggings));
		SPItems.walnut.add(3, new ItemStack(SPItems.walnut_boots));
		
		SPItems.wenge_helmet = new SPItemArmor(SPArmorMaterial.wengeArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("wenge_helmet");
		SPItems.wenge_chestplate = new SPItemArmor(SPArmorMaterial.wengeArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("wenge_chestplate");
		SPItems.wenge_leggings = new SPItemArmor(SPArmorMaterial.wengeArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("wenge_leggings");
		SPItems.wenge_boots = new SPItemArmor(SPArmorMaterial.wengeArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("wenge_boots");
		SPItems.wenge = NonNullList.create();
		SPItems.wenge.add(0, new ItemStack(SPItems.wenge_helmet));
		SPItems.wenge.add(1, new ItemStack(SPItems.wenge_chestplate));
		SPItems.wenge.add(2, new ItemStack(SPItems.wenge_leggings));
		SPItems.wenge.add(3, new ItemStack(SPItems.wenge_boots));
		
		SPItems.willow_helmet_forestry = new SPItemArmor(SPArmorMaterial.willowForestryArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("willow_helmet_forestry");
		SPItems.willow_chestplate_forestry = new SPItemArmor(SPArmorMaterial.willowForestryArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("willow_chestplate_forestry");
		SPItems.willow_leggings_forestry = new SPItemArmor(SPArmorMaterial.willowForestryArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("willow_leggings_forestry");
		SPItems.willow_boots_forestry = new SPItemArmor(SPArmorMaterial.willowForestryArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("willow_boots_forestry");
		SPItems.willow_forestry = NonNullList.create();
		SPItems.willow_forestry.add(0, new ItemStack(SPItems.willow_helmet_forestry));
		SPItems.willow_forestry.add(1, new ItemStack(SPItems.willow_chestplate_forestry));
		SPItems.willow_forestry.add(2, new ItemStack(SPItems.willow_leggings_forestry));
		SPItems.willow_forestry.add(3, new ItemStack(SPItems.willow_boots_forestry));
		
		SPItems.zebrawood_helmet = new SPItemArmor(SPArmorMaterial.zebrawoodArmorMaterial, EntityEquipmentSlot.HEAD).setRegistryName("zebrawood_helmet");
		SPItems.zebrawood_chestplate = new SPItemArmor(SPArmorMaterial.zebrawoodArmorMaterial, EntityEquipmentSlot.CHEST).setRegistryName("zebrawood_chestplate");
		SPItems.zebrawood_leggings = new SPItemArmor(SPArmorMaterial.zebrawoodArmorMaterial, EntityEquipmentSlot.LEGS).setRegistryName("zebrawood_leggings");
		SPItems.zebrawood_boots = new SPItemArmor(SPArmorMaterial.zebrawoodArmorMaterial, EntityEquipmentSlot.FEET).setRegistryName("zebrawood_boots");
		SPItems.zebrawood = NonNullList.create();
		SPItems.zebrawood.add(0, new ItemStack(SPItems.zebrawood_helmet));
		SPItems.zebrawood.add(1, new ItemStack(SPItems.zebrawood_chestplate));
		SPItems.zebrawood.add(2, new ItemStack(SPItems.zebrawood_leggings));
		SPItems.zebrawood.add(3, new ItemStack(SPItems.zebrawood_boots));
		
	}
	
	public static void register()
	{
		SurvivalPlusArmor.registerItem(SPItems.desert_acacia);
		SurvivalPlusArmor.registerItem(SPItems.balsa);
		SurvivalPlusArmor.registerItem(SPItems.baobab);
		SurvivalPlusArmor.registerItem(SPItems.cherry_forestry);
		SurvivalPlusArmor.registerItem(SPItems.chestnut);
		SurvivalPlusArmor.registerItem(SPItems.citrus);
		SurvivalPlusArmor.registerItem(SPItems.cocobolo);
		SurvivalPlusArmor.registerItem(SPItems.ebony_forestry);
		SurvivalPlusArmor.registerItem(SPItems.giant_sequoia);
		SurvivalPlusArmor.registerItem(SPItems.greenheart);
		SurvivalPlusArmor.registerItem(SPItems.ipe);
		SurvivalPlusArmor.registerItem(SPItems.kapok);
		SurvivalPlusArmor.registerItem(SPItems.larch);
		SurvivalPlusArmor.registerItem(SPItems.lime);
		SurvivalPlusArmor.registerItem(SPItems.mahoe);
		SurvivalPlusArmor.registerItem(SPItems.mahogany_forestry);
		SurvivalPlusArmor.registerItem(SPItems.maple);
		SurvivalPlusArmor.registerItem(SPItems.padauk);
		SurvivalPlusArmor.registerItem(SPItems.palm_forestry);
		SurvivalPlusArmor.registerItem(SPItems.papaya);
		SurvivalPlusArmor.registerItem(SPItems.pine_forestry);
		SurvivalPlusArmor.registerItem(SPItems.plum);
		SurvivalPlusArmor.registerItem(SPItems.poplar);
		SurvivalPlusArmor.registerItem(SPItems.sequoia);
		SurvivalPlusArmor.registerItem(SPItems.teak);
		SurvivalPlusArmor.registerItem(SPItems.walnut);
		SurvivalPlusArmor.registerItem(SPItems.wenge);
		SurvivalPlusArmor.registerItem(SPItems.willow_forestry);
		SurvivalPlusArmor.registerItem(SPItems.zebrawood);
		
	}

}
