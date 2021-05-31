package net.coolsimulations.SurvivalPlus.api.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class SPItemCupcake extends ItemFood {

	public SPItemCupcake(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
	}
	
	public SPItemCupcake(int amount, boolean isWolfFood)
    {
        super(amount, 0.6F, isWolfFood);
    }
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
		player.addStat(StatList.CAKE_SLICES_EATEN);
    }

}
