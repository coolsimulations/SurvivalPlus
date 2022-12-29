package net.coolsimulations.SurvivalPlus.core.proxy;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.client.model.SPModelSconce;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce.EnumTorch;
import net.coolsimulations.SurvivalPlus.core.client.renderer.SPTileEntitySconceRenderer;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTileEntities;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientProxy extends CommonProxy{

	@Override
	public void init(){
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientProxy::textureStitch);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientProxy::registerCutouts);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientProxy::registerTileRenders);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientProxy::registerLayerDefinition);
	}

	@SubscribeEvent
	public static void textureStitch(TextureStitchEvent.Pre event) {

		if (event.getAtlas().location() == InventoryMenu.BLOCK_ATLAS) {

			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/bronze_shield_base"));
			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/bronze_shield_base_nopattern"));
			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/titanium_shield_base"));
			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/titanium_shield_base_nopattern"));

			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/sconce/sconce"));
			for (EnumTorch torch : EnumTorch.values()) {
				if (torch != EnumTorch.EMPTY && torch.isLoaded()) {
					event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/sconce/sconce" + "_" + torch.getSerializedName()));
					if (torch.getSerializedName().contains("candle"))
						event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/sconce/sconce" + "_" + torch.getSerializedName() + "_lit"));
				}
			}
		}
	}

	@SubscribeEvent
	public static void registerCutouts(FMLClientSetupEvent event)
	{
		ItemProperties.register(SPItems.bronze_shield.get(), new ResourceLocation(SPReference.MOD_ID, "blocking"), (stack, world, player, seed) -> {
			return player != null && player.isUsingItem() && player.getUseItem() == stack ? 1.0F : 0.0F;});
		ItemProperties.register(SPItems.titanium_shield.get(), new ResourceLocation(SPReference.MOD_ID, "blocking"), (stack, world, player, seed) -> {
			return player != null && player.isUsingItem() && player.getUseItem() == stack ? 1.0F : 0.0F;});
	}

	@SubscribeEvent
	public static void registerTileRenders(EntityRenderersEvent.RegisterRenderers event)
	{
		event.registerBlockEntityRenderer(SurvivalPlusTileEntities.SCONCE.get(), SPTileEntitySconceRenderer::new);
	}

	@SubscribeEvent
	public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event)
	{
		event.registerLayerDefinition(SPModelSconce.sconce, SPModelSconce::createBaseLayer);
	}

}
