package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ItemStack;

public class TerrestriaArmor {
	
	public static void init() {
		
		SPItems.redwood_helmet_terrestria = new SPItemArmor(SPArmorMaterial.redwoodTerrestriaArmorMaterial, Type.HELMET);
		SPItems.redwood_chestplate_terrestria = new SPItemArmor(SPArmorMaterial.redwoodTerrestriaArmorMaterial, Type.CHESTPLATE);
		SPItems.redwood_leggings_terrestria = new SPItemArmor(SPArmorMaterial.redwoodTerrestriaArmorMaterial, Type.LEGGINGS);
		SPItems.redwood_boots_terrestria = new SPItemArmor(SPArmorMaterial.redwoodTerrestriaArmorMaterial, Type.BOOTS);
		SPItems.redwood_terrestria = NonNullList.create();
		SPItems.redwood_terrestria.add(0, new ItemStack(SPItems.redwood_helmet_terrestria));
		SPItems.redwood_terrestria.add(1, new ItemStack(SPItems.redwood_chestplate_terrestria));
		SPItems.redwood_terrestria.add(2, new ItemStack(SPItems.redwood_leggings_terrestria));
		SPItems.redwood_terrestria.add(3, new ItemStack(SPItems.redwood_boots_terrestria));
		
		SPItems.hemlock_helmet = new SPItemArmor(SPArmorMaterial.hemlockArmorMaterial, Type.HELMET);
		SPItems.hemlock_chestplate = new SPItemArmor(SPArmorMaterial.hemlockArmorMaterial, Type.CHESTPLATE);
		SPItems.hemlock_leggings = new SPItemArmor(SPArmorMaterial.hemlockArmorMaterial, Type.LEGGINGS);
		SPItems.hemlock_boots = new SPItemArmor(SPArmorMaterial.hemlockArmorMaterial, Type.BOOTS);
		SPItems.hemlock = NonNullList.create();
		SPItems.hemlock.add(0, new ItemStack(SPItems.hemlock_helmet));
		SPItems.hemlock.add(1, new ItemStack(SPItems.hemlock_chestplate));
		SPItems.hemlock.add(2, new ItemStack(SPItems.hemlock_leggings));
		SPItems.hemlock.add(3, new ItemStack(SPItems.hemlock_boots));
		
		SPItems.rubber_helmet_terrestria = new SPItemArmor(SPArmorMaterial.rubberTerrestriaArmorMaterial, Type.HELMET);
		SPItems.rubber_chestplate_terrestria = new SPItemArmor(SPArmorMaterial.rubberTerrestriaArmorMaterial, Type.CHESTPLATE);
		SPItems.rubber_leggings_terrestria = new SPItemArmor(SPArmorMaterial.rubberTerrestriaArmorMaterial, Type.LEGGINGS);
		SPItems.rubber_boots_terrestria = new SPItemArmor(SPArmorMaterial.rubberTerrestriaArmorMaterial, Type.BOOTS);
		SPItems.rubber_terrestria = NonNullList.create();
		SPItems.rubber_terrestria.add(0, new ItemStack(SPItems.rubber_helmet_terrestria));
		SPItems.rubber_terrestria.add(1, new ItemStack(SPItems.rubber_chestplate_terrestria));
		SPItems.rubber_terrestria.add(2, new ItemStack(SPItems.rubber_leggings_terrestria));
		SPItems.rubber_terrestria.add(3, new ItemStack(SPItems.rubber_boots_terrestria));
		
		SPItems.cypress_helmet = new SPItemArmor(SPArmorMaterial.cypressArmorMaterial, Type.HELMET);
		SPItems.cypress_chestplate = new SPItemArmor(SPArmorMaterial.cypressArmorMaterial, Type.CHESTPLATE);
		SPItems.cypress_leggings = new SPItemArmor(SPArmorMaterial.cypressArmorMaterial, Type.LEGGINGS);
		SPItems.cypress_boots = new SPItemArmor(SPArmorMaterial.cypressArmorMaterial, Type.BOOTS);
		SPItems.cypress = NonNullList.create();
		SPItems.cypress.add(0, new ItemStack(SPItems.cypress_helmet));
		SPItems.cypress.add(1, new ItemStack(SPItems.cypress_chestplate));
		SPItems.cypress.add(2, new ItemStack(SPItems.cypress_leggings));
		SPItems.cypress.add(3, new ItemStack(SPItems.cypress_boots));
		
		SPItems.willow_helmet_terrestria = new SPItemArmor(SPArmorMaterial.willowTerrestriaArmorMaterial, Type.HELMET);
		SPItems.willow_chestplate_terrestria = new SPItemArmor(SPArmorMaterial.willowTerrestriaArmorMaterial, Type.CHESTPLATE);
		SPItems.willow_leggings_terrestria = new SPItemArmor(SPArmorMaterial.willowTerrestriaArmorMaterial, Type.LEGGINGS);
		SPItems.willow_boots_terrestria = new SPItemArmor(SPArmorMaterial.willowTerrestriaArmorMaterial, Type.BOOTS);
		SPItems.willow_terrestria = NonNullList.create();
		SPItems.willow_terrestria.add(0, new ItemStack(SPItems.willow_helmet_terrestria));
		SPItems.willow_terrestria.add(1, new ItemStack(SPItems.willow_chestplate_terrestria));
		SPItems.willow_terrestria.add(2, new ItemStack(SPItems.willow_leggings_terrestria));
		SPItems.willow_terrestria.add(3, new ItemStack(SPItems.willow_boots_terrestria));
		
		SPItems.japanese_maple_helmet = new SPItemArmor(SPArmorMaterial.japaneseMapleArmorMaterial, Type.HELMET);
		SPItems.japanese_maple_chestplate = new SPItemArmor(SPArmorMaterial.japaneseMapleArmorMaterial, Type.CHESTPLATE);
		SPItems.japanese_maple_leggings = new SPItemArmor(SPArmorMaterial.japaneseMapleArmorMaterial, Type.LEGGINGS);
		SPItems.japanese_maple_boots = new SPItemArmor(SPArmorMaterial.japaneseMapleArmorMaterial, Type.BOOTS);
		SPItems.japanese_maple = NonNullList.create();
		SPItems.japanese_maple.add(0, new ItemStack(SPItems.japanese_maple_helmet));
		SPItems.japanese_maple.add(1, new ItemStack(SPItems.japanese_maple_chestplate));
		SPItems.japanese_maple.add(2, new ItemStack(SPItems.japanese_maple_leggings));
		SPItems.japanese_maple.add(3, new ItemStack(SPItems.japanese_maple_boots));
		
		SPItems.rainbow_eucalyptus_helmet = new SPItemArmor(SPArmorMaterial.rainbowEucalyptusArmorMaterial, Type.HELMET);
		SPItems.rainbow_eucalyptus_chestplate = new SPItemArmor(SPArmorMaterial.rainbowEucalyptusArmorMaterial, Type.CHESTPLATE);
		SPItems.rainbow_eucalyptus_leggings = new SPItemArmor(SPArmorMaterial.rainbowEucalyptusArmorMaterial, Type.LEGGINGS);
		SPItems.rainbow_eucalyptus_boots = new SPItemArmor(SPArmorMaterial.rainbowEucalyptusArmorMaterial, Type.BOOTS);
		SPItems.rainbow_eucalyptus = NonNullList.create();
		SPItems.rainbow_eucalyptus.add(0, new ItemStack(SPItems.rainbow_eucalyptus_helmet));
		SPItems.rainbow_eucalyptus.add(1, new ItemStack(SPItems.rainbow_eucalyptus_chestplate));
		SPItems.rainbow_eucalyptus.add(2, new ItemStack(SPItems.rainbow_eucalyptus_leggings));
		SPItems.rainbow_eucalyptus.add(3, new ItemStack(SPItems.rainbow_eucalyptus_boots));
		
		SPItems.sakura_helmet = new SPItemArmor(SPArmorMaterial.sakuraArmorMaterial, Type.HELMET);
		SPItems.sakura_chestplate = new SPItemArmor(SPArmorMaterial.sakuraArmorMaterial, Type.CHESTPLATE);
		SPItems.sakura_leggings = new SPItemArmor(SPArmorMaterial.sakuraArmorMaterial, Type.LEGGINGS);
		SPItems.sakura_boots = new SPItemArmor(SPArmorMaterial.sakuraArmorMaterial, Type.BOOTS);
		SPItems.sakura = NonNullList.create();
		SPItems.sakura.add(0, new ItemStack(SPItems.sakura_helmet));
		SPItems.sakura.add(1, new ItemStack(SPItems.sakura_chestplate));
		SPItems.sakura.add(2, new ItemStack(SPItems.sakura_leggings));
		SPItems.sakura.add(3, new ItemStack(SPItems.sakura_boots));
		
		SPItems.yucca_palm_helmet = new SPItemArmor(SPArmorMaterial.yuccaPalmArmorMaterial, Type.HELMET);
		SPItems.yucca_palm_chestplate = new SPItemArmor(SPArmorMaterial.yuccaPalmArmorMaterial, Type.CHESTPLATE);
		SPItems.yucca_palm_leggings = new SPItemArmor(SPArmorMaterial.yuccaPalmArmorMaterial, Type.LEGGINGS);
		SPItems.yucca_palm_boots = new SPItemArmor(SPArmorMaterial.yuccaPalmArmorMaterial, Type.BOOTS);
		SPItems.yucca_palm = NonNullList.create();
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
