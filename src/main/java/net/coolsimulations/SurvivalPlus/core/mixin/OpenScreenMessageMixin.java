package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce;
import net.minecraft.client.Minecraft;
import torcherino.client.screen.TorcherinoScreen;
import torcherino.network.OpenScreenMessage;

@Mixin(OpenScreenMessage.class)
public class OpenScreenMessageMixin  {

	@Inject(at = @At("TAIL"), method = "openTorcherinoScreen", remap = false, require = 0)
	private static void openTorcherinoScreen(OpenScreenMessage message, CallbackInfo info) {
        Minecraft minecraft = Minecraft.getInstance();
		minecraft.submitAsync(() -> {
            if (minecraft.player.level.getBlockEntity(((OpenScreenMessageAccessor) (Object)message).getPos()) instanceof TileEntitySconce blockEntity) {
                TorcherinoScreen screen = new TorcherinoScreen(((OpenScreenMessageAccessor) (Object)message).getTitle(), ((OpenScreenMessageAccessor) (Object)message).getXRange(), ((OpenScreenMessageAccessor) (Object)message).getZRange(), ((OpenScreenMessageAccessor) (Object)message).getYRange(),
                		((OpenScreenMessageAccessor) (Object)message).getSpeed(), ((OpenScreenMessageAccessor) (Object)message).getRedstoneMode(), blockEntity.getBlockPos(), blockEntity.getTier());
                minecraft.setScreen(screen);
            }
        });
	}
}
