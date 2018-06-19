package net.coolsimulations.SurvivalPlus.api;

import net.minecraftforge.common.ForgeVersion;

public class SPReference {
	public static final String MOD_ID = "survivalplus";
	public static final String MOD_NAME = "Survival Plus";
	public static final String VERSION = "0.1.0";
	public static final String ACCEPTED_VERSIONS = "[1.11, 1.11.2]";
	public static final String CLIENT_PROXY_CLASS = "net.coolsimulations.SurvivalPlus.core.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "net.coolsimulations.SurvivalPlus.core.proxy.ServerProxy";
	public static final String DEPENDENCIES_FORGE = "required-after:forge@[13.20.0.2288,);";
	public static final String DEPENDENCIES = DEPENDENCIES_FORGE + "after:" + SPCompatibilityManager.JEI_MODID +"@[4.5.1,);after:" + SPCompatibilityManager.PROJECTE_MODID +"@[1.11.2-PE0.0.0,);after:" + SPCompatibilityManager.GCCORE_MODID +"@[4.0.0,);after:" + SPCompatibilityManager.GCPLANETS_MODID + "@[4.0.0,);after:" + SPCompatibilityManager.IC2_MODID + "@[2.7.81-ex111,);after:" + SPCompatibilityManager.BOP_MODID + "@[6.2.0.2254,);after:" + SPCompatibilityManager.BASEMETALS_MODID + "@[2.4.0,);after:" + SPCompatibilityManager.FLOURPOWER_MODID + "@[1.11-0.0.3-2,);after:" + SPCompatibilityManager.SIMPLEGRINDER_MODID + "@[3.122.R1112,);";

	public static final String SURVIVALPLUS_CONFIG_FILE = "SurvivalPlus/SurvivalPlus.conf";
	public static final String CONFIG_CATEGORY_RECIPES = "recipes";
	public static final String CONFIG_CATEGORY_COMPATIBILITY = "compatibility";
	public static final String CONFIG_CATEGORY_GENERATION = "generation";
	public static final String CONFIG_CATEGORY_COMMAND = "command";
}
