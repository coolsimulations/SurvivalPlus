package net.coolsimulations.SurvivalPlus.core.compat;

import java.util.Map;

import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.doubledoordev.lumberjack.items.ItemLumberAxe;
import net.insane96mcp.carbonado.lib.Properties;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class SurvivalPlusLumberjack {

	public static void init() {

		SPItems.bronze_lumberaxe = new ItemLumberAxe(SPItems.bronzeToolMaterial);
		SPItems.titanium_lumberaxe = new ItemLumberAxe(SPItems.titaniumToolMaterial);

		if(SPCompatibilityManager.isGCLoaded()) {

			GCItems.TOOL_STEEL.setRepairItem(new ItemStack(GCItems.basicItem, 1, 9));
			SPItems.steel_lumberaxe = new ItemLumberAxe(GCItems.TOOL_STEEL);

			if(SPCompatibilityManager.isGCPLoaded()) {
				MarsItems.TOOLDESH.setRepairItem(new ItemStack(MarsItems.marsItemBasic, 1, 2));
				SPItems.desh_lumberaxe = new ItemLumberAxe(MarsItems.TOOLDESH);
			}
		}
	}

	public static void registerEventHandler() {
		
		MinecraftForge.EVENT_BUS.register(new SurvivalPlusLumberjack());
	}
	
	@SubscribeEvent
	public void removeRecipes(RegistryEvent.Register<IRecipe> event) {
		
		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
		
		if(SPCompatibilityManager.isCarbonadoLoaded()) {
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.LUMBERJACK_MODID + ":" + "carbonado"));
		}

		if(SPCompatibilityManager.isNoTreePunchingLoaded()) {
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.LUMBERJACK_MODID + ":" + "wood"));
		}
	}
	
	@SubscribeEvent
	public void anvilRecipe(AnvilUpdateEvent event) {
		if(SPCompatibilityManager.isCarbonadoLoaded()) {

			ItemStack left = event.getLeft();
			ItemStack right = event.getRight();
			ItemStack output = null;
			int carbonadoAmount = 4;

			if (Properties.config.tools.enableAnvilCrafting && left.isItemEqualIgnoreDurability(new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.LUMBERJACK_MODID, "diamond_lumberaxe")))) && right.getItem().equals(net.insane96mcp.carbonado.init.ModItems.carbonadoItem) && right.getCount() >= carbonadoAmount) {

				output = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(SPCompatibilityManager.LUMBERJACK_MODID, "carbonado_lumberaxe")));
				NBTTagCompound tags = left.getTagCompound();
				output.setTagCompound(tags);
				event.setOutput(output);
				event.setMaterialCost(carbonadoAmount);

				int cost = 0;
				Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(left);
				for (Enchantment enchantment : enchantments.keySet()) {
					int lvl = enchantments.get(enchantment);
					int baseCost = 0;
					switch (enchantment.getRarity())
					{
					case COMMON:
						baseCost = 1;
						break;
					case UNCOMMON:
						baseCost = 2;
						break;
					case RARE:
						baseCost = 4;
						break;
					case VERY_RARE:
						baseCost = 8;
					}
					cost += baseCost * lvl;
				}
				cost *= 0.5f;
				event.setCost(MathHelper.clamp(cost, 1, 39));
			}
		}
	}

}
