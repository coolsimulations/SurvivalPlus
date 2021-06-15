package net.coolsimulations.SurvivalPlus.core.blocks;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IItemProvider;

public class BlockOnionCrop extends CropsBlock{
	
	public BlockOnionCrop() {
		super(Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
		this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
	}

	@Override
	protected IItemProvider getBaseSeedId() {
	      return SPItems.onion_seeds;
	}
	
	/**@Override
	protected IItemProvider getCropsItem() {
        return SPItems.raw_onion;
    }**/

}
