package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class SurvivalPlusArmor {
	
	
	public static void init(){
		
		SPItems.bronzeArmorMaterial = EnumHelper.addArmorMaterial("bronze", SPReference.MOD_ID + ":" +  "bronze", 20, new int[] {2, 6, 5, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
		SPItems.bronze_helmet = new SPItemArmor(SPItems.bronzeArmorMaterial, 0, EntityEquipmentSlot.HEAD, "bronze_helmet", "ingotBronze").setUnlocalizedName("bronze_helmet").setRegistryName("bronze_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.bronze_chestplate = new SPItemArmor(SPItems.bronzeArmorMaterial, 0, EntityEquipmentSlot.CHEST, "bronze_chestplate", "ingotBronze").setUnlocalizedName("bronze_chestplate").setRegistryName("bronze_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.bronze_leggings = new SPItemArmor(SPItems.bronzeArmorMaterial, 0, EntityEquipmentSlot.LEGS, "bronze_leggings", "ingotBronze").setUnlocalizedName("bronze_leggings").setRegistryName("bronze_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.bronze_boots = new SPItemArmor(SPItems.bronzeArmorMaterial, 0, EntityEquipmentSlot.FEET, "bronze_boots", "ingotBronze").setUnlocalizedName("bronze_boots").setRegistryName("bronze_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.stoneArmorMaterial = EnumHelper.addArmorMaterial("stone", SPReference.MOD_ID + ":" +  "stone", 20, new int[] {1, 2, 4, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.stone_helmet = new SPItemArmor(SPItems.stoneArmorMaterial, 0, EntityEquipmentSlot.HEAD, "stone_helmet", "cobblestone").setUnlocalizedName("stone_helmet").setRegistryName("stone_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.stone_chestplate = new SPItemArmor(SPItems.stoneArmorMaterial, 0, EntityEquipmentSlot.CHEST, "stone_chestplate", "cobblestone").setUnlocalizedName("stone_chestplate").setRegistryName("stone_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.stone_leggings = new SPItemArmor(SPItems.stoneArmorMaterial, 0, EntityEquipmentSlot.LEGS, "stone_leggings", "cobblestone").setUnlocalizedName("stone_leggings").setRegistryName("stone_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.stone_boots = new SPItemArmor(SPItems.stoneArmorMaterial, 0, EntityEquipmentSlot.FEET, "stone_boots", "cobblestone").setUnlocalizedName("stone_boots").setRegistryName("stone_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.titaniumArmorMaterial = EnumHelper.addArmorMaterial("titanium", SPReference.MOD_ID + ":" +  "titanium", 20, new int[] {3, 2, 5, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F);
		SPItems.titanium_helmet = new SPItemArmor(SPItems.titaniumArmorMaterial, 0, EntityEquipmentSlot.HEAD, "titanium_helmet", "ingotTitanium").setUnlocalizedName("titanium_helmet").setRegistryName("titanium_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.titanium_chestplate = new SPItemArmor(SPItems.titaniumArmorMaterial, 0, EntityEquipmentSlot.CHEST, "titanium_chestplate", "ingotTitanium").setUnlocalizedName("titanium_chestplate").setRegistryName("titanium_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.titanium_leggings = new SPItemArmor(SPItems.titaniumArmorMaterial, 0, EntityEquipmentSlot.LEGS, "titanium_leggings", "ingotTitanium").setUnlocalizedName("titanium_leggings").setRegistryName("titanium_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.titanium_boots = new SPItemArmor(SPItems.titaniumArmorMaterial, 0, EntityEquipmentSlot.FEET, "titanium_boots", "ingotTitanium").setUnlocalizedName("titanium_boots").setRegistryName("titanium_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.oakArmorMaterial = EnumHelper.addArmorMaterial("oak", SPReference.MOD_ID + ":" +  "oak", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.oak_helmet = new SPItemArmor(SPItems.oakArmorMaterial, 0, EntityEquipmentSlot.HEAD, "oak_helmet", "stickWood").setUnlocalizedName("oak_helmet").setRegistryName("oak_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.oak_chestplate = new SPItemArmor(SPItems.oakArmorMaterial, 0, EntityEquipmentSlot.CHEST, "oak_chestplate", "stickWood").setUnlocalizedName("oak_chestplate").setRegistryName("oak_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.oak_leggings = new SPItemArmor(SPItems.oakArmorMaterial, 0, EntityEquipmentSlot.LEGS, "oak_leggings", "stickWood").setUnlocalizedName("oak_leggings").setRegistryName("oak_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.oak_boots = new SPItemArmor(SPItems.oakArmorMaterial, 0, EntityEquipmentSlot.FEET, "oak_boots", "stickWood").setUnlocalizedName("oak_boots").setRegistryName("oak_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.spruceArmorMaterial = EnumHelper.addArmorMaterial("spruce", SPReference.MOD_ID + ":" +  "spruce", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.spruce_helmet = new SPItemArmor(SPItems.spruceArmorMaterial, 0, EntityEquipmentSlot.HEAD, "spruce_helmet", "stickWood").setUnlocalizedName("spruce_helmet").setRegistryName("spruce_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.spruce_chestplate = new SPItemArmor(SPItems.spruceArmorMaterial, 0, EntityEquipmentSlot.CHEST, "spruce_chestplate", "stickWood").setUnlocalizedName("spruce_chestplate").setRegistryName("spruce_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.spruce_leggings = new SPItemArmor(SPItems.spruceArmorMaterial, 0, EntityEquipmentSlot.LEGS, "spruce_leggings", "stickWood").setUnlocalizedName("spruce_leggings").setRegistryName("spruce_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.spruce_boots = new SPItemArmor(SPItems.spruceArmorMaterial, 0, EntityEquipmentSlot.FEET, "spruce_boots", "stickWood").setUnlocalizedName("spruce_boots").setRegistryName("spruce_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.birchArmorMaterial = EnumHelper.addArmorMaterial("birch", SPReference.MOD_ID + ":" +  "birch", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.birch_helmet = new SPItemArmor(SPItems.birchArmorMaterial, 0, EntityEquipmentSlot.HEAD, "birch_helmet", "stickWood").setUnlocalizedName("birch_helmet").setRegistryName("birch_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.birch_chestplate = new SPItemArmor(SPItems.birchArmorMaterial, 0, EntityEquipmentSlot.CHEST, "birch_chestplate", "stickWood").setUnlocalizedName("birch_chestplate").setRegistryName("birch_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.birch_leggings = new SPItemArmor(SPItems.birchArmorMaterial, 0, EntityEquipmentSlot.LEGS, "birch_leggings", "stickWood").setUnlocalizedName("birch_leggings").setRegistryName("birch_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.birch_boots = new SPItemArmor(SPItems.birchArmorMaterial, 0, EntityEquipmentSlot.FEET, "birch_boots", "stickWood").setUnlocalizedName("birch_boots").setRegistryName("birch_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.jungleArmorMaterial = EnumHelper.addArmorMaterial("jungle", SPReference.MOD_ID + ":" +  "jungle", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.jungle_helmet = new SPItemArmor(SPItems.jungleArmorMaterial, 0, EntityEquipmentSlot.HEAD, "jungle_helmet", "stickWood").setUnlocalizedName("jungle_helmet").setRegistryName("jungle_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.jungle_chestplate = new SPItemArmor(SPItems.jungleArmorMaterial, 0, EntityEquipmentSlot.CHEST, "jungle_chestplate", "stickWood").setUnlocalizedName("jungle_chestplate").setRegistryName("jungle_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.jungle_leggings = new SPItemArmor(SPItems.jungleArmorMaterial, 0, EntityEquipmentSlot.LEGS, "jungle_leggings", "stickWood").setUnlocalizedName("jungle_leggings").setRegistryName("jungle_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.jungle_boots = new SPItemArmor(SPItems.jungleArmorMaterial, 0, EntityEquipmentSlot.FEET, "jungle_boots", "stickWood").setUnlocalizedName("jungle_boots").setRegistryName("jungle_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.acaciaArmorMaterial = EnumHelper.addArmorMaterial("acacia", SPReference.MOD_ID + ":" +  "acacia", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.acacia_helmet = new SPItemArmor(SPItems.acaciaArmorMaterial, 0, EntityEquipmentSlot.HEAD, "acacia_helmet", "stickWood").setUnlocalizedName("acacia_helmet").setRegistryName("acacia_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.acacia_chestplate = new SPItemArmor(SPItems.acaciaArmorMaterial, 0, EntityEquipmentSlot.CHEST, "acacia_chestplate", "stickWood").setUnlocalizedName("acacia_chestplate").setRegistryName("acacia_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.acacia_leggings = new SPItemArmor(SPItems.acaciaArmorMaterial, 0, EntityEquipmentSlot.LEGS, "acacia_leggings", "stickWood").setUnlocalizedName("acacia_leggings").setRegistryName("acacia_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.acacia_boots = new SPItemArmor(SPItems.acaciaArmorMaterial, 0, EntityEquipmentSlot.FEET, "acacia_boots", "stickWood").setUnlocalizedName("acacia_boots").setRegistryName("acacia_boots").setCreativeTab(SurvivalPlus.tabCombat);
		
		SPItems.darkOakArmorMaterial = EnumHelper.addArmorMaterial("dark_oak", SPReference.MOD_ID + ":" +  "dark_oak", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.dark_oak_helmet = new SPItemArmor(SPItems.darkOakArmorMaterial, 0, EntityEquipmentSlot.HEAD, "dark_oak_helmet", "stickWood").setUnlocalizedName("dark_oak_helmet").setRegistryName("dark_oak_helmet").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.dark_oak_chestplate = new SPItemArmor(SPItems.darkOakArmorMaterial, 0, EntityEquipmentSlot.CHEST, "dark_oak_chestplate", "stickWood").setUnlocalizedName("dark_oak_chestplate").setRegistryName("dark_oak_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.dark_oak_leggings = new SPItemArmor(SPItems.darkOakArmorMaterial, 0, EntityEquipmentSlot.LEGS, "dark_oak_leggings", "stickWood").setUnlocalizedName("dark_oak_leggings").setRegistryName("dark_oak_leggings").setCreativeTab(SurvivalPlus.tabCombat);
		SPItems.dark_oak_boots = new SPItemArmor(SPItems.darkOakArmorMaterial, 0, EntityEquipmentSlot.FEET, "dark_oak_boots", "stickWood").setUnlocalizedName("dark_oak_boots").setRegistryName("dark_oak_boots").setCreativeTab(SurvivalPlus.tabCombat);

		if (OreDictionary.getOres("woodRubber").size() > 0) {
			
			SPItems.rubberArmorMaterial = EnumHelper.addArmorMaterial("rubber", SPReference.MOD_ID + ":" + "rubber", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
			SPItems.rubber_helmet = new SPItemArmor(SPItems.rubberArmorMaterial, 0, EntityEquipmentSlot.HEAD, "rubber_helmet", "stickWood").setUnlocalizedName("rubber_helmet").setRegistryName("rubber_helmet").setCreativeTab(SurvivalPlus.tabCombat);
			SPItems.rubber_chestplate = new SPItemArmor(SPItems.rubberArmorMaterial, 0, EntityEquipmentSlot.CHEST, "rubber_chestplate", "stickWood").setUnlocalizedName("rubber_chestplate").setRegistryName("rubber_chestplate").setCreativeTab(SurvivalPlus.tabCombat);
			SPItems.rubber_leggings = new SPItemArmor(SPItems.rubberArmorMaterial, 0, EntityEquipmentSlot.LEGS, "rubber_leggings", "stickWood").setUnlocalizedName("rubber_leggings").setRegistryName("rubber_leggings").setCreativeTab(SurvivalPlus.tabCombat);
			SPItems.rubber_boots = new SPItemArmor(SPItems.rubberArmorMaterial, 0, EntityEquipmentSlot.FEET, "rubber_boots", "stickWood").setUnlocalizedName("rubber_boots").setRegistryName("rubber_boots").setCreativeTab(SurvivalPlus.tabCombat);
			
		}
		
		if(SPCompatibilityManager.isBopLoaded()){
			BOPArmor.init();
		}
		
		if(SPCompatibilityManager.isForestryLoaded()){
			ForestryArmor.init();
		}
		
	}
	public static void register()
	{
		registerItem(SPItems.bronze_helmet);
		registerItem(SPItems.bronze_chestplate);
		registerItem(SPItems.bronze_leggings);
		registerItem(SPItems.bronze_boots);
		registerItem(SPItems.stone_helmet);
		registerItem(SPItems.stone_chestplate);
		registerItem(SPItems.stone_leggings);
		registerItem(SPItems.stone_boots);
		registerItem(SPItems.titanium_helmet);
		registerItem(SPItems.titanium_chestplate);
		registerItem(SPItems.titanium_leggings);
		registerItem(SPItems.titanium_boots);
		registerItem(SPItems.oak_helmet);
		registerItem(SPItems.oak_chestplate);
		registerItem(SPItems.oak_leggings);
		registerItem(SPItems.oak_boots);
		registerItem(SPItems.spruce_helmet);
		registerItem(SPItems.spruce_chestplate);
		registerItem(SPItems.spruce_leggings);
		registerItem(SPItems.spruce_boots);
		registerItem(SPItems.birch_helmet);
		registerItem(SPItems.birch_chestplate);
		registerItem(SPItems.birch_leggings);
		registerItem(SPItems.birch_boots);
		registerItem(SPItems.jungle_helmet);
		registerItem(SPItems.jungle_chestplate);
		registerItem(SPItems.jungle_leggings);
		registerItem(SPItems.jungle_boots);
		registerItem(SPItems.acacia_helmet);
		registerItem(SPItems.acacia_chestplate);
		registerItem(SPItems.acacia_leggings);
		registerItem(SPItems.acacia_boots);
		registerItem(SPItems.dark_oak_helmet);
		registerItem(SPItems.dark_oak_chestplate);
		registerItem(SPItems.dark_oak_leggings);
		registerItem(SPItems.dark_oak_boots);
		
		if (OreDictionary.getOres("woodRubber").size() > 0) {
			registerItem(SPItems.rubber_helmet);
			registerItem(SPItems.rubber_chestplate);
			registerItem(SPItems.rubber_leggings);
			registerItem(SPItems.rubber_boots);
		}
		
		if(SPCompatibilityManager.isBopLoaded()){
			BOPArmor.register();
		}
		
		if(SPCompatibilityManager.isForestryLoaded()){
			ForestryArmor.register();
		}
	}
	
	public static void registerRenders()
	{
		registerRender(SPItems.bronze_helmet);
		registerRender(SPItems.bronze_chestplate);
		registerRender(SPItems.bronze_leggings);
		registerRender(SPItems.bronze_boots);
		registerRender(SPItems.stone_helmet);
		registerRender(SPItems.stone_chestplate);
		registerRender(SPItems.stone_leggings);
		registerRender(SPItems.stone_boots);
		registerRender(SPItems.titanium_helmet);
		registerRender(SPItems.titanium_chestplate);
		registerRender(SPItems.titanium_leggings);
		registerRender(SPItems.titanium_boots);
		registerRender(SPItems.oak_helmet);
		registerRender(SPItems.oak_chestplate);
		registerRender(SPItems.oak_leggings);
		registerRender(SPItems.oak_boots);
		registerRender(SPItems.spruce_helmet);
		registerRender(SPItems.spruce_chestplate);
		registerRender(SPItems.spruce_leggings);
		registerRender(SPItems.spruce_boots);
		registerRender(SPItems.birch_helmet);
		registerRender(SPItems.birch_chestplate);
		registerRender(SPItems.birch_leggings);
		registerRender(SPItems.birch_boots);
		registerRender(SPItems.jungle_helmet);
		registerRender(SPItems.jungle_chestplate);
		registerRender(SPItems.jungle_leggings);
		registerRender(SPItems.jungle_boots);
		registerRender(SPItems.acacia_helmet);
		registerRender(SPItems.acacia_chestplate);
		registerRender(SPItems.acacia_leggings);
		registerRender(SPItems.acacia_boots);
		registerRender(SPItems.dark_oak_helmet);
		registerRender(SPItems.dark_oak_chestplate);
		registerRender(SPItems.dark_oak_leggings);
		registerRender(SPItems.dark_oak_boots);
		
		if (OreDictionary.getOres("woodRubber").size() > 0) {
			registerRender(SPItems.rubber_helmet);
			registerRender(SPItems.rubber_chestplate);
			registerRender(SPItems.rubber_leggings);
			registerRender(SPItems.rubber_boots);
		}
		
		if(SPCompatibilityManager.isBopLoaded()){
			BOPArmor.registerRenders();
		}
		
		if(SPCompatibilityManager.isForestryLoaded()){
			ForestryArmor.registerRenders();
		}

	}
	
	public static void registerItem(Item item) {
		
		SurvivalPlus.ITEMS_ARMOR.add(item);
	}
	
	public static void registerItems(IForgeRegistry<Item> registry) {
		
	for (Item item : SurvivalPlus.ITEMS_ARMOR)
    {
        registry.register(item);
    	}
	}
	
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
