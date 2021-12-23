package net.coolsimulations.SurvivalPlus.core.util;

import java.net.URL;
import java.util.Scanner;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.versions.mcp.MCPVersion;

public class SurvivalPlusUpdateHandler {
	
	private static String latestVersion;
	private static String latestVersionInfo;
	public static boolean isOld = false;
	public static TranslatableComponent updateInfo = null;
	public static TextComponent updateVersionInfo = null;
	
	public static void init() {
		
		try {
            URL url = new URL("https://coolsimulations.net/mcmods/survivalplus/versionchecker118.txt");
            Scanner s = new Scanner(url.openStream());
            latestVersion = s.next();
            s.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		try {
            URL url = new URL("https://coolsimulations.net/mcmods/survivalplus/updateinfo118.txt");
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
				
				TextComponent MCVersion = new TextComponent(MCPVersion.getMCVersion());
				MCVersion.withStyle(ChatFormatting.BLUE);
				
				updateInfo = new TranslatableComponent("sp.update.display3", new Object[] {sp, MCVersion});
				updateInfo.withStyle(ChatFormatting.YELLOW);
				
			}
			
			if(!latestVersion.equals(SPReference.VERSION) && !latestVersion.equals("ended")) {
				
				isOld = true;
				
				TranslatableComponent sp = new TranslatableComponent("sp.name");
				sp.withStyle(ChatFormatting.BLUE);
				
				TextComponent version = new TextComponent(latestVersion);
				version.withStyle(ChatFormatting.BLUE);
				
				updateInfo = new TranslatableComponent("sp.update.display1", new Object[] {sp, version});
				updateInfo.withStyle(ChatFormatting.YELLOW);
				
				if(latestVersionInfo != null) {
					
					updateVersionInfo = new TextComponent(latestVersionInfo);
					updateVersionInfo.withStyle(ChatFormatting.DARK_AQUA);
					updateVersionInfo.withStyle(ChatFormatting.BOLD);
					
				}
				
			}
			
		}
	}

}
