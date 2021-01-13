package net.coolsimulations.SurvivalPlus.api.recipes;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableMap;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.village.TradeOffers.Factory;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

public class SPTradeRecipes {

	private static List<Factory> armorer_novice = new ArrayList<Factory>();
	private static List<Factory> armorer_apprentice = new ArrayList<Factory>();
	private static List<Factory> armorer_journeyman = new ArrayList<Factory>();
	private static List<Factory> armorer_expert = new ArrayList<Factory>();
	private static List<Factory> armorer_master = new ArrayList<Factory>();

	private static List<Factory> butcher_novice = new ArrayList<Factory>();
	private static List<Factory> butcher_apprentice = new ArrayList<Factory>();
	private static List<Factory> butcher_journeyman = new ArrayList<Factory>();
	private static List<Factory> butcher_expert = new ArrayList<Factory>();
	private static List<Factory> butcher_master = new ArrayList<Factory>();

	private static List<Factory> cartographer_novice = new ArrayList<Factory>();
	private static List<Factory> cartographer_apprentice = new ArrayList<Factory>();
	private static List<Factory> cartographer_journeyman = new ArrayList<Factory>();
	private static List<Factory> cartographer_expert = new ArrayList<Factory>();
	private static List<Factory> cartographer_master = new ArrayList<Factory>();

	private static List<Factory> cleric_novice = new ArrayList<Factory>();
	private static List<Factory> cleric_apprentice = new ArrayList<Factory>();
	private static List<Factory> cleric_journeyman = new ArrayList<Factory>();
	private static List<Factory> cleric_expert = new ArrayList<Factory>();
	private static List<Factory> cleric_master = new ArrayList<Factory>();

	private static List<Factory> farmer_novice = new ArrayList<Factory>();
	private static List<Factory> farmer_apprentice = new ArrayList<Factory>();
	private static List<Factory> farmer_journeyman = new ArrayList<Factory>();
	private static List<Factory> farmer_expert = new ArrayList<Factory>();
	private static List<Factory> farmer_master = new ArrayList<Factory>();

	private static List<Factory> fisherman_novice = new ArrayList<Factory>();
	private static List<Factory> fisherman_apprentice = new ArrayList<Factory>();
	private static List<Factory> fisherman_journeyman = new ArrayList<Factory>();
	private static List<Factory> fisherman_expert = new ArrayList<Factory>();
	private static List<Factory> fisherman_master = new ArrayList<Factory>();

	private static List<Factory> fletcher_novice = new ArrayList<Factory>();
	private static List<Factory> fletcher_apprentice = new ArrayList<Factory>();
	private static List<Factory> fletcher_journeyman = new ArrayList<Factory>();
	private static List<Factory> fletcher_expert = new ArrayList<Factory>();
	private static List<Factory> fletcher_master = new ArrayList<Factory>();

	private static List<Factory> leatherworker_novice = new ArrayList<Factory>();
	private static List<Factory> leatherworker_apprentice = new ArrayList<Factory>();
	private static List<Factory> leatherworker_journeyman = new ArrayList<Factory>();
	private static List<Factory> leatherworker_expert = new ArrayList<Factory>();
	private static List<Factory> leatherworker_master = new ArrayList<Factory>();

	private static List<Factory> librarian_novice = new ArrayList<Factory>();
	private static List<Factory> librarian_apprentice = new ArrayList<Factory>();
	private static List<Factory> librarian_journeyman = new ArrayList<Factory>();
	private static List<Factory> librarian_expert = new ArrayList<Factory>();
	private static List<Factory> librarian_master = new ArrayList<Factory>();

	private static List<Factory> mason_novice = new ArrayList<Factory>();
	private static List<Factory> mason_apprentice = new ArrayList<Factory>();
	private static List<Factory> mason_journeyman = new ArrayList<Factory>();
	private static List<Factory> mason_expert = new ArrayList<Factory>();
	private static List<Factory> mason_master = new ArrayList<Factory>();

	private static List<Factory> shepherd_novice = new ArrayList<Factory>();
	private static List<Factory> shepherd_apprentice = new ArrayList<Factory>();
	private static List<Factory> shepherd_journeyman = new ArrayList<Factory>();
	private static List<Factory> shepherd_expert = new ArrayList<Factory>();
	private static List<Factory> shepherd_master = new ArrayList<Factory>();

	private static List<Factory> toolsmith_novice = new ArrayList<Factory>();
	private static List<Factory> toolsmith_apprentice = new ArrayList<Factory>();
	private static List<Factory> toolsmith_journeyman = new ArrayList<Factory>();
	private static List<Factory> toolsmith_expert = new ArrayList<Factory>();
	private static List<Factory> toolsmith_master = new ArrayList<Factory>();

	private static List<Factory> weaponsmith_novice = new ArrayList<Factory>();
	private static List<Factory> weaponsmith_apprentice = new ArrayList<Factory>();
	private static List<Factory> weaponsmith_journeyman = new ArrayList<Factory>();
	private static List<Factory> weaponsmith_expert = new ArrayList<Factory>();
	private static List<Factory> weaponsmith_master = new ArrayList<Factory>();
	
	public static List<Factory> wandering_trader = new ArrayList<Factory>();

	public static void addBasicRecipe(VillagerProfession profession, VillagerLevel level, TradeOffers.Factory trade) {

		getListForProfessionAndLevel(profession, level).add(trade);
	}
	
	public static void addWanderingBasicRecipe(TradeOffers.Factory trade) {

		wandering_trader.add(trade);
	}

	public static List<Factory> getListForProfessionAndLevel(VillagerProfession profession, int level) {
		return getListForProfessionAndLevel(profession, VillagerLevel.getIDByLevel(level));
	}

	public static List<Factory> getListForProfessionAndLevel(VillagerProfession profession, VillagerLevel level) {

		if(profession == VillagerProfession.ARMORER) {
			switch (level) {
			case NOVICE:
				return armorer_novice;
			case APPRENTICE:
				return armorer_apprentice;
			case JOURNEYMAN:
				return armorer_journeyman;
			case EXPERT:
				return armorer_expert;
			case MASTER:
				return armorer_master;
			}
		}

		if(profession == VillagerProfession.BUTCHER) {
			switch (level) {
			case NOVICE:
				return butcher_novice;
			case APPRENTICE:
				return butcher_apprentice;
			case JOURNEYMAN:
				return butcher_journeyman;
			case EXPERT:
				return butcher_expert;
			case MASTER:
				return butcher_master;
			}
		}

		if(profession == VillagerProfession.CARTOGRAPHER) {
			switch (level) {
			case NOVICE:
				return cartographer_novice;
			case APPRENTICE:
				return cartographer_apprentice;
			case JOURNEYMAN:
				return cartographer_journeyman;
			case EXPERT:
				return cartographer_expert;
			case MASTER:
				return cartographer_master;
			}
		}

		if(profession == VillagerProfession.CLERIC) {
			switch (level) {
			case NOVICE:
				return cleric_novice;
			case APPRENTICE:
				return cleric_apprentice;
			case JOURNEYMAN:
				return cleric_journeyman;
			case EXPERT:
				return cleric_expert;
			case MASTER:
				return cleric_master;
			}
		}

		if(profession == VillagerProfession.FARMER) {
			switch (level) {
			case NOVICE:
				return farmer_novice;
			case APPRENTICE:
				return farmer_apprentice;
			case JOURNEYMAN:
				return farmer_journeyman;
			case EXPERT:
				return farmer_expert;
			case MASTER:
				return farmer_master;
			}
		}

		if(profession == VillagerProfession.FISHERMAN) {
			switch (level) {
			case NOVICE:
				return fisherman_novice;
			case APPRENTICE:
				return fisherman_apprentice;
			case JOURNEYMAN:
				return fisherman_journeyman;
			case EXPERT:
				return fisherman_expert;
			case MASTER:
				return fisherman_master;
			}
		}

		if(profession == VillagerProfession.FLETCHER) {
			switch (level) {
			case NOVICE:
				return fletcher_novice;
			case APPRENTICE:
				return fletcher_apprentice;
			case JOURNEYMAN:
				return fletcher_journeyman;
			case EXPERT:
				return fletcher_expert;
			case MASTER:
				return fletcher_master;
			}
		}

		if(profession == VillagerProfession.LEATHERWORKER) {
			switch (level) {
			case NOVICE:
				return leatherworker_novice;
			case APPRENTICE:
				return leatherworker_apprentice;
			case JOURNEYMAN:
				return leatherworker_journeyman;
			case EXPERT:
				return leatherworker_expert;
			case MASTER:
				return leatherworker_master;
			}
		}

		if(profession == VillagerProfession.LIBRARIAN) {
			switch (level) {
			case NOVICE:
				return librarian_novice;
			case APPRENTICE:
				return librarian_apprentice;
			case JOURNEYMAN:
				return librarian_journeyman;
			case EXPERT:
				return librarian_expert;
			case MASTER:
				return librarian_master;
			}
		}

		if(profession == VillagerProfession.MASON) {
			switch (level) {
			case NOVICE:
				return mason_novice;
			case APPRENTICE:
				return mason_apprentice;
			case JOURNEYMAN:
				return mason_journeyman;
			case EXPERT:
				return mason_expert;
			case MASTER:
				return mason_master;
			}
		}

		if(profession == VillagerProfession.SHEPHERD) {
			switch (level) {
			case NOVICE:
				return shepherd_novice;
			case APPRENTICE:
				return shepherd_apprentice;
			case JOURNEYMAN:
				return shepherd_journeyman;
			case EXPERT:
				return shepherd_expert;
			case MASTER:
				return shepherd_master;
			}
		}

		if(profession == VillagerProfession.TOOLSMITH) {
			switch (level) {
			case NOVICE:
				return toolsmith_novice;
			case APPRENTICE:
				return toolsmith_apprentice;
			case JOURNEYMAN:
				return toolsmith_journeyman;
			case EXPERT:
				return toolsmith_expert;
			case MASTER:
				return toolsmith_master;
			}
		}

		if(profession == VillagerProfession.WEAPONSMITH) {
			switch (level) {
			case NOVICE:
				return weaponsmith_novice;
			case APPRENTICE:
				return weaponsmith_apprentice;
			case JOURNEYMAN:
				return weaponsmith_journeyman;
			case EXPERT:
				return weaponsmith_expert;
			case MASTER:
				return weaponsmith_master;
			}
		}

		return null;
	}

	public static Int2ObjectMap<TradeOffers.Factory[]> copyToFastUtilMap(ImmutableMap<Integer, TradeOffers.Factory[]> immutableMap) {
		return new Int2ObjectOpenHashMap(immutableMap);
	}

	public static enum VillagerLevel {
		NOVICE("novice", 1),
		APPRENTICE("apprentice", 2),
		JOURNEYMAN("journeyman", 3),
		EXPERT("expert", 4),
		MASTER("master", 5);

		private String id;
		private int level;

		private VillagerLevel(String name, int level) {
			this.id = name;
			this.level = level;
		}

		public String toString() {
			return id;
		}

		public int getLevel() {
			return level;
		}

		public static VillagerLevel getIDByLevel(int level) {
			if(level <=1)
				return NOVICE;
			else if(level == 2)
				return APPRENTICE;
			else if(level == 3)
				return JOURNEYMAN;
			else if(level == 4)
				return EXPERT;
			else
				return MASTER;
		}
	}

}
