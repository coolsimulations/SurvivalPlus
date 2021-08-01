package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TripWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;

@Mixin(TripWireBlock.class)
public abstract class TripWireBlockMixin extends Block {
	
	@Shadow
	public static BooleanProperty DISARMED;
	
	public TripWireBlockMixin(Properties settings) {
		super(settings);
	}

	@Inject(at = @At("HEAD"), method = "playerWillDestroy", cancellable = true)
	public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player, CallbackInfo info) {
	      if (!world.isClientSide && !player.getMainHandItem().isEmpty() && player.getMainHandItem().getItem() instanceof ShearsItem) {
	         world.setBlock(pos, (BlockState)state.setValue(DISARMED, true), 4);
	         world.gameEvent(player, GameEvent.SHEAR, pos);
	      }
	   }

}
