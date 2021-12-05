package net.coolsimulations.SurvivalPlus.core.compat;

import java.io.File;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.venus.VenusBlocks;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class SurvivalPlusLighting {

	public static void initSmoothEntityLight(FMLPreInitializationEvent event) {

		String itemListDefault = "torch,glowstone=12,glowstone_dust=10,lit_pumpkin,lava_bucket,redstone_torch=10,redstone=10,golden_helmet=14,easycoloredlights:easycoloredlightsCLStone=-1";

		Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "sel.cfg"));

		Property itemsList = config.get(Configuration.CATEGORY_GENERAL, "Light Items", itemListDefault);
		itemsList.setComment("Comma separated list of items that shine light when dropped in the World or held in player's or mob's hands.");

		String itemsListString = itemsList.getString();

		if(!itemsListString.contains(SPBlocks.amethyst.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.amethyst.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.ruby.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.ruby.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.pearl.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.pearl.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.topaz.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.topaz.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.sapphire.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.sapphire.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.spinel.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.spinel.getRegistryName() + "=10";
		}
		
		itemsListString += initCardboardLanterns();
		
		if(SPCompatibilityManager.isGCLoaded()) {
			if(!itemsListString.contains(GCBlocks.glowstoneTorch.getRegistryName().toString())) {
				itemsListString += "," + GCBlocks.glowstoneTorch.getRegistryName() + "=13";
			}
			if(SPCompatibilityManager.isGCPLoaded()) {
				if(!itemsListString.contains(VenusBlocks.torchWeb.getRegistryName().toString())) {
					itemsListString += "," + VenusBlocks.torchWeb.getRegistryName();
				}
			}
		}

		config.get(Configuration.CATEGORY_GENERAL, "Light Items", itemListDefault).set(itemsListString);
		config.save();

	}

	public static void initDynamicLights(FMLPreInitializationEvent event) {

		thePlayers(event);
		otherPlayers(event);
		mobEquipment(event);
		dropItems(event);
	}

	private static void otherPlayers(FMLPreInitializationEvent event) {

		String itemListDefault = "torch,glowstone=12,glowstone_dust=10,lit_pumpkin,lava_bucket,redstone_torch=10,redstone=10,golden_helmet=14";

		Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "dynamiclights_otherplayers.cfg"));

		Property itemsList = config.get(Configuration.CATEGORY_GENERAL, "LightItems", itemListDefault);
		itemsList.setComment("Item IDs that shine light while held. Armor Items also work when worn. [ONLY ON OTHERS] Syntax: ItemID[-MetaValue]:LightValue, seperated by commas");

		String itemsListString = itemsList.getString();

		if(!itemsListString.contains(SPBlocks.amethyst.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.amethyst.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.ruby.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.ruby.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.pearl.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.pearl.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.topaz.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.topaz.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.sapphire.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.sapphire.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.spinel.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.spinel.getRegistryName() + "=10";
		}

		itemsListString += initCardboardLanterns();
		
		if(SPCompatibilityManager.isGCLoaded()) {
			if(!itemsListString.contains(GCBlocks.glowstoneTorch.getRegistryName().toString())) {
				itemsListString += "," + GCBlocks.glowstoneTorch.getRegistryName() + "=13";
			}
			if(SPCompatibilityManager.isGCPLoaded()) {
				if(!itemsListString.contains(VenusBlocks.torchWeb.getRegistryName().toString())) {
					itemsListString += "," + VenusBlocks.torchWeb.getRegistryName();
				}
			}
		}

		config.get(Configuration.CATEGORY_GENERAL, "LightItems", itemListDefault).set(itemsListString);
		config.save();

	}

	private static void thePlayers(FMLPreInitializationEvent event) {

		String itemListDefault = "torch,glowstone=12,glowstone_dust=10,lit_pumpkin,lava_bucket,redstone_torch=10,redstone=10,golden_helmet=14,golden_horse_armor=15";

		Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "dynamiclights_theplayer.cfg"));

		Property itemsList = config.get(Configuration.CATEGORY_GENERAL, "LightItems", itemListDefault);
		itemsList.setComment("Item IDs that shine light while held. Armor Items also work when worn. [ONLY ON YOURSELF]");

		String itemsListString = itemsList.getString();

		if(!itemsListString.contains(SPBlocks.amethyst.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.amethyst.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.ruby.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.ruby.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.pearl.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.pearl.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.topaz.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.topaz.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.sapphire.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.sapphire.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.spinel.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.spinel.getRegistryName() + "=10";
		}
		
		itemsListString += initCardboardLanterns();

		if(SPCompatibilityManager.isGCLoaded()) {
			if(!itemsListString.contains(GCBlocks.glowstoneTorch.getRegistryName().toString())) {
				itemsListString += "," + GCBlocks.glowstoneTorch.getRegistryName() + "=13";
			}
			if(SPCompatibilityManager.isGCPLoaded()) {
				if(!itemsListString.contains(VenusBlocks.torchWeb.getRegistryName().toString())) {
					itemsListString += "," + VenusBlocks.torchWeb.getRegistryName();
				}
			}
		}

		config.get(Configuration.CATEGORY_GENERAL, "LightItems", itemListDefault).set(itemsListString);
		config.save();

	}

	private static void mobEquipment(FMLPreInitializationEvent event) {

		String itemListDefault = "torch,glowstone=12,glowstone_dust=10,lit_pumpkin,lava_bucket,redstone_torch=10,redstone=10,golden_helmet=14";

		Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "dynamiclights_mobequipment.cfg"));

		Property itemsList = config.get(Configuration.CATEGORY_GENERAL, "LightItems", itemListDefault);
		itemsList.setComment("Item and Armor IDs that shine light when found on any EntityLiving. Syntax: ItemID:LightValue, seperated by commas");

		String itemsListString = itemsList.getString();

		if(!itemsListString.contains(SPBlocks.amethyst.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.amethyst.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.ruby.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.ruby.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.pearl.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.pearl.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.topaz.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.topaz.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.sapphire.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.sapphire.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.spinel.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.spinel.getRegistryName() + "=10";
		}
		
		itemsListString += initCardboardLanterns();

		if(SPCompatibilityManager.isGCLoaded()) {
			if(!itemsListString.contains(GCBlocks.glowstoneTorch.getRegistryName().toString())) {
				itemsListString += "," + GCBlocks.glowstoneTorch.getRegistryName() + "=13";
			}
			if(SPCompatibilityManager.isGCPLoaded()) {
				if(!itemsListString.contains(VenusBlocks.torchWeb.getRegistryName().toString())) {
					itemsListString += "," + VenusBlocks.torchWeb.getRegistryName();
				}
			}
		}

		config.get(Configuration.CATEGORY_GENERAL, "LightItems", itemListDefault).set(itemsListString);
		config.save();

	}

	private static void dropItems(FMLPreInitializationEvent event) {

		String itemListDefault = "torch,glowstone=12,glowstone_dust=10,lit_pumpkin,lava_bucket,redstone_torch=10,redstone=10,golden_helmet=14";

		Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "dynamiclights_dropitems.cfg"));

		Property itemsList = config.get(Configuration.CATEGORY_GENERAL, "LightItems", itemListDefault);
		itemsList.setComment("Item IDs that shine light when dropped in the World.");

		String itemsListString = itemsList.getString();

		if(!itemsListString.contains(SPBlocks.amethyst.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.amethyst.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.ruby.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.ruby.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.pearl.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.pearl.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.topaz.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.topaz.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.sapphire.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.sapphire.getRegistryName() + "=10";
		}
		if(!itemsListString.contains(SPBlocks.spinel.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.spinel.getRegistryName() + "=10";
		}
		
		itemsListString += initCardboardLanterns();

		if(SPCompatibilityManager.isGCLoaded()) {
			if(!itemsListString.contains(GCBlocks.glowstoneTorch.getRegistryName().toString())) {
				itemsListString += "," + GCBlocks.glowstoneTorch.getRegistryName() + "=13";
			}
			if(SPCompatibilityManager.isGCPLoaded()) {
				if(!itemsListString.contains(VenusBlocks.torchWeb.getRegistryName().toString())) {
					itemsListString += "," + VenusBlocks.torchWeb.getRegistryName();
				}
			}
		}

		config.get(Configuration.CATEGORY_GENERAL, "LightItems", itemListDefault).set(itemsListString);
		config.save();

	}
	
	private static String initCardboardLanterns() {
		
		String itemsListString = "";
		
		if(!itemsListString.contains(SPBlocks.cardboard_lantern.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_black.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_black.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_blue.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_blue.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_brown.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_brown.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_cyan.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_cyan.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_green.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_green.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_grey.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_grey.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_light_blue.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_light_blue.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_light_grey.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_light_grey.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_lime.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_lime.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_magenta.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_magenta.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_orange.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_orange.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_pink.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_pink.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_purple.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_purple.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_red.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_red.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_white.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_white.getRegistryName();
		}
		if(!itemsListString.contains(SPBlocks.cardboard_lantern_yellow.getRegistryName().toString())) {
			itemsListString += "," + SPBlocks.cardboard_lantern_yellow.getRegistryName();
		}
		
		return itemsListString;
	}

}
