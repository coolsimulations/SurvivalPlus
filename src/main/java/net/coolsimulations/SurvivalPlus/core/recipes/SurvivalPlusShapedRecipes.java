package net.coolsimulations.SurvivalPlus.core.recipes;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.polegamers.flourpower.config.ConfigHandler;

public class SurvivalPlusShapedRecipes {
	
	
	public static void register() {
		
	addRecipe(new ItemStack(SPBlocks.tin_block), new Object[]{"TTT","TTT","TTT", 'T', "ingotTin"});
	addRecipe(new ItemStack(SPBlocks.copper_block), new Object[]{"CCC","CCC","CCC", 'C', "ingotCopper"});
	addRecipe(new ItemStack(SPBlocks.bronze_block), new Object[]{"BBB","BBB","BBB", 'B', "ingotBronze"});
	addRecipe(new ItemStack(SPBlocks.titanium_block), new Object[]{"TTT","TTT","TTT", 'T', "ingotTitanium"});
	GameRegistry.addRecipe(new ItemStack(SPItems.cheese, 6), new Object[]{"MMM", 'M', Items.MILK_BUCKET});
	
<<<<<<< HEAD
	addRecipe(new ItemStack(SPBlocks.campfire), new Object[]{"S S","WWW","   ", 'S', "stickWood", 'W', "logWood"});
	addRecipe(new ItemStack(SPBlocks.campfire), new Object[]{"   ","S S","WWW", 'S', "stickWood", 'W', "logWood"});
=======
	addRecipe(new ItemStack(SPBlocks.campfire), new Object[]{"S S","WWW", 'S', "stickWood", 'W', "logWood"});
>>>>>>> 56bd8bad81f789036d017e9d4785df60c82bf9ee
	addRecipe(new ItemStack(SPItems.paper_cup, 7), new Object[]{"P P"," P ", 'P', "paper"});
	addRecipe(new ItemStack(SPItems.bronze_ingot), new Object[]{"BBB","BBB", "BBB", 'B', "nuggetBronze"});
	addRecipe(new ItemStack(SPItems.titanium_ingot), new Object[]{"BBB","BBB", "BBB", 'B', "nuggetTitanium"});
	
	addRecipe(new ItemStack(SPBlocks.cardboard, 8), new Object[]{"SSS","S S","SSS", 'S', "stickWood"});
	addRecipe(new ItemStack(SPBlocks.cardboard_white, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyeWhite"});
	addRecipe(new ItemStack(SPBlocks.cardboard_light_grey, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyeLightGray"});
	addRecipe(new ItemStack(SPBlocks.cardboard_grey, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyeGray"});
	addRecipe(new ItemStack(SPBlocks.cardboard_black, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyeBlack"});
	addRecipe(new ItemStack(SPBlocks.cardboard_red, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyeRed"});
	addRecipe(new ItemStack(SPBlocks.cardboard_orange, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyeOrange"});
	addRecipe(new ItemStack(SPBlocks.cardboard_yellow, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyeYellow"});
	addRecipe(new ItemStack(SPBlocks.cardboard_lime, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyeLime"});
	addRecipe(new ItemStack(SPBlocks.cardboard_green, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyeGreen"});
	addRecipe(new ItemStack(SPBlocks.cardboard_light_blue, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyeLightBlue"});
	addRecipe(new ItemStack(SPBlocks.cardboard_cyan, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyeCyan"});
	addRecipe(new ItemStack(SPBlocks.cardboard_blue, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyeBlue"});
	addRecipe(new ItemStack(SPBlocks.cardboard_purple, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyePurple"});
	addRecipe(new ItemStack(SPBlocks.cardboard_magenta, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyeMagenta"});
	addRecipe(new ItemStack(SPBlocks.cardboard_pink, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyePink"});
	addRecipe(new ItemStack(SPBlocks.cardboard_brown, 8), new Object[]{"SSS","SBS","SSS", 'S', "stickWood", 'B', "dyeBrown"});
	addRecipe(new ItemStack(SPBlocks.cardboard_white, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyeWhite"});
	addRecipe(new ItemStack(SPBlocks.cardboard_light_grey, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyeLightGray"});
	addRecipe(new ItemStack(SPBlocks.cardboard_grey, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyeGray"});
	addRecipe(new ItemStack(SPBlocks.cardboard_black, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyeBlack"});
	addRecipe(new ItemStack(SPBlocks.cardboard_red, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyeRed"});
	addRecipe(new ItemStack(SPBlocks.cardboard_orange, 8), new Object[]{"SSS","SBS","SSS", 'S',"blockCardboard", 'B', "dyeOrange"});
	addRecipe(new ItemStack(SPBlocks.cardboard_yellow, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyeYellow"});
	addRecipe(new ItemStack(SPBlocks.cardboard_lime, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyeLime"});
	addRecipe(new ItemStack(SPBlocks.cardboard_green, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyeGreen"});
	addRecipe(new ItemStack(SPBlocks.cardboard_light_blue, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyeLightBlue"});
	addRecipe(new ItemStack(SPBlocks.cardboard_cyan, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyeCyan"});
	addRecipe(new ItemStack(SPBlocks.cardboard_blue, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyeBlue"});
	addRecipe(new ItemStack(SPBlocks.cardboard_purple, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyePurple"});
	addRecipe(new ItemStack(SPBlocks.cardboard_magenta, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyeMagenta"});
	addRecipe(new ItemStack(SPBlocks.cardboard_pink, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyePink"});
	addRecipe(new ItemStack(SPBlocks.cardboard_brown, 8), new Object[]{"SSS","SBS","SSS", 'S', "blockCardboard", 'B', "dyeBrown"});
	
	addRecipe(new ItemStack(SPItems.stone_helmet), new Object[]{"BBB","B B", 'B', "stone"});
	addRecipe(new ItemStack(SPItems.stone_chestplate), new Object[]{"B B","BBB","BBB", 'B', "stone"});
	addRecipe(new ItemStack(SPItems.stone_leggings), new Object[]{"BBB","B B","B B", 'B', "stone"});
	addRecipe(new ItemStack(SPItems.stone_boots), new Object[]{"B B","B B", 'B', "stone"});
	
	addRecipe(new ItemStack(SPItems.titanium_helmet), new Object[]{"BBB","B B", 'B', "ingotTitanium"});
	addRecipe(new ItemStack(SPItems.titanium_chestplate), new Object[]{"B B","BBB","BBB", 'B', "ingotTitanium"});
	addRecipe(new ItemStack(SPItems.titanium_leggings), new Object[]{"BBB","B B","B B", 'B', "ingotTitanium"});
	addRecipe(new ItemStack(SPItems.titanium_boots), new Object[]{"B B","B B", 'B', "ingotTitanium"});
	
	addRecipe(new ItemStack(SPItems.titanium_pickaxe), new Object[]{"BBB"," S "," S ", 'B', "ingotTitanium", 'S', "stickWood"});
	addRecipe(new ItemStack(SPItems.titanium_axe), new Object[]{"BB","BS"," S", 'B', "ingotTitanium", 'S', "stickWood"});
	addRecipe(new ItemStack(SPItems.titanium_axe), new Object[]{"BB","SB","S ", 'B', "ingotTitanium", 'S', "stickWood"});
	addRecipe(new ItemStack(SPItems.titanium_shovel), new Object[]{"B","S","S", 'B', "ingotTitanium", 'S', "stickWood"});
	addRecipe(new ItemStack(SPItems.titanium_hoe), new Object[]{"BB"," S"," S", 'B', "ingotTitanium", 'S', "stickWood"});
	addRecipe(new ItemStack(SPItems.titanium_hoe), new Object[]{"BB","S ","S ", 'B', "ingotTitanium", 'S', "stickWood"});
	addRecipe(new ItemStack(SPItems.titanium_sword), new Object[]{"B","B","S", 'B', "ingotTitanium", 'S', "stickWood"});
	addRecipe(new ItemStack(SPItems.titanium_shears), new Object[]{" B","B ", 'B', "ingotTitanium"});

	addRecipe(new ItemStack(SPItems.bronze_pickaxe), new Object[]{"BBB"," S "," S ", 'B', "ingotBronze", 'S', "stickWood"});
	addRecipe(new ItemStack(SPItems.bronze_axe), new Object[]{"BB","BS"," S", 'B', "ingotBronze", 'S', "stickWood"});
	addRecipe(new ItemStack(SPItems.bronze_axe), new Object[]{"BB","SB","S ", 'B', "ingotBronze", 'S', "stickWood"});
	addRecipe(new ItemStack(SPItems.bronze_shovel), new Object[]{"B","S","S", 'B', "ingotBronze", 'S', "stickWood"});
	addRecipe(new ItemStack(SPItems.bronze_hoe), new Object[]{"BB"," S"," S", 'B', "ingotBronze", 'S', "stickWood"});
	addRecipe(new ItemStack(SPItems.bronze_hoe), new Object[]{"BB","S ","S ", 'B', "ingotBronze", 'S', "stickWood"});
	addRecipe(new ItemStack(SPItems.bronze_sword), new Object[]{"B","B","S", 'B', "ingotBronze", 'S', "stickWood"});
	addRecipe(new ItemStack(SPItems.bronze_shears), new Object[]{" B","B ", 'B', "ingotBronze"});
	
	addRecipe(new ItemStack(SPItems.bronze_helmet), new Object[]{"BBB","B B", 'B', "ingotBronze"});
	addRecipe(new ItemStack(SPItems.bronze_chestplate), new Object[]{"B B","BBB","BBB", 'B', "ingotBronze"});
	addRecipe(new ItemStack(SPItems.bronze_leggings), new Object[]{"BBB","B B","B B", 'B', "ingotBronze"});
	addRecipe(new ItemStack(SPItems.bronze_boots), new Object[]{"B B","B B", 'B', "ingotBronze"});
	addRecipe(new ItemStack(SPItems.bronze_shears), new Object[]{" B","B ", 'B', "ingotBronze"});
	
	GameRegistry.addRecipe(new ItemStack(SPItems.oak_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(Blocks.LOG, 1, 0)});
	GameRegistry.addRecipe(new ItemStack(SPItems.oak_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(Blocks.LOG, 1, 0)});
	GameRegistry.addRecipe(new ItemStack(SPItems.oak_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(Blocks.LOG, 1, 0)});
	GameRegistry.addRecipe(new ItemStack(SPItems.oak_boots), new Object[]{"B B","B B", 'B', new ItemStack(Blocks.LOG, 1, 0)});
	
	GameRegistry.addRecipe(new ItemStack(SPItems.spruce_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(Blocks.LOG, 1, 1)});
	GameRegistry.addRecipe(new ItemStack(SPItems.spruce_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(Blocks.LOG, 1, 1)});
	GameRegistry.addRecipe(new ItemStack(SPItems.spruce_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(Blocks.LOG, 1, 1)});
	GameRegistry.addRecipe(new ItemStack(SPItems.spruce_boots), new Object[]{"B B","B B", 'B', new ItemStack(Blocks.LOG, 1, 1)});
	
	GameRegistry.addRecipe(new ItemStack(SPItems.birch_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(Blocks.LOG, 1, 2)});
	GameRegistry.addRecipe(new ItemStack(SPItems.birch_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(Blocks.LOG, 1, 2)});
	GameRegistry.addRecipe(new ItemStack(SPItems.birch_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(Blocks.LOG, 1, 2)});
	GameRegistry.addRecipe(new ItemStack(SPItems.birch_boots), new Object[]{"B B","B B", 'B', new ItemStack(Blocks.LOG, 1, 2)});
	
	GameRegistry.addRecipe(new ItemStack(SPItems.jungle_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(Blocks.LOG, 1, 3)});
	GameRegistry.addRecipe(new ItemStack(SPItems.jungle_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(Blocks.LOG, 1, 3)});
	GameRegistry.addRecipe(new ItemStack(SPItems.jungle_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(Blocks.LOG, 1, 3)});
	GameRegistry.addRecipe(new ItemStack(SPItems.jungle_boots), new Object[]{"B B","B B", 'B', new ItemStack(Blocks.LOG, 1, 3)});
	
	GameRegistry.addRecipe(new ItemStack(SPItems.acacia_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(Blocks.LOG2, 1, 0)});
	GameRegistry.addRecipe(new ItemStack(SPItems.acacia_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(Blocks.LOG2, 1, 0)});
	GameRegistry.addRecipe(new ItemStack(SPItems.acacia_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(Blocks.LOG2, 1, 0)});
	GameRegistry.addRecipe(new ItemStack(SPItems.acacia_boots), new Object[]{"B B","B B", 'B', new ItemStack(Blocks.LOG2, 1, 0)});
		
	GameRegistry.addRecipe(new ItemStack(SPItems.dark_oak_helmet), new Object[]{"BBB","B B", 'B', new ItemStack(Blocks.LOG2, 1, 1)});
	GameRegistry.addRecipe(new ItemStack(SPItems.dark_oak_chestplate), new Object[]{"B B","BBB","BBB", 'B', new ItemStack(Blocks.LOG2, 1, 1)});
	GameRegistry.addRecipe(new ItemStack(SPItems.dark_oak_leggings), new Object[]{"BBB","B B","B B", 'B', new ItemStack(Blocks.LOG2, 1, 1)});
	GameRegistry.addRecipe(new ItemStack(SPItems.dark_oak_boots), new Object[]{"B B","B B", 'B', new ItemStack(Blocks.LOG2, 1, 1)});
	
	if (OreDictionary.getOres("woodRubber").size() > 0) {
		
		RubberCampfireRecipes();
		addRecipe(new ItemStack(SPItems.rubber_helmet), new Object[]{"BBB","B B", 'B', "woodRubber"});
		addRecipe(new ItemStack(SPItems.rubber_chestplate), new Object[]{"B B","BBB","BBB", 'B', "woodRubber"});
		addRecipe(new ItemStack(SPItems.rubber_leggings), new Object[]{"BBB","B B","B B", 'B', "woodRubber"});
		addRecipe(new ItemStack(SPItems.rubber_boots), new Object[]{"B B","B B", 'B', "woodRubber"});
	}
	
	if(SPConfig.enableSponge) {
		
		addRecipe(new ItemStack(Blocks.SPONGE), new Object[]{"CWC","WGW","CWC", 'G', "ingotGold", 'C', "foodCheese", 'W', new ItemStack(Blocks.WOOL, 1, 4)});
	}
	
	if(SPCompatibilityManager.isGCLoaded() && SPConfig.enableCheeseBlock) {
		
		addRecipe(new ItemStack(GCBlocks.cheeseBlock), new Object[]{"CCC","CMC","CCC", 'M', Items.MILK_BUCKET, 'C', "foodCheese"});
	}
	
	if(SPCompatibilityManager.isFlourPowerLoaded() && ConfigHandler.enableCakeRecipe) {
		
		addRecipe(new ItemStack(SPBlocks.sponge_cake), new Object[]{"PMP","SES","FFF", 'M', Items.MILK_BUCKET, 'P', Blocks.SPONGE, 'S', Items.SUGAR, 'E', "egg", 'F', "flour"});
		addRecipe(new ItemStack(SPBlocks.cheese_cake), new Object[]{"CMC","SES","FFF", 'M', Items.MILK_BUCKET, 'C', "foodCheese", 'S', Items.SUGAR, 'E', "egg", 'F', "flour"});
		
	}else {
		
		addRecipe(new ItemStack(SPBlocks.sponge_cake), new Object[]{"PMP","SES","WWW", 'M', Items.MILK_BUCKET, 'P', Blocks.SPONGE, 'S', Items.SUGAR, 'E', "egg", 'W', "cropWheat"});
		addRecipe(new ItemStack(SPBlocks.cheese_cake), new Object[]{"CMC","SES","WWW", 'M', Items.MILK_BUCKET, 'C', "foodCheese", 'S', Items.SUGAR, 'E', "egg", 'W', "cropWheat"});
	}
	
	}
	
	
	public static void RubberCampfireRecipes() {
		
		addRecipe(new ItemStack(SPBlocks.campfire), new Object[]{"S S","RRR", 'S', "stickWood", 'R', "woodRubber"});
		addRecipe(new ItemStack(SPBlocks.campfire), new Object[]{"S S","WRR", 'S', "stickWood", 'R', "woodRubber", 'W', "logWood"});
		addRecipe(new ItemStack(SPBlocks.campfire), new Object[]{"S S","RWR", 'S', "stickWood", 'R', "woodRubber", 'W', "logWood"});
		addRecipe(new ItemStack(SPBlocks.campfire), new Object[]{"S S","RRW", 'S', "stickWood", 'R', "woodRubber", 'W', "logWood"});
		addRecipe(new ItemStack(SPBlocks.campfire), new Object[]{"S S","WRW", 'S', "stickWood", 'R', "woodRubber", 'W', "logWood"});
		addRecipe(new ItemStack(SPBlocks.campfire), new Object[]{"S S","WWR", 'S', "stickWood", 'R', "woodRubber", 'W', "logWood"});
		addRecipe(new ItemStack(SPBlocks.campfire), new Object[]{"S S","RWW", 'S', "stickWood", 'R', "woodRubber", 'W', "logWood"});
		
	}
	
    @SuppressWarnings("unchecked")
    public static void addRecipe(ItemStack result, Object[] obj)
    {
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(result, obj));
    }

}
