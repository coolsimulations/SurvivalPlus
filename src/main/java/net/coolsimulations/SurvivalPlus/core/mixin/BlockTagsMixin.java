package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;

@Mixin(BlockTags.class)
public interface BlockTagsMixin {
	
	@Invoker("bind")
	public static Tag.Named<Block> register(String id){
		throw new AssertionError();
	};

}
