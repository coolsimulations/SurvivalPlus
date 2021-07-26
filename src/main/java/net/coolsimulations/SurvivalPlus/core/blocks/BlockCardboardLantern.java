package net.coolsimulations.SurvivalPlus.core.blocks;

import java.util.List;
import java.util.Random;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class BlockCardboardLantern extends BlockCardboard {

	protected static final AxisAlignedBB CARDBOARD_LANTERN_AABB = new AxisAlignedBB(0.359375D, 0.0D, 0.359375D, 0.640625D, 0.4375D, 0.640625D);
	protected static final AxisAlignedBB CARDBOARD_LANTERN_HANGING_AABB = new AxisAlignedBB(0.359375D, 0.0625D, 0.359375D, 0.640625D, 1.0D, 0.640625D);
	protected static final AxisAlignedBB CARDBOARD_PAD_AABB = new AxisAlignedBB(0.25D, -0.15625D, 0.25D, 0.75D, 0.34375D, 0.75D);
	protected static final AxisAlignedBB CARDBOARD_LANTERN_NORTH_AABB = new AxisAlignedBB(0.359375D, 0.0625D, 0.484375D, 0.640625D, 0.5D, 1.0D);
	protected static final AxisAlignedBB CARDBOARD_LANTERN_SOUTH_AABB = new AxisAlignedBB(0.359375D, 0.0625D, 0.0D, 0.640625D, 0.5D, 0.515625D);
	protected static final AxisAlignedBB CARDBOARD_LANTERN_EAST_AABB = new AxisAlignedBB(0.0D, 0.0625D, 0.359375D, 0.515625D, 0.5D, 0.640625D);
	protected static final AxisAlignedBB CARDBOARD_LANTERN_WEST_AABB = new AxisAlignedBB(0.484375D, 0.0625D, 0.359375D, 1.0D, 0.5D, 0.640625D);
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	public static final PropertyBool FLOATING = PropertyBool.create("floating");
	
	protected boolean isDyed;

	public BlockCardboardLantern(MapColor colour, boolean isDyed) {
		super(colour);
		this.setLightLevel(1.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP).withProperty(FLOATING, Boolean.valueOf(false)));
		this.isDyed = isDyed;
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
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
		boolean isFloating = state.getValue(FLOATING);

		if(isFloating) {
			if(enumfacing == EnumFacing.DOWN) {
				return CARDBOARD_LANTERN_HANGING_AABB;
			} else {
				return CARDBOARD_PAD_AABB;
			}
		} else {
			switch (enumfacing) {
			case UP:
				return CARDBOARD_LANTERN_AABB;
			case EAST:
				return CARDBOARD_LANTERN_EAST_AABB;
			case SOUTH:
				return CARDBOARD_LANTERN_SOUTH_AABB;
			case WEST:
				return CARDBOARD_LANTERN_WEST_AABB;
			case NORTH:
				return CARDBOARD_LANTERN_NORTH_AABB;
			case DOWN:
				return CARDBOARD_LANTERN_HANGING_AABB;
			}
		}

		return CARDBOARD_PAD_AABB;
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		EnumFacing enumfacing = (EnumFacing)stateIn.getValue(FACING);
		boolean isFloating = stateIn.getValue(FLOATING);
		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.21875D;
		double d2 = (double)pos.getZ() + 0.5D;

		if(isFloating) {
			if(enumfacing == EnumFacing.DOWN) {
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
			} else {
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1 - 0.03125D, d2, 0.0D, 0.0D, 0.0D);
			}
		} else {
			switch (enumfacing) {
			case UP:
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				break;
			case EAST:
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 - 0.125, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
				break;
			case SOUTH:
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1 + 0.0625D, d2 - 0.125, 0.0D, 0.0D, 0.0D);
				break;
			case WEST:
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + 0.125, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
				break;
			case NORTH:
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1 + 0.0625D, d2 + 0.125, 0.0D, 0.0D, 0.0D);
				break;
			case DOWN:
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1 + 0.0625D, d2, 0.0D, 0.0D, 0.0D);
				break;
			}
		}
	}

	/**
	 * Called when the block is right clicked by a player.
	 */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		ItemStack itemStackIn = playerIn.getHeldItem(hand);
		
		if(!isDyed) {
			
			boolean success = false;
			
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyeWhite", SPBlocks.cardboard_lantern_white);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyeLightGray", SPBlocks.cardboard_lantern_light_grey);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyeGray", SPBlocks.cardboard_lantern_grey);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyeBlack", SPBlocks.cardboard_lantern_black);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyeRed", SPBlocks.cardboard_lantern_red);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyeOrange", SPBlocks.cardboard_lantern_orange);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyeYellow", SPBlocks.cardboard_lantern_yellow);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyeLime", SPBlocks.cardboard_lantern_lime);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyeGreen", SPBlocks.cardboard_lantern_green);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyeLightBlue", SPBlocks.cardboard_lantern_light_blue);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyeCyan", SPBlocks.cardboard_lantern_cyan);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyeBlue", SPBlocks.cardboard_lantern_blue);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyePurple", SPBlocks.cardboard_lantern_purple);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyeMagenta", SPBlocks.cardboard_lantern_magenta);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyePink", SPBlocks.cardboard_lantern_pink);
			if(!success)
				success = checkDye(worldIn, pos, state, playerIn, itemStackIn, "dyeBrown", SPBlocks.cardboard_lantern_brown);
			
			state.neighborChanged(worldIn, pos, this, pos);
			return success;
		} else {
			state.neighborChanged(worldIn, pos, this, pos);
		}
		
		return false;
	}

	protected boolean checkDye(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, ItemStack stack, String oreDictionary, Block dyeBlock) {

		List<ItemStack> acceptableItems = OreDictionary.getOres(oreDictionary);
		for(ItemStack i : acceptableItems ){
			if(ItemStack.areItemsEqual(i, stack) && oreDictionary != null) {
				if(!playerIn.capabilities.isCreativeMode)
					stack.shrink(1);
				worldIn.setBlockState(pos, dyeBlock.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(FLOATING, state.getValue(FLOATING)), 3);
				return true;
			}

		}
		
		return false;
	}

	/**
	 * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
	 * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
	 * block, etc.
	 */
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (this.checkForDrop(worldIn, pos, state) && !canPlaceBlock(worldIn, pos, (EnumFacing)state.getValue(FACING)) && !state.getValue(FLOATING))
		{
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		} else {
			if(state.getValue(FACING) == EnumFacing.DOWN && !isValidPos(worldIn, fromPos, EnumFacing.DOWN)) {
				this.dropBlockAsItem(worldIn, pos, state, 0);
				worldIn.setBlockToAir(pos);
			}
		}

		if(state.getValue(FLOATING) && !canBlockStay(worldIn, pos, state)) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
	}

	@Override
	public void observedNeighborChange(IBlockState observerState, World worldIn, BlockPos observerPos, Block changedBlock, BlockPos changedBlockPos) {
		if(changedBlock instanceof BlockTrapDoor && (observerState.getValue(FACING) == EnumFacing.DOWN || observerState.getValue(FACING) == EnumFacing.UP)) {

			EnumFacing direction = observerState.getValue(FACING);

			if(!isValidPos(worldIn, observerPos, direction)) {
				this.dropBlockAsItem(worldIn, observerPos, observerState, 0);
				worldIn.setBlockToAir(observerPos);
			}
		}
		
		if(changedBlock instanceof BlockCauldron && (observerState.getValue(FLOATING) == true)) {
			if(!canBlockStay(worldIn, observerPos, observerState)) {
				this.dropBlockAsItem(worldIn, observerPos, observerState, 0);
				worldIn.setBlockToAir(observerPos);
			}
		}
	}

	private boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
	{
		if (this.canPlaceBlockAt(worldIn, pos))
		{
			return true;
		}
		else
		{
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
			return false;
		}
	}

	protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		if (!this.canBlockStay(worldIn, pos, state))
		{
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
		}
	}

	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
	{
		IBlockState iblockstate = worldIn.getBlockState(pos.down());
		Material material = iblockstate.getMaterial();
		return material == Material.WATER && ((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0 || material == Material.ICE || (iblockstate.getBlock() instanceof BlockCauldron && iblockstate.getValue(BlockCauldron.LEVEL) == 3);
	}

	/**
	 * Called after the block is set in the Chunk data, but before the Tile Entity is set
	 */
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		Random rand = new Random();
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + rand.nextInt(10));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if(state.getValue(FLOATING)) {
			this.checkAndDropBlock(worldIn, pos, state);
		}
	}

	/**
	 * Check whether this Block can be placed at pos, while aiming at the specified side of an adjacent block
	 */
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side)
	{
		return canPlaceBlock(worldIn, pos, side);
	}

	/**
	 * Checks if this block can be placed exactly at the given position.
	 */
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		for (EnumFacing enumfacing : EnumFacing.values())
		{
			if (canPlaceBlock(worldIn, pos, enumfacing))
			{
				return true;
			}
		}

		return false;
	}

	/**
	 * Check whether this block can be placed on the block in the given direction.
	 */
	protected static boolean canPlaceBlock(World worldIn, BlockPos pos, EnumFacing direction)
	{
		BlockPos blockpos = pos.offset(direction.getOpposite());
		IBlockState iblockstate = worldIn.getBlockState(blockpos);
		BlockFaceShape blockfaceshape = iblockstate.getBlockFaceShape(worldIn, blockpos, direction);
		Block block = iblockstate.getBlock();

		if (direction == EnumFacing.UP)
		{
			if(worldIn.getBlockState(blockpos.up()).getMaterial() == Material.WATER && worldIn.getBlockState(blockpos.up().up()).getMaterial() != Material.WATER) {
				return false;
			} else if(block instanceof BlockTrapDoor && !isTrapdoorValid(iblockstate, direction)) {
				return false;
			} else if(block instanceof BlockCardboardLantern && iblockstate.getValue(FACING).getAxis() == EnumFacing.Axis.Y) {
				return false;
			} else {
				return true;
			}
		} else if (direction != EnumFacing.DOWN) {
			return !isExceptBlockForAttachWithPiston(block) && blockfaceshape != BlockFaceShape.UNDEFINED && blockfaceshape != BlockFaceShape.BOWL;
		} else {
			return isValidPos(worldIn, pos, EnumFacing.DOWN);
		}
	}

	protected boolean canFloat(World worldIn, BlockPos pos, EnumFacing direction)
	{
		BlockPos blockpos = pos.offset(direction.getOpposite());
		IBlockState iblockstate = worldIn.getBlockState(blockpos);

		return iblockstate.getBlock() == Blocks.WATER || (iblockstate.getMaterial() == Material.ICE && direction != EnumFacing.DOWN) || (iblockstate.getBlock() instanceof BlockCauldron && iblockstate.getValue(BlockCauldron.LEVEL) == 3);
	}

	protected static boolean isValidPos(World worldIn, BlockPos pos, EnumFacing direction)
	{
		BlockPos blockpos = pos.offset(direction.getOpposite());
		IBlockState state = worldIn.getBlockState(blockpos);
		Block block = state.getBlock();

		if(block instanceof BlockTrapDoor) {
			return isTrapdoorValid(state, direction);
		}

		if(block instanceof BlockHopper) {
			return false;
		}

		if(block.isAir(state, worldIn, blockpos)) {
			return false;
		} else {
			return true;
		}
	}

	protected static boolean isTrapdoorValid(IBlockState state, EnumFacing facing) {
		return state.getProperties().containsKey(BlockTrapDoor.HALF) && (facing == EnumFacing.UP && state.getValue(BlockTrapDoor.HALF) == BlockTrapDoor.DoorHalf.TOP || facing == EnumFacing.DOWN && state.getValue(BlockTrapDoor.HALF) == BlockTrapDoor.DoorHalf.BOTTOM) && !state.getValue(BlockTrapDoor.OPEN);
	}

	/**
	 * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
	 * IBlockstate
	 */
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		if(canPlaceBlock(worldIn, pos, facing)) {
			return this.getDefaultState().withProperty(FACING, facing).withProperty(FLOATING, Boolean.valueOf(canFloat(worldIn, pos, facing)));
		} else {
			return this.getDefaultState().withProperty(FACING, EnumFacing.DOWN).withProperty(FLOATING, Boolean.valueOf(canFloat(worldIn, pos, facing)));
		}
	}

	/**
	 * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
	 * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
	 */
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return BlockFaceShape.UNDEFINED;
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		EnumFacing enumfacing;

		switch (meta & 7)
		{
		case 0:
			enumfacing = EnumFacing.DOWN;
			break;
		case 1:
			enumfacing = EnumFacing.EAST;
			break;
		case 2:
			enumfacing = EnumFacing.WEST;
			break;
		case 3:
			enumfacing = EnumFacing.SOUTH;
			break;
		case 4:
			enumfacing = EnumFacing.NORTH;
			break;
		case 5:
		default:
			enumfacing = EnumFacing.UP;
		}

		return this.getDefaultState().withProperty(FACING, enumfacing).withProperty(FLOATING, Boolean.valueOf((meta & 8) > 0));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i;

		switch ((EnumFacing)state.getValue(FACING))
		{
		case EAST:
			i = 1;
			break;
		case WEST:
			i = 2;
			break;
		case SOUTH:
			i = 3;
			break;
		case NORTH:
			i = 4;
			break;
		case UP:
		default:
			i = 5;
			break;
		case DOWN:
			i = 0;
		}

		if (((Boolean)state.getValue(FLOATING)).booleanValue())
		{
			i |= 8;
		}

		return i;
	}

	/**
	 * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
	 * blockstate.
	 */
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}

	/**
	 * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
	 * blockstate.
	 */
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	{
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING, FLOATING});
	}

}
