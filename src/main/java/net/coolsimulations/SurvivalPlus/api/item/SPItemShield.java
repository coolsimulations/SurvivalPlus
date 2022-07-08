package net.coolsimulations.SurvivalPlus.api.item;

import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.client.renderer.TileEntityShieldRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class SPItemShield extends ShieldItem {

	public SPItemShield(int maxDamage) {
		super((new Item.Properties()).stacksTo(1).defaultDurability(maxDamage).tab(SPTabs.tabCombat));
	}

	@Override
	public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction)
	{
		return net.minecraftforge.common.ToolActions.DEFAULT_SHIELD_ACTIONS.contains(toolAction);
	}

	@Override
	@ParametersAreNonnullByDefault
	public void initializeClient(Consumer<IClientItemExtensions> consumer)
	{
		consumer.accept(new IClientItemExtensions()
		{
			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer()
			{
				return TileEntityShieldRenderer.instance;
			}
		});
	}

}
