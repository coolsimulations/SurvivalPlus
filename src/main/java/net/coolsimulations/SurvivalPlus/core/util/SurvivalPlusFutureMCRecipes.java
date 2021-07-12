package net.coolsimulations.SurvivalPlus.core.util;

import com.coliwogg.gemsmod.init.BlockInit;

import ic2.api.item.IC2Items;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.compat.SPCompatRecipeManager;
import net.insane96mcp.carbonado.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class SurvivalPlusFutureMCRecipes {
	
	public static void init()
    {
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryCampfireRecipe("egg", new ItemStack(SPItems.fried_egg), 600);
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryCampfireRecipe("cropCarrot", new ItemStack(SPItems.roast_carrot), 600);
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryCampfireRecipe("foodCheesebread", new ItemStack(SPItems.melted_cheese_bread), 600);
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryCampfireRecipe("cropApple", new ItemStack(SPItems.baked_apple), 600);
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryCampfireRecipe("cropOnion", new ItemStack(SPItems.fried_onion), 600);
		
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_axe), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_hoe), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_pickaxe), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_shears), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_shovel), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_sword), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_helmet), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_chestplate), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_leggings), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.bronze_boots), new ItemStack(SPItems.bronze_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_axe), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_hoe), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_pickaxe), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_shears), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_shovel), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_sword), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_helmet), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_chestplate), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_leggings), new ItemStack(SPItems.titanium_nugget));
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_boots), new ItemStack(SPItems.titanium_nugget));
		
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("oreCopper", new ItemStack(SPItems.copper_ingot), true);
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("oreTin", new ItemStack(SPItems.tin_ingot), true);
		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPBlocks.titanium_ore), new ItemStack(SPItems.titanium_ingot));
		
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("cropOnion", SPCompatRecipeManager.futureRecipeManager.getComposterRarityRare());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("seedOnion", SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodApplebaked", SPCompatRecipeManager.futureRecipeManager.getComposterRarityEpic());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodCheese", SPCompatRecipeManager.futureRecipeManager.getComposterRarityUnCommon());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodFriedonions", SPCompatRecipeManager.futureRecipeManager.getComposterRarityRare());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodRoastcarrot", SPCompatRecipeManager.futureRecipeManager.getComposterRarityEpic());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodApplepie", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodBeefpie", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodChickenpie", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodMuttonpie", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodPorkpie", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodRabbitpie", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodVegetablepie", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodCheesebread", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodMeltedCheesebread", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodCupcake", SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodCheesecupcake", SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodSpongecupcake", SPCompatRecipeManager.futureRecipeManager.getComposterRarityCommon());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodCheesecake", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryComposterRecipe("foodSpongecake", SPCompatRecipeManager.futureRecipeManager.getComposterRarityLegendary());
		
		if(SPCompatibilityManager.isSimpleGrinderLoaded() || SPCompatibilityManager.isIc2Loaded()) {
			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("dustCopper", new ItemStack(SPItems.copper_ingot), true);
			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("dustTin", new ItemStack(SPItems.tin_ingot), true);
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(SPItems.titanium_dust), new ItemStack(SPItems.titanium_ingot));
		}
		
		if(SPCompatibilityManager.isIc2Loaded()) {
			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedCopper", new ItemStack(SPItems.copper_ingot), true);
			SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedCopper", new ItemStack(SPItems.copper_ingot), true);
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("dustCopper", new ItemStack(SPItems.copper_ingot), true);
	       	
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedTin", new ItemStack(SPItems.tin_ingot), true);
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedTin", new ItemStack(SPItems.tin_ingot), true);
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("dustTin", new ItemStack(SPItems.tin_ingot), true);
	       	
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("dustBronze", new ItemStack(SPItems.bronze_ingot), true);
	    	
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedTitanium", new ItemStack(SPItems.titanium_ingot));
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedTitanium", new ItemStack(SPItems.titanium_ingot));
	       	
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedGold", new ItemStack(Items.GOLD_INGOT));
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedGold", new ItemStack(Items.GOLD_INGOT));
	       	
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedIron", new ItemStack(Items.IRON_INGOT));
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedIron", new ItemStack(Items.IRON_INGOT));
	       	
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedLead", IC2Items.getItem("ingot", "lead"));
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedLead", IC2Items.getItem("ingot", "lead"));
	       	
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedSilver", IC2Items.getItem("ingot", "silver"));
	       	SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedSilver", IC2Items.getItem("ingot", "silver"));
	       	
	       	SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(IC2Items.getItem("dust", "coal_fuel"), IC2Items.getItem("dust", "coal"));
	       	
	       	SPCompatRecipeManager.futureRecipeManager.addCampfireRecipe(IC2Items.getItem("mug", "cold_coffee"), IC2Items.getItem("mug", "dark_coffee"), 600);
	       	SPCompatRecipeManager.futureRecipeManager.addSmokerRecipe(IC2Items.getItem("mug", "cold_coffee"), IC2Items.getItem("mug", "dark_coffee"));
	       	
	       	if(SPCompatibilityManager.isGCLoaded()) {
	       		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedAluminum", new ItemStack(GCItems.basicItem, 1, 5));
	       		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("crushedPurifiedAluminum", new ItemStack(GCItems.basicItem, 1, 5));
	       	}
		}
		
		if(SPCompatibilityManager.isGCLoaded()) {
			
			SPCompatRecipeManager.futureRecipeManager.addCampfireRecipe(new ItemStack(GCItems.foodItem, 1, 6), new ItemStack(GCItems.foodItem, 1, 7), 600);
			
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.canister, 1, 1), new ItemStack(SPItems.copper_ingot, 3));
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(GCItems.canister), new ItemStack(SPItems.tin_ingot, 3));
			
			if(SPCompatibilityManager.isGCPLoaded()) {
	       		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(MarsItems.marsItemBasic), new ItemStack(MarsItems.marsItemBasic, 1, 2));
	       		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(AsteroidsItems.basicItem, 1, 3), new ItemStack(Items.IRON_INGOT));
	       		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(AsteroidsItems.basicItem, 1, 4), new ItemStack(AsteroidsItems.basicItem));
	       	}
		}
		
		if(SPCompatibilityManager.isCarbonadoLoaded()) {
			SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ModItems.carbonadoShardItem), new ItemStack(ModItems.carbonadoShardMoltenItem));
       	}
       	
       	if(SPCompatibilityManager.isForestryLoaded()) {
       		Item peat = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "peat"));
       		Item ash = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "ash"));
       		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(peat), new ItemStack(ash));
       	}
       	
       	if(SPCompatibilityManager.isGACLoaded()) {
       		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(BlockInit.AMETHYST_ORE), new ItemStack(SPBlocks.amethyst));
    		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(BlockInit.RUBY_ORE), new ItemStack(SPBlocks.ruby));
    		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(BlockInit.SAPPHIRE_ORE), new ItemStack(SPBlocks.sapphire));
    		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(BlockInit.TOPAZ_ORE), new ItemStack(SPBlocks.topaz));
       	}
       	
       	if(SPCompatibilityManager.isTriGemsLoaded()) {
       		Item ruby = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "ruby_ore"));
       		Item sapphire = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "sapphire_ore"));
       		Item topaz = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.TRIGEMS_MODID, "topaz_ore"));
       		
       		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(ruby), new ItemStack(SPBlocks.ruby));
    		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(sapphire), new ItemStack(SPBlocks.sapphire));
    		SPCompatRecipeManager.futureRecipeManager.addBlastFurnaceRecipe(new ItemStack(topaz), new ItemStack(SPBlocks.topaz));
       	}
       	
       	if(SPCompatibilityManager.isBamboozledLoaded()) {
       		Item dried_bamboo = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.BAMBOOZLED_MODID, "bamboo_dried"));
       		
       		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryCampfireRecipe("cropBamboo", new ItemStack(dried_bamboo), 600);
       	}
       	
       	if(SPCompatibilityManager.isWeepingAngelsLoaded()) {
       		Item ingot = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.WEEPING_ANGELS_MODID, "kontron_ingot"));
       		
       		SPCompatRecipeManager.futureRecipeManager.addOreDictionaryBlastFurnaceRecipe("oreKontron", new ItemStack(ingot));
       	}
    }

}
