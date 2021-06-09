package net.coolsimulations.SurvivalPlus.api.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

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
		super(Properties.create(Material.ROCK, Material.ROCK.getColor()).hardnessAndResistance(resource.hardness, resource.resistance).sound(resource.getBlockSoundType()));
		this.resource = resource;
		this.experience = dropsXP;
	}

	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public void spawnAdditionalDrops(BlockState state, World world, BlockPos pos, ItemStack stack) {
		super.spawnAdditionalDrops(state, world, pos, stack);
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return resource.harvestLevel;
	}

	@Override
	public int getLightValue(BlockState p_getLightValue_1_) {

		return 0;
	}

	protected int getExperience(Random random) {
		if(experience) {
			if (resource == Resource.TIER_0) {
				return MathHelper.nextInt(random, 0, 2);
			} else if (resource == Resource.TIER_1) {
				return MathHelper.nextInt(random, 2, 5);
			} else if (resource == Resource.TIER_2) {
				return MathHelper.nextInt(random, 3, 7);
			} else {
				return resource == Resource.TIER_3 ? MathHelper.nextInt(random, 3, 7) : 0;
			}
		}
		return 0;
	}

	@Override
	public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int p_getExpDrop_4_, int amount) {
		return amount == 0 ? this.getExperience(this.RANDOM) : 0;
	}

	public enum Resource {
		TIER_0(0, 3.0F, 5.0F, SoundType.STONE, ItemTier.WOOD),
		TIER_1(1, 3.5F, 5.0F, SoundType.STONE, ItemTier.STONE),
		TIER_2(2, 3.0F, 5.0F, SoundType.STONE, ItemTier.IRON),
		TIER_3(3, 3.5F, 5.0F, SoundType.STONE, ItemTier.DIAMOND);

		public final float hardness;
		public final float resistance;
		private final SoundType soundType;
		public final int harvestLevel;
		public final IItemTier itemTier;

		Resource(int harvestLevel, float hardness, float resistance, SoundType soundType, IItemTier itemTier) {
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
