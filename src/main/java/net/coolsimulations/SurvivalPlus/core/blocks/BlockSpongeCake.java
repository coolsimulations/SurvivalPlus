package net.coolsimulations.SurvivalPlus.core.blocks;

import com.google.common.jimfs.PathType;

import net.coolsimulations.SurvivalPlus.api.SPItems;
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
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.CollisionView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class BlockSpongeCake extends Block
{
    public static final IntProperty BITES;
    protected static final VoxelShape[] CAKE_AABB;
    public static final IntProperty BITES_0_7;

    public BlockSpongeCake()
    {
    	super(FabricBlockSettings.of(Material.CAKE).strength(0.5F).sounds(BlockSoundGroup.WOOL));
        this.setDefaultState((this.stateManager.getDefaultState()).with(BITES, 0));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView source, BlockPos pos, EntityContext context) {
        return CAKE_AABB[(Integer)state.get(BITES)];
    }

    public ActionResult onUse(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockHitResult ray) {
		if (!worldIn.isClient) {
			if(playerIn.getStackInHand(hand).getItem() == SPItems.paper_cup) {

				decrementBites(worldIn, state, pos);

				if(!playerIn.isCreative()) {

					ItemStack itemStackIn;

					if (playerIn.getOffHandStack().getItem() == SPItems.paper_cup)
					{
						itemStackIn = playerIn.getOffHandStack();
					}
					else
					{
						itemStackIn = playerIn.getMainHandStack();
					}

					if(itemStackIn.getCount() == 1) {
						if (ItemStack.areItemsEqual(playerIn.getOffHandStack(), itemStackIn))
						{
							playerIn.setStackInHand(Hand.OFF_HAND, new ItemStack(SPItems.sponge_cupcake));
						}
						else
						{
							playerIn.setStackInHand(Hand.MAIN_HAND, new ItemStack(SPItems.sponge_cupcake));
						}
					} else  if(itemStackIn.getCount() >= 2){
						itemStackIn.decrement(1);
						boolean flag = playerIn.inventory.insertStack(new ItemStack(SPItems.sponge_cupcake));
						if(!flag) {
							playerIn.dropItem(new ItemStack(SPItems.sponge_cupcake), false);
						}

					}
				}
				return ActionResult.SUCCESS;
			} else if(playerIn.getMainHandStack().getItem() != SPItems.paper_cup && playerIn.getOffHandStack().getItem() != SPItems.paper_cup) {
				return this.tryEat(worldIn, pos, state, playerIn);
			}
			return ActionResult.PASS;

		} else {
			return ActionResult.PASS;
		}
	}

    private ActionResult tryEat(IWorld worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
           return ActionResult.PASS;
        } else {
           player.incrementStat(Stats.EAT_CAKE_SLICE);
           player.getHungerManager().add(2, 0.1F);
           decrementBites(worldIn, state, pos);

           return ActionResult.SUCCESS;
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
    	BITES_0_7 = IntProperty.of("bites", 0, 7);
        BITES = BITES_0_7;
        CAKE_AABB = new VoxelShape[] {Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(2.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(4.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(6.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(10.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(14.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)};
    }
}