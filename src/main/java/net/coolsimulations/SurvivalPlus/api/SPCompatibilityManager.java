package net.coolsimulations.SurvivalPlus.api;

import org.apache.commons.lang3.StringUtils;

import net.fabricmc.loader.api.FabricLoader;

public class SPCompatibilityManager {

	private static boolean modGCLoaded;
	private static boolean modShieldLibLoaded;
	private static boolean modRefinedMachineryLoaded;
	private static boolean modBlockusLoaded;
	private static boolean modBambooTweaksLoaded;
	private static boolean modBambooEverythingLoaded;
	private static boolean modBetterBambooLoaded;
	private static boolean modTraverseLoaded;
	private static boolean modTerrestriaLoaded;
	private static boolean modMoreGemsLoaded;
	private static boolean modEasyEmeraldLoaded;
	private static boolean modVanillaEnhancedLoaded;
	private static boolean modRobinsEmeraldLoaded;
	private static boolean modRobinsRubyLoaded;
	private static boolean modRobinsAmethystLoaded;
	private static boolean modSimpleEmeraldLoaded;
	private static boolean modBambooExpandedLoaded;
	private static boolean modMechanixLoaded;
	private static boolean modPulverizerLoaded;
	private static boolean modIndustrialRevolutionLoaded;
	private static boolean modModernIndustrializationLoaded;
	private static boolean modObsidianEquipmentLoaded;
	private static boolean modEmeraldEquipmentLoaded;
	private static boolean modAdabraniumLoaded;
	private static boolean modAetherRebornLoaded;
	private static boolean modGobberLoaded;

	public static final String GCCORE_MODID = "galacticraft";
	public static final String FABRIC_SHIELD_LIB_MODID = "fabricshieldlib";
	public static final String REFINED_MACHINERY_MODID = "refinedmachinery";
	public static final String BLOCKUS_MODID = "blockus";
	public static final String BAMBOO_TWEAKS_MODID = "bambootweaks";
	public static final String BAMBOO_EVERYTHING_MODID = "bambooeverything";
	public static final String BETTER_BAMBOO_MODID = "bamboomod";
	public static final String TRAVERSE_MODID = "traverse";
	public static final String TERRESTRIA_MODID = "terrestria";
	public static final String MORE_GEMS_MODID = "more_gems";
	public static final String EASY_EMERALD_MODID = "emerald_tools";
	public static final String VANILLA_ENHANCED_MODID = "vanillaenhanced";
	public static final String ROBINS_EMERALD_MODID = "emerald_mod";
	public static final String ROBINS_RUBY_MODID = "ruby_mod";
	public static final String ROBINS_AMETHYST_MODID = "amethyst_mod";
	public static final String SIMPLE_EMERALD_MODID = "em";
	public static final String BAMBOO_EXPANDED_MODID = "bambooexpanded";
	public static final String MECHANIX_MODID = "mechanix";
	public static final String PULVERIZER_MODID = "pulverizer_mod";
	public static final String INDUSTRIAL_REVOLUTION_MODID = "indrev";
	public static final String MODERN_INDUSTRIALIZATION_MODID = "modern_industrialization";
	public static final String OBSIDIAN_EQUIPMENT_MODID = "obsidianequipment";
	public static final String EMERALD_EQUIPMENT_MODID = "emeraldequipment";
	public static final String ADABRANIUM_MODID = "adabraniummod";
	public static final String AETHER_REBORN_MODID = "the_aether";
	public static final String GOBBER_MODID = "gobber2";
	
	public static final String FABRIC_LOADER_MODID = "fabricloader";

	public static void checkForCompatibleMods(){

		if (FabricLoader.getInstance().isModLoaded(GCCORE_MODID))
		{
			SPCompatibilityManager.modGCLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(FABRIC_SHIELD_LIB_MODID))
		{
			SPCompatibilityManager.modShieldLibLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(REFINED_MACHINERY_MODID))
		{
			SPCompatibilityManager.modRefinedMachineryLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(BLOCKUS_MODID))
		{
			SPCompatibilityManager.modBlockusLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(BAMBOO_TWEAKS_MODID))
		{
			SPCompatibilityManager.modBambooTweaksLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(BAMBOO_EVERYTHING_MODID))
		{
			SPCompatibilityManager.modBambooEverythingLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(BETTER_BAMBOO_MODID))
		{
			SPCompatibilityManager.modBetterBambooLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(TRAVERSE_MODID))
		{
			SPCompatibilityManager.modTraverseLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(TERRESTRIA_MODID))
		{
			SPCompatibilityManager.modTerrestriaLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(MORE_GEMS_MODID))
		{
			SPCompatibilityManager.modMoreGemsLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(EASY_EMERALD_MODID))
		{
			SPCompatibilityManager.modEasyEmeraldLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(VANILLA_ENHANCED_MODID))
		{
			SPCompatibilityManager.modVanillaEnhancedLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(ROBINS_EMERALD_MODID))
		{
			SPCompatibilityManager.modRobinsEmeraldLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(ROBINS_RUBY_MODID))
		{
			SPCompatibilityManager.modRobinsRubyLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(ROBINS_AMETHYST_MODID))
		{
			SPCompatibilityManager.modRobinsAmethystLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(SIMPLE_EMERALD_MODID))
		{
			SPCompatibilityManager.modSimpleEmeraldLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(BAMBOO_EXPANDED_MODID))
		{
			SPCompatibilityManager.modBambooExpandedLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(MECHANIX_MODID))
		{
			SPCompatibilityManager.modMechanixLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(PULVERIZER_MODID))
		{
			SPCompatibilityManager.modPulverizerLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(INDUSTRIAL_REVOLUTION_MODID))
		{
			SPCompatibilityManager.modIndustrialRevolutionLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(MODERN_INDUSTRIALIZATION_MODID))
		{
			SPCompatibilityManager.modModernIndustrializationLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(OBSIDIAN_EQUIPMENT_MODID))
		{
			SPCompatibilityManager.modObsidianEquipmentLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(EMERALD_EQUIPMENT_MODID))
		{
			SPCompatibilityManager.modEmeraldEquipmentLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(ADABRANIUM_MODID))
		{
			SPCompatibilityManager.modAdabraniumLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(AETHER_REBORN_MODID))
		{
			SPCompatibilityManager.modAetherRebornLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(GOBBER_MODID))
		{
			SPCompatibilityManager.modGobberLoaded = true;
		}
	}

	public static boolean isGCLoaded()
	{
		return SPCompatibilityManager.modGCLoaded;
	}
	
	public static boolean isShieldLibLoaded()
	{
		return SPCompatibilityManager.modShieldLibLoaded;
	}
	
	public static boolean isRefinedMachineryLoaded()
	{
		return SPCompatibilityManager.modRefinedMachineryLoaded;
	}
	
	public static boolean isBlockusLoaded()
	{
		return SPCompatibilityManager.modBlockusLoaded;
	}
	
	public static boolean isBambooTweaksLoaded()
	{
		return SPCompatibilityManager.modBambooTweaksLoaded;
	}
	
	public static boolean isBambooEverythingLoaded()
	{
		return SPCompatibilityManager.modBambooEverythingLoaded;
	}
	
	public static boolean isBetterBambooLoaded()
	{
		return SPCompatibilityManager.modBetterBambooLoaded;
	}
	
	public static boolean isBambooModsLoaded() {
		return isBlockusLoaded() || isBambooTweaksLoaded() || isBambooEverythingLoaded() || isBetterBambooLoaded() || isBambooExpandedModLoaded() || isVanillaEnhancedLoaded();
	}
	
	public static boolean isTraverseLoaded()
	{
		return SPCompatibilityManager.modTraverseLoaded;
	}
	
	public static boolean isTerrestriaLoaded()
	{
		return SPCompatibilityManager.modTerrestriaLoaded;
	}
	
	public static boolean isMoreGemsLoaded()
	{
		return SPCompatibilityManager.modMoreGemsLoaded;
	}
	
	public static boolean isEasyEmeraldLoaded()
	{
		return SPCompatibilityManager.modEasyEmeraldLoaded;
	}
	
	public static boolean isVanillaEnhancedLoaded()
	{
		return SPCompatibilityManager.modVanillaEnhancedLoaded;
	}
	
	public static boolean isRobinsEmeraldLoaded()
	{
		return SPCompatibilityManager.modRobinsEmeraldLoaded;
	}
	
	public static boolean isRobinsRubyLoaded()
	{
		return SPCompatibilityManager.modRobinsRubyLoaded;
	}
	
	public static boolean isRobinsAmethystLoaded()
	{
		return SPCompatibilityManager.modRobinsAmethystLoaded;
	}
	
	public static boolean isSimpleEmeraldLoaded()
	{
		return SPCompatibilityManager.modSimpleEmeraldLoaded;
	}
	
	public static boolean isObsidianEquipmentLoaded()
	{
		return SPCompatibilityManager.modObsidianEquipmentLoaded;
	}
	
	public static boolean isEmeraldEquipmentLoaded()
	{
		return SPCompatibilityManager.modEmeraldEquipmentLoaded;
	}
	
	public static boolean isEmeraldMaterialModsLoaded()
	{
		return isEasyEmeraldLoaded() || isVanillaEnhancedLoaded() || isRobinsEmeraldLoaded() || isSimpleEmeraldLoaded() || isEmeraldEquipmentLoaded();
	}
	
	public static boolean isObsidianMaterialModsLoaded()
	{
		return isVanillaEnhancedLoaded() || isEasyEmeraldLoaded() || isObsidianEquipmentLoaded();
	}
	
	public static boolean isBambooExpandedModLoaded()
	{
		return SPCompatibilityManager.modBambooExpandedLoaded;
	}
	
	public static boolean isMechanixLoaded()
	{
		return SPCompatibilityManager.modMechanixLoaded;
	}
	
	public static boolean isPulverizerLoaded()
	{
		return SPCompatibilityManager.modPulverizerLoaded;
	}
	
	public static boolean isIndustrialRevolutionLoaded()
	{
		return SPCompatibilityManager.modIndustrialRevolutionLoaded;
	}
	
	public static boolean isModernIndustrializationLoaded()
	{
		return SPCompatibilityManager.modModernIndustrializationLoaded;
	}
	
	public static boolean isAdabraniumLoaded()
	{
		return SPCompatibilityManager.modAdabraniumLoaded;
	}
	
	public static boolean isAetherRebornLoaded()
	{
		return SPCompatibilityManager.modAetherRebornLoaded;
	}
	
	public static boolean isGobberLoaded()
	{
		return SPCompatibilityManager.modGobberLoaded;
	}
	
	
	public static boolean isFabricLoader12Loaded()
	{
		if(FabricLoader.getInstance().isModLoaded(FABRIC_LOADER_MODID))
		{
			String loader_version = FabricLoader.getInstance().getModContainer(FABRIC_LOADER_MODID).get().getMetadata().getVersion().getFriendlyString();
			String[] version = loader_version.split("[.]");
			
			int major = Integer.parseInt(version[0]);
			int minor = Integer.parseInt(version[1]);
			//int patch = Integer.parseInt(version[2]);
			
			if(major > 0)
			{
				return true;
			}
			else if(minor >= 12)
			{
				return true;
			}
		}
		
		return false;
	}

}
