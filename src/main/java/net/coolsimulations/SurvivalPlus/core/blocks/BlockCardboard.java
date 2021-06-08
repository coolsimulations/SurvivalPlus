package net.coolsimulations.SurvivalPlus.core.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockCardboard extends Block {

	public BlockCardboard(MaterialColor colour) {
		super(FabricBlockSettings.of(Material.WOOD, colour).hardness(0.5F).resistance(2.5F).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 1).lightLevel(0));
		FireBlock fireblock = (FireBlock) Blocks.FIRE;
		fireblock.registerFlammableBlock(this, 30, 60);
	}

}