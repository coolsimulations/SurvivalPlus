package net.coolsimulations.SurvivalPlus.core.recipes;

import java.util.HashMap;
import java.util.Map;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.compat.SPBehaviorDispenseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.core.dispenser.ShearsDispenseItemBehavior;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.registries.ForgeRegistries;

public class SurvivalPlusDispenserBehavior {

	public static void init() {

		for(ResourceLocation location : ForgeRegistries.ITEMS.getKeys()) {
			if(ForgeRegistries.ITEMS.getValue(location) instanceof ShearsItem) {
				Item item = ForgeRegistries.ITEMS.getValue(location);
				DispenserBlock.registerBehavior(item, new OptionalDispenseItemBehavior() {
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
		
		DispenserBlock.registerBehavior(Items.BUCKET, new BehaviorDispenseExtinguish(Items.BUCKET, SoundEvents.GRAVEL_STEP, SPItems.charcoal_bucket, true));
	}
	
	public static class BehaviorDispenseExtinguish extends SPBehaviorDispenseItem {

		SoundEvent igniteSound;
		int damage = 0;
		Item replacement;
		boolean ignoreFallback = false;

		BehaviorDispenseExtinguish(Item fallback, SoundEvent sound, int damage) {
			super(fallback);
			this.igniteSound = sound;
			this.damage = damage;
		}
		
		BehaviorDispenseExtinguish(Item fallback, SoundEvent sound, int damage, boolean ignore) {
			super(fallback);
			this.igniteSound = sound;
			this.damage = damage;
			this.ignoreFallback = ignore;
		}
		
		BehaviorDispenseExtinguish(Item fallback, SoundEvent sound, Item replacement) {
			super(fallback);
			this.igniteSound = sound;
			this.replacement = replacement;
		}
		
		BehaviorDispenseExtinguish(Item fallback, SoundEvent sound, Item replacement, boolean ignore) {
			super(fallback);
			this.igniteSound = sound;
			this.replacement = replacement;
			this.ignoreFallback = ignore;
		}

		@Override
		protected Map<ItemStack, Boolean> execute(BlockSource source, ItemStack stack)
		{
			Level world = source.getLevel();
			this.successful = false;
			Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
            BlockPos blockpos = source.getPos().relative(direction);
			BlockState state = world.getBlockState(blockpos);
			Block block = world.getBlockState(blockpos).getBlock();
			boolean doDamage = false;

			Map<ItemStack, Boolean> map = new HashMap<ItemStack, Boolean>();

			if(block instanceof CampfireBlock) {

				if(state.getValue(CampfireBlock.LIT)) {
					if (!world.isClientSide()) {
						world.levelEvent((Player) null, 1009, blockpos, 0);
					}
					CampfireBlock.dowse(null, world, blockpos, state);
					world.setBlockAndUpdate(blockpos, state.setValue(CampfireBlock.LIT, false));
					this.successful = true;
					doDamage = true;
				} else {
					if(this.ignoreFallback)
						this.successful = true;
				}
			}
			
			if(doDamage) {
				if(damage > 0) {
					if (stack.hurt(1, world.random, (ServerPlayer)null)) {
			               stack.setCount(0);
			        }
				} else {
					if(stack.getCount() == 1) {
						stack = new ItemStack(replacement);
					} else if(stack.getCount() > 1) {
						stack.setCount(stack.getCount() - 1);
						if(replacement == SPItems.charcoal_bucket) {
							BlockEntity tile = world.getBlockEntity(source.getPos());
							if(tile instanceof DispenserBlockEntity) {
								DispenserBlockEntity dispenser = (DispenserBlockEntity) tile;
								if(dispenser.addItem(new ItemStack(replacement)) == -1) {
									DefaultDispenseItemBehavior.spawnItem(world, new ItemStack(replacement), 6, direction, source);
								}
							}
						}
					}
				}
			}

			map.put(stack, this.successful);

			return map;
		}
	}

}
