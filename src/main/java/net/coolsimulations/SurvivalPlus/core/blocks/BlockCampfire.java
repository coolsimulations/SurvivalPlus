package net.coolsimulations.SurvivalPlus.core.blocks;

import java.util.Random;

import net.coolsimulations.SurvivalPlus.api.SPAchievements;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCampfire extends Block{
	
    protected static final AxisAlignedBB CampfireSouth_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.875D, 0.5D, 0.9375D);
    protected static final AxisAlignedBB CampfireNorth_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.9375D, 0.5D, 0.9375D);
    protected static final AxisAlignedBB CampfireEast_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.125D, 0.875D, 0.5D, 0.9375D);
    protected static final AxisAlignedBB CampfireWest_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.0625D, 0.9375D, 0.5D, 0.875D);
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool BURNING = PropertyBool.create("burning");

	public BlockCampfire(boolean isBurning) {
		super(Material.WOOD);
		
		IBlockState state;
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(BURNING, Boolean.valueOf(isBurning)));
		this.blockSoundType = SoundType.WOOD;
		this.setHarvestLevel("axe", 0);
		this.setHardness(1.5F);
		this.setResistance(3.5F);
		this.setLightOpacity(1);
		this.setLightLevel(0.0F);
		this.setTickRandomly(true);
	}
	
	@Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos)
    {
    	if (state.getValue(BURNING) == true)
        {
    		return 13;
        }
    	else
    	{
    		return 0;
    	}
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
	
    @SuppressWarnings("incomplete-switch")
    @Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
        
		switch (enumfacing)
        {
            case WEST:
            	return CampfireWest_AABB;
            
            case EAST:
            	return CampfireEast_AABB;
            
            case NORTH:
            	return CampfireNorth_AABB;
            
            case SOUTH:
            	return CampfireSouth_AABB;
        }
		return null;
    }
	
    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(SPBlocks.campfire);
    }

    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
    	Random rand = new Random();
        this.setDefaultFacing(worldIn, pos, state);
        worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + rand.nextInt(10));
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.north());
            IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
            IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
            IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }

    @SideOnly(Side.CLIENT)
    @SuppressWarnings("incomplete-switch")
    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        if (stateIn.getValue(BURNING) == true && !canDie(worldIn, pos))
        {
            EnumFacing enumfacing = (EnumFacing)stateIn.getValue(FACING);
            /**double df0 = (double)pos.getX() + 0.5D;
            double df1 = (double)pos.getY() + rand.nextDouble() * 6.0D / 16.0D;
            double df2 = (double)pos.getZ() + 0.5D;
            double df3 = 0.52D;
            double df4 = rand.nextDouble() * 0.6D - 0.3D;**/
            
            double dfx1 = (double)pos.getX() + 0.1D;
            double dfx15 = (double)pos.getX() + 0.15D;
            double dfx2 = (double)pos.getX() + 0.2D;
            double dfx3 = (double)pos.getX() + 0.3D;
            double dfx4 = (double)pos.getX() + 0.4D;
            double dfx5 = (double)pos.getX() + 0.5D;
            double dfx6 = (double)pos.getX() + 0.6D;
            double dfx7 = (double)pos.getX() + 0.7D;
            double dfx8 = (double)pos.getX() + 0.8D;
            double dfx85 = (double)pos.getX() + 0.85D;
            double dfx9 = (double)pos.getX() + 0.9D;
            
            double dfy4 = (double)pos.getY() + 0.4D;
            double dfy5 = (double)pos.getY() + 0.5D;
            double dfy6 = (double)pos.getY() + 0.6D;
            double dfy7 = (double)pos.getZ() + 0.7D;
            double dfy8 = (double)pos.getY() + 0.8D;
            
            double dfz1 = (double)pos.getZ() + 0.1D;
            double dfz15 = (double)pos.getZ() + 0.15D;
            double dfz2 = (double)pos.getZ() + 0.2D;
            double dfz3 = (double)pos.getZ() + 0.3D;
            double dfz4 = (double)pos.getZ() + 0.4D;
            double dfz5 = (double)pos.getZ() + 0.5D;
            double dfz85 = (double)pos.getZ() + 0.85D;
            double dfz6 = (double)pos.getZ() + 0.6D;
            double dfz7 = (double)pos.getZ() + 0.7D;
            double dfz8 = (double)pos.getZ() + 0.8D;
            double dfz9 = (double)pos.getZ() + 0.9D;
            
            //defaultSmoke
            double d0 = (double)pos.getX() + rand.nextDouble();
            double d1 = (double)pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
            double d2 = (double)pos.getZ() + rand.nextDouble();
            
            double d8 = d0 + (double)rand.nextFloat();
            double d4 = d1 + stateIn.getBoundingBox(worldIn, pos).maxY;
            double d6 = d2 + (double)rand.nextFloat();

            if (rand.nextDouble() < 0.1D)
            {
            	 worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
            }

            switch (enumfacing)
            {
                case WEST:
                	worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx6, dfy6, dfz4, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.6D y: 0.6D z: 0.4D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx4, dfy5, dfz4, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.6D y: 0.5D z: 0.4D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx6, dfy5, dfz2, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.6D y: 0.5D z: 0.2D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx4, dfy6, dfz6, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.4D y: 0.6D z: 0.6D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx5, dfy4, dfz7, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.5D y: 0.4D z: 0.7D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx2, dfy5, dfz9, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.2D y: 0.5D z: 0.9D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx2, dfy5, dfz1, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.2D y: 0.5D z: 0.1D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx7, dfy5, dfz8, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.7D y: 0.5D z: 0.8D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx7, dfy5, dfz1, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.7D y: 0.5D z: 0.1D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx2, dfy5, dfz8, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.2D y: 0.5D z: 0.8D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx7, dfy6, dfz7, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.7D y: 0.7D z: 0.7D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx8, dfy6, dfz1, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.8D y: 0.7D z: 0.1D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx5, dfy4, dfz3, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.5D y: 0.4D z: 0.3D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx15, dfy5, dfz5, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.5D y: 0.5D z: 0.15D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx15, dfy5, dfz7, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.15D y: 0.5D z: 0.7D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx15, dfy5, dfz3, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.15D y: 0.5D z: 0.3D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx85, dfy5, dfz5, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.85D y: 0.5D z: 0.5D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx85, dfy5, dfz7, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.85D y: 0.5D z: 0.7D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx85, dfy5, dfz3, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.85D y: 0.5D z: 0.3D
                    worldIn.spawnParticle(EnumParticleTypes.LAVA, d8, d4, d6, 0.0D, 0.0D, 0.0D, new int[0]);
                    break;
                case EAST:
                	worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx4, dfy6, dfz6, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.4D y: 0.6D z: 0.6D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx6, dfy5, dfz6, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.6D y: 0.5D z: 0.6D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx4, dfy5, dfz8, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.4D y: 0.5D z: 0.8D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx6, dfy6, dfz4, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.8D y: 0.6D z: 0.8D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx5, dfy4, dfz3, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.5D y: 0.4D z: 0.3D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx8, dfy5, dfz1, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.8D y: 0.5D z: 0.1D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx8, dfy5, dfz9, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.8D y: 0.5D z: 0.1D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx3, dfy5, dfz2, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.3D y: 0.5D z: 0.2D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx3, dfy5, dfz9, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.7D y: 0.5D z: 0.9D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx8, dfy5, dfz2, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.8D y: 0.5D z: 0.2D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx3, dfy6, dfz3, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.3D y: 0.7D z: 0.3D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx1, dfy6, dfz8, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.1D y: 0.7D z: 0.8D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx5, dfy4, dfz7, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.5D y: 0.4D z: 0.7D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx85, dfy5, dfz5, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.85D y: 0.5D z: 0.5D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx85, dfy5, dfz3, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.85D y: 0.5D z: 0.3D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx85, dfy5, dfz7, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.85D y: 0.5D z: 0.7D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx15, dfy5, dfz5, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.15D y: 0.5D z: 0.5D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx15, dfy5, dfz3, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.15D y: 0.5D z: 0.3D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx15, dfy5, dfz7, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.15D y: 0.5D z: 0.7D
                    worldIn.spawnParticle(EnumParticleTypes.LAVA, d8, d4, d6, 0.0D, 0.0D, 0.0D, new int[0]);
                    break;
                case NORTH:
                	worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx6, dfy6, dfz6, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.6D y: 0.6D z: 0.6D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx6, dfy5, dfz4, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.6D y: 0.5D z: 0.4D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx8, dfy5, dfz6, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.8D y: 0.5D z: 0.6D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx4, dfy6, dfz4, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.4D y: 0.6D z: 0.8D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx3, dfy4, dfz5, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.3D y: 0.4D z: 0.5D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx1, dfy5, dfz2, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.1D y: 0.5D z: 0.2D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx9, dfy5, dfz2, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.9D y: 0.5D z: 0.2D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx2, dfy5, dfz7, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.2D y: 0.5D z: 0.7D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx9, dfy5, dfz7, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.9D y: 0.5D z: 0.7D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx2, dfy5, dfz2, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.2D y: 0.5D z: 0.2D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx7, dfy6, dfz3, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.7D y: 0.7D z: 0.3D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx9, dfy6, dfz8, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.9D y: 0.7D z: 0.8D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx7, dfy4, dfz5, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.7D y: 0.4D z: 0.5D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx5, dfy5, dfz15, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.5D y: 0.5D z: 0.15D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx3, dfy5, dfz15, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.3D y: 0.5D z: 0.15D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx7, dfy5, dfz15, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.7D y: 0.5D z: 0.15D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx5, dfy5, dfz85, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.5D y: 0.5D z: 0.85D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx3, dfy5, dfz85, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.3D y: 0.5D z: 0.85D
                	worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx7, dfy5, dfz85, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.7D y: 0.5D z: 0.85D
                    worldIn.spawnParticle(EnumParticleTypes.LAVA, d8, d4, d6, 0.0D, 0.0D, 0.0D, new int[0]);
                    break;
                case SOUTH:
                	worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx4, dfy6, dfz4, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.4D y: 0.6D z: 0.4D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx4, dfy5, dfz6, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.4D y: 0.5D z: 0.6D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx2, dfy5, dfz4, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.2D y: 0.5D z: 0.4D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx6, dfy6, dfz6, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.6D y: 0.6D z: 0.6D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx7, dfy4, dfz5, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.7D y: 0.4D z: 0.5D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx9, dfy5, dfz8, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.9D y: 0.5D z: 0.8D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx1, dfy5, dfz8, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.1D y: 0.5D z: 0.8D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx8, dfy5, dfz3, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.8D y: 0.5D z: 0.3D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx1, dfy5, dfz3, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.1D y: 0.5D z: 0.3D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx8, dfy5, dfz8, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.8D y: 0.5D z: 0.8D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx3, dfy6, dfz7, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.7D y: 0.7D z: 0.7D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx1, dfy6, dfz2, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.1D y: 0.7D z: 0.2D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx3, dfy4, dfz5, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.3D y: 0.4D z: 0.5D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx5, dfy5, dfz85, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.5D y: 0.5D z: 0.85D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx7, dfy5, dfz85, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.7D y: 0.5D z: 0.85D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx3, dfy5, dfz85, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.3D y: 0.5D z: 0.85D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx5, dfy5, dfz15, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.5D y: 0.5D z: 0.15D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx7, dfy5, dfz15, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.7D y: 0.5D z: 0.15D
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, dfx3, dfy5, dfz15, 0.0D, 0.0D, 0.0D, new int[0]); //x: 0.3D y: 0.5D z: 0.15D
                    worldIn.spawnParticle(EnumParticleTypes.LAVA, d8, d4, d6, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
        else {
        	worldIn.setBlockState(pos, SPBlocks.campfire.getDefaultState().withProperty(FACING, stateIn.getValue(FACING)), 3);
        }
    }
    
    /**
     * Called when the block is right clicked by a player.
     */
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	ItemStack itemStackIn = playerIn.getHeldItem(hand);
    	Item item = itemStackIn.getItem();
    	Item water_bottle = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER).getItem();
    	String fluid;
    	FluidStack fluidStack;
    	
    	if(itemStackIn.hasTagCompound()) {
    		fluidStack = FluidStack.loadFluidStackFromNBT(itemStackIn.getTagCompound().getCompoundTag("Fluid"));
    	} else {
    		fluidStack = null;
    	}
    	
    	if(fluidStack != null){
    		fluid = FluidRegistry.getFluidName(fluidStack);
    	} else {
    		fluid = null;
    	}
    	
    	IBlockState iblockstate = worldIn.getBlockState(pos);
    	//defaultSmoke
        double d0 = (double)pos.getX() + worldIn.rand.nextDouble();
        double d1 = (double)pos.getY() + worldIn.rand.nextDouble() * 0.5D + 0.5D;
        double d2 = (double)pos.getZ() + worldIn.rand.nextDouble();
    	
    	if(!worldIn.isRemote && item == Items.FLINT_AND_STEEL && state.getValue(BURNING) == false && !canDie(worldIn, pos)) {
    		worldIn.setBlockState(pos, state.withProperty(FACING, iblockstate.getValue(FACING)).withProperty(BURNING, Boolean.valueOf(true)), 3);
    		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
    		itemStackIn.damageItem(1, playerIn);
    		if(!playerIn.hasAchievement(SPAchievements.achievementCampfire)) {
    			playerIn.addStat(SPAchievements.achievementCampfire);
    		}
		}
    	else if(!worldIn.isRemote && item == Items.FIRE_CHARGE && state.getValue(BURNING) == false && !canDie(worldIn, pos)) {
    		worldIn.setBlockState(pos, state.withProperty(FACING, iblockstate.getValue(FACING)).withProperty(BURNING, Boolean.valueOf(true)), 3);
    		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
    		if(!playerIn.capabilities.isCreativeMode){
    			if (ItemStack.areItemStacksEqual(playerIn.getHeldItemOffhand(), itemStackIn))
    			{
    				playerIn.setHeldItem(EnumHand.OFF_HAND, ItemStack.EMPTY);
    			}
    			else
    			{
    				playerIn.setHeldItem(EnumHand.MAIN_HAND, ItemStack.EMPTY);
    			}
    		}
    		if(!playerIn.hasAchievement(SPAchievements.achievementCampfire)) {
    			playerIn.addStat(SPAchievements.achievementCampfire);
    		}
		}
    	else if(!worldIn.isRemote && item == Items.LAVA_BUCKET && state.getValue(BURNING) == false) {
    		worldIn.setBlockState(pos, state.withProperty(FACING, iblockstate.getValue(FACING)).withProperty(BURNING, Boolean.valueOf(true)), 3);
    		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.ITEM_BUCKET_EMPTY_LAVA, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
    		if(!playerIn.capabilities.isCreativeMode){
    			if (ItemStack.areItemStacksEqual(playerIn.getHeldItemOffhand(), itemStackIn))
    			{
    				playerIn.setHeldItem(EnumHand.OFF_HAND, new ItemStack(Items.BUCKET));
    			}
    			else
    			{
    				playerIn.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.BUCKET));
    			}
    		}
    		if(!playerIn.hasAchievement(SPAchievements.achievementCampfire)) {
    			playerIn.addStat(SPAchievements.achievementCampfire);
    		}
    	}
    	else if(!worldIn.isRemote && item == Items.WATER_BUCKET && state.getValue(BURNING) == true) {
    		worldIn.setBlockState(pos, state.withProperty(FACING, iblockstate.getValue(FACING)).withProperty(BURNING, Boolean.valueOf(false)), 3);
    		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
    		worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
    		if(!playerIn.capabilities.isCreativeMode){
    			if (ItemStack.areItemStacksEqual(playerIn.getHeldItemOffhand(), itemStackIn))
				{
    			playerIn.setHeldItem(EnumHand.OFF_HAND, new ItemStack(Items.BUCKET));
				}
				else
				{
    				playerIn.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.BUCKET));
				}
    		}
    	}
    	else if(!worldIn.isRemote && item == water_bottle && state.getValue(BURNING) == true) {
    		worldIn.setBlockState(pos, state.withProperty(FACING, iblockstate.getValue(FACING)).withProperty(BURNING, Boolean.valueOf(false)), 3);
    		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
    		worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
    		if(!playerIn.capabilities.isCreativeMode){
    			if (ItemStack.areItemStacksEqual(playerIn.getHeldItemOffhand(), itemStackIn))
    			{
    				playerIn.setHeldItem(EnumHand.OFF_HAND, new ItemStack(Items.GLASS_BOTTLE));
    			}
    			else
    			{
    				playerIn.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.GLASS_BOTTLE));
    			}
    		}
    	}
    	else if(!worldIn.isRemote && item == Items.BUCKET && state.getValue(BURNING) == true && !playerIn.capabilities.isCreativeMode) {
    		worldIn.setBlockState(pos, state.withProperty(FACING, iblockstate.getValue(FACING)).withProperty(BURNING, Boolean.valueOf(false)), 3);
    		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_GRAVEL_STEP, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
    		worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
    		if(itemStackIn.getCount() == 1) {
    			if (ItemStack.areItemStacksEqual(playerIn.getHeldItemOffhand(), itemStackIn))
    			{
    				playerIn.setHeldItem(EnumHand.OFF_HAND, new ItemStack(SPItems.charcoal_bucket));
    			}
    			else
    			{
   					playerIn.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(SPItems.charcoal_bucket));
   				}
    		} else  if(itemStackIn.getCount() >= 2){
    			itemStackIn.shrink(1);
    			boolean flag = playerIn.inventory.addItemStackToInventory(new ItemStack(SPItems.charcoal_bucket));
    			if(!flag) {
    				playerIn.dropItem(new ItemStack(SPItems.charcoal_bucket), false);
    			}
    			
    		}
    	}
    	if(fluid != null) {
    		if(!worldIn.isRemote && fluid == FluidRegistry.getFluidName(FluidRegistry.LAVA) && state.getValue(BURNING) == false) {
    			worldIn.setBlockState(pos, state.withProperty(FACING, iblockstate.getValue(FACING)).withProperty(BURNING, Boolean.valueOf(true)), 3);
        		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.ITEM_BUCKET_EMPTY_LAVA, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
        		if(!playerIn.capabilities.isCreativeMode){
        			itemStackIn.getTagCompound().removeTag("Fluid");
        			itemStackIn.getTagCompound().removeTag("Amount");
    				//IFluidHandler handler = FluidUtil.getFluidHandler(itemStackIn);
    				//handler.drain(1000, true);
        		}
        		if(!playerIn.hasAchievement(SPAchievements.achievementCampfire)) {
        			playerIn.addStat(SPAchievements.achievementCampfire);
        		}
        	}
    		else if(!worldIn.isRemote && fluid == FluidRegistry.getFluidName(FluidRegistry.WATER) && state.getValue(BURNING) == true) {
        		worldIn.setBlockState(pos, state.withProperty(FACING, iblockstate.getValue(FACING)).withProperty(BURNING, Boolean.valueOf(false)), 3);
        		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
        		worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
        		if(!playerIn.capabilities.isCreativeMode){
        			itemStackIn.getTagCompound().removeTag("Fluid");
        			itemStackIn.getTagCompound().removeTag("Amount");
        		}
        	}
    	}

    	return true;
    }
    
    /**
     * How many world ticks before ticking
     */
    @Override
    public int tickRate(World worldIn)
    {
        return 30;
    }
    
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
    	//defaultSmoke
        double d0 = (double)pos.getX() + rand.nextDouble();
        double d1 = (double)pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
        double d2 = (double)pos.getZ() + rand.nextDouble();
    	
    	if (canDie(worldIn, pos) && state.getValue(BURNING) == true) {
    		worldIn.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, Boolean.valueOf(false)), 3);
    		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, rand.nextFloat() * 0.4F + 0.8F, false);
    		worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
    	}
    	
    	worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + rand.nextInt(10));
    }
    
    protected boolean canDie(World worldIn, BlockPos pos)
    {
        return worldIn.isRainingAt(pos) || worldIn.isRainingAt(pos.west()) || worldIn.isRainingAt(pos.east()) || worldIn.isRainingAt(pos.north()) || worldIn.isRainingAt(pos.south());
    }
    
    /**
     * Sets player on fire if the collide with the campfire 
     */
    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
    {
    	if (state.getValue(BURNING) == true)
        {
	    	if (entity instanceof EntityLivingBase) {
	            entity.setFire(1); 
	        }
        }
    }

    /**
     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    /**
     * Called by ItemBlocks after a block is set in the world, to allow post-place logic
     */
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

    }

    /**
     * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
     */
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(SPBlocks.campfire);
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
                enumfacing = EnumFacing.EAST;
                break;
            case 1:
                enumfacing = EnumFacing.WEST;
                break;
            case 2:
                enumfacing = EnumFacing.SOUTH;
                break;
            case 3:
            default:
                enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing).withProperty(BURNING, Boolean.valueOf((meta & 8) > 0));
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

        if (((Boolean)state.getValue(BURNING)).booleanValue())
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
        return new BlockStateContainer(this, new IProperty[] {FACING, BURNING});
    }
}