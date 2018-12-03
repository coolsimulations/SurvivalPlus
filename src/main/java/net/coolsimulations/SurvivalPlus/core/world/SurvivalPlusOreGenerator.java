package net.coolsimulations.SurvivalPlus.core.world;

import java.util.Random;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.world.SPNetherGeneratorPredicate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMushroomIsland;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.google.common.base.Predicate;

public class SurvivalPlusOreGenerator implements IWorldGenerator{

	private WorldGenerator copper_ore;
	private WorldGenerator tin_ore;
	private WorldGenerator titanium_ore;
	
	private WorldGenerator amethyst;
	private WorldGenerator ruby;
	private WorldGenerator topaz;
	private WorldGenerator sapphire;
	
	private WorldGenerator pearl;
	private WorldGenerator spinel;
	
	public SurvivalPlusOreGenerator() {
		copper_ore = new WorldGenMinable(SPBlocks.copper_ore.getDefaultState(), 8);
		tin_ore = new WorldGenMinable(SPBlocks.tin_ore.getDefaultState(), 8);
		titanium_ore = new WorldGenMinable(SPBlocks.titanium_ore.getDefaultState(), 4);
		
		amethyst = new WorldGenMinable(SPBlocks.amethyst.getDefaultState(), 3, new SPNetherGeneratorPredicate());
		ruby = new WorldGenMinable(SPBlocks.ruby.getDefaultState(), 3, new SPNetherGeneratorPredicate());
		topaz = new WorldGenMinable(SPBlocks.topaz.getDefaultState(), 3, new SPNetherGeneratorPredicate());
		sapphire = new WorldGenMinable(SPBlocks.sapphire.getDefaultState(), 3, new SPNetherGeneratorPredicate());
		
		pearl = new WorldGenMinable(SPBlocks.pearl.getDefaultState(), 3, new SPGravelGeneratorPredicate());
		spinel = new WorldGenMinable(SPBlocks.spinel.getDefaultState(), 3);
	}

	private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
		throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
	
		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i ++) {
			int x = chunkX * 16 + random.nextInt(16);
	        	int y = minHeight + random.nextInt(heightDiff);
	        	int z = chunkZ * 16 + random.nextInt(16);
	        generator.generate(world, random, new BlockPos(x, y, z));
		}
	}

	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
	
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(chunkX * 16, 64, chunkZ * 16));
		
		switch(world.provider.getDimension()) 	{
		case 0: //Overworld
			if(!SPConfig.disableCopperOreGen) {
				this.runGenerator(copper_ore, world, random, chunkX, chunkZ, 40, 1, 54);
			}
			
			if(!SPConfig.disableTinOreGen) {
				this.runGenerator(tin_ore, world, random, chunkX, chunkZ, 40, 1, 54);
			}
			
			if(!SPConfig.disableTitaniumOreGen) {
				this.runGenerator(titanium_ore, world, random, chunkX, chunkZ, 10, 1, 25);
			}
			
			if(biome instanceof BiomeOcean && !SPConfig.disablePearlGen){
				this.runGenerator(pearl, world, random, chunkX, chunkZ, 10, 20, 63);
			}
			
			if(biome instanceof BiomeMushroomIsland && !SPConfig.disableSpinelGen){
				this.runGenerator(spinel, world, random, chunkX, chunkZ, 5, 1, 5);
			}
			
		case 1: //End
			
		case -1: //Nether
			
			if(!SPConfig.disableAmethystGen) {
				this.runGenerator(amethyst, world, random, chunkX, chunkZ, 20, 1, 255);
			}
			
			if(!SPConfig.disableRubyGen) {
				this.runGenerator(ruby, world, random, chunkX, chunkZ, 20, 1, 255);
			}
			
			if(!SPConfig.disableTopazGen) {
				this.runGenerator(topaz, world, random, chunkX, chunkZ, 20, 1, 255);
			}
			
			if(!SPConfig.disableSapphireGen) {
				this.runGenerator(sapphire, world, random, chunkX, chunkZ, 20, 1, 255);
			}
		}
	}

	
	public class SPGravelGeneratorPredicate implements Predicate<IBlockState> {
		
		@Override
		public boolean apply(IBlockState input) {
			return input != null && input.getBlock() == Blocks.GRAVEL;
		}
	}

}
