package net.coolsimulations.SurvivalPlus.core;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockSconce;
import net.coolsimulations.SurvivalPlus.api.client.model.SPModelSconce;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockGemStaff;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce.EnumTorch;
import net.coolsimulations.SurvivalPlus.core.client.renderer.SPTileEntitySconceRenderer;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTileEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
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
				ItemProperties.register(item, new ResourceLocation("blocking"),(itemStack, clientWorld, livingEntity, seed) -> {
					return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;
				});
			}
		}
		
		for(ResourceLocation location : Registry.BLOCK.keySet()) {
			Block block = Registry.BLOCK.get(location);
			
			if(block instanceof BlockCardboardLantern || block instanceof SPBlockSconce || block instanceof BlockGemStaff) {
				BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
			}
			
			if(location.getNamespace().equals(SPReference.MOD_ID) && block instanceof AmethystClusterBlock) {
				BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
			}
		}
		
		BlockEntityRenderers.register(SurvivalPlusTileEntities.SCONCE, SPTileEntitySconceRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(SPModelSconce.sconce, SPModelSconce::createBaseLayer);
	}
	
	@Environment(EnvType.CLIENT)
	public void textureStitch() {
		
		ClientSpriteRegistryCallback.event(InventoryMenu.BLOCK_ATLAS).register((atlasTexture, registry)->
        {
        	registry.register(new ResourceLocation(SPReference.MOD_ID, "entity/bronze_shield_base"));
    		registry.register(new ResourceLocation(SPReference.MOD_ID, "entity/bronze_shield_base_nopattern"));
    		registry.register(new ResourceLocation(SPReference.MOD_ID, "entity/titanium_shield_base"));
    		registry.register(new ResourceLocation(SPReference.MOD_ID, "entity/titanium_shield_base_nopattern"));
    		
    		registry.register(new ResourceLocation(SPReference.MOD_ID, "entity/sconce/sconce"));
			for (EnumTorch torch : EnumTorch.values()) {
				if (torch != EnumTorch.EMPTY && torch.isLoaded()) {
					registry.register(new ResourceLocation(SPReference.MOD_ID, "entity/sconce/sconce" + "_" + torch.getSerializedName()));
					if (torch.getSerializedName().contains("candle"))
						registry.register(new ResourceLocation(SPReference.MOD_ID, "entity/sconce/sconce" + "_" + torch.getSerializedName() + "_lit"));
				}
			}

        });
	}

}
