package net.coolsimulations.SurvivalPlus.api.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class SPBlockOre extends Block {

	public final Resource resource;
	public final Boolean experience;

	/**
	 * @param harvestLevel Harvest level:
	 *     Wood:    0
	 *     Stone:   1
	 *     Iron:    2
	 *     Diamond: 3
	 *     Gold:    0
	 *     Anything higher than 3 will revert to 3
	 */

	public SPBlockOre(Resource resource, Boolean dropsXP) {
		super(Properties.of(Material.STONE, Material.STONE.getColor()).requiresCorrectToolForDrops().strength(resource.hardness, resource.resistance).sound(resource.getBlockSoundType()).lightLevel((p_235464_0_) -> {return 0;}));
		this.resource = resource;
		this.experience = dropsXP;
	}

	@Override
	public void spawnAfterBreak(BlockState state, ServerLevel worldIn, BlockPos pos, ItemStack stack, boolean bl) {
		super.spawnAfterBreak(state, worldIn, pos, stack, bl);
	}

	protected int getExperience(RandomSource random) {
		if(experience) {
			if (resource == Resource.TIER_0 || resource == Resource.TIER_0_DEEPSLATE) {
				return Mth.nextInt(random, 0, 2);
			} else if (resource == Resource.TIER_1 || resource == Resource.TIER_1_DEEPSLATE) {
				return Mth.nextInt(random, 2, 5);
			} else if (resource == Resource.TIER_2 || resource == Resource.TIER_2_DEEPSLATE) {
				return Mth.nextInt(random, 3, 7);
			} else {
				return resource == Resource.TIER_3 || resource == Resource.TIER_3_DEEPSLATE ? Mth.nextInt(random, 3, 7) : 0;
			}
		}
		return 0;
	}

	@Override
	public int getExpDrop(BlockState state, LevelReader reader, RandomSource random, BlockPos pos, int p_getExpDrop_4_, int amount) {
		return amount == 0 ? this.getExperience(random) : 0;
	}

	public enum Resource {
		TIER_0(0, 3.0F, 3.0F, SoundType.STONE, Tiers.WOOD),
		TIER_0_DEEPSLATE(0, 3.0F, 4.5F, SoundType.DEEPSLATE, Tiers.WOOD),
		TIER_1(1, 3.0F, 3.0F, SoundType.STONE, Tiers.STONE),
		TIER_1_DEEPSLATE(1, 3.0F, 4.5F, SoundType.DEEPSLATE, Tiers.STONE),
		TIER_2(2, 3.0F, 3.0F, SoundType.STONE, Tiers.IRON),
		TIER_2_DEEPSLATE(2, 3.0F, 4.5F, SoundType.DEEPSLATE, Tiers.IRON),
		TIER_3(3, 3.0F, 3.0F, SoundType.STONE, Tiers.DIAMOND),
		TIER_3_DEEPSLATE(3, 3.0F, 4.5F, SoundType.DEEPSLATE, Tiers.DIAMOND);

		public final float hardness;
		public final float resistance;
		private final SoundType soundType;
		public final int harvestLevel;
		public final Tier itemTier;

		Resource(int harvestLevel, float hardness, float resistance, SoundType soundType, Tier itemTier) {
			this.hardness = hardness;
			this.resistance = resistance;
			this.soundType = soundType;
			this.harvestLevel = harvestLevel;
			this.itemTier = itemTier;
		}

		public SoundType getBlockSoundType() {
			return soundType;
		}

	}

}
