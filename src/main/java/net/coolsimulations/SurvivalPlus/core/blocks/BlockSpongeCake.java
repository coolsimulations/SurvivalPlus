package net.coolsimulations.SurvivalPlus.core.blocks;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockSpongeCake extends Block {
	public static final IntegerProperty BITES;
	protected static final VoxelShape[] CAKE_AABB;
	public static final IntegerProperty BITES_0_7;

	public BlockSpongeCake()
	{
		super(FabricBlockSettings.of(Material.CAKE).strength(0.5F).sounds(SoundType.WOOL));
		this.registerDefaultState((this.stateDefinition.any()).setValue(BITES, 0));
	}

	public VoxelShape getShape(BlockState state, BlockGetter source, BlockPos pos, CollisionContext context) {
		return CAKE_AABB[(Integer)state.getValue(BITES)];
	}

	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult ray) {
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
							playerIn.setItemInHand(InteractionHand.OFF_HAND, new ItemStack(SPItems.sponge_cupcake));
						}
						else
						{
							playerIn.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(SPItems.sponge_cupcake));
						}
					} else  if(itemStackIn.getCount() >= 2){
						itemStackIn.shrink(1);
						boolean flag = playerIn.inventory.add(new ItemStack(SPItems.sponge_cupcake));
						if(!flag) {
							playerIn.drop(new ItemStack(SPItems.sponge_cupcake), false);
						}

					}
				}
				return InteractionResult.SUCCESS;
			} else if(playerIn.getMainHandItem().getItem() != SPItems.paper_cup && playerIn.getOffhandItem().getItem() != SPItems.paper_cup) {
				return this.eat(worldIn, pos, state, playerIn);
			}
			return InteractionResult.CONSUME;

		} else {
			return InteractionResult.CONSUME;
		}
	}

	private InteractionResult eat(LevelAccessor world, BlockPos pos, BlockState state, Player player) {
		if (!player.canEat(false)) {
			return InteractionResult.PASS;
		} else {
			player.awardStat(Stats.EAT_CAKE_SLICE);
			player.getFoodData().eat(2, 0.1F);
			decrementBites(world, state, pos);

			return InteractionResult.SUCCESS;
		}
	}
	
	private void decrementBites(LevelAccessor worldIn, BlockState state, BlockPos pos) {

		int bites = (Integer)state.getValue(BITES);

		if (bites < 7) {
			worldIn.setBlock(pos, (BlockState)state.setValue(BITES, bites + 1), 3);
		} else {
			worldIn.removeBlock(pos, false);
		}
	}

	public BlockState updateShape(BlockState state, Direction side, BlockState blockState, LevelAccessor worldIn, BlockPos pos, BlockPos blockPos) {
		return side == Direction.DOWN && !state.canSurvive(worldIn, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, side, blockState, worldIn, pos, blockPos);
	}

	public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
		return reader.getBlockState(pos.below()).getMaterial().isSolid();
	}

	protected void createBlockStateDefinition(Builder<Block, BlockState> stateBuilder) {
		stateBuilder.add(BITES);
	}

	public int getAnalogOutputSignal(BlockState state, Level worldIn, BlockPos pos) {
		return (7 - (Integer)state.getValue(BITES)) * 2;
	}

	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	public boolean isPathfindable(BlockState state, BlockGetter reader, BlockPos pos, PathComputationType type) {
		return false;
	}

	static {
		BITES_0_7 = IntegerProperty.create("bites", 0, 7);
		BITES = BITES_0_7;
		CAKE_AABB = new VoxelShape[] {Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(2.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(4.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(6.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(10.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(12.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(14.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)};
	}
}