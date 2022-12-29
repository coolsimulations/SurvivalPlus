package net.coolsimulations.SurvivalPlus.core.blocks;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import com.chaosthedude.realistictorches.config.ConfigHandler;
import com.chaosthedude.realistictorches.items.RealisticTorchesItems;
import com.google.common.collect.Lists;
import com.sci.torcherino.Torcherino;
import com.sci.torcherino.TorcherinoRegistry;

import forestry.apiculture.blocks.BlockCandle;
import micdoodle8.mods.galacticraft.api.block.IOxygenReliantBlock;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.util.OxygenUtil;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.blocks.SPBlockSconce;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce.EnumTorch;
import net.coolsimulations.SurvivalPlus.core.compat.SurvivalPlusITorch;
import net.covers1624.stonetorch.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.Method;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import thedarkcolour.futuremc.registry.FParticles;
import thedarkcolour.futuremc.registry.FSounds;

@Interface(iface = "micdoodle8.mods.galacticraft.api.block.IOxygenReliantBlock", modid = SPCompatibilityManager.GCCORE_MODID)
public class BlockSconce extends SPBlockSconce implements ITileEntityProvider, IOxygenReliantBlock{

	protected static final AxisAlignedBB SCONCE_TORCH_NORTH_AABB = new AxisAlignedBB(0.375D, 0.113172D, 0.599423D, 0.625D, 0.820092D, 1.0D);
	protected static final AxisAlignedBB SCONCE_TORCH_SOUTH_AABB = new AxisAlignedBB(0.375D, 0.113172D, 0.0D, 0.625D, 0.820092D, 0.400577D);
	protected static final AxisAlignedBB SCONCE_TORCH_WEST_AABB = new AxisAlignedBB(0.599423D, 0.113172D, 0.375D, 1.0D, 0.820092D, 0.625D);
	protected static final AxisAlignedBB SCONCE_TORCH_EAST_AABB = new AxisAlignedBB(0.0D, 0.113172D, 0.375D, 0.400577D, 0.820092D, 0.625D);

	protected static final AxisAlignedBB SCONCE_STAFF_NORTH_AABB = new AxisAlignedBB(0.375D, 0.113172D, 0.599423D, 0.625D, 0.76235D, 1.0D);
	protected static final AxisAlignedBB SCONCE_STAFF_SOUTH_AABB = new AxisAlignedBB(0.375D, 0.113172D, 0.0D, 0.625D, 0.76235D, 0.400577D);
	protected static final AxisAlignedBB SCONCE_STAFF_WEST_AABB = new AxisAlignedBB(0.599423D, 0.113172D, 0.375D, 1.0D, 0.76235D, 0.625D);
	protected static final AxisAlignedBB SCONCE_STAFF_EAST_AABB = new AxisAlignedBB(0.0D, 0.113172D, 0.375D, 0.400577D, 0.76235D, 0.625D);

	protected static final AxisAlignedBB SCONCE_GEM_STAFF_NORTH_AABB = new AxisAlignedBB(0.375D, 0.113172D, 0.53564D, 0.625D, 0.978371D, 1.0D);
	protected static final AxisAlignedBB SCONCE_GEM_STAFF_SOUTH_AABB = new AxisAlignedBB(0.375D, 0.113172D, 0.0D, 0.625D, 0.978371D, 0.453564D);
	protected static final AxisAlignedBB SCONCE_GEM_STAFF_WEST_AABB = new AxisAlignedBB(0.53564D, 0.113172D, 0.375D, 1.0D, 0.978371D, 0.625D);
	protected static final AxisAlignedBB SCONCE_GEM_STAFF_EAST_AABB = new AxisAlignedBB(0.0D, 0.113172D, 0.375D, 0.453564D, 0.978371D, 0.625D);

	public static final PropertyBool POWERED = PropertyBool.create("powered");

	private static final Map<World, List<Toggle>> toggles = new java.util.WeakHashMap<World, List<Toggle>>();

	private ItemStack torch = ItemStack.EMPTY;

	public BlockSconce() {
		if (SPCompatibilityManager.isFutureMCLoaded())
			this.blockSoundType = FSounds.INSTANCE.getLANTERN();
		this.setTickRandomly(true);
		this.hasTileEntity = true;
		this.setLightOpacity(1);
		this.setLightLevel(0.0F);
		this.translucent = true;
		this.setDefaultState(this.getDefaultState().withProperty(POWERED, false));
		if(SPCompatibilityManager.isTorcherinoLoaded())
			TorcherinoRegistry.blacklistBlock(this);
	}

	//SCONCE

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		TileEntity tileentity = source.getTileEntity(pos);	
		if (tileentity instanceof TileEntitySconce) {
			TileEntitySconce te = (TileEntitySconce) tileentity;
			if (te.getTorch() == EnumTorch.EMPTY) {
				switch ((EnumFacing)state.getValue(FACING))
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
					switch ((EnumFacing)state.getValue(FACING))
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
					switch ((EnumFacing)state.getValue(FACING))
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
					switch ((EnumFacing)state.getValue(FACING))
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
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		EnumFacing enumfacing = stateIn.getValue(FACING);
		EnumFacing enumfacing1 = enumfacing.getOpposite();
		TileEntity tileentity = worldIn.getTileEntity(pos);	
		if (tileentity instanceof TileEntitySconce) {
			TileEntitySconce te = (TileEntitySconce) tileentity;

			if (te.getTorch().isLoaded()) {
				if (te.getTorch() == EnumTorch.TORCH || te.getTorch() == EnumTorch.SOUL_TORCH || te.getTorch().getName().contains("candle") || te.getTorch() == EnumTorch.TORCH_UNLIT || te.getTorch() == EnumTorch.AMBROSIUM_TORCH || te.getTorch().getName().contains("torcherino") || te.getTorch() == EnumTorch.BONE_TORCH || te.getTorch() == EnumTorch.TORCH_LIT || te.getTorch() == EnumTorch.TORCH_SMOLDERING || te.getTorch() == EnumTorch.INTERDICTION_TORCH || te.getTorch() == EnumTorch.STONE_TORCH || te.getTorch() == EnumTorch.OBSIDIAN_TORCH || te.getTorch() == EnumTorch.GOLDEN_TORCH) {
					double d0 = (double)pos.getX() + 0.5D;
					double d1 = (double)pos.getY() + 0.7D;
					double d2 = (double)pos.getZ() + 0.5D;
					int r = rand.nextInt(4);

					EnumParticleTypes flame = EnumParticleTypes.FLAME;
					if (te.getTorch() == EnumTorch.SOUL_TORCH)
						flame = FParticles.INSTANCE.getSOUL_FLAME();
					if ((te.getLit() && (te.getTorch() != EnumTorch.TORCH_UNLIT && te.getTorch() != EnumTorch.TORCH_SMOLDERING)) || (te.getTorch() == EnumTorch.TORCH_UNLIT && (SPCompatibilityManager.isGCLoaded() ? worldIn.provider instanceof IGalacticraftWorldProvider : SPCompatibilityManager.isRealisticTorchesLoaded() ? ConfigHandler.unlitParticlesEnabled : true)) || (te.getTorch() == EnumTorch.TORCH_SMOLDERING && SPCompatibilityManager.isRealisticTorchesLoaded() && r == 2)) {
						worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + 0.17D * enumfacing1.getFrontOffsetX(), d1 + 0.22D, d2 + 0.17D * enumfacing1.getFrontOffsetZ(), 0.0D, 0.0D, 0.0D);
					}
					if (te.getLit() && te.getTorch() != EnumTorch.TORCH_UNLIT && te.getTorch() != EnumTorch.AMBROSIUM_TORCH && te.getTorch() != EnumTorch.INTERDICTION_TORCH)
						worldIn.spawnParticle(flame, d0 + 0.17D * enumfacing1.getFrontOffsetX(), d1 + 0.22D, d2 + 0.17D * enumfacing1.getFrontOffsetZ(), 0.0D, 0.0D, 0.0D);
				} else if (te.getTorch() == EnumTorch.REDSTONE_TORCH_ON) {
					double d0 = (double)pos.getX() + 0.5D + (rand.nextDouble() - 0.5D) * 0.2D;
					double d1 = (double)pos.getY() + 0.7D + (rand.nextDouble() - 0.5D) * 0.2D;
					double d2 = (double)pos.getZ() + 0.5D + (rand.nextDouble() - 0.5D) * 0.2D;
					double d3 = 0.17D;

					d0 += 0.17D * (double)enumfacing1.getFrontOffsetX();
					d1 += 0.22D;
					d2 += 0.17D * (double)enumfacing1.getFrontOffsetZ();

					worldIn.spawnParticle(EnumParticleTypes.REDSTONE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				} else if (te.getTorch() == EnumTorch.NETHERRACK_TORCH || te.getTorch() == EnumTorch.PRISMARINE_TORCH) {
					double d0 = (double)pos.getX() + 0.5D;
					double d1 = (double)pos.getY() + 0.7D;
					double d2 = (double)pos.getZ() + 0.5D;

					EnumParticleTypes particle = EnumParticleTypes.SMOKE_NORMAL;
					if (te.getTorch() == EnumTorch.PRISMARINE_TORCH)
						particle = EnumParticleTypes.WATER_DROP;

					worldIn.spawnParticle(particle, d0 + 0.17D * enumfacing1.getFrontOffsetX(), d1 + 0.22D, d2 + 0.17D * enumfacing1.getFrontOffsetZ(), 0.0D, 0.0D, 0.0D);
				} else if (te.getTorch().ordinal() > 43 && te.getTorch().ordinal() < 60) {
					double d0 = (double)pos.getX() + 0.5D;
					double d1 = (double)pos.getY() + 0.7D;
					double d2 = (double)pos.getZ() + 0.5D;

					Color color = new Color(255, 255, 255);
					String colorName = te.getTorch().getName().replace("_torch", "");
					if (te.getTorch() == EnumTorch.LIGHT_GRAY_TORCH)
						color = new Color(169, 169, 169);
					else if (te.getTorch() == EnumTorch.GRAY_TORCH)
						color = new Color(80, 80, 80);
					else if (te.getTorch() == EnumTorch.BLACK_TORCH)
						color = new Color(0, 0, 0);
					else if (te.getTorch() == EnumTorch.RED_TORCH)
						color = new Color(178, 34, 34);
					else if (te.getTorch() == EnumTorch.ORANGE_TORCH)
						color = new Color(255, 140, 0);
					else if (te.getTorch() == EnumTorch.YELLOW_TORCH)
						color = new Color(255, 255, 0);
					else if (te.getTorch() == EnumTorch.LIME_TORCH)
						color = new Color(0, 255, 0);
					else if (te.getTorch() == EnumTorch.GREEN_TORCH)
						color = new Color(0, 128, 0);
					else if (te.getTorch() == EnumTorch.LIGHT_BLUE_TORCH)
						color = new Color(173, 216, 230);
					else if (te.getTorch() == EnumTorch.CYAN_TORCH)
						color = new Color(0, 255, 255);
					else if (te.getTorch() == EnumTorch.BLUE_TORCH)
						color = new Color(30, 144, 255);
					else if (te.getTorch() == EnumTorch.PURPLE_TORCH)
						color = new Color(148, 0, 211);
					else if (te.getTorch() == EnumTorch.MAGENTA_TORCH)
						color = new Color(255, 0, 255);
					else if (te.getTorch() == EnumTorch.PINK_TORCH)
						color = new Color(255, 105, 180);
					else if (te.getTorch() == EnumTorch.BROWN_TORCH)
						color = new Color(160, 82, 45);

					SurvivalPlusITorch.spawnTorchParticles(worldIn, enumfacing1, d0, d1, d2, colorName, color);
				}
			}
		}

	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		TileEntitySconce te = worldIn.getTileEntity(pos) instanceof TileEntitySconce ? (TileEntitySconce)worldIn.getTileEntity(pos) : null;
		if (te.getTorch() == EnumTorch.REDSTONE_TORCH_ON || te.getTorch() == EnumTorch.REDSTONE_TORCH_OFF) {
			boolean flag = this.shouldBeOff(worldIn, pos, state);
			List<Toggle> list = (List)toggles.get(worldIn);

			while (list != null && !list.isEmpty() && worldIn.getTotalWorldTime() - (list.get(0)).time > 60L)
			{
				list.remove(0);
			}

			if (te.getTorch() == EnumTorch.REDSTONE_TORCH_ON)
			{
				if (flag)
				{
					updateTorch(te, worldIn, state, pos, EnumTorch.REDSTONE_TORCH_OFF, false, false);

					if (this.isBurnedOut(worldIn, pos, true))
					{
						worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_REDSTONE_TORCH_BURNOUT, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

						for (int i = 0; i < 5; ++i)
						{
							double d0 = (double)pos.getX() + rand.nextDouble() * 0.6D + 0.2D;
							double d1 = (double)pos.getY() + rand.nextDouble() * 0.6D + 0.2D;
							double d2 = (double)pos.getZ() + rand.nextDouble() * 0.6D + 0.2D;
							worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D);
						}

						worldIn.scheduleUpdate(pos, worldIn.getBlockState(pos).getBlock(), 160);
					}
				}
			}
			else if (!flag && !this.isBurnedOut(worldIn, pos, false))
			{
				updateTorch(te, worldIn, state, pos, EnumTorch.REDSTONE_TORCH_ON, false, false);
			}
		} else if ((te.getTorch() == EnumTorch.TORCH || te.getTorch() == EnumTorch.TORCH_UNLIT) && SPCompatibilityManager.isGCLoaded())
			if (worldIn instanceof IGalacticraftWorldProvider)
				this.checkOxygen(worldIn, pos, state);
	}

	@Override
	public void randomTick(World world, BlockPos pos, IBlockState state, Random random) {
		TileEntitySconce te = world.getTileEntity(pos) instanceof TileEntitySconce ? (TileEntitySconce)world.getTileEntity(pos) : null;
		if (te.getTorch() == EnumTorch.TORCH_LIT || te.getTorch() == EnumTorch.TORCH_SMOLDERING)
			this.updateUnlitTorch(te, world, state, pos);
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		TileEntitySconce te = worldIn.getTileEntity(pos) instanceof TileEntitySconce ? (TileEntitySconce)worldIn.getTileEntity(pos) : null;
		if (!this.onNeighborChangeInternal(worldIn, pos, state))
		{
			if (te.getTorch() == EnumTorch.REDSTONE_TORCH_ON == this.shouldBeOff(worldIn, pos, state))
			{
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
			} else if ((te.getTorch() == EnumTorch.TORCH ||te.getTorch() == EnumTorch.TORCH_UNLIT)  && SPCompatibilityManager.isGCLoaded()) {
				this.checkOxygen(worldIn, pos, state);
			} else if (te.getTorch().getName().contains("torcherino") && SPCompatibilityManager.isTorcherinoLoaded()) {
				te.setPoweredByRedstone(worldIn.isBlockIndirectlyGettingPowered(pos) > 0);
			}
		}
	}

	@Override
	public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		TileEntity tileentity = world.getTileEntity(pos);	
		if (tileentity instanceof TileEntitySconce) {
			TileEntitySconce te = (TileEntitySconce) tileentity;
			if (te.getLit())
				return te.getTorch().getLightLevel();
		}
		return 0;
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		super.getDrops(drops, world, pos, state, fortune);
		TileEntitySconce te = world.getTileEntity(pos) instanceof TileEntitySconce ? (TileEntitySconce)world.getTileEntity(pos) : null;
		if (te != null) {
			if (te.getTorch().getItemStack() != ItemStack.EMPTY) {
				ItemStack drop = te.getTorch().getItemStack();
				if (te.getTorch().getName().contains("candle"))
					drop.setItemDamage(te.getLit() ? 1 : 0);
				else if (te.getTorch() == EnumTorch.GEM_STAFF_AMETHYST)
					drops.add(new ItemStack(SPBlocks.amethyst));
				else if (te.getTorch() == EnumTorch.GEM_STAFF_RUBY)
					drops.add(new ItemStack(SPBlocks.ruby));
				else if (te.getTorch() == EnumTorch.GEM_STAFF_PEARL)
					drops.add(new ItemStack(SPBlocks.pearl));
				else if (te.getTorch() == EnumTorch.GEM_STAFF_TOPAZ)
					drops.add(new ItemStack(SPBlocks.topaz));
				else if (te.getTorch() == EnumTorch.GEM_STAFF_SAPPHIRE)
					drops.add(new ItemStack(SPBlocks.sapphire));
				else if (te.getTorch() == EnumTorch.GEM_STAFF_SPINEL)
					drops.add(new ItemStack(SPBlocks.spinel));
				else if (te.getTorch() == EnumTorch.TORCH && SPCompatibilityManager.isRealisticTorchesLoaded() && ConfigHandler.vanillaTorchDropsUnlit) {
					drops.add(new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.REALISTIRC_TORCHES_MODID, "torch_unlit"))));
					return;
				}
				drops.add(drop);
			} else if (SPCompatibilityManager.isUnlitTorchModsLoaded() && te.getTorch() == EnumTorch.TORCH_UNLIT) {
				if (SPCompatibilityManager.isGCLoaded()) {
					if (SPCompatibilityManager.isRealisticTorchesLoaded())
						if (((World)world).provider instanceof IGalacticraftWorldProvider)
							drops.add(new ItemStack(Blocks.TORCH));
						else
							drops.add(new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.REALISTIRC_TORCHES_MODID, "torch_unlit"))));
				} else if (SPCompatibilityManager.isRealisticTorchesLoaded())
					drops.add(new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.REALISTIRC_TORCHES_MODID, "torch_unlit"))));
			} else if (te.getTorch() == EnumTorch.STONE_TORCH) {
				if (SPCompatibilityManager.isStoneTorchesLoaded())
					drops.add(new ItemStack(ModBlocks.torch_block));
				else if (SPCompatibilityManager.isJetLoaded())
					drops.add(new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.JET_MODID, "torch"))));
			}
		}
	}

	@Override
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest)
	{
		if (willHarvest)
			return true;
		return super.removedByPlayer(state, world, pos, player, willHarvest);
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack tool)
	{
		super.harvestBlock(world, player, pos, state, te, tool);
		world.setBlockToAir(pos);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		TileEntity tileentity = worldIn.getTileEntity(pos);	
		ItemStack itemStackIn = playerIn.getHeldItem(hand);
		Item item = itemStackIn.getItem();

		if (tileentity instanceof TileEntitySconce) {
			TileEntitySconce te = (TileEntitySconce) tileentity;
			boolean success = false;
			if (te.getTorch() == EnumTorch.EMPTY) {

				for (EnumTorch torch : EnumTorch.values()) {
					if (torch != EnumTorch.EMPTY && torch.isLoaded() && torch.isPlaceable()) {
						if(!success)
							success = setTorch(te, worldIn, state, playerIn, hand, pos, torch);
						else
							break;
					}
				}

				return success;
			} else if (te.getTorch().getName().contains("candle")) {

				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyeWhite", EnumTorch.WHITE_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyeLightGray", EnumTorch.LIGHT_GRAY_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyeGray", EnumTorch.GRAY_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyeBlack", EnumTorch.BLACK_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyeRed", EnumTorch.RED_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyeOrange", EnumTorch.ORANGE_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyeYellow", EnumTorch.YELLOW_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyeLime", EnumTorch.LIME_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyeGreen", EnumTorch.GREEN_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyeLightBlue", EnumTorch.LIGHT_BLUE_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyeCyan", EnumTorch.CYAN_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyeBlue", EnumTorch.BLUE_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyePurple", EnumTorch.PURPLE_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyeMagenta", EnumTorch.MAGENTA_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyePink", EnumTorch.PINK_CANDLE, false, true);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "dyeBrown", EnumTorch.BROWN_CANDLE, false, true);

				if (!te.getLit() && !success) {
					if (SPCompatibilityManager.isForestryLoaded()) {
						for (Item ignite :BlockCandle.lightingItems) {
							if (ignite == itemStackIn.getItem()) {
								te.setLit(true);
								updateTorch(te, worldIn, state, pos, te.getTorch(), false, true);
								success = true;
								break;
							}
						}
					}
				}

				if (te.getLit() && !success) {
					te.setLit(false);
					updateTorch(te, worldIn, state, pos, te.getTorch(), false, true);
					success = true;
				}

				return success;

			} else if (te.getTorch() == EnumTorch.GEM_STAFF) {

				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "gemAmethyst", EnumTorch.GEM_STAFF_AMETHYST, true, false);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "gemRuby", EnumTorch.GEM_STAFF_RUBY, true, false);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "gemPearl", EnumTorch.GEM_STAFF_PEARL, true, false);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "gemTopaz", EnumTorch.GEM_STAFF_TOPAZ, true, false);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "gemSapphire", EnumTorch.GEM_STAFF_SAPPHIRE, true, false);
				if(!success)
					success = checkOre(te, worldIn, pos, state, playerIn, itemStackIn, "gemSpinel", EnumTorch.GEM_STAFF_SPINEL, true, false);

				return success;
			} else if (te.getTorch().getName().contains("torcherino") && hand != EnumHand.OFF_HAND && SPCompatibilityManager.isTorcherinoLoaded()) {
				if (Torcherino.keyStates.get(playerIn) == null) {
					te.changeMode(false);
				} else {
					te.changeMode((Boolean) Torcherino.keyStates.get(playerIn));
				};
				playerIn.sendStatusMessage(te.getDescription(), true);
				return true;
			} else if ((te.getTorch() == EnumTorch.TORCH_LIT || te.getTorch() == EnumTorch.TORCH_SMOLDERING || te.getTorch() == EnumTorch.TORCH_UNLIT) && SPCompatibilityManager.isRealisticTorchesLoaded()) {
				if (te.getTorch() != EnumTorch.TORCH_UNLIT) {
					if(ItemStack.areItemsEqual(new ItemStack(RealisticTorchesItems.glowstonePaste), itemStackIn)) {
						if(!playerIn.capabilities.isCreativeMode)
							itemStackIn.shrink(1);
						updateTorch(te, worldIn, state, pos, EnumTorch.TORCH, false, false);
						return true;
					}
				}
				if (te.getTorch() == EnumTorch.TORCH_UNLIT || te.getTorch() == EnumTorch.TORCH_SMOLDERING) {
					if (SPCompatibilityManager.isGCLoaded() && te.getTorch() == EnumTorch.TORCH_UNLIT) 
						if ((worldIn.provider instanceof IGalacticraftWorldProvider)) 
							return false;
					if(itemStackIn.getItem() == Items.FLINT_AND_STEEL || (ConfigHandler.matchboxCreatesFire && itemStackIn.getItem() == Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.REALISTIRC_TORCHES_MODID, "matchbox")))) {
						if(!playerIn.capabilities.isCreativeMode)
							itemStackIn.damageItem(1, playerIn);
						updateTorch(te, worldIn, state, pos, EnumTorch.TORCH_LIT, false, false);
						worldIn.playSound(null, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F);
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		TileEntitySconce te = world.getTileEntity(pos) instanceof TileEntitySconce ? (TileEntitySconce)world.getTileEntity(pos) : null;
		if (te.getTorch() == EnumTorch.REDSTONE_TORCH_ON)
		{
			for (EnumFacing enumfacing : EnumFacing.values())
			{
				world.notifyNeighborsOfStateChange(pos.offset(enumfacing), this, false);
			}
		}
	}

	protected boolean setTorch(TileEntitySconce te, World worldIn, IBlockState state, EntityPlayer playerIn, EnumHand hand, BlockPos pos, EnumTorch torch) {
		ItemStack itemStackIn = playerIn.getHeldItem(hand);
		Item item = itemStackIn.getItem();
		if((item == torch.getItemStack().getItem() && (torch.getItemStack().getMetadata() != 0 ? itemStackIn.getMetadata() == torch.getItemStack().getMetadata() : true)) && torch.getItemStack() != ItemStack.EMPTY) {
			if(!playerIn.capabilities.isCreativeMode)
				itemStackIn.shrink(1);
			if (torch.getName().contains("candle")) {
				boolean candleLit = itemStackIn.getItemDamage() == 1;
				int color = 0;
				if (itemStackIn.hasTagCompound() && itemStackIn.getTagCompound().hasKey("colour"))
					color = itemStackIn.getTagCompound().getInteger("colour");
				if (candleLit)
					te.setLit(true);
				if (color == 0)
					updateTorch(te, worldIn, state, pos, EnumTorch.CANDLE, true, candleLit ? true : false);
				else if (color == -1)
					updateTorch(te, worldIn, state, pos, EnumTorch.WHITE_CANDLE, true, candleLit ? true : false);
				else if (color == -6643295)
					updateTorch(te, worldIn, state, pos, EnumTorch.LIGHT_GRAY_CANDLE, true, candleLit ? true : false);
				else if (color == -11908534)
					updateTorch(te, worldIn, state, pos, EnumTorch.GRAY_CANDLE, true, candleLit ? true : false);
				else if (color == -15461356)
					updateTorch(te, worldIn, state, pos, EnumTorch.BLACK_CANDLE, true, candleLit ? true : false);
				else if (color == -6933456)
					updateTorch(te, worldIn, state, pos, EnumTorch.RED_CANDLE, true, candleLit ? true : false);
				else if (color == -2392770)
					updateTorch(te, worldIn, state, pos, EnumTorch.ORANGE_CANDLE, true, candleLit ? true : false);
				else if (color == -236)
					updateTorch(te, worldIn, state, pos, EnumTorch.YELLOW_CANDLE, true, candleLit ? true : false);
				else if (color == -15401196)
					updateTorch(te, worldIn, state, pos, EnumTorch.LIME_CANDLE, true, candleLit ? true : false);
				else if (color == -13285861)
					updateTorch(te, worldIn, state, pos, EnumTorch.GREEN_CANDLE, true, candleLit ? true : false);
				else if (color == -9729335)
					updateTorch(te, worldIn, state, pos, EnumTorch.LIGHT_BLUE_CANDLE, true, candleLit ? true : false);
				else if (color == -15400961)
					updateTorch(te, worldIn, state, pos, EnumTorch.CYAN_CANDLE, true, candleLit ? true : false);
				else if (color == -15461121)
					updateTorch(te, worldIn, state, pos, EnumTorch.BLUE_CANDLE, true, candleLit ? true : false);
				else if (color == -8503883)
					updateTorch(te, worldIn, state, pos, EnumTorch.PURPLE_CANDLE, true, candleLit ? true : false);
				else if (color == -60161)
					updateTorch(te, worldIn, state, pos, EnumTorch.MAGENTA_CANDLE, true, candleLit ? true : false);
				else if (color == -3111783)
					updateTorch(te, worldIn, state, pos, EnumTorch.PINK_CANDLE, true, candleLit ? true : false);
				else if (color == -11587041)
					updateTorch(te, worldIn, state, pos, EnumTorch.BROWN_CANDLE, true, candleLit ? true : false);

			} else
				updateTorch(te, worldIn, state, pos, torch, true, false);
			return true;
		} else {
			if (SPCompatibilityManager.isUnlitTorchModsLoaded()) {
				if (torch == EnumTorch.TORCH) {
					if (SPCompatibilityManager.isGCLoaded()) {
						if (item == Item.getItemFromBlock(GCBlocks.unlitTorch) || item == Item.getItemFromBlock(GCBlocks.unlitTorchLit)) {
							if(!playerIn.capabilities.isCreativeMode)
								itemStackIn.shrink(1);
							updateTorch(te, worldIn, state, pos, torch, true, false);
							return true;
						}
					}
				} else if (torch == EnumTorch.TORCH_UNLIT) {
					if (SPCompatibilityManager.isRealisticTorchesLoaded()) {
						if (item == Item.getItemFromBlock(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.REALISTIRC_TORCHES_MODID, "torch_unlit")))) {
							if(!playerIn.capabilities.isCreativeMode)
								itemStackIn.shrink(1);
							updateTorch(te, worldIn, state, pos, torch, true, false);
							return true;
						}
					}
				}
			}
			if (torch == EnumTorch.STONE_TORCH) {
				if (SPCompatibilityManager.isStoneTorchesLoaded()) {
					if(ItemStack.areItemsEqual(new ItemStack(net.covers1624.stonetorch.init.ModBlocks.torch_block), itemStackIn)) {
						if(!playerIn.capabilities.isCreativeMode)
							itemStackIn.shrink(1);
						updateTorch(te, worldIn, state, pos, torch, false, false);
						return true;
					}
				}

				if (SPCompatibilityManager.isJetLoaded()) {
					if(ItemStack.areItemsEqual(new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.JET_MODID, "torch"))), itemStackIn)) {
						if(!playerIn.capabilities.isCreativeMode)
							itemStackIn.shrink(1);
						updateTorch(te, worldIn, state, pos, torch, false, false);
						return true;
					}
				}
			}
		}

		return false;
	}

	protected void updateTorch(TileEntitySconce te, World worldIn, IBlockState state, BlockPos pos, EnumTorch torch, boolean doSound, boolean keepLit) {
		if (doSound)
			worldIn.playSound(null, pos, torch.getSound(), SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F);
		if (te.getTorch() != torch)
			te.setTorch(torch);
		if(!keepLit)
			te.setLit(torch.startLit());
		if (torch == EnumTorch.REDSTONE_TORCH_ON) {
			worldIn.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(POWERED, true), 3);
			for (EnumFacing enumfacing : EnumFacing.values())
			{
				worldIn.notifyNeighborsOfStateChange(pos.offset(enumfacing), this, false);
			}
		} else if (state.getValue(POWERED)) {
			worldIn.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(POWERED, false), 3);
		}
		if ((torch == EnumTorch.TORCH || torch == EnumTorch.TORCH_UNLIT) && SPCompatibilityManager.isGCLoaded()) {
			this.checkOxygen(worldIn, pos, state);
		} else if (te.getTorch().getName().contains("torcherino") && SPCompatibilityManager.isTorcherinoLoaded()) {
			te.setPoweredByRedstone(worldIn.isBlockIndirectlyGettingPowered(pos) > 0);
		} else if (torch == EnumTorch.OBSIDIAN_TORCH) {
			this.setResistance(3000.0F);
		} else if (torch == EnumTorch.GOLDEN_TORCH) {
			this.setResistance(30.0F);
		}
		if (torch == EnumTorch.TORCH_LIT || torch == EnumTorch.TORCH_SMOLDERING && SPCompatibilityManager.isRealisticTorchesLoaded()) {
			if (this.canBurnout()) {
				if (worldIn.isRainingAt(pos.up())) {
					this.extinguish(te, worldIn, state, pos, true);
				} else {
					te.setCountdown(torch == EnumTorch.TORCH_LIT ? (int) ((double) ConfigHandler.torchBurnout * 0.9D) : ConfigHandler.torchBurnout / 10);
				}
			}
		}
		worldIn.notifyBlockUpdate(pos, state, state, 3);
		worldIn.markAndNotifyBlock(pos, worldIn.getChunkFromBlockCoords(pos), state, state, 3);
		worldIn.checkLight(pos);
	}

	//REDSTONE TORCH

	@Override
	public boolean canProvidePower(IBlockState state)
	{
		return state.getValue(POWERED);
	}

	private boolean isBurnedOut(World worldIn, BlockPos pos, boolean turnOff)
	{
		if (!toggles.containsKey(worldIn))
		{
			toggles.put(worldIn, Lists.newArrayList());
		}

		List<Toggle> list = (List)toggles.get(worldIn);

		if (turnOff)
		{
			list.add(new Toggle(pos, worldIn.getTotalWorldTime()));
		}

		int i = 0;

		for (int j = 0; j < list.size(); ++j)
		{
			Toggle toggle = list.get(j);

			if (toggle.pos.equals(pos))
			{
				++i;

				if (i >= 8)
				{
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public int tickRate(World world)
	{
		return 2;
	}

	@Override
	public int getWeakPower(IBlockState blockState, IBlockAccess world, BlockPos pos, EnumFacing side)
	{
		TileEntitySconce te = world.getTileEntity(pos) instanceof TileEntitySconce ? (TileEntitySconce)world.getTileEntity(pos) : null;
		return te.getTorch() == EnumTorch.REDSTONE_TORCH_ON && blockState.getValue(FACING) != side ? 15 : 0;
	}

	@Override
	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return side == EnumFacing.DOWN ? blockState.getWeakPower(blockAccess, pos, side) : 0;
	}

	private boolean shouldBeOff(World worldIn, BlockPos pos, IBlockState state)
	{
		EnumFacing enumfacing = ((EnumFacing)state.getValue(FACING)).getOpposite();
		return worldIn.isSidePowered(pos.offset(enumfacing), enumfacing);
	}

	//CANDLE

	protected boolean checkOre(TileEntitySconce te, World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, ItemStack stack, String oreDictionary, EnumTorch dyeTorch, boolean doSound, boolean keepLit) {

		List<ItemStack> acceptableItems = OreDictionary.getOres(oreDictionary);
		for(ItemStack i : acceptableItems ){
			if(ItemStack.areItemsEqual(i, stack) && oreDictionary != null) {
				if(!playerIn.capabilities.isCreativeMode)
					stack.shrink(1);
				updateTorch(te, worldIn, state, pos, dyeTorch, doSound, keepLit);
				return true;
			}
		}

		return false;
	}

	//UNLIT TORCH

	@Method(modid = SPCompatibilityManager.GCCORE_MODID)
	@Override
	public void onOxygenRemoved(World world, BlockPos pos, IBlockState state)
	{
		if (world.provider instanceof IGalacticraftWorldProvider)
		{
			TileEntitySconce te = world.getTileEntity(pos) instanceof TileEntitySconce ? (TileEntitySconce)world.getTileEntity(pos) : null;
			if (te.getTorch() == EnumTorch.TORCH)
				updateTorch(te, world, state, pos, EnumTorch.TORCH_UNLIT, false, false);
		}
	}

	@Method(modid = SPCompatibilityManager.GCCORE_MODID)
	@Override
	public void onOxygenAdded(World world, BlockPos pos, IBlockState state)
	{
		if (world.provider instanceof IGalacticraftWorldProvider)
		{
			TileEntitySconce te = world.getTileEntity(pos) instanceof TileEntitySconce ? (TileEntitySconce)world.getTileEntity(pos) : null;
			if (te.getTorch() == EnumTorch.TORCH_UNLIT)
				updateTorch(te, world, state, pos, EnumTorch.TORCH, false, false);
		}
	}

	@Method(modid = SPCompatibilityManager.GCCORE_MODID)
	public void checkOxygen(World world, BlockPos pos, IBlockState state)
	{
		if (world.provider instanceof IGalacticraftWorldProvider)
		{
			if (OxygenUtil.checkTorchHasOxygen(world, pos))
			{
				this.onOxygenAdded(world, pos, state);
			}
			else
			{
				this.onOxygenRemoved(world, pos, state);
			}
		}
	}

	//UNLIT TORCH

	public boolean canBurnout() {
		return ConfigHandler.torchBurnout > 0;
	}

	public void updateUnlitTorch(TileEntitySconce te, World world, IBlockState state, BlockPos pos) {
		if (this.canBurnout() && world.isRainingAt(pos) && (te.getTorch() == EnumTorch.TORCH_LIT || te.getTorch() == EnumTorch.TORCH_SMOLDERING))
			this.extinguish(te, world, state, pos, true);
	}

	public void extinguish(TileEntitySconce te, World world, IBlockState state, BlockPos pos, boolean extinguishFully) {
		world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);
		if (!extinguishFully) {
			updateTorch(te, world, state, pos, EnumTorch.TORCH_SMOLDERING, false, false);
		} else if (!ConfigHandler.noRelightEnabled) {
			updateTorch(te, world, state, pos, EnumTorch.TORCH_UNLIT, false, false);
		} else {
			updateTorch(te, world, state, pos, EnumTorch.EMPTY, false, false);
		}
	}

	//TILE ENTITY

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntitySconce();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasCustomBreakingProgress(IBlockState state)
	{
		return true;
	}

	//BLOCKSTATE

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		EnumFacing enumfacing;

		switch (meta & 3)
		{
		case 0:
			enumfacing = EnumFacing.EAST;
			break;
		case 1:
			enumfacing = EnumFacing.WEST;
			break;
		case 2:
			enumfacing = EnumFacing.SOUTH;
			break;
		case 3:
			enumfacing = EnumFacing.NORTH;
			break;
		default:
			enumfacing = EnumFacing.EAST;
		}

		return this.getDefaultState().withProperty(FACING, enumfacing).withProperty(POWERED, Boolean.valueOf((meta & 4) > 0));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;

		switch ((EnumFacing)state.getValue(FACING))
		{
		case EAST:
			i = 0;
			break;
		case WEST:
			i = 1;
			break;
		case SOUTH:
			i = 2;
			break;
		case NORTH:
			i = 3;
			break;
		default:
			i = 3;
		}

		if ((state.getValue(POWERED)).booleanValue())
		{
			i |= 4;
		}

		return i;
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING, POWERED});
	}

	static class Toggle
	{
		BlockPos pos;
		long time;

		public Toggle(BlockPos pos, long time)
		{
			this.pos = pos;
			this.time = time;
		}
	}
}
