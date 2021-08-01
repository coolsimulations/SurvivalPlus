package net.coolsimulations.SurvivalPlus.core.recipes;

import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.core.dispenser.ShearsDispenseItemBehavior;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusDispenserBehavior {

	public static void init() {

		for(ResourceLocation location : ForgeRegistries.ITEMS.getKeys()) {
			if(ForgeRegistries.ITEMS.getValue(location) instanceof ShearsItem) {
				Item item = ForgeRegistries.ITEMS.getValue(location);
				DispenserBlock.registerBehavior(item, new OptionalDispenseItemBehavior() {
					@SuppressWarnings("deprecation")
					protected ItemStack execute(BlockSource source, ItemStack stack) {
						Level world = source.getLevel();
						if (!world.isClientSide()) {
							this.setSuccess(false);
							BlockPos blockpos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));

							for(net.minecraft.world.entity.Entity entity : world.getEntities((net.minecraft.world.entity.Entity)null, new AABB(blockpos), e -> !e.isSpectator() && e instanceof IForgeShearable)) {
								net.minecraftforge.common.IForgeShearable target = (net.minecraftforge.common.IForgeShearable)entity;
								if (target.isShearable(stack, world, blockpos)) {
									java.util.List<ItemStack> drops = target.onSheared(null, stack, entity.level, blockpos,
											net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.BLOCK_FORTUNE, stack));
									java.util.Random rand = new java.util.Random();
									drops.forEach(d -> {
										net.minecraft.world.entity.item.ItemEntity ent = entity.spawnAtLocation(d, 1.0F);
										ent.setDeltaMovement(ent.getDeltaMovement().add((double)((rand.nextFloat() - rand.nextFloat()) * 0.1F), (double)(rand.nextFloat() * 0.05F), (double)((rand.nextFloat() - rand.nextFloat()) * 0.1F)));
									});
									if (stack.hurt(1, world.random, (ServerPlayer)null)) {
										stack.setCount(0);
									}

									this.setSuccess(true);
									break;
								}
							}
						}

						return stack;
					}
				});
				DispenserBlock.registerBehavior(item, new ShearsDispenseItemBehavior());
			}
		}
	}

}
