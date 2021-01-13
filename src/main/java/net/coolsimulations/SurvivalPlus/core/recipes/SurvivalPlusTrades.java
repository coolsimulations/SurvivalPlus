package net.coolsimulations.SurvivalPlus.core.recipes;

import java.util.Map.Entry;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.coolsimulations.SurvivalPlus.api.recipes.SPTradeRecipes;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import net.minecraft.village.TradeOffers.Factory;

public class SurvivalPlusTrades {
	
	public static void initVillagerTrades() {

		for(Entry<VillagerProfession, Int2ObjectMap<Factory[]>> trades : TradeOffers.PROFESSION_TO_LEVELED_TRADE.entrySet()) {

			if(trades.getKey() == VillagerProfession.ARMORER) {
				addVillagerFactory(VillagerProfession.ARMORER, trades);
			}

			if(trades.getKey() == VillagerProfession.BUTCHER) {
				addVillagerFactory(VillagerProfession.BUTCHER, trades);
			}

			if(trades.getKey() == VillagerProfession.CARTOGRAPHER) {
				addVillagerFactory(VillagerProfession.CARTOGRAPHER, trades);
			}
			
			if(trades.getKey() == VillagerProfession.CLERIC) {
				addVillagerFactory(VillagerProfession.CLERIC, trades);
			}
			
			if(trades.getKey() == VillagerProfession.FARMER) {
				addVillagerFactory(VillagerProfession.FARMER, trades);
			}
			
			if(trades.getKey() == VillagerProfession.FISHERMAN) {
				addVillagerFactory(VillagerProfession.FISHERMAN, trades);
			}
			
			if(trades.getKey() == VillagerProfession.FLETCHER) {
				addVillagerFactory(VillagerProfession.FLETCHER, trades);
			}
			
			if(trades.getKey() == VillagerProfession.LEATHERWORKER) {
				addVillagerFactory(VillagerProfession.LEATHERWORKER, trades);
			}
			
			if(trades.getKey() == VillagerProfession.LIBRARIAN) {
				addVillagerFactory(VillagerProfession.LIBRARIAN, trades);
			}
			
			if(trades.getKey() == VillagerProfession.MASON) {
				addVillagerFactory(VillagerProfession.MASON, trades);
			}
			
			if(trades.getKey() == VillagerProfession.SHEPHERD) {
				addVillagerFactory(VillagerProfession.SHEPHERD, trades);
			}
			
			if(trades.getKey() == VillagerProfession.TOOLSMITH) {
				addVillagerFactory(VillagerProfession.TOOLSMITH, trades);
			}
			
			if(trades.getKey() == VillagerProfession.WEAPONSMITH) {
				addVillagerFactory(VillagerProfession.WEAPONSMITH, trades);
			}
		}
		
		for(Entry<Integer, Factory[]> trades : TradeOffers.WANDERING_TRADER_TRADES.int2ObjectEntrySet()) {
			for(Factory factory : trades.getValue()) {
				SPTradeRecipes.addWanderingBasicRecipe(factory);
			}
		}
	}
	
	private static void addVillagerFactory(VillagerProfession profession, Entry<VillagerProfession, Int2ObjectMap<Factory[]>> trades) {
		for(Factory factory : trades.getValue().get(1)) {
			SPTradeRecipes.getListForProfessionAndLevel(profession, SPTradeRecipes.VillagerLevel.NOVICE).add(factory);
		}
		for(Factory factory : trades.getValue().get(2)) {
			SPTradeRecipes.getListForProfessionAndLevel(profession, SPTradeRecipes.VillagerLevel.APPRENTICE).add(factory);
		}
		for(Factory factory : trades.getValue().get(3)) {
			SPTradeRecipes.getListForProfessionAndLevel(profession, SPTradeRecipes.VillagerLevel.JOURNEYMAN).add(factory);
		}
		for(Factory factory : trades.getValue().get(4)) {
			SPTradeRecipes.getListForProfessionAndLevel(profession, SPTradeRecipes.VillagerLevel.EXPERT).add(factory);
		}
		for(Factory factory : trades.getValue().get(5)) {
			SPTradeRecipes.getListForProfessionAndLevel(profession, SPTradeRecipes.VillagerLevel.MASTER).add(factory);
		}
	}

}
