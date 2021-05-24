package net.coolsimulations.SurvivalPlus.core.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SurvivalPlusConfigGUI {

	public static Screen getConfigScreen(Screen parent)
	{
		ConfigBuilder builder = ConfigBuilder.create()
				.setParentScreen(parent)
				.setTitle(new TranslatableText("sp.configgui.title"));

		builder.setSavingRunnable(() -> {
			SurvivalPlusConfig.save(SurvivalPlusConfig.getFile(), SurvivalPlusConfig.getObject());
			SurvivalPlusConfig.load(SurvivalPlusConfig.getFile());
		});

		builder.setDefaultBackgroundTexture(new Identifier(SPReference.MOD_ID + ":textures/blocks/bronze_block.png"));

		ConfigCategory generation = builder.getOrCreateCategory(new TranslatableText(SPReference.CONFIG_CATEGORY_GENERATION));
		ConfigCategory command = builder.getOrCreateCategory(new TranslatableText(SPReference.CONFIG_CATEGORY_COMMAND));
		ConfigCategory compatibility = builder.getOrCreateCategory(new TranslatableText(SPReference.CONFIG_CATEGORY_COMPATIBILITY));
		ConfigEntryBuilder entryBuilder = builder.entryBuilder();

		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_copper_ore_gen"), SPConfig.disableCopperOreGen).setTooltip(new TranslatableText("sp.configgui.disable_copper_ore_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableCopperOreGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_tin_ore_gen"), SPConfig.disableTinOreGen).setTooltip(new TranslatableText("sp.configgui.disable_tin_ore_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableTinOreGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_titanium_ore_gen"), SPConfig.disableTitaniumOreGen).setTooltip(new TranslatableText("sp.configgui.disable_titanium_ore_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableTitaniumOreGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_amethyst_gen"), SPConfig.disableAmethystGen).setTooltip(new TranslatableText("sp.configgui.disable_amethyst_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableAmethystGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_ruby_gen"), SPConfig.disableRubyGen).setTooltip(new TranslatableText("sp.configgui.disable_ruby_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableRubyGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_topaz_gen"), SPConfig.disableTopazGen).setTooltip(new TranslatableText("sp.configgui.disable_topaz_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableTopazGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_sapphire_gen"), SPConfig.disableSapphireGen).setTooltip(new TranslatableText("sp.configgui.disable_sapphire_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableSapphireGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_pearl_gen"), SPConfig.disablePearlGen).setTooltip(new TranslatableText("sp.configgui.disable_pearl_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disablePearlGen = newValue).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_spinel_gen"), SPConfig.disableSpinelGen).setTooltip(new TranslatableText("sp.configgui.disable_spinel_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableSpinelGen = newValue).build());

		command.addEntry(entryBuilder.startIntSlider(new TranslatableText("sp.configgui.op_wak_command"), SPConfig.opWak, 0, 4).setTooltip(new TranslatableText("sp.configgui.op_wak_command")).setDefaultValue(0).setSaveConsumer(newValue->SPConfig.opWak = newValue).build());
		command.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.update_check"), SPConfig.disableUpdateCheck).setTooltip(new TranslatableText("sp.configgui.update_check")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableUpdateCheck = newValue).build());

		compatibility.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.sun_audio"), SPConfig.disableSunAudio).setTooltip(new TranslatableText("sp.configgui.sun_audio")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableSunAudio = newValue).build());

		command.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("sp.configgui.disable_thanks"), SPConfig.disableThanks).setTooltip(new TranslatableText("sp.configgui.disable_thanks")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableThanks = newValue).build());

		return builder.build();
	}
}
