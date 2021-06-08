package net.coolsimulations.SurvivalPlus.api;

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
	private static boolean modWeepingAngelsLoaded;

	public static final String GCCORE_MODID = "galacticraft";
	public static final String FABRIC_SHIELD_LIB_MODID = "fabricshieldlib";
	public static final String REFINED_MACHINERY_MODID = "refinedmachinery";
	public static final String BLOCKUS_MODID = "blockus";
	public static final String BAMBOO_TWEAKS_MODID = "bambootweaks";
	public static final String BAMBOO_EVERYTHING_MODID = "bambooeverything";
	public static final String BETTER_BAMBOO_MODID = "bamboomod";
	public static final String TRAVERSE_MODID = "traverse";
	public static final String TERRESTRIA_MODID = "terrestria";
	public static final String WEEPING_ANGELS_MODID = "weeping-angels";

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
		
		if (FabricLoader.getInstance().isModLoaded(WEEPING_ANGELS_MODID))
		{
			SPCompatibilityManager.modWeepingAngelsLoaded = true;
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
		return isBlockusLoaded() || isBambooTweaksLoaded() || isBambooEverythingLoaded() || isBetterBambooLoaded();
	}
	
	public static boolean isTraverseLoaded()
	{
		return SPCompatibilityManager.modTraverseLoaded;
	}
	
	public static boolean isTerrestriaLoaded()
	{
		return SPCompatibilityManager.modTerrestriaLoaded;
	}
	
	public static boolean isWeepingAngelsLoaded()
	{
		return SPCompatibilityManager.modWeepingAngelsLoaded;
	}

}
