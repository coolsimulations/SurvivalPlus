package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class SurvivalPlusArmor {

	public static void init(){

		SPItems.bronze_helmet = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, EquipmentSlot.HEAD);
		SPItems.bronze_chestplate = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, EquipmentSlot.CHEST);
		SPItems.bronze_leggings = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, EquipmentSlot.LEGS);
		SPItems.bronze_boots = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, EquipmentSlot.FEET);
		SPItems.bronze = NonNullList.create();
		SPItems.bronze.add(0, new ItemStack(SPItems.bronze_helmet));
		SPItems.bronze.add(1, new ItemStack(SPItems.bronze_chestplate));
		SPItems.bronze.add(2, new ItemStack(SPItems.bronze_leggings));
		SPItems.bronze.add(3, new ItemStack(SPItems.bronze_boots));

		SPItems.stone_helmet = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, EquipmentSlot.HEAD);
		SPItems.stone_chestplate = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, EquipmentSlot.CHEST);
		SPItems.stone_leggings = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, EquipmentSlot.LEGS);
		SPItems.stone_boots = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, EquipmentSlot.FEET);
		SPItems.stone = NonNullList.create();
		SPItems.stone.add(0, new ItemStack(SPItems.stone_helmet));
		SPItems.stone.add(1, new ItemStack(SPItems.stone_chestplate));
		SPItems.stone.add(2, new ItemStack(SPItems.stone_leggings));
		SPItems.stone.add(3, new ItemStack(SPItems.stone_boots));

		SPItems.titanium_helmet = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, EquipmentSlot.HEAD);
		SPItems.titanium_chestplate = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, EquipmentSlot.CHEST);
		SPItems.titanium_leggings = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, EquipmentSlot.LEGS);
		SPItems.titanium_boots = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, EquipmentSlot.FEET);
		SPItems.titanium = NonNullList.create();
		SPItems.titanium.add(0, new ItemStack(SPItems.titanium_helmet));
		SPItems.titanium.add(1, new ItemStack(SPItems.titanium_chestplate));
		SPItems.titanium.add(2, new ItemStack(SPItems.titanium_leggings));
		SPItems.titanium.add(3, new ItemStack(SPItems.titanium_boots));

		SPItems.oak_helmet = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, EquipmentSlot.HEAD);
		SPItems.oak_chestplate = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, EquipmentSlot.CHEST);
		SPItems.oak_leggings = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, EquipmentSlot.LEGS);
		SPItems.oak_boots = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, EquipmentSlot.FEET);
		SPItems.oak = NonNullList.create();
		SPItems.oak.add(0, new ItemStack(SPItems.oak_helmet));
		SPItems.oak.add(1, new ItemStack(SPItems.oak_chestplate));
		SPItems.oak.add(2, new ItemStack(SPItems.oak_leggings));
		SPItems.oak.add(3, new ItemStack(SPItems.oak_boots));

		SPItems.spruce_helmet = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, EquipmentSlot.HEAD);
		SPItems.spruce_chestplate = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, EquipmentSlot.CHEST);
		SPItems.spruce_leggings = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, EquipmentSlot.LEGS);
		SPItems.spruce_boots = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, EquipmentSlot.FEET);
		SPItems.spruce = NonNullList.create();
		SPItems.spruce.add(0, new ItemStack(SPItems.spruce_helmet));
		SPItems.spruce.add(1, new ItemStack(SPItems.spruce_chestplate));
		SPItems.spruce.add(2, new ItemStack(SPItems.spruce_leggings));
		SPItems.spruce.add(3, new ItemStack(SPItems.spruce_boots));

		SPItems.birch_helmet = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, EquipmentSlot.HEAD);
		SPItems.birch_chestplate = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, EquipmentSlot.CHEST);
		SPItems.birch_leggings = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, EquipmentSlot.LEGS);
		SPItems.birch_boots = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, EquipmentSlot.FEET);
		SPItems.birch = NonNullList.create();
		SPItems.birch.add(0, new ItemStack(SPItems.birch_helmet));
		SPItems.birch.add(1, new ItemStack(SPItems.birch_chestplate));
		SPItems.birch.add(2, new ItemStack(SPItems.birch_leggings));
		SPItems.birch.add(3, new ItemStack(SPItems.birch_boots));

		SPItems.jungle_helmet = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, EquipmentSlot.HEAD);
		SPItems.jungle_chestplate = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, EquipmentSlot.CHEST);
		SPItems.jungle_leggings = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, EquipmentSlot.LEGS);
		SPItems.jungle_boots = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, EquipmentSlot.FEET);
		SPItems.jungle = NonNullList.create();
		SPItems.jungle.add(0, new ItemStack(SPItems.jungle_helmet));
		SPItems.jungle.add(1, new ItemStack(SPItems.jungle_chestplate));
		SPItems.jungle.add(2, new ItemStack(SPItems.jungle_leggings));
		SPItems.jungle.add(3, new ItemStack(SPItems.jungle_boots));

		SPItems.acacia_helmet = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, EquipmentSlot.HEAD);
		SPItems.acacia_chestplate = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, EquipmentSlot.CHEST);
		SPItems.acacia_leggings = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, EquipmentSlot.LEGS);
		SPItems.acacia_boots = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, EquipmentSlot.FEET);
		SPItems.acacia = NonNullList.create();
		SPItems.acacia.add(0, new ItemStack(SPItems.acacia_helmet));
		SPItems.acacia.add(1, new ItemStack(SPItems.acacia_chestplate));
		SPItems.acacia.add(2, new ItemStack(SPItems.acacia_leggings));
		SPItems.acacia.add(3, new ItemStack(SPItems.acacia_boots));

		SPItems.dark_oak_helmet = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, EquipmentSlot.HEAD);
		SPItems.dark_oak_chestplate = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, EquipmentSlot.CHEST);
		SPItems.dark_oak_leggings = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, EquipmentSlot.LEGS);
		SPItems.dark_oak_boots = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, EquipmentSlot.FEET);
		SPItems.dark_oak = NonNullList.create();
		SPItems.dark_oak.add(0, new ItemStack(SPItems.dark_oak_helmet));
		SPItems.dark_oak.add(1, new ItemStack(SPItems.dark_oak_chestplate));
		SPItems.dark_oak.add(2, new ItemStack(SPItems.dark_oak_leggings));
		SPItems.dark_oak.add(3, new ItemStack(SPItems.dark_oak_boots));
		
		SPItems.crimson_helmet = new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, EquipmentSlot.HEAD);
		SPItems.crimson_chestplate = new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, EquipmentSlot.CHEST);
		SPItems.crimson_leggings = new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, EquipmentSlot.LEGS);
		SPItems.crimson_boots = new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, EquipmentSlot.FEET);
		SPItems.crimson = NonNullList.create();
		SPItems.crimson.add(0, new ItemStack(SPItems.crimson_helmet));
		SPItems.crimson.add(1, new ItemStack(SPItems.crimson_chestplate));
		SPItems.crimson.add(2, new ItemStack(SPItems.crimson_leggings));
		SPItems.crimson.add(3, new ItemStack(SPItems.crimson_boots));
		
		SPItems.warped_helmet = new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, EquipmentSlot.HEAD);
		SPItems.warped_chestplate = new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, EquipmentSlot.CHEST);
		SPItems.warped_leggings = new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, EquipmentSlot.LEGS);
		SPItems.warped_boots = new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, EquipmentSlot.FEET);
		SPItems.warped = NonNullList.create();
		SPItems.warped.add(0, new ItemStack(SPItems.warped_helmet));
		SPItems.warped.add(1, new ItemStack(SPItems.warped_chestplate));
		SPItems.warped.add(2, new ItemStack(SPItems.warped_leggings));
		SPItems.warped.add(3, new ItemStack(SPItems.warped_boots));
		
		if(SPCompatibilityManager.isBambooModsLoaded()) {
			SPItems.bamboo_helmet = new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, EquipmentSlot.HEAD);
			SPItems.bamboo_chestplate = new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, EquipmentSlot.CHEST);
			SPItems.bamboo_leggings = new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, EquipmentSlot.LEGS);
			SPItems.bamboo_boots = new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, EquipmentSlot.FEET);
			SPItems.bamboo = NonNullList.create();
			SPItems.bamboo.add(0, new ItemStack(SPItems.bamboo_helmet));
			SPItems.bamboo.add(1, new ItemStack(SPItems.bamboo_chestplate));
			SPItems.bamboo.add(2, new ItemStack(SPItems.bamboo_leggings));
			SPItems.bamboo.add(3, new ItemStack(SPItems.bamboo_boots));
		}
		
		if(SPCompatibilityManager.isVanillaEnhancedLoaded()) {
			SPItems.redwood_helmet_vanilla_enhanced = new SPItemArmor(SPArmorMaterial.redwoodVanillaEnhancedArmorMaterial, EquipmentSlot.HEAD);
			SPItems.redwood_chestplate_vanilla_enhanced = new SPItemArmor(SPArmorMaterial.redwoodVanillaEnhancedArmorMaterial, EquipmentSlot.CHEST);
			SPItems.redwood_leggings_vanilla_enhanced = new SPItemArmor(SPArmorMaterial.redwoodVanillaEnhancedArmorMaterial, EquipmentSlot.LEGS);
			SPItems.redwood_boots_vanilla_enhanced = new SPItemArmor(SPArmorMaterial.redwoodVanillaEnhancedArmorMaterial, EquipmentSlot.FEET);
			SPItems.redwood_vanilla_enhanced = NonNullList.create();
			SPItems.redwood_vanilla_enhanced.add(0, new ItemStack(SPItems.redwood_helmet_vanilla_enhanced));
			SPItems.redwood_vanilla_enhanced.add(1, new ItemStack(SPItems.redwood_chestplate_vanilla_enhanced));
			SPItems.redwood_vanilla_enhanced.add(2, new ItemStack(SPItems.redwood_leggings_vanilla_enhanced));
			SPItems.redwood_vanilla_enhanced.add(3, new ItemStack(SPItems.redwood_boots_vanilla_enhanced));
		}
		
		if(SPCompatibilityManager.isTraverseLoaded()) {
			TraverseArmor.init();
		}
		
		if(SPCompatibilityManager.isTerrestriaLoaded()) {
			TerrestriaArmor.init();
		}
		
		if(SPCompatibilityManager.isAetherRebornLoaded()) {
			AetherRebornArmor.init();
		}

	}

	public static void register()
	{
		registerItem(SPItems.bronze, "bronze");
		registerItem(SPItems.stone, "stone");
		registerItem(SPItems.titanium, "titanium");
		registerItem(SPItems.oak, "oak");
		registerItem(SPItems.spruce, "spruce");
		registerItem(SPItems.birch, "birch");
		registerItem(SPItems.jungle, "jungle");
		registerItem(SPItems.acacia, "acacia");
		registerItem(SPItems.dark_oak, "dark_oak");
		registerItem(SPItems.crimson, "crimson");
		registerItem(SPItems.warped, "warped");
		
		if(SPCompatibilityManager.isBambooModsLoaded()) {
			registerItem(SPItems.bamboo, "bamboo");
		}
		
		if(SPCompatibilityManager.isVanillaEnhancedLoaded()) {
			registerItem(SPItems.redwood_vanilla_enhanced, "redwood", "vanilla_enhanced");
		}
		
		if(SPCompatibilityManager.isTraverseLoaded()) {
			TraverseArmor.register();
		}
		
		if(SPCompatibilityManager.isTerrestriaLoaded()) {
			TerrestriaArmor.register();
		}
		
		if(SPCompatibilityManager.isAetherRebornLoaded()) {
			AetherRebornArmor.register();
		}
	}
	
	public static void registerItem(NonNullList<ItemStack> item, String materialName) {
		registerItem(item, materialName, "");
	}

	public static void registerItem(NonNullList<ItemStack> item, String materialName, String modId) {

		for(int i = 0; i < item.size(); i++) {
			if(item.get(i).getItem() instanceof ArmorItem) {

				EquipmentSlot slotType = ((ArmorItem) item.get(i).getItem()).getSlot();
				String lastName;

				switch (slotType) {
				case HEAD:
					lastName = "helmet";
					break;
				case CHEST:
					lastName = "chestplate";
					break;
				case LEGS:
					lastName = "leggings";
					break;
				case FEET:
					lastName = "boots";
					break;
				default:
					lastName = "";
					break;
				}

				if(modId != "") {
					Registry.register(Registry.ITEM, new ResourceLocation(SPReference.MOD_ID, materialName + "_" + lastName + "_" + modId), item.get(i).getItem());
				} else {
					Registry.register(Registry.ITEM, new ResourceLocation(SPReference.MOD_ID, materialName + "_" + lastName), item.get(i).getItem());
				}
			}
		}
	}

}
