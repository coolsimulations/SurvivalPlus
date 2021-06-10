package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

@Mixin(CakeBlock.class)
public abstract class CakeBlockMixin {

	@Shadow
	protected abstract ActionResult tryEat(IWorld world, BlockPos pos, BlockState state, PlayerEntity player);

	@Inject(at = @At("HEAD"), method = "onUse", cancellable = true)
	public void onUse(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
		if (!worldIn.isClient) {
			if(playerIn.getStackInHand(hand).getItem() == SPItems.paper_cup) {

				decrementBites(worldIn, state, pos);

				if(!playerIn.isCreative()) {

					ItemStack itemStackIn;

					if (playerIn.getOffHandStack().getItem() == SPItems.paper_cup)
					{
						itemStackIn = playerIn.getOffHandStack();
					}
					else
					{
						itemStackIn = playerIn.getMainHandStack();
					}

					if(itemStackIn.getCount() == 1) {
						if (ItemStack.areItemsEqual(playerIn.getOffHandStack(), itemStackIn))
						{
							playerIn.setStackInHand(Hand.OFF_HAND, new ItemStack(SPItems.cupcake));
						}
						else
						{
							playerIn.setStackInHand(Hand.MAIN_HAND, new ItemStack(SPItems.cupcake));
						}
					} else  if(itemStackIn.getCount() >= 2){
						itemStackIn.decrement(1);
						boolean flag = playerIn.inventory.insertStack(new ItemStack(SPItems.cupcake));
						if(!flag) {
							playerIn.dropItem(new ItemStack(SPItems.cupcake), false);
						}

					}
				}
				cir.setReturnValue(ActionResult.SUCCESS);
				cir.cancel();
			}
		} else {
			cir.setReturnValue(ActionResult.SUCCESS);
			cir.cancel();
		}
	}

	private void decrementBites(IWorld worldIn, BlockState state, BlockPos pos) {

		int bites = (Integer)state.get(CakeBlock.BITES);

		if (bites < 6) {
			worldIn.setBlockState(pos, (BlockState)state.with(CakeBlock.BITES, bites + 1), 3);
		} else {
			worldIn.removeBlock(pos, false);
		}
	}

}
