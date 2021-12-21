package net.coolsimulations.SurvivalPlus.api.compat;

import java.util.HashMap;
import java.util.Map;

import net.coolsimulations.SurvivalPlus.core.mixin.DispenserBlockMixin;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;

/**
 * Extend this class to add your own item dispenser behavior to items that already have existing behaviors
 */
public class SPBehaviorDispenseItem implements DispenseItemBehavior {

	protected boolean successful = false;
	protected DispenseItemBehavior fallback;

	protected SPBehaviorDispenseItem(Item original) {
		try {
			this.fallback = DispenserBlockMixin.getRegistry().get(original);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public final ItemStack dispense(BlockSource source, ItemStack stack)
	{
		Map<ItemStack, Boolean> map = execute(source, stack);

		if(map.entrySet().stream().findFirst().get().getValue()) {
			this.playSound(source);
		    this.playAnimation(source, source.getBlockState().getValue(DispenserBlock.FACING));
			return map.entrySet().stream().findFirst().get().getKey();
		} else {
			return fallback.dispense(source, stack);
		}
	}

	protected Map<ItemStack, Boolean> execute(BlockSource source, ItemStack stack)
	{
		Map<ItemStack, Boolean> map = new HashMap<ItemStack, Boolean>();
		map.put(stack, this.successful);
		return map;
	}

	protected void playSound(BlockSource source)
	{
		source.getLevel().levelEvent(this.successful ? 1000 : 1001, source.getPos(), 0);
	}

	protected void playAnimation(BlockSource source, Direction facingIn)
	{
		source.getLevel().levelEvent(2000, source.getPos(), facingIn.get3DDataValue());
	}
}
