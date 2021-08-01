package net.coolsimulations.SurvivalPlus.core.util;

import java.net.URL;
import java.util.Scanner;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.ChatFormatting;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;

public class SurvivalPlusUpdateHandler {
	
	private static String latestVersion;
	private static String latestVersionInfo;
	public static boolean isOld = false;
	public static TranslatableComponent updateInfo = null;
	public static TextComponent updateVersionInfo = null;
	
	public static void init() {
		
		try {
            URL url = new URL("https://coolsimulations.net/mcmods/survivalplus-fabric/versionchecker117.txt");
            Scanner s = new Scanner(url.openStream());
            latestVersion = s.next();
            s.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		try {
            URL url = new URL("https://coolsimulations.net/mcmods/survivalplus-fabric/updateinfo117.txt");
            Scanner s = new Scanner(url.openStream());
            latestVersionInfo = s.nextLine();
            s.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		if(latestVersion != null) {
			
			if(latestVersion.equals("ended")) {
				
				isOld = true;
				
				TranslatableComponent sp = new TranslatableComponent("sp.name");
				sp.withStyle(ChatFormatting.BLUE);
				
				TextComponent MCVersion = new TextComponent(SharedConstants.getCurrentVersion().getName());
				MCVersion.withStyle(ChatFormatting.BLUE);
				
				updateInfo = new TranslatableComponent("sp.update.display3", new Object[] {sp, MCVersion});
				updateInfo.withStyle(ChatFormatting.YELLOW);
				
				//updateInfo.getStyle().withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("sp.update.display2")));
				//updateInfo.getStyle().withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus-fabric"));
				
			}
			
			if(!latestVersion.equals(SPReference.VERSION) && !latestVersion.equals("ended")) {
				
				isOld = true;
				
				TranslatableComponent sp = new TranslatableComponent("sp.name");
				sp.withStyle(ChatFormatting.BLUE);
				
				TextComponent version = new TextComponent(latestVersion);
				version.withStyle(ChatFormatting.BLUE);
				
				updateInfo = new TranslatableComponent("sp.update.display1", new Object[] {sp, version});
				updateInfo.withStyle(ChatFormatting.YELLOW);
				
				//updateInfo.getStyle().withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("sp.update.display2")));
				//updateInfo.getStyle().withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus-fabric"));
				
				if(latestVersionInfo != null) {
					
					updateVersionInfo = new TextComponent(latestVersionInfo);
					updateVersionInfo.withStyle(ChatFormatting.DARK_AQUA, ChatFormatting.BOLD);
					
					//updateVersionInfo.getStyle().withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("sp.update.display2")));
					//updateVersionInfo.getStyle().withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus-fabric"));
					
				}
				
			}
			
		}
	}

}
