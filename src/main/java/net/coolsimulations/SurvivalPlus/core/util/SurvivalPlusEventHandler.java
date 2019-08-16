package net.coolsimulations.SurvivalPlus.core.util;

import net.coolsimulations.SurvivalPlus.api.SPAchievements;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.oredict.OreDictionary;

public class SurvivalPlusEventHandler {
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent event)
    {
        if (event.getModID().equals(SPReference.MOD_ID))
        {
            SurvivalPlusConfig.syncConfig(false);
        }
    }
	
	@SubscribeEvent
	public void onplayerLogin(PlayerLoggedInEvent event)
    {
		EntityPlayer player = (EntityPlayer) event.player;
		
        if (!player.hasAchievement(SPAchievements.achievementInstall))
        {
            player.addStat(SPAchievements.achievementInstall);
            
            if(!player.worldObj.isRemote) {
            	
            	TextComponentTranslation installInfo = new TextComponentTranslation("achievement.sp.install.display1");
            	installInfo.getStyle().setColor(TextFormatting.GOLD);
            	installInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentTranslation("achievement.sp.install.display2")));
            	installInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus"));
								player.addChatMessage(installInfo);
            	
            }
        }
        
        if(SurvivalPlusUpdateHandler.isOld == true && SPConfig.disableUpdateCheck == false) {
        	player.addChatMessage(SurvivalPlusUpdateHandler.updateInfo);
        }
    }
	
	@SubscribeEvent
	public void onCrafted(ItemCraftedEvent event)
	{
		EntityPlayer player = (EntityPlayer) event.player;
		Item item = event.crafting.getItem();
		
		for(ItemStack stack : OreDictionary.getOres("foodCheese")) {
			
			if(!player.hasAchievement(SPAchievements.achievementCheese) && stack.getItem() == item) {
				player.addStat(SPAchievements.achievementCheese);
			}
		}
		
		for(ItemStack stack : OreDictionary.getOres("blockCardboard")) {
			
			if(!player.hasAchievement(SPAchievements.achievementCardboard) && stack.getItem() == item) {
				player.addStat(SPAchievements.achievementCardboard);
			}
		}
		
		for(ItemStack stack : OreDictionary.getOres("foodCheesecake")) {
			
			if(!player.hasAchievement(SPAchievements.achievementCheeseCake) && stack.getItem() == item) {
				player.addStat(SPAchievements.achievementCheeseCake);
			}
		}
		
		for(ItemStack stack : OreDictionary.getOres("foodCheesecupcake")) {
			
			if(!player.hasAchievement(SPAchievements.achievementCupcake) && stack.getItem() == item) {
				player.addStat(SPAchievements.achievementCupcake);
			}
		}
	}
	
	@SubscribeEvent
	public void onSmelted(ItemSmeltedEvent event)
	{
		EntityPlayer player = (EntityPlayer) event.player;
		Item item = event.smelting.getItem();
		
		for(ItemStack stack : OreDictionary.getOres("foodCheese")) {
			
			if(!player.hasAchievement(SPAchievements.achievementCheese) && stack.getItem() == item) {
				player.addStat(SPAchievements.achievementCheese);
			}
		}
		
		for(ItemStack stack : OreDictionary.getOres("foodMeltedCheesebread")) {
			
			if(!player.hasAchievement(SPAchievements.achievementCheeseBread) && stack.getItem() == item) {
				player.addStat(SPAchievements.achievementCheeseBread);
			}
		}
	}

}
