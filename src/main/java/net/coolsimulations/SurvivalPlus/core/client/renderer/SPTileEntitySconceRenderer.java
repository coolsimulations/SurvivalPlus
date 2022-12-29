package net.coolsimulations.SurvivalPlus.core.client.renderer;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.client.model.SPModelSconce;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce.EnumTorch;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SPTileEntitySconceRenderer extends TileEntitySpecialRenderer<TileEntitySconce> {
	
    private final SPModelSconce modelSconce = new SPModelSconce();

    public void render(TileEntitySconce te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        int i = 0;

        if (te.hasWorld())
        {
            i = te.getBlockMetadata() & 3;
        }

        if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0F, 4.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }
        else
        {
            this.bindTexture(new ResourceLocation(SPReference.MOD_ID, "textures/entity/sconce/sconce"
            		+ (te.getTorch() == EnumTorch.EMPTY ? "" : "_" + te.getTorch().getName())
            		+ (te.getTorch().getName().contains("candle") && !te.getLit() ? "_unlit" : "") + ".png"));
        }

        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);
        GlStateManager.translate(x+0.5F, y+1.5F, z+0.5F);
        GlStateManager.scale(1.0F, -1.0F, -1.0F);
        int j = 0;

        if (i == 0)
        {
            j = 180;
        }

        if (i == 1)
        {
            j = 0;
        }

        if (i == 2)
        {
            j = 270;
        }

        if (i == 3)
        {
            j = 90;
        }
        
        GlStateManager.rotate(j, 0.0F, 1.0F, 0.0F);
        GlStateManager.enableRescaleNormal();
        this.modelSconce.render();
        if (te.getTorch() != EnumTorch.EMPTY) {
        	if (te.getTorch() == EnumTorch.GEM_STAFF
        			|| te.getTorch() == EnumTorch.GEM_STAFF_AMETHYST
        			|| te.getTorch() == EnumTorch.GEM_STAFF_RUBY
        			|| te.getTorch() == EnumTorch.GEM_STAFF_PEARL
        			|| te.getTorch() == EnumTorch.GEM_STAFF_TOPAZ
        			|| te.getTorch() == EnumTorch.GEM_STAFF_SAPPHIRE
        			|| te.getTorch() == EnumTorch.GEM_STAFF_SPINEL) {
        		this.modelSconce.renderStaff();
        		if (te.getTorch() != EnumTorch.GEM_STAFF)
        			this.modelSconce.renderGem();
        	} else {
        		this.modelSconce.renderTorch();
        	}
        	if (te.getTorch() == EnumTorch.REDSTONE_TORCH_ON || te.getTorch() == EnumTorch.GLOWSTONE_TORCH || te.getTorch() == EnumTorch.INTERDICTION_TORCH)
        		this.modelSconce.renderTorchGlow();
        	if (te.getTorch() == EnumTorch.AMBROSIUM_TORCH)
        		this.modelSconce.renderTorchTallGlow();
        }
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
}
