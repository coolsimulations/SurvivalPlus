package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusArmor {

	public static void init(){

		SPItems.bronze_helmet = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, EquipmentSlot.HEAD).setRegistryName("bronze_helmet");
		SPItems.bronze_chestplate = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, EquipmentSlot.CHEST).setRegistryName("bronze_chestplate");
		SPItems.bronze_leggings = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, EquipmentSlot.LEGS).setRegistryName("bronze_leggings");
		SPItems.bronze_boots = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, EquipmentSlot.FEET).setRegistryName("bronze_boots");
		SPItems.bronze = NonNullList.create();
		SPItems.bronze.add(0, new ItemStack(SPItems.bronze_helmet));
		SPItems.bronze.add(1, new ItemStack(SPItems.bronze_chestplate));
		SPItems.bronze.add(2, new ItemStack(SPItems.bronze_leggings));
		SPItems.bronze.add(3, new ItemStack(SPItems.bronze_boots));

		SPItems.stone_helmet = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, EquipmentSlot.HEAD).setRegistryName("stone_helmet");
		SPItems.stone_chestplate = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, EquipmentSlot.CHEST).setRegistryName("stone_chestplate");
		SPItems.stone_leggings = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, EquipmentSlot.LEGS).setRegistryName("stone_leggings");
		SPItems.stone_boots = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, EquipmentSlot.FEET).setRegistryName("stone_boots");
		SPItems.stone = NonNullList.create();
		SPItems.stone.add(0, new ItemStack(SPItems.stone_helmet));
		SPItems.stone.add(1, new ItemStack(SPItems.stone_chestplate));
		SPItems.stone.add(2, new ItemStack(SPItems.stone_leggings));
		SPItems.stone.add(3, new ItemStack(SPItems.stone_boots));

		SPItems.titanium_helmet = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, EquipmentSlot.HEAD).setRegistryName("titanium_helmet");
		SPItems.titanium_chestplate = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, EquipmentSlot.CHEST).setRegistryName("titanium_chestplate");
		SPItems.titanium_leggings = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, EquipmentSlot.LEGS).setRegistryName("titanium_leggings");
		SPItems.titanium_boots = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, EquipmentSlot.FEET).setRegistryName("titanium_boots");
		SPItems.titanium = NonNullList.create();
		SPItems.titanium.add(0, new ItemStack(SPItems.titanium_helmet));
		SPItems.titanium.add(1, new ItemStack(SPItems.titanium_chestplate));
		SPItems.titanium.add(2, new ItemStack(SPItems.titanium_leggings));
		SPItems.titanium.add(3, new ItemStack(SPItems.titanium_boots));

		SPItems.oak_helmet = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, EquipmentSlot.HEAD).setRegistryName("oak_helmet");
		SPItems.oak_chestplate = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, EquipmentSlot.CHEST).setRegistryName("oak_chestplate");
		SPItems.oak_leggings = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, EquipmentSlot.LEGS).setRegistryName("oak_leggings");
		SPItems.oak_boots = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, EquipmentSlot.FEET).setRegistryName("oak_boots");
		SPItems.oak = NonNullList.create();
		SPItems.oak.add(0, new ItemStack(SPItems.oak_helmet));
		SPItems.oak.add(1, new ItemStack(SPItems.oak_chestplate));
		SPItems.oak.add(2, new ItemStack(SPItems.oak_leggings));
		SPItems.oak.add(3, new ItemStack(SPItems.oak_boots));

		SPItems.spruce_helmet = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, EquipmentSlot.HEAD).setRegistryName("spruce_helmet");
		SPItems.spruce_chestplate = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, EquipmentSlot.CHEST).setRegistryName("spruce_chestplate");
		SPItems.spruce_leggings = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, EquipmentSlot.LEGS).setRegistryName("spruce_leggings");
		SPItems.spruce_boots = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, EquipmentSlot.FEET).setRegistryName("spruce_boots");
		SPItems.spruce = NonNullList.create();
		SPItems.spruce.add(0, new ItemStack(SPItems.spruce_helmet));
		SPItems.spruce.add(1, new ItemStack(SPItems.spruce_chestplate));
		SPItems.spruce.add(2, new ItemStack(SPItems.spruce_leggings));
		SPItems.spruce.add(3, new ItemStack(SPItems.spruce_boots));

		SPItems.birch_helmet = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, EquipmentSlot.HEAD).setRegistryName("birch_helmet");
		SPItems.birch_chestplate = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, EquipmentSlot.CHEST).setRegistryName("birch_chestplate");
		SPItems.birch_leggings = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, EquipmentSlot.LEGS).setRegistryName("birch_leggings");
		SPItems.birch_boots = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, EquipmentSlot.FEET).setRegistryName("birch_boots");
		SPItems.birch = NonNullList.create();
		SPItems.birch.add(0, new ItemStack(SPItems.birch_helmet));
		SPItems.birch.add(1, new ItemStack(SPItems.birch_chestplate));
		SPItems.birch.add(2, new ItemStack(SPItems.birch_leggings));
		SPItems.birch.add(3, new ItemStack(SPItems.birch_boots));

		SPItems.jungle_helmet = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, EquipmentSlot.HEAD).setRegistryName("jungle_helmet");
		SPItems.jungle_chestplate = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, EquipmentSlot.CHEST).setRegistryName("jungle_chestplate");
		SPItems.jungle_leggings = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, EquipmentSlot.LEGS).setRegistryName("jungle_leggings");
		SPItems.jungle_boots = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, EquipmentSlot.FEET).setRegistryName("jungle_boots");
		SPItems.jungle = NonNullList.create();
		SPItems.jungle.add(0, new ItemStack(SPItems.jungle_helmet));
		SPItems.jungle.add(1, new ItemStack(SPItems.jungle_chestplate));
		SPItems.jungle.add(2, new ItemStack(SPItems.jungle_leggings));
		SPItems.jungle.add(3, new ItemStack(SPItems.jungle_boots));

		SPItems.acacia_helmet = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, EquipmentSlot.HEAD).setRegistryName("acacia_helmet");
		SPItems.acacia_chestplate = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, EquipmentSlot.CHEST).setRegistryName("acacia_chestplate");
		SPItems.acacia_leggings = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, EquipmentSlot.LEGS).setRegistryName("acacia_leggings");
		SPItems.acacia_boots = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, EquipmentSlot.FEET).setRegistryName("acacia_boots");
		SPItems.acacia = NonNullList.create();
		SPItems.acacia.add(0, new ItemStack(SPItems.acacia_helmet));
		SPItems.acacia.add(1, new ItemStack(SPItems.acacia_chestplate));
		SPItems.acacia.add(2, new ItemStack(SPItems.acacia_leggings));
		SPItems.acacia.add(3, new ItemStack(SPItems.acacia_boots));

		SPItems.dark_oak_helmet = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, EquipmentSlot.HEAD).setRegistryName("dark_oak_helmet");
		SPItems.dark_oak_chestplate = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, EquipmentSlot.CHEST).setRegistryName("dark_oak_chestplate");
		SPItems.dark_oak_leggings = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, EquipmentSlot.LEGS).setRegistryName("dark_oak_leggings");
		SPItems.dark_oak_boots = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, EquipmentSlot.FEET).setRegistryName("dark_oak_boots");
		SPItems.dark_oak = NonNullList.create();
		SPItems.dark_oak.add(0, new ItemStack(SPItems.dark_oak_helmet));
		SPItems.dark_oak.add(1, new ItemStack(SPItems.dark_oak_chestplate));
		SPItems.dark_oak.add(2, new ItemStack(SPItems.dark_oak_leggings));
		SPItems.dark_oak.add(3, new ItemStack(SPItems.dark_oak_boots));

		SPItems.crimson_helmet = new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, EquipmentSlot.HEAD).setRegistryName("crimson_helmet");
		SPItems.crimson_chestplate = new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, EquipmentSlot.CHEST).setRegistryName("crimson_chestplate");
		SPItems.crimson_leggings = new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, EquipmentSlot.LEGS).setRegistryName("crimson_leggings");
		SPItems.crimson_boots = new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, EquipmentSlot.FEET).setRegistryName("crimson_boots");
		SPItems.crimson = NonNullList.create();
		SPItems.crimson.add(0, new ItemStack(SPItems.crimson_helmet));
		SPItems.crimson.add(1, new ItemStack(SPItems.crimson_chestplate));
		SPItems.crimson.add(2, new ItemStack(SPItems.crimson_leggings));
		SPItems.crimson.add(3, new ItemStack(SPItems.crimson_boots));

		SPItems.warped_helmet = new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, EquipmentSlot.HEAD).setRegistryName("warped_helmet");
		SPItems.warped_chestplate = new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, EquipmentSlot.CHEST).setRegistryName("warped_chestplate");
		SPItems.warped_leggings = new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, EquipmentSlot.LEGS).setRegistryName("warped_leggings");
		SPItems.warped_boots = new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, EquipmentSlot.FEET).setRegistryName("warped_boots");
		SPItems.warped = NonNullList.create();
		SPItems.warped.add(0, new ItemStack(SPItems.warped_helmet));
		SPItems.warped.add(1, new ItemStack(SPItems.warped_chestplate));
		SPItems.warped.add(2, new ItemStack(SPItems.warped_leggings));
		SPItems.warped.add(3, new ItemStack(SPItems.warped_boots));

		if (SPCompatibilityManager.isIc2Loaded()) {

			SPItems.rubber_helmet = new SPItemArmor(SPArmorMaterial.rubberArmorMaterial, EquipmentSlot.HEAD).setRegistryName("rubber_helmet");
			SPItems.rubber_chestplate = new SPItemArmor(SPArmorMaterial.rubberArmorMaterial, EquipmentSlot.CHEST).setRegistryName("rubber_chestplate");
			SPItems.rubber_leggings = new SPItemArmor(SPArmorMaterial.rubberArmorMaterial, EquipmentSlot.LEGS).setRegistryName("rubber_leggings");
			SPItems.rubber_boots = new SPItemArmor(SPArmorMaterial.rubberArmorMaterial, EquipmentSlot.FEET).setRegistryName("rubber_boots");
			SPItems.rubber = NonNullList.create();
			SPItems.rubber.add(0, new ItemStack(SPItems.rubber_helmet));
			SPItems.rubber.add(1, new ItemStack(SPItems.rubber_chestplate));
			SPItems.rubber.add(2, new ItemStack(SPItems.rubber_leggings));
			SPItems.rubber.add(3, new ItemStack(SPItems.rubber_boots));

		}
		
		if (SPCompatibilityManager.isBambooModsLoaded()) {

			SPItems.bamboo_helmet = new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, EquipmentSlot.HEAD).setRegistryName("bamboo_helmet");
			SPItems.bamboo_chestplate = new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, EquipmentSlot.CHEST).setRegistryName("bamboo_chestplate");
			SPItems.bamboo_leggings = new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, EquipmentSlot.LEGS).setRegistryName("bamboo_leggings");
			SPItems.bamboo_boots = new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, EquipmentSlot.FEET).setRegistryName("bamboo_boots");
			SPItems.bamboo = NonNullList.create();
			SPItems.bamboo.add(0, new ItemStack(SPItems.bamboo_helmet));
			SPItems.bamboo.add(1, new ItemStack(SPItems.bamboo_chestplate));
			SPItems.bamboo.add(2, new ItemStack(SPItems.bamboo_leggings));
			SPItems.bamboo.add(3, new ItemStack(SPItems.bamboo_boots));
		}

		if(SPCompatibilityManager.isBopLoaded()){
			BOPArmor.init();
		}

		if(SPCompatibilityManager.isForestryLoaded()){
			ForestryArmor.init();
		}
		
		if(SPCompatibilityManager.isTraverseLoaded()) {
			TraverseArmor.init();
		}

	}
	public static void register()
	{
		registerItem(SPItems.bronze);
		registerItem(SPItems.stone);
		registerItem(SPItems.titanium);
		registerItem(SPItems.oak);
		registerItem(SPItems.spruce);
		registerItem(SPItems.birch);
		registerItem(SPItems.jungle);
		registerItem(SPItems.acacia);
		registerItem(SPItems.dark_oak);
		registerItem(SPItems.crimson);
		registerItem(SPItems.warped);

		if (SPCompatibilityManager.isIc2Loaded()) {

			registerItem(SPItems.rubber);
		}

		if (SPCompatibilityManager.isBambooModsLoaded()) {
			registerItem(SPItems.bamboo);
		}

		if(SPCompatibilityManager.isBopLoaded()){
			BOPArmor.register();
		}

		if(SPCompatibilityManager.isForestryLoaded()){
			ForestryArmor.register();
		}
		
		if(SPCompatibilityManager.isTraverseLoaded()) {
			TraverseArmor.register();
		}
	}

	public static void registerItem(NonNullList<ItemStack> item) {

		for(int i = 0; i < item.size(); i++) {
			ForgeRegistries.ITEMS.register(item.get(i).getItem());
		}
	}

}
