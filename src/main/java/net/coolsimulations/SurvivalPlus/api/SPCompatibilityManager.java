package net.coolsimulations.SurvivalPlus.api;

import net.minecraftforge.fml.ModList;

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
	private static boolean modBopExtrasLoaded;
	private static boolean modBaseMetalsLoaded;
	private static boolean modFlourPowerLoaded;
	private static boolean modWoodenBucketLoaded;
	private static boolean modSimpleGrinderLoaded;
	private static boolean modRecyclerLoaded;
	private static boolean modForestryLoaded;
	private static boolean modRailcraftLoaded;
	private static boolean modLumberjackLoaded;
	private static boolean modHammerTimeLoaded;
	private static boolean modJerLoaded;
	private static boolean modSwordBlockingLoaded;
	private static boolean modSilentMechanismsLoaded;
	private static boolean modMrCrayfishGunModLoaded;
	private static boolean modNoTreePunchingLoaded;
	private static boolean modGemsAndCrystalsLoaded;
	private static boolean modStandardMaterialsLoaded;
	private static boolean modObsidianArmorAndToolsLoaded;
	private static boolean modExtendedNetherBackportLoaded;
	private static boolean modVulcaniteLoaded;
	private static boolean modCarbonadoLoaded;
	private static boolean modFutureMCLoaded;
	private static boolean modWeepingAngelsLoaded;
	private static boolean modTraverseLoaded;
	private static boolean modBambooEverythingLoaded;
	private static boolean modBamboo2Loaded;
	private static boolean modClothConfigLoaded;
	private static boolean modCavesandCliffsBackportLoaded;

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
	public static final String BOPEXTRAS_MODID = "biomesoplentyextras";
	public static final String BASEMETALS_MODID = "basemetals";
	public static final String FLOURPOWER_MODID = "flourpower";
	public static final String WOODENBUCKET_MODID = "woodenbucket";
	public static final String VEFLUIDS_MODID = "vefluids";
	public static final String SIMPLEGRINDER_MODID = "simplegrinder";
	public static final String RECYCLER_MODID = "recycler";
	public static final String FORESTRY_MODID = "forestry";
	public static final String RAILCRAFT_MODID = "railcraft";
	public static final String LUMBERJACK_MODID = "lumberjack";
	public static final String HAMMER_TIME_MODID = "hammertime";
	public static final String JER_MODID = "jeresources";
	public static final String SWORD_BLOCKING_MODID = "swordblockingcombat";
	public static final String SILENT_MECHANISMS_MODID = "silents_mechanisms";
	public static final String MRCRAYFISH_GUN_MOD_MODID = "cgm";
	public static final String NO_TREE_PUNCHING_MODID = "notreepunching";
	public static final String GEMS_AND_CRYSTALS_MODID = "gemsandcrystals";
	public static final String STANDARD_MATERIALS_MODID = "standardmaterials";
	public static final String OBSIDIAN_ARMOR_AND_TOOLS_MODID = "obsidiantools";
	public static final String EXTENDED_NETHER_BACKPORT_MODID = "extendednether";
	public static final String VULCANITE_MODID = "vulcanite";
	public static final String CARBONADO_MODID = "carbonado";
	public static final String FUTURE_MC_MODID = "futuremc";
	public static final String WEEPING_ANGELS_MODID = "weeping-angels";
	public static final String TRAVERSE_MODID = "traverse";
	public static final String BAMBOO_EVERYTHING_MODID = "bambooeverything";
	public static final String BAMBOO_2_MODID = "bamboo2";
	public static final String CLOTH_CONFIG_MODID = "cloth-config2";
	public static final String CAVES_AND_CLIFFS_BACKPORT_MODID = "cavesandcliffs";

	public static void checkForCompatibleMods(){

		if (ModList.get().isLoaded(TE_MODID))
		{
			SPCompatibilityManager.modTELoaded = true;
		}

		if (ModList.get().isLoaded(GCCORE_MODID))
		{
			SPCompatibilityManager.modGCLoaded = true;
		}

		if (ModList.get().isLoaded(GCPLANETS_MODID))
		{
			SPCompatibilityManager.modGCPLoaded = true;
		}

		if (ModList.get().isLoaded(PROJECTE_MODID))
		{
			SPCompatibilityManager.modProjectELoaded = true;
		}

		if (ModList.get().isLoaded(JEI_MODID))
		{
			SPCompatibilityManager.modJeiLoaded = true;
		}

		if (ModList.get().isLoaded(IC2_MODID))
		{
			SPCompatibilityManager.modIc2Loaded = true;
		}


		if (ModList.get().isLoaded(BCRAFTCORE_MODID))
		{
			SPCompatibilityManager.modBCraftLoaded = true;
		}

		if (ModList.get().isLoaded(APPENG_MODID))
		{
			SPCompatibilityManager.modAppEngLoaded = true;
		}

		if (ModList.get().isLoaded(PNEUMATICCRAFT_MODID))
		{
			SPCompatibilityManager.modPneumaticCraftLoaded = true;
		}

		if (ModList.get().isLoaded(BOP_MODID))
		{
			SPCompatibilityManager.modBopLoaded = true;
		}

		if (ModList.get().isLoaded(BOPEXTRAS_MODID))
		{
			SPCompatibilityManager.modBopExtrasLoaded = true;
		}

		if (ModList.get().isLoaded(BASEMETALS_MODID))
		{
			SPCompatibilityManager.modBaseMetalsLoaded = true;
		}

		if (ModList.get().isLoaded(FLOURPOWER_MODID))
		{
			SPCompatibilityManager.modFlourPowerLoaded = true;
		}

		if (ModList.get().isLoaded(WOODENBUCKET_MODID) && ModList.get().isLoaded(VEFLUIDS_MODID))
		{
			SPCompatibilityManager.modWoodenBucketLoaded = true;
		}

		if (ModList.get().isLoaded(SIMPLEGRINDER_MODID))
		{
			SPCompatibilityManager.modSimpleGrinderLoaded = true;
		}

		if (ModList.get().isLoaded(RECYCLER_MODID))
		{
			SPCompatibilityManager.modRecyclerLoaded = true;
		}

		if (ModList.get().isLoaded(FORESTRY_MODID))
		{
			SPCompatibilityManager.modForestryLoaded = true;
		}

		if (ModList.get().isLoaded(RAILCRAFT_MODID))
		{
			SPCompatibilityManager.modRailcraftLoaded = true;
		}

		if (ModList.get().isLoaded(LUMBERJACK_MODID))
		{
			SPCompatibilityManager.modLumberjackLoaded = true;
		}

		if (ModList.get().isLoaded(HAMMER_TIME_MODID))
		{
			SPCompatibilityManager.modHammerTimeLoaded = true;
		}

		if (ModList.get().isLoaded(JER_MODID))
		{
			SPCompatibilityManager.modJerLoaded = true;
		}

		if (ModList.get().isLoaded(SWORD_BLOCKING_MODID))
		{
			SPCompatibilityManager.modSwordBlockingLoaded = true;
		}

		if (ModList.get().isLoaded(SILENT_MECHANISMS_MODID))
		{
			SPCompatibilityManager.modSilentMechanismsLoaded = true;
		}

		if (ModList.get().isLoaded(MRCRAYFISH_GUN_MOD_MODID))
		{
			SPCompatibilityManager.modMrCrayfishGunModLoaded = true;
		}
		
		if (ModList.get().isLoaded(NO_TREE_PUNCHING_MODID))
		{
			SPCompatibilityManager.modNoTreePunchingLoaded = true;
		}
		
		if (ModList.get().isLoaded(GEMS_AND_CRYSTALS_MODID))
		{
			SPCompatibilityManager.modGemsAndCrystalsLoaded = true;
		}
		
		if (ModList.get().isLoaded(STANDARD_MATERIALS_MODID))
		{
			SPCompatibilityManager.modStandardMaterialsLoaded = true;
		}
		
		if (ModList.get().isLoaded(OBSIDIAN_ARMOR_AND_TOOLS_MODID))
		{
			SPCompatibilityManager.modObsidianArmorAndToolsLoaded = true;
		}
		
		if (ModList.get().isLoaded(EXTENDED_NETHER_BACKPORT_MODID))
		{
			SPCompatibilityManager.modExtendedNetherBackportLoaded = true;
		}
		
		if (ModList.get().isLoaded(VULCANITE_MODID))
		{
			SPCompatibilityManager.modVulcaniteLoaded = true;
		}
		
		if (ModList.get().isLoaded(CARBONADO_MODID))
		{
			SPCompatibilityManager.modCarbonadoLoaded = true;
		}
		
		if (ModList.get().isLoaded(FUTURE_MC_MODID))
		{
			SPCompatibilityManager.modFutureMCLoaded = true;
		}
		
		if (ModList.get().isLoaded(WEEPING_ANGELS_MODID))
		{
			SPCompatibilityManager.modWeepingAngelsLoaded = true;
		}
		
		if (ModList.get().isLoaded(TRAVERSE_MODID))
		{
			SPCompatibilityManager.modTraverseLoaded = true;
		}
		
		if (ModList.get().isLoaded(BAMBOO_EVERYTHING_MODID))
		{
			SPCompatibilityManager.modBambooEverythingLoaded = true;
		}
		
		if (ModList.get().isLoaded(BAMBOO_2_MODID))
		{
			SPCompatibilityManager.modBamboo2Loaded = true;
		}
		
		if (ModList.get().isLoaded(CLOTH_CONFIG_MODID))
		{
			SPCompatibilityManager.modClothConfigLoaded = true;
		}
		
		if (ModList.get().isLoaded(CAVES_AND_CLIFFS_BACKPORT_MODID))
		{
			SPCompatibilityManager.modCavesandCliffsBackportLoaded = true;
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

	public static boolean isBopExtrasLoaded()
	{
		return SPCompatibilityManager.modBopExtrasLoaded;
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

	public static boolean isRecyclerLoaded()
	{
		return SPCompatibilityManager.modRecyclerLoaded;
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

	public static boolean isSilentMechanismsLoaded()
	{
		return SPCompatibilityManager.modSilentMechanismsLoaded;
	}

	public static boolean isCGMLoaded()
	{
		return SPCompatibilityManager.modMrCrayfishGunModLoaded;
	}
	
	public static boolean isNoTreePunchingLoaded()
	{
		return SPCompatibilityManager.modNoTreePunchingLoaded;
	}
	
	public static boolean isGACLoaded()
	{
		return SPCompatibilityManager.modGemsAndCrystalsLoaded;
	}
	
	public static boolean isStandardMaterialsLoaded()
	{
		return SPCompatibilityManager.modStandardMaterialsLoaded;
	}
	
	public static boolean isOAATLoaded()
	{
		return SPCompatibilityManager.modObsidianArmorAndToolsLoaded;
	}
	
	public static boolean isEmeraldMaterialModsLoaded()
	{
		return isGACLoaded() || isStandardMaterialsLoaded();
	}
	
	public static boolean isObsidianMaterialModsLoaded()
	{
		return isOAATLoaded() || isStandardMaterialsLoaded();
	}
	
	public static boolean isExtendedNetherBackportLoaded()
	{
		return SPCompatibilityManager.modExtendedNetherBackportLoaded;
	}
	
	public static boolean isVulcaniteLoaded()
	{
		return SPCompatibilityManager.modVulcaniteLoaded;
	}
	
	public static boolean isCarbonadoLoaded()
	{
		return SPCompatibilityManager.modCarbonadoLoaded;
	}
	
	public static boolean isFutureMCLoaded()
	{
		return SPCompatibilityManager.modFutureMCLoaded;
	}
	
	public static boolean isWeepingAngelsLoaded()
	{
		return SPCompatibilityManager.modWeepingAngelsLoaded;
	}
	
	public static boolean isTraverseLoaded()
	{
		return SPCompatibilityManager.modTraverseLoaded;
	}
	
	public static boolean isBambooEverythingLoaded()
	{
		return SPCompatibilityManager.modBambooEverythingLoaded;
	}
	
	public static boolean isBamboo2Loaded()
	{
		return SPCompatibilityManager.modBamboo2Loaded;
	}
	
	public static boolean isBambooModsLoaded() {
		return isBambooEverythingLoaded() || isBamboo2Loaded();
	}
	
	public static boolean isClothConfigLoaded()
	{
		return SPCompatibilityManager.modClothConfigLoaded;
	}
	
	public static boolean isCavesAndCliffsBackportLoaded()
	{
		return SPCompatibilityManager.modCavesandCliffsBackportLoaded;
	}

}
