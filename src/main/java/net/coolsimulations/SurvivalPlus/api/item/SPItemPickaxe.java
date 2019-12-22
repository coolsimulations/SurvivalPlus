package net.coolsimulations.SurvivalPlus.api.item;

import java.util.List;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SPItemPickaxe extends ItemPickaxe{
	
	public final String oreDictionary;

	public SPItemPickaxe(ToolMaterial material, String oreDictionary) {
		super(material);
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
