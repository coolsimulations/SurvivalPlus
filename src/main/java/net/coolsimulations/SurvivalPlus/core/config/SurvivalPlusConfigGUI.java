package net.coolsimulations.SurvivalPlus.core.config;

import me.shedaniel.forge.clothconfig2.api.ConfigBuilder;
import me.shedaniel.forge.clothconfig2.api.ConfigCategory;
import me.shedaniel.forge.clothconfig2.api.ConfigEntryBuilder;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SurvivalPlusConfigGUI {

	public static Screen getConfigScreen(Screen parent)
	{
		ConfigBuilder builder = ConfigBuilder.create()
				.setParentScreen(parent)
				.setTitle(new TranslationTextComponent("sp.configgui.title").getFormattedText());

		builder.setSavingRunnable(() -> {
			SurvivalPlusConfig.commonSpec.save();
		});

		builder.setDefaultBackgroundTexture(new ResourceLocation(SPReference.MOD_ID + ":textures/blocks/bronze_block.png"));

		ConfigCategory generation = builder.getOrCreateCategory(SPReference.CONFIG_CATEGORY_GENERATION);
		ConfigCategory command = builder.getOrCreateCategory(SPReference.CONFIG_CATEGORY_COMMAND);
		ConfigCategory compatibility = builder.getOrCreateCategory(SPReference.CONFIG_CATEGORY_COMPATIBILITY);
		ConfigEntryBuilder entryBuilder = builder.getEntryBuilder();

		generation.addEntry(entryBuilder.startBooleanToggle(new TranslationTextComponent("sp.configgui.disable_copper_ore_gen").getFormattedText(), SPConfig.disableCopperOreGen.get()).setTooltip("Disable SurvivalPlus Copper Ore Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableCopperOreGen.set(newValue)).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslationTextComponent("sp.configgui.disable_tin_ore_gen").getFormattedText(), SPConfig.disableTinOreGen.get()).setTooltip("Disable SurvivalPlus Tin Ore Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableTinOreGen.set(newValue)).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslationTextComponent("sp.configgui.disable_titanium_ore_gen").getFormattedText(), SPConfig.disableTitaniumOreGen.get()).setTooltip("Disable SurvivalPlus Titanium Ore Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableTitaniumOreGen.set(newValue)).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslationTextComponent("sp.configgui.disable_amethyst_gen").getFormattedText(), SPConfig.disableAmethystGen.get()).setTooltip("Disable SurvivalPlus Amethyst Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableAmethystGen.set(newValue)).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslationTextComponent("sp.configgui.disable_ruby_gen").getFormattedText(), SPConfig.disableRubyGen.get()).setTooltip("Disable SurvivalPlus Ruby Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableRubyGen.set(newValue)).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslationTextComponent("sp.configgui.disable_topaz_gen").getFormattedText(), SPConfig.disableTopazGen.get()).setTooltip("Disable SurvivalPlus Topaz Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableTopazGen.set(newValue)).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslationTextComponent("sp.configgui.disable_sapphire_gen").getFormattedText(), SPConfig.disableSapphireGen.get()).setTooltip("Disable SurvivalPlus Sapphire Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableSapphireGen.set(newValue)).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslationTextComponent("sp.configgui.disable_pearl_gen").getFormattedText(), SPConfig.disablePearlGen.get()).setTooltip("Disable SurvivalPlus Pearl Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disablePearlGen.set(newValue)).build());
		generation.addEntry(entryBuilder.startBooleanToggle(new TranslationTextComponent("sp.configgui.disable_spinel_gen").getFormattedText(), SPConfig.disableSpinelGen.get()).setTooltip("Disable SurvivalPlus Spinel Gen").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableSpinelGen.set(newValue)).build());

		command.addEntry(entryBuilder.startIntSlider(new TranslationTextComponent("sp.configgui.op_wak_command").getFormattedText(), SPConfig.opWak.get(), 0, 4).setTooltip("If this is set to 0 anyone can use the Wak Command").setDefaultValue(0).setSaveConsumer(newValue->SPConfig.opWak.set(newValue)).build());
		command.addEntry(entryBuilder.startBooleanToggle(new TranslationTextComponent("sp.configgui.update_check").getFormattedText(), SPConfig.disableUpdateCheck.get()).setTooltip("Disable SurvivalPlus Update Checker Message").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableUpdateCheck.set(newValue)).build());

		compatibility.addEntry(entryBuilder.startBooleanToggle(new TranslationTextComponent("sp.configgui.sun_audio").getFormattedText(), SPConfig.disableSunAudio.get()).setTooltip("Disable Sounds Played Through sun.audio").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableSunAudio.set(newValue)).build());

		command.addEntry(entryBuilder.startBooleanToggle(new TranslationTextComponent("sp.configgui.disable_thanks").getFormattedText(), SPConfig.disableThanks.get()).setTooltip("Disable SurvivalPlus Thank You Message").setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableThanks.set(newValue)).build());

		return builder.build();
	}
}
