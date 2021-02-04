package net.coolsimulations.SurvivalPlus.core.util;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.SpecificTool.BlockBase2;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class SurvivalPlusBlockus {
	
	public static void init() {
		
		SPBlocks.onion_crate = new BlockBase2("onion_crate", 2.5f, 2.5f, Material.SOLID_ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0);
	}

}
