package net.coolsimulations.SurvivalPlus.api.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class SPItemArmor extends ArmorItem{
	
    public SPItemArmor(ArmorMaterial material, Type equipmentSlotIn) {
		super(material, equipmentSlotIn, (new FabricItemSettings()));
	}

}
