package net.coolsimulations.SurvivalPlus.api.blocks;

import java.util.List;

import com.google.common.collect.ImmutableList;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BuddingAmethystBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SPBlockCrystalBudding extends BuddingAmethystBlock {
	
	private static final Direction[] DIRECTIONS = Direction.values();
	
	private final Block small;
    private final Block medium;
    private final Block large;
    private final Block cluster;

	public SPBlockCrystalBudding(Properties properties, List<AmethystClusterBlock> clusters) {
		super(properties);
		if (clusters.size() > 4) {
            for(int i = 4; i < clusters.size(); i++) {
            	clusters.remove(i);
            }
        } else if (clusters.size() < 4){
        	throw new IllegalArgumentException("Crystals should have 4 states!");
        }
        this.small = clusters.get(0);
        this.medium = clusters.get(1);
        this.large = clusters.get(2);
        this.cluster = clusters.get(3);
	}
	
	@Override
	public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource random) {
		if (random.nextInt(5) == 0) {
			Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
			BlockPos blockPos2 = blockPos.relative(direction);
			BlockState blockState2 = serverLevel.getBlockState(blockPos2);
			Block block = null;
			if (canClusterGrowAtState(blockState2)) {
				block = small;
			} else if (blockState2.is(small)
					&& blockState2.getValue(AmethystClusterBlock.FACING) == direction) {
				block = medium;
			} else if (blockState2.is(medium)
					&& blockState2.getValue(AmethystClusterBlock.FACING) == direction) {
				block = large;
			} else if (blockState2.is(large)
					&& blockState2.getValue(AmethystClusterBlock.FACING) == direction) {
				block = cluster;
			}

			if (block != null) {
				BlockState blockState3 = (BlockState) ((BlockState) block.defaultBlockState()
						.setValue(AmethystClusterBlock.FACING, direction)).setValue(AmethystClusterBlock.WATERLOGGED,
								blockState2.getFluidState().getType() == Fluids.WATER);
				serverLevel.setBlockAndUpdate(blockPos2, blockState3);
			}

		}
	}
	
	public List<BlockState> getStates() {
        return ImmutableList.of(small.defaultBlockState(), medium.defaultBlockState(), large.defaultBlockState(), cluster.defaultBlockState());
    }

}
