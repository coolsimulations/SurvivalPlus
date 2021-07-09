package net.coolsimulations.SurvivalPlus.api.client.renderer;

import java.util.List;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;

import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry.DynamicItemRenderer;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;

public class TileEntityShieldRenderer implements DynamicItemRenderer {
	
	private final ShieldModel modelShield = new ShieldModel();

	@Override
	public void render(ItemStack stack, TransformType mode, PoseStack matrix, MultiBufferSource vertexConsumerProvider, int light, int overlay) {

		Item item = stack.getItem();

		if (item instanceof SPItemShield) {

			boolean bl = stack.getTagElement("BlockEntityTag") != null;
			matrix.pushPose();
			matrix.scale(1.0F, -1.0F, -1.0F);
			Material Material = bl ? new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation(Registry.ITEM.getKey(item).getNamespace(), "entity/" + Registry.ITEM.getKey(item).getPath() + "_base")) : new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation(Registry.ITEM.getKey(item).getNamespace(), "entity/" + Registry.ITEM.getKey(item).getPath() + "_base_nopattern"));
			VertexConsumer vertexConsumer = Material.sprite().wrap(ItemRenderer.getFoilBufferDirect(vertexConsumerProvider, this.modelShield.renderType(Material.atlasLocation()), true, stack.hasFoil()));
			this.modelShield.handle().render(matrix, vertexConsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
			if (bl) {
				List<Pair<BannerPattern, DyeColor>> list = BannerBlockEntity.createPatterns(ShieldItem.getColor(stack), BannerBlockEntity.getItemPatterns(stack));
				BannerRenderer.renderPatterns(matrix, vertexConsumerProvider, light, overlay, this.modelShield.plate(), Material, false, list, stack.hasFoil());
			} else {
				this.modelShield.plate().render(matrix, vertexConsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
			}

			matrix.popPose();
		}

	}

}
