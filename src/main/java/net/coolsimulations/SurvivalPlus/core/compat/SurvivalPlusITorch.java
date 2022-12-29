package net.coolsimulations.SurvivalPlus.core.compat;

import java.awt.Color;

import com.notloki.itorch.entities.particles.ParticleCustomFlame;
import com.notloki.itorch.entities.particles.ParticleCustomSmoke;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SurvivalPlusITorch {
	
	@SideOnly(Side.CLIENT)
	public static void spawnTorchParticles(World worldIn, EnumFacing enumfacing1, double d0, double d1, double d2, String colorName, Color color) {
		ParticleCustomSmoke newEffect = new ParticleCustomSmoke(worldIn, d0 + 0.17D * enumfacing1.getFrontOffsetX(), d1 + 0.22D, d2 + 0.17D * enumfacing1.getFrontOffsetZ(), 0.0D, 0.0D, 0.0D, 1.0F, color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F);
		Minecraft.getMinecraft().effectRenderer.addEffect(newEffect);
		ParticleCustomFlame newEffect2 = new ParticleCustomFlame(worldIn, d0 + 0.17D * enumfacing1.getFrontOffsetX(), d1 + 0.22D, d2 + 0.17D * enumfacing1.getFrontOffsetZ(), 0.0D, 0.0D, 0.0D, colorName, color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F);
		Minecraft.getMinecraft().effectRenderer.addEffect(newEffect2);
	}

}
