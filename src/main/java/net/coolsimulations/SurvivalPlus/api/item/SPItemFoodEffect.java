package net.coolsimulations.SurvivalPlus.api.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class SPItemFoodEffect extends ItemFood{

	public SPItemFoodEffect(int amount, float saturation, boolean isWolfFood, Potion effect, int probability, Properties properties) {
		super(amount, saturation, isWolfFood, properties);
		PotionEffect potioneffct = new PotionEffect(effect, probability, 1);
		this.setPotionEffect(potioneffct, probability);
		
	}

}
