package net.coolsimulations.SurvivalPlus.core.blocks;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IItemProvider;

public class BlockOnionCrop extends CropsBlock{
	
	public BlockOnionCrop() {
		super(Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.CROP));
		this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
	}

	@Override
	protected IItemProvider getSeedsItem() {
	      return SPItems.onion_seeds;
	}
	
	/**@Override
	protected IItemProvider getCropsItem() {
        return SPItems.raw_onion;
    }**/

}
