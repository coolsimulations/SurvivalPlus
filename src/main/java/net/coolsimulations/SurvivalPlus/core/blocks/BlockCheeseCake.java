package net.coolsimulations.SurvivalPlus.core.blocks;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockCheeseCake extends Block {
	public static final int MAX_BITES = 6;
	public static final IntegerProperty BITES;
	public static final int FULL_CAKE_SIGNAL;
	protected static final float AABB_OFFSET = 1.0F;
	protected static final float AABB_SIZE_PER_BITE = 2.0F;
	protected static final VoxelShape[] CAKE_AABB;

	public BlockCheeseCake() {
		super(Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL));
		this.registerDefaultState((BlockState) ((BlockState) this.stateDefinition.any()).setValue(BITES, 0));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
		return CAKE_AABB[(Integer) state.getValue(BITES)];
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult ray) {
		ItemStack itemStack = playerIn.getItemInHand(hand);
		Item item = itemStack.getItem();
		if (itemStack.is(ItemTags.CANDLES) && (Integer) state.getValue(BITES) == 0) {
			Block block = Block.byItem(item);
			if (block instanceof CandleBlock) {
				if (!playerIn.isCreative()) {
					itemStack.shrink(1);
				}

				worldIn.playSound((Player) null, pos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlockAndUpdate(pos, BlockCandleCheeseCake.byCandle(block));
				worldIn.gameEvent(playerIn, GameEvent.BLOCK_CHANGE, pos);
				playerIn.awardStat(Stats.ITEM_USED.get(item));
				return InteractionResult.SUCCESS;
			}
		}

		if (worldIn.isClientSide) {
			if (cupcake(state, worldIn, pos, playerIn, hand).consumesAction()) {
				return InteractionResult.SUCCESS;
			}

			if (itemStack.isEmpty()) {
				return InteractionResult.CONSUME;
			}
		}

		return cupcake(state, worldIn, pos, playerIn, hand);
	}
	
	protected static InteractionResult cupcake(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		if (!worldIn.isClientSide) {
			if(playerIn.getItemInHand(hand).getItem() == SPItems.paper_cup.get()) {

				decrementBites(worldIn, state, pos, playerIn);

				if(!playerIn.isCreative()) {

					ItemStack itemStackIn;

					if (playerIn.getOffhandItem().getItem() == SPItems.paper_cup.get())
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
							playerIn.setItemInHand(InteractionHand.OFF_HAND, new ItemStack(SPItems.cheese_cupcake.get()));
						}
						else
						{
							playerIn.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(SPItems.cheese_cupcake.get()));
						}
					} else  if(itemStackIn.getCount() >= 2){
						itemStackIn.shrink(1);
						boolean flag = playerIn.getInventory().add(new ItemStack(SPItems.cheese_cupcake.get()));
						if(!flag) {
							playerIn.drop(new ItemStack(SPItems.cheese_cupcake.get()), false);
						}

					}
				}
				return InteractionResult.SUCCESS;
			} else if(playerIn.getMainHandItem().getItem() != SPItems.paper_cup.get() && playerIn.getOffhandItem().getItem() != SPItems.paper_cup.get()) {
				return eat(worldIn, pos, state, playerIn);
			}
			return InteractionResult.CONSUME;

		} else {
			return InteractionResult.CONSUME;
		}
	}

	protected static InteractionResult eat(LevelAccessor world, BlockPos pos, BlockState state, Player player) {
		if (!player.canEat(false)) {
			return InteractionResult.PASS;
		} else {
			player.awardStat(Stats.EAT_CAKE_SLICE);
			player.getFoodData().eat(3, 0.2F);
			decrementBites(world, state, pos, player);

			return InteractionResult.SUCCESS;
		}
	}
	
	private static void decrementBites(LevelAccessor worldIn, BlockState state, BlockPos pos, Player player) {

		int bites = (Integer) state.getValue(BITES);
		worldIn.gameEvent(player, GameEvent.EAT, pos);
		
		if (bites < MAX_BITES) {
			worldIn.setBlock(pos, (BlockState) state.setValue(BITES, bites + 1), 3);
		} else {
			worldIn.removeBlock(pos, false);
			worldIn.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
		}
	}

	@Override
	public BlockState updateShape(BlockState state, Direction side, BlockState blockState, LevelAccessor worldIn, BlockPos pos, BlockPos blockPos) {
		return side == Direction.DOWN && !state.canSurvive(worldIn, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, side, blockState, worldIn, pos, blockPos);
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
		return reader.getBlockState(pos.below()).getMaterial().isSolid();
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> stateBuilder) {
		stateBuilder.add(new Property[]{BITES});
	}
	
	@Override
	public int getAnalogOutputSignal(BlockState state, Level worldIn, BlockPos pos) {
		return getOutputSignal((Integer) state.getValue(BITES));
	}

	public static int getOutputSignal(int i) {
		return (7 - i) * 2;
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public boolean isPathfindable(BlockState state, BlockGetter reader, BlockPos pos, PathComputationType type) {
		return false;
	}

	static {
		BITES = BlockStateProperties.BITES;
		FULL_CAKE_SIGNAL = getOutputSignal(0);
		CAKE_AABB = new VoxelShape[]{Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
				Block.box(3.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(5.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
				Block.box(7.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(9.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
				Block.box(11.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(13.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D)};
	}
}