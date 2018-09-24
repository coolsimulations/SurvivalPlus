package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPAchievements;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class SurvivalPlusAchievements {
	
	//public Achievement achievementInstall = createAchievement("install", 0, 0, null);
	
	public static void regsiterAchievements() {
		
		SPAchievements.achievementInstall = new Achievement("achievement.sp.install", "sp.install", 0, 0, new ItemStack(SPBlocks.bronze_block), null).setSpecial();
		SPAchievements.achievementInstall.registerStat();
		
		SPAchievements.achievementCheese = new Achievement("achievement.sp.cheese", "sp.cheese", 3, -1, new ItemStack(SPItems.cheese), SPAchievements.achievementInstall).registerStat();
		SPAchievements.achievementCardboard = new Achievement("achievement.sp.cardboard", "sp.cardboard", -1, 3, new ItemStack(SPBlocks.cardboard), SPAchievements.achievementInstall).registerStat();
		SPAchievements.achievementCheeseBread = new Achievement("achievement.sp.cheesebread", "sp.cheesebread", 6, 0, new ItemStack(SPItems.melted_cheese_bread), SPAchievements.achievementCheese).registerStat();
		SPAchievements.achievementCheeseCake = new Achievement("achievement.sp.cheesecake", "sp.cheesecake", 4, -3, new ItemStack(SPBlocks.cheese_cake), SPAchievements.achievementCheese).registerStat();
		SPAchievements.achievementCampfire = new Achievement("achievement.sp.campfire", "sp.campfire", 2, 4, new ItemStack(SPBlocks.campfire), SPAchievements.achievementInstall).registerStat();
		SPAchievements.achievementCupcake = new Achievement("achievement.sp.cupcake", "sp.cupcake", 1, 2, new ItemStack(SPItems.cheese_cupcake), SPAchievements.achievementCheese).registerStat();
		
		SPAchievements.spPage = new AchievementPage(SPReference.MOD_NAME, SPAchievements.achievementInstall, SPAchievements.achievementCheese, SPAchievements.achievementCardboard, SPAchievements.achievementCheeseBread, SPAchievements.achievementCheeseCake, SPAchievements.achievementCampfire, SPAchievements.achievementCupcake);
	}
	
	public static void registerPage()
	{
		AchievementPage.registerAchievementPage(SPAchievements.spPage);
	}

}
