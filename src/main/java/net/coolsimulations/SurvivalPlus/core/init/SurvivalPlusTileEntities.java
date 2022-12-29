package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntityGemStaff;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
public class SurvivalPlusTileEntities {
	
	public static BlockEntityType<TileEntitySconce> SCONCE;
	
	public static BlockEntityType<TileEntityGemStaff> GEM_STAFF;
	
	public static void init() {
		
		SCONCE = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(SPReference.MOD_ID, "sconce"),
				FabricBlockEntityTypeBuilder.create(TileEntitySconce::new, SPBlocks.sconce).build());
		
		GEM_STAFF = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(SPReference.MOD_ID, "gem_staff"),
				FabricBlockEntityTypeBuilder.create(TileEntityGemStaff::new, SPBlocks.gem_staff).build());
	}

}
