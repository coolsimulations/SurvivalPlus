package net.coolsimulations.SurvivalPlus.core.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;

import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;

@Mixin(BlockEntityWithoutLevelRenderer.class)
public class BlockEntityWithoutLevelRendererMixin {

	@Shadow
	private ShieldModel shieldModel;

	@Inject(method = "renderByItem", at = @At("HEAD"), cancellable = true)
	private void renderByItem(ItemStack stack, ItemTransforms.TransformType mode, PoseStack matrix, MultiBufferSource vertexConsumerProvider, int light, int overlay, CallbackInfo info) {

		Item item = stack.getItem();

		if (item instanceof SPItemShield) {

			boolean bl = stack.getTagElement("BlockEntityTag") != null;
			matrix.pushPose();
			matrix.scale(1.0F, -1.0F, -1.0F);
			Material Material = bl ? new Material(InventoryMenu.BLOCK_ATLAS, new ResourceLocation(Registry.ITEM.getKey(item).getNamespace(), "entity/" + Registry.ITEM.getKey(item).getPath() + "_base")) : new Material(InventoryMenu.BLOCK_ATLAS, new ResourceLocation(Registry.ITEM.getKey(item).getNamespace(), "entity/" + Registry.ITEM.getKey(item).getPath() + "_base_nopattern"));
			VertexConsumer vertexConsumer = Material.sprite().wrap(ItemRenderer.getFoilBufferDirect(vertexConsumerProvider, this.shieldModel.renderType(Material.atlasLocation()), true, stack.hasFoil()));
			this.shieldModel.handle().render(matrix, vertexConsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
			if (bl) {
				List<Pair<BannerPattern, DyeColor>> list = BannerBlockEntity.createPatterns(ShieldItem.getColor(stack), BannerBlockEntity.getItemPatterns(stack));
				BannerRenderer.renderPatterns(matrix, vertexConsumerProvider, light, overlay, this.shieldModel.plate(), Material, false, list, stack.hasFoil());
			} else {
				this.shieldModel.plate().render(matrix, vertexConsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
			}

			matrix.popPose();
			info.cancel();
			return;
		}
	}

}
