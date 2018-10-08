package net.coolsimulations.SurvivalPlus.core.util;

import ic2.api.item.IC2Items;

import java.util.Iterator;
import java.util.Map;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.venus.VenusBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SurvivalPlusAPIRecipes {
	
	public static void loadRecipes()
    {

        if (SPCompatibilityManager.isIc2Loaded())
        {
            SurvivalPlusAPIRecipes.addIndustrialCraft2Recipes();
        }
        
        if(SPCompatibilityManager.isForestryLoaded()) {
        	SurvivalPlusAPIRecipes.addForestryItemsRecipes();
        }
        
        if(SPCompatibilityManager.isGCLoaded()) {
        	SurvivalPlusAPIRecipes.addGCItemsRecipes();
        }
        
        if(SPCompatibilityManager.isSimpleGrinderLoaded() && !SPCompatibilityManager.isIc2Loaded()) {
        	
        	GameRegistry.addSmelting(SPItems.copper_dust, new ItemStack(SPItems.copper_ingot), 3.0F);
			GameRegistry.addSmelting(SPItems.tin_dust, new ItemStack(SPItems.tin_ingot), 3.0F);
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
		
		addRecipe(cable, new Object []{"GGG", "ETE", "GGG", 'G', Blocks.GLASS, 'T', "dustTitanium", 'E', IC2Items.getItem("dust", "energium")});
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
	
	private static void addForestryItemsRecipes() {
		
		Block resources = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "resources"));
		Item ingotCopper = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "ingot_copper"));
		Item ingotTin = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "ingot_tin"));
		
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
		
		/**SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 1, 2), new Object[] {"ingotCopper"});
		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 1, 3), new Object[] {"ingotTin"});
		SurvivalPlusShapelessRecipes.addShapelessOreRecipe(new ItemStack(nugget, 1, 6), new Object[] {"ingotBronze"});
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
		addRecipe(new ItemStack(SPItems.bronze_ingot), new Object []{"BBB", "BBB", "BBB", 'B', new ItemStack(nugget, 1, 6)});**/
		
		if(SPCompatibilityManager.isIc2Loaded()) {
			
			removeFurnaceRecipe(new ItemStack(ingot, 1, 3));
			GameRegistry.addSmelting(new ItemStack(oreMetal, 1, 2), IC2Items.getItem("ingot", "lead"), 1.0F);
			removeFurnaceRecipe(new ItemStack(ingot, 1, 4));
			GameRegistry.addSmelting(new ItemStack(oreMetal, 1, 3), IC2Items.getItem("ingot", "silver"), 1.0F);
			/**removeCraftingRecipe(new ItemStack(ingot, 1, 3));
			removeCraftingRecipe(new ItemStack(ingot, 9, 3));
			removeCraftingRecipe(new ItemStack(ingot, 1, 4));
			removeCraftingRecipe(new ItemStack(ingot, 9, 4));
			removeCraftingRecipe(new ItemStack(generic, 1, 10));
			removeCraftingRecipe(new ItemStack(generic, 1, 2));
			addRecipe(IC2Items.getItem("ingot", "lead"), new Object []{"BBB", "BBB", "BBB", 'B', new ItemStack(nugget, 1, 4)});
			addRecipe(IC2Items.getItem("ingot", "silver"), new Object []{"BBB", "BBB", "BBB", 'B', new ItemStack(nugget, 1, 5)});**/
		}
	}
	
    @SuppressWarnings("unchecked")
    public static void addRecipe(ItemStack result, Object[] obj)
    {
        GameRegistry.addShapedRecipe(result.getItem().getRegistryName(), null, result, obj);
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
	
	public static ItemStack getIndustrialCraftItem(String name)
	{
		return IC2Items.getItem(name, null);
	}

}
