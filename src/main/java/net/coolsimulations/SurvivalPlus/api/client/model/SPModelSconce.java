package net.coolsimulations.SurvivalPlus.api.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.datafix.fixes.AddBedTileEntity;

public class SPModelSconce extends ModelBase {
	
    public ModelRenderer base;
    public ModelRenderer bars;
    public ModelRenderer top;
    
    public ModelRenderer torch;
    public ModelRenderer glow1;
    public ModelRenderer glow2;
    public ModelRenderer glow3;
    public ModelRenderer glow4;
    public ModelRenderer staff;
    public ModelRenderer gem1;
    public ModelRenderer gem2;
    public ModelRenderer gem3;
    public ModelRenderer gem4;
    public ModelRenderer gem5;
    public ModelRenderer gem6;
    
	
	public SPModelSconce() {
		this.textureWidth = 32;
		this.textureHeight = 32;
		
		this.base = new ModelRenderer(this, 16, 0);
		this.base.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.base.addBox(-2.0F, -2.0F, -2.0F, 4, 3, 4, 0.0F);
		setRotationAngle(base, 0.0F, 0.0F, -0.3927F);
		
		this.bars = new ModelRenderer(this, 0, 7);
		this.bars.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.bars.addBox(-1.5F, -5.0F, -1.5F, 3, 3, 3, 0.0F);
		setRotationAngle(bars, 0.0F, 0.0F, -0.3927F);
		
		this.top = new ModelRenderer(this, 0, 0);
		this.top.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.top.addBox(-2.0F, -8.0F, -2.0F, 4, 3, 4, 0.0F);
		setRotationAngle(top, 0.0F, 0.0F, -0.3927F);
		
		this.torch = new ModelRenderer(this, 0, 20);
		this.torch.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.torch.addBox(-1.0F, -10.0F, -1.0F, 2, 10, 2, 0.0F);
		setRotationAngle(torch, 0.0F, 0.0F, -0.3927F);
		
		this.glow1 = new ModelRenderer(this, 8, 25);
		this.glow1.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.glow1.addBox(-1.0F, -11.0F, -2.0F, 2, 3, 4, 0.0F);
		setRotationAngle(glow1, 0.0F, 0.0F, -0.3927F);
		
		this.glow2 = new ModelRenderer(this, 20, 27);
		this.glow2.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.glow2.addBox(-2.0F, -11.0F, -1.0F, 4, 3, 2, 0.0F);
		setRotationAngle(glow2, 0.0F, 0.0F, -0.3927F);
		
		this.glow3 = new ModelRenderer(this, 8, 25);
		this.glow3.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.glow3.addBox(-1.0F, -12.0F, -2.0F, 2, 3, 4, 0.0F);
		setRotationAngle(glow3, 0.0F, 0.0F, -0.3927F);
		
		this.glow4 = new ModelRenderer(this, 20, 27);
		this.glow4.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.glow4.addBox(-2.0F, -12.0F, -1.0F, 4, 3, 2, 0.0F);
		setRotationAngle(glow4, 0.0F, 0.0F, -0.3927F);
		
		this.staff = new ModelRenderer(this, 0, 22);
		this.staff.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.staff.addBox(-1.0F, -9.0F, -1.0F, 2, 8, 2, 0.0F);
		setRotationAngle(staff, 0.0F, 0.0F, -0.3927F);
		
		this.gem1 = new ModelRenderer(this, 8, 28);
		this.gem1.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.gem1.addBox(-1.5F, -10.0F, -1.5F, 3, 1, 3, 0.0F);
		setRotationAngle(gem1, 0.0F, 0.0F, -0.3927F);
		
		this.gem2 = new ModelRenderer(this, 20, 28);
		this.gem2.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.gem2.addBox(-1.25F, -12.0F, -0.75F, 2, 2, 2, 0.0F);
		setRotationAngle(gem2, 0.0F, 0.0F, -0.3927F);
		
		this.gem3 = new ModelRenderer(this, 28, 29);
		this.gem3.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.gem3.addBox(-0.625F, -13.0F, -0.125F, 1, 2, 1, 0.0F);
		setRotationAngle(gem3, 0.0F, 0.0F, -0.3927F);
		
		this.gem4 = new ModelRenderer(this, 8, 26);
		this.gem4.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.gem4.addBox(-1.125F, -11.0F, -0.875F, 2, 1, 1, 0.0F);
		setRotationAngle(gem4, 0.0F, 0.0F, -0.3927F);
		
		this.gem5 = new ModelRenderer(this, 14, 26);
		this.gem5.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.gem5.addBox(0.0F, -11.0F, 0.5F, 1, 1, 1, 0.0F);
		setRotationAngle(gem5, 0.0F, 0.0F, -0.3927F);
		
		this.gem6 = new ModelRenderer(this, 18, 26);
		this.gem6.setRotationPoint(6.5F, 20.5F, 0.0F);
		this.gem6.addBox(-1.675F, -11.0F, 0.425F, 1, 1, 1, 0.0F);
		setRotationAngle(gem6, 0.0F, 0.0F, -0.3927F);
	}
	
	public void render() {
		base.render(0.0625F);
		bars.render(0.0625F);
		top.render(0.0625F);
	}
	
	public void renderTorch() {
		torch.render(0.0625F);
	}
	
	public void renderTorchGlow() {
		glow1.render(0.0625F);
		glow2.render(0.0625F);
	}
	
	public void renderTorchTallGlow() {
		glow3.render(0.0625F);
		glow4.render(0.0625F);
	}
	
	public void renderStaff() {
		staff.render(0.0625F);
	}
	
	public void renderGem() {
		gem1.render(0.0625F);
		gem2.render(0.0625F);
		gem3.render(0.0625F);
		gem4.render(0.0625F);
		gem5.render(0.0625F);
		gem6.render(0.0625F);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

}
