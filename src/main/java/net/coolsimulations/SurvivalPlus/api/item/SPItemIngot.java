package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SPItemIngot extends Item {
	
	private boolean beacon;
	private boolean golem;
	private float health;
	
	public SPItemIngot(boolean isBeaconIngot, boolean healsIronGolem, float golemHealth) {
		super(new Item.Properties().group(SPTabs.tabMaterials));
		this.beacon = isBeaconIngot;
		this.golem = healsIronGolem;
		this.health = golemHealth;
	}
	
	public SPItemIngot(boolean isBeaconIngot) {
		super(new Item.Properties().group(SPTabs.tabMaterials));
		this.beacon = isBeaconIngot;
		this.golem = false;
		this.health = 0.0F;
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
	
	/**
     * Get the amount of health that will be added to the Iron Golem's Health
     *
     * @return true if this Item can be used
     */
	public float getGolemHealth()
    {
        return this.health;
    }
	
	/**
     * Determines if this ingot will heal an Iron Golem
     *
     * @return true if this Item can be used
     */
	public boolean healsGolem()
    {
        return this.golem;
    }

}
