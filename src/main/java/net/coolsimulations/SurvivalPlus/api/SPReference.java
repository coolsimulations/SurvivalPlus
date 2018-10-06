package net.coolsimulations.SurvivalPlus.api;

public class SPReference {
	public static final String MOD_ID = "survivalplus";
	public static final String MOD_NAME = "Survival Plus";
	public static final String VERSION = "0.1.0";
	public static final String ACCEPTED_VERSIONS = "[1.10, 1.10.2]";
	public static final String CLIENT_PROXY_CLASS = "net.coolsimulations.SurvivalPlus.core.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "net.coolsimulations.SurvivalPlus.core.proxy.ServerProxy";

	public static final String DEPENDENCIES_FORGE = "required-after:Forge@[12.18.3.2511,);";
	public static final String DEPENDENCIES = DEPENDENCIES_FORGE + "after:" + SPCompatibilityManager.JEI_MODID +"@[3.14.7,);after:" + SPCompatibilityManager.PROJECTE_MODID +"@[1.10.2-PE1.3.0,);after:" + SPCompatibilityManager.GCCORE_MODID +"@[4.0.1.181,);after:" + SPCompatibilityManager.GCPLANETS_MODID + "@[4.0.1.181,);after:" + SPCompatibilityManager.IC2_MODID + "@[2.6.234-ex110,);after:" + SPCompatibilityManager.BOP_MODID + "@[5.0.0,);after:" + SPCompatibilityManager.BASEMETALS_MODID + "@[2.5.0,);after:" + SPCompatibilityManager.FLOURPOWER_MODID + "@[1.9.4-0.0.3,);after:" + SPCompatibilityManager.SIMPLEGRINDER_MODID + "@[2.095.R1102,);after:" + SPCompatibilityManager.FORESTRY_MODID + "@[5.2.17.390,);after:" + SPCompatibilityManager.RAILCRAFT_MODID + "@[10.3.1,);";

	public static final String SURVIVALPLUS_CONFIG_FILE = "SurvivalPlus/SurvivalPlus.conf";
	public static final String CONFIG_CATEGORY_RECIPES = "recipes";
	public static final String CONFIG_CATEGORY_COMPATIBILITY = "compatibility";
	public static final String CONFIG_CATEGORY_GENERATION = "generation";
	public static final String CONFIG_CATEGORY_COMMAND = "command";
}
