package net.coolsimulations.SurvivalPlus.core.util;

import java.net.URL;
import java.util.Scanner;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.versions.mcp.MCPVersion;

public class SurvivalPlusUpdateHandler {
	
	private static String latestVersion;
	private static String latestVersionInfo;
	public static boolean isOld = false;
	public static TranslationTextComponent updateInfo = null;
	public static StringTextComponent updateVersionInfo = null;
	
	public static void init() {
		
		try {
            URL url = new URL("https://coolsimulations.net/mcmods/survivalplus/versionchecker116.txt");
            Scanner s = new Scanner(url.openStream());
            latestVersion = s.next();
            s.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		try {
            URL url = new URL("https://coolsimulations.net/mcmods/survivalplus/updateinfo116.txt");
            Scanner s = new Scanner(url.openStream());
            latestVersionInfo = s.nextLine();
            s.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		if(latestVersion != null) {
			
			if(latestVersion.equals("ended")) {
				
				isOld = true;
				
				TranslationTextComponent sp = new TranslationTextComponent("sp.name");
				sp.func_240699_a_(TextFormatting.BLUE);
				
				StringTextComponent MCVersion = new StringTextComponent(MCPVersion.getMCVersion());
				MCVersion.func_240699_a_(TextFormatting.BLUE);
				
				updateInfo = new TranslationTextComponent("sp.update.display3", new Object[] {sp, MCVersion});
				updateInfo.func_240699_a_(TextFormatting.YELLOW);
				
				//updateInfo.getStyle().func_240716_a_(new HoverEvent(HoverEvent.Action.field_230550_a_, new TranslationTextComponent("sp.update.display2")));
				//updateInfo.getStyle().func_240715_a_(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus"));
				
			}
			
			if(!latestVersion.equals(SPReference.VERSION) && !latestVersion.equals("ended")) {
				
				isOld = true;
				
				TranslationTextComponent sp = new TranslationTextComponent("sp.name");
				sp.func_240699_a_(TextFormatting.BLUE);
				
				StringTextComponent version = new StringTextComponent(latestVersion);
				version.func_240699_a_(TextFormatting.BLUE);
				
				updateInfo = new TranslationTextComponent("sp.update.display1", new Object[] {sp, version});
				updateInfo.func_240699_a_(TextFormatting.YELLOW);
				
				//updateInfo.getStyle().func_240716_a_(new HoverEvent(HoverEvent.Action.field_230550_a_, new TranslationTextComponent("sp.update.display2")));
				//updateInfo.getStyle().func_240715_a_(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus"));
				
				if(latestVersionInfo != null) {
					
					updateVersionInfo = new StringTextComponent(latestVersionInfo);
					updateVersionInfo.func_240699_a_(TextFormatting.DARK_AQUA);
					updateVersionInfo.func_240699_a_(TextFormatting.BOLD);
					
					//updateVersionInfo.getStyle().func_240716_a_(new HoverEvent(HoverEvent.Action.field_230550_a_, new TranslationTextComponent("sp.update.display2")));
					//updateVersionInfo.getStyle().func_240715_a_(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus"));
					
				}
				
			}
			
		}
	}

}
