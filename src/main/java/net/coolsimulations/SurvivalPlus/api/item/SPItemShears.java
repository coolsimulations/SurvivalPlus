package net.coolsimulations.SurvivalPlus.api.item;

import java.util.List;

import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SPItemShears extends ItemShears{
	
	public final String oreDictionary;
	
	public SPItemShears(int maxDamage, String oreDictionary)
    {
        this.setMaxStackSize(1);
        this.setMaxDamage(maxDamage);
        this.oreDictionary = oreDictionary;
    }
	
	@Override
    public boolean getIsRepairable(ItemStack tool, ItemStack stack)
    {
    	List<ItemStack> acceptableItems = OreDictionary.getOres(oreDictionary);
    	for(ItemStack i : acceptableItems ){
    		if(ItemStack.areItemsEqual(i, stack) && this.oreDictionary != null) return true;
    	}
    	return false;
    }

}
