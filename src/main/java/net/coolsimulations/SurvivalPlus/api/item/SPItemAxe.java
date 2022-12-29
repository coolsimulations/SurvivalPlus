package net.coolsimulations.SurvivalPlus.api.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class SPItemAxe extends AxeItem {

	public SPItemAxe(Tier tier, float damage, float speed) {
		super(tier, damage, speed, (new Item.Properties()));
	}
	
	@Override
	public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker)
	{
		return stack.getItem() instanceof SPItemAxe;
	}

}