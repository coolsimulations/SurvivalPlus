package net.coolsimulations.SurvivalPlus.api.client.renderer;

import java.util.List;
import java.util.function.Supplier;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;

import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;

public class TileEntityShieldRenderer extends BlockEntityWithoutLevelRenderer {
	
	private ShieldModel modelShield;
	private EntityModelSet entityModelSet;
	
	public static final BlockEntityWithoutLevelRenderer instance = new TileEntityShieldRenderer(() -> Minecraft.getInstance().getBlockEntityRenderDispatcher(), () -> Minecraft.getInstance().getEntityModels());

	public TileEntityShieldRenderer(Supplier<BlockEntityRenderDispatcher> p_172550_, Supplier<EntityModelSet> p_172551_) {
		super(p_172550_.get(), p_172551_.get());
		entityModelSet = p_172551_.get();
		modelShield = new ShieldModel(entityModelSet.bakeLayer(ModelLayers.SHIELD));
	}
	
	@Override
	public void onResourceManagerReload(ResourceManager p_172555_) {
		modelShield = new ShieldModel(this.entityModelSet.bakeLayer(ModelLayers.SHIELD));
	}

	@Override
	public void renderByItem(ItemStack stack, TransformType transformType, PoseStack matrix, MultiBufferSource buffer, int combinedLight, int combinedOverlay)
	{
		Item item = stack.getItem();

		if (item instanceof SPItemShield) {
			boolean tag = stack.getTagElement("BlockEntityTag") != null;
			matrix.pushPose();
			matrix.scale(1.0F, -1.0F, -1.0F);
			Material material = tag
					? new Material(TextureAtlas.LOCATION_BLOCKS,
							new ResourceLocation(item.getRegistryName().getNamespace(), "entity/" + item.getRegistryName().getPath() + "_base"))
							: new Material(TextureAtlas.LOCATION_BLOCKS,
									new ResourceLocation(item.getRegistryName().getNamespace(), "entity/" + item.getRegistryName().getPath() + "_base_nopattern"));
			VertexConsumer lvt_9_3_ = material.sprite().wrap(ItemRenderer.getFoilBuffer(buffer,
					this.modelShield.renderType(material.atlasLocation()), false, stack.hasFoil()));
			this.modelShield.handle().render(matrix, lvt_9_3_, combinedLight, combinedOverlay, 1.0F, 1.0F,
					1.0F, 1.0F);
			if (tag) {
				List<Pair<BannerPattern, DyeColor>> colour = BannerBlockEntity.createPatterns(
						ShieldItem.getColor(stack), BannerBlockEntity.getItemPatterns(stack));
				BannerRenderer.renderPatterns(matrix, buffer, combinedLight, combinedOverlay,
						this.modelShield.plate(), material, false, colour);
			} else {
				this.modelShield.plate().render(matrix, lvt_9_3_, combinedLight, combinedOverlay, 1.0F,
						1.0F, 1.0F, 1.0F);
			}

			matrix.popPose();
		}
	}

}
