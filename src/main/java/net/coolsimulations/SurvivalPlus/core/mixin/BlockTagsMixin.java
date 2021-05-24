package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.Block;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;

@Mixin(BlockTags.class)
public interface BlockTagsMixin {
	
	@Invoker("register")
	public static Tag.Identified<Block> register(String id){
		throw new AssertionError();
	};

}
