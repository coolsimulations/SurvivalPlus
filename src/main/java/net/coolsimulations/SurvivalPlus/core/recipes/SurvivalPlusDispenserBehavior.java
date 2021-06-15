package net.coolsimulations.SurvivalPlus.core.recipes;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.BeehiveDispenseBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusDispenserBehavior {

	public static void init() {

		for(ResourceLocation location : ForgeRegistries.ITEMS.getKeys()) {
			if(ForgeRegistries.ITEMS.getValue(location) instanceof ShearsItem) {
				Item item = ForgeRegistries.ITEMS.getValue(location);
				DispenserBlock.registerBehavior(item, new OptionalDispenseBehavior() {
					@SuppressWarnings("deprecation")
					protected ItemStack execute(IBlockSource source, ItemStack stack) {
						World world = source.getLevel();
						if (!world.isClientSide()) {
							this.setSuccess(false);
							BlockPos blockpos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));

							for(net.minecraft.entity.Entity entity : world.getEntities((net.minecraft.entity.Entity)null, new AxisAlignedBB(blockpos), e -> !e.isSpectator() && e instanceof IForgeShearable)) {
								net.minecraftforge.common.IForgeShearable target = (net.minecraftforge.common.IForgeShearable)entity;
								if (target.isShearable(stack, world, blockpos)) {
									java.util.List<ItemStack> drops = target.onSheared(null, stack, entity.level, blockpos,
											net.minecraft.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.enchantment.Enchantments.BLOCK_FORTUNE, stack));
									java.util.Random rand = new java.util.Random();
									drops.forEach(d -> {
										net.minecraft.entity.item.ItemEntity ent = entity.spawnAtLocation(d, 1.0F);
										ent.setDeltaMovement(ent.getDeltaMovement().add((double)((rand.nextFloat() - rand.nextFloat()) * 0.1F), (double)(rand.nextFloat() * 0.05F), (double)((rand.nextFloat() - rand.nextFloat()) * 0.1F)));
									});
									if (stack.hurt(1, world.random, (ServerPlayerEntity)null)) {
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
				DispenserBlock.registerBehavior(item, new BeehiveDispenseBehavior());
			}
		}
	}

}
