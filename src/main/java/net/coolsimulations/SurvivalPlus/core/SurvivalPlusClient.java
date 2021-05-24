package net.coolsimulations.SurvivalPlus.core;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;

public class SurvivalPlusClient implements ClientModInitializer {
	
	@Override
	public void onInitializeClient() {
		
		textureStitch();
		BlockRenderLayerMap.INSTANCE.putBlock(SPBlocks.onion, RenderLayer.getCutout());
	}
	
	@Environment(EnvType.CLIENT)
	public void textureStitch() {
		
		ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry)->
        {
        	registry.register(new Identifier(SPReference.MOD_ID, "entity/bronze_shield_base"));
    		registry.register(new Identifier(SPReference.MOD_ID, "entity/bronze_shield_base_nopattern"));
    		registry.register(new Identifier(SPReference.MOD_ID, "entity/titanium_shield_base"));
    		registry.register(new Identifier(SPReference.MOD_ID, "entity/titanium_shield_base_nopattern"));
        });
	}

}
