package net.coolsimulations.SurvivalPlus.api;

import net.minecraftforge.common.ForgeVersion;

public class SPReference {
	public static final String MOD_ID = "survivalplus";
	public static final String MOD_NAME = "Survival Plus";
	public static final String VERSION = "0.1.0";
	public static final String ACCEPTED_VERSIONS = "[1.12, 1.12.2]";
	public static final String CLIENT_PROXY_CLASS = "net.coolsimulations.SurvivalPlus.core.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "net.coolsimulations.SurvivalPlus.core.proxy.ServerProxy";
	public static final String DEPENDENCIES_FORGE = "required-after:forge@[14.23.4.2705,);";

	public static final String DEPENDENCIES_ADDON = DEPENDENCIES_FORGE + "required-after:" + MOD_ID + "@[" + VERSION + ",);";
	public static final String DEPENDENCIES = DEPENDENCIES_FORGE + "after:" + SPCompatibilityManager.JEI_MODID +"@[4.9.2,);after:" + SPCompatibilityManager.PROJECTE_MODID +"@[1.12.2-PE1.3.0,);after:" + SPCompatibilityManager.GCCORE_MODID +"@[4.0.1.181,);after:" + SPCompatibilityManager.GCPLANETS_MODID + "@[4.0.1.181,);after:" + SPCompatibilityManager.IC2_MODID + "@[2.8.83-ex112,);after:" + SPCompatibilityManager.BOP_MODID + "@[7.0.1.2391,);after:" + SPCompatibilityManager.BASEMETALS_MODID + "@[2.5.0,);after:" + SPCompatibilityManager.FLOURPOWER_MODID + "@[1.12-0.0.6,);after:" + SPCompatibilityManager.SIMPLEGRINDER_MODID + ";after:" + SPCompatibilityManager.FORESTRY_MODID + "@[5.8.0.319,)";

	public static final String SURVIVALPLUS_CONFIG_FILE = "SurvivalPlus/SurvivalPlus.conf";
	public static final String CONFIG_CATEGORY_RECIPES = "recipes";
	public static final String CONFIG_CATEGORY_COMPATIBILITY = "compatibility";
	public static final String CONFIG_CATEGORY_GENERATION = "generation";
	public static final String CONFIG_CATEGORY_COMMAND = "command";
}
