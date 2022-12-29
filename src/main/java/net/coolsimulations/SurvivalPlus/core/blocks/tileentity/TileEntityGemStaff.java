package net.coolsimulations.SurvivalPlus.core.blocks.tileentity;

import java.util.List;

import com.illusivesoulworks.beaconsforall.BeaconsForAllMod;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockGemStaff;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class TileEntityGemStaff extends BlockEntity {

	public TileEntityGemStaff(BlockPos pos, BlockState state) {
		super(SurvivalPlusTileEntities.GEM_STAFF, pos, state);
	}

	public static <T extends BlockEntity> void tick(Level world, BlockPos pos, BlockState state, T te) {
		if (world.getGameTime() % 80L == 0L)
		{
			if (!world.isClientSide() && world.getBlockState(pos).getBlock() instanceof BlockGemStaff) {
				switch (world.getBlockState(pos).getValue(BlockGemStaff.GEM)) {
				case AMETHYST:
					addEffectsToPlayers(world, pos, MobEffects.DIG_SPEED);
					break;
				case RUBY:
					addEffectsToPlayers(world, pos, MobEffects.DAMAGE_BOOST);
					break;
				case PEARL:
					addEffectsToPlayers(world, pos, MobEffects.WATER_BREATHING);
					break;
				case TOPAZ:
					addEffectsToPlayers(world, pos, MobEffects.FIRE_RESISTANCE);
					break;
				case SAPPHIRE:
					addEffectsToPlayers(world, pos, MobEffects.INVISIBILITY);
					break;
				case SPINEL:
					addEffectsToPlayers(world, pos, MobEffects.REGENERATION);
					break;
				default:
					break;
				}
			}
		}
	}
	
	public static void addEffectsToPlayers(Level world, BlockPos pos, MobEffect effect)
	{
		int k = pos.getX();
		int l = pos.getY();
		int i1 = pos.getZ();
		AABB axisalignedbb = (new AABB(k, l, i1, (k + 1), (l + 1), (i1 + 1))).inflate(4).expandTowards(0.0D, 4.0D, 0.0D);
        List<Player> list = world.getEntitiesOfClass(Player.class, axisalignedbb);

		for (Player entityplayer : list)
		{
			entityplayer.addEffect(new MobEffectInstance(effect, 150, 0, true, effect == MobEffects.INVISIBILITY ? false : true));
		}

		if (SPCompatibilityManager.isBeaconsForAllLoaded()) {
			List<LivingEntity> list1 = world.getEntitiesOfClass(LivingEntity.class, axisalignedbb, living -> !(living instanceof Player) && BeaconsForAllMod.canApplyEffects(living));

			for (LivingEntity entityLivingBase : list1)
			{
				entityLivingBase.addEffect(new MobEffectInstance(effect, 150, 0, true, effect == MobEffects.INVISIBILITY ? false : true));
			}
		}
	}

}
