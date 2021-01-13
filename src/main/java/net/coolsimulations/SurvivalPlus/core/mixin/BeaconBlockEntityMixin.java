package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockMetal;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

@Mixin(BeaconBlockEntity.class)
public class BeaconBlockEntityMixin extends BlockEntity {

	public BeaconBlockEntityMixin(BlockEntityType<?> type) {
		super(type);
	}

	@Shadow
	private int level;

	@Inject(at = @At("TAIL"), method = "updateLevel", cancellable = true)
	public void updateLevel(int x, int y, int z, CallbackInfo info) {
		this.level = 0;

		for(int i = 1; i <= 4; this.level = i++) {
			int j = y - i;
			if (j < 0) {
				break;
			}

			boolean bl = true;

			for(int k = x - i; k <= x + i && bl; ++k) {
				for(int l = z - i; l <= z + i; ++l) {
					Block block = this.world.getBlockState(new BlockPos(k, j, l)).getBlock();
					if(block instanceof SPBlockMetal) {
						if (!((SPBlockMetal) block).beacon) {
							bl = false;
							break;
						}
					} else {
						if (block != Blocks.EMERALD_BLOCK && block != Blocks.GOLD_BLOCK && block != Blocks.DIAMOND_BLOCK && block != Blocks.IRON_BLOCK) {
							bl = false;
							break;
						}
					}
				}
			}

			if (!bl) {
				break;
			}
		}
	}


}
