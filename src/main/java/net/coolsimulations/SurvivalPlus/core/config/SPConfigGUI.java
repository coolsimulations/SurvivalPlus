package net.coolsimulations.SurvivalPlus.core.config;

import java.util.function.Function;

import io.github.prospector.modmenu.api.ModMenuApi;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.Screen;

@Environment(EnvType.CLIENT)
public class SPConfigGUI implements ModMenuApi {

    @Override
    public String getModId() {
        return SPReference.MOD_ID;
    }

    @Override
    public Function<Screen, ? extends Screen> getConfigScreenFactory() {
        return screen -> SurvivalPlusConfigGUI.getConfigScreen(screen);
    }
}

