package net.coolsimulations.SurvivalPlus.core.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SurvivalPlusConfigGUI {

	public static Screen getConfigScreen(Screen parent)
	{
		ConfigBuilder builder = ConfigBuilder.create()
				.setParentScreen(parent)
				.setTitle(new TranslatableText("sp.configgui.title").asFormattedString());

		builder.setSavingRunnable(() -> {
			SurvivalPlusConfig.save(SurvivalPlusConfig.getFile(), SurvivalPlusConfig.getObject());
			SurvivalPlusConfig.load(SurvivalPlusConfig.getFile());
		});

		builder.setDefaultBackgroundTexture(new Identifier(SPReference.MOD_ID + ":textures/blocks/bronze_block.png"));

		ConfigCategory generation = builder.getOrCreateCategory(SPReference.CONFIG_CATEGORY_GENERATION);
		ConfigCategory command = builder.getOrCreateCategory(SPReference.CONFIG_CATEGORY_COMMAND);
		ConfigCategory compatibility = builder.getOrCreateCategory(SPReference.CONFIG_CATEGORY_COMPATIBILITY);
		ConfigEntryBuilder entryBuilder = builder.entryBuilder();

		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_copper_ore_gen").asFormattedString(), SPConfig.disableCopperOreGen).setTooltip("Disable SurvivalPlus Copper Ore Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableCopperOreGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_tin_ore_gen").asFormattedString(), SPConfig.disableTinOreGen).setTooltip("Disable SurvivalPlus Tin Ore Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableTinOreGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_titanium_ore_gen").asFormattedString(), SPConfig.disableTitaniumOreGen).setTooltip("Disable SurvivalPlus Titanium Ore Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableTitaniumOreGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_amethyst_gen").asFormattedString(), SPConfig.disableAmethystGen).setTooltip("Disable SurvivalPlus Amethyst Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableAmethystGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_ruby_gen").asFormattedString(), SPConfig.disableRubyGen).setTooltip("Disable SurvivalPlus Ruby Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableRubyGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_topaz_gen").asFormattedString(), SPConfig.disableTopazGen).setTooltip("Disable SurvivalPlus Topaz Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableTopazGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_sapphire_gen").asFormattedString(), SPConfig.disableSapphireGen).setTooltip("Disable SurvivalPlus Sapphire Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableSapphireGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_pearl_gen").asFormattedString(), SPConfig.disablePearlGen).setTooltip("Disable SurvivalPlus Pearl Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disablePearlGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_spinel_gen").asFormattedString(), SPConfig.disableSpinelGen).setTooltip("Disable SurvivalPlus Spinel Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableSpinelGen = newValue).build());

		command.addEntry(entryBuilder.startIntSlider(new TranslatableText("sp.configgui.op_wak_command").asFormattedString(), SPConfig.opWak, 0, 4).setTooltip("If this is set to 0 anyone can use the Wak Command").setDefaultValue(0).setSaveConsumer(newValue->SPConfig.opWak = newValue).build());
		command.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.update_check").asFormattedString(), SPConfig.disableUpdateCheck).setTooltip("Disable SurvivalPlus Update Checker Message").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableUpdateCheck = newValue).build());

		compatibility.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.sun_audio").asFormattedString(), SPConfig.disableSunAudio).setTooltip("Disable Sounds Played Through sun.audio").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableSunAudio = newValue).build());

		command.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_thanks").asFormattedString(), SPConfig.disableThanks).setTooltip("Disable SurvivalPlus Thank You Message").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableThanks = newValue).build());

		return builder.build();
	}
}
