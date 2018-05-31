package net.coolsimulations.SurvivalPlus.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SPBlockOre extends Block{
	
	/**
	 * @param harvestLevel Harvest level:
     *     Wood:    0
     *     Stone:   1
     *     Iron:    2
     *     Diamond: 3
     *     Gold:    0
     *     Anything higher than 3 will revert to 3
	 */
	
	public SPBlockOre(int harvestLevel) {
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
	}

}
