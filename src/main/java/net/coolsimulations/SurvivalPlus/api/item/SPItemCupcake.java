package net.coolsimulations.SurvivalPlus.api.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class SPItemCupcake extends Item {

	public SPItemCupcake(Properties properties) {
		super(properties);
	}

	/**
	 * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
	 * the Item before the action is complete.
	 */

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		
		if(entityLiving instanceof Player)
			((Player) entityLiving).awardStat(Stats.EAT_CAKE_SLICE);
		return entityLiving.eat(worldIn, stack);
	}

}