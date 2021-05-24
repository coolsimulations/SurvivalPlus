package net.coolsimulations.SurvivalPlus.api.blocks;

import java.util.Random;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SPBlockOre extends Block{

	public final Resource resource;
	public final Boolean experience;

	/**
	 * @param harvestLevel Harvest level:
	 *     Wood:    0
	 *     Stone:   1
	 *     Iron:    2
	 *     Diamond: 3
	 *     Gold:    0
	 *     Anything higher than 3 will revert to 3
	 */

	public SPBlockOre(Resource resource, Boolean dropsXP) {
		super(FabricBlockSettings.of(Material.STONE).requiresTool().hardness(resource.hardness).resistance(resource.resistance).breakByTool(FabricToolTags.PICKAXES, resource.harvestLevel).sounds(resource.getBlockSoundType()).luminance(0));
		this.resource = resource;
		this.experience = dropsXP;
	}

	protected int getExperience(Random random) {
		if(experience) {
			if (resource == Resource.TIER_0) {
				return MathHelper.nextInt(random, 0, 2);
			} else if (resource == Resource.TIER_1) {
				return MathHelper.nextInt(random, 2, 5);
			} else if (resource == Resource.TIER_2) {
				return MathHelper.nextInt(random, 3, 7);
			} else {
				return resource == Resource.TIER_3 ? MathHelper.nextInt(random, 3, 7) : 0;
			}
		}
		return 0;
	}

	@Override
	public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
		super.onStacksDropped(state, world, pos, stack);
		int i = this.getExperience(world.random);
		if (i > 0) {
			this.dropExperience(world, pos, i);
		}
	}

	public enum Resource {
		TIER_0(0, 3.0F, 5.0F, BlockSoundGroup.STONE, ToolMaterials.WOOD),
		TIER_1(1, 3.5F, 5.0F, BlockSoundGroup.STONE, ToolMaterials.STONE),
		TIER_2(2, 3.0F, 5.0F, BlockSoundGroup.STONE, ToolMaterials.IRON),
		TIER_3(3, 3.5F, 5.0F, BlockSoundGroup.STONE, ToolMaterials.DIAMOND);

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
