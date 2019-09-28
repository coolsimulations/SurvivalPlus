package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ArmorItem;

public class SPItemArmor extends ArmorItem{
	
    public SPItemArmor(IArmorMaterial material, EquipmentSlotType equipmentSlotIn) {
		super(material, equipmentSlotIn, (new Item.Properties()).group(SPTabs.tabCombat));
	}

}
