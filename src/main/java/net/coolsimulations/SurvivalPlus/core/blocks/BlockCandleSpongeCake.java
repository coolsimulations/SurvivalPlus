package net.coolsimulations.SurvivalPlus.core.blocks;

import java.util.Map;
import java.util.function.Consumer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockCandleSpongeCake extends AbstractCandleBlock {
	public static final BooleanProperty LIT;
	protected static final float AABB_OFFSET = 1.0F;
	protected static final VoxelShape CAKE_AABB;
	protected static final VoxelShape CANDLE_AABB;
	protected static final VoxelShape AABB;
	private static final Map<Block, BlockCandleSpongeCake> BY_CANDLE;
	private static final Iterable<Vec3> PARTICLE_OFFSETS;

	public BlockCandleSpongeCake(Block block) {
		super(Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL).lightLevel((blockStatex) -> {
			if(blockStatex.getValue(LIT))
				return 3;
			else
				return 0;
		}));
		this.registerDefaultState((BlockState) ((BlockState) this.stateDefinition.any()).setValue(LIT, false));
		BY_CANDLE.put(block, this);
	}

	protected Iterable<Vec3> getParticleOffsets(BlockState state) {
		return PARTICLE_OFFSETS;
	}

	public VoxelShape getShape(BlockState state, BlockGetter source, BlockPos pos, CollisionContext context) {
		return AABB;
	}

	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult ray) {
		ItemStack itemStack = playerIn.getItemInHand(hand);
		
		if (!itemStack.is(Items.FLINT_AND_STEEL) && !itemStack.is(Items.FIRE_CHARGE)) {
			if (candleHit(ray) && playerIn.getItemInHand(hand).isEmpty() && (Boolean) state.getValue(LIT)) {
				extinguish(playerIn, state, worldIn, pos);
				return InteractionResult.sidedSuccess(worldIn.isClientSide);
			} else {
				InteractionResult interactionResult = BlockSpongeCake.cupcake(SPBlocks.sponge_cake.get().defaultBlockState(), worldIn, pos, playerIn, hand);
				if (interactionResult.consumesAction()) {
					dropResources(state, worldIn, pos);
				}

				return interactionResult;
			}
		} else {
			
			if(canLight(state)) {
				
				if(itemStack.is(Items.FIRE_CHARGE)) {
					worldIn.playSound((Player) null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, (worldIn.getRandom().nextFloat() - worldIn.getRandom().nextFloat()) * 0.2F + 1.0F);
				} else {
					worldIn.playSound(playerIn, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, worldIn.getRandom().nextFloat() * 0.4F + 0.8F);
				}
				worldIn.setBlockAndUpdate(pos, state.setValue(LIT, true));
				worldIn.gameEvent(playerIn, GameEvent.BLOCK_PLACE, pos);
				if(itemStack.is(Items.FIRE_CHARGE)) {
					itemStack.shrink(1);
				} else {
					itemStack.hurtAndBreak(1, (LivingEntity)playerIn, (Consumer)((playerx) -> {
						((LivingEntity) playerx).broadcastBreakEvent(hand);
					}));
				}
				
				return InteractionResult.sidedSuccess(worldIn.isClientSide);
			} else {
				
				return InteractionResult.PASS;
			}
		}
	}

	private static boolean candleHit(BlockHitResult ray) {
		return ray.getLocation().y - (double) ray.getBlockPos().getY() > 0.5D;
	}

	protected void createBlockStateDefinition(Builder<Block, BlockState> stateBuilder) {
		stateBuilder.add(new Property[]{LIT});
	}

	public ItemStack getCloneItemStack(BlockGetter reader, BlockPos pos, BlockState state) {
		return new ItemStack(SPBlocks.sponge_cake.get());
	}

	public BlockState updateShape(BlockState state, Direction side, BlockState blockState, LevelAccessor worldIn, BlockPos pos, BlockPos blockPos) {
		return side == Direction.DOWN && !state.canSurvive(worldIn, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, side, blockState, worldIn, pos, blockPos);
	}

	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.below()).getMaterial().isSolid();
	}

	public int getAnalogOutputSignal(BlockState state, Level worldIn, BlockPos pos) {
		return BlockSpongeCake.FULL_CAKE_SIGNAL;
	}

	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	public boolean isPathfindable(BlockState state, BlockGetter reader, BlockPos pos, PathComputationType type) {
		return false;
	}

	public static BlockState byCandle(Block block) {
		return ((BlockCandleSpongeCake) BY_CANDLE.get(block)).defaultBlockState();
	}

	public static boolean canLight(BlockState state) {
		return state.is(BlockTags.CANDLE_CAKES, blockStateBase -> (blockStateBase.hasProperty(LIT) && !state.getValue(LIT)));
	}

	static {
		LIT = AbstractCandleBlock.LIT;
		CAKE_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
		CANDLE_AABB = Block.box(7.0D, 8.0D, 7.0D, 9.0D, 14.0D, 9.0D);
		AABB = Shapes.or(CAKE_AABB, CANDLE_AABB);
		BY_CANDLE = Maps.newHashMap();
		PARTICLE_OFFSETS = ImmutableList.of(new Vec3(0.5D, 1.0D, 0.5D));
	}
}