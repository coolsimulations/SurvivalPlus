package net.coolsimulations.SurvivalPlus.core.recipes;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class SurvivalPlusShapelessRecipes {

	public static void register() {
		
	addShapelessOreRecipe(new ItemStack(SPItems.copper_ingot, 9), "blockCopper");
	addShapelessOreRecipe(new ItemStack(SPItems.tin_ingot, 9), "blockTin");
	addShapelessOreRecipe(new ItemStack(SPItems.bronze_ingot, 9), "blockBronze");
	addShapelessOreRecipe(new ItemStack(SPItems.titanium_ingot, 9), "blockTitanium");
	GameRegistry.addShapelessRecipe(new ItemStack(Items.COAL, 3, 1), new ItemStack(SPItems.charcoal_bucket.setContainerItem(Items.BUCKET)));
	GameRegistry.addShapelessRecipe(new ItemStack(SPItems.charcoal_bucket), new ItemStack(Items.BUCKET), new ItemStack(Items.COAL, 1, 1), new ItemStack(Items.COAL, 1, 1), new ItemStack(Items.COAL, 1, 1));
	addShapelessOreRecipe(new ItemStack(SPItems.cupcake, 7), "cupPaper", "cupPaper", "cupPaper", "cupPaper", "cupPaper", "cupPaper", "cupPaper", new ItemStack(Items.CAKE));
	addShapelessOreRecipe(new ItemStack(SPItems.white_dye, 2), "cropOnion");
	
	addShapelessOreRecipe(new ItemStack(SPItems.bronze_nugget, 9), new Object[] {"ingotBronze"});
	addShapelessOreRecipe(new ItemStack(SPItems.titanium_nugget, 9), new Object[] {"ingotTitanium"});
	addShapelessOreRecipe(new ItemStack(SPItems.onion_soup), new ItemStack(Items.BOWL), "cropOnion", "cropOnion");
	addShapelessOreRecipe(new ItemStack(SPItems.apple_pie), "foodApplebaked", "egg", new ItemStack(Items.SUGAR));
	addShapelessOreRecipe(new ItemStack(SPItems.beef_pie), new ItemStack(Items.COOKED_BEEF), "egg", new ItemStack(Items.SUGAR));
	addShapelessOreRecipe(new ItemStack(SPItems.pork_pie), new ItemStack(Items.COOKED_PORKCHOP), "egg", new ItemStack(Items.SUGAR));
	addShapelessOreRecipe(new ItemStack(SPItems.chicken_pie), new ItemStack(Items.COOKED_CHICKEN), "egg", new ItemStack(Items.SUGAR));
	addShapelessOreRecipe(new ItemStack(SPItems.mutton_pie), new ItemStack(Items.COOKED_MUTTON), "egg", new ItemStack(Items.SUGAR));
	addShapelessOreRecipe(new ItemStack(SPItems.rabbit_pie), new ItemStack(Items.COOKED_RABBIT), "egg", new ItemStack(Items.SUGAR));
	addShapelessOreRecipe(new ItemStack(SPItems.vegetable_pie), new ItemStack(Items.BEETROOT), "cropCarrot", "cropOnion", "egg", new ItemStack(Items.SUGAR));
	addShapelessOreRecipe(new ItemStack(SPItems.cheese_cupcake, 7), "cupPaper", "cupPaper", "cupPaper", "cupPaper", "cupPaper", "cupPaper", "cupPaper", "foodCheesecake");
	addShapelessOreRecipe(new ItemStack(SPItems.sponge_cupcake, 8), "cupPaper", "cupPaper", "cupPaper", "cupPaper", "cupPaper", "cupPaper", "cupPaper", "cupPaper", "foodSpongecake");
	addShapelessOreRecipe(new ItemStack(SPItems.cheese_bread), new Object[] {Items.BREAD, "foodCheese"});

	}
	
	public static void addShapelessOreRecipe(ItemStack result, Object... recipe)
	{
	  CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(result, recipe));
	}
	  
}
