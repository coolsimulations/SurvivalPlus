package net.coolsimulations.SurvivalPlus.core.blocks;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
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

    public VoxelShape getShape(BlockState state, IBlockReader source, BlockPos pos, ISelectionContext context) {
        return CAKE_AABB[(Integer)state.get(BITES)];
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult ray) {
		if (!worldIn.isRemote) {
			if(playerIn.getHeldItem(hand).getItem() == SPItems.paper_cup) {

				decrementBites(worldIn, state, pos);

				if(!playerIn.isCreative()) {

					ItemStack itemStackIn;

					if (playerIn.getHeldItemOffhand().getItem() == SPItems.paper_cup)
					{
						itemStackIn = playerIn.getHeldItemOffhand();
					}
					else
					{
						itemStackIn = playerIn.getHeldItemMainhand();
					}

					if(itemStackIn.getCount() == 1) {
						if (ItemStack.areItemStacksEqual(playerIn.getHeldItemOffhand(), itemStackIn))
						{
							playerIn.setHeldItem(Hand.OFF_HAND, new ItemStack(SPItems.sponge_cupcake));
						}
						else
						{
							playerIn.setHeldItem(Hand.MAIN_HAND, new ItemStack(SPItems.sponge_cupcake));
						}
					} else  if(itemStackIn.getCount() >= 2){
						itemStackIn.shrink(1);
						boolean flag = playerIn.inventory.addItemStackToInventory(new ItemStack(SPItems.sponge_cupcake));
						if(!flag) {
							playerIn.dropItem(new ItemStack(SPItems.sponge_cupcake), false);
						}

					}
				}
				return ActionResultType.SUCCESS;
			} else if(playerIn.getHeldItemMainhand().getItem() != SPItems.paper_cup && playerIn.getHeldItemOffhand().getItem() != SPItems.paper_cup) {
				return this.eatCake(worldIn, pos, state, playerIn);
			}
			return ActionResultType.CONSUME;

		} else {
			return ActionResultType.CONSUME;
		}
	}
    
    private ActionResultType eatCake(IWorld worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		if (!player.canEat(false)) {
			return ActionResultType.PASS;
		} else {
			player.addStat(Stats.EAT_CAKE_SLICE);
			player.getFoodStats().addStats(2, 0.1F);
			decrementBites(worldIn, state, pos);

			return ActionResultType.SUCCESS;
		}
	}
    
    private void decrementBites(IWorld worldIn, BlockState state, BlockPos pos) {

		int bites = (Integer)state.get(BITES);

		if (bites < 7) {
			worldIn.setBlockState(pos, (BlockState)state.with(BITES, bites + 1), 3);
		} else {
			worldIn.removeBlock(pos, false);
		}
	}

    public BlockState updatePostPlacement(BlockState state, Direction side, BlockState blockState, IWorld worldIn, BlockPos pos, BlockPos blockPos) {
        return side == Direction.DOWN && !state.isValidPosition(worldIn, pos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(state, side, blockState, worldIn, pos, blockPos);
    }

    public boolean isValidPosition(BlockState state, IWorldReader readerBase, BlockPos pos) {
        return readerBase.getBlockState(pos.down()).getMaterial().isSolid();
    }

    public IItemProvider getItemDropped(BlockState state, World worldIn, BlockPos pos, int amount) {
        return Items.AIR;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(new IProperty[]{BITES});
    }

    public int getComparatorInputOverride(BlockState state, World worldIn, BlockPos pos) {
        return (8 - (Integer)state.get(BITES)) * 2;
    }

    public boolean hasComparatorInputOverride(BlockState state) {
        return true;
    }

    public boolean allowsMovement(BlockState state, IBlockReader reader, BlockPos pos, PathType type) {
        return false;
    }

    static {
    	BITES_0_7 = IntegerProperty.create("bites", 0, 7);
        BITES = BITES_0_7;
        CAKE_AABB = new VoxelShape[] {Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(2.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(10.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(14.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)};
    }
}