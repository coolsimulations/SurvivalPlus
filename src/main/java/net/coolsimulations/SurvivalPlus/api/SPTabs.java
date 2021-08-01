package net.coolsimulations.SurvivalPlus.api;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SPTabs {
	
	public static final CreativeModeTab tabMaterials = (new CreativeModeTab(CreativeModeTab.TABS.length, "tabMaterials") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack makeIcon() {
	         return new ItemStack(SPItems.tin_ingot);
	      }
	   }).setRecipeFolderName("tabMaterials");
	public static final CreativeModeTab tabBlocks = (new CreativeModeTab(CreativeModeTab.TABS.length, "tabBlocks") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack makeIcon() {
	         return new ItemStack(SPBlocks.tin_block);
	      }
	   }).setRecipeFolderName("tabBlocks");
	public static final CreativeModeTab tabFood = (new CreativeModeTab(CreativeModeTab.TABS.length, "tabFood") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack makeIcon() {
	         return new ItemStack(SPItems.apple_pie);
	      }
	   }).setRecipeFolderName("tabFood");
	public static final CreativeModeTab tabGem = (new CreativeModeTab(CreativeModeTab.TABS.length, "tabGem") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack makeIcon() {
	         return new ItemStack(SPBlocks.sapphire_cluster);
	      }
	   }).setRecipeFolderName("tabGem");
	public static final CreativeModeTab tabCombat = (new CreativeModeTab(CreativeModeTab.TABS.length, "tabCombat") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack makeIcon() {
	         return new ItemStack(SPItems.titanium_sword);
	      }
	   }).setRecipeFolderName("tabCombat");
	public static final CreativeModeTab tabTools = (new CreativeModeTab(CreativeModeTab.TABS.length, "tabTools") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack makeIcon() {
	         return new ItemStack(SPItems.bronze_axe);
	      }
	   }).setRecipeFolderName("tabTools");

}
