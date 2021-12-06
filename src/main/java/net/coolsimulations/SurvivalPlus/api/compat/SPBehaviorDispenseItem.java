package net.coolsimulations.SurvivalPlus.api.compat;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

/**
 * Extend this class to add your own item dispenser behavior to items that already have existing behaviors
 */
public class SPBehaviorDispenseItem implements IBehaviorDispenseItem {

	protected boolean successful = false;
	protected IBehaviorDispenseItem fallback;

	protected SPBehaviorDispenseItem(Item original) {
		this.fallback = BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.getObject(original);
	}

	@Override
	public final ItemStack dispense(IBlockSource source, ItemStack stack)
	{
		Map<ItemStack, Boolean> map = dispenseStack(source, stack);

		if(map.entrySet().stream().findFirst().get().getValue()) {
			this.playDispenseSound(source);
			this.spawnDispenseParticles(source, (EnumFacing)source.getBlockState().getValue(BlockDispenser.FACING));
			return map.entrySet().stream().findFirst().get().getKey();
		} else {
			return fallback.dispense(source, stack);
		}
	}

	protected Map<ItemStack, Boolean> dispenseStack(IBlockSource source, ItemStack stack)
	{
		Map<ItemStack, Boolean> map = new HashMap<ItemStack, Boolean>();
		map.put(stack, this.successful);
		return map;
	}

	protected void playDispenseSound(IBlockSource source)
	{
		source.getWorld().playEvent(this.successful ? 1000 : 1001, source.getBlockPos(), 0);
	}

	protected void spawnDispenseParticles(IBlockSource source, EnumFacing facingIn)
	{
		source.getWorld().playEvent(2000, source.getBlockPos(), this.getWorldEventDataFrom(facingIn));
	}

	private int getWorldEventDataFrom(EnumFacing facingIn)
	{
		return facingIn.getFrontOffsetX() + 1 + (facingIn.getFrontOffsetZ() + 1) * 3;
	}
}