package net.coolsimulations.SurvivalPlus.core.proxy;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void init(){
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientProxy::textureStitch);
	}
	
	@SubscribeEvent
	public static void textureStitch(TextureStitchEvent.Pre event) {

		if (event.getMap().getTextureLocation() == AtlasTexture.LOCATION_BLOCKS_TEXTURE) {

			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/bronze_shield_base"));
			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/bronze_shield_base_nopattern"));
			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/titanium_shield_base"));
			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/titanium_shield_base_nopattern"));
		}
	}
	
}
