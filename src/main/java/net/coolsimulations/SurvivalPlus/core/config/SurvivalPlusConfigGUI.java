package net.coolsimulations.SurvivalPlus.core.config;

import java.util.Set;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;

public class SurvivalPlusConfigGUI implements IModGuiFactory {
	
	public static class SPConfigGUI extends GuiConfig
    {
        public SPConfigGUI(GuiScreen parent)
        {
            super(parent, SurvivalPlusConfig.getConfigElements(), SPReference.MOD_ID, false, false, I18n.translateToLocal("sp.configgui.title"));
        }
    }

    @Override
    public void initialize(Minecraft minecraftInstance)
    {

    }

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass()
    {
        return SPConfigGUI.class;
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
    {
        return null;
    }

    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element)
    {
        return null;
    }

	public GuiScreen createConfigGui(GuiScreen arg0)
	{
		// TODO  Forge 2282 addition!
		return new SPConfigGUI(arg0);
	}

	public boolean hasConfigGui()
	{
		return true;
	}

}
