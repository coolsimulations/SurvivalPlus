package net.coolsimulations.SurvivalPlus.core.util;

import com.ToMe.trigems.TriGemsMod;
import com.coliwogg.gemsmod.init.BlockInit;
import com.mojang.realmsclient.client.Request.Put;

import forestry.api.core.ForestryAPI;
import ic2.api.item.IC2Items;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.fluid.ThreadFindSeal.intBucket;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusSmeltingRecipes;
import net.insane96mcp.carbonado.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import scala.reflect.internal.Trees.New;
import thedarkcolour.futuremc.block.villagepillage.ComposterBlock;
import thedarkcolour.futuremc.block.villagepillage.ComposterRarity;
import thedarkcolour.futuremc.compat.crafttweaker.Composter;
import thedarkcolour.futuremc.compat.jei.composter.ComposterRecipeCategory;
import thedarkcolour.futuremc.recipe.campfire.CampfireRecipes;
import thedarkcolour.futuremc.recipe.furnace.BlastFurnaceRecipes;
import thedarkcolour.futuremc.recipe.furnace.SmokerRecipes;

public class SurvivalPlusFutureMCRecipes {
	
	public static void init()
    {
		addOreDictionaryCampfireRecipe("egg", new ItemStack(SPItems.fried_egg), 600);
		addOreDictionaryCampfireRecipe("cropCarrot", new ItemStack(SPItems.roast_carrot), 600);
		addOreDictionaryCampfireRecipe("foodCheesebread", new ItemStack(SPItems.melted_cheese_bread), 600);
		CampfireRecipes.INSTANCE.addRecipe(new ItemStack(Items.APPLE), new ItemStack(SPItems.baked_apple), 600);
		addOreDictionaryCampfireRecipe("cropApple", new ItemStack(SPItems.baked_apple), 600);
		addOreDictionaryCampfireRecipe("cropOnion", new ItemStack(SPItems.fried_onion), 600);
		
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.bronze_axe), new ItemStack(SPItems.bronze_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.bronze_hoe), new ItemStack(SPItems.bronze_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.bronze_pickaxe), new ItemStack(SPItems.bronze_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.bronze_shears), new ItemStack(SPItems.bronze_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.bronze_shovel), new ItemStack(SPItems.bronze_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.bronze_sword), new ItemStack(SPItems.bronze_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.bronze_helmet), new ItemStack(SPItems.bronze_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.bronze_chestplate), new ItemStack(SPItems.bronze_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.bronze_leggings), new ItemStack(SPItems.bronze_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.bronze_boots), new ItemStack(SPItems.bronze_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.titanium_axe), new ItemStack(SPItems.titanium_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.titanium_hoe), new ItemStack(SPItems.titanium_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.titanium_pickaxe), new ItemStack(SPItems.titanium_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.titanium_shears), new ItemStack(SPItems.titanium_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.titanium_shovel), new ItemStack(SPItems.titanium_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.titanium_sword), new ItemStack(SPItems.titanium_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.titanium_helmet), new ItemStack(SPItems.titanium_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.titanium_chestplate), new ItemStack(SPItems.titanium_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.titanium_leggings), new ItemStack(SPItems.titanium_nugget));
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.titanium_boots), new ItemStack(SPItems.titanium_nugget));
		
		addOreDictionaryBlastFurnaceRecipe("oreCopper", new ItemStack(SPItems.copper_ingot), true);
		addOreDictionaryBlastFurnaceRecipe("oreTin", new ItemStack(SPItems.tin_ingot), true);
		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPBlocks.titanium_ore), new ItemStack(SPItems.titanium_ingot));
		
		addOreDictionaryComposterRecipe("cropOnion", ComposterRarity.Companion.getRARE());
		addOreDictionaryComposterRecipe("seedOnion", ComposterRarity.Companion.getCOMMON());
		addOreDictionaryComposterRecipe("foodApplebaked", ComposterRarity.Companion.getEPIC());
		addOreDictionaryComposterRecipe("foodCheese", ComposterRarity.Companion.getUNCOMMON());
		addOreDictionaryComposterRecipe("foodFriedonions", ComposterRarity.Companion.getRARE());
		addOreDictionaryComposterRecipe("foodRoastcarrot", ComposterRarity.Companion.getEPIC());
		addOreDictionaryComposterRecipe("foodApplepie", ComposterRarity.Companion.getLEGENDARY());
		addOreDictionaryComposterRecipe("foodBeefpie", ComposterRarity.Companion.getLEGENDARY());
		addOreDictionaryComposterRecipe("foodChickenpie", ComposterRarity.Companion.getLEGENDARY());
		addOreDictionaryComposterRecipe("foodMuttonpie", ComposterRarity.Companion.getLEGENDARY());
		addOreDictionaryComposterRecipe("foodPorkpie", ComposterRarity.Companion.getLEGENDARY());
		addOreDictionaryComposterRecipe("foodRabbitpie", ComposterRarity.Companion.getLEGENDARY());
		addOreDictionaryComposterRecipe("foodVegetablepie", ComposterRarity.Companion.getLEGENDARY());
		addOreDictionaryComposterRecipe("foodCheesebread", ComposterRarity.Companion.getLEGENDARY());
		addOreDictionaryComposterRecipe("foodMeltedCheesebread", ComposterRarity.Companion.getLEGENDARY());
		addOreDictionaryComposterRecipe("foodCupcake", ComposterRarity.Companion.getCOMMON());
		addOreDictionaryComposterRecipe("foodCheesecupcake", ComposterRarity.Companion.getCOMMON());
		addOreDictionaryComposterRecipe("foodSpongecupcake", ComposterRarity.Companion.getCOMMON());
		addOreDictionaryComposterRecipe("foodCheesecake", ComposterRarity.Companion.getLEGENDARY());
		addOreDictionaryComposterRecipe("foodSpongecake", ComposterRarity.Companion.getLEGENDARY());
		
		if(SPCompatibilityManager.isSimpleGrinderLoaded() || SPCompatibilityManager.isIc2Loaded()) {
			addOreDictionaryBlastFurnaceRecipe("dustCopper", new ItemStack(SPItems.copper_ingot), true);
			addOreDictionaryBlastFurnaceRecipe("dustTin", new ItemStack(SPItems.tin_ingot), true);
			BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(SPItems.titanium_dust), new ItemStack(SPItems.titanium_ingot));
		}
		
		if(SPCompatibilityManager.isIc2Loaded()) {
			addOreDictionaryBlastFurnaceRecipe("crushedCopper", new ItemStack(SPItems.copper_ingot), true);
	       	addOreDictionaryBlastFurnaceRecipe("crushedPurifiedCopper", new ItemStack(SPItems.copper_ingot), true);
	       	addOreDictionaryBlastFurnaceRecipe("dustCopper", new ItemStack(SPItems.copper_ingot), true);
	       	
	       	addOreDictionaryBlastFurnaceRecipe("crushedTin", new ItemStack(SPItems.tin_ingot), true);
	       	addOreDictionaryBlastFurnaceRecipe("crushedPurifiedTin", new ItemStack(SPItems.tin_ingot), true);
	       	addOreDictionaryBlastFurnaceRecipe("dustTin", new ItemStack(SPItems.tin_ingot), true);
	       	
	       	addOreDictionaryBlastFurnaceRecipe("dustBronze", new ItemStack(SPItems.bronze_ingot), true);
	    	
	       	addOreDictionaryBlastFurnaceRecipe("crushedTitanium", new ItemStack(SPItems.titanium_ingot));
	       	addOreDictionaryBlastFurnaceRecipe("crushedPurifiedTitanium", new ItemStack(SPItems.titanium_ingot));
	       	
	       	addOreDictionaryBlastFurnaceRecipe("crushedGold", new ItemStack(Items.GOLD_INGOT));
	       	addOreDictionaryBlastFurnaceRecipe("crushedPurifiedGold", new ItemStack(Items.GOLD_INGOT));
	       	
	       	addOreDictionaryBlastFurnaceRecipe("crushedIron", new ItemStack(Items.IRON_INGOT));
	       	addOreDictionaryBlastFurnaceRecipe("crushedPurifiedIron", new ItemStack(Items.IRON_INGOT));
	       	
	       	addOreDictionaryBlastFurnaceRecipe("crushedLead", IC2Items.getItem("ingot", "lead"));
	       	addOreDictionaryBlastFurnaceRecipe("crushedPurifiedLead", IC2Items.getItem("ingot", "lead"));
	       	
	       	addOreDictionaryBlastFurnaceRecipe("crushedSilver", IC2Items.getItem("ingot", "silver"));
	       	addOreDictionaryBlastFurnaceRecipe("crushedPurifiedSilver", IC2Items.getItem("ingot", "silver"));
	       	
	       	BlastFurnaceRecipes.INSTANCE.addRecipe(IC2Items.getItem("dust", "coal_fuel"), IC2Items.getItem("dust", "coal"));
	       	
	       	SmokerRecipes.INSTANCE.addRecipe(IC2Items.getItem("mug", "cold_coffee"), IC2Items.getItem("mug", "dark_coffee"));
	       	CampfireRecipes.INSTANCE.addRecipe(IC2Items.getItem("mug", "cold_coffee"), IC2Items.getItem("mug", "dark_coffee"), 600);
	       	
	       	if(SPCompatibilityManager.isGCLoaded()) {
	       		addOreDictionaryBlastFurnaceRecipe("crushedAluminum", new ItemStack(GCItems.basicItem, 1, 5));
		       	addOreDictionaryBlastFurnaceRecipe("crushedPurifiedAluminum", new ItemStack(GCItems.basicItem, 1, 5));
	       	}
		}
		
		if(SPCompatibilityManager.isGCLoaded()) {
			
			CampfireRecipes.INSTANCE.addRecipe(new ItemStack(GCItems.foodItem, 1, 6), new ItemStack(GCItems.foodItem, 1, 7), 600);
			
			BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(GCItems.canister, 1, 1), new ItemStack(SPItems.copper_ingot, 3));
			BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(GCItems.canister), new ItemStack(SPItems.tin_ingot, 3));
			
			if(SPCompatibilityManager.isGCPLoaded()) {
	       		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(MarsItems.marsItemBasic), new ItemStack(MarsItems.marsItemBasic, 1, 2));
	       		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(AsteroidsItems.basicItem, 1, 3), new ItemStack(Items.IRON_INGOT));
	       		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(AsteroidsItems.basicItem, 1, 4), new ItemStack(AsteroidsItems.basicItem));
	       	}
		}
		
		if(SPCompatibilityManager.isCarbonadoLoaded()) {
       		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(ModItems.carbonadoShardItem), new ItemStack(ModItems.carbonadoShardMoltenItem));
       	}
       	
       	if(SPCompatibilityManager.isForestryLoaded()) {
       		Item peat = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "peat"));
       		Item ash = Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.FORESTRY_MODID, "ash"));
       		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(peat), new ItemStack(ash));
       	}
       	
       	if(SPCompatibilityManager.isGACLoaded()) {
       		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(BlockInit.AMETHYST_ORE), new ItemStack(SPBlocks.amethyst));
    		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(BlockInit.RUBY_ORE), new ItemStack(SPBlocks.ruby));
    		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(BlockInit.SAPPHIRE_ORE), new ItemStack(SPBlocks.sapphire));
    		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(BlockInit.TOPAZ_ORE), new ItemStack(SPBlocks.topaz));
       	}
       	
       	if(SPCompatibilityManager.isTriGemsLoaded()) {
       		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(TriGemsMod.oreRuby), new ItemStack(SPBlocks.ruby));
    		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(TriGemsMod.oreSapphire), new ItemStack(SPBlocks.sapphire));
    		BlastFurnaceRecipes.INSTANCE.addRecipe(new ItemStack(TriGemsMod.oreTopaz), new ItemStack(SPBlocks.topaz));
       	}
    }
	
	protected static void addOreDictionaryCampfireRecipe(String input, ItemStack output, int duration) {
		
		for(ItemStack stack : OreDictionary.getOres(input)) {
			CampfireRecipes.INSTANCE.addRecipe(stack, output, duration);
		}
	}
	
	protected static void addOreDictionaryBlastFurnaceRecipe(String input, ItemStack output) {
		
		addOreDictionaryBlastFurnaceRecipe(input, output, false);
	}
	
	protected static void addOreDictionaryBlastFurnaceRecipe(String input, ItemStack output, boolean removeCurrent) {
		
		for(ItemStack stack : OreDictionary.getOres(input)) {
			if(BlastFurnaceRecipes.INSTANCE.getRecipe(stack) != null && removeCurrent) {
				BlastFurnaceRecipes.INSTANCE.removeRecipe(stack);
			}
			BlastFurnaceRecipes.INSTANCE.addRecipe(stack, output);
		}
	}
	
	protected static void addOreDictionaryComposterRecipe(String input, int rarity) {
		
		for(ItemStack stack : OreDictionary.getOres(input)) {
			ComposterBlock.ItemsForComposter.add(stack, rarity);
		}
	}

}
