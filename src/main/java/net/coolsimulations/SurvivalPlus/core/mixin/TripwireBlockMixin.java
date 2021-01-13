package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TripwireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.ShearsItem;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(TripwireBlock.class)
public abstract class TripwireBlockMixin extends Block {
	
	@Shadow
	public static BooleanProperty DISARMED;
	
	public TripwireBlockMixin(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("HEAD"), method = "onBreak", cancellable = true)
	public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player, CallbackInfo info) {
	      if (!world.isClient && !player.getMainHandStack().isEmpty() && player.getMainHandStack().getItem() instanceof ShearsItem) {
	         world.setBlockState(pos, (BlockState)state.with(DISARMED, true), 4);
	      }
	   }

}
