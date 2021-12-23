package net.coolsimulations.SurvivalPlus.core.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BlockCardboard extends Block {

	public BlockCardboard(MaterialColor colour) {
		super(FabricBlockSettings.of(Material.WOOD, colour).hardness(0.5F).resistance(2.5F).sounds(SoundType.WOOD).luminance(0));
		FlammableBlockRegistry.getDefaultInstance().add(this, 30, 60);
	}
	
	public BlockCardboard(Properties properties) {
		super(properties);
		FlammableBlockRegistry.getDefaultInstance().add(this, 30, 60);
	}

}