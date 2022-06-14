package net.coolsimulations.SurvivalPlus.core.util;

import java.net.URL;
import java.util.Scanner;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraftforge.versions.mcp.MCPVersion;

public class SurvivalPlusUpdateHandler {
	
	private static String latestVersion;
	private static String latestVersionInfo;
	public static boolean isOld = false;
	public static MutableComponent updateInfo = null;
	public static MutableComponent updateVersionInfo = null;
	
	public static void init() {
		
		try {
            URL url = new URL("https://coolsimulations.net/mcmods/survivalplus/versionchecker119.txt");
            Scanner s = new Scanner(url.openStream());
            latestVersion = s.next();
            s.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		try {
            URL url = new URL("https://coolsimulations.net/mcmods/survivalplus/updateinfo119.txt");
            Scanner s = new Scanner(url.openStream());
            latestVersionInfo = s.nextLine();
            s.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		if(latestVersion != null) {
			
			if(latestVersion.equals("ended")) {
				
				isOld = true;
				
				MutableComponent sp = Component.translatable("sp.name");
				sp.withStyle(ChatFormatting.BLUE);
				
				MutableComponent MCVersion = Component.literal(MCPVersion.getMCVersion());
				MCVersion.withStyle(ChatFormatting.BLUE);
				
				updateInfo = Component.translatable("sp.update.display3", new Object[] {sp, MCVersion});
				updateInfo.withStyle(ChatFormatting.YELLOW);
				
			}
			
			if(!latestVersion.equals(SPReference.VERSION) && !latestVersion.equals("ended")) {
				
				isOld = true;
				
				MutableComponent sp = Component.translatable("sp.name");
				sp.withStyle(ChatFormatting.BLUE);
				
				MutableComponent version = Component.literal(latestVersion);
				version.withStyle(ChatFormatting.BLUE);
				
				updateInfo = Component.translatable("sp.update.display1", new Object[] {sp, version});
				updateInfo.withStyle(ChatFormatting.YELLOW);
				
				if(latestVersionInfo != null) {
					
					updateVersionInfo = Component.literal(latestVersionInfo);
					updateVersionInfo.withStyle(ChatFormatting.DARK_AQUA);
					updateVersionInfo.withStyle(ChatFormatting.BOLD);
					
				}
				
			}
			
		}
	}

}
