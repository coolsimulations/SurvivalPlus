package net.coolsimulations.SurvivalPlus.core;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.client.renderer.TileEntityShieldRenderer;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SurvivalPlusClient implements ClientModInitializer {
	
	@Override
	public void onInitializeClient() {
		
		textureStitch();
		BlockRenderLayerMap.INSTANCE.putBlock(SPBlocks.onion, RenderLayer.getCutout());
		
		for(int i = 0; i < Registry.BLOCK.getIds().size(); i++) {
			Block block = Registry.BLOCK.get(i);
			
			if(block instanceof BlockCardboardLantern) {
				BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
			}
		}
		
		for(int i = 0; i < Registry.ITEM.getIds().size(); i++) {
			Item item = Registry.ITEM.get(i);
			
			if(item instanceof SPItemShield) {
				BuiltinItemRendererRegistry.INSTANCE.register(item, new TileEntityShieldRenderer());
			}
		}
	}
	
	@Environment(EnvType.CLIENT)
	public void textureStitch() {
		
		ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEX).register((atlasTexture, registry)->
        {
        	registry.register(new Identifier(SPReference.MOD_ID, "entity/bronze_shield_base"));
    		registry.register(new Identifier(SPReference.MOD_ID, "entity/bronze_shield_base_nopattern"));
    		registry.register(new Identifier(SPReference.MOD_ID, "entity/titanium_shield_base"));
    		registry.register(new Identifier(SPReference.MOD_ID, "entity/titanium_shield_base_nopattern"));
        });
	}

}
