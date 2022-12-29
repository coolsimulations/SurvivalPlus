package net.coolsimulations.SurvivalPlus.core.blocks;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.ItemLike;

public class BlockOnionCrop extends CropBlock{
	
	public BlockOnionCrop() {
		super(Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
		this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
	}

	@Override
	protected ItemLike getBaseSeedId() {
	      return SPItems.onion_seeds.get();
	}
	
	/**@Override
	protected IItemProvider getCropsItem() {
        return SPItems.raw_onion;
    }**/

}
