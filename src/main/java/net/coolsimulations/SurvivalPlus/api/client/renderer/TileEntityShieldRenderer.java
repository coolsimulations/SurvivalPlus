package net.coolsimulations.SurvivalPlus.api.client.renderer;

import java.util.List;

import com.mojang.datafixers.util.Pair;

import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRenderer;
import net.minecraft.block.entity.BannerBlockEntity;
import net.minecraft.block.entity.BannerPattern;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BannerBlockEntityRenderer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TileEntityShieldRenderer implements BuiltinItemRenderer {
	
	private final ShieldEntityModel modelShield = new ShieldEntityModel();

	@Override
	public void render(ItemStack stack, MatrixStack matrix, VertexConsumerProvider vertexConsumerProvider, int light, int overlay) {

		Item item = stack.getItem();

		if (item instanceof SPItemShield) {
			boolean bl = stack.getSubTag("BlockEntityTag") != null;
			matrix.push();
			matrix.scale(1.0F, -1.0F, -1.0F);
			SpriteIdentifier spriteIdentifier = bl ? new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(Registry.ITEM.getId(item).getNamespace(), "entity/" + Registry.ITEM.getId(item).getPath() + "_base")) : new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(Registry.ITEM.getId(item).getNamespace(), "entity/" + Registry.ITEM.getId(item).getPath() + "_base_nopattern"));
			VertexConsumer vertexConsumer = spriteIdentifier.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getArmorVertexConsumer(vertexConsumerProvider, this.modelShield.getLayer(spriteIdentifier.getAtlasId()), false, stack.hasEnchantmentGlint()));
			this.modelShield.method_23775().render(matrix, vertexConsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
			if (bl) {
				List<Pair<BannerPattern, DyeColor>> list = BannerBlockEntity.method_24280(ShieldItem.getColor(stack), BannerBlockEntity.method_24281(stack));
				BannerBlockEntityRenderer.method_23802(matrix, vertexConsumerProvider, light, overlay, this.modelShield.method_23774(), spriteIdentifier, false, list);
			} else {
				this.modelShield.method_23774().render(matrix, vertexConsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
			}

			matrix.pop();
		}

	}

}
