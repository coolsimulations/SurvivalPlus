package net.coolsimulations.SurvivalPlus.core.init;

import java.util.Collections;
import java.util.List;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class SurvivalPlusArmor {
	
	
	public static void init(){
		
		SPItems.bronzeArmorMaterial = EnumHelper.addArmorMaterial("bronze", SPReference.MOD_ID + ":" +  "bronze", 20, new int[] {2, 6, 5, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
		SPItems.bronze_helmet = new SPItemArmor(SPItems.bronzeArmorMaterial, 0, EntityEquipmentSlot.HEAD, "bronze_helmet", "ingotBronze").setUnlocalizedName("bronze_helmet").setRegistryName("bronze_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.bronze_chestplate = new SPItemArmor(SPItems.bronzeArmorMaterial, 0, EntityEquipmentSlot.CHEST, "bronze_chestplate", "ingotBronze").setUnlocalizedName("bronze_chestplate").setRegistryName("bronze_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.bronze_leggings = new SPItemArmor(SPItems.bronzeArmorMaterial, 0, EntityEquipmentSlot.LEGS, "bronze_leggings", "ingotBronze").setUnlocalizedName("bronze_leggings").setRegistryName("bronze_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.bronze_boots = new SPItemArmor(SPItems.bronzeArmorMaterial, 0, EntityEquipmentSlot.FEET, "bronze_boots", "ingotBronze").setUnlocalizedName("bronze_boots").setRegistryName("bronze_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.bronze = NonNullList.create();
		SPItems.bronze.add(0, new ItemStack(SPItems.bronze_helmet));
		SPItems.bronze.add(1, new ItemStack(SPItems.bronze_chestplate));
		SPItems.bronze.add(2, new ItemStack(SPItems.bronze_leggings));
		SPItems.bronze.add(3, new ItemStack(SPItems.bronze_boots));
		
		SPItems.stoneArmorMaterial = EnumHelper.addArmorMaterial("stone", SPReference.MOD_ID + ":" +  "stone", 20, new int[] {1, 2, 4, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.stone_helmet = new SPItemArmor(SPItems.stoneArmorMaterial, 0, EntityEquipmentSlot.HEAD, "stone_helmet", "cobblestone").setUnlocalizedName("stone_helmet").setRegistryName("stone_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.stone_chestplate = new SPItemArmor(SPItems.stoneArmorMaterial, 0, EntityEquipmentSlot.CHEST, "stone_chestplate", "cobblestone").setUnlocalizedName("stone_chestplate").setRegistryName("stone_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.stone_leggings = new SPItemArmor(SPItems.stoneArmorMaterial, 0, EntityEquipmentSlot.LEGS, "stone_leggings", "cobblestone").setUnlocalizedName("stone_leggings").setRegistryName("stone_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.stone_boots = new SPItemArmor(SPItems.stoneArmorMaterial, 0, EntityEquipmentSlot.FEET, "stone_boots", "cobblestone").setUnlocalizedName("stone_boots").setRegistryName("stone_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.stone = NonNullList.create();
		SPItems.stone.add(0, new ItemStack(SPItems.stone_helmet));
		SPItems.stone.add(1, new ItemStack(SPItems.stone_chestplate));
		SPItems.stone.add(2, new ItemStack(SPItems.stone_leggings));
		SPItems.stone.add(3, new ItemStack(SPItems.stone_boots));
		
		SPItems.titaniumArmorMaterial = EnumHelper.addArmorMaterial("titanium", SPReference.MOD_ID + ":" +  "titanium", 20, new int[] {3, 2, 5, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F);
		SPItems.titanium_helmet = new SPItemArmor(SPItems.titaniumArmorMaterial, 0, EntityEquipmentSlot.HEAD, "titanium_helmet", "ingotTitanium").setUnlocalizedName("titanium_helmet").setRegistryName("titanium_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.titanium_chestplate = new SPItemArmor(SPItems.titaniumArmorMaterial, 0, EntityEquipmentSlot.CHEST, "titanium_chestplate", "ingotTitanium").setUnlocalizedName("titanium_chestplate").setRegistryName("titanium_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.titanium_leggings = new SPItemArmor(SPItems.titaniumArmorMaterial, 0, EntityEquipmentSlot.LEGS, "titanium_leggings", "ingotTitanium").setUnlocalizedName("titanium_leggings").setRegistryName("titanium_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.titanium_boots = new SPItemArmor(SPItems.titaniumArmorMaterial, 0, EntityEquipmentSlot.FEET, "titanium_boots", "ingotTitanium").setUnlocalizedName("titanium_boots").setRegistryName("titanium_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.titanium = NonNullList.create();
		SPItems.titanium.add(0, new ItemStack(SPItems.titanium_helmet));
		SPItems.titanium.add(1, new ItemStack(SPItems.titanium_chestplate));
		SPItems.titanium.add(2, new ItemStack(SPItems.titanium_leggings));
		SPItems.titanium.add(3, new ItemStack(SPItems.titanium_boots));
		
		SPItems.oakArmorMaterial = EnumHelper.addArmorMaterial("oak", SPReference.MOD_ID + ":" +  "oak", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.oak_helmet = new SPItemArmor(SPItems.oakArmorMaterial, 0, EntityEquipmentSlot.HEAD, "oak_helmet", "stickWood").setUnlocalizedName("oak_helmet").setRegistryName("oak_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.oak_chestplate = new SPItemArmor(SPItems.oakArmorMaterial, 0, EntityEquipmentSlot.CHEST, "oak_chestplate", "stickWood").setUnlocalizedName("oak_chestplate").setRegistryName("oak_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.oak_leggings = new SPItemArmor(SPItems.oakArmorMaterial, 0, EntityEquipmentSlot.LEGS, "oak_leggings", "stickWood").setUnlocalizedName("oak_leggings").setRegistryName("oak_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.oak_boots = new SPItemArmor(SPItems.oakArmorMaterial, 0, EntityEquipmentSlot.FEET, "oak_boots", "stickWood").setUnlocalizedName("oak_boots").setRegistryName("oak_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.oak = NonNullList.create();
		SPItems.oak.add(0, new ItemStack(SPItems.oak_helmet));
		SPItems.oak.add(1, new ItemStack(SPItems.oak_chestplate));
		SPItems.oak.add(2, new ItemStack(SPItems.oak_leggings));
		SPItems.oak.add(3, new ItemStack(SPItems.oak_boots));
		
		SPItems.spruceArmorMaterial = EnumHelper.addArmorMaterial("spruce", SPReference.MOD_ID + ":" +  "spruce", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.spruce_helmet = new SPItemArmor(SPItems.spruceArmorMaterial, 0, EntityEquipmentSlot.HEAD, "spruce_helmet", "stickWood").setUnlocalizedName("spruce_helmet").setRegistryName("spruce_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.spruce_chestplate = new SPItemArmor(SPItems.spruceArmorMaterial, 0, EntityEquipmentSlot.CHEST, "spruce_chestplate", "stickWood").setUnlocalizedName("spruce_chestplate").setRegistryName("spruce_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.spruce_leggings = new SPItemArmor(SPItems.spruceArmorMaterial, 0, EntityEquipmentSlot.LEGS, "spruce_leggings", "stickWood").setUnlocalizedName("spruce_leggings").setRegistryName("spruce_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.spruce_boots = new SPItemArmor(SPItems.spruceArmorMaterial, 0, EntityEquipmentSlot.FEET, "spruce_boots", "stickWood").setUnlocalizedName("spruce_boots").setRegistryName("spruce_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.spruce = NonNullList.create();
		SPItems.spruce.add(0, new ItemStack(SPItems.spruce_helmet));
		SPItems.spruce.add(1, new ItemStack(SPItems.spruce_chestplate));
		SPItems.spruce.add(2, new ItemStack(SPItems.spruce_leggings));
		SPItems.spruce.add(3, new ItemStack(SPItems.spruce_boots));
		
		SPItems.birchArmorMaterial = EnumHelper.addArmorMaterial("birch", SPReference.MOD_ID + ":" +  "birch", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.birch_helmet = new SPItemArmor(SPItems.birchArmorMaterial, 0, EntityEquipmentSlot.HEAD, "birch_helmet", "stickWood").setUnlocalizedName("birch_helmet").setRegistryName("birch_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.birch_chestplate = new SPItemArmor(SPItems.birchArmorMaterial, 0, EntityEquipmentSlot.CHEST, "birch_chestplate", "stickWood").setUnlocalizedName("birch_chestplate").setRegistryName("birch_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.birch_leggings = new SPItemArmor(SPItems.birchArmorMaterial, 0, EntityEquipmentSlot.LEGS, "birch_leggings", "stickWood").setUnlocalizedName("birch_leggings").setRegistryName("birch_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.birch_boots = new SPItemArmor(SPItems.birchArmorMaterial, 0, EntityEquipmentSlot.FEET, "birch_boots", "stickWood").setUnlocalizedName("birch_boots").setRegistryName("birch_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.birch = NonNullList.create();
		SPItems.birch.add(0, new ItemStack(SPItems.birch_helmet));
		SPItems.birch.add(1, new ItemStack(SPItems.birch_chestplate));
		SPItems.birch.add(2, new ItemStack(SPItems.birch_leggings));
		SPItems.birch.add(3, new ItemStack(SPItems.birch_boots));
		
		SPItems.jungleArmorMaterial = EnumHelper.addArmorMaterial("jungle", SPReference.MOD_ID + ":" +  "jungle", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.jungle_helmet = new SPItemArmor(SPItems.jungleArmorMaterial, 0, EntityEquipmentSlot.HEAD, "jungle_helmet", "stickWood").setUnlocalizedName("jungle_helmet").setRegistryName("jungle_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.jungle_chestplate = new SPItemArmor(SPItems.jungleArmorMaterial, 0, EntityEquipmentSlot.CHEST, "jungle_chestplate", "stickWood").setUnlocalizedName("jungle_chestplate").setRegistryName("jungle_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.jungle_leggings = new SPItemArmor(SPItems.jungleArmorMaterial, 0, EntityEquipmentSlot.LEGS, "jungle_leggings", "stickWood").setUnlocalizedName("jungle_leggings").setRegistryName("jungle_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.jungle_boots = new SPItemArmor(SPItems.jungleArmorMaterial, 0, EntityEquipmentSlot.FEET, "jungle_boots", "stickWood").setUnlocalizedName("jungle_boots").setRegistryName("jungle_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.jungle = NonNullList.create();
		SPItems.jungle.add(0, new ItemStack(SPItems.jungle_helmet));
		SPItems.jungle.add(1, new ItemStack(SPItems.jungle_chestplate));
		SPItems.jungle.add(2, new ItemStack(SPItems.jungle_leggings));
		SPItems.jungle.add(3, new ItemStack(SPItems.jungle_boots));
		
		SPItems.acaciaArmorMaterial = EnumHelper.addArmorMaterial("acacia", SPReference.MOD_ID + ":" +  "acacia", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.acacia_helmet = new SPItemArmor(SPItems.acaciaArmorMaterial, 0, EntityEquipmentSlot.HEAD, "acacia_helmet", "stickWood").setUnlocalizedName("acacia_helmet").setRegistryName("acacia_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.acacia_chestplate = new SPItemArmor(SPItems.acaciaArmorMaterial, 0, EntityEquipmentSlot.CHEST, "acacia_chestplate", "stickWood").setUnlocalizedName("acacia_chestplate").setRegistryName("acacia_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.acacia_leggings = new SPItemArmor(SPItems.acaciaArmorMaterial, 0, EntityEquipmentSlot.LEGS, "acacia_leggings", "stickWood").setUnlocalizedName("acacia_leggings").setRegistryName("acacia_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.acacia_boots = new SPItemArmor(SPItems.acaciaArmorMaterial, 0, EntityEquipmentSlot.FEET, "acacia_boots", "stickWood").setUnlocalizedName("acacia_boots").setRegistryName("acacia_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.acacia = NonNullList.create();
		SPItems.acacia.add(0, new ItemStack(SPItems.acacia_helmet));
		SPItems.acacia.add(1, new ItemStack(SPItems.acacia_chestplate));
		SPItems.acacia.add(2, new ItemStack(SPItems.acacia_leggings));
		SPItems.acacia.add(3, new ItemStack(SPItems.acacia_boots));
		
		SPItems.darkOakArmorMaterial = EnumHelper.addArmorMaterial("dark_oak", SPReference.MOD_ID + ":" +  "dark_oak", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
		SPItems.dark_oak_helmet = new SPItemArmor(SPItems.darkOakArmorMaterial, 0, EntityEquipmentSlot.HEAD, "dark_oak_helmet", "stickWood").setUnlocalizedName("dark_oak_helmet").setRegistryName("dark_oak_helmet").setCreativeTab(SPTabs.tabCombat);
		SPItems.dark_oak_chestplate = new SPItemArmor(SPItems.darkOakArmorMaterial, 0, EntityEquipmentSlot.CHEST, "dark_oak_chestplate", "stickWood").setUnlocalizedName("dark_oak_chestplate").setRegistryName("dark_oak_chestplate").setCreativeTab(SPTabs.tabCombat);
		SPItems.dark_oak_leggings = new SPItemArmor(SPItems.darkOakArmorMaterial, 0, EntityEquipmentSlot.LEGS, "dark_oak_leggings", "stickWood").setUnlocalizedName("dark_oak_leggings").setRegistryName("dark_oak_leggings").setCreativeTab(SPTabs.tabCombat);
		SPItems.dark_oak_boots = new SPItemArmor(SPItems.darkOakArmorMaterial, 0, EntityEquipmentSlot.FEET, "dark_oak_boots", "stickWood").setUnlocalizedName("dark_oak_boots").setRegistryName("dark_oak_boots").setCreativeTab(SPTabs.tabCombat);
		SPItems.dark_oak = NonNullList.create();
		SPItems.dark_oak.add(0, new ItemStack(SPItems.dark_oak_helmet));
		SPItems.dark_oak.add(1, new ItemStack(SPItems.dark_oak_chestplate));
		SPItems.dark_oak.add(2, new ItemStack(SPItems.dark_oak_leggings));
		SPItems.dark_oak.add(3, new ItemStack(SPItems.dark_oak_boots));

		if (OreDictionary.getOres("woodRubber").size() > 0) {
			
			SPItems.rubberArmorMaterial = EnumHelper.addArmorMaterial("rubber", SPReference.MOD_ID + ":" + "rubber", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
			SPItems.rubber_helmet = new SPItemArmor(SPItems.rubberArmorMaterial, 0, EntityEquipmentSlot.HEAD, "rubber_helmet", "stickWood").setUnlocalizedName("rubber_helmet").setRegistryName("rubber_helmet").setCreativeTab(SPTabs.tabCombat);
			SPItems.rubber_chestplate = new SPItemArmor(SPItems.rubberArmorMaterial, 0, EntityEquipmentSlot.CHEST, "rubber_chestplate", "stickWood").setUnlocalizedName("rubber_chestplate").setRegistryName("rubber_chestplate").setCreativeTab(SPTabs.tabCombat);
			SPItems.rubber_leggings = new SPItemArmor(SPItems.rubberArmorMaterial, 0, EntityEquipmentSlot.LEGS, "rubber_leggings", "stickWood").setUnlocalizedName("rubber_leggings").setRegistryName("rubber_leggings").setCreativeTab(SPTabs.tabCombat);
			SPItems.rubber_boots = new SPItemArmor(SPItems.rubberArmorMaterial, 0, EntityEquipmentSlot.FEET, "rubber_boots", "stickWood").setUnlocalizedName("rubber_boots").setRegistryName("rubber_boots").setCreativeTab(SPTabs.tabCombat);
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
		register(SPItems.bronze);
		register(SPItems.stone);
		register(SPItems.titanium);
		register(SPItems.oak);
		register(SPItems.spruce);
		register(SPItems.birch);
		register(SPItems.jungle);
		register(SPItems.acacia);
		register(SPItems.dark_oak);
		
		if (OreDictionary.getOres("woodRubber").size() > 0) {
			
			register(SPItems.rubber);
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
		
		registerRender(SPItems.bronze);
		registerRender(SPItems.stone);
		registerRender(SPItems.titanium);
		registerRender(SPItems.oak);
		registerRender(SPItems.spruce);
		registerRender(SPItems.birch);
		registerRender(SPItems.jungle);
		registerRender(SPItems.acacia);
		registerRender(SPItems.dark_oak);
		
		if (OreDictionary.getOres("woodRubber").size() > 0) {

			registerRender(SPItems.rubber);
		}
		
		if(SPCompatibilityManager.isBopLoaded()){
			BOPArmor.registerRenders();
		}
		
		if(SPCompatibilityManager.isForestryLoaded()){
			ForestryArmor.registerRenders();
		}

	}
	
	public static void register(NonNullList<ItemStack> item)
	{
		for(int i = 0; i < item.size(); i++) {
			GameRegistry.register(item.get(i).getItem());
		}
	}
	
	public static void registerRender(NonNullList<ItemStack> item)
	{
		for(int i = 0; i < item.size(); i++) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item.get(i).getItem(), 0, new ModelResourceLocation(item.get(i).getItem().getRegistryName(), "inventory"));
		}
	}

}
