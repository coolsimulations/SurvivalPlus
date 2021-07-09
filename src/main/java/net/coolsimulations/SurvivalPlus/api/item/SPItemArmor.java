package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class SPItemArmor extends ArmorItem{
	
    public SPItemArmor(ArmorMaterial material, EquipmentSlot equipmentSlotIn) {
		super(material, equipmentSlotIn, (new FabricItemSettings()).tab(SPTabs.tabCombat));
	}

}
