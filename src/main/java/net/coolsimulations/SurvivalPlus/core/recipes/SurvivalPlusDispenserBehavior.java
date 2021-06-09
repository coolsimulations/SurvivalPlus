package net.coolsimulations.SurvivalPlus.core.recipes;

import net.minecraft.block.DispenserBlock;
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
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusDispenserBehavior {

	public static void init() {

		for(ResourceLocation location : ForgeRegistries.ITEMS.getKeys()) {
			if(ForgeRegistries.ITEMS.getValue(location) instanceof ShearsItem) {
				Item item = ForgeRegistries.ITEMS.getValue(location);
				DispenserBlock.registerDispenseBehavior(item, new OptionalDispenseBehavior() {
					@SuppressWarnings("deprecation")
					protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
						World world = source.getWorld();
						if (!world.isRemote()) {
							this.successful = false;
							BlockPos blockpos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));

							for(net.minecraft.entity.Entity entity : world.getEntitiesInAABBexcluding((net.minecraft.entity.Entity)null, new AxisAlignedBB(blockpos), e -> !e.isSpectator() && e instanceof net.minecraftforge.common.IShearable)) {
								net.minecraftforge.common.IShearable target = (net.minecraftforge.common.IShearable)entity;
								if (target.isShearable(stack, world, blockpos)) {
									java.util.List<ItemStack> drops = target.onSheared(stack, entity.world, blockpos,
											net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.FORTUNE, stack));
									java.util.Random rand = new java.util.Random();
									drops.forEach(d -> {
										net.minecraft.entity.item.ItemEntity ent = entity.entityDropItem(d, 1.0F);
										ent.setMotion(ent.getMotion().add((double)((rand.nextFloat() - rand.nextFloat()) * 0.1F), (double)(rand.nextFloat() * 0.05F), (double)((rand.nextFloat() - rand.nextFloat()) * 0.1F)));
									});
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}

									this.successful = true;
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