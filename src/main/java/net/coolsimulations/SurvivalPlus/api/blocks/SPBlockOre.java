package net.coolsimulations.SurvivalPlus.api.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class SPBlockOre extends Block{
	
	public final int harvestLevel;
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
	
	public SPBlockOre(int harvestLevel, Boolean dropsXP) {
		super(Material.ROCK);
		if(harvestLevel == 0) {
			this.setHarvestLevel("pickaxe", 0);
		}
		else if (harvestLevel == 1) {
			this.setHarvestLevel("pickaxe", 1);
		}
		else if (harvestLevel == 2) {
			this.setHarvestLevel("pickaxe", 2);
		}
		else if (harvestLevel >= 3) {
			this.setHarvestLevel("pickaxe", 3);
		}
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setLightOpacity(16);
		this.blockSoundType = SoundType.STONE;
		this.experience = dropsXP;
		this.harvestLevel = harvestLevel;
	}
	
	protected int getExperience(Random random) {
		if(experience) {
			if (harvestLevel == 0) {
				return MathHelper.getInt(random, 0, 2);
			} else if (harvestLevel == 1) {
				return MathHelper.getInt(random, 2, 5);
			} else if (harvestLevel == 2) {
				return MathHelper.getInt(random, 3, 7);
			} else {
				return harvestLevel == 3 ? MathHelper.getInt(random, 3, 7) : 0;
			}
		}
		return 0;
	}
	
	@Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int amount)
    {
		return amount == 0 ? this.getExperience(this.RANDOM) : 0;
    }

}
