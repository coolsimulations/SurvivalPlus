package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.UUID;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mojang.authlib.GameProfile;

import net.coolsimulations.SurvivalPlus.api.events.EntityAccessor;
import net.coolsimulations.SurvivalPlus.api.events.SPPlayerDeathEvent;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.scores.PlayerTeam;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player {

	public ServerPlayerMixin(Level world, BlockPos pos, float yaw, GameProfile profile) {
		super(world, pos, yaw, profile);
	}

	@Inject(at = @At("TAIL"), method = "restoreFrom", cancellable = true)
	public void restoreFrom(ServerPlayer oldPlayer, boolean alive, CallbackInfo info) {
		CompoundTag old = ((EntityAccessor) oldPlayer).getPersistentData();
		if (old.contains("PlayerPersisted"))
			((EntityAccessor) this).getPersistentData().put("PlayerPersisted", old.get("PlayerPersisted"));
	}
	
	@Inject(at = @At("TAIL"), method = "die", cancellable = true)
    private  void die(DamageSource source, CallbackInfo info) {
        InteractionResult result = SPPlayerDeathEvent.EVENT.invoker().killPlayer((ServerPlayer) (Object) this, source);

        if (result == InteractionResult.FAIL) {
            info.cancel();
        }
    }
	
	@Nullable
	@Inject(at = @At("TAIL"), method = "getTabListDisplayName", cancellable = true)
	public void getTabListDisplayName(CallbackInfoReturnable<Component> cir) {
		
		if(this.getUUID().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412"))) {
			
			TextComponent coolsim = new TextComponent("coolsim");
			coolsim.withStyle(ChatFormatting.GOLD);
			
			if(this.getTeam() == null) {
				cir.setReturnValue(coolsim);
			} else if(this.getTeam() instanceof PlayerTeam) {
				if(((PlayerTeam) this.getTeam()).getColor() == ChatFormatting.RESET)
					cir.setReturnValue(coolsim);
			}
		}

	}

}
