package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.SurvivalPlus.api.item.SPItemIngot;
import net.minecraft.container.BeaconContainer;
import net.minecraft.container.Container;
import net.minecraft.container.ContainerType;
import net.minecraft.inventory.BasicInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

@Mixin(BeaconContainer.class)
public abstract class BeaconContainerMixin extends Container {

	protected BeaconContainerMixin(ContainerType<?> type, int syncId) {
		super(type, syncId);
	}

	@Shadow
	public Inventory paymentInv;

	private List<Item> validItems = new ArrayList<Item>();

	@Inject(at = @At("TAIL"), method = "<init>(ILnet/minecraft/inventory/Inventory;Lnet/minecraft/container/PropertyDelegate;Lnet/minecraft/container/BlockContext;)V", cancellable = false)
	public void BeaconContainer(CallbackInfo info)
	{
		for(int i = 0; i < Registry.ITEM.getIds().size(); i++) {
			if(Registry.ITEM.get(i) instanceof SPItemIngot) {
				Item item = Registry.ITEM.get(i);
				if(((SPItemIngot) item).beacon) {
					validItems.add(item);
				}
			}
		}
		
		validItems.add(Items.EMERALD);
		validItems.add(Items.DIAMOND);
		validItems.add(Items.GOLD_INGOT);
		validItems.add(Items.IRON_INGOT);
		
		this.paymentInv = new BasicInventory(1) {
			@Override
			public boolean isValidInvStack(int slot, ItemStack stack) {
				
				return validItems.contains(stack.getItem());
			}

			@Override
			public int getInvMaxStackAmount() {
				return 1;
			}
		};
	}

}
