package net.coolsimulations.SurvivalPlus.core;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockSconce;
import net.coolsimulations.SurvivalPlus.api.client.model.SPModelSconce;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockGemStaff;
import net.coolsimulations.SurvivalPlus.core.client.renderer.SPTileEntitySconceRenderer;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTileEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;

public class SurvivalPlusClient implements ClientModInitializer {
	
	@Override
	public void onInitializeClient() {
		
		BlockRenderLayerMap.INSTANCE.putBlock(SPBlocks.onion, RenderType.cutout());
		
		for(ResourceLocation location : BuiltInRegistries.ITEM.keySet()) {
			Item item = BuiltInRegistries.ITEM.get(location);
			
			if(item instanceof SPItemShield) {
				ItemProperties.register(item, new ResourceLocation("blocking"),(itemStack, clientWorld, livingEntity, seed) -> {
					return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;
				});
			}
		}
		
		for(ResourceLocation location : BuiltInRegistries.BLOCK.keySet()) {
			Block block = BuiltInRegistries.BLOCK.get(location);
			
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

}
