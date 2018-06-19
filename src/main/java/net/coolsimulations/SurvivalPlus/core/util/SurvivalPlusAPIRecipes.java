package net.coolsimulations.SurvivalPlus.core.util;

import ic2.api.item.IC2Items;
import ic2.api.recipe.Recipes;

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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
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
        
        if(SPCompatibilityManager.isGCLoaded()) {
        	SurvivalPlusAPIRecipes.addGCItemsRecipes();
        }
        
        if(SPCompatibilityManager.isSimpleGrinderLoaded()) {
        	SurvivalPlusAPIRecipes.addSimpleGrinderRecipes();
        }
        
        if(SPCompatibilityManager.isSimpleGrinderLoaded() || SPCompatibilityManager.isIc2Loaded()) {
        	GameRegistry.addSmelting(SPItems.titanium_dust, new ItemStack(SPItems.titanium_ingot), 3.0F);
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
