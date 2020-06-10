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

}
