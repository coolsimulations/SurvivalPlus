package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CommandBlock;
import net.minecraft.world.level.block.JigsawBlock;
import net.minecraft.world.level.block.StructureBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(ServerPlayerGameMode.class)
public class ServerPlayerGameModeMixin {

	@Shadow
	private ServerLevel level;

	@Shadow
	private ServerPlayer player;

	@Inject(at = @At("HEAD"), method = "destroyBlock", cancellable = true)
	public void destroyBlock(BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
		BlockState blockState = this.level.getBlockState(blockPos);
		if (this.player.getMainHandItem().getItem().canAttackBlock(blockState, this.level, blockPos, this.player)) {
			BlockEntity blockEntity = this.level.getBlockEntity(blockPos);
			Block block = blockState.getBlock();
			if (!(block instanceof CommandBlock || block instanceof StructureBlock || block instanceof JigsawBlock) && !this.player.canUseGameMasterBlocks()) {
				if (((ItemAccessor) player.getMainHandItem().getItem()).onBlockStartBreak(player.getMainHandItem(), blockPos, player)) {
					cir.setReturnValue(false);

				}
			}

		}
	}
}
