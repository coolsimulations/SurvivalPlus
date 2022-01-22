package net.coolsimulations.SurvivalPlus.api;

import net.minecraftforge.fml.common.Loader;

public class SPCompatibilityManager {

	private static boolean modTELoaded;
	private static boolean modGCLoaded;
	private static boolean modGCPLoaded;
	private static boolean modProjectELoaded;
	private static boolean modJeiLoaded;
	private static boolean modIc2Loaded;
	private static boolean modBCraftLoaded;
	private static boolean modAppEngLoaded;
	private static boolean modPneumaticCraftLoaded;
	private static boolean modBopLoaded;
	private static boolean modBaseMetalsLoaded;
	private static boolean modFlourPowerLoaded;
	private static boolean modWoodenBucketLoaded;
	private static boolean modSimpleGrinderLoaded;
	private static boolean modForestryLoaded;
	private static boolean modRailcraftLoaded;
	private static boolean modLumberjackLoaded;
	private static boolean modHammerTimeLoaded;
	private static boolean modJerLoaded;
	private static boolean modSwordBlockingLoaded;
	private static boolean modBetterCombatLoaded;
	private static boolean modDynamicLightsLoaded;
	private static boolean modSmoothEntityLightLoaded;
	private static boolean modMrCrayfishGunModLoaded;
	private static boolean modReskillableLoaded;
	private static boolean modNoTreePunchingLoaded;
	private static boolean modGemsAndCrystalsLoaded;
	private static boolean modPI3xEmeraldsLoaded;
	private static boolean modTriGemsLoaded;
	private static boolean modFancyToolsLoaded;
	private static boolean modEmeraldAndObsidianLoaded;
	private static boolean modObsidianArmorAndToolsLoaded;
	private static boolean modObsidianToolsAndArmorLoaded;
	private static boolean modNetheriteModLoaded;
	private static boolean modVulcaniteLoaded;
	private static boolean modCarbonadoLoaded;
	private static boolean modGalaxiteOreLoaded;
	private static boolean modFutureMCLoaded;
	private static boolean modAetherLegacyLoaded;
	private static boolean modWeepingAngelsLoaded;
	private static boolean modBamboozledLoaded;
	private static boolean modTraverseLoaded;
	private static boolean modExtraPlanetsLoaded;
	private static boolean modFluidloggedAPILoaded;
	private static boolean modGobberLoaded;

	public static final String TE_MODID = "thermalexpansion";
	public static final String GCCORE_MODID = "galacticraftcore";
	public static final String GCPLANETS_MODID = "galacticraftplanets";
	public static final String PROJECTE_MODID = "projecte";
	public static final String JEI_MODID = "jei";
	public static final String IC2_MODID = "ic2";
	public static final String BCRAFTCORE_MODID = "buildcraftcore";
	public static final String APPENG_MODID = "appliedenergistics2";
	public static final String PNEUMATICCRAFT_MODID = "pneumaticcraft";
	public static final String BOP_MODID = "biomesoplenty";
	public static final String BASEMETALS_MODID = "basemetals";
	public static final String FLOURPOWER_MODID = "flourpower";
	public static final String WOODENBUCKET_MODID = "woodenbucket";
	public static final String VEFLUIDS_MODID = "vefluids";
	public static final String SIMPLEGRINDER_MODID = "simplegrinder";
	public static final String FORESTRY_MODID = "forestry";
	public static final String RAILCRAFT_MODID = "railcraft";
	public static final String LUMBERJACK_MODID = "lumberjack";
	public static final String HAMMER_TIME_MODID = "hammertime";
	public static final String JER_MODID = "jeresources";
	public static final String SWORD_BLOCKING_MODID = "swordblockingcombat";
	public static final String BETTER_COMBAT_MODID = "bettercombatmod";
	public static final String DYNAMIC_LIGHTS_MODID = "dynamiclights";
	public static final String SMOOTH_ENTITY_LIGHT_MODID = "sel";
	public static final String MRCRAYFISH_GUN_MOD_MODID = "cgm";
	public static final String RESKILLABLE_MODID = "reskillable";
	public static final String NO_TREE_PUNCHING_MODID = "notreepunching";
	public static final String GEMS_AND_CRYSTALS_MODID = "gm";
	public static final String PI3XEMERALDS_MODID = "emeralds";
	public static final String TRIGEMS_MODID = "trigems";
	public static final String FANCYTOOLS_MODID = "fancytools";
	public static final String EMERALD_AND_OBSIDIAN_MODID = "emeraldobsidian";
	public static final String OBSIDIAN_ARMOR_AND_TOOLS_MODID = "obsidiantools";
	public static final String OBSIDIAN_TOOLS_AND_ARMOR_MODID = "ota";
	public static final String NETHERITE_MOD_MODID = "netherite";
	public static final String VULCANITE_MODID = "vulcanite";
	public static final String CARBONADO_MODID = "carbonado";
	public static final String GALAXITE_ORE_MODID = "galaxite";
	public static final String FUTURE_MC_MODID = "futuremc";
	public static final String AETHER_LEGACY_MODID = "aether_legacy";
	public static final String WEEPING_ANGELS_MODID = "weeping-angels";
	public static final String BAMBOOZLED_MODID = "bamboozled";
	public static final String TRAVERSE_MODID = "traverse";
	public static final String EXTRA_PLANETS_MODID = "extraplanets";
	public static final String FLUIDLOGGED_API_MODID = "fluidlogged_api";
	public static final String GOBBER_MODID = "gb";

	public static void checkForCompatibleMods(){

		if (Loader.isModLoaded(TE_MODID))
		{
			SPCompatibilityManager.modTELoaded = true;
		}

		if (Loader.isModLoaded(GCCORE_MODID))
		{
			SPCompatibilityManager.modGCLoaded = true;
		}

		if (Loader.isModLoaded(GCPLANETS_MODID))
		{
			SPCompatibilityManager.modGCPLoaded = true;
		}

		if (Loader.isModLoaded(PROJECTE_MODID))
		{
			SPCompatibilityManager.modProjectELoaded = true;
		}

		if (Loader.isModLoaded(JEI_MODID))
		{
			SPCompatibilityManager.modJeiLoaded = true;
		}

		if (Loader.isModLoaded(IC2_MODID))
		{
			SPCompatibilityManager.modIc2Loaded = true;
		}

		if (Loader.isModLoaded(BCRAFTCORE_MODID))
		{
			SPCompatibilityManager.modBCraftLoaded = true;
		}

		if (Loader.isModLoaded(APPENG_MODID))
		{
			SPCompatibilityManager.modAppEngLoaded = true;
		}

		if (Loader.isModLoaded(PNEUMATICCRAFT_MODID))
		{
			SPCompatibilityManager.modPneumaticCraftLoaded = true;
		}

		if (Loader.isModLoaded(BOP_MODID))
		{
			SPCompatibilityManager.modBopLoaded = true;
		}

		if (Loader.isModLoaded(BASEMETALS_MODID))
		{
			SPCompatibilityManager.modBaseMetalsLoaded = true;
		}

		if (Loader.isModLoaded(FLOURPOWER_MODID))
		{
			SPCompatibilityManager.modFlourPowerLoaded = true;
		}

		if (Loader.isModLoaded(WOODENBUCKET_MODID) && Loader.isModLoaded(VEFLUIDS_MODID))
		{
			SPCompatibilityManager.modWoodenBucketLoaded = true;
		}

		if (Loader.isModLoaded(SIMPLEGRINDER_MODID))
		{
			SPCompatibilityManager.modSimpleGrinderLoaded = true;
		}

		if (Loader.isModLoaded(FORESTRY_MODID))
		{
			SPCompatibilityManager.modForestryLoaded = true;
		}

		if (Loader.isModLoaded(RAILCRAFT_MODID))
		{
			SPCompatibilityManager.modRailcraftLoaded = true;
		}

		if (Loader.isModLoaded(LUMBERJACK_MODID))
		{
			SPCompatibilityManager.modLumberjackLoaded = true;
		}

		if (Loader.isModLoaded(HAMMER_TIME_MODID))
		{
			SPCompatibilityManager.modHammerTimeLoaded = true;
		}

		if (Loader.isModLoaded(JER_MODID))
		{
			SPCompatibilityManager.modJerLoaded = true;
		}
		
		if (Loader.isModLoaded(SWORD_BLOCKING_MODID))
		{
			SPCompatibilityManager.modSwordBlockingLoaded = true;
		}
		
		if (Loader.isModLoaded(BETTER_COMBAT_MODID))
		{
			SPCompatibilityManager.modBetterCombatLoaded = true;
		}
		
		if (Loader.isModLoaded(DYNAMIC_LIGHTS_MODID))
		{
			SPCompatibilityManager.modDynamicLightsLoaded = true;
		}
		
		if (Loader.isModLoaded(SMOOTH_ENTITY_LIGHT_MODID))
		{
			SPCompatibilityManager.modSmoothEntityLightLoaded = true;
		}
		
		if (Loader.isModLoaded(MRCRAYFISH_GUN_MOD_MODID))
		{
			SPCompatibilityManager.modMrCrayfishGunModLoaded = true;
		}
		
		if (Loader.isModLoaded(RESKILLABLE_MODID))
		{
			SPCompatibilityManager.modReskillableLoaded = true;
		}
		
		if (Loader.isModLoaded(NO_TREE_PUNCHING_MODID))
		{
			SPCompatibilityManager.modNoTreePunchingLoaded = true;
		}
		
		if (Loader.isModLoaded(GEMS_AND_CRYSTALS_MODID))
		{
			SPCompatibilityManager.modGemsAndCrystalsLoaded = true;
		}
		
		if (Loader.isModLoaded(PI3XEMERALDS_MODID))
		{
			SPCompatibilityManager.modPI3xEmeraldsLoaded = true;
		}
		
		if (Loader.isModLoaded(TRIGEMS_MODID))
		{
			SPCompatibilityManager.modTriGemsLoaded = true;
		}
		
		if (Loader.isModLoaded(FANCYTOOLS_MODID))
		{
			SPCompatibilityManager.modFancyToolsLoaded = true;
		}
		
		if (Loader.isModLoaded(EMERALD_AND_OBSIDIAN_MODID))
		{
			SPCompatibilityManager.modEmeraldAndObsidianLoaded = true;
		}
		
		if (Loader.isModLoaded(OBSIDIAN_ARMOR_AND_TOOLS_MODID))
		{
			SPCompatibilityManager.modObsidianArmorAndToolsLoaded = true;
		}
		
		if (Loader.isModLoaded(OBSIDIAN_TOOLS_AND_ARMOR_MODID))
		{
			SPCompatibilityManager.modObsidianToolsAndArmorLoaded = true;
		}
		
		if (Loader.isModLoaded(NETHERITE_MOD_MODID))
		{
			SPCompatibilityManager.modNetheriteModLoaded = true;
		}
		
		if (Loader.isModLoaded(VULCANITE_MODID))
		{
			SPCompatibilityManager.modVulcaniteLoaded = true;
		}
		
		if (Loader.isModLoaded(CARBONADO_MODID))
		{
			SPCompatibilityManager.modCarbonadoLoaded = true;
		}
		
		if (Loader.isModLoaded(GALAXITE_ORE_MODID))
		{
			SPCompatibilityManager.modGalaxiteOreLoaded = true;
		}
		
		if (Loader.isModLoaded(FUTURE_MC_MODID))
		{
			SPCompatibilityManager.modFutureMCLoaded = true;
		}
		
		if (Loader.isModLoaded(AETHER_LEGACY_MODID))
		{
			SPCompatibilityManager.modAetherLegacyLoaded = true;
		}
		
		if (Loader.isModLoaded(WEEPING_ANGELS_MODID))
		{
			SPCompatibilityManager.modWeepingAngelsLoaded = true;
		}
		
		if (Loader.isModLoaded(BAMBOOZLED_MODID))
		{
			SPCompatibilityManager.modBamboozledLoaded = true;
		}
		
		if (Loader.isModLoaded(TRAVERSE_MODID))
		{
			SPCompatibilityManager.modTraverseLoaded = true;
		}
		
		if (Loader.isModLoaded(EXTRA_PLANETS_MODID))
		{
			SPCompatibilityManager.modExtraPlanetsLoaded = true;
		}
		
		if (Loader.isModLoaded(FLUIDLOGGED_API_MODID))
		{
			SPCompatibilityManager.modFluidloggedAPILoaded = true;
		}
		
		if (Loader.isModLoaded(GOBBER_MODID))
		{
			SPCompatibilityManager.modGobberLoaded = true;
		}
	}

	public static boolean isIc2Loaded()
	{
		return SPCompatibilityManager.modIc2Loaded;
	}

	public static boolean isProjectELoaded()
	{
		return SPCompatibilityManager.modProjectELoaded;
	}

	public static boolean isGCLoaded()
	{
		return SPCompatibilityManager.modGCLoaded;
	}

	public static boolean isBCraftLoaded()
	{
		return SPCompatibilityManager.modBCraftLoaded;
	}

	public static boolean isTELoaded()
	{
		return SPCompatibilityManager.modTELoaded;
	}

	public static boolean isGCPLoaded()
	{
		return SPCompatibilityManager.modGCPLoaded;
	}

	public static boolean isAppEngLoaded()
	{
		return SPCompatibilityManager.modAppEngLoaded;
	}

	public static boolean isPneumaticCraftLoaded()
	{
		return SPCompatibilityManager.modPneumaticCraftLoaded;
	}

	public static boolean isJeiLoaded()
	{
		return SPCompatibilityManager.modJeiLoaded;
	}

	public static boolean isBopLoaded()
	{
		return SPCompatibilityManager.modBopLoaded;
	}

	public static boolean isBaseMetalsLoaded()
	{
		return SPCompatibilityManager.modBaseMetalsLoaded;
	}

	public static boolean isFlourPowerLoaded()
	{
		return SPCompatibilityManager.modFlourPowerLoaded;
	}

	public static boolean isWoodenBucketLoaded()
	{
		return SPCompatibilityManager.modWoodenBucketLoaded;
	}

	public static boolean isSimpleGrinderLoaded()
	{
		return SPCompatibilityManager.modSimpleGrinderLoaded;
	}

	public static boolean isForestryLoaded()
	{
		return SPCompatibilityManager.modForestryLoaded;
	}

	public static boolean isRailcraftLoaded()
	{
		return SPCompatibilityManager.modRailcraftLoaded;
	}

	public static boolean isLumberjackLoaded()
	{
		return SPCompatibilityManager.modLumberjackLoaded;
	}

	public static boolean isHammerTimeLoaded()
	{
		return SPCompatibilityManager.modHammerTimeLoaded;
	}

	public static boolean isJerLoaded()
	{
		return SPCompatibilityManager.modJerLoaded;
	}
	
	public static boolean isSwordBlockingLoaded()
	{
		return SPCompatibilityManager.modSwordBlockingLoaded;
	}
	
	public static boolean isBetterCombatLoaded()
	{
		return SPCompatibilityManager.modBetterCombatLoaded;
	}
	
	public static boolean isDynamicLightsLoaded()
	{
		return SPCompatibilityManager.modDynamicLightsLoaded;
	}
	
	public static boolean isSELLoaded()
	{
		return SPCompatibilityManager.modSmoothEntityLightLoaded;
	}
	
	public static boolean isCGMLoaded()
	{
		return SPCompatibilityManager.modMrCrayfishGunModLoaded;
	}
	
	public static boolean isReskillableLoaded()
	{
		return SPCompatibilityManager.modReskillableLoaded;
	}
	
	public static boolean isNoTreePunchingLoaded()
	{
		return SPCompatibilityManager.modNoTreePunchingLoaded;
	}
	
	public static boolean isGACLoaded()
	{
		return SPCompatibilityManager.modGemsAndCrystalsLoaded;
	}
	
	public static boolean isPI3xLoaded()
	{
		return SPCompatibilityManager.modPI3xEmeraldsLoaded;
	}
	
	public static boolean isTriGemsLoaded()
	{
		return SPCompatibilityManager.modTriGemsLoaded;
	}
	
	public static boolean isFancyToolsLoaded()
	{
		return SPCompatibilityManager.modFancyToolsLoaded;
	}
	
	public static boolean isEAOLoaded()
	{
		return SPCompatibilityManager.modEmeraldAndObsidianLoaded;
	}
	
	public static boolean isOAATLoaded()
	{
		return SPCompatibilityManager.modObsidianArmorAndToolsLoaded;
	}
	
	public static boolean isOTAALoaded()
	{
		return SPCompatibilityManager.modObsidianToolsAndArmorLoaded;
	}
	
	public static boolean isEmeraldMaterialModsLoaded()
	{
		return isGACLoaded() || isPI3xLoaded() || isTriGemsLoaded() || isFancyToolsLoaded() || isEAOLoaded();
	}
	
	public static boolean isObsidianMaterialModsLoaded()
	{
		return isFancyToolsLoaded() || isEAOLoaded() || isOAATLoaded() || isOTAALoaded();
	}
	
	public static boolean isNetheriteModLoaded()
	{
		return SPCompatibilityManager.modNetheriteModLoaded;
	}
	
	public static boolean isVulcaniteLoaded()
	{
		return SPCompatibilityManager.modVulcaniteLoaded;
	}
	
	public static boolean isCarbonadoLoaded()
	{
		return SPCompatibilityManager.modCarbonadoLoaded;
	}
	
	public static boolean isGalaxiteOreLoaded()
	{
		return SPCompatibilityManager.modGalaxiteOreLoaded;
	}
	
	public static boolean isFutureMCLoaded()
	{
		return SPCompatibilityManager.modFutureMCLoaded;
	}
	
	public static boolean isAetherLegacyLoaded()
	{
		return SPCompatibilityManager.modAetherLegacyLoaded;
	}
	
	public static boolean isWeepingAngelsLoaded()
	{
		return SPCompatibilityManager.modWeepingAngelsLoaded;
	}
	
	public static boolean isBamboozledLoaded()
	{
		return SPCompatibilityManager.modBamboozledLoaded;
	}
	
	public static boolean isBambooModsLoaded() {
		return isBamboozledLoaded();
	}
	
	public static boolean isTraverseLoaded()
	{
		return SPCompatibilityManager.modTraverseLoaded;
	}
	
	public static boolean isExtraPlanetsLoaded()
	{
		return SPCompatibilityManager.modExtraPlanetsLoaded;
	}
	
	public static boolean isFluidLoggedLoaded()
	{
		return SPCompatibilityManager.modFluidloggedAPILoaded;
	}
	
	public static boolean isGobberLoaded()
	{
		return SPCompatibilityManager.modGobberLoaded;
	}

}
