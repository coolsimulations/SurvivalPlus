package net.coolsimulations.SurvivalPlus.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.events.EntityAccessor;
import net.coolsimulations.SurvivalPlus.api.events.SPPlayerDeathEvent;
import net.coolsimulations.SurvivalPlus.api.events.SPPlayerJoinEvent;
import net.fabricmc.fabric.api.loot.v2.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.ServerAdvancementManager;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DeadBushBlock;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.NetherSproutsBlock;
import net.minecraft.world.level.block.SeagrassBlock;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.WebBlock;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.predicates.AlternativeLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class SurvivalPlusEventHandler {

	public static void init() {

		onplayerLogin();
		coolsimDeath();
		villagerTrades();
		addLootTable();
	}

	public static void onplayerLogin()
	{
		SPPlayerJoinEvent.EVENT.register((player, server) -> {

			CompoundTag entityData = ((EntityAccessor) player).getPersistentData();

			ServerAdvancementManager manager = server.getAdvancements();
			Advancement install = manager.getAdvancement(new ResourceLocation(SPReference.MOD_ID, SPReference.MOD_ID + "/install"));

			boolean isDone = false;

			Timer timer = new Timer();

			if(install !=null && player.getAdvancements().getOrStartProgress(install).hasProgress()) {
				isDone = true;
			}

			if(!entityData.getBoolean("sp.firstJoin") && !isDone && !SPConfig.disableThanks) {

				entityData.putBoolean("sp.firstJoin", true);

				if(!player.level.isClientSide) {

					MutableComponent installInfo = Component.translatable("advancements.sp.install.display1");
					installInfo.withStyle(ChatFormatting.GOLD);
					player.sendSystemMessage(installInfo.setStyle(installInfo.getStyle().withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("advancements.sp.install.display2"))).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus-fabric"))));

					MutableComponent discord = Component.translatable("sp.discord.display1");
					discord.withStyle(ChatFormatting.DARK_GREEN, ChatFormatting.BOLD);

					for(int i = 0; i < SPReference.MOD_ADDON_NAMES.size(); i++) {

						MutableComponent formatted = Component.translatable(SPReference.MOD_ADDON_NAMES.get(i));
						formatted.withStyle(ChatFormatting.BLUE, ChatFormatting.BOLD);

						MutableComponent gap = Component.literal(", ");
						gap.withStyle(ChatFormatting.WHITE);

						discord.append(formatted);
						if(i + 1 != SPReference.MOD_ADDON_NAMES.size()) {
							discord.append(gap);
						}
					}

					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							player.sendSystemMessage(discord.setStyle(discord.getStyle().withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("sp.discord.display2"))).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/7DDsHfQ"))));
						}
					}, 30000);
				}
			}

			if(SurvivalPlusUpdateHandler.isOld == true && SPConfig.disableUpdateCheck == false) {
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						player.sendSystemMessage(SurvivalPlusUpdateHandler.updateInfo.setStyle(SurvivalPlusUpdateHandler.updateInfo.getStyle().withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("sp.update.display2"))).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus-fabric"))));
						player.sendSystemMessage(SurvivalPlusUpdateHandler.updateVersionInfo.setStyle(SurvivalPlusUpdateHandler.updateVersionInfo.getStyle().withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("sp.update.display2"))).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus-fabric"))));
					}
				}, 15000);
			}
			return InteractionResult.PASS;
		});
	}

	public static void villagerTrades() {

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 3, factories -> {
			factories.add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(SPItems.beef_pie, 4), 16, 20, 0.05F));
		});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
			factories.add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(SPItems.onion_seeds, 4), 12, 2, 0.05F));
		});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> {
			factories.add((entity, random) -> new MerchantOffer(new ItemStack(SPItems.raw_onion, 6), new ItemStack(Items.EMERALD), 16, 5, 0.05F));
		});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, factories -> {
			factories.add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(SPItems.bronze_chestplate), 12, 5, 0.2F));
		});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, factories -> {
			factories.add((entity, random) -> new MerchantOffer(new ItemStack(SPItems.bronze_ingot, 3), new ItemStack(Items.EMERALD), 12, 5, 0.05F));
		});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 2, factories -> {
			factories.add((entity, random) -> new MerchantOffer(new ItemStack(SPItems.bronze_ingot, 3), new ItemStack(Items.EMERALD), 12, 5, 0.05F));
		});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, factories -> {
			factories.add((entity, random) -> new MerchantOffer(new ItemStack(SPItems.titanium_ingot, 3), new ItemStack(Items.EMERALD), 12, 10, 0.05F));
		});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 2, factories -> {
			factories.add((entity, random) -> new MerchantOffer(new ItemStack(SPItems.titanium_ingot, 3), new ItemStack(Items.EMERALD), 12, 10, 0.05F));
		});

		TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
			factories.add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD), new ItemStack(SPItems.onion_seeds, 4), 12, 20, 0.05F));
		});
	}

	public static void addLootTable() {
		LootTableEvents.REPLACE.register((resourceManager, manager, id, table, source) -> {
			if(id.equals(BuiltInLootTables.PIGLIN_BARTERING)) {

				LootPoolEntryContainer spinel = LootItem.lootTableItem(SPItems.spinel_shard).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).build();

				List<LootPoolEntryContainer> newList = new ArrayList<LootPoolEntryContainer>();
				newList.add(spinel);

				for(LootPoolEntryContainer pool : table.pools[0].entries) {
					newList.add(pool);
				}

				LootPool.Builder newBuilder = LootPool.lootPool();

				for(LootPoolEntryContainer pool : newList) {
					newBuilder.with(pool);
				}

				return LootTable.lootTable().withPool(newBuilder).build();
			}

			for(ResourceLocation location : Registry.BLOCK.keySet()) {
				Block block = Registry.BLOCK.get(location);
				
				if(block instanceof LeavesBlock || block == Blocks.OAK_LEAVES) {
					LootTable check = replaceLootWithShears(block, id, table, manager, source);
					if(check != null)
						return check;
				}

				if(block instanceof WebBlock) {
					LootTable check = replaceLootWithShears(block, id, table, manager, source);
					if(check != null)
						return check;
				}

				if(block instanceof DeadBushBlock) {
					LootTable check = replaceLootWithShears(block, id, table, manager, source);
					if(check != null)
						return check;
				}

				if(block instanceof NetherSproutsBlock) {
					LootTable check = replaceLootWithShears(block, id, table, manager, source);
					if(check != null)
						return check;
				}

				if(block instanceof VineBlock) {
					LootTable check = replaceLootWithShears(block, id, table, manager, source);
					if(check != null)
						return check;
				}

				if(block instanceof SeagrassBlock) {
					LootTable check = replaceLootWithShears(block, id, table, manager, source);
					if(check != null)
						return check;
				}

				if(block instanceof GlowLichenBlock) {
					LootTable check = replaceLootWithShears(block, id, table, manager, source);
					if(check != null)
						return check;
				}

				if(block == Blocks.FERN) {
					LootTable check = replaceLootWithShears(block, id, table, manager, source);
					if(check != null)
						return check;
				}

				if(block == Blocks.LARGE_FERN) {
					LootTable check = replaceLootWithShears(block, Items.FERN, 2, id, table, manager, source);
					if(check != null)
						return check;
				}

				if(block == Blocks.GRASS) {
					LootTable check = replaceLootWithShears(block, id, table, manager, source);
					if(check != null)
						return check;
				}

				if(block == Blocks.TALL_GRASS) {
					LootTable check = replaceLootWithShears(block, Items.GRASS, 2, id, table, manager, source);
					if(check != null)
						return check;
				}

				if(block == Blocks.TALL_SEAGRASS) {
					LootTable check = replaceLootWithShears(block, Items.SEAGRASS, 2, id, table, manager, source);
					if(check != null)
						return check;
				}
			}

			return null;
		});
	}

	public static void coolsimDeath() {
		SPPlayerDeathEvent.EVENT.register((player, source) -> {

			if(player.getUUID().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412")) && source.getEntity() instanceof ServerPlayer) {

				ServerPlayer attacker = (ServerPlayer) source.getEntity();
				ItemStack coolsimHead = getcoolsimHead(player);

				if(coolsimHead != null) {
					dropItem(coolsimHead, attacker);
				} else {
					MutableComponent error = Component.translatable("sp.coolsim.error");
					error.withStyle(ChatFormatting.RED);
					attacker.sendSystemMessage(error);
				}
			}

			return InteractionResult.PASS;
		});

	}

	public static ItemStack getcoolsimHead(Player coolsim)
	{
		String texture = "eyJ0aW1lc3RhbXAiOjE1NzYxMTM5OTc5ODUsInByb2ZpbGVJZCI6IjU0NDgxMjU3N2I2ZDRjOGU4YWFjY2E2Zjg2NGUxNDEyIiwicHJvZmlsZU5hbWUiOiJjb29sc2ltIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzdmMDkwM2QxOGMyZTE4YmQzYzBiMDk5YmIzZGFkNmVjYTQ2ZDBjMzdkZjJkM2FlMjljYzAwOWYwN2I5OTM3NmYifX19";

		ItemStack playerhead = new ItemStack(Items.PLAYER_HEAD);

		MutableComponent headName = Component.translatable("block.minecraft.player_head.named", new Object[] {"coolsim"});
		headName.withStyle(ChatFormatting.ITALIC);
		CompoundTag properties = new CompoundTag();
		ListTag textures = new ListTag();
		CompoundTag tex = new CompoundTag();
		tex.putString("Value", texture);
		textures.add(tex);
		properties.put("textures", textures);
		playerhead.addTagElement("SkullOwner", NbtUtils.writeGameProfile(new CompoundTag(), coolsim.getGameProfile()));
		playerhead.setHoverName(headName);

		return playerhead;
	}

	public static void dropItem(ItemStack stack, Player player) {

		boolean bl = player.getInventory().add(stack);
		ItemEntity itemEntity;
		if (bl && stack.isEmpty()) {
			stack.setCount(1);
			itemEntity = player.drop(stack, false);
			if (itemEntity != null) {
				itemEntity.makeFakeItem();
			}

			player.level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, ((player.getRandom().nextFloat() - player.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);
			player.containerMenu.broadcastChanges();
		} else {
			itemEntity = player.drop(stack, false);
			if (itemEntity != null) {
				itemEntity.setNoPickUpDelay();
				itemEntity.setOwner(player.getUUID());
			}
		}
	}

	public static LootTable replaceLootWithShears(Block block, ResourceLocation id, LootTable supplier, LootTables manager, LootTableSource setter) {
		return replaceLootWithShears(block, block.asItem(), 1, id, supplier, manager, setter);
	}

	public static LootTable replaceLootWithShears(Block block, Item item, ResourceLocation id, LootTable supplier, LootTables manager, LootTableSource setter) {
		return replaceLootWithShears(block, item, 1, id, supplier, manager, setter);
	}

	/**
	 * Replaces the shear item of a Loot Table with the fabric tag.
	 * 
	 * It is a modified version of ERN468's solution found here: https://www.reddit.com/r/fabricmc/comments/mcl827/my_custom_shears_wont_work_like_shears_unless_i/
	 * 
	 * @author ERN468 and coolsim
	 * @param block The block to be Sheared
	 * @param item The item that should be dropped
	 * @param count The amount of items to be dropped
	 * @param id The LootTable ResourceLocaiton
	 * @param table The Loot Supplier
	 * @param manager The Loot Manager
	 * @param source THe Loot Setter
	 */
	public static LootTable replaceLootWithShears(Block block, Item item, int count, ResourceLocation id, LootTable table, LootTables manager, LootTableSource source) {

		if (id.equals(block.getLootTable())) {
			if (table != null) {

				LootContextParamSet contextType = table.getParamSet();
				List<LootPool> pools = Arrays.asList(table.pools);
				List<LootItemFunction> functions = Arrays.asList(table.functions);
				LootTable.Builder replacement = LootTable.lootTable()
						.setParamSet(contextType);
				int i = 0;
				for (LootPool pool : pools) {
					i++;
					if(i == 2) {
						LootPool.Builder poolBuilder = FabricLootPoolBuilder.copyOf(pool)
								.conditionally(MatchTool.toolMatches(ItemPredicate.Builder.item().of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("fabric", "shears")))).invert().build());
						replacement.withPool(poolBuilder);
					}
					else if (i == 1){
						LootPool.Builder poolBuilder = FabricLootPoolBuilder.copyOf(pool)
								.apply(LimitCount.limitCount(IntRange.range(0, 0)).when(InvertedLootItemCondition.invert(AlternativeLootItemCondition.alternative(MatchTool.toolMatches(ItemPredicate.Builder.item().of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("fabric", "shears")))).invert()).or(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))))));
						replacement.withPool(poolBuilder);
					}
					else {
						replacement.pool(pool);
					}
				}
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.conditionally(MatchTool.toolMatches(ItemPredicate.Builder.item().of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("fabric", "shears")))).build())
						.conditionally(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS)).invert().build())
						.setRolls(ConstantValue.exactly(1))
						.with(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(count))).build());
				replacement.withPool(poolBuilder);
				replacement.apply(functions);
				return replacement.build();
			}
		}
		
		return null;
	}
}
