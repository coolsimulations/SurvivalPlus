package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.coolsimulations.SurvivalPlus.api.events.EntityAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;

@Mixin(Entity.class)
public abstract class EntityMixin implements EntityAccessor{

	@Shadow
	public abstract double getX();
	@Shadow
	public abstract double getY();
	@Shadow
	public abstract double getZ();
	@Shadow
	public float yaw;
	@Shadow
	public float pitch;

	private CompoundTag persistentData;

	@Inject(at = @At("TAIL"), method = "fromTag", cancellable = true)
	public void fromTag(CompoundTag tag, CallbackInfo info) {
		if (Double.isFinite(this.getX()) && Double.isFinite(this.getY()) && Double.isFinite(this.getZ())) {
			if (Double.isFinite((double)this.yaw) && Double.isFinite((double)this.pitch)) {
				if(tag.contains("SurvivalPlusData", 10)) persistentData = tag.getCompound("SurvivalPlusData");
			}
		}
	}

	@Inject(at = @At("TAIL"), method = "toTag", cancellable = true)
	public void toTag(CompoundTag tag, CallbackInfoReturnable<CompoundTag> cir) {
		try {
			if(persistentData != null) tag.put("SurvivalPlusData", persistentData);
			cir.setReturnValue(tag);
		} catch (Throwable var8) {
			CrashReport crashReport = CrashReport.create(var8, "Saving entity NBT");
			CrashReportSection crashReportSection = crashReport.addElement("Entity being saved");
			this.populateCrashReport(crashReportSection);
			throw new CrashException(crashReport);
		}
	}

	@Override
	@Unique
	public CompoundTag getPersistentData() {
		if (persistentData == null)
			persistentData = new CompoundTag();
		return persistentData;
	}

	@Shadow
	public abstract void populateCrashReport(CrashReportSection section);

}
