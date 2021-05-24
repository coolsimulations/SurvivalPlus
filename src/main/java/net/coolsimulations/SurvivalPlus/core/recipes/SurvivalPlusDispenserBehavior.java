package net.coolsimulations.SurvivalPlus.core.recipes;

import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ShearsDispenserBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.registry.Registry;

public class SurvivalPlusDispenserBehavior {

	public static void init() {

		for(int i = 0; i < Registry.ITEM.getIds().size(); i++) {
			if(Registry.ITEM.get(i) instanceof ShearsItem) {
				Item item = Registry.ITEM.get(i);
				DispenserBlock.registerBehavior(item, new ShearsDispenserBehavior());
			}
		}
	}

}
