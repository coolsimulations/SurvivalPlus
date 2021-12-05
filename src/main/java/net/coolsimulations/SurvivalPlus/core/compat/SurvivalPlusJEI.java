package net.coolsimulations.SurvivalPlus.core.compat;

import java.util.Collections;

import javax.annotation.Nonnull;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.insane96mcp.carbonado.init.ModItems;
import net.insane96mcp.carbonado.lib.Properties;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@JEIPlugin
public class SurvivalPlusJEI extends BlankModPlugin{
	
	public static void loadBlacklist(IIngredientBlacklist jeiHidden){
		
		jeiHidden.addIngredientToBlacklist(new ItemStack(SPBlocks.onion, 1, 0));
		
		if(SPCompatibilityManager.isNoTreePunchingLoaded())
			jeiHidden.addIngredientToBlacklist(new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.LUMBERJACK_MODID, "wood_lumberaxe"))));
		if(SPCompatibilityManager.isFutureMCLoaded())
			jeiHidden.addIngredientToBlacklist(new ItemStack(SPBlocks.campfire));
	}
	
	@Override
    public void register(@Nonnull IModRegistry registry)
    {
        SurvivalPlusJEI.loadBlacklist(registry.getJeiHelpers().getIngredientBlacklist());
        
        if(SPCompatibilityManager.isCarbonadoLoaded() && Properties.config.tools.enableAnvilCrafting) {
        	registry.addAnvilRecipe(new ItemStack(Items.DIAMOND_AXE), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 3)), Collections.singletonList(new ItemStack(ModItems.carbonadoAxeItem)));
        	registry.addAnvilRecipe(new ItemStack(Items.DIAMOND_SHOVEL), Collections.singletonList(new ItemStack(ModItems.carbonadoItem)), Collections.singletonList(new ItemStack(ModItems.carbonadoShovelItem)));
        	registry.addAnvilRecipe(new ItemStack(Items.DIAMOND_PICKAXE), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 3)), Collections.singletonList(new ItemStack(ModItems.carbonadoPickaxeItem)));
        	registry.addAnvilRecipe(new ItemStack(Items.DIAMOND_SWORD), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 2)), Collections.singletonList(new ItemStack(ModItems.carbonadoSwordItem)));
        	registry.addAnvilRecipe(new ItemStack(Items.DIAMOND_HOE), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 2)), Collections.singletonList(new ItemStack(ModItems.carbonadoHoeItem)));
        	registry.addAnvilRecipe(new ItemStack(Items.DIAMOND_HELMET), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 5)), Collections.singletonList(new ItemStack(ModItems.carbonadoHelmetItem)));
        	registry.addAnvilRecipe(new ItemStack(Items.DIAMOND_CHESTPLATE), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 8)), Collections.singletonList(new ItemStack(ModItems.carbonadoChestplateItem)));
        	registry.addAnvilRecipe(new ItemStack(Items.DIAMOND_LEGGINGS), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 7)), Collections.singletonList(new ItemStack(ModItems.carbonadoLeggingsItem)));
        	registry.addAnvilRecipe(new ItemStack(Items.DIAMOND_BOOTS), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 4)), Collections.singletonList(new ItemStack(ModItems.carbonadoBootsItem)));
        	if(SPCompatibilityManager.isLumberjackLoaded())
        		registry.addAnvilRecipe(new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.LUMBERJACK_MODID, "diamond_lumberaxe"))), Collections.singletonList(new ItemStack(ModItems.carbonadoItem, 4)), Collections.singletonList(new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.LUMBERJACK_MODID, "carbonado_lumberaxe")))));
        }
    }


}
