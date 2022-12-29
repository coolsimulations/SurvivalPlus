package net.coolsimulations.SurvivalPlus.api.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SPModelSconce {

	public static ModelLayerLocation sconce = new ModelLayerLocation(new ResourceLocation(SPReference.MOD_ID, "sconce"), "main");

	public final ModelPart base;
	public final ModelPart bars;
	public final ModelPart top;
	
	public final ModelPart torch;
    public final ModelPart glow1;
    public final ModelPart glow2;
    public final ModelPart glow3;
    public final ModelPart glow4;
    public final ModelPart staff;
    public final ModelPart gem1;
    public final ModelPart gem2;
    public final ModelPart gem3;
    public final ModelPart gem4;
    public final ModelPart gem5;
    public final ModelPart gem6;
    public final ModelPart candle1;
    public final ModelPart candle2;

	public SPModelSconce(ModelPart part) {
		this.base = part.getChild("base");
		this.bars = part.getChild("bars");
		this.top = part.getChild("top");
		
		this.torch = part.getChild("torch");
		
		this.glow1 = part.getChild("glow1");
		this.glow2 = part.getChild("glow2");
		
		this.glow3 = part.getChild("glow3");
		this.glow4 = part.getChild("glow4");
		
		this.staff = part.getChild("staff");
		
		this.gem1 = part.getChild("gem1");
		this.gem2 = part.getChild("gem2");
		this.gem3 = part.getChild("gem3");
		this.gem4 = part.getChild("gem4");
		this.gem5 = part.getChild("gem5");
		this.gem6 = part.getChild("gem6");
		
		this.candle1 = part.getChild("candle1");
		this.candle2 = part.getChild("candle2");
	}

	public static LayerDefinition createBaseLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(16, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		partdefinition.addOrReplaceChild("bars", CubeListBuilder.create().texOffs(0, 7).addBox(-1.5F, -5.0F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		partdefinition.addOrReplaceChild("top", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -8.0F, -2.0F, 4.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		
		partdefinition.addOrReplaceChild("torch", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		
		partdefinition.addOrReplaceChild("glow1", CubeListBuilder.create().texOffs(8, 25).addBox(-1.0F, -11.0F, -2.0F, 2.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		partdefinition.addOrReplaceChild("glow2", CubeListBuilder.create().texOffs(20, 27).addBox(-2.0F, -11.0F, -1.0F, 4.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		
		partdefinition.addOrReplaceChild("glow3", CubeListBuilder.create().texOffs(8, 25).addBox(-1.0F, -12.0F, -2.0F, 2.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		partdefinition.addOrReplaceChild("glow4", CubeListBuilder.create().texOffs(20, 27).addBox(-2.0F, -12.0F, -1.0F, 4.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		
		partdefinition.addOrReplaceChild("staff", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 8.0F, 2.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		
		partdefinition.addOrReplaceChild("gem1", CubeListBuilder.create().texOffs(8, 28).addBox(-1.5F, -10.0F, -1.5F, 3.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		partdefinition.addOrReplaceChild("gem2", CubeListBuilder.create().texOffs(20, 28).addBox(-1.25F, -12.0F, -0.75F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		partdefinition.addOrReplaceChild("gem3", CubeListBuilder.create().texOffs(28, 29).addBox(-0.625F, -13.0F, -0.125F, 1.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		partdefinition.addOrReplaceChild("gem4", CubeListBuilder.create().texOffs(8, 26).addBox(-1.125F, -11.0F, -0.875F, 2.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		partdefinition.addOrReplaceChild("gem5", CubeListBuilder.create().texOffs(14, 26).addBox(0.0F, -11.0F, 0.5F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		partdefinition.addOrReplaceChild("gem6", CubeListBuilder.create().texOffs(18, 26).addBox(-1.675F, -11.0F, 0.425F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		
		partdefinition.addOrReplaceChild("candle1", CubeListBuilder.create().texOffs(8, 31).addBox(-0.5F, -11.0F, 0.0F, 1.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		partdefinition.addOrReplaceChild("candle2", CubeListBuilder.create().texOffs(8, 30).addBox(0.0F, -11.0F, -0.5F, 0.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(6.5F, -3.5F, 0.0F, 0.0F, 0.0F, -0.3927F));
		
		return LayerDefinition.create(meshdefinition, 32, 32);
	}
	
	public void render(PoseStack matrix, VertexConsumer vertexconsumer, int combinedLight, int combinedOverlay) {
		base.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
		bars.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
		top.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
	}
	
	public void renderTorch(PoseStack matrix, VertexConsumer vertexconsumer, int combinedLight, int combinedOverlay) {
		torch.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
	}
	
	public void renderTorchGlow(PoseStack matrix, VertexConsumer vertexconsumer, int combinedLight, int combinedOverlay) {
		glow1.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
		glow2.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
	}
	
	public void renderTorchTallGlow(PoseStack matrix, VertexConsumer vertexconsumer, int combinedLight, int combinedOverlay) {
		glow3.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
		glow4.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
	}
	
	public void renderStaff(PoseStack matrix, VertexConsumer vertexconsumer, int combinedLight, int combinedOverlay) {
		staff.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
	}
	
	public void renderGem(PoseStack matrix, VertexConsumer vertexconsumer, int combinedLight, int combinedOverlay) {
		gem1.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
		gem2.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
		gem3.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
		gem4.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
		gem5.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
		gem6.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
	}
	
	public void renderCandle(PoseStack matrix, VertexConsumer vertexconsumer, int combinedLight, int combinedOverlay) {
		candle1.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
		candle2.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
	}
}
