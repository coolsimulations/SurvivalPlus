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
	private static boolean modMoreGemsLoaded;
	private static boolean modEasyEmeraldLoaded;
	private static boolean modVanillaEnhancedLoaded;
	private static boolean modRobinsEmeraldLoaded;
	private static boolean modRobinsRubyLoaded;
	private static boolean modBugBoyEmeraldLoaded;
	private static boolean modSimpleEmeraldLoaded;
	private static boolean modSimplyEmeraldLoaded;
	private static boolean modSimpleQuartzLoaded;

	public static final String GCCORE_MODID = "galacticraft-rewoven";
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
	public static final String BUGBOY_EMERALD_MODID = "emeraldtools";
	public static final String SIMPLE_EMERALD_MODID = "emerald-tools-justfatlard";
	public static final String SIMPLY_EMERALD_MODID = "simpleemeralds";
	public static final String SIMPLE_QUARTZ_MODID = "quartz-tools-justfatlard";

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
		
		if (FabricLoader.getInstance().isModLoaded(BUGBOY_EMERALD_MODID))
		{
			SPCompatibilityManager.modBugBoyEmeraldLoaded = true;
		}
		
		try {
			Class bugBoy = Class.forName("net.fabricmc.emeraldtools.EmeraldTools");
			if(bugBoy.getMethod("onInitialize", new Class[0]) != null)
				SPCompatibilityManager.modBugBoyEmeraldLoaded = true;
		} catch (Exception e) {
			SPCompatibilityManager.modBugBoyEmeraldLoaded = false;
		}
		
		if (FabricLoader.getInstance().isModLoaded(SIMPLE_EMERALD_MODID))
		{
			SPCompatibilityManager.modSimpleEmeraldLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(SIMPLY_EMERALD_MODID))
		{
			SPCompatibilityManager.modSimplyEmeraldLoaded = true;
		}
		
		if (FabricLoader.getInstance().isModLoaded(SIMPLE_QUARTZ_MODID))
		{
			SPCompatibilityManager.modSimpleQuartzLoaded = true;
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
	
	public static boolean isBugBoyEmeraldLoaded()
	{
		return SPCompatibilityManager.modBugBoyEmeraldLoaded;
	}
	
	public static boolean isSimpleEmeraldLoaded()
	{
		return SPCompatibilityManager.modSimpleEmeraldLoaded;
	}
	
	public static boolean isSimplyEmeraldLoaded()
	{
		return SPCompatibilityManager.modSimplyEmeraldLoaded;
	}
	
	public static boolean isSimpleQuartzLoaded()
	{
		return SPCompatibilityManager.modSimpleQuartzLoaded;
	}
	
	public static boolean isEmeraldMaterialModsLoaded()
	{
		return isMoreGemsLoaded() || isEasyEmeraldLoaded() || isVanillaEnhancedLoaded() || isRobinsEmeraldLoaded() || isBugBoyEmeraldLoaded() || isSimpleEmeraldLoaded() || isSimplyEmeraldLoaded();
	}
	
	public static boolean isObsidianMaterialModsLoaded()
	{
		return isVanillaEnhancedLoaded();
	}

}
