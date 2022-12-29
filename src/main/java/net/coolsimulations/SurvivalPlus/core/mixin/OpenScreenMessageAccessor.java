package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import torcherino.network.OpenScreenMessage;

@Mixin(OpenScreenMessage.class)
public interface OpenScreenMessageAccessor {

	@Accessor
	BlockPos getPos();
	@Accessor
	Component getTitle();
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
