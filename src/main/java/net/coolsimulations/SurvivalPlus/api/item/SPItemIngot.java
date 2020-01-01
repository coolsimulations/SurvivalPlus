package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SPItemIngot extends Item {
	
	public final boolean beacon;
	
	public SPItemIngot(boolean isBeaconIngot) {
		super(new Item.Properties().group(SPTabs.tabMaterials));
		this.beacon = isBeaconIngot;
	}
	
	/**
     * Whether this Item can be used as a payment to activate the vanilla beacon.
     *
     * @param stack the ItemStack
     * @return true if this Item can be used
     */
	@Override
	public boolean isBeaconPayment(ItemStack stack)
    {
        return this.beacon;
    }

}
