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
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusShapelessRecipes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.api.item.BOPItems;

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
		cable.stackSize = 6;
		
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
		
		GameRegistry.addRecipe(new ItemStack(SPItems.cherry_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_0, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.cherry_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_0, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.cherry_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_0, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.cherry_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_0, 1, 5)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.dead_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_4, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.dead_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_4, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.dead_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_4, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.dead_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_4, 1, 5)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.ebony_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_3, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.ebony_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_3, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.ebony_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_3, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.ebony_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_3, 1, 6)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.ethereal_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_1, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.ethereal_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_1, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.ethereal_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_1, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.ethereal_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_1, 1, 4)});

		GameRegistry.addRecipe(new ItemStack(SPItems.eucalyptus_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_3, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.eucalyptus_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_3, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.eucalyptus_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_3, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.eucalyptus_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_3, 1, 7)});

		GameRegistry.addRecipe(new ItemStack(SPItems.fir_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_0, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.fir_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_0, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.fir_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_0, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.fir_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_0, 1, 7)});

		GameRegistry.addRecipe(new ItemStack(SPItems.hellbark_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_2, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.hellbark_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_2, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.hellbark_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_2, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.hellbark_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_2, 1, 7)});

		GameRegistry.addRecipe(new ItemStack(SPItems.jacaranda_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_3, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.jacaranda_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_3, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.jacaranda_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_3, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.jacaranda_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_3, 1, 4)});

		GameRegistry.addRecipe(new ItemStack(SPItems.magic_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_1, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.magic_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_1, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.magic_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_1, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.magic_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_1, 1, 5)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.mahogany_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_3, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.mahogany_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_3, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.mahogany_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_3, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.mahogany_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_3, 1, 5)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.mangrove_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_1, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.mangrove_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_1, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.mangrove_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_1, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.mangrove_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_1, 1, 6)});

		GameRegistry.addRecipe(new ItemStack(SPItems.palm_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_1, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.palm_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_1, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.palm_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_1, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.palm_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_1, 1, 7)});

		GameRegistry.addRecipe(new ItemStack(SPItems.pine_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_2, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.pine_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_2, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.pine_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_2, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.pine_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_2, 1, 6)});

		GameRegistry.addRecipe(new ItemStack(SPItems.redwood_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_2, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.redwood_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_2, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.redwood_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_2, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.redwood_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_2, 1, 4)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.sacred_oak_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_0, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.sacred_oak_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_0, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.sacred_oak_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_0, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.sacred_oak_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_0, 1, 4)});

		GameRegistry.addRecipe(new ItemStack(SPItems.umbran_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_0, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.umbran_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_0, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.umbran_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_0, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.umbran_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_0, 1, 6)});

		GameRegistry.addRecipe(new ItemStack(SPItems.willow_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(BOPBlocks.log_2, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.willow_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(BOPBlocks.log_2, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.willow_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(BOPBlocks.log_2, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.willow_boots), new Object[]{"B B","B B", 'B', new ItemStack(BOPBlocks.log_2, 1, 5)});
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
			copper.stackSize = ConfigHandler.getIronDustOutput();
			
			ItemStack tin = IC2Items.getItem("dust", "tin");
			tin.stackSize = ConfigHandler.getIronDustOutput();
			
			ItemStack lead = IC2Items.getItem("dust", "lead");
			lead.stackSize = ConfigHandler.getIronDustOutput();
			
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
			GrinderRecipes.instance().addSmelting(SPItems.cherry_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.cherry_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.cherry_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.cherry_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.dead_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.dead_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.dead_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.dead_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ebony_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ebony_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ebony_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ebony_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ethereal_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ethereal_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ethereal_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ethereal_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.eucalyptus_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.eucalyptus_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.eucalyptus_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.eucalyptus_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.fir_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.fir_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.fir_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.fir_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.hellbark_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.hellbark_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.hellbark_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.hellbark_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.jacaranda_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.jacaranda_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.jacaranda_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.jacaranda_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.magic_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.magic_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.magic_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.magic_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mahogany_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mahogany_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mahogany_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mahogany_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mangrove_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mangrove_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mangrove_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mangrove_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.palm_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.palm_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.palm_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.palm_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.pine_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.pine_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.pine_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.pine_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.redwood_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.redwood_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.redwood_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.redwood_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.sacred_oak_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.sacred_oak_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.sacred_oak_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.sacred_oak_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.umbran_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.umbran_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.umbran_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.umbran_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.willow_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.willow_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.willow_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.willow_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
		}
		
		if(SPCompatibilityManager.isFlourPowerLoaded()) {
			GrinderRecipes.instance().addSmelting(Items.WHEAT, new ItemStack(ItemFlourPower.itemFlour, 1), 1.0F);
		}
		
		if(OreDictionary.getOres("woodRubber").size() > 0) {
			GrinderRecipes.instance().addSmelting(SPItems.rubber_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.rubber_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.rubber_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.rubber_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
		}
		
		if(SPCompatibilityManager.isForestryLoaded()) {
			GrinderRecipes.instance().addSmeltingRecipeForBlock(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.0")), new ItemStack(ItemsCore.wood_chips, ConfigHandler.getWoodChipsOutput()), 0.5F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.1")), new ItemStack(ItemsCore.wood_chips, ConfigHandler.getWoodChipsOutput()), 0.5F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.2")), new ItemStack(ItemsCore.wood_chips, ConfigHandler.getWoodChipsOutput()), 0.5F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.3")), new ItemStack(ItemsCore.wood_chips, ConfigHandler.getWoodChipsOutput()), 0.5F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.4")), new ItemStack(ItemsCore.wood_chips, ConfigHandler.getWoodChipsOutput()), 0.5F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.5")), new ItemStack(ItemsCore.wood_chips, ConfigHandler.getWoodChipsOutput()), 0.5F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.6")), new ItemStack(ItemsCore.wood_chips, ConfigHandler.getWoodChipsOutput()), 0.5F);
			GrinderRecipes.instance().addSmeltingRecipeForBlock(Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "logs.7")), new ItemStack(ItemsCore.wood_chips, ConfigHandler.getWoodChipsOutput()), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.desert_acacia_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.desert_acacia_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.desert_acacia_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.desert_acacia_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.balsa_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.balsa_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.balsa_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.balsa_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.baobab_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.baobab_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.baobab_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.baobab_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.cherry_helmet_forestry, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.cherry_chestplate_forestry, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.cherry_leggings_forestry, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.cherry_boots_forestry, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.chestnut_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.chestnut_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.chestnut_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.chestnut_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.citrus_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.citrus_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.citrus_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.citrus_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.cocobolo_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.cocobolo_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.cocobolo_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.cocobolo_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ebony_helmet_forestry, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ebony_chestplate_forestry, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ebony_leggings_forestry, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ebony_boots_forestry, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.giant_sequoia_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.giant_sequoia_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.giant_sequoia_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.giant_sequoia_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.greenheart_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.greenheart_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.greenheart_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.greenheart_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ipe_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ipe_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ipe_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.ipe_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.kapok_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.kapok_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.kapok_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.kapok_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.larch_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.larch_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.larch_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.larch_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.lime_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.lime_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.lime_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.lime_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mahoe_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mahoe_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mahoe_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mahoe_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mahogany_helmet_forestry, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mahogany_chestplate_forestry, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mahogany_leggings_forestry, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.mahogany_boots_forestry, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.maple_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.maple_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.maple_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.maple_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.padauk_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.padauk_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.padauk_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.padauk_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.palm_helmet_forestry, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.palm_chestplate_forestry, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.palm_leggings_forestry, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.palm_boots_forestry, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.papaya_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.papaya_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.papaya_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.papaya_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.pine_helmet_forestry, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.pine_chestplate_forestry, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.pine_leggings_forestry, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.pine_boots_forestry, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.plum_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.plum_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.plum_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.plum_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.poplar_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.poplar_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.poplar_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.poplar_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.sequoia_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.sequoia_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.sequoia_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.sequoia_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.teak_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.teak_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.teak_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.teak_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.walnut_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.walnut_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.walnut_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.walnut_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.wenge_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.wenge_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.wenge_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.wenge_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.willow_helmet_forestry, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.willow_chestplate_forestry, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.willow_leggings_forestry, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.willow_boots_forestry, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.zebrawood_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.zebrawood_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.zebrawood_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
			GrinderRecipes.instance().addSmelting(SPItems.zebrawood_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
		}
		
		GrinderRecipes.instance().addSmeltingRecipeForBlock(SPBlocks.titanium_ore, new ItemStack(SPItems.titanium_dust,ConfigHandler.getGoldDustOutput()), 2.0F);
		GrinderRecipes.instance().addSmelting(SPItems.titanium_helmet, new ItemStack(SPItems.titanium_dust, 5), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.titanium_chestplate, new ItemStack(SPItems.titanium_dust, 8), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.titanium_leggings, new ItemStack(SPItems.titanium_dust, 7), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.titanium_boots, new ItemStack(SPItems.titanium_dust, 4), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.stone_helmet, new ItemStack(Blocks.COBBLESTONE, 5), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.stone_chestplate, new ItemStack(Blocks.COBBLESTONE, 8), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.stone_leggings, new ItemStack(Blocks.COBBLESTONE, 7), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.stone_boots, new ItemStack(Blocks.COBBLESTONE, 4), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.oak_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.oak_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.oak_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.oak_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.spruce_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.spruce_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.spruce_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.spruce_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.birch_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.birch_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.birch_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.birch_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.jungle_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.jungle_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.jungle_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.jungle_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.acacia_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.acacia_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.acacia_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.acacia_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.dark_oak_helmet, new ItemStack(ItemsCore.wood_chips, 5), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.dark_oak_chestplate, new ItemStack(ItemsCore.wood_chips, 8), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.dark_oak_leggings, new ItemStack(ItemsCore.wood_chips, 7), 0.5F);
		GrinderRecipes.instance().addSmelting(SPItems.dark_oak_boots, new ItemStack(ItemsCore.wood_chips, 4), 0.5F);
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
		Item ingotCopper = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "ingotCopper"));
		Item ingotTin = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "ingotTin"));
		
		GameRegistry.addRecipe(new ItemStack(SPItems.desert_acacia_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs0, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.desert_acacia_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs0, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.desert_acacia_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs0, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.desert_acacia_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs0, 1, 2)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.balsa_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs2, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.balsa_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs2, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.balsa_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs2, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.balsa_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs2, 1, 3)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.baobab_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs1, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.baobab_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs1, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.baobab_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs1, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.baobab_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs1, 1, 2)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.cherry_helmet_forestry), new Object[]{"BBB","B B", 'B', new ItemStack(logs3, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.cherry_chestplate_forestry), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs3, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.cherry_leggings_forestry), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs3, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.cherry_boots_forestry), new Object[]{"B B","B B", 'B', new ItemStack(logs3, 1, 3)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.chestnut_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.chestnut_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.chestnut_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.chestnut_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs1)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.citrus_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs5, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.citrus_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs5, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.citrus_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs5, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.citrus_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs5, 1, 3)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.cocobolo_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs6, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.cocobolo_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs6, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.cocobolo_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs6, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.cocobolo_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs6, 1, 3)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.ebony_helmet_forestry), new Object[]{"BBB","B B", 'B', new ItemStack(logs2, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.ebony_chestplate_forestry), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs2, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.ebony_leggings_forestry), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs2, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.ebony_boots_forestry), new Object[]{"B B","B B", 'B', new ItemStack(logs2, 1, 1)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.giant_sequoia_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.giant_sequoia_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.giant_sequoia_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs6)});
		GameRegistry.addRecipe(new ItemStack(SPItems.giant_sequoia_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs6)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.greenheart_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs3, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.greenheart_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs3, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.greenheart_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs3, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.greenheart_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs3, 1, 2)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.ipe_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs6, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.ipe_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs6, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.ipe_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs6, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.ipe_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs6, 1, 1)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.kapok_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.kapok_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.kapok_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.kapok_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs2)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.larch_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs0)});
		GameRegistry.addRecipe(new ItemStack(SPItems.larch_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs0)});
		GameRegistry.addRecipe(new ItemStack(SPItems.larch_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs0)});
		GameRegistry.addRecipe(new ItemStack(SPItems.larch_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs0)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.lime_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs0, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.lime_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs0, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.lime_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs0, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.lime_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs0, 1, 3)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.mahoe_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.mahoe_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.mahoe_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs4)});
		GameRegistry.addRecipe(new ItemStack(SPItems.mahoe_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs4)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.mahogany_helmet_forestry), new Object[]{"BBB","B B", 'B', new ItemStack(logs2, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.mahogany_chestplate_forestry), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs2, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.mahogany_leggings_forestry), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs2, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.mahogany_boots_forestry), new Object[]{"B B","B B", 'B', new ItemStack(logs2, 1, 2)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.maple_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs5, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.maple_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs5, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.maple_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs5, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.maple_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs5, 1, 2)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.padauk_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs6, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.padauk_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs6, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.padauk_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs6, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.padauk_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs6, 1, 2)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.palm_helmet_forestry), new Object[]{"BBB","B B", 'B', new ItemStack(logs4, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.palm_chestplate_forestry), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs4, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.palm_leggings_forestry), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs4, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SPItems.palm_boots_forestry), new Object[]{"B B","B B", 'B', new ItemStack(logs4, 1, 2)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.papaya_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs4, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.papaya_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs4, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.papaya_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs4, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.papaya_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs4, 1, 3)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.pine_helmet_forestry), new Object[]{"BBB","B B", 'B', new ItemStack(logs5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.pine_chestplate_forestry), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.pine_leggings_forestry), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs5)});
		GameRegistry.addRecipe(new ItemStack(SPItems.pine_boots_forestry), new Object[]{"B B","B B", 'B', new ItemStack(logs5)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.plum_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs5, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.plum_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs5, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.plum_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs5, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.plum_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs5, 1, 1)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.poplar_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs4, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.poplar_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs4, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.poplar_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs4, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.poplar_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs4, 1, 1)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.sequoia_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs1, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.sequoia_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs1, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.sequoia_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs1, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.sequoia_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs1, 1, 3)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.teak_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs0, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.teak_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs0, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.teak_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs0, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.teak_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs0, 1, 1)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.walnut_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs3, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.walnut_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs3, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.walnut_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs3, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.walnut_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs3, 1, 1)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.wenge_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs1, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.wenge_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs1, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.wenge_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs1, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SPItems.wenge_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs1, 1, 1)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.willow_helmet_forestry), new Object[]{"BBB","B B", 'B', new ItemStack(logs3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.willow_chestplate_forestry), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.willow_leggings_forestry), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs3)});
		GameRegistry.addRecipe(new ItemStack(SPItems.willow_boots_forestry), new Object[]{"B B","B B", 'B', new ItemStack(logs3)});
		
		GameRegistry.addRecipe(new ItemStack(SPItems.zebrawood_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(logs7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.zebrawood_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(logs7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.zebrawood_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(logs7)});
		GameRegistry.addRecipe(new ItemStack(SPItems.zebrawood_boots), new Object[]{"B B","B B", 'B', new ItemStack(logs7)});
		
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
		
		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 1, 2), new Object[] {"ingotCopper"});
		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 1, 3), new Object[] {"ingotTin"});
		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 1, 6), new Object[] {"ingotBronze"});
		removeCraftingRecipe(new ItemStack(ingot, 1, 1));
		removeCraftingRecipe(new ItemStack(ingot, 1, 2));
		removeCraftingRecipe(new ItemStack(ingot, 1, 5));
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
		}
	}
	
	
    @SuppressWarnings("unchecked")
    public static void addRecipe(ItemStack result, Object[] obj)
    {
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(result, obj));
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
