package net.coolsimulations.SurvivalPlus.core.recipes;

import java.util.HashMap;
import java.util.Map;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.compat.SPBehaviorDispenseItem;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCampfire;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import thedarkcolour.futuremc.block.villagepillage.CampfireBlock;

public class SurvivalPlusDispenserBehavior {

	public static void init() {

		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.FLINT_AND_STEEL, new BehaviorDispenseIgnite(Items.FLINT_AND_STEEL, SoundEvents.ITEM_FLINTANDSTEEL_USE, 1));
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.FIRE_CHARGE, new BehaviorDispenseIgnite(Items.FIRE_CHARGE, SoundEvents.ITEM_FIRECHARGE_USE, ItemStack.EMPTY.getItem(), true));
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.LAVA_BUCKET, new BehaviorDispenseIgnite(Items.LAVA_BUCKET, SoundEvents.ITEM_BUCKET_EMPTY_LAVA, Items.BUCKET, true));
		
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.WATER_BUCKET, new BehaviorDispenseExtinguish(Items.WATER_BUCKET, SoundEvents.BLOCK_LAVA_EXTINGUISH, Items.BUCKET, true));
		
		Item water_bottle = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER).getItem();
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(water_bottle, new BehaviorDispenseExtinguish(water_bottle, SoundEvents.BLOCK_LAVA_EXTINGUISH, Items.GLASS_BOTTLE, true));
		
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.BUCKET, new BehaviorDispenseExtinguish(Items.BUCKET, SoundEvents.BLOCK_GRAVEL_STEP, SPItems.charcoal_bucket, true));
	}
	
	public static void postInit() {
		
		if(SPCompatibilityManager.isNoTreePunchingLoaded()) {
			Item fire_starter = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.NO_TREE_PUNCHING_MODID, "fire_starter"));
			BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(fire_starter, new BehaviorDispenseIgnite(fire_starter, SoundEvents.ITEM_FLINTANDSTEEL_USE, 1, true));
		}
	}

	public static class BehaviorDispenseIgnite extends SPBehaviorDispenseItem {

		SoundEvent igniteSound;
		int damage = 0;
		Item replacement;
		boolean ignoreFallback = false;

		BehaviorDispenseIgnite(Item fallback, SoundEvent sound, int damage) {
			super(fallback);
			this.igniteSound = sound;
			this.damage = damage;
		}
		
		BehaviorDispenseIgnite(Item fallback, SoundEvent sound, int damage, boolean ignore) {
			super(fallback);
			this.igniteSound = sound;
			this.damage = damage;
			this.ignoreFallback = ignore;
		}
		
		BehaviorDispenseIgnite(Item fallback, SoundEvent sound, Item replacement) {
			super(fallback);
			this.igniteSound = sound;
			this.replacement = replacement;
		}
		
		BehaviorDispenseIgnite(Item fallback, SoundEvent sound, Item replacement, boolean ignore) {
			super(fallback);
			this.igniteSound = sound;
			this.replacement = replacement;
			this.ignoreFallback = ignore;
		}

		@Override
		protected Map<ItemStack, Boolean> dispenseStack(IBlockSource source, ItemStack stack)
		{
			World world = source.getWorld();
			this.successful = false;
			BlockPos blockpos = source.getBlockPos().offset((EnumFacing)source.getBlockState().getValue(BlockDispenser.FACING));
			IBlockState state = world.getBlockState(blockpos);
			Block block = world.getBlockState(blockpos).getBlock();
			boolean doDamage = false;

			Map<ItemStack, Boolean> map = new HashMap<ItemStack, Boolean>();

			if(block instanceof BlockCampfire) {

				BlockCampfire campfire = (BlockCampfire) state.getBlock();

				if(state.getValue(BlockCampfire.BURNING) == false) {
					campfire.igniteCampfire(world, null, state, blockpos, igniteSound);
					this.successful = true;
					doDamage = true;
				} else {
					if(this.ignoreFallback)
						this.successful = true;
				}
			}
			
			if(doDamage) {
				if(damage > 0) {
					if (stack.attemptDamageItem(1, world.rand, (EntityPlayerMP)null))
					{
						stack.setCount(damage);
					}
				} else {
					if(stack.getCount() == 1) {
						stack = new ItemStack(replacement);
					} else if(stack.getCount() > 1) {
						stack.setCount(stack.getCount() - 1);
					}
				}
			}

			map.put(stack, this.successful);

			return map;
		}
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
		protected Map<ItemStack, Boolean> dispenseStack(IBlockSource source, ItemStack stack)
		{
			World world = source.getWorld();
			this.successful = false;
			BlockPos blockpos = source.getBlockPos().offset((EnumFacing)source.getBlockState().getValue(BlockDispenser.FACING));
			IBlockState state = world.getBlockState(blockpos);
			Block block = world.getBlockState(blockpos).getBlock();
			boolean doDamage = false;

			Map<ItemStack, Boolean> map = new HashMap<ItemStack, Boolean>();

			if(block instanceof BlockCampfire) {

				BlockCampfire campfire = (BlockCampfire) state.getBlock();

				if(state.getValue(BlockCampfire.BURNING) == true) {
					campfire.extinguishCampfire(world, null, state, blockpos, igniteSound);
					this.successful = true;
					doDamage = true;
				} else {
					if(this.ignoreFallback)
						this.successful = true;
				}
			}
			
			if(SPCompatibilityManager.isFutureMCLoaded() && block instanceof CampfireBlock) {
				PropertyBool LIT = ObfuscationReflectionHelper.getPrivateValue(CampfireBlock.class, (CampfireBlock) block, "LIT");
				PropertyBool SIGNAL = ObfuscationReflectionHelper.getPrivateValue(CampfireBlock.class, (CampfireBlock) block, "SIGNAL");
				
				if(state.getValue(LIT) == true) {
					world.setBlockState(blockpos, state.withProperty(LIT, false));
					if (world.isRemote) {
						for (int i = 0; i < 20; ++i) {
							CampfireBlock.Companion.spawnSmokeParticles(world, blockpos, (Boolean) state.getValue(SIGNAL), true);
						}
					} else {
						world.playSound((EntityPlayer) null, blockpos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					}
					this.successful = true;
					doDamage = true;
				} else {
					if(this.ignoreFallback)
						this.successful = true;
				}
			}
			
			if(doDamage) {
				if(damage > 0) {
					if (stack.attemptDamageItem(1, world.rand, (EntityPlayerMP)null))
					{
						stack.setCount(damage);
					}
				} else {
					if(stack.getCount() == 1) {
						stack = new ItemStack(replacement);
					} else if(stack.getCount() > 1) {
						stack.setCount(stack.getCount() - 1);
						if(replacement == SPItems.charcoal_bucket) {
							TileEntity tile = world.getTileEntity(source.getBlockPos());
							if(tile instanceof TileEntityDispenser) {
								TileEntityDispenser dispenser = (TileEntityDispenser) tile;
								if(dispenser.addItemStack(new ItemStack(replacement)) == -1) {
									BehaviorDefaultDispenseItem.doDispense(world, new ItemStack(replacement), 6, source.getBlockState().getValue(BlockDispenser.FACING), source);
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
