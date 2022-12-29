package net.coolsimulations.SurvivalPlus.core.compat;

import java.io.File;

import c4.creaturebeacons.core.ConfigHandler;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class SurvivalPlusBeaconsForAll {

	public static Configuration config;

	public static void initBeaconsForAll(FMLPreInitializationEvent event) {

		config = new Configuration(new File(event.getModConfigurationDirectory(), "creaturebeacons.cfg"));
	}
	
	public static boolean isValidCreature(EntityLivingBase entityLivingBase) {
		boolean flag1 = false;

		String desc = "Set which creatures can be affected by beacons\nValid values:\nALL_TAMED\nALL_PASSIVE\nALL";
		Property creatureType = config.get(Configuration.CATEGORY_GENERAL, "Creature Type", "ALL_TAMED", desc);

		if (creatureType.getString().equals("ALL_TAMED"))
			flag1 = entityLivingBase instanceof EntityTameable && ((EntityTameable) entityLivingBase).isTamed();
		else if (creatureType.getString().equals("ALL_PASSIVE"))
			flag1 = entityLivingBase instanceof IAnimals && !(entityLivingBase instanceof IMob);
		else
			flag1 = true;

		ResourceLocation rl = EntityList.getKey(entityLivingBase);
		boolean flag2 = false;

		if (rl != null) {

			for (String s : ConfigHandler.creatureList) {

				if (s.equals(rl.toString())) {
					flag2 = true;
					break;
				}
			}
		}
		return flag1 || flag2;
	}
}
