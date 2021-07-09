package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.events.SPPlayerJoinEvent;
import net.minecraft.network.Connection;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.InteractionResult;

@Mixin(PlayerList.class)
public class PlayerListMixin {
	
    @Inject(at = @At("TAIL"), method = "placeNewPlayer", cancellable = true)
	public void placeNewPlayer(Connection connection, ServerPlayer player, CallbackInfo info) {
    	InteractionResult result = SPPlayerJoinEvent.EVENT.invoker().playerLogin(player, player.getServer());

        if (result == InteractionResult.FAIL) {
            info.cancel();
        }
	}

}
