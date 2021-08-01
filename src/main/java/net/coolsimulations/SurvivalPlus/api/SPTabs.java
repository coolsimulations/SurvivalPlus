package net.coolsimulations.SurvivalPlus.api;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class SPTabs {
	
	public static final CreativeModeTab tabMaterials = FabricItemGroupBuilder.build(new ResourceLocation(SPReference.MOD_ID, "tabmaterials"),  
			() -> new ItemStack(SPItems.tin_ingot));
	public static final CreativeModeTab tabBlocks = FabricItemGroupBuilder.build(new ResourceLocation(SPReference.MOD_ID, "tabblocks"),  
			() -> new ItemStack(SPBlocks.tin_block));
	public static final CreativeModeTab tabFood = FabricItemGroupBuilder.build(new ResourceLocation(SPReference.MOD_ID, "tabfood"),  
			() -> new ItemStack(SPItems.apple_pie));
	public static final CreativeModeTab tabGem = FabricItemGroupBuilder.build(new ResourceLocation(SPReference.MOD_ID, "tabgem"),  
			() -> new ItemStack(SPBlocks.sapphire_cluster));
	public static final CreativeModeTab tabCombat = FabricItemGroupBuilder.build(new ResourceLocation(SPReference.MOD_ID, "tabcombat"),  
			() -> new ItemStack(SPItems.titanium_sword));
	public static final CreativeModeTab tabTools = FabricItemGroupBuilder.build(new ResourceLocation(SPReference.MOD_ID, "tabtools"),  
			() -> new ItemStack(SPItems.bronze_axe));
}
