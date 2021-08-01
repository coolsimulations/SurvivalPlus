package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem;

public class SPItemArmor extends ArmorItem{
	
    public SPItemArmor(ArmorMaterial material, EquipmentSlot equipmentSlotIn) {
		super(material, equipmentSlotIn, (new Item.Properties()).tab(SPTabs.tabCombat));
	}

}
