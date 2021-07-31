package net.coolsimulations.SurvivalPlus.api.blocks;

import java.util.Random;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class SPBlockOre extends Block{

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
		super(FabricBlockSettings.of(Material.STONE, Material.STONE.getColor()).requiresTool().hardness(resource.hardness).resistance(resource.resistance).breakByTool(FabricToolTags.PICKAXES, resource.harvestLevel).sounds(resource.getBlockSoundType()).luminance(0));
		this.resource = resource;
		this.experience = dropsXP;
	}

	protected int getExperience(Random random) {
		if(experience) {
			if (resource == Resource.TIER_0) {
				return Mth.nextInt(random, 0, 2);
			} else if (resource == Resource.TIER_1) {
				return Mth.nextInt(random, 2, 5);
			} else if (resource == Resource.TIER_2) {
				return Mth.nextInt(random, 3, 7);
			} else {
				return resource == Resource.TIER_3 ? Mth.nextInt(random, 3, 7) : 0;
			}
		}
		return 0;
	}

	@Override
	public void spawnAfterBreak(BlockState state, ServerLevel world, BlockPos pos, ItemStack stack) {
		super.spawnAfterBreak(state, world, pos, stack);
		int i = this.getExperience(world.random);
		if (i > 0) {
			this.popExperience(world, pos, i);
		}
	}

	public enum Resource {
		TIER_0(0, 3.0F, 3.0F, SoundType.STONE, Tiers.WOOD),
		TIER_1(1, 3.0F, 3.0F, SoundType.STONE, Tiers.STONE),
		TIER_2(2, 3.0F, 3.0F, SoundType.STONE, Tiers.IRON),
		TIER_3(3, 3.0F, 3.0F, SoundType.STONE, Tiers.DIAMOND);

		public final float hardness;
		public final float resistance;
		private final SoundType soundType;
		public final int harvestLevel;
		public final Tiers itemTier;

		Resource(int harvestLevel, float hardness, float resistance, SoundType soundType, Tiers itemTier) {
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
