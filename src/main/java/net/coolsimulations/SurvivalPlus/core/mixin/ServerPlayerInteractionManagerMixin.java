package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.events.ItemAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CommandBlock;
import net.minecraft.block.JigsawBlock;
import net.minecraft.block.StructureBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

@Mixin(ServerPlayerInteractionManager.class)
public class ServerPlayerInteractionManagerMixin {

	@Shadow
	private ServerWorld world;

	@Shadow
	private ServerPlayerEntity player;

	@Inject(at = @At("HEAD"), method = "tryBreakBlock", cancellable = true)
	public void tryBreakBlock(BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
		BlockState blockState = this.world.getBlockState(blockPos);
		if (this.player.getMainHandStack().getItem().canMine(blockState, this.world, blockPos, this.player)) {
			BlockEntity blockEntity = this.world.getBlockEntity(blockPos);
			Block block = blockState.getBlock();
			if (!(block instanceof CommandBlock || block instanceof StructureBlock || block instanceof JigsawBlock) && !this.player.isCreativeLevelTwoOp()) {
				if (((ItemAccessor) player.getMainHandStack().getItem()).onBlockStartBreak(player.getMainHandStack(), blockPos, player)) {
					cir.setReturnValue(false);

				}
			}

		}
	}
}
