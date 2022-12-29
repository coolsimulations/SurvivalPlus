package net.coolsimulations.SurvivalPlus.core.blocks;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.jetbrains.annotations.Nullable;

import com.google.common.collect.Lists;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPTags;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockSconce;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce.EnumTorch;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTileEntities;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.id.paradiselost.client.rendering.particle.ParadiseLostParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ChunkHolder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import torcherino.TorcherinoImpl;
import torcherino.api.TorcherinoAPI;
import torcherino.config.Config;

public class BlockSconce extends SPBlockSconce implements EntityBlock, SimpleWaterloggedBlock {

	protected static final VoxelShape SCONCE_TORCH_NORTH_AABB = Block.box(6.0D, 1.810752D, 9.590768D, 10.0D, 13.121472D, 16.0D);
	protected static final VoxelShape SCONCE_TORCH_SOUTH_AABB = Block.box(6.0D, 1.810752D, 0.0D, 10.0D, 13.121472D, 6.409232D);
	protected static final VoxelShape SCONCE_TORCH_WEST_AABB = Block.box(9.590768D, 1.810752D, 6.0D, 16.0D, 13.121472D, 10.0D);
	protected static final VoxelShape SCONCE_TORCH_EAST_AABB = Block.box(0.0D, 1.810752D, 6.0D, 6.409232D, 13.121472D, 10.0D);

	protected static final VoxelShape SCONCE_STAFF_NORTH_AABB = Block.box(6.0D, 1.810752D, 9.590768D, 10.0D, 12.1976D, 16.0D);
	protected static final VoxelShape SCONCE_STAFF_SOUTH_AABB = Block.box(6.0D, 1.810752D, 0.0D, 10.0D, 12.1976D, 6.409232D);
	protected static final VoxelShape SCONCE_STAFF_WEST_AABB = Block.box(9.590768D, 1.810752D, 6.0D, 16.0D, 12.1976D, 10.0D);
	protected static final VoxelShape SCONCE_STAFF_EAST_AABB = Block.box(0.0D, 1.810752D, 6.0D, 6.409232D, 12.1976D, 10.0D);

	protected static final VoxelShape SCONCE_GEM_STAFF_NORTH_AABB = Block.box(6.0D, 1.810752D, 8.57024D, 10.0D, 15.653936D, 16.0D);
	protected static final VoxelShape SCONCE_GEM_STAFF_SOUTH_AABB = Block.box(6.0D, 1.810752D, 0.0D, 10.0D, 15.653936D, 7.257024D);
	protected static final VoxelShape SCONCE_GEM_STAFF_WEST_AABB = Block.box(8.57024D, 1.810752D, 6.0D, 16.0D, 15.653936D, 10.0D);
	protected static final VoxelShape SCONCE_GEM_STAFF_EAST_AABB = Block.box(0.0D, 1.810752D, 6.0D, 7.257024D, 15.653936D, 10.0D);

	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	private static final Map<BlockGetter, List<Toggle>> RECENT_TOGGLES = new WeakHashMap<>();

	public BlockSconce() {
		this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, false).setValue(WATERLOGGED, false));
		if(SPCompatibilityManager.isTorcherinoLoaded())
			TorcherinoAPI.INSTANCE.blacklistBlock(this);
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
	{
		BlockEntity tileentity = worldIn.getBlockEntity(pos);	
		if (tileentity instanceof TileEntitySconce) {
			TileEntitySconce te = (TileEntitySconce) tileentity;
			if (te.getTorch() == EnumTorch.EMPTY) {
				switch ((Direction)state.getValue(FACING))
				{
				case EAST:
					return SCONCE_EAST_AABB;
				case WEST:
					return SCONCE_WEST_AABB;
				case SOUTH:
					return SCONCE_SOUTH_AABB;
				case NORTH:
					return SCONCE_NORTH_AABB;
				default:
					return SCONCE_EAST_AABB;
				}
			} else {
				if (te.getTorch() == EnumTorch.GEM_STAFF) {
					switch ((Direction)state.getValue(FACING))
					{
					case EAST:
						return SCONCE_STAFF_EAST_AABB;
					case WEST:
						return SCONCE_STAFF_WEST_AABB;
					case SOUTH:
						return SCONCE_STAFF_SOUTH_AABB;
					case NORTH:
						return SCONCE_STAFF_NORTH_AABB;
					default:
						return SCONCE_STAFF_EAST_AABB;
					}
				} else if (te.getTorch() == EnumTorch.GEM_STAFF_AMETHYST || te.getTorch() == EnumTorch.GEM_STAFF_RUBY || te.getTorch() == EnumTorch.GEM_STAFF_PEARL || te.getTorch() == EnumTorch.GEM_STAFF_TOPAZ || te.getTorch() == EnumTorch.GEM_STAFF_SAPPHIRE || te.getTorch() == EnumTorch.GEM_STAFF_SPINEL) {
					switch ((Direction)state.getValue(FACING))
					{
					case EAST:
						return SCONCE_GEM_STAFF_EAST_AABB;
					case WEST:
						return SCONCE_GEM_STAFF_WEST_AABB;
					case SOUTH:
						return SCONCE_GEM_STAFF_SOUTH_AABB;
					case NORTH:
						return SCONCE_GEM_STAFF_NORTH_AABB;
					default:
						return SCONCE_GEM_STAFF_EAST_AABB;
					}
				} else {
					switch ((Direction)state.getValue(FACING))
					{
					case EAST:
						return SCONCE_TORCH_EAST_AABB;
					case WEST:
						return SCONCE_TORCH_WEST_AABB;
					case SOUTH:
						return SCONCE_TORCH_SOUTH_AABB;
					case NORTH:
						return SCONCE_TORCH_NORTH_AABB;
					default:
						return SCONCE_TORCH_EAST_AABB;
					}
				}
			}
		}
		return SCONCE_NORTH_AABB;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
	{
		if (context instanceof EntityCollisionContext) {
			Entity entity = ((EntityCollisionContext) context).getEntity();
			if (entity instanceof Projectile && entity.isOnFire()) 
				return super.getShape(state, worldIn, pos, context);
		}
		return Shapes.empty();
	}
	
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos fromPos) {
	      if (state.getValue(WATERLOGGED)) {
	    	  worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
	      }

	      return super.updateShape(state, facing, facingState, worldIn, pos, fromPos);
	   }

	@Environment(EnvType.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand)
	{
		Direction enumfacing = stateIn.getValue(FACING);
		Direction enumfacing1 = enumfacing.getOpposite();
		BlockEntity tileentity = worldIn.getBlockEntity(pos);

		if (tileentity instanceof TileEntitySconce) {
			TileEntitySconce te = (TileEntitySconce) tileentity;

			if (te.getTorch().isLoaded()) {
				if (te.getTorch() == EnumTorch.TORCH || te.getTorch() == EnumTorch.SOUL_TORCH || te.getTorch() == EnumTorch.AMBROSIUM_TORCH || te.getTorch().getSerializedName().contains("torcherino")) {
					double d0 = (double)pos.getX() + 0.5D;
					double d1 = (double)pos.getY() + 0.7D;
					double d2 = (double)pos.getZ() + 0.5D;

					ParticleOptions flame = ParticleTypes.FLAME;
					if (te.getTorch() == EnumTorch.SOUL_TORCH)
						flame = ParticleTypes.SOUL_FIRE_FLAME;
					else if (te.getTorch() == EnumTorch.AMBROSIUM_TORCH)
						flame = ParadiseLostParticles.AMBROSIUM_FLAME;
					if (te.getLit())
						worldIn.addParticle(ParticleTypes.SMOKE, d0 + 0.17D * enumfacing1.getStepX(), d1 + 0.22D, d2 + 0.17D * enumfacing1.getStepZ(), 0.0D, 0.0D, 0.0D);
					if (te.getLit() && !te.getTorch().getSerializedName().contains("torcherino"))
						worldIn.addParticle(flame, d0 + 0.17D * enumfacing1.getStepX(), d1 + 0.22D, d2 + 0.17D * enumfacing1.getStepZ(), 0.0D, 0.0D, 0.0D);
				} else if (te.getTorch() == EnumTorch.REDSTONE_TORCH_ON) {
					double d0 = (double)pos.getX() + 0.5D + (rand.nextDouble() - 0.5D) * 0.2D;
					double d1 = (double)pos.getY() + 0.7D + (rand.nextDouble() - 0.5D) * 0.2D;
					double d2 = (double)pos.getZ() + 0.5D + (rand.nextDouble() - 0.5D) * 0.2D;
					double d3 = 0.17D;

					d0 += 0.17D * (double)enumfacing1.getStepX();
					d1 += 0.22D;
					d2 += 0.17D * (double)enumfacing1.getStepZ();

					worldIn.addParticle(DustParticleOptions.REDSTONE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				} else if (te.getTorch().getSerializedName().contains("candle")) {
					double d0 = (double)pos.getX() + 0.5D;
					double d1 = (double)pos.getY() + 0.7D;
					double d2 = (double)pos.getZ() + 0.5D;
					float f = rand.nextFloat();

					if (te.getLit()) {
						if (f < 0.3F)
							worldIn.addParticle(ParticleTypes.SMOKE, d0 + 0.17D * enumfacing1.getStepX(), d1 + 0.22D, d2 + 0.145D * enumfacing1.getStepZ(), 0.0D, 0.1D, 0.0D);
						if (f < 0.17F)
							worldIn.playLocalSound(d0, pos.getY() + 0.5D, d2, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
						worldIn.addParticle(ParticleTypes.SMALL_FLAME, d0 + 0.17D * enumfacing1.getStepX(), d1 + 0.22D, d2 + 0.145D * enumfacing1.getStepZ(), 0.0D, 0.0D, 0.0D);
					}
				}
			}
		}
	}

	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand)
	{
		TileEntitySconce te = worldIn.getBlockEntity(pos) instanceof TileEntitySconce ? (TileEntitySconce)worldIn.getBlockEntity(pos) : null;
		if (te.getTorch() == EnumTorch.REDSTONE_TORCH_ON || te.getTorch() == EnumTorch.REDSTONE_TORCH_OFF) {
			boolean flag = this.hasNeighborSignal(worldIn, pos, state);
			List<Toggle> list = RECENT_TOGGLES.get(worldIn);

			while(list != null && !list.isEmpty() && worldIn.getGameTime() - (list.get(0)).when > 60L) {
				list.remove(0);
			}

			if (te.getTorch() == EnumTorch.REDSTONE_TORCH_ON) {
				if (flag) {
					updateTorch(te, worldIn, state, pos, EnumTorch.REDSTONE_TORCH_OFF, false, false);
					if (isToggledTooFrequently(worldIn, pos, true)) {
						worldIn.levelEvent(1502, pos, 0);
						worldIn.scheduleTick(pos, worldIn.getBlockState(pos).getBlock(), 160);
					}
				}
			} else if (!flag && !isToggledTooFrequently(worldIn, pos, false)) {
				updateTorch(te, worldIn, state, pos, EnumTorch.REDSTONE_TORCH_ON, false, false);
			}
		}
	}

	@Override
	public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean flag)
	{
		TileEntitySconce te = worldIn.getBlockEntity(pos) instanceof TileEntitySconce ? (TileEntitySconce)worldIn.getBlockEntity(pos) : null;
		if (te.getTorch() == EnumTorch.REDSTONE_TORCH_ON == this.hasNeighborSignal(worldIn, pos, state) && !worldIn.getBlockTicks().willTickThisTick(pos, this)) {
			worldIn.scheduleTick(pos, this, 2);
		} else if (te.getTorch().getSerializedName().contains("torcherino") && SPCompatibilityManager.isTorcherinoLoaded()) {
			te.setPoweredByRedstone(worldIn.hasSignal(pos.below(), Direction.UP));
		}

	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter world, BlockPos pos)
	{
		BlockEntity tileentity = world.getBlockEntity(pos);	
		if (tileentity instanceof TileEntitySconce) {
			TileEntitySconce te = (TileEntitySconce) tileentity;
			if (te.getLit())
				return te.getTorch().getLightLevel();
		}
		return super.getLightBlock(state, world, pos);
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> drops = super.getDrops(state, builder);
		TileEntitySconce te = builder.getParameter(LootContextParams.BLOCK_ENTITY) instanceof TileEntitySconce ? (TileEntitySconce) builder.getParameter(LootContextParams.BLOCK_ENTITY) : null;
		if (te != null) {
			if (te.getTorch().getItemStack() != ItemStack.EMPTY) {
				ItemStack drop = te.getTorch().getItemStack();
				if (getAdditionalDrop(te.getTorch()) != ItemStack.EMPTY)
					drops.add(getAdditionalDrop(te.getTorch()));
				drops.add(drop);
			}
		}

		return drops;
	}

	public ItemStack getAdditionalDrop(EnumTorch torch) {

		if (torch == EnumTorch.GEM_STAFF_AMETHYST)
			return new ItemStack(Items.AMETHYST_SHARD);
		else if (torch == EnumTorch.GEM_STAFF_RUBY)
			return new ItemStack(SPItems.ruby_shard);
		else if (torch == EnumTorch.GEM_STAFF_PEARL)
			return new ItemStack(SPItems.pearl);
		else if (torch == EnumTorch.GEM_STAFF_TOPAZ)
			return new ItemStack(SPItems.topaz_shard);
		else if (torch == EnumTorch.GEM_STAFF_SAPPHIRE)
			return new ItemStack(SPItems.sapphire_shard);
		else if (torch == EnumTorch.GEM_STAFF_SPINEL)
			return new ItemStack(SPItems.spinel_shard);

		return ItemStack.EMPTY;
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit)
	{
		BlockEntity tileentity = worldIn.getBlockEntity(pos);	
		ItemStack itemStackIn = playerIn.getItemInHand(hand);
		Item item = itemStackIn.getItem();

		if (tileentity instanceof TileEntitySconce && playerIn.getAbilities().mayBuild) {
			TileEntitySconce te = (TileEntitySconce) tileentity;
			InteractionResult success = InteractionResult.PASS;
			if (te.getTorch() == EnumTorch.EMPTY) {

				for (EnumTorch torch : EnumTorch.values()) {
					if (torch != EnumTorch.EMPTY && torch.isLoaded() && torch.isPlaceable() && (state.getValue(WATERLOGGED) ? torch.surviveWaterlogging() : true)) {
						if(!success.consumesAction())
							success = setTorch(te, worldIn, state, playerIn, hand, pos, torch);
						else
							break;
					}
				}

				return success;
			} else if (te.getTorch().getSerializedName().contains("candle")) {

				if(!success.consumesAction() && !te.getLit() && !state.getValue(WATERLOGGED))
					success = checkIgnite(te, worldIn, pos, state, playerIn, hand, itemStackIn);
				else if (!success.consumesAction() && te.getLit() && itemStackIn.isEmpty())
					success = extinguish(te, worldIn, pos, state, playerIn);

				return success;
			} else if (te.getTorch() == EnumTorch.GEM_STAFF) {

				if(!success.consumesAction())
					success = checkGem(te, worldIn, pos, state, playerIn, itemStackIn, SPTags.Items.SHARDS_AMETHYST, EnumTorch.GEM_STAFF_AMETHYST);
				if(!success.consumesAction())
					success = checkGem(te, worldIn, pos, state, playerIn, itemStackIn, SPTags.Items.SHARDS_RUBY, EnumTorch.GEM_STAFF_RUBY);
				if(!success.consumesAction())
					success = checkGem(te, worldIn, pos, state, playerIn, itemStackIn, SPTags.Items.PEARLS, EnumTorch.GEM_STAFF_PEARL);
				if(!success.consumesAction())
					success = checkGem(te, worldIn, pos, state, playerIn, itemStackIn, SPTags.Items.SHARDS_TOPAZ, EnumTorch.GEM_STAFF_TOPAZ);
				if(!success.consumesAction())
					success = checkGem(te, worldIn, pos, state, playerIn, itemStackIn, SPTags.Items.SHARDS_SAPPHIRE, EnumTorch.GEM_STAFF_SAPPHIRE);
				if(!success.consumesAction())
					success = checkGem(te, worldIn, pos, state, playerIn, itemStackIn, SPTags.Items.SHARDS_SPINEL, EnumTorch.GEM_STAFF_SPINEL);

				return success;
			} else if (!worldIn.isClientSide && hand != InteractionHand.OFF_HAND && te.getTorch().getSerializedName().contains("torcherino") && SPCompatibilityManager.isTorcherinoLoaded()) {
				te.openTorcherinoScreen((ServerPlayer) playerIn);
				return InteractionResult.SUCCESS;
			}
		}

		return InteractionResult.PASS;
	}

	@Override
	public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean willHarvest)
	{
		super.onRemove(state, worldIn, pos, newState, willHarvest);
		if (!willHarvest) {
			for(Direction direction : Direction.values()) {
				worldIn.updateNeighborsAt(pos.relative(direction), this);
			}
		}
	}

	protected InteractionResult setTorch(TileEntitySconce te, Level worldIn, BlockState state, Player playerIn, InteractionHand hand, BlockPos pos, EnumTorch torch) {
		ItemStack itemStackIn = playerIn.getItemInHand(hand);
		Item item = itemStackIn.getItem();
		if((item == torch.getItemStack().getItem() && (torch.getItemStack().getDamageValue() != 0 ? itemStackIn.getDamageValue() == torch.getItemStack().getDamageValue() : true)) && torch.getItemStack() != ItemStack.EMPTY) {
			if(!playerIn.isCreative())
				itemStackIn.shrink(1);
			updateTorch(te, worldIn, state, playerIn, pos, torch, true, false);
			return InteractionResult.sidedSuccess(worldIn.isClientSide);
		}

		return InteractionResult.PASS;
	}

	public void updateTorch(TileEntitySconce te, Level worldIn, BlockState state, BlockPos pos, EnumTorch torch, boolean doSound, boolean keepLit) {
		updateTorch(te, worldIn, state, null, pos, torch, keepLit, keepLit);
	}

	public void updateTorch(TileEntitySconce te, Level worldIn, BlockState state, @Nullable Player playerIn, BlockPos pos, EnumTorch torch, boolean doSound, boolean keepLit) {
		if (doSound)
			worldIn.playSound(null, pos, torch.getSound(), SoundSource.BLOCKS, 1.0F, worldIn.getRandom().nextFloat() * 0.4F + 0.8F);
		if (te.getTorch() != torch)
			te.setTorch(torch);
		if(!keepLit)
			te.setLit(torch.startLit());
		if (torch == EnumTorch.REDSTONE_TORCH_ON) {
			worldIn.setBlock(pos, state.setValue(FACING, state.getValue(FACING)).setValue(POWERED, true).setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
			for(Direction direction : Direction.values())
			{
				worldIn.updateNeighborsAt(pos.relative(direction), this);
			}
		} else if (state.getValue(POWERED)) {
			worldIn.setBlock(pos, state.setValue(FACING, state.getValue(FACING)).setValue(POWERED, false).setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
		}
		if (te.getTorch().getSerializedName().contains("torcherino") && SPCompatibilityManager.isTorcherinoLoaded()) {
			if (!Config.INSTANCE.online_mode.equals("")) {
				te.setOwner(playerIn == null ? "" : playerIn.getStringUUID());
			}
			if (Config.INSTANCE.log_placement) {
				String prefix = playerIn == null ? "Something" : playerIn.getDisplayName().getString() + "(" + playerIn.getStringUUID() + ")";
				TorcherinoImpl.LOGGER.info("[Torcherino] {} placed a {} at {}, {}, {}.", prefix, BuiltInRegistries.BLOCK.getKey(state.getBlock()), pos.getX(), pos.getY(), pos.getZ());
			}
			te.setPoweredByRedstone(worldIn.hasSignal(pos.below(), Direction.UP));
		}
		BlockState blockstate = worldIn.getBlockState(pos);
		worldIn.setBlocksDirty(pos, blockstate, blockstate);
		if (!worldIn.isClientSide || (worldIn.isClientSide || ((LevelChunk) worldIn.getChunk(pos)).getFullStatus() != null && ((LevelChunk) worldIn.getChunk(pos)).getFullStatus().isOrAfter(ChunkHolder.FullChunkStatus.TICKING)))
			worldIn.sendBlockUpdated(pos, blockstate, blockstate, 3);
		worldIn.setBlockAndUpdate(pos, blockstate);
		if (!worldIn.isClientSide && blockstate.hasAnalogOutputSignal())
			worldIn.updateNeighbourForOutputSignal(pos, blockstate.getBlock());
		blockstate.updateIndirectNeighbourShapes(worldIn, pos, 2, 511);
		blockstate.updateNeighbourShapes(worldIn, pos, 511);
		worldIn.onBlockStateChange(pos, blockstate, blockstate);
		worldIn.getLightEngine().checkBlock(pos);
	}

	@Override
	public boolean placeLiquid(LevelAccessor worldIn, BlockPos pos, BlockState state, FluidState fluid) {
		boolean success = SimpleWaterloggedBlock.super.placeLiquid(worldIn, pos, state, fluid);
		TileEntitySconce te = worldIn.getBlockEntity(pos) instanceof TileEntitySconce ? (TileEntitySconce)worldIn.getBlockEntity(pos) : null;

		if (worldIn instanceof ServerLevel && success && !te.getTorch().surviveWaterlogging()) {
			popResource((ServerLevel) worldIn, pos, te.getTorch().getItemStack());
			if (getAdditionalDrop(te.getTorch()) != ItemStack.EMPTY)
				popResource((ServerLevel) worldIn, pos, getAdditionalDrop(te.getTorch()));
			updateTorch(te, (ServerLevel) worldIn, worldIn.getBlockState(pos), pos, EnumTorch.EMPTY, false, false);
		} else if (worldIn instanceof ServerLevel && te.getTorch().getSerializedName().contains("candle")) {
			extinguish(te, (ServerLevel) worldIn, pos, state, null);
		}

		return success;
	}
	
	protected boolean isWaterLogged(LevelAccessor worldIn, BlockPos pos) {
		FluidState ifluidstate = worldIn.getFluidState(pos);
		return Boolean.valueOf(ifluidstate.getType() == Fluids.WATER);

	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state != null)
			state = state.setValue(WATERLOGGED, isWaterLogged(context.getLevel(), context.getClickedPos()));
		return state;
	}

	//REDSTONE TORCH

	@Override
	public boolean isSignalSource(BlockState state)
	{
		return state.getValue(POWERED);
	}

	private boolean isToggledTooFrequently(Level worldIn, BlockPos pos, boolean turnoff) {
		List<Toggle> list = RECENT_TOGGLES.computeIfAbsent(worldIn, (p_55680_) -> {
			return Lists.newArrayList();
		});
		if (turnoff) {
			list.add(new Toggle(pos.immutable(), worldIn.getGameTime()));
		}

		int i = 0;

		for(int j = 0; j < list.size(); ++j) {
			Toggle redstonetorchblock$toggle = list.get(j);
			if (redstonetorchblock$toggle.pos.equals(pos)) {
				++i;
				if (i >= 8) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public int getSignal(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
		TileEntitySconce te = world.getBlockEntity(pos) instanceof TileEntitySconce ? (TileEntitySconce)world.getBlockEntity(pos) : null;
		return te.getTorch() == EnumTorch.REDSTONE_TORCH_ON && state.getValue(FACING) != side ? 15 : 0;
	}

	protected boolean hasNeighborSignal(Level worldIn, BlockPos pos, BlockState state) {
		Direction direction = state.getValue(FACING).getOpposite();
		return worldIn.hasSignal(pos.relative(direction), direction);
	}

	@Override
	public int getDirectSignal(BlockState state, BlockGetter worldIn, BlockPos pos, Direction facing) {
		return facing == Direction.DOWN ? state.getSignal(worldIn, pos, facing) : 0;
	}

	//CANDLE

	@Override
	public void onProjectileHit(Level world, BlockState state, BlockHitResult hit, Projectile projectile) {
		TileEntitySconce te = world.getBlockEntity(hit.getBlockPos()) instanceof TileEntitySconce ? (TileEntitySconce)world.getBlockEntity(hit.getBlockPos()) : null;
		if (projectile.isOnFire() && !te.getLit() && te.getTorch().getSerializedName().contains("candle")) {
			te.setLit(true);
			updateTorch(te, world, state, hit.getBlockPos(), te.getTorch(), false, true);
		}
	}

	protected InteractionResult checkIgnite(TileEntitySconce te, Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand handIn, ItemStack stack) {
		if(ItemStack.isSame(stack, new ItemStack(Items.FLINT_AND_STEEL)) || ItemStack.isSame(stack, new ItemStack(Items.FIRE_CHARGE))) {
			if(!playerIn.isCreative())
				if (ItemStack.isSame(stack, new ItemStack(Items.FIRE_CHARGE)))
					stack.shrink(1);
				else
					stack.hurtAndBreak(1, playerIn, (p_150686_) -> {
						p_150686_.broadcastBreakEvent(handIn);
					});
			if (ItemStack.isSame(stack, new ItemStack(Items.FIRE_CHARGE)))
				worldIn.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, (worldIn.getRandom().nextFloat() - worldIn.getRandom().nextFloat()) * 0.2F + 1.0F);
			else
				worldIn.playSound(playerIn, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, worldIn.getRandom().nextFloat() * 0.4F + 0.8F);
			te.setLit(true);
			updateTorch(te, worldIn, state, pos, te.getTorch(), false, true);
			return InteractionResult.sidedSuccess(worldIn.isClientSide);
		}
		return InteractionResult.PASS;
	}

	//GEM STAFF

	protected InteractionResult checkGem(TileEntitySconce te, Level worldIn, BlockPos pos, BlockState state, Player playerIn, ItemStack stack, TagKey<Item> tag, EnumTorch gem) {

		if(stack.is(tag)) {
			if(!playerIn.isCreative())
				stack.shrink(1);
			updateTorch(te, worldIn, state, pos, gem, true, false);
			return InteractionResult.sidedSuccess(worldIn.isClientSide);
		}

		return InteractionResult.PASS;
	}

	protected InteractionResult extinguish(TileEntitySconce te, Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		updateTorch(te, worldIn, state, pos, te.getTorch(), false, false);
		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.7D;
		double d2 = (double)pos.getZ() + 0.5D;
		Direction enumfacing1 = state.getValue(FACING).getOpposite();
		worldIn.addParticle(ParticleTypes.SMOKE, d0 + 0.17D * enumfacing1.getStepX(), d1 + 0.22D, d2 + 0.145D * enumfacing1.getStepZ(), 0.0D, 0.1D, 0.0D);
		worldIn.playSound(null, pos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
		worldIn.gameEvent(playerIn, GameEvent.BLOCK_CHANGE, pos);
		return InteractionResult.sidedSuccess(worldIn.isClientSide);
	}

	//TILE ENTITY

	@Override
	public RenderShape getRenderShape(BlockState state)
	{
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level worldIn, BlockState state, BlockEntityType<T> te) {
		return te == SurvivalPlusTileEntities.SCONCE ? TileEntitySconce::tick : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return SurvivalPlusTileEntities.SCONCE.create(pos, state);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
		state.add(FACING, POWERED, WATERLOGGED);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return (Boolean) state.getValue(WATERLOGGED)
				? Fluids.WATER.getSource(false)
						: super.getFluidState(state);
	}

	static class Toggle {
		final BlockPos pos;
		final long when;

		public Toggle(BlockPos p_55734_, long p_55735_) {
			this.pos = p_55734_;
			this.when = p_55735_;
		}
	}
}
