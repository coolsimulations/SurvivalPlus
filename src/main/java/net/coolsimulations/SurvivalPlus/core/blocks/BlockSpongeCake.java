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
		super(Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL));
		this.registerDefaultState((this.stateDefinition.any()).setValue(BITES, 0));
	}

	public VoxelShape getShape(BlockState state, IBlockReader source, BlockPos pos, ISelectionContext context) {
		return CAKE_AABB[(Integer)state.getValue(BITES)];
	}

	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult ray) {
		if (!worldIn.isClientSide) {
			if(playerIn.getItemInHand(hand).getItem() == SPItems.paper_cup) {

				decrementBites(worldIn, state, pos);

				if(!playerIn.isCreative()) {

					ItemStack itemStackIn;

					if (playerIn.getOffhandItem().getItem() == SPItems.paper_cup)
					{
						itemStackIn = playerIn.getOffhandItem();
					}
					else
					{
						itemStackIn = playerIn.getMainHandItem();
					}

					if(itemStackIn.getCount() == 1) {
						if (ItemStack.isSame(playerIn.getOffhandItem(), itemStackIn))
						{
							playerIn.setItemInHand(Hand.OFF_HAND, new ItemStack(SPItems.sponge_cupcake));
						}
						else
						{
							playerIn.setItemInHand(Hand.MAIN_HAND, new ItemStack(SPItems.sponge_cupcake));
						}
					} else  if(itemStackIn.getCount() >= 2){
						itemStackIn.shrink(1);
						boolean flag = playerIn.inventory.add(new ItemStack(SPItems.sponge_cupcake));
						if(!flag) {
							playerIn.drop(new ItemStack(SPItems.sponge_cupcake), false);
						}

					}
				}
				return ActionResultType.SUCCESS;
			} else if(playerIn.getMainHandItem().getItem() != SPItems.paper_cup && playerIn.getOffhandItem().getItem() != SPItems.paper_cup) {
				return this.eat(worldIn, pos, state, playerIn);
			}
			return ActionResultType.CONSUME;

		} else {
			return ActionResultType.CONSUME;
		}
	}

	private ActionResultType eat(IWorld worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		if (!player.canEat(false)) {
			return ActionResultType.PASS;
		} else {
			player.awardStat(Stats.EAT_CAKE_SLICE);
			player.getFoodData().eat(2, 0.1F);
			decrementBites(worldIn, state, pos);

			return ActionResultType.SUCCESS;
		}
	}
	
	private void decrementBites(IWorld worldIn, BlockState state, BlockPos pos) {
		
		int bites = (Integer) state.getValue(BITES);
		
		if (bites < 7) {
			worldIn.setBlock(pos, (BlockState) state.setValue(BITES, bites + 1), 3);
		} else {
			worldIn.removeBlock(pos, false);
		}
	}

	public BlockState updateShape(BlockState state, Direction side, BlockState blockState, IWorld worldIn, BlockPos pos, BlockPos blockPos) {
		return side == Direction.DOWN && !state.canSurvive(worldIn, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, side, blockState, worldIn, pos, blockPos);
	}

	public boolean canSurvive(BlockState state, IWorldReader readerBase, BlockPos pos) {
		return readerBase.getBlockState(pos.below()).getMaterial().isSolid();
	}

	public IItemProvider getItemDropped(BlockState state, World worldIn, BlockPos pos, int amount) {
		return Items.AIR;
	}

	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> stateBuilder) {
		stateBuilder.add(BITES);
	}

	public int getAnalogOutputSignal(BlockState state, World worldIn, BlockPos pos) {
		return (8 - (Integer)state.getValue(BITES)) * 2;
	}

	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	public boolean isPathfindable(BlockState state, IBlockReader reader, BlockPos pos, PathType type) {
		return false;
	}

	static {
		BITES_0_7 = IntegerProperty.create("bites", 0, 7);
		BITES = BITES_0_7;
		CAKE_AABB = new VoxelShape[] {Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(2.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(4.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(6.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(10.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(12.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(14.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)};
	}
}