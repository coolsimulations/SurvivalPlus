package net.coolsimulations.SurvivalPlus.core.blocks;

import javax.annotation.Nullable;

import net.coolsimulations.SurvivalPlus.api.SPTags;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntityGemStaff;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.Tags;

public class BlockGemStaff extends Block implements EntityBlock, SimpleWaterloggedBlock {

	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	public static final EnumProperty<EnumGemHeld> GEM = EnumProperty.create("gem", EnumGemHeld.class);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	protected static final VoxelShape GEM_STAFF_LOWER = Shapes.or(Block.box(6.0D, 0.0D, 6.D, 10.0D, 1.0D, 10.0D), Block.box(7.0D, 1.0D, 7.0D, 9.0D, 16.0D, 9.0D));
	protected static final VoxelShape GEM_STAFF_UPPER = Shapes.or(Block.box(7.0D, 0.0D, 7.0D, 9.0D, 6.0D, 9.0D), Block.box(6.0D, 6.0D, 6.0D, 10.0D, 8.0D, 10.0D), Block.box(9.0D, 8.0D, 6.0D, 10.0D, 9.0D, 7.0D), Block.box(6.0D, 8.0D, 6.0D, 7.0D, 9.0, 7.0D), Block.box(9.0D, 8.0D, 9.0D, 10.0D, 9.0D, 10.0D), Block.box(6.0D, 8.0D, 9.0D, 7.0D, 9.0D, 10.0D));
	protected static final VoxelShape GEM_STAFF_UPPER_GEM = Shapes.or(GEM_STAFF_UPPER, Block.box(6.5D, 8.0D, 6.5D, 9.5D, 10.0D, 9.5D), Block.box(7.25D, 10.0D, 7.25D, 8.75D, 12.5D, 8.75D), Block.box(7.625D, 12.5D, 7.875D, 8.125D, 14.0D, 8.375D), Block.box(8.5D, 10.5D, 7.875D, 9.0D, 12.0D, 8.375), Block.box(7.675D, 10.0D, 8.425D, 8.925D, 10.75D, 8.925D), Block.box(7.0D, 10.0D, 8.5D, 7.5D, 11.5D, 9.0D), Block.box(7.125D, 10.0D, 7.125D, 8.375D, 10.5D, 7.625D));

	public BlockGemStaff() {
		super(Properties.of(Material.METAL).strength(3.5F, 3.7F).requiresCorrectToolForDrops().sound(SoundType.METAL));
		this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, false).setValue(GEM, EnumGemHeld.EMPTY));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
	{
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER)
			return GEM_STAFF_LOWER;
		else if (state.getValue(GEM) == EnumGemHeld.EMPTY)
			return GEM_STAFF_UPPER;
		else
			return GEM_STAFF_UPPER_GEM;
	}

	@Override
	public MaterialColor getMapColor(BlockState state, BlockGetter world, BlockPos pos, MaterialColor color) {
		return state.getValue(GEM).getColor();
	}

	@Override
	public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
		if (state.getValue(GEM) != EnumGemHeld.EMPTY)
			return 12;

		return 0;
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos fromPos) {
		DoubleBlockHalf doubleblockhalf = state.getValue(HALF);

		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		if (facing.getAxis() == Direction.Axis.Y && doubleblockhalf == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return facingState.is(this) && facingState.getValue(HALF) != doubleblockhalf ? state.setValue(GEM, facingState.getValue(GEM)).setValue(WATERLOGGED, state.getValue(WATERLOGGED)) : isWaterLogged(worldIn, pos) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
		} else {
			return doubleblockhalf == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(worldIn, pos) ? isWaterLogged(worldIn, pos) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, fromPos);
		}
	}

	@Override
	public PushReaction getPistonPushReaction(BlockState state)
	{
		return PushReaction.DESTROY;
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState blockstate = world.getBlockState(blockpos);
		return state.getValue(HALF) == DoubleBlockHalf.LOWER ? blockstate.isFaceSturdy(world, blockpos, Direction.UP) : blockstate.is(this);
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit)
	{
		ItemStack itemStackIn = playerIn.getItemInHand(hand);

		if(state.getValue(GEM) == EnumGemHeld.EMPTY) {

			InteractionResult success = InteractionResult.PASS;

			if(!success.consumesAction())
				success = checkGem(worldIn, pos, state, playerIn, itemStackIn, Tags.Items.GEMS_AMETHYST, EnumGemHeld.AMETHYST);
			if(!success.consumesAction())
				success = checkGem(worldIn, pos, state, playerIn, itemStackIn, SPTags.Items.SHARDS_RUBY, EnumGemHeld.RUBY);
			if(!success.consumesAction())
				success = checkGem(worldIn, pos, state, playerIn, itemStackIn, SPTags.Items.PEARLS, EnumGemHeld.PEARL);
			if(!success.consumesAction())
				success = checkGem(worldIn, pos, state, playerIn, itemStackIn, SPTags.Items.SHARDS_TOPAZ, EnumGemHeld.TOPAZ);
			if(!success.consumesAction())
				success = checkGem(worldIn, pos, state, playerIn, itemStackIn, SPTags.Items.SHARDS_SAPPHIRE, EnumGemHeld.SAPPHIRE);
			if(!success.consumesAction())
				success = checkGem(worldIn, pos, state, playerIn, itemStackIn, SPTags.Items.SHARDS_SPINEL, EnumGemHeld.SPINEL);

			state.updateShape(hit.getDirection(), state, worldIn, pos, pos);
			return success;
		} else {
			state.updateShape(hit.getDirection(), state, worldIn, pos, pos);
		}

		return InteractionResult.PASS;
	}

	protected InteractionResult checkGem(Level worldIn, BlockPos pos, BlockState state, Player playerIn, ItemStack stack, TagKey<Item> tag, EnumGemHeld gem) {

		if(stack.is(tag)) {
			if(!playerIn.isCreative())
				stack.shrink(1);
			worldIn.setBlock(pos, state.setValue(GEM, gem), 3);
			if (state.getValue(HALF) == DoubleBlockHalf.LOWER)
				worldIn.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER).setValue(GEM, gem).setValue(WATERLOGGED, isWaterLogged(worldIn, pos.above())), 3);
			else
				worldIn.setBlock(pos.below(), state.setValue(HALF, DoubleBlockHalf.LOWER).setValue(GEM, gem).setValue(WATERLOGGED, isWaterLogged(worldIn, pos.below())), 3);
			return InteractionResult.sidedSuccess(worldIn.isClientSide);
		}

		return InteractionResult.PASS;
	}

	@Override
	public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player player) {
		if (!worldIn.isClientSide && player.isCreative()) {
			DoublePlantBlock.preventCreativeDropFromBottomPart(worldIn, pos, state, player);
		}

		super.playerWillDestroy(worldIn, pos, state, player);
	}
	
	protected boolean isWaterLogged(LevelAccessor worldIn, BlockPos pos) {
		FluidState ifluidstate = worldIn.getFluidState(pos);
		return Boolean.valueOf(ifluidstate.getType() == Fluids.WATER);

	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockPos blockpos = context.getClickedPos();
		Level level = context.getLevel();
		if (blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, isWaterLogged(level, blockpos));
		} else {
			return null;
		}
	}

	@Override
	public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
		worldIn.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER).setValue(WATERLOGGED, isWaterLogged(worldIn, pos.above())), 3);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level worldIn, BlockState state, BlockEntityType<T> te) {
		return te == SurvivalPlusTileEntities.GEM_STAFF.get() ? TileEntityGemStaff::tick : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return SurvivalPlusTileEntities.GEM_STAFF.get().create(pos, state);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
		state.add(HALF, GEM, WATERLOGGED);
	}

	@Override
	public long getSeed(BlockState state, BlockPos pos) {
		return Mth.getSeed(pos.getX(), pos.below(state.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return (Boolean) state.getValue(WATERLOGGED)
				? Fluids.WATER.getSource(false)
						: super.getFluidState(state);
	}

	public static enum EnumGemHeld implements StringRepresentable
	{
		EMPTY("empty", MaterialColor.METAL),
		AMETHYST("amethyst", MaterialColor.COLOR_PURPLE),
		RUBY("ruby", MaterialColor.COLOR_RED),
		PEARL("pearl", MaterialColor.SNOW),
		TOPAZ("topaz", MaterialColor.COLOR_YELLOW),
		SAPPHIRE("sapphire", MaterialColor.COLOR_BLUE),
		SPINEL("spinel", MaterialColor.COLOR_BLACK);

		private final String name;
		private final MaterialColor color;

		private EnumGemHeld(String nameIn, MaterialColor colorIn) {
			this.name = nameIn;
			this.color = colorIn;
		}

		public String toString()
		{
			return this.getSerializedName();
		}

		public MaterialColor getColor() {
			return this.color;
		}

		public String getSerializedName()
		{
			return this.name;
		}
	}

}
