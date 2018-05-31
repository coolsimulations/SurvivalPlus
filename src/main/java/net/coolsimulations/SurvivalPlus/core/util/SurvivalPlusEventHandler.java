package net.coolsimulations.SurvivalPlus.core.util;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfig;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SurvivalPlusEventHandler {
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent event)
    {
        if (event.getModID().equals(SPReference.MOD_ID))
        {
            SurvivalPlusConfig.syncConfig(false);
        }
    }

}
