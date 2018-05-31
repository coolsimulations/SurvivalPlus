package net.coolsimulations.SurvivalPlus.api.item;

import java.util.List;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.oredict.OreDictionary;

public class SPItemArmor extends ItemArmor{
	
	public final String name;
	public final String oreDictionary;

    public SPItemArmor(ItemArmor.ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlotIn , String name, String oreDictionary) {
		super(material, renderIndex, equipmentSlotIn);
		this.name = name;
		this.oreDictionary = oreDictionary;
	}

	public String getName(){
		return name;
		
	}
	
	/**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack armor, ItemStack stack)
    {
    	List<ItemStack> acceptableItems = OreDictionary.getOres(oreDictionary);
    	for(ItemStack i : acceptableItems ){
    		if(ItemStack.areItemsEqual(i, stack) && this.oreDictionary != null) return true;
    	}
    	return false;
    }

}
