package net.coolsimulations.SurvivalPlus.core.blocks;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IItemProvider;

public class BlockOnionCrop extends BlockCrops{
	
	public BlockOnionCrop() {
		super(Properties.create(Material.PLANTS).doesNotBlockMovement().needsRandomTick().sound(SoundType.PLANT));
		this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
	}

	@Override
	protected IItemProvider getSeedsItem() {
	      return SPItems.onion_seeds;
	}
	
	@Override
	protected IItemProvider getCropsItem() {
        return SPItems.raw_onion;
    }

}
