package net.coolsimulations.SurvivalPlus.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.compat.RainbowComponent;
import net.coolsimulations.SurvivalPlus.api.item.SPItemIngot;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.Advancement;
import net.minecraft.locale.Language;
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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SurvivalPlusEventHandler {

	@SubscribeEvent
	public void onplayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		ServerPlayer player = (ServerPlayer) event.getEntity();
		CompoundTag entityData = player.getPersistentData();

		ServerAdvancementManager manager = player.getServer().getAdvancements();
		Advancement install = manager.getAdvancement(new ResourceLocation(SPReference.MOD_ID, SPReference.MOD_ID + "/install"));

		boolean isDone = false;

		Timer timer = new Timer();

		if(install !=null && player.getAdvancements().getOrStartProgress(install).hasProgress()) {
			isDone = true;
		}

		if(!entityData.getBoolean("sp.firstJoin") && !isDone && !SPConfig.disableThanks.get()) {

			entityData.putBoolean("sp.firstJoin", true);

			if(!player.level.isClientSide) {

				MutableComponent installInfo = Component.translatable("advancements.sp.install.display1");
				installInfo.withStyle(ChatFormatting.GOLD);
				player.sendSystemMessage(installInfo.setStyle(installInfo.getStyle().withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("advancements.sp.install.display2"))).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus"))));

				MutableComponent discord = Component.translatable("sp.discord.display1");
				discord.withStyle(ChatFormatting.DARK_GREEN);
				discord.withStyle(ChatFormatting.BOLD);

				for(int i = 0; i < SPReference.MOD_ADDON_NAMES.size(); i++) {
					String name = Language.getInstance().getOrDefault(SPReference.MOD_ADDON_NAMES.get(i));

					MutableComponent formatted = Component.literal(name);
					formatted.withStyle(ChatFormatting.BLUE);
					formatted.withStyle(ChatFormatting.BOLD);

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

		if(SurvivalPlusUpdateHandler.isOld == true && SPConfig.disableUpdateCheck.get() == false) {
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					player.sendSystemMessage(SurvivalPlusUpdateHandler.updateInfo.setStyle(SurvivalPlusUpdateHandler.updateInfo.getStyle().withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("sp.update.display2"))).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus"))));
					player.sendSystemMessage(SurvivalPlusUpdateHandler.updateVersionInfo.setStyle(SurvivalPlusUpdateHandler.updateVersionInfo.getStyle().withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("sp.update.display2"))).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus"))));
				}
			}, 15000);
		}
	}

	@SubscribeEvent
	public void villagerTrades(VillagerTradesEvent event) {
		Int2ObjectMap<List<ItemListing>> trades = event.getTrades();

		if(event.getType() == VillagerProfession.BUTCHER) {
			trades.get(3).add(new BasicItemListing(2, new ItemStack(SPItems.beef_pie.get(), 4), 16, 20));
		}

		if(event.getType() == VillagerProfession.FARMER) {
			trades.get(1).add(new BasicItemListing(1, new ItemStack(SPItems.onion_seeds.get(), 4), 12, 2)); //temp till forge pull request #6142 is resolved
			trades.get(2).add(new BasicItemListing(new ItemStack(SPItems.raw_onion.get(), 6), new ItemStack(Items.EMERALD), 16, 5, 0.05F));
		}

		if(event.getType() == VillagerProfession.ARMORER) {
			trades.get(2).add(new BasicItemListing(3, new ItemStack(SPItems.bronze_chestplate.get()), 12, 5, 0.2F));
		}

		if(event.getType() == VillagerProfession.ARMORER  || event.getType() == VillagerProfession.WEAPONSMITH) {
			trades.get(2).add(new BasicItemListing(new ItemStack(SPItems.bronze_ingot.get(), 3), new ItemStack(Items.EMERALD), 12, 5, 0.05F));
			trades.get(2).add(new BasicItemListing(new ItemStack(SPItems.titanium_ingot.get(), 3), new ItemStack(Items.EMERALD), 12, 10, 0.05F));
		}

	}

	@SubscribeEvent
	public void villagerTrades(WandererTradesEvent event) {
		List<ItemListing> trades = (List<ItemListing>) event.getGenericTrades();

		trades.add(new BasicItemListing(1, new ItemStack(SPItems.onion_seeds.get(), 4), 12, 20));		
	}

	@SubscribeEvent
	public void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		Level world = event.getLevel();
		Block block = world.getBlockState(event.getPos()).getBlock();
		BlockState state = world.getBlockState(event.getPos());

		Player entityplayer = event.getEntity();
		ItemStack itemStackIn = entityplayer.getItemInHand(event.getHand());
		Item item = itemStackIn.getItem();

		if(block instanceof CampfireBlock) {
			if(state.getValue(CampfireBlock.LIT) && item == Items.BUCKET  && !entityplayer.getAbilities().instabuild) {
				if (!world.isClientSide()) {
					world.levelEvent((Player) null, 1009, event.getPos(), 0);
				}
				CampfireBlock.dowse(entityplayer, world, event.getPos(), state);
				world.setBlockAndUpdate(event.getPos(), state.setValue(CampfireBlock.LIT, false));
				if(itemStackIn.getCount() == 1) {
					if (ItemStack.isSame(entityplayer.getOffhandItem(), itemStackIn))
					{
						entityplayer.setItemInHand(InteractionHand.OFF_HAND, new ItemStack(SPItems.charcoal_bucket.get()));
					}
					else
					{
						entityplayer.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(SPItems.charcoal_bucket.get()));
					}
				} else  if(itemStackIn.getCount() >= 2){
					itemStackIn.shrink(1);
					boolean flag = entityplayer.getInventory().add(new ItemStack(SPItems.charcoal_bucket.get()));
					if(!flag) {
						entityplayer.drop(new ItemStack(SPItems.charcoal_bucket.get()), false);
					}		
				}
			}
		}

		if(block == Blocks.CAKE) {

			if((entityplayer.getMainHandItem().getItem() == SPItems.paper_cup.get() || entityplayer.getOffhandItem().getItem() == SPItems.paper_cup.get()) || entityplayer.getMainHandItem().getItem() == SPItems.cupcake.get() || entityplayer.getOffhandItem().getItem() == SPItems.cupcake.get()) {
				event.setCanceled(true);
			}

			if(entityplayer.getItemInHand(event.getHand()).getItem() == SPItems.paper_cup.get()) {

				if(!world.isClientSide) {

					int bites = (Integer)state.getValue(CakeBlock.BITES);

					if (bites < CakeBlock.MAX_BITES) {
						world.setBlock(event.getPos(), (BlockState)state.setValue(CakeBlock.BITES, bites + 1), 3);
					} else {
						world.removeBlock(event.getPos(), false);
					}

					if(!entityplayer.isCreative()) {
						if(itemStackIn.getCount() == 1) {
							if (ItemStack.isSame(entityplayer.getOffhandItem(), itemStackIn))
							{
								entityplayer.setItemInHand(InteractionHand.OFF_HAND, new ItemStack(SPItems.cupcake.get()));
							}
							else
							{
								entityplayer.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(SPItems.cupcake.get()));
							}
						} else  if(itemStackIn.getCount() >= 2){
							itemStackIn.shrink(1);
							boolean flag = entityplayer.getInventory().add(new ItemStack(SPItems.cupcake.get()));
							if(!flag) {
								entityplayer.drop(new ItemStack(SPItems.cupcake.get()), false);
							}
						}
					}
				}
			}
		}

		if(block instanceof CandleCakeBlock) {

			if((entityplayer.getMainHandItem().getItem() == SPItems.paper_cup.get()|| entityplayer.getOffhandItem().getItem() == SPItems.paper_cup.get()) || entityplayer.getMainHandItem().getItem() == SPItems.cupcake.get() || entityplayer.getOffhandItem().getItem() == SPItems.cupcake.get()) {
				event.setCanceled(true);
			}

			if(!world.isClientSide) {

				int bites = (Integer)Blocks.CAKE.defaultBlockState().getValue(CakeBlock.BITES);

				if (bites < CakeBlock.MAX_BITES) {
					world.setBlock(event.getPos(), (BlockState)Blocks.CAKE.defaultBlockState().setValue(CakeBlock.BITES, bites + 1), 3);
				} else {
					world.removeBlock(event.getPos(), false);
				}

				if(!entityplayer.isCreative()) {
					if(itemStackIn.getCount() == 1) {
						if (ItemStack.isSame(entityplayer.getOffhandItem(), itemStackIn))
						{
							entityplayer.setItemInHand(InteractionHand.OFF_HAND, new ItemStack(SPItems.cupcake.get()));
						}
						else
						{
							entityplayer.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(SPItems.cupcake.get()));
						}
					} else  if(itemStackIn.getCount() >= 2){
						itemStackIn.shrink(1);
						boolean flag = entityplayer.getInventory().add(new ItemStack(SPItems.cupcake.get()));
						if(!flag) {
							entityplayer.drop(new ItemStack(SPItems.cupcake.get()), false);
						}
					}
				}

				Block.dropResources(state, world, event.getPos());
			}
		}

	}

	@SubscribeEvent
	public void golemHealth(EntityInteract event) {
		ItemStack itemstack = event.getItemStack();
		Item item = itemstack.getItem();
		Random rand = new Random();
		if(event.getTarget() instanceof IronGolem) {
			if (((LivingEntity) event.getTarget()).getHealth() < ((LivingEntity) event.getTarget()).getMaxHealth()) {
				if(item instanceof SPItemIngot && ((SPItemIngot) item).healsGolem()) {
					((LivingEntity) event.getTarget()).heal(((SPItemIngot) item).getGolemHealth());
					float f1 = 1.0F + (rand.nextFloat() - rand.nextFloat()) * 0.2F;
					((LivingEntity) event.getTarget()).playSound(SoundEvents.IRON_GOLEM_REPAIR, 1.0F, f1);
					if (!event.getEntity().getAbilities().instabuild) {
						itemstack.shrink(1);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void addLootTable(LootTableLoadEvent event) {

		if(event.getName().equals(BuiltInLootTables.PIGLIN_BARTERING)) {

			LootPoolEntryContainer spinel = LootItem.lootTableItem(SPItems.spinel_shard.get()).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).build();

			LootTable table = event.getTable();

			if(event.getTable().getPool("main") != null) {
				try {
					List<LootPoolEntryContainer> list = new ArrayList<LootPoolEntryContainer>(Arrays.asList(event.getTable().getPool("main").entries));

					list.add(spinel);

					event.getTable().getPool("main").entries = list.toArray(new LootPoolEntryContainer[0]);

				} catch (IllegalArgumentException e) {
					System.out.println("Failed to add Spinel Loot");
				}
			}

			event.setTable(table);
		}
	}

	/**@SubscribeEvent
    public static <T extends IForgeRegistryEntry<T>> void registerRecipes(RegistryEvent.Register<T> event)
    {
		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
		final RecipeManager recipeManager = event.getServer().getRecipeManager();

		if(!SPConfig.enableSponge.get()) {
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "sponge"));
		}

				if(SPCompatibilityManager.isHammerTimeLoaded()) {
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxediamond"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxegold"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxeiron"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxestone"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxewood"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammerdiamond"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammergold"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammeriron"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammerstone"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammerwood"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshoveldiamond"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshovelgold"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshoveliron"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshovelstone"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshovelwood"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsicklediamond"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsicklegold"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsickleiron"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsicklestone"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsicklewood"));
		}

    }**/

	@SubscribeEvent
	public void coolsimTabList(PlayerEvent.TabListNameFormat event) {

		if(event.getEntity().getUUID().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412"))) {

			MutableComponent coolsim = Component.literal("coolsim");
			coolsim.withStyle(ChatFormatting.GOLD);

			if(event.getEntity().getTeam() == null) {
				event.setDisplayName(coolsim);
			} else if(event.getEntity().getTeam() instanceof PlayerTeam) {
				if(((PlayerTeam) event.getEntity().getTeam()).getColor() == ChatFormatting.RESET)
					event.setDisplayName(coolsim);
			}
		}

		if(event.getEntity().getUUID().equals(UUID.fromString("a07ca1b4-b0c5-4cbf-bf5f-2d9acf0603d2"))) {

			MutableComponent alpaca = Component.literal(new RainbowComponent(event.getEntity().getName().getString()).getText());

			if(event.getEntity().getTeam() == null) {
				event.setDisplayName(alpaca);
			} else if(event.getEntity().getTeam() instanceof PlayerTeam) {
				if(((PlayerTeam) event.getEntity().getTeam()).getColor() == ChatFormatting.RESET)
					event.setDisplayName(alpaca);
			}
		}
	}

	@SubscribeEvent
	public void coolsimDisplayName(PlayerEvent.NameFormat event) {

		if(event.getEntity().getUUID().equals(UUID.fromString("a07ca1b4-b0c5-4cbf-bf5f-2d9acf0603d2"))) {

			MutableComponent alpaca = Component.literal(new RainbowComponent(event.getUsername().getString()).getText());

			if(event.getEntity().getTeam() == null) {
				event.setDisplayname(alpaca);
			} else if(event.getEntity().getTeam() instanceof PlayerTeam) {
				if(((PlayerTeam) event.getEntity().getTeam()).getColor() == ChatFormatting.RESET)
					event.setDisplayname(alpaca);
			}
		}
	}

	//Replaced with Mixin until Forge adds new events that work with the new 1.19 Chat system
	/**@SubscribeEvent
	public void coolsimChat(ServerChatEvent event) {

		MutableComponent coolsim = Component.translatable("sp.coolsim.creator");
		coolsim.withStyle(ChatFormatting.GOLD);

		if(event.getPlayer().getUUID().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412"))) {
			if(ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayerByName(event.getUsername()) != null)
				event.setComponent(Component.translatable("%s <%s> %s", new Object[] {coolsim, ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayerByName(event.getUsername()).getDisplayName(), event.getMessage()}));
		}
	}**/

	@SubscribeEvent
	public void coolsimReceivedChat(ClientChatReceivedEvent event) {

		MutableComponent coolsim = Component.translatable("sp.coolsim.creator", new Object[] {"", event.getMessage()});
		coolsim.withStyle(ChatFormatting.GOLD);

		MutableComponent playerJoined = Component.translatable("multiplayer.player.joined", new Object[] {"coolsim"});
		playerJoined.withStyle(ChatFormatting.YELLOW);

		MutableComponent playerLeft = Component.translatable("multiplayer.player.left", new Object[] {"coolsim"});
		playerLeft.withStyle(ChatFormatting.YELLOW);

		MutableComponent coolsimJoined = Component.translatable("sp.coolsim.joined", new Object[] {"coolsim"});
		coolsimJoined.withStyle(ChatFormatting.YELLOW);

		MutableComponent coolsimLeft = Component.translatable("sp.coolsim.left", new Object[] {"coolsim"});
		coolsimLeft.withStyle(ChatFormatting.YELLOW);

		if(event.getMessage().getString().equals(playerJoined.getString())) {
			event.setMessage(coolsimJoined);
		}

		if(event.getMessage().getString().equals(playerLeft.getString())) {
			event.setMessage(coolsimLeft);
		}

		if(event.getMessage().getString().startsWith("[coolsim]")) {
			event.setMessage(Component.literal(coolsim.getString().replaceFirst("<", "").replaceFirst("> ", "")));
		}
	}

	@SubscribeEvent
	public void coolsimDeath(LivingDeathEvent event) {

		if(event.getEntity() instanceof ServerPlayer && event.getEntity().getUUID().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412")) && event.getSource().getEntity() instanceof ServerPlayer) {

			ServerPlayer attacker = (ServerPlayer) event.getSource().getEntity();
			ItemStack coolsimHead = getcoolsimHead((Player) event.getEntity());

			if(coolsimHead != null) {
				dropItem(coolsimHead, attacker);
			} else {
				MutableComponent error = Component.translatable("sp.coolsim.error");
				error.withStyle(ChatFormatting.RED);
				attacker.sendSystemMessage(error);
			}
		}

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
		if (bl && stack.isEmpty()) {
			stack.setCount(1);
			ItemEntity itementity1 = player.drop(stack, false);
			if (itementity1 != null) {
				itementity1.makeFakeItem();
			}

			player.level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, ((player.getRandom().nextFloat() - player.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);
			player.containerMenu.broadcastChanges();;
		} else {
			ItemEntity itementity = player.drop(stack, false);
			if (itementity != null) {
				itementity.setNoPickUpDelay();
				itementity.setOwner(player.getUUID());
			}
		}

	}

}
