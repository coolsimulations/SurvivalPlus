package net.coolsimulations.SurvivalPlus.api.client.renderer;

import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.datafixers.util.Pair;

import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.model.ShieldModel;
import net.minecraft.client.renderer.model.Material;
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
	public void render(ItemStack stack, MatrixStack matrix, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay)
	{
		Item item = stack.getItem();

		/**if (item instanceof SPItemShield) {
			if (stack.getChildTag("BlockEntityTag") != null) {
				this.banner.loadFromItemStack(stack, ShieldItem.getColor(stack));
				Minecraft.getInstance().getTextureManager()
				.bindTexture(new BannerTextures.Cache("shield_", new ResourceLocation(item.getRegistryName().getNamespace(), "textures/entity/" + item.getRegistryName().getPath() + "_base.png"), "textures/entity/shield/").getResourceLocation(this.banner.getPatternResourceLocation(), this.banner.getPatternList(), this.banner.getColorList()));
			} else {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation(item.getRegistryName().getNamespace(), "textures/entity/" + item.getRegistryName().getPath() + "_base_nopattern.png"));
			}

			GlStateManager.pushMatrix();
			GlStateManager.scalef(1.0F, -1.0F, -1.0F);
			this.modelShield.render();
			if (stack.hasEffect()) {
				ShieldModel var10001 = this.modelShield;
				this.modelShield.getClass();
				this.renderEffect(var10001::render);
			}

			GlStateManager.popMatrix();
		}**/

		if (item instanceof SPItemShield) {
			boolean tag = stack.getChildTag("BlockEntityTag") != null;
			matrix.push();
			matrix.scale(1.0F, -1.0F, -1.0F);
			Material material = tag
					? new Material(AtlasTexture.LOCATION_BLOCKS_TEXTURE,
							new ResourceLocation(item.getRegistryName().getNamespace(), "entity/" + item.getRegistryName().getPath() + "_base"))
							: new Material(AtlasTexture.LOCATION_BLOCKS_TEXTURE,
									new ResourceLocation(item.getRegistryName().getNamespace(), "entity/" + item.getRegistryName().getPath() + "_base_nopattern"));
			IVertexBuilder lvt_9_3_ = material.getSprite().wrapBuffer(ItemRenderer.getBuffer(buffer,
					this.modelShield.getRenderType(material.getAtlasLocation()), false, stack.hasEffect()));
			this.modelShield.func_228294_b_().render(matrix, lvt_9_3_, combinedLight, combinedOverlay, 1.0F, 1.0F,
					1.0F, 1.0F);
			if (tag) {
				List<Pair<BannerPattern, DyeColor>> colour = BannerTileEntity.func_230138_a_(
						ShieldItem.getColor(stack), BannerTileEntity.func_230139_a_(stack));
				BannerTileEntityRenderer.func_230180_a_(matrix, buffer, combinedLight, combinedOverlay,
						this.modelShield.func_228293_a_(), material, false, colour);
			} else {
				this.modelShield.func_228293_a_().render(matrix, lvt_9_3_, combinedLight, combinedOverlay, 1.0F,
						1.0F, 1.0F, 1.0F);
			}

			matrix.pop();
		}
	}

}
