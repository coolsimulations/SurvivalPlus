package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(CampfireBlock.class)
public abstract class CampfireBlockMixin {
	
	@Inject(at = @At("HEAD"), method = "onUse", cancellable = true)
	public void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
		ItemStack itemStackIn = player.getStackInHand(hand);
		Item item = itemStackIn.getItem();
		
		if(state.get(CampfireBlock.LIT) && item == Items.BUCKET  && !player.abilities.creativeMode) {
			world.setBlockState(pos, state.with(CampfireBlock.LIT, false));
			if (world.isClient()) {
				for (int i = 0; i < 20; ++i) {
					CampfireBlock.spawnSmokeParticle(world, pos, (Boolean) state.get(CampfireBlock.SIGNAL_FIRE),true);
				}
			} else {
				world.playSound((PlayerEntity) null, pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
			if(itemStackIn.getCount() == 1) {
				if (ItemStack.areItemsEqual(player.getOffHandStack(), itemStackIn))
				{
					player.setStackInHand(Hand.OFF_HAND, new ItemStack(SPItems.charcoal_bucket));
				}
				else
				{
					player.setStackInHand(Hand.MAIN_HAND, new ItemStack(SPItems.charcoal_bucket));
				}
			} else  if(itemStackIn.getCount() >= 2){
				itemStackIn.decrement(1);
				boolean flag = player.inventory.insertStack(new ItemStack(SPItems.charcoal_bucket));
				if(!flag) {
					player.dropItem(new ItemStack(SPItems.charcoal_bucket), false);
				}		
			}
		}
	}

}
