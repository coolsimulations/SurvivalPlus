package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

@Mixin(CandleCakeBlock.class)
public abstract class CandleCakeBlockMixin extends AbstractCandleBlock {

	protected CandleCakeBlockMixin(Properties properties) {
		super(properties);
	}

	@Inject(at = @At("HEAD"), method = "use", cancellable = true)
	public void use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit, CallbackInfoReturnable<InteractionResult> cir) {
		if (!worldIn.isClientSide) {
			
			InteractionResult interactionResult = cupcake(worldIn, pos, hand, playerIn);
			if (interactionResult.consumesAction()) {
				dropResources(state, worldIn, pos);
			}

			if(interactionResult.consumesAction()) {
				cir.setReturnValue(interactionResult);
				cir.cancel();
			}
			
		} else {
			cir.setReturnValue(InteractionResult.CONSUME);
			cir.cancel();
		}
	}
	
	private static InteractionResult cupcake(Level worldIn, BlockPos pos, InteractionHand hand, Player playerIn) {
		if(playerIn.getItemInHand(hand).getItem() == SPItems.paper_cup) {

			decrementBites(worldIn, Blocks.CAKE.defaultBlockState(), pos);

			if(!playerIn.isCreative()) {

				ItemStack itemStackIn;

				if (playerIn.getOffhandItem().getItem() == SPItems.paper_cup)
				{
					itemStackIn = playerIn.getOffhandItem();
				}
				else
				{
					itemStackIn = playerIn.getMainHandItem();
				}

				if(itemStackIn.getCount() == 1) {
					if (ItemStack.isSame(playerIn.getOffhandItem(), itemStackIn))
					{
						playerIn.setItemInHand(InteractionHand.OFF_HAND, new ItemStack(SPItems.cupcake));
					}
					else
					{
						playerIn.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(SPItems.cupcake));
					}
				} else  if(itemStackIn.getCount() >= 2){
					itemStackIn.shrink(1);
					boolean flag = playerIn.getInventory().add(new ItemStack(SPItems.cupcake));
					if(!flag) {
						playerIn.drop(new ItemStack(SPItems.cupcake), false);
					}

				}
			}
			return InteractionResult.CONSUME;
		}
		
		return InteractionResult.PASS;
	}

	private static void decrementBites(LevelAccessor worldIn, BlockState state, BlockPos pos) {

		int bites = (Integer)state.getValue(CakeBlock.BITES);

		if (bites < CakeBlock.MAX_BITES) {
			worldIn.setBlock(pos, (BlockState)state.setValue(CakeBlock.BITES, bites + 1), 3);
		} else {
			worldIn.removeBlock(pos, false);
		}
	}

}
