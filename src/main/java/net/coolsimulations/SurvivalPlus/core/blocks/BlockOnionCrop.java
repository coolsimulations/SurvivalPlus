package net.coolsimulations.SurvivalPlus.core.blocks;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.BlockSoundGroup;

public class BlockOnionCrop extends CropBlock{
	
	public BlockOnionCrop() {
		super(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
		this.setDefaultState(this.stateManager.getDefaultState().with(this.getAgeProperty(), Integer.valueOf(0)));
	}

	@Override
	protected ItemConvertible getSeedsItem() {
	      return SPItems.onion_seeds;
	}
	
	/**@Override
	protected IItemProvider getCropsItem() {
        return SPItems.raw_onion;
    }**/

}
