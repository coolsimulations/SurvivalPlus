package net.coolsimulations.SurvivalPlus.core.recipes;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class SurvivalPlusDispenserBehavior {

	public static void init() {

		for(int i = 0; i < Registry.ITEM.getIds().size(); i++) {
			if(Registry.ITEM.get(i) instanceof ShearsItem) {
				Item item = Registry.ITEM.get(i);
				DispenserBlock.registerBehavior(item, new FallibleItemDispenserBehavior() {
					protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
						World world = pointer.getWorld();
						if (!world.isClient()) {
							this.success = false;
							BlockPos blockPos = pointer.getBlockPos().offset((Direction)pointer.getBlockState().get(DispenserBlock.FACING));
							List<SheepEntity> list = world.getNonSpectatingEntities(SheepEntity.class, new Box(blockPos));
							Iterator var6 = list.iterator();

							while(var6.hasNext()) {
								SheepEntity sheepEntity = (SheepEntity)var6.next();
								if (sheepEntity.isAlive() && !sheepEntity.isSheared() && !sheepEntity.isBaby()) {
									sheepEntity.dropItems();
									if (stack.damage(1, (Random)world.random, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}

									this.success = true;
									break;
								}
							}
						}

						return stack;
					}
				});
			}
		}
	}

}
