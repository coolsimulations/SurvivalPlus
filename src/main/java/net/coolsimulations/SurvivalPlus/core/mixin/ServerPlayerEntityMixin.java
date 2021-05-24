package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.authlib.GameProfile;

import net.coolsimulations.SurvivalPlus.api.events.EntityAccessor;
import net.coolsimulations.SurvivalPlus.api.events.SPPlayerDeathEvent;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity {

	public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile profile) {
		super(world, pos, yaw, profile);
	}

	@Inject(at = @At("TAIL"), method = "copyFrom", cancellable = true)
	public void copyFrom(ServerPlayerEntity oldPlayer, boolean alive, CallbackInfo info) {
		CompoundTag old = ((EntityAccessor) oldPlayer).getPersistentData();
		if (old.contains("PlayerPersisted"))
			((EntityAccessor) this).getPersistentData().put("PlayerPersisted", old.get("PlayerPersisted"));
	}
	
	@Inject(at = @At("TAIL"), method = "onDeath", cancellable = true)
    private  void onDeath(DamageSource source, CallbackInfo info) {
        ActionResult result = SPPlayerDeathEvent.EVENT.invoker().killPlayer((ServerPlayerEntity) (Object) this, source);

        if (result == ActionResult.FAIL) {
            info.cancel();
        }
    }

}
