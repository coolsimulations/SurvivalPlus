package net.coolsimulations.SurvivalPlus.api;

import java.util.ArrayList;
import java.util.List;

public class SPReference {
	public static final String MOD_ID = "survivalplus";
	public static final String MOD_NAME = "SurvivalPlus";
	public static final String VERSION = "0.1.6d";
	public static final String CLIENT_PROXY_CLASS = "net.coolsimulations.SurvivalPlus.core.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "net.coolsimulations.SurvivalPlus.core.proxy.ServerProxy";

	public static List<String> MOD_ADDON_NAMES = new ArrayList<String>() {{add("sp.name");}}; 

	public static final String SURVIVALPLUS_CONFIG_FILE = "SurvivalPlus/SurvivalPlus.conf";
	public static final String CONFIG_CATEGORY_RECIPES = "sp.configgui.recipes";
	public static final String CONFIG_CATEGORY_COMPATIBILITY = "sp.configgui.compatibility";
	public static final String CONFIG_CATEGORY_GENERATION = "sp.configgui.generation";
	public static final String CONFIG_CATEGORY_COMMAND = "sp.configgui.command";
}
