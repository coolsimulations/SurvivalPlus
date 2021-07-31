package net.coolsimulations.SurvivalPlus.api.blocks;	

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.sound.BlockSoundGroup;

public class SPBlockMetal extends Block {

	public final Resource resource;
	public final Boolean beacon;

	/**
	 * @param metalTier accepts SPBlockMetal.Resouce
	 */

	public SPBlockMetal(MaterialColor colour, Resource resource, boolean isBeaconMetal) {
		super(FabricBlockSettings.of(Material.METAL, colour).hardness(resource.hardness).resistance(resource.resistance).breakByTool(FabricToolTags.PICKAXES, resource.harvestLevel).sounds(resource.getBlockSoundType()).lightLevel(0));
		this.resource = resource;
		this.beacon = isBeaconMetal;
	}

	public enum Resource {
		TIER_0(1, 5.0F, 6.0F, BlockSoundGroup.METAL, ToolMaterials.STONE),
		TIER_1(2, 5.0F, 6.0F, BlockSoundGroup.METAL, ToolMaterials.IRON),
		TIER_2(2, 5.0F, 6.0F, BlockSoundGroup.METAL, ToolMaterials.IRON),
		TIER_3(3, 5.0F, 6.0F, BlockSoundGroup.METAL, ToolMaterials.DIAMOND);

		public final float hardness;
		public final float resistance;
		private final BlockSoundGroup soundType;
		public final int harvestLevel;
		public final ToolMaterial itemTier;

		Resource(int harvestLevel, float hardness, float resistance, BlockSoundGroup soundType, ToolMaterial itemTier) {
			this.hardness = hardness;
			this.resistance = resistance;
			this.soundType = soundType;
			this.harvestLevel = harvestLevel;
			this.itemTier = itemTier;
		}

		public BlockSoundGroup getBlockSoundType() {
			return soundType;
		}

	}

}
