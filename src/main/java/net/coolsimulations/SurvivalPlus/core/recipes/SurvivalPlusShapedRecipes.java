package net.coolsimulations.SurvivalPlus.core.recipes;

import biomesoplenty.api.block.BOPBlocks;

import com.polegamers.flourpower.config.ConfigHandler;
import com.polegamers.flourpower.item.ItemFlourPower;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class SurvivalPlusShapedRecipes {
	
	
	public static void register() {
		
	addRecipe(new ItemStack(SPBlocks.tin_block), new Object[]{"TTT","TTT","TTT", 'T', "ingotTin"});
	addRecipe(new ItemStack(SPBlocks.copper_block), new Object[]{"CCC","CCC","CCC", 'C', "ingotCopper"});
	addRecipe(new ItemStack(SPBlocks.bronze_block), new Object[]{"BBB","BBB","BBB", 'B', "ingotBronze"});
	addRecipe(new ItemStack(SPBlocks.titanium_block), new Object[]{"TTT","TTT","TTT", 'T', "ingotTitanium"});
	GameRegistry.addRecipe(new ItemStack(SPItems.cheese, 6), new Object[]{"MMM", 'M', Items.MILK_BUCKET});
	
	addRecipe(new ItemStack(SPBlocks.campfire), new Object[]{"S S","WWW", 'S', "stickWood", 'W', "logWood"});
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
	addRecipe(new ItemStack(SPBlocks.cardboard_white, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyeWhite"});
	addRecipe(new ItemStack(SPBlocks.cardboard_light_grey, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyeLightGray"});
	addRecipe(new ItemStack(SPBlocks.cardboard_grey, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyeGray"});
	addRecipe(new ItemStack(SPBlocks.cardboard_black, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyeBlack"});
	addRecipe(new ItemStack(SPBlocks.cardboard_red, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyeRed"});
	addRecipe(new ItemStack(SPBlocks.cardboard_orange, 8), new Object[]{"SSS","SBS","SSS", 'S',SPBlocks.cardboard, 'B', "dyeOrange"});
	addRecipe(new ItemStack(SPBlocks.cardboard_yellow, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyeYellow"});
	addRecipe(new ItemStack(SPBlocks.cardboard_lime, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyeLime"});
	addRecipe(new ItemStack(SPBlocks.cardboard_green, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyeGreen"});
	addRecipe(new ItemStack(SPBlocks.cardboard_light_blue, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyeLightBlue"});
	addRecipe(new ItemStack(SPBlocks.cardboard_cyan, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyeCyan"});
	addRecipe(new ItemStack(SPBlocks.cardboard_blue, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyeBlue"});
	addRecipe(new ItemStack(SPBlocks.cardboard_purple, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyePurple"});
	addRecipe(new ItemStack(SPBlocks.cardboard_magenta, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyeMagenta"});
	addRecipe(new ItemStack(SPBlocks.cardboard_pink, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyePink"});
	addRecipe(new ItemStack(SPBlocks.cardboard_brown, 8), new Object[]{"SSS","SBS","SSS", 'S', SPBlocks.cardboard, 'B', "dyeBrown"});
	
	addArmorRecipe(SPItems.stone, "stone");
	
	addArmorRecipe(SPItems.titanium, "ingotTitanium");
	
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
	
	addArmorRecipe(SPItems.bronze, "ingotBronze");
	addRecipe(new ItemStack(SPItems.bronze_shears), new Object[]{" B","B ", 'B', "ingotBronze"});
	
	addArmorRecipe(SPItems.oak, new ItemStack(Blocks.LOG, 1, 0));
	addArmorRecipe(SPItems.spruce, new ItemStack(Blocks.LOG, 1, 1));
	addArmorRecipe(SPItems.birch, new ItemStack(Blocks.LOG, 1, 2));
	addArmorRecipe(SPItems.jungle, new ItemStack(Blocks.LOG, 1, 3));
	addArmorRecipe(SPItems.acacia, new ItemStack(Blocks.LOG2, 1, 0));
	addArmorRecipe(SPItems.dark_oak, new ItemStack(Blocks.LOG2, 1, 1));
	
	if (OreDictionary.getOres("woodRubber").size() > 0) {
		
		RubberCampfireRecipes();
		addArmorRecipe(SPItems.rubber, "woodRubber");
	}
	
	if (OreDictionary.getOres("nuggetCopper").size() > 0) {
		
		addRecipe(new ItemStack(SPItems.copper_ingot), new Object[]{"BBB","BBB", "BBB", 'B', "nuggetCopper"});
	}
	
	if (OreDictionary.getOres("nuggetTin").size() > 0) {
		
		addRecipe(new ItemStack(SPItems.tin_ingot), new Object[]{"BBB","BBB", "BBB", 'B', "nuggetTin"});
	}
	
	if(SPConfig.enableSponge) {
		
		addRecipe(new ItemStack(Blocks.SPONGE), new Object[]{"CWC","WGW","CWC", 'G', "nuggetGold", 'C', "foodCheese", 'W', new ItemStack(Blocks.WOOL, 1, 4)});
	}
	
	if(SPCompatibilityManager.isFlourPowerLoaded() && ConfigHandler.enableCakeRecipe) {
		
		addRecipe(new ItemStack(SPBlocks.sponge_cake), new Object[]{"PMP","SES","FFF", 'M', Items.MILK_BUCKET, 'P', Blocks.SPONGE, 'S', Items.SUGAR, 'E', "egg", 'F', new ItemStack(ItemFlourPower.itemFlour)});
		addRecipe(new ItemStack(SPBlocks.cheese_cake), new Object[]{"CMC","SES","FFF", 'M', Items.MILK_BUCKET, 'C', "foodCheese", 'S', Items.SUGAR, 'E', "egg", 'F', new ItemStack(ItemFlourPower.itemFlour)});
		
	}
	
	addRecipe(new ItemStack(SPBlocks.sponge_cake), new Object[]{"PMP","SES","WWW", 'M', Items.MILK_BUCKET, 'P', Blocks.SPONGE, 'S', Items.SUGAR, 'E', "egg", 'W', "cropWheat"});
	addRecipe(new ItemStack(SPBlocks.cheese_cake), new Object[]{"CMC","SES","WWW", 'M', Items.MILK_BUCKET, 'C', "foodCheese", 'S', Items.SUGAR, 'E', "egg", 'W', "cropWheat"});
	
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
	
	public static void addArmorRecipe(NonNullList<ItemStack> result, ItemStack material)
    {
    	GameRegistry.addRecipe(result.get(0), new Object[]{"BBB","B B", 'B', material});
		GameRegistry.addRecipe(result.get(1), new Object[]{"B B","BBB","BBB", 'B', material});
		GameRegistry.addRecipe(result.get(2), new Object[]{"BBB","B B","B B", 'B', material});
		GameRegistry.addRecipe(result.get(3), new Object[]{"B B","B B", 'B', material});
    }
	
	public static void addArmorRecipe(NonNullList<ItemStack> result, String material)
    {
    	addRecipe(result.get(0), new Object[]{"BBB","B B", 'B', material});
		addRecipe(result.get(1), new Object[]{"B B","BBB","BBB", 'B', material});
		addRecipe(result.get(2), new Object[]{"BBB","B B","B B", 'B', material});
		addRecipe(result.get(3), new Object[]{"B B","B B", 'B', material});
    }
	
    @SuppressWarnings("unchecked")
    public static void addRecipe(ItemStack result, Object[] obj)
    {
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(result, obj));
    }

}
