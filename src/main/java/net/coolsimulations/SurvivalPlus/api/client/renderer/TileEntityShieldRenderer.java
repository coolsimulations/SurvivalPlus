package net.coolsimulations.SurvivalPlus.api.client.renderer;

import com.mojang.blaze3d.platform.GlStateManager;

import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BannerTextures;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.model.ShieldModel;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.tileentity.BannerTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TileEntityShieldRenderer extends ItemStackTileEntityRenderer{
	
	private final BannerTileEntity banner = new BannerTileEntity();
	private final ShieldModel modelShield = new ShieldModel();
	
	@OnlyIn(Dist.CLIENT)
	public static TileEntityShieldRenderer instance = new TileEntityShieldRenderer();
	
	@Override
	public void renderByItem(ItemStack stack)
    {
        Item item = stack.getItem();

       if (item instanceof SPItemShield) {
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
       }
    }
	
	private void renderEffect(Runnable runnable) {
		GlStateManager.color3f(0.5019608F, 0.2509804F, 0.8F);
		Minecraft.getInstance().getTextureManager().bindTexture(ItemRenderer.RES_ITEM_GLINT);
		ItemRenderer.renderEffect(Minecraft.getInstance().getTextureManager(), runnable, 1);
	}

}
