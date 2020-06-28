package net.coolsimulations.SurvivalPlus.core.blocks;

import java.lang.reflect.Method;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class BlockCardboard extends Block{

	public BlockCardboard() {
		super(Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.5F).sound(SoundType.WOOD).func_235838_a_((p_235464_0_) -> {return 0;}));
		FireBlock fireblock = (FireBlock) Blocks.FIRE;
		try {
			Method setFireInfo = ObfuscationReflectionHelper.findMethod(fireblock.getClass(), "func_180686_a", Block.class, int.class, int.class);
			setFireInfo.invoke(fireblock, this, 30, 60);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@Override
	public void spawnAdditionalDrops(BlockState state, World world, BlockPos pos, ItemStack stack) {
		super.spawnAdditionalDrops(state, world, pos, stack);
	}

	@Override
	public int getHarvestLevel(BlockState state) {

		return 1;
	}

}