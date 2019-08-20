package net.coolsimulations.SurvivalPlus.core.blocks;

import java.util.Random;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.Particles;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionUtils;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReaderBase;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fluids.FluidStack;

public class BlockCampfire extends Block{
	
    protected static final VoxelShape CampfireSouth_AABB = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 14.0D, 8.0D, 15.0D);
    protected static final VoxelShape CampfireNorth_AABB = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 15.0D, 8.0D, 15.0D);
    protected static final VoxelShape CampfireEast_AABB = Block.makeCuboidShape(1.0D, 0.0D, 2.0D, 14.D, 8.0D, 15.0D);
    protected static final VoxelShape CampfireWest_AABB = Block.makeCuboidShape(2.0D, 0.0D, 1.0D, 15.D, 8.0D, 14.D);
	public static final DirectionProperty FACING = BlockHorizontal.HORIZONTAL_FACING;
	public static final BooleanProperty BURNING = BooleanProperty.create("burning");

	public BlockCampfire(boolean isBurning) {
		super(Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F, 3.5F).lightValue(0).needsRandomTick());
		
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.NORTH).with(BURNING, Boolean.valueOf(isBurning)));
	}
	
	@Override
	public ToolType getHarvestTool(IBlockState state) {
		return ToolType.AXE;
	}
	
	@Override
    public int getLightValue(IBlockState state)
    {
    	if (state.get(BURNING) == true)
        {
    		return 13;
        }
    	else
    	{
    		return 0;
    	}
    }
	
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
    public VoxelShape getShape(IBlockState state, IBlockReader source, BlockPos pos) {
        EnumFacing enumfacing = (EnumFacing)state.get(FACING);
        
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
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int amount) {
        return SPBlocks.campfire.asItem();
    }

    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
    /**@Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
    	Random rand = new Random();
        this.setDefaultFacing(worldIn, pos, state);
        worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + rand.nextInt(10));
    }**/

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.north());
            IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
            IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
            IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
            EnumFacing enumfacing = (EnumFacing)state.get(FACING);

            if (enumfacing == EnumFacing.NORTH && iblockstate.isFullCube() && !iblockstate1.isFullCube())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullCube() && !iblockstate.isFullCube())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullCube() && !iblockstate3.isFullCube())
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullCube() && !iblockstate2.isFullCube())
            {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.with(FACING, enumfacing), 2);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @SuppressWarnings("incomplete-switch")
    @Override
    public void animateTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        if (stateIn.get(BURNING) == true && !canDie(worldIn, pos))
        {
            EnumFacing enumfacing = (EnumFacing)stateIn.get(FACING);
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
            double d4 = d1 + pos.up().getY();
            double d6 = d2 + (double)rand.nextFloat();

            if (rand.nextDouble() < 0.1D)
            {
            	 worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
            }

            switch (enumfacing)
            {
                case WEST:
                	worldIn.spawnParticle(Particles.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
                	worldIn.spawnParticle(Particles.FLAME, dfx6, dfy6, dfz4, 0.0D, 0.0D, 0.0D); //x: 0.6D y: 0.6D z: 0.4D
                	worldIn.spawnParticle(Particles.FLAME, dfx4, dfy5, dfz4, 0.0D, 0.0D, 0.0D); //x: 0.6D y: 0.5D z: 0.4D
                	worldIn.spawnParticle(Particles.FLAME, dfx6, dfy5, dfz2, 0.0D, 0.0D, 0.0D); //x: 0.6D y: 0.5D z: 0.2D
                	worldIn.spawnParticle(Particles.FLAME, dfx4, dfy6, dfz6, 0.0D, 0.0D, 0.0D); //x: 0.4D y: 0.6D z: 0.6D
                	worldIn.spawnParticle(Particles.FLAME, dfx5, dfy4, dfz7, 0.0D, 0.0D, 0.0D); //x: 0.5D y: 0.4D z: 0.7D
                	worldIn.spawnParticle(Particles.FLAME, dfx2, dfy5, dfz9, 0.0D, 0.0D, 0.0D); //x: 0.2D y: 0.5D z: 0.9D
                	worldIn.spawnParticle(Particles.FLAME, dfx2, dfy5, dfz1, 0.0D, 0.0D, 0.0D); //x: 0.2D y: 0.5D z: 0.1D
                	worldIn.spawnParticle(Particles.FLAME, dfx7, dfy5, dfz8, 0.0D, 0.0D, 0.0D); //x: 0.7D y: 0.5D z: 0.8D
                	worldIn.spawnParticle(Particles.FLAME, dfx7, dfy5, dfz1, 0.0D, 0.0D, 0.0D); //x: 0.7D y: 0.5D z: 0.1D
                	worldIn.spawnParticle(Particles.FLAME, dfx2, dfy5, dfz8, 0.0D, 0.0D, 0.0D); //x: 0.2D y: 0.5D z: 0.8D
                	worldIn.spawnParticle(Particles.FLAME, dfx7, dfy6, dfz7, 0.0D, 0.0D, 0.0D); //x: 0.7D y: 0.7D z: 0.7D
                	worldIn.spawnParticle(Particles.FLAME, dfx8, dfy6, dfz1, 0.0D, 0.0D, 0.0D); //x: 0.8D y: 0.7D z: 0.1D
                	worldIn.spawnParticle(Particles.FLAME, dfx5, dfy4, dfz3, 0.0D, 0.0D, 0.0D); //x: 0.5D y: 0.4D z: 0.3D
                	worldIn.spawnParticle(Particles.FLAME, dfx15, dfy5, dfz5, 0.0D, 0.0D, 0.0D); //x: 0.5D y: 0.5D z: 0.15D
                	worldIn.spawnParticle(Particles.FLAME, dfx15, dfy5, dfz7, 0.0D, 0.0D, 0.0D); //x: 0.15D y: 0.5D z: 0.7D
                	worldIn.spawnParticle(Particles.FLAME, dfx15, dfy5, dfz3, 0.0D, 0.0D, 0.0D); //x: 0.15D y: 0.5D z: 0.3D
                	worldIn.spawnParticle(Particles.FLAME, dfx85, dfy5, dfz5, 0.0D, 0.0D, 0.0D); //x: 0.85D y: 0.5D z: 0.5D
                	worldIn.spawnParticle(Particles.FLAME, dfx85, dfy5, dfz7, 0.0D, 0.0D, 0.0D); //x: 0.85D y: 0.5D z: 0.7D
                	worldIn.spawnParticle(Particles.FLAME, dfx85, dfy5, dfz3, 0.0D, 0.0D, 0.0D); //x: 0.85D y: 0.5D z: 0.3D
                    worldIn.spawnParticle(Particles.LAVA, d8, d4, d6, 0.0D, 0.0D, 0.0D);
                    break;
                case EAST:
                	worldIn.spawnParticle(Particles.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
                	worldIn.spawnParticle(Particles.FLAME, dfx4, dfy6, dfz6, 0.0D, 0.0D, 0.0D); //x: 0.4D y: 0.6D z: 0.6D
                    worldIn.spawnParticle(Particles.FLAME, dfx6, dfy5, dfz6, 0.0D, 0.0D, 0.0D); //x: 0.6D y: 0.5D z: 0.6D
                	worldIn.spawnParticle(Particles.FLAME, dfx4, dfy5, dfz8, 0.0D, 0.0D, 0.0D); //x: 0.4D y: 0.5D z: 0.8D
                    worldIn.spawnParticle(Particles.FLAME, dfx6, dfy6, dfz4, 0.0D, 0.0D, 0.0D); //x: 0.8D y: 0.6D z: 0.8D
                	worldIn.spawnParticle(Particles.FLAME, dfx5, dfy4, dfz3, 0.0D, 0.0D, 0.0D); //x: 0.5D y: 0.4D z: 0.3D
                	worldIn.spawnParticle(Particles.FLAME, dfx8, dfy5, dfz1, 0.0D, 0.0D, 0.0D); //x: 0.8D y: 0.5D z: 0.1D
                	worldIn.spawnParticle(Particles.FLAME, dfx8, dfy5, dfz9, 0.0D, 0.0D, 0.0D); //x: 0.8D y: 0.5D z: 0.1D
                	worldIn.spawnParticle(Particles.FLAME, dfx3, dfy5, dfz2, 0.0D, 0.0D, 0.0D); //x: 0.3D y: 0.5D z: 0.2D
                	worldIn.spawnParticle(Particles.FLAME, dfx3, dfy5, dfz9, 0.0D, 0.0D, 0.0D); //x: 0.7D y: 0.5D z: 0.9D
                	worldIn.spawnParticle(Particles.FLAME, dfx8, dfy5, dfz2, 0.0D, 0.0D, 0.0D); //x: 0.8D y: 0.5D z: 0.2D
                	worldIn.spawnParticle(Particles.FLAME, dfx3, dfy6, dfz3, 0.0D, 0.0D, 0.0D); //x: 0.3D y: 0.7D z: 0.3D
                	worldIn.spawnParticle(Particles.FLAME, dfx1, dfy6, dfz8, 0.0D, 0.0D, 0.0D); //x: 0.1D y: 0.7D z: 0.8D
                	worldIn.spawnParticle(Particles.FLAME, dfx5, dfy4, dfz7, 0.0D, 0.0D, 0.0D); //x: 0.5D y: 0.4D z: 0.7D
                	worldIn.spawnParticle(Particles.FLAME, dfx85, dfy5, dfz5, 0.0D, 0.0D, 0.0D); //x: 0.85D y: 0.5D z: 0.5D
                	worldIn.spawnParticle(Particles.FLAME, dfx85, dfy5, dfz3, 0.0D, 0.0D, 0.0D); //x: 0.85D y: 0.5D z: 0.3D
                	worldIn.spawnParticle(Particles.FLAME, dfx85, dfy5, dfz7, 0.0D, 0.0D, 0.0D); //x: 0.85D y: 0.5D z: 0.7D
                	worldIn.spawnParticle(Particles.FLAME, dfx15, dfy5, dfz5, 0.0D, 0.0D, 0.0D); //x: 0.15D y: 0.5D z: 0.5D
                	worldIn.spawnParticle(Particles.FLAME, dfx15, dfy5, dfz3, 0.0D, 0.0D, 0.0D); //x: 0.15D y: 0.5D z: 0.3D
                	worldIn.spawnParticle(Particles.FLAME, dfx15, dfy5, dfz7, 0.0D, 0.0D, 0.0D); //x: 0.15D y: 0.5D z: 0.7D
                    worldIn.spawnParticle(Particles.LAVA, d8, d4, d6, 0.0D, 0.0D, 0.0D);
                    break;
                case NORTH:
                	worldIn.spawnParticle(Particles.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
                	worldIn.spawnParticle(Particles.FLAME, dfx6, dfy6, dfz6, 0.0D, 0.0D, 0.0D); //x: 0.6D y: 0.6D z: 0.6D
                	worldIn.spawnParticle(Particles.FLAME, dfx6, dfy5, dfz4, 0.0D, 0.0D, 0.0D); //x: 0.6D y: 0.5D z: 0.4D
                	worldIn.spawnParticle(Particles.FLAME, dfx8, dfy5, dfz6, 0.0D, 0.0D, 0.0D); //x: 0.8D y: 0.5D z: 0.6D
                    worldIn.spawnParticle(Particles.FLAME, dfx4, dfy6, dfz4, 0.0D, 0.0D, 0.0D); //x: 0.4D y: 0.6D z: 0.8D
                	worldIn.spawnParticle(Particles.FLAME, dfx3, dfy4, dfz5, 0.0D, 0.0D, 0.0D); //x: 0.3D y: 0.4D z: 0.5D
                	worldIn.spawnParticle(Particles.FLAME, dfx1, dfy5, dfz2, 0.0D, 0.0D, 0.0D); //x: 0.1D y: 0.5D z: 0.2D
                	worldIn.spawnParticle(Particles.FLAME, dfx9, dfy5, dfz2, 0.0D, 0.0D, 0.0D); //x: 0.9D y: 0.5D z: 0.2D
                	worldIn.spawnParticle(Particles.FLAME, dfx2, dfy5, dfz7, 0.0D, 0.0D, 0.0D); //x: 0.2D y: 0.5D z: 0.7D
                	worldIn.spawnParticle(Particles.FLAME, dfx9, dfy5, dfz7, 0.0D, 0.0D, 0.0D); //x: 0.9D y: 0.5D z: 0.7D
                	worldIn.spawnParticle(Particles.FLAME, dfx2, dfy5, dfz2, 0.0D, 0.0D, 0.0D); //x: 0.2D y: 0.5D z: 0.2D
                	worldIn.spawnParticle(Particles.FLAME, dfx7, dfy6, dfz3, 0.0D, 0.0D, 0.0D); //x: 0.7D y: 0.7D z: 0.3D
                	worldIn.spawnParticle(Particles.FLAME, dfx9, dfy6, dfz8, 0.0D, 0.0D, 0.0D); //x: 0.9D y: 0.7D z: 0.8D
                	worldIn.spawnParticle(Particles.FLAME, dfx7, dfy4, dfz5, 0.0D, 0.0D, 0.0D); //x: 0.7D y: 0.4D z: 0.5D
                	worldIn.spawnParticle(Particles.FLAME, dfx5, dfy5, dfz15, 0.0D, 0.0D, 0.0D); //x: 0.5D y: 0.5D z: 0.15D
                	worldIn.spawnParticle(Particles.FLAME, dfx3, dfy5, dfz15, 0.0D, 0.0D, 0.0D); //x: 0.3D y: 0.5D z: 0.15D
                	worldIn.spawnParticle(Particles.FLAME, dfx7, dfy5, dfz15, 0.0D, 0.0D, 0.0D); //x: 0.7D y: 0.5D z: 0.15D
                	worldIn.spawnParticle(Particles.FLAME, dfx5, dfy5, dfz85, 0.0D, 0.0D, 0.0D); //x: 0.5D y: 0.5D z: 0.85D
                	worldIn.spawnParticle(Particles.FLAME, dfx3, dfy5, dfz85, 0.0D, 0.0D, 0.0D); //x: 0.3D y: 0.5D z: 0.85D
                	worldIn.spawnParticle(Particles.FLAME, dfx7, dfy5, dfz85, 0.0D, 0.0D, 0.0D); //x: 0.7D y: 0.5D z: 0.85D
                    worldIn.spawnParticle(Particles.LAVA, d8, d4, d6, 0.0D, 0.0D, 0.0D);
                    break;
                case SOUTH:
                	worldIn.spawnParticle(Particles.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
                    worldIn.spawnParticle(Particles.FLAME, dfx4, dfy6, dfz4, 0.0D, 0.0D, 0.0D); //x: 0.4D y: 0.6D z: 0.4D
                    worldIn.spawnParticle(Particles.FLAME, dfx4, dfy5, dfz6, 0.0D, 0.0D, 0.0D); //x: 0.4D y: 0.5D z: 0.6D
                    worldIn.spawnParticle(Particles.FLAME, dfx2, dfy5, dfz4, 0.0D, 0.0D, 0.0D); //x: 0.2D y: 0.5D z: 0.4D
                    worldIn.spawnParticle(Particles.FLAME, dfx6, dfy6, dfz6, 0.0D, 0.0D, 0.0D); //x: 0.6D y: 0.6D z: 0.6D
                    worldIn.spawnParticle(Particles.FLAME, dfx7, dfy4, dfz5, 0.0D, 0.0D, 0.0D); //x: 0.7D y: 0.4D z: 0.5D
                    worldIn.spawnParticle(Particles.FLAME, dfx9, dfy5, dfz8, 0.0D, 0.0D, 0.0D); //x: 0.9D y: 0.5D z: 0.8D
                    worldIn.spawnParticle(Particles.FLAME, dfx1, dfy5, dfz8, 0.0D, 0.0D, 0.0D); //x: 0.1D y: 0.5D z: 0.8D
                    worldIn.spawnParticle(Particles.FLAME, dfx8, dfy5, dfz3, 0.0D, 0.0D, 0.0D); //x: 0.8D y: 0.5D z: 0.3D
                    worldIn.spawnParticle(Particles.FLAME, dfx1, dfy5, dfz3, 0.0D, 0.0D, 0.0D); //x: 0.1D y: 0.5D z: 0.3D
                    worldIn.spawnParticle(Particles.FLAME, dfx8, dfy5, dfz8, 0.0D, 0.0D, 0.0D); //x: 0.8D y: 0.5D z: 0.8D
                    worldIn.spawnParticle(Particles.FLAME, dfx3, dfy6, dfz7, 0.0D, 0.0D, 0.0D); //x: 0.7D y: 0.7D z: 0.7D
                    worldIn.spawnParticle(Particles.FLAME, dfx1, dfy6, dfz2, 0.0D, 0.0D, 0.0D); //x: 0.1D y: 0.7D z: 0.2D
                    worldIn.spawnParticle(Particles.FLAME, dfx3, dfy4, dfz5, 0.0D, 0.0D, 0.0D); //x: 0.3D y: 0.4D z: 0.5D
                    worldIn.spawnParticle(Particles.FLAME, dfx5, dfy5, dfz85, 0.0D, 0.0D, 0.0D); //x: 0.5D y: 0.5D z: 0.85D
                    worldIn.spawnParticle(Particles.FLAME, dfx7, dfy5, dfz85, 0.0D, 0.0D, 0.0D); //x: 0.7D y: 0.5D z: 0.85D
                    worldIn.spawnParticle(Particles.FLAME, dfx3, dfy5, dfz85, 0.0D, 0.0D, 0.0D); //x: 0.3D y: 0.5D z: 0.85D
                    worldIn.spawnParticle(Particles.FLAME, dfx5, dfy5, dfz15, 0.0D, 0.0D, 0.0D); //x: 0.5D y: 0.5D z: 0.15D
                    worldIn.spawnParticle(Particles.FLAME, dfx7, dfy5, dfz15, 0.0D, 0.0D, 0.0D); //x: 0.7D y: 0.5D z: 0.15D
                    worldIn.spawnParticle(Particles.FLAME, dfx3, dfy5, dfz15, 0.0D, 0.0D, 0.0D); //x: 0.3D y: 0.5D z: 0.15D
                    worldIn.spawnParticle(Particles.LAVA, d8, d4, d6, 0.0D, 0.0D, 0.0D);
            }
        }
        else {
        	worldIn.setBlockState(pos, SPBlocks.campfire.getDefaultState().with(FACING, stateIn.get(FACING)), 3);
        }
    }
    
    /**
     * Called when the block is right clicked by a player.
     */
    @Override
    public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	ItemStack itemStackIn = playerIn.getHeldItem(hand);
    	Item item = itemStackIn.getItem();
    	Item water_bottle = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), PotionTypes.WATER).getItem();
    	String fluid;
    	FluidStack fluidStack;
    	
    	if(itemStackIn.hasTag()) {
    		fluidStack = FluidStack.loadFluidStackFromNBT((NBTTagCompound) itemStackIn.getTag().getTag("Fluid"));
    	} else {
    		fluidStack = null;
    	}
    	
    	if(fluidStack != null){
    		fluid = fluidStack.getFluid().getUnlocalizedName();
    	} else {
    		fluid = null;
    	}
    	
    	IBlockState iblockstate = worldIn.getBlockState(pos);
    	//defaultSmoke
        double d0 = (double)pos.getX() + worldIn.rand.nextDouble();
        double d1 = (double)pos.getY() + worldIn.rand.nextDouble() * 0.5D + 0.5D;
        double d2 = (double)pos.getZ() + worldIn.rand.nextDouble();
    	
    	if(!worldIn.isRemote && item == Items.FLINT_AND_STEEL && state.get(BURNING) == false && !canDie(worldIn, pos)) {
    		worldIn.setBlockState(pos, state.with(FACING, iblockstate.get(FACING)).with(BURNING, Boolean.valueOf(true)), 3);
    		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
    		itemStackIn.damageItem(1, playerIn);
		}
    	else if(!worldIn.isRemote && item == Items.FIRE_CHARGE && state.get(BURNING) == false && !canDie(worldIn, pos)) {
    		worldIn.setBlockState(pos, state.with(FACING, iblockstate.get(FACING)).with(BURNING, Boolean.valueOf(true)), 3);
    		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
    		if(!playerIn.abilities.isCreativeMode){
    			if (ItemStack.areItemStacksEqual(playerIn.getHeldItemOffhand(), itemStackIn))
    			{
    				playerIn.setHeldItem(EnumHand.OFF_HAND, ItemStack.EMPTY);
    			}
    			else
    			{
    				playerIn.setHeldItem(EnumHand.MAIN_HAND, ItemStack.EMPTY);
    			}
    		}
		}
    	else if(!worldIn.isRemote && item == Items.LAVA_BUCKET && state.get(BURNING) == false) {
    		worldIn.setBlockState(pos, state.with(FACING, iblockstate.get(FACING)).with(BURNING, Boolean.valueOf(true)), 3);
    		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.ITEM_BUCKET_EMPTY_LAVA, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
    		if(!playerIn.abilities.isCreativeMode){
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
    	else if(!worldIn.isRemote && item == Items.WATER_BUCKET && state.get(BURNING) == true) {
    		worldIn.setBlockState(pos, state.with(FACING, iblockstate.get(FACING)).with(BURNING, Boolean.valueOf(false)), 3);
    		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
    		worldIn.spawnParticle(Particles.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    		if(!playerIn.abilities.isCreativeMode){
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
    	else if(!worldIn.isRemote && item == water_bottle && state.get(BURNING) == true) {
    		worldIn.setBlockState(pos, state.with(FACING, iblockstate.get(FACING)).with(BURNING, Boolean.valueOf(false)), 3);
    		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
    		worldIn.spawnParticle(Particles.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    		if(!playerIn.abilities.isCreativeMode){
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
    	else if(!worldIn.isRemote && item == Items.BUCKET && state.get(BURNING) == true && !playerIn.abilities.isCreativeMode) {
    		worldIn.setBlockState(pos, state.with(FACING, iblockstate.get(FACING)).with(BURNING, Boolean.valueOf(false)), 3);
    		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_GRAVEL_STEP, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
    		worldIn.spawnParticle(Particles.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
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
    		if(!worldIn.isRemote && fluid == "lava" && state.get(BURNING) == false) {
    			worldIn.setBlockState(pos, state.with(FACING, iblockstate.get(FACING)).with(BURNING, Boolean.valueOf(true)), 3);
        		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.ITEM_BUCKET_EMPTY_LAVA, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
        		if(!playerIn.abilities.isCreativeMode){
        			itemStackIn.getTag().removeTag("Fluid");
        			itemStackIn.getTag().removeTag("Amount");
    				//IFluidHandler handler = FluidUtil.getFluidHandler(itemStackIn);
    				//handler.drain(1000, true);
        		}
        	}
    		else if(!worldIn.isRemote && fluid == "water" && state.get(BURNING) == true) {
        		worldIn.setBlockState(pos, state.with(FACING, iblockstate.get(FACING)).with(BURNING, Boolean.valueOf(false)), 3);
        		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
        		worldIn.spawnParticle(Particles.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        		if(!playerIn.abilities.isCreativeMode){
        			itemStackIn.getTag().removeTag("Fluid");
        			itemStackIn.getTag().removeTag("Amount");
        		}
        	}
    	}

    	return true;
    }
    
    /**
     * How many world ticks before ticking
     */
    @Override
    public int tickRate(IWorldReaderBase worldIn)
    {
        return 30;
    }
    
    @Override
    public void tick(IBlockState state, World worldIn, BlockPos pos, Random rand) {
    	//defaultSmoke
        double d0 = (double)pos.getX() + rand.nextDouble();
        double d1 = (double)pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
        double d2 = (double)pos.getZ() + rand.nextDouble();
    	
    	if (canDie(worldIn, pos) && state.get(BURNING) == true) {
    		worldIn.setBlockState(pos, state.with(FACING, state.get(FACING)).with(BURNING, Boolean.valueOf(false)), 3);
    		worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, rand.nextFloat() * 0.4F + 0.8F, false);
    		worldIn.spawnParticle(Particles.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    	}
    	
    	//worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + rand.nextInt(10));
    }
    
    protected static boolean canDie(World worldIn, BlockPos pos)
    {
        return worldIn.isRainingAt(pos) || worldIn.isRainingAt(pos.west()) || worldIn.isRainingAt(pos.east()) || worldIn.isRainingAt(pos.north()) || worldIn.isRainingAt(pos.south());
    }
    
    /**
     * Sets player on fire if the collide with the campfire 
     */
    @Override
    public void onEntityCollision(IBlockState state, World worldIn, BlockPos pos, Entity entity)
    {
    	if (state.get(BURNING) == true)
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
	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		return (IBlockState) this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

    /**
     * Called by ItemBlocks after a block is set in the world, to allow post-place logic
     */
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.with(FACING, placer.getHorizontalFacing().getOpposite()), 2);

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
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    @Override
    public IBlockState rotate(IBlockState state, Rotation rot)
    {
        return state.with(FACING, rot.rotate((EnumFacing)state.get(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    @SuppressWarnings("deprecation")
	@Override
    public IBlockState mirror(IBlockState state, Mirror mirrorIn)
    {
        return state.rotate(mirrorIn.toRotation((EnumFacing)state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(Builder<Block, IBlockState> state) {
		state.add(new IProperty[]{FACING, BURNING});
	}
}