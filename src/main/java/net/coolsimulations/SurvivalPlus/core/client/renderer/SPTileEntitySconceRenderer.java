package net.coolsimulations.SurvivalPlus.core.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockSconce;
import net.coolsimulations.SurvivalPlus.api.client.model.SPModelSconce;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce.EnumTorch;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SPTileEntitySconceRenderer<T extends BlockEntity> implements BlockEntityRenderer<T> {

	private final SPModelSconce modelSconce;

	public SPTileEntitySconceRenderer(BlockEntityRendererProvider.Context context) {
		ModelPart modelpart = context.bakeLayer(SPModelSconce.sconce);
		modelSconce = new SPModelSconce(modelpart);
	}

	@Override
	public void render(T be, float partialTicks, PoseStack matrix, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
		Level level = be.getLevel();
		boolean flag = level != null;
		BlockState blockstate = flag ? be.getBlockState() : SPBlocks.sconce.get().defaultBlockState().setValue(SPBlockSconce.FACING, Direction.EAST);
		Block block = blockstate.getBlock();
		if (block instanceof SPBlockSconce && be instanceof TileEntitySconce) {
			TileEntitySconce te = (TileEntitySconce) be;
			
			matrix.pushPose();
			matrix.translate(0.5D, 0.0D, 0.5D);
			matrix.scale(1.0F, -1.0F, -1.0F);
			
			if (blockstate.getValue(SPBlockSconce.FACING) == Direction.EAST)
				matrix.mulPose(Axis.YN.rotationDegrees(180.0F));
			else if (blockstate.getValue(SPBlockSconce.FACING) == Direction.NORTH)
				matrix.mulPose(Axis.YN.rotationDegrees(270.0F));
			else if (blockstate.getValue(SPBlockSconce.FACING) == Direction.SOUTH)
				matrix.mulPose(Axis.YN.rotationDegrees(90.0F));

			Material sconce = new Material(InventoryMenu.BLOCK_ATLAS, new ResourceLocation(SPReference.MOD_ID, "entity/sconce/sconce"
					+ (te.getTorch() == EnumTorch.EMPTY ? "" : "_" + te.getTorch().getSerializedName())
					+ (te.getTorch().getSerializedName().contains("candle") && te.getLit() ? "_lit" : "")));
			VertexConsumer vertexconsumer = sconce.buffer(buffer, RenderType::entityCutout);
			modelSconce.render(matrix, vertexconsumer, combinedLight, combinedOverlay);
			if (te.getTorch() != EnumTorch.EMPTY) {
				if (te.getTorch() == EnumTorch.GEM_STAFF
	        			|| te.getTorch() == EnumTorch.GEM_STAFF_AMETHYST
	        			|| te.getTorch() == EnumTorch.GEM_STAFF_RUBY
	        			|| te.getTorch() == EnumTorch.GEM_STAFF_PEARL
	        			|| te.getTorch() == EnumTorch.GEM_STAFF_TOPAZ
	        			|| te.getTorch() == EnumTorch.GEM_STAFF_SAPPHIRE
	        			|| te.getTorch() == EnumTorch.GEM_STAFF_SPINEL) {
	        		this.modelSconce.renderStaff(matrix, vertexconsumer, combinedLight, combinedOverlay);
	        		if (te.getTorch() != EnumTorch.GEM_STAFF)
	        			this.modelSconce.renderGem(matrix, vertexconsumer, combinedLight, combinedOverlay);
	        	} else {
	        		this.modelSconce.renderTorch(matrix, vertexconsumer, combinedLight, combinedOverlay);
	        		if (te.getTorch().getSerializedName().contains("candle"))
	        			this.modelSconce.renderCandle(matrix, vertexconsumer, combinedLight, combinedOverlay);
	        	}
	        	if (te.getTorch() == EnumTorch.REDSTONE_TORCH_ON || te.getTorch() == EnumTorch.GLOWSTONE_TORCH || te.getTorch() == EnumTorch.INTERDICTION_TORCH)
	        		this.modelSconce.renderTorchGlow(matrix, vertexconsumer, combinedLight, combinedOverlay);
	        	if (te.getTorch() == EnumTorch.AMBROSIUM_TORCH)
	        		this.modelSconce.renderTorchTallGlow(matrix, vertexconsumer, combinedLight, combinedOverlay);
			}
			matrix.popPose();
		}
	}

}
