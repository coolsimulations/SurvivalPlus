package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

@Mixin(CampfireBlock.class)
public abstract class CampfireBlockMixin {
	
	@Inject(at = @At("HEAD"), method = "use", cancellable = true)
	public void use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit, CallbackInfoReturnable<InteractionResult> cir) {
		ItemStack itemStackIn = player.getItemInHand(hand);
		Item item = itemStackIn.getItem();
		
		if(state.getValue(CampfireBlock.LIT) && item == Items.BUCKET  && !player.getAbilities().instabuild) {
			if (!world.isClientSide()) {
				world.levelEvent((Player) null, 1009, pos, 0);
			}
			CampfireBlock.dowse(player, world, pos, state);
			world.setBlockAndUpdate(pos, state.setValue(CampfireBlock.LIT, false));
			if(itemStackIn.getCount() == 1) {
				if (ItemStack.isSame(player.getOffhandItem(), itemStackIn))
				{
					player.setItemInHand(InteractionHand.OFF_HAND, new ItemStack(SPItems.charcoal_bucket));
				}
				else
				{
					player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(SPItems.charcoal_bucket));
				}
			} else  if(itemStackIn.getCount() >= 2){
				itemStackIn.shrink(1);
				boolean flag = player.getInventory().add(new ItemStack(SPItems.charcoal_bucket));
				if(!flag) {
					player.drop(new ItemStack(SPItems.charcoal_bucket), false);
				}		
			}
		}
	}

}
