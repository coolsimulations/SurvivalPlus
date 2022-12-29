package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.core.BlockPos;
import torcherino.network.ValueUpdateMessage;

@Mixin(ValueUpdateMessage.class)
public interface ValueUpdateMessageAccessor {

	@Accessor
	BlockPos getPos();
	@Accessor
	int getXRange();
	@Accessor	
	int getZRange();
	@Accessor
	int getYRange();
	@Accessor
	int getSpeed();
	@Accessor
	int getRedstoneMode();
}
