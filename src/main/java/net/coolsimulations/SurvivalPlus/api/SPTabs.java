package net.coolsimulations.SurvivalPlus.api;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SPTabs {
	
	public static final ItemGroup tabMaterials = (new ItemGroup(ItemGroup.TABS.length, "tabMaterials") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack makeIcon() {
	         return new ItemStack(SPItems.tin_ingot);
	      }
	   }).setRecipeFolderName("tabMaterials");
	public static final ItemGroup tabBlocks = (new ItemGroup(ItemGroup.TABS.length, "tabBlocks") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack makeIcon() {
	         return new ItemStack(SPBlocks.tin_block);
	      }
	   }).setRecipeFolderName("tabBlocks");
	public static final ItemGroup tabFood = (new ItemGroup(ItemGroup.TABS.length, "tabFood") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack makeIcon() {
	         return new ItemStack(SPItems.apple_pie);
	      }
	   }).setRecipeFolderName("tabFood");
	public static final ItemGroup tabGem = (new ItemGroup(ItemGroup.TABS.length, "tabGem") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack makeIcon() {
	         return new ItemStack(SPBlocks.amethyst);
	      }
	   }).setRecipeFolderName("tabGem");
	public static final ItemGroup tabCombat = (new ItemGroup(ItemGroup.TABS.length, "tabCombat") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack makeIcon() {
	         return new ItemStack(SPItems.titanium_sword);
	      }
	   }).setRecipeFolderName("tabCombat");
	public static final ItemGroup tabTools = (new ItemGroup(ItemGroup.TABS.length, "tabTools") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack makeIcon() {
	         return new ItemStack(SPItems.bronze_axe);
	      }
	   }).setRecipeFolderName("tabTools");

}
