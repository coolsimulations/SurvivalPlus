package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class TerrestriaArmor {
	
	public static void init() {
		
		SPItems.redwood_helmet_terrestria = new SPItemArmor(SPArmorMaterial.redwoodTerrestriaArmorMaterial, EquipmentSlot.HEAD);
		SPItems.redwood_chestplate_terrestria = new SPItemArmor(SPArmorMaterial.redwoodTerrestriaArmorMaterial, EquipmentSlot.CHEST);
		SPItems.redwood_leggings_terrestria = new SPItemArmor(SPArmorMaterial.redwoodTerrestriaArmorMaterial, EquipmentSlot.LEGS);
		SPItems.redwood_boots_terrestria = new SPItemArmor(SPArmorMaterial.redwoodTerrestriaArmorMaterial, EquipmentSlot.FEET);
		SPItems.redwood_terrestria = DefaultedList.of();
		SPItems.redwood_terrestria.add(0, new ItemStack(SPItems.redwood_helmet_terrestria));
		SPItems.redwood_terrestria.add(1, new ItemStack(SPItems.redwood_chestplate_terrestria));
		SPItems.redwood_terrestria.add(2, new ItemStack(SPItems.redwood_leggings_terrestria));
		SPItems.redwood_terrestria.add(3, new ItemStack(SPItems.redwood_boots_terrestria));
		
		SPItems.hemlock_helmet = new SPItemArmor(SPArmorMaterial.hemlockArmorMaterial, EquipmentSlot.HEAD);
		SPItems.hemlock_chestplate = new SPItemArmor(SPArmorMaterial.hemlockArmorMaterial, EquipmentSlot.CHEST);
		SPItems.hemlock_leggings = new SPItemArmor(SPArmorMaterial.hemlockArmorMaterial, EquipmentSlot.LEGS);
		SPItems.hemlock_boots = new SPItemArmor(SPArmorMaterial.hemlockArmorMaterial, EquipmentSlot.FEET);
		SPItems.hemlock = DefaultedList.of();
		SPItems.hemlock.add(0, new ItemStack(SPItems.hemlock_helmet));
		SPItems.hemlock.add(1, new ItemStack(SPItems.hemlock_chestplate));
		SPItems.hemlock.add(2, new ItemStack(SPItems.hemlock_leggings));
		SPItems.hemlock.add(3, new ItemStack(SPItems.hemlock_boots));
		
		SPItems.rubber_helmet_terrestria = new SPItemArmor(SPArmorMaterial.rubberTerrestriaArmorMaterial, EquipmentSlot.HEAD);
		SPItems.rubber_chestplate_terrestria = new SPItemArmor(SPArmorMaterial.rubberTerrestriaArmorMaterial, EquipmentSlot.CHEST);
		SPItems.rubber_leggings_terrestria = new SPItemArmor(SPArmorMaterial.rubberTerrestriaArmorMaterial, EquipmentSlot.LEGS);
		SPItems.rubber_boots_terrestria = new SPItemArmor(SPArmorMaterial.rubberTerrestriaArmorMaterial, EquipmentSlot.FEET);
		SPItems.rubber_terrestria = DefaultedList.of();
		SPItems.rubber_terrestria.add(0, new ItemStack(SPItems.rubber_helmet_terrestria));
		SPItems.rubber_terrestria.add(1, new ItemStack(SPItems.rubber_chestplate_terrestria));
		SPItems.rubber_terrestria.add(2, new ItemStack(SPItems.rubber_leggings_terrestria));
		SPItems.rubber_terrestria.add(3, new ItemStack(SPItems.rubber_boots_terrestria));
		
		SPItems.cypress_helmet = new SPItemArmor(SPArmorMaterial.cypressArmorMaterial, EquipmentSlot.HEAD);
		SPItems.cypress_chestplate = new SPItemArmor(SPArmorMaterial.cypressArmorMaterial, EquipmentSlot.CHEST);
		SPItems.cypress_leggings = new SPItemArmor(SPArmorMaterial.cypressArmorMaterial, EquipmentSlot.LEGS);
		SPItems.cypress_boots = new SPItemArmor(SPArmorMaterial.cypressArmorMaterial, EquipmentSlot.FEET);
		SPItems.cypress = DefaultedList.of();
		SPItems.cypress.add(0, new ItemStack(SPItems.cypress_helmet));
		SPItems.cypress.add(1, new ItemStack(SPItems.cypress_chestplate));
		SPItems.cypress.add(2, new ItemStack(SPItems.cypress_leggings));
		SPItems.cypress.add(3, new ItemStack(SPItems.cypress_boots));
		
		SPItems.willow_helmet_terrestria = new SPItemArmor(SPArmorMaterial.willowTerrestriaArmorMaterial, EquipmentSlot.HEAD);
		SPItems.willow_chestplate_terrestria = new SPItemArmor(SPArmorMaterial.willowTerrestriaArmorMaterial, EquipmentSlot.CHEST);
		SPItems.willow_leggings_terrestria = new SPItemArmor(SPArmorMaterial.willowTerrestriaArmorMaterial, EquipmentSlot.LEGS);
		SPItems.willow_boots_terrestria = new SPItemArmor(SPArmorMaterial.willowTerrestriaArmorMaterial, EquipmentSlot.FEET);
		SPItems.willow_terrestria = DefaultedList.of();
		SPItems.willow_terrestria.add(0, new ItemStack(SPItems.willow_helmet_terrestria));
		SPItems.willow_terrestria.add(1, new ItemStack(SPItems.willow_chestplate_terrestria));
		SPItems.willow_terrestria.add(2, new ItemStack(SPItems.willow_leggings_terrestria));
		SPItems.willow_terrestria.add(3, new ItemStack(SPItems.willow_boots_terrestria));
		
		SPItems.japanese_maple_helmet = new SPItemArmor(SPArmorMaterial.japaneseMapleArmorMaterial, EquipmentSlot.HEAD);
		SPItems.japanese_maple_chestplate = new SPItemArmor(SPArmorMaterial.japaneseMapleArmorMaterial, EquipmentSlot.CHEST);
		SPItems.japanese_maple_leggings = new SPItemArmor(SPArmorMaterial.japaneseMapleArmorMaterial, EquipmentSlot.LEGS);
		SPItems.japanese_maple_boots = new SPItemArmor(SPArmorMaterial.japaneseMapleArmorMaterial, EquipmentSlot.FEET);
		SPItems.japanese_maple = DefaultedList.of();
		SPItems.japanese_maple.add(0, new ItemStack(SPItems.japanese_maple_helmet));
		SPItems.japanese_maple.add(1, new ItemStack(SPItems.japanese_maple_chestplate));
		SPItems.japanese_maple.add(2, new ItemStack(SPItems.japanese_maple_leggings));
		SPItems.japanese_maple.add(3, new ItemStack(SPItems.japanese_maple_boots));
		
		SPItems.rainbow_eucalyptus_helmet = new SPItemArmor(SPArmorMaterial.rainbowEucalyptusArmorMaterial, EquipmentSlot.HEAD);
		SPItems.rainbow_eucalyptus_chestplate = new SPItemArmor(SPArmorMaterial.rainbowEucalyptusArmorMaterial, EquipmentSlot.CHEST);
		SPItems.rainbow_eucalyptus_leggings = new SPItemArmor(SPArmorMaterial.rainbowEucalyptusArmorMaterial, EquipmentSlot.LEGS);
		SPItems.rainbow_eucalyptus_boots = new SPItemArmor(SPArmorMaterial.rainbowEucalyptusArmorMaterial, EquipmentSlot.FEET);
		SPItems.rainbow_eucalyptus = DefaultedList.of();
		SPItems.rainbow_eucalyptus.add(0, new ItemStack(SPItems.rainbow_eucalyptus_helmet));
		SPItems.rainbow_eucalyptus.add(1, new ItemStack(SPItems.rainbow_eucalyptus_chestplate));
		SPItems.rainbow_eucalyptus.add(2, new ItemStack(SPItems.rainbow_eucalyptus_leggings));
		SPItems.rainbow_eucalyptus.add(3, new ItemStack(SPItems.rainbow_eucalyptus_boots));
		
		SPItems.sakura_helmet = new SPItemArmor(SPArmorMaterial.sakuraArmorMaterial, EquipmentSlot.HEAD);
		SPItems.sakura_chestplate = new SPItemArmor(SPArmorMaterial.sakuraArmorMaterial, EquipmentSlot.CHEST);
		SPItems.sakura_leggings = new SPItemArmor(SPArmorMaterial.sakuraArmorMaterial, EquipmentSlot.LEGS);
		SPItems.sakura_boots = new SPItemArmor(SPArmorMaterial.sakuraArmorMaterial, EquipmentSlot.FEET);
		SPItems.sakura = DefaultedList.of();
		SPItems.sakura.add(0, new ItemStack(SPItems.sakura_helmet));
		SPItems.sakura.add(1, new ItemStack(SPItems.sakura_chestplate));
		SPItems.sakura.add(2, new ItemStack(SPItems.sakura_leggings));
		SPItems.sakura.add(3, new ItemStack(SPItems.sakura_boots));
		
		SPItems.yucca_palm_helmet = new SPItemArmor(SPArmorMaterial.yuccaPalmArmorMaterial, EquipmentSlot.HEAD);
		SPItems.yucca_palm_chestplate = new SPItemArmor(SPArmorMaterial.yuccaPalmArmorMaterial, EquipmentSlot.CHEST);
		SPItems.yucca_palm_leggings = new SPItemArmor(SPArmorMaterial.yuccaPalmArmorMaterial, EquipmentSlot.LEGS);
		SPItems.yucca_palm_boots = new SPItemArmor(SPArmorMaterial.yuccaPalmArmorMaterial, EquipmentSlot.FEET);
		SPItems.yucca_palm = DefaultedList.of();
		SPItems.yucca_palm.add(0, new ItemStack(SPItems.yucca_palm_helmet));
		SPItems.yucca_palm.add(1, new ItemStack(SPItems.yucca_palm_chestplate));
		SPItems.yucca_palm.add(2, new ItemStack(SPItems.yucca_palm_leggings));
		SPItems.yucca_palm.add(3, new ItemStack(SPItems.yucca_palm_boots));
	}
	
	public static void register() {
		
		SurvivalPlusArmor.registerItem(SPItems.redwood_terrestria, "redwood", SPCompatibilityManager.TERRESTRIA_MODID);
		SurvivalPlusArmor.registerItem(SPItems.hemlock, "hemlock");
		SurvivalPlusArmor.registerItem(SPItems.rubber_terrestria, "rubber", SPCompatibilityManager.TERRESTRIA_MODID);
		SurvivalPlusArmor.registerItem(SPItems.cypress, "cypress");
		SurvivalPlusArmor.registerItem(SPItems.willow_terrestria, "willow", SPCompatibilityManager.TERRESTRIA_MODID);
		SurvivalPlusArmor.registerItem(SPItems.japanese_maple, "japanese_maple");
		SurvivalPlusArmor.registerItem(SPItems.rainbow_eucalyptus, "rainbow_eucalyptus");
		SurvivalPlusArmor.registerItem(SPItems.sakura, "sakura");
		SurvivalPlusArmor.registerItem(SPItems.yucca_palm, "yucca_palm");
	}

}
