package net.coolsimulations.SurvivalPlus.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SPBlockMetal extends Block{
	
	/**
	 * @param metalTier only accepts 0-3, anything higher will revert to 3
	 */
	
	public SPBlockMetal(int metalTier) {
		super(Material.IRON);
		if(metalTier == 0) {
			this.setHardness(4.0F);
			this.setHarvestLevel("pickaxe", 1);
		}
		else if (metalTier == 1) {
			this.setHardness(4.5F);
			this.setHarvestLevel("pickaxe", 2);
		}
		else if (metalTier == 2) {
			this.setHardness(5.0F);
			this.setHarvestLevel("pickaxe", 2);
		}
		else if (metalTier >= 3) {
			this.setHardness(5.5F);
			this.setHarvestLevel("pickaxe", 3);
		}
		this.setResistance(10.0F);
		this.setLightOpacity(16);
		this.blockSoundType = SoundType.METAL;
	}

}
