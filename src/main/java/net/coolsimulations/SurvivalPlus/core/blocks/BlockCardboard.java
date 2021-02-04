package net.coolsimulations.SurvivalPlus.core.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockCardboard extends Block{
		
		public BlockCardboard(MaterialColor colour) {
			super(FabricBlockSettings.of(Material.WOOD, colour).hardness(0.5F).resistance(2.5F).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 1).lightLevel(0));
			FlammableBlockRegistry.getDefaultInstance().add(this, 30, 60);
		}
		
}