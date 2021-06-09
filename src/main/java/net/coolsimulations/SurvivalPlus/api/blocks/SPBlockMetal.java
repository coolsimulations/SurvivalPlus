package net.coolsimulations.SurvivalPlus.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.BlockState;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class SPBlockMetal extends Block{

	public final Resource resource;
	public final Boolean beacon;

	/**
	 * @param metalTier accepts SPBlockMetal.Resouce
	 */

	public SPBlockMetal(MaterialColor colour, Resource resource, boolean isBeaconMetal) {
		super(Properties.create(Material.IRON, colour).hardnessAndResistance(resource.hardness, resource.resistance).sound(resource.getBlockSoundType()));
		this.resource = resource;
		this.beacon = isBeaconMetal;
	}

	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public void spawnAdditionalDrops(BlockState state, World world, BlockPos pos, ItemStack stack) {
		super.spawnAdditionalDrops(state, world, pos, stack);
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return resource.harvestLevel;
	}

	@Override
	public int getLightValue(BlockState p_getLightValue_1_) {

		return 0;
	}

	@Override
	public boolean isBeaconBase(BlockState state, IWorldReader world, BlockPos pos, BlockPos beacon)
	{
		return this.beacon;
	}


	public enum Resource {
		TIER_0(1, 4.0F, 10.0F, SoundType.METAL, ItemTier.STONE),
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
