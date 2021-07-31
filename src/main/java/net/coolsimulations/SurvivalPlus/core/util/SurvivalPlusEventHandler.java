package net.coolsimulations.SurvivalPlus.core.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.coolsimulations.SurvivalPlus.api.SPBlocks;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPItemIngot;
import net.coolsimulations.SurvivalPlus.core.world.SurvivalPlusOreGenerator;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.LanguageMap;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class SurvivalPlusEventHandler {

	@SubscribeEvent
	public void onplayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		CompoundNBT entityData = player.getPersistentData();

		AdvancementManager manager = player.getServer().getAdvancements();
		Advancement install = manager.getAdvancement(new ResourceLocation(SPReference.MOD_ID, SPReference.MOD_ID + "/install"));

		boolean isDone = false;

		Timer timer = new Timer();

		if(install !=null && player.getAdvancements().getOrStartProgress(install).hasProgress()) {
			isDone = true;
		}

		if(!entityData.getBoolean("sp.firstJoin") && !isDone && !SPConfig.disableThanks.get()) {

			entityData.putBoolean("sp.firstJoin", true);

			if(!player.level.isClientSide) {

				TranslationTextComponent installInfo = new TranslationTextComponent("advancements.sp.install.display1");
				installInfo.withStyle(TextFormatting.GOLD);
				player.sendMessage(installInfo.withStyle((style) -> {return style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("advancements.sp.install.display2"))).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus"));}), ChatType.SYSTEM, Util.NIL_UUID);

				TranslationTextComponent discord = new TranslationTextComponent("sp.discord.display1");
				discord.withStyle(TextFormatting.DARK_GREEN);
				discord.withStyle(TextFormatting.BOLD);

				for(int i = 0; i < SPReference.MOD_ADDON_NAMES.size(); i++) {
					String name = LanguageMap.getInstance().getOrDefault(SPReference.MOD_ADDON_NAMES.get(i));

					StringTextComponent formatted = new StringTextComponent(name);
					formatted.withStyle(TextFormatting.BLUE);
					formatted.withStyle(TextFormatting.BOLD);

					StringTextComponent gap = new StringTextComponent(", ");
					gap.withStyle(TextFormatting.WHITE);

					discord.append(formatted);
					if(i + 1 != SPReference.MOD_ADDON_NAMES.size()) {
						discord.append(gap);
					}
				}

				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						player.sendMessage(discord.withStyle((style) -> {return style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("sp.discord.display2"))).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/7DDsHfQ"));}), ChatType.SYSTEM, Util.NIL_UUID);
					}
				}, 30000);
			}
		}

		if(SurvivalPlusUpdateHandler.isOld == true && SPConfig.disableUpdateCheck.get() == false) {
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					player.sendMessage(SurvivalPlusUpdateHandler.updateInfo.withStyle((style) -> {return style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("sp.update.display2"))).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus"));}), ChatType.SYSTEM, Util.NIL_UUID);
					player.sendMessage(SurvivalPlusUpdateHandler.updateVersionInfo.withStyle((style) -> {return style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("sp.update.display2"))).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus"));}), ChatType.SYSTEM, Util.NIL_UUID);
				}
			}, 15000);
		}
	}

	@SubscribeEvent
	public void villagerTrades(VillagerTradesEvent event) {
		Int2ObjectMap<List<ITrade>> trades = event.getTrades();

		if(event.getType() == VillagerProfession.BUTCHER) {
			trades.get(3).add(new BasicTrade(2, new ItemStack(SPItems.beef_pie, 4), 16, 20));
		}

		if(event.getType() == VillagerProfession.FARMER) {
			trades.get(1).add(new BasicTrade(1, new ItemStack(SPItems.onion_seeds, 4), 12, 2)); //temp till forge pull request #6142 is resolved
			trades.get(2).add(new BasicTrade(new ItemStack(SPItems.raw_onion, 6), new ItemStack(Items.EMERALD), 16, 5, 0.05F));
		}

		if(event.getType() == VillagerProfession.ARMORER) {
			trades.get(2).add(new BasicTrade(3, new ItemStack(SPItems.bronze_chestplate), 12, 5, 0.2F));
		}

		if(event.getType() == VillagerProfession.ARMORER  || event.getType() == VillagerProfession.WEAPONSMITH) {
			trades.get(2).add(new BasicTrade(new ItemStack(SPItems.bronze_ingot, 3), new ItemStack(Items.EMERALD), 12, 5, 0.05F));
			trades.get(2).add(new BasicTrade(new ItemStack(SPItems.titanium_ingot, 3), new ItemStack(Items.EMERALD), 12, 10, 0.05F));
		}

	}

	@SubscribeEvent
	public void villagerTrades(WandererTradesEvent event) {
		List<ITrade> trades = (List<ITrade>) event.getGenericTrades();

		trades.add(new BasicTrade(1, new ItemStack(SPItems.onion_seeds, 4), 12, 20));		
	}

	@SubscribeEvent
	public void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
		BlockState state = event.getWorld().getBlockState(event.getPos());

		PlayerEntity entityplayer = event.getPlayer();
		ItemStack itemStackIn = entityplayer.getItemInHand(event.getHand());
		Item item = itemStackIn.getItem();
		ItemStack itemStackIn1 = itemStackIn.copy();

		if(block instanceof CampfireBlock) {
			if(state.getValue(CampfireBlock.LIT) && item == Items.BUCKET  && !entityplayer.abilities.instabuild) {
				event.getWorld().setBlockAndUpdate(event.getPos(), state.setValue(CampfireBlock.LIT, false));
				if (event.getWorld().isClientSide()) {
					for (int i = 0; i < 20; ++i) {
						CampfireBlock.makeParticles(event.getWorld(), event.getPos(), (Boolean) state.getValue(CampfireBlock.SIGNAL_FIRE),true);
					}
				} else {
					event.getWorld().playSound((PlayerEntity) null, event.getPos(), SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
				}
				if(itemStackIn.getCount() == 1) {
					if (ItemStack.isSame(entityplayer.getOffhandItem(), itemStackIn))
					{
						entityplayer.setItemInHand(Hand.OFF_HAND, new ItemStack(SPItems.charcoal_bucket));
					}
					else
					{
						entityplayer.setItemInHand(Hand.MAIN_HAND, new ItemStack(SPItems.charcoal_bucket));
					}
				} else  if(itemStackIn.getCount() >= 2){
					itemStackIn.shrink(1);
					boolean flag = entityplayer.inventory.add(new ItemStack(SPItems.charcoal_bucket));
					if(!flag) {
						entityplayer.drop(new ItemStack(SPItems.charcoal_bucket), false);
					}		
				}
			}
		}

		if(block == Blocks.CAKE) {

			if((entityplayer.getMainHandItem().getItem() == SPItems.paper_cup || entityplayer.getOffhandItem().getItem() == SPItems.paper_cup) || entityplayer.getMainHandItem().getItem() == SPItems.cupcake || entityplayer.getOffhandItem().getItem() == SPItems.cupcake) {
				event.setCanceled(true);
			}

			if(entityplayer.getItemInHand(event.getHand()).getItem() == SPItems.paper_cup) {

				if(!event.getWorld().isClientSide) {

					int bites = (Integer)state.getValue(CakeBlock.BITES);

					if (bites < 6) {
						event.getWorld().setBlock(event.getPos(), (BlockState)state.setValue(CakeBlock.BITES, bites + 1), 3);
					} else {
						event.getWorld().removeBlock(event.getPos(), false);
					}

					if(!entityplayer.isCreative()) {
						if(itemStackIn.getCount() == 1) {
							if (ItemStack.isSame(entityplayer.getOffhandItem(), itemStackIn))
							{
								entityplayer.setItemInHand(Hand.OFF_HAND, new ItemStack(SPItems.cupcake));
							}
							else
							{
								entityplayer.setItemInHand(Hand.MAIN_HAND, new ItemStack(SPItems.cupcake));
							}
						} else  if(itemStackIn.getCount() >= 2){
							itemStackIn.shrink(1);
							boolean flag = entityplayer.inventory.add(new ItemStack(SPItems.cupcake));
							if(!flag) {
								entityplayer.drop(new ItemStack(SPItems.cupcake), false);
							}
						}
					}
				}
			}
		}

	}

	@SubscribeEvent
	public void golemHealth(EntityInteract event) {
		ItemStack itemstack = event.getItemStack();
		Item item = itemstack.getItem();
		Random rand = new Random();
		if(event.getTarget() instanceof IronGolemEntity) {
			if (((LivingEntity) event.getTarget()).getHealth() < ((LivingEntity) event.getTarget()).getMaxHealth()) {
				if(item instanceof SPItemIngot && ((SPItemIngot) item).healsGolem()) {
					((LivingEntity) event.getTarget()).heal(((SPItemIngot) item).getGolemHealth());
					float f1 = 1.0F + (rand.nextFloat() - rand.nextFloat()) * 0.2F;
					((LivingEntity) event.getTarget()).playSound(SoundEvents.IRON_GOLEM_REPAIR, 1.0F, f1);
					if (!event.getPlayer().abilities.instabuild) {
						itemstack.shrink(1);
					}
				}
			}
		}
	}

	@SubscribeEvent(priority =  EventPriority.HIGH)
	public void genOres(BiomeLoadingEvent event) {
		SurvivalPlusOreGenerator.generateOres(event.getName(), event.getClimate(), event.getCategory(), event.getDepth(), event.getScale(), event.getEffects(), event.getGeneration(), event.getSpawns());
	}

	@SubscribeEvent
	public void addLootTable(LootTableLoadEvent event) {

		if(event.getName().equals(LootTables.PIGLIN_BARTERING)) {

			LootEntry spinel = ItemLootEntry.lootTableItem(SPBlocks.spinel).setWeight(15).apply(SetCount.setCount(RandomValueRange.between(1.0F, 2.0F))).build();

			LootTable table = event.getTable();

			Field entires = ObfuscationReflectionHelper.findField(LootPool.class, "field_186453_a");

			if(event.getTable().getPool("main") != null) {
				try {
					List<LootEntry> list = (List<LootEntry>) entires.get(event.getTable().getPool("main"));

					list.add(spinel);

				} catch (IllegalArgumentException e) {
					System.out.println("Failed to add Spinel Loot");
				} catch (IllegalAccessException e) {
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

		if(SPCompatibilityManager.isIc2Loaded()) {
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "bronze_ingot_alt2"));
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

		if(event.getPlayer().getUUID().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412"))) {

			StringTextComponent coolsim = new StringTextComponent("coolsim");
			coolsim.withStyle(TextFormatting.GOLD);

			if(event.getPlayer().getTeam() == null) {
				event.setDisplayName(coolsim);
			} else if(event.getPlayer().getTeam() instanceof ScorePlayerTeam) {
				if(((ScorePlayerTeam) event.getPlayer().getTeam()).getColor() == TextFormatting.RESET)
					event.setDisplayName(coolsim);
			}
		}
	}

	@SubscribeEvent
	public void coolsimChat(ServerChatEvent event) {

		TranslationTextComponent coolsim = new TranslationTextComponent("sp.coolsim.creator");
		coolsim.withStyle(TextFormatting.GOLD);

		if(event.getPlayer().getUUID().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412"))) {
			if(ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayerByName(event.getUsername()) != null)
				event.setComponent(new TranslationTextComponent("%s <%s> %s", new Object[] {coolsim, ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayerByName(event.getUsername()).getDisplayName(), event.getMessage()}));
		}
	}

	@SubscribeEvent
	public void coolsimReceivedChat(ClientChatReceivedEvent event) {

		TranslationTextComponent coolsim = new TranslationTextComponent("sp.coolsim.creator");
		coolsim.withStyle(TextFormatting.GOLD);

		TranslationTextComponent playerJoined = new TranslationTextComponent("multiplayer.player.joined", new Object[] {"coolsim"});
		playerJoined.withStyle(TextFormatting.YELLOW);

		TranslationTextComponent playerLeft = new TranslationTextComponent("multiplayer.player.left", new Object[] {"coolsim"});
		playerLeft.withStyle(TextFormatting.YELLOW);

		TranslationTextComponent coolsimJoined = new TranslationTextComponent("sp.coolsim.joined", new Object[] {"coolsim"});
		coolsimJoined.withStyle(TextFormatting.YELLOW);

		TranslationTextComponent coolsimLeft = new TranslationTextComponent("sp.coolsim.left", new Object[] {"coolsim"});
		coolsimLeft.withStyle(TextFormatting.YELLOW);

		if(event.getMessage().getString().equals(playerJoined.getString())) {
			event.setMessage(coolsimJoined);
		}

		if(event.getMessage().getString().equals(playerLeft.getString())) {
			event.setMessage(coolsimLeft);
		}

		if(event.getMessage().getString().startsWith("[coolsim]")) {
			event.setMessage(new TranslationTextComponent("%s %s", new Object[] {coolsim, event.getMessage()}));
		}
	}

	@SubscribeEvent
	public void coolsimDeath(LivingDeathEvent event) {

		if(event.getEntity() instanceof ServerPlayerEntity && event.getEntity().getUUID().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412")) && event.getSource().getEntity() instanceof ServerPlayerEntity) {

			ServerPlayerEntity attacker = (ServerPlayerEntity) event.getSource().getEntity();
			ItemStack coolsimHead = getcoolsimHead((PlayerEntity) event.getEntity());

			if(coolsimHead != null) {
				dropItem(coolsimHead, attacker);
			} else {
				TranslationTextComponent error = new TranslationTextComponent("sp.coolsim.error");
				error.withStyle(TextFormatting.RED);
				attacker.sendMessage(error, ChatType.SYSTEM, Util.NIL_UUID);
			}
		}

	}

	public static ItemStack getcoolsimHead(PlayerEntity coolsim)
	{
		String texture = "eyJ0aW1lc3RhbXAiOjE1NzYxMTM5OTc5ODUsInByb2ZpbGVJZCI6IjU0NDgxMjU3N2I2ZDRjOGU4YWFjY2E2Zjg2NGUxNDEyIiwicHJvZmlsZU5hbWUiOiJjb29sc2ltIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzdmMDkwM2QxOGMyZTE4YmQzYzBiMDk5YmIzZGFkNmVjYTQ2ZDBjMzdkZjJkM2FlMjljYzAwOWYwN2I5OTM3NmYifX19";

		ItemStack playerhead = new ItemStack(Items.PLAYER_HEAD);

		TranslationTextComponent headName = new TranslationTextComponent("block.minecraft.player_head.named", new Object[] {"coolsim"});
		headName.withStyle(TextFormatting.ITALIC);
		CompoundNBT properties = new CompoundNBT();
		ListNBT textures = new ListNBT();
		CompoundNBT tex = new CompoundNBT();
		tex.putString("Value", texture);
		textures.add(tex);
		properties.put("textures", textures);
		playerhead.addTagElement("SkullOwner", NBTUtil.writeGameProfile(new CompoundNBT(), coolsim.getGameProfile()));
		playerhead.setHoverName(headName);

		return playerhead;
	}

	public static void dropItem(ItemStack stack, PlayerEntity player) {

		boolean bl = player.inventory.add(stack);
		if (bl && stack.isEmpty()) {
			stack.setCount(1);
			ItemEntity itementity1 = player.drop(stack, false);
			if (itementity1 != null) {
				itementity1.makeFakeItem();
			}

			player.level.playSound((PlayerEntity)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, ((player.getRandom().nextFloat() - player.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);
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
