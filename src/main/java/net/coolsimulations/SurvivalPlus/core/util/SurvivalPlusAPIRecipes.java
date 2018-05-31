package net.coolsimulations.SurvivalPlus.core.util;

import ic2.api.item.IC2Items;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.venus.VenusBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusShapelessRecipes;
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
    }
	
	private static void addIndustrialCraft2Recipes()
    {
		
		//These recipes are added so that you can used BOP dirt and grass to makes these
		addRecipe(IC2Items.getItem("te", "terraformer"), new Object []{"GTG", "DAD", "GDG", 'G', "dustGlowstone", 'T', IC2Items.getItem("tfbp", "blank"), 'A', IC2Items.getItem("resource", "advanced_machine"), 'D', "dirt"});
		addRecipe(IC2Items.getItem("te", "recycler"), new Object []{" G ", "DCD", "IDI", 'G', "dustGlowstone", 'C', IC2Items.getItem("te", "compressor"), 'I', "ingotIron", 'D', "dirt"});
		addRecipe(IC2Items.getItem("tfbp", "flatification"), new Object []{" D ", "DTD", " D ", 'T', IC2Items.getItem("tfbp", "blank"), 'D', "dirt"});
		if (SPCompatibilityManager.isBopLoaded()){
			GameRegistry.addRecipe(IC2Items.getItem("crafting", "plant_ball"), new Object []{"GGG", "G G", "GGG", 'G', new ItemStack(BOPBlocks.plant_0, 1, 0)});
			GameRegistry.addRecipe(IC2Items.getItem("crafting", "plant_ball"), new Object []{"GGG", "G G", "GGG", 'G', new ItemStack(BOPBlocks.plant_0, 1, 1)});
			GameRegistry.addRecipe(IC2Items.getItem("crafting", "plant_ball"), new Object []{"GGG", "G G", "GGG", 'G', new ItemStack(BOPBlocks.plant_0, 1, 7)});
			GameRegistry.addRecipe(IC2Items.getItem("crafting", "plant_ball"), new Object []{"GGG", "G G", "GGG", 'G', new ItemStack(BOPBlocks.plant_0, 1, 8)});
			GameRegistry.addRecipe(IC2Items.getItem("crafting", "plant_ball"), new Object []{"GGG", "G G", "GGG", 'G', new ItemStack(BOPBlocks.plant_0, 1, 13)});
			GameRegistry.addRecipe(IC2Items.getItem("crafting", "plant_ball"), new Object []{"GGG", "G G", "GGG", 'G', new ItemStack(BOPBlocks.plant_0, 1, 14)});
			GameRegistry.addRecipe(IC2Items.getItem("crafting", "plant_ball"), new Object []{"GGG", "G G", "GGG", 'G', new ItemStack(BOPBlocks.plant_1)});
		}
		
		addRecipe(new ItemStack(SPItems.titanium_dust), new Object []{"CCC", "CCC", "CCC", 'C', "dustTinyTitanium"});
		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(SPItems.titanium_casing, 2), new Object []{"plateTitanium", "craftingToolForgeHammer"});
		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(SPItems.titanium_plate), new Object []{"ingotTitanium", "craftingToolForgeHammer"});
		addRecipe(IC2Items.getItem("cable", "type:glass,insulation:0"), new Object []{"GGG", "ETE", "GGG", 'G', "blockGlass", 'T', "dustTitanium", 'E', IC2Items.getItem("dust", "energium")});
		
		removeCraftingRecipe(IC2Items.getItem("te", "blast_furnace"));
		addRecipe(IC2Items.getItem("te", "blast_furnace"), new Object []{"CTC", "TMT", "CHC", 'T', "casingTitanium", 'C', IC2Items.getItem("casing", "iron"), 'M', IC2Items.getItem("resource", "machine"), 'H', IC2Items.getItem("crafting", "heat_conductor")});
		removeCraftingRecipe(IC2Items.getItem("te", "steam_generator"));
		addRecipe(IC2Items.getItem("te", "steam_generator"), new Object []{"CTC", "TBT", "CHC", 'T', "casingTitanium", 'C', IC2Items.getItem("casing", "iron"), 'B', IC2Items.getItem("crafting", "copper_boiler"), 'H', IC2Items.getItem("crafting", "heat_conductor")});
		removeCraftingRecipe(IC2Items.getItem("te", "electric_heat_generator"));
		addRecipe(IC2Items.getItem("te", "electric_heat_generator"), new Object []{"CRC", "TET", "CHC", 'T', "casingTitanium", 'R', new ItemStack(IC2Items.getItem("re_battery").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'C', IC2Items.getItem("casing", "iron"), 'E', "circuitBasic", 'H', IC2Items.getItem("crafting", "heat_conductor")});
		removeCraftingRecipe(IC2Items.getItem("te", "rt_generator"));
		addRecipe(IC2Items.getItem("te", "rt_generator"), new Object []{"CTC", "TRT", "CGC", 'T', "casingTitanium", 'R', IC2Items.getItem("te", "reactor_chamber"), 'C', IC2Items.getItem("casing", "iron"), 'G', IC2Items.getItem("te", "generator")});
		removeCraftingRecipe(IC2Items.getItem("te", "rt_heat_generator"));
		addRecipe(IC2Items.getItem("te", "rt_heat_generator"), new Object []{"CTC", "TRT", "CHC", 'T', "casingTitanium", 'R', IC2Items.getItem("te", "reactor_chamber"), 'C', IC2Items.getItem("casing", "iron"), 'H', IC2Items.getItem("crafting", "heat_conductor")});
		removeCraftingRecipe(IC2Items.getItem("drill"));
		addRecipe(IC2Items.getItem("drill"), new Object []{" P ", "PPP", "TUT", 'P', "plateIron", 'T', "plateTitanium", 'U', IC2Items.getItem("crafting", "power_unit")});
		removeCraftingRecipe(IC2Items.getItem("chainsaw"));
		addRecipe(IC2Items.getItem("chainsaw"), new Object []{" PP", "TPP", "UT ", 'P', "plateIron", 'T', "plateTitanium", 'U', IC2Items.getItem("crafting", "power_unit")});
		
    }
	
	private static void addSPItemsRecipes() {
		
		if(SPConfig.enableReplaceBOPRecipe){
		removeCraftingRecipe(new ItemStack(BOPItems.terrestrial_artifact));
		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(BOPItems.terrestrial_artifact), new Object[] {"gemRuby", "gemTopaz", "gemAmber", "gemPeridot", "gemMalachite", "gemSapphire", "gemTanzanite", "gemEmerald"});
		}
		
		if(SPCompatibilityManager.isGCLoaded()){
			SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(BOPItems.terrestrial_artifact), new Object[] {"gemRuby", "gemTopaz", "gemAmber", "gemPeridot", "gemMalachite", new ItemStack(GCItems.itemBasicMoon, 1, 2), "gemTanzanite", "gemEmerald"});
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
