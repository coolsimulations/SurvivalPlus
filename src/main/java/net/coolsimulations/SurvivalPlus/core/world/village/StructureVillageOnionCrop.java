package net.coolsimulations.SurvivalPlus.core.world.village;

/**import java.util.List;
import java.util.Random;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.Direction;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.VillagePieces;
import net.minecraft.world.gen.feature.template.TemplateManager;**/

public class StructureVillageOnionCrop //extends VillagePieces.Village
{
    /** First crop type for this field. */
	//private BlockState cropTypeA;
    /** Second crop type for this field. */
	//private BlockState cropTypeB;

    /**public StructureVillageOnionCrop()
    {
    }**/

    /**public StructureVillageOnionCrop(VillagePieces.Start start, int p_i45569_2_, Random rand, MutableBoundingBox p_i45569_4_, EnumFacing facing)
    {
        super(start, p_i45569_2_);
        this.setCoordBaseMode(facing);
        this.boundingBox = p_i45569_4_;
        this.cropTypeA = getRandomCropType(rand);
        this.cropTypeB = getRandomCropType(rand);
    }**/

    /**
     * (abstract) Helper method to write subclass data to NBT
     */
    /**protected void writeStructureToNBT(CompoundNBT tagCompound)
    {
        super.writeStructureToNBT(tagCompound);
        tagCompound.setTag("CA", NBTUtil.writeBlockState(this.cropTypeA));
        tagCompound.setTag("CB", NBTUtil.writeBlockState(this.cropTypeB));
    }**/

    /**
     * (abstract) Helper method to read subclass data from NBT
     */
    /**protected void readStructureFromNBT(CompoundNBT tagCompound, TemplateManager p_143011_2_)
    {
        super.readStructureFromNBT(tagCompound, p_143011_2_);
        this.cropTypeA = NBTUtil.readBlockState(tagCompound.getCompound("CA"));
        this.cropTypeB = NBTUtil.readBlockState(tagCompound.getCompound("CB"));
    }

    private BlockState getRandomCropType(Random rand)
    {
        switch (rand.nextInt(10))
        {
            case 0:
            case 1:
                return SPBlocks.onion.getDefaultState(); //CARROTS
            case 2:
            case 3:
                return SPBlocks.onion.getDefaultState(); //POTATOES
            case 4:
                return SPBlocks.onion.getDefaultState(); //BEETROOTS
            default:
                return SPBlocks.onion.getDefaultState(); //WHEAT
        }
    }

    public static StructureVillageOnionCrop createPiece(VillagePieces.Start start, List<StructurePiece> p_175852_1_, Random rand, int p_175852_3_, int p_175852_4_, int p_175852_5_, EnumFacing facing, int p_175852_7_)
    {
    	MutableBoundingBox structureboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175852_3_, p_175852_4_, p_175852_5_, 0, 0, 0, 7, 4, 9, facing);
        return canVillageGoDeeper(structureboundingbox) && StructurePiece.findIntersecting(p_175852_1_, structureboundingbox) == null ? new StructureVillageOnionCrop(start, p_175852_7_, rand, structureboundingbox, facing) : null;
    }**/

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
     * Mineshafts at the end, it adds Fences...
     */
    /**@Override
    public boolean addComponentParts(IWorld worldIn, Random randomIn, MutableBoundingBox structureBoundingBoxIn, ChunkPos pos)
    {
        if (this.averageGroundLvl < 0)
        {
            this.averageGroundLvl = this.getAverageGroundLevel(worldIn, structureBoundingBoxIn);

            if (this.averageGroundLvl < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 4 - 1, 0);
        }

        BlockState BlockState = this.getBiomeSpecificBlockState(Blocks.OAK_LOG.getDefaultState());
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 1, 0, 6, 4, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 1, 2, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 0, 1, 5, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 0, 0, 8, BlockState, BlockState, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 0, 0, 6, 0, 8, BlockState, BlockState, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 0, 5, 0, 0, BlockState, BlockState, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 8, 5, 0, 8, BlockState, BlockState, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 0, 1, 3, 0, 7, Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), false);

        for (int i = 1; i <= 7; ++i)
        {
        	CropsBlock CropsBlock = (CropsBlock)this.cropTypeA.getBlock();
            int j = CropsBlock.getMaxAge();
            int k = j / 3;
            this.setBlockState(worldIn, this.cropTypeA.with(CropsBlock.getAgeProperty(), Integer.valueOf(MathHelper.nextInt(randomIn, k, j))), 1, 1, i, structureBoundingBoxIn);
            this.setBlockState(worldIn, this.cropTypeA.with(CropsBlock.getAgeProperty(), Integer.valueOf(MathHelper.nextInt(randomIn, k, j))), 2, 1, i, structureBoundingBoxIn);
            int l = CropsBlock.getMaxAge();
            int i1 = l / 3;
            this.setBlockState(worldIn, this.cropTypeB.with(CropsBlock.getAgeProperty(), Integer.valueOf(MathHelper.nextInt(randomIn, i1, l))), 4, 1, i, structureBoundingBoxIn);
            this.setBlockState(worldIn, this.cropTypeB.with(CropsBlock.getAgeProperty(), Integer.valueOf(MathHelper.nextInt(randomIn, i1, l))), 5, 1, i, structureBoundingBoxIn);
        }

        for (int j1 = 0; j1 < 9; ++j1)
        {
            for (int k1 = 0; k1 < 7; ++k1)
            {
                this.clearCurrentPositionBlocksUpwards(worldIn, k1, 4, j1, structureBoundingBoxIn);
                this.replaceAirAndLiquidDownwards(worldIn, Blocks.DIRT.getDefaultState(), k1, -1, j1, structureBoundingBoxIn);
            }
        }

        return true;
    }**/
}