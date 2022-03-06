package net.coolsimulations.SurvivalPlus.core.proxy;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockCardboardLantern;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
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

		if (event.getAtlas().location() == InventoryMenu.BLOCK_ATLAS) {

			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/bronze_shield_base"));
			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/bronze_shield_base_nopattern"));
			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/titanium_shield_base"));
			event.addSprite(new ResourceLocation(SPReference.MOD_ID, "entity/titanium_shield_base_nopattern"));
		}
	}
	
	@SubscribeEvent
	public static void registerCutouts(FMLClientSetupEvent event)
	{
		ItemBlockRenderTypes.setRenderLayer(SPBlocks.onion.get(), RenderType.cutout());
		
		for(ResourceLocation location : ForgeRegistries.BLOCKS.getKeys()) {
			Block block = ForgeRegistries.BLOCKS.getValue(location);
			
			if(block instanceof BlockCardboardLantern) {
				ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutout());
			}
			
			if(location.getNamespace().equals(SPReference.MOD_ID) && block instanceof AmethystClusterBlock) {
				ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutout());
			}
		}
		
		ItemProperties.register(SPItems.bronze_shield.get(), new ResourceLocation(SPReference.MOD_ID, "blocking"), (stack, world, player, seed) -> {
	         return player != null && player.isUsingItem() && player.getUseItem() == stack ? 1.0F : 0.0F;});
		ItemProperties.register(SPItems.titanium_shield.get(), new ResourceLocation(SPReference.MOD_ID, "blocking"), (stack, world, player, seed) -> {
	         return player != null && player.isUsingItem() && player.getUseItem() == stack ? 1.0F : 0.0F;});
	}
	
}
