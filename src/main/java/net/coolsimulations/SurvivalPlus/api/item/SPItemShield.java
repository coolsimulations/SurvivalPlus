package net.coolsimulations.SurvivalPlus.api.item;

import java.util.function.Consumer;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.coolsimulations.SurvivalPlus.api.client.renderer.TileEntityShieldRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.client.IItemRenderProperties;

public class SPItemShield extends ShieldItem {

	public SPItemShield(int maxDamage) {
		super((new Item.Properties()).stacksTo(1).defaultDurability(maxDamage).tab(SPTabs.tabCombat));
	}
	
	@Override
	public boolean isShield(ItemStack stack, @Nullable LivingEntity entity)
	{
		return true;
	}
	
	@Override
	@ParametersAreNonnullByDefault
    public void initializeClient(Consumer<IItemRenderProperties> consumer)
    {
        consumer.accept(new IItemRenderProperties()
        {
            @Override
            public BlockEntityWithoutLevelRenderer getItemStackRenderer()
            {
                return TileEntityShieldRenderer.instance;
            }
        });
    }

}
