package net.coolsimulations.SurvivalPlus.core.util;

import java.util.Iterator;
import java.util.Map;

import com.coliwogg.gemsmod.init.BlockInit;
import com.coliwogg.gemsmod.init.ItemInit;

import ic2.api.item.IC2Items;
import micdoodle8.mods.galacticraft.core.GCItems;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusSmeltingRecipes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class SurvivalPlusAPIRecipes {
	
	public static void loadRecipes()
    {

        if (SPCompatibilityManager.isIc2Loaded())
        {
            SurvivalPlusAPIRecipes.addIndustrialCraft2Recipes();
        }
        
        if(SPCompatibilityManager.isGCLoaded() && SPConfig.enableReplaceSmelting) {
        	SurvivalPlusAPIRecipes.addGCItemsRecipes();
        }
        
        if(SPCompatibilityManager.isSimpleGrinderLoaded() || SPCompatibilityManager.isIc2Loaded()) {
        	if(SPConfig.enableReplaceSmelting) {
        		SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("dustCopper", new ItemStack(SPItems.copper_ingot), 3.0F, true);
        		SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("dustTin", new ItemStack(SPItems.tin_ingot), 3.0F, true);
        	} else {
        		GameRegistry.addSmelting(SPItems.copper_dust, new ItemStack(SPItems.copper_ingot), 3.0F);
        		GameRegistry.addSmelting(SPItems.tin_dust, new ItemStack(SPItems.tin_ingot), 3.0F);
        	}
        	GameRegistry.addSmelting(SPItems.titanium_dust, new ItemStack(SPItems.titanium_ingot), 3.0F);
        }
        
        if(SPCompatibilityManager.isRailcraftLoaded() && SPConfig.enableReplaceSmelting) {
        	SurvivalPlusAPIRecipes.addRailcraftItemsRecipes();
        }
        
        if(SPCompatibilityManager.isTriGemsLoaded() && SPConfig.enableReplaceSmelting) {
        	SurvivalPlusAPIRecipes.addTriGemsItemsRecipes();
        }
        
        if(SPCompatibilityManager.isGACLoaded() && SPConfig.enableReplaceSmelting) {
        	SurvivalPlusAPIRecipes.addGemsAndCrystalsItemsRecipes();
        }
        
        if(SPCompatibilityManager.isBopLoaded()) {
        	Item bamboo = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.BOP_MODID, "bamboo"));
        	
        	OreDictionary.registerOre("cropBamboo", new ItemStack(bamboo));
        }
        
        if(SPCompatibilityManager.isBamboozledLoaded()) {
        	Item bamboo = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.BAMBOOZLED_MODID, "bamboo"));
        	Item dried_bamboo = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.BAMBOOZLED_MODID, "bamboo_dried"));
        	
        	OreDictionary.registerOre("cropBamboo", new ItemStack(bamboo));
        	removeFurnaceRecipe(new ItemStack(dried_bamboo));
        	SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("cropBamboo", new ItemStack(dried_bamboo), 1.0F, true);
        }
        
        if(SPCompatibilityManager.isWeepingAngelsLoaded()) {
        	Item ore = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.WEEPING_ANGELS_MODID, "kontron_ore"));
        	Item ingot = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.WEEPING_ANGELS_MODID, "kontron_ingot"));
        	
        	OreDictionary.registerOre("oreKontron", new ItemStack(ore));
        	OreDictionary.registerOre("ingotKontron", new ItemStack(ingot));
        	SurvivalPlusSmeltingRecipes.addOreDictionaryRecipe("oreKontron", new ItemStack(ingot), 0.7F, true);
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
		removeFurnaceRecipe(new ItemStack(GCItems.basicItem, 1, 4));
		removeFurnaceRecipe(new ItemStack(GCItems.basicItem, 3, 4));
		GameRegistry.addSmelting(new ItemStack(GCItems.canister), new ItemStack(SPItems.tin_ingot, 3), 0.5F);
		
		
	}
	
	private static void addRailcraftItemsRecipes() {
		
		Item ingot = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "ingot"));
		Item nugget = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "nugget"));
		Block oreMetal = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "ore_metal"));
		Block generic = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.RAILCRAFT_MODID, "generic"));
		
		/**if (OreDictionary.getOres("ingotSteel").size() > 0) {
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
	
	private static void addGemsAndCrystalsItemsRecipes() {
		
		removeFurnaceRecipe(new ItemStack(ItemInit.AMETHYST));
		removeFurnaceRecipe(new ItemStack(ItemInit.RUBY));
		removeFurnaceRecipe(new ItemStack(ItemInit.SAPPHIRE));;
		removeFurnaceRecipe(new ItemStack(ItemInit.TOPAZ));
		GameRegistry.addSmelting(BlockInit.AMETHYST_ORE, new ItemStack(SPBlocks.amethyst), 1.5F);
		GameRegistry.addSmelting(BlockInit.RUBY_ORE, new ItemStack(SPBlocks.ruby), 1.5F);
		GameRegistry.addSmelting(BlockInit.SAPPHIRE_ORE, new ItemStack(SPBlocks.sapphire), 1.5F);
		GameRegistry.addSmelting(BlockInit.TOPAZ_ORE, new ItemStack(SPBlocks.topaz), 1.5F);
	}
	
	private static void addTriGemsItemsRecipes() {
		
		Item ruby = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "ruby"));
		Item sapphire = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "sapphire"));
		Item topaz = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "topaz"));
		
		Block ruby_ore = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "ruby_ore"));
		Block sapphire_ore = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "sapphire_ore"));
		Block topaz_ore = Block.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "topaz_ore"));
		
		removeFurnaceRecipe(new ItemStack(ruby));
		removeFurnaceRecipe(new ItemStack(sapphire));
		removeFurnaceRecipe(new ItemStack(topaz));
		GameRegistry.addSmelting(ruby_ore, new ItemStack(SPBlocks.ruby), 0.5F);
		GameRegistry.addSmelting(sapphire_ore, new ItemStack(SPBlocks.sapphire), 0.5F);
		GameRegistry.addSmelting(topaz_ore, new ItemStack(SPBlocks.topaz), 0.5F);
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

}
