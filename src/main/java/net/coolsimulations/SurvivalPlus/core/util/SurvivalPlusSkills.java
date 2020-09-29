package net.coolsimulations.SurvivalPlus.core.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import codersafterdark.reskillable.base.LevelLockHandler;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.item.SPItemAxe;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import scala.actors.threadpool.Arrays;

public class SurvivalPlusSkills {
	
	protected static List<String> skills = new ArrayList<String>();
	public static boolean isNotBlacklist;
	
	public static void initReskillable(FMLPreInitializationEvent event) {
		
		Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "reskillable.cfg"));
		
		String desc = "Set requirements for items in this list. Each entry is composed of the item key and the requirements\nThe item key is in the simple mod:item_id format. Optionally, it can be in mod:item_id:metadata, if you want to match metadata.\nThe requirements are in a comma separated list, each in a key|value format. For example, to make an iron pickaxe require 5 mining\nand 5 building, you'd use the following string:\n\"minecraft:iron_pickaxe=mining|5,building|5\"\n\nItem usage can also be locked behind an advancement, by using adv|id. For example, to make the elytra require the \"Acquire Hardware.\" advancement\nyou'd use the following string:\n\"minecraft:elytra=adv|minecraft:story/smelt_iron\"\n\nSkill requirements and advancements can be mixed and matched, so you can make an item require both, if you want.\nYou can also lock placed blocks from being used or broken, in the same manner.\n\nLocks defined here apply to all the following cases: Right clicking an item, placing a block, breaking a block, using a block that's placed,\nleft clicking an item, using an item to break any block, and equipping an armor item.\n\nYou can lock entire mods by just using their name as the left argument. You can then specify specific items to not be locked,\nby defining their lock in the normal way. If you want an item to not be locked in this way, use \"none\" after the =";
		Property itemsList = config.get(Configuration.CATEGORY_GENERAL, "Skill Locks", LevelLockHandler.DEFAULT_SKILL_LOCKS, desc);
		
		List<String> locksList = new ArrayList<String>(Arrays.asList(itemsList.getStringList()));
		skills = locksList;
		
		Property blacklist = config.get(Configuration.CATEGORY_GENERAL, "Enable Automatic SurvivalPlus Entries", true, "SurvivalPlus automatically adds it's values based on the set Iron ones, turn this off to remove SurvivalPlus entries from the Skill Locks list");
		isNotBlacklist = blacklist.getBoolean(true);

		addItemDynamic(locksList, SPItems.bronze_shovel, "gathering", -2, "iron", 3);
		addItemDynamic(locksList, SPItems.bronze_axe, "gathering", -2, "iron", 3);
		addItemDynamic(locksList, SPItems.bronze_sword, "attack", -2, "iron", 3);
		addItemDynamic(locksList, SPItems.bronze_pickaxe, "mining", -2, "iron", 3);
		addItemDynamic(locksList, SPItems.bronze_hoe, "farming", -2, "iron", 3);
		addItemDynamic(locksList, SPItems.bronze_helmet, "defense", -2, "iron", 3);
		addItemDynamic(locksList, SPItems.bronze_chestplate, "defense", -2, "iron", 3);
		addItemDynamic(locksList, SPItems.bronze_leggings, "defense", -2, "iron", 3);
		addItemDynamic(locksList, SPItems.bronze_boots, "defense", -2, "iron", 3);
		addItemDynamic(locksList, SPItems.bronze_shears, "farming", -2, "gathering", "iron", 3);
		addItemDynamic(locksList, SPItems.bronze_shield, "defense", -2, "iron", 6);
		
		addItemDynamic(locksList, SPItems.titanium_shovel, "gathering", 2, "iron", 7);
		addItemDynamic(locksList, SPItems.titanium_axe, "gathering", 2, "iron", 7);
		addItemDynamic(locksList, SPItems.titanium_sword, "attack", 2, "iron", 7);
		addItemDynamic(locksList, SPItems.titanium_pickaxe, "mining", 2, "iron", 7);
		addItemDynamic(locksList, SPItems.titanium_hoe, "farming", 2, "iron", 7);
		addItemDynamic(locksList, SPItems.titanium_helmet, "defense", 2, "iron", 7);
		addItemDynamic(locksList, SPItems.titanium_chestplate, "defense", 2, "iron", 7);
		addItemDynamic(locksList, SPItems.titanium_leggings, "defense", 2, "iron", 7);
		addItemDynamic(locksList, SPItems.titanium_boots, "defense", 2, "iron", 7);
		addItemDynamic(locksList, SPItems.titanium_shears, "farming", 2, "gathering", "iron", 7);
		addItemDynamic(locksList, SPItems.titanium_shield, "defense", 2, "iron", 10);
		
		itemsList.set(skills.toArray(new String[0]));;

		config.save();
	}
	
	protected static void addItem(List<String> originalList, Item item, String type, int level) {
		
		if(!checkList(originalList, item) && isNotBlacklist) {
			skills.add(item.getRegistryName() + ":*=reskillable:" + type + "|" + level);
		}	
	}
	
	protected static void addItem(List<String> originalList, Item item, String typeOne, int levelOne, String typeTwo, int levelTwo) {
		
		if(!checkList(originalList, item) && isNotBlacklist) {
			skills.add(item.getRegistryName() + ":*=reskillable:" + typeOne + "|" + levelOne + ",reskillable:" + typeTwo + "|" + levelTwo);
		}	
	}
	
	protected static void addItemDynamic(List<String> originalList, Item item, String type, int levelDifference, String material, int backupDefault) {
		
		int originalLevel = getIntFromMaterial(originalList, item, material);
		int finalInt;
		
		if((originalLevel + levelDifference) < 0)
			finalInt = backupDefault;
		else
			finalInt = originalLevel + levelDifference;
		
		addItem(originalList, item, type, finalInt);
	}
	
	protected static void addItemDynamic(List<String> originalList, Item item, String typeOne, int levelDifference, String typeTwo, String material, int backupDefault) {
		
		int originalLevel = getIntFromMaterial(originalList, item, material);
		int finalInt;
		
		if((originalLevel + levelDifference) < 0)
			finalInt = backupDefault;
		else
			finalInt = originalLevel + levelDifference;
		
		addItem(originalList, item, typeOne, finalInt, typeTwo, finalInt);
	}
	
	protected static boolean checkList(List<String> list, Item item) {
		
		for(int i = 0; i < list.size(); i++ ) {
			
			if(list.get(i).contains(item.getRegistryName().toString()))
				return true;
		}
		
		return false;
	}
	
	protected static String checkListString(List<String> list, Item item) {
		
		for(int i = 0; i < list.size(); i++ ) {
			
			if(list.get(i).contains(item.getRegistryName().toString()))
				return list.get(i);
		}
		
		return "";
	}
	
	protected static int getIntFromString(String skill, Item checkedItem) {
		
		if(StringUtils.countMatches(skill, "reskillable") == 1) {
			String edited = removeItem(removeSkill(removePrefix(skill)), checkedItem);
			return Integer.parseInt(edited);
		}
		
		if(StringUtils.countMatches(skill, "reskillable") == 2) {
			String edited = removeItem(removeSkill(removePrefix(skill)), checkedItem);
			if(edited.length() == 2) {
				int first = Character.getNumericValue((edited.charAt(0)));
				int second = Character.getNumericValue((edited.charAt(1)));
				System.out.print("ASDF: First: " + first + " Second: " + second);
				if(first == second)
					return first;
				else
					return first < second ? second : second < first ? first : 1;
			} else if(edited.length() == 3) {
				int first = Character.getNumericValue(edited.charAt(0)) + Character.getNumericValue(edited.charAt(1));
				int second = Character.getNumericValue(edited.charAt(1)) + Character.getNumericValue(edited.charAt(2));
				if(first == second)
					return first;
				else
					return first < second ? second : second < first ? first : 1;
			} else if(edited.length() == 4) {
				int first = Character.getNumericValue(edited.charAt(0)) + Character.getNumericValue(edited.charAt(1));
				int second = Character.getNumericValue(edited.charAt(2)) + Character.getNumericValue(edited.charAt(3));
				if(first == second)
					return first;
				else
					return first < second ? second : second < first ? first : 1;
			}
		}
		
		return 1;
	}
	
	protected static String removePrefix(String skill) {
		
		String edited = skill;
		
		edited = edited.replace(":*=reskillable:", "");
		edited = edited.replace("|", "");
		if(edited.contains(",reskillable:"))
			edited = edited.replace(",reskillable:", "");
		
		return edited;
	}
	
	protected static String removeItem(String skill, Item item) {
		
		String edited = skill;
		
		edited = edited.replace(item.getRegistryName().toString(), "");
		
		return edited;
	}
	
	protected static String removeSkill(String skill) {
		
		String edited = skill;
		
		if(edited.contains("gathering"))
			edited = edited.replace("gathering", "");
		if(edited.contains("mining"))
			edited = edited.replace("mining", "");
		if(edited.contains("farming"))
			edited = edited.replace("farming", "");
		if(edited.contains("attack"))
			edited = edited.replace("attack", "");
		if(edited.contains("defense"))
			edited = edited.replace("defense", "");
		if(edited.contains("agility"))
			edited = edited.replace("agility", "");
		if(edited.contains("magic"))
			edited = edited.replace("magic", "");
		if(edited.contains("building"))
			edited = edited.replace("building", "");
		
		return edited;
	}
	
	protected static int getIntFromMaterial(List<String> list, Item item, String material) {
		
		if(material.toLowerCase() == "iron") {
			if(item instanceof ItemSpade && checkList(list, Items.IRON_SHOVEL)) {
				String shovel = checkListString(list, Items.IRON_SHOVEL);
				return getIntFromString(shovel, Items.IRON_SHOVEL);
			}
			
			if((item instanceof SPItemAxe || item instanceof ItemAxe || (item instanceof ItemTool && item.getRegistryName().getResourcePath().contains("axe") && !item.getRegistryName().getResourcePath().contains("pickaxe"))) && checkList(list, Items.IRON_AXE)) {
				String shovel = checkListString(list, Items.IRON_AXE);
				return getIntFromString(shovel, Items.IRON_AXE);
			}
			
			if(item instanceof ItemSword && checkList(list, Items.IRON_SWORD)) {
				String shovel = checkListString(list, Items.IRON_SWORD);
				return getIntFromString(shovel, Items.IRON_SWORD);
			}
			
			if(item instanceof ItemPickaxe && checkList(list, Items.IRON_PICKAXE)) {
				String shovel = checkListString(list, Items.IRON_PICKAXE);
				return getIntFromString(shovel, Items.IRON_PICKAXE);
			}
			
			if(item instanceof ItemHoe && checkList(list, Items.IRON_HOE)) {
				String shovel = checkListString(list, Items.IRON_HOE);
				return getIntFromString(shovel, Items.IRON_HOE);
			}
			
			if(item instanceof ItemArmor && ((ItemArmor) item).getEquipmentSlot() == EntityEquipmentSlot.HEAD && checkList(list, Items.IRON_HELMET)) {
				String shovel = checkListString(list, Items.IRON_HELMET);
				return getIntFromString(shovel, Items.IRON_HELMET);
			}
			
			if(item instanceof ItemArmor && ((ItemArmor) item).getEquipmentSlot() == EntityEquipmentSlot.CHEST && checkList(list, Items.IRON_CHESTPLATE)) {
				String shovel = checkListString(list, Items.IRON_CHESTPLATE);
				return getIntFromString(shovel, Items.IRON_CHESTPLATE);
			}
			
			if(item instanceof ItemArmor && ((ItemArmor) item).getEquipmentSlot() == EntityEquipmentSlot.LEGS && checkList(list, Items.IRON_LEGGINGS)) {
				String shovel = checkListString(list, Items.IRON_LEGGINGS);
				return getIntFromString(shovel, Items.IRON_LEGGINGS);
			}
			
			if(item instanceof ItemArmor && ((ItemArmor) item).getEquipmentSlot() == EntityEquipmentSlot.FEET && checkList(list, Items.IRON_BOOTS)) {
				String shovel = checkListString(list, Items.IRON_BOOTS);
				return getIntFromString(shovel, Items.IRON_BOOTS);
			}
			
			if(item instanceof ItemShears && checkList(list, Items.SHEARS)) {
				String shovel = checkListString(list, Items.SHEARS);
				return getIntFromString(shovel, Items.SHEARS);
			}
			
			if(item instanceof ItemShield && checkList(list, Items.SHIELD)) {
				String shovel = checkListString(list, Items.SHIELD);
				return getIntFromString(shovel, Items.SHIELD);
			}
		}
		
		return 1;
	}

}
