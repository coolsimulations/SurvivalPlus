package net.coolsimulations.SurvivalPlus.core.util;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.events.EntityAccessor;
import net.coolsimulations.SurvivalPlus.api.events.SPPlayerDeathEvent;
import net.coolsimulations.SurvivalPlus.api.events.SPPlayerJoinEvent;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplier;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback.LootTableSetter;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.advancement.Advancement;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CobwebBlock;
import net.minecraft.block.DeadBushBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SeagrassBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AlternativeLootCondition;
import net.minecraft.loot.condition.InvertedLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.LimitCountLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.server.ServerAdvancementLoader;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BoundedIntUnaryOperator;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

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

			ServerAdvancementLoader manager = server.getAdvancementLoader();
			Advancement install = manager.get(new Identifier(SPReference.MOD_ID, SPReference.MOD_ID + "/install"));

			boolean isDone = false;

			Timer timer = new Timer();

			if(install !=null && player.getAdvancementTracker().getProgress(install).isAnyObtained()) {
				isDone = true;
			}

			if(!entityData.getBoolean("sp.firstJoin") && !isDone && !SPConfig.disableThanks) {

				entityData.putBoolean("sp.firstJoin", true);

				if(!player.world.isClient) {

					TranslatableText installInfo = new TranslatableText("advancements.sp.install.display1");
					installInfo.getStyle().setColor(Formatting.GOLD);
					installInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableText("advancements.sp.install.display2")));
					installInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus-fabric"));
					player.sendMessage(installInfo);

					TranslatableText discord = new TranslatableText("sp.discord.display1");
					discord.getStyle().setColor(Formatting.DARK_GREEN);
					discord.getStyle().setBold(true);

					for(int i = 0; i < SPReference.MOD_ADDON_NAMES.size(); i++) {

						TranslatableText formatted = new TranslatableText(SPReference.MOD_ADDON_NAMES.get(i));
						formatted.getStyle().setColor(Formatting.BLUE);
						formatted.getStyle().setBold(true);

						LiteralText gap = new LiteralText(", ");
						gap.getStyle().setColor(Formatting.WHITE);

						discord.append(formatted);
						if(i + 1 != SPReference.MOD_ADDON_NAMES.size()) {
							discord.append(gap);
						}
					}
					discord.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableText("sp.discord.display2")));
					discord.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/7DDsHfQ"));

					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							player.sendMessage(discord);
						}
					}, 30000);
				}
			}

			if(SurvivalPlusUpdateHandler.isOld == true && SPConfig.disableUpdateCheck == false) {
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						player.sendMessage(SurvivalPlusUpdateHandler.updateInfo);
						player.sendMessage(SurvivalPlusUpdateHandler.updateVersionInfo);
					}
				}, 15000);
			}
			return ActionResult.PASS;
		});
	}

	public static void villagerTrades() {
		
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(SPItems.beef_pie, 4), 16, 20, 0.05F));
		});
		
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(SPItems.onion_seeds, 4), 12, 2, 0.05F));
		});
		
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(SPItems.raw_onion, 6), new ItemStack(Items.EMERALD), 16, 5, 0.05F));
		});
		
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(SPItems.bronze_chestplate), 12, 5, 0.2F));
		});
		
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(SPItems.bronze_ingot, 3), new ItemStack(Items.EMERALD), 12, 5, 0.05F));
		});
		
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(SPItems.bronze_ingot, 3), new ItemStack(Items.EMERALD), 12, 5, 0.05F));
		});
		
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(SPItems.titanium_ingot, 3), new ItemStack(Items.EMERALD), 12, 10, 0.05F));
		});
		
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(SPItems.titanium_ingot, 3), new ItemStack(Items.EMERALD), 12, 10, 0.05F));
		});
		
		TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD), new ItemStack(SPItems.onion_seeds, 4), 12, 20, 0.05F));
		});
	}
	
	public static void addLootTable() {
		LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {

			for(Identifier identifier : Registry.BLOCK.getIds()) {
				Block block = Registry.BLOCK.get(identifier);

				if(block instanceof LeavesBlock) {
					replaceLootWithShears(block, id, supplier, manager, setter);
				}
				
				if(block instanceof CobwebBlock) {
					replaceLootWithShears(block, id, supplier, manager, setter);
				}
				
				if(block instanceof DeadBushBlock) {
					replaceLootWithShears(block, id, supplier, manager, setter);
				}
				
				if(block instanceof VineBlock) {
					replaceLootWithShears(block, id, supplier, manager, setter);
				}
				
				if(block instanceof SeagrassBlock) {
					replaceLootWithShears(block, id, supplier, manager, setter);
				}
			}
			
			replaceLootWithShears(Blocks.FERN, id, supplier, manager, setter);
			replaceLootWithShears(Blocks.LARGE_FERN, Items.FERN, id, supplier, manager, setter);
			replaceLootWithShears(Blocks.GRASS, id, supplier, manager, setter);
			replaceLootWithShears(Blocks.TALL_GRASS, Items.GRASS, id, supplier, manager, setter);
			replaceLootWithShears(Blocks.TALL_SEAGRASS, Items.SEAGRASS, id, supplier, manager, setter);
		});
	}

	public static void coolsimDeath() {
		SPPlayerDeathEvent.EVENT.register((player, source) -> {

			if(player.getUuid().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412")) && source.getAttacker() instanceof ServerPlayerEntity) {

				ServerPlayerEntity attacker = (ServerPlayerEntity) source.getAttacker();
				ItemStack coolsimHead = getcoolsimHead();

				if(coolsimHead != null) {
					dropItem(coolsimHead, attacker);
				} else {
					TranslatableText error = new TranslatableText("sp.coolsim.error");
					error.getStyle().setColor(Formatting.RED);
					attacker.sendMessage(error);
				}
			}

			return ActionResult.PASS;
		});

	}

	public static ItemStack getcoolsimHead()
	{
		String texture = "eyJ0aW1lc3RhbXAiOjE1NzYxMTM5OTc5ODUsInByb2ZpbGVJZCI6IjU0NDgxMjU3N2I2ZDRjOGU4YWFjY2E2Zjg2NGUxNDEyIiwicHJvZmlsZU5hbWUiOiJjb29sc2ltIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzdmMDkwM2QxOGMyZTE4YmQzYzBiMDk5YmIzZGFkNmVjYTQ2ZDBjMzdkZjJkM2FlMjljYzAwOWYwN2I5OTM3NmYifX19";
		String id = new UUID(texture.hashCode(), texture.hashCode()).toString();

		ItemStack playerhead = new ItemStack(Items.PLAYER_HEAD);

		TranslatableText headName = new TranslatableText("block.minecraft.player_head.named", new Object[] {"coolsim"});
		headName.getStyle().setItalic(true);
		CompoundTag skullOwner = new CompoundTag();
		skullOwner.putString("Id", id);
		CompoundTag properties = new CompoundTag();
		ListTag textures = new ListTag();
		CompoundTag tex = new CompoundTag();
		tex.putString("Value", texture);
		textures.add(tex);
		properties.put("textures", textures);
		skullOwner.put("Properties", properties);
		playerhead.putSubTag("SkullOwner", skullOwner);
		playerhead.setCustomName(headName);

		return playerhead;
	}

	public static void dropItem(ItemStack stack, PlayerEntity player) {

		boolean bl = player.inventory.insertStack(stack);
		ItemEntity itemEntity;
		if (bl && stack.isEmpty()) {
			stack.setCount(1);
			itemEntity = player.dropItem(stack, false);
			if (itemEntity != null) {
				itemEntity.setDespawnImmediately();
			}

			player.world.playSound((PlayerEntity)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, ((player.getRandom().nextFloat() - player.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);
			player.playerContainer.sendContentUpdates();
		} else {
			itemEntity = player.dropItem(stack, false);
			if (itemEntity != null) {
				itemEntity.resetPickupDelay();
				itemEntity.setOwner(player.getUuid());
			}
		}
	}
	
	public static String replaceFormattingCodes(Text message) {

		String text = message.asFormattedString();

		if(text.contains("§")) {
			
			for(int i = 0; i <= StringUtils.countMatches(text, "§"); i++) {
				text = text.substring(0, text.indexOf("§")) + text.substring(text.indexOf("§") + 2);
			}
		}

		return text;
	}

	public static void replaceLootWithShears(Block block, Identifier id, FabricLootSupplierBuilder supplier, LootManager manager, LootTableSetter setter) {
		replaceLootWithShears(block, block.asItem(), 1, id, supplier, manager, setter);
	}
	
	public static void replaceLootWithShears(Block block, Item item, Identifier id, FabricLootSupplierBuilder supplier, LootManager manager, LootTableSetter setter) {
		replaceLootWithShears(block, item, 1, id, supplier, manager, setter);
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
	 * @param supplier The Loot Supplier
	 * @param manager The Loot Manager
	 * @param setter THe Loot Setter
	 */
	public static void replaceLootWithShears(Block block, Item item, int count, Identifier id, FabricLootSupplierBuilder supplier, LootManager manager, LootTableSetter setter) {
		
		if (id.equals(block.getDropTableId())) {
			if (supplier != null) {

				LootTable table = manager.getSupplier(id);

				if(table instanceof FabricLootSupplier) {

					FabricLootSupplier extended = (FabricLootSupplier) table;

					LootContextType contextType = supplier.create().getType();
					List<LootPool> pools = extended.getPools();
					List<LootFunction> functions = extended.getFunctions();
					FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
							.withType(contextType);
					int i = 0;
					for (LootPool pool : pools) {
						i++;
						if(i == 2) {
							FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
									.withCondition(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(FabricToolTags.SHEARS)).invert());
							replacement.withPool(poolBuilder.build());
						}
						else if (i == 1){
							FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
									.withFunction(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).withCondition(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(FabricToolTags.SHEARS)).invert()).withCondition(MatchToolLootCondition.builder(ItemPredicate.Builder.create().item(Items.SHEARS))))));
							replacement.withPool(poolBuilder.build());
						}
						else {
							replacement.withPool(pool);
						}
					}
					FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
							.withCondition(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(FabricToolTags.SHEARS)))
							.withCondition(MatchToolLootCondition.builder(ItemPredicate.Builder.create().item(Items.SHEARS)).invert())
							.withRolls(ConstantLootTableRange.create(1))
							.withEntry(ItemEntry.builder(item).withFunction(SetCountLootFunction.builder(ConstantLootTableRange.create(count))).build());
					replacement.withPool(poolBuilder.build());
					replacement.withFunctions(functions);
					setter.set(replacement.create());
				}
			}
		}
	}
}
