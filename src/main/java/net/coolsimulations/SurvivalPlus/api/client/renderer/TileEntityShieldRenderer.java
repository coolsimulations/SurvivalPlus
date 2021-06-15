package net.coolsimulations.SurvivalPlus.api.client.renderer;

import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.datafixers.util.Pair;

import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.model.ShieldModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.BannerTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.tileentity.BannerTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TileEntityShieldRenderer extends ItemStackTileEntityRenderer {

	private final ShieldModel modelShield = new ShieldModel();

	@OnlyIn(Dist.CLIENT)
	public static TileEntityShieldRenderer instance = new TileEntityShieldRenderer();

	@Override
	public void renderByItem(ItemStack stack, TransformType transformType, MatrixStack matrix, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay)
	{
		Item item = stack.getItem();

		if (item instanceof SPItemShield) {
			boolean tag = stack.getTagElement("BlockEntityTag") != null;
			matrix.pushPose();
			matrix.scale(1.0F, -1.0F, -1.0F);
			RenderMaterial material = tag
					? new RenderMaterial(AtlasTexture.LOCATION_BLOCKS,
							new ResourceLocation(item.getRegistryName().getNamespace(), "entity/" + item.getRegistryName().getPath() + "_base"))
							: new RenderMaterial(AtlasTexture.LOCATION_BLOCKS,
									new ResourceLocation(item.getRegistryName().getNamespace(), "entity/" + item.getRegistryName().getPath() + "_base_nopattern"));
			IVertexBuilder lvt_9_3_ = material.sprite().wrap(ItemRenderer.getFoilBuffer(buffer,
					this.modelShield.renderType(material.atlasLocation()), false, stack.hasFoil()));
			this.modelShield.handle().render(matrix, lvt_9_3_, combinedLight, combinedOverlay, 1.0F, 1.0F,
					1.0F, 1.0F);
			if (tag) {
				List<Pair<BannerPattern, DyeColor>> colour = BannerTileEntity.createPatterns(
						ShieldItem.getColor(stack), BannerTileEntity.getItemPatterns(stack));
				BannerTileEntityRenderer.renderPatterns(matrix, buffer, combinedLight, combinedOverlay,
						this.modelShield.plate(), material, false, colour);
			} else {
				this.modelShield.plate().render(matrix, lvt_9_3_, combinedLight, combinedOverlay, 1.0F,
						1.0F, 1.0F, 1.0F);
			}

			matrix.popPose();
		}
	}

}
