package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class SPItemArmor extends ArmorItem{
	
    public SPItemArmor(ArmorMaterial material, EquipmentSlot equipmentSlotIn) {
		super(material, equipmentSlotIn, (new FabricItemSettings()).group(SPTabs.tabCombat));
	}

}
