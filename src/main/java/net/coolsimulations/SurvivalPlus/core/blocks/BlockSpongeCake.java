package net.coolsimulations.SurvivalPlus.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReaderBase;
import net.minecraft.world.World;

public class BlockSpongeCake extends Block
{
    public static final IntegerProperty BITES;
    protected static final VoxelShape[] CAKE_AABB;
    public static final IntegerProperty BITES_0_7;

    public BlockSpongeCake()
    {
    	super(Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH));
        this.setDefaultState((this.stateContainer.getBaseState()).with(BITES, 0));
    }

    public VoxelShape getShape(IBlockState state, IBlockReader source, BlockPos pos) {
        return CAKE_AABB[(Integer)state.get(BITES)];
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            return this.eatCake(worldIn, pos, state, playerIn);
        } else {
            ItemStack itemstack = playerIn.getHeldItem(hand);
            return this.eatCake(worldIn, pos, state, playerIn) || itemstack.isEmpty();
        }
    }

    private boolean eatCake(IWorld worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        if (!player.canEat(false)) {
            return false;
        } else {
            player.addStat(StatList.EAT_CAKE_SLICE);
            player.getFoodStats().addStats(3, 0.2F);
            int bites = (Integer)state.get(BITES);
            if (bites < 7) {
                worldIn.setBlockState(pos, (IBlockState)state.with(BITES, bites + 1), 3);
            } else {
                worldIn.removeBlock(pos);
            }

            return true;
        }
    }

    public IBlockState updatePostPlacement(IBlockState state, EnumFacing side, IBlockState blockState, IWorld worldIn, BlockPos pos, BlockPos blockPos) {
        return side == EnumFacing.DOWN && !state.isValidPosition(worldIn, pos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(state, side, blockState, worldIn, pos, blockPos);
    }

    public boolean isValidPosition(IBlockState state, IWorldReaderBase readerBase, BlockPos pos) {
        return readerBase.getBlockState(pos.down()).getMaterial().isSolid();
    }

    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int amount) {
        return Items.AIR;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> stateBuilder) {
        stateBuilder.add(new IProperty[]{BITES});
    }

    public int getComparatorInputOverride(IBlockState state, World worldIn, BlockPos pos) {
        return (7 - (Integer)state.get(BITES)) * 2;
    }

    public boolean hasComparatorInputOverride(IBlockState state) {
        return true;
    }

    public BlockFaceShape getBlockFaceShape(IBlockReader reader, IBlockState state, BlockPos pos, EnumFacing side) {
        return BlockFaceShape.UNDEFINED;
    }

    public boolean allowsMovement(IBlockState state, IBlockReader reader, BlockPos pos, PathType type) {
        return false;
    }

    static {
    	BITES_0_7 = IntegerProperty.create("bites", 0, 7);
        BITES = BITES_0_7;
        CAKE_AABB = new VoxelShape[] {Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(2.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(10.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(14.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)};
    }
}