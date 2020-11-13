package net.coolsimulations.SurvivalPlus.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockState;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class SPBlockMetal extends Block{
	
	public final Resource resource;
	
	/**
	 * @param metalTier accepts SPBlockMetal.Resouce
	 */
	
	public SPBlockMetal(Resource resource) {
		super(Properties.create(Material.IRON).setRequiresTool().hardnessAndResistance(resource.hardness, resource.resistance).sound(resource.getBlockSoundType()).setLightLevel((p_235464_0_) -> {return 0;}));
		this.resource = resource;
	}
	
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}
	
	@Override
	public void spawnAdditionalDrops(BlockState state, ServerWorld worldIn, BlockPos pos, ItemStack stack) {
	      super.spawnAdditionalDrops(state, worldIn, pos, stack);
	}
	
	@Override
	public int getHarvestLevel(BlockState state) {
		return resource.harvestLevel;
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
