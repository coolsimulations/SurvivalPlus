package net.coolsimulations.SurvivalPlus.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class SPBlockMetal extends Block{
	
	public final Resource resource;
	
	/**
	 * @param metalTier accepts SPBlockMetal.Resouce
	 */
	
	public SPBlockMetal(Resource resource) {
		super(Properties.create(Material.IRON).hardnessAndResistance(resource.hardness, resource.resistance).sound(resource.getBlockSoundType()));
		this.resource = resource;
	}
	
	@Override
	public ToolType getHarvestTool(IBlockState state) {
		return ToolType.PICKAXE;
	}
	
	@Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune)
    {
        return this;
    }
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return resource.harvestLevel;
	}
	
	@Override
	public int getLightValue(IBlockState p_getLightValue_1_) {
		
		return 0;
	}
	
	public enum Resource {
		TIER_0(1, 4.0F, 10.0F, SoundType.METAL, ItemTier.IRON),
		TIER_1(2, 4.5F, 10.0F, SoundType.METAL, ItemTier.IRON),
		TIER_2(2, 5.0F, 10.0F, SoundType.METAL, ItemTier.IRON),
		TIER_3(3, 5.5F, 10.0F, SoundType.METAL, ItemTier.DIAMOND);
		
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
