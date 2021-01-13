package net.coolsimulations.SurvivalPlus.api.recipes;

import com.google.common.collect.ImmutableMap;

import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradeOffers.Factory;
import net.minecraft.village.VillagerProfession;

public class SPTrades {
	
	/**
	 * @apiNote
	 * Call this method after registering trade recipes to update the TradeOffers List
	 */
	public static void postInitVillagerTrades() {
		
		Factory[] armorer_novice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.ARMORER, 1).toArray(new Factory[0]);
		Factory[] armorer_apprentice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.ARMORER, 2).toArray(new Factory[0]);
		Factory[] armorer_journeyman = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.ARMORER, 3).toArray(new Factory[0]);
		Factory[] armorer_expert = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.ARMORER, 4).toArray(new Factory[0]);
		Factory[] armorer_master = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.ARMORER, 5).toArray(new Factory[0]);
		TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.ARMORER, SPTradeRecipes.copyToFastUtilMap(ImmutableMap.of(1, armorer_novice, 2, armorer_apprentice, 3, armorer_journeyman, 4, armorer_expert, 5, armorer_master)));
		
		Factory[] butcher_novice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.BUTCHER, 1).toArray(new Factory[0]);
		Factory[] butcher_apprentice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.BUTCHER, 2).toArray(new Factory[0]);
		Factory[] butcher_journeyman = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.BUTCHER, 3).toArray(new Factory[0]);
		Factory[] butcher_expert = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.BUTCHER, 4).toArray(new Factory[0]);
		Factory[] butcher_master = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.BUTCHER, 5).toArray(new Factory[0]);
		TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.BUTCHER, SPTradeRecipes.copyToFastUtilMap(ImmutableMap.of(1, butcher_novice, 2, butcher_apprentice, 3, butcher_journeyman, 4, butcher_expert, 5, butcher_master)));
		
		Factory[] cartographer_novice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.CARTOGRAPHER, 1).toArray(new Factory[0]);
		Factory[] cartographer_apprentice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.CARTOGRAPHER, 2).toArray(new Factory[0]);
		Factory[] cartographer_journeyman = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.CARTOGRAPHER, 3).toArray(new Factory[0]);
		Factory[] cartographer_expert = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.CARTOGRAPHER, 4).toArray(new Factory[0]);
		Factory[] cartographer_master = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.CARTOGRAPHER, 5).toArray(new Factory[0]);
		TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.CARTOGRAPHER, SPTradeRecipes.copyToFastUtilMap(ImmutableMap.of(1, cartographer_novice, 2, cartographer_apprentice, 3, cartographer_journeyman, 4, cartographer_expert, 5, cartographer_master)));
		
		Factory[] cleric_novice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.CLERIC, 1).toArray(new Factory[0]);
		Factory[] cleric_apprentice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.CLERIC, 2).toArray(new Factory[0]);
		Factory[] cleric_journeyman = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.CLERIC, 3).toArray(new Factory[0]);
		Factory[] cleric_expert = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.CLERIC, 4).toArray(new Factory[0]);
		Factory[] cleric_master = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.CLERIC, 5).toArray(new Factory[0]);
		TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.CLERIC, SPTradeRecipes.copyToFastUtilMap(ImmutableMap.of(1, cleric_novice, 2, cleric_apprentice, 3, cleric_journeyman, 4, cleric_expert, 5, cleric_master)));
		
		Factory[] farmer_novice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FARMER, 1).toArray(new Factory[0]);
		Factory[] farmer_apprentice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FARMER, 2).toArray(new Factory[0]);
		Factory[] farmer_journeyman = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FARMER, 3).toArray(new Factory[0]);
		Factory[] farmer_expert = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FARMER, 4).toArray(new Factory[0]);
		Factory[] farmer_master = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FARMER, 5).toArray(new Factory[0]);
		TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.FARMER, SPTradeRecipes.copyToFastUtilMap(ImmutableMap.of(1, farmer_novice, 2, farmer_apprentice, 3, farmer_journeyman, 4, farmer_expert, 5, farmer_master)));
		
		Factory[] fisherman_novice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FISHERMAN, 1).toArray(new Factory[0]);
		Factory[] fisherman_apprentice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FISHERMAN, 2).toArray(new Factory[0]);
		Factory[] fisherman_journeyman = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FISHERMAN, 3).toArray(new Factory[0]);
		Factory[] fisherman_expert = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FISHERMAN, 4).toArray(new Factory[0]);
		Factory[] fisherman_master = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FISHERMAN, 5).toArray(new Factory[0]);
		TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.FISHERMAN, SPTradeRecipes.copyToFastUtilMap(ImmutableMap.of(1, fisherman_novice, 2, fisherman_apprentice, 3, fisherman_journeyman, 4, fisherman_expert, 5, fisherman_master)));
		
		Factory[] fletcher_novice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FLETCHER, 1).toArray(new Factory[0]);
		Factory[] fletcher_apprentice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FLETCHER, 2).toArray(new Factory[0]);
		Factory[] fletcher_journeyman = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FLETCHER, 3).toArray(new Factory[0]);
		Factory[] fletcher_expert = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FLETCHER, 4).toArray(new Factory[0]);
		Factory[] fletcher_master = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.FLETCHER, 5).toArray(new Factory[0]);
		TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.FLETCHER, SPTradeRecipes.copyToFastUtilMap(ImmutableMap.of(1, fletcher_novice, 2, fletcher_apprentice, 3, fletcher_journeyman, 4, fletcher_expert, 5, fletcher_master)));
		
		Factory[] leatherworker_novice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.LEATHERWORKER, 1).toArray(new Factory[0]);
		Factory[] leatherworker_apprentice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.LEATHERWORKER, 2).toArray(new Factory[0]);
		Factory[] leatherworker_journeyman = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.LEATHERWORKER, 3).toArray(new Factory[0]);
		Factory[] leatherworker_expert = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.LEATHERWORKER, 4).toArray(new Factory[0]);
		Factory[] leatherworker_master = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.LEATHERWORKER, 5).toArray(new Factory[0]);
		TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.LEATHERWORKER, SPTradeRecipes.copyToFastUtilMap(ImmutableMap.of(1, leatherworker_novice, 2, leatherworker_apprentice, 3, leatherworker_journeyman, 4, leatherworker_expert, 5, leatherworker_master)));
		
		Factory[] librarian_novice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.LIBRARIAN, 1).toArray(new Factory[0]);
		Factory[] librarian_apprentice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.LIBRARIAN, 2).toArray(new Factory[0]);
		Factory[] librarian_journeyman = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.LIBRARIAN, 3).toArray(new Factory[0]);
		Factory[] librarian_expert = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.LIBRARIAN, 4).toArray(new Factory[0]);
		Factory[] librarian_master = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.LIBRARIAN, 5).toArray(new Factory[0]);
		TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.LIBRARIAN, SPTradeRecipes.copyToFastUtilMap(ImmutableMap.of(1, librarian_novice, 2, librarian_apprentice, 3, librarian_journeyman, 4, librarian_expert, 5, librarian_master)));
		
		Factory[] mason_novice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.MASON, 1).toArray(new Factory[0]);
		Factory[] mason_apprentice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.MASON, 2).toArray(new Factory[0]);
		Factory[] mason_journeyman = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.MASON, 3).toArray(new Factory[0]);
		Factory[] mason_expert = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.MASON, 4).toArray(new Factory[0]);
		Factory[] mason_master = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.MASON, 5).toArray(new Factory[0]);
		TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.MASON, SPTradeRecipes.copyToFastUtilMap(ImmutableMap.of(1, mason_novice, 2, mason_apprentice, 3, mason_journeyman, 4, mason_expert, 5, mason_master)));
		
		Factory[] shepherd_novice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.SHEPHERD, 1).toArray(new Factory[0]);
		Factory[] shepherd_apprentice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.SHEPHERD, 2).toArray(new Factory[0]);
		Factory[] shepherd_journeyman = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.SHEPHERD, 3).toArray(new Factory[0]);
		Factory[] shepherd_expert = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.SHEPHERD, 4).toArray(new Factory[0]);
		Factory[] shepherd_master = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.SHEPHERD, 5).toArray(new Factory[0]);
		TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.SHEPHERD, SPTradeRecipes.copyToFastUtilMap(ImmutableMap.of(1, shepherd_novice, 2, shepherd_apprentice, 3, shepherd_journeyman, 4, shepherd_expert, 5, shepherd_master)));
		
		Factory[] toolsmith_novice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.TOOLSMITH, 1).toArray(new Factory[0]);
		Factory[] toolsmith_apprentice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.TOOLSMITH, 2).toArray(new Factory[0]);
		Factory[] toolsmith_journeyman = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.TOOLSMITH, 3).toArray(new Factory[0]);
		Factory[] toolsmith_expert = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.TOOLSMITH, 4).toArray(new Factory[0]);
		Factory[] toolsmith_master = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.TOOLSMITH, 5).toArray(new Factory[0]);
		TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.TOOLSMITH, SPTradeRecipes.copyToFastUtilMap(ImmutableMap.of(1, toolsmith_novice, 2, toolsmith_apprentice, 3, toolsmith_journeyman, 4, toolsmith_expert, 5, toolsmith_master)));
		
		Factory[] weaponsmith_novice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.WEAPONSMITH, 1).toArray(new Factory[0]);
		Factory[] weaponsmith_apprentice = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.WEAPONSMITH, 2).toArray(new Factory[0]);
		Factory[] weaponsmith_journeyman = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.WEAPONSMITH, 3).toArray(new Factory[0]);
		Factory[] weaponsmith_expert = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.WEAPONSMITH, 4).toArray(new Factory[0]);
		Factory[] weaponsmith_master = SPTradeRecipes.getListForProfessionAndLevel(VillagerProfession.WEAPONSMITH, 5).toArray(new Factory[0]);
		TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.WEAPONSMITH, SPTradeRecipes.copyToFastUtilMap(ImmutableMap.of(1, weaponsmith_novice, 2, weaponsmith_apprentice, 3, weaponsmith_journeyman, 4, weaponsmith_expert, 5, weaponsmith_master)));
		
		Factory[] wander_trader = SPTradeRecipes.wandering_trader.toArray(new Factory[0]);
		TradeOffers.WANDERING_TRADER_TRADES.put(1, wander_trader);
		
	}

}
