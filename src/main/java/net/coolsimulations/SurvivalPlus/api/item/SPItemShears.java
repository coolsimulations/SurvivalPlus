package net.coolsimulations.SurvivalPlus.api.item;

import net.minecraft.item.ItemShears;

public class SPItemShears extends ItemShears{
	
	public SPItemShears(int maxDamage)
    {
        this.setMaxStackSize(1);
        this.setMaxDamage(maxDamage);
    }

}
