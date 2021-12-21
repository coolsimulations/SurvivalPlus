package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;

public class BOPArmor {
	
	public static void init(){
		
		SPItems.cherry_helmet = new SPItemArmor(SPArmorMaterial.cherryArmorMaterial, EquipmentSlot.HEAD).setRegistryName("cherry_helmet");
		SPItems.cherry_chestplate = new SPItemArmor(SPArmorMaterial.cherryArmorMaterial, EquipmentSlot.CHEST).setRegistryName("cherry_chestplate");
		SPItems.cherry_leggings = new SPItemArmor(SPArmorMaterial.cherryArmorMaterial, EquipmentSlot.LEGS).setRegistryName("cherry_leggings");
		SPItems.cherry_boots = new SPItemArmor(SPArmorMaterial.cherryArmorMaterial, EquipmentSlot.FEET).setRegistryName("cherry_boots");
		SPItems.cherry = NonNullList.create();
		SPItems.cherry.add(0, new ItemStack(SPItems.cherry_helmet));
		SPItems.cherry.add(1, new ItemStack(SPItems.cherry_chestplate));
		SPItems.cherry.add(2, new ItemStack(SPItems.cherry_leggings));
		SPItems.cherry.add(3, new ItemStack(SPItems.cherry_boots));
		
		SPItems.dead_helmet = new SPItemArmor(SPArmorMaterial.deadArmorMaterial, EquipmentSlot.HEAD).setRegistryName("dead_helmet");
		SPItems.dead_chestplate = new SPItemArmor(SPArmorMaterial.deadArmorMaterial, EquipmentSlot.CHEST).setRegistryName("dead_chestplate");
		SPItems.dead_leggings = new SPItemArmor(SPArmorMaterial.deadArmorMaterial, EquipmentSlot.LEGS).setRegistryName("dead_leggings");
		SPItems.dead_boots = new SPItemArmor(SPArmorMaterial.deadArmorMaterial, EquipmentSlot.FEET).setRegistryName("dead_boots");
		SPItems.dead = NonNullList.create();
		SPItems.dead.add(0, new ItemStack(SPItems.dead_helmet));
		SPItems.dead.add(1, new ItemStack(SPItems.dead_chestplate));
		SPItems.dead.add(2, new ItemStack(SPItems.dead_leggings));
		SPItems.dead.add(3, new ItemStack(SPItems.dead_boots));

		SPItems.fir_helmet = new SPItemArmor(SPArmorMaterial.firArmorMaterial, EquipmentSlot.HEAD).setRegistryName("fir_helmet");
		SPItems.fir_chestplate = new SPItemArmor(SPArmorMaterial.firArmorMaterial, EquipmentSlot.CHEST).setRegistryName("fir_chestplate");
		SPItems.fir_leggings = new SPItemArmor(SPArmorMaterial.firArmorMaterial, EquipmentSlot.LEGS).setRegistryName("fir_leggings");
		SPItems.fir_boots = new SPItemArmor(SPArmorMaterial.firArmorMaterial, EquipmentSlot.FEET).setRegistryName("fir_boots");
		SPItems.fir = NonNullList.create();
		SPItems.fir.add(0, new ItemStack(SPItems.fir_helmet));
		SPItems.fir.add(1, new ItemStack(SPItems.fir_chestplate));
		SPItems.fir.add(2, new ItemStack(SPItems.fir_leggings));
		SPItems.fir.add(3, new ItemStack(SPItems.fir_boots));

		SPItems.hellbark_helmet = new SPItemArmor(SPArmorMaterial.hellbarkArmorMaterial, EquipmentSlot.HEAD).setRegistryName("hellbark_helmet");
		SPItems.hellbark_chestplate = new SPItemArmor(SPArmorMaterial.hellbarkArmorMaterial, EquipmentSlot.CHEST).setRegistryName("hellbark_chestplate");
		SPItems.hellbark_leggings = new SPItemArmor(SPArmorMaterial.hellbarkArmorMaterial, EquipmentSlot.LEGS).setRegistryName("hellbark_leggings");
		SPItems.hellbark_boots = new SPItemArmor(SPArmorMaterial.hellbarkArmorMaterial, EquipmentSlot.FEET).setRegistryName("hellbark_boots");
		SPItems.hellbark = NonNullList.create();
		SPItems.hellbark.add(0, new ItemStack(SPItems.hellbark_helmet));
		SPItems.hellbark.add(1, new ItemStack(SPItems.hellbark_chestplate));
		SPItems.hellbark.add(2, new ItemStack(SPItems.hellbark_leggings));
		SPItems.hellbark.add(3, new ItemStack(SPItems.hellbark_boots));

		SPItems.jacaranda_helmet = new SPItemArmor(SPArmorMaterial.jacarandaArmorMaterial, EquipmentSlot.HEAD).setRegistryName("jacaranda_helmet");
		SPItems.jacaranda_chestplate = new SPItemArmor(SPArmorMaterial.jacarandaArmorMaterial, EquipmentSlot.CHEST).setRegistryName("jacaranda_chestplate");
		SPItems.jacaranda_leggings = new SPItemArmor(SPArmorMaterial.jacarandaArmorMaterial, EquipmentSlot.LEGS).setRegistryName("jacaranda_leggings");
		SPItems.jacaranda_boots = new SPItemArmor(SPArmorMaterial.jacarandaArmorMaterial, EquipmentSlot.FEET).setRegistryName("jacaranda_boots");
		SPItems.jacaranda = NonNullList.create();
		SPItems.jacaranda.add(0, new ItemStack(SPItems.jacaranda_helmet));
		SPItems.jacaranda.add(1, new ItemStack(SPItems.jacaranda_chestplate));
		SPItems.jacaranda.add(2, new ItemStack(SPItems.jacaranda_leggings));
		SPItems.jacaranda.add(3, new ItemStack(SPItems.jacaranda_boots));

		SPItems.magic_helmet = new SPItemArmor(SPArmorMaterial.magicArmorMaterial, EquipmentSlot.HEAD).setRegistryName("magic_helmet");
		SPItems.magic_chestplate = new SPItemArmor(SPArmorMaterial.magicArmorMaterial, EquipmentSlot.CHEST).setRegistryName("magic_chestplate");
		SPItems.magic_leggings = new SPItemArmor(SPArmorMaterial.magicArmorMaterial, EquipmentSlot.LEGS).setRegistryName("magic_leggings");
		SPItems.magic_boots = new SPItemArmor(SPArmorMaterial.magicArmorMaterial, EquipmentSlot.FEET).setRegistryName("magic_boots");
		SPItems.magic = NonNullList.create();
		SPItems.magic.add(0, new ItemStack(SPItems.magic_helmet));
		SPItems.magic.add(1, new ItemStack(SPItems.magic_chestplate));
		SPItems.magic.add(2, new ItemStack(SPItems.magic_leggings));
		SPItems.magic.add(3, new ItemStack(SPItems.magic_boots));

		SPItems.mahogany_helmet = new SPItemArmor(SPArmorMaterial.mahoganyArmorMaterial, EquipmentSlot.HEAD).setRegistryName("mahogany_helmet");
		SPItems.mahogany_chestplate = new SPItemArmor(SPArmorMaterial.mahoganyArmorMaterial, EquipmentSlot.CHEST).setRegistryName("mahogany_chestplate");
		SPItems.mahogany_leggings = new SPItemArmor(SPArmorMaterial.mahoganyArmorMaterial, EquipmentSlot.LEGS).setRegistryName("mahogany_leggings");
		SPItems.mahogany_boots = new SPItemArmor(SPArmorMaterial.mahoganyArmorMaterial, EquipmentSlot.FEET).setRegistryName("mahogany_boots");
		SPItems.mahogany = NonNullList.create();
		SPItems.mahogany.add(0, new ItemStack(SPItems.mahogany_helmet));
		SPItems.mahogany.add(1, new ItemStack(SPItems.mahogany_chestplate));
		SPItems.mahogany.add(2, new ItemStack(SPItems.mahogany_leggings));
		SPItems.mahogany.add(3, new ItemStack(SPItems.mahogany_boots));

		SPItems.palm_helmet = new SPItemArmor(SPArmorMaterial.palmArmorMaterial, EquipmentSlot.HEAD).setRegistryName("palm_helmet");
		SPItems.palm_chestplate = new SPItemArmor(SPArmorMaterial.palmArmorMaterial, EquipmentSlot.CHEST).setRegistryName("palm_chestplate");
		SPItems.palm_leggings = new SPItemArmor(SPArmorMaterial.palmArmorMaterial, EquipmentSlot.LEGS).setRegistryName("palm_leggings");
		SPItems.palm_boots = new SPItemArmor(SPArmorMaterial.palmArmorMaterial, EquipmentSlot.FEET).setRegistryName("palm_boots");
		SPItems.palm = NonNullList.create();
		SPItems.palm.add(0, new ItemStack(SPItems.palm_helmet));
		SPItems.palm.add(1, new ItemStack(SPItems.palm_chestplate));
		SPItems.palm.add(2, new ItemStack(SPItems.palm_leggings));
		SPItems.palm.add(3, new ItemStack(SPItems.palm_boots));

		SPItems.redwood_helmet = new SPItemArmor(SPArmorMaterial.redwoodArmorMaterial, EquipmentSlot.HEAD).setRegistryName("redwood_helmet");
		SPItems.redwood_chestplate = new SPItemArmor(SPArmorMaterial.redwoodArmorMaterial, EquipmentSlot.CHEST).setRegistryName("redwood_chestplate");
		SPItems.redwood_leggings = new SPItemArmor(SPArmorMaterial.redwoodArmorMaterial, EquipmentSlot.LEGS).setRegistryName("redwood_leggings");
		SPItems.redwood_boots = new SPItemArmor(SPArmorMaterial.redwoodArmorMaterial, EquipmentSlot.FEET).setRegistryName("redwood_boots");
		SPItems.redwood = NonNullList.create();
		SPItems.redwood.add(0, new ItemStack(SPItems.redwood_helmet));
		SPItems.redwood.add(1, new ItemStack(SPItems.redwood_chestplate));
		SPItems.redwood.add(2, new ItemStack(SPItems.redwood_leggings));
		SPItems.redwood.add(3, new ItemStack(SPItems.redwood_boots));

		SPItems.umbran_helmet = new SPItemArmor(SPArmorMaterial.umbranArmorMaterial, EquipmentSlot.HEAD).setRegistryName("umbran_helmet");
		SPItems.umbran_chestplate = new SPItemArmor(SPArmorMaterial.umbranArmorMaterial, EquipmentSlot.CHEST).setRegistryName("umbran_chestplate");
		SPItems.umbran_leggings = new SPItemArmor(SPArmorMaterial.umbranArmorMaterial, EquipmentSlot.LEGS).setRegistryName("umbran_leggings");
		SPItems.umbran_boots = new SPItemArmor(SPArmorMaterial.umbranArmorMaterial, EquipmentSlot.FEET).setRegistryName("umbran_boots");
		SPItems.umbran = NonNullList.create();
		SPItems.umbran.add(0, new ItemStack(SPItems.umbran_helmet));
		SPItems.umbran.add(1, new ItemStack(SPItems.umbran_chestplate));
		SPItems.umbran.add(2, new ItemStack(SPItems.umbran_leggings));
		SPItems.umbran.add(3, new ItemStack(SPItems.umbran_boots));

		SPItems.willow_helmet = new SPItemArmor(SPArmorMaterial.willowArmorMaterial, EquipmentSlot.HEAD).setRegistryName("willow_helmet");
		SPItems.willow_chestplate = new SPItemArmor(SPArmorMaterial.willowArmorMaterial, EquipmentSlot.CHEST).setRegistryName("willow_chestplate");
		SPItems.willow_leggings = new SPItemArmor(SPArmorMaterial.willowArmorMaterial, EquipmentSlot.LEGS).setRegistryName("willow_leggings");
		SPItems.willow_boots = new SPItemArmor(SPArmorMaterial.willowArmorMaterial, EquipmentSlot.FEET).setRegistryName("willow_boots");
		SPItems.willow = NonNullList.create();
		SPItems.willow.add(0, new ItemStack(SPItems.willow_helmet));
		SPItems.willow.add(1, new ItemStack(SPItems.willow_chestplate));
		SPItems.willow.add(2, new ItemStack(SPItems.willow_leggings));
		SPItems.willow.add(3, new ItemStack(SPItems.willow_boots));
		
		if(SPCompatibilityManager.isBopExtrasLoaded()) {
			
			SPItems.ebony_helmet = new SPItemArmor(SPArmorMaterial.ebonyArmorMaterial, EquipmentSlot.HEAD).setRegistryName("ebony_helmet");
			SPItems.ebony_chestplate = new SPItemArmor(SPArmorMaterial.ebonyArmorMaterial, EquipmentSlot.CHEST).setRegistryName("ebony_chestplate");
			SPItems.ebony_leggings = new SPItemArmor(SPArmorMaterial.ebonyArmorMaterial, EquipmentSlot.LEGS).setRegistryName("ebony_leggings");
			SPItems.ebony_boots = new SPItemArmor(SPArmorMaterial.ebonyArmorMaterial, EquipmentSlot.FEET).setRegistryName("ebony_boots");
			SPItems.ebony = NonNullList.create();
			SPItems.ebony.add(0, new ItemStack(SPItems.ebony_helmet));
			SPItems.ebony.add(1, new ItemStack(SPItems.ebony_chestplate));
			SPItems.ebony.add(2, new ItemStack(SPItems.ebony_leggings));
			SPItems.ebony.add(3, new ItemStack(SPItems.ebony_boots));
			
			SPItems.eucalyptus_helmet = new SPItemArmor(SPArmorMaterial.eucalyptusArmorMaterial, EquipmentSlot.HEAD).setRegistryName("eucalyptus_helmet");
			SPItems.eucalyptus_chestplate = new SPItemArmor(SPArmorMaterial.eucalyptusArmorMaterial, EquipmentSlot.CHEST).setRegistryName("eucalyptus_chestplate");
			SPItems.eucalyptus_leggings = new SPItemArmor(SPArmorMaterial.eucalyptusArmorMaterial, EquipmentSlot.LEGS).setRegistryName("eucalyptus_leggings");
			SPItems.eucalyptus_boots = new SPItemArmor(SPArmorMaterial.eucalyptusArmorMaterial, EquipmentSlot.FEET).setRegistryName("eucalyptus_boots");
			SPItems.eucalyptus = NonNullList.create();
			SPItems.eucalyptus.add(0, new ItemStack(SPItems.eucalyptus_helmet));
			SPItems.eucalyptus.add(1, new ItemStack(SPItems.eucalyptus_chestplate));
			SPItems.eucalyptus.add(2, new ItemStack(SPItems.eucalyptus_leggings));
			SPItems.eucalyptus.add(3, new ItemStack(SPItems.eucalyptus_boots));
			
			SPItems.mangrove_helmet = new SPItemArmor(SPArmorMaterial.mangroveArmorMaterial, EquipmentSlot.HEAD).setRegistryName("mangrove_helmet");
			SPItems.mangrove_chestplate = new SPItemArmor(SPArmorMaterial.mangroveArmorMaterial, EquipmentSlot.CHEST).setRegistryName("mangrove_chestplate");
			SPItems.mangrove_leggings = new SPItemArmor(SPArmorMaterial.mangroveArmorMaterial, EquipmentSlot.LEGS).setRegistryName("mangrove_leggings");
			SPItems.mangrove_boots = new SPItemArmor(SPArmorMaterial.mangroveArmorMaterial, EquipmentSlot.FEET).setRegistryName("mangrove_boots");
			SPItems.mangrove = NonNullList.create();
			SPItems.mangrove.add(0, new ItemStack(SPItems.mangrove_helmet));
			SPItems.mangrove.add(1, new ItemStack(SPItems.mangrove_chestplate));
			SPItems.mangrove.add(2, new ItemStack(SPItems.mangrove_leggings));
			SPItems.mangrove.add(3, new ItemStack(SPItems.mangrove_boots));
			
			SPItems.pine_helmet = new SPItemArmor(SPArmorMaterial.pineArmorMaterial, EquipmentSlot.HEAD).setRegistryName("pine_helmet");
			SPItems.pine_chestplate = new SPItemArmor(SPArmorMaterial.pineArmorMaterial, EquipmentSlot.CHEST).setRegistryName("pine_chestplate");
			SPItems.pine_leggings = new SPItemArmor(SPArmorMaterial.pineArmorMaterial, EquipmentSlot.LEGS).setRegistryName("pine_leggings");
			SPItems.pine_boots = new SPItemArmor(SPArmorMaterial.pineArmorMaterial, EquipmentSlot.FEET).setRegistryName("pine_boots");
			SPItems.pine = NonNullList.create();
			SPItems.pine.add(0, new ItemStack(SPItems.pine_helmet));
			SPItems.pine.add(1, new ItemStack(SPItems.pine_chestplate));
			SPItems.pine.add(2, new ItemStack(SPItems.pine_leggings));
			SPItems.pine.add(3, new ItemStack(SPItems.pine_boots));
			
			SPItems.sacred_oak_helmet = new SPItemArmor(SPArmorMaterial.sacredOakArmorMaterial, EquipmentSlot.HEAD).setRegistryName("sacred_oak_helmet");
			SPItems.sacred_oak_chestplate = new SPItemArmor(SPArmorMaterial.sacredOakArmorMaterial, EquipmentSlot.CHEST).setRegistryName("sacred_oak_chestplate");
			SPItems.sacred_oak_leggings = new SPItemArmor(SPArmorMaterial.sacredOakArmorMaterial, EquipmentSlot.LEGS).setRegistryName("sacred_oak_leggings");
			SPItems.sacred_oak_boots = new SPItemArmor(SPArmorMaterial.sacredOakArmorMaterial, EquipmentSlot.FEET).setRegistryName("sacred_oak_boots");
			SPItems.sacred_oak = NonNullList.create();
			SPItems.sacred_oak.add(0, new ItemStack(SPItems.sacred_oak_helmet));
			SPItems.sacred_oak.add(1, new ItemStack(SPItems.sacred_oak_chestplate));
			SPItems.sacred_oak.add(2, new ItemStack(SPItems.sacred_oak_leggings));
			SPItems.sacred_oak.add(3, new ItemStack(SPItems.sacred_oak_boots));
			
			SPItems.ethereal_helmet = new SPItemArmor(SPArmorMaterial.etherealArmorMaterial, EquipmentSlot.HEAD).setRegistryName("ethereal_helmet");
			SPItems.ethereal_chestplate = new SPItemArmor(SPArmorMaterial.etherealArmorMaterial, EquipmentSlot.CHEST).setRegistryName("ethereal_chestplate");
			SPItems.ethereal_leggings = new SPItemArmor(SPArmorMaterial.etherealArmorMaterial, EquipmentSlot.LEGS).setRegistryName("ethereal_leggings");
			SPItems.ethereal_boots = new SPItemArmor(SPArmorMaterial.etherealArmorMaterial, EquipmentSlot.FEET).setRegistryName("ethereal_boots");
			SPItems.ethereal = NonNullList.create();
			SPItems.ethereal.add(0, new ItemStack(SPItems.ethereal_helmet));
			SPItems.ethereal.add(1, new ItemStack(SPItems.ethereal_chestplate));
			SPItems.ethereal.add(2, new ItemStack(SPItems.ethereal_leggings));
			SPItems.ethereal.add(3, new ItemStack(SPItems.ethereal_boots));
		}
	}
	
	public static void register()
	{
		SurvivalPlusArmor.registerItem(SPItems.cherry);
		SurvivalPlusArmor.registerItem(SPItems.dead);
		SurvivalPlusArmor.registerItem(SPItems.fir);
		SurvivalPlusArmor.registerItem(SPItems.hellbark);
		SurvivalPlusArmor.registerItem(SPItems.jacaranda);
		SurvivalPlusArmor.registerItem(SPItems.magic);
		SurvivalPlusArmor.registerItem(SPItems.mahogany);
		SurvivalPlusArmor.registerItem(SPItems.palm);
		SurvivalPlusArmor.registerItem(SPItems.redwood);
		SurvivalPlusArmor.registerItem(SPItems.umbran);
		SurvivalPlusArmor.registerItem(SPItems.willow);
		
		if(SPCompatibilityManager.isBopExtrasLoaded()) {
			
			SurvivalPlusArmor.registerItem(SPItems.ebony);
			SurvivalPlusArmor.registerItem(SPItems.eucalyptus);
			SurvivalPlusArmor.registerItem(SPItems.mangrove);
			SurvivalPlusArmor.registerItem(SPItems.pine);
			SurvivalPlusArmor.registerItem(SPItems.sacred_oak);
			SurvivalPlusArmor.registerItem(SPItems.ethereal);
		}
	}

}
