package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class SPItemArmor extends ItemArmor{
	
    public SPItemArmor(IArmorMaterial material, EntityEquipmentSlot equipmentSlotIn) {
		super(material, equipmentSlotIn, (new Item.Properties()).group(SPTabs.tabCombat));
	}

}
