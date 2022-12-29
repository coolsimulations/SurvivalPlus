package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;
import torcherino.Torcherino;
import torcherino.network.ValueUpdateMessage;

@Mixin(ValueUpdateMessage.class)
public class ValueUpdateMessageMixin {
	
	@Inject(at = @At("TAIL"), method = "handle", remap = false, require = 0)
	private static void handle(ValueUpdateMessage message, Supplier<NetworkEvent.Context> contextSupplier, CallbackInfo info) {
		NetworkEvent.Context context = contextSupplier.get();
        if (context.getDirection().getOriginationSide() == LogicalSide.CLIENT) {
            context.enqueueWork(() -> {
                if (context.getSender().level.getBlockEntity(((ValueUpdateMessageAccessor) (Object)message).getPos()) instanceof TileEntitySconce blockEntity) {
                    if (!blockEntity.readClientData(((ValueUpdateMessageAccessor) (Object)message).getXRange(), ((ValueUpdateMessageAccessor) (Object)message).getZRange(), ((ValueUpdateMessageAccessor) (Object)message).getYRange(), ((ValueUpdateMessageAccessor) (Object)message).getSpeed(), ((ValueUpdateMessageAccessor) (Object)message).getRedstoneMode())) {
                        Torcherino.LOGGER.error("Data received from " + context.getSender().getName().getString() + "(" + context.getSender().getStringUUID() + ") is invalid.");
                    }
                }
            });
            context.setPacketHandled(true);
        }
	}
}
