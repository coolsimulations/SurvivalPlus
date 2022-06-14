package net.coolsimulations.SurvivalPlus.core.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SurvivalPlusConfigGUI {

	public static Screen getConfigScreen(Screen parent)
	{
		ConfigBuilder builder = ConfigBuilder.create()
				.setParentScreen(parent)
				.setTitle(Component.translatable("sp.configgui.title"));

		builder.setSavingRunnable(() -> {
			SurvivalPlusConfig.commonSpec.save();
		});

		builder.setDefaultBackgroundTexture(new ResourceLocation(SPReference.MOD_ID + ":textures/blocks/bronze_block.png"));

		ConfigCategory generation = builder.getOrCreateCategory(Component.translatable("sp.configgui.generation"));
		ConfigCategory command = builder.getOrCreateCategory(Component.translatable("sp.configgui.command"));
		ConfigCategory compatibility = builder.getOrCreateCategory(Component.translatable("sp.configgui.compatibility"));
		ConfigEntryBuilder entryBuilder = builder.entryBuilder();

		generation.addEntry(entryBuilder.startBooleanToggle(Component.translatable("sp.configgui.disable_tin_ore_gen"), SPConfig.disableTinOreGen.get()).setTooltip(Component.translatable("sp.configgui.disable_tin_ore_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableTinOreGen.set(newValue)).build());
		generation.addEntry(entryBuilder.startBooleanToggle(Component.translatable("sp.configgui.disable_titanium_ore_gen"), SPConfig.disableTitaniumOreGen.get()).setTooltip(Component.translatable("sp.configgui.disable_titanium_ore_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableTitaniumOreGen.set(newValue)).build());
		generation.addEntry(entryBuilder.startBooleanToggle(Component.translatable("sp.configgui.disable_ruby_gen"), SPConfig.disableRubyGen.get()).setTooltip(Component.translatable("sp.configgui.disable_ruby_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableRubyGen.set(newValue)).build());
		generation.addEntry(entryBuilder.startBooleanToggle(Component.translatable("sp.configgui.disable_topaz_gen"), SPConfig.disableTopazGen.get()).setTooltip(Component.translatable("sp.configgui.disable_topaz_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableTopazGen.set(newValue)).build());
		generation.addEntry(entryBuilder.startBooleanToggle(Component.translatable("sp.configgui.disable_sapphire_gen"), SPConfig.disableSapphireGen.get()).setTooltip(Component.translatable("sp.configgui.disable_sapphire_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableSapphireGen.set(newValue)).build());
		generation.addEntry(entryBuilder.startBooleanToggle(Component.translatable("sp.configgui.disable_pearl_gen"), SPConfig.disablePearlGen.get()).setTooltip(Component.translatable("sp.configgui.disable_pearl_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disablePearlGen.set(newValue)).build());
		generation.addEntry(entryBuilder.startBooleanToggle(Component.translatable("sp.configgui.disable_spinel_gen"), SPConfig.disableSpinelGen.get()).setTooltip(Component.translatable("sp.configgui.disable_spinel_gen")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableSpinelGen.set(newValue)).build());

		command.addEntry(entryBuilder.startIntSlider(Component.translatable("sp.configgui.op_wak_command"), SPConfig.opWak.get(), 0, 4).setTooltip(Component.translatable("sp.configgui.op_wak_command")).setDefaultValue(0).setSaveConsumer(newValue->SPConfig.opWak.set(newValue)).build());
		command.addEntry(entryBuilder.startBooleanToggle(Component.translatable("sp.configgui.update_check"), SPConfig.disableUpdateCheck.get()).setTooltip(Component.translatable("sp.configgui.update_check")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableUpdateCheck.set(newValue)).build());

		compatibility.addEntry(entryBuilder.startBooleanToggle(Component.translatable("sp.configgui.client_audio"), SPConfig.disableClientAudio.get()).setTooltip(Component.translatable("sp.configgui.client_audio")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableClientAudio.set(newValue)).build());

		command.addEntry(entryBuilder.startBooleanToggle(Component.translatable("sp.configgui.disable_thanks"), SPConfig.disableThanks.get()).setTooltip(Component.translatable("sp.configgui.disable_thanks")).setDefaultValue(false).setSaveConsumer(newValue->SPConfig.disableThanks.set(newValue)).build());

		return builder.build();
	}
}
