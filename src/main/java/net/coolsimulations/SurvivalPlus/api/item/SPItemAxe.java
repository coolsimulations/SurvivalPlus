package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SPItemAxe extends AxeItem {

	public SPItemAxe(Tier tier, float damage, float speed) {
		super(tier, damage, speed, (new Item.Properties().tab(SPTabs.tabTools)));
	}
	
	@Override
	public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker)
	{
		return stack.getItem() instanceof SPItemAxe;
	}

}