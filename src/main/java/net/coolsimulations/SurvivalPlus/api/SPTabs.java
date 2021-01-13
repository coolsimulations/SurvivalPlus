package net.coolsimulations.SurvivalPlus.api;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class SPTabs {
	
	public static final ItemGroup tabMaterials = FabricItemGroupBuilder.build(new Identifier(SPReference.MOD_ID, "tabmaterials"),  
			() -> new ItemStack(SPItems.tin_ingot));
	public static final ItemGroup tabBlocks = FabricItemGroupBuilder.build(new Identifier(SPReference.MOD_ID, "tabblocks"),  
			() -> new ItemStack(SPBlocks.tin_block));
	public static final ItemGroup tabFood = FabricItemGroupBuilder.build(new Identifier(SPReference.MOD_ID, "tabfood"),  
			() -> new ItemStack(SPItems.apple_pie));
	public static final ItemGroup tabGem = FabricItemGroupBuilder.build(new Identifier(SPReference.MOD_ID, "tabgem"),  
			() -> new ItemStack(SPBlocks.amethyst));
	public static final ItemGroup tabCombat = FabricItemGroupBuilder.build(new Identifier(SPReference.MOD_ID, "tabcombat"),  
			() -> new ItemStack(SPItems.titanium_sword));
	public static final ItemGroup tabTools = FabricItemGroupBuilder.build(new Identifier(SPReference.MOD_ID, "tabtools"),  
			() -> new ItemStack(SPItems.bronze_axe));
}
