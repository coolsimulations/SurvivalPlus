package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(DoublePlantBlock.class)
public interface DoublePlantBlockAccessor {

	@Invoker("preventCreativeDropFromBottomPart")
	public static void invokePreventCreativeDropFromBottomPart(Level worldIn, BlockPos pos, BlockState state, Player player) {
		throw new AssertionError();
	}
}
