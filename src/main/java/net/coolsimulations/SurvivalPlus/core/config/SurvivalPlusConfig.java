package net.coolsimulations.SurvivalPlus.core.config;

import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

import org.apache.commons.lang3.tuple.Pair;

public class SurvivalPlusConfig {
	public static class Common {

		Common(final ForgeConfigSpec.Builder builder) {
			builder.comment("Common config settings")
					.push("common");

			SPConfig.enableSponge = builder
					.comment("If this is enabled, sponge can be crafted with a combination of gold ingots, yellow wool and cheese. By default this is set to false as to make sponge cake rarer.")
					.translation("sp.configgui.enable_sponge")
					.define("enableSponge", false);
			
			SPConfig.enableReplaceBOPRecipe = builder
					.comment("If this is enable and Biomes O' Plenty are played with, the crafting recipe for the Terrestrial Artifact can use SurvivalPlus's ruby, topaz, and sapphire. By default this is set to false as the idea of the Terrestrial Artifact is that you need to go to all BOP biomes to find the needed gems, whereas SurvivalPlus gems generate everywhere.")
					.translation("sp.configgui.enable_Replace_BOP_Recipe")
					.define("enableReplaceBOPRecipe", false);
			
			SPConfig.disableCopperOreGen = builder
					.comment("Disable SurvivalPlus Copper Ore Gen")
					.translation("sp.configgui.disable_copper_ore_gen")
					.define("disableCopperOreGen", false);
			
			SPConfig.disableTinOreGen = builder
					.comment("Disable SurvivalPlus Tin Ore Gen")
					.translation("sp.configgui.disable_tin_ore_gen")
					.define("disableTinOreGen", false);
			
			SPConfig.disableTitaniumOreGen = builder
					.comment("Disable SurvivalPlus Titanium Ore Gen")
					.translation("sp.configgui.disable_titanium_ore_gen")
					.define("disableTitaniumOreGen", false);
			
			SPConfig.disableAmethystGen = builder
					.comment("Disable SurvivalPlus Amethyst Gen")
					.translation("sp.configgui.disable_amethyst_gen")
					.define("disableAmethystGen", false);
			
			SPConfig.disableRubyGen = builder
					.comment("Disable SurvivalPlus Ruby Gen")
					.translation("sp.configgui.disable_ruby_gen")
					.define("disableRubyGen", false);
			
			SPConfig.disableTopazGen = builder
					.comment("Disable SurvivalPlus Topaz Gen")
					.translation("sp.configgui.disable_topaz_gen")
					.define("disableTopazGen", false);
			
			SPConfig.disableSapphireGen = builder
					.comment("Disable SurvivalPlus Sapphire Gen")
					.translation("sp.configgui.disable_sapphire_gen")
					.define("disableSapphireGen", false);
			
			
			SPConfig.disablePearlGen = builder
					.comment("Disable SurvivalPlus Pearl Gen")
					.translation("sp.configgui.disable_pearl_gen")
					.define("disablePearlGen", false);
			
			SPConfig.disableSpinelGen = builder
					.comment("Disable SurvivalPlus Spinel Gen")
					.translation("sp.configgui.disable_spinel_gen")
					.define("disableSpinelGen", false);
			
			SPConfig.opWak = builder
					.comment("If this is set to 0 anyone can use the Wak Command. If set above 4 then it will return 4.")
					.translation("sp.configgui.op_wak_command")
					.defineInRange("opWak", 0, 0, 4);
			
			SPConfig.disableUpdateCheck = builder
					.comment("Disable SurvivalPlus Update Checker Message")
					.translation("sp.configgui.update_check")
					.define("disableUpdateCheck", false);


			builder.pop();
		}
	}

	private static final ForgeConfigSpec commonSpec;
	public static final Common COMMON;

	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		commonSpec = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	public static void register(final ModLoadingContext context) {
		context.registerConfig(ModConfig.Type.COMMON, commonSpec);
	}
}
