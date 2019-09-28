package net.coolsimulations.SurvivalPlus.core.init;

import java.util.Collections;
import java.util.List;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTags;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.minecraft.client.Minecraft;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.util.SoundEvents;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.Tags;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagCollection;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class SurvivalPlusArmor {
	
	public static void init(){
		
		SPItems.bronze_helmet = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, EquipmentSlotType.HEAD).setRegistryName("bronze_helmet");
		SPItems.bronze_chestplate = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, EquipmentSlotType.CHEST).setRegistryName("bronze_chestplate");
		SPItems.bronze_leggings = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, EquipmentSlotType.LEGS).setRegistryName("bronze_leggings");
		SPItems.bronze_boots = new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, EquipmentSlotType.FEET).setRegistryName("bronze_boots");
		SPItems.bronze = NonNullList.create();
		SPItems.bronze.add(0, new ItemStack(SPItems.bronze_helmet));
		SPItems.bronze.add(1, new ItemStack(SPItems.bronze_chestplate));
		SPItems.bronze.add(2, new ItemStack(SPItems.bronze_leggings));
		SPItems.bronze.add(3, new ItemStack(SPItems.bronze_boots));
		
		SPItems.stone_helmet = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, EquipmentSlotType.HEAD).setRegistryName("stone_helmet");
		SPItems.stone_chestplate = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, EquipmentSlotType.CHEST).setRegistryName("stone_chestplate");
		SPItems.stone_leggings = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, EquipmentSlotType.LEGS).setRegistryName("stone_leggings");
		SPItems.stone_boots = new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, EquipmentSlotType.FEET).setRegistryName("stone_boots");
		SPItems.stone = NonNullList.create();
		SPItems.stone.add(0, new ItemStack(SPItems.stone_helmet));
		SPItems.stone.add(1, new ItemStack(SPItems.stone_chestplate));
		SPItems.stone.add(2, new ItemStack(SPItems.stone_leggings));
		SPItems.stone.add(3, new ItemStack(SPItems.stone_boots));
		
		SPItems.titanium_helmet = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, EquipmentSlotType.HEAD).setRegistryName("titanium_helmet");
		SPItems.titanium_chestplate = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, EquipmentSlotType.CHEST).setRegistryName("titanium_chestplate");
		SPItems.titanium_leggings = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, EquipmentSlotType.LEGS).setRegistryName("titanium_leggings");
		SPItems.titanium_boots = new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, EquipmentSlotType.FEET).setRegistryName("titanium_boots");
		SPItems.titanium = NonNullList.create();
		SPItems.titanium.add(0, new ItemStack(SPItems.titanium_helmet));
		SPItems.titanium.add(1, new ItemStack(SPItems.titanium_chestplate));
		SPItems.titanium.add(2, new ItemStack(SPItems.titanium_leggings));
		SPItems.titanium.add(3, new ItemStack(SPItems.titanium_boots));
		
		SPItems.oak_helmet = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, EquipmentSlotType.HEAD).setRegistryName("oak_helmet");
		SPItems.oak_chestplate = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, EquipmentSlotType.CHEST).setRegistryName("oak_chestplate");
		SPItems.oak_leggings = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, EquipmentSlotType.LEGS).setRegistryName("oak_leggings");
		SPItems.oak_boots = new SPItemArmor(SPArmorMaterial.oakArmorMaterial, EquipmentSlotType.FEET).setRegistryName("oak_boots");
		SPItems.oak = NonNullList.create();
		SPItems.oak.add(0, new ItemStack(SPItems.oak_helmet));
		SPItems.oak.add(1, new ItemStack(SPItems.oak_chestplate));
		SPItems.oak.add(2, new ItemStack(SPItems.oak_leggings));
		SPItems.oak.add(3, new ItemStack(SPItems.oak_boots));
		
		SPItems.spruce_helmet = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, EquipmentSlotType.HEAD).setRegistryName("spruce_helmet");
		SPItems.spruce_chestplate = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, EquipmentSlotType.CHEST).setRegistryName("spruce_chestplate");
		SPItems.spruce_leggings = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, EquipmentSlotType.LEGS).setRegistryName("spruce_leggings");
		SPItems.spruce_boots = new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, EquipmentSlotType.FEET).setRegistryName("spruce_boots");
		SPItems.spruce = NonNullList.create();
		SPItems.spruce.add(0, new ItemStack(SPItems.spruce_helmet));
		SPItems.spruce.add(1, new ItemStack(SPItems.spruce_chestplate));
		SPItems.spruce.add(2, new ItemStack(SPItems.spruce_leggings));
		SPItems.spruce.add(3, new ItemStack(SPItems.spruce_boots));
		
		SPItems.birch_helmet = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, EquipmentSlotType.HEAD).setRegistryName("birch_helmet");
		SPItems.birch_chestplate = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, EquipmentSlotType.CHEST).setRegistryName("birch_chestplate");
		SPItems.birch_leggings = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, EquipmentSlotType.LEGS).setRegistryName("birch_leggings");
		SPItems.birch_boots = new SPItemArmor(SPArmorMaterial.birchArmorMaterial, EquipmentSlotType.FEET).setRegistryName("birch_boots");
		SPItems.birch = NonNullList.create();
		SPItems.birch.add(0, new ItemStack(SPItems.birch_helmet));
		SPItems.birch.add(1, new ItemStack(SPItems.birch_chestplate));
		SPItems.birch.add(2, new ItemStack(SPItems.birch_leggings));
		SPItems.birch.add(3, new ItemStack(SPItems.birch_boots));
		
		SPItems.jungle_helmet = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, EquipmentSlotType.HEAD).setRegistryName("jungle_helmet");
		SPItems.jungle_chestplate = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, EquipmentSlotType.CHEST).setRegistryName("jungle_chestplate");
		SPItems.jungle_leggings = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, EquipmentSlotType.LEGS).setRegistryName("jungle_leggings");
		SPItems.jungle_boots = new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, EquipmentSlotType.FEET).setRegistryName("jungle_boots");
		SPItems.jungle = NonNullList.create();
		SPItems.jungle.add(0, new ItemStack(SPItems.jungle_helmet));
		SPItems.jungle.add(1, new ItemStack(SPItems.jungle_chestplate));
		SPItems.jungle.add(2, new ItemStack(SPItems.jungle_leggings));
		SPItems.jungle.add(3, new ItemStack(SPItems.jungle_boots));
		
		SPItems.acacia_helmet = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, EquipmentSlotType.HEAD).setRegistryName("acacia_helmet");
		SPItems.acacia_chestplate = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, EquipmentSlotType.CHEST).setRegistryName("acacia_chestplate");
		SPItems.acacia_leggings = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, EquipmentSlotType.LEGS).setRegistryName("acacia_leggings");
		SPItems.acacia_boots = new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, EquipmentSlotType.FEET).setRegistryName("acacia_boots");
		SPItems.acacia = NonNullList.create();
		SPItems.acacia.add(0, new ItemStack(SPItems.acacia_helmet));
		SPItems.acacia.add(1, new ItemStack(SPItems.acacia_chestplate));
		SPItems.acacia.add(2, new ItemStack(SPItems.acacia_leggings));
		SPItems.acacia.add(3, new ItemStack(SPItems.acacia_boots));
		
		SPItems.dark_oak_helmet = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, EquipmentSlotType.HEAD).setRegistryName("dark_oak_helmet");
		SPItems.dark_oak_chestplate = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, EquipmentSlotType.CHEST).setRegistryName("dark_oak_chestplate");
		SPItems.dark_oak_leggings = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, EquipmentSlotType.LEGS).setRegistryName("dark_oak_leggings");
		SPItems.dark_oak_boots = new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, EquipmentSlotType.FEET).setRegistryName("dark_oak_boots");
		SPItems.dark_oak = NonNullList.create();
		SPItems.dark_oak.add(0, new ItemStack(SPItems.dark_oak_helmet));
		SPItems.dark_oak.add(1, new ItemStack(SPItems.dark_oak_chestplate));
		SPItems.dark_oak.add(2, new ItemStack(SPItems.dark_oak_leggings));
		SPItems.dark_oak.add(3, new ItemStack(SPItems.dark_oak_boots));

		if (SPCompatibilityManager.isIc2Loaded()) {
			
			SPItems.rubber_helmet = new SPItemArmor(SPArmorMaterial.rubberArmorMaterial, EquipmentSlotType.HEAD).setRegistryName("rubber_helmet");
			SPItems.rubber_chestplate = new SPItemArmor(SPArmorMaterial.rubberArmorMaterial, EquipmentSlotType.CHEST).setRegistryName("rubber_chestplate");
			SPItems.rubber_leggings = new SPItemArmor(SPArmorMaterial.rubberArmorMaterial, EquipmentSlotType.LEGS).setRegistryName("rubber_leggings");
			SPItems.rubber_boots = new SPItemArmor(SPArmorMaterial.rubberArmorMaterial, EquipmentSlotType.FEET).setRegistryName("rubber_boots");
			SPItems.rubber = NonNullList.create();
			SPItems.rubber.add(0, new ItemStack(SPItems.rubber_helmet));
			SPItems.rubber.add(1, new ItemStack(SPItems.rubber_chestplate));
			SPItems.rubber.add(2, new ItemStack(SPItems.rubber_leggings));
			SPItems.rubber.add(3, new ItemStack(SPItems.rubber_boots));
			
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
		registerItem(SPItems.bronze);
		registerItem(SPItems.stone);
		registerItem(SPItems.titanium);
		registerItem(SPItems.oak);
		registerItem(SPItems.spruce);
		registerItem(SPItems.birch);
		registerItem(SPItems.jungle);
		registerItem(SPItems.acacia);
		registerItem(SPItems.dark_oak);
		
		if (SPCompatibilityManager.isIc2Loaded()) {
			
			registerItem(SPItems.rubber);
		}

		
		if(SPCompatibilityManager.isBopLoaded()){
			BOPArmor.register();
		}
		
		if(SPCompatibilityManager.isForestryLoaded()){
			ForestryArmor.register();
		}
	}

	public static void registerItem(NonNullList<ItemStack> item) {
		
		for(int i = 0; i < item.size(); i++) {
			ForgeRegistries.ITEMS.register(item.get(i).getItem());
		}
	}

}
