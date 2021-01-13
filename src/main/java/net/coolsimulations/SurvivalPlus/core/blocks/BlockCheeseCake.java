package net.coolsimulations.SurvivalPlus.core.blocks;

import com.google.common.jimfs.PathType;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.CollisionView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class BlockCheeseCake extends Block
{
    public static final IntProperty BITES;
    protected static final VoxelShape[] CAKE_AABB;

    public BlockCheeseCake()
    {
    	super(FabricBlockSettings.of(Material.CAKE).strength(0.5F).sounds(BlockSoundGroup.WOOL));
        this.setDefaultState((this.stateManager.getDefaultState()).with(BITES, 0));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView source, BlockPos pos, EntityContext context) {
        return CAKE_AABB[(Integer)state.get(BITES)];
    }

    public boolean activate(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockHitResult ray) {
        if (!worldIn.isClient) {
            return this.tryEat(worldIn, pos, state, playerIn);
        } else {
            ItemStack itemstack = playerIn.getStackInHand(hand);
            return this.tryEat(worldIn, pos, state, playerIn) || itemstack.isEmpty();
        }
    }

    private boolean tryEat(IWorld worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return false;
        } else {
            player.incrementStat(Stats.EAT_CAKE_SLICE);
            player.getHungerManager().add(2, 0.1F);
            int bites = (Integer)state.get(BITES);
            if (bites < 6) {
                worldIn.setBlockState(pos, (BlockState)state.with(BITES, bites + 1), 3);
            } else {
                worldIn.removeBlock(pos, false);
            }

            return true;
        }
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction side, BlockState blockState, IWorld worldIn, BlockPos pos, BlockPos blockPos) {
        return side == Direction.DOWN && !state.canPlaceAt(worldIn, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, side, blockState, worldIn, pos, blockPos);
    }

    public boolean canPlaceAt(BlockState state, CollisionView reader, BlockPos pos) {
        return reader.getBlockState(pos.down()).getMaterial().isSolid();
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(BITES);
    }

    public int getComparatorOutput(BlockState state, World worldIn, BlockPos pos) {
        return (7 - (Integer)state.get(BITES)) * 2;
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public boolean canPlaceAtSide(BlockState state, BlockView reader, BlockPos pos, PathType type) {
        return false;
    }

    static {
        BITES = Properties.BITES;
        CAKE_AABB = new VoxelShape[]{Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.createCuboidShape(3.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.createCuboidShape(5.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.createCuboidShape(7.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.createCuboidShape(9.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.createCuboidShape(11.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.createCuboidShape(13.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D)};
    }
}