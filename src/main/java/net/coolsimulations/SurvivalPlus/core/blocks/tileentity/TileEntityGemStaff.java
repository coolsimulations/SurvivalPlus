package net.coolsimulations.SurvivalPlus.core.blocks.tileentity;

import java.util.List;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockGemStaff;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusBeaconsForAll;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityGemStaff extends TileEntity implements ITickable {

	@Override
	public void update() {
		if (this.world.getTotalWorldTime() % 80L == 0L)
		{
			if (!this.world.isRemote && this.world.getBlockState(pos).getBlock() instanceof BlockGemStaff) {
				switch (this.world.getBlockState(this.pos).getValue(BlockGemStaff.GEM)) {
				case AMETHYST:
					addEffectsToPlayers(this.world, pos, MobEffects.HASTE);
					break;
				case RUBY:
					addEffectsToPlayers(this.world, pos, MobEffects.STRENGTH);
					break;
				case PEARL:
					addEffectsToPlayers(this.world, pos, MobEffects.WATER_BREATHING);
					break;
				case TOPAZ:
					addEffectsToPlayers(this.world, pos, MobEffects.FIRE_RESISTANCE);
					break;
				case SAPPHIRE:
					addEffectsToPlayers(this.world, pos, MobEffects.INVISIBILITY);
					break;
				case SPINEL:
					addEffectsToPlayers(this.world, pos, MobEffects.REGENERATION);
					break;
				default:
					break;
				}
			}
		}
	}

	public static void addEffectsToPlayers(World world, BlockPos pos, Potion effect)
	{
		int k = pos.getX();
		int l = pos.getY();
		int i1 = pos.getZ();
		AxisAlignedBB axisalignedbb = (new AxisAlignedBB(k, l, i1, (k + 1), (l + 1), (i1 + 1))).grow(4).expand(0.0D, 4.0D, 0.0D);
		List<EntityPlayer> list = world.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);

		for (EntityPlayer entityplayer : list)
		{
			entityplayer.addPotionEffect(new PotionEffect(effect, 150, 0, true, effect == MobEffects.INVISIBILITY ? false : true));
		}

		if (SPCompatibilityManager.isBeaconsForAllLoaded()) {
			List<EntityLivingBase> list1 = world.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb, living -> !(living instanceof EntityPlayer) && SurvivalPlusBeaconsForAll.isValidCreature(living));

			for (EntityLivingBase entityLivingBase : list1)
			{
				entityLivingBase.addPotionEffect(new PotionEffect(effect, 150, 0, true, effect == MobEffects.INVISIBILITY ? false : true));
			}
		}
	}

}
