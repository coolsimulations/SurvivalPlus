package net.coolsimulations.SurvivalPlus.api;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SPTabs {
	
	public static final ItemGroup tabMaterials = (new ItemGroup(ItemGroup.GROUPS.length, "tabMaterials") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack createIcon() {
	         return new ItemStack(SPItems.tin_ingot);
	      }
	   }).func_199783_b("tabMaterials");
	public static final ItemGroup tabBlocks = (new ItemGroup(ItemGroup.GROUPS.length, "tabBlocks") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack createIcon() {
	         return new ItemStack(SPBlocks.tin_block);
	      }
	   }).func_199783_b("tabBlocks");
	public static final ItemGroup tabFood = (new ItemGroup(ItemGroup.GROUPS.length, "tabFood") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack createIcon() {
	         return new ItemStack(SPItems.apple_pie);
	      }
	   }).func_199783_b("tabFood");
	public static final ItemGroup tabGem = (new ItemGroup(ItemGroup.GROUPS.length, "tabGem") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack createIcon() {
	         return new ItemStack(SPBlocks.amethyst);
	      }
	   }).func_199783_b("tabGem");
	public static final ItemGroup tabCombat = (new ItemGroup(ItemGroup.GROUPS.length, "tabCombat") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack createIcon() {
	         return new ItemStack(SPItems.titanium_sword);
	      }
	   }).func_199783_b("tabCombat");
	public static final ItemGroup tabTools = (new ItemGroup(ItemGroup.GROUPS.length, "tabTools") {
	      @OnlyIn(Dist.CLIENT)
	      public ItemStack createIcon() {
	         return new ItemStack(SPItems.bronze_axe);
	      }
	   }).func_199783_b("tabTools");

}
