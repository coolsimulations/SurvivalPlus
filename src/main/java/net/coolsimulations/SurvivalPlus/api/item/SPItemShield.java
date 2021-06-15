package net.coolsimulations.SurvivalPlus.api.item;

import javax.annotation.Nullable;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.client.renderer.TileEntityShieldRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;

public class SPItemShield extends ShieldItem {

	public SPItemShield(int maxDamage) {
		super((new Item.Properties()).stacksTo(1).defaultDurability(maxDamage).setISTER(() -> TileEntityShieldRenderer::new).tab(SPTabs.tabCombat));
	}
	
	@Override
	public boolean isShield(ItemStack stack, @Nullable LivingEntity entity)
	{
		return true;
	}

}
