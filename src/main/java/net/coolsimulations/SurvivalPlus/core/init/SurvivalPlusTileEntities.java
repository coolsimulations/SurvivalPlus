package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntityGemStaff;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SurvivalPlusTileEntities {
	
	public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SPReference.MOD_ID);
	
	public static final RegistryObject<BlockEntityType<TileEntitySconce>> SCONCE = TILE_ENTITY_TYPES.register("sconce",
            () -> BlockEntityType.Builder.of(TileEntitySconce::new, SPBlocks.sconce.get()).build(null));
	
	public static final RegistryObject<BlockEntityType<TileEntityGemStaff>> GEM_STAFF = TILE_ENTITY_TYPES.register("gem_staff",
            () -> BlockEntityType.Builder.of(TileEntityGemStaff::new, SPBlocks.gem_staff.get()).build(null));

}
