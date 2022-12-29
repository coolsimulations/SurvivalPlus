package net.coolsimulations.SurvivalPlus.api.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class SPBlockMetal extends Block {

	public final Resource resource;

	/**
	 * @param metalTier accepts SPBlockMetal.Resouce
	 */

	public SPBlockMetal(MaterialColor colour, Resource resource) {
		super(Properties.of(Material.METAL, colour).requiresCorrectToolForDrops().strength(resource.hardness, resource.resistance).sound(resource.getBlockSoundType()).lightLevel((p_235464_0_) -> {return 0;}));
		this.resource = resource;
	}

	@Override
	public void spawnAfterBreak(BlockState state, ServerLevel worldIn, BlockPos pos, ItemStack stack, boolean bl) {
		super.spawnAfterBreak(state, worldIn, pos, stack, bl);
	}

	public enum Resource {
		TIER_0(1, 5.0F, 6.0F, SoundType.METAL, Tiers.STONE),
		TIER_1(2, 5.0F, 6.0F, SoundType.METAL, Tiers.IRON),
		TIER_2(2, 5.0F, 6.0F, SoundType.METAL, Tiers.IRON),
		TIER_3(3, 5.0F, 6.0F, SoundType.METAL, Tiers.DIAMOND);

		public final float hardness;
		public final float resistance;
		private final SoundType soundType;
		public final int harvestLevel;
		public final Tier itemTier;

		Resource(int harvestLevel, float hardness, float resistance, SoundType soundType, Tier itemTier) {
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
