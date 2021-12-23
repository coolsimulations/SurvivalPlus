package net.coolsimulations.SurvivalPlus.core.compat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.annotation.Nonnull;

import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.plugins.vanilla.anvil.AnvilRecipeWrapper;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.insane96mcp.carbonado.init.ModItems;
import net.insane96mcp.carbonado.lib.Properties;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class SurvivalPlusCardbonado {
	
	public static void initJEI(@Nonnull IModRegistry registry) {
		
		if(Properties.config.tools.enableAnvilCrafting) {
			
			Collection<AnvilRecipeWrapper> anvilRecipes = new ArrayList<AnvilRecipeWrapper>();
			
			anvilRecipes.add(new AnvilRecipeWrapper(Collections.singletonList(new ItemStack(Items.DIAMOND_AXE)), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 3)), Collections.singletonList(new ItemStack(ModItems.carbonadoAxeItem))));
        	anvilRecipes.add(new AnvilRecipeWrapper(Collections.singletonList(new ItemStack(Items.DIAMOND_SHOVEL)), Collections.singletonList(new ItemStack(ModItems.carbonadoItem)), Collections.singletonList(new ItemStack(ModItems.carbonadoShovelItem))));
        	anvilRecipes.add(new AnvilRecipeWrapper(Collections.singletonList(new ItemStack(Items.DIAMOND_PICKAXE)), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 3)), Collections.singletonList(new ItemStack(ModItems.carbonadoPickaxeItem))));
        	anvilRecipes.add(new AnvilRecipeWrapper(Collections.singletonList(new ItemStack(Items.DIAMOND_SWORD)), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 2)), Collections.singletonList(new ItemStack(ModItems.carbonadoSwordItem))));
        	anvilRecipes.add(new AnvilRecipeWrapper(Collections.singletonList(new ItemStack(Items.DIAMOND_HOE)), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 2)), Collections.singletonList(new ItemStack(ModItems.carbonadoHoeItem))));
        	anvilRecipes.add(new AnvilRecipeWrapper(Collections.singletonList(new ItemStack(Items.DIAMOND_HELMET)), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 5)), Collections.singletonList(new ItemStack(ModItems.carbonadoHelmetItem))));
        	anvilRecipes.add(new AnvilRecipeWrapper(Collections.singletonList(new ItemStack(Items.DIAMOND_CHESTPLATE)), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 8)), Collections.singletonList(new ItemStack(ModItems.carbonadoChestplateItem))));
        	anvilRecipes.add(new AnvilRecipeWrapper(Collections.singletonList(new ItemStack(Items.DIAMOND_LEGGINGS)), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 7)), Collections.singletonList(new ItemStack(ModItems.carbonadoLeggingsItem))));
        	anvilRecipes.add(new AnvilRecipeWrapper(Collections.singletonList(new ItemStack(Items.DIAMOND_BOOTS)), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 4)), Collections.singletonList(new ItemStack(ModItems.carbonadoBootsItem))));
        	if(SPCompatibilityManager.isLumberjackLoaded())
        		anvilRecipes.add(new AnvilRecipeWrapper(Collections.singletonList(new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.LUMBERJACK_MODID, "diamond_lumberaxe")))), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 4)), Collections.singletonList(new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.LUMBERJACK_MODID, "carbonado_lumberaxe"))))));
        	
        	registry.addRecipes(anvilRecipes, VanillaRecipeCategoryUid.ANVIL);
        }
	}

}
