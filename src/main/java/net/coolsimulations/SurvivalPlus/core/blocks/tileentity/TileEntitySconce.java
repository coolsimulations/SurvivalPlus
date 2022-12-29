package net.coolsimulations.SurvivalPlus.core.blocks.tileentity;

import java.util.Random;

import com.sci.torcherino.TorcherinoRegistry;

import moze_intel.projecte.utils.WorldHelper;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.core.blocks.BlockSconce;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;

public class TileEntitySconce extends TileEntity implements ITickable {

	private EnumTorch torch = EnumTorch.EMPTY;
	private boolean isLit = false;

	//Torcherino
	private static final String[] MODES = new String[]{"Stopped", "Area: 3x3x3", "Area: 5x3x5", "Area: 7x3x7", "Area: 9x3x9"};
	private static final int SPEEDS = 4;
	private boolean poweredByRedstone;
	private byte speed;
	private byte mode;
	private byte cachedMode = -1;
	private Random rand = new Random();
	private int xMin;
	private int yMin;
	private int zMin;
	private int xMax;
	private int yMax;
	private int zMax;
	
	//Unlit Torch
	private int ticksTillExtinguish;

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		if (compound.hasKey("torch"))
		{
			EnumTorch torch = EnumTorch.byMetadata(compound.getInteger("torch"));
			if (torch.isLoaded())
				this.torch = torch;
			else
				this.torch = EnumTorch.EMPTY;
		}

		if (compound.hasKey("lit"))
		{
			if (this.torch != EnumTorch.EMPTY)
				this.isLit = compound.getBoolean("lit");
		}
		
		if (this.torch.getName().contains("torcherino") && SPCompatibilityManager.isTorcherinoLoaded()) {
			if (compound.hasKey("Speed"))
				this.speed = compound.getByte("Speed");
			if (compound.hasKey("Mode"))
				this.mode = compound.getByte("Mode");
			if (compound.hasKey("PoweredByRedstone"))
				this.poweredByRedstone = compound.getBoolean("PoweredByRedstone");
		}
		
		if ((this.torch == EnumTorch.TORCH_LIT || this.torch == EnumTorch.TORCH_SMOLDERING) && SPCompatibilityManager.isRealisticTorchesLoaded())
			if (compound.hasKey("ticksTillExtinguish"))
				this.ticksTillExtinguish = compound.getInteger("ticksTillExtinguish");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("torch", this.torch.index);
		compound.setBoolean("lit", this.isLit);
		if (this.torch.getName().contains("torcherino") && SPCompatibilityManager.isTorcherinoLoaded()) {
			compound.setByte("Speed", this.speed);
			compound.setByte("Mode", this.mode);
			compound.setBoolean("PoweredByRedstone", this.poweredByRedstone);
		}
		if ((this.torch == EnumTorch.TORCH_LIT || this.torch == EnumTorch.TORCH_SMOLDERING) && SPCompatibilityManager.isRealisticTorchesLoaded())
			compound.setInteger("ticksTillExtinguish", ticksTillExtinguish);
		return compound;
	}

	@Override
	public NBTTagCompound getUpdateTag()
	{
		return this.writeToNBT(new NBTTagCompound());
	}

	public SPacketUpdateTileEntity getUpdatePacket()
	{
		return new SPacketUpdateTileEntity(this.pos, 0, this.getUpdateTag());
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
	{
		this.readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public boolean canRenderBreaking()
	{
		return true;
	}
	
	//REDSTONE TORCH

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
		if (newState.getBlock() == SPBlocks.sconce)
			if(oldState.getValue(BlockSconce.POWERED) != newState.getValue(BlockSconce.POWERED))
				return false;

		return super.shouldRefresh(world, pos, oldState, newState);
	}
	
	//GEM STAFF

	@Override
	public void update() {
		if (this.world.getTotalWorldTime() % 80L == 0L)
		{
			if (!this.world.isRemote) {
				if (this.getTorch() == EnumTorch.GEM_STAFF_AMETHYST)
					TileEntityGemStaff.addEffectsToPlayers(this.world, pos, MobEffects.HASTE);
				else if (this.getTorch() == EnumTorch.GEM_STAFF_RUBY)
					TileEntityGemStaff.addEffectsToPlayers(this.world, pos, MobEffects.STRENGTH);
				else if (this.getTorch() == EnumTorch.GEM_STAFF_PEARL)
					TileEntityGemStaff.addEffectsToPlayers(this.world, pos, MobEffects.WATER_BREATHING);
				else if (this.getTorch() == EnumTorch.GEM_STAFF_TOPAZ)
					TileEntityGemStaff.addEffectsToPlayers(this.world, pos, MobEffects.FIRE_RESISTANCE);
				else if (this.getTorch() == EnumTorch.GEM_STAFF_SAPPHIRE)
					TileEntityGemStaff.addEffectsToPlayers(this.world, pos, MobEffects.INVISIBILITY);
				else if (this.getTorch() == EnumTorch.GEM_STAFF_SPINEL)
					TileEntityGemStaff.addEffectsToPlayers(this.world, pos, MobEffects.REGENERATION);
			}
		}
		if (!this.world.isRemote && (this.getTorch() == EnumTorch.TORCH || this.getTorch() == EnumTorch.TORCH_UNLIT) && SPCompatibilityManager.isGCLoaded()) {
			if (this.world.getBlockState(this.pos).getBlock() instanceof BlockSconce) {
				BlockSconce sconce = (BlockSconce) this.world.getBlockState(this.pos).getBlock();
				sconce.checkOxygen(world, pos, this.world.getBlockState(this.pos));
			}
		}
		if (!this.world.isRemote && this.torch.getName().contains("torcherino") && SPCompatibilityManager.isTorcherinoLoaded()) {
			if (!this.poweredByRedstone && this.mode != 0 && this.speed != 0) {
				this.updateCachedModeIfNeeded();
				this.tickNeighbors();
			}
		}
		if (!this.world.isRemote && (this.torch == EnumTorch.TORCH_LIT || this.torch == EnumTorch.TORCH_SMOLDERING)) {
			if (this.ticksTillExtinguish <= 0) {
				BlockSconce sconce = (BlockSconce) this.world.getBlockState(this.pos).getBlock();
				sconce.extinguish(this, world, this.world.getBlockState(this.pos), pos, this.torch == EnumTorch.TORCH_LIT ? false : true);
			} else
				setCountdown(this.ticksTillExtinguish - 1);
		}
		
		if (this.torch == EnumTorch.INTERDICTION_TORCH) {
			WorldHelper.repelEntitiesInAABBFromPoint(this.world, new AxisAlignedBB(this.pos.add(-8, -8, -8), this.pos.add(8, 8, 8)), this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D, false);
		}
	}
	
	//TORCHERINO
	
	protected int speed(int base) {
		if (this.torch == EnumTorch.COMPRESSED_TORCHERINO)
			return base * 9;
		else if (this.torch == EnumTorch.DOUBLE_COMPRESSED_TORCHERINO)
			return base * 81;
		else
			return base;
	}
	
	private void updateCachedModeIfNeeded() {
		if (this.cachedMode != this.mode) {
			this.xMin = this.pos.getX() - this.mode;
			this.yMin = this.pos.getY() - 1;
			this.zMin = this.pos.getZ() - this.mode;
			this.xMax = this.pos.getX() + this.mode;
			this.yMax = this.pos.getY() + 1;
			this.zMax = this.pos.getZ() + this.mode;
			this.cachedMode = this.mode;
		}
	}

	private void tickNeighbors() {
		for (int x = this.xMin; x <= this.xMax; ++x)
			for (int y = this.yMin; y <= this.yMax; ++y)
				for (int z = this.zMin; z <= this.zMax; ++z)
					this.tickBlock(new BlockPos(x, y, z));
	}

	private void tickBlock(BlockPos pos) {
		IBlockState blockState = this.world.getBlockState(pos);
		Block block = blockState.getBlock();
		if (block != null && !(block instanceof BlockFluidBase) && !TorcherinoRegistry.isBlockBlacklisted(block)) {
			if (block.getTickRandomly()) {
				for (int i = 0; i < this.speed(this.speed)
						&& this.getWorld().getBlockState(pos) == blockState; ++i) {
					block.updateTick(this.world, pos, blockState, this.rand);
				}
			}

			if (block.hasTileEntity(this.world.getBlockState(pos))) {
				TileEntity tile = this.world.getTileEntity(pos);
				if (tile == null || tile.isInvalid()) {
					return;
				}

				if (TorcherinoRegistry.isTileBlacklisted(tile.getClass())) {
					return;
				}

				for (int i = 0; i < this.speed(this.speed) && !tile.isInvalid(); ++i) {
					if (tile instanceof ITickable) {
						((ITickable) tile).update();
					}
				}
			}

		}
	}

	public void setPoweredByRedstone(boolean poweredByRedstone) {
		this.poweredByRedstone = poweredByRedstone;
	}

	public void changeMode(boolean modifier) {
		if (modifier) {
			if (this.speed < 4) {
				++this.speed;
			} else {
				this.speed = 0;
			}
		} else if (this.mode < MODES.length - 1) {
			++this.mode;
		} else {
			this.mode = 0;
		}

	}

	public TextComponentString getDescription() {
		return new TextComponentString(MODES[this.mode] + " | Speed: " + this.speed(this.speed) * 100 + "%");
	}

	public String getMode() {
		return MODES[this.mode];
	}
	
	//UNLIT TORCH
	
	public void setCountdown(int ticks) {
		this.ticksTillExtinguish = ticks;
		this.markDirty();
	}
	
	//SCONE METHODS

	public EnumTorch getTorch()
	{
		return this.torch;
	}

	public void setTorch(EnumTorch torch)
	{
		this.torch = torch;
		this.markDirty();
	}

	public boolean getLit()
	{
		return this.isLit;
	}

	public void setLit(boolean lit)
	{
		this.isLit = lit;
		this.markDirty();
	}

	public enum EnumTorch implements IStringSerializable
	{
		EMPTY(0, "empty", true, null, 0, ItemStack.EMPTY, true, false),
		TORCH(1, "torch", true, SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Blocks.TORCH), true, true),
		REDSTONE_TORCH_ON(2, "redstone_torch_on", true, SoundEvents.BLOCK_WOOD_PLACE, 7, new ItemStack(Blocks.REDSTONE_TORCH), true, true),
		REDSTONE_TORCH_OFF(3, "redstone_torch_off", true, SoundEvents.BLOCK_WOOD_PLACE, 0, new ItemStack(Blocks.REDSTONE_TORCH), false, false),
		SOUL_TORCH(4, "soul_torch", SPCompatibilityManager.isFutureMCLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 10, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FUTURE_MC_MODID, "soul_fire_torch"))), true, true),
		CANDLE(5, "candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), true, false),
		WHITE_CANDLE(6, "white_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		LIGHT_GRAY_CANDLE(7, "light_gray_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		GRAY_CANDLE(8, "gray_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		BLACK_CANDLE(9, "black_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		RED_CANDLE(10, "red_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		ORANGE_CANDLE(11, "orange_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		YELLOW_CANDLE(12, "yellow_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		LIME_CANDLE(13, "lime_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		GREEN_CANDLE(14, "green_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		LIGHT_BLUE_CANDLE(15, "light_blue_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		CYAN_CANDLE(16, "cyan_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		BLUE_CANDLE(17, "blue_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		PURPLE_CANDLE(18, "purple_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		MAGENTA_CANDLE(19, "magenta_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		PINK_CANDLE(20, "pink_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		BROWN_CANDLE(21, "brown_candle", SPCompatibilityManager.isForestryLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "candle"))), false, false),
		GEM_STAFF(22, "gem_staff", true, SoundEvents.BLOCK_METAL_PLACE, 0, new ItemStack(SPItems.gem_staff), true, false),
		GEM_STAFF_AMETHYST(23, "gem_staff_amethyst", true, SoundEvents.BLOCK_GLASS_PLACE, 12, new ItemStack(SPItems.gem_staff), false, true),
		GEM_STAFF_RUBY(24, "gem_staff_ruby", true, SoundEvents.BLOCK_GLASS_PLACE, 12, new ItemStack(SPItems.gem_staff), false, true),
		GEM_STAFF_PEARL(25, "gem_staff_pearl", true, SoundEvents.BLOCK_GLASS_PLACE, 12, new ItemStack(SPItems.gem_staff), false, true),
		GEM_STAFF_TOPAZ(26, "gem_staff_topaz", true, SoundEvents.BLOCK_GLASS_PLACE, 12, new ItemStack(SPItems.gem_staff), false, true),
		GEM_STAFF_SAPPHIRE(27, "gem_staff_sapphire", true, SoundEvents.BLOCK_GLASS_PLACE, 12, new ItemStack(SPItems.gem_staff), false, true),
		GEM_STAFF_SPINEL(28, "gem_staff_spinel", true, SoundEvents.BLOCK_GLASS_PLACE, 12, new ItemStack(SPItems.gem_staff), false, true),
		TORCH_UNLIT(29, "torch_unlit", SPCompatibilityManager.isUnlitTorchModsLoaded(), SoundEvents.BLOCK_WOOD_PLACE, SPCompatibilityManager.isGCLoaded() ? 3 : 0, ItemStack.EMPTY, SPCompatibilityManager.isRealisticTorchesLoaded(), true),
		GLOWSTONE_TORCH(30, "glowstone_torch", SPCompatibilityManager.isGCLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.GCCORE_MODID, "glowstone_torch"))), true, true),
		AMBROSIUM_TORCH(31, "ambrosium_torch", SPCompatibilityManager.isAetherLegacyLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.AETHER_LEGACY_MODID, "ambrosium_torch"))), true, true),
		TORCHERINO(32, "torcherino", SPCompatibilityManager.isTorcherinoLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TORCHERINO_MODID, "blocktorcherino"))), true, true),
		COMPRESSED_TORCHERINO(33, "compressed_torcherino", SPCompatibilityManager.isTorcherinoLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TORCHERINO_MODID, "blockcompressedtorcherino"))), true, true),
		DOUBLE_COMPRESSED_TORCHERINO(34, "double_compressed_torcherino", SPCompatibilityManager.isTorcherinoLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TORCHERINO_MODID, "blockdoublecompressedtorcherino"))), true, true),
		BONE_TORCH(35, "bone_torch", SPCompatibilityManager.isBoneTorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.BONE_TORCH_MODID, "bonetorch"))), true, true),
		TORCH_LIT(36, "torch_lit", SPCompatibilityManager.isRealisticTorchesLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.REALISTIRC_TORCHES_MODID, "torch_lit"))), true, true),
		TORCH_SMOLDERING(37, "torch_smoldering", SPCompatibilityManager.isRealisticTorchesLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 10, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.REALISTIRC_TORCHES_MODID, "torch_smoldering"))), true, true),
		INTERDICTION_TORCH(38, "interdiction_torch", SPCompatibilityManager.isProjectELoaded(), SoundEvents.BLOCK_STONE_PLACE, 14, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.PROJECTE_MODID, "interdiction_torch"))), true, true),
		STONE_TORCH(39, "stone_torch", SPCompatibilityManager.isStoneTorchesLoaded() || SPCompatibilityManager.isJetLoaded(), SoundEvents.BLOCK_STONE_PLACE, SPCompatibilityManager.isStoneTorchesLoaded() ? 15 : 14, ItemStack.EMPTY, true, true),
		NETHERRACK_TORCH(40, "netherrack_torch", SPCompatibilityManager.isJetLoaded(), SoundEvents.BLOCK_STONE_PLACE, 10, new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.JET_MODID, "torch")), 1, 1), true, true),
		PRISMARINE_TORCH(41, "prismarine_torch", SPCompatibilityManager.isJetLoaded(), SoundEvents.BLOCK_GLASS_PLACE, 15, new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.JET_MODID, "torch")), 1, 2), true, true),
		OBSIDIAN_TORCH(42, "obsidian_torch", SPCompatibilityManager.isJetLoaded(), SoundEvents.BLOCK_STONE_PLACE, 13, new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.JET_MODID, "torch")), 1, 3), true, true),
		GOLDEN_TORCH(43, "golden_torch", SPCompatibilityManager.isJetLoaded(), SoundEvents.BLOCK_METAL_PLACE, 14, new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.JET_MODID, "torch")), 1, 4), true, true),
		WHITE_TORCH(44, "white_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_white"))), true, true),
		LIGHT_GRAY_TORCH(45, "light_gray_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_light_gray"))), true, true),
		GRAY_TORCH(46, "gray_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_gray"))), true, true),
		BLACK_TORCH(47, "black_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_black"))), true, true),
		RED_TORCH(48, "red_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_red"))), true, true),
		ORANGE_TORCH(49, "orange_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_orange"))), true, true),
		YELLOW_TORCH(50, "yellow_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch"))), true, true),
		LIME_TORCH(51, "lime_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_lime"))), true, true),
		GREEN_TORCH(52, "green_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_green"))), true, true),
		LIGHT_BLUE_TORCH(53, "light_blue_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_light_blue"))), true, true),
		CYAN_TORCH(54, "cyan_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_cyan"))), true, true),
		BLUE_TORCH(55, "blue_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_blue"))), true, true),
		PURPLE_TORCH(56, "purple_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_purple"))), true, true),
		MAGENTA_TORCH(57, "magenta_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_magenta"))), true, true),
		PINK_TORCH(58, "pink_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_pink"))), true, true),
		BROWN_TORCH(59, "brown_torch", SPCompatibilityManager.isITorchLoaded(), SoundEvents.BLOCK_WOOD_PLACE, 15, new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.ITORCH_MODID, "i_torch_brown"))), true, true);

		private static final EnumTorch[] META_LOOKUP = new EnumTorch[values().length];
		private final int index;
		private final String name;
		private final boolean isLoaded;
		private final SoundEvent sound;
		private final int light;
		private final ItemStack stack;
		private final boolean isPlaceable;
		private final boolean isLit;

		private EnumTorch(int indexIn, String nameIn, boolean isLoadedIn, SoundEvent soundIn, int lightIn, ItemStack stackIn, boolean isPlaceableIn, boolean isLitIn)
		{
			this.index = indexIn;
			this.name = nameIn;
			this.isLoaded = isLoadedIn;
			this.sound = soundIn;
			this.light = lightIn;
			this.stack = stackIn;
			this.isPlaceable = isPlaceableIn;	
			this.isLit = isLitIn;
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
			if (getName().contains("candle") && this != EnumTorch.CANDLE) {
				NBTTagCompound color = new NBTTagCompound();
				if (this == EnumTorch.WHITE_CANDLE)
					color.setInteger("colour", -1);
				else if (this == EnumTorch.LIGHT_GRAY_CANDLE)
					color.setInteger("colour", -6643295);
				else if (this == EnumTorch.GRAY_CANDLE)
					color.setInteger("colour", -11908534);
				else if (this == EnumTorch.BLACK_CANDLE)
					color.setInteger("colour", -15461356);
				else if (this == EnumTorch.RED_CANDLE)
					color.setInteger("colour", -6933456);
				else if (this == EnumTorch.ORANGE_CANDLE)
					color.setInteger("colour", -2392770);
				else if (this == EnumTorch.YELLOW_CANDLE)
					color.setInteger("colour", -236);
				else if (this == EnumTorch.LIME_CANDLE)
					color.setInteger("colour", -15401196);
				else if (this == EnumTorch.GREEN_CANDLE)
					color.setInteger("colour", -13285861);
				else if (this == EnumTorch.LIGHT_BLUE_CANDLE)
					color.setInteger("colour", -9729335);
				else if (this == EnumTorch.CYAN_CANDLE)
					color.setInteger("colour", -15400961);
				else if (this == EnumTorch.BLUE_CANDLE)
					color.setInteger("colour", -15461121);
				else if (this == EnumTorch.PURPLE_CANDLE)
					color.setInteger("colour", -8503883);
				else if (this == EnumTorch.MAGENTA_CANDLE)
					color.setInteger("colour", -60161);
				else if (this == EnumTorch.PINK_CANDLE)
					color.setInteger("colour", -3111783);
				else if (this == EnumTorch.BROWN_CANDLE)
					color.setInteger("colour", -11587041);
				stack.setTagCompound(color);
			}
			return stack;
		}

		public boolean isPlaceable() {
			return isPlaceable;
		}

		public boolean startLit() {
			return isLit;
		}

		@Override
		public String getName() {
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
