package net.coolsimulations.SurvivalPlus.core.util;

import ic2.api.item.IC2Items;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.AsteroidBlocks;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.venus.VenusBlocks;
import micdoodle8.mods.galacticraft.planets.venus.VenusItems;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.core.init.BOPArmor;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusShapelessRecipes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.api.item.BOPItems;

import com.google.common.collect.Lists;
import com.polegamers.flourpower.item.ItemFlourPower;
import com.rumaruka.simplegrinder.Core.ConfigHandler;
import com.rumaruka.simplegrinder.Init.GrinderRecipes;
import com.rumaruka.simplegrinder.Init.ItemsCore;

public class SurvivalPlusAPIRecipes {
	
	public static void loadRecipes()
    {

        if (SPCompatibilityManager.isIc2Loaded())
        {
            SurvivalPlusAPIRecipes.addIndustrialCraft2Recipes();
        }
        
        if(SPCompatibilityManager.isBopLoaded()) {
        	SurvivalPlusAPIRecipes.addSPItemsRecipes();
        }
        
        if(SPCompatibilityManager.isForestryLoaded()) {
        	SurvivalPlusAPIRecipes.addForestryItemsRecipes();
        }
        
        if(SPCompatibilityManager.isGCLoaded()) {
        	SurvivalPlusAPIRecipes.addGCItemsRecipes();
        }
        
        if(SPCompatibilityManager.isSimpleGrinderLoaded()) {
        	SurvivalPlusAPIRecipes.addSimpleGrinderRecipes();
        }
        
        if(SPCompatibilityManager.isSimpleGrinderLoaded() || SPCompatibilityManager.isIc2Loaded()) {
        	GameRegistry.addSmelting(SPItems.titanium_dust, new ItemStack(SPItems.titanium_ingot), 3.0F);
        }
        
        if(SPCompatibilityManager.isRailcraftLoaded()) {
        	SurvivalPlusAPIRecipes.addRailcraftItemsRecipes();
        }
    }
	
	private static void addIndustrialCraft2Recipes()
    {
		ItemStack cable = IC2Items.getItem("cable", "type:glass,insulation:0");
		cable.setCount(6);
		
		addRecipe(new ItemStack(SPItems.titanium_dust), new Object []{"CCC", "CCC", "CCC", 'C', "dustTinyTitanium"});
		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(SPItems.titanium_casing, 2), new Object []{"plateTitanium", "craftingToolForgeHammer"});
		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(SPItems.titanium_plate), new Object []{"ingotTitanium", "craftingToolForgeHammer"});
		addRecipe(cable, new Object []{"GGG", "ETE", "GGG", 'G', Blocks.GLASS, 'T', "dustTitanium", 'E', IC2Items.getItem("dust", "energium")});
		
    }
	
	private static void addSPItemsRecipes() {
		
		if(SPConfig.enableReplaceBOPRecipe){
		removeCraftingRecipe(new ItemStack(BOPItems.terrestrial_artifact));
		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(BOPItems.terrestrial_artifact), new Object[] {"gemRuby", "gemTopaz", "gemAmber", "gemPeridot", "gemMalachite", "gemSapphire", "gemTanzanite", "gemEmerald"});
		if(SPCompatibilityManager.isGCLoaded()){
			SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(BOPItems.terrestrial_artifact), new Object[] {"gemRuby", "gemTopaz", "gemAmber", "gemPeridot", "gemMalachite", new ItemStack(GCItems.itemBasicMoon, 1, 2), "gemTanzanite", "gemEmerald"});
		}
		}
		
		if(SPCompatibilityManager.isGCLoaded() && !SPConfig.enableReplaceBOPRecipe){
			GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.terrestrial_artifact), new Object[] {new ItemStack(BOPItems.gem, 1, 1), new ItemStack(BOPItems.gem, 1, 3), new ItemStack(BOPItems.gem, 1, 7), new ItemStack(BOPItems.gem, 1, 2), new ItemStack(BOPItems.gem, 1, 5), new ItemStack(GCItems.itemBasicMoon, 1, 2), new ItemStack(BOPItems.gem, 1, 4), new ItemStack(Items.EMERALD)});
		}
		
		removeCraftingRecipe(new ItemStack(BOPItems.white_dye, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(SPItems.white_dye, 2), new Object[]{new ItemStack(BOPBlocks.flower_0, 1, 9)});
		GameRegistry.addShapelessRecipe(new ItemStack(SPItems.white_dye, 2), new Object[]{new ItemStack(BOPBlocks.flower_0, 1, 14)});
		
		addArmorRecipe(SPItems.cherry, new ItemStack(BOPBlocks.log_0, 1, 5));
		addArmorRecipe(SPItems.dead, new ItemStack(BOPBlocks.log_4, 1, 5));
		addArmorRecipe(SPItems.ebony, new ItemStack(BOPBlocks.log_3, 1, 6));
		addArmorRecipe(SPItems.ethereal, new ItemStack(BOPBlocks.log_1, 1, 4));
		addArmorRecipe(SPItems.eucalyptus, new ItemStack(BOPBlocks.log_3, 1, 7));
		addArmorRecipe(SPItems.fir, new ItemStack(BOPBlocks.log_0, 1, 7));
		addArmorRecipe(SPItems.hellbark, new ItemStack(BOPBlocks.log_2, 1, 7));
		addArmorRecipe(SPItems.jacaranda, new ItemStack(BOPBlocks.log_3, 1, 4));
		addArmorRecipe(SPItems.magic, new ItemStack(BOPBlocks.log_1, 1, 5));
		addArmorRecipe(SPItems.mahogany, new ItemStack(BOPBlocks.log_3, 1, 5));
		addArmorRecipe(SPItems.mangrove, new ItemStack(BOPBlocks.log_1, 1, 6));
		addArmorRecipe(SPItems.palm, new ItemStack(BOPBlocks.log_1, 1, 7));
		addArmorRecipe(SPItems.pine, new ItemStack(BOPBlocks.log_2, 1, 6));
		addArmorRecipe(SPItems.redwood, new ItemStack(BOPBlocks.log_2, 1, 4));
		addArmorRecipe(SPItems.sacred_oak, new ItemStack(BOPBlocks.log_0, 1, 4));
		addArmorRecipe(SPItems.umbran, new ItemStack(BOPBlocks.log_0, 1, 6));
		addArmorRecipe(SPItems.willow, new ItemStack(BOPBlocks.log_2, 1, 5));
	}
	
	private static void addGCItemsRecipes() {
		
		removeFurnaceRecipe(new ItemStack(GCItems.basicItem, 1, 3));
		removeFurnaceRecipe(new ItemStack(GCItems.basicItem, 3, 3));
		GameRegistry.addSmelting(new ItemStack(GCItems.canister, 1, 1), new ItemStack(SPItems.copper_ingot, 3), 1.0F);
		GameRegistry.addSmelting(new ItemStack(GCBlocks.basicBlock, 1, 5), new ItemStack(SPItems.copper_ingot), 1.0F);
		GameRegistry.addSmelting(new ItemStack(GCBlocks.blockMoon), new ItemStack(SPItems.copper_ingot), 1.0F);
		removeFurnaceRecipe(new ItemStack(GCItems.basicItem, 1, 4));
		removeFurnaceRecipe(new ItemStack(GCItems.basicItem, 3, 4));
		GameRegistry.addSmelting(new ItemStack(GCItems.canister), new ItemStack(SPItems.tin_ingot, 3), 0.5F);
		GameRegistry.addSmelting(new ItemStack(GCBlocks.basicBlock, 1, 6), new ItemStack(SPItems.tin_ingot), 0.5F);
		GameRegistry.addSmelting(new ItemStack(GCBlocks.blockMoon, 1, 1), new ItemStack(SPItems.tin_ingot), 0.5F);
		
		if(SPCompatibilityManager.isGCPLoaded()) {
			GameRegistry.addSmelting(new ItemStack(MarsBlocks.marsBlock), new ItemStack(SPItems.copper_ingot), 1.0F);
			GameRegistry.addSmelting(new ItemStack(VenusBlocks.venusBlock, 1, 7), new ItemStack(SPItems.copper_ingot), 1.0F);
			GameRegistry.addSmelting(new ItemStack(MarsBlocks.marsBlock, 1, 1), new ItemStack(SPItems.tin_ingot), 0.5F);
			GameRegistry.addSmelting(new ItemStack(VenusBlocks.venusBlock, 1, 11), new ItemStack(SPItems.tin_ingot), 1.0F);
		}
		
	}
	
	private static void addSimpleGrinderRecipes() {
		
		if(!SPCompatibilityManager.isIc2Loaded()) {
			
			GrinderRecipes.instance().addSmeltingRecipeForBlock(SPBlocks.copper_ore, new ItemStack(SPItems.copper_dust, ConfigHandler.getIronDustOutput()), 0.5F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(SPBlocks.tin_ore, new ItemStack(SPItems.tin_dust, ConfigHandler.getIronDustOutput()), 0.5F);
			GameRegistry.addSmelting(SPItems.copper_dust, new ItemStack(SPItems.copper_ingot), 3.0F);
			GameRegistry.addSmelting(SPItems.tin_dust, new ItemStack(SPItems.tin_ingot), 3.0F);
			
			if(SPCompatibilityManager.isGCLoaded()) {
				
				GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(GCBlocks.basicBlock, 1, 5), new ItemStack(SPItems.copper_dust, ConfigHandler.getIronDustOutput()), 0.5F);
				GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(GCBlocks.blockMoon), new ItemStack(SPItems.copper_dust, ConfigHandler.getIronDustOutput()), 0.5F);
				GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(GCBlocks.basicBlock, 1, 6), new ItemStack(SPItems.tin_dust, ConfigHandler.getIronDustOutput()), 0.5F);
				GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(GCBlocks.blockMoon, 1, 1), new ItemStack(SPItems.tin_dust, ConfigHandler.getIronDustOutput()), 0.5F);
				
				if(SPCompatibilityManager.isGCPLoaded()) {
					
					GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(MarsBlocks.marsBlock), new ItemStack(SPItems.copper_dust, ConfigHandler.getIronDustOutput()), 0.5F);
					GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(VenusBlocks.venusBlock, 1, 7), new ItemStack(SPItems.copper_dust, ConfigHandler.getIronDustOutput()), 0.5F);
					GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(MarsBlocks.marsBlock, 1, 1), new ItemStack(SPItems.tin_dust, ConfigHandler.getIronDustOutput()), 0.5F);
					GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(VenusBlocks.venusBlock, 1, 11), new ItemStack(SPItems.tin_dust, ConfigHandler.getIronDustOutput()), 0.5F);
				}
				
			}
			
			if(SPCompatibilityManager.isForestryLoaded()) {
				Block resources = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "resources"));
				GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(resources, 1, 1), new ItemStack(SPItems.copper_dust, ConfigHandler.getIronDustOutput()), 0.5F);
				GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(resources, 1, 2), new ItemStack(SPItems.tin_dust, ConfigHandler.getIronDustOutput()), 0.5F);
			}
			
		} else {
			
			ItemStack copper = IC2Items.getItem("dust", "copper");
			copper.setCount(ConfigHandler.getIronDustOutput());
			
			ItemStack tin = IC2Items.getItem("dust", "tin");
			tin.setCount(ConfigHandler.getIronDustOutput());
			
			ItemStack lead = IC2Items.getItem("dust", "lead");
			lead.setCount(ConfigHandler.getIronDustOutput());
			
			GrinderRecipes.instance().addSmeltingRecipeForBlock(SPBlocks.copper_ore, copper, 0.5F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(SPBlocks.tin_ore, tin, 0.5F);
			GrinderRecipes.instance().addSmeltingRecipe(IC2Items.getItem("resource", "copper_ore"), copper, 0.5F);
			GrinderRecipes.instance().addSmeltingRecipe(IC2Items.getItem("resource", "tin_ore"), tin, 0.5F);
			GrinderRecipes.instance().addSmeltingRecipe(IC2Items.getItem("resource", "lead_ore"), lead, 0.5F);
			
			if(SPCompatibilityManager.isGCLoaded()) {
				
				GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(GCBlocks.basicBlock, 1, 5), copper, 0.5F);
				GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(GCBlocks.blockMoon), copper, 0.5F);
				GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(GCBlocks.basicBlock, 1, 6), tin, 0.5F);
				GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(GCBlocks.blockMoon, 1, 1), tin, 0.5F);
				
				if(SPCompatibilityManager.isGCPLoaded()) {
					
					GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(MarsBlocks.marsBlock), copper, 0.5F);
					GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(VenusBlocks.venusBlock, 1, 7), copper, 0.5F);
					GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(MarsBlocks.marsBlock, 1, 1), tin, 0.5F);
					GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(VenusBlocks.venusBlock, 1, 11), tin, 0.5F);
				}
			}
			
			if(SPCompatibilityManager.isForestryLoaded()) {
				Block resources = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "resources"));
				GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(resources, 1, 1), copper, 0.5F);
				GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(resources, 1, 2), tin, 0.5F);
			}
		}
		
		if(SPCompatibilityManager.isGCPLoaded()) {
			
			GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(MarsBlocks.marsBlock, 1, 3), new ItemStack(ItemsCore.dust_iron,ConfigHandler.getIronDustOutput()), 0.7F);
			GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(AsteroidBlocks.blockBasic, 1, 5), new ItemStack(ItemsCore.dust_iron,ConfigHandler.getIronDustOutput()), 0.7F);
			GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(AsteroidBlocks.blockBasic, 1, 4), new ItemStack(AsteroidsItems.basicItem,ConfigHandler.getGoldDustOutput(), 9), 1.0F);
			GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(VenusBlocks.venusBlock, 1, 9), new ItemStack(Items.QUARTZ,ConfigHandler.getQuartzOutput()), 1.0F);
		}
		
		if(SPCompatibilityManager.isGCLoaded()) {
			GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(GCBlocks.blockMoon, 1, 6), new ItemStack(GCItems.itemBasicMoon,ConfigHandler.getEmeraldOutput(), 2), 1.0F);
		}
		
		if(SPCompatibilityManager.isBopLoaded()) {
			GrinderRecipes.instance().addSmeltingRecipeForBlock(BOPBlocks.white_sandstone, new ItemStack(BOPBlocks.white_sand,ConfigHandler.getSandstoneSandOutput()), 0.6F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(BOPBlocks.log_0, new ItemStack(ItemsCore.wood_chips, ConfigHandler.getWoodChipsOutput()), 0.5F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(BOPBlocks.log_1, new ItemStack(ItemsCore.wood_chips, ConfigHandler.getWoodChipsOutput()), 0.5F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(BOPBlocks.log_2, new ItemStack(ItemsCore.wood_chips, ConfigHandler.getWoodChipsOutput()), 0.5F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(BOPBlocks.log_3, new ItemStack(ItemsCore.wood_chips, ConfigHandler.getWoodChipsOutput()), 0.5F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(BOPBlocks.log_4, new ItemStack(ItemsCore.wood_chips, ConfigHandler.getWoodChipsOutput()), 0.5F);
			GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(BOPBlocks.gem_ore, 1, 1), new ItemStack(BOPItems.gem, ConfigHandler.getEmeraldOutput(), 1), 1.0F);
			GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(BOPBlocks.gem_ore, 1, 2), new ItemStack(BOPItems.gem, ConfigHandler.getEmeraldOutput(), 2), 1.0F);
			GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(BOPBlocks.gem_ore, 1, 3), new ItemStack(BOPItems.gem, ConfigHandler.getEmeraldOutput(), 3), 1.0F);
			GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(BOPBlocks.gem_ore, 1, 4), new ItemStack(BOPItems.gem, ConfigHandler.getEmeraldOutput(), 4), 1.0F);
			GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(BOPBlocks.gem_ore, 1, 5), new ItemStack(BOPItems.gem, ConfigHandler.getEmeraldOutput(), 5), 1.0F);
			GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(BOPBlocks.gem_ore, 1, 6), new ItemStack(BOPItems.gem, ConfigHandler.getEmeraldOutput(), 6), 1.0F);
			GrinderRecipes.instance().addSmeltingRecipe(new ItemStack(BOPBlocks.gem_ore, 1, 7), new ItemStack(BOPItems.gem, ConfigHandler.getEmeraldOutput(), 7), 1.0F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(SPBlocks.topaz, new ItemStack(BOPItems.gem, ConfigHandler.getEmeraldOutput(), 3), 1.0F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(SPBlocks.ruby, new ItemStack(BOPItems.gem, ConfigHandler.getEmeraldOutput(), 1), 1.0F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(SPBlocks.sapphire, new ItemStack(BOPItems.gem, ConfigHandler.getEmeraldOutput(), 6), 1.0F);
		}
		
		if(SPCompatibilityManager.isFlourPowerLoaded()) {
			GrinderRecipes.instance().addSmelting(Items.WHEAT, new ItemStack(ItemFlourPower.itemFlour, 1), 1.0F);
		}

		GrinderRecipes.instance().addSmeltingRecipeForBlock(SPBlocks.titanium_ore, new ItemStack(SPItems.titanium_dust,ConfigHandler.getGoldDustOutput()), 2.0F);
	}
	
	private static void addForestryItemsRecipes() {
		
		Block logs0 = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.0"));
		Block logs1 = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.1"));
		Block logs2 = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.2"));
		Block logs3 = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.3"));
		Block logs4 = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.4"));
		Block logs5 = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.5"));
		Block logs6 = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.6"));
		Block logs7 = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.7"));
		Block resources = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "resources"));
		Item ingotCopper = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "ingot_copper"));
		Item ingotTin = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "ingot_tin"));
		
		addArmorRecipe(SPItems.desert_acacia, new ItemStack(logs0, 1, 2));
		addArmorRecipe(SPItems.balsa, new ItemStack(logs2, 1, 3));
		addArmorRecipe(SPItems.baobab, new ItemStack(logs1, 1, 2));
		addArmorRecipe(SPItems.cherry_forestry, new ItemStack(logs3, 1, 3));
		addArmorRecipe(SPItems.chestnut, new ItemStack(logs1));
		addArmorRecipe(SPItems.citrus, new ItemStack(logs5, 1, 3));
		addArmorRecipe(SPItems.cocobolo, new ItemStack(logs6, 1, 3));
		addArmorRecipe(SPItems.ebony_forestry, new ItemStack(logs2, 1, 1));
		addArmorRecipe(SPItems.giant_sequoia, new ItemStack(logs6));
		addArmorRecipe(SPItems.greenheart, new ItemStack(logs3, 1, 2));
		addArmorRecipe(SPItems.ipe, new ItemStack(logs6, 1, 1));
		addArmorRecipe(SPItems.kapok, new ItemStack(logs2));
		addArmorRecipe(SPItems.larch, new ItemStack(logs0));
		addArmorRecipe(SPItems.lime, new ItemStack(logs0, 1, 3));
		addArmorRecipe(SPItems.mahoe, new ItemStack(logs4));
		addArmorRecipe(SPItems.mahogany_forestry, new ItemStack(logs2, 1, 2));
		addArmorRecipe(SPItems.maple, new ItemStack(logs5, 1, 2));
		addArmorRecipe(SPItems.padauk, new ItemStack(logs6, 1, 2));
		addArmorRecipe(SPItems.palm_forestry, new ItemStack(logs4, 1, 2));
		addArmorRecipe(SPItems.papaya, new ItemStack(logs4, 1, 3));
		addArmorRecipe(SPItems.pine_forestry, new ItemStack(logs5));
		addArmorRecipe(SPItems.plum, new ItemStack(logs5, 1, 1));
		addArmorRecipe(SPItems.poplar, new ItemStack(logs4, 1, 1));
		addArmorRecipe(SPItems.sequoia, new ItemStack(logs1, 1, 3));
		addArmorRecipe(SPItems.teak, new ItemStack(logs0, 1, 1));
		addArmorRecipe(SPItems.walnut, new ItemStack(logs3, 1, 1));
		addArmorRecipe(SPItems.wenge, new ItemStack(logs1, 1, 1));
		addArmorRecipe(SPItems.willow_forestry, new ItemStack(logs1, 1, 1));
		addArmorRecipe(SPItems.zebrawood, new ItemStack(logs7));
		
		removeFurnaceRecipe(new ItemStack(ingotCopper));
		removeFurnaceRecipe(new ItemStack(ingotTin));
		GameRegistry.addSmelting(new ItemStack(resources, 1, 1), new ItemStack(SPItems.copper_ingot), 0.7F);
		GameRegistry.addSmelting(new ItemStack(resources, 1, 2), new ItemStack(SPItems.tin_ingot), 0.7F);
	}
	
	private static void addRailcraftItemsRecipes() {
		
		Item ingot = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "ingot"));
		Item nugget = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "nugget"));
		Block oreMetal = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "ore_metal"));
		Block generic = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "generic"));
		
		removeFurnaceRecipe(new ItemStack(ingot, 1, 1));
		GameRegistry.addSmelting(new ItemStack(oreMetal), new ItemStack(SPItems.copper_ingot), 1.0F);
		removeFurnaceRecipe(new ItemStack(ingot, 1, 2));
		GameRegistry.addSmelting(new ItemStack(oreMetal, 1, 1), new ItemStack(SPItems.tin_ingot), 1.0F);
		
		if (OreDictionary.getOres("ingotSteel").size() > 0) {
			SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 9, 1), new Object[] {"ingotSteel"});
		}
		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 9, 2), new Object[] {"ingotCopper"});
		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 9, 3), new Object[] {"ingotTin"});
		if (OreDictionary.getOres("ingotLead").size() > 0) {
			SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 9, 4), new Object[] {"ingotLead"});
		}
		if (OreDictionary.getOres("ingotSilver").size() > 0) {
			SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 9, 5), new Object[] {"ingotSilver"});
		}
		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 9, 6), new Object[] {"ingotBronze"});
		if (OreDictionary.getOres("ingotNickel").size() > 0) {
			SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 9, 7), new Object[] {"ingotNickel"});
		}
		if (OreDictionary.getOres("ingotInvar").size() > 0) {
			SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 9, 8), new Object[] {"ingotInvar"});
		}
		if (OreDictionary.getOres("ingotZinc").size() > 0) {
			SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 9, 9), new Object[] {"ingotZinc"});
		}
		if (OreDictionary.getOres("ingotBrass").size() > 0) {
			SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 9, 10), new Object[] {"ingotBrass"});
		}
		removeCraftingRecipe(new ItemStack(ingot, 1, 1));
		removeCraftingRecipe(new ItemStack(ingot, 9, 1));
		removeCraftingRecipe(new ItemStack(ingot, 1, 2));
		removeCraftingRecipe(new ItemStack(ingot, 9, 2));
		removeCraftingRecipe(new ItemStack(ingot, 1, 5));
		removeCraftingRecipe(new ItemStack(ingot, 9, 5));
		removeCraftingRecipe(new ItemStack(ingot, 4, 5));
		removeCraftingRecipe(new ItemStack(generic, 1, 11));
		removeCraftingRecipe(new ItemStack(generic, 1, 1));
		removeCraftingRecipe(new ItemStack(generic));
		addRecipe(new ItemStack(SPItems.copper_ingot), new Object []{"BBB", "BBB", "BBB", 'B', new ItemStack(nugget, 1, 2)});
		addRecipe(new ItemStack(SPItems.tin_ingot), new Object []{"BBB", "BBB", "BBB", 'B', new ItemStack(nugget, 1, 3)});
		addRecipe(new ItemStack(SPItems.bronze_ingot), new Object []{"BBB", "BBB", "BBB", 'B', new ItemStack(nugget, 1, 6)});
		
		if(SPCompatibilityManager.isIc2Loaded()) {
			
			removeFurnaceRecipe(new ItemStack(ingot, 1, 3));
			GameRegistry.addSmelting(new ItemStack(oreMetal, 1, 2), IC2Items.getItem("ingot", "lead"), 1.0F);
			removeFurnaceRecipe(new ItemStack(ingot, 1, 4));
			GameRegistry.addSmelting(new ItemStack(oreMetal, 1, 3), IC2Items.getItem("ingot", "silver"), 1.0F);
			removeCraftingRecipe(new ItemStack(ingot, 1, 3));
			removeCraftingRecipe(new ItemStack(ingot, 9, 3));
			removeCraftingRecipe(new ItemStack(ingot, 1, 4));
			removeCraftingRecipe(new ItemStack(ingot, 9, 4));
			removeCraftingRecipe(new ItemStack(generic, 1, 10));
			removeCraftingRecipe(new ItemStack(generic, 1, 2));
			addRecipe(IC2Items.getItem("ingot", "lead"), new Object []{"BBB", "BBB", "BBB", 'B', new ItemStack(nugget, 1, 4)});
			addRecipe(IC2Items.getItem("ingot", "silver"), new Object []{"BBB", "BBB", "BBB", 'B', new ItemStack(nugget, 1, 5)});
		}
	}
	
	
    @SuppressWarnings("unchecked")
    public static void addRecipe(ItemStack result, Object[] obj)
    {
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(result, obj));
    }
    
    public static void addArmorRecipe(NonNullList<ItemStack> result, ItemStack material)
    {
    	GameRegistry.addRecipe(result.get(0), new Object[]{"BBB","B B", 'B', material});
		GameRegistry.addRecipe(result.get(1), new Object[]{"B B","BBB","BBB", 'B', material});
		GameRegistry.addRecipe(result.get(2), new Object[]{"BBB","B B","B B", 'B', material});
		GameRegistry.addRecipe(result.get(3), new Object[]{"B B","B B", 'B', material});
    }
    
    public static void removeFurnaceRecipe (ItemStack resultItem)
	{
		Map<ItemStack, ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList();
		for (Iterator<Map.Entry<ItemStack,ItemStack>> entries = recipes.entrySet().iterator(); entries.hasNext(); ){
			Map.Entry<ItemStack,ItemStack> entry = entries.next();
			ItemStack result = entry.getValue();
			if (ItemStack.areItemStacksEqual(result, resultItem)){ // If the output matches the specified ItemStack,
				entries.remove(); // Remove the recipe
			}
		}
	}
	
	public static void removeCraftingRecipe(ItemStack resultItem)
	{

		List<IRecipe> recipies = CraftingManager.getInstance().getRecipeList();

		Iterator<IRecipe> entries = recipies.iterator();

		while (entries.hasNext())
		{
			ItemStack result = entries.next().getRecipeOutput();

			if (ItemStack.areItemStacksEqual(result, resultItem))
			{
				entries.remove();
			}


		}

	}
	
	public static ItemStack getIndustrialCraftItem(String name)
	{
		return IC2Items.getItem(name, null);
	}

}
