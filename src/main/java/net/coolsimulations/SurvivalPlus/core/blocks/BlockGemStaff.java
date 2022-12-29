package net.coolsimulations.SurvivalPlus.core.blocks;

import java.util.List;
import java.util.Random;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntityGemStaff;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class BlockGemStaff extends Block implements ITileEntityProvider {

	public static final PropertyEnum<EnumGemStaffHalf> HALF = PropertyEnum.<EnumGemStaffHalf>create("half", EnumGemStaffHalf.class);
	public static final PropertyEnum<EnumGemHeld> GEM = PropertyEnum.<EnumGemHeld>create("gem", EnumGemHeld.class);

	protected static final AxisAlignedBB GEM_STAFF_LOWER = new AxisAlignedBB(0.375D, 0.0D, 0.625D, 0.625D, 1.0D, 0.375D);
	protected static final AxisAlignedBB GEM_STAFF_UPPER = new AxisAlignedBB(0.375D, 0.0D, 0.625D, 0.625F, 0.5625D, 0.375D);
	protected static final AxisAlignedBB GEM_STAFF_UPPER_GEM = new AxisAlignedBB(0.375D, 0.0D, 0.625D, 0.625D, 0.875D, 0.375D);

	public BlockGemStaff() {
		super(Material.IRON);
		this.setHardness(3.5F);
		this.setResistance(7.5F);
		this.setLightOpacity(0);
		this.setHarvestLevel("pickaxe", 1);
		this.blockSoundType = SoundType.METAL;
		this.hasTileEntity = true;
		this.setDefaultState(this.blockState.getBaseState().withProperty(HALF, EnumGemStaffHalf.LOWER).withProperty(GEM, EnumGemHeld.EMPTY));
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		if (state.getValue(HALF) == EnumGemStaffHalf.LOWER)
			return GEM_STAFF_LOWER;
		else if (state.getValue(GEM) == EnumGemHeld.EMPTY)
			return GEM_STAFF_UPPER;
		else
			return GEM_STAFF_UPPER_GEM;
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		return state.getValue(GEM).getColor();
	}

	@Override
	public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		if (state.getValue(GEM) != EnumGemHeld.EMPTY)
			return 12;

		return 0;
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		super.getDrops(drops, world, pos, state, fortune);
		if (state.getValue(HALF) != EnumGemStaffHalf.UPPER)
			switch (state.getValue(GEM)) {
			case AMETHYST:
				drops.add(new ItemStack(SPBlocks.amethyst));
				break;
			case RUBY:
				drops.add(new ItemStack(SPBlocks.ruby));
				break;
			case PEARL:
				drops.add(new ItemStack(SPBlocks.pearl));
				break;
			case TOPAZ:
				drops.add(new ItemStack(SPBlocks.topaz));
				break;
			case SAPPHIRE:
				drops.add(new ItemStack(SPBlocks.sapphire));
				break;
			case SPINEL:
				drops.add(new ItemStack(SPBlocks.spinel));
				break;
			default:
				break;
			}
	}

	@Override
	public String getLocalizedName()
	{
		return I18n.translateToLocal((this.getUnlocalizedName() + ".name").replaceAll("tile", "item"));
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
		return false;
	}

	@Override
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	@Override
	public EnumPushReaction getMobilityFlag(IBlockState state)
	{
		return EnumPushReaction.DESTROY;
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (state.getValue(HALF) == EnumGemStaffHalf.UPPER)
		{
			BlockPos blockpos = pos.down();
			IBlockState iblockstate = worldIn.getBlockState(blockpos);

			if (iblockstate.getBlock() != this)
			{
				worldIn.setBlockToAir(pos);
			}
			else if (blockIn != this)
			{
				iblockstate.neighborChanged(worldIn, blockpos, blockIn, fromPos);
			}
		}
		else
		{
			boolean flag1 = false;
			BlockPos blockpos1 = pos.up();
			IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);

			if (iblockstate1.getBlock() != this)
			{
				worldIn.setBlockToAir(pos);
				flag1 = true;
			}

			if (!worldIn.getBlockState(pos.down()).isSideSolid(worldIn,  pos.down(), EnumFacing.UP))
			{
				worldIn.setBlockToAir(pos);
				flag1 = true;

				if (iblockstate1.getBlock() == this)
				{
					worldIn.setBlockToAir(blockpos1);
				}
			}

			if (flag1)
			{
				if (!worldIn.isRemote)
				{
					this.dropBlockAsItem(worldIn, pos, state, 0);
				}
			}
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		ItemStack itemStackIn = playerIn.getHeldItem(hand);
		Item item = itemStackIn.getItem();

		if (state.getValue(GEM) == EnumGemHeld.EMPTY) {
			boolean success = false;

			if(!success)
				success = checkGem(worldIn, pos, state, playerIn, itemStackIn, "gemAmethyst", EnumGemHeld.AMETHYST);
			if(!success)
				success = checkGem(worldIn, pos, state, playerIn, itemStackIn, "gemRuby", EnumGemHeld.RUBY);
			if(!success)
				success = checkGem(worldIn, pos, state, playerIn, itemStackIn, "gemPearl", EnumGemHeld.PEARL);
			if(!success)
				success = checkGem(worldIn, pos, state, playerIn, itemStackIn, "gemTopaz", EnumGemHeld.TOPAZ);
			if(!success)
				success = checkGem(worldIn, pos, state, playerIn, itemStackIn, "gemSapphire", EnumGemHeld.SAPPHIRE);
			if(!success)
				success = checkGem(worldIn, pos, state, playerIn, itemStackIn, "gemSpinel", EnumGemHeld.SPINEL);

			return success;
		}

		return false;
	}

	protected boolean checkGem(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, ItemStack stack, String oreDictionary, EnumGemHeld gem) {

		List<ItemStack> acceptableItems = OreDictionary.getOres(oreDictionary);
		for(ItemStack i : acceptableItems ){
			if(ItemStack.areItemsEqual(i, stack) && oreDictionary != null) {
				if(!playerIn.capabilities.isCreativeMode)
					stack.shrink(1);
				worldIn.setBlockState(pos, state.withProperty(GEM, gem), 3);
				if (state.getValue(HALF) == EnumGemStaffHalf.LOWER)
					worldIn.setBlockState(pos.up(), state.withProperty(HALF, EnumGemStaffHalf.UPPER).withProperty(GEM, gem), 3);
				else
					worldIn.setBlockState(pos.down(), state.withProperty(HALF, EnumGemStaffHalf.LOWER).withProperty(GEM, gem), 3);

				return true;
			}

		}

		return false;
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return state.getValue(HALF) == EnumGemStaffHalf.UPPER ? Items.AIR : SPItems.gem_staff;
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(SPItems.gem_staff);
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		BlockPos blockpos = pos.down();
		BlockPos blockpos1 = pos.up();

		if (player.capabilities.isCreativeMode && state.getValue(HALF) == EnumGemStaffHalf.UPPER && worldIn.getBlockState(blockpos).getBlock() == this)
		{
			worldIn.setBlockToAir(blockpos);
		}

		if (state.getValue(HALF) == EnumGemStaffHalf.LOWER && worldIn.getBlockState(blockpos1).getBlock() == this)
		{
			if (player.capabilities.isCreativeMode)
			{
				worldIn.setBlockToAir(pos);
			}

			worldIn.setBlockToAir(blockpos1);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		EnumGemHeld enumgemheld;

		switch (meta > 6 ? meta - 7 : meta)
		{
		case 0:
			enumgemheld = EnumGemHeld.EMPTY;
			break;
		case 1:
			enumgemheld = EnumGemHeld.AMETHYST;
			break;
		case 2:
			enumgemheld = EnumGemHeld.RUBY;
			break;
		case 3:
			enumgemheld = EnumGemHeld.PEARL;
			break;
		case 4:
			enumgemheld = EnumGemHeld.TOPAZ;
			break;
		case 5:
			enumgemheld = EnumGemHeld.SAPPHIRE;
			break;
		case 6:
			enumgemheld = EnumGemHeld.SPINEL;
			break;
		default:
			enumgemheld = EnumGemHeld.EMPTY;
		}

		return meta > 6 ? this.getDefaultState().withProperty(HALF, EnumGemStaffHalf.UPPER).withProperty(GEM, enumgemheld) : this.getDefaultState().withProperty(HALF, EnumGemStaffHalf.LOWER).withProperty(GEM, enumgemheld);

	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;

		switch (state.getValue(GEM))
		{
		case EMPTY:
			i = 0;
			break;
		case AMETHYST:
			i = 1;
			break;
		case RUBY:
			i = 2;
			break;
		case PEARL:
			i = 3;
			break;
		case TOPAZ:
			i = 4;
			break;
		case SAPPHIRE:
			i = 5;
			break;
		case SPINEL:
			i = 6;
			break;
		default:
			i = 0;
		}

		if (state.getValue(HALF) == EnumGemStaffHalf.UPPER)
		{
			i = i + 7;
		}

		return i;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityGemStaff();
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {HALF, GEM});
	}

	public static enum EnumGemHeld implements IStringSerializable
	{
		EMPTY("empty", MapColor.IRON),
		AMETHYST("amethyst", MapColor.PURPLE),
		RUBY("ruby", MapColor.RED),
		PEARL("pearl", MapColor.SNOW),
		TOPAZ("topaz", MapColor.YELLOW),
		SAPPHIRE("sapphire", MapColor.BLUE),
		SPINEL("spinel", MapColor.BLACK);

		private final String name;
		private final MapColor color;

		private EnumGemHeld(String nameIn, MapColor colorIn) {
			this.name = nameIn;
			this.color = colorIn;
		}

		public String toString()
		{
			return this.getName();
		}

		public MapColor getColor() {
			return this.color;
		}

		public String getName()
		{
			return this.name;
		}
	}

	public static enum EnumGemStaffHalf implements IStringSerializable
	{
		UPPER,
		LOWER;

		public String toString()
		{
			return this.getName();
		}

		public String getName()
		{
			return this == UPPER ? "upper" : "lower";
		}
	}
}
