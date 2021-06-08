package net.coolsimulations.SurvivalPlus.api.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class SPItemCupcake extends Item {

	public SPItemCupcake(Settings properties) {
		super(properties);
	}

	/**
	 * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
	 * the Item before the action is complete.
	 */

	@Override
	public ItemStack finishUsing(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		
		if(entityLiving instanceof PlayerEntity)
			((PlayerEntity) entityLiving).incrementStat(Stats.EAT_CAKE_SLICE);
		return entityLiving.eatFood(worldIn, stack);
	}

}
