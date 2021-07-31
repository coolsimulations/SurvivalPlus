package net.coolsimulations.SurvivalPlus.api.blocks;	

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class SPBlockMetal extends Block {

	public final Resource resource;

	/**
	 * @param metalTier accepts SPBlockMetal.Resouce
	 */

	public SPBlockMetal(MaterialColor colour, Resource resource) {
		super(FabricBlockSettings.of(Material.METAL, colour).requiresTool().hardness(resource.hardness).resistance(resource.resistance).breakByTool(FabricToolTags.PICKAXES, resource.harvestLevel).sounds(resource.getBlockSoundType()).luminance(0));
		this.resource = resource;
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
		public final Tiers itemTier;

		Resource(int harvestLevel, float hardness, float resistance, SoundType soundType, Tiers itemTier) {
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
