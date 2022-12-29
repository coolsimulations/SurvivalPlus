package net.coolsimulations.SurvivalPlus.core.blocks.tileentity;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusTorcherino;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import torcherino.api.Tier;
import torcherino.api.TorcherinoAPI;
import torcherino.config.Config;
import torcherino.platform.NetworkUtils;

public class TileEntitySconce extends BlockEntity {

	private EnumTorch torch = EnumTorch.EMPTY;
	private boolean isLit = false;

	//Torcherino
	public static int randomTicks;
	private int xRange;
	private int yRange;
	private int zRange;
	private int speed;
	private int redstoneMode;
	private Iterable<BlockPos> area;
	private boolean active;
	private String uuid = "";

	public TileEntitySconce(BlockPos pos, BlockState state) {
		super(SurvivalPlusTileEntities.SCONCE, pos, state);
	}

	@Override
	public void load(CompoundTag compound)
	{
		super.load(compound);

		if (compound.contains("torch")) {
			EnumTorch torch = EnumTorch.byMetadata(compound.getInt("torch"));
			if (torch.isLoaded())
				this.torch = torch;
			else
				this.torch = EnumTorch.EMPTY;
		}

		if (compound.contains("lit"))
		{
			if (this.torch != EnumTorch.EMPTY)
				this.isLit = compound.getBoolean("lit");
		}

		if (this.torch.getSerializedName().contains("torcherino") && SPCompatibilityManager.isTorcherinoLoaded()) {
			xRange = compound.getInt("XRange");
			zRange = compound.getInt("ZRange");
			yRange = compound.getInt("YRange");
			speed = compound.getInt("Speed");
			redstoneMode = compound.getInt("RedstoneMode");
			active = compound.getBoolean("Active");
			uuid = compound.getString("Owner");

			area = BlockPos.betweenClosed(worldPosition.getX() - xRange, worldPosition.getY() - yRange, worldPosition.getZ() - zRange,
					worldPosition.getX() + xRange, worldPosition.getY() + yRange, worldPosition.getZ() + zRange);
		}
	}

	@Override
	protected void saveAdditional(CompoundTag compound)
	{
		super.saveAdditional(compound);
		compound.putInt("torch", this.torch.index);
		compound.putBoolean("lit", this.isLit);

		if (this.torch.getSerializedName().contains("torcherino") && SPCompatibilityManager.isTorcherinoLoaded()) {
			compound.putInt("XRange", xRange);
			compound.putInt("ZRange", zRange);
			compound.putInt("YRange", yRange);
			compound.putInt("Speed", speed);
			compound.putInt("RedstoneMode", redstoneMode);
			compound.putBoolean("Active", active);
			compound.putString("Owner", getOwner() == null ? "" : getOwner());
		}
	}

	@Override
	public CompoundTag getUpdateTag()
	{
		return this.saveWithoutMetadata();
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket()
	{
		return ClientboundBlockEntityDataPacket.create(this);
	}

	//GEM STAFF

	public static <T extends BlockEntity> void tick(Level world, BlockPos pos, BlockState state, T be) {
		if (world.getGameTime() % 80L == 0L)
		{
			if (!world.isClientSide() && be instanceof TileEntitySconce) {
				TileEntitySconce te = (TileEntitySconce) be;
				if (te.getTorch() == EnumTorch.GEM_STAFF_AMETHYST)
					TileEntityGemStaff.addEffectsToPlayers(world, pos, MobEffects.DIG_SPEED);
				else if (te.getTorch() == EnumTorch.GEM_STAFF_RUBY)
					TileEntityGemStaff.addEffectsToPlayers(world, pos, MobEffects.DAMAGE_BOOST);
				else if (te.getTorch() == EnumTorch.GEM_STAFF_PEARL)
					TileEntityGemStaff.addEffectsToPlayers(world, pos, MobEffects.WATER_BREATHING);
				else if (te.getTorch() == EnumTorch.GEM_STAFF_TOPAZ)
					TileEntityGemStaff.addEffectsToPlayers(world, pos, MobEffects.FIRE_RESISTANCE);
				else if (te.getTorch() == EnumTorch.GEM_STAFF_SAPPHIRE)
					TileEntityGemStaff.addEffectsToPlayers(world, pos, MobEffects.INVISIBILITY);
				else if (te.getTorch() == EnumTorch.GEM_STAFF_SPINEL)
					TileEntityGemStaff.addEffectsToPlayers(world, pos, MobEffects.REGENERATION);
			}
		}

		if (be instanceof TileEntitySconce) {
			TileEntitySconce te = (TileEntitySconce) be;
			if (te.getTorch().getSerializedName().contains("torcherino")) {
				if (te.active && te.speed != 0 && (te.xRange != 0 || te.yRange != 0 || te.zRange != 0)) {
					if (Config.INSTANCE.online_mode.equals("")
							|| NetworkUtils.getInstance().s_isPlayerOnline(te.getOwner())) {
						te.randomTicks = world.getGameRules().getInt(GameRules.RULE_RANDOMTICKING);
						te.area.forEach(te::tickBlock);
					}

				}
			}
		}
	}

	//TORCHERINO

	private boolean valueInRange(int value, int min, int max) {
		return value >= min && value <= max;
	}

	public ResourceLocation getTier() {
		if (getTorch() == EnumTorch.COMPRESSED_TORCHERINO)
			return new ResourceLocation(SPCompatibilityManager.TORCHERINO_MODID, "compressed");
		else if (getTorch() == EnumTorch.DOUBLE_COMPRESSED_TORCHERINO)
			return new ResourceLocation(SPCompatibilityManager.TORCHERINO_MODID, "double_compressed");
		else
			return new ResourceLocation(SPCompatibilityManager.TORCHERINO_MODID, "normal");
	}

	public boolean readClientData(int xRange, int zRange, int yRange, int speed, int redstoneMode) {
		Tier tier = TorcherinoAPI.INSTANCE.getTiers().get(getTier());
		if (this.valueInRange(xRange, 0, tier.xzRange()) &&
				this.valueInRange(zRange, 0, tier.xzRange()) &&
				this.valueInRange(yRange, 0, tier.yRange()) &&
				this.valueInRange(speed, 0, tier.maxSpeed()) &&
				this.valueInRange(redstoneMode, 0, 3)) {
			this.xRange = xRange;
			this.zRange = zRange;
			this.yRange = yRange;
			this.speed = speed;
			this.redstoneMode = redstoneMode;
			area = BlockPos.betweenClosed(worldPosition.getX() - xRange, worldPosition.getY() - yRange, worldPosition.getZ() - zRange,
					worldPosition.getX() + xRange, worldPosition.getY() + yRange, worldPosition.getZ() + zRange);
			this.getBlockState().neighborChanged(level, worldPosition, null, null, false);
			return true;
		}
		return false;
	}

	@Override
	public void setLevel(Level level) {
		super.setLevel(level);
		if (!level.isClientSide() && getTorch().getSerializedName().contains("torcherino")) {
			level.getServer().tell(new TickTask(level.getServer().getTickCount(), () -> getBlockState().neighborChanged(level, worldPosition, null, null, false)));
		}
	}

	private String getOwner() {
		return this.uuid;
	}

	public void setOwner(String s) {
		this.uuid = s;
	}

	private void tickBlock(BlockPos pos) {
		BlockState blockState = this.level.getBlockState(pos);
		Block block = blockState.getBlock();
		if (!TorcherinoAPI.INSTANCE.isBlockBlacklisted(block)) {
			if (this.level instanceof ServerLevel && block.isRandomlyTicking(blockState)) {
				RandomSource random = this.level.getRandom();
				if (random.nextInt(Mth.clamp(4096 / (this.speed * 4), 1, 4096)) < randomTicks) {
					blockState.randomTick((ServerLevel) this.level, pos, this.level.getRandom());
				}
			}

			if (block instanceof EntityBlock) {
				EntityBlock entityBlock = (EntityBlock) block;
				BlockEntity blockEntity = this.level.getBlockEntity(pos);
				if (blockEntity != null) {
					BlockEntityTicker<BlockEntity> ticker = (BlockEntityTicker<BlockEntity>) entityBlock.getTicker(this.level, blockState, blockEntity.getType());
					if (blockEntity.isRemoved()
							|| TorcherinoAPI.INSTANCE.isBlockEntityBlacklisted(blockEntity.getType())
							|| ticker == null) {
						return;
					}

					for (int i = 0; i < this.speed && !blockEntity.isRemoved(); ++i) {
						ticker.tick(this.level, pos, blockState, blockEntity);
					}
				}

			}
		}
	}

	public void setPoweredByRedstone(boolean powered) {
		switch (redstoneMode) {
		case 0 -> active = !powered;
		case 1 -> active = powered;
		case 2 -> active = true;
		case 3 -> active = false;
		}
	}

	public void openTorcherinoScreen(ServerPlayer player) {
		Component title = Component.translatable("block.torcherino.torcherino");
		if (getTorch() == EnumTorch.COMPRESSED_TORCHERINO)
			title = Component.translatable("block.torcherino.compressed_torcherino");
		else if (getTorch() == EnumTorch.DOUBLE_COMPRESSED_TORCHERINO)
			title = Component.translatable("block.torcherino.double_compressed_torcherino");
		SurvivalPlusTorcherino.s2c_openTorcherinoScreen(player, worldPosition, Component.translatable(getBlockState().getBlock().getDescriptionId()).append(": ").append(title), xRange, zRange, yRange, speed, redstoneMode);
	}

	//SCONE METHODS

	public EnumTorch getTorch()
	{
		return this.torch;
	}

	public void setTorch(EnumTorch torch)
	{
		this.torch = torch;
	}

	public boolean getLit()
	{
		return this.isLit;
	}

	public void setLit(boolean lit)
	{
		this.isLit = lit;
	}

	public enum EnumTorch implements StringRepresentable
	{
		EMPTY(0, "empty", true, null, 0, ItemStack.EMPTY, true, false, true),
		TORCH(1, "torch", true, SoundEvents.WOOD_PLACE, 14, new ItemStack(Blocks.TORCH), true, true, false),
		REDSTONE_TORCH_ON(2, "redstone_torch_on", true, SoundEvents.WOOD_PLACE, 7, new ItemStack(Blocks.REDSTONE_TORCH), true, true, false),
		REDSTONE_TORCH_OFF(3, "redstone_torch_off", true, SoundEvents.WOOD_PLACE, 0, new ItemStack(Blocks.REDSTONE_TORCH), false, false, false),
		SOUL_TORCH(4, "soul_torch", true, SoundEvents.WOOD_PLACE, 10, new ItemStack(Blocks.SOUL_TORCH), true, true, false),
		CANDLE(5, "candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.CANDLE), true, false, true),
		WHITE_CANDLE(6, "white_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.WHITE_CANDLE), true, false, true),
		LIGHT_GRAY_CANDLE(7, "light_gray_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.LIGHT_GRAY_CANDLE), true, false, true),
		GRAY_CANDLE(8, "gray_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.GRAY_CANDLE), true, false, true),
		BLACK_CANDLE(9, "black_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.BLACK_CANDLE), true, false, true),
		RED_CANDLE(10, "red_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.RED_CANDLE), true, false, true),
		ORANGE_CANDLE(11, "orange_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.ORANGE_CANDLE), true, false, true),
		YELLOW_CANDLE(12, "yellow_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.YELLOW_CANDLE), true, false, true),
		LIME_CANDLE(13, "lime_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.LIME_CANDLE), true, false, true),
		GREEN_CANDLE(14, "green_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.GREEN_CANDLE), true, false, true),
		LIGHT_BLUE_CANDLE(15, "light_blue_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.LIGHT_BLUE_CANDLE), true, false, true),
		CYAN_CANDLE(16, "cyan_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.CYAN_CANDLE), true, false, true),
		BLUE_CANDLE(17, "blue_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.BLUE_CANDLE), true, false, true),
		PURPLE_CANDLE(18, "purple_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.PURPLE_CANDLE), true, false, true),
		MAGENTA_CANDLE(19, "magenta_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.MAGENTA_CANDLE), true, false, true),
		PINK_CANDLE(20, "pink_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.PINK_CANDLE), true, false, true),
		BROWN_CANDLE(21, "brown_candle", true, SoundEvents.CANDLE_PLACE, 14, new ItemStack(Blocks.BROWN_CANDLE), true, false, true),
		GEM_STAFF(22, "gem_staff", true, SoundEvents.METAL_PLACE, 0, new ItemStack(SPBlocks.gem_staff), true, false, true),
		GEM_STAFF_AMETHYST(23, "gem_staff_amethyst", true, SoundEvents.AMETHYST_BLOCK_PLACE, 12, new ItemStack(SPBlocks.gem_staff), false, true, true),
		GEM_STAFF_RUBY(24, "gem_staff_ruby", true, SoundEvents.AMETHYST_BLOCK_PLACE, 12, new ItemStack(SPBlocks.gem_staff), false, true, true),
		GEM_STAFF_PEARL(25, "gem_staff_pearl", true, SoundEvents.AMETHYST_BLOCK_PLACE, 12, new ItemStack(SPBlocks.gem_staff), false, true, true),
		GEM_STAFF_TOPAZ(26, "gem_staff_topaz", true, SoundEvents.AMETHYST_BLOCK_PLACE, 12, new ItemStack(SPBlocks.gem_staff), false, true, true),
		GEM_STAFF_SAPPHIRE(27, "gem_staff_sapphire", true, SoundEvents.AMETHYST_BLOCK_PLACE, 12, new ItemStack(SPBlocks.gem_staff), false, true, true),
		GEM_STAFF_SPINEL(28, "gem_staff_spinel", true, SoundEvents.AMETHYST_BLOCK_PLACE, 12, new ItemStack(SPBlocks.gem_staff), false, true, true),
		TORCH_UNLIT(29, "torch_unlit", false, SoundEvents.WOOD_PLACE, 0, ItemStack.EMPTY, false, true, false), //Waiting for GC to Update
		GLOWSTONE_TORCH(30, "glowstone_torch", SPCompatibilityManager.isGCLoaded(), SoundEvents.WOOD_PLACE, 14, new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(SPCompatibilityManager.GCCORE_MODID, "glowstone_torch"))), true, true, true),
		AMBROSIUM_TORCH(31, "ambrosium_torch", SPCompatibilityManager.isAetherRebornLoaded(), SoundEvents.WOOD_PLACE, 15, new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(SPCompatibilityManager.AETHER_REBORN_MODID, "ambrosium_torch"))), true, true, false),
		TORCHERINO(32, "torcherino", SPCompatibilityManager.isTorcherinoLoaded(), SoundEvents.WOOD_PLACE, 15, new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(SPCompatibilityManager.TORCHERINO_MODID, "torcherino"))), true, true, false),
		COMPRESSED_TORCHERINO(33, "compressed_torcherino", SPCompatibilityManager.isTorcherinoLoaded(), SoundEvents.WOOD_PLACE, 15, new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(SPCompatibilityManager.TORCHERINO_MODID, "compressed_torcherino"))), true, true, false),
		DOUBLE_COMPRESSED_TORCHERINO(34, "double_compressed_torcherino", SPCompatibilityManager.isTorcherinoLoaded(), SoundEvents.WOOD_PLACE, 15, new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(SPCompatibilityManager.TORCHERINO_MODID, "double_compressed_torcherino"))), true, true, false);

		private static final EnumTorch[] META_LOOKUP = new EnumTorch[values().length];
		private final int index;
		private final String name;
		private final boolean isLoaded;
		private final SoundEvent sound;
		private final int light;
		private final ItemStack stack;
		private final boolean isPlaceable;
		private final boolean isLit;
		private final boolean isWaterlogged;

		private EnumTorch(int indexIn, String nameIn, boolean isLoadedIn, SoundEvent soundIn, int lightIn, ItemStack stackIn, boolean isPlaceableIn, boolean isLitIn, boolean isWaterloggedIn)
		{
			this.index = indexIn;
			this.name = nameIn;
			this.isLoaded = isLoadedIn;
			this.sound = soundIn;
			this.light = lightIn;
			this.stack = stackIn;
			this.isPlaceable = isPlaceableIn;	
			this.isLit = isLitIn;
			this.isWaterlogged = isWaterloggedIn;
		}

		public static EnumTorch byMetadata(int meta)
		{
			if (meta < 0 || meta >= META_LOOKUP.length)
			{
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		public boolean isLoaded() {
			return isLoaded;
		}

		public SoundEvent getSound() {
			return sound;
		}

		public int getLightLevel() {
			return light;
		}

		public ItemStack getItemStack() {
			return stack;
		}

		public boolean isPlaceable() {
			return isPlaceable;
		}

		public boolean startLit() {
			return isLit;
		}
		
		public boolean surviveWaterlogging() {
			return isWaterlogged;
		}

		@Override
		public String getSerializedName() {
			return this.name;
		}

		static
		{
			for (EnumTorch torch : values())
			{
				META_LOOKUP[torch.index] = torch;
			}
		}
	}
}
