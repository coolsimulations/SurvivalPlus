package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CommandBlock;
import net.minecraft.world.level.block.JigsawBlock;
import net.minecraft.world.level.block.StructureBlock;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(MultiPlayerGameMode.class)
public class MultiPlayerGameModeMixin {

	@Shadow
	private Minecraft minecraft;

	@Shadow
	private GameType localPlayerMode;

	@Inject(at = @At("HEAD"), method = "destroyBlock", cancellable = true)
	public void destroyBlock(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {

		if (!this.minecraft.player.blockActionRestricted(this.minecraft.level, pos, this.localPlayerMode)) {
			Level world = this.minecraft.level;
			BlockState blockState = world.getBlockState(pos);
			if (this.minecraft.player.getMainHandItem().getItem().canAttackBlock(blockState, world, pos, this.minecraft.player)) {
				Block block = blockState.getBlock();
				if (!(block instanceof CommandBlock || block instanceof StructureBlock || block instanceof JigsawBlock) && !this.minecraft.player.canUseGameMasterBlocks()) {
					if(blockState.isAir()) {
						if (((ItemAccessor) minecraft.player.getMainHandItem().getItem()).onBlockStartBreak(minecraft.player.getMainHandItem(), pos, minecraft.player)) cir.setReturnValue(false);

						cir.setReturnValue(false);
					}
				}
			}
		}
	}

}
