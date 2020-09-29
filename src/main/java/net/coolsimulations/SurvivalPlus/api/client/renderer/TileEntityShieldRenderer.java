package net.coolsimulations.SurvivalPlus.api.client.renderer;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelShield;
import net.minecraft.client.renderer.BannerTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityShieldRenderer extends TileEntityItemStackRenderer{
	
	private final TileEntityBanner banner = new TileEntityBanner();
	private final ModelShield modelShield = new ModelShield();
	
	@SideOnly(Side.CLIENT)
	public static TileEntityShieldRenderer instance = new TileEntityShieldRenderer();
	
	public void renderByItem(ItemStack stack, float partialTicks)
    {
        Item item = stack.getItem();

        if (item instanceof SPItemShield)
        {
            if (stack.getSubCompound("BlockEntityTag") != null)
            {
                this.banner.setItemValues(stack, true);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new BannerTextures.Cache("S", new ResourceLocation(item.getRegistryName().getResourceDomain(), "textures/entity/" + item.getRegistryName().getResourcePath() + "_base.png"), "textures/entity/shield/").getResourceLocation(this.banner.getPatternResourceLocation(), this.banner.getPatternList(), this.banner.getColorList()));
            }
            else
            {
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(item.getRegistryName().getResourceDomain(), "textures/entity/" + item.getRegistryName().getResourcePath() + "_base_nopattern.png"));
            }

            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0F, -1.0F, -1.0F);
            this.modelShield.render();
            GlStateManager.popMatrix();
        }
    }

}
