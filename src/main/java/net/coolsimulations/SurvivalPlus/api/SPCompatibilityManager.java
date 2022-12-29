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
	private static boolean modJerLoaded;
	private static boolean modSwordBlockingLoaded;
	private static boolean modSilentMechanismsLoaded;
	private static boolean modMrCrayfishGunModLoaded;
	private static boolean modNoTreePunchingLoaded;
	private static boolean modObsidianArmorAndToolsLoaded;
	private static boolean modSimpleEmeraldModLoaded;
	private static boolean modEasyEmeraldToolsLoaded;
	private static boolean modWeepingAngelsLoaded;
	private static boolean modTraverseLoaded;
	private static boolean modBambooEverythingLoaded;
	private static boolean modBamboo2Loaded;
	private static boolean modClothConfigLoaded;
	private static boolean modBambooTweaksLoaded;
	private static boolean modFancyToolsLoaded;
	private static boolean modObsidianEquipmentLoaded;
	private static boolean modEmeraldEquipmentLoaded;
	private static boolean modPlainGrinderLoaded;
	private static boolean modGobberLoaded;
	private static boolean modBeaconsForAllLoaded;
	private static boolean modTorcherinoLoaded;
	private static boolean modBoneTorchLoaded;
	private static boolean modRealisticTorchesLoaded;
	private static boolean modEpicFightLoaded;
	private static boolean modBetterCombatLoaded;
	private static boolean modAetherLoaded;

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
	public static final String JER_MODID = "jeresources";
	public static final String SWORD_BLOCKING_MODID = "swordblockingcombat";
	public static final String SILENT_MECHANISMS_MODID = "silents_mechanisms";
	public static final String MRCRAYFISH_GUN_MOD_MODID = "cgm";
	public static final String NO_TREE_PUNCHING_MODID = "notreepunching";
	public static final String OBSIDIAN_ARMOR_AND_TOOLS_MODID = "obsidiantools";
	public static final String SIMPLE_EMERALD_MODID = "emeraldmod";
	public static final String EASY_EMERALD_TOOLS_MODID = "easy_emerald";
	public static final String WEEPING_ANGELS_MODID = "weeping-angels";
	public static final String TRAVERSE_MODID = "traverse";
	public static final String BAMBOO_EVERYTHING_MODID = "bambooeverything";
	public static final String BAMBOO_2_MODID = "bamboo2";
	public static final String CLOTH_CONFIG_MODID = "cloth_config";
	public static final String BAMBOO_TWEAKS_MODID = "bambootweaks";
	public static final String FANCYTOOLS_MODID = "fancytools";
	public static final String OBSIDIAN_EQUIPMENT_MODID = "obsidianequipment";
	public static final String EMERALD_EQUIPMENT_MODID = "emeraldequipment";
	public static final String PLAIN_GRINDER_MODID = "plaingrinder";
	public static final String GOBBER_MODID = "gobber2";
	public static final String BEACONS_FOR_ALL_MODID = "beaconsforall";
	public static final String TORCHERINO_MODID = "torcherino";
	public static final String BONE_TORCH_MODID = "bonetorch";
	public static final String REALISTIRC_TORCHES_MODID = "realistictorches";
	public static final String EPIC_FIGHT_MODID = "epicfight";
	public static final String BETTER_COMBAT_MODID = "epicfight";
	public static final String AETHER_MODID = "aether";

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
		
		if (ModList.get().isLoaded(OBSIDIAN_ARMOR_AND_TOOLS_MODID))
		{
			SPCompatibilityManager.modObsidianArmorAndToolsLoaded = true;
		}
		
		if (ModList.get().isLoaded(SIMPLE_EMERALD_MODID))
		{
			SPCompatibilityManager.modSimpleEmeraldModLoaded = true;
		}
		
		if (ModList.get().isLoaded(EASY_EMERALD_TOOLS_MODID))
		{
			SPCompatibilityManager.modEasyEmeraldToolsLoaded = true;
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
		
		if (ModList.get().isLoaded(BAMBOO_TWEAKS_MODID))
		{
			SPCompatibilityManager.modBambooTweaksLoaded = true;
		}
		
		if (ModList.get().isLoaded(FANCYTOOLS_MODID))
		{
			SPCompatibilityManager.modFancyToolsLoaded = true;
		}
		
		if (ModList.get().isLoaded(OBSIDIAN_EQUIPMENT_MODID))
		{
			SPCompatibilityManager.modObsidianEquipmentLoaded = true;
		}
		
		if (ModList.get().isLoaded(EMERALD_EQUIPMENT_MODID))
		{
			SPCompatibilityManager.modEmeraldEquipmentLoaded = true;
		}
		
		if (ModList.get().isLoaded(PLAIN_GRINDER_MODID))
		{
			SPCompatibilityManager.modPlainGrinderLoaded = true;
		}
		
		if (ModList.get().isLoaded(GOBBER_MODID))
		{
			SPCompatibilityManager.modGobberLoaded = true;
		}
		
		if (ModList.get().isLoaded(BEACONS_FOR_ALL_MODID))
		{
			SPCompatibilityManager.modBeaconsForAllLoaded = true;
		}
		
		if (ModList.get().isLoaded(TORCHERINO_MODID))
		{
			SPCompatibilityManager.modTorcherinoLoaded = true;
		}
		
		if (ModList.get().isLoaded(BONE_TORCH_MODID))
		{
			SPCompatibilityManager.modBoneTorchLoaded = true;
		}
		
		if (ModList.get().isLoaded(REALISTIRC_TORCHES_MODID))
		{
			SPCompatibilityManager.modRealisticTorchesLoaded = true;
		}
		
		if (ModList.get().isLoaded(EPIC_FIGHT_MODID))
		{
			SPCompatibilityManager.modEpicFightLoaded = true;
		}
		
		if (ModList.get().isLoaded(BETTER_COMBAT_MODID))
		{
			SPCompatibilityManager.modBetterCombatLoaded = true;
		}
		
		if (ModList.get().isLoaded(AETHER_MODID))
		{
			SPCompatibilityManager.modAetherLoaded = true;
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
	
	public static boolean isOAATLoaded()
	{
		return SPCompatibilityManager.modObsidianArmorAndToolsLoaded;
	}
	
	public static boolean isSimpleEmeraldLoaded()
	{
		return SPCompatibilityManager.modSimpleEmeraldModLoaded;
	}
	
	public static boolean isEasyEmeraldLoaded()
	{
		return SPCompatibilityManager.modEasyEmeraldToolsLoaded;
	}
	
	public static boolean isFancyToolsLoaded()
	{
		return SPCompatibilityManager.modFancyToolsLoaded;
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
		return isSimpleEmeraldLoaded() || isEasyEmeraldLoaded() || isFancyToolsLoaded() || isEmeraldEquipmentLoaded();
	}
	
	public static boolean isObsidianMaterialModsLoaded()
	{
		return isOAATLoaded() || isEasyEmeraldLoaded() || isFancyToolsLoaded() || isObsidianEquipmentLoaded();
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
	
	public static boolean isBambooTweaksLoaded()
	{
		return SPCompatibilityManager.modBambooTweaksLoaded;
	}
	
	public static boolean isBambooModsLoaded() {
		return isBambooEverythingLoaded() || isBamboo2Loaded() || isBambooTweaksLoaded();
	}
	
	public static boolean isClothConfigLoaded()
	{
		return SPCompatibilityManager.modClothConfigLoaded;
	}
	
	public static boolean isPlainGrinderLoaded()
	{
		return SPCompatibilityManager.modPlainGrinderLoaded;
	}
	
	public static boolean isGobberLoaded()
	{
		return SPCompatibilityManager.modGobberLoaded;
	}
	
	public static boolean isBeaconsForAllLoaded()
	{
		return SPCompatibilityManager.modBeaconsForAllLoaded;
	}
	
	public static boolean isUnlitTorchModsLoaded() {
		return isGCLoaded() || isRealisticTorchesLoaded();
	}
	
	public static boolean isTorcherinoLoaded()
	{
		return SPCompatibilityManager.modTorcherinoLoaded;
	}
	
	public static boolean isBoneTorchLoaded()
	{
		return SPCompatibilityManager.modBoneTorchLoaded;
	}
	
	public static boolean isRealisticTorchesLoaded()
	{
		return SPCompatibilityManager.modRealisticTorchesLoaded;
	}

	public static boolean isEpicFightLoaded()
	{
		return SPCompatibilityManager.modEpicFightLoaded;
	}

	public static boolean isBetterCombatLoaded()
	{
		return SPCompatibilityManager.modBetterCombatLoaded;
	}
	
	public static boolean isAetherLoaded()
	{
		return SPCompatibilityManager.modAetherLoaded;
	}

}
