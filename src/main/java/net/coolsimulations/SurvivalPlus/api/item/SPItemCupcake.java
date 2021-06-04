package net.coolsimulations.SurvivalPlus.api.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;

public class SPItemCupcake extends Item {

	public SPItemCupcake(Properties properties) {
		super(properties);
	}

	/**
	 * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
	 * the Item before the action is complete.
	 */

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		
		if(entityLiving instanceof PlayerEntity)
			((PlayerEntity) entityLiving).addStat(Stats.EAT_CAKE_SLICE);
		return entityLiving.onFoodEaten(worldIn, stack);
	}

}
