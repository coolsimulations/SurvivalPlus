package net.coolsimulations.SurvivalPlus.core;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;

public class SurvivalPlusClient implements ClientModInitializer {
	
	@Override
	public void onInitializeClient() {
		
		textureStitch();
		BlockRenderLayerMap.INSTANCE.putBlock(SPBlocks.onion, RenderType.cutout());
		
		for(ResourceLocation location : Registry.ITEM.keySet()) {
			Item item = Registry.ITEM.get(location);
			
			if(item instanceof SPItemShield) {
				FabricModelPredicateProviderRegistry.register(item, new ResourceLocation("blocking"),(itemStack, clientWorld, livingEntity, seed) -> {
					return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;
				});
			}
		}
		
		for(ResourceLocation location : Registry.BLOCK.keySet()) {
			Block block = Registry.BLOCK.get(location);
			
			if(block instanceof BlockCardboardLantern) {
				BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
			}
			
			if(location.getNamespace().equals(SPReference.MOD_ID) && block instanceof AmethystClusterBlock) {
				BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
			}
		}

	}
	
	@Environment(EnvType.CLIENT)
	public void textureStitch() {
		
		ClientSpriteRegistryCallback.event(InventoryMenu.BLOCK_ATLAS).register((atlasTexture, registry)->
        {
        	registry.register(new ResourceLocation(SPReference.MOD_ID, "entity/bronze_shield_base"));
    		registry.register(new ResourceLocation(SPReference.MOD_ID, "entity/bronze_shield_base_nopattern"));
    		registry.register(new ResourceLocation(SPReference.MOD_ID, "entity/titanium_shield_base"));
    		registry.register(new ResourceLocation(SPReference.MOD_ID, "entity/titanium_shield_base_nopattern"));
        });
	}

}
