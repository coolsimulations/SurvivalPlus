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
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {

	@Shadow
	private MinecraftClient client;

	@Shadow
	private GameMode gameMode;

	@Inject(at = @At("HEAD"), method = "breakBlock", cancellable = true)
	public void breakBlock(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {

		if (!this.client.player.isBlockBreakingRestricted(this.client.world, pos, this.gameMode)) {
			World world = this.client.world;
			BlockState blockState = world.getBlockState(pos);
			if (this.client.player.getMainHandStack().getItem().canMine(blockState, world, pos, this.client.player)) {
				Block block = blockState.getBlock();
				if (!(block instanceof CommandBlock || block instanceof StructureBlock || block instanceof JigsawBlock) && !this.client.player.isCreativeLevelTwoOp()) {
					if(blockState.isAir()) {
						if (((ItemAccessor) client.player.getMainHandStack().getItem()).onBlockStartBreak(client.player.getMainHandStack(), pos, client.player)) cir.setReturnValue(false);

						cir.setReturnValue(false);
					}
				}
			}
		}
	}

}
