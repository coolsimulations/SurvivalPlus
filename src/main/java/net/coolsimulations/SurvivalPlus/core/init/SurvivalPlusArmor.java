package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ItemStack;

public class SurvivalPlusArmor {

	public static void init(){

		SPItems.bronze_helmet = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, Type.HELMET);
		SPItems.bronze_chestplate = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, Type.CHESTPLATE);
		SPItems.bronze_leggings = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, Type.LEGGINGS);
		SPItems.bronze_boots = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, Type.BOOTS);
		SPItems.bronze = NonNullList.create();
		SPItems.bronze.add(0, new ItemStack(SPItems.bronze_helmet));
		SPItems.bronze.add(1, new ItemStack(SPItems.bronze_chestplate));
		SPItems.bronze.add(2, new ItemStack(SPItems.bronze_leggings));
		SPItems.bronze.add(3, new ItemStack(SPItems.bronze_boots));

		SPItems.stone_helmet = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, Type.HELMET);
		SPItems.stone_chestplate = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, Type.CHESTPLATE);
		SPItems.stone_leggings = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, Type.LEGGINGS);
		SPItems.stone_boots = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, Type.BOOTS);
		SPItems.stone = NonNullList.create();
		SPItems.stone.add(0, new ItemStack(SPItems.stone_helmet));
		SPItems.stone.add(1, new ItemStack(SPItems.stone_chestplate));
		SPItems.stone.add(2, new ItemStack(SPItems.stone_leggings));
		SPItems.stone.add(3, new ItemStack(SPItems.stone_boots));

		SPItems.titanium_helmet = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, Type.HELMET);
		SPItems.titanium_chestplate = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, Type.CHESTPLATE);
		SPItems.titanium_leggings = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, Type.LEGGINGS);
		SPItems.titanium_boots = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, Type.BOOTS);
		SPItems.titanium = NonNullList.create();
		SPItems.titanium.add(0, new ItemStack(SPItems.titanium_helmet));
		SPItems.titanium.add(1, new ItemStack(SPItems.titanium_chestplate));
		SPItems.titanium.add(2, new ItemStack(SPItems.titanium_leggings));
		SPItems.titanium.add(3, new ItemStack(SPItems.titanium_boots));

		SPItems.oak_helmet = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, Type.HELMET);
		SPItems.oak_chestplate = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, Type.CHESTPLATE);
		SPItems.oak_leggings = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, Type.LEGGINGS);
		SPItems.oak_boots = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, Type.BOOTS);
		SPItems.oak = NonNullList.create();
		SPItems.oak.add(0, new ItemStack(SPItems.oak_helmet));
		SPItems.oak.add(1, new ItemStack(SPItems.oak_chestplate));
		SPItems.oak.add(2, new ItemStack(SPItems.oak_leggings));
		SPItems.oak.add(3, new ItemStack(SPItems.oak_boots));

		SPItems.spruce_helmet = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, Type.HELMET);
		SPItems.spruce_chestplate = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, Type.CHESTPLATE);
		SPItems.spruce_leggings = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, Type.LEGGINGS);
		SPItems.spruce_boots = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, Type.BOOTS);
		SPItems.spruce = NonNullList.create();
		SPItems.spruce.add(0, new ItemStack(SPItems.spruce_helmet));
		SPItems.spruce.add(1, new ItemStack(SPItems.spruce_chestplate));
		SPItems.spruce.add(2, new ItemStack(SPItems.spruce_leggings));
		SPItems.spruce.add(3, new ItemStack(SPItems.spruce_boots));

		SPItems.birch_helmet = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, Type.HELMET);
		SPItems.birch_chestplate = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, Type.CHESTPLATE);
		SPItems.birch_leggings = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, Type.LEGGINGS);
		SPItems.birch_boots = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, Type.BOOTS);
		SPItems.birch = NonNullList.create();
		SPItems.birch.add(0, new ItemStack(SPItems.birch_helmet));
		SPItems.birch.add(1, new ItemStack(SPItems.birch_chestplate));
		SPItems.birch.add(2, new ItemStack(SPItems.birch_leggings));
		SPItems.birch.add(3, new ItemStack(SPItems.birch_boots));

		SPItems.jungle_helmet = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, Type.HELMET);
		SPItems.jungle_chestplate = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, Type.CHESTPLATE);
		SPItems.jungle_leggings = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, Type.LEGGINGS);
		SPItems.jungle_boots = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, Type.BOOTS);
		SPItems.jungle = NonNullList.create();
		SPItems.jungle.add(0, new ItemStack(SPItems.jungle_helmet));
		SPItems.jungle.add(1, new ItemStack(SPItems.jungle_chestplate));
		SPItems.jungle.add(2, new ItemStack(SPItems.jungle_leggings));
		SPItems.jungle.add(3, new ItemStack(SPItems.jungle_boots));

		SPItems.acacia_helmet = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, Type.HELMET);
		SPItems.acacia_chestplate = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, Type.CHESTPLATE);
		SPItems.acacia_leggings = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, Type.LEGGINGS);
		SPItems.acacia_boots = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, Type.BOOTS);
		SPItems.acacia = NonNullList.create();
		SPItems.acacia.add(0, new ItemStack(SPItems.acacia_helmet));
		SPItems.acacia.add(1, new ItemStack(SPItems.acacia_chestplate));
		SPItems.acacia.add(2, new ItemStack(SPItems.acacia_leggings));
		SPItems.acacia.add(3, new ItemStack(SPItems.acacia_boots));

		SPItems.dark_oak_helmet = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, Type.HELMET);
		SPItems.dark_oak_chestplate = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, Type.CHESTPLATE);
		SPItems.dark_oak_leggings = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, Type.LEGGINGS);
		SPItems.dark_oak_boots = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, Type.BOOTS);
		SPItems.dark_oak = NonNullList.create();
		SPItems.dark_oak.add(0, new ItemStack(SPItems.dark_oak_helmet));
		SPItems.dark_oak.add(1, new ItemStack(SPItems.dark_oak_chestplate));
		SPItems.dark_oak.add(2, new ItemStack(SPItems.dark_oak_leggings));
		SPItems.dark_oak.add(3, new ItemStack(SPItems.dark_oak_boots));
		
		SPItems.crimson_helmet = new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, Type.HELMET);
		SPItems.crimson_chestplate = new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, Type.CHESTPLATE);
		SPItems.crimson_leggings = new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, Type.LEGGINGS);
		SPItems.crimson_boots = new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, Type.BOOTS);
		SPItems.crimson = NonNullList.create();
		SPItems.crimson.add(0, new ItemStack(SPItems.crimson_helmet));
		SPItems.crimson.add(1, new ItemStack(SPItems.crimson_chestplate));
		SPItems.crimson.add(2, new ItemStack(SPItems.crimson_leggings));
		SPItems.crimson.add(3, new ItemStack(SPItems.crimson_boots));
		
		SPItems.warped_helmet = new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, Type.HELMET);
		SPItems.warped_chestplate = new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, Type.CHESTPLATE);
		SPItems.warped_leggings = new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, Type.LEGGINGS);
		SPItems.warped_boots = new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, Type.BOOTS);
		SPItems.warped = NonNullList.create();
		SPItems.warped.add(0, new ItemStack(SPItems.warped_helmet));
		SPItems.warped.add(1, new ItemStack(SPItems.warped_chestplate));
		SPItems.warped.add(2, new ItemStack(SPItems.warped_leggings));
		SPItems.warped.add(3, new ItemStack(SPItems.warped_boots));
		
		SPItems.mangrove_helmet = new SPItemArmor(SPArmorMaterial.mangroveArmorMaterial, Type.HELMET);
		SPItems.mangrove_chestplate = new SPItemArmor(SPArmorMaterial.mangroveArmorMaterial, Type.CHESTPLATE);
		SPItems.mangrove_leggings = new SPItemArmor(SPArmorMaterial.mangroveArmorMaterial, Type.LEGGINGS);
		SPItems.mangrove_boots = new SPItemArmor(SPArmorMaterial.mangroveArmorMaterial, Type.BOOTS);
		SPItems.mangrove = NonNullList.create();
		SPItems.mangrove.add(0, new ItemStack(SPItems.mangrove_helmet));
		SPItems.mangrove.add(1, new ItemStack(SPItems.mangrove_chestplate));
		SPItems.mangrove.add(2, new ItemStack(SPItems.mangrove_leggings));
		SPItems.mangrove.add(3, new ItemStack(SPItems.mangrove_boots));
		
		if(SPCompatibilityManager.isBambooModsLoaded()) {
			SPItems.bamboo_helmet = new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, Type.HELMET);
			SPItems.bamboo_chestplate = new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, Type.CHESTPLATE);
			SPItems.bamboo_leggings = new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, Type.LEGGINGS);
			SPItems.bamboo_boots = new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, Type.BOOTS);
			SPItems.bamboo = NonNullList.create();
			SPItems.bamboo.add(0, new ItemStack(SPItems.bamboo_helmet));
			SPItems.bamboo.add(1, new ItemStack(SPItems.bamboo_chestplate));
			SPItems.bamboo.add(2, new ItemStack(SPItems.bamboo_leggings));
			SPItems.bamboo.add(3, new ItemStack(SPItems.bamboo_boots));
		}
		
		if(SPCompatibilityManager.isEnrichedLoaded()) {
			SPItems.redwood_helmet_vanilla_enhanced = new SPItemArmor(SPArmorMaterial.redwoodVanillaEnhancedArmorMaterial, Type.HELMET);
			SPItems.redwood_chestplate_vanilla_enhanced = new SPItemArmor(SPArmorMaterial.redwoodVanillaEnhancedArmorMaterial, Type.CHESTPLATE);
			SPItems.redwood_leggings_vanilla_enhanced = new SPItemArmor(SPArmorMaterial.redwoodVanillaEnhancedArmorMaterial, Type.LEGGINGS);
			SPItems.redwood_boots_vanilla_enhanced = new SPItemArmor(SPArmorMaterial.redwoodVanillaEnhancedArmorMaterial, Type.BOOTS);
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
		registerItem(SPItems.mangrove, "mangrove");
		
		if(SPCompatibilityManager.isBambooModsLoaded()) {
			registerItem(SPItems.bamboo, "bamboo");
		}
		
		if(SPCompatibilityManager.isEnrichedLoaded()) {
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

				Type slotType = ((ArmorItem) item.get(i).getItem()).getType();
				String lastName;

				switch (slotType) {
				case HELMET:
					lastName = "helmet";
					break;
				case CHESTPLATE:
					lastName = "chestplate";
					break;
				case LEGGINGS:
					lastName = "leggings";
					break;
				case BOOTS:
					lastName = "boots";
					break;
				default:
					lastName = "";
					break;
				}

				if(modId != "") {
					Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(SPReference.MOD_ID, materialName + "_" + lastName + "_" + modId), item.get(i).getItem());
				} else {
					Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(SPReference.MOD_ID, materialName + "_" + lastName), item.get(i).getItem());
				}
			}
		}
	}

}
