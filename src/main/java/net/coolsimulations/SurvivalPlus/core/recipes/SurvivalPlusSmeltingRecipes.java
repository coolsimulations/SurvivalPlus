package net.coolsimulations.SurvivalPlus.core.recipes;

import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SurvivalPlusSmeltingRecipes {
	
	public static void register() {
		
	GameRegistry.addSmelting(SPBlocks.copper_ore, new ItemStack(SPItems.copper_ingot), 0.7F);
    GameRegistry.addSmelting(SPBlocks.tin_ore, new ItemStack(SPItems.tin_ingot), 0.7F);
    GameRegistry.addSmelting(SPBlocks.titanium_ore, new ItemStack(SPItems.titanium_ingot), 1.0F);
	GameRegistry.addSmelting(Items.EGG, new ItemStack(SPItems.fried_egg), 0.35F);
	GameRegistry.addSmelting(Items.CARROT, new ItemStack(SPItems.roast_carrot), 0.35F);
	GameRegistry.addSmelting(SPItems.cheese_bread, new ItemStack(SPItems.melted_cheese_bread), 0.4F);
	GameRegistry.addSmelting(Items.APPLE, new ItemStack(SPItems.baked_apple), 0.35F);
	GameRegistry.addSmelting(SPItems.raw_onion, new ItemStack(SPItems.fried_onion), 0.35F);
	GameRegistry.addSmelting(SPItems.bronze_axe, new ItemStack(SPItems.bronze_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.bronze_hoe, new ItemStack(SPItems.bronze_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.bronze_pickaxe, new ItemStack(SPItems.bronze_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.bronze_shears, new ItemStack(SPItems.bronze_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.bronze_shovel, new ItemStack(SPItems.bronze_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.bronze_sword, new ItemStack(SPItems.bronze_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.bronze_helmet, new ItemStack(SPItems.bronze_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.bronze_chestplate, new ItemStack(SPItems.bronze_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.bronze_leggings, new ItemStack(SPItems.bronze_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.bronze_boots, new ItemStack(SPItems.bronze_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.titanium_axe, new ItemStack(SPItems.titanium_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.titanium_hoe, new ItemStack(SPItems.titanium_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.titanium_pickaxe, new ItemStack(SPItems.titanium_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.titanium_shears, new ItemStack(SPItems.titanium_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.titanium_shovel, new ItemStack(SPItems.titanium_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.titanium_sword, new ItemStack(SPItems.titanium_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.titanium_helmet, new ItemStack(SPItems.titanium_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.titanium_chestplate, new ItemStack(SPItems.titanium_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.titanium_leggings, new ItemStack(SPItems.titanium_nugget), 0.1F);
	GameRegistry.addSmelting(SPItems.titanium_boots, new ItemStack(SPItems.titanium_nugget), 0.1F);

	}

}
