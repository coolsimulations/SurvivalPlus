package net.coolsimulations.SurvivalPlus.core.world;

import java.util.List;
import java.util.Random;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMushroomIsland;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.google.common.collect.Lists;

public class WorldOreGen implements IWorldGenerator{
	
    protected List<StructureComponent> components = Lists.<StructureComponent>newLinkedList();
    
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()){
		
		case -1:
			GenerateNether(world, chunkX * 16, chunkZ * 16, random);

			break;
			
		case 0:
			GenerateOverworld(world, chunkX * 16, chunkZ * 16, random);
			break;
			
		case 1:
			GenerateEnd(world, chunkX * 16, chunkZ * 16, random);
			break;
		}
		
	}

	private void addOre(Block block, Block blockSpawn, Random random, World world, int posX, int posZ, int minY, int maxY, int minVein, int maxVein, int spawnChance){
		for(int i = 0; i < spawnChance; i ++){
			int defaultChunkSize = 16;
			
			int Xpos = posX + random.nextInt(defaultChunkSize);
			int Ypos = minY + random.nextInt(maxY - minY);
			int Zpos = posZ + random.nextInt(defaultChunkSize);
			
			IBlockState state = block.getDefaultState();
			BlockPos blockPos = new BlockPos(Xpos, Ypos, Zpos);
			
			new WorldGenMinable(state, maxVein).generate(world, random, blockPos);
		}
	}

	private void GenerateEnd(World world, int i, int j, Random random) {
		
	}

	private void GenerateOverworld(World world, int i, int j, Random random) {
		
		if(!SPConfig.disableCopperOreGen) {
		addOre(SPBlocks.copper_ore, Blocks.STONE, random, world, i, j, 1, 54, 4, 8, 40);
		}
		
		if(!SPConfig.disableTinOreGen) {
		addOre(SPBlocks.tin_ore, Blocks.STONE, random, world, i, j, 1, 54, 4, 8, 40);
		}
		
		if(!SPConfig.disableAmethystGen) {
		addOre(SPBlocks.amethyst, Blocks.STONE, random, world, i, j, 1, 20, 2, 3, 20);
		}
		
		if(!SPConfig.disableRubyGen) {
		addOre(SPBlocks.ruby, Blocks.STONE, random, world, i, j, 1, 20, 2, 3, 20);
		}
		
		if(!SPConfig.disableTopazGen) {
		addOre(SPBlocks.topaz, Blocks.STONE, random, world, i, j, 1, 20, 2, 3, 20);
		}
		
		if(!SPConfig.disableSapphireGen) {
		addOre(SPBlocks.sapphire, Blocks.STONE, random, world, i, j, 1, 20, 2, 3, 20);
		}
		
		if(!SPConfig.disableTitaniumOreGen) {
		addOre(SPBlocks.titanium_ore, Blocks.STONE, random, world, i, j, 1, 25, 2, 4, 10);
		}
		
		//Biome biome = world.getBiomeGenForCoords(new BlockPos(i, 64, j));
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(i, 64, j));

		if(biome instanceof BiomeOcean && !SPConfig.disablePearlGen){
			addOre(SPBlocks.pearl, Blocks.SAND, random, world, i, j, 20, 63, 2, 3, 10);
		}
		
		if(biome instanceof BiomeMushroomIsland && !SPConfig.disableSpinelGen){
			addOre(SPBlocks.spinel, Blocks.STONE, random, world, i, j, 1, 5, 2, 3, 5);
		}
		
		/**Biome biome = world.getBiomeGenForCoords(new BlockPos(i, 64, j));
		if(biome == Biome.getBiome(3))
		{
			// how many we want to make per chunk
			// let's make it random between MIN and MAX
			int MIN = 1;
			int MAX = 1;
			int numBushes = MIN + random.nextInt(MAX - MIN);
			// now let's generate the bushes
			for(int h = 0; h < numBushes; h++)
			{
				// get a random position in the chunk
				int randX = i + random.nextInt(16);
				int randZ = j + random.nextInt(16);
				// the y-value we pass here will be used as minimum spawn height (in our generator, anyway)
				genCookieBushes.generate(world, random, new BlockPos(randX, 24, randZ));
			}
		}**/
		
		  /**Biome biome = world.getBiomeGenForCoords(new BlockPos(i, 64, j));
		  
		  if (biome == Biomes.FOREST || biome == Biomes.PLAINS || biome == Biomes.SWAMPLAND)
          {
          	ComponentSmallFeature.SmallCrop componentscatteredfeaturepieces$smallcrop = new ComponentSmallFeature.SmallCrop(random, i * 16, j * 16);
              this.components.add(componentscatteredfeaturepieces$smallcrop);
          }**/
		  
		  /**if (biome == Biomes.FOREST || biome == Biomes.PLAINS || biome == Biomes.SWAMPLAND)
		  {
			  for(int x = 0;x<2;x++)
			  {
			  int h = i + random.nextInt(16);
			  int k = j + random.nextInt(16);
			  int l = 24;
			  ComponentSmallFeature.addComponentParts(world, random, h, l, k);
			  }
		  }**/

	}

	private void GenerateNether(World world, int i, int j, Random random) {
		

	}

}
