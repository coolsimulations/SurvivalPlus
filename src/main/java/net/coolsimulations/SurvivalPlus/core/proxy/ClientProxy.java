package net.coolsimulations.SurvivalPlus.core.proxy;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void init(){
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientProxy::textureStitch);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientProxy::registerCutouts);
	}
	
	@SubscribeEvent
	public static void textureStitch(TextureStitchEvent.Pre event) {

		if (event.getMap().location() == AtlasTexture.LOCATION_BLOCKS) {

			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/bronze_shield_base"));
			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/bronze_shield_base_nopattern"));
			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/titanium_shield_base"));
			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/titanium_shield_base_nopattern"));
		}
	}
	
	@SubscribeEvent
	public static void registerCutouts(FMLClientSetupEvent event)
	{
		RenderTypeLookup.setRenderLayer(SPBlocks.onion, RenderType.cutout());
		
		for(ResourceLocation location : ForgeRegistries.BLOCKS.getKeys()) {
			Block block = ForgeRegistries.BLOCKS.getValue(location);
			
			if(block instanceof BlockCardboardLantern) {
				RenderTypeLookup.setRenderLayer(block, RenderType.cutout());
			}
		}
		
		ItemModelsProperties.register(SPItems.bronze_shield, new ResourceLocation(SPReference.MOD_ID, "blocking"), (stack, world, player) -> {
	         return player != null && player.isUsingItem() && player.getUseItem() == stack ? 1.0F : 0.0F;});
		ItemModelsProperties.register(SPItems.titanium_shield, new ResourceLocation(SPReference.MOD_ID, "blocking"), (stack, world, player) -> {
	         return player != null && player.isUsingItem() && player.getUseItem() == stack ? 1.0F : 0.0F;});
	}
	
}
