package net.coolsimulations.SurvivalPlus.core.recipes;

import net.minecraft.core.Registry;
import net.minecraft.core.dispenser.ShearsDispenseItemBehavior;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.block.DispenserBlock;

public class SurvivalPlusDispenserBehavior {

	public static void init() {

		for(int i = 0; i < Registry.ITEM.keySet().size(); i++) {
			if(Registry.ITEM.byId(i) instanceof ShearsItem) {
				Item item = Registry.ITEM.byId(i);
				DispenserBlock.registerBehavior(item, new ShearsDispenseItemBehavior());
			}
		}
	}

}
