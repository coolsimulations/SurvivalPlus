package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.screen.ingame.BeaconScreen;
import net.minecraft.client.gui.screen.ingame.ContainerScreen;
import net.minecraft.container.BeaconContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

@Mixin(BeaconScreen.class)
public abstract class BeaconScreenMixin extends ContainerScreen<BeaconContainer> {

	public BeaconScreenMixin(BeaconContainer container, PlayerInventory playerInventory, Text name) {
		super(container, playerInventory, name);
	}

	@Shadow
	private StatusEffect primaryEffect;

	@Inject(at = @At("TAIL"), method = "tick", cancellable = false)
	public void tick(CallbackInfo info)
	{
		for(int i = 0; i < this.buttons.size(); i++) {
			if(this.buttons.get(i).x == this.x + 164 && this.buttons.get(i).y == this.y + 107) {
				this.buttons.get(i).active = !((BeaconContainer)this.container).getSlot(0).getStack().isEmpty() && this.primaryEffect != null;
			}

		}
	}

}
